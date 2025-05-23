package com.tencent.hippy.qq.preload;

import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PreloadPrivilegeManager {
    private static final String KEY_HIPPY_CONFIG = "hippy";
    private static final String KEY_WEB_CONFIG = "web";
    private static final String TAG = "PreloadPrivilegeManager";
    private static volatile PreloadPrivilegeManager sPreloadPrivilegeManager;
    private HashMap<String, List<PrivilegeItem>> mHippyPrivileges = new HashMap<>();
    private HashMap<String, List<PrivilegeItem>> mWebPrivileges = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class PrivilegeItem {
        public String mBundleName;
        public TabPreloadItem.PreloadType mPreloadType;

        public PrivilegeItem(JSONObject jSONObject) {
            this.mBundleName = jSONObject.optString("bundle");
            this.mPreloadType = TabPreloadItem.convertToPreloadType(jSONObject.optString("type"));
        }

        public boolean checkData() {
            TabPreloadItem.PreloadType preloadType = this.mPreloadType;
            if (preloadType != TabPreloadItem.PreloadType.NO_PRELOAD && (preloadType == TabPreloadItem.PreloadType.PRE_BASE || !TextUtils.isEmpty(this.mBundleName))) {
                return true;
            }
            return false;
        }

        public boolean isMatch(OpenHippyInfo openHippyInfo) {
            TabPreloadItem.PreloadType preloadType = openHippyInfo.preloadType;
            if (preloadType == TabPreloadItem.PreloadType.NO_PRELOAD || preloadType != this.mPreloadType) {
                return false;
            }
            if (preloadType != TabPreloadItem.PreloadType.PRE_BASE) {
                if (TextUtils.isEmpty(openHippyInfo.bundleName) || !openHippyInfo.bundleName.equals(this.mBundleName)) {
                    return false;
                }
                return true;
            }
            return true;
        }
    }

    PreloadPrivilegeManager() {
        ToggleProxy toggleProxy = VasToggle.HIPPY_PRELOAD_PRIVILEGE;
        if (toggleProxy.isEnable(false)) {
            String stringDataSet = toggleProxy.getStringDataSet("hippy", null);
            String stringDataSet2 = toggleProxy.getStringDataSet("web", null);
            parsePrivilegeConfig(stringDataSet, this.mHippyPrivileges);
            parsePrivilegeConfig(stringDataSet2, this.mWebPrivileges);
        }
    }

    private boolean checkPrivilege(OpenHippyInfo openHippyInfo, List<PrivilegeItem> list) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null && list.get(i3).isMatch(openHippyInfo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static PreloadPrivilegeManager getInstance() {
        if (sPreloadPrivilegeManager == null) {
            synchronized (PreloadPrivilegeManager.class) {
                if (sPreloadPrivilegeManager == null) {
                    sPreloadPrivilegeManager = new PreloadPrivilegeManager();
                }
            }
        }
        return sPreloadPrivilegeManager;
    }

    private void parsePrivilegeConfig(String str, HashMap<String, List<PrivilegeItem>> hashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!TextUtils.isEmpty(str2)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(str2);
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        PrivilegeItem privilegeItem = new PrivilegeItem(optJSONArray.optJSONObject(i3));
                        if (privilegeItem.checkData()) {
                            arrayList.add(privilegeItem);
                        }
                    }
                    hashMap.put(str2, arrayList);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parsePrivileges e:", e16);
        }
    }

    public boolean checkHippyPreload(String str, OpenHippyInfo openHippyInfo) {
        if (!TextUtils.isEmpty(str) && openHippyInfo != null) {
            return checkPrivilege(openHippyInfo, this.mHippyPrivileges.get(str));
        }
        return false;
    }

    public boolean checkWebPreload(String str, OpenHippyInfo openHippyInfo) {
        if (!TextUtils.isEmpty(str) && openHippyInfo != null) {
            String lowerCase = str.toLowerCase();
            for (Map.Entry<String, List<PrivilegeItem>> entry : this.mWebPrivileges.entrySet()) {
                if (AuthorizeConfig.P(entry.getKey(), lowerCase) && checkPrivilege(openHippyInfo, entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onAppDestroy() {
        sPreloadPrivilegeManager = null;
    }
}

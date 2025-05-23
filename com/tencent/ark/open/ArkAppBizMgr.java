package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.Logger;
import com.tencent.ark.Utils;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.mmkv.MMKVUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppBizMgr {
    private static final String TAG = "ArkAppBizMgr";
    private static volatile ArkAppBizMgr sInstance;
    private final Map<String, List<String>> mAppNameBizMap = new ConcurrentHashMap();

    protected ArkAppBizMgr() {
    }

    public static ArkAppBizMgr getInstance() {
        if (sInstance == null) {
            synchronized (ArkAppBizMgr.class) {
                if (sInstance == null) {
                    sInstance = new ArkAppBizMgr();
                }
            }
        }
        return sInstance;
    }

    private void saveBizSrcList(String str, List<String> list) {
        String str2;
        if (Utils.isEmpty(list)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.put(i3, list.get(i3));
            }
            str2 = jSONArray.toString();
        } catch (Exception e16) {
            Logger.logE(TAG, "putBizSrcInList parse error = " + e16);
            str2 = "";
        }
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return;
        }
        arkMMKV.putString(MMKVUtils.fixAppBizConfigKey(str), str2);
    }

    public List<String> getBizSrcList(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        List<String> list = this.mAppNameBizMap.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            this.mAppNameBizMap.put(str, arrayList);
            return arrayList;
        }
        String string = arkMMKV.getString(MMKVUtils.fixAppBizConfigKey(str), "");
        if (TextUtils.isEmpty(string)) {
            this.mAppNameBizMap.put(str, arrayList);
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
        } catch (Exception e16) {
            Logger.logE(TAG, "getBizSrcList parse error = " + e16);
        }
        this.mAppNameBizMap.put(str, arrayList);
        return arrayList;
    }

    public void putBizSrcInList(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<String> bizSrcList = getBizSrcList(str);
            if (bizSrcList == null) {
                bizSrcList = new ArrayList<>();
            }
            if (bizSrcList.contains(str2)) {
                return;
            }
            bizSrcList.add(str2);
            this.mAppNameBizMap.put(str, bizSrcList);
            saveBizSrcList(str, bizSrcList);
        }
    }

    public void removeBizSrc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<String> bizSrcList = getBizSrcList(str);
            if (!Utils.isEmpty(bizSrcList) && bizSrcList.contains(str2)) {
                bizSrcList.remove(str2);
                this.mAppNameBizMap.put(str, bizSrcList);
                saveBizSrcList(str, bizSrcList);
            }
        }
    }
}

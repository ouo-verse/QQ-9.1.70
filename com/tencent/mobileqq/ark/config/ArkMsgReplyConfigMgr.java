package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkMsgReplyConfigMgr implements IArkMsgReplyMgr {
    public static final String ARK_REPLY_FROM_TYPE_CARD_ARK_APP = "com.tencent.mobileqq.cardshare";
    public static final String ARK_REPLY_FROM_TYPE_CARD_ARK_VIEW = "contact";
    public static final int ARK_REPLY_FROM_TYPE_MAP = 14;
    public static final String ARK_REPLY_FROM_TYPE_MAP_STRING = "LocationShare";
    public static final int ARK_REPLY_FROM_TYPE_MUSIC = 13;
    public static final String ARK_REPLY_FROM_TYPE_MUSIC_STRING = "music";
    public static final int ARK_REPLY_FROM_TYPE_NEWS = 11;
    public static final String ARK_REPLY_FROM_TYPE_NEWS_STRING = "news";
    public static final int ARK_REPLY_FROM_TYPE_UNKNOWN = 10;
    public static final int ARK_REPLY_FROM_TYPE_VIDEO = 12;
    public static final String ARK_REPLY_FROM_TYPE_VIDEO_STRING = "video";
    private static final String ARK_REPLY_MAP = "com.tencent.map";
    private static final String ARK_REPLY_STRUCTMSG = "com.tencent.structmsg";
    public static final String ARK_REPLY_TVALUE_MENU_CLICK = "0X800AA84";
    public static final String ARK_REPLY_TVALUE_QUOTE_CLICK = "0X800AA86";
    public static final String ARK_REPLY_TVALUE_SENDBTN_CLICK = "0X800AA85";
    public static final String JSON_PATH_SCHEME = "jsonpath:";
    public static final String TAG = "ArkMsgReplyConfigMgr";
    public static final String kArkMsgReplyConfig = "kArkMsgReplyConfig";
    private static volatile ArkMsgReplyConfigMgr sInstance;
    private volatile LinkedHashMap<String, f> mBizsrcConfigs;
    private volatile LinkedHashMap<String, f> mConfigs;

    private String getAndroidJumpUrlFromProfileCardArkMsg(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        if (optJSONObject == null) {
            QLog.e(TAG, 1, "getAndroidJumpUrlFromMsg: metaJson is null");
            return "";
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("contact");
        if (optJSONObject2 == null) {
            QLog.e(TAG, 1, "getAndroidJumpUrlFromMsg: contactJson is null");
            return "";
        }
        return optJSONObject2.optString("androidJumpUrl", "");
    }

    private f getConfigByAppBizsrc(String str, String str2) {
        return this.mBizsrcConfigs.get(str + str2);
    }

    private f getConfigByAppView(String str, String str2) {
        f fVar = new f();
        fVar.f199254a = str;
        fVar.f199255b = str2;
        if (!fVar.a()) {
            return null;
        }
        if (this.mConfigs.isEmpty()) {
            f91.a.b();
            QLog.d(TAG, 1, "mConfigs is empty reload");
            return null;
        }
        return this.mConfigs.get(fVar.b());
    }

    private String getContentByPath(JSONObject jSONObject, String str) {
        try {
            if (isJSONPathString(str)) {
                str = str.substring(9);
            }
            Object a16 = new a(str).a(transformJsonObjectToMap(jSONObject));
            if (a16 == null) {
                QLog.i(TAG, 1, "getContentByPath error: object == null");
                return "";
            }
            return a16.toString();
        } catch (Exception unused) {
            QLog.i(TAG, 1, "getContentByPath exception");
            return "";
        }
    }

    public static ArkMsgReplyConfigMgr getInstance() {
        if (sInstance == null) {
            synchronized (ArkMsgReplyConfigMgr.class) {
                if (sInstance == null) {
                    ArkMsgReplyConfigMgr arkMsgReplyConfigMgr = new ArkMsgReplyConfigMgr();
                    arkMsgReplyConfigMgr.mConfigs = new LinkedHashMap<>();
                    arkMsgReplyConfigMgr.mBizsrcConfigs = new LinkedHashMap<>();
                    arkMsgReplyConfigMgr.parseConfig(arkMsgReplyConfigMgr.loadConfig());
                    sInstance = arkMsgReplyConfigMgr;
                }
            }
        }
        return sInstance;
    }

    private boolean isJSONPathString(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(JSON_PATH_SCHEME)) {
            return false;
        }
        return true;
    }

    private JSONObject loadConfig() {
        String d16 = cl.d(BaseApplication.getContext(), kArkMsgReplyConfig);
        try {
            return new JSONObject(d16);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "loadConfig exception configJSON" + d16 + " ,error " + e16);
            return null;
        }
    }

    private void parseConfig(JSONObject jSONObject) {
        this.mConfigs.clear();
        this.mBizsrcConfigs.clear();
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("messageReplyConfig");
        QLog.i(TAG, 1, "ArkMsgReplyConfigMgr=" + optJSONArray);
        if (optJSONArray != null) {
            QLog.i(TAG, 1, "messageReplyConfigList size " + optJSONArray.length());
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                f fVar = new f();
                fVar.f199254a = optJSONObject.optString("app", "");
                fVar.f199255b = optJSONObject.optString("view", "");
                fVar.f199256c = optJSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, "");
                fVar.f199257d = optJSONObject.optString("title", "");
                fVar.f199258e = optJSONObject.optString("tag", "");
                fVar.f199259f = optJSONObject.optString("icon", "");
                fVar.f199260g = optJSONObject.optString("action", "");
                fVar.f199261h = optJSONObject.optString("jumpURL", "");
                if (!fVar.a()) {
                    QLog.i(TAG, 1, "parseConfig, item is invalid");
                } else {
                    if (!TextUtils.isEmpty(fVar.f199256c)) {
                        this.mBizsrcConfigs.put(fVar.f199254a + fVar.f199256c, fVar);
                    }
                    this.mConfigs.put(fVar.b(), fVar);
                }
            }
        }
    }

    private void saveConfig(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            jSONObject2 = "{}";
        }
        cl.j(BaseApplication.getContext(), kArkMsgReplyConfig, jSONObject2);
    }

    public static ArrayList<Object> transformJsonArrayToList(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList<Object> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt != null) {
                    if (opt.getClass() == JSONObject.class) {
                        arrayList.add(transformJsonObjectToMap((JSONObject) opt));
                    } else if (opt.getClass() == JSONArray.class) {
                        arrayList.add(transformJsonArrayToList((JSONArray) opt));
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public static Map<String, Object> transformJsonObjectToMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = keys.next() + "";
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj.getClass() == JSONObject.class) {
                    linkedHashMap.put(str, transformJsonObjectToMap((JSONObject) obj));
                } else if (obj.getClass() == JSONArray.class) {
                    linkedHashMap.put(str, transformJsonArrayToList((JSONArray) obj));
                } else {
                    linkedHashMap.put(str, obj);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public boolean canReply(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return ArkAppConfigMgr.getInstance().canReply(str, str3);
        }
        if (getConfigByAppView(str, str2) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public boolean canReplyByFreesia(String str, String str2) {
        if (getConfigByAppView(str, str2) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public Map<String, String> getArkReplyConfig(JSONObject jSONObject) {
        f fVar;
        String str;
        String str2;
        String optString = jSONObject.optString("app", "");
        String optString2 = jSONObject.optString("view", "");
        String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, "");
        if (!TextUtils.isEmpty(optString3)) {
            fVar = getConfigByAppBizsrc(optString, optString3);
        } else {
            fVar = null;
        }
        if (fVar == null) {
            fVar = getConfigByAppView(optString, optString2);
        }
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (isJSONPathString(fVar.f199257d)) {
            str = getContentByPath(jSONObject, fVar.f199257d);
        } else {
            str = fVar.f199257d;
        }
        if (TextUtils.isEmpty(str)) {
            str = jSONObject.optString("prompt", "");
        }
        hashMap.put("app", optString);
        hashMap.put("view", optString2);
        hashMap.put(QQCustomArkDialogUtil.BIZ_SRC, fVar.f199256c);
        hashMap.put("title", str);
        hashMap.put("tag", fVar.f199258e);
        hashMap.put("icon", fVar.f199259f);
        hashMap.put("action", fVar.f199260g);
        if (isJSONPathString(fVar.f199261h)) {
            str2 = getContentByPath(jSONObject, fVar.f199261h);
        } else {
            str2 = fVar.f199261h;
        }
        hashMap.put(WadlProxyConsts.KEY_JUMP_URL, str2);
        if (optString.equals(ARK_REPLY_FROM_TYPE_CARD_ARK_APP) && optString2.equals("contact")) {
            hashMap.put(WadlProxyConsts.KEY_JUMP_URL, getAndroidJumpUrlFromProfileCardArkMsg(jSONObject));
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public Map<String, String> getReplyConfigFromMsg(JSONObject jSONObject) {
        String str;
        String optString = jSONObject.optString("app", "");
        String optString2 = jSONObject.optString("view", "");
        f configByAppView = getConfigByAppView(optString, optString2);
        if (configByAppView == null) {
            QLog.i(TAG, 1, "getReplyConfigFromMsg: config is null, return empty map");
            return new LinkedHashMap();
        }
        if (isJSONPathString(configByAppView.f199257d)) {
            str = getContentByPath(jSONObject, configByAppView.f199257d);
        } else {
            str = configByAppView.f199257d;
        }
        if (TextUtils.isEmpty(str)) {
            str = jSONObject.optString("prompt", "");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyApp, optString);
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyView, optString2);
        linkedHashMap.put(IArkMsgReplyMgr.ARKMSGREPLYBIZSRC, configByAppView.f199256c);
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyTitle, str);
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyTag, configByAppView.f199258e);
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyIcon, configByAppView.f199259f);
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyAction, configByAppView.f199260g);
        boolean isJSONPathString = isJSONPathString(configByAppView.f199261h);
        String str2 = configByAppView.f199261h;
        if (isJSONPathString) {
            str2 = getContentByPath(jSONObject, str2);
        }
        linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyJumpUrl, str2);
        if (optString.equals(ARK_REPLY_FROM_TYPE_CARD_ARK_APP) && optString2.equals("contact")) {
            linkedHashMap.put(IArkMsgReplyMgr.kArkMsgReplyJumpUrl, getAndroidJumpUrlFromProfileCardArkMsg(jSONObject));
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public int msgReplyFromType(String str, String str2) {
        if ("com.tencent.structmsg".equals(str) && "news".equals(str2)) {
            return 11;
        }
        if ("com.tencent.structmsg".equals(str) && "video".equals(str2)) {
            return 12;
        }
        if ("com.tencent.structmsg".equals(str) && "music".equals(str2)) {
            return 13;
        }
        if ("com.tencent.map".equals(str) && ARK_REPLY_FROM_TYPE_MAP_STRING.equals(str2)) {
            return 14;
        }
        return 10;
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public void updateConfig(JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            parseConfig(jSONObject);
            saveConfig(jSONObject);
        } else {
            QLog.i(TAG, 1, "ArkMsgReplyConfig json == null ");
        }
    }
}

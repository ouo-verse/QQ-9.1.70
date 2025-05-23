package com.tencent.comic.config;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.data.ComicCancelRedPointPopConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.IPExpressionConfig;
import com.tencent.comic.utils.f;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.webbundle.sdk.WebBundleConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicConfBean {

    /* renamed from: a, reason: collision with root package name */
    public b f99266a = new b();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f99267b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private a f99268c = new a();

    /* renamed from: d, reason: collision with root package name */
    private IPExpressionConfig f99269d = new IPExpressionConfig();

    /* renamed from: e, reason: collision with root package name */
    private BoodoHippyConfig f99270e = new BoodoHippyConfig();

    /* renamed from: f, reason: collision with root package name */
    private ComicReaderConfig f99271f = new ComicReaderConfig();

    /* renamed from: g, reason: collision with root package name */
    private ComicCancelRedPointPopConfig f99272g = new ComicCancelRedPointPopConfig();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class ComicReaderConfig implements Serializable {
        public static final int SECTION_COMMENT_MASTER_SWITCH_OFF = 0;
        public static final int SECTION_COMMENT_MASTER_SWITCH_ON = 1;
        public static final int SECTION_COMMENT_NUM_VS_DEFAULT = 1;
        public static final int SECTION_COMMENT_NUM_VS_MAX = 3;
        public boolean enablePreRead = true;
        public boolean enablePreload = false;
        public int preloadNum = 3;
        public boolean sectionCommentMasterSwitch = false;
        public int sectionCommentNumVS = 1;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f99273a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f99274b = "";

        private static String d(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                String[] split = new JSONObject(str).getString("oac_triggle").split(ContainerUtils.FIELD_DELIMITER);
                if (split != null) {
                    for (String str2 : split) {
                        if (str2.startsWith("busi_id")) {
                            return URLUtil.decodeUrl(str2.split(ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQComicConfBean", 1, e16, new Object[0]);
            }
            return str;
        }

        public boolean e(String str) {
            return TextUtils.equals(str, this.f99273a);
        }

        public boolean f(String str, Context context, int i3, AppInterface appInterface) {
            if (!e(str) || TextUtils.isEmpty(this.f99274b)) {
                return false;
            }
            String str2 = this.f99274b;
            IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
            Message lastMessage = iMessageFacade.getLastMessage(str, 1008);
            String d16 = (lastMessage == null || lastMessage.isread) ? null : d(lastMessage.getExtInfoFromExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND));
            if (!TextUtils.isEmpty(d16)) {
                str2 = c(str2, "_ext", d16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQComicConfBean", 2, "launchIfMatched, params=", d16, ", finalUrl=", str2);
            }
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str2, i3, new C1011a(iMessageFacade, str));
        }

        public String toString() {
            return "ServiceAccountConfig{uin=" + this.f99273a + ", url=" + this.f99274b + '}';
        }

        /* compiled from: P */
        /* renamed from: com.tencent.comic.config.QQComicConfBean$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C1011a implements MiniAppLaunchListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IMessageFacade f99275a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f99276b;

            C1011a(IMessageFacade iMessageFacade, String str) {
                this.f99275a = iMessageFacade;
                this.f99276b = str;
            }

            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                if (z16) {
                    this.f99275a.setReaded(this.f99276b, 1008, true, true);
                }
            }
        }

        private static String c(String str, String str2, String str3) {
            String encodeUrl;
            StringBuilder sb5;
            int indexOf = str.indexOf(63);
            int indexOf2 = str.indexOf(35);
            if (indexOf == -1) {
                encodeUrl = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            } else {
                try {
                    encodeUrl = URLUtil.encodeUrl(ContainerUtils.FIELD_DELIMITER);
                } catch (Exception unused) {
                    return str;
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(encodeUrl);
            sb6.append(URLUtil.encodeUrl(str2 + '=' + str3));
            String sb7 = sb6.toString();
            if (indexOf2 == -1) {
                sb5 = new StringBuilder();
                sb5.append(str);
            } else {
                sb5 = new StringBuilder();
                sb5.append(str.substring(0, indexOf2));
                sb5.append(sb7);
                sb7 = str.substring(indexOf2);
            }
            sb5.append(sb7);
            str = sb5.toString();
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f99278a = false;

        /* renamed from: b, reason: collision with root package name */
        public String f99279b = "";

        public b() {
        }

        public boolean a() {
            return this.f99278a && !TextUtils.isEmpty(this.f99279b);
        }

        public String toString() {
            return "WebBundleConfig{enable=" + this.f99278a + ", preloadUrl='" + this.f99279b + "'}";
        }
    }

    public static ComicCancelRedPointPopConfig a() {
        QQComicConfBean qQComicConfBean = (QQComicConfBean) am.s().x(534);
        if (qQComicConfBean == null) {
            return new ComicCancelRedPointPopConfig();
        }
        return qQComicConfBean.f99272g;
    }

    public static BoodoHippyConfig b() {
        return ((QQComicConfBean) am.s().x(534)).f99270e;
    }

    public static IPExpressionConfig c() {
        return ((QQComicConfBean) am.s().x(534)).f99269d;
    }

    public static ComicReaderConfig d() {
        return ((QQComicConfBean) am.s().x(534)).f99271f;
    }

    public static QQComicConfBean e(ai[] aiVarArr) {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray jSONArray;
        String str4;
        String str5;
        JSONObject optJSONObject3;
        ai[] aiVarArr2 = aiVarArr;
        String str6 = "urlConfig";
        String str7 = "webbundle";
        String str8 = "hippyConfig";
        if (aiVarArr2 == null || aiVarArr2.length == 0) {
            return null;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("QQComicConfBean", 2, "parse");
        }
        char c16 = 0;
        try {
            QQComicConfBean qQComicConfBean = new QQComicConfBean();
            int length = aiVarArr2.length;
            int i16 = 0;
            while (i16 < length) {
                ai aiVar = aiVarArr2[i16];
                if (TextUtils.isEmpty(aiVar.f202268b)) {
                    str = str6;
                    str2 = str7;
                    str3 = str8;
                } else {
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[i3];
                        objArr[c16] = "parse, content=";
                        objArr[1] = aiVar.f202268b;
                        QLog.d("QQComicConfBean", i3, objArr);
                    }
                    JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                    if (jSONObject.has(str8)) {
                        JSONObject optJSONObject4 = jSONObject.optJSONObject(str8);
                        if (optJSONObject4 != null) {
                            qQComicConfBean.f99270e.mHippyStatus = optJSONObject4.optInt("hippyStatus");
                            qQComicConfBean.f99270e.mMainModuleName = optJSONObject4.optString("mainModuleName");
                            JSONArray optJSONArray = optJSONObject4.optJSONArray("preloadModules");
                            qQComicConfBean.f99270e.mPreloadModules.clear();
                            int length2 = optJSONArray.length();
                            int i17 = 0;
                            while (i17 < length2) {
                                qQComicConfBean.f99270e.mPreloadModules.add(optJSONArray.optString(i17));
                                i17++;
                                str8 = str8;
                            }
                            str3 = str8;
                            qQComicConfBean.f99270e.mAllModules.clear();
                            JSONArray optJSONArray2 = optJSONObject4.optJSONArray("allModules");
                            int length3 = optJSONArray2.length();
                            for (int i18 = 0; i18 < length3; i18++) {
                                qQComicConfBean.f99270e.mAllModules.add(optJSONArray2.optString(i18));
                            }
                            qQComicConfBean.f99270e.mPsKeyHost = optJSONObject4.optString("pskeyHost");
                        } else {
                            str3 = str8;
                        }
                    } else {
                        str3 = str8;
                        if (jSONObject.has("ipEmoji")) {
                            JSONObject optJSONObject5 = jSONObject.optJSONObject("ipEmoji");
                            if (optJSONObject5 != null) {
                                qQComicConfBean.f99269d.mPrefixUrl = optJSONObject5.optString("url");
                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("matchList");
                                if (optJSONObject6 != null) {
                                    Iterator keys = optJSONObject6.keys();
                                    while (keys.hasNext()) {
                                        String str9 = (String) keys.next();
                                        qQComicConfBean.f99269d.mExpressionMap.put(str9, qQComicConfBean.f99269d.mPrefixUrl + optJSONObject6.optString(str9));
                                    }
                                }
                            }
                        } else if (jSONObject.has(str7)) {
                            JSONObject optJSONObject7 = jSONObject.optJSONObject(str7);
                            if (optJSONObject7 != null && (optJSONObject3 = optJSONObject7.optJSONObject("qqcomic")) != null) {
                                qQComicConfBean.f99266a.f99278a = optJSONObject3.optBoolean("enable", false);
                                qQComicConfBean.f99266a.f99279b = optJSONObject3.optString(WebBundleConstants.WEBBUNDLE_PRELOAD_URL, "");
                            }
                        } else if (jSONObject.has(str6)) {
                            JSONArray optJSONArray3 = jSONObject.optJSONArray(str6);
                            if (QLog.isColorLevel()) {
                                QLog.d("QQComicConfBean", 2, "parse, urlConfig=", optJSONArray3);
                            }
                            int length4 = optJSONArray3.length();
                            int i19 = 0;
                            while (i19 < length4) {
                                JSONObject jSONObject2 = optJSONArray3.getJSONObject(i19);
                                String optString = jSONObject2.optString("bizName");
                                if (TextUtils.isEmpty(optString)) {
                                    jSONArray = optJSONArray3;
                                    str4 = str6;
                                    str5 = str7;
                                } else {
                                    jSONArray = optJSONArray3;
                                    str4 = str6;
                                    str5 = str7;
                                    if (f.a(AppSetting.f99551k, jSONObject2.optString("minVersion"), jSONObject2.optString("maxVersion"))) {
                                        String optString2 = jSONObject2.optString("androidUrl");
                                        if (TextUtils.isEmpty(optString2)) {
                                            optString2 = jSONObject2.optString("url");
                                        }
                                        if (!TextUtils.isEmpty(optString2)) {
                                            qQComicConfBean.f99267b.put(optString, optString2);
                                            QLog.d("QQComicConfBean", 1, "parse, urlConfig, bizName=", optString, ", url=", optString2);
                                        }
                                    } else {
                                        QLog.d("QQComicConfBean", 1, "parse, urlConfig, bizName=", optString, ", version not match");
                                    }
                                }
                                i19++;
                                optJSONArray3 = jSONArray;
                                str6 = str4;
                                str7 = str5;
                            }
                        } else {
                            str = str6;
                            str2 = str7;
                            if (jSONObject.has("serviceAccount")) {
                                JSONObject optJSONObject8 = jSONObject.optJSONObject("serviceAccount");
                                if (optJSONObject8 != null) {
                                    qQComicConfBean.f99268c.f99273a = optJSONObject8.optString("uin");
                                    qQComicConfBean.f99268c.f99274b = optJSONObject8.optString("url");
                                }
                            } else if (jSONObject.has("comicReader")) {
                                JSONObject optJSONObject9 = jSONObject.optJSONObject("comicReader");
                                if (optJSONObject9 != null) {
                                    JSONObject optJSONObject10 = optJSONObject9.optJSONObject("newVersion");
                                    if (optJSONObject10 != null && (optJSONObject2 = optJSONObject10.optJSONObject("preload")) != null) {
                                        qQComicConfBean.f99271f.enablePreload = optJSONObject2.optBoolean("enable");
                                        qQComicConfBean.f99271f.preloadNum = optJSONObject2.optInt("maxNum");
                                    }
                                    JSONObject optJSONObject11 = optJSONObject9.optJSONObject("preRead");
                                    if (optJSONObject10 != null) {
                                        qQComicConfBean.f99271f.enablePreRead = optJSONObject11.optBoolean("enable");
                                    }
                                    JSONObject optJSONObject12 = optJSONObject9.optJSONObject("sectionComment");
                                    if (optJSONObject12 != null) {
                                        int optInt = optJSONObject12.optInt("commentNumVS", 1);
                                        int min = optInt < 0 ? 0 : Math.min(optInt, 3);
                                        ComicReaderConfig comicReaderConfig = qQComicConfBean.f99271f;
                                        comicReaderConfig.sectionCommentNumVS = min;
                                        comicReaderConfig.sectionCommentMasterSwitch = optJSONObject12.optInt("masterSwitch", 0) == 1;
                                    }
                                }
                            } else if (jSONObject.has("cancelRedPointPopConfig") && (optJSONObject = jSONObject.optJSONObject("cancelRedPointPopConfig")) != null) {
                                qQComicConfBean.f99272g.popSwitch = optJSONObject.optInt("popSwitch", 0);
                                qQComicConfBean.f99272g.enableLocalCache = optJSONObject.optInt(VideoProxy.PARAM_ENABLE_CACHE, 1);
                                qQComicConfBean.f99272g.ignoreRedDot = optJSONObject.optInt("ignoreRedDot", 0);
                                qQComicConfBean.f99272g.dayCount = optJSONObject.optInt("dayCount", 1);
                                qQComicConfBean.f99272g.ignoreInteractiveControll = optJSONObject.optInt("ignoreInteractive", 0);
                                qQComicConfBean.f99272g.list.clear();
                                JSONArray optJSONArray4 = optJSONObject.optJSONArray("list");
                                if (optJSONArray4 != null) {
                                    List<ComicCancelRedPointPopItemData> parseFromJsonArray = ComicCancelRedPointPopItemData.parseFromJsonArray(optJSONArray4, true);
                                    if (!parseFromJsonArray.isEmpty()) {
                                        qQComicConfBean.f99272g.list.addAll(parseFromJsonArray);
                                    }
                                }
                            }
                        }
                    }
                    str = str6;
                    str2 = str7;
                }
                i16++;
                aiVarArr2 = aiVarArr;
                str8 = str3;
                str6 = str;
                str7 = str2;
                c16 = 0;
                i3 = 2;
            }
            VipComicHelper.h(qQComicConfBean.f99267b.get("danmuAnswerUrl"));
            QLog.d("QQComicConfBean", 1, "parse, confBean=", qQComicConfBean);
            return qQComicConfBean;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("QQComicConfBean", 1, "parse e:", e16.toString());
            return null;
        }
    }

    public static a f() {
        return ((QQComicConfBean) am.s().x(534)).f99268c;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("qqComicConfig:");
        sb5.append(this.f99266a);
        sb5.append(" ,urlConfigMap:");
        sb5.append(this.f99267b);
        sb5.append(" ,serviceAccountConfig:");
        sb5.append(this.f99268c);
        return sb5.toString();
    }
}

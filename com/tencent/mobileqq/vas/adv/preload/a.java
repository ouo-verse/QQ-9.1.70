package com.tencent.mobileqq.vas.adv.preload;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.filemanager.util.l;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdCheckCallBack;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdConstants;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010\u001d\u001a\u00020\bJ\u0010\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020 J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bJ\b\u0010$\u001a\u0004\u0018\u00010\bJ\u0016\u0010(\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010'\u001a\u00020&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/a;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "", DomainData.DOMAIN_NAME, "url", "o", "", h.F, "filePath", "", "c", "ad", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "i", "resSuffix", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "b", "k", "r", "d", "cachedAdStr", "Ljava/util/ArrayList;", "g", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "e", "posId", "f", "p", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdCheckCallBack;", "callBack", "a", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f308150a = new a();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.vas.adv.preload.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public /* synthetic */ class C8900a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308151a;

        static {
            int[] iArr = new int[MaskAdvName.values().length];
            try {
                iArr[MaskAdvName.QQ_WEATHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaskAdvName.QQ_HEALTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaskAdvName.TIANSHU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaskAdvName.QQ_SHOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MaskAdvName.QFS_PUB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f308151a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/preload/a$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements VasAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaskAdCheckCallBack f308152a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qq_ad_get.QQAdGetRsp.AdInfo f308153b;

        b(MaskAdCheckCallBack maskAdCheckCallBack, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            this.f308152a = maskAdCheckCallBack;
            this.f308153b = adInfo;
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (retCode == 0 && adRsp != null && adRsp.qq_ad_get_rsp.pos_ads_info.has()) {
                this.f308152a.realTimeCheckCallBack(this.f308153b);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MaskAdDownloadHelper", 2, "ad rsp failed");
            }
            this.f308152a.realTimeCheckCallBack(null);
        }
    }

    a() {
    }

    private final String n(int adType) {
        if (r(adType)) {
            return ".apng";
        }
        return ".mp4";
    }

    private final String o(String url) {
        boolean z16;
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(url);
        if (!argumentsFromURL.containsKey("version")) {
            return "";
        }
        return String.valueOf(argumentsFromURL.get("version"));
    }

    private final JSONObject q(GdtAd gdtAd) {
        String i3 = i(gdtAd, "shop");
        if (i3 != null) {
            return f308150a.d(gdtAd, i3);
        }
        return null;
    }

    public final void a(@NotNull qq_ad_get.QQAdGetRsp.AdInfo ad5, @NotNull MaskAdCheckCallBack callBack) {
        ArrayList<JSONObject> arrayListOf;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MaskAdConstants.MASK_AD_SHOP_CHECK_KEY, false)) {
            callBack.realTimeCheckCallBack(ad5);
            return;
        }
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add("7085109922408095");
        build.setTargetPosId("7085109922408095");
        a aVar = f308150a;
        JSONObject q16 = aVar.q(new GdtAd(ad5));
        if (q16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(q16);
            build.setSpecifiedAdsJsonList(arrayListOf);
        }
        build.setBusiType(9);
        build.setUin(aVar.h());
        new com.tencent.mobileqq.vas.adv.base.service.d(build, new b(callBack, ad5)).j();
    }

    public final void b() {
        FileUtils.deleteFilesInDirectory(m());
    }

    public final boolean c(@Nullable String filePath) {
        boolean z16;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        QLog.d("MaskAdDownloadHelper", 1, "file path is " + filePath + " exit is " + l.b(filePath));
        return l.b(filePath);
    }

    @NotNull
    public final JSONObject d(@NotNull GdtAd gdtAd, @NotNull String url) {
        Object obj;
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
        PBUInt64Field pBUInt64Field;
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", gdtAd.getAId());
        if (gdtAd.isValid()) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
            if (adInfo != null && (reportInfo = adInfo.report_info) != null && (traceInfo = reportInfo.trace_info) != null && (pBUInt64Field = traceInfo.creative_id) != null) {
                obj = Long.valueOf(pBUInt64Field.get());
            } else {
                obj = null;
            }
        } else {
            obj = Integer.MIN_VALUE;
        }
        jSONObject.put("creative_id", obj);
        jSONObject.put("update_time", System.currentTimeMillis());
        jSONObject.put(QWalletPreferenceApiImpl.PREF_KEY_ZIP_URL, url);
        jSONObject.put("ad_inner_type", gdtAd.getInnerShowType());
        String o16 = o(url);
        if (o16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            jSONObject.put("version", o16);
        }
        return jSONObject;
    }

    @Nullable
    public final String e(@NotNull MaskAdvName businessName) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        int i3 = C8900a.f308151a[businessName.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return null;
                        }
                        return "qfs_pub";
                    }
                    return "shop";
                }
                return "tianshu";
            }
            return AdHippyFragment.HEALTH_NAME;
        }
        return "weather";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[ORIG_RETURN, RETURN] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f(@NotNull String posId) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        switch (posId.hashCode()) {
            case -1968453630:
                if (posId.equals("6011195015998218")) {
                    return "weather";
                }
                return "tianshu";
            case -553317403:
                if (posId.equals("7085109922408095")) {
                    return "shop";
                }
                break;
            case 1797720771:
                if (posId.equals("1082214467882419")) {
                    return AdHippyFragment.HEALTH_NAME;
                }
                break;
            case 2054643833:
                if (posId.equals("5005607931217942")) {
                    return "qfs_pub";
                }
                break;
        }
    }

    @NotNull
    public final ArrayList<JSONObject> g(@NotNull String cachedAdStr) {
        Intrinsics.checkNotNullParameter(cachedAdStr, "cachedAdStr");
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(cachedAdStr);
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "cachedAdJson.keys()");
            while (keys.hasNext()) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(String.valueOf(keys.next()), ""));
                String l3 = l(jSONObject2.optString(QWalletPreferenceApiImpl.PREF_KEY_ZIP_URL, ""), jSONObject2.optInt("ad_inner_type", 0));
                if (c(l3)) {
                    jSONObject2.put(AdHippyFragment.RES_PATH, l3);
                    arrayList.add(jSONObject2);
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.e("MaskAdDownloadHelper", 1, "getReadyAdJson failed, error is ", th5);
            return arrayList;
        }
    }

    public final long h() {
        try {
            return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        } catch (Throwable th5) {
            QLog.e("MaskAdDownloadHelper", 1, "get uin failed, error is " + th5);
            return 0L;
        }
    }

    @Nullable
    public final String i(@NotNull GdtAd ad5, @NotNull String businessName) {
        String str;
        boolean z16;
        String downloadUrl;
        boolean z17;
        boolean z18;
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext;
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str2;
        boolean z19;
        boolean z26;
        PBStringField pBStringField3;
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext3;
        qq_ad_get.QQAdGetRsp.AdInfo.Ext ext4;
        PBStringField pBStringField4;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        String str3 = "";
        if (!ad5.isValid()) {
            return "";
        }
        String str4 = null;
        boolean z27 = false;
        if (r(ad5.getInnerShowType())) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = ad5.info;
            if (adInfo != null && (ext3 = adInfo.ext) != null && (ext4 = ext3.get()) != null && (pBStringField4 = ext4.img2) != null) {
                str2 = pBStringField4.get();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = ad5.info;
                if (adInfo2 != null && (pBStringField3 = adInfo2.ext_json) != null) {
                    str4 = pBStringField3.get();
                }
                if (str4 != null && str4.length() != 0) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                if (z26) {
                    str2 = "";
                } else {
                    str2 = new JSONObject(str4).optString("img2", "");
                }
            }
            if (str2 == null || str2.length() == 0) {
                z27 = true;
            }
            if (z27) {
                return "";
            }
            return str2;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo3 = ad5.info;
        if (adInfo3 != null && (pBStringField2 = adInfo3.ext_json) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            downloadUrl = "";
        } else {
            downloadUrl = new JSONObject(str).optString(QWalletPreferenceApiImpl.PREF_KEY_ZIP_URL, "");
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo4 = ad5.info;
        if (adInfo4 != null && (ext = adInfo4.ext) != null && (ext2 = ext.get()) != null && (pBStringField = ext2.zip_url) != null) {
            str4 = pBStringField.get();
        }
        if (downloadUrl != null && downloadUrl.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (str4 != null && str4.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                str3 = str4;
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(downloadUrl, "downloadUrl");
            str3 = downloadUrl;
        }
        if (str3 == null || str3.length() == 0) {
            z27 = true;
        }
        if (!z27) {
            return URLUtil.addParameter(str3, "name", businessName);
        }
        return str3;
    }

    @NotNull
    public final String j(@Nullable String url, @NotNull String resSuffix) {
        boolean z16;
        Intrinsics.checkNotNullParameter(resSuffix, "resSuffix");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str = "";
        if (z16) {
            return "";
        }
        String md5 = MD5.toMD5(url);
        if (!TextUtils.isEmpty(resSuffix)) {
            str = md5 + resSuffix;
        }
        return m() + md5 + '/' + str;
    }

    @NotNull
    public final String k(@NotNull String businessName, int adType) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        if (TextUtils.equals(businessName, "tianshu")) {
            return ".mp4";
        }
        if (r(adType)) {
            return ".apng";
        }
        return ".zip";
    }

    @NotNull
    public final String l(@Nullable String url, int adType) {
        try {
            if (TextUtils.isEmpty(url)) {
                return "";
            }
            if (!r(adType) && adType != 0) {
                String md5 = MD5.toMD5(url);
                String m3 = m();
                File file = new File(m3 + md5 + '/', "manifest.json");
                String str = "alphaVideo.mp4";
                if (file.exists()) {
                    JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                    if (jSONObject.optInt("superMaskType", 0) == 3) {
                        str = jSONObject.optString("animFileName", "alphaVideo.mp4");
                        Intrinsics.checkNotNullExpressionValue(str, "configJson.optString(SUP\u2026NAME, DEFAULT_RES_SUFFIX)");
                    }
                }
                return m3 + md5 + '/' + str;
            }
            return j(url, n(adType));
        } catch (Throwable th5) {
            QLog.e("MaskAdDownloadHelper", 1, "get adRes path failed, error is " + th5);
            return "";
        }
    }

    @NotNull
    public final String m() {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic("qq_mask_ad", PreDownloadConstants.DEPARTMENT_VAS, false) + '/';
    }

    @Nullable
    public final String p() {
        ArrayList<JSONObject> j3 = MaskAdDownloadManager.f308139a.j(MaskAdvName.QQ_SHOP);
        if (j3 != null && !j3.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                try {
                    Iterator<JSONObject> it = j3.iterator();
                    while (it.hasNext()) {
                        JSONObject next = it.next();
                        long optLong = next.optLong("aid");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("aid", optLong);
                        jSONObject2.put("creative_id", next.optLong("creative_id"));
                        jSONObject2.put("version", next.optLong("version"));
                        jSONObject.put(String.valueOf(optLong), jSONObject2);
                    }
                    return jSONObject.toString();
                } catch (Exception e16) {
                    QLog.e("MaskAdDownloadHelper", 1, "getShopCacheAdJson failed, error is ", e16);
                    return jSONObject.toString();
                }
            } catch (Throwable unused) {
                return jSONObject.toString();
            }
        }
        return null;
    }

    public final boolean r(int adType) {
        if (adType != 50 && adType != 49) {
            return false;
        }
        return true;
    }
}

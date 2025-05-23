package com.tencent.mobileqq.vas.adv.preload;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoDeclare;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdDownloadCallBack;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import fz2.AdConfigBean;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J8\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J,\u0010\u0018\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u001f\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J \u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010&\u001a\u00020\u0002J\"\u0010*\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010(j\n\u0012\u0004\u0012\u00020#\u0018\u0001`)2\u0006\u0010\u000e\u001a\u00020'J\u0016\u0010,\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\nR\u0016\u0010/\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R>\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0;j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`<8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/MaskAdDownloadManager;", "", "", "t", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "rsp", "k", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$PosAdInfo;", "adInfo", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdDownloadCallBack;", "realTimeDownloadCallBack", "p", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "downloadUrl", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, ReportConstant.COSTREPORT_PREFIX, "url", "filePath", "Lcom/tencent/mobileqq/vip/f;", "downloadListener", "f", "Lcom/tencent/mobileqq/vip/g;", "task", "", "aid", "", "isPreload", "l", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "cachedAds", h.F, "o", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "callBack", "r", "b", "J", "mAdEffectiveInterval", "c", "I", "mAdInfoListMaxSize", "Lcom/tencent/mobileqq/vip/h;", "d", "Lcom/tencent/mobileqq/vip/h;", "mDownloaderInterface", "Lfz2/a;", "e", "Lfz2/a;", "mMaskAdConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getMMaskAdPosId", "()Ljava/util/HashMap;", "setMMaskAdPosId", "(Ljava/util/HashMap;)V", "mMaskAdPosId", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "g", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class MaskAdDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MaskAdDownloadManager f308139a = new MaskAdDownloadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mAdEffectiveInterval = 604800000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int mAdInfoListMaxSize = 20;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.vip.h mDownloaderInterface = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static AdConfigBean mMaskAdConfig = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Business/Ad/Inject_ad_pos_id_config.yml", version = 1)
    @NotNull
    private static HashMap<String, String> mMaskAdPosId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity mEntity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/preload/MaskAdDownloadManager$a", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements VasAdCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (retCode == 0 && adRsp != null && adRsp.qq_ad_get_rsp.pos_ads_info.has()) {
                MaskAdDownloadManager maskAdDownloadManager = MaskAdDownloadManager.f308139a;
                qq_ad_get.QQAdGetRsp qQAdGetRsp = adRsp.qq_ad_get_rsp;
                Intrinsics.checkNotNullExpressionValue(qQAdGetRsp, "adRsp.qq_ad_get_rsp");
                maskAdDownloadManager.k(qQAdGetRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MaskAdDownloadManager", 2, "ad rsp failed");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/adv/preload/MaskAdDownloadManager$b", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDoneFile", "onDone", "", "onStart", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f308146a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GdtAd f308147b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference<MaskAdDownloadCallBack> f308148c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ qq_ad_get.QQAdGetRsp.AdInfo f308149d;

        b(String str, GdtAd gdtAd, WeakReference<MaskAdDownloadCallBack> weakReference, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            this.f308146a = str;
            this.f308147b = gdtAd;
            this.f308148c = weakReference;
            this.f308149d = adInfo;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@Nullable g task) {
            String str;
            boolean z16 = false;
            if (task != null && task.i() == 3) {
                z16 = true;
            }
            if (z16) {
                str = "maskAdResourceDownloadSuccess";
            } else {
                str = "maskAdResourceDownloadFailed";
            }
            e.f308162a.b(MaskAdvName.EMPTY, str, null);
            super.onDone(task);
            MaskAdDownloadCallBack maskAdDownloadCallBack = this.f308148c.get();
            if (maskAdDownloadCallBack != null) {
                maskAdDownloadCallBack.realTimeDownloadDone(this.f308149d);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(@Nullable g task) {
            boolean z16;
            super.onDoneFile(task);
            if (!TextUtils.equals(this.f308146a, "tianshu")) {
                MaskAdDownloadManager maskAdDownloadManager = MaskAdDownloadManager.f308139a;
                long aId = this.f308147b.getAId();
                if (this.f308148c.get() == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                maskAdDownloadManager.l(task, aId, z16);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(@Nullable g task) {
            return super.onStart(task);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        mMaskAdPosId = hashMap;
        hashMap.put("qfs_pub", "5005607931217942");
        mMaskAdPosId.put("shop", "7085109922408095");
        mMaskAdPosId.put("health_tianshu", "mengcheng_tianshu_1012");
        mMaskAdPosId.put("weather_tianshu", "mengcheng_tianshu_1013");
        mMaskAdPosId.put(WidgetCacheConstellationData.HEALTH, "1082214467882419");
        mMaskAdPosId.put("waeather", "6011195015998218");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        mEntity = from;
    }

    MaskAdDownloadManager() {
    }

    private final void f(final String url, final String filePath, final com.tencent.mobileqq.vip.f downloadListener, final String businessName) {
        boolean z16;
        if (!TextUtils.isEmpty(url)) {
            if (filePath != null && filePath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.preload.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MaskAdDownloadManager.g(url, filePath, businessName, downloadListener);
                    }
                }, 128, null, true);
                return;
            }
        }
        QLog.i("MaskAdDownloadManager", 1, "cancel real download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String str, String str2, String businessName, com.tencent.mobileqq.vip.f downloadListener) {
        Intrinsics.checkNotNullParameter(businessName, "$businessName");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        g gVar = new g(str, new File(str2));
        gVar.f313008f = 2;
        gVar.S = businessName;
        e.f308162a.b(MaskAdvName.EMPTY, " maskAdResourceDownloadStart", null);
        com.tencent.mobileqq.vip.h hVar = mDownloaderInterface;
        if (hVar != null) {
            hVar.startDownload(gVar, downloadListener, null);
        }
    }

    private final void h(JSONObject cachedAds, String businessName) {
        int coerceAtMost;
        try {
            Iterator keys = cachedAds.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "cachedAds.keys()");
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                JSONObject jSONObject = new JSONObject(cachedAds.optString(String.valueOf(keys.next()), ""));
                if (currentTimeMillis - jSONObject.optLong("update_time", 0L) <= mAdEffectiveInterval) {
                    arrayList.add(jSONObject);
                }
            }
            final MaskAdDownloadManager$filterAdJsonList$1 maskAdDownloadManager$filterAdJsonList$1 = new Function2<JSONObject, JSONObject, Integer>() { // from class: com.tencent.mobileqq.vas.adv.preload.MaskAdDownloadManager$filterAdJsonList$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(JSONObject jSONObject2, JSONObject jSONObject3) {
                    return Integer.valueOf(jSONObject2.optLong("update_time", 0L) < jSONObject3.optLong("update_time", 0L) ? 1 : -1);
                }
            };
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: com.tencent.mobileqq.vas.adv.preload.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i3;
                    i3 = MaskAdDownloadManager.i(Function2.this, obj, obj2);
                    return i3;
                }
            });
            JSONObject jSONObject2 = new JSONObject();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(mAdInfoListMaxSize, arrayList.size());
            for (int i3 = 0; i3 < coerceAtMost; i3++) {
                jSONObject2.put(((JSONObject) arrayList.get(i3)).optString("aid"), ((JSONObject) arrayList.get(i3)).toString());
            }
            mEntity.encodeString(businessName + com.tencent.mobileqq.vas.adv.preload.a.f308150a.h(), jSONObject2.toString());
        } catch (Throwable th5) {
            QLog.e("MaskAdDownloadManager", 1, "filterAdJsonList failed, error is ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(qq_ad_get.QQAdGetRsp rsp) {
        try {
            for (qq_ad_get.QQAdGetRsp.PosAdInfo adInfo : rsp.pos_ads_info.get()) {
                if (adInfo.has() && !adInfo.ads_info.get().isEmpty()) {
                    Intrinsics.checkNotNullExpressionValue(adInfo, "adInfo");
                    p(adInfo, new WeakReference<>(null));
                }
                QLog.d("MaskAdDownloadManager", 2, "adInfo inValid");
            }
        } catch (Throwable th5) {
            QLog.e("MaskAdDownloadManager", 1, "handMaskAdRsp failed", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(g task, long aid, boolean isPreload) {
        Map<String, File> map;
        String str;
        if (task != null) {
            try {
                map = task.f313010h;
            } catch (Throwable th5) {
                QLog.e("MaskAdDownloadManager", 1, th5, new Object[0]);
                return;
            }
        } else {
            map = null;
        }
        if (map != null && !TextUtils.isEmpty(task.f313004c)) {
            File file = task.f313010h.get(task.f313004c);
            if (file == null) {
                QLog.i("MaskAdDownloadManager", 1, "downloaded file is null, cancel unzip file");
                return;
            }
            if (!file.exists()) {
                QLog.i("MaskAdDownloadManager", 1, "downloaded file not exit, cancel unzip file");
                return;
            }
            e eVar = e.f308162a;
            MaskAdvName maskAdvName = MaskAdvName.EMPTY;
            eVar.b(maskAdvName, "maskAdResourceUnzipStart", null);
            String j3 = com.tencent.mobileqq.vas.adv.preload.a.f308150a.j(task.f313004c, "");
            int unZipFolder = ZipUtils.unZipFolder(file.getAbsolutePath(), j3);
            if (unZipFolder == 0) {
                str = "maskAdResourceUnzipSuccess";
            } else {
                str = "maskAdResourceUnzipFailed";
            }
            eVar.b(maskAdvName, str, null);
            if (unZipFolder == 0) {
                FileUtils.delete(file.getAbsolutePath(), true);
            }
            if (isPreload) {
                String valueOf = String.valueOf(aid);
                String str2 = task.S;
                Intrinsics.checkNotNullExpressionValue(str2, "task.businessCode");
                n("new_folder_splashad_preload", valueOf, str2);
            }
            if (QLog.isColorLevel()) {
                QLog.i("MaskAdDownloadManager", 1, "start unzip file, file path is " + file.getAbsolutePath() + " target path is" + j3);
                return;
            }
            return;
        }
        QLog.i("MaskAdDownloadManager", 1, "task info unusual, cancel unzip file");
    }

    private final boolean m() {
        boolean z16;
        long decodeLong = mEntity.decodeLong("last_request_time" + com.tencent.mobileqq.vas.adv.preload.a.f308150a.h(), 0L);
        AdConfigBean adConfigBean = mMaskAdConfig;
        if (adConfigBean != null && !adConfigBean.getIsPreloadAd()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || NetConnInfoCenter.getServerTime() - decodeLong < 600) {
            return true;
        }
        return false;
    }

    private final void n(String reportAction, String aid, String businessName) {
        String str;
        if (TextUtils.equals(businessName, AdHippyFragment.HEALTH_NAME) && TextUtils.equals(businessName, "weather")) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(aid);
            sb5.append("||");
            if (TextUtils.equals(businessName, "weather")) {
                str = "1";
            } else {
                str = "2|" + AppSetting.getSubVersion();
            }
            sb5.append(str);
            ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportMaskAd(null, reportAction, sb5.toString());
        }
    }

    private final void p(final qq_ad_get.QQAdGetRsp.PosAdInfo adInfo, final WeakReference<MaskAdDownloadCallBack> realTimeDownloadCallBack) {
        com.tencent.mobileqq.vas.adv.preload.a aVar = com.tencent.mobileqq.vas.adv.preload.a.f308150a;
        String str = adInfo.pos_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "adInfo.pos_id.get()");
        final String f16 = aVar.f(str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.preload.b
            @Override // java.lang.Runnable
            public final void run() {
                MaskAdDownloadManager.q(f16, adInfo, realTimeDownloadCallBack);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String businessName, qq_ad_get.QQAdGetRsp.PosAdInfo adInfo, WeakReference realTimeDownloadCallBack) {
        boolean z16;
        JSONObject jSONObject;
        String i3;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(businessName, "$businessName");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Intrinsics.checkNotNullParameter(realTimeDownloadCallBack, "$realTimeDownloadCallBack");
        String decodeString = mEntity.decodeString(businessName + com.tencent.mobileqq.vas.adv.preload.a.f308150a.h(), "");
        if (decodeString != null && decodeString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(decodeString);
        }
        for (qq_ad_get.QQAdGetRsp.AdInfo info : adInfo.ads_info.get()) {
            GdtAd gdtAd = new GdtAd(info);
            if (TextUtils.equals(businessName, "tianshu")) {
                i3 = gdtAd.getVideoUrl();
            } else {
                i3 = com.tencent.mobileqq.vas.adv.preload.a.f308150a.i(gdtAd, businessName);
            }
            String valueOf = String.valueOf(gdtAd.getAId());
            com.tencent.mobileqq.vas.adv.preload.a aVar = com.tencent.mobileqq.vas.adv.preload.a.f308150a;
            if (i3 == null) {
                str = "";
            } else {
                str = i3;
            }
            jSONObject.put(valueOf, aVar.d(gdtAd, str));
            if (realTimeDownloadCallBack.get() == null) {
                f308139a.n("new_folder_splashad_start_preload", String.valueOf(gdtAd.getAId()), businessName);
            }
            if (aVar.c(aVar.l(i3, gdtAd.getInnerShowType()))) {
                if (QLog.isColorLevel()) {
                    QLog.d("MaskAdDownloadManager", 1, "res has downloaded, cancel download");
                }
                MaskAdDownloadCallBack maskAdDownloadCallBack = (MaskAdDownloadCallBack) realTimeDownloadCallBack.get();
                if (maskAdDownloadCallBack != null) {
                    maskAdDownloadCallBack.realTimeDownloadDone(info);
                }
            } else {
                MaskAdDownloadManager maskAdDownloadManager = f308139a;
                if (i3 == null) {
                    str2 = "";
                } else {
                    str2 = i3;
                }
                Intrinsics.checkNotNullExpressionValue(info, "info");
                maskAdDownloadManager.s(businessName, str2, info, gdtAd.getInnerShowType(), realTimeDownloadCallBack);
            }
        }
        f308139a.h(jSONObject, businessName);
    }

    private final void s(String businessName, String downloadUrl, qq_ad_get.QQAdGetRsp.AdInfo adInfo, int adType, WeakReference<MaskAdDownloadCallBack> realTimeDownloadCallBack) {
        boolean z16;
        if (downloadUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("MaskAdDownloadManager", 1, "can't download zip file, cancel download");
            return;
        }
        b bVar = new b(businessName, new GdtAd(adInfo), realTimeDownloadCallBack, adInfo);
        com.tencent.mobileqq.vas.adv.preload.a aVar = com.tencent.mobileqq.vas.adv.preload.a.f308150a;
        f(downloadUrl, aVar.j(downloadUrl, aVar.k(businessName, adType)), bVar, businessName);
    }

    private final void t() {
        if (QLog.isColorLevel()) {
            QLog.i("MaskAdDownloadManager", 2, "update config");
        }
        AdConfigBean adConfigBean = (AdConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100480");
        mMaskAdConfig = adConfigBean;
        if (adConfigBean != null) {
            long j3 = 60;
            mAdEffectiveInterval = adConfigBean.getAdEffectiveInterval() * 24 * j3 * j3 * 1000;
            mAdInfoListMaxSize = adConfigBean.getAdInfoListMaxSize();
        }
    }

    @Nullable
    public final ArrayList<JSONObject> j(@NotNull MaskAdvName businessName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        com.tencent.mobileqq.vas.adv.preload.a aVar = com.tencent.mobileqq.vas.adv.preload.a.f308150a;
        String e16 = aVar.e(businessName);
        boolean z17 = false;
        if (e16 != null && e16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        String cachedAdStr = mEntity.decodeString(e16 + aVar.h(), "");
        if (cachedAdStr == null || cachedAdStr.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(cachedAdStr, "cachedAdStr");
        return aVar.g(cachedAdStr);
    }

    public final void o() {
        long serverTime;
        if (m()) {
            if (QLog.isColorLevel()) {
                QLog.i("MaskAdDownloadManager", 2, "can't preload ad, cancel preload");
                return;
            }
            return;
        }
        MMKVOptionEntity mMKVOptionEntity = mEntity;
        String str = "last_request_time" + com.tencent.mobileqq.vas.adv.preload.a.f308150a.h();
        if (QLog.isDebugVersion()) {
            serverTime = 0;
        } else {
            serverTime = NetConnInfoCenter.getServerTime();
        }
        mMKVOptionEntity.encodeLong(str, serverTime);
        QLog.i("MaskAdDownloadManager", 2, "config is " + mMaskAdConfig);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        AdConfigBean adConfigBean = mMaskAdConfig;
        if (adConfigBean != null) {
            build.getAdvPos().add(adConfigBean.getWeatherFirstPosId());
            build.getAdvPos().add(adConfigBean.getHealthPosId());
            build.getAdvPos().add(adConfigBean.getTianShuWeatherPosId());
            build.getAdvPos().add(adConfigBean.getTianShuHealthPosId());
        }
        for (Map.Entry<String, String> entry : mMaskAdPosId.entrySet()) {
            if (!build.getAdvPos().contains(entry.getValue())) {
                build.getAdvPos().add(entry.getValue());
            }
        }
        build.setBusiType(14);
        build.setUin(com.tencent.mobileqq.vas.adv.preload.a.f308150a.h());
        new com.tencent.mobileqq.vas.adv.base.service.d(build, new a()).j();
        t();
    }

    public final void r(@NotNull qq_ad_get.QQAdGetRsp.PosAdInfo adInfo, @NotNull MaskAdDownloadCallBack callBack) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (adInfo.get() == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MaskAdDownloadManager", 2, "ad rsp failed");
                return;
            }
            return;
        }
        p(adInfo, new WeakReference<>(callBack));
    }
}

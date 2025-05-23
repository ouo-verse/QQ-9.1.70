package ih;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ToastUtil;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J8\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\bJ \u0010\u0018\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013J\u0016\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0013J\u001e\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010$\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lih/e;", "", "", "a", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "tianshuAd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "k", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "qzoneActivity", "Landroid/os/ResultReceiver;", "resultReceiver", "Lcom/qzone/reborn/feedx/presenter/ad/reward/e;", "adResultCallBack", "isFullScreenClick", "isRealTimeRequest", "j", "", "url", tl.h.F, "b", "rewardItem", "l", DomainData.DOMAIN_NAME, "e", "f", QZoneDTLoginReporter.SCHEMA, "h5Url", "d", "g", "userName", "path", "i", "", "J", "mLastRewardClickTime", "c", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "mAdSequence", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f407623a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mLastRewardClickTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mAdSequence;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ih/e$a", "Ltz2/c;", "", "adSequence", "", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements tz2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f407626a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.feedx.presenter.ad.reward.e f407627b;

        a(Activity activity, com.qzone.reborn.feedx.presenter.ad.reward.e eVar) {
            this.f407626a = activity;
            this.f407627b = eVar;
        }

        @Override // tz2.c
        public void b(VasAdvServiceCode code, String errMsg) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("QZoneAdJumpUtils", 1, "[requestRealTimeRewardAd] request rewardAd error");
            ToastUtil.s("\u62c9\u53d6\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5", 4);
        }

        @Override // tz2.c
        public void a(long adSequence) {
            QLog.i("QZoneAdJumpUtils", 1, "[requestRealTimeRewardAd] show realtime request rewardAd");
            e eVar = e.f407623a;
            eVar.m(adSequence);
            eVar.n(this.f407626a, this.f407627b);
        }
    }

    e() {
    }

    private final boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = currentTimeMillis - mLastRewardClickTime < 500;
        mLastRewardClickTime = currentTimeMillis;
        return z16;
    }

    public final void b() {
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).ensureDeviceInfoValid();
    }

    public final long c() {
        return mAdSequence;
    }

    public final boolean d(Activity activity, String schema, String h5Url) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(h5Url, "h5Url");
        if (TextUtils.isEmpty(schema)) {
            return f(activity, h5Url);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(schema));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            PackageManager packageManager = activity.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "activity.getPackageManager()");
            if (packageManager.resolveActivity(intent, 65536) != null) {
                activity.startActivity(intent);
                return false;
            }
        } catch (Exception e16) {
            QLog.e("QZoneAdJumpUtils", 1, "handleJumpAppSchema" + e16);
        }
        return f(activity, h5Url);
    }

    public final void e(Activity activity, vac_adv_get.QzoneActivity qzoneActivity, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        GdtMotiveVideoPageData createMVPageData = GdtUtil.createMVPageData(QZoneAdFeedUtils.f55717a.z(qzoneActivity), GdtUtil.adapterToAndroidScreenOrientation(3));
        if (createMVPageData != null) {
            createMVPageData.motiveBrowsingKey = "QZONE_REWARD_AD_MOTIVE_BROWSING";
        }
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, createMVPageData, resultReceiver));
    }

    public final boolean f(Activity activity, String url) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            QLog.i("QZoneAdJumpUtils", 1, "jumpH5Url is null");
            return false;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtra(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
            activity.startActivity(intent);
            return true;
        } catch (Exception e16) {
            QLog.e("QZoneAdJumpUtils", 1, "handleJumpH5" + e16);
            return false;
        }
    }

    public final void g(Activity activity, String schema) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(schema, "schema");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, schema, 2054, null);
    }

    public final void h(Activity activity, String url) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        f(activity, url);
    }

    public final void i(Activity activity, String userName, String path) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(path, "path");
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, "wxf0a80d0ac2e82aa7");
        if (!createWXAPI.isWXAppInstalled()) {
            QQToastUtil.showQQToast(1, R.string.f170986w14);
            return;
        }
        if (createWXAPI.getWXAppSupportAPI() < 621086464) {
            QQToastUtil.showQQToast(1, R.string.f170987w15);
            return;
        }
        try {
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = userName;
            req.path = path;
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
        } catch (Throwable th5) {
            QLog.e("QZoneAdJumpUtils", 1, "[handleJumpWXMiniProgram] sendReq error:" + th5);
        }
    }

    public final void j(Activity activity, vac_adv_get.QzoneActivity qzoneActivity, ResultReceiver resultReceiver, com.qzone.reborn.feedx.presenter.ad.reward.e adResultCallBack, boolean isFullScreenClick, boolean isRealTimeRequest) {
        PBStringField pBStringField;
        boolean contains;
        PBEnumField pBEnumField;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        Intrinsics.checkNotNullParameter(adResultCallBack, "adResultCallBack");
        if (a()) {
            return;
        }
        String str = null;
        if (isFullScreenClick) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            contains = CollectionsKt___CollectionsKt.contains(qZoneAdFeedUtils.x(), (qzoneActivity == null || (pBStringField2 = qzoneActivity.trace_id) == null) ? null : pBStringField2.get());
            if (!contains) {
                if (isRealTimeRequest) {
                    QLog.i("QZoneAdJumpUtils", 1, "[handleRewardAdJump] realTime request rewardAd");
                    b();
                    vac_adv_get.Activity y16 = qZoneAdFeedUtils.y(qzoneActivity);
                    l(activity, adResultCallBack, String.valueOf((y16 == null || (pBEnumField = y16.reward_type) == null) ? 0 : pBEnumField.get()));
                    return;
                }
                QLog.i("QZoneAdJumpUtils", 1, "[handleRewardAdJump] show pre request rewardAd");
                e(activity, qzoneActivity, resultReceiver);
                return;
            }
        }
        vac_adv_get.Activity y17 = QZoneAdFeedUtils.f55717a.y(qzoneActivity);
        if (y17 != null && (pBStringField = y17.jump_url) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            str = "";
        }
        h(activity, str);
    }

    public final void k(QZoneAdTianshuFeedData tianshuAd, Activity activity) {
        Intrinsics.checkNotNullParameter(tianshuAd, "tianshuAd");
        if (activity == null) {
            return;
        }
        f.f407629a.i(tianshuAd, 1);
        String jumpType = tianshuAd.getJumpType();
        switch (jumpType.hashCode()) {
            case 49:
                if (jumpType.equals("1")) {
                    f(activity, tianshuAd.getH5Url());
                    return;
                }
                return;
            case 50:
                if (jumpType.equals("2")) {
                    g(activity, tianshuAd.getSchemaUrl());
                    return;
                }
                return;
            case 51:
                if (jumpType.equals("3")) {
                    i(activity, tianshuAd.getWxUserName(), tianshuAd.getWxPath());
                    return;
                }
                return;
            case 52:
                if (jumpType.equals("4")) {
                    d(activity, tianshuAd.getSchemaUrl(), tianshuAd.getH5Url());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void l(Activity activity, com.qzone.reborn.feedx.presenter.ad.reward.e adResultCallBack, String rewardItem) {
        Intrinsics.checkNotNullParameter(adResultCallBack, "adResultCallBack");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        VasRewardAdReqParams.a aVar = new VasRewardAdReqParams.a();
        aVar.d(26);
        aVar.c(rewardItem);
        VasRewardAdReqParams a16 = aVar.a();
        if (!NetworkUtil.isNetSupport(activity)) {
            QLog.e("QZoneAdJumpUtils", 1, "[requestRealTimeRewardAd] request error, network disconnect");
            ToastUtil.s("\u62c9\u53d6\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5", 4);
        } else {
            ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).requestAd(a16, new a(activity, adResultCallBack));
        }
    }

    public final void m(long j3) {
        mAdSequence = j3;
    }

    public final void n(Activity activity, com.qzone.reborn.feedx.presenter.ad.reward.e adResultCallBack) {
        Intrinsics.checkNotNullParameter(adResultCallBack, "adResultCallBack");
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).showRewardAd(activity, mAdSequence, "\u83b7\u5f97\u6709\u6548\u5956\u52b1", "biz_src_jc_qzone", new b(adResultCallBack));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"ih/e$b", "Ltz2/d;", "", "code", "", "profitable", "elapsedTime", "totalTime", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements tz2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.feedx.presenter.ad.reward.e f407628a;

        b(com.qzone.reborn.feedx.presenter.ad.reward.e eVar) {
            this.f407628a = eVar;
        }

        @Override // tz2.d
        public void a(int code, boolean profitable, int elapsedTime, int totalTime) {
            if (code != 0) {
                QLog.e("QZoneAdJumpUtils", 1, "[showRealTimeRewardAd] show rewardAd error");
                ToastUtil.s("\u62c9\u53d6\u5f02\u5e38\uff0c\u7a0d\u540e\u91cd\u8bd5", 4);
            } else {
                this.f407628a.a(profitable, elapsedTime, totalTime);
            }
        }
    }
}

package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DrawableRes;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSAdDownloadButton;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRecomInfo;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Foreground;
import seal.SealEdgeComputing$AdvertInfo;
import seal.SealEdgeComputing$ClientItemInfo;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f85448a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f85449b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f85450a;

        a(float f16) {
            this.f85450a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f85450a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements QFSAdDownloadButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdAppDownloadButtonController f85451a;

        b(AdAppDownloadButtonController adAppDownloadButtonController) {
            this.f85451a = adAppDownloadButtonController;
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSAdDownloadButton.b
        public void onCancelClick() {
            this.f85451a.onCancelClick(10067);
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSAdDownloadButton.b
        public void onClick(int i3) {
            int i16;
            if (i3 == 5) {
                i16 = 10068;
            } else {
                i16 = 10066;
            }
            this.f85451a.onClick(i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public static String A(GdtAd gdtAd, View view) {
        if (gdtAd != null && gdtAd.isValid() && gdtAd.isAppProductType()) {
            if (c(gdtAd, view)) {
                return "\u53bb\u6253\u5f00";
            }
            return "\u53bb\u4e0b\u8f7d";
        }
        return "\u53bb\u770b\u770b";
    }

    private static GdtHandler.Params B(Activity activity, GdtAd gdtAd) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.activity = new WeakReference<>(activity);
        params.f108486ad = gdtAd;
        params.sceneID = 0;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ads_xsj");
        return params;
    }

    public static int C(GdtAd gdtAd) {
        String str;
        if (gdtAd != null) {
            str = gdtAd.getMarketPendantImageUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFSFeedAdUiHelper", 1, "[getMarketingPendantStyle] error, url is empty");
            return Integer.MIN_VALUE;
        }
        if (gdtAd == null) {
            return Integer.MIN_VALUE;
        }
        return gdtAd.getExperimentIntegerParam(124210, Integer.MIN_VALUE);
    }

    public static String D(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo motivePupInfo;
        if (gdtAd == null || (motivePupInfo = gdtAd.getMotivePupInfo()) == null || TextUtils.isEmpty(motivePupInfo.background_color.get())) {
            return "#804200CF";
        }
        return motivePupInfo.background_color.get();
    }

    public static String E(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo motivePupInfo;
        if (gdtAd == null || (motivePupInfo = gdtAd.getMotivePupInfo()) == null || TextUtils.isEmpty(motivePupInfo.font_color.get())) {
            return "#FFFFFF";
        }
        return motivePupInfo.font_color.get();
    }

    public static qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BannerInfo F(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (displayInfo = adInfo.display_info) != null) {
            return displayInfo.banner_info;
        }
        return null;
    }

    private static String G() {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic("qcircle_ad_pag_audio", PreDownloadConstants.DEPARTMENT_VAS, false) + "/";
    }

    public static String H(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        if (gdtAd == null || (adInfo = gdtAd.info) == null || !adInfo.display_info.pic_to_video_template_url.has()) {
            return "";
        }
        return gdtAd.info.display_info.pic_to_video_template_url.get();
    }

    public static Boolean I(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return Boolean.valueOf("1".equals(N(feedCloudMeta$StFeed, "bannerFromBeginning")));
    }

    public static boolean J(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return "1".equals(N(feedCloudMeta$StFeed, "hasBigCard"));
    }

    public static boolean K(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return "1".equals(N(feedCloudMeta$StFeed, "hasLittleCard"));
    }

    public static String L(GdtAd gdtAd) {
        if (gdtAd != null) {
            return gdtAd.getExperimentParam(124648);
        }
        return null;
    }

    public static long M() {
        return uq3.k.b().f("sp_key_ad_space_displayed_last_time_millis", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    private static String N(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (feedCloudMeta$StFeed != null && !feedCloudMeta$StFeed.extInfo.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StFeed.extInfo.get()) {
                if (TextUtils.equals(feedCloudCommon$Entry.key.get(), str)) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return "";
    }

    public static int O(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            String N = N(feedCloudMeta$StFeed, "firstAnimationDuration");
            if (TextUtils.isEmpty(N)) {
                return 1000;
            }
            return 1000 * Integer.parseInt(N);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QFSFeedAdUiHelper", 2, "getTopViewFirstAnimDuration error::" + e16);
            }
            return 1000;
        }
    }

    public static int P(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        try {
            String N = N(feedCloudMeta$StFeed, "secondAnimationDuration");
            if (TextUtils.isEmpty(N)) {
                return 2000;
            }
            return Integer.parseInt(N) * 1000;
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QFSFeedAdUiHelper", 2, "getTopViewSecondAnimDuration error::" + e16);
            }
            return 2000;
        }
    }

    public static void Q(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FrameLayout frameLayout) {
        j0((GradientDrawable) frameLayout.getBackground(), w(feedCloudMeta$StFeed, "startColor"), w(feedCloudMeta$StFeed, "endColor"));
    }

    public static AdAppDownloadButtonController R(Activity activity, GdtAd gdtAd, QFSAdDownloadButton qFSAdDownloadButton, View view, @DrawableRes int i3) {
        if (gdtAd == null || qFSAdDownloadButton == null || view == null) {
            return null;
        }
        boolean k3 = k(gdtAd);
        QLog.d("QFSFeedAdUiHelper", 1, "initDownloadBtnView isValid: " + k3);
        if (!k3) {
            qFSAdDownloadButton.setVisibility(8);
            view.setVisibility(0);
            return null;
        }
        qFSAdDownloadButton.setAd(gdtAd);
        qFSAdDownloadButton.setActionBtnLayoutBg(i3);
        AdAppDownloadButtonController.Params params = new AdAppDownloadButtonController.Params();
        params.clickParams = GdtHandler.toParams(B(activity, gdtAd));
        qFSAdDownloadButton.update(0, 100);
        AdAppDownloadButtonController adAppDownloadButtonController = new AdAppDownloadButtonController(params);
        adAppDownloadButtonController.registerView(new WeakReference<>(qFSAdDownloadButton));
        qFSAdDownloadButton.setVisibility(0);
        view.setVisibility(8);
        qFSAdDownloadButton.setOnAdBtnClickListener(new b(adAppDownloadButtonController));
        return adAppDownloadButtonController;
    }

    public static boolean S(QCircleAsyncTextView qCircleAsyncTextView, String str, int i3, int i16) {
        if (qCircleAsyncTextView.getPaint().measureText(str + "\u8d1f\u53cd\u9988") > i3 * i16) {
            return true;
        }
        return false;
    }

    public static boolean T(GdtAd gdtAd) {
        if (gdtAd == null) {
            return false;
        }
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 1 && innerShowType != 2) {
            return false;
        }
        return true;
    }

    public static boolean U() {
        return f85448a;
    }

    public static boolean V(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo adMaterialInfo = gdtAd.getAdMaterialInfo();
        if (adMaterialInfo != null && !TextUtils.isEmpty(adMaterialInfo.image_url.get()) && !TextUtils.isEmpty(adMaterialInfo.title.get())) {
            return true;
        }
        return false;
    }

    private static boolean W(GdtAd gdtAd) {
        return true;
    }

    public static boolean X(GdtAd gdtAd) {
        if (y(gdtAd) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Y(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2, GdtAd gdtAd) {
        if (n(feedCloudMeta$StFeed, feedCloudMeta$StFeed2, gdtAd) || gdtAd == null || !gdtAd.canLeftSlide() || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ad_enable_left_slide", true)) {
            return false;
        }
        return true;
    }

    public static boolean Z(GdtAd gdtAd) {
        if (gdtAd == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ad_enable_shake", true)) {
            return false;
        }
        if (!gdtAd.canBidAdShake() && !gdtAd.canContractAdShake()) {
            return false;
        }
        return true;
    }

    public static void a(View view) {
        if (view != null && view.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = p();
            view.setLayoutParams(layoutParams);
        }
    }

    public static boolean a0(GdtAd gdtAd, int i3) {
        if ((gdtAd != null && QFSTopViewManager.h(gdtAd.info)) || eq.f85700a.f(i3)) {
            return true;
        }
        return false;
    }

    public static boolean b(GdtAd gdtAd, Activity activity) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ads_xsj");
        params.activity = new WeakReference<>(activity);
        return GdtHandler.canLaunchApp(params);
    }

    public static boolean b0(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo motivePupInfo;
        if (gdtAd == null || (motivePupInfo = gdtAd.getMotivePupInfo()) == null || TextUtils.isEmpty(motivePupInfo.text.get())) {
            return false;
        }
        return true;
    }

    public static boolean c(GdtAd gdtAd, View view) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ads_xsj");
        params.activity = new WeakReference<>((Activity) view.getContext());
        return GdtHandler.canLaunchApp(params);
    }

    public static boolean c0(GdtAd gdtAd) {
        if (gdtAd == null) {
            QLog.i("QFSFeedAdUiHelper", 2, "[isSupportDynamicBackground] mAd is null");
            return false;
        }
        if (TextUtils.isEmpty(gdtAd.getCardBackgroundUrl())) {
            QLog.i("QFSFeedAdUiHelper", 2, "[isSupportDynamicBackground] backgroundPagUrl is null");
            return false;
        }
        if (gdtAd.getCardBackgroundFormat() == 1) {
            return true;
        }
        QLog.e("QFSFeedAdUiHelper", 2, "[isSupportDynamicBackground] foramt error");
        return false;
    }

    public static boolean d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        SealEdgeComputing$AdvertInfo sealEdgeComputing$AdvertInfo;
        SealEdgeComputing$ClientItemInfo r16 = r(feedCloudMeta$StFeed, feedCloudMeta$StFeed2);
        if (r16 != null && (sealEdgeComputing$AdvertInfo = r16.advert_info) != null && sealEdgeComputing$AdvertInfo.use_rcmd_advert_room_switch.get()) {
            return true;
        }
        return false;
    }

    public static boolean d0(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BannerInfo F = F(gdtAd);
        if (F != null && F.type.get() == 2) {
            return true;
        }
        return false;
    }

    public static boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        SealEdgeComputing$AdvertInfo sealEdgeComputing$AdvertInfo;
        SealEdgeComputing$ClientItemInfo r16 = r(feedCloudMeta$StFeed, feedCloudMeta$StFeed2);
        if (r16 != null && (sealEdgeComputing$AdvertInfo = r16.advert_info) != null && sealEdgeComputing$AdvertInfo.can_show_advert_room.get()) {
            return true;
        }
        return false;
    }

    public static boolean e0(GdtAd gdtAd, String str, int i3) {
        if (i3 == 1 && gdtAd != null && TextUtils.equals(gdtAd.getExperimentParam(121009), str)) {
            return true;
        }
        return false;
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return TextUtils.equals(N(feedCloudMeta$StFeed, "highlightAtReplay"), "1");
    }

    public static boolean f0(GdtAd gdtAd, int i3) {
        return e0(gdtAd, "2", i3);
    }

    public static boolean g(GdtAd gdtAd, int i3) {
        List<String> arrayList;
        if (gdtAd != null) {
            arrayList = gdtAd.getDanmakuContents();
        } else {
            arrayList = new ArrayList<>();
        }
        if (arrayList == null || arrayList.isEmpty() || eq.f85700a.a(gdtAd, i3) || j(gdtAd, i3)) {
            return false;
        }
        return true;
    }

    public static boolean g0(GdtAd gdtAd, int i3) {
        if (e0(gdtAd, "1", i3) && !TextUtils.isEmpty(gdtAd.getPosterCoverUrl())) {
            return true;
        }
        return false;
    }

    public static boolean h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2, GdtAd gdtAd) {
        if (n(feedCloudMeta$StFeed, feedCloudMeta$StFeed2, gdtAd)) {
            return false;
        }
        if (d(feedCloudMeta$StFeed, feedCloudMeta$StFeed2)) {
            return true;
        }
        String N = N(feedCloudMeta$StFeed2, "endcardType");
        if (TextUtils.isEmpty(N) || TextUtils.equals(N, "0")) {
            return false;
        }
        return true;
    }

    public static String h0(ByteBuffer byteBuffer, String str) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        String md5 = MD5Utils.toMD5(str);
        try {
            String G = G();
            File file = new File(G);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(G + md5 + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);
            if (!file2.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            }
            return file2.getAbsolutePath();
        } catch (IOException e16) {
            QLog.e("QFSFeedAdUiHelper", 1, "outputAudioFile error:", e16);
            return "";
        }
    }

    public static boolean i(GdtAd gdtAd, int i3, int i16) {
        if (i16 == Integer.MIN_VALUE) {
            return false;
        }
        if (i16 == 1) {
            eq eqVar = eq.f85700a;
            if (eqVar.h(gdtAd)) {
                QLog.e("QFSFeedAdUiHelper", 2, "[getMarketingPendantStyle] error, is motive style");
                return false;
            }
            if (eqVar.b(gdtAd, i3)) {
                QLog.e("QFSFeedAdUiHelper", 2, "[canShowMarketingPendantStyle] error, is social pendant");
                return false;
            }
            if (eqVar.j(gdtAd, i3)) {
                QLog.e("QFSFeedAdUiHelper", 2, "[getMarketingPendantStyle] error, is poi style");
                return false;
            }
            if (eqVar.a(gdtAd, i3)) {
                QLog.e("QFSFeedAdUiHelper", 2, "[getMarketingPendantStyle] error, is tag style");
                return false;
            }
        } else if (i16 == 2) {
            if (eq.f85700a.h(gdtAd)) {
                QLog.i("QFSFeedAdUiHelper", 2, "[getMarketingPendantStyle] error, is motive style");
                return false;
            }
        } else {
            QLog.e("QFSFeedAdUiHelper", 1, "[getMarketingPendantStyle] error, unknown style, style:" + i16);
            return false;
        }
        if (eq.f85700a.l(gdtAd, i3)) {
            return true;
        }
        QLog.e("QFSFeedAdUiHelper", 2, "[getMarketingPendantStyle] error, not three state style, cardStyle:" + i3);
        return false;
    }

    public static void i0(GdtShakeIconView gdtShakeIconView) {
        if (gdtShakeIconView == null) {
            return;
        }
        gdtShakeIconView.stop();
    }

    public static boolean j(GdtAd gdtAd, int i3) {
        int C = C(gdtAd);
        if (C == 2 && i(gdtAd, i3, C)) {
            return true;
        }
        return false;
    }

    public static void j0(GradientDrawable gradientDrawable, String str, String str2) {
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setColors(new int[]{Color.parseColor(str), Color.parseColor(str2)});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    }

    public static boolean k(GdtAd gdtAd) {
        AdAppDownloadButtonController.Params params = new AdAppDownloadButtonController.Params();
        params.clickParams = GdtHandler.toParams(B(Foreground.getTopActivity(), gdtAd));
        return new AdAppDownloadButtonController(params).isValid();
    }

    public static void k0(boolean z16) {
        f85448a = z16;
    }

    public static boolean l(GdtAd gdtAd, int i3) {
        if (gdtAd == null || gdtAd.getLocalStoreInfo() == null || b0(gdtAd)) {
            return false;
        }
        if (eq.f85700a.b(gdtAd, i3)) {
            QLog.i("QFSFeedAdUiHelper", 2, "[canShowPoiCard] error, is socialPendantStyle");
            return false;
        }
        return !TextUtils.isEmpty(gdtAd.getLocalStoreInfo().store_name.get());
    }

    public static void l0(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new a(f16));
        view.setClipToOutline(true);
    }

    private static boolean m(long j3) {
        boolean z16 = false;
        if (j3 <= 0) {
            QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] return true, minIntervalMillis:" + j3);
            return false;
        }
        long M = M();
        if (M <= 0) {
            QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] return true, minIntervalMillis:" + j3 + " lastTimeMillis:" + M);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - M;
        if (currentTimeMillis >= j3) {
            z16 = true;
        }
        QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] result:" + z16 + " minIntervalMillis:" + j3 + " lastTimeMillis:" + M + " intervalMillis:" + currentTimeMillis);
        return z16;
    }

    public static void m0(GdtShakeIconView gdtShakeIconView) {
        if (gdtShakeIconView == null) {
            return;
        }
        gdtShakeIconView.stop();
        gdtShakeIconView.setVisibility(0);
        gdtShakeIconView.setImageResource();
        gdtShakeIconView.startAnimation(Integer.MAX_VALUE, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
    }

    public static boolean n(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2, GdtAd gdtAd) {
        int i3;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        if (a16 != DeviceType.PHONE) {
            QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] not supported, deviceType:" + a16);
            return false;
        }
        if (feedCloudMeta$StFeed2 == null) {
            QLog.e("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, adFeed is null");
            return false;
        }
        if (gdtAd == null) {
            QLog.e("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, ad is null");
            return false;
        }
        int innerShowType = gdtAd.getInnerShowType();
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = feedCloudMeta$StFeed2.video;
        int i16 = Integer.MIN_VALUE;
        if (feedCloudMeta$StVideo != null && (pBUInt32Field2 = feedCloudMeta$StVideo.width) != null) {
            i3 = pBUInt32Field2.get();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2 = feedCloudMeta$StFeed2.video;
        if (feedCloudMeta$StVideo2 != null && (pBUInt32Field = feedCloudMeta$StVideo2.height) != null) {
            i16 = pBUInt32Field.get();
        }
        if (innerShowType == 3) {
            if (i3 <= 0 || i16 <= 0 || i3 * 9 != i16 * 16) {
                QLog.e("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, innerAdShowType:" + innerShowType + " width:" + i3 + " height:" + i16);
                return false;
            }
        } else if (innerShowType == 4) {
            if (i3 <= 0 || i16 <= 0 || i3 * 16 != i16 * 9) {
                QLog.e("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, innerAdShowType:" + innerShowType + " width:" + i3 + " height:" + i16);
                return false;
            }
        } else {
            QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] not supported, innerAdShowType:" + innerShowType);
            return false;
        }
        if (!TextUtils.isEmpty(gdtAd.getAdvertiser_corporate_image_name()) && !TextUtils.isEmpty(gdtAd.getText()) && !TextUtils.isEmpty(gdtAd.getMotiveButtonText())) {
            if (d(feedCloudMeta$StFeed, feedCloudMeta$StFeed2)) {
                return e(feedCloudMeta$StFeed, feedCloudMeta$StFeed2);
            }
            int spaceFrequencyTimeSeconds = gdtAd.getSpaceFrequencyTimeSeconds();
            int spaceSlideThreshold = gdtAd.getSpaceSlideThreshold();
            if (spaceFrequencyTimeSeconds > 0 && spaceSlideThreshold > 0) {
                if (m(spaceFrequencyTimeSeconds * 1000)) {
                    return true;
                }
                QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] not enabled, too frequently, frequencyTimeSeconds:" + spaceFrequencyTimeSeconds + " slideThreshold:" + spaceSlideThreshold + " lastTimeMillis:" + M());
                return false;
            }
            QLog.i("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, frequencyTimeSeconds:" + spaceFrequencyTimeSeconds + " slideThreshold:" + spaceSlideThreshold);
            return false;
        }
        QLog.e("QFSFeedAdUiHelper", 1, "[canShowSpaceView] error, title:" + gdtAd.getAdvertiser_corporate_image_name() + " description:" + gdtAd.getText() + " buttonText:" + gdtAd.getMotiveButtonText());
        return false;
    }

    public static void n0(GdtShakeIconView gdtShakeIconView) {
        if (gdtShakeIconView == null) {
            return;
        }
        gdtShakeIconView.setVisibility(8);
        gdtShakeIconView.stop();
        gdtShakeIconView.resetImageResource();
    }

    public static boolean o(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return TextUtils.equals(N(feedCloudMeta$StFeed, "concatText"), "1");
    }

    public static void o0(View view, int i3) {
        GradientDrawable gradientDrawable;
        if (view == null || (gradientDrawable = (GradientDrawable) view.getBackground()) == null) {
            return;
        }
        gradientDrawable.setColor(i3);
    }

    public static int p() {
        return (int) (com.tencent.biz.qqcircle.utils.bz.j() * 0.72f);
    }

    public static void p0(ImageView imageView, Boolean bool) {
        int i3;
        if (imageView == null) {
            return;
        }
        if (bool.booleanValue()) {
            i3 = R.drawable.o1d;
        } else {
            i3 = R.drawable.o1c;
        }
        imageView.setImageResource(i3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = com.tencent.biz.qqcircle.utils.cx.a(78.0f);
        layoutParams.height = com.tencent.biz.qqcircle.utils.cx.a(17.0f);
    }

    public static int q(String str, String str2) {
        int parseColor = Color.parseColor(str);
        try {
            return Color.parseColor(str2);
        } catch (Exception e16) {
            QLog.e("QFSFeedAdUiHelper", 1, "parse color failed, error " + e16);
            return parseColor;
        }
    }

    public static void q0() {
        QLog.i("QFSFeedAdUiHelper", 1, "[updateSpaceDisplayedTimeMillis]");
        uq3.k.b().n("sp_key_ad_space_displayed_last_time_millis", System.currentTimeMillis());
    }

    private static SealEdgeComputing$ClientItemInfo r(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo;
        try {
            SealEdgeComputing$ClientItemInfo sealEdgeComputing$ClientItemInfo = new SealEdgeComputing$ClientItemInfo();
            if (feedCloudMeta$StFeed != null && (feedCloudMeta$StRecomInfo = feedCloudMeta$StFeed.recomInfo) != null) {
                byte[] byteArray = feedCloudMeta$StRecomInfo.clientSealData.get().toByteArray();
                sealEdgeComputing$ClientItemInfo.mergeFrom(byteArray);
                String str = "[getClientItemInfo] recom feed id: " + com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed) + " | ad feed id:" + com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed2) + " | traceid: " + com.tencent.biz.qqcircle.immersive.utils.ba.d(feedCloudMeta$StFeed) + " | can show advert room: " + sealEdgeComputing$ClientItemInfo.advert_info.can_show_advert_room.get() + " | use rcmd advert room switch: " + sealEdgeComputing$ClientItemInfo.advert_info.use_rcmd_advert_room_switch.get() + " | bytes length: " + byteArray.length;
                if (!TextUtils.equals(str, f85449b)) {
                    QLog.d("QFSFeedAdUiHelper", 1, str);
                    f85449b = str;
                }
                return sealEdgeComputing$ClientItemInfo;
            }
            QLog.d("QFSFeedAdUiHelper", 1, "[getClientItemInfo] current recomInfo is null.");
            return null;
        } catch (Throwable th5) {
            QLog.e("QFSFeedAdUiHelper", 1, "[getClientItemInfo] ex: ", th5);
            return null;
        }
    }

    public static void r0(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public static int s(GdtAd gdtAd) {
        float f16;
        float f17;
        float f18;
        if (gdtAd == null) {
            return 0;
        }
        int innerShowType = gdtAd.getInnerShowType();
        boolean W = W(gdtAd);
        if (innerShowType != 1) {
            if (innerShowType != 2) {
                if (innerShowType != 3) {
                    if (innerShowType != 4) {
                        if (innerShowType != 19) {
                            switch (innerShowType) {
                                case 8:
                                case 10:
                                    break;
                                case 9:
                                    if (W) {
                                        f18 = 74.0f;
                                    } else {
                                        f18 = 50.0f;
                                    }
                                    return ImmersiveUtils.dpToPx(f18);
                                default:
                                    return 0;
                            }
                        }
                    }
                }
            }
            if (W) {
                f17 = 178.0f;
            } else {
                f17 = 121.0f;
            }
            return ImmersiveUtils.dpToPx(f17);
        }
        if (W) {
            f16 = 100.0f;
        } else {
            f16 = 68.0f;
        }
        return ImmersiveUtils.dpToPx(f16);
    }

    public static int t(GdtAd gdtAd) {
        if (gdtAd == null) {
            return 0;
        }
        int innerShowType = gdtAd.getInnerShowType();
        if (!W(gdtAd) && innerShowType == 9) {
            return ImmersiveUtils.dpToPx(2.0f);
        }
        return ImmersiveUtils.dpToPx(4.0f);
    }

    public static int u(GdtAd gdtAd) {
        float f16;
        float f17;
        float f18;
        float f19;
        if (gdtAd == null) {
            return 0;
        }
        int innerShowType = gdtAd.getInnerShowType();
        boolean W = W(gdtAd);
        if (innerShowType != 1) {
            if (innerShowType != 2) {
                if (innerShowType != 3) {
                    if (innerShowType != 4 && innerShowType != 19) {
                        switch (innerShowType) {
                            case 8:
                                if (W) {
                                    f18 = 133.0f;
                                } else {
                                    f18 = 91.0f;
                                }
                                return ImmersiveUtils.dpToPx(f18);
                            case 9:
                                if (W) {
                                    f19 = 99.0f;
                                } else {
                                    f19 = 67.0f;
                                }
                                return ImmersiveUtils.dpToPx(f19);
                            case 10:
                                break;
                            default:
                                return 0;
                        }
                    }
                }
            }
            if (W) {
                f17 = 100.0f;
            } else {
                f17 = 68.0f;
            }
            return ImmersiveUtils.dpToPx(f17);
        }
        if (W) {
            f16 = 178.0f;
        } else {
            f16 = 121.0f;
        }
        return ImmersiveUtils.dpToPx(f16);
    }

    public static String v(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String N = N(feedCloudMeta$StFeed, "scrollNext");
        if (TextUtils.isEmpty(N)) {
            return "0";
        }
        return N;
    }

    public static String w(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        String N = N(feedCloudMeta$StFeed, str);
        if (!TextUtils.isEmpty(N)) {
            return "#" + N;
        }
        return "#0099FF";
    }

    public static String x(GdtAd gdtAd) {
        if (gdtAd == null) {
            return "";
        }
        return gdtAd.getInteractiveTipTxt();
    }

    public static int y(GdtAd gdtAd) {
        if (gdtAd == null) {
            return -1;
        }
        return gdtAd.getExperimentIntegerParam(122752, -1);
    }

    public static int z(GdtAd gdtAd) {
        if (gdtAd == null) {
            return -1;
        }
        return gdtAd.getExperimentIntegerParam(122753, -1);
    }
}

package com.tencent.sqshow.zootopia.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.capability.TPHdrCapability;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u001c\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0012J\u001a\u0010\u0018\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bJ\u0016\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bJ(\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010&J \u0010+\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bR\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010,R#\u00103\u001a\n /*\u0004\u0018\u00010.0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/VideoUtils;", "", "", "url", "vid", tl.h.F, "Landroid/view/View;", "view", "", "targetW", "targetH", "", "o", "Lcom/tencent/sqshow/zootopia/player/preload/e;", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "e", "f", "", DomainData.DOMAIN_NAME, "j", "", "i", "l", "b", "c", "width", "height", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "videoW", "videoH", "r", ReportConstant.COSTREPORT_PREFIX, "containerHeight", "targetView", "videoWidth", "videoHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "k", "coverW", "coverH", "p", "Ljava/lang/String;", "VIDEO_CACHE_FILE", "Lcom/tencent/superplayer/api/ISPBandwidthPredictor;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "g", "()Lcom/tencent/superplayer/api/ISPBandwidthPredictor;", "BAND_WIDTH_PREDICTOR", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class VideoUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final VideoUtils f373236a = new VideoUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String VIDEO_CACHE_FILE = BaseApplication.getContext().getExternalCacheDir() + "/superplayer/170303124";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy BAND_WIDTH_PREDICTOR;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISPBandwidthPredictor>() { // from class: com.tencent.sqshow.zootopia.utils.VideoUtils$BAND_WIDTH_PREDICTOR$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ISPBandwidthPredictor invoke() {
                return SuperPlayerFactory.createBandwidthPredictor(BaseApplication.getContext());
            }
        });
        BAND_WIDTH_PREDICTOR = lazy;
    }

    VideoUtils() {
    }

    private final ISPBandwidthPredictor g() {
        return (ISPBandwidthPredictor) BAND_WIDTH_PREDICTOR.getValue();
    }

    private final String h(String url, String vid) {
        boolean contains$default;
        int indexOf$default;
        try {
            String firstPath = Uri.parse(url).getPathSegments().get(0);
            Intrinsics.checkNotNullExpressionValue(firstPath, "firstPath");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) firstPath, (CharSequence) ".mp4", false, 2, (Object) null);
            if (contains$default) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) firstPath, ".mp4", 0, false, 6, (Object) null);
                String substring = firstPath.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring;
            }
        } catch (Exception e16) {
            QLog.d("VideoUtils", 1, "getFileIdWithTapPosition exception:" + e16);
        }
        if (!TextUtils.isEmpty(vid)) {
            QLog.d("VideoUtils", 1, "getFileIdWithTapPosition return vid" + vid);
            return vid == null ? "" : vid;
        }
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        QLog.d("VideoUtils", 1, "getFileIdWithTapPosition return url" + url);
        return url == null ? "" : url;
    }

    public final boolean b(String url, String vid) {
        String str = VIDEO_CACHE_FILE;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("/%s.mp4", Arrays.copyOf(new Object[]{h(url, vid)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return new File(str + format).exists();
    }

    public final void c() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.y
            @Override // java.lang.Runnable
            public final void run() {
                VideoUtils.d();
            }
        });
    }

    public final SuperPlayerVideoInfo e(com.tencent.sqshow.zootopia.player.preload.e record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return f(record.d(), record.g());
    }

    public final SuperPlayerVideoInfo f(String url, String vid) {
        boolean contains$default;
        boolean contains$default2;
        int i3;
        ArrayList<String> arrayListOf;
        if (!n(url, vid)) {
            return null;
        }
        String h16 = h(url, vid);
        Intrinsics.checkNotNull(url);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "flv", false, 2, (Object) null);
        if (contains$default) {
            i3 = 202;
        } else {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "rtmp", false, 2, (Object) null);
            i3 = contains$default2 ? 103 : 101;
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(new String[]{url}, i3, h16, "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(j(url));
        createVideoInfoForUrl.setUrlHostList(arrayListOf);
        return createVideoInfoForUrl;
    }

    public final long i() {
        long currentPrediction = g().getCurrentPrediction();
        long a16 = com.tencent.sqshow.zootopia.player.q.INSTANCE.a();
        QLog.d("VideoUtils", 2, "getPredictSpeed predictSpeedFromSdk :" + currentPrediction + " | predictSpeedLastDownload:" + a16);
        if (currentPrediction > 0) {
            return ((float) currentPrediction) * uq3.c.K0();
        }
        if (a16 > 0) {
            return a16;
        }
        QLog.d("VideoUtils", 2, "getPredictSpeed no consult data,return high level!");
        return uq3.c.X0("qqcircle", "qqcir_hightLevelThreshold", Integer.valueOf(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID)).intValue();
    }

    public final String j(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return Uri.parse(url).getHost();
        } catch (Exception e16) {
            QLog.e("VideoUtils", 1, "get host failed: " + url + ", error = " + e16.getMessage());
            return null;
        }
    }

    public final boolean m(int width, int height) {
        if (width >= height) {
            return true;
        }
        return false;
    }

    public final void p(View view, int coverW, int coverH) {
        if (coverH != 0 && coverW != 0 && view != null) {
            int instantScreenWidth = ScreenUtil.getInstantScreenWidth(view.getContext());
            int i3 = -1;
            if (coverW != -1 || coverH != -1) {
                if (coverW > 0) {
                    i3 = (int) ((instantScreenWidth / coverW) * coverH);
                } else if (coverH > 0) {
                    float f16 = coverH;
                    instantScreenWidth = (int) ((f16 / f16) * coverW);
                    i3 = coverH;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.width = instantScreenWidth;
                layoutParams2.height = i3;
                layoutParams2.addRule(13);
                view.setLayoutParams(layoutParams2);
                QLog.d("VideoUtils", 1, "fs_lifecycle setSize origin:" + coverW + "|" + coverH + " , target:" + instantScreenWidth + "|" + i3 + " , hashCode" + hashCode());
                return;
            }
            instantScreenWidth = -1;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams22.width = instantScreenWidth;
            layoutParams22.height = i3;
            layoutParams22.addRule(13);
            view.setLayoutParams(layoutParams22);
            QLog.d("VideoUtils", 1, "fs_lifecycle setSize origin:" + coverW + "|" + coverH + " , target:" + instantScreenWidth + "|" + i3 + " , hashCode" + hashCode());
            return;
        }
        QLog.d("VideoUtils", 1, "setSize origin size zero");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        QQVideoPlaySDKManager.clearMemory(124);
    }

    private final void o(View view, int targetW, int targetH) {
        if (view == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = targetW;
        layoutParams2.height = targetH;
        layoutParams2.addRule(13);
        view.setLayoutParams(layoutParams2);
    }

    public final boolean l() {
        try {
            String hlgModels = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_support_hlg_models", "2106118C;M2102K1C;M2011K2C;M2104K10AC;PEEM00;PEYM00;PBEM00;OCE-AN10;TAS-AN00;TAS-AL00;ANA-AN00;ELS-AN00;NAM-AL00;RTE-AL00;NTH-AN00;V2049A;V2133A;SM-G9860;LE2120;");
            Intrinsics.checkNotNullExpressionValue(hlgModels, "hlgModels");
            Object[] array = new Regex(";").split(hlgModels, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array) {
                if (Intrinsics.areEqual(DeviceInfoMonitor.getModel(), str)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.w("VideoUtils", 1, "[isHDRsupport] ", e16);
        }
        return QQVideoPlaySDKManager.isSDKReady() && TPHdrCapability.getHdrCapability(3) == 1;
    }

    public final boolean n(String url, String vid) {
        try {
            if (TextUtils.isEmpty(url)) {
                return !TextUtils.isEmpty(vid);
            }
            Uri parse = Uri.parse(url);
            return (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost()) || TextUtils.isEmpty(parse.getPath())) ? false : true;
        } catch (Exception e16) {
            QLog.d("VideoUtils", 1, e16, new Object[0]);
            return false;
        }
    }

    public final boolean k(Context context) {
        if (context == null) {
            return false;
        }
        int instantScreenWidth = ScreenUtil.getInstantScreenWidth(context);
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(context);
        if (instantScreenWidth == 0 || instantScreenHeight == 0) {
            return false;
        }
        float f16 = instantScreenWidth / instantScreenHeight;
        float intValue = uq3.c.X0("qqcircle", "qqcircle_folder_screen_mim_ratio", 71).intValue() / 100.0f;
        float f17 = 1 / intValue;
        QLog.d("VideoUtils", 1, "isFolderScreenOpenMode:" + f16 + "|wnsRatio:" + intValue + "|maxRatio" + f17 + "__disPlayWidth| disPlayHeight:" + instantScreenWidth + "|" + instantScreenHeight);
        return f16 > intValue && f16 < f17;
    }

    public final void q(int containerHeight, View targetView, int videoWidth, int videoHeight) {
        if (containerHeight != 0 && containerHeight > 0) {
            o(targetView, (int) (containerHeight * (videoWidth / videoHeight)), containerHeight);
        }
    }

    public final boolean r(int videoW, int videoH) {
        if (videoW == 0 || videoH == 0) {
            return false;
        }
        float f16 = videoH / videoW;
        float intValue = uq3.c.X0("qqcircle", "qqcircle_show_vertical_video_max_ratio", 3000).intValue() / 1000.0f;
        float intValue2 = uq3.c.X0(ASEngineConstants.MAIN_KEY_FLASH_SHOW, "qqcircle_show_vertical_video_min_ratio", 1740).intValue() / 1000.0f;
        QLog.d("VideoUtils", 1, "setSize origin size shouldFullScreen():" + videoH + "|" + videoW + "|" + f16 + "|" + intValue + "|" + intValue2);
        return f16 > intValue2 && f16 < intValue;
    }

    public final boolean s(int videoW, int videoH) {
        if (videoW == 0 || videoH == 0) {
            return false;
        }
        float f16 = videoH / videoW;
        float intValue = uq3.c.X0("qqcircle", "qqcircle_show_vertical_video_max_ratio", 3000).intValue() / 1000.0f;
        QLog.d("VideoUtils", 1, "setSize origin size shouldFullScreen():" + videoH + "|" + videoW + "|" + f16 + "|" + intValue);
        return f16 >= intValue;
    }
}

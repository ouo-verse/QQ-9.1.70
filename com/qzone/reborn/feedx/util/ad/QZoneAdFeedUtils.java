package com.qzone.reborn.feedx.util.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.gdt.GdtTimeLineComponentData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.event.ad.QZoneAdClickEvent;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ar;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdt.tangram.ad.AdArea;
import com.tencent.gdt.tangram.ad.qzone.embedded.b;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.util.j;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.HalfScreenBrowserActivity;
import com.tencent.mobileqq.ad.views.AdHalfScreenFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import cooperation.qzone.api.QZoneApiProxy;
import g6.a;
import ih.f;
import ih.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.a;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004J8\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J@\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016JH\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J \u0010 \u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010#\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J$\u0010+\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010-\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020\u0004J\u001a\u0010/\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J,\u00102\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u000200J\"\u00108\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020.J$\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004092\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00107\u001a\u00020.J\u001a\u0010;\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u000105J$\u0010?\u001a\u00020\u000e2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010<2\u0006\u0010>\u001a\u00020\bJ$\u0010@\u001a\u00020\u00042\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010<2\u0006\u0010>\u001a\u00020\bJ\u0016\u0010B\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010A\u001a\u00020.J\u0006\u0010C\u001a\u00020\u000eJ\u001c\u0010D\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010>\u001a\u0004\u0018\u00010\bJ\u0010\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010I\u001a\u0004\u0018\u00010H2\b\u0010G\u001a\u0004\u0018\u00010EJ\u0012\u0010K\u001a\u0004\u0018\u00010J2\b\u0010G\u001a\u0004\u0018\u00010EJ\u0010\u0010L\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010EJ\u0010\u0010M\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0018\u0010O\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010P\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010Q\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010R\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010S\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010T\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010U\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010V\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0010\u0010W\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u001a\u0010Z\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010Y\u001a\u0004\u0018\u00010XJ\u0010\u0010[\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\\\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0012J\u001a\u0010^\u001a\u00020]2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010Y\u001a\u0004\u0018\u00010XJ\u0014\u0010`\u001a\u00020\b*\u0004\u0018\u00010\b2\u0006\u0010_\u001a\u00020\u0004J\u0018\u0010b\u001a\u00020\u000b2\b\u0010a\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u000203J\u001a\u0010c\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010f\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u000200R\u0014\u0010i\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0017\u0010m\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bj\u0010h\u001a\u0004\bk\u0010lR'\u0010s\u001a\u0012\u0012\u0004\u0012\u00020\b0nj\b\u0012\u0004\u0012\u00020\b`o8\u0006\u00a2\u0006\f\n\u0004\b;\u0010p\u001a\u0004\bq\u0010rR'\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\b0nj\b\u0012\u0004\u0012\u00020\b`o8\u0006\u00a2\u0006\f\n\u0004\b8\u0010p\u001a\u0004\bt\u0010rR'\u0010w\u001a\u0012\u0012\u0004\u0012\u00020\b0nj\b\u0012\u0004\u0012\u00020\b`o8\u0006\u00a2\u0006\f\n\u0004\b2\u0010p\u001a\u0004\bv\u0010rR'\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\b0nj\b\u0012\u0004\u0012\u00020\b`o8\u0006\u00a2\u0006\f\n\u0004\bT\u0010p\u001a\u0004\bx\u0010rR3\u0010\u007f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0zj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`{8\u0006\u00a2\u0006\f\n\u0004\bV\u0010|\u001a\u0004\b}\u0010~R5\u0010\u0081\u0001\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002000zj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000200`{8\u0006\u00a2\u0006\r\n\u0004\bS\u0010|\u001a\u0005\b\u0080\u0001\u0010~\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/qzone/reborn/feedx/util/ad/QZoneAdFeedUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/drawable/Drawable;", "image", "", "e0", "path", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "areaId", "", "X", "Landroid/view/View;", "view", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "Lcom/qzone/proxy/feedcomponent/ui/FeedElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "listener", "G", "position", "H", WadlProxyConsts.SCENE_ID, "E", "currentData", "", "datas", "d0", "feedData", "L", "a0", "innerAdShowType", "T", "O", ExifInterface.LATITUDE_SOUTH, "P", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "visiblePercent", "N", "", "p", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "f", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup$LayoutParams;", "params", "ratio", "e", "Landroid/util/Pair;", DomainData.DOMAIN_NAME, "d", "", "eventMap", "key", "I", "r", "showRate", "J", "U", "o", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "c0", "qzoneActivity", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$Activity;", "y", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Y", "Z", "Lcom/qzone/proxy/feedcomponent/model/gdt/GdtTimeLineComponentData;", "B", "W", "V", "k", "i", "g", "j", h.F, "l", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "M", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", ReportConstant.COSTREPORT_PREFIX, "size", BdhLogUtil.LogTag.Tag_Conn, "url", "b0", "g0", "traceId", "progress", "f0", "b", "Ljava/lang/String;", "TAG", "c", "getAD_PHOTO_SAVE_PATH", "()Ljava/lang/String;", "AD_PHOTO_SAVE_PATH", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "t", "()Ljava/util/HashSet;", "mExposedAdCache", "u", "mExposedRewardAdCache", HippyTKDListViewAdapter.X, "mRewardAdHasReceived", "v", "mExposedTianshuAdCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "w", "()Ljava/util/HashMap;", "mLeftTextVisibleMap", "getMVideoCurrentPosition", "mVideoCurrentPosition", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdFeedUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneAdFeedUtils f55717a = new QZoneAdFeedUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZoneAdFeedUtils";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String AD_PHOTO_SAVE_PATH = AppConstants.SDCARD_FILE_SAVE_PATH + "Ad/Photo/";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> mExposedAdCache = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> mExposedRewardAdCache = new HashSet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> mRewardAdHasReceived = new HashSet<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> mExposedTianshuAdCache = new HashSet<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Boolean> mLeftTextVisibleMap = new HashMap<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Long> mVideoCurrentPosition = new HashMap<>();

    QZoneAdFeedUtils() {
    }

    @JvmStatic
    public static final int A(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(activity, MobileQQ.sMobileQQ.peekAppRuntime());
        int c16 = az.e(activity) ? az.c(activity) : 0;
        int d16 = needShowQzoneFrame ? ar.d(54.0f) : 0;
        QLog.i(TAG, 1, "getScreenHeightWithoutBottomBar navigationBarHeight: " + c16 + ", mainTab: " + d16);
        return (a.f426446a.p(activity) - d16) - c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(BusinessFeedData data, int i3, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(data, "$data");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "onExposure");
        }
        AdArea d16 = GdtFeedUtilForQZone.d(i3, 0);
        CellFeedCommInfo feedCommInfo = data.getFeedCommInfo();
        b.s(data, d16, feedCommInfo != null && feedCommInfo.isInstalled, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e0(Drawable image) {
        Bitmap f16 = ar.f(image);
        String str = AD_PHOTO_SAVE_PATH + System.currentTimeMillis() + ".jpg";
        BitmapUtils.saveBitmap(f16, str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Activity activity, String path) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, path);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, path);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, path);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, path);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(activity, ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentActivityClass());
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        activity.startActivityForResult(intent, 21);
    }

    public final List<GdtTimeLineComponentData> B(BusinessFeedData feedData) {
        LinkedList linkedList = new LinkedList();
        String valueFromCurrencyPassField = feedData != null ? feedData.getValueFromCurrencyPassField("timeline_widget") : null;
        if (TextUtils.isEmpty(valueFromCurrencyPassField)) {
            return linkedList;
        }
        JSONArray optJSONArray = AdJSONUtil.optJSONArray(AdJSONUtil.newJSONObject(valueFromCurrencyPassField), "component_list");
        if (AdJSONArrayUtil.isEmpty(optJSONArray)) {
            return linkedList;
        }
        try {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    GdtTimeLineComponentData build = GdtTimeLineComponentData.build(AdJSONUtil.newJSONObject(optString));
                    Intrinsics.checkNotNullExpressionValue(build, "build(AdJSONUtil.newJSONObject(str))");
                    linkedList.add(build);
                }
            }
            return linkedList;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getTimeLineAdComponents] error", th5);
            return linkedList;
        }
    }

    public final int D(BusinessFeedData feedData, GdtAd ad5) {
        if (QZoneAdFeedDataExtKt.isTianshuAd(feedData)) {
            return ar.d(13.0f);
        }
        if (k(feedData) || l(feedData)) {
            return 0;
        }
        return ar.d(13.0f);
    }

    public final void E(int sceneId, Activity activity, View view, final BusinessFeedData data, FeedElement element, int areaId, final int position, AdFeedbackDialogFragment.Listener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(element, "element");
        a.b bVar = new a.b();
        bVar.f401411d = areaId;
        bVar.f401410c = sceneId;
        bVar.f401408a = new WeakReference<>(activity);
        bVar.f401413f = new WeakReference<>(listener);
        bVar.f401412e = element;
        bVar.f401414g = new WeakReference<>(view);
        bVar.f401409b = data;
        String traceId = QZoneAdFeedDataExtKt.getTraceId(data);
        Long l3 = mVideoCurrentPosition.get(traceId);
        if (l3 != null) {
            bVar.f401415h = l3.longValue();
        }
        String a16 = j.f109555a.a(traceId, X(areaId));
        bVar.f401416i = a16;
        g6.a.g(bVar);
        f.f407629a.b(data, a16, position);
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(data));
        AdExposureChecker.onClick(view.getContext(), gdtAd, new WeakReference(new AdExposureChecker.ExposureCallback() { // from class: ih.a
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                QZoneAdFeedUtils.F(BusinessFeedData.this, position, weakReference);
            }
        }));
        SimpleEventBus.getInstance().dispatchEvent(new QZoneAdClickEvent(gdtAd, areaId));
    }

    public final void G(Activity activity, View view, BusinessFeedData data, FeedElement element, int areaId, AdFeedbackDialogFragment.Listener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(element, "element");
        E(2, activity, view, data, element, areaId, 0, listener);
    }

    public final void H(Activity activity, View view, BusinessFeedData data, FeedElement element, int areaId, int position, AdFeedbackDialogFragment.Listener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(element, "element");
        E(0, activity, view, data, element, areaId, position, listener);
    }

    public final boolean I(Map<String, Integer> eventMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (eventMap != null) {
            return eventMap.containsKey(key);
        }
        return false;
    }

    public final boolean J(View view, float showRate) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        int i16 = rect.bottom;
        if (i16 > 0) {
            if (i16 > DisplayUtil.getScreenHeight()) {
                rect.bottom = DisplayUtil.getScreenHeight();
            }
            i3 = rect.bottom - rect.top;
        } else {
            i3 = 0;
        }
        float f16 = i3 / height;
        QLog.d(TAG, 1, "inPlayAreaVertical  | rate = " + f16 + " | showRate = " + showRate);
        return f16 >= showRate;
    }

    public final boolean L(BusinessFeedData feedData) {
        if (QZoneAdFeedDataExtKt.isTianshuAd(feedData)) {
            QZoneAdTianshuFeedData tianshuData = feedData != null ? QZoneAdFeedDataExtKt.getTianshuData(feedData) : null;
            return Intrinsics.areEqual(tianshuData != null ? tianshuData.getAdType() : null, "1");
        }
        return O(feedData != null ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(feedData) : 0);
    }

    public final boolean M(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        return (feedData.isAdFeeds() || feedData.isGDTAdvFeed()) && !QZoneAdFeedDataExtKt.isNativeAd(feedData);
    }

    public final boolean N(View view, Activity activity, int visiblePercent) {
        return p(view, activity) >= ((float) visiblePercent);
    }

    public final boolean O(int innerAdShowType) {
        if (innerAdShowType != 3 && innerAdShowType != 31) {
            return false;
        }
        return true;
    }

    public final boolean P(int innerAdShowType) {
        if (innerAdShowType == 1 || innerAdShowType == 2) {
            return true;
        }
        return false;
    }

    public final boolean Q(int innerAdShowType) {
        if (innerAdShowType == 10) {
            return true;
        }
        return false;
    }

    public final boolean R(int innerAdShowType) {
        if (innerAdShowType != 4 && innerAdShowType != 2) {
            return false;
        }
        return true;
    }

    public final boolean S(int innerAdShowType) {
        if (innerAdShowType == 4) {
            return true;
        }
        return false;
    }

    public final boolean T(int innerAdShowType) {
        return O(innerAdShowType) || S(innerAdShowType);
    }

    public final boolean U() {
        return Foreground.isCurrentProcessForeground();
    }

    public final boolean W(Activity activity) {
        boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(activity, MobileQQ.sMobileQQ.peekAppRuntime());
        return QQTheme.isNowThemeIsNight() || !(needShowQzoneFrame || QZoneCoverUtils.getSuperCoverTrans(null) == 255) || (needShowQzoneFrame && QQTheme.isVasTheme());
    }

    public final boolean X(int areaId) {
        if (areaId != 80 && areaId != 2001) {
            return true;
        }
        return false;
    }

    public final boolean a0(BusinessFeedData feedData) {
        if (QZoneAdFeedDataExtKt.isTianshuAd(feedData)) {
            QZoneAdTianshuFeedData tianshuData = feedData != null ? QZoneAdFeedDataExtKt.getTianshuData(feedData) : null;
            return Intrinsics.areEqual(tianshuData != null ? tianshuData.getAdType() : null, "3");
        }
        return S(feedData != null ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(feedData) : 0);
    }

    public final void b0(String url, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (url == null || url.length() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("halfFragmentClass", AdHalfScreenFragment.class);
        bundle.putInt("webViewBgRes", R.drawable.jsk);
        bundle.putFloat("webViewHeightRatio", 0.5f);
        bundle.putInt("backgroundColorId", R.color.by);
        bundle.putBoolean("isTransparentTitle", true);
        Intent intent = new Intent(context, (Class<?>) HalfScreenBrowserActivity.class);
        String j3 = com.tencent.mobileqq.webview.util.f.f314875a.j(url, 0.5f);
        intent.putExtra("url", j3);
        intent.setData(Uri.parse(j3));
        Integer num = context instanceof Activity ? null : 268435456;
        if (num != null) {
            num.intValue();
            intent.setFlags(num.intValue());
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final vac_adv_get.QzoneActivity c0(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CellRecommAction recommAction = data.getRecommAction();
        String str = recommAction != null ? recommAction.currency_pass_field : null;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new vac_adv_get.QzoneActivity().mergeFrom(com.qzone.proxy.feedcomponent.manager.a.a(data.getRecommAction().currency_pass_field));
        } catch (Exception unused) {
            return null;
        }
    }

    public final void f0(String traceId, long progress) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        HashMap<String, Long> hashMap = mVideoCurrentPosition;
        if (hashMap.size() >= 200) {
            hashMap.clear();
        }
        hashMap.put(traceId, Long.valueOf(progress));
    }

    public final boolean g(BusinessFeedData feedData) {
        return (ih.j.l(feedData) && ih.j.m(feedData)) ? false : true;
    }

    public final boolean j(BusinessFeedData feedData) {
        return k(feedData) && !l(feedData);
    }

    public final boolean k(BusinessFeedData feedData) {
        return QZoneAdFeedDataExtKt.isNativeAd(feedData) && !QZoneAdStyleManager.f55731a.a(4L, feedData);
    }

    public final boolean l(BusinessFeedData feedData) {
        if (!QZoneAdFeedDataExtKt.isHitAdOuterLayerDownload(feedData)) {
            return false;
        }
        AdAppDownloadButtonController.Params params = new AdAppDownloadButtonController.Params();
        params.clickParams = GdtHandler.toParams(s(Foreground.getTopActivity(), GdtFeedUtilForQZone.E(feedData)));
        return (!new AdAppDownloadButtonController(params).isValid() || ih.j.k(feedData) || ih.j.l(feedData) || h(feedData)) ? false : true;
    }

    public final int q(BusinessFeedData feedData) {
        if (k(feedData)) {
            return 0;
        }
        return ar.d(13.0f);
    }

    public final int r(Map<String, Integer> eventMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (eventMap == null) {
            return 0;
        }
        try {
            Integer num = eventMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getEventMapValue key:" + key + " error:", th5);
            return 0;
        }
    }

    public final GdtHandler.Params s(Activity activity, GdtAd ad5) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.activity = new WeakReference<>(activity);
        params.f108486ad = ad5;
        params.sceneID = 0;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        return params;
    }

    public final HashSet<String> t() {
        return mExposedAdCache;
    }

    public final HashSet<String> u() {
        return mExposedRewardAdCache;
    }

    public final HashSet<String> v() {
        return mExposedTianshuAdCache;
    }

    public final HashMap<String, Boolean> w() {
        return mLeftTextVisibleMap;
    }

    public final HashSet<String> x() {
        return mRewardAdHasReceived;
    }

    public final boolean K(BusinessFeedData feedData, View view, Activity activity) {
        if (feedData != null) {
            return f55717a.N(view, activity, QZoneAdFeedDataExtKt.getShakeAdVisiblePercent(feedData));
        }
        return false;
    }

    public final boolean V(BusinessFeedData feedData) {
        Integer num;
        if (feedData != null) {
            num = Integer.valueOf(feedData.isGDTAdvFeed() ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(feedData) : Integer.MIN_VALUE);
        } else {
            num = null;
        }
        return ((num == null || num.intValue() != 1) && ((num == null || num.intValue() != 3) && !((num != null && num.intValue() == 31) || k(feedData) || QZoneAdFeedDataExtKt.isMDPAStyleB(feedData) || l(feedData)))) || !QZoneAdStyleManager.f55731a.a(1L, feedData);
    }

    public final boolean Z(BusinessFeedData feedData) {
        return feedData != null && feedData.isGDTAdvFeed();
    }

    public final void d0(BusinessFeedData currentData, List<? extends BusinessFeedData> datas) {
        BusinessFeedData businessFeedData;
        if (datas == null || datas.isEmpty()) {
            return;
        }
        Iterator<? extends BusinessFeedData> it = datas.iterator();
        boolean z16 = false;
        while (true) {
            if (!it.hasNext()) {
                businessFeedData = null;
                break;
            }
            businessFeedData = it.next();
            if (Intrinsics.areEqual("0", GdtFeedUtilForQZone.g(businessFeedData))) {
                if (businessFeedData == currentData && !z16) {
                    z16 = true;
                } else if (businessFeedData.isGDTAdvFeed() && z16) {
                    break;
                }
            }
        }
        if (businessFeedData != null) {
            GdtFeedUtilForQZone.e(businessFeedData);
            GdtFeedUtilForQZone.C(businessFeedData);
        }
    }

    public final Pair<Integer, Integer> n(Context context, float ratio) {
        int l3;
        float f16;
        float f17;
        if (context == null) {
            return new Pair<>(0, 0);
        }
        if (1 / ratio > 1.1d) {
            l3 = (int) (pl.a.f426446a.l(context) * 0.58f);
            f16 = l3;
            f17 = 1.3333334f;
        } else {
            l3 = pl.a.f426446a.l(context);
            f16 = l3;
            f17 = 0.5625f;
        }
        return new Pair<>(Integer.valueOf(l3), Integer.valueOf((int) (f16 * f17)));
    }

    public final vac_adv_get.Activity y(vac_adv_get.QzoneActivity qzoneActivity) {
        if (qzoneActivity == null || qzoneActivity.get().activities.isEmpty()) {
            return null;
        }
        return qzoneActivity.get().activities.get(0).get();
    }

    public final qq_ad_get.QQAdGetRsp.AdInfo z(vac_adv_get.QzoneActivity qzoneActivity) {
        if (qzoneActivity == null || qzoneActivity.get().adv.vac_adv_msgs.isEmpty()) {
            return null;
        }
        return qzoneActivity.get().adv.vac_adv_msgs.get(0).get().adv_rsp.get();
    }

    public final boolean Y(vac_adv_get.QzoneActivity qzoneActivity) {
        return qzoneActivity != null && qzoneActivity.click_mode.get() == 1;
    }

    public final boolean i(BusinessFeedData feedData) {
        String str;
        if (feedData == null || !k(feedData)) {
            return false;
        }
        ArrayList<String> labelsContentFromCurrencyPassFieldSafely = QZoneAdFeedDataExtKt.getLabelsContentFromCurrencyPassFieldSafely(feedData);
        if (labelsContentFromCurrencyPassFieldSafely.isEmpty()) {
            labelsContentFromCurrencyPassFieldSafely = QZoneAdFeedDataExtKt.getLabelsContentFromExtendInfoSafely(feedData);
        }
        boolean z16 = !labelsContentFromCurrencyPassFieldSafely.isEmpty();
        CellRecommAction recommAction = feedData.getRecommAction();
        return (z16 || (recommAction != null && (str = recommAction.remark) != null && str.length() > 0)) ? false : true;
    }

    public final boolean h(BusinessFeedData feedData) {
        if (feedData == null) {
            return false;
        }
        List<QZoneAdFeedData.GestureStageInfo> c16 = i.f407634a.c(feedData);
        return !(c16 == null || c16.isEmpty());
    }

    public final String o(BusinessFeedData data, String key) {
        if (!(key == null || key.length() == 0) && data != null && data.getRecommAction() != null) {
            String str = data.getRecommAction().currency_pass_field;
            if (!(str == null || str.length() == 0)) {
                try {
                    JSONObject jSONObject = new JSONObject(data.getRecommAction().currency_pass_field);
                    if (jSONObject.has(key)) {
                        return jSONObject.optString(key, null);
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "getAdCurrencyStringField failed, exception is " + e16);
                }
            }
        }
        return null;
    }

    public final String C(String str, int i3) {
        if (str != null && i3 >= 0) {
            if (str.length() <= i3) {
                return str;
            }
            String substring = str.substring(0, i3 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return "";
    }

    public final void d(Context context, ViewGroup.LayoutParams params) {
        if (context == null || params == null) {
            return;
        }
        int l3 = (int) (pl.a.f426446a.l(context) * 0.58f * 1.3333334f);
        params.width = l3;
        params.height = l3;
    }

    public final void e(Context context, ViewGroup.LayoutParams params, float ratio) {
        if (context == null || params == null) {
            return;
        }
        Pair<Integer, Integer> n3 = n(context, ratio);
        Object obj = n3.first;
        Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
        params.width = ((Number) obj).intValue();
        Object obj2 = n3.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "pair.second");
        params.height = ((Number) obj2).intValue();
    }

    public final void g0(BusinessFeedData feedData, final Activity activity) {
        String adPictureUrl;
        if (feedData == null || activity == null) {
            return;
        }
        if (T(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(feedData))) {
            adPictureUrl = feedData.getVideoInfo().coverUrl.url;
            Intrinsics.checkNotNullExpressionValue(adPictureUrl, "feedData.videoInfo.coverUrl.url");
        } else {
            adPictureUrl = QZoneAdFeedDataExtKt.getAdPictureUrl(feedData);
            if (adPictureUrl == null) {
                adPictureUrl = "";
            }
        }
        final Drawable loadImage = ImageLoader.getInstance().loadImage(adPictureUrl, new ImageLoader.ImageLoadListener() { // from class: com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils$shareAdImageToQQ$drawable$1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String url, ImageLoader.Options options) {
                QQToast.makeText(activity, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 0).show();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String url, final Drawable image, ImageLoader.Options options) {
                final Activity activity2 = activity;
                ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils$shareAdImageToQQ$drawable$1$onImageLoaded$1
                    @Override // java.lang.Runnable
                    public void run() {
                        String e06;
                        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                        e06 = qZoneAdFeedUtils.e0(image);
                        qZoneAdFeedUtils.m(activity2, e06);
                    }
                }, 16, null, false);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String url, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String url, float progress, ImageLoader.Options options) {
            }
        }, new ImageLoader.Options());
        if (loadImage != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils$shareAdImageToQQ$1$1
                @Override // java.lang.Runnable
                public void run() {
                    String e06;
                    QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                    e06 = qZoneAdFeedUtils.e0(loadImage);
                    qZoneAdFeedUtils.m(activity, e06);
                }
            }, 16, null, false);
        }
    }

    public final float p(View view, Activity activity) {
        int i3;
        int i16;
        int coerceAtMost;
        int coerceAtLeast;
        if (view != null && activity != null) {
            int A = A(activity);
            int e16 = QZoneFeedxViewUtils.e(activity);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect) && (i3 = rect.top) < A && (i16 = rect.bottom) > 0) {
                QLog.i(TAG, 1, "top:" + i3 + ", bottom:" + i16 + ",screenHeight:" + A + ",titlebar:" + e16);
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(A, rect.bottom);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(rect.top, e16);
                return ((coerceAtMost - coerceAtLeast) / view.getHeight()) * 100;
            }
        }
        return 0.0f;
    }

    public final boolean f(BusinessFeedData feedData, View view, Activity activity, long showTime) {
        int i3;
        if (view == null || activity == null || feedData == null) {
            return true;
        }
        String str = TAG;
        QLog.i(str, 1, "canInterShake percent: " + QZoneAdFeedDataExtKt.shakeAdScreenBottomPercent(feedData) + " stayTime " + QZoneAdFeedDataExtKt.shakeAdScreenShowTime(feedData) + "showTime " + showTime);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = iArr[1] + view.getHeight();
        if (QZoneAdFeedDataExtKt.shakeAdScreenBottomPercent(feedData) == 0) {
            return height > A(activity) && showTime < ((long) QZoneAdFeedDataExtKt.shakeAdScreenShowTime(feedData));
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int p16 = pl.a.f426446a.p(activity);
        if (!globalVisibleRect || rect.top >= p16 || (i3 = rect.bottom) <= 0) {
            return true;
        }
        QLog.i(str, 1, "canInterShake bottom:" + i3 + ",screenHeight:" + p16 + "time " + showTime);
        return ((float) (p16 - rect.bottom)) / ((float) p16) < ((float) QZoneAdFeedDataExtKt.shakeAdScreenBottomPercent(feedData)) / 100.0f && showTime < ((long) QZoneAdFeedDataExtKt.shakeAdScreenShowTime(feedData));
    }
}

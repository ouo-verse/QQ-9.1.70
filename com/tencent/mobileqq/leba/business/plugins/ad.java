package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.dz;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.state.data.SquareJSConst;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010h\u001a\u00020g\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u000fJT\u0010(\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00072\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!2\b\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J2\u0010)\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020\u0004J\u000f\u0010*\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010,\u001a\u00020\u0002JW\u00102\u001a\u00020\u00022\"\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`.2\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002000-j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000200`.H\u0000\u00a2\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010=\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u001cR\u0018\u0010A\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00107R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010CR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010OR\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001cR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010OR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010OR\u0018\u0010U\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00107R\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010OR\u0016\u0010Y\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010\u001cR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010[R\u0016\u0010]\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010OR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010_R\u0016\u0010a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010OR\u0014\u0010c\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010bR\u0016\u0010f\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010e\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/ad;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", tl.h.F, "p", "", "rightMargin", "H", "Landroid/content/Context;", "context", UserInfo.SEX_FEMALE, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "i", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "g", "w", "v", "t", "u", "I", "k", WidgetCacheConstellationData.NUM, "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "uinHeadMap", "recommendRedDotWording", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isNewUser", "showRecommendRedDot", "D", "G", BdhLogUtil.LogTag.Tag_Conn, "()V", "B", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "", "byteAttrs", "f", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", DomainData.DOMAIN_NAME, "(Landroid/content/Context;)V", "a", "Ljava/lang/String;", "mQQCircleRedDotReportExt", "b", "mTabTipWording", "c", "[B", "mQQCircleRedDotTransInfo", "d", "mQQCircleEntranceTargetTabType", "e", "mQQCircleRedDotJumpUrl", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mQQCircleRedDot", "mQQCircleRedDotTextView", "mQQCirclePassiveRedDot", "mQQCircleNewUser", "Landroid/widget/ImageSwitcher;", "Landroid/widget/ImageSwitcher;", "mQQCircleSubIconTwo", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mQQCircleIconShadow", "mQQCircleSubIcon", "Z", "mQQCircleShouldReport", "mQQCircleRedNum", "o", "mQQCircleShowActiveRedDot", "mQQCircleShowRecommendRedDot", "mQQCircleRecommendRedDotWord", "r", "mQQCircleShowPymkRedDot", ReportConstant.COSTREPORT_PREFIX, "mQQCircleRedUinListSize", "Lcom/tencent/mobileqq/activity/dz;", "Lcom/tencent/mobileqq/activity/dz;", "mLebaQQCircleFacePlayHelper", "mIsNewUser", "Lqqcircle/QQCircleCounter$RedPointInfo;", "Lqqcircle/QQCircleCounter$RedPointInfo;", "mRedPointInfo", "mIsForeground", "Landroid/view/View;", "root", "Lcom/tencent/mobileqq/avatar/observer/a;", "Lcom/tencent/mobileqq/avatar/observer/a;", "avatarObserver", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "<init>", "(Landroid/view/ViewGroup;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mQQCircleRedDotReportExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mTabTipWording;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] mQQCircleRedDotTransInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mQQCircleEntranceTargetTabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mQQCircleRedDotJumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQQCircleRedDot;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQQCircleRedDotTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQQCirclePassiveRedDot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQQCircleNewUser;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageSwitcher mQQCircleSubIconTwo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mQQCircleIconShadow;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageSwitcher mQQCircleSubIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mQQCircleShouldReport;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private volatile int mQQCircleRedNum;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mQQCircleShowActiveRedDot;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mQQCircleShowRecommendRedDot;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile String mQQCircleRecommendRedDotWord;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean mQQCircleShowPymkRedDot;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private volatile int mQQCircleRedUinListSize;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dz mLebaQQCircleFacePlayHelper;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean mIsNewUser;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQCircleCounter$RedPointInfo mRedPointInfo;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForeground;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.avatar.observer.a avatarObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/ad$a;", "", "", "REPORT_QQCIRCLE_RED_DOT_ACTION_LEBA_ENTRY", "I", "REPORT_QQCIRCLE_RED_DOT_SUB_ACTION_CLICK", "REPORT_QQCIRCLE_RED_DOT_SUB_ACTION_EXPOSE", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_ACTIVE", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_ACTIVE_AND_NUM", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_IDLE", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NEW", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NONE", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_NUM", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_PYMK", "REPORT_QQCIRCLE_RED_DOT_THRD_ACTION_RECOMMEND", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.ad$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/ad$b", "Lcom/tencent/mobileqq/avatar/observer/a;", "", "isSuccess", "", "uin", "", "onUpdateCustomHead", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ad.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean isSuccess, @NotNull String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (isSuccess && !TextUtils.isEmpty(uin)) {
                ad.this.I();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ad(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
            return;
        }
        this.mQQCircleEntranceTargetTabType = -1;
        this.mQQCircleShouldReport = true;
        this.mRedPointInfo = new QQCircleCounter$RedPointInfo();
        this.avatarObserver = new b();
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.gxi, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026dtouch, container, false)");
        this.root = inflate;
        q();
    }

    private final void A() {
        Map<String, Object> dtElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(dtElementParams, "dtElementParams");
        dtElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        dtElementParams.put("xsj_action_type", "imp");
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB);
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, i());
        String str = this.mQQCircleRedDotReportExt;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str);
        String str3 = this.mTabTipWording;
        if (str3 != null) {
            str2 = str3;
        }
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str2);
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, m());
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, j());
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, dtElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(boolean z16, ad this$0, int i3, QBaseActivity activity, String str, List list, boolean z17, Map uinHeadMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(uinHeadMap, "$uinHeadMap");
        if (z16) {
            TextView textView = this$0.mQQCircleNewUser;
            if (textView != null && textView != null) {
                textView.setVisibility(0);
            }
            com.tencent.widget.d.b(this$0.mQQCircleNewUser, 2, 0, 0);
            TextView textView2 = this$0.mQQCirclePassiveRedDot;
            if (textView2 != null && textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this$0.mQQCircleRedDotTextView;
            if (textView3 != null && textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this$0.mQQCircleRedDot;
            if (textView4 != null && textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            TextView textView5 = this$0.mQQCircleNewUser;
            if (textView5 != null && textView5 != null) {
                textView5.setVisibility(8);
            }
            if (i3 > 0) {
                TextView textView6 = this$0.mQQCirclePassiveRedDot;
                if (textView6 != null) {
                    Intrinsics.checkNotNull(textView6);
                    textView6.setVisibility(0);
                }
                com.tencent.widget.d.b(this$0.mQQCirclePassiveRedDot, 9, i3, 0);
                com.tencent.widget.d.e(activity, this$0.mQQCirclePassiveRedDot, 9, false);
            } else {
                TextView textView7 = this$0.mQQCirclePassiveRedDot;
                if (textView7 != null) {
                    Intrinsics.checkNotNull(textView7);
                    textView7.setVisibility(8);
                }
            }
            TextView textView8 = this$0.mQQCircleRedDotTextView;
            if (textView8 != null) {
                Intrinsics.checkNotNull(textView8);
                textView8.setVisibility(8);
            }
            try {
                this$0.G(str, activity, list, z17);
                ArrayList<String> arrayList = new ArrayList<>();
                if (list != null) {
                    arrayList.addAll(list);
                }
                if (this$0.mQQCircleSubIcon != null && this$0.mLebaQQCircleFacePlayHelper != null) {
                    if (this$0.p()) {
                        dz dzVar = this$0.mLebaQQCircleFacePlayHelper;
                        if (dzVar != null) {
                            dzVar.x(true);
                        }
                        dz dzVar2 = this$0.mLebaQQCircleFacePlayHelper;
                        if (dzVar2 != null) {
                            dzVar2.A(uinHeadMap);
                        }
                    } else {
                        dz dzVar3 = this$0.mLebaQQCircleFacePlayHelper;
                        if (dzVar3 != null) {
                            dzVar3.x(false);
                        }
                        dz dzVar4 = this$0.mLebaQQCircleFacePlayHelper;
                        if (dzVar4 != null) {
                            dzVar4.z(arrayList);
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("QCircleEeveeRedPoint_LebaPluginQCircleRedViewHolder", 1, "updateQQCircleRedFlag" + e16);
            }
        }
        if (this$0.mQQCircleShouldReport && this$0.mIsForeground) {
            this$0.B();
        }
    }

    private final void F(Context context) {
        if (this.mQQCircleRedDot == null) {
            return;
        }
        C();
        TextView textView = this.mQQCircleRedDot;
        Intrinsics.checkNotNull(textView);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.f158889rm) + ViewUtils.dpToPx(5.0f);
            marginLayoutParams.rightMargin = 0;
            TextView textView2 = this.mQQCircleRedDot;
            Intrinsics.checkNotNull(textView2);
            textView2.setLayoutParams(layoutParams);
        }
    }

    private final void H(int rightMargin) {
        TextView textView = this.mQQCircleRedDotTextView;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNull(textView);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.rightMargin = rightMargin;
        TextView textView2 = this.mQQCircleRedDotTextView;
        Intrinsics.checkNotNull(textView2);
        textView2.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void J(ad this$0, QBaseActivity qBaseActivity) {
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo;
        long j3;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        int i17;
        boolean z18;
        byte[] bArr;
        int size;
        boolean z19;
        String str3;
        boolean z26;
        List<QQCircleCounterMsg$RedDisplayInfo> list;
        String str4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        this$0.mQQCircleRedDotJumpUrl = null;
        QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (!QCircleHostUtil.isRedDotSame(outerEntranceRedPointInfoByAppid, this$0.mRedPointInfo)) {
            this$0.mQQCircleShouldReport = true;
        }
        if (outerEntranceRedPointInfoByAppid == null) {
            qQCircleCounter$RedPointInfo = new QQCircleCounter$RedPointInfo();
        } else {
            qQCircleCounter$RedPointInfo = outerEntranceRedPointInfoByAppid;
        }
        this$0.mRedPointInfo = qQCircleCounter$RedPointInfo;
        if (outerEntranceRedPointInfoByAppid != null) {
            j3 = outerEntranceRedPointInfoByAppid.outLayerInfo.combineRedTypes.get();
            this$0.mTabTipWording = outerEntranceRedPointInfoByAppid.allPushInfo.tabTipWording.get();
            i16 = outerEntranceRedPointInfoByAppid.redTotalNum.get();
            if (i16 > 0) {
                i17 = i16 + 0;
            } else {
                i17 = 0;
            }
            z18 = QCircleHostUtil.checkOperateMaskEnabled(j3, 1);
            if (this$0.p()) {
                QLog.d("LebaPluginQCircleRedViewHolder", 2, "updateRedFlag hit word exp");
                list = outerEntranceRedPointInfoByAppid.allPushInfo.styleBottomTab.button.icons.get();
                Intrinsics.checkNotNullExpressionValue(list, "redPointInfo.allPushInfo\u2026tomTab.button.icons.get()");
            } else {
                list = outerEntranceRedPointInfoByAppid.rptRedInfo.get();
                Intrinsics.checkNotNullExpressionValue(list, "redPointInfo.rptRedInfo.get()");
            }
            if (list.size() > 0) {
                Iterator<QQCircleCounterMsg$RedDisplayInfo> it = list.iterator();
                while (it.hasNext()) {
                    String str5 = it.next().headImg.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "displayInfo.headImg.get()");
                    arrayList.add(str5);
                }
            }
            if (!list.isEmpty()) {
                for (QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo : list) {
                    String str6 = qQCircleCounterMsg$RedDisplayInfo.headImg.get();
                    Intrinsics.checkNotNullExpressionValue(str6, "displayInfo.headImg.get()");
                    String str7 = qQCircleCounterMsg$RedDisplayInfo.avatarURL.get();
                    Intrinsics.checkNotNullExpressionValue(str7, "displayInfo.avatarURL.get()");
                    hashMap.put(str6, str7);
                }
            }
            if (!TextUtils.isEmpty(outerEntranceRedPointInfoByAppid.wording.get())) {
                str4 = outerEntranceRedPointInfoByAppid.wording.get();
            } else {
                str4 = null;
            }
            z16 = QCircleHostUtil.checkOperateMaskEnabled(j3, 6);
            z17 = QCircleHostUtil.checkOperateMaskEnabled(j3, 3);
            if (uq3.c.o0()) {
                this$0.mQQCircleRedDotJumpUrl = outerEntranceRedPointInfoByAppid.redJumpInfo.jumpLink.get();
            }
            String str8 = outerEntranceRedPointInfoByAppid.extend.get();
            if (i17 <= 0 && !z18 && !z17 && !z16) {
                str2 = str4;
                str = str8;
                i3 = -1;
            } else {
                ByteStringMicro byteStringMicro = outerEntranceRedPointInfoByAppid.transInfo.get();
                if (byteStringMicro != null && byteStringMicro.size() > 0) {
                    bArr = byteStringMicro.toByteArray();
                } else {
                    bArr = null;
                }
                str2 = str4;
                str = str8;
                i3 = outerEntranceRedPointInfoByAppid.tabType.get();
                this$0.mQQCircleRedDotReportExt = str;
                this$0.mQQCircleRedDotTransInfo = bArr;
                this$0.mQQCircleEntranceTargetTabType = i3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[updateQQCircleRedFlag]");
                sb5.append(", redDotCombineTypes = ");
                sb5.append(j3);
                sb5.append(", pushUnReadNum = ");
                sb5.append(i16);
                sb5.append(", showActiveRedDot = ");
                sb5.append(z18);
                sb5.append(", showPYMKRedDot = ");
                sb5.append(z16);
                sb5.append(", uinList = ");
                sb5.append(arrayList);
                sb5.append(", showRecommendRedDot = ");
                sb5.append(z17);
                sb5.append(", recommendRedDotWording = ");
                sb5.append(str2);
                sb5.append(", entranceTargetTabType = ");
                sb5.append(i3);
                sb5.append(", redDotReportExt = ");
                sb5.append(str);
                QLog.d("QCircleEeveeRedPoint_LebaPluginQCircleRedViewHolder", 2, sb5);
                size = arrayList.size();
                if (this$0.mQQCircleRedNum != i17) {
                    this$0.mQQCircleRedNum = i17;
                }
                if (this$0.mQQCircleShowActiveRedDot != z18) {
                    this$0.mQQCircleShowActiveRedDot = z18;
                }
                if (this$0.mQQCircleRedUinListSize != size) {
                    this$0.mQQCircleRedUinListSize = size;
                }
                if (this$0.mQQCircleShowPymkRedDot != z16) {
                    this$0.mQQCircleShowPymkRedDot = z16;
                }
                if (this$0.mQQCircleShowRecommendRedDot != z17) {
                    this$0.mQQCircleShowRecommendRedDot = z17;
                }
                if (!TextUtils.equals(this$0.mQQCircleRecommendRedDotWord, str2)) {
                    this$0.mQQCircleRecommendRedDotWord = str2;
                }
                if (!QzoneConfig.getQQCircleShowGuideOnLebaEntrance() && QCircleHostConfig.isNeedShowLebaQCircleEnterGuideNew() != 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                this$0.mIsNewUser = z19;
                if (!QCircleHostUtil.needHideSmallRedDotInLeba(outerEntranceRedPointInfoByAppid)) {
                    QLog.i("LebaPluginQCircleRedViewHolder", 1, "updateRedFlag, needHideRedDotInLeba");
                    arrayList.clear();
                    hashMap.clear();
                    z26 = false;
                    str3 = "";
                } else {
                    str3 = str2;
                    z26 = z17;
                }
                this$0.D(i17, arrayList, hashMap, str3, qBaseActivity, this$0.mIsNewUser, z26);
            }
        } else {
            j3 = 0;
            str = null;
            str2 = null;
            z16 = false;
            z17 = false;
            i3 = -1;
            i16 = 0;
            i17 = 0;
            z18 = false;
        }
        bArr = null;
        this$0.mQQCircleRedDotReportExt = str;
        this$0.mQQCircleRedDotTransInfo = bArr;
        this$0.mQQCircleEntranceTargetTabType = i3;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("[updateQQCircleRedFlag]");
        sb52.append(", redDotCombineTypes = ");
        sb52.append(j3);
        sb52.append(", pushUnReadNum = ");
        sb52.append(i16);
        sb52.append(", showActiveRedDot = ");
        sb52.append(z18);
        sb52.append(", showPYMKRedDot = ");
        sb52.append(z16);
        sb52.append(", uinList = ");
        sb52.append(arrayList);
        sb52.append(", showRecommendRedDot = ");
        sb52.append(z17);
        sb52.append(", recommendRedDotWording = ");
        sb52.append(str2);
        sb52.append(", entranceTargetTabType = ");
        sb52.append(i3);
        sb52.append(", redDotReportExt = ");
        sb52.append(str);
        QLog.d("QCircleEeveeRedPoint_LebaPluginQCircleRedViewHolder", 2, sb52);
        size = arrayList.size();
        if (this$0.mQQCircleRedNum != i17) {
        }
        if (this$0.mQQCircleShowActiveRedDot != z18) {
        }
        if (this$0.mQQCircleRedUinListSize != size) {
        }
        if (this$0.mQQCircleShowPymkRedDot != z16) {
        }
        if (this$0.mQQCircleShowRecommendRedDot != z17) {
        }
        if (!TextUtils.equals(this$0.mQQCircleRecommendRedDotWord, str2)) {
        }
        if (!QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
        }
        z19 = false;
        this$0.mIsNewUser = z19;
        if (!QCircleHostUtil.needHideSmallRedDotInLeba(outerEntranceRedPointInfoByAppid)) {
        }
        this$0.D(i17, arrayList, hashMap, str3, qBaseActivity, this$0.mIsNewUser, z26);
    }

    private final boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_enable_show_reddot_when_not_word", true);
    }

    private final String i() {
        if (this.mIsNewUser) {
            return QCircleDaTongConstant.ElementParamValue.NEW;
        }
        if (this.mQQCircleRedNum > 0) {
            return "number";
        }
        if (this.mQQCircleShowRecommendRedDot) {
            return QCircleDaTongConstant.ElementParamValue.RECOM;
        }
        return "none";
    }

    private final String j() {
        if (com.tencent.mobileqq.leba.feed.d.a()) {
            return "feeds";
        }
        return "qzone";
    }

    private final int l() {
        int i3;
        if (this.mQQCircleRedNum > 0 && this.mQQCircleShowActiveRedDot) {
            i3 = 3;
        } else if (this.mQQCircleShowActiveRedDot) {
            i3 = 1;
        } else if (this.mQQCircleRedNum > 0) {
            i3 = 2;
        } else if (this.mQQCircleShowRecommendRedDot) {
            i3 = 5;
        } else if (this.mQQCircleShowPymkRedDot) {
            i3 = 6;
        } else {
            i3 = 4;
        }
        if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
            return 7;
        }
        return i3;
    }

    private final String m() {
        if (StudyModeManager.t()) {
            return "teenager";
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return "simple";
        }
        return "default";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str, Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!TextUtils.isEmpty(str)) {
            com.tencent.biz.qqcircle.launcher.c.g(context, str);
        }
    }

    private final boolean p() {
        return TextUtils.equals(com.tencent.biz.qqcircle.utils.l.b("exp_xsj_dongtai_page_red_wording_opt"), "exp_xsj_dongtai_page_red_wording_opt_B");
    }

    private final void q() {
        View findViewById = this.root.findViewById(R.id.f6291324);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.mQQCircleRedDot = (TextView) findViewById;
        View findViewById2 = this.root.findViewById(R.id.f6292325);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mQQCircleRedDotTextView = (TextView) findViewById2;
        View findViewById3 = this.root.findViewById(R.id.f6290323);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mQQCirclePassiveRedDot = (TextView) findViewById3;
        View findViewById4 = this.root.findViewById(R.id.f6289322);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.mQQCircleNewUser = (TextView) findViewById4;
        View findViewById5 = this.root.findViewById(R.id.f628531y);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageSwitcher");
        ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById5;
        this.mQQCircleSubIcon = imageSwitcher;
        Intrinsics.checkNotNull(imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.mobileqq.leba.business.plugins.y
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                View r16;
                r16 = ad.r(ad.this);
                return r16;
            }
        });
        View findViewById6 = this.root.findViewById(R.id.f6287320);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        this.mQQCircleIconShadow = (ImageView) findViewById6;
        View findViewById7 = this.root.findViewById(R.id.f628631z);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageSwitcher");
        ImageSwitcher imageSwitcher2 = (ImageSwitcher) findViewById7;
        this.mQQCircleSubIconTwo = imageSwitcher2;
        Intrinsics.checkNotNull(imageSwitcher2);
        imageSwitcher2.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.mobileqq.leba.business.plugins.z
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                View s16;
                s16 = ad.s(ad.this);
                return s16;
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mLebaQQCircleFacePlayHelper = new dz(this.mQQCircleSubIcon, this.mQQCircleSubIconTwo, this.mQQCircleIconShadow, (QQAppInterface) peekAppRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View r(ad this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = new ImageView(this$0.root.getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View s(ad this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = new ImageView(this$0.root.getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private final void x() {
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder thrActionType = new QCircleLpReportDc05504DataBuilder().setActionType(1).setSubActionType(2).setThrActionType(l());
        String str = this.mQQCircleRedDotReportExt;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        QCircleLpReportDc05504DataBuilder ext7 = thrActionType.setExt5(str).setExt7(QCircleNativeSessionManager.g().getSession());
        String str3 = this.mTabTipWording;
        if (str3 != null) {
            str2 = str3;
        }
        iQCircleReportApi.report5504(ext7.setExt8(str2));
    }

    private final void y() {
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder thrActionType = new QCircleLpReportDc05504DataBuilder().setActionType(1).setSubActionType(1).setThrActionType(l());
        String str = this.mQQCircleRedDotReportExt;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        QCircleLpReportDc05504DataBuilder ext7 = thrActionType.setExt5(str).setExt7(QCircleNativeSessionManager.g().getSession());
        String str3 = this.mTabTipWording;
        if (str3 != null) {
            str2 = str3;
        }
        iQCircleReportApi.report5504(ext7.setExt8(str2));
    }

    private final void z() {
        Map<String, Object> dtElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(dtElementParams, "dtElementParams");
        dtElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        dtElementParams.put("xsj_action_type", "clck");
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB);
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, i());
        String str = this.mQQCircleRedDotReportExt;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str);
        String str3 = this.mTabTipWording;
        if (str3 != null) {
            str2 = str3;
        }
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str2);
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, m());
        dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, j());
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, dtElementParams);
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        y();
        A();
        this.mQQCircleShouldReport = false;
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        TextView textView = this.mQQCircleRedDot;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNull(textView);
        if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            TextView textView2 = this.mQQCircleRedDot;
            Intrinsics.checkNotNull(textView2);
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).addRule(15, 0);
        }
    }

    public final void D(final int num, @Nullable final List<String> uinList, @NotNull final Map<String, String> uinHeadMap, @Nullable final String recommendRedDotWording, @NotNull final QBaseActivity activity, final boolean isNewUser, final boolean showRecommendRedDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(num), uinList, uinHeadMap, recommendRedDotWording, activity, Boolean.valueOf(isNewUser), Boolean.valueOf(showRecommendRedDot));
            return;
        }
        Intrinsics.checkNotNullParameter(uinHeadMap, "uinHeadMap");
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.leba.util.a.b(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.E(isNewUser, this, num, activity, recommendRedDotWording, uinList, showRecommendRedDot, uinHeadMap);
            }
        });
    }

    public final void G(@Nullable String recommendRedDotWording, @NotNull Context context, @Nullable List<String> uinList, boolean showRecommendRedDot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, recommendRedDotWording, context, uinList, Boolean.valueOf(showRecommendRedDot));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = this.mQQCircleRedDotTextView;
        if (textView != null && this.mQQCircleRedDot != null) {
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(0);
            TextView textView2 = this.mQQCircleRedDot;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(0);
            TextView textView3 = this.mQQCircleRedDotTextView;
            Intrinsics.checkNotNull(textView3);
            textView3.setText(recommendRedDotWording);
            com.tencent.widget.d.b(this.mQQCircleRedDot, 8, 0, 0);
            if (uinList != null && uinList.size() > 1) {
                H(ViewUtils.dpToPx(80.0f));
                F(context);
                return;
            }
            if (uinList != null && uinList.size() == 1) {
                H(ViewUtils.dpToPx(48.0f));
                F(context);
                return;
            }
            if (!showRecommendRedDot || !h()) {
                z16 = false;
            }
            if (TextUtils.isEmpty(recommendRedDotWording) && !z16) {
                TextView textView4 = this.mQQCircleRedDot;
                Intrinsics.checkNotNull(textView4);
                textView4.setVisibility(8);
            } else {
                H(ViewUtils.dpToPx(25.0f));
                com.tencent.widget.d.e(context, this.mQQCircleRedDot, 10, false);
            }
        }
    }

    public final void I() {
        QQAppInterface qQAppInterface;
        final QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Context context = this.root.getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        } else {
            qBaseActivity = null;
        }
        if (qQAppInterface != null && qBaseActivity != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ad.J(ad.this, qBaseActivity);
                }
            }, 16, null, false);
        } else {
            QLog.i("LebaPluginQCircleRedViewHolder", 1, "updateQQCircleRedFlag app == null || activity == null");
        }
    }

    public final void f(@NotNull HashMap<String, String> attrs, @NotNull HashMap<String, byte[]> byteAttrs) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) attrs, (Object) byteAttrs);
            return;
        }
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(byteAttrs, "byteAttrs");
        if (this.mQQCircleShowActiveRedDot) {
            str = "1";
        } else {
            str = "0";
        }
        attrs.put("key_show_active_red_dot", str);
        int i3 = this.mQQCircleRedNum;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        attrs.put("key_unread_red_num", sb5.toString());
        byte[] bArr = this.mQQCircleRedDotTransInfo;
        if (bArr != null) {
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                byteAttrs.put("key_red_dot_trans_info", bArr);
            }
        }
        int i16 = this.mQQCircleEntranceTargetTabType;
        if (i16 > 0) {
            attrs.put(QCircleSchemeAttr.Polymerize.TAB_TYPE, String.valueOf(i16));
        }
    }

    @NotNull
    public final View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.root;
    }

    @NotNull
    public final String k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mQQCircleRedNum > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = this.mQQCircleShowActiveRedDot;
        boolean z18 = this.mIsNewUser;
        if (z16) {
            return "num_red_dot";
        }
        if (z17) {
            return "little_red_dot";
        }
        if (z18) {
            return "new_red_dot";
        }
        if (this.mQQCircleShowRecommendRedDot) {
            return "recomd_red_dot";
        }
        return "";
    }

    public final void n(@NotNull final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        x();
        z();
        final String str = this.mQQCircleRedDotJumpUrl;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.ab
            @Override // java.lang.Runnable
            public final void run() {
                ad.o(str, context);
            }
        });
    }

    public final void t() {
        QQAppInterface qQAppInterface;
        dz dzVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && (dzVar = this.mLebaQQCircleFacePlayHelper) != null) {
            dzVar.r(qQAppInterface);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        dz dzVar = this.mLebaQQCircleFacePlayHelper;
        if (dzVar != null) {
            dzVar.s();
        }
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        dz dzVar = this.mLebaQQCircleFacePlayHelper;
        if (dzVar != null) {
            dzVar.t();
        }
        this.mQQCircleShouldReport = true;
        this.mIsForeground = false;
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        dz dzVar = this.mLebaQQCircleFacePlayHelper;
        if (dzVar != null) {
            dzVar.v();
        }
        this.mIsForeground = true;
    }
}

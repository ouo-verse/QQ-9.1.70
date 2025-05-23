package com.qzone.reborn.feedpro.widget.picmix;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.utils.aq;
import com.qzone.reborn.feedx.event.QZoneVideoOnPlayEvent;
import com.qzone.reborn.feedx.video.QZonePlayer;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.util.m;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.video.RFWLayerVideoPlayPosRecorder;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u00aa\u00012\u00020\u00012\u00020\u0002:\u000e>\u00ab\u0001\u00ac\u0001H\u00ad\u0001\u00ae\u0001\u00af\u0001\u00b0\u0001B.\b\u0007\u0012\b\u0010\u00a4\u0001\u001a\u00030\u00a3\u0001\u0012\f\b\u0002\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a5\u0001\u0012\t\b\u0002\u0010\u00a7\u0001\u001a\u00020\f\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0004J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\fH\u0014J\u0010\u0010 \u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\u0003H\u0014J\b\u0010(\u001a\u00020'H\u0014J\u001a\u0010+\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014J\"\u00100\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0004J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0010H\u0014J\u0010\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0010H\u0014J\u0018\u0010:\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\tH\u0014J\u0006\u0010;\u001a\u00020\u0003J\u000e\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0010J\b\u0010>\u001a\u00020\u0003H\u0016J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0010H\u0004J\u0010\u0010D\u001a\u00020C2\b\u0010B\u001a\u0004\u0018\u00010AJ\u0010\u0010F\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010\tJ\u000e\u0010G\u001a\u00020\t2\u0006\u0010B\u001a\u00020AJ\n\u0010H\u001a\u0004\u0018\u00010,H\u0016J\b\u0010I\u001a\u00020\u0010H\u0014J\u000e\u0010K\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0010J\u000e\u0010M\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u0010J\u000e\u0010N\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u0010J\u0010\u0010Q\u001a\u00020\u00032\b\u0010P\u001a\u0004\u0018\u00010OR$\u0010X\u001a\u0004\u0018\u00010A8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR*\u0010`\u001a\u00020$2\u0006\u0010Y\u001a\u00020$8\u0006@DX\u0086.\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010g\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010k\u001a\u00020\"8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bh\u0010b\u001a\u0004\bi\u0010d\"\u0004\bj\u0010fR\"\u0010s\u001a\u00020l8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010bR\u0016\u0010|\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R%\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b}\u0010{\u001a\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010{R\u0018\u0010\u0084\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010{R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R(\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009d\u0001\u0010b\u001a\u0005\b\u009e\u0001\u0010d\"\u0005\b\u009f\u0001\u0010fR\u0016\u0010\u00a2\u0001\u001a\u00020\u00108DX\u0084\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00a1\u0001\u0010\u007f\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProMixBaseWidgetView;", "Lde/f;", "", "z1", "S0", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "q1", "", ReportConstant.COSTREPORT_PREFIX, ICustomDataEditor.STRING_PARAM_1, "", "videoDuration", "currentDuration", "F1", "", "isMute", "C1", "p1", "player", "W0", "X0", "Lcom/qzone/reborn/feedx/video/QZonePlayer;", "T0", "getLogTag", "getLayoutId", "j1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, com.tencent.luggage.wxa.c8.c.G, "o0", "Q0", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/widget/ImageView;", "q0", "Lcom/qzone/reborn/feedx/video/view/QZoneVideoView;", "i1", "P0", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "U0", "Landroid/view/ViewGroup$LayoutParams;", "rootViewParams", "m0", "Landroid/view/View;", "view", "realWidth", "realHeight", "A1", "pause", "play", "Y0", ICustomDataEditor.NUMBER_PARAM_1, "continuePlay", "B1", "Lcom/qzone/reborn/feedx/video/c;", "options", "playUrlKey", "O0", "o1", "outPutMute", "setOutPutMute", "a", "isVisible", "t1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "Z0", "url", ICustomDataEditor.STRING_ARRAY_PARAM_1, "h1", "d", "m1", "isPlayFromStart", "setIsPlayFromStart", NodeProps.VISIBLE, "setIsTimeMuteLayoutVisible", "setPlayIconVisible", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$b;", "callback", "setVideoStateBroadcastCallback", "E", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "f1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "setMVideoInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;)V", "mVideoInfo", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/video/view/QZoneVideoView;", "g1", "()Lcom/qzone/reborn/feedx/video/view/QZoneVideoView;", "y1", "(Lcom/qzone/reborn/feedx/video/view/QZoneVideoView;)V", "mVideoView", "G", "Landroid/widget/ImageView;", "b1", "()Landroid/widget/ImageView;", "v1", "(Landroid/widget/ImageView;)V", "mCoverView", "H", "d1", "w1", "mPlayIcon", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "e1", "()Landroid/widget/LinearLayout;", "x1", "(Landroid/widget/LinearLayout;)V", "mTimeMuteLayout", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mTvVideoTime", "K", "mIvOutputMute", "L", "Z", "mIsPlayFromStart", "M", "c1", "()Z", "mOutputMute", "N", "mIsTimeMuteLayoutVisible", "P", "mIsPlayIconVisible", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$g;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$g;", "mPlayerSdkInitListener", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$d;", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$d;", "mPlayerLooperListener", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$h;", ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$h;", "mPlayerSeekListener", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$f;", "T", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$f;", "mPlayerPrepareListener", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$c;", "U", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$c;", "mCompletionListener", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$e;", "V", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$e;", "mPlayerPassivePauseListener", "W", "getAnimCoverView", "setAnimCoverView", "animCoverView", "l1", "isIgnoreUserAutoPlay", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a0", "b", "c", "e", "f", "g", tl.h.F, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFeedProVideoItemWidgetView extends QzoneFeedProMixBaseWidgetView implements de.f {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b0, reason: collision with root package name */
    private static final String f54678b0 = "PsProLink-QzoneFeedProVideoItemWidgetView";

    /* renamed from: E, reason: from kotlin metadata */
    private CommonVideo mVideoInfo;

    /* renamed from: F, reason: from kotlin metadata */
    protected QZoneVideoView mVideoView;

    /* renamed from: G, reason: from kotlin metadata */
    protected ImageView mCoverView;

    /* renamed from: H, reason: from kotlin metadata */
    protected ImageView mPlayIcon;

    /* renamed from: I, reason: from kotlin metadata */
    protected LinearLayout mTimeMuteLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTvVideoTime;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView mIvOutputMute;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsPlayFromStart;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mOutputMute;

    /* renamed from: N, reason: from kotlin metadata */
    private volatile boolean mIsTimeMuteLayoutVisible;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsPlayIconVisible;

    /* renamed from: Q, reason: from kotlin metadata */
    private g mPlayerSdkInitListener;

    /* renamed from: R, reason: from kotlin metadata */
    private d mPlayerLooperListener;

    /* renamed from: S, reason: from kotlin metadata */
    private h mPlayerSeekListener;

    /* renamed from: T, reason: from kotlin metadata */
    private f mPlayerPrepareListener;

    /* renamed from: U, reason: from kotlin metadata */
    private c mCompletionListener;

    /* renamed from: V, reason: from kotlin metadata */
    private e mPlayerPassivePauseListener;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView animCoverView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$a;", "", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "weakReference", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final QzoneFeedProVideoItemWidgetView b(WeakReference<QzoneFeedProVideoItemWidgetView> weakReference) {
            if (weakReference == null) {
                QLog.e(QzoneFeedProVideoItemWidgetView.f54678b0, 1, "getVideoItemWidgetView  weakReference == null");
                return null;
            }
            QzoneFeedProVideoItemWidgetView qzoneFeedProVideoItemWidgetView = weakReference.get();
            if (qzoneFeedProVideoItemWidgetView != null) {
                return qzoneFeedProVideoItemWidgetView;
            }
            QLog.e(QzoneFeedProVideoItemWidgetView.f54678b0, 1, "getVideoItemWidgetView  widgetView == null");
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$b;", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$c;", "Llh/a;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "iSuperPlayer", "", "onCompletion", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "", "b", "Ljava/lang/String;", "mPlayUrlKey", "widgetView", "playUrlKey", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;Ljava/lang/String;)V", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements lh.a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f54680d = "QZoneCompletionListener";

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String mPlayUrlKey;

        public c(QzoneFeedProVideoItemWidgetView widgetView, String playUrlKey) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            Intrinsics.checkNotNullParameter(playUrlKey, "playUrlKey");
            this.mWeakReference = new WeakReference<>(widgetView);
            this.mPlayUrlKey = playUrlKey;
        }

        @Override // lh.a
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            Intrinsics.checkNotNullParameter(iSuperPlayer, "iSuperPlayer");
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(this.mPlayUrlKey, 0L);
            b16.t1(true);
            b16.s1("[addCallback]  [onCompletion]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$e;", "Llh/d;", "", "what", "model", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "soloTime", "playTimeBaseVideoPos", "", "onVideoPassivePause", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements lh.d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        public e(QzoneFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.d
        public void onVideoPassivePause(int what, int model, long playTime, long soloTime, long playTimeBaseVideoPos) {
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            b16.t1(true);
            b16.s1("[addCallback]  [onVideoPassivePause]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$f;", "Llh/e;", "Lcom/qzone/reborn/feedx/video/QZonePlayer;", "player", "", "a", "b", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements lh.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        public f(QzoneFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.e
        public void a(QZonePlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null || b16.T0(player)) {
                return;
            }
            ISuperPlayer i3 = player.i();
            Intrinsics.checkNotNullExpressionValue(i3, "player.realPlayer");
            b16.W0(i3);
        }

        @Override // lh.e
        public void b(QZonePlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null || b16.T0(player)) {
                return;
            }
            b16.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$g;", "Llh/f;", "Lcom/qzone/reborn/feedx/video/QZonePlayer;", "player", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements lh.f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        public g(QzoneFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.f
        public void a(QZonePlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            b16.g1().setOutPutMute(b16.getMOutputMute());
            b16.C1(b16.getMOutputMute());
            b16.g1().setLoopBack(b16.m1());
            b16.s1("[addCallback]  [onInitSuccess]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$h;", "Llh/h;", "Landroid/widget/SeekBar;", "seekBar", "", "onStartTrackingTouch", "onStopTrackingTouch", "", "progress", "", "fromUser", "onSeekBarProgressChanged", "", "timeString", "videoDuration", "currentDuration", "onProgress", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "b", "Ljava/lang/String;", "mPlayUrlKey", "widgetView", "playUrlKey", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class h implements lh.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String mPlayUrlKey;

        public h(QzoneFeedProVideoItemWidgetView widgetView, String playUrlKey) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            Intrinsics.checkNotNullParameter(playUrlKey, "playUrlKey");
            this.mWeakReference = new WeakReference<>(widgetView);
            this.mPlayUrlKey = playUrlKey;
        }

        @Override // lh.h
        public void onProgress(String timeString, int videoDuration, int currentDuration) {
            Intrinsics.checkNotNullParameter(timeString, "timeString");
            QzoneFeedProVideoItemWidgetView b16 = QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            RFWLayerVideoPlayPosRecorder.INSTANCE.updatePlayPosition(this.mPlayUrlKey, currentDuration);
            b16.F1(videoDuration, currentDuration);
        }

        @Override // lh.h
        public void onSeekBarProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // lh.h
        public void onStartTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // lh.h
        public void onStopTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProVideoItemWidgetView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(final boolean isMute) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.picmix.i
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProVideoItemWidgetView.D1(QzoneFeedProVideoItemWidgetView.this, isMute);
                }
            });
            return;
        }
        ImageView imageView = null;
        if (!this.mIsTimeMuteLayoutVisible) {
            ImageView imageView2 = this.mIvOutputMute;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.mIvOutputMute;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
            imageView3 = null;
        }
        if (imageView3.getVisibility() == 8) {
            ImageView imageView4 = this.mIvOutputMute;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
        }
        if (isMute) {
            ImageView imageView5 = this.mIvOutputMute;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
                imageView5 = null;
            }
            imageView5.setImageResource(R.drawable.qui_voice_mute);
        } else {
            ImageView imageView6 = this.mIvOutputMute;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
                imageView6 = null;
            }
            imageView6.setImageResource(R.drawable.qui_voice_low);
        }
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView7 = this.mIvOutputMute;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvOutputMute");
        } else {
            imageView = imageView7;
        }
        a16.m(imageView, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(QzoneFeedProVideoItemWidgetView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(final int videoDuration, final int currentDuration) {
        String str;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.picmix.j
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProVideoItemWidgetView.G1(QzoneFeedProVideoItemWidgetView.this, videoDuration, currentDuration);
                }
            });
            return;
        }
        int i3 = videoDuration - currentDuration;
        TextView textView = null;
        if (!this.mIsTimeMuteLayoutVisible) {
            TextView textView2 = this.mTvVideoTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvVideoTime");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mTvVideoTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvVideoTime");
            textView3 = null;
        }
        textView3.setVisibility(0);
        String d16 = nh.c.d(i3);
        TextView textView4 = this.mTvVideoTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvVideoTime");
        } else {
            textView = textView4;
        }
        textView.setText(d16);
        String e16 = nh.c.e(i3);
        LinearLayout e17 = e1();
        if (this.mOutputMute) {
            str = "\u6253\u5f00\u58f0\u97f3";
        } else {
            str = "\u9759\u97f3";
        }
        e17.setContentDescription("\u5269\u4f59\u65f6\u95f4" + e16 + "\u70b9\u51fb" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(QzoneFeedProVideoItemWidgetView this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F1(i3, i16);
    }

    private final void S0() {
        z1();
        g1().setDataPosInList(getMFeedPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(QzoneFeedProVideoItemWidgetView this$0, LoadState loadState, Option option) {
        CommonPicUrl e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinish()) {
            String str = f54678b0;
            String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(this$0.getMFeedData());
            int mFeedPosition = this$0.getMFeedPosition();
            CommonVideo commonVideo = this$0.mVideoInfo;
            Intrinsics.checkNotNull(commonVideo);
            CommonImage cover = commonVideo.getCover();
            QLog.i(str, 4, "createCoverLoadStateListener  | state = " + loadState + " | feedKey = " + feedUniqueKey + " | pos = " + mFeedPosition + " | url = " + ((cover == null || (e16 = xd.d.e(cover)) == null) ? null : e16.getUrl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(ISuperPlayer player) {
        if (g1() == null) {
            return;
        }
        player.setXYaxis(2);
        g1().start();
        s1("[doOnVideoPrepare]  ");
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(QzoneFeedProVideoItemWidgetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        CommonVideo commonVideo = this.mVideoInfo;
        if (commonVideo == null) {
            return;
        }
        Intrinsics.checkNotNull(commonVideo);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneVideoOnPlayEvent(commonVideo.getId(), getRootView().hashCode()));
        t1(false);
        s1("[onVideoStartViewOperation]  ");
    }

    private final void q1(ISuperPlayer superPlayer) {
        if (!n1()) {
            QLog.d(f54678b0, 1, "playWhenOldPlayerIsExist  !isPlaySameVideo, startANewPlayer");
            B1(false);
            return;
        }
        if (superPlayer.isPlaying() && g1().y0()) {
            QLog.d(f54678b0, 1, "playWhenOldPlayerIsExist  isPlaying , return");
            if (b1().getVisibility() == 0) {
                t1(false);
                return;
            }
            return;
        }
        if (superPlayer.isPausing()) {
            if (this.mIsPlayFromStart) {
                superPlayer.seekTo(0);
                QLog.d(f54678b0, 1, "playWhenOldPlayerIsExist  isPausing , start play from start");
            } else if (Y0()) {
                superPlayer.seekTo((int) Z0(this.mVideoInfo));
            }
            superPlayer.start();
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.picmix.k
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProVideoItemWidgetView.r1(QzoneFeedProVideoItemWidgetView.this);
                }
            }, 300L);
            QLog.d(f54678b0, 1, "playWhenOldPlayerIsExist  isPausing , start play");
            return;
        }
        QLog.d(f54678b0, 1, "playWhenOldPlayerIsExist  startANewPlayer");
        B1(!this.mIsPlayFromStart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(QzoneFeedProVideoItemWidgetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(String s16) {
        String str;
        String url;
        String str2 = f54678b0 + "QZone_PLAYER";
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        CommonVideo commonVideo = this.mVideoInfo;
        String str3 = "";
        if (commonVideo == null || (str = commonVideo.getId()) == null) {
            str = "";
        }
        int mFeedPosition = getMFeedPosition();
        CommonVideo commonVideo2 = this.mVideoInfo;
        if (commonVideo2 != null && (url = commonVideo2.getUrl()) != null) {
            str3 = url;
        }
        QLog.i(str2, 1, s16 + " | feedKey = " + feedUniqueKey + " | id = " + str + " | position = " + mFeedPosition + " | url = " + str3 + " | text = " + CommonFeedDataUtilKt.getFeedContentSummary(getMFeedData()) + " | hashcode: " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(QzoneFeedProVideoItemWidgetView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t1(z16);
    }

    private final void z1() {
        if (g1().getSuperPlayer() == null) {
            return;
        }
        g1().getSuperPlayer().setXYaxis(2);
        g1().requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A1(View view, int realWidth, int realHeight) {
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = realWidth;
        layoutParams2.height = realHeight;
        view.setLayoutParams(layoutParams2);
    }

    protected void B1(boolean continuePlay) {
        if (this.mVideoInfo == null) {
            QLog.d(f54678b0 + "QZone_PLAYER", 1, "startANewPlayer fail : " + g1());
            return;
        }
        g1().setData(getMFeedData(), getMFeedPosition());
        CommonVideo commonVideo = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo);
        String h16 = h1(commonVideo);
        long j3 = 0;
        if (continuePlay) {
            long playPosition = RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(h16);
            if (playPosition != 0) {
                j3 = playPosition;
            }
        }
        com.qzone.reborn.feedx.video.c l3 = com.qzone.reborn.feedx.video.c.l();
        CommonVideo commonVideo2 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo2);
        com.qzone.reborn.feedx.video.c n3 = l3.n(commonVideo2.getUrl());
        CommonVideo commonVideo3 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo3);
        com.qzone.reborn.feedx.video.c m3 = n3.m(commonVideo3.getId());
        CommonVideo commonVideo4 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo4);
        com.qzone.reborn.feedx.video.c o16 = m3.o(commonVideo4.getId());
        CommonVideo commonVideo5 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo5);
        com.qzone.reborn.feedx.video.c options = o16.r(commonVideo5.getVideoTime()).q((int) j3);
        Intrinsics.checkNotNullExpressionValue(options, "options");
        O0(options, h16);
        g1().A0(options);
        String str = f54678b0 + "QZone_PLAYER";
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        int mFeedPosition = getMFeedPosition();
        CommonVideo commonVideo6 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo6);
        String url = commonVideo6.getUrl();
        CommonVideo commonVideo7 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo7);
        String id5 = commonVideo7.getId();
        CommonVideo commonVideo8 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo8);
        QLog.d(str, 1, "[startANewPlayer]  | feedKey = " + feedUniqueKey + " | position = " + mFeedPosition + " | url = " + url + " | id = " + id5 + " | time = " + commonVideo8.getVideoTime() + " | text = " + CommonFeedDataUtilKt.getFeedContentSummary(getMFeedData()) + " | playUrlKey = " + h16 + " | startOffset = " + j3 + " | hashcode: " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O0(com.qzone.reborn.feedx.video.c options, String playUrlKey) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(playUrlKey, "playUrlKey");
        this.mPlayerSdkInitListener = new g(this);
        options.b().f(this.mPlayerSdkInitListener);
        this.mPlayerLooperListener = new d(this);
        options.b().c(this.mPlayerLooperListener);
        this.mPlayerSeekListener = new h(this, playUrlKey);
        options.b().h(this.mPlayerSeekListener);
        this.mPlayerPrepareListener = new f(this);
        options.b().e(this.mPlayerPrepareListener);
        this.mPlayerPassivePauseListener = new e(this);
        options.b().d(this.mPlayerPassivePauseListener);
        this.mCompletionListener = new c(this, playUrlKey);
        options.b().a(this.mCompletionListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P0() {
        CommonPicUrl e16;
        CommonVideo commonVideo = this.mVideoInfo;
        if (commonVideo != null) {
            Intrinsics.checkNotNull(commonVideo);
            if (commonVideo.getCover() != null) {
                Option obtain = Option.obtain();
                CommonVideo commonVideo2 = this.mVideoInfo;
                Intrinsics.checkNotNull(commonVideo2);
                CommonImage cover = commonVideo2.getCover();
                obtain.setUrl((cover == null || (e16 = xd.d.e(cover)) == null) ? null : e16.getUrl());
                if (b1().getLayoutParams() != null) {
                    obtain.setRequestWidth(b1().getLayoutParams().width);
                    obtain.setRequestHeight(b1().getLayoutParams().height);
                }
                obtain.setTargetView(b1());
                m mVar = m.f59551a;
                obtain.setLoadingDrawable(mVar.b(getContext()));
                obtain.setFailDrawable(mVar.a(getContext()));
                com.tencent.mobileqq.qzone.picload.c.a().i(obtain, U0());
                if (g1().getSuperPlayer() == null || !g1().getSuperPlayer().isPlaying()) {
                    t1(true);
                    return;
                }
                return;
            }
        }
        QLog.e(f54678b0, 1, "bindCoverData  params error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IPicLoadStateListener U0() {
        return new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.widget.picmix.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QzoneFeedProVideoItemWidgetView.V0(QzoneFeedProVideoItemWidgetView.this, loadState, option);
            }
        };
    }

    public boolean Y0() {
        return true;
    }

    public void a() {
        VideoReport.unbindVideoPlayerInfo(g1());
        if (g1().getSuperPlayer() != null) {
            g1().release();
        }
        t1(true);
        s1("[releasePlayer]  ");
    }

    public final long a1(String url) {
        if (TextUtils.isEmpty(url)) {
            return 0L;
        }
        String playUrlKey = nh.c.g(url);
        RFWLayerVideoPlayPosRecorder rFWLayerVideoPlayPosRecorder = RFWLayerVideoPlayPosRecorder.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(playUrlKey, "playUrlKey");
        return rFWLayerVideoPlayPosRecorder.getPlayPosition(playUrlKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView b1() {
        ImageView imageView = this.mCoverView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCoverView");
        return null;
    }

    /* renamed from: c1, reason: from getter */
    public final boolean getMOutputMute() {
        return this.mOutputMute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView d1() {
        ImageView imageView = this.mPlayIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayIcon");
        return null;
    }

    protected final LinearLayout e1() {
        LinearLayout linearLayout = this.mTimeMuteLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTimeMuteLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f1, reason: from getter */
    public final CommonVideo getMVideoInfo() {
        return this.mVideoInfo;
    }

    public final QZoneVideoView g1() {
        QZoneVideoView qZoneVideoView = this.mVideoView;
        if (qZoneVideoView != null) {
            return qZoneVideoView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chp;
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    protected String getLogTag() {
        return f54678b0;
    }

    public final String h1(CommonVideo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        if (!TextUtils.isEmpty(videoInfo.getId())) {
            String id5 = videoInfo.getId();
            return id5 == null ? "" : id5;
        }
        String g16 = nh.c.g(videoInfo.getUrl());
        Intrinsics.checkNotNullExpressionValue(g16, "getVideoFilePathUrl(videoInfo.url)");
        return g16;
    }

    public QZoneVideoView i1() {
        return g1();
    }

    protected final boolean l1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    public void m0(CommonMedia media, ViewGroup.LayoutParams rootViewParams) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        Intrinsics.checkNotNullParameter(media, "media");
        CommonFeed mFeedData = getMFeedData();
        if (((mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null) ? 0 : mediaItems.size()) > 1) {
            return;
        }
        if (this.mVideoInfo != null && media.getVideo() != null) {
            CommonVideo commonVideo = this.mVideoInfo;
            if (commonVideo == null) {
                commonVideo = media.getVideo();
            }
            this.mVideoInfo = commonVideo;
            if (rootViewParams == null) {
                rootViewParams = new ViewGroup.LayoutParams(-1, -1);
            }
            aq aqVar = aq.f54314a;
            Context context = getContext();
            CommonVideo commonVideo2 = this.mVideoInfo;
            Intrinsics.checkNotNull(commonVideo2);
            int width = commonVideo2.getWidth();
            CommonVideo commonVideo3 = this.mVideoInfo;
            Intrinsics.checkNotNull(commonVideo3);
            aqVar.b(context, rootViewParams, width, commonVideo3.getHeight(), r0());
            A1(b1(), rootViewParams.width, rootViewParams.height);
            A1(g1(), rootViewParams.width, rootViewParams.height);
            String str = f54678b0;
            int mFeedPosition = getMFeedPosition();
            String feedContentSummary = CommonFeedDataUtilKt.getFeedContentSummary(getMFeedData());
            String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
            CommonVideo commonVideo4 = this.mVideoInfo;
            Intrinsics.checkNotNull(commonVideo4);
            int width2 = commonVideo4.getWidth();
            CommonVideo commonVideo5 = this.mVideoInfo;
            Intrinsics.checkNotNull(commonVideo5);
            QLog.i(str, 1, "adjustViewSize  | position = " + mFeedPosition + " | text = " + feedContentSummary + " | feedKey = " + feedUniqueKey + " | videoWidth = " + width2 + " | videoHeight = " + commonVideo5.getHeight() + " | realWidth = " + rootViewParams.width + " | realHeight = " + rootViewParams.height);
            return;
        }
        QLog.e(f54678b0, 1, "adjustViewSize  params error");
    }

    protected boolean m1() {
        return false;
    }

    protected boolean n1() {
        if (getMFeedData() == null || !(g1().getData() instanceof CommonFeed)) {
            return false;
        }
        Object data = g1().getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed");
        return TextUtils.equals(CommonFeedExtKt.getFeedUniqueKey((CommonFeed) data), CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0 */
    public void bindData(CommonMedia media, int pos) {
        Intrinsics.checkNotNullParameter(media, "media");
        super.bindData(media, pos);
        if (media.getVideo() == null) {
            QLog.e(f54678b0, 1, "bindData  params error");
        } else {
            Q0(media);
        }
    }

    public final void o1() {
        if (g1().getOutPutMute()) {
            g1().setOutPutMute(false);
            C1(false);
            setOutPutMute(false);
        } else {
            g1().setOutPutMute(true);
            C1(true);
            setOutPutMute(true);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void pause() {
        String str;
        String str2 = f54678b0 + "QZone_PLAYER";
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        int mFeedPosition = getMFeedPosition();
        CommonVideo commonVideo = this.mVideoInfo;
        if (commonVideo == null || (str = commonVideo.getUrl()) == null) {
            str = "";
        }
        QLog.d(str2, 1, "[pause]   | feedKey = " + feedUniqueKey + " | position = " + mFeedPosition + " | url = " + str + " | hashcode = " + hashCode());
        if (g1().getSuperPlayer() != null && g1().getSuperPlayer().isPlaying()) {
            g1().getSuperPlayer().pause();
        }
        t1(true);
    }

    public void play() {
        String str;
        boolean l16 = l1();
        String str2 = f54678b0;
        String str3 = str2 + "QZone_PLAYER";
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        int mFeedPosition = getMFeedPosition();
        CommonVideo commonVideo = this.mVideoInfo;
        if (commonVideo == null || (str = commonVideo.getUrl()) == null) {
            str = "";
        }
        QLog.d(str3, 1, "[play]   | feedKey = " + feedUniqueKey + " | position = " + mFeedPosition + " | url = " + str + " | ignoreUserAutoPlay = " + l16 + " | this = " + this);
        if (!l16) {
            boolean m3 = com.qzone.adapter.feedcomponent.i.H().m();
            QLog.d(str2, 1, "[play]  userCanAutoPlay = " + m3);
            if (!m3) {
                return;
            }
        }
        ISuperPlayer superPlayer = g1().getSuperPlayer();
        if (superPlayer != null) {
            q1(superPlayer);
        } else {
            B1(!this.mIsPlayFromStart);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    /* renamed from: q0 */
    public ImageView getMImageView() {
        return b1();
    }

    public final void setAnimCoverView(ImageView imageView) {
        this.animCoverView = imageView;
    }

    public final void setIsPlayFromStart(boolean isPlayFromStart) {
        this.mIsPlayFromStart = isPlayFromStart;
    }

    public final void setIsTimeMuteLayoutVisible(boolean visible) {
        this.mIsTimeMuteLayoutVisible = visible;
        e1().setVisibility(visible ? 0 : 8);
    }

    public final void setOutPutMute(boolean outPutMute) {
        this.mOutputMute = outPutMute;
        b1().setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.valueOf(outPutMute));
    }

    public final void setPlayIconVisible(boolean visible) {
        this.mIsPlayIconVisible = visible;
        d1().setVisibility(visible ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t1(final boolean isVisible) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.picmix.h
                @Override // java.lang.Runnable
                public final void run() {
                    QzoneFeedProVideoItemWidgetView.u1(QzoneFeedProVideoItemWidgetView.this, isVisible);
                }
            });
            return;
        }
        ImageView imageView = this.animCoverView;
        if (imageView != null && !isVisible) {
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
        }
        b1().setVisibility(isVisible ? 0 : 8);
        QLog.d(f54678b0, 1, "setCoverViewVisibility  isVisible=" + isVisible);
        if (this.mIsPlayIconVisible) {
            d1().setVisibility(isVisible ? 0 : 8);
        } else {
            d1().setVisibility(8);
        }
        e1().setVisibility((isVisible && this.mIsTimeMuteLayoutVisible) ? 8 : 0);
    }

    protected final void v1(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mCoverView = imageView;
    }

    protected final void w1(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mPlayIcon = imageView;
    }

    protected final void x1(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mTimeMuteLayout = linearLayout;
    }

    protected final void y1(QZoneVideoView qZoneVideoView) {
        Intrinsics.checkNotNullParameter(qZoneVideoView, "<set-?>");
        this.mVideoView = qZoneVideoView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProVideoItemWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzoneFeedProVideoItemWidgetView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProVideoItemWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOutputMute = true;
        this.mIsTimeMuteLayoutVisible = true;
        this.mIsPlayIconVisible = true;
        j1();
        setOutPutMute(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T0(QZonePlayer player) {
        if (player == null || this.mVideoInfo == null) {
            return true;
        }
        String c16 = player.h().c();
        CommonVideo commonVideo = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo);
        if (TextUtils.equals(c16, commonVideo.getUrl())) {
            return false;
        }
        String str = f54678b0 + "QZone_PLAYER";
        String c17 = player.h().c();
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        CommonVideo commonVideo2 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo2);
        String id5 = commonVideo2.getId();
        int mFeedPosition = getMFeedPosition();
        CommonVideo commonVideo3 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo3);
        QLog.w(str, 1, "checkIsNotSameVideo   url not equals | player.playUrl = " + c17 + " | feedKey = " + feedUniqueKey + " | videoId = " + id5 + " | position = " + mFeedPosition + " | url = " + commonVideo3.getUrl() + " | hashcode = " + hashCode());
        return true;
    }

    public final void Q0(CommonMedia media) {
        CommonPicUrl e16;
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        String str = null;
        if ((media != null ? media.getVideo() : null) == null) {
            return;
        }
        this.mVideoInfo = media.getVideo();
        String str2 = f54678b0 + "QZone_PLAYER";
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        int mFeedPosition = getMFeedPosition();
        int mPicPosition = getMPicPosition();
        CommonFeed mFeedData = getMFeedData();
        String feedContentSummary = mFeedData != null ? CommonFeedDataUtilKt.getFeedContentSummary(mFeedData) : null;
        CommonFeed mFeedData2 = getMFeedData();
        String nick = (mFeedData2 == null || (cellUserInfo = mFeedData2.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null) ? null : user.getNick();
        CommonVideo commonVideo = this.mVideoInfo;
        String url = commonVideo != null ? commonVideo.getUrl() : null;
        CommonVideo commonVideo2 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo2);
        CommonImage cover = commonVideo2.getCover();
        if (cover != null && (e16 = xd.d.e(cover)) != null) {
            str = e16.getUrl();
        }
        QLog.d(str2, 1, "[bindVideoInfoData]   | feedKey = " + feedUniqueKey + " | position = " + mFeedPosition + " | mPicPosition = " + mPicPosition + " | text = " + feedContentSummary + " | nick = " + nick + " | url = " + url + " | coverUrl = " + str + " | hashcode = " + hashCode());
        m0(media, v0().getLayoutParams());
        P0();
        S0();
        CommonVideo commonVideo3 = this.mVideoInfo;
        Intrinsics.checkNotNull(commonVideo3);
        F1((int) commonVideo3.getVideoTime(), 0);
    }

    protected final void j1() {
        View findViewById = findViewById(R.id.n6k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_layout_round_view)");
        z0((RoundCorneredFrameLayout) findViewById);
        View findViewById2 = findViewById(R.id.ndb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_video_view)");
        y1((QZoneVideoView) findViewById2);
        View findViewById3 = findViewById(R.id.mth);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_cover_view)");
        v1((ImageView) findViewById3);
        View findViewById4 = findViewById(R.id.l2y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_feed_video_play_icon)");
        w1((ImageView) findViewById4);
        d1().setImageResource(R.drawable.f153484);
        View findViewById5 = findViewById(R.id.m_y);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_video_time_mute)");
        x1((LinearLayout) findViewById5);
        View findViewById6 = findViewById(R.id.nks);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_video_time)");
        this.mTvVideoTime = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f162750ln3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.iv_mute_status)");
        this.mIvOutputMute = (ImageView) findViewById7;
        e1().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.picmix.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProVideoItemWidgetView.k1(QzoneFeedProVideoItemWidgetView.this, view);
            }
        });
        AccessibilityUtil.s(this, l.a(R.string.f2202968q));
    }

    public final long Z0(CommonVideo videoInfo) {
        String id5;
        if (videoInfo == null) {
            return 0L;
        }
        Long l3 = null;
        if (!TextUtils.isEmpty(videoInfo.getId()) && (id5 = videoInfo.getId()) != null) {
            l3 = Long.valueOf(RFWLayerVideoPlayPosRecorder.INSTANCE.getPlayPosition(id5));
        }
        if (l3 == null && !TextUtils.isEmpty(videoInfo.getUrl())) {
            l3 = Long.valueOf(a1(videoInfo.getUrl()));
        }
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView$d;", "Llh/c;", "", "onVideoLoopStart", "onVideoLoopEnd", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements lh.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QzoneFeedProVideoItemWidgetView> mWeakReference;

        public d(QzoneFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.c
        public void onVideoLoopStart() {
            QzoneFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
        }

        @Override // lh.c
        public void onVideoLoopEnd() {
        }
    }

    private final void X0() {
    }

    @Override // de.f
    public View d() {
        return this;
    }

    public final void setVideoStateBroadcastCallback(b callback) {
    }
}

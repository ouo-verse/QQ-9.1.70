package com.qzone.reborn.feedpro.widget.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.qzone.commoncode.module.gdt.QZoneAdVideoPlayReporter;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProSingleVideoWidgetView;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.util.m;
import com.qzone.util.ag;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lh.a;

@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 z2\u00020\u0001:\b\u001d{|}~\u007f\u0080\u0001B\u0011\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u00a2\u0006\u0004\bs\u0010tB\u001b\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u00a2\u0006\u0004\bs\u0010wB#\b\u0016\u0012\u0006\u0010r\u001a\u00020q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u0012\u0006\u0010x\u001a\u00020\u0012\u00a2\u0006\u0004\bs\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0016\u0010!\u001a\u00020\u00022\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\b\u0010#\u001a\u00020\"H\u0014J\u0010\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010$J\u0010\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)J\u0010\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\u0002H\u0014R\u0018\u00105\u001a\u0004\u0018\u0001028\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001e\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010J\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER$\u0010Q\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010X\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020i8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010kR\u0011\u0010o\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\bo\u0010p\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProSingleVideoWidgetView;", "", "W1", "V1", "Lcom/tencent/superplayer/api/ISuperPlayer;", "iSuperPlayer", "S1", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "T1", "", "url", "R1", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "feedPosition", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QCircleScheme.AttrDetail.VIDEO_INFO, "U1", "Lcom/qzone/reborn/feedx/video/c;", "options", "playUrlKey", "O0", "play", "pause", "a", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "listener", "setVideoCoverLoadStateListener", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "U0", "Ljava/lang/Runnable;", "videoStartPlayCallback", "setVideoStartPlayCallback", "videoStopCallback", "setVideoStopCallback", "Lcom/qzone/commoncode/module/gdt/f;", "videoProgressCallback", "setVideoProgressCallback", "Lcom/qzone/commoncode/module/gdt/e;", "videoLoopStartCallback", "setVideoLoopStartCallback", "", "Y0", "P0", "Lcom/tencent/gdtad/aditem/GdtAd;", "c0", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$b;", "d0", "Ljava/lang/ref/WeakReference;", "mVideoCompletionListener", "e0", "mVideoCoverLoadStateListener", "Lcom/qzone/commoncode/module/gdt/QZoneAdVideoPlayReporter;", "f0", "Lcom/qzone/commoncode/module/gdt/QZoneAdVideoPlayReporter;", "mVideoReporter", "g0", "Ljava/lang/Runnable;", "getMVideoStartPlayCallback", "()Ljava/lang/Runnable;", "setMVideoStartPlayCallback", "(Ljava/lang/Runnable;)V", "mVideoStartPlayCallback", "h0", "getMVideoStopCallback", "setMVideoStopCallback", "mVideoStopCallback", "i0", "Lcom/qzone/commoncode/module/gdt/f;", "Q1", "()Lcom/qzone/commoncode/module/gdt/f;", "setMVideoProgressCallback", "(Lcom/qzone/commoncode/module/gdt/f;)V", "mVideoProgressCallback", "j0", "Lcom/qzone/commoncode/module/gdt/e;", "P1", "()Lcom/qzone/commoncode/module/gdt/e;", "setMVideoLoopStartCallback", "(Lcom/qzone/commoncode/module/gdt/e;)V", "mVideoLoopStartCallback", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$d;", "k0", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$d;", "mCompletionListener", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$f;", "l0", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$f;", "mPlayerLooperListener", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$e;", "m0", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$e;", "mPlayErrorStatusListener", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$g;", "n0", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$g;", "mPlayerSeekListener", "", "O1", "()J", "durationMillis", "N1", "currentPositionMillis", "isPlaying", "()Z", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "o0", "b", "c", "d", "e", "f", "g", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneAdFeedProVideoItemWidgetView extends QzoneFeedProSingleVideoWidgetView {

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: p0, reason: collision with root package name */
    private static final String f54448p0 = "PSLink-QZoneAdFeedProVideoItemWidgetView";

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    protected GdtAd mAd;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b> mVideoCompletionListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private WeakReference<c> mVideoCoverLoadStateListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private QZoneAdVideoPlayReporter mVideoReporter;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private Runnable mVideoStartPlayCallback;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private Runnable mVideoStopCallback;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private com.qzone.commoncode.module.gdt.f mVideoProgressCallback;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private com.qzone.commoncode.module.gdt.e mVideoLoopStartCallback;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private d mCompletionListener;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private f mPlayerLooperListener;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private e mPlayErrorStatusListener;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private g mPlayerSeekListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$a;", "", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "weakReference", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProVideoItemWidgetView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final QZoneAdFeedProVideoItemWidgetView b(WeakReference<QZoneAdFeedProVideoItemWidgetView> weakReference) {
            if (weakReference == null) {
                QLog.e(QZoneAdFeedProVideoItemWidgetView.f54448p0, 1, "getAdVideoItemWidgetView  weakReference == null");
                return null;
            }
            QZoneAdFeedProVideoItemWidgetView qZoneAdFeedProVideoItemWidgetView = weakReference.get();
            if (qZoneAdFeedProVideoItemWidgetView != null) {
                return qZoneAdFeedProVideoItemWidgetView;
            }
            QLog.e(QZoneAdFeedProVideoItemWidgetView.f54448p0, 1, "getAdVideoItemWidgetView  widgetView == null");
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$b;", "Llh/a;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b extends a {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface c extends IPicLoadStateListener {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$d;", "Llh/a;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "iSuperPlayer", "", "onCompletion", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class d implements a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneAdFeedProVideoItemWidgetView> mWeakReference;

        public d(QZoneAdFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.a
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            Intrinsics.checkNotNullParameter(iSuperPlayer, "iSuperPlayer");
            QZoneAdFeedProVideoItemWidgetView b16 = QZoneAdFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            GdtAd gdtAd = b16.mAd;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long N1 = b16.N1();
            QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[onCompletion] aid:" + aId + " currentPosition:" + N1);
            b16.S1(iSuperPlayer);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$e;", "Llh/b;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onVideoPlayError", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class e implements lh.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneAdFeedProVideoItemWidgetView> mWeakReference;

        public e(QZoneAdFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.b
        public void onVideoPlayError(int module, int errorType, int errorCode, String extraInfo) {
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
            QZoneAdFeedProVideoItemWidgetView b16 = QZoneAdFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            GdtAd gdtAd = b16.mAd;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long N1 = b16.N1();
            QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[onVideoPlayError] aid:" + aId + " currentPosition:" + N1);
            QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = b16.mVideoReporter;
            if (qZoneAdVideoPlayReporter != null) {
                qZoneAdVideoPlayReporter.k(N1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$f;", "Llh/c;", "", "onVideoLoopStart", "onVideoLoopEnd", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class f implements lh.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneAdFeedProVideoItemWidgetView> mWeakReference;

        public f(QZoneAdFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.c
        public void onVideoLoopEnd() {
            QZoneAdFeedProVideoItemWidgetView b16 = QZoneAdFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            GdtAd gdtAd = b16.mAd;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long N1 = b16.N1();
            QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[onVideoLoopEnd] aid:" + aId + " currentPosition:" + N1);
            QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = b16.mVideoReporter;
            if (qZoneAdVideoPlayReporter != null) {
                qZoneAdVideoPlayReporter.m(b16.O1());
            }
        }

        @Override // lh.c
        public void onVideoLoopStart() {
            QZoneAdFeedProVideoItemWidgetView b16 = QZoneAdFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            GdtAd gdtAd = b16.mAd;
            long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long N1 = b16.N1();
            QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[onVideoLoopStart] aid:" + aId + " currentPosition:" + N1);
            QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = b16.mVideoReporter;
            if (qZoneAdVideoPlayReporter != null) {
                qZoneAdVideoPlayReporter.l(0L, false, true);
            }
            com.qzone.commoncode.module.gdt.e mVideoLoopStartCallback = b16.getMVideoLoopStartCallback();
            if (mVideoLoopStartCallback != null) {
                mVideoLoopStartCallback.a();
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$g;", "Llh/h;", "Landroid/widget/SeekBar;", "seekBar", "", "onStartTrackingTouch", "onStopTrackingTouch", "", "progress", "", "fromUser", "onSeekBarProgressChanged", "", "timeString", "videoDuration", "currentDuration", "onProgress", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "widgetView", "<init>", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class g implements lh.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneAdFeedProVideoItemWidgetView> mWeakReference;

        public g(QZoneAdFeedProVideoItemWidgetView widgetView) {
            Intrinsics.checkNotNullParameter(widgetView, "widgetView");
            this.mWeakReference = new WeakReference<>(widgetView);
        }

        @Override // lh.h
        public void onProgress(String timeString, int videoDuration, int currentDuration) {
            String traceId;
            Intrinsics.checkNotNullParameter(timeString, "timeString");
            QZoneAdFeedProVideoItemWidgetView b16 = QZoneAdFeedProVideoItemWidgetView.INSTANCE.b(this.mWeakReference);
            if (b16 == null) {
                return;
            }
            GdtAd gdtAd = b16.mAd;
            if (gdtAd != null && (traceId = gdtAd.getTraceId()) != null) {
                QZoneAdFeedUtils.f55717a.f0(traceId, currentDuration);
            }
            com.qzone.commoncode.module.gdt.f mVideoProgressCallback = b16.getMVideoProgressCallback();
            if (mVideoProgressCallback != null) {
                mVideoProgressCallback.onProgress(currentDuration);
            }
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$h", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class h implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPicLoadStateListener f54465d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneAdFeedProVideoItemWidgetView f54466e;

        h(IPicLoadStateListener iPicLoadStateListener, QZoneAdFeedProVideoItemWidgetView qZoneAdFeedProVideoItemWidgetView) {
            this.f54465d = iPicLoadStateListener;
            this.f54466e = qZoneAdFeedProVideoItemWidgetView;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState state, Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            this.f54465d.onStateChange(state, option);
            this.f54466e.T1(state, option);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$i", "Lkh/c;", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "superPlayerOption", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class i extends kh.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.commoncode.module.gdt.d f54467d;

        i(com.qzone.commoncode.module.gdt.d dVar) {
            this.f54467d = dVar;
        }

        @Override // kh.c
        public void b(SuperPlayerOption superPlayerOption, ISuperPlayer superPlayer) {
            Intrinsics.checkNotNullParameter(superPlayerOption, "superPlayerOption");
            Intrinsics.checkNotNullParameter(superPlayer, "superPlayer");
            super.b(superPlayerOption, superPlayer);
            QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[updateSettingsForP2PAndPCDN][beforeOpenMedia]");
            SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
            superPlayerDownOption.pcdnChargeId = "pcdn_ad_qqkj";
            com.qzone.commoncode.module.gdt.d dVar = this.f54467d;
            superPlayerDownOption.enablePcdn = dVar.f46207a;
            int i3 = dVar.f46208b;
            int i16 = dVar.f46209c;
            int i17 = dVar.f46210d;
            superPlayer.setBusinessDownloadStrategy(i3, i16, i17, i17);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProVideoItemWidgetView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N1() {
        return getMVideoInfo() != null ? Z0(getMVideoInfo()) : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long O1() {
        CommonVideo mVideoInfo = getMVideoInfo();
        return mVideoInfo != null ? mVideoInfo.getVideoTime() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    private final void R1(final String url) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProVideoItemWidgetView$loadVideoFirstFrame$1
            @Override // java.lang.Runnable
            public void run() {
                ImageView mImageView = QZoneAdFeedProVideoItemWidgetView.this.getMImageView();
                if (mImageView != null) {
                    mImageView.setImageDrawable(m.f59551a.b(QZoneAdFeedProVideoItemWidgetView.this.getContext()));
                }
            }
        });
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProVideoItemWidgetView$loadVideoFirstFrame$2
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(QZoneAdFeedProVideoItemWidgetView.f54448p0, 2, "[loadVideoFirstFrame]");
                ImageView mImageView = QZoneAdFeedProVideoItemWidgetView.this.getMImageView();
                Bitmap d16 = ag.d(url);
                Intrinsics.checkNotNullExpressionValue(d16, "getFirstFrame(url)");
                String u16 = ag.u(d16);
                Intrinsics.checkNotNullExpressionValue(u16, "saveBitmapToLocal(thumbBitmap)");
                Option obtain = Option.obtain();
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
                obtain.setLocalPath(u16);
                m mVar = m.f59551a;
                obtain.setLoadingDrawable(mVar.b(QZoneAdFeedProVideoItemWidgetView.this.getContext()));
                obtain.setFailDrawable(mVar.a(QZoneAdFeedProVideoItemWidgetView.this.getContext()));
                obtain.setTargetView(mImageView);
                c.a().i(obtain, QZoneAdFeedProVideoItemWidgetView.this.U0());
                if (QZoneAdFeedProVideoItemWidgetView.this.g1().getSuperPlayer() == null || !QZoneAdFeedProVideoItemWidgetView.this.g1().getSuperPlayer().isPlaying()) {
                    QZoneAdFeedProVideoItemWidgetView.this.t1(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(ISuperPlayer iSuperPlayer) {
        WeakReference<b> weakReference = this.mVideoCompletionListener;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar == null) {
            return;
        }
        bVar.onCompletion(iSuperPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(LoadState state, Option option) {
        WeakReference<c> weakReference = this.mVideoCoverLoadStateListener;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (cVar == null) {
            return;
        }
        cVar.onStateChange(state, option);
    }

    private final void V1() {
        QLog.i(f54448p0, 2, "[updateReporter]");
        this.mVideoReporter = new QZoneAdVideoPlayReporter(this.mAd, 1, O1());
    }

    private final void W1() {
        Object obj;
        com.qzone.commoncode.module.gdt.d dVar = new com.qzone.commoncode.module.gdt.d(this.mAd);
        String str = f54448p0;
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            obj = Long.valueOf(gdtAd.getAId());
        } else {
            obj = "";
        }
        QLog.i(str, 2, "[updateSettingsForP2PAndPCDN] aid:" + obj + " enablePCDN:" + dVar.f46207a + " emergencyTimeSeconds:" + dVar.f46208b + " safePlayTimeSeconds:" + dVar.f46209c + " preloadDurationSeconds:" + dVar.f46210d);
        if (!dVar.a()) {
            QLog.i(str, 1, "[updateSettingsForP2PAndPCDN] error, not valid");
            g1().setDynamicPlayerInterceptor(null);
        } else if (!dVar.f46207a) {
            QLog.i(str, 1, "[updateSettingsForP2PAndPCDN] P2P and PCDN not enabled");
            g1().setDynamicPlayerInterceptor(null);
        } else {
            g1().setDynamicPlayerInterceptor(new i(dVar));
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView
    protected void O0(com.qzone.reborn.feedx.video.c options, String playUrlKey) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(playUrlKey, "playUrlKey");
        super.O0(options, playUrlKey);
        if (options.b() == null) {
            QLog.e(f54448p0, 1, "[addCallback] error");
            return;
        }
        this.mCompletionListener = new d(this);
        options.b().a(this.mCompletionListener);
        this.mPlayerLooperListener = new f(this);
        options.b().c(this.mPlayerLooperListener);
        this.mPlayErrorStatusListener = new e(this);
        options.b().b(this.mPlayErrorStatusListener);
        this.mPlayerSeekListener = new g(this);
        options.b().h(this.mPlayerSeekListener);
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView
    protected void P0() {
        String url;
        CommonImage cover;
        CommonPicUrl e16;
        CommonVideo mVideoInfo = getMVideoInfo();
        if (TextUtils.isEmpty((mVideoInfo == null || (cover = mVideoInfo.getCover()) == null || (e16 = xd.d.e(cover)) == null) ? null : e16.getUrl())) {
            QLog.e(f54448p0, 1, "bindCoverData params is null");
            CommonVideo mVideoInfo2 = getMVideoInfo();
            if (mVideoInfo2 == null || (url = mVideoInfo2.getUrl()) == null) {
                return;
            }
            R1(url);
            return;
        }
        super.P0();
    }

    /* renamed from: P1, reason: from getter */
    public final com.qzone.commoncode.module.gdt.e getMVideoLoopStartCallback() {
        return this.mVideoLoopStartCallback;
    }

    /* renamed from: Q1, reason: from getter */
    public final com.qzone.commoncode.module.gdt.f getMVideoProgressCallback() {
        return this.mVideoProgressCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView
    public IPicLoadStateListener U0() {
        return new h(super.U0(), this);
    }

    public final void U1(CommonFeed feedData, int feedPosition, CommonMedia videoInfo) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        setFeedData(feedData);
        yd.a h16 = xd.c.h(feedData);
        this.mAd = h16 != null ? h16.getGdtAd() : null;
        setFeedPosition(feedPosition);
        Q0(videoInfo);
        W1();
        V1();
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView
    public boolean Y0() {
        return false;
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView, de.f
    public void a() {
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter;
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.mAd;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long N1 = N1();
        QLog.i(f54448p0, 2, "[releasePlayer] aid:" + aId + " currentPosition:" + N1 + " isPlaying:" + isPlaying);
        super.a();
        if (!isPlaying || (qZoneAdVideoPlayReporter = this.mVideoReporter) == null) {
            return;
        }
        qZoneAdVideoPlayReporter.m(N1);
    }

    public final boolean isPlaying() {
        QZoneVideoView g16 = g1();
        return (g16 != null ? g16.getSuperPlayer() : null) != null && g1().getSuperPlayer().isPlaying();
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView, de.f
    public void pause() {
        Runnable runnable;
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter;
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.mAd;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long N1 = N1();
        QLog.i(f54448p0, 2, "[pause] aid:" + aId + " currentPosition:" + N1 + " isPlaying:" + isPlaying);
        super.pause();
        if (isPlaying && (qZoneAdVideoPlayReporter = this.mVideoReporter) != null) {
            qZoneAdVideoPlayReporter.m(N1);
        }
        if (!isPlaying || (runnable = this.mVideoStopCallback) == null) {
            return;
        }
        runnable.run();
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView, de.f
    public void play() {
        Runnable runnable;
        QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter;
        boolean isPlaying = isPlaying();
        GdtAd gdtAd = this.mAd;
        long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        long N1 = N1();
        QLog.i(f54448p0, 2, "[play] aid:" + aId + " currentPosition:" + N1 + " isPlaying:" + isPlaying);
        super.play();
        if (!isPlaying && (qZoneAdVideoPlayReporter = this.mVideoReporter) != null) {
            qZoneAdVideoPlayReporter.l(N1, false, false);
        }
        if (isPlaying || (runnable = this.mVideoStartPlayCallback) == null) {
            return;
        }
        runnable.run();
    }

    public final void setMVideoLoopStartCallback(com.qzone.commoncode.module.gdt.e eVar) {
        this.mVideoLoopStartCallback = eVar;
    }

    public final void setMVideoProgressCallback(com.qzone.commoncode.module.gdt.f fVar) {
        this.mVideoProgressCallback = fVar;
    }

    public final void setMVideoStartPlayCallback(Runnable runnable) {
        this.mVideoStartPlayCallback = runnable;
    }

    public final void setMVideoStopCallback(Runnable runnable) {
        this.mVideoStopCallback = runnable;
    }

    public final void setVideoCoverLoadStateListener(WeakReference<c> listener) {
        this.mVideoCoverLoadStateListener = listener;
    }

    public final void setVideoLoopStartCallback(com.qzone.commoncode.module.gdt.e videoLoopStartCallback) {
        this.mVideoLoopStartCallback = videoLoopStartCallback;
    }

    public final void setVideoProgressCallback(com.qzone.commoncode.module.gdt.f videoProgressCallback) {
        this.mVideoProgressCallback = videoProgressCallback;
    }

    public final void setVideoStartPlayCallback(Runnable videoStartPlayCallback) {
        this.mVideoStartPlayCallback = videoStartPlayCallback;
    }

    public final void setVideoStopCallback(Runnable videoStopCallback) {
        this.mVideoStopCallback = videoStopCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProVideoItemWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdFeedProVideoItemWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

package com.tencent.mobileqq.tvideo.presenter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeDataEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandFullScreenEvent;
import com.tencent.mobileqq.tvideo.pr.TVideoPrFloatShowShowEvent;
import com.tencent.mobileqq.tvideo.view.TVideoSettingDefinitionView;
import com.tencent.mobileqq.tvideo.view.TVideoSettingSkipHeadTailView;
import com.tencent.mobileqq.tvideo.view.TVideoSettingSpeedChooseView;
import com.tencent.mobileqq.tvideo.view.morepanel.TVideoBrightnessBarView;
import com.tencent.mobileqq.tvideo.view.morepanel.TVideoVolumeBarView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;
import vx2.Definition;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u001c\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00190\u0018j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019`\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/bb;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "q1", "x1", "B1", "p1", "A1", "", "show", "z1", "Ltvideo/VideoPlotDetails;", "videoPlotDetails", "o1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "Landroid/view/ViewStub;", "I", "Landroid/view/ViewStub;", "settingViewStub", "J", "Landroid/view/View;", "settingView", "K", "scrollView", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "moreView", "M", "episodeView", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSpeedChooseView;", "N", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSpeedChooseView;", "speedChooseView", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSkipHeadTailView;", "P", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSkipHeadTailView;", "skipHeadTailView", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingDefinitionView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingDefinitionView;", "definitionView", "Lcom/tencent/mobileqq/tvideo/view/morepanel/TVideoVolumeBarView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/tvideo/view/morepanel/TVideoVolumeBarView;", "volumeBarView", "Lcom/tencent/mobileqq/tvideo/view/morepanel/TVideoBrightnessBarView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/tvideo/view/morepanel/TVideoBrightnessBarView;", "brightnessBarView", "Lvx2/a;", "T", "Lvx2/a;", "currentDefinition", "", "U", "Ljava/util/List;", "supportedDefinition", "Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;", "V", "Lcom/tencent/biz/qqcircle/immersive/views/QFSTVKVideoView;", "playerView", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class bb extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ViewStub settingViewStub;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View settingView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View scrollView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView moreView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View episodeView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TVideoSettingSpeedChooseView speedChooseView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TVideoSettingSkipHeadTailView skipHeadTailView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TVideoSettingDefinitionView definitionView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TVideoVolumeBarView volumeBarView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private TVideoBrightnessBarView brightnessBarView;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Definition currentDefinition;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private List<Definition> supportedDefinition;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private QFSTVKVideoView playerView;

    private final void A1() {
        VideoReport.setElementParams(this.moreView, gy2.c.g());
        VideoReport.setElementExposePolicy(this.moreView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.moreView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.moreView, "more");
    }

    private final void B1() {
        View view = this.settingView;
        if (view != null) {
            view.setVisibility(0);
        }
        TVideoVolumeBarView tVideoVolumeBarView = this.volumeBarView;
        if (tVideoVolumeBarView != null) {
            tVideoVolumeBarView.k();
        }
        TVideoBrightnessBarView tVideoBrightnessBarView = this.brightnessBarView;
        if (tVideoBrightnessBarView != null) {
            tVideoBrightnessBarView.k();
        }
        T0(new wx2.e(true));
        z1(false);
    }

    private final void o1(VideoPlotDetails videoPlotDetails) {
        int i3;
        List<VideoPlot> list;
        if (videoPlotDetails != null && (list = videoPlotDetails.video_plot_list) != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            View view = this.episodeView;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.episodeView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void p1() {
        View view = this.settingView;
        if (view != null) {
            view.setVisibility(8);
        }
        TVideoVolumeBarView tVideoVolumeBarView = this.volumeBarView;
        if (tVideoVolumeBarView != null) {
            tVideoVolumeBarView.j();
        }
        TVideoBrightnessBarView tVideoBrightnessBarView = this.brightnessBarView;
        if (tVideoBrightnessBarView != null) {
            tVideoBrightnessBarView.j();
        }
        T0(new wx2.e(false));
        z1(true);
    }

    private final void q1() {
        TVideoSettingSpeedChooseView tVideoSettingSpeedChooseView;
        TVideoSettingSkipHeadTailView tVideoSettingSkipHeadTailView;
        TVideoSettingDefinitionView tVideoSettingDefinitionView;
        TVideoVolumeBarView tVideoVolumeBarView;
        View view;
        if (this.settingView != null) {
            return;
        }
        ViewStub viewStub = this.settingViewStub;
        TVideoBrightnessBarView tVideoBrightnessBarView = null;
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            this.settingView = inflate;
            if (inflate != null) {
                view = inflate.findViewById(R.id.f83874kq);
            } else {
                view = null;
            }
            this.scrollView = view;
        }
        View view2 = this.scrollView;
        if (view2 != null) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.tvideo.presenter.aw
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean r16;
                    r16 = bb.r1(bb.this, view3, motionEvent);
                    return r16;
                }
            });
        }
        View view3 = this.settingView;
        if (view3 != null) {
            tVideoSettingSpeedChooseView = (TVideoSettingSpeedChooseView) view3.findViewById(R.id.f87274tx);
        } else {
            tVideoSettingSpeedChooseView = null;
        }
        this.speedChooseView = tVideoSettingSpeedChooseView;
        if (tVideoSettingSpeedChooseView != null) {
            tVideoSettingSpeedChooseView.setOnSpeedChangedCallback(new Consumer() { // from class: com.tencent.mobileqq.tvideo.presenter.ax
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    bb.s1(bb.this, (Float) obj);
                }
            });
        }
        View view4 = this.settingView;
        if (view4 != null) {
            tVideoSettingSkipHeadTailView = (TVideoSettingSkipHeadTailView) view4.findViewById(R.id.f86104qr);
        } else {
            tVideoSettingSkipHeadTailView = null;
        }
        this.skipHeadTailView = tVideoSettingSkipHeadTailView;
        if (tVideoSettingSkipHeadTailView != null) {
            tVideoSettingSkipHeadTailView.setOnSkipChangedCallback(new Consumer() { // from class: com.tencent.mobileqq.tvideo.presenter.ay
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    bb.t1(bb.this, (Boolean) obj);
                }
            });
        }
        View view5 = this.settingView;
        if (view5 != null) {
            tVideoSettingDefinitionView = (TVideoSettingDefinitionView) view5.findViewById(R.id.uft);
        } else {
            tVideoSettingDefinitionView = null;
        }
        this.definitionView = tVideoSettingDefinitionView;
        if (tVideoSettingDefinitionView != null) {
            tVideoSettingDefinitionView.setOnDefinitionChangedCallback(new Consumer() { // from class: com.tencent.mobileqq.tvideo.presenter.az
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    bb.u1(bb.this, (Definition) obj);
                }
            });
        }
        View view6 = this.settingView;
        if (view6 != null) {
            tVideoVolumeBarView = (TVideoVolumeBarView) view6.findViewById(R.id.f12023790);
        } else {
            tVideoVolumeBarView = null;
        }
        this.volumeBarView = tVideoVolumeBarView;
        View view7 = this.settingView;
        if (view7 != null) {
            tVideoBrightnessBarView = (TVideoBrightnessBarView) view7.findViewById(R.id.tbo);
        }
        this.brightnessBarView = tVideoBrightnessBarView;
        x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.ba
            @Override // java.lang.Runnable
            public final void run() {
                bb.this.x1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1(bb this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((motionEvent.getAction() & 255) == 1) {
            this$0.p1();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(bb this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T0(new wx2.h(it.floatValue()));
        this$0.p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(bb this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T0(new wx2.g(it.booleanValue()));
        hy2.a.f406605a.d(it.booleanValue());
        this$0.p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(bb this$0, Definition it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T0(new wx2.b(it));
        this$0.currentDefinition = it;
        this$0.p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(bb this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q1();
        this$0.B1();
        VideoReport.reportEvent("clck", this$0.moreView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandFullScreenEvent(true));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.at
            @Override // java.lang.Runnable
            public final void run() {
                bb.y1(bb.this);
            }
        });
        TVideoSettingSkipHeadTailView tVideoSettingSkipHeadTailView = this.skipHeadTailView;
        if (tVideoSettingSkipHeadTailView != null) {
            tVideoSettingSkipHeadTailView.setSkipState(hy2.a.f406605a.b());
        }
        List<Definition> list = this.supportedDefinition;
        if (list != null && this.currentDefinition != null) {
            TVideoSettingDefinitionView tVideoSettingDefinitionView = this.definitionView;
            if (tVideoSettingDefinitionView != null) {
                tVideoSettingDefinitionView.f(list);
            }
            TVideoSettingDefinitionView tVideoSettingDefinitionView2 = this.definitionView;
            if (tVideoSettingDefinitionView2 != null) {
                tVideoSettingDefinitionView2.setCurrentDefinition(this.currentDefinition);
            }
        }
        o1((VideoPlotDetails) this.E.b("tvideo_episode_blockdara_transform"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(bb this$0) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TVideoSettingSpeedChooseView tVideoSettingSpeedChooseView = this$0.speedChooseView;
        if (tVideoSettingSpeedChooseView != null) {
            QFSTVKVideoView qFSTVKVideoView = this$0.playerView;
            if (qFSTVKVideoView != null) {
                f16 = qFSTVKVideoView.getPlayRate();
            } else {
                f16 = 1.0f;
            }
            tVideoSettingSpeedChooseView.f(f16);
        }
    }

    private final void z1(boolean show) {
        TVideoPrFloatShowShowEvent tVideoPrFloatShowShowEvent = new TVideoPrFloatShowShowEvent();
        tVideoPrFloatShowShowEvent.setShow(show);
        SimpleEventBus.getInstance().dispatchEvent(tVideoPrFloatShowShowEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        if (event instanceof wx2.d) {
            wx2.d dVar = (wx2.d) event;
            this.supportedDefinition = dVar.b();
            this.currentDefinition = dVar.getCurrentDefinition();
            TVideoSettingDefinitionView tVideoSettingDefinitionView = this.definitionView;
            if (tVideoSettingDefinitionView != null) {
                tVideoSettingDefinitionView.f(this.supportedDefinition);
            }
            TVideoSettingDefinitionView tVideoSettingDefinitionView2 = this.definitionView;
            if (tVideoSettingDefinitionView2 != null) {
                tVideoSettingDefinitionView2.setCurrentDefinition(this.currentDefinition);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        this.settingViewStub = (ViewStub) rootView.findViewById(R.id.f112756os);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f56792lk);
        this.moreView = imageView;
        jy2.f.f411169a.j(imageView, "https://ugd.gtimg.com//vg/1678695273961_tvideo_more.png");
        ImageView imageView2 = this.moreView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.au
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bb.v1(bb.this, view);
                }
            });
        }
        View findViewById = rootView.findViewById(R.id.f56782lj);
        this.episodeView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.av
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bb.w1(view);
                }
            });
        }
        this.playerView = (QFSTVKVideoView) rootView.findViewById(R.id.f74163vi);
        A1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSTVideoEpisodeDataEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        x1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        this.supportedDefinition = null;
        this.currentDefinition = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoEpisodeDataEvent) {
            o1(((QFSTVideoEpisodeDataEvent) simpleBaseEvent).getVideoPlotDetails());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoSettingPresenter";
    }
}

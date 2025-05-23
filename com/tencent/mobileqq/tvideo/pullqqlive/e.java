package com.tencent.mobileqq.tvideo.pullqqlive;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.pullqqlive.h;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/tvideo/pullqqlive/e;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "r1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ICustomDataEditor.STRING_PARAM_1, "view", "w1", "o1", "", "m1", "", "l1", "v1", "", "", "k1", ICustomDataEditor.NUMBER_PARAM_1, "w0", "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "I", "Landroid/view/View;", "verticalRootView", "Ltvideo/Video;", "J", "Ltvideo/Video;", "videoFeed", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "landscapeDmButton", "<init>", "()V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View verticalRootView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Video videoFeed;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView landscapeDmButton;

    private final Map<String, Object> k1() {
        String str;
        Map<String, Object> i3 = gy2.c.i(this.videoFeed);
        Intrinsics.checkNotNullExpressionValue(i3, "buildElementParams(videoFeed)");
        if (h.h(m0())) {
            str = "1";
        } else {
            str = "0";
        }
        i3.put("is_install_txsp", str);
        return i3;
    }

    private final boolean l1() {
        if (this.f85018i == h.e() && h.f() && h.d()) {
            return true;
        }
        return false;
    }

    private final String m1() {
        VideoBaseInfo videoBaseInfo;
        Video video = this.videoFeed;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            return videoBaseInfo.vid;
        }
        return null;
    }

    private final View n1() {
        if (ScreenUtils.isLandscape()) {
            return this.landscapeDmButton;
        }
        return this.verticalRootView;
    }

    private final void o1() {
        h.m(m0(), m1());
        VideoReport.reportEvent("clck", n1(), k1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(e this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.r1();
        } else {
            this$0.v1();
        }
        if (this$0.l1()) {
            if (h.h(this$0.m0())) {
                h.o();
                h.m(this$0.m0(), this$0.m1());
            }
            View n16 = this$0.n1();
            if (n16 == null) {
                n16 = this$0.C.findViewById(R.id.f41041g0);
                this$0.w1(n16);
            }
            VideoReport.reportEvent("clck", n16, this$0.k1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(e this$0, View rootView, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        if (z16) {
            this$0.s1(rootView);
        }
    }

    private final void r1() {
        View view = this.verticalRootView;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.landscapeDmButton;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void s1(View rootView) {
        ImageView imageView;
        View findViewById = rootView.findViewById(R.id.f41041g0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026fs_feed_pull_qqlive_stub)");
        this.verticalRootView = ((ViewStub) findViewById).inflate();
        this.landscapeDmButton = (ImageView) rootView.findViewById(R.id.f56822ln);
        View view = this.verticalRootView;
        if (view != null) {
            imageView = (ImageView) view.findViewById(R.id.f41021fy);
        } else {
            imageView = null;
        }
        View view2 = this.verticalRootView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ImageView imageView2 = this.landscapeDmButton;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        jy2.f fVar = jy2.f.f411169a;
        fVar.j(this.landscapeDmButton, "https://ugd.gtimg.com/vg/1688457976198_%25E8%25B7%25AF%25E5%25BE%2584%25202.png");
        fVar.j(imageView, "https://ugd.gtimg.com/vg/1688457976198_%25E8%25B7%25AF%25E5%25BE%2584%25202.png");
        ImageView imageView3 = this.landscapeDmButton;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    e.t1(e.this, view3);
                }
            });
        }
        View view3 = this.verticalRootView;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    e.u1(e.this, view4);
                }
            });
        }
        w1(this.landscapeDmButton);
        w1(this.verticalRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v1() {
        View view = this.verticalRootView;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.landscapeDmButton;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (!jy2.g.E((FeedCloudMeta$StFeed) this.f85017h) && !jy2.g.z((FeedCloudMeta$StFeed) this.f85017h)) {
            VideoReport.reportEvent("imp", n1(), k1());
        }
    }

    private final void w1(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "open_txsp");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        h.i(new h.a() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.b
            @Override // com.tencent.mobileqq.tvideo.pullqqlive.h.a
            public final void a(boolean z16) {
                e.q1(e.this, rootView, z16);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        h.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        this.videoFeed = jy2.g.q((FeedCloudMeta$StFeed) this.f85017h);
        h.i(new h.a() { // from class: com.tencent.mobileqq.tvideo.pullqqlive.a
            @Override // com.tencent.mobileqq.tvideo.pullqqlive.h.a
            public final void a(boolean z16) {
                e.p1(e.this, z16);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "TVideoPullQQLivePresenter";
    }
}

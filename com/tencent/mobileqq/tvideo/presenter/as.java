package com.tencent.mobileqq.tvideo.presenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.MainThread;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0003J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/as;", "Lcom/tencent/mobileqq/tvideo/presenter/af;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/s;", "event", "", "r1", "", "module", "errorCode", "", "p1", "t1", ICustomDataEditor.STRING_PARAM_1, "w1", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "C0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedUnSelected", "Landroid/view/ViewStub;", "L", "Landroid/view/ViewStub;", "errorViewStub", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "descView", "N", "retryView", "P", "Landroid/view/View;", "errorView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "loadingView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class as extends af {

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ViewStub errorViewStub;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView descView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView retryView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View errorView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    private final String p1(int module, int errorCode) {
        return "(" + module + "." + errorCode + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(as this$0, com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r1((com.tencent.biz.qqcircle.immersive.feed.event.s) hVar);
    }

    @MainThread
    private final void r1(com.tencent.biz.qqcircle.immersive.feed.event.s event) {
        t1();
        View view = this.errorView;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.descView;
        if (textView != null) {
            textView.setText(p1(event.e(), event.a()));
        }
        View view2 = this.loadingView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        l1();
    }

    private final void s1() {
        View view = this.errorView;
        if (view != null) {
            view.setVisibility(8);
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.t(true));
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private final void t1() {
        TextView textView;
        TextView textView2;
        if (this.errorView != null) {
            return;
        }
        ViewStub viewStub = this.errorViewStub;
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            this.errorView = inflate;
            if (inflate != null) {
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.aq
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        as.u1(view);
                    }
                });
            }
            View view = this.errorView;
            View view2 = null;
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.uwq);
            } else {
                textView = null;
            }
            this.descView = textView;
            View view3 = this.errorView;
            if (view3 != null) {
                textView2 = (TextView) view3.findViewById(R.id.i9c);
            } else {
                textView2 = null;
            }
            this.retryView = textView2;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.ar
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        as.v1(as.this, view4);
                    }
                });
            }
            View view4 = this.errorView;
            if (view4 != null) {
                view2 = view4.findViewById(R.id.uwp);
            }
            i1(view2, this.errorView);
        }
        w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(as this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s1();
        VideoReport.reportEvent("clck", this$0.retryView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w1() {
        VideoReport.setElementParams(this.retryView, gy2.c.g());
        VideoReport.setElementExposePolicy(this.retryView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.retryView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.retryView, "retry_loading");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable final com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        super.C0(event);
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.s) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.ap
                @Override // java.lang.Runnable
                public final void run() {
                    as.q1(as.this, event);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        this.errorViewStub = (ViewStub) rootView.findViewById(R.id.f112736oq);
        this.loadingView = rootView.findViewById(R.id.f112716oo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        View view;
        if (selectInfo != null && selectInfo.getPosition() == this.f85018i && (view = this.errorView) != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.af, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoPlayErrorPresenter";
    }
}

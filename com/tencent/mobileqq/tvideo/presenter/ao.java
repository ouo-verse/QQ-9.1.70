package com.tencent.mobileqq.tvideo.presenter;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/ao;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/ap;", "event", "", "i1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "C0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "leftBottomPlayBtn", "J", "Landroid/view/View;", "centerPlayBtn", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ao extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView leftBottomPlayBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View centerPlayBtn;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(ao this$0, com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i1((com.tencent.biz.qqcircle.immersive.feed.event.ap) hVar);
    }

    private final void i1(com.tencent.biz.qqcircle.immersive.feed.event.ap event) {
        if (event.b()) {
            jy2.f.f411169a.j(this.leftBottomPlayBtn, "https://ugd.gtimg.com//vg/1678696023610_tvideo_play.png");
            View view = this.centerPlayBtn;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        jy2.f.f411169a.j(this.leftBottomPlayBtn, "https://ugd.gtimg.com//vg/1678696061021_tvideo_pause.png");
        View view2 = this.centerPlayBtn;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable final com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.ap) {
            x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.an
                @Override // java.lang.Runnable
                public final void run() {
                    ao.h1(ao.this, event);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.leftBottomPlayBtn = (ImageView) rootView.findViewById(R.id.f56812lm);
        this.centerPlayBtn = rootView.findViewById(R.id.va5);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        View view = this.centerPlayBtn;
        if (view != null) {
            view.setVisibility(8);
        }
        jy2.f.f411169a.j(this.leftBottomPlayBtn, "https://ugd.gtimg.com//vg/1678696061021_tvideo_pause.png");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoPlayButtonPresenter";
    }
}

package com.tencent.biz.qqcircle.immersive.feed;

import androidx.annotation.CallSuper;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0017J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0017J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ab;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "", "onFeedSelected", "onFeedUnSelected", "", "w0", "onResumed", "", "h1", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class ab extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(ab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, this$0.m0()));
    }

    public boolean h1() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    @CallSuper
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        if (h1()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, m0()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    @CallSuper
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        if (h1()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, m0()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    @CallSuper
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (E0() & h1()) {
            x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ab.i1(ab.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLayerFeedDisableSlideRightPresenter";
    }
}

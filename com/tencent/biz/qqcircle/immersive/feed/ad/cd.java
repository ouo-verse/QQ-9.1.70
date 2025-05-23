package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAdItemView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/cd;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "state", "", "l1", "", "w0", "data", "", "position", "k1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onResumed", "onPaused", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "I", "Ljava/lang/String;", "TAG", "J", "Lfeedcloud/FeedCloudMeta$StFeed;", "mAdFeed", "Lcom/tencent/gdtad/aditem/GdtAd;", "K", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "L", "Z", "mIsFeedAdSupportLeftSlide", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class cd extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mAdFeed;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsFeedAdSupportLeftSlide;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "QFSFeedChildAdLeftSlidePresenter";

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private GdtAd mAd = new GdtAd();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(cd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(cd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1(this$0.mIsFeedAdSupportLeftSlide);
    }

    private final void l1(boolean state) {
        View view = this.C;
        if (view instanceof QFSLayerFeedAdItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAdItemView");
            ((QFSLayerFeedAdItemView) view).setEnableSlide(state);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@NotNull com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cb
                @Override // java.lang.Runnable
                public final void run() {
                    cd.i1(cd.this);
                }
            });
        } else if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cc
                @Override // java.lang.Runnable
                public final void run() {
                    cd.j1(cd.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.L0(data, position);
        this.mAdFeed = u.c(this.E);
        this.mAd = new GdtAd(u.e(this.E));
        e30.b bVar = this.E;
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        this.mIsFeedAdSupportLeftSlide = af.Y(feedCloudMeta$StFeed, this.mAdFeed, this.mAd);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        l1(this.mIsFeedAdSupportLeftSlide);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        l1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        l1(this.mIsFeedAdSupportLeftSlide);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }
}

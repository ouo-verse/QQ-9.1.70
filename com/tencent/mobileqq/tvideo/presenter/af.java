package com.tencent.mobileqq.tvideo.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenChangedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 !2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000bj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f`\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0004J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\b\u0010\u0019\u001a\u00020\tH\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/af;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "uiState", "", "k1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "", "onFeedSelected", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "", "w0", "Landroid/view/View;", "backView", "parentPannel", "i1", "h1", "l1", "I", "Landroid/view/View;", "mBackView", "J", "mParentPannel", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class af extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mBackView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View mParentPannel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(af this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context m06 = this$0.m0();
        Intrinsics.checkNotNull(m06, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) m06).setRequestedOrientation(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean k1(int uiState) {
        View view;
        if (ScreenUtils.isLandscape() && (view = this.mParentPannel) != null) {
            Intrinsics.checkNotNull(view);
            if (view.getVisibility() == 0 && uiState == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QFSTVideoScreenChangedEvent.class);
        return arrayList;
    }

    protected final void h1(int uiState) {
        if (this.mBackView == null) {
            return;
        }
        if (k1(uiState)) {
            View view = this.mBackView;
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
        } else {
            View view2 = this.mBackView;
            Intrinsics.checkNotNull(view2);
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i1(@Nullable View backView, @Nullable View parentPannel) {
        this.mBackView = backView;
        this.mParentPannel = parentPannel;
        Intrinsics.checkNotNull(backView);
        backView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                af.j1(af.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l1() {
        cy2.b.e().t();
        h1(0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@NotNull RFWFeedSelectInfo selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        super.onFeedSelected(selectInfo);
        View view = this.mBackView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            QLog.d(getTAG(), 4, "QCircleConfigChangeEvent");
            h1(cy2.b.e().f());
        } else if (simpleBaseEvent instanceof QFSTVideoScreenChangedEvent) {
            h1(((QFSTVideoScreenChangedEvent) simpleBaseEvent).getUiState());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        throw null;
    }
}

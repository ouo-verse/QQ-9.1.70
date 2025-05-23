package com.tencent.mobileqq.tvideo.presenter.intro;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoIntroEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.mobileqq.tvideo.event.TVideoHalfWebViewHideEvent;
import com.tencent.mobileqq.tvideo.pr.TVideoPrFloatShowShowEvent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.CollectionUtils;
import tvideo.VideoBriefIntro$VideoBriefIntroductionActorList;
import tvideo.VideoBriefIntro$VideoBriefIntroductionPage;
import tvideo.VideoBriefIntro$VideoBriefIntroductionText;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J(\u0010\r\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n`\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/intro/h;", "Lcom/tencent/mobileqq/tvideo/presenter/intro/QFSTVideoIntroPresenter;", "Ltvideo/VideoBriefIntro$VideoBriefIntroductionPage;", "response", "", "P1", "Q1", "", "o1", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "", "l1", ICustomDataEditor.NUMBER_PARAM_1, "J1", "m1", "Landroid/view/View;", "f0", "Landroid/view/View;", "gapView", "<init>", "()V", "g0", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends QFSTVideoIntroPresenter {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gapView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tvideo/presenter/intro/h$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getMSpace", "()I", "setMSpace", "(I)V", "mSpace", "<init>", "(Lcom/tencent/mobileqq/tvideo/presenter/intro/h;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mSpace;

        public b(int i3) {
            this.mSpace = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = this.mSpace;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean P1(VideoBriefIntro$VideoBriefIntroductionPage response) {
        VideoBriefIntro$VideoBriefIntroductionActorList videoBriefIntro$VideoBriefIntroductionActorList = response.actor_info;
        if (videoBriefIntro$VideoBriefIntroductionActorList != null && !CollectionUtils.isEmpty(videoBriefIntro$VideoBriefIntroductionActorList.actor_list.get())) {
            return false;
        }
        return true;
    }

    private final boolean Q1(VideoBriefIntro$VideoBriefIntroductionPage response) {
        VideoBriefIntro$VideoBriefIntroductionText videoBriefIntro$VideoBriefIntroductionText = response.text;
        if (videoBriefIntro$VideoBriefIntroductionText != null && !TextUtils.isEmpty(videoBriefIntro$VideoBriefIntroductionText.description.get())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter
    protected void J1(@NotNull VideoBriefIntro$VideoBriefIntroductionPage response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!TextUtils.isEmpty(response.poster.rating.get())) {
            this.K.setText(response.poster.rating.get());
            G1(this.L, "https://ugd.gtimg.com/vg/1685427910744_start.png");
        } else if (!TextUtils.isEmpty(response.poster.hotval.get())) {
            this.K.setText(response.poster.hotval.get());
            G1(this.L, "https://ugd.gtimg.com/vg/1685428129944_%25E7%259F%25A9%25E5%25BD%25A2.png");
        } else {
            this.J.findViewById(R.id.f80254az).setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoIntroEvent.class);
        arrayList.add(TVideoHalfWebViewHideEvent.class);
        arrayList.add(QFSTVideoPageWebViewShowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter
    protected int l1() {
        return R.id.f112706on;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter
    public void m1(@NotNull VideoBriefIntro$VideoBriefIntroductionPage response) {
        Intrinsics.checkNotNullParameter(response, "response");
        super.m1(response);
        if (!P1(response) && !Q1(response)) {
            View view = this.gapView;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.gapView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter
    protected void n1() {
        this.I.addItemDecoration(new b(cx.a(15.0f)));
        e eVar = new e();
        this.N = eVar;
        this.I.setAdapter(eVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(m0());
        linearLayoutManager.setOrientation(0);
        this.I.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter
    public void o1() {
        super.o1();
        this.f85016f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.N1(h.this, view);
            }
        });
        this.f85016f.findViewById(R.id.uij).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.O1(view);
            }
        });
        G1(this.M, "https://ugd.gtimg.com/vg/1685428916762_%25E7%259F%25A9%25E5%25BD%25A2.png");
        this.gapView = this.J.findViewById(R.id.vlb);
    }

    @Override // com.tencent.mobileqq.tvideo.presenter.intro.QFSTVideoIntroPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        if (this.f304703e0) {
            QLog.d("TVideoVerticalIntroPresenter", 1, "onReceiveEvent paused");
            return;
        }
        if (!E0()) {
            QLog.d("TVideoVerticalIntroPresenter", 1, "onReceiveEvent isFeedOnScreen false");
            return;
        }
        if (!ScreenUtils.isPortrait()) {
            QLog.d("TVideoVerticalIntroPresenter", 1, "onReceiveEvent isPortrait true");
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoIntroEvent) {
            QLog.d("TVideoVerticalIntroPresenter", 1, "onReceiveEvent QFSTVideoIntroEvent");
            B1();
            TVideoPrFloatShowShowEvent tVideoPrFloatShowShowEvent = new TVideoPrFloatShowShowEvent();
            tVideoPrFloatShowShowEvent.setShow(false);
            tVideoPrFloatShowShowEvent.setHandleLeftWebView(true);
            SimpleEventBus.getInstance().dispatchEvent(tVideoPrFloatShowShowEvent);
            return;
        }
        if ((simpleBaseEvent instanceof TVideoHalfWebViewHideEvent) || (simpleBaseEvent instanceof QFSTVideoPageWebViewShowEvent)) {
            t1();
        }
    }
}

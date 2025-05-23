package com.tencent.robot.discover.adapter.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/n;", "Lcom/tencent/robot/discover/adapter/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lk34/a;", "data", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "e", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "Ll34/d;", "f", "Ll34/d;", "listener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar searchBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private l34.d listener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l34.d dVar = this$0.listener;
        if (dVar != null) {
            dVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f7656420);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026bot_discovery_search_bar)");
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById;
        this.searchBar = qUISearchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setCustomResource(n34.e.f418127a.b());
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        this.listener = l34.e.d(mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable k34.a data, int position, @Nullable List<Object> payload) {
        int i3;
        QUISearchBar qUISearchBar = this.searchBar;
        QUISearchBar qUISearchBar2 = null;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar = null;
        }
        q(qUISearchBar, "em_search_bar", null);
        if (data instanceof k34.e) {
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            k34.e eVar = (k34.e) data;
            int i16 = 0;
            if (eVar.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            mRootView.setVisibility(i3);
            QUISearchBar qUISearchBar3 = this.searchBar;
            if (qUISearchBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar3 = null;
            }
            if (!eVar.getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String()) {
                i16 = 8;
            }
            qUISearchBar3.setVisibility(i16);
            QUISearchBar qUISearchBar4 = this.searchBar;
            if (qUISearchBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                qUISearchBar2 = qUISearchBar4;
            }
            qUISearchBar2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.u(n.this, view);
                }
            });
        }
    }
}

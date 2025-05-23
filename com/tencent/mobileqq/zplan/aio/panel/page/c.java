package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.zplan.aio.panel.page.view.PageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00198\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/c;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/zplan/aio/panel/page/c$a;", "g", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "source", "", "d", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "f", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "b", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "e", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;", "pageTheme", "", "c", "I", "getPageType", "()I", "pageType", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView$a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class c implements com.tencent.mobileqq.zplan.aio.panel.panel.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final PageView.Theme pageTheme;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int pageType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView;", "E", "Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView;", "l", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView;", "view", "<init>", "(Lcom/tencent/mobileqq/zplan/aio/panel/page/view/PageView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final PageView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PageView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        /* renamed from: l, reason: from getter */
        public final PageView getView() {
            return this.view;
        }
    }

    public c(CoroutineScope scope, PageView.Theme pageTheme) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(pageTheme, "pageTheme");
        this.scope = scope;
        this.pageTheme = pageTheme;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public void d(RecyclerView.ViewHolder viewHolder, StateFlow<? extends Page> source) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(source, "source");
        PageView view = ((a) viewHolder).getView();
        PageAdapter pageAdapter = new PageAdapter(source, this.pageTheme);
        pageAdapter.x0(source.getValue().j(pageAdapter));
        view.setAdapter(pageAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final PageView.Theme getPageTheme() {
        return this.pageTheme;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a c(RecyclerView parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        PageView pageView = new PageView(context, null, 0, 6, null);
        pageView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        pageView.setLayoutManager(new GridLayoutManager(parent.getContext(), this.pageTheme.getSpanCount()));
        return new a(pageView);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.panel.a
    public int getPageType() {
        return this.pageType;
    }
}

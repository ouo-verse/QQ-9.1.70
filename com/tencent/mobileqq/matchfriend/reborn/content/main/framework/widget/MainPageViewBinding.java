package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.refresh.MainRefreshHeader;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00198\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0014\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/a;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/a;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/a;", "f", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/a;)V", "mainPageCallBack", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "b", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "()Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "recyclerView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "c", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "()Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/TitleBarViewBinding;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/TitleBarViewBinding;", "e", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/TitleBarViewBinding;", "titleBarViewBinding", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "root", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainPageViewBinding {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a mainPageCallBack;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SkinnableRecycleView recyclerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SmartRefreshLayout refreshLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TitleBarViewBinding titleBarViewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout root;

    public MainPageViewBinding(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SkinnableRecycleView skinnableRecycleView = new SkinnableRecycleView(context);
        skinnableRecycleView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        skinnableRecycleView.setLayoutManager(new c(context));
        skinnableRecycleView.setOverScrollMode(2);
        skinnableRecycleView.setHasFixedSize(true);
        skinnableRecycleView.setItemAnimator(null);
        skinnableRecycleView.setClipChildren(false);
        skinnableRecycleView.setClipToPadding(false);
        this.recyclerView = skinnableRecycleView;
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, o.e(0));
        layoutParams.weight = 1.0f;
        smartRefreshLayout.setLayoutParams(layoutParams);
        smartRefreshLayout.a(false);
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.T(true);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        smartRefreshLayout.b(new MainRefreshHeader(context));
        smartRefreshLayout.addView(skinnableRecycleView);
        this.refreshLayout = smartRefreshLayout;
        this.titleBarViewBinding = new TitleBarViewBinding(context);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.MainPageViewBinding$root$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                setWillNotDraw(false);
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                a mainPageCallBack = this.getMainPageCallBack();
                if (mainPageCallBack != null) {
                    mainPageCallBack.D8(getDrawingTime());
                }
            }
        };
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LayoutInflater.from(context).inflate(R.layout.cxi, (ViewGroup) linearLayout, true);
        linearLayout.addView(smartRefreshLayout);
        this.root = linearLayout;
    }

    /* renamed from: a, reason: from getter */
    public final a getMainPageCallBack() {
        return this.mainPageCallBack;
    }

    /* renamed from: b, reason: from getter */
    public final SkinnableRecycleView getRecyclerView() {
        return this.recyclerView;
    }

    /* renamed from: c, reason: from getter */
    public final SmartRefreshLayout getRefreshLayout() {
        return this.refreshLayout;
    }

    /* renamed from: d, reason: from getter */
    public final LinearLayout getRoot() {
        return this.root;
    }

    /* renamed from: e, reason: from getter */
    public final TitleBarViewBinding getTitleBarViewBinding() {
        return this.titleBarViewBinding;
    }

    public final void f(a aVar) {
        this.mainPageCallBack = aVar;
    }
}

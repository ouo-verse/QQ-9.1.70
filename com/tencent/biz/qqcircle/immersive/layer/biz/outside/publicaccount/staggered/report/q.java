package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJL\u0010\u0016\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R(\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/q;", "", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "adapter", "Lcom/tencent/biz/qqcircle/scrollers/b;", "helper", "", "a", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "g", "Landroid/view/View;", "view", "i", "j", "f", "d", tl.h.F, "c", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "b", "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "getAdapter", "()Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "setAdapter", "(Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;)V", "Lcom/tencent/biz/qqcircle/scrollers/b;", "getHelper", "()Lcom/tencent/biz/qqcircle/scrollers/b;", "setHelper", "(Lcom/tencent/biz/qqcircle/scrollers/b;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseListViewAdapter<?> adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.scrollers.b helper;

    public final void a(@Nullable Context context, @Nullable RecyclerView recyclerView, @Nullable BaseListViewAdapter<?> adapter, @Nullable com.tencent.biz.qqcircle.scrollers.b helper) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.helper = helper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: b, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public void i(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void h() {
    }

    public void g(@Nullable RecyclerView recyclerView, int newState, @Nullable RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
    }
}

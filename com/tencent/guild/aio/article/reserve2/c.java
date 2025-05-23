package com.tencent.guild.aio.article.reserve2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.guild.aio.article.reserve2.GuildArticleReserve2UIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn0.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000f0\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/article/reserve2/c;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/guild/aio/article/reserve2/GuildArticleReserve2UIState;", "", "h1", "i1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "d1", "", "Ljava/lang/Class;", "getObserverStates", "state", "e1", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "mShowLoadingTask", "Lvn0/p;", "e", "Lvn0/p;", "mLoadingBinding", "Lmqq/util/WeakReference;", "Landroid/view/ViewGroup;", "f", "Lmqq/util/WeakReference;", "mLoadingViewRef", "<init>", "()V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<Object, GuildArticleReserve2UIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Runnable mShowLoadingTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private p mLoadingBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private WeakReference<ViewGroup> mLoadingViewRef;

    private final void f1() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = this.mShowLoadingTask;
        WeakReference<ViewGroup> weakReference = null;
        if (runnable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingTask");
            runnable = null;
        }
        uIHandlerV2.removeCallbacks(runnable);
        WeakReference<ViewGroup> weakReference2 = this.mLoadingViewRef;
        if (weakReference2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingViewRef");
        } else {
            weakReference = weakReference2;
        }
        final ViewGroup viewGroup = weakReference.get();
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            viewGroup.animate().alphaBy(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.tencent.guild.aio.article.reserve2.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.g1(viewGroup);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(ViewGroup it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.setVisibility(8);
    }

    private final void h1() {
        p pVar = this.mLoadingBinding;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBinding");
            pVar = null;
        }
        WeakReference<ViewGroup> weakReference = new WeakReference<>(pVar.getRoot());
        this.mLoadingViewRef = weakReference;
        ViewGroup viewGroup = weakReference.get();
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            viewGroup.setAlpha(0.0f);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.y3z);
            if (imageView != null) {
                Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(\u2026ild_article_loading_view)");
                imageView.setImageDrawable(com.tencent.mobileqq.guild.util.qqui.d.d(imageView.getContext(), 2));
            }
        }
    }

    private final void i1() {
        this.mShowLoadingTask = new Runnable() { // from class: com.tencent.guild.aio.article.reserve2.a
            @Override // java.lang.Runnable
            public final void run() {
                c.j1(c.this);
            }
        };
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = this.mShowLoadingTask;
        if (runnable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingTask");
            runnable = null;
        }
        uIHandlerV2.postDelayed(runnable, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<ViewGroup> weakReference = this$0.mLoadingViewRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingViewRef");
            weakReference = null;
        }
        ViewGroup viewGroup = weakReference.get();
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            viewGroup.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<Object, GuildArticleReserve2UIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildArticleReserve2UIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildArticleReserve2UIState.GuildArticleAIOHideLoadingUIState) {
            f1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildArticleReserve2UIState>> getObserverStates() {
        List<Class<? extends GuildArticleReserve2UIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildArticleReserve2UIState.GuildArticleAIOHideLoadingUIState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        p g16 = p.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.mLoadingBinding = g16;
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1);
        p pVar = this.mLoadingBinding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBinding");
            pVar = null;
        }
        pVar.getRoot().setLayoutParams(a16);
        h1();
        i1();
        p pVar3 = this.mLoadingBinding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingBinding");
        } else {
            pVar2 = pVar3;
        }
        FrameLayout root = pVar2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mLoadingBinding.root");
        return root;
    }
}

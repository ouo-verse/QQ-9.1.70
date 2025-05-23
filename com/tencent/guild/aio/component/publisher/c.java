package com.tencent.guild.aio.component.publisher;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.publisher.GuildPostMediaUIState;
import com.tencent.guild.aio.component.publisher.a;
import com.tencent.guild.api.input.INTPostMediaRecyclerViewApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/publisher/a;", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaViewModel;", "c1", "", "bindViewAndData", "e1", "state", "d1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", TtmlNode.TAG_LAYOUT, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "e", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "mAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildPostMediaUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout layout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.Adapter<?> mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter<?> adapter = this$0.mAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            adapter = null;
        }
        adapter.notifyDataSetChanged();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        RecyclerView.Adapter<?> adapter = this.mAdapter;
        RecyclerView recyclerView = null;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            adapter = null;
        }
        sendIntent(new a.C1181a(adapter));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setBackgroundColor(getMContext().getResources().getColor(R.color.guild_media_preview_bg));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public GuildPostMediaViewModel createVM() {
        return new GuildPostMediaViewModel();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildPostMediaUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView recyclerView = null;
        if (state instanceof GuildPostMediaUIState.RefreshPostMedia) {
            if (!((GuildPostMediaUIState.RefreshPostMedia) state).a().isEmpty()) {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                recyclerView.setVisibility(0);
                e1();
                return;
            }
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(8);
            return;
        }
        if (state instanceof GuildPostMediaUIState.HidePostMedia) {
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.setVisibility(8);
        }
    }

    public final void e1() {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView.Adapter<?> adapter = null;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.isComputingLayout()) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.post(new Runnable() { // from class: com.tencent.guild.aio.component.publisher.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f1(c.this);
                }
            });
            return;
        }
        RecyclerView.Adapter<?> adapter2 = this.mAdapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            adapter = adapter2;
        }
        adapter.notifyDataSetChanged();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.mAdapter = d.a().getPostMediaAdapter(getMContext());
        INTPostMediaRecyclerViewApi a16 = d.a();
        Context mContext = getMContext();
        RecyclerView.Adapter<?> adapter = this.mAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            adapter = null;
        }
        this.recyclerView = a16.getPostMediaRecyclerView(mContext, adapter);
        FrameLayout frameLayout = new FrameLayout(getMContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        frameLayout.addView(recyclerView, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(96.0f)));
        this.layout = frameLayout;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(8);
        FrameLayout frameLayout2 = this.layout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
            return null;
        }
        return frameLayout2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
    }
}

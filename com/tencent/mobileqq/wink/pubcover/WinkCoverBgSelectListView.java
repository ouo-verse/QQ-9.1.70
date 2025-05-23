package com.tencent.mobileqq.wink.pubcover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.pubcover.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#B#\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010$\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/WinkCoverBgSelectListView;", "Landroid/widget/FrameLayout;", "", "c", "Lcom/tencent/mobileqq/wink/pubcover/e$a;", "listener", "setListener", "", com.tencent.luggage.wxa.c8.c.G, "setSelect", "b", "", "enable", "setListViewShow", "e", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "coverSelect", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "switchIcon", "Lcom/tencent/mobileqq/wink/pubcover/e;", "f", "Lcom/tencent/mobileqq/wink/pubcover/e;", "winkCoverBgSelectAdapter", tl.h.F, "Z", "isEnableShow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCoverBgSelectListView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView coverSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView switchIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e winkCoverBgSelectAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableShow;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f325455i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkCoverBgSelectListView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WinkCoverBgSelectListView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.switchIcon;
        RecyclerView recyclerView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchIcon");
            imageView = null;
        }
        imageView.setVisibility(8);
        RecyclerView recyclerView2 = this$0.coverSelect;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void b() {
        RecyclerView recyclerView = this.coverSelect;
        ImageView imageView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        ImageView imageView2 = this.switchIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    public final void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.i58, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026er_select_bg, this, true)");
        View findViewById = inflate.findViewById(R.id.u_s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_bg_select)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.coverSelect = recyclerView;
        ImageView imageView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 10));
        this.winkCoverBgSelectAdapter = new e();
        RecyclerView recyclerView2 = this.coverSelect;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.winkCoverBgSelectAdapter);
        RecyclerView recyclerView3 = this.coverSelect;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            recyclerView3 = null;
        }
        recyclerView3.setOverScrollMode(2);
        RecyclerView recyclerView4 = this.coverSelect;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            recyclerView4 = null;
        }
        recyclerView4.setVisibility(8);
        View findViewById2 = inflate.findViewById(R.id.y8v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_select_bg_switch)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.switchIcon = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchIcon");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        ImageView imageView3 = this.switchIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.pubcover.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkCoverBgSelectListView.d(WinkCoverBgSelectListView.this, view);
            }
        });
    }

    public final void e() {
        if (this.isEnableShow) {
            ImageView imageView = this.switchIcon;
            RecyclerView recyclerView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchIcon");
                imageView = null;
            }
            imageView.setVisibility(0);
            RecyclerView recyclerView2 = this.coverSelect;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverSelect");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
        }
    }

    public final void setListViewShow(boolean enable) {
        this.isEnableShow = enable;
    }

    public final void setListener(@NotNull e.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e eVar = this.winkCoverBgSelectAdapter;
        Intrinsics.checkNotNull(eVar);
        eVar.n0(listener);
    }

    public final void setSelect(int pos) {
        e eVar = this.winkCoverBgSelectAdapter;
        if (eVar != null) {
            eVar.o0(pos);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkCoverBgSelectListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkCoverBgSelectListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f325455i = new LinkedHashMap();
        this.isEnableShow = true;
        c();
    }
}

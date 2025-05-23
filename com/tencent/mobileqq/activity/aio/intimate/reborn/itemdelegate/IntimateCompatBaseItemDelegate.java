package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J4\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bH\u0016J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&R\u001b\u0010\u001b\u001a\u00020\u00028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u00028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u00028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/IntimateCompatBaseItemDelegate;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lj61/a;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/view/ViewGroup$MarginLayoutParams;", "i", "d", "Lkotlin/Lazy;", "e", "()I", "dp12", "f", "dp16", "g", "dp24", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class IntimateCompatBaseItemDelegate extends h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dp12;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dp16;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dp24;

    public IntimateCompatBaseItemDelegate() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate$dp12$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(12.0f));
            }
        });
        this.dp12 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate$dp16$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(16.0f));
            }
        });
        this.dp16 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate$dp24$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(24.0f));
            }
        });
        this.dp24 = lazy3;
    }

    @NotNull
    public abstract View d(@NotNull Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        return ((Number) this.dp12.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return ((Number) this.dp16.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return ((Number) this.dp24.getValue()).intValue();
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public final int getLayoutId() {
        return 0;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    @Nullable
    protected Drawable h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDrawable(R.drawable.juf, null);
    }

    @NotNull
    protected ViewGroup.MarginLayoutParams i() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.leftMargin = f();
        marginLayoutParams.rightMargin = f();
        marginLayoutParams.bottomMargin = g();
        return marginLayoutParams;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(k61.f.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public final SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Context realContext;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!(parent.getContext() instanceof Activity) && (parent.getContext() instanceof ContextWrapper)) {
            Context context = parent.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.ContextWrapper");
            realContext = ((ContextWrapper) context).getBaseContext();
        } else {
            realContext = parent.getContext();
        }
        Intrinsics.checkNotNullExpressionValue(realContext, "realContext");
        View d16 = d(realContext);
        d16.setLayoutParams(i());
        d16.setBackground(h(realContext));
        ArrayList arrayList = new ArrayList();
        initSection(parent, d16, arrayList);
        return new SectionViewHolder<>(d16, arrayList);
    }
}

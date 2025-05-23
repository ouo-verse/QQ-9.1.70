package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/FallbackFactoryMerger;", "Landroid/view/LayoutInflater$Factory2;", "delegateFactory", "Landroid/view/LayoutInflater$Factory;", "delegateFactory2", "fallbackFactory", "fallbackFactory2", "(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V", "onCreateView", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "name", "", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class FallbackFactoryMerger implements LayoutInflater.Factory2 {
    private final LayoutInflater.Factory delegateFactory;
    private final LayoutInflater.Factory2 delegateFactory2;
    private final LayoutInflater.Factory fallbackFactory;
    private final LayoutInflater.Factory2 fallbackFactory2;

    public FallbackFactoryMerger(@NotNull LayoutInflater.Factory delegateFactory, @Nullable LayoutInflater.Factory2 factory2, @NotNull LayoutInflater.Factory fallbackFactory, @Nullable LayoutInflater.Factory2 factory22) {
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        Intrinsics.checkNotNullParameter(fallbackFactory, "fallbackFactory");
        this.delegateFactory = delegateFactory;
        this.delegateFactory2 = factory2;
        this.fallbackFactory = fallbackFactory;
        this.fallbackFactory2 = factory22;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View onCreateView = this.delegateFactory.onCreateView(name, context, attrs);
        return onCreateView != null ? onCreateView : this.fallbackFactory.onCreateView(name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View parent, @NotNull String name, @NotNull Context context, @NotNull AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        LayoutInflater.Factory2 factory2 = this.delegateFactory2;
        View onCreateView = factory2 != null ? factory2.onCreateView(parent, name, context, attrs) : this.delegateFactory.onCreateView(name, context, attrs);
        if (onCreateView != null) {
            return onCreateView;
        }
        LayoutInflater.Factory2 factory22 = this.fallbackFactory2;
        return factory22 != null ? factory22.onCreateView(parent, name, context, attrs) : this.fallbackFactory.onCreateView(name, context, attrs);
    }
}

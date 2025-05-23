package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0005J,\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/ForceMainFactory2;", "Landroid/view/LayoutInflater$Factory2;", "delegateFactory", "Landroid/view/LayoutInflater$Factory;", "delegateFactory2", "(Landroid/view/LayoutInflater$Factory;Landroid/view/LayoutInflater$Factory2;)V", "mainHandler", "Landroid/os/Handler;", "onCreateView", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "name", "", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ForceMainFactory2 implements LayoutInflater.Factory2 {
    private final LayoutInflater.Factory delegateFactory;
    private final LayoutInflater.Factory2 delegateFactory2;
    private final Handler mainHandler;

    public ForceMainFactory2(@NotNull LayoutInflater.Factory delegateFactory, @NotNull LayoutInflater.Factory2 delegateFactory2) {
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        Intrinsics.checkNotNullParameter(delegateFactory2, "delegateFactory2");
        this.delegateFactory = delegateFactory;
        this.delegateFactory2 = delegateFactory2;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NotNull final String name, @NotNull final Context context, @NotNull final AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (CreateViewRedirectManager.INSTANCE.needRedirect(name, context, attrs) && (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
            FutureTask futureTask = new FutureTask(new Callable<View>() { // from class: com.tencent.biz.richframework.layoutinflater.ForceMainFactory2$onCreateView$futureTask$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public final View call() {
                    LayoutInflater.Factory factory;
                    factory = ForceMainFactory2.this.delegateFactory;
                    return factory.onCreateView(name, context, attrs);
                }
            });
            this.mainHandler.post(futureTask);
            try {
                return (View) futureTask.get();
            } catch (InterruptedException e16) {
                RFWLog.e("RFWPreload_ForceMainFactory2", RFWLog.USR, e16);
                return null;
            } catch (ExecutionException e17) {
                RFWLog.e("RFWPreload_ForceMainFactory2", RFWLog.USR, e17);
                return null;
            }
        }
        return this.delegateFactory.onCreateView(name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable final View parent, @NotNull final String name, @NotNull final Context context, @NotNull final AttributeSet attrs) {
        View view;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (CreateViewRedirectManager.INSTANCE.needRedirect(name, context, attrs) && (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
            long nanoTime = System.nanoTime();
            FutureTask futureTask = new FutureTask(new Callable<View>() { // from class: com.tencent.biz.richframework.layoutinflater.ForceMainFactory2$onCreateView$futureTask$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public final View call() {
                    LayoutInflater.Factory2 factory2;
                    factory2 = ForceMainFactory2.this.delegateFactory2;
                    return factory2.onCreateView(parent, name, context, attrs);
                }
            });
            this.mainHandler.post(futureTask);
            View view2 = null;
            try {
                view = (View) futureTask.get();
            } catch (InterruptedException e16) {
                e = e16;
            } catch (ExecutionException e17) {
                e = e17;
            }
            try {
                int i3 = RFWLog.DEV;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCreateView name ");
                sb5.append(name);
                sb5.append(" in main thread end");
                sb5.append(" cost:");
                sb5.append(System.nanoTime() - nanoTime);
                sb5.append(" createResult:");
                sb5.append(view != null);
                RFWLog.i("RFWPreload_ForceMainFactory2", i3, sb5.toString());
                return view;
            } catch (InterruptedException e18) {
                e = e18;
                view2 = view;
                RFWLog.e("RFWPreload_ForceMainFactory2", RFWLog.USR, e);
                return view2;
            } catch (ExecutionException e19) {
                e = e19;
                view2 = view;
                RFWLog.e("RFWPreload_ForceMainFactory2", RFWLog.USR, e);
                return view2;
            }
        }
        return this.delegateFactory2.onCreateView(parent, name, context, attrs);
    }
}

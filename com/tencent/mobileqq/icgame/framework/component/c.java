package com.tencent.mobileqq.icgame.framework.component;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import g32.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\f\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\u0007J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/component/c;", "Lf32/a;", "Lg32/b;", "E", "event", "", "b", "(Lg32/b;)V", "Landroid/content/Context;", "getContext", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "w0", "", "getKey", "Lcom/tencent/mobileqq/icgame/framework/component/e;", HippyQQConstants.URL_COMPONENT_NAME, "a", "d", "Lf32/a;", "rootComponentContext", "Lg32/h;", "e", "Lg32/h;", "trigger", "f", "Ljava/lang/String;", "key", tl.h.F, "Lcom/tencent/mobileqq/icgame/framework/component/e;", "<init>", "(Lf32/a;Lg32/h;Ljava/lang/String;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class c implements f32.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.a rootComponentContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g32.h trigger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e component;

    public c(@NotNull f32.a rootComponentContext, @NotNull g32.h trigger, @NotNull String key) {
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(key, "key");
        this.rootComponentContext = rootComponentContext;
        this.trigger = trigger;
        this.key = key;
    }

    private final <E extends g32.b> void b(E event) {
        f32.a aVar = this.rootComponentContext;
        if (aVar instanceof g32.i) {
            ((g32.i) aVar).a(event);
        } else {
            e32.c.e(new QQLiveException("RootComponentContext is not IRootEventTrigger!"));
        }
    }

    public final void a(@NotNull e component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    @Override // f32.a
    @NotNull
    public Context getContext() {
        return this.rootComponentContext.getContext();
    }

    @Override // f32.a
    @NotNull
    public String getKey() {
        return this.key;
    }

    @Override // f32.a
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        return this.rootComponentContext.getLifecycleOwner();
    }

    @Override // g32.h
    public <E extends g32.b> void w0(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof k) {
            b(event);
        } else {
            this.trigger.w0(event);
        }
    }
}

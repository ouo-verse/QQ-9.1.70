package i01;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import i01.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Li01/e;", "Li01/a;", "", "tag", "Landroid/view/View;", "viewWithTag", "Lcom/tencent/kuikly/core/render/android/c;", "callback", "", "addKuiklyRenderLifecycleCallback", "(Lcom/tencent/kuikly/core/render/android/c;)Lkotlin/Unit;", "removeKuiklyRenderLifeCycleCallback", "Lcom/tencent/kuikly/core/render/android/a;", "_kuiklyRenderContext", "Lcom/tencent/kuikly/core/render/android/a;", "value", "getKuiklyRenderContext", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class e implements a {
    private com.tencent.kuikly.core.render.android.a _kuiklyRenderContext;

    @Nullable
    public final Unit addKuiklyRenderLifecycleCallback(@NotNull com.tencent.kuikly.core.render.android.c callback) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.g(callback);
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return a.C10497a.a(this, method, obj, function1);
    }

    @Override // i01.a
    @Nullable
    public Activity getActivity() {
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                Context baseContext = contextWrapper.getBaseContext();
                if (baseContext != null) {
                    return (Activity) baseContext;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            context = contextWrapper.getBaseContext();
        }
        return null;
    }

    @Nullable
    public final Context getContext() {
        Context context;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        Context context2 = null;
        if (aVar != null) {
            context = aVar.getContext();
        } else {
            context = null;
        }
        if (context instanceof ContextWrapper) {
            com.tencent.kuikly.core.render.android.a aVar2 = get_kuiklyRenderContext();
            if (aVar2 != null) {
                context2 = aVar2.getContext();
            }
            if (context2 != null) {
                return ((ContextWrapper) context2).getBaseContext();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ContextWrapper");
        }
        com.tencent.kuikly.core.render.android.a aVar3 = get_kuiklyRenderContext();
        if (aVar3 == null) {
            return null;
        }
        return aVar3.getContext();
    }

    @Override // i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext, reason: from getter */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return this._kuiklyRenderContext;
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        a.C10497a.c(this);
    }

    @Override // i01.a
    @UiThread
    public void onDestroy() {
        a.C10497a.d(this);
    }

    @Nullable
    public final Unit removeKuiklyRenderLifeCycleCallback(@NotNull com.tencent.kuikly.core.render.android.c callback) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.f(callback);
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        this._kuiklyRenderContext = aVar;
    }

    @Nullable
    public final View viewWithTag(int tag) {
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            return aVar.b(tag);
        }
        return null;
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return a.C10497a.b(this, method, str, function1);
    }
}

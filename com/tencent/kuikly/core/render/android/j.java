package com.tencent.kuikly.core.render.android;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020.\u0012\b\b\u0002\u00108\u001a\u00020\u000e\u0012\b\b\u0002\u0010:\u001a\u00020\u000e\u0012\b\b\u0002\u0010<\u001a\u00020\u000e\u00a2\u0006\u0004\bD\u0010EJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J'\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J'\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0017J#\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020 H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010%R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010.0.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010?\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010B\u001a\u0004\u0018\u00010.8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/kuikly/core/render/android/j;", "Landroid/content/ContextWrapper;", "Lcom/tencent/kuikly/core/render/android/a;", "Landroid/content/Context;", "getBaseContext", PM.BASE, "", "attachBaseContext", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "d", "R0", "newContext", "e", "", "M0", "u0", "T", "Landroid/view/View;", "view", "", "key", "P0", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/Object;", "", "data", "N0", "Q0", "Li01/e;", "name", "a", "(Ljava/lang/String;)Li01/e;", "", "tag", "b", "Lg01/a;", "c", "Lcom/tencent/kuikly/core/render/android/g;", "Landroid/util/SparseArray;", "Landroid/util/ArrayMap;", "Landroid/util/SparseArray;", "viewData", "f", "Lg01/a;", "imageLoader", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/kuikly/core/render/android/d;", "kotlin.jvm.PlatformType", tl.h.F, "Ljava/lang/ref/WeakReference;", "kuiklyRenderViewWeakRef", "i", "Landroid/content/Context;", "customBaseContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "enableContextReplace", BdhLogUtil.LogTag.Tag_Conn, "useHostDisplayMetrics", "D", "isImmersiveEnable", "getContext", "()Landroid/content/Context;", "context", "O0", "()Lcom/tencent/kuikly/core/render/android/d;", "kuiklyRenderRootView", "kuiklyRenderView", "<init>", "(Landroid/content/Context;Lcom/tencent/kuikly/core/render/android/d;ZZZ)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class j extends ContextWrapper implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean useHostDisplayMetrics;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isImmersiveEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private KuiklyContextParams contextParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<ArrayMap<String, Object>> viewData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private g01.a imageLoader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<d> kuiklyRenderViewWeakRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context customBaseContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean enableContextReplace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull Context context, @NotNull d kuiklyRenderView, boolean z16, boolean z17, boolean z18) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(kuiklyRenderView, "kuiklyRenderView");
        this.enableContextReplace = z16;
        this.useHostDisplayMetrics = z17;
        this.isImmersiveEnable = z18;
        this.viewData = new SparseArray<>();
        this.kuiklyRenderViewWeakRef = new WeakReference<>(kuiklyRenderView);
        if (z16) {
            this.customBaseContext = context;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.a
    /* renamed from: M0, reason: from getter */
    public boolean getUseHostDisplayMetrics() {
        return this.useHostDisplayMetrics;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    public void N0(@NotNull View view, @NotNull String key, @NotNull Object data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        int hashCode = view.hashCode();
        ArrayMap<String, Object> arrayMap = this.viewData.get(hashCode);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.viewData.put(hashCode, arrayMap);
        }
        arrayMap.put(key, data);
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public d O0() {
        return this.kuiklyRenderViewWeakRef.get();
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public <T> T P0(@NotNull View view, @NotNull String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayMap<String, Object> arrayMap = this.viewData.get(view.hashCode());
        if (arrayMap != null) {
            obj = arrayMap.get(key);
        } else {
            obj = null;
        }
        if (!(obj instanceof Object)) {
            return null;
        }
        return (T) obj;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public <T> T Q0(@NotNull View view, @NotNull String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayMap<String, Object> arrayMap = this.viewData.get(view.hashCode());
        if (arrayMap != null) {
            obj = arrayMap.remove(key);
        } else {
            obj = null;
        }
        if (!(obj instanceof Object)) {
            return null;
        }
        return (T) obj;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    /* renamed from: R0, reason: from getter */
    public KuiklyContextParams getContextParams() {
        return this.contextParams;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public <T extends i01.e> T a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        d dVar = this.kuiklyRenderViewWeakRef.get();
        if (dVar != null) {
            return (T) dVar.a(name);
        }
        return null;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(@Nullable Context base) {
        super.attachBaseContext(base);
        if (this.enableContextReplace) {
            this.customBaseContext = base;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public View b(int tag) {
        d dVar = this.kuiklyRenderViewWeakRef.get();
        if (dVar != null) {
            return dVar.b(tag);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @Nullable
    public g01.a c() {
        KuiklyContextParams kuiklyContextParams;
        if (this.imageLoader == null && (kuiklyContextParams = this.contextParams) != null) {
            this.imageLoader = new g01.a(kuiklyContextParams.getExecuteMode(), kuiklyContextParams.getAssetsPath());
        }
        return this.imageLoader;
    }

    public void d(@NotNull KuiklyContextParams contextParams) {
        Intrinsics.checkNotNullParameter(contextParams, "contextParams");
        this.contextParams = contextParams;
    }

    public void e(@NotNull Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        if (this.enableContextReplace) {
            this.customBaseContext = newContext;
        }
    }

    @Override // android.content.ContextWrapper
    @Nullable
    public Context getBaseContext() {
        if (this.enableContextReplace) {
            Context context = this.customBaseContext;
            if (context == null) {
                return super.getBaseContext();
            }
            return context;
        }
        return super.getBaseContext();
    }

    @Override // com.tencent.kuikly.core.render.android.a
    /* renamed from: u0, reason: from getter */
    public boolean getIsImmersiveEnable() {
        return this.isImmersiveEnable;
    }

    @Override // com.tencent.kuikly.core.render.android.a
    @NotNull
    public Context getContext() {
        return this;
    }
}

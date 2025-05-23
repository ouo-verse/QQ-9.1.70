package com.tencent.kuikly.core.render.android.layer;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/render/android/layer/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "viewName", "Li01/c;", "Li01/c;", "()Li01/c;", "viewExport", "<init>", "(Ljava/lang/String;Li01/c;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.kuikly.core.render.android.layer.d, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class RenderViewHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String viewName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final i01.c viewExport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/kuikly/core/render/android/layer/d$a", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.layer.d$a */
    /* loaded from: classes7.dex */
    public static final class a implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f118129d;

        a(ViewGroup viewGroup) {
            this.f118129d = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            this.f118129d.setClipChildren(false);
            this.f118129d.removeOnLayoutChangeListener(this);
        }
    }

    public RenderViewHandler(@NotNull String viewName, @NotNull i01.c viewExport) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        Intrinsics.checkNotNullParameter(viewExport, "viewExport");
        this.viewName = viewName;
        this.viewExport = viewExport;
        ViewGroup k3 = com.tencent.kuikly.core.render.android.css.ktx.b.k(viewExport);
        if (k3 != null) {
            k3.addOnLayoutChangeListener(new a(k3));
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final i01.c getViewExport() {
        return this.viewExport;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RenderViewHandler) {
                RenderViewHandler renderViewHandler = (RenderViewHandler) other;
                if (!Intrinsics.areEqual(this.viewName, renderViewHandler.viewName) || !Intrinsics.areEqual(this.viewExport, renderViewHandler.viewExport)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.viewName;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        i01.c cVar = this.viewExport;
        if (cVar != null) {
            i16 = cVar.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "RenderViewHandler(viewName=" + this.viewName + ", viewExport=" + this.viewExport + ")";
    }
}

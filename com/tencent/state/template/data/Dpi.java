package com.tencent.state.template.data;

import android.app.Application;
import android.util.Size;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\rJ\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/template/data/Dpi;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "formatSize", "Landroid/util/Size;", "needCalPx", "hashCode", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Dpi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int height;
    private final int width;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/Dpi$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Dpi(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final Dpi copy(int width, int height) {
        return new Dpi(width, height);
    }

    public final Size formatSize(boolean needCalPx) {
        int i3;
        Application application = Square.INSTANCE.getApplication();
        int i16 = this.width;
        if (needCalPx) {
            i16 = ViewExtensionsKt.calPx(application, i16);
        }
        if (needCalPx) {
            i3 = ViewExtensionsKt.calPx(application, this.height);
        } else {
            i3 = this.height;
        }
        return new Size(i16, i3);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "Dpi(width=" + this.width + ", height=" + this.height + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dpi)) {
            return false;
        }
        Dpi dpi = (Dpi) other;
        return this.width == dpi.width && this.height == dpi.height;
    }

    public static /* synthetic */ Dpi copy$default(Dpi dpi, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = dpi.width;
        }
        if ((i17 & 2) != 0) {
            i16 = dpi.height;
        }
        return dpi.copy(i3, i16);
    }

    public static /* synthetic */ Size formatSize$default(Dpi dpi, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return dpi.formatSize(z16);
    }
}

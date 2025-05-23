package dx;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cB\t\b\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Ldx/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "e", "(I)V", "collectFps", "b", "c", "g", "renderFps", "d", h.F, "renderWidth", "Z", "()Z", "f", "(Z)V", "enableInterpolate", "<init>", "(IIIZ)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int collectFps;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int renderFps;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int renderWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enableInterpolate;

    public e(int i3, int i16, int i17, boolean z16) {
        this.collectFps = i3;
        this.renderFps = i16;
        this.renderWidth = i17;
        this.enableInterpolate = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCollectFps() {
        return this.collectFps;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableInterpolate() {
        return this.enableInterpolate;
    }

    /* renamed from: c, reason: from getter */
    public final int getRenderFps() {
        return this.renderFps;
    }

    /* renamed from: d, reason: from getter */
    public final int getRenderWidth() {
        return this.renderWidth;
    }

    public final void e(int i3) {
        this.collectFps = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.collectFps == eVar.collectFps && this.renderFps == eVar.renderFps && this.renderWidth == eVar.renderWidth && this.enableInterpolate == eVar.enableInterpolate) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.enableInterpolate = z16;
    }

    public final void g(int i3) {
        this.renderFps = i3;
    }

    public final void h(int i3) {
        this.renderWidth = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((this.collectFps * 31) + this.renderFps) * 31) + this.renderWidth) * 31;
        boolean z16 = this.enableInterpolate;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "{ZplanMachineConfig collectFps: " + this.collectFps + ", renderFps: " + this.renderFps + ", renderWidth: " + this.renderWidth + " enableInterpolate: " + this.enableInterpolate + "}";
    }

    public e() {
        this(20, 30, 720, false);
    }
}

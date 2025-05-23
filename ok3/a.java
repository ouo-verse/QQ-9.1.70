package ok3;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lok3/a;", "", "", "b", "c", "Landroid/graphics/SurfaceTexture;", "a", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "Landroid/view/Surface;", "Landroid/view/Surface;", "()Landroid/view/Surface;", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "(Landroid/view/Surface;)V", "surface", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile SurfaceTexture surfaceTexture;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile Surface surface;

    /* renamed from: a, reason: from getter */
    public final Surface getSurface() {
        return this.surface;
    }

    public final synchronized void b() {
        if (this.surfaceTexture == null) {
            this.surfaceTexture = new SurfaceTexture(0);
            this.surface = new Surface(this.surfaceTexture);
        }
    }

    public final synchronized void c() {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surfaceTexture = null;
        this.surface = null;
    }
}

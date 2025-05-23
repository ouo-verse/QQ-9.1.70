package kk3;

import android.view.Surface;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lkk3/j;", "Lkk3/a;", "", "preInitTRTC", "", "userId", "playScreenCapture", "Landroid/view/Surface;", "surface", "", "width", "height", "playScreenCaptureWithSurface", "updateScreenCaptureSurface", "stopPlayScreenCapture", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j implements a {
    @Override // kk3.a
    public void playScreenCapture(String userId) {
        ((a) k74.i.INSTANCE.a(a.class)).playScreenCapture(userId);
    }

    @Override // kk3.a
    public void playScreenCaptureWithSurface(String userId, Surface surface, int width, int height) {
        ((a) k74.i.INSTANCE.a(a.class)).playScreenCaptureWithSurface(userId, surface, width, height);
    }

    @Override // kk3.a
    public void preInitTRTC() {
        ((a) k74.i.INSTANCE.a(a.class)).preInitTRTC();
    }

    @Override // kk3.a
    public void stopPlayScreenCapture(String userId) {
        ((a) k74.i.INSTANCE.a(a.class)).stopPlayScreenCapture(userId);
    }

    @Override // kk3.a
    public void updateScreenCaptureSurface(String userId, Surface surface, int width, int height) {
        ((a) k74.i.INSTANCE.a(a.class)).updateScreenCaptureSurface(userId, surface, width, height);
    }
}

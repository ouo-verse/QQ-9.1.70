package mw;

import android.view.View;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.fragment.NTDoubleMeetingFragment;
import com.tencent.av.ui.fragment.NTMultiVideoBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements k {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<NTBaseVideoFragment> f417702a;

    public a(NTBaseVideoFragment nTBaseVideoFragment) {
        this.f417702a = new WeakReference<>(nTBaseVideoFragment);
    }

    @Override // mw.k
    public void a(boolean z16, boolean z17) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().ij(z16, z17);
        }
    }

    @Override // mw.k
    public int b() {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            return weakReference.get().zh();
        }
        return 0;
    }

    @Override // mw.k
    public void c(long j3, float f16) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().Sj(j3, f16);
        }
    }

    @Override // mw.k
    public boolean d() {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        return weakReference != null && weakReference.get().ai();
    }

    @Override // mw.k
    public void e(long j3) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().ki(j3);
        }
    }

    @Override // mw.k
    public void f(long j3, View view, String str) {
        if (this.f417702a == null) {
            return;
        }
        if (QQPermissionConstants.Permission.CAMERA.equals(str)) {
            this.f417702a.get().oi(j3, view);
        } else if (QQPermissionConstants.Permission.RECORD_AUDIO.equals(str)) {
            this.f417702a.get().wi(j3, view);
        } else if (QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE.equals(str)) {
            this.f417702a.get().xi(j3);
        }
    }

    @Override // mw.k
    public void g(long j3) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().xj(j3);
        }
    }

    @Override // mw.k
    public int getSystemBarHeight() {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            return weakReference.get().Gh();
        }
        return 0;
    }

    @Override // mw.k
    public void h() {
        if (this.f417702a.get() instanceof NTMultiVideoBaseFragment) {
            ((NTMultiVideoBaseFragment) this.f417702a.get()).Il();
        }
    }

    @Override // mw.k
    public void i() {
        if (this.f417702a.get() instanceof NTDoubleMeetingFragment) {
            ((NTDoubleMeetingFragment) this.f417702a.get()).hl();
        }
    }

    @Override // mw.k
    public void j(boolean z16, long j3) {
        if (this.f417702a.get() instanceof NTMultiVideoBaseFragment) {
            ((NTMultiVideoBaseFragment) this.f417702a.get()).ol(z16, j3);
        }
    }

    @Override // mw.k
    public long k() {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            return weakReference.get().Fh();
        }
        return 0L;
    }

    @Override // mw.k
    public void onBeforeCloseCamera(long j3) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().ji(j3);
        }
    }

    @Override // mw.k
    public void p() {
        if (this.f417702a.get() instanceof NTMultiVideoBaseFragment) {
            ((NTMultiVideoBaseFragment) this.f417702a.get()).tl();
        }
    }

    @Override // mw.k
    public void updateBtn(long j3, int i3) {
        WeakReference<NTBaseVideoFragment> weakReference = this.f417702a;
        if (weakReference != null) {
            weakReference.get().lk(j3, i3);
        }
    }
}

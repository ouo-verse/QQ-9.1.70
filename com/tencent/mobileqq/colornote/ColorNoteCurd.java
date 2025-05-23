package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgServlet;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteCurd {

    /* renamed from: a, reason: collision with root package name */
    private g f201316a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f201317b = new b(this);

    private AppRuntime g() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private boolean k() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void a(final Bundle bundle) {
        if (k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ColorNoteCurd.1
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteCurd.this.b(bundle);
                }
            }, 32, null, true);
        } else {
            b(bundle);
        }
    }

    void b(Bundle bundle) {
        AppRuntime g16 = g();
        if (g16 == null) {
            return;
        }
        boolean addColorNote = ((IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all")).addColorNote(bundle);
        Message obtain = Message.obtain();
        obtain.obj = bundle;
        if (addColorNote) {
            obtain.what = 3;
        } else {
            obtain.what = 4;
        }
        this.f201317b.sendMessage(obtain);
    }

    void c(int i3, String str, int i16) {
        AppRuntime g16 = g();
        if (g16 == null) {
            return;
        }
        boolean deleteColorNote = ((IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all")).deleteColorNote(i3, str, i16);
        Message obtain = Message.obtain();
        obtain.obj = new Pair(Integer.valueOf(i3), str);
        if (deleteColorNote) {
            obtain.what = 5;
        } else {
            obtain.what = 6;
        }
        this.f201317b.sendMessage(obtain);
    }

    public boolean d() {
        if (MobileQQ.sProcessId == 1) {
            AppRuntime g16 = g();
            if (g16 != null) {
                return ((IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote();
            }
            return false;
        }
        return ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getCanAddColorNote();
    }

    public void e(int i3, String str) {
        f(i3, str, 0);
    }

    public void f(final int i3, final String str, final int i16) {
        if (k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ColorNoteCurd.2
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteCurd.this.c(i3, str, i16);
                }
            }, 32, null, true);
        } else {
            c(i3, str, i16);
        }
    }

    public g h() {
        return this.f201316a;
    }

    public boolean i() {
        return ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).getSyncState();
    }

    public boolean j(int i3, String str) {
        return ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).isColorNoteExist(i3, str);
    }

    public void l(g gVar) {
        this.f201316a = gVar;
    }

    public void m(final ColorNote colorNote) {
        if (k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ColorNoteCurd.4
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteCurd.this.n(colorNote);
                }
            }, 32, null, true);
        } else {
            n(colorNote);
        }
    }

    void n(ColorNote colorNote) {
        boolean z16;
        if (colorNote == null) {
            return;
        }
        String uniKey = colorNote.getUniKey();
        AppRuntime g16 = g();
        if (g16 == null) {
            return;
        }
        IColorNoteHelper iColorNoteHelper = (IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all");
        String str = colorNote.mMainTitle;
        if (str != null) {
            z16 = iColorNoteHelper.updateColorNote(uniKey, "mMainTitle", str);
        } else {
            z16 = true;
        }
        String str2 = colorNote.mSubTitle;
        if (str2 != null) {
            z16 &= iColorNoteHelper.updateColorNote(uniKey, "mSubTitle", str2);
        }
        String str3 = colorNote.mPicUrl;
        if (str3 != null) {
            z16 &= iColorNoteHelper.updateColorNote(uniKey, "mPicUrl", str3);
        }
        byte[] bArr = colorNote.mReserve;
        if (bArr != null) {
            z16 &= iColorNoteHelper.updateColorNote(uniKey, "mReserve", bArr, 1);
        }
        Message obtain = Message.obtain();
        if (z16) {
            obtain.what = 10;
        } else {
            obtain.what = 11;
        }
        obtain.obj = colorNote;
        this.f201317b.sendMessage(obtain);
    }

    public void o(final int i3, final String str, final boolean z16) {
        if (k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ColorNoteCurd.3
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteCurd.this.q(i3, str, z16);
                }
            }, 32, null, true);
        } else {
            q(i3, str, z16);
        }
    }

    void p(int i3, String str, boolean z16) {
        AppRuntime g16 = g();
        if (g16 == null) {
            QLog.i("ColorNoteCurd", 1, "updateColorNoteStateAux getAppRuntime():null");
            return;
        }
        try {
            Bundle updateColorNoteState = ((IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all")).updateColorNoteState(i3, str, z16);
            if (updateColorNoteState == null) {
                return;
            }
            updateColorNoteState.putInt(CreateUpdatableMsgServlet.KEY_SERVICE_TYPE, i3);
            updateColorNoteState.putString("key_sub_type", str);
            Message obtain = Message.obtain();
            obtain.what = 9;
            obtain.obj = updateColorNoteState;
            this.f201317b.sendMessage(obtain);
        } catch (IllegalStateException e16) {
            QLog.i("ColorNoteCurd", 1, "get IColorNoteHelper early and return:" + e16);
        }
    }

    void q(int i3, String str, boolean z16) {
        if (k()) {
            return;
        }
        AppRuntime g16 = g();
        if (g16 == null) {
            QLog.i("ColorNoteCurd", 1, "updateColorNoteStateAuxPreventEarly getAppRuntime():null");
            return;
        }
        try {
            g16.getRuntimeService(IColorNoteHelper.class, "all");
        } catch (IllegalStateException e16) {
            QLog.i("ColorNoteCurd", 1, "get IColorNoteHelper early and delay:" + e16);
            try {
                LockMethodProxy.sleep(500L);
            } catch (InterruptedException e17) {
                e17.printStackTrace();
            }
        }
        p(i3, str, z16);
    }

    public void r(final ColorNote colorNote) {
        if (k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ColorNoteCurd.5
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteCurd.this.s(colorNote);
                }
            }, 32, null, true);
        } else {
            s(colorNote);
        }
    }

    void s(ColorNote colorNote) {
        AppRuntime g16 = g();
        if (g16 == null) {
            return;
        }
        ((IColorNoteHelper) g16.getRuntimeService(IColorNoteHelper.class, "all")).updateRecentNote(colorNote);
    }
}

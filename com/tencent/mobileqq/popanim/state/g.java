package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f259149a;

    /* renamed from: b, reason: collision with root package name */
    private e f259150b;

    /* renamed from: c, reason: collision with root package name */
    private PopDeleteState f259151c;

    /* renamed from: d, reason: collision with root package name */
    private h f259152d;

    /* renamed from: e, reason: collision with root package name */
    private d f259153e;

    /* renamed from: f, reason: collision with root package name */
    private f f259154f;

    /* renamed from: g, reason: collision with root package name */
    private a f259155g;

    /* renamed from: h, reason: collision with root package name */
    private a f259156h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f259157i;

    public g(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            return;
        }
        this.f259154f = fVar;
        RelativeLayout c16 = PopOutAnimViewHolder.d().c();
        this.f259149a = new c(c16, fVar);
        this.f259150b = new e(c16, fVar);
        this.f259151c = new PopDeleteState(c16, fVar);
        this.f259152d = new h(c16, fVar);
        this.f259153e = new d(c16, fVar);
    }

    private a b(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PopOut_StateMachine", 2, "getCurState exception type = " + i3);
                            }
                            return null;
                        }
                        return this.f259153e;
                    }
                    return this.f259152d;
                }
                return this.f259151c;
            }
            return this.f259150b;
        }
        return this.f259149a;
    }

    private void e(int i3) {
        String str;
        a b16 = b(i3);
        if (b16 != this.f259155g && !this.f259157i) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[6];
                objArr[0] = "transition state, hashCode:";
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = " newState = ";
                String str2 = null;
                if (b16 != null) {
                    str = b16.getClass().getSimpleName();
                } else {
                    str = null;
                }
                objArr[3] = str;
                objArr[4] = " preState:";
                a aVar = this.f259155g;
                if (aVar != null) {
                    str2 = aVar.getClass().getSimpleName();
                }
                objArr[5] = str2;
                QLog.d("PopOut_StateMachine", 2, objArr);
            }
            a aVar2 = this.f259155g;
            this.f259156h = aVar2;
            this.f259155g = b16;
            if (aVar2 != null) {
                aVar2.b(b16);
            }
            a aVar3 = this.f259155g;
            if (aVar3 != null) {
                aVar3.a(this.f259156h);
            }
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        e(4);
        e(5);
        this.f259157i = true;
    }

    public boolean c(MotionEvent motionEvent, com.tencent.mobileqq.popanim.c cVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent, (Object) cVar)).booleanValue();
        }
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3 && !this.f259154f.f259146k) {
            if (motionEvent.getAction() == 2 && !this.f259154f.b()) {
                f fVar = this.f259154f;
                if (!fVar.f259144i && cVar.a(motionEvent)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                fVar.f259144i = z16;
                if (this.f259154f.f259144i) {
                    if (cVar.d(motionEvent)) {
                        e(3);
                    } else {
                        e(2);
                    }
                }
            }
        } else {
            e(4);
        }
        this.f259155g.c(motionEvent);
        return true;
    }

    public void d(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonInfo);
            return;
        }
        this.f259157i = false;
        this.f259154f.f259137b = emoticonInfo;
        e(1);
    }
}

package com.tencent.mobileqq.surfaceviewaction.gl;

import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends d implements com.tencent.mobileqq.surfaceviewaction.c<d>, d.a {
    static IPatchRedirector $redirector_;
    public List<com.tencent.mobileqq.surfaceviewaction.a> Q;

    public c(SpriteGLView spriteGLView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spriteGLView);
        } else {
            this.Q = new ArrayList();
            this.P = spriteGLView;
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d
    public void A(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), fArr);
            return;
        }
        super.A(i3, i16, i17, i18, i19, i26, i27, fArr);
        for (int i28 = 0; i28 < this.Q.size(); i28++) {
            ((d) this.Q.get(i28)).A(i3, i16, i17, i18, i19, i26, i27, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        for (com.tencent.mobileqq.surfaceviewaction.a aVar : this.Q) {
            if (aVar instanceof e) {
                ((e) aVar).B();
            }
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.c
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else if (dVar.I == null) {
            this.Q.add(dVar);
            dVar.I = this;
        } else {
            new RuntimeException("the node had another parent");
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d.a
    public boolean c(MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        Object[] array = this.Q.toArray();
        for (int length = array.length - 1; length >= 0; length--) {
            Object obj = array[length];
            if ((obj instanceof d.a) && ((d.a) obj).c(motionEvent, i3, i16)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.m();
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            ((d) this.Q.get(i3)).m();
        }
        this.Q.clear();
    }
}

package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.f;
import com.tencent.mobileqq.surfaceviewaction.gl.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends e implements d.a {
    static IPatchRedirector $redirector_;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private InterfaceC8634a f291294a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f291295b0;

    /* renamed from: c0, reason: collision with root package name */
    private f f291296c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f291297d0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.surfaceviewaction.gl.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8634a {
        void a(e eVar);
    }

    public a(SpriteGLView spriteGLView, boolean z16, String str) {
        super(spriteGLView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spriteGLView, Boolean.valueOf(z16), str);
            return;
        }
        this.Z = false;
        this.f291295b0 = false;
        this.f291296c0 = new f(0.0f, 0.0f);
        this.f291295b0 = z16;
        this.f291297d0 = str;
    }

    public void L(InterfaceC8634a interfaceC8634a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC8634a);
        } else {
            this.f291294a0 = interfaceC8634a;
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.gl.d.a
    public boolean c(MotionEvent motionEvent, int i3, int i16) {
        float height;
        float height2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        Texture texture = this.Q;
        if (texture != null && texture.f291255b != null) {
            int action = motionEvent.getAction();
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            h(this.f291296c0);
            float g16 = g();
            float width = (this.f291296c0.f291217a - ((this.Q.f291255b.getWidth() * this.f291155m) / 2.0f)) * g16;
            float width2 = (this.f291296c0.f291217a + ((this.Q.f291255b.getWidth() * this.f291155m) / 2.0f)) * g16;
            if (this.P.H) {
                float f16 = i16;
                height = f16 - ((this.f291296c0.f291218b + ((this.Q.f291255b.getHeight() * this.f291155m) / 2.0f)) * g16);
                height2 = f16 - ((this.f291296c0.f291218b - ((this.Q.f291255b.getHeight() * this.f291155m) / 2.0f)) * g16);
            } else {
                height = (this.f291296c0.f291218b - ((this.Q.f291255b.getHeight() * this.f291155m) / 2.0f)) * g16;
                height2 = (this.f291296c0.f291218b + ((this.Q.f291255b.getHeight() * this.f291155m) / 2.0f)) * g16;
            }
            if (action == 0) {
                if (x16 > width && x16 < width2 && y16 > height && y16 < height2) {
                    this.Z = true;
                    if (this.f291295b0) {
                        this.E = 128;
                    }
                } else {
                    this.Z = false;
                    if (this.f291295b0) {
                        this.E = 255;
                    }
                }
                return this.Z;
            }
            if (action == 1 || action == 3) {
                this.Z = false;
                if (this.f291295b0) {
                    this.E = 255;
                }
                if (x16 > width && x16 < width2 && y16 > height && y16 < height2) {
                    InterfaceC8634a interfaceC8634a = this.f291294a0;
                    if (interfaceC8634a != null) {
                        interfaceC8634a.a(this);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public a(SpriteGLView spriteGLView, Bitmap bitmap, boolean z16) {
        super(spriteGLView, bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, spriteGLView, bitmap, Boolean.valueOf(z16));
            return;
        }
        this.Z = false;
        this.f291295b0 = false;
        this.f291296c0 = new f(0.0f, 0.0f);
        this.f291295b0 = z16;
    }
}

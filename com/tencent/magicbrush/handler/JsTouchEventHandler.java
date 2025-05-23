package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsTouchEventHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IntBuffer f147453a;

    /* renamed from: b, reason: collision with root package name */
    public FloatBuffer f147454b;

    /* renamed from: c, reason: collision with root package name */
    public b f147455c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f147456a;

        public b(JsTouchEventHandler jsTouchEventHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jsTouchEventHandler);
            } else {
                this.f147456a = new WeakReference(jsTouchEventHandler);
            }
        }

        @Override // com.tencent.magicbrush.handler.JsTouchEventHandler.a
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            JsTouchEventHandler jsTouchEventHandler = (JsTouchEventHandler) this.f147456a.get();
            if (jsTouchEventHandler != null) {
                jsTouchEventHandler.nativeFreeTouchEvent(j3);
            }
        }
    }

    public JsTouchEventHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f147455c = new b(this);
            a(10);
        }
    }

    private native long nativeCreateTouchEvent(int i3, int i16, int i17, IntBuffer intBuffer, FloatBuffer floatBuffer, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeFreeTouchEvent(long j3);

    public final int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return 0;
        }
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    if (i3 == 5) {
                        return 0;
                    }
                    if (i3 != 6) {
                        return -1;
                    }
                }
            }
            return i16;
        }
        return 2;
    }

    public final float a(MotionEvent motionEvent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent, i3)).floatValue();
        }
        if (i3 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i3) + (motionEvent.getRawX() - motionEvent.getX());
    }

    public final float b(MotionEvent motionEvent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent, i3)).floatValue();
        }
        if (i3 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i3) + (motionEvent.getRawY() - motionEvent.getY());
    }

    public long a(MotionEvent motionEvent, float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, motionEvent, Float.valueOf(f16), Boolean.valueOf(z16))).longValue();
        }
        a(motionEvent.getPointerCount());
        int a16 = a(motionEvent);
        if (a16 == -1) {
            return 0L;
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            this.f147453a.put(motionEvent.getPointerId(i3));
            if (z16) {
                this.f147454b.put(a(motionEvent, i3) / f16);
                this.f147454b.put(b(motionEvent, i3) / f16);
            } else {
                this.f147454b.put(motionEvent.getX(i3) / f16);
                this.f147454b.put(motionEvent.getY(i3) / f16);
            }
        }
        return nativeCreateTouchEvent(a(motionEvent), a16 != 1 ? motionEvent.getActionIndex() : -1, pointerCount, this.f147453a, this.f147454b, motionEvent.getEventTime());
    }

    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f147455c : (a) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public final void a(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        IntBuffer intBuffer = this.f147453a;
        if (intBuffer != null && intBuffer.capacity() >= i3) {
            this.f147453a.clear();
            this.f147454b.clear();
            return;
        }
        IntBuffer intBuffer2 = this.f147453a;
        if (intBuffer2 != null) {
            i16 = intBuffer2.capacity();
            while (i16 < i3) {
                i16 *= 2;
            }
        } else {
            i16 = i3;
        }
        Object[] objArr = new Object[3];
        IntBuffer intBuffer3 = this.f147453a;
        objArr[0] = Integer.valueOf(intBuffer3 == null ? 0 : intBuffer3.capacity());
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i16);
        f.c("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", objArr);
        this.f147453a = ByteBuffer.allocateDirect(i16 * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        this.f147454b = ByteBuffer.allocateDirect(i16 * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public final int a(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? b(motionEvent.getActionMasked()) : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).intValue();
    }
}

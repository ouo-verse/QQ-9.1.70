package com.tencent.turingcam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bwfl9 extends SurfaceView {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private spXPg f381738a;

    public Bwfl9(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    private void a() {
        getHolder();
        Log.i("MFASurfaceView", "[method: init ] ");
    }

    @Override // android.view.SurfaceView
    public SurfaceHolder getHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SurfaceHolder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f381738a == null) {
            this.f381738a = new spXPg(this, super.getHolder());
        }
        return this.f381738a;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements SurfaceHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private SurfaceHolder f381739a;

        /* renamed from: b, reason: collision with root package name */
        private List<SurfaceHolder.Callback> f381740b;

        /* compiled from: P */
        /* renamed from: com.tencent.turingcam.Bwfl9$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public class SurfaceHolderCallbackC10024spXPg implements SurfaceHolder.Callback {
            static IPatchRedirector $redirector_;

            public SurfaceHolderCallbackC10024spXPg() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) spXPg.this);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    return;
                }
                Log.i("MFASurfaceView", "[method: surfaceChanged ] ");
                if (spXPg.this.f381740b != null) {
                    Iterator it = spXPg.this.f381740b.iterator();
                    while (it.hasNext()) {
                        ((SurfaceHolder.Callback) it.next()).surfaceChanged(surfaceHolder, i3, i16, i17);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
                    return;
                }
                Log.i("MFASurfaceView", "[method: surfaceCreated ] ");
                if (spXPg.this.f381740b != null) {
                    Iterator it = spXPg.this.f381740b.iterator();
                    while (it.hasNext()) {
                        ((SurfaceHolder.Callback) it.next()).surfaceCreated(surfaceHolder);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
                    return;
                }
                Log.i("MFASurfaceView", "[method: surfaceDestroyed ] ");
                if (spXPg.this.f381740b != null) {
                    Iterator it = spXPg.this.f381740b.iterator();
                    while (it.hasNext()) {
                        ((SurfaceHolder.Callback) it.next()).surfaceDestroyed(surfaceHolder);
                    }
                    spXPg.this.f381740b.clear();
                }
            }
        }

        public spXPg(Bwfl9 bwfl9, SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bwfl9, (Object) surfaceHolder);
                return;
            }
            this.f381739a = null;
            this.f381740b = new ArrayList();
            SurfaceHolderCallbackC10024spXPg surfaceHolderCallbackC10024spXPg = new SurfaceHolderCallbackC10024spXPg();
            this.f381739a = surfaceHolder;
            surfaceHolder.addCallback(surfaceHolderCallbackC10024spXPg);
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
                return;
            }
            List<SurfaceHolder.Callback> list = this.f381740b;
            if (list != null && !list.contains(callback)) {
                Log.i("MFASurfaceView", "[method: addCallback ] " + callback);
                this.f381740b.add(callback);
            }
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Surface) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurface();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Rect) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurfaceFrame();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                return surfaceHolder.isCreating();
            }
            return false;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Canvas) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
                return;
            }
            List<SurfaceHolder.Callback> list = this.f381740b;
            if (list != null) {
                list.remove(callback);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.setFixedSize(i3, i16);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.setFormat(i3);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z16);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.setSizeFromLayout();
            }
        }

        @Override // android.view.SurfaceHolder
        public void setType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.setType(i3);
            }
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
                return;
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Canvas) iPatchRedirector.redirect((short) 11, (Object) this, (Object) rect);
            }
            SurfaceHolder surfaceHolder = this.f381739a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas(rect);
            }
            return null;
        }
    }

    public Bwfl9(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

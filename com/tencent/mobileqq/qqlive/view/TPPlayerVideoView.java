package com.tencent.mobileqq.qqlive.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.view.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressLint({"ObsoleteSdkInt"})
/* loaded from: classes17.dex */
public class TPPlayerVideoView extends FrameLayout implements ITPPlayerVideoView {
    static IPatchRedirector $redirector_;
    private ViewGroup C;
    private int D;
    private List<ITPPlayerVideoView.IVideoViewCallback> E;
    private List<ITPPlayerVideoView.IVideoSurfaceCallback> F;
    private Object G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private a.InterfaceC8403a N;

    /* renamed from: d, reason: collision with root package name */
    private Context f273463d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.view.a f273464e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.view.a f273465f;

    /* renamed from: h, reason: collision with root package name */
    private int f273466h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f273467i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f273468m;

    /* renamed from: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView$2, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TPPlayerVideoView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.M) {
                this.this$0.f273465f = null;
            } else {
                if (this.this$0.f273465f != null) {
                    TPPlayerVideoView tPPlayerVideoView = this.this$0;
                    tPPlayerVideoView.removeView((View) tPPlayerVideoView.f273465f);
                }
                this.this$0.f273465f = null;
            }
            this.this$0.f273464e.setOpaqueInfo(true);
            ((View) this.this$0.f273464e).requestFocus();
        }
    }

    /* renamed from: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView$4, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TPPlayerVideoView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((View) this.this$0.f273464e).requestLayout();
            }
        }
    }

    /* loaded from: classes17.dex */
    class a implements a.InterfaceC8403a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TPPlayerVideoView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.view.a.InterfaceC8403a
        public void onViewChanged(Object obj, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (TPPlayerVideoView.this.K != i3 || TPPlayerVideoView.this.L != i16) {
                TPPlayerVideoView.this.K = i3;
                TPPlayerVideoView.this.L = i16;
                TPPlayerVideoView.this.G = obj;
                TPPlayerVideoView.this.n(obj);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.view.a.InterfaceC8403a
        public void onViewCreated(Object obj, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TPPlayerVideoView.this.H = true;
                TPPlayerVideoView.this.G = obj;
                TPPlayerVideoView.this.o(obj);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        @Override // com.tencent.mobileqq.qqlive.view.a.InterfaceC8403a
        public void onViewDestroyed(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TPPlayerVideoView.this.H = false;
                TPPlayerVideoView.this.p(obj);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, obj);
            }
        }
    }

    public TPPlayerVideoView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f273465f = null;
        this.f273466h = 0;
        this.f273467i = false;
        this.f273468m = false;
        this.C = null;
        this.D = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = new a();
        this.f273463d = context;
        this.E = new ArrayList();
        this.f273466h = new Random().nextInt();
        setBackgroundColor(-16777216);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        List<ITPPlayerVideoView.IVideoViewCallback> list = this.E;
        if (list != null) {
            for (ITPPlayerVideoView.IVideoViewCallback iVideoViewCallback : list) {
                if (iVideoViewCallback != null) {
                    iVideoViewCallback.onSurfaceChanged(obj);
                }
            }
        }
        List<ITPPlayerVideoView.IVideoSurfaceCallback> list2 = this.F;
        if (list2 != null) {
            for (ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback : list2) {
                if (iVideoSurfaceCallback != null) {
                    iVideoSurfaceCallback.onSurfaceChanged(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        List<ITPPlayerVideoView.IVideoViewCallback> list = this.E;
        if (list != null) {
            for (ITPPlayerVideoView.IVideoViewCallback iVideoViewCallback : list) {
                if (iVideoViewCallback != null) {
                    iVideoViewCallback.onSurfaceCreated(obj);
                }
            }
        }
        List<ITPPlayerVideoView.IVideoSurfaceCallback> list2 = this.F;
        if (list2 != null) {
            for (ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback : list2) {
                if (iVideoSurfaceCallback != null) {
                    iVideoSurfaceCallback.onSurfaceCreated(obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Object obj) {
        List<ITPPlayerVideoView.IVideoViewCallback> list = this.E;
        if (list != null) {
            for (ITPPlayerVideoView.IVideoViewCallback iVideoViewCallback : list) {
                if (iVideoViewCallback != null) {
                    iVideoViewCallback.onSurfaceDestroy(obj);
                }
            }
        }
        List<ITPPlayerVideoView.IVideoSurfaceCallback> list2 = this.F;
        if (list2 != null) {
            for (ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback : list2) {
                if (iVideoSurfaceCallback != null) {
                    iVideoSurfaceCallback.onSurfaceDestroy(obj);
                }
            }
        }
    }

    private void q() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        com.tencent.mobileqq.qqlive.view.a a16 = c.a(this.f273463d, this.f273468m, this.I, this.J);
        this.f273464e = a16;
        a16.setViewCallBack(this.N);
        addView((View) this.f273464e, layoutParams);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) iVideoSurfaceCallback);
            return;
        }
        if (iVideoSurfaceCallback == null) {
            return;
        }
        if (this.F == null) {
            this.F = new CopyOnWriteArrayList();
        }
        if (!this.F.contains(iVideoSurfaceCallback)) {
            this.F.add(iVideoSurfaceCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void blackScreen(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        Object obj = this.f273464e;
        if (obj instanceof View) {
            View view = (View) obj;
            if (z16) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public View getCurrentDisplayView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public Rect getDisplayViewRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Rect) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        Rect rect = new Rect();
        Object obj = this.f273464e;
        if (obj instanceof View) {
            ((View) obj).getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public int getViewRenderMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.D;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f273469d;

                {
                    this.f273469d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TPPlayerVideoView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TPPlayerVideoView.this.r(this.f273469d);
                    }
                }
            });
            return;
        }
        if (this.H && this.f273467i && z16) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.H = false;
            this.G = null;
            this.f273464e.setViewCallBack(null);
            com.tencent.mobileqq.qqlive.view.a a16 = c.a(this.f273463d, this.f273468m, this.I, this.J);
            a16.setViewCallBack(this.N);
            View view = (View) a16;
            view.setVisibility(0);
            a16.setOpaqueInfo(true);
            a16.setXYAxis(this.D);
            this.f273464e.setOpaqueInfo(false);
            if (this.M) {
                removeView((View) this.f273464e);
                this.f273465f = null;
            } else {
                Object obj = this.f273465f;
                if (obj != null) {
                    removeView((View) obj);
                }
                this.f273465f = this.f273464e;
            }
            addView(view, layoutParams);
            this.f273464e = a16;
        }
        if (z16) {
            this.f273467i = false;
        }
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            removeAllViews();
            this.f273463d = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iVideoSurfaceCallback);
            return;
        }
        List<ITPPlayerVideoView.IVideoSurfaceCallback> list = this.F;
        if (list != null && iVideoSurfaceCallback != null) {
            list.remove(iVideoSurfaceCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public boolean setDegree(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        boolean degree = this.f273464e.setDegree(i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TPPlayerVideoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    ((View) TPPlayerVideoView.this.f273464e).requestLayout();
                } catch (Exception e16) {
                    QLog.e("TPPlayer[TPPlayerVideoView]", 1, "setDegree error", e16);
                }
            }
        });
        return degree;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 > 0 && i16 > 0) {
            this.f273464e.setVideoWidthAndHeight(i3, i16);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ((View) this.f273464e).requestLayout();
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TPPlayerVideoView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ((View) TPPlayerVideoView.this.f273464e).requestLayout();
                        }
                    }
                });
            }
        }
    }

    public void setMidLayout(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            if (view instanceof ViewStub) {
                this.C = (ViewGroup) ((ViewStub) view).inflate();
            } else if (view instanceof ViewGroup) {
                this.C = (ViewGroup) view;
            }
        }
    }

    public void setRenderGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        Object obj = this.f273464e;
        if (obj != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((View) obj).getLayoutParams();
            layoutParams.gravity = i3;
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setScaleParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else {
            this.f273464e.setScaleParam(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setXYAxis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        try {
            this.f273464e.setXYAxis(i3);
            this.D = i3;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TPPlayerVideoView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((View) TPPlayerVideoView.this.f273464e).requestLayout();
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e("TPPlayer[TPPlayerVideoView]", 1, "setXYAis error", e16);
        }
    }
}

package com.tencent.xweb;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ar.x0;

/* loaded from: classes27.dex */
public class XWebExtendPluginNativeViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final Context f385053a;

    /* renamed from: b, reason: collision with root package name */
    public VirtualDisplay f385054b;

    /* renamed from: c, reason: collision with root package name */
    public final Surface f385055c;

    /* renamed from: d, reason: collision with root package name */
    public final SurfaceTexture f385056d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f385057e;

    /* renamed from: f, reason: collision with root package name */
    public int f385058f;

    /* renamed from: g, reason: collision with root package name */
    public int f385059g;

    /* renamed from: h, reason: collision with root package name */
    public NativeViewPresentation f385060h;

    /* renamed from: i, reason: collision with root package name */
    public XWebExtendPluginNativeViewDelegate f385061i;

    @TargetApi(17)
    @CalledByRuntime
    /* loaded from: classes27.dex */
    public class NativeViewPresentation extends Presentation {
        private final XWebExtendPluginNativeViewClient mClient;
        private FrameLayout mContentView;
        private boolean mStartFocused;

        public NativeViewPresentation(Context context, Display display, boolean z16, XWebExtendPluginNativeViewClient xWebExtendPluginNativeViewClient) {
            super(context, display);
            this.mStartFocused = false;
            getWindow().setFlags(8, 8);
            this.mStartFocused = z16;
            this.mClient = xWebExtendPluginNativeViewClient;
        }

        public void detach() {
            if (XWebExtendPluginNativeViewClient.this.f385057e != null) {
                XWebExtendPluginNativeViewClient.this.f385057e.removeAllViews();
            }
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            XWebExtendPluginNativeViewClient.this.f385057e = new FrameLayout(getContext());
            FrameLayout frameLayout = this.mContentView;
            if (frameLayout != null) {
                if (this.mStartFocused) {
                    frameLayout.requestFocus();
                }
                XWebExtendPluginNativeViewClient.this.f385057e.addView(this.mContentView);
            }
            setContentView(XWebExtendPluginNativeViewClient.this.f385057e);
            if (XWebExtendPluginNativeViewClient.this.f385061i != null) {
                XWebExtendPluginNativeViewClient.this.f385061i.onCreate(this.mClient.f385058f, this.mClient.f385059g);
            }
        }
    }

    public XWebExtendPluginNativeViewClient(Context context, SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f385053a = context;
        this.f385056d = surfaceTexture;
        this.f385055c = new Surface(surfaceTexture);
        this.f385058f = i3;
        this.f385059g = i16;
    }

    public void dispose() {
        XWebExtendPluginNativeViewDelegate xWebExtendPluginNativeViewDelegate = this.f385061i;
        if (xWebExtendPluginNativeViewDelegate != null) {
            xWebExtendPluginNativeViewDelegate.onDestroy();
        }
        NativeViewPresentation nativeViewPresentation = this.f385060h;
        if (nativeViewPresentation != null) {
            nativeViewPresentation.cancel();
            this.f385060h.detach();
        }
        VirtualDisplay virtualDisplay = this.f385054b;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
    }

    public Context getContext() {
        XWebExtendPluginNativeViewDelegate xWebExtendPluginNativeViewDelegate = this.f385061i;
        if (xWebExtendPluginNativeViewDelegate != null) {
            return xWebExtendPluginNativeViewDelegate.getContext();
        }
        x0.c("XWebExtendPluginNativeViewClient", "no context");
        return null;
    }

    public FrameLayout getRootView() {
        return this.f385057e;
    }

    public void onSizeChanged(int i3, int i16) {
        XWebExtendPluginNativeViewDelegate xWebExtendPluginNativeViewDelegate = this.f385061i;
        if (xWebExtendPluginNativeViewDelegate != null) {
            xWebExtendPluginNativeViewDelegate.onSizeChanged(i3, i16);
        }
        if (this.f385058f != i3 || this.f385059g != i16) {
            this.f385058f = i3;
            this.f385059g = i16;
            a(false);
        }
    }

    public void setDelegate(XWebExtendPluginNativeViewDelegate xWebExtendPluginNativeViewDelegate) {
        this.f385061i = xWebExtendPluginNativeViewDelegate;
        if (xWebExtendPluginNativeViewDelegate != null) {
            this.f385057e = new FrameLayout(xWebExtendPluginNativeViewDelegate.getContext());
            a(false);
        }
    }

    public final void a(boolean z16) {
        NativeViewPresentation nativeViewPresentation = this.f385060h;
        if (nativeViewPresentation != null) {
            nativeViewPresentation.detach();
        }
        VirtualDisplay virtualDisplay = this.f385054b;
        if (virtualDisplay != null) {
            virtualDisplay.setSurface(null);
            this.f385054b.release();
        }
        SurfaceTexture surfaceTexture = this.f385056d;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this.f385058f, this.f385059g);
        }
        this.f385054b = ((DisplayManager) getContext().getSystemService("display")).createVirtualDisplay("xweb-vd" + hashCode(), this.f385058f, this.f385059g, getContext().getResources().getDisplayMetrics().densityDpi, this.f385055c, 0);
        NativeViewPresentation nativeViewPresentation2 = new NativeViewPresentation(getContext(), this.f385054b.getDisplay(), false, this);
        this.f385060h = nativeViewPresentation2;
        nativeViewPresentation2.show();
    }

    public XWebExtendPluginNativeViewClient(Context context, Surface surface, int i3, int i16) {
        this.f385053a = context;
        this.f385056d = null;
        this.f385055c = surface;
        this.f385058f = i3;
        this.f385059g = i16;
    }

    public void onNativeViewDestroy(int i3) {
    }

    public void onNativeViewReady(int i3) {
    }

    public void onNativeViewTouch(int i3, MotionEvent motionEvent) {
    }

    public void onNativeViewSizeChanged(int i3, int i16, int i17) {
    }
}

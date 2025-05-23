package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.util.LogUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class THookTextureView extends TextureView {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "THookTextureView";
    private static SurfaceTextureHookCallback hookCallback;
    private TextureView.SurfaceTextureListener mInnerSetListener;
    private TextureView.SurfaceTextureListener mOutSetListener;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface SurfaceTextureHookCallback {
        boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture surfaceTexture);
    }

    public THookTextureView(@Nullable Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static void setHookCallback(SurfaceTextureHookCallback surfaceTextureHookCallback) {
        hookCallback = surfaceTextureHookCallback;
    }

    @Override // android.view.TextureView
    public final void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTextureListener);
        } else {
            this.mOutSetListener = surfaceTextureListener;
            super.setSurfaceTextureListener(this.mInnerSetListener);
        }
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mInnerSetListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.tmediacodec.hook.THookTextureView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) THookTextureView.this);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(@Nullable SurfaceTexture surfaceTexture, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, this, surfaceTexture, Integer.valueOf(i16), Integer.valueOf(i17));
                    } else if (THookTextureView.this.mOutSetListener != null) {
                        THookTextureView.this.mOutSetListener.onSurfaceTextureAvailable(surfaceTexture, i16, i17);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) surfaceTexture)).booleanValue();
                    }
                    boolean z17 = false;
                    if (THookTextureView.this.mOutSetListener != null && !THookTextureView.this.mOutSetListener.onSurfaceTextureDestroyed(surfaceTexture)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (THookTextureView.hookCallback != null) {
                        if (z16 && THookTextureView.hookCallback.onSurfaceTextureDestroyedCalled(surfaceTexture)) {
                            z17 = true;
                        }
                        LogUtils.d("THookTextureView", this + "onSurfaceTextureDestroyed surfaceTexture:" + surfaceTexture + " hookResult:" + z17 + "result:" + z16);
                        return z17;
                    }
                    LogUtils.d("THookTextureView", this + ", onSurfaceTextureDestroyed surfaceTexture:" + surfaceTexture + " result:" + z16);
                    return z16;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i16), Integer.valueOf(i17));
                    } else if (THookTextureView.this.mOutSetListener != null) {
                        THookTextureView.this.mOutSetListener.onSurfaceTextureSizeChanged(surfaceTexture, i16, i17);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) surfaceTexture);
                    } else if (THookTextureView.this.mOutSetListener != null) {
                        THookTextureView.this.mOutSetListener.onSurfaceTextureUpdated(surfaceTexture);
                    }
                }
            };
            setSurfaceTextureListener(null);
        }
    }
}

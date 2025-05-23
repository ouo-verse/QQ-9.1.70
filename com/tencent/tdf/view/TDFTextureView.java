package com.tencent.tdf.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.view.RenderSurface;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFTextureView extends TextureView implements RenderSurface {
    static IPatchRedirector $redirector_;
    private RenderSurface.Callback mCallback;
    private boolean mIsRenderInImageView;
    private Surface renderSurface;
    private final TextureView.SurfaceTextureListener surfaceTextureListener;

    public TDFTextureView(Context context, RenderSurface.Callback callback) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCallback = callback;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) callback);
        }
    }

    private void init() {
        setSurfaceTextureListener(this.surfaceTextureListener);
        setOpaque(false);
    }

    @Override // com.tencent.tdf.view.RenderSurface
    public void attachSurfaceToRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Surface surface = this.renderSurface;
        if (surface != null && !this.mIsRenderInImageView) {
            this.mCallback.surfaceCreated(surface);
        }
    }

    @Override // com.tencent.tdf.view.RenderSurface
    public void setRenderInImageView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mIsRenderInImageView = z16;
        }
    }

    public TDFTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mIsRenderInImageView = false;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.tdf.view.TDFTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TDFTextureView.this);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
                } else if (TDFTextureView.this.getSurfaceTexture() != null) {
                    TDFTextureView.this.renderSurface = new Surface(TDFTextureView.this.getSurfaceTexture());
                    TDFTextureView.this.attachSurfaceToRenderer();
                    TDFTextureView.this.mCallback.surfaceChanged(TDFTextureView.this.renderSurface, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 5, (Object) this, (Object) surfaceTexture)).booleanValue();
                }
                TDFTextureView.this.mCallback.surfaceDestroyed(TDFTextureView.this.renderSurface);
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    TDFTextureView.this.mCallback.surfaceChanged(TDFTextureView.this.renderSurface, i3, i16);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) surfaceTexture);
                }
            }
        };
        init();
    }
}

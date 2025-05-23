package com.tencent.turingcam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CFgXs extends TextureView implements TextureView.SurfaceTextureListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private spXPg f381742a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f381743b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface spXPg {
        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16);

        boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);
    }

    public CFgXs(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView
    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!this.f381743b.get()) {
            return null;
        }
        return super.getBitmap();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        spXPg spxpg = this.f381742a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.f381743b.set(false);
        spXPg spxpg = this.f381742a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceTexture);
        } else {
            this.f381743b.set(true);
        }
    }

    public CFgXs(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f381743b = new AtomicBoolean(false);
            a();
        }
    }

    public void a(spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f381742a = spxpg;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) spxpg);
        }
    }
}

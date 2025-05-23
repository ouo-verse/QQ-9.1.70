package com.tencent.mobileqq.surfaceviewaction.nv;

import android.media.MediaMetadataRetriever;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends c {
    static IPatchRedirector $redirector_;
    protected VPNGImageView R;

    public e(SpriteNativeView spriteNativeView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spriteNativeView, (Object) str);
            return;
        }
        this.P = spriteNativeView;
        this.R = new VPNGImageView(spriteNativeView.getContext());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                this.f291151e = Integer.parseInt(extractMetadata) / 2;
                this.f291152f = Integer.parseInt(extractMetadata2);
                this.R.setLayoutParams(new FrameLayout.LayoutParams((int) this.f291151e, (int) this.f291152f));
                this.R.setPivotX(this.f291151e / 2.0f);
                this.R.setPivotY(this.f291152f / 2.0f);
            } catch (Exception e16) {
                QLog.e("VideoSprite", 2, "MediaMetadataRetriever exception " + e16);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.c
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean A = super.A();
        h(this.Q);
        float g16 = (this.Q.f291217a * g()) - (this.f291151e / 2.0f);
        float g17 = (this.N - (this.Q.f291218b * g())) - (this.f291152f / 2.0f);
        this.R.setX(g16);
        this.R.setY(g17);
        this.R.setScaleX(this.f291155m * g());
        this.R.setScaleY(this.f291155m * g());
        this.R.setRotation(this.D);
        this.R.setAlpha((this.E * (f() / 255.0f)) / 255.0f);
        return A;
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.c
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.P.addView(this.R);
        }
    }

    public void C(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            this.R.setVideo(str, z16);
        }
    }
}

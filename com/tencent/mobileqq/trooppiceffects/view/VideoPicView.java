package com.tencent.mobileqq.trooppiceffects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.am;

/* loaded from: classes19.dex */
public class VideoPicView extends FrameLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f303316d;

    /* renamed from: e, reason: collision with root package name */
    protected SpriteVideoView f303317e;

    /* renamed from: f, reason: collision with root package name */
    protected String f303318f;

    public VideoPicView(Context context, int i3, int i16, int i17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f303318f = am.k(i3);
        this.f303316d = new ImageView(getContext());
        this.f303317e = new SpriteVideoView(getContext(), true);
        this.f303316d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f303317e.setLooping(true);
        addView(this.f303316d, -1, -1);
        addView(this.f303317e, i16, i17);
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f303317e.u();
        }
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f303317e.x(this.f303318f, null);
        }
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void setBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        } else {
            this.f303316d.setImageBitmap(bitmap);
        }
    }
}

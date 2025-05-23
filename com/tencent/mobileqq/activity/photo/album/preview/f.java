package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f<O extends OtherCommonData> extends e<O> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(PeakFragmentActivity peakFragmentActivity) {
        super(peakFragmentActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peakFragmentActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            v().a();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return v().b();
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f184337i.c(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return v().d();
    }

    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f184337i.doOnDestroy();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f184337i.doOnPause();
        }
    }

    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f184337i.doOnResume();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public RelativeLayout.LayoutParams e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return v().e();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public RelativeLayout.LayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return v().f();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            v().g();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            v().h();
        }
    }

    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            this.f184337i.j(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            v().k(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            this.f184337i.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            v().onBackPressed();
        }
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onClickDragView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else if (f16 < 0.8f) {
            v().getContentView().setVisibility(4);
        }
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onGestureFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        onBackPressed();
        PeakFragmentActivity peakFragmentActivity = this.f184333d;
        if (peakFragmentActivity != null) {
            peakFragmentActivity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    @Override // com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener
    public void onResetPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            v().getContentView().setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            v().p(view);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void q(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, compoundButton, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            v().r();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.a
    public Class<? extends AbstractPhotoListActivity> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return AbstractPhotoListActivity.class;
    }
}

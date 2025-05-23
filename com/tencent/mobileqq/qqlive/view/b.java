package com.tencent.mobileqq.qqlive.view;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements ITPPlayerVideoView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ISPlayerVideoView f273485d;

    /* renamed from: e, reason: collision with root package name */
    private int f273486e;

    public b(ISPlayerVideoView iSPlayerVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iSPlayerVideoView);
        } else {
            this.f273485d = iSPlayerVideoView;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iVideoSurfaceCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void blackScreen(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        Object obj = this.f273485d;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object obj = this.f273485d;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public Rect getDisplayViewRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Rect) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Rect rect = new Rect();
        View renderView = this.f273485d.getRenderView();
        if (renderView != null) {
            renderView.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public int getViewRenderMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f273486e;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iVideoSurfaceCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public boolean setDegree(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        this.f273485d.setDegree(i3);
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setFixedSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f273485d.setFixedSize(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setScaleParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.f273485d.setScaleParam(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
    public void setXYAxis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        QLog.i("SuperPlayerVideoView", 1, "setXYAxis: " + i3);
        this.f273486e = i3;
        this.f273485d.setXYaxis(i3);
    }
}

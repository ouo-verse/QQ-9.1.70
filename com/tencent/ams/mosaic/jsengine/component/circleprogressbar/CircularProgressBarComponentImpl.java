package com.tencent.ams.mosaic.jsengine.component.circleprogressbar;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class CircularProgressBarComponentImpl extends BasicComponent implements CircularProgressBarComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final CircularProgressBar f70981d;

    public CircularProgressBarComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f70981d = new CircularProgressBar(context);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70981d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.circleprogressbar.CircularProgressBarComponent
    public void setBarBackground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f70981d.setBarBackground(MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.circleprogressbar.CircularProgressBarComponent
    public void setBarForeground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f70981d.setBarForeground(MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.circleprogressbar.CircularProgressBarComponent
    public void setBarWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f70981d.setBarWidth(MosaicUtils.j(i3));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.circleprogressbar.CircularProgressBarComponent
    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.f70981d.setProgress(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "CircularProgressBarComponentImpl";
    }
}

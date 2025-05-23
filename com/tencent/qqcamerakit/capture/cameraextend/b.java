package com.tencent.qqcamerakit.capture.cameraextend;

import android.app.Activity;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqcamerakit.common.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f344880a;

    /* renamed from: b, reason: collision with root package name */
    private View f344881b;

    /* renamed from: c, reason: collision with root package name */
    private int f344882c;

    /* renamed from: d, reason: collision with root package name */
    private int f344883d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f344884e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f344885f;

    public b(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f344880a = false;
        this.f344884e = false;
        this.f344885f = activity;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.f344881b == null) {
                this.f344881b = new View(this.f344885f);
            }
            this.f344881b.setBackgroundColor(-1);
            this.f344881b.setAlpha(0.7f);
            if (this.f344881b.getParent() != null) {
                ((ViewGroup) this.f344881b.getParent()).removeView(this.f344881b);
            }
            this.f344885f.addContentView(this.f344881b, new ViewGroup.LayoutParams(-1, -1));
            try {
                this.f344882c = Settings.System.getInt(this.f344885f.getContentResolver(), "screen_brightness_mode");
                Settings.System.putInt(this.f344885f.getContentResolver(), "screen_brightness_mode", 0);
                this.f344883d = Settings.System.getInt(this.f344885f.getContentResolver(), "screen_brightness");
                Settings.System.putInt(this.f344885f.getContentResolver(), "screen_brightness", 255);
                this.f344884e = true;
                return;
            } catch (Exception e16) {
                this.f344882c = 1;
                this.f344883d = 100;
                if (e.f()) {
                    e.b("FrontFlashImpl", 2, "turn FrontFlash Error ", e16);
                    e16.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (this.f344884e) {
            Settings.System.putInt(this.f344885f.getContentResolver(), "screen_brightness", this.f344883d);
            Settings.System.putInt(this.f344885f.getContentResolver(), "screen_brightness_mode", this.f344882c);
            this.f344884e = false;
        }
        View view = this.f344881b;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f344881b.getParent()).removeView(this.f344881b);
        }
    }
}

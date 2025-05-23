package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MusicFileBrowserView extends FileBrowserViewBase {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f206098k;

    /* renamed from: l, reason: collision with root package name */
    private SeekBar f206099l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f206100m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f206101n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f206102o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f206103p;

    public MusicFileBrowserView(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        }
    }

    public void A(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onSeekBarChangeListener);
        } else if (onSeekBarChangeListener != null) {
            this.f206099l.setOnSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (i3 > 0) {
            this.f206099l.setMax(i3);
        }
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f206101n.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
        if (this.f206084a == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.amp, (ViewGroup) null, false);
            this.f206084a = inflate;
            this.f206098k = (ImageView) inflate.findViewById(R.id.f166361f41);
            this.f206102o = (TextView) this.f206084a.findViewById(R.id.c_g);
            this.f206099l = (SeekBar) this.f206084a.findViewById(R.id.fvk);
            this.f206101n = (TextView) this.f206084a.findViewById(R.id.f164298rh);
            this.f206100m = (TextView) this.f206084a.findViewById(R.id.fxp);
            this.f206103p = (TextView) this.f206084a.findViewById(R.id.c_c);
            this.f206099l.setSplitTrack(false);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f206098k.getLayoutParams();
            int i3 = (int) (f16 * 150.0f);
            layoutParams.width = i3;
            layoutParams.height = i3;
            this.f206098k.setLayoutParams(layoutParams);
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f206100m.setText(str);
        }
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f206103p.setText(str);
        }
    }

    public void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (this.f206102o.getMeasuredWidth() <= 0) {
            this.f206102o.post(new Runnable(str) { // from class: com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f206104d;

                {
                    this.f206104d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MusicFileBrowserView.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MusicFileBrowserView.this.f206102o.setText(ah.M0(this.f206104d, false, MusicFileBrowserView.this.f206102o.getMeasuredWidth(), MusicFileBrowserView.this.f206102o.getPaint(), 2));
                    }
                }
            });
        } else {
            TextView textView = this.f206102o;
            textView.setText(ah.M0(str, false, textView.getMeasuredWidth(), this.f206102o.getPaint(), 2));
        }
    }

    public void w(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else if (onClickListener != null) {
            this.f206098k.setOnClickListener(onClickListener);
        }
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else if (z16) {
            this.f206098k.setImageResource(R.drawable.e_a);
            this.f206098k.setContentDescription(BaseApplication.getContext().getString(R.string.aa_));
        } else {
            this.f206098k.setImageResource(R.drawable.e_b);
            this.f206098k.setContentDescription(BaseApplication.getContext().getString(R.string.aab));
        }
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f206099l.setEnabled(z16);
        }
    }

    public void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f206099l.setProgress(i3);
        }
    }
}

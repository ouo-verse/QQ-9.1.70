package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MusicFileViewer extends a {
    private ImageView H;
    private SeekBar I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;

    public MusicFileViewer(Activity activity) {
        super(activity);
    }

    public void A(String str) {
        this.L.setText(str);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void f() {
        QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
        if (this.f208606e == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.amp, this.f208605d, false);
            this.f208606e = inflate;
            this.H = (ImageView) inflate.findViewById(R.id.f166361f41);
            this.J = (TextView) this.f208606e.findViewById(R.id.fdn);
            this.M = (TextView) this.f208606e.findViewById(R.id.c_g);
            this.I = (SeekBar) this.f208606e.findViewById(R.id.fvk);
            this.L = (TextView) this.f208606e.findViewById(R.id.f164298rh);
            this.K = (TextView) this.f208606e.findViewById(R.id.fxp);
            this.N = (TextView) this.f208606e.findViewById(R.id.c_c);
            this.I.setSplitTrack(false);
        }
    }

    public void q() {
        if (FontSettingManager.getFontLevel() > 17.0f) {
            int i3 = (int) (this.f208607f.getResources().getDisplayMetrics().density * 150.0f);
            this.H.setLayoutParams(new FrameLayout.LayoutParams(i3, i3));
        }
    }

    public void r(String str) {
        this.K.setText(str);
    }

    public void s(String str) {
        this.N.setText(str);
    }

    public void t(final String str) {
        if (this.M.getMeasuredWidth() <= 0) {
            this.M.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer.1
                @Override // java.lang.Runnable
                public void run() {
                    MusicFileViewer.this.M.setText(FileManagerUtil.handleLongFileName(str, false, MusicFileViewer.this.M.getMeasuredWidth(), MusicFileViewer.this.M.getPaint(), 2));
                }
            });
        } else {
            TextView textView = this.M;
            textView.setText(FileManagerUtil.handleLongFileName(str, false, textView.getMeasuredWidth(), this.M.getPaint(), 2));
        }
    }

    public void u(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.H.setOnClickListener(onClickListener);
        }
    }

    public void v(boolean z16) {
        if (z16) {
            this.H.setImageResource(R.drawable.e_a);
            this.H.setContentDescription(this.f208607f.getString(R.string.aa_));
        } else {
            this.H.setImageResource(R.drawable.e_b);
            this.H.setContentDescription(this.f208607f.getString(R.string.aab));
        }
    }

    public void w(boolean z16) {
        this.I.setEnabled(z16);
    }

    public void x(int i3) {
        this.I.setProgress(i3);
    }

    public void y(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        if (onSeekBarChangeListener != null) {
            this.I.setOnSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    public void z(int i3) {
        if (i3 > 0) {
            this.I.setMax(i3);
        }
    }
}

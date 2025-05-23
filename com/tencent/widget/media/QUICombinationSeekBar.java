package com.tencent.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QUICombinationSeekBar extends FrameLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QUISeekBar f384792d;

    /* renamed from: e, reason: collision with root package name */
    private final QUIPlayStatusIconView f384793e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f384794f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f384795h;

    public QUICombinationSeekBar(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private String f(int i3) {
        String valueOf;
        int i16 = i3 / 1000;
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = String.valueOf(i17);
        }
        if (i18 < 10) {
            return String.format("%s:0%s", valueOf, Integer.valueOf(i18));
        }
        return String.format("%s:%s", valueOf, Integer.valueOf(i18));
    }

    @Override // com.tencent.widget.media.a
    public SeekBar a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SeekBar) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f384792d.a();
    }

    public void b(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            if (onSeekBarChangeListener == null) {
                return;
            }
            this.f384792d.z(onSeekBarChangeListener);
        }
    }

    public QUIPlayStatusIconView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (QUIPlayStatusIconView) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f384793e;
    }

    @Override // com.tencent.widget.media.a
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this;
    }

    public QUISeekBar e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QUISeekBar) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f384792d;
    }

    public void g(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.f384792d.U(onSeekBarChangeListener);
        }
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.f384793e.a(z16);
        if (z16) {
            this.f384792d.X();
        } else {
            this.f384792d.T();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            setMeasuredDimension(getMeasuredWidth(), ViewUtils.dip2px(34.0f));
        }
    }

    public void setEnableMinStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.f384792d.setEnableMinStatus(z16);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            super.setEnabled(z16);
            e().setEnabled(z16);
        }
    }

    public void setEventHelper(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bVar);
        } else {
            this.f384792d.setEventHelper(bVar);
        }
    }

    public void setMax(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f384792d.setMax(i3);
            this.f384795h.setText(f(i3));
        }
    }

    public void setMiddleThumbStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.f384792d.setMiddleThumbStyle(i3);
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f384792d.setProgress(i3);
            this.f384794f.setText(f(i3));
        }
    }

    @Override // com.tencent.widget.media.a
    public void setSeekBarListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.f384792d.setSeekBarListener(onSeekBarChangeListener);
        }
    }

    public QUICombinationSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUICombinationSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public QUICombinationSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168949hg2, (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(inflate, layoutParams);
        this.f384792d = (QUISeekBar) inflate.findViewById(R.id.f66433am);
        this.f384793e = (QUIPlayStatusIconView) inflate.findViewById(R.id.f66353ae);
        this.f384794f = (TextView) inflate.findViewById(R.id.f66343ad);
        this.f384795h = (TextView) inflate.findViewById(R.id.f66323ab);
    }
}

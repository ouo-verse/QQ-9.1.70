package com.tencent.centaur.host.loader.debug.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.centaur.host.loader.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CentaurSettingSwitchView extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private TextView f99136d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f99137e;

    /* renamed from: f, reason: collision with root package name */
    private SwitchCompat f99138f;

    /* renamed from: h, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f99139h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CentaurSettingSwitchView.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                CentaurSettingSwitchView.z0(CentaurSettingSwitchView.this);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    public CentaurSettingSwitchView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void A0(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.e1d, (ViewGroup) this, true);
        this.f99136d = (TextView) findViewById(R.id.f10654690);
        this.f99137e = (TextView) findViewById(R.id.f1065368z);
        this.f99138f = (SwitchCompat) findViewById(R.id.f912554o);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f99116q);
        String string = obtainStyledAttributes.getString(c.f99120s);
        String string2 = obtainStyledAttributes.getString(c.f99118r);
        obtainStyledAttributes.recycle();
        this.f99136d.setText(string);
        this.f99137e.setText(string2);
        B0(this.f99138f);
        this.f99138f.setOnCheckedChangeListener(this.f99139h);
    }

    private void B0(SwitchCompat switchCompat) {
        switchCompat.setThumbDrawable(getResources().getDrawable(R.drawable.f160400mp3));
        switchCompat.setTrackDrawable(getResources().getDrawable(R.drawable.jfo));
    }

    static /* synthetic */ b z0(CentaurSettingSwitchView centaurSettingSwitchView) {
        centaurSettingSwitchView.getClass();
        return null;
    }

    public void setChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f99138f.setChecked(z16);
        }
    }

    public void setCheckedOnly(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.f99138f.setOnCheckedChangeListener(null);
        setChecked(z16);
        this.f99138f.setOnCheckedChangeListener(this.f99139h);
    }

    public void setDesTvVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        TextView textView = this.f99137e;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public void setHide(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f99137e.setText(str);
        }
    }

    public void setListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f99136d.setText(str);
        }
    }

    public CentaurSettingSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CentaurSettingSwitchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f99139h = new a();
            A0(context, attributeSet);
        }
    }
}

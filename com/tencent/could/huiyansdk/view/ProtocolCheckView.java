package com.tencent.could.huiyansdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.could.huiyansdk.fragments.ProtocolShowFragment;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class ProtocolCheckView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CheckBox f100354a;

    /* renamed from: b, reason: collision with root package name */
    public Button f100355b;

    public ProtocolCheckView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public boolean getCheckBoxIsSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        CheckBox checkBox = this.f100354a;
        if (checkBox == null) {
            return false;
        }
        return checkBox.isChecked();
    }

    public void setButton(Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) button);
        } else {
            this.f100355b = button;
        }
    }

    public ProtocolCheckView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.i2p, this);
        inflate.findViewById(R.id.f113556qy).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolCheckView.a(view);
            }
        });
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.f113646r7);
        this.f100354a = checkBox;
        checkBox.setChecked(false);
        this.f100354a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.could.huiyansdk.view.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ProtocolCheckView.this.a(compoundButton, z16);
            }
        });
    }

    public ProtocolCheckView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z16) {
        Button button = this.f100355b;
        if (button == null) {
            return;
        }
        if (z16) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
    }

    public static void a(View view) {
        d.b.f100161a.a("ProtocolStage", "ShowProtocolPage", "");
        b.a.f100131a.a(new ProtocolShowFragment());
    }
}

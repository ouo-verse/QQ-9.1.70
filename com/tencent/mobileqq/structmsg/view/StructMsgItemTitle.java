package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgItemTitle extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    public int f290482g1;

    /* renamed from: h1, reason: collision with root package name */
    public boolean f290483h1;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f290484i1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TitleTextView extends TextView {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f290485d;

        public TitleTextView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.f290485d = 0;
            }
        }

        private void a(CharSequence charSequence, int i3) {
            int ceil;
            if (!TextUtils.isEmpty(charSequence) && i3 > 0 && (ceil = (int) Math.ceil(Layout.getDesiredWidth(charSequence, getPaint()))) > i3) {
                int floor = (int) Math.floor((getTextSize() * i3) / ceil);
                if (QLog.isColorLevel()) {
                    QLog.i("StructMsg", 2, "adjustTextSize avail:" + i3 + " width:" + ceil + " oldSize:" + getTextSize() + " newSize:" + floor);
                }
                if (floor == getTextSize()) {
                    floor--;
                }
                setTextSize(0, floor);
                a(charSequence, i3);
            }
        }

        @Override // android.widget.TextView, android.view.View
        protected void onMeasure(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            super.onMeasure(i3, i16);
            int measuredWidth = getMeasuredWidth();
            this.f290485d = measuredWidth;
            a(getText(), (measuredWidth - getPaddingLeft()) - getPaddingRight());
        }
    }

    public StructMsgItemTitle() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.structmsg.b
    protected Class<? extends TextView> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.f290484i1) {
            return TitleTextView.class;
        }
        return super.B();
    }

    public void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f290484i1 = z16;
        }
    }

    public void N(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f290483h1 = z16;
            this.f290482g1 = i3;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        int g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view instanceof TextView) {
            if (TextUtils.isEmpty(this.R0)) {
                g16 = m();
            } else {
                g16 = com.tencent.mobileqq.structmsg.k.g(this.R0);
            }
            ((TextView) view).setTextColor(g16);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Title";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void j(AbsShareMsg absShareMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absShareMsg);
        } else {
            absShareMsg.mContentTitle = this.X0;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.f290483h1 && this.f290482g1 != 0) {
            return -1;
        }
        return -16777216;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 28;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    protected int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.kbs;
    }

    public StructMsgItemTitle(String str) {
        super(str, "title");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f290482g1 = 0;
        this.f290483h1 = false;
        this.f290484i1 = false;
    }
}

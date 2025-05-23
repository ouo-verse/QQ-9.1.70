package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.ForwardHeadView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ForwardRecentRoundItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    public String C;
    public int D;
    public int E;
    public ResultRecord F;

    /* renamed from: d, reason: collision with root package name */
    public View f187018d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f187019e;

    /* renamed from: f, reason: collision with root package name */
    public ForwardHeadView f187020f;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f187021h;

    /* renamed from: i, reason: collision with root package name */
    public QUICheckBox f187022i;

    /* renamed from: m, reason: collision with root package name */
    public RelativeLayout f187023m;

    public ForwardRecentRoundItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            c();
            b();
        }
    }

    private void b() {
        this.D = getResources().getDimensionPixelOffset(R.dimen.aet);
        this.E = getResources().getDimensionPixelOffset(R.dimen.f158606ka);
    }

    private void c() {
        View inflate = View.inflate(getContext(), R.layout.hmp, this);
        this.f187018d = inflate;
        this.f187023m = (RelativeLayout) inflate.findViewById(R.id.ibz);
        this.f187019e = (TextView) this.f187018d.findViewById(R.id.text1);
        ForwardHeadView forwardHeadView = (ForwardHeadView) this.f187018d.findViewById(R.id.head);
        this.f187020f = forwardHeadView;
        this.f187021h = forwardHeadView.a();
        QUICheckBox qUICheckBox = (QUICheckBox) this.f187018d.findViewById(R.id.axa);
        this.f187022i = qUICheckBox;
        qUICheckBox.setType(3);
    }

    public void a(String str, Drawable drawable, ResultRecord resultRecord, boolean z16, boolean z17) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, drawable, resultRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.C = str;
        this.F = resultRecord;
        if (resultRecord != null && !AppConstants.DATALINE_GUILD_UIN.equals(resultRecord.uin) && ((i16 = resultRecord.uinType) == 10016 || i16 == 10014 || i16 == 10027)) {
            this.f187020f.setShowGuildIcon(true);
            if (z16) {
                this.f187022i.setChecked(false);
                this.f187022i.setEnabled(false);
            } else {
                this.f187022i.setEnabled(true);
            }
        } else {
            this.f187022i.setEnabled(true);
            this.f187020f.setShowGuildIcon(false);
        }
        this.f187019e.setText(str);
        this.f187021h.setImageDrawable(drawable);
        this.f187022i.setChecked(z17);
        if (z16) {
            this.f187022i.setVisibility(0);
            Resources resources = getResources();
            if (z17) {
                i3 = R.string.f170750a34;
            } else {
                i3 = R.string.i_z;
            }
            setContentDescription(str + resources.getString(i3));
            return;
        }
        this.f187022i.setVisibility(8);
        setContentDescription(str);
    }

    public void d(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.f187022i.setChecked(z16);
        if (AppSetting.f99565y) {
            Resources resources = getResources();
            if (z16) {
                i3 = R.string.f170750a34;
            } else {
                i3 = R.string.i_z;
            }
            setContentDescription(this.C + resources.getString(i3));
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f187022i.setVisibility(8);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f187022i.setVisibility(0);
        }
    }
}

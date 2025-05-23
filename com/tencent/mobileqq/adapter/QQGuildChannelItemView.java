package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQGuildChannelItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private static final int E;
    private static final int F;
    public View C;
    public ResultRecord D;

    /* renamed from: d, reason: collision with root package name */
    public View f187038d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f187039e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f187040f;

    /* renamed from: h, reason: collision with root package name */
    public CheckBox f187041h;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f187042i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f187043m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            E = ViewUtils.dpToPx(40.0f);
            F = ViewUtils.dpToPx(24.0f);
        }
    }

    public QQGuildChannelItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            a();
        }
    }

    private void a() {
        View inflate = View.inflate(getContext(), R.layout.f3t, this);
        this.f187038d = inflate;
        this.f187042i = (RelativeLayout) inflate.findViewById(R.id.ibz);
        this.f187039e = (TextView) this.f187038d.findViewById(R.id.f94705d0);
        this.f187040f = (TextView) this.f187038d.findViewById(R.id.f94805d_);
        this.f187041h = (CheckBox) this.f187038d.findViewById(R.id.axa);
        this.f187043m = (ImageView) this.f187038d.findViewById(R.id.icon);
        this.C = this.f187038d.findViewById(R.id.xd9);
    }

    public void setMultiSelectStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f187042i.getLayoutParams();
        layoutParams.leftMargin = F;
        this.f187042i.setLayoutParams(layoutParams);
    }
}

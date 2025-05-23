package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
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
public class ForwardRecentItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    public QUICheckBox C;
    public RelativeLayout D;
    public boolean E;
    public View F;
    public String G;
    public int H;
    public int I;
    public ResultRecord J;
    public boolean K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    public View f187008d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f187009e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f187010f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f187011h;

    /* renamed from: i, reason: collision with root package name */
    public ForwardHeadView f187012i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f187013m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f187014d;

        a(RelativeLayout.LayoutParams layoutParams) {
            this.f187014d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentItemView.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f187014d.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ForwardRecentItemView.this.D.setLayoutParams(this.f187014d);
            ForwardRecentItemView forwardRecentItemView = ForwardRecentItemView.this;
            forwardRecentItemView.f187010f.setMaxWidth(forwardRecentItemView.I - forwardRecentItemView.H);
            if (AppSetting.f99565y) {
                Resources resources = ForwardRecentItemView.this.getResources();
                if (ForwardRecentItemView.this.C.isChecked()) {
                    i3 = R.string.f170750a34;
                } else {
                    i3 = R.string.i_z;
                }
                String string = resources.getString(i3);
                ForwardRecentItemView.this.setContentDescription(ForwardRecentItemView.this.G + string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f187016d;

        b(RelativeLayout.LayoutParams layoutParams) {
            this.f187016d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentItemView.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f187016d.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ForwardRecentItemView.this.D.setLayoutParams(this.f187016d);
            ForwardRecentItemView.this.C.setChecked(false);
            ForwardRecentItemView forwardRecentItemView = ForwardRecentItemView.this;
            forwardRecentItemView.f187010f.setMaxWidth(forwardRecentItemView.I);
            if (AppSetting.f99565y) {
                ForwardRecentItemView forwardRecentItemView2 = ForwardRecentItemView.this;
                forwardRecentItemView2.setContentDescription(forwardRecentItemView2.G);
            }
        }
    }

    public ForwardRecentItemView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void c() {
        this.H = getResources().getDimensionPixelOffset(R.dimen.aet);
        this.I = getResources().getDimensionPixelOffset(R.dimen.f158606ka);
    }

    private void d() {
        View inflate = View.inflate(getContext(), R.layout.f169062bw4, this);
        this.f187008d = inflate;
        this.D = (RelativeLayout) inflate.findViewById(R.id.ibz);
        this.f187009e = (TextView) this.f187008d.findViewById(R.id.f27640gs);
        this.f187010f = (TextView) this.f187008d.findViewById(R.id.text1);
        this.f187011h = (TextView) this.f187008d.findViewById(R.id.text2);
        ForwardHeadView forwardHeadView = (ForwardHeadView) this.f187008d.findViewById(R.id.head);
        this.f187012i = forwardHeadView;
        this.f187013m = forwardHeadView.a();
        this.C = (QUICheckBox) this.f187008d.findViewById(R.id.axa);
        this.F = this.f187008d.findViewById(R.id.kab);
    }

    private boolean f() {
        int i3;
        ResultRecord resultRecord = this.J;
        if (resultRecord != null && ((AppConstants.DATALINE_GUILD_UIN.equals(resultRecord.uin) && ((i3 = this.J.uinType) == 10016 || i3 == 10014)) || this.J.uinType == 10027)) {
            return true;
        }
        return false;
    }

    private void i() {
        ResultRecord resultRecord = this.J;
        boolean z16 = true;
        if (resultRecord == null) {
            this.K = true;
            return;
        }
        if (resultRecord.uinType == 10027) {
            z16 = false;
        }
        this.K = z16;
    }

    public void a(String str, String str2, Drawable drawable, ResultRecord resultRecord, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, drawable, resultRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            b(str, str2, drawable, resultRecord, z16, z17, false);
        }
    }

    public void b(String str, String str2, Drawable drawable, ResultRecord resultRecord, boolean z16, boolean z17, boolean z18) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, drawable, resultRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.G = str;
        this.J = resultRecord;
        this.f187012i.setShowGuildIcon(f());
        i();
        this.f187010f.setText(str);
        this.f187013m.setImageDrawable(drawable);
        if (TextUtils.isEmpty(str2)) {
            this.f187011h.setVisibility(8);
        } else {
            this.f187011h.setVisibility(0);
            if (str2.startsWith("(")) {
                this.f187011h.setText(str2);
            } else {
                this.f187011h.setText(String.format("(%s)", str2));
            }
        }
        View view = this.F;
        if (view != null) {
            if (z18) {
                i16 = 0;
            }
            view.setVisibility(i16);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        int i17 = this.H;
        layoutParams.leftMargin = -i17;
        int i18 = this.I;
        this.L = z16;
        if (z16) {
            layoutParams.leftMargin = 0;
            i18 -= i17;
        }
        this.D.setLayoutParams(layoutParams);
        this.C.setEnabled(this.K);
        if (this.K) {
            this.C.setChecked(z17);
        } else {
            this.C.setChecked(false);
        }
        this.f187010f.setMaxWidth(i18);
        Resources resources = getResources();
        if (z17) {
            i3 = R.string.f170750a34;
        } else {
            i3 = R.string.i_z;
        }
        setContentDescription(str + resources.getString(i3));
    }

    public void e(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.C.setChecked(z16);
        if (AppSetting.f99565y) {
            Resources resources = getResources();
            if (z16) {
                i3 = R.string.f170750a34;
            } else {
                i3 = R.string.i_z;
            }
            setContentDescription(this.G + resources.getString(i3));
        }
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
            return;
        }
        if (!this.L) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.H);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new b(layoutParams));
        this.L = false;
        ofInt.start();
    }

    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        if (this.L) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.H, 0);
        ofInt.setInterpolator(new com.tencent.mobileqq.widget.g());
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new a(layoutParams));
        this.L = true;
        ofInt.start();
    }

    public void setMultiSelectStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.L = true;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.D.setLayoutParams(layoutParams);
        this.f187010f.setMaxWidth(this.I - this.H);
    }

    public ForwardRecentItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ForwardRecentItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = false;
        this.L = false;
        d();
        c();
    }
}

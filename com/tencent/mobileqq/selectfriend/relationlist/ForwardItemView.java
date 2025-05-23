package com.tencent.mobileqq.selectfriend.relationlist;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.widget.g;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ForwardItemView extends RelativeLayout {
    public RelativeLayout C;
    public View D;
    public View E;
    public String F;
    public int G;
    public int H;
    public SharedNode I;

    /* renamed from: d, reason: collision with root package name */
    public View f285539d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f285540e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f285541f;

    /* renamed from: h, reason: collision with root package name */
    public ForwardAvatarView f285542h;

    /* renamed from: i, reason: collision with root package name */
    public QQProAvatarView f285543i;

    /* renamed from: m, reason: collision with root package name */
    public QUICheckBox f285544m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f285545d;

        a(RelativeLayout.LayoutParams layoutParams) {
            this.f285545d = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f285545d.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ForwardItemView.this.C.setLayoutParams(this.f285545d);
            ForwardItemView forwardItemView = ForwardItemView.this;
            forwardItemView.f285540e.setMaxWidth(forwardItemView.H - forwardItemView.G);
            if (AppSetting.f99565y) {
                String string = ForwardItemView.this.getResources().getString(ForwardItemView.this.f285544m.isChecked() ? R.string.f170750a34 : R.string.i_z);
                ForwardItemView.this.setContentDescription(ForwardItemView.this.F + string);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f285547d;

        b(RelativeLayout.LayoutParams layoutParams) {
            this.f285547d = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f285547d.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ForwardItemView.this.C.setLayoutParams(this.f285547d);
            ForwardItemView.this.f285544m.setChecked(false);
            ForwardItemView forwardItemView = ForwardItemView.this;
            forwardItemView.f285540e.setMaxWidth(forwardItemView.H);
            if (AppSetting.f99565y) {
                ForwardItemView forwardItemView2 = ForwardItemView.this;
                forwardItemView2.setContentDescription(forwardItemView2.F);
            }
        }
    }

    public ForwardItemView(Context context) {
        this(context, null);
    }

    private void b() {
        this.G = getResources().getDimensionPixelOffset(R.dimen.aet);
        this.H = getResources().getDimensionPixelOffset(R.dimen.f158606ka);
    }

    private void c() {
        View inflate = View.inflate(getContext(), R.layout.cyn, this);
        this.f285539d = inflate;
        this.C = (RelativeLayout) inflate.findViewById(R.id.f163194ot3);
        this.f285540e = (TextView) this.f285539d.findViewById(R.id.ot9);
        this.f285541f = (TextView) this.f285539d.findViewById(R.id.ot_);
        ForwardAvatarView forwardAvatarView = (ForwardAvatarView) this.f285539d.findViewById(R.id.f163191ot0);
        this.f285542h = forwardAvatarView;
        this.f285543i = forwardAvatarView.a();
        this.f285544m = (QUICheckBox) this.f285539d.findViewById(R.id.osx);
        this.D = this.f285539d.findViewById(R.id.otb);
        this.E = this.f285539d.findViewById(R.id.osv);
    }

    public void d(long j3) {
        f(this.I, false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.G);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new b(layoutParams));
        ofInt.start();
    }

    public void e(long j3) {
        f(this.I, true);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.G, 0);
        ofInt.setInterpolator(new g());
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new a(layoutParams));
        ofInt.start();
    }

    public void setMultiSelectStatus() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.C.setLayoutParams(layoutParams);
        this.f285540e.setMaxWidth(this.H - this.G);
    }

    public ForwardItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForwardItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
        b();
    }

    private void f(SharedNode sharedNode, boolean z16) {
        if (sharedNode == null) {
            return;
        }
        if (e.f285562a.h(sharedNode) && z16) {
            this.f285544m.setEnabled(false);
            setClickable(false);
        } else {
            this.f285544m.setEnabled(true);
            setClickable(true);
        }
    }

    public void a(SharedNode sharedNode, Drawable drawable, boolean z16, boolean z17) {
        if (sharedNode == null) {
            return;
        }
        this.F = sharedNode.getTitle();
        this.I = sharedNode;
        if (AppConstants.DATALINE_GUILD_UIN.equals(sharedNode.getKey()) && (String.valueOf(10016).equals(sharedNode.getType()) || String.valueOf(10014).equals(sharedNode.getType()) || String.valueOf(10027).equals(sharedNode.getType()))) {
            this.f285542h.setShowGuildIcon(true);
        } else {
            this.f285542h.setShowGuildIcon(false);
        }
        this.f285540e.setText(this.F);
        if (drawable != null) {
            this.f285543i.setImageDrawable(drawable);
        } else {
            this.f285543i.x(sharedNode.getAvatarType(), sharedNode.getKey(), new e.a().g(100).a());
        }
        String tips = sharedNode.getTips();
        if (TextUtils.isEmpty(tips)) {
            this.f285541f.setVisibility(8);
        } else {
            this.f285541f.setVisibility(0);
            if (tips.startsWith("(")) {
                this.f285541f.setText(tips);
            } else {
                this.f285541f.setText(String.format("(%s)", tips));
            }
        }
        View view = this.D;
        if (view != null) {
            view.setVisibility(sharedNode.isRobot() ? 0 : 8);
        }
        View view2 = this.E;
        if (view2 != null) {
            view2.setVisibility(sharedNode.getNeedRightArrow() ? 0 : 8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        int i3 = this.G;
        layoutParams.leftMargin = -i3;
        int i16 = this.H;
        if (z16) {
            layoutParams.leftMargin = 0;
            i16 -= i3;
        }
        this.C.setLayoutParams(layoutParams);
        this.f285544m.setChecked(z17);
        f(sharedNode, z16);
        this.f285540e.setMaxWidth(i16);
        setContentDescription(this.F + getResources().getString(z17 ? R.string.f170750a34 : R.string.i_z));
    }
}

package com.tencent.mobileqq.mutualmark.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkIcon extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private ValueAnimator C;
    private int D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private final View f252313d;

    /* renamed from: e, reason: collision with root package name */
    private final QUIShimmerImageView f252314e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f252315f;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f252316h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f252317i;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f252318m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MutualMarkIcon.this.l(((Float) valueAnimator.getAnimatedValue()).floatValue());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            MutualMarkIcon.this.D++;
            if (MutualMarkIcon.this.D >= 2) {
                MutualMarkIcon.this.C.start();
            } else if (MutualMarkIcon.this.f252318m != null) {
                MutualMarkIcon.this.f252318m.cancel();
                MutualMarkIcon.this.f252318m.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MutualMarkIcon.this.l(((Float) valueAnimator.getAnimatedValue()).floatValue());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else if (MutualMarkIcon.this.f252317i != null) {
                MutualMarkIcon.this.f252317i.cancel();
                MutualMarkIcon.this.f252317i.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                MutualMarkIcon.this.f252314e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public MutualMarkIcon(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void j() {
        ValueAnimator valueAnimator = this.f252318m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f252318m = null;
        }
        ValueAnimator valueAnimator2 = this.f252317i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f252317i = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f252317i = ofFloat;
        ofFloat.setRepeatCount(0);
        this.f252317i.addUpdateListener(new a());
        this.f252317i.addListener(new b());
        he0.b.m(this.f252317i, R.anim.f154986ut, 6.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f252318m = ofFloat2;
        ofFloat2.setRepeatCount(0);
        this.f252318m.addUpdateListener(new c());
        this.f252318m.addListener(new d());
        he0.b.m(this.f252318m, R.anim.f154986ut, 6.0f);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.5f);
        this.C = ofFloat3;
        he0.b.m(ofFloat3, R.anim.f154986ut, 3.0f);
        this.C.setRepeatCount(0);
        this.C.addUpdateListener(new e());
    }

    private void k(MutualMarkModel mutualMarkModel, int i3) {
        HashMap<String, Object> interactTagAreaData = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getInteractTagAreaData();
        interactTagAreaData.put("interact_tag_id", Long.valueOf(mutualMarkModel.D));
        if (!mutualMarkModel.N) {
            interactTagAreaData.put("interact_tag_status", "0");
        } else if (!mutualMarkModel.M) {
            interactTagAreaData.put("interact_tag_status", "2");
        } else {
            interactTagAreaData.put("interact_tag_status", "1");
        }
        interactTagAreaData.put("interact_tag_rank", Integer.valueOf(i3));
        if (mutualMarkModel.f252157e == MutualMarkModel.f252153c0) {
            interactTagAreaData.put("interact_tag_is_new", "1");
        } else {
            interactTagAreaData.put("interact_tag_is_new", "2");
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_interact_tag_specific", null, interactTagAreaData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f16) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f16);
        this.f252314e.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public void h(MutualMarkModel mutualMarkModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mutualMarkModel);
        } else {
            i(mutualMarkModel, 0, true);
        }
    }

    public void i(MutualMarkModel mutualMarkModel, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, mutualMarkModel, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setIconWithModel(this.f252314e, mutualMarkModel, true, null);
        }
        if (!TextUtils.isEmpty(mutualMarkModel.f252160i)) {
            this.f252315f.setImageDrawable(f.a(mutualMarkModel.f252160i));
        } else {
            this.f252315f.setImageDrawable(null);
        }
        if (mutualMarkModel.M) {
            this.f252316h.setVisibility(0);
            this.f252316h.setImageDrawable(f.a("https://downv6.qq.com/extendfriend/mutual_tag_peidai.png"));
        } else if (mutualMarkModel.S) {
            this.f252316h.setVisibility(0);
            this.f252316h.setImageDrawable(f.a("https://downv6.qq.com/extendfriend/mutual_tag_new.png"));
        } else {
            this.f252316h.setImageDrawable(null);
        }
        if (mutualMarkModel.R) {
            this.f252314e.setAlpha(0.5f);
        } else {
            this.f252314e.setAlpha(1.0f);
        }
        this.f252313d.setBackgroundResource(R.drawable.ksv);
        if (mutualMarkModel.f252157e == MutualMarkModel.f252153c0) {
            this.f252314e.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.widget.MutualMarkIcon.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MutualMarkIcon.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MutualMarkIcon.this.m();
                    }
                }
            }, 1500L);
        }
        k(mutualMarkModel, i3);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f252314e.updateColors(0, ColorUtils.setAlphaComponent(this.E, 153), ColorUtils.setAlphaComponent(this.E, 102), 0);
            this.f252314e.startShimming(null);
        }
    }

    public void setElementParams(View view, String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, str, map);
            return;
        }
        VideoReport.setElementId(view, str);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public MutualMarkIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MutualMarkIcon(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = 0;
        View inflate = View.inflate(getContext(), R.layout.gz6, null);
        this.f252313d = inflate;
        addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
        QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) inflate.findViewById(R.id.zlc);
        this.f252314e = qUIShimmerImageView;
        qUIShimmerImageView.setImageDrawable(new ColorDrawable(0));
        qUIShimmerImageView.updateRepeatCount(0);
        this.f252315f = (ImageView) inflate.findViewById(R.id.zle);
        this.f252316h = (ImageView) inflate.findViewById(R.id.zld);
        this.E = context.getResources().getColor(R.color.cpf, null);
        j();
        setElementParams(inflate, "em_interact_tag_specific", null);
    }
}

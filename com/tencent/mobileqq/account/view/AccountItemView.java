package com.tencent.mobileqq.account.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemConstants;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AccountItemView extends RelativeLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private b C;
    ImageView D;
    private QQAccount E;
    private int F;
    private final Rect G;
    private final Paint H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    private View f174512d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f174513e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f174514f;

    /* renamed from: h, reason: collision with root package name */
    private QQProAvatarView f174515h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f174516i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f174517m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountItemView.this);
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
            } else {
                AccountItemView.this.f174517m.setVisibility(8);
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

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(AccountItemView accountItemView, QQAccount qQAccount);

        void b(AccountItemView accountItemView, QQAccount qQAccount);

        void c(AccountItemView accountItemView, QQAccount qQAccount);
    }

    public AccountItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.G = new Rect();
        this.H = new Paint();
        this.I = 0;
    }

    public static Drawable b(Context context, float f16, float f17) {
        return QUIListItemBackgroundType.INSTANCE.a(context, 1000, R.color.qui_common_fill_light_secondary, f16, f17);
    }

    private void f(View view) {
        if (view.getTag() instanceof ObjectAnimator) {
            ((ObjectAnimator) view.getTag()).cancel();
        }
        view.setTranslationX(0.0f);
    }

    private void i(View view, float f16, float f17, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f16, f17);
        ofFloat.setDuration(250L);
        if (view.getTag() != null) {
            ((ObjectAnimator) view.getTag()).cancel();
        }
        view.setTag(ofFloat);
        ofFloat.start();
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
    }

    private void j() {
        this.f174514f.setText(this.E.getNickname());
        TextView textView = this.f174514f;
        textView.setContentDescription(textView.getText());
        this.f174513e.setText(this.E.getUin());
        this.f174515h.w(1, this.E.getUin());
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.f174516i.setVisibility(8);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAccount qQAccount = this.E;
        if (qQAccount != null && qQAccount.getUin() != null && TextUtils.equals(this.E.getUin(), peekAppRuntime.getCurrentAccountUin())) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        View view = this.f174512d;
        i(view, view.getTranslationX(), 0.0f, null);
        ImageView imageView = this.f174516i;
        i(imageView, imageView.getTranslationX(), 0.0f, null);
        a aVar = new a();
        TextView textView = this.f174517m;
        i(textView, textView.getTranslationX(), 0.0f, aVar);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f(this.f174512d);
        f(this.f174516i);
        f(this.f174517m);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f174516i.setVisibility(0);
        if (this.D.getVisibility() == 0) {
            this.D.setVisibility(8);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f174517m.setVisibility(0);
        i(this.f174512d, 0.0f, -this.F, null);
        i(this.f174516i, 0.0f, -this.F, null);
        i(this.f174517m, 0.0f, -this.F, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f75693zn) {
            b bVar2 = this.C;
            if (bVar2 != null) {
                bVar2.a(this, this.E);
            }
        } else if (view.getId() == R.id.f165921y23) {
            b bVar3 = this.C;
            if (bVar3 != null) {
                bVar3.c(this, this.E);
            }
        } else if (view.getId() == R.id.agp && (bVar = this.C) != null) {
            bVar.b(this, this.E);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.I;
        if (i3 == 1 || i3 == 2) {
            this.H.setColor(ContextCompat.getColor(getContext(), R.color.qui_common_border_standard));
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.G;
            int i16 = FormItemConstants.PADDING_DEFAULT_BG_DIVIDER;
            rect.set(i16, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth - i16, measuredHeight);
            canvas.drawRect(this.G, this.H);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.f174512d = findViewById(R.id.f166091ed3);
        this.f174513e = (TextView) findViewById(R.id.f1057466u);
        this.f174514f = (TextView) findViewById(R.id.k9t);
        this.f174515h = (QQProAvatarView) findViewById(R.id.f165909du3);
        this.f174516i = (ImageView) findViewById(R.id.f165921y23);
        this.f174517m = (TextView) findViewById(R.id.agp);
        this.D = (ImageView) findViewById(R.id.check);
        findViewById(R.id.f75693zn).setOnClickListener(this);
        this.f174516i.setOnClickListener(this);
        this.f174517m.setOnClickListener(this);
        this.F = ViewUtils.dip2px(70.0f);
    }

    public void setAccount(QQAccount qQAccount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAccount);
        } else {
            this.E = qQAccount;
            j();
        }
    }

    public void setOnItemClickListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.C = bVar;
        }
    }

    public void setPosition(int i3, int i16) {
        Drawable b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        float dimension = getContext().getResources().getDimension(R.dimen.d_y);
        if (i16 == 1) {
            b16 = b(getContext(), dimension, dimension);
            this.I = 0;
        } else if (i3 == i16 - 1) {
            b16 = b(getContext(), 0.0f, dimension);
            this.I = 3;
        } else if (i3 == 0) {
            b16 = b(getContext(), dimension, 0.0f);
            this.I = 1;
        } else {
            b16 = b(getContext(), 0.0f, 0.0f);
            this.I = 2;
        }
        setBackground(b16);
    }

    public AccountItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.G = new Rect();
        this.H = new Paint();
        this.I = 0;
    }
}

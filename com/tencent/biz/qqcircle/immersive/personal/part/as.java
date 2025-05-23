package com.tencent.biz.qqcircle.immersive.personal.part;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class as extends com.tencent.biz.qqcircle.immersive.part.u {
    public static final int W = cx.a(188.0f);
    private View C;
    private ImageView D;
    private int E;
    private int F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private Drawable M;
    private Drawable N;
    private Drawable P;
    private Drawable Q;
    private Drawable R;
    private Drawable S;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r T;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t U;
    private boolean V = false;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f88884d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f88885e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f88886f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f88887h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f88888i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f88889m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends m60.a {
        a() {
        }

        @Override // m60.a
        public void d(@NonNull RecyclerView recyclerView, int i3, int i16, int i17) {
            as.this.B9(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<as> f88891d;

        /* renamed from: e, reason: collision with root package name */
        private int f88892e;

        /* renamed from: f, reason: collision with root package name */
        private int f88893f;

        b(as asVar, int i3, int i16) {
            this.f88891d = new WeakReference<>(asVar);
            this.f88892e = i3;
            this.f88893f = i16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WeakReference<as> weakReference = this.f88891d;
            if (weakReference != null && weakReference.get() != null) {
                this.f88891d.get().D9(this.f88892e, this.f88893f, valueAnimator);
            }
        }
    }

    private void A9(ImageView imageView, Drawable drawable) {
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
            imageView.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9(int i3) {
        int i16 = (int) (((i3 * 1.0f) / W) * 255.0f);
        if (i16 > 255) {
            i16 = 255;
        } else if (i16 < 10) {
            i16 = 0;
        }
        F9(i16);
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.T;
        if (rVar == null) {
            return;
        }
        rVar.u2().setValue(Integer.valueOf(i16));
    }

    private void C9(int i3, int i16) {
        if (this.V) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(i3, i16).setDuration(200L);
        this.V = true;
        duration.addUpdateListener(new b(this, i3, i16));
        duration.start();
        ValueAnimator duration2 = ValueAnimator.ofInt(i16, i3).setDuration(200L);
        duration2.setStartDelay(200L);
        duration2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(int i3, int i16, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (i16 == 255 && this.f88885e.getDrawable() != null) {
            Drawable drawable = this.f88885e.getDrawable();
            Drawable drawable2 = this.G;
            if (drawable != drawable2) {
                A9(this.f88885e, drawable2);
                A9(this.f88889m, this.K);
                A9(this.f88886f, this.I);
                A9(this.f88887h, this.P);
                A9(this.f88888i, this.R);
                A9(this.D, this.M);
            }
        }
        boolean z16 = true;
        E9(this.f88885e, intValue, true);
        E9(this.f88886f, intValue, true);
        E9(this.f88887h, intValue, true);
        E9(this.f88888i, intValue, true);
        E9(this.f88889m, intValue, true);
        E9(this.D, intValue, true);
        if (i16 == intValue && i16 == 0) {
            A9(this.f88885e, this.H);
            A9(this.f88889m, this.L);
            A9(this.f88886f, this.J);
            A9(this.f88887h, this.Q);
            A9(this.f88888i, this.S);
            A9(this.D, this.N);
            QUIImmersiveHelper.s(getActivity(), true, false);
        }
        if (i16 == intValue) {
            z16 = false;
        }
        this.V = z16;
    }

    private void E9(ImageView imageView, int i3, boolean z16) {
        if (imageView == null) {
            return;
        }
        if (imageView.getBackground() != null) {
            imageView.getBackground().setAlpha(i3);
        }
        if (z16) {
            imageView.setAlpha((float) ((i3 * 1.0d) / 255.0d));
        }
    }

    private void F9(int i3) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.U;
        if (tVar != null && tVar.N1() != null) {
            this.f88884d.setBackgroundColor(Color.argb(i3, Color.red(this.F), Color.green(this.F), Color.blue(this.F)));
            this.C.setVisibility(0);
            if (i3 == 0) {
                this.f88884d.setBackgroundColor(this.E);
                this.C.setVisibility(8);
                QUIImmersiveHelper.s(getActivity(), true, false);
            } else if (i3 >= 255) {
                this.f88884d.setBackgroundColor(this.F);
            }
            ImageView imageView = this.f88885e;
            if (imageView != null && imageView.getBackground() != null) {
                if (i3 < 255 && this.f88885e.getBackground().getAlpha() == 0) {
                    C9(0, 255);
                } else if (i3 >= 255 && this.f88885e.getBackground().getAlpha() != 0) {
                    C9(255, 0);
                }
            }
        }
    }

    private void G9() {
        if (getContext() != null && getContext().getResources() != null) {
            this.G = getContext().getResources().getDrawable(R.drawable.qui_chevron_left_icon_white);
            this.H = getContext().getResources().getDrawable(R.drawable.qui_chevron_left);
            this.I = getContext().getResources().getDrawable(R.drawable.qui_question_mark_circle_icon_white);
            this.J = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_question_mark_circle);
            this.F = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_light);
            this.E = getContext().getResources().getColor(R.color.cjt);
            this.K = getContext().getResources().getDrawable(R.drawable.qui_chat_settings_icon_white);
            this.L = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_chat_settings);
            this.M = getContext().getResources().getDrawable(R.drawable.qui_face_to_face_add_friend_icon_white);
            this.N = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_face_to_face_add_friend);
            this.P = getContext().getResources().getDrawable(R.drawable.qui_more_icon_white);
            this.Q = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_more);
            this.R = getContext().getResources().getDrawable(R.drawable.qui_question_mark_circle_icon_white);
            this.S = QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_question_mark_circle);
            A9(this.f88885e, this.G);
            A9(this.f88889m, this.K);
            A9(this.f88886f, this.I);
            A9(this.f88887h, this.P);
            A9(this.f88888i, this.R);
            A9(this.D, this.M);
        }
    }

    private void H9(View view) {
        ((RecyclerView) view.findViewById(R.id.f73913uu)).addOnScrollListener(new a());
    }

    private void initViewModel() {
        this.T = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.U = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalTitleSlidingPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88885e = (ImageView) view.findViewById(R.id.f44611pn);
        this.f88884d = (RelativeLayout) view.findViewById(R.id.f760340k);
        this.f88886f = (ImageView) view.findViewById(R.id.y77);
        this.f88887h = (ImageView) view.findViewById(R.id.f44511pd);
        this.f88888i = (ImageView) view.findViewById(R.id.f44521pe);
        this.f88889m = (ImageView) view.findViewById(R.id.f44641pq);
        this.C = view.findViewById(R.id.f1186774s);
        this.D = (ImageView) view.findViewById(R.id.y75);
        G9();
        initViewModel();
        H9(view);
    }
}

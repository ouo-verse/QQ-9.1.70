package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class Face2FaceFriendBubbleView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private static final int[] P;
    private TextView C;
    private Animation D;
    private Animation E;
    private HashMap<View, Integer> F;
    private String G;
    private int H;
    private String I;
    private int J;
    private int K;
    private int L;
    private Animation.AnimationListener M;
    private Animation.AnimationListener N;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f205688d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f205689e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f205690f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f205691h;

    /* renamed from: i, reason: collision with root package name */
    private View f205692i;

    /* renamed from: m, reason: collision with root package name */
    private ProgressBar f205693m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceFriendBubbleView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Face2FaceFriendBubbleView.this.f205692i.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (Face2FaceFriendBubbleView.this.L == 1) {
                Face2FaceFriendBubbleView.this.f205691h.setVisibility(8);
                Face2FaceFriendBubbleView.this.f205693m.setVisibility(8);
            } else if (Face2FaceFriendBubbleView.this.L == 2) {
                Face2FaceFriendBubbleView.this.f205691h.setImageResource(R.drawable.f160727cm1);
                Face2FaceFriendBubbleView.this.f205691h.setVisibility(0);
                Face2FaceFriendBubbleView.this.f205693m.setVisibility(8);
            } else if (Face2FaceFriendBubbleView.this.L == 3) {
                Face2FaceFriendBubbleView.this.f205691h.setImageResource(R.drawable.f160728cm2);
                Face2FaceFriendBubbleView.this.f205691h.setVisibility(0);
                Face2FaceFriendBubbleView.this.f205693m.setVisibility(8);
            } else if (Face2FaceFriendBubbleView.this.L == 4) {
                Face2FaceFriendBubbleView.this.f205691h.setImageResource(R.drawable.f160729cm3);
                Face2FaceFriendBubbleView.this.f205691h.setVisibility(0);
                Face2FaceFriendBubbleView.this.f205693m.setVisibility(0);
            }
            Face2FaceFriendBubbleView.this.f205692i.setVisibility(4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceFriendBubbleView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else if (Face2FaceFriendBubbleView.this.L != 2 && Face2FaceFriendBubbleView.this.L != 3 && Face2FaceFriendBubbleView.this.L != 4) {
                Face2FaceFriendBubbleView.this.f205692i.setVisibility(8);
            } else {
                Face2FaceFriendBubbleView.this.f205692i.startAnimation(Face2FaceFriendBubbleView.this.D);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f205696d;

        /* renamed from: e, reason: collision with root package name */
        private View f205697e;

        public c(int i3, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Face2FaceFriendBubbleView.this, Integer.valueOf(i3), view);
            } else {
                this.f205696d = i3;
                this.f205697e = view;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            View view = this.f205697e;
            if (view == null) {
                return;
            }
            int i3 = this.f205696d;
            if (i3 == 0) {
                view.setVisibility(0);
            } else if (i3 == 1) {
                view.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            P = new int[]{R.id.col, R.id.co9};
        }
    }

    public Face2FaceFriendBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f205689e = null;
        this.f205690f = null;
        this.f205691h = null;
        this.f205692i = null;
        this.f205693m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = 1;
        this.I = "";
        this.J = 0;
        this.K = 0;
        this.L = 1;
        this.M = new a();
        this.N = new b();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f167949ns, this);
        this.f205688d = (LinearLayout) findViewById(R.id.coi);
        this.f205689e = (ImageView) findViewById(R.id.cnp);
        this.f205690f = (ImageView) findViewById(R.id.jyo);
        this.f205692i = findViewById(R.id.col);
        this.f205691h = (ImageView) findViewById(R.id.cok);
        this.f205693m = (ProgressBar) findViewById(R.id.j28);
        TextView textView = (TextView) findViewById(R.id.coa);
        this.C = textView;
        textView.setContentDescription("");
        this.D = AnimationUtils.loadAnimation(context, R.anim.f154547b1);
        this.E = AnimationUtils.loadAnimation(context, R.anim.f154546b0);
        this.D.setAnimationListener(this.M);
        this.E.setAnimationListener(this.N);
    }

    public void f(QQAppInterface qQAppInterface, e eVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface, (Object) eVar);
            return;
        }
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e(Face2FaceAddFriendActivity.E1, 2, "bindFriendInfo Face2FaceUserData is Null~~~~~");
                return;
            }
            return;
        }
        setTag(eVar);
        String str2 = eVar.f205754b;
        this.G = str2;
        this.H = eVar.f205753a;
        this.I = str2;
        boolean z16 = eVar instanceof com.tencent.mobileqq.facetoface.c;
        if (z16) {
            this.I = eVar.f205754b + "_" + ((com.tencent.mobileqq.facetoface.c) eVar).f205749d;
        }
        String str3 = eVar.f205754b;
        int i3 = this.H;
        if (i3 == 1) {
            g gVar = (g) eVar;
            if (TextUtils.isEmpty(gVar.f205761d)) {
                str = gVar.f205762e;
            } else {
                str = gVar.f205761d;
            }
            str3 = str;
            this.C.setLines(1);
            this.f205690f.setVisibility(8);
        } else if (i3 == 2) {
            if (eVar instanceof f) {
                str3 = ((f) eVar).f205755c;
                this.C.setLines(1);
                this.f205690f.setVisibility(8);
                i3 = 1;
            } else if (z16) {
                str3 = ((com.tencent.mobileqq.facetoface.c) eVar).f205748c;
                this.f205690f.setVisibility(0);
                if (this.J < 1) {
                    this.K = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158754o1);
                    this.J = BaseApplication.getContext().getResources().getDrawable(R.drawable.cmi).getIntrinsicWidth();
                }
                this.C.setLines(2);
                this.C.setMaxWidth(this.K - this.J);
                if (QLog.isColorLevel()) {
                    QLog.e("zivonchen", 2, "nickMaxWidth = " + this.K + ", flagWidth = " + this.J + ", realWidth = " + (this.K - this.J));
                }
            }
        }
        if (str3 == null) {
            str3 = this.G;
        } else if (TextUtils.isEmpty(str3.trim())) {
            str3 = this.G;
        }
        this.C.setText(str3);
        m(qQAppInterface, this.G, i3);
    }

    public e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (getTag() != null) {
            return (e) getTag();
        }
        return null;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String charSequence = this.C.getText().toString();
        if (TextUtils.isEmpty(charSequence.trim())) {
            return this.G;
        }
        return charSequence;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.I;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.L;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.G;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.H;
    }

    public void m(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qQAppInterface, str, Integer.valueOf(i3));
        } else if (i3 == 1) {
            this.f205689e.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 1, str));
        } else if (i3 == 2) {
            this.f205689e.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 4, str));
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int length = P.length;
        HashMap<View, Integer> hashMap = this.F;
        if (hashMap != null && hashMap.size() == length) {
            for (int i3 = 0; i3 < length; i3++) {
                View findViewById = findViewById(P[i3]);
                if (this.F.get(findViewById).intValue() == 0 && findViewById.getVisibility() == 4) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154545az);
                    loadAnimation.setAnimationListener(new c(0, findViewById));
                    findViewById.startAnimation(loadAnimation);
                }
            }
            this.F.clear();
            return;
        }
        HashMap<View, Integer> hashMap2 = this.F;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.e(Face2FaceAddFriendActivity.E1, 2, "restoreAndHideLables error: ids.size not equals cache.size~~~~~");
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int length = P.length;
        HashMap<View, Integer> hashMap = this.F;
        if (hashMap == null) {
            this.F = new HashMap<>(length);
        } else if (!hashMap.isEmpty()) {
            this.F.clear();
        }
        for (int i3 = 0; i3 < length; i3++) {
            View findViewById = findViewById(P[i3]);
            int visibility = findViewById.getVisibility();
            this.F.put(findViewById, Integer.valueOf(visibility));
            if (visibility == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154544ay);
                loadAnimation.setAnimationListener(new c(1, findViewById));
                findViewById.startAnimation(loadAnimation);
            }
        }
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.C.setText(str);
        }
    }

    public void setStatusWithAnimation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3 || i3 == 4) {
                this.L = i3;
                if (this.f205692i.getVisibility() == 0) {
                    this.f205692i.startAnimation(this.E);
                } else {
                    if (this.f205692i.getVisibility() == 8) {
                        this.f205692i.setVisibility(4);
                    }
                    this.f205692i.startAnimation(this.D);
                }
            }
        } else {
            this.L = i3;
            if (this.f205692i.getVisibility() == 0) {
                this.f205692i.startAnimation(this.E);
            }
        }
        String h16 = h();
        if (i3 == 2) {
            h16 = h16 + HardCodeUtil.qqStr(R.string.mc5);
        } else if (i3 == 3) {
            h16 = h16 + HardCodeUtil.qqStr(R.string.f171962mc3);
        } else if (i3 == 4) {
            h16 = h16 + HardCodeUtil.qqStr(R.string.mc7);
        }
        this.f205689e.setContentDescription(h16);
        this.f205688d.setContentDescription(h16);
    }

    public void setStatusWithoutAnimation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.L = i3;
                        this.f205693m.setVisibility(0);
                        this.f205691h.setImageResource(R.drawable.f160729cm3);
                        this.f205691h.setVisibility(0);
                        this.f205692i.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.L = i3;
                this.f205693m.setVisibility(8);
                this.f205691h.setImageResource(R.drawable.f160728cm2);
                this.f205691h.setVisibility(0);
                this.f205692i.setVisibility(0);
                return;
            }
            this.L = i3;
            this.f205693m.setVisibility(8);
            this.f205691h.setImageResource(R.drawable.f160727cm1);
            this.f205691h.setVisibility(0);
            this.f205692i.setVisibility(0);
            return;
        }
        this.L = i3;
        this.f205692i.setVisibility(8);
    }

    public Face2FaceFriendBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }
}

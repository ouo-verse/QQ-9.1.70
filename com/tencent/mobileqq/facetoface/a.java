package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;
    public static byte[] C;
    public QQAppInterface A;
    public Context B;

    /* renamed from: a, reason: collision with root package name */
    int f205706a;

    /* renamed from: b, reason: collision with root package name */
    double f205707b;

    /* renamed from: c, reason: collision with root package name */
    float f205708c;

    /* renamed from: d, reason: collision with root package name */
    float f205709d;

    /* renamed from: e, reason: collision with root package name */
    boolean f205710e;

    /* renamed from: f, reason: collision with root package name */
    int f205711f;

    /* renamed from: g, reason: collision with root package name */
    boolean f205712g;

    /* renamed from: h, reason: collision with root package name */
    public int f205713h;

    /* renamed from: i, reason: collision with root package name */
    public int f205714i;

    /* renamed from: j, reason: collision with root package name */
    ImageView f205715j;

    /* renamed from: k, reason: collision with root package name */
    public List<Face2FaceFriendBubbleView> f205716k;

    /* renamed from: l, reason: collision with root package name */
    List<Integer> f205717l;

    /* renamed from: m, reason: collision with root package name */
    List<Integer> f205718m;

    /* renamed from: n, reason: collision with root package name */
    Map<String, Integer> f205719n;

    /* renamed from: o, reason: collision with root package name */
    List<Integer> f205720o;

    /* renamed from: p, reason: collision with root package name */
    List<Integer> f205721p;

    /* renamed from: q, reason: collision with root package name */
    int f205722q;

    /* renamed from: r, reason: collision with root package name */
    int f205723r;

    /* renamed from: s, reason: collision with root package name */
    int f205724s;

    /* renamed from: t, reason: collision with root package name */
    com.tencent.mobileqq.facetoface.e f205725t;

    /* renamed from: u, reason: collision with root package name */
    int f205726u;

    /* renamed from: v, reason: collision with root package name */
    int f205727v;

    /* renamed from: w, reason: collision with root package name */
    int f205728w;

    /* renamed from: x, reason: collision with root package name */
    int f205729x;

    /* renamed from: y, reason: collision with root package name */
    RotateAnimation f205730y;

    /* renamed from: z, reason: collision with root package name */
    List<Integer> f205731z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.facetoface.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class AnimationAnimationListenerC7516a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ boolean C;
        final /* synthetic */ boolean D;
        final /* synthetic */ Face2FaceFriendBubbleView E;
        final /* synthetic */ int F;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.facetoface.e f205732d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f205733e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ double f205734f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f205735h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f205736i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.facetoface.e f205737m;

        AnimationAnimationListenerC7516a(com.tencent.mobileqq.facetoface.e eVar, int i3, double d16, boolean z16, boolean z17, com.tencent.mobileqq.facetoface.e eVar2, boolean z18, boolean z19, Face2FaceFriendBubbleView face2FaceFriendBubbleView, int i16) {
            this.f205732d = eVar;
            this.f205733e = i3;
            this.f205734f = d16;
            this.f205735h = z16;
            this.f205736i = z17;
            this.f205737m = eVar2;
            this.C = z18;
            this.D = z19;
            this.E = face2FaceFriendBubbleView;
            this.F = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, eVar, Integer.valueOf(i3), Double.valueOf(d16), Boolean.valueOf(z16), Boolean.valueOf(z17), eVar2, Boolean.valueOf(z18), Boolean.valueOf(z19), face2FaceFriendBubbleView, Integer.valueOf(i16));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                ((Face2FaceAddFriendActivity) a.this.B).T3(this.f205737m, this.C, this.D);
                this.E.setStatusWithAnimation(this.F);
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
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendInAnimation currentUin ( " + this.f205732d.f205754b.substring(0, 4) + ", " + this.f205733e + " ) Animation Start  ");
            }
            double atan = (Math.atan(this.f205734f) * 180.0d) / 3.141592653589793d;
            a aVar = a.this;
            double d16 = atan * aVar.f205711f;
            if (this.f205735h) {
                d16 = 180.0d - d16;
            }
            aVar.f205709d = (float) d16;
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendInAnimation uinToHoleIndex add( " + this.f205732d.f205754b.substring(0, 4) + ", " + this.f205733e + " )");
            }
            a.this.i(2, this.f205736i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendDisappearAnimation disappear ( disappearCount: " + a.this.f205726u + ", disappearSize: " + a.this.f205727v + " )");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f205739d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f205740e;

        c(int i3, boolean z16) {
            this.f205739d = i3;
            this.f205740e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            a aVar = a.this;
            aVar.f205708c = aVar.f205709d;
            ((Face2FaceAddFriendActivity) aVar.B).Q3(this.f205739d, this.f205740e);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                ((Face2FaceAddFriendActivity) a.this.B).R3();
                a.this.f205730y = null;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements Interpolator {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            if (f16 == 0.0f) {
                return 0.0f;
            }
            float f17 = f16 * 2.0f;
            if (f17 >= 2.0f) {
                return 1.0f;
            }
            if (f17 < 1.0f) {
                float f18 = f17 - 1.0f;
                return (float) (Math.pow(2.0d, 10.0f * f18) * (-0.5d) * Math.sin(((f18 - 0.112500004f) * 6.283185307179586d) / 0.45000002f));
            }
            float f19 = f17 - 1.0f;
            return ((float) (Math.pow(2.0d, (-10.0f) * f19) * 0.5d * Math.sin(((f19 - 0.112500004f) * 6.283185307179586d) / 0.45000002f))) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements Interpolator {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            float f17 = f16 - 1.0f;
            return 1.0f - (((f17 * f17) * f17) * f17);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71829);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            C = new byte[0];
        }
    }

    public a(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        this.f205706a = 1;
        this.f205707b = 0.0d;
        this.f205708c = 0.0f;
        this.f205709d = 0.0f;
        this.f205710e = false;
        this.f205711f = -1;
        this.f205712g = false;
        this.f205722q = 0;
        this.f205723r = -1;
        this.f205725t = null;
        this.f205726u = 0;
        this.f205727v = 0;
        this.f205728w = 0;
        this.f205729x = 0;
        this.f205731z = Arrays.asList(Integer.valueOf(R.id.clk), Integer.valueOf(R.id.clm), Integer.valueOf(R.id.cln), Integer.valueOf(R.id.clo), Integer.valueOf(R.id.clp), Integer.valueOf(R.id.clq), Integer.valueOf(R.id.clr), Integer.valueOf(R.id.cls), Integer.valueOf(R.id.clt), Integer.valueOf(R.id.cll));
        this.A = qQAppInterface;
        this.B = context;
    }

    private static int f(int i3, int i16) {
        return (int) ((Math.random() * ((i16 - i3) + 1)) + i3);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (this.f205719n.containsKey(str) && !this.f205717l.contains(str)) {
            this.f205717l.add(this.f205719n.get(str));
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f205719n.clear();
        this.f205717l.clear();
        this.f205718m.clear();
        this.f205720o.clear();
        this.f205721p.clear();
        this.f205716k.clear();
    }

    public Face2FaceFriendBubbleView c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Face2FaceFriendBubbleView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (this.f205719n.containsKey(str)) {
            return this.f205716k.get(this.f205719n.get(str).intValue());
        }
        return null;
    }

    public float d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).floatValue();
        }
        return (float) ((Math.random() * (i16 - i3)) + i3);
    }

    public void e(QQAppInterface qQAppInterface, View view, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, view, Integer.valueOf(i3), str);
            return;
        }
        Context context = this.B;
        if (context == null) {
            return;
        }
        this.f205713h = context.getResources().getDisplayMetrics().widthPixels;
        this.f205714i = this.B.getResources().getDisplayMetrics().heightPixels;
        this.f205715j = (ImageView) view.findViewById(R.id.b6n);
        if (i3 == 1 && !TextUtils.isEmpty(str)) {
            ((ImageView) view.findViewById(R.id.b6o)).setVisibility(4);
            this.f205715j.setImageResource(R.drawable.clz);
            Bitmap troopFaceBitmap = qQAppInterface.getTroopFaceBitmap(str, (byte) 3, false, false);
            if (troopFaceBitmap == null) {
                troopFaceBitmap = BaseImageUtil.getDefaultTroopFaceBitmap();
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.jy6);
            imageView.setImageBitmap(troopFaceBitmap);
            imageView.setVisibility(0);
        }
        this.f205716k = new ArrayList();
        for (int i16 = 0; i16 < 10; i16++) {
            Face2FaceFriendBubbleView face2FaceFriendBubbleView = (Face2FaceFriendBubbleView) view.findViewById(this.f205731z.get(i16).intValue());
            face2FaceFriendBubbleView.setStatusWithAnimation(1);
            face2FaceFriendBubbleView.setOnClickListener((View.OnClickListener) this.B);
            this.f205716k.add(face2FaceFriendBubbleView);
        }
        this.f205717l = new LinkedList();
        this.f205719n = new HashMap();
        LinkedList linkedList = new LinkedList();
        this.f205718m = linkedList;
        linkedList.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        LinkedList linkedList2 = new LinkedList();
        this.f205720o = linkedList2;
        linkedList2.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        LinkedList linkedList3 = new LinkedList();
        this.f205721p = linkedList3;
        linkedList3.addAll(Arrays.asList(0, 1, 8, 9));
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else if (this.f205719n.containsKey(str)) {
            this.f205717l.remove(this.f205719n.get(str));
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        Face2FaceFriendBubbleView face2FaceFriendBubbleView = this.f205716k.get(i3);
        if (face2FaceFriendBubbleView != null && face2FaceFriendBubbleView.i() != null && this.f205719n.containsKey(face2FaceFriendBubbleView.i())) {
            this.f205719n.remove(face2FaceFriendBubbleView.i());
            face2FaceFriendBubbleView.setVisibility(4);
            face2FaceFriendBubbleView.setStatusWithoutAnimation(1);
            face2FaceFriendBubbleView.setClickable(false);
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "removeShowedFriendMap uinToHoleIndex remove( " + face2FaceFriendBubbleView.i() + ", " + i3 + " )");
            }
        }
    }

    public void i(int i3, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.B == null) {
            return;
        }
        if (i3 == 1) {
            this.f205709d = d(45, 180);
            if (d(0, 1) < 0.5d) {
                this.f205709d *= -1.0f;
            }
            j3 = d(800, 1500);
        } else {
            j3 = 750;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.f205708c, this.f205709d, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(j3);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new e());
        this.f205715j.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new c(i3, z16));
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.B == null) {
            return;
        }
        long d16 = d(800, 1200);
        float f16 = this.f205709d;
        int d17 = (int) d(5, 12);
        if (this.f205710e) {
            this.f205710e = false;
            this.f205709d = this.f205708c - d17;
        } else {
            this.f205710e = true;
            this.f205709d = this.f205708c + d17;
        }
        float f17 = this.f205709d;
        if (f16 == f17) {
            float f18 = this.f205708c;
            if (f17 > f18) {
                this.f205709d = f18 - d17;
            } else {
                this.f205709d = f18 + d17;
            }
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, this.f205709d, 1, 0.5f, 1, 0.5f);
        this.f205730y = rotateAnimation;
        rotateAnimation.setDuration(d16);
        this.f205730y.setFillAfter(true);
        this.f205730y.setInterpolator(new e());
        this.f205715j.startAnimation(this.f205730y);
        this.f205730y.setAnimationListener(new d());
    }

    public void k(com.tencent.mobileqq.facetoface.e eVar, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, eVar, Boolean.valueOf(z16));
            return;
        }
        if (eVar != null && this.B != null) {
            String str = eVar.f205754b;
            if (eVar instanceof com.tencent.mobileqq.facetoface.c) {
                str = eVar.f205754b + "_" + ((com.tencent.mobileqq.facetoface.c) eVar).f205749d;
            }
            if (this.f205719n.containsKey(str)) {
                i3 = this.f205719n.get(str).intValue();
            } else {
                i3 = -1;
            }
            if (i3 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendDisappearAnimation disappear uin " + eVar.f205754b.substring(0, 4) + " is not in the hole");
                    QLog.d(Face2FaceAddFriendActivity.F1, 2, "startFriendDisappearAnimation disappear uin " + eVar.f205754b.substring(0, 4) + " is not in the hole");
                    this.f205726u = this.f205726u + 1;
                    return;
                }
                return;
            }
            Face2FaceFriendBubbleView face2FaceFriendBubbleView = this.f205716k.get(i3);
            if (z16) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(1000L);
                animationSet.setFillAfter(true);
                animationSet.setInterpolator(new f());
                animationSet.setAnimationListener(new b());
                if (face2FaceFriendBubbleView != null) {
                    face2FaceFriendBubbleView.startAnimation(animationSet);
                }
            }
            if (face2FaceFriendBubbleView != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendDisappearAnimation disappear uin " + eVar.f205754b.substring(0, 4));
                }
                if (this.f205717l.contains(Integer.valueOf(i3))) {
                    this.f205717l.remove(Integer.valueOf(i3));
                }
                h(i3);
                ((Face2FaceAddFriendActivity) this.B).S3(eVar);
                this.f205718m.add(Integer.valueOf(i3));
                if (i3 >= 2 && i3 <= 7) {
                    this.f205720o.add(Integer.valueOf(i3));
                    return;
                } else {
                    if ((i3 >= 0 && i3 <= 1) || (i3 >= 8 && i3 <= 9)) {
                        this.f205721p.add(Integer.valueOf(i3));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendDisappearAnimation disappear data is " + eVar + " mContext " + this.B);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(com.tencent.mobileqq.facetoface.e eVar, boolean z16, int i3, boolean z17, boolean z18) {
        int i16;
        int intValue;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, eVar, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if (eVar != null && this.B != null) {
            if (this.f205718m.size() == 1) {
                intValue = this.f205718m.get(0).intValue();
            } else {
                if (this.f205718m.size() > 1) {
                    if (this.f205720o.size() == 1) {
                        intValue = this.f205720o.get(0).intValue();
                    } else if (this.f205720o.size() > 1) {
                        List<Integer> list = this.f205720o;
                        intValue = list.get(f(0, list.size() - 1)).intValue();
                    } else if (this.f205721p.size() == 0) {
                        intValue = this.f205721p.get(0).intValue();
                    } else if (this.f205721p.size() > 1) {
                        List<Integer> list2 = this.f205721p;
                        intValue = list2.get(f(0, list2.size() - 1)).intValue();
                    }
                }
                i16 = -1;
                if (i16 != -1) {
                    return;
                }
                Face2FaceFriendBubbleView face2FaceFriendBubbleView = this.f205716k.get(i16);
                this.f205724s = i16;
                if (face2FaceFriendBubbleView == null) {
                    return;
                }
                this.f205725t = eVar;
                face2FaceFriendBubbleView.f(this.A, eVar);
                face2FaceFriendBubbleView.setVisibility(0);
                face2FaceFriendBubbleView.setClickable(true);
                if (QLog.isColorLevel()) {
                    if (!TextUtils.isEmpty(eVar.f205754b)) {
                        QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendInAnimation get ( currentUin= " + eVar.f205754b.substring(0, 4) + " , index = " + i16 + " )");
                    } else {
                        QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendInAnimation get  currentUin= null");
                    }
                }
                this.f205706a = 1;
                this.f205712g = false;
                this.f205711f = -1;
                int[] iArr = new int[2];
                this.f205715j.getLocationOnScreen(iArr);
                int width = iArr[0] + (this.f205715j.getWidth() >> 1);
                int height = iArr[1] + (this.f205715j.getHeight() >> 1);
                int[] iArr2 = new int[2];
                face2FaceFriendBubbleView.getLocationOnScreen(iArr2);
                int width2 = iArr2[0] + (face2FaceFriendBubbleView.getWidth() >> 1);
                int height2 = iArr2[1] + (face2FaceFriendBubbleView.getHeight() >> 1);
                int abs = Math.abs(width - width2);
                int abs2 = Math.abs(height - height2);
                this.f205707b = abs / abs2;
                int width3 = (face2FaceFriendBubbleView.getWidth() >> 1) + width;
                if (abs == 0) {
                    i17 = (face2FaceFriendBubbleView.getHeight() >> 1) + height;
                    if (height2 > height) {
                        i17 = (this.f205714i - height) + (face2FaceFriendBubbleView.getHeight() >> 1);
                    }
                } else {
                    i17 = (width3 * abs2) / abs;
                }
                int width4 = iArr2[0] + face2FaceFriendBubbleView.getWidth();
                int i19 = i17 - abs2;
                if (height2 > height) {
                    this.f205706a = 2;
                }
                if (width2 > width) {
                    width4 = this.f205713h - iArr2[0];
                    if (height2 < height) {
                        this.f205706a = 5;
                    } else {
                        this.f205706a = 6;
                    }
                }
                if (i17 - height >= (face2FaceFriendBubbleView.getHeight() >> 1) || i17 - (this.f205714i - height) >= (face2FaceFriendBubbleView.getHeight() >> 1)) {
                    if (height2 < height) {
                        i17 = height + (face2FaceFriendBubbleView.getHeight() >> 1);
                        int height3 = iArr2[1] + face2FaceFriendBubbleView.getHeight();
                        if (width2 < width) {
                            this.f205706a = 3;
                        } else {
                            this.f205706a = 4;
                        }
                        i19 = height3;
                    } else if (height2 > height) {
                        int height4 = (face2FaceFriendBubbleView.getHeight() >> 1) + (this.f205714i - height);
                        int i26 = this.f205714i - iArr2[1];
                        if (width2 < width) {
                            this.f205706a = 7;
                        } else {
                            this.f205706a = 8;
                        }
                        i17 = height4;
                        i19 = i26;
                    }
                    width4 = ((i17 * abs) / abs2) - abs;
                }
                switch (this.f205706a) {
                    case 1:
                        width4 = -width4;
                        i19 = -i19;
                        this.f205711f = -1;
                        this.f205712g = false;
                        break;
                    case 2:
                        width4 = -width4;
                        this.f205711f = -1;
                        this.f205712g = true;
                        break;
                    case 3:
                        width4 = -width4;
                        i19 = -i19;
                        this.f205711f = -1;
                        this.f205712g = false;
                        break;
                    case 4:
                        i19 = -i19;
                        this.f205711f = 1;
                        this.f205712g = false;
                        break;
                    case 5:
                        i19 = -i19;
                        this.f205711f = 1;
                        this.f205712g = false;
                        break;
                    case 6:
                        this.f205711f = 1;
                        this.f205712g = true;
                        break;
                    case 7:
                        width4 = -width4;
                        this.f205711f = -1;
                        this.f205712g = true;
                        break;
                    case 8:
                        this.f205711f = 1;
                        this.f205712g = true;
                        break;
                }
                double d16 = this.f205707b;
                boolean z19 = this.f205712g;
                TranslateAnimation translateAnimation = new TranslateAnimation(width4, 0.0f, i19, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setInterpolator(new f());
                int i27 = i16;
                translateAnimation.setAnimationListener(new AnimationAnimationListenerC7516a(eVar, i16, d16, z19, z18, eVar, z16, z17, face2FaceFriendBubbleView, i3));
                face2FaceFriendBubbleView.startAnimation(translateAnimation);
                String str = eVar.f205754b;
                if (eVar instanceof com.tencent.mobileqq.facetoface.c) {
                    str = eVar.f205754b + "_" + ((com.tencent.mobileqq.facetoface.c) eVar).f205749d;
                }
                this.f205719n.put(str, Integer.valueOf(i27));
                ((Face2FaceAddFriendActivity) this.B).P3(eVar, z16, z17);
                if (QLog.isColorLevel()) {
                    i18 = 2;
                    QLog.d(Face2FaceAddFriendActivity.F1, 2, "uinToHoleIndex put identify=" + str);
                } else {
                    i18 = 2;
                }
                this.f205718m.remove(Integer.valueOf(i27));
                if (this.f205720o.contains(Integer.valueOf(i27))) {
                    this.f205720o.remove(Integer.valueOf(i27));
                } else if (this.f205721p.contains(Integer.valueOf(i27))) {
                    this.f205721p.remove(Integer.valueOf(i27));
                }
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, i18, "startFriendInAnimation currentUIn= " + eVar.f205754b.substring(0, 4) + " startAnimation OK");
                    return;
                }
                return;
            }
            i16 = intValue;
            if (i16 != -1) {
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.E1, 2, "startFriendInAnimation  data is " + eVar + " mContext " + this.B);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
        }
        RotateAnimation rotateAnimation = this.f205730y;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        ImageView imageView = this.f205715j;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}

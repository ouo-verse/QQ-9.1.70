package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HasClockView extends e implements Observer {
    private RoundRectUrlImageView C;
    private ImageView D;
    private TextView E;
    private TickerView F;
    private TickerView G;
    private TickerView H;
    private TextView I;
    private TextView J;
    private ImageView K;
    private LinearLayout L;
    private g M;
    private Handler N;
    private boolean P;
    private List<c> Q;
    private int R;
    private int S;
    private int T;
    private int U;
    Runnable V;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f293317e;

    /* renamed from: f, reason: collision with root package name */
    private Context f293318f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f293319h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.together.clockin.c f293320i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f293321m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                HasClockView.this.u(0.5f);
            } else if (action == 1) {
                HasClockView.this.u(1.0f);
                HasClockView.this.p();
            } else if (action == 3) {
                HasClockView.this.u(1.0f);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public float f293324a;

        /* renamed from: b, reason: collision with root package name */
        public float f293325b;

        /* renamed from: c, reason: collision with root package name */
        public int f293326c;

        public c(float f16, float f17, int i3) {
            this.f293324a = f16;
            this.f293325b = f17;
            this.f293326c = i3;
        }
    }

    public HasClockView(Context context, QQAppInterface qQAppInterface, FrameLayout frameLayout, com.tencent.mobileqq.together.clockin.c cVar, com.tencent.mobileqq.together.clockin.b bVar, com.tencent.mobileqq.together.clockin.a aVar) {
        super(aVar);
        this.N = new Handler();
        this.P = true;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = new Runnable() { // from class: com.tencent.mobileqq.together.clockin.HasClockView.2
            @Override // java.lang.Runnable
            public void run() {
                if (HasClockView.this.P) {
                    HasClockView.this.s();
                }
            }
        };
        if (aVar != null) {
            aVar.addObserver(this);
        }
        this.f293317e = qQAppInterface;
        this.f293318f = context;
        this.f293319h = frameLayout;
        this.f293320i = cVar;
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        arrayList.add(new c(90.0f, -10.0f, 300));
        this.Q.add(new c(-10.0f, 15.0f, 300));
        this.Q.add(new c(15.0f, 0.0f, 250));
        l();
    }

    private boolean j() {
        if (this.f293317e != null && this.f293318f != null && this.f293319h != null && this.f293320i != null && this.C != null && this.D != null && this.E != null && this.F != null && this.G != null && this.H != null && this.I != null && this.L != null && this.J != null && this.K != null) {
            return true;
        }
        return false;
    }

    private String k(int i3) {
        if (i3 < 10) {
            return "0" + i3;
        }
        return "" + i3;
    }

    private void l() {
        Context context;
        if (this.f293317e != null && (context = this.f293318f) != null && this.f293319h != null && this.f293320i != null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.gzw, (ViewGroup) null);
            this.f293321m = relativeLayout;
            this.f293319h.addView(relativeLayout);
            this.C = (RoundRectUrlImageView) this.f293321m.findViewById(R.id.a7v);
            this.D = (ImageView) this.f293321m.findViewById(R.id.f115256vj);
            this.E = (TextView) this.f293321m.findViewById(R.id.smu);
            this.F = (TickerView) this.f293321m.findViewById(R.id.f97265jx);
            this.G = (TickerView) this.f293321m.findViewById(R.id.f97295k0);
            this.H = (TickerView) this.f293321m.findViewById(R.id.f97335k4);
            this.I = (TextView) this.f293321m.findViewById(R.id.f164820tz3);
            this.L = (LinearLayout) this.f293321m.findViewById(R.id.tyo);
            this.J = (TextView) this.f293321m.findViewById(R.id.typ);
            this.K = (ImageView) this.f293321m.findViewById(R.id.tyn);
            y();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HasClockView", 2, "create arg error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f293321m != null && this.Q != null) {
            r(0);
            this.f293321m.bringToFront();
            if (this.R >= this.Q.size()) {
                return;
            }
            if (this.M == null) {
                g gVar = new g();
                this.M = gVar;
                gVar.setFillAfter(true);
                this.M.setAnimationListener(new b());
            }
            c cVar = this.Q.get(this.R);
            if (cVar != null) {
                float f16 = this.f293318f.getResources().getDisplayMetrics().density;
                this.M.setInterpolator(new LinearInterpolator());
                this.M.a(f16, cVar.f293324a, cVar.f293325b, this.f293321m.getWidth() / 2.0f, this.f293321m.getHeight() / 2.0f, 0.0f, true);
                this.M.setDuration(cVar.f293326c);
                this.f293321m.startAnimation(this.M);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        TickerView tickerView = this.F;
        if (tickerView != null && this.G != null && this.H != null && this.S != 0 && this.T != 0 && this.U != 0) {
            tickerView.setPreferredScrollingDirection(2);
            this.F.setDigitalAnimWidthSpeedIncrement(false);
            this.F.setIgnoreWidthAnim(true);
            this.F.setText(k(this.S));
            this.F.setVisibility(0);
            this.G.setPreferredScrollingDirection(2);
            this.G.setDigitalAnimWidthSpeedIncrement(false);
            this.G.setIgnoreWidthAnim(true);
            this.G.setText(k(this.T));
            this.G.setVisibility(0);
            this.H.setPreferredScrollingDirection(2);
            this.H.setDigitalAnimWidthSpeedIncrement(false);
            this.H.setIgnoreWidthAnim(true);
            this.H.setText(k(this.U));
            this.H.setVisibility(0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HasClockView", 2, "smoothUpdateTime error");
        }
    }

    private void t() {
        this.C.setAllRadius(ViewUtils.dpToPx(16.0f));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (!TextUtils.isEmpty(this.f293320i.f293354q)) {
            this.C.setImageDrawable(URLDrawable.getDrawable(this.f293320i.f293354q, obtain));
            this.C.setVisibility(0);
            return;
        }
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f16) {
        ImageView imageView = this.K;
        if (imageView != null && this.J != null && this.L != null) {
            imageView.setAlpha(f16);
            this.J.setAlpha(f16);
            this.L.setAlpha(f16);
        }
    }

    private void v() {
        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
        QQAppInterface qQAppInterface = this.f293317e;
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, qQAppInterface.getCurrentUin(), 4, defaultFaceDrawable, defaultFaceDrawable);
        Drawable drawable = this.D.getDrawable();
        if (drawable != null && (drawable instanceof FaceDrawable) && drawable != faceDrawable) {
            ((FaceDrawable) drawable).cancel();
        }
        this.D.setImageDrawable(faceDrawable);
    }

    private void w() {
        this.L.setOnTouchListener(new a());
        this.I.setText(this.f293320i.f293350m);
        this.E.setText(this.f293320i.f293348k);
        this.K.setImageResource(R.drawable.skin_wt_arrow);
        this.K.setColorFilter(Color.parseColor("#FFFFFF"));
        this.J.setText(this.f293320i.f293351n);
    }

    private void x() {
        int i3;
        int i16;
        int i17;
        Calendar calendar = Calendar.getInstance();
        long j3 = this.f293320i.f293349l;
        if (j3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("HasClockView", 2, "updateTimeUI : selfClockTime == 0");
                return;
            }
            return;
        }
        calendar.setTimeInMillis(j3 * 1000);
        this.S = calendar.get(11);
        this.T = calendar.get(12);
        this.U = calendar.get(13);
        if (this.f293320i.f293340c) {
            i3 = n(this.S, 24);
        } else {
            i3 = this.S;
        }
        String k3 = k(i3);
        if (this.f293320i.f293340c) {
            i16 = n(this.T, 60);
        } else {
            i16 = this.T;
        }
        String k16 = k(i16);
        if (this.f293320i.f293340c) {
            i17 = n(this.U, 60);
        } else {
            i17 = this.U;
        }
        String k17 = k(i17);
        this.F.setCharacterLists("1234567890");
        this.F.setCustomCharacterList(o(this.S, 24));
        this.F.setText(k3, false);
        this.F.setAnimationDuration(1000L);
        this.F.setGravity(17);
        this.G.setCharacterLists("1234567890");
        this.G.setCustomCharacterList(o(this.T, 60));
        this.G.setText(k16, false);
        this.G.setAnimationDuration(1000L);
        this.F.setAnimationDelay(30L);
        this.G.setGravity(17);
        this.H.setCharacterLists("1234567890");
        this.H.setCustomCharacterList(o(this.U, 60));
        this.H.setText(k17, false);
        this.H.setAnimationDuration(1000L);
        this.F.setAnimationDelay(60L);
        this.H.setGravity(17);
    }

    private void y() {
        if (!j()) {
            if (QLog.isColorLevel()) {
                QLog.d("HasClockView", 2, "updateUI checkData error");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HasClockView", 2, "updateUI data:" + this.f293320i.toString());
        }
        t();
        v();
        w();
        x();
    }

    public void m() {
        g gVar = this.M;
        if (gVar != null) {
            gVar.setAnimationListener(null);
            this.M.cancel();
            this.M = null;
        }
        RelativeLayout relativeLayout = this.f293321m;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f293321m = null;
        }
        List<c> list = this.Q;
        if (list != null) {
            list.clear();
        }
    }

    public int n(int i3, int i16) {
        return (((i3 + i16) - 8) % i16) + 1;
    }

    public ArrayList<String> o(int i3, int i16) {
        int n3 = n(i3, i16);
        ArrayList<String> arrayList = new ArrayList<>();
        String k3 = k(n3);
        String str = "" + k3.substring(0, 1);
        String str2 = "" + k3.substring(1, 2);
        for (int i17 = 0; i17 < 7; i17++) {
            n3 = (n3 + 1) % i16;
            String k16 = k(n3);
            str = str + k16.substring(0, 1);
            str2 = str2 + k16.substring(1, 2);
        }
        arrayList.add(str);
        arrayList.add(str2);
        return arrayList;
    }

    public void p() {
        com.tencent.mobileqq.together.clockin.c cVar = this.f293320i;
        if (cVar != null && !TextUtils.isEmpty(cVar.f293352o)) {
            Intent intent = new Intent(this.f293318f, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f293320i.f293352o);
            this.f293318f.startActivity(intent);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op_via", "2");
        QQAppInterface qQAppInterface = this.f293317e;
        if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getCurrentAccountUin())) {
            hashMap.put("A8", this.f293317e.getCurrentAccountUin());
        }
        com.tencent.mobileqq.together.clockin.c cVar2 = this.f293320i;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.f293338a)) {
            hashMap.put("qq_group_num", this.f293320i.f293338a);
        }
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    public void r(int i3) {
        RelativeLayout relativeLayout = this.f293321m;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Handler handler;
        Runnable runnable;
        if (!(obj instanceof Integer)) {
            return;
        }
        Integer num = (Integer) obj;
        if (num.intValue() == 2) {
            y();
            q();
        } else if (num.intValue() == 3 && (handler = this.N) != null && (runnable = this.V) != null) {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (HasClockView.this.R < HasClockView.this.Q.size()) {
                HasClockView.this.q();
            } else {
                HasClockView.this.b(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (HasClockView.this.R == 0) {
                HasClockView.this.b(3);
            }
            HasClockView.this.R++;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

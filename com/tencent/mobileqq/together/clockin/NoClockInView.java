package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NoClockInView extends e implements QQAvatarFHDDecoder.a, View.OnClickListener, Observer {
    private RoundRectUrlImageView C;
    private RoundRectUrlImageView D;
    private RoundRectUrlImageView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private LinearLayout I;
    private TextView J;
    private View K;
    private TextView L;
    private Button M;
    private LinearLayout N;
    private ImageView P;
    private TextView Q;
    private TextView R;
    private b S;
    private QQAvatarFHDDecoder T;
    private g U;
    boolean V;

    /* renamed from: e, reason: collision with root package name */
    private Context f293328e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f293329f;

    /* renamed from: h, reason: collision with root package name */
    private c f293330h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f293331i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f293332m;

    public NoClockInView(Context context, QQAppInterface qQAppInterface, FrameLayout frameLayout, c cVar, b bVar, com.tencent.mobileqq.together.clockin.a aVar) {
        super(aVar);
        this.U = null;
        this.V = false;
        if (aVar != null) {
            aVar.addObserver(this);
        }
        this.f293329f = qQAppInterface;
        this.f293328e = context;
        this.f293331i = frameLayout;
        this.f293330h = cVar;
        this.S = bVar;
        f();
    }

    private boolean e() {
        if (this.f293329f != null && this.f293328e != null && this.f293332m != null && this.f293330h != null && this.f293331i != null && this.C != null && this.D != null && this.E != null && this.F != null && this.G != null && this.H != null && this.I != null && this.J != null && this.K != null && this.L != null && this.N != null && this.Q != null && this.P != null && this.R != null && this.M != null) {
            return true;
        }
        return false;
    }

    private void f() {
        Context context;
        if (this.f293329f != null && (context = this.f293328e) != null && this.f293331i != null && this.f293332m == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.gzx, (ViewGroup) null);
            this.f293332m = relativeLayout;
            if (relativeLayout == null) {
                return;
            }
            this.f293331i.addView(relativeLayout);
            this.C = (RoundRectUrlImageView) this.f293332m.findViewById(R.id.a7v);
            this.E = (RoundRectUrlImageView) this.f293332m.findViewById(R.id.t69);
            this.D = (RoundRectUrlImageView) this.f293332m.findViewById(R.id.t6d);
            this.F = (TextView) this.f293332m.findViewById(R.id.f164948ue2);
            this.G = (TextView) this.f293332m.findViewById(R.id.f164951ue4);
            this.H = (TextView) this.f293332m.findViewById(R.id.ue9);
            this.I = (LinearLayout) this.f293332m.findViewById(R.id.f164821tz4);
            this.J = (TextView) this.f293332m.findViewById(R.id.tz5);
            this.K = this.f293332m.findViewById(R.id.tz7);
            this.L = (TextView) this.f293332m.findViewById(R.id.tz6);
            this.N = (LinearLayout) this.f293332m.findViewById(R.id.v6v);
            this.P = (ImageView) this.f293332m.findViewById(R.id.x7w);
            this.Q = (TextView) this.f293332m.findViewById(R.id.v6u);
            this.R = (TextView) this.f293332m.findViewById(R.id.v6t);
            Button button = (Button) this.f293332m.findViewById(R.id.tym);
            this.M = button;
            button.setTag(Integer.valueOf(R.id.tym));
            this.M.setOnClickListener(this);
            p();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NoClockInView", 2, "init failed");
        }
    }

    private String h(int i3) {
        switch (i3) {
            case 1:
                return this.f293328e.getString(R.string.f2327375c);
            case 2:
                return this.f293328e.getString(R.string.f23267757);
            case 3:
                return this.f293328e.getString(R.string.f23268758);
            case 4:
                return this.f293328e.getString(R.string.f23269759);
            case 5:
                return this.f293328e.getString(R.string.f2327075_);
            case 6:
                return this.f293328e.getString(R.string.f2327175a);
            case 7:
                return this.f293328e.getString(R.string.f2327275b);
            default:
                return "";
        }
    }

    private boolean i() {
        c cVar = this.f293330h;
        if (cVar != null && !TextUtils.isEmpty(cVar.f293341d)) {
            return true;
        }
        return false;
    }

    private void j() {
        b bVar = this.S;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void m() {
        if (i()) {
            if (this.T == null) {
                this.T = new QQAvatarFHDDecoder(this.f293329f);
            }
            this.C.setAllRadius(ViewUtils.dpToPx(16.0f));
            this.T.j(this.f293330h.f293341d, false, this);
            this.C.setVisibility(0);
            this.E.setAllRadius(ViewUtils.dpToPx(16.0f));
            this.E.setVisibility(0);
            this.D.setAllRadius(ViewUtils.dpToPx(16.0f));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (!TextUtils.isEmpty(this.f293330h.f293344g)) {
                this.D.setImageDrawable(URLDrawable.getDrawable(this.f293330h.f293344g, obtain));
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
            return;
        }
        this.C.setAllRadius(ViewUtils.dpToPx(16.0f));
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        if (!TextUtils.isEmpty(this.f293330h.f293344g)) {
            this.C.setImageDrawable(URLDrawable.getDrawable(this.f293330h.f293344g, obtain2));
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.D.setVisibility(8);
        this.E.setVisibility(8);
    }

    private void n() {
        if (i()) {
            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.f293329f, 1, this.f293330h.f293341d, 4, defaultFaceDrawable, defaultFaceDrawable);
            Drawable drawable = this.P.getDrawable();
            if (drawable != null && (drawable instanceof FaceDrawable) && drawable != faceDrawable) {
                ((FaceDrawable) drawable).cancel();
            }
            this.P.setImageDrawable(faceDrawable);
            if (!TextUtils.isEmpty(this.f293330h.f293342e)) {
                this.Q.setText(this.f293330h.f293342e);
            }
            if (!TextUtils.isEmpty(this.f293330h.f293343f)) {
                this.R.setText(this.f293330h.f293343f);
            }
            this.N.setVisibility(0);
            return;
        }
        this.N.setVisibility(8);
    }

    private void o() {
        StringBuilder sb5;
        StringBuilder sb6;
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(2) + 1;
        int i16 = calendar.get(5);
        TextView textView = this.F;
        if (i16 < 10) {
            sb5 = new StringBuilder();
            sb5.append("0");
        } else {
            sb5 = new StringBuilder();
            sb5.append("");
        }
        sb5.append(i16);
        textView.setText(sb5.toString());
        TextView textView2 = this.G;
        if (i3 < 10) {
            sb6 = new StringBuilder();
            sb6.append("0");
        } else {
            sb6 = new StringBuilder();
            sb6.append("");
        }
        sb6.append(i3);
        textView2.setText(sb6.toString());
        this.H.setText(h(calendar.get(7)));
        if (!TextUtils.isEmpty(this.f293330h.f293347j)) {
            this.M.setText(this.f293330h.f293347j);
        }
        if (TextUtils.isEmpty(this.f293330h.f293345h) && TextUtils.isEmpty(this.f293330h.f293346i)) {
            this.I.setVisibility(8);
            return;
        }
        this.I.setVisibility(0);
        if (!TextUtils.isEmpty(this.f293330h.f293345h) && !TextUtils.isEmpty(this.f293330h.f293346i)) {
            this.K.setVisibility(0);
        } else {
            this.K.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f293330h.f293345h)) {
            this.J.setVisibility(0);
            this.J.setText(this.f293330h.f293345h);
        } else {
            this.J.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f293330h.f293346i)) {
            this.L.setVisibility(0);
            this.L.setText(this.f293330h.f293346i);
        } else {
            this.L.setVisibility(8);
        }
    }

    private void p() {
        if (QLog.isColorLevel()) {
            QLog.d("NoClockInView", 2, "updateUI");
        }
        if (e()) {
            if (QLog.isColorLevel()) {
                QLog.d("NoClockInView", 2, "checkData true" + this.f293330h.toString());
            }
            m();
            n();
            o();
        }
    }

    @Override // com.tencent.mobileqq.util.QQAvatarFHDDecoder.a
    public void a(String str, boolean z16, final Drawable drawable) {
        if (QLog.isColorLevel()) {
            QLog.d("NoClockInView", 2, "onGetQQAvatarFHD isSuc" + z16 + " ,uin = " + str);
        }
        if (z16 && drawable != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.together.clockin.NoClockInView.1
                @Override // java.lang.Runnable
                public void run() {
                    final Drawable drawable2;
                    Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(drawable);
                    if (drawabletoBitmap != null) {
                        try {
                            eh.a(drawabletoBitmap, 5);
                            drawable2 = new BitmapDrawable(drawabletoBitmap);
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                            drawabletoBitmap.recycle();
                            drawable2 = drawable;
                        }
                    } else {
                        drawable2 = null;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.together.clockin.NoClockInView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NoClockInView.this.C != null && drawable2 != null) {
                                NoClockInView.this.C.setImageDrawable(drawable2);
                            }
                        }
                    });
                }
            }, 8, null, true);
        }
    }

    public void g() {
        g gVar = this.U;
        if (gVar != null) {
            gVar.setAnimationListener(null);
            this.U.cancel();
            this.U = null;
        }
        RelativeLayout relativeLayout = this.f293332m;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f293332m = null;
        }
    }

    public void k(int i3) {
        RelativeLayout relativeLayout = this.f293332m;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    public void l() {
        if (this.f293332m != null && this.f293328e != null) {
            if (this.U == null) {
                this.U = new g(this.f293328e.getResources().getDisplayMetrics().density, 0.0f, -90.0f, r0.getWidth() / 2.0f, this.f293332m.getHeight() / 2.0f, 0.0f, true);
            }
            this.U.setDuration(200L);
            this.U.setInterpolator(new LinearInterpolator());
            this.U.setFillAfter(true);
            this.U.setAnimationListener(new a());
            if (QLog.isColorLevel()) {
                QLog.d("NoClockInView", 2, "startRotateAnim");
            }
            this.V = true;
            this.f293332m.startAnimation(this.U);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && ((Integer) view.getTag()).intValue() == R.id.tym) {
            j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1 && !this.V) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NoClockInView.this.k(8);
            if (NoClockInView.this.M != null) {
                NoClockInView.this.M.setOnClickListener(null);
            }
            NoClockInView.this.b(2);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            NoClockInView.this.b(1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

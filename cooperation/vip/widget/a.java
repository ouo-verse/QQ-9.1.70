package cooperation.vip.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.animation.rebound.SimpleSpringListener;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends PopupWindow {

    /* renamed from: t, reason: collision with root package name */
    private static final SpringConfig f391443t = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 8.0d);

    /* renamed from: u, reason: collision with root package name */
    private static final Drawable f391444u = g(R.drawable.h8a);

    /* renamed from: v, reason: collision with root package name */
    private static final Drawable f391445v = g(R.drawable.h8b);

    /* renamed from: w, reason: collision with root package name */
    private static final Drawable f391446w = new ColorDrawable(HWColorFormat.COLOR_FormatVendorStartUnused);

    /* renamed from: a, reason: collision with root package name */
    public Activity f391447a;

    /* renamed from: b, reason: collision with root package name */
    private Spring f391448b;

    /* renamed from: c, reason: collision with root package name */
    private ListView f391449c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f391450d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f391451e;

    /* renamed from: f, reason: collision with root package name */
    private int f391452f;

    /* renamed from: g, reason: collision with root package name */
    private int f391453g;

    /* renamed from: h, reason: collision with root package name */
    private int f391454h;

    /* renamed from: i, reason: collision with root package name */
    private float f391455i;

    /* renamed from: j, reason: collision with root package name */
    private float f391456j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f391457k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f391458l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f391459m;

    /* renamed from: n, reason: collision with root package name */
    private int f391460n;

    /* renamed from: o, reason: collision with root package name */
    private int f391461o;

    /* renamed from: p, reason: collision with root package name */
    private e f391462p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<f> f391463q;

    /* renamed from: r, reason: collision with root package name */
    private View.OnKeyListener f391464r;

    /* renamed from: s, reason: collision with root package name */
    private View.OnTouchListener f391465s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.vip.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10131a extends SimpleSpringListener {
        C10131a() {
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            a.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 2) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i3 == 4) {
                a.this.e();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.e();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                a.this.e();
                return true;
            }
            return view.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f391470d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f391471e;

        public e(Context context) {
            this.f391470d = context;
        }

        private View a() {
            return b().inflate(R.layout.c3f, (ViewGroup) null);
        }

        private LayoutInflater b() {
            if (this.f391471e == null) {
                this.f391471e = LayoutInflater.from(this.f391470d);
            }
            return this.f391471e;
        }

        private void c(f fVar, g gVar) {
            gVar.f391479c.setImageDrawable(URLDrawable.getDrawable(fVar.f391475c, (URLDrawable.URLDrawableOptions) null));
            gVar.f391478b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            gVar.f391479c.setVisibility(0);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<f> arrayList = a.this.f391463q;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            ArrayList<f> arrayList = a.this.f391463q;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            if (a.this.f391463q != null) {
                return r3.size();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            g gVar;
            if (view == null) {
                gVar = new g();
                View a16 = a();
                gVar.f391478b = (TextView) a16.findViewById(R.id.eq7);
                gVar.f391479c = (ImageView) a16.findViewById(R.id.e7j);
                gVar.f391480d = a16.findViewById(R.id.bqe);
                a16.setTag(gVar);
                view2 = a16;
            } else {
                view2 = view;
                gVar = (g) view.getTag();
            }
            if (gVar != null) {
                if (getCount() <= 1) {
                    gVar.f391480d.setVisibility(8);
                    view2.setBackgroundResource(R.drawable.b0t);
                } else if (i3 <= 0) {
                    gVar.f391480d.setVisibility(0);
                    view2.setBackgroundResource(R.drawable.b0t);
                } else if (i3 < getCount() - 1) {
                    gVar.f391480d.setVisibility(0);
                    view2.setBackgroundResource(R.drawable.b0s);
                } else {
                    gVar.f391480d.setVisibility(8);
                    view2.setBackgroundResource(R.drawable.b0r);
                }
                f fVar = (f) getItem(i3);
                if (fVar != null) {
                    gVar.f391477a = fVar;
                    gVar.f391478b.setText(fVar.f391474b);
                    if (TextUtils.isEmpty(fVar.f391475c)) {
                        gVar.f391479c.setVisibility(8);
                    }
                    c(fVar, gVar);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f391473a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f391474b;

        /* renamed from: c, reason: collision with root package name */
        public String f391475c;

        /* renamed from: d, reason: collision with root package name */
        public String f391476d;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        public f f391477a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f391478b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f391479c;

        /* renamed from: d, reason: collision with root package name */
        public View f391480d;

        public g() {
        }
    }

    public a(Activity activity) {
        super(activity);
        this.f391448b = null;
        this.f391449c = null;
        this.f391450d = null;
        this.f391451e = null;
        this.f391452f = 0;
        this.f391453g = 0;
        this.f391454h = 0;
        this.f391455i = 0.1f;
        this.f391456j = 0.0f;
        this.f391457k = false;
        this.f391458l = true;
        this.f391459m = true;
        this.f391460n = 0;
        this.f391461o = 0;
        this.f391464r = new c();
        this.f391465s = new d();
        this.f391447a = activity;
        o();
    }

    private void c() {
        super.dismiss();
    }

    public static Drawable g(int i3) {
        try {
            return BaseApplicationImpl.getApplication().getResources().getDrawable(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    private int j() {
        if (f() == null) {
            return 0;
        }
        Rect rect = new Rect();
        f().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i3 = rect.top;
        if (i3 > 0) {
            return i3;
        }
        return ViewUtils.getScreenHeight() - rect.height();
    }

    public static double m(double d16, double d17, double d18, double d19, double d26) {
        return d19 + (((d16 - d17) / (d18 - d17)) * (d26 - d19));
    }

    private void o() {
        this.f391463q = new ArrayList<>();
        r(R.layout.buk);
        setFocusable(true);
        setBackgroundDrawable(null);
        setWidth(-1);
        setHeight(-1);
        this.f391448b = SpringSystem.create().createSpring().setSpringConfig(f391443t).addListener(new C10131a());
        this.f391462p = new e(this.f391447a);
        ListView listView = (ListView) this.f391450d.findViewById(R.id.bqf);
        this.f391449c = listView;
        listView.setFooterDividersEnabled(false);
        this.f391449c.setHeaderDividersEnabled(false);
        this.f391449c.setAdapter((ListAdapter) this.f391462p);
        this.f391449c.setOnTouchListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        float f16;
        Spring spring = this.f391448b;
        if (spring == null) {
            return;
        }
        float currentValue = (float) spring.getCurrentValue();
        float m3 = (float) m(currentValue, 0.0d, 1.0d, 0.0d, 1.0d);
        if (currentValue < 0.0f) {
            this.f391457k = true;
        }
        if (this.f391457k) {
            m3 = (float) this.f391448b.getEndValue();
            f16 = (float) this.f391448b.getEndValue();
        } else if (this.f391458l) {
            float f17 = this.f391456j;
            float f18 = this.f391455i + f17;
            this.f391456j = f18;
            if (f18 > 1.0f) {
                this.f391456j = 1.0f;
            }
            m3 = f17;
            f16 = m3;
        } else {
            f16 = m3;
        }
        q(this.f391450d, m3);
        q(this.f391449c, 1.0f);
        ViewUtils.setScaleX(this.f391449c, f16);
        ViewUtils.setScaleY(this.f391449c, f16);
        if (this.f391459m) {
            ViewUtils.setPivotY(this.f391449c, 0.0f);
            ViewUtils.setPivotX(this.f391449c, this.f391460n);
        } else {
            ViewUtils.setPivotY(this.f391449c, this.f391461o);
            ViewUtils.setPivotX(this.f391449c, this.f391460n);
        }
        if (!this.f391458l && f16 == 0.0f) {
            c();
        }
    }

    private void q(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    private void r(int i3) {
        if (this.f391451e == null) {
            Activity f16 = f();
            if (f16 == null) {
                return;
            } else {
                this.f391451e = LayoutInflater.from(f16);
            }
        }
        if (this.f391450d == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f391451e.inflate(i3, (ViewGroup) null);
            this.f391450d = relativeLayout;
            if (relativeLayout == null) {
                return;
            }
        }
        q(this.f391450d, 0.0f);
        this.f391450d.setFocusable(true);
        this.f391450d.setFocusableInTouchMode(true);
        this.f391450d.setOnKeyListener(this.f391464r);
        this.f391450d.setOnTouchListener(this.f391465s);
        ViewUtils.setViewBackground(this.f391450d, f391446w);
        super.setContentView(this.f391450d);
    }

    public void b(f fVar) {
        ArrayList<f> arrayList = this.f391463q;
        if (arrayList != null && fVar != null) {
            arrayList.add(fVar);
        }
    }

    public boolean d(int i3, int i16) {
        if (this.f391450d != null && this.f391449c != null) {
            int screenWidth = ViewUtils.getScreenWidth() - (this.f391450d.getPaddingRight() * 2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f391449c.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(screenWidth, this.f391454h);
            }
            int k3 = i16 - k();
            layoutParams.width = screenWidth;
            layoutParams.height = this.f391454h;
            layoutParams.topMargin = k3 - ViewUtils.dpToPx(5.0f);
            this.f391449c.setLayoutParams(layoutParams);
            this.f391461o = this.f391454h;
            this.f391460n = screenWidth - ((this.f391452f / 2) - this.f391450d.getPaddingRight());
            return true;
        }
        return false;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.f391458l = false;
        l();
    }

    public void e() {
        dismiss();
    }

    public Activity f() {
        return this.f391447a;
    }

    public int h() {
        return this.f391454h;
    }

    public View i() {
        return f().findViewById(android.R.id.content).getRootView();
    }

    public int k() {
        int screenHeight;
        if (this.f391450d.getHeight() > 0 && (screenHeight = ViewUtils.getScreenHeight() - this.f391450d.getHeight()) <= ViewUtils.dpToPx(25.0f)) {
            return screenHeight;
        }
        int j3 = j();
        if (j3 <= 0) {
            return ViewUtils.dpToPx(25.0f);
        }
        return j3;
    }

    public void l() {
        Spring spring = this.f391448b;
        if (spring == null || spring.getCurrentValue() != this.f391448b.getEndValue()) {
            return;
        }
        if (this.f391448b.getEndValue() == 0.0d) {
            this.f391448b.setEndValue(1.0d);
        } else {
            this.f391448b.setEndValue(0.0d);
        }
    }

    public void n() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f391462p.getCount(); i16++) {
            View view = this.f391462p.getView(i16, null, this.f391449c);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i3 += view.getMeasuredHeight();
        }
        this.f391454h = i3 + ViewUtils.dpToPx(9.0f);
    }

    public void s(AdapterView.OnItemClickListener onItemClickListener) {
        ListView listView = this.f391449c;
        if (listView != null && onItemClickListener != null) {
            listView.setOnItemClickListener(onItemClickListener);
        }
    }

    public void t() {
        if (isShowing()) {
            return;
        }
        this.f391456j = 0.0f;
        this.f391457k = false;
        this.f391458l = true;
        this.f391459m = true;
        q(this.f391450d, 0.0f);
        ViewUtils.setViewBackground(this.f391449c, f391445v);
        ListView listView = this.f391449c;
        if (listView != null) {
            listView.setPadding(listView.getPaddingLeft(), this.f391449c.getPaddingTop() + ViewUtils.dpToPx(9.0f), this.f391449c.getPaddingRight(), this.f391449c.getPaddingBottom());
        }
        super.showAtLocation(i(), 17, 0, 0);
        l();
    }

    public void u() {
        if (isShowing()) {
            return;
        }
        this.f391456j = 0.0f;
        this.f391457k = false;
        this.f391458l = true;
        this.f391459m = false;
        q(this.f391450d, 0.0f);
        ViewUtils.setViewBackground(this.f391449c, f391444u);
        super.showAtLocation(i(), 17, 0, 0);
        l();
    }
}

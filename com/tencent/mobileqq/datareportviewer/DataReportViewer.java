package com.tencent.mobileqq.datareportviewer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DataReportViewer extends RelativeLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected TextView C;
    protected ArrayList<ReportData> D;
    protected j E;
    protected Path F;
    protected float G;
    protected Handler H;
    protected RelativeLayout I;
    protected boolean J;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f203306d;

    /* renamed from: e, reason: collision with root package name */
    protected ListView f203307e;

    /* renamed from: f, reason: collision with root package name */
    protected Button f203308f;

    /* renamed from: h, reason: collision with root package name */
    protected Button f203309h;

    /* renamed from: i, reason: collision with root package name */
    protected Button f203310i;

    /* renamed from: m, reason: collision with root package name */
    protected CheckBox f203311m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.datareportviewer.DataReportViewer$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class AnimationAnimationListenerC7481a implements Animation.AnimationListener {
            static IPatchRedirector $redirector_;

            AnimationAnimationListenerC7481a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                } else {
                    DataReportViewer.this.f203306d.setVisibility(8);
                    DataReportViewer.this.f();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
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

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            DataReportViewer.this.C.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(200L);
            DataReportViewer.this.C.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new AnimationAnimationListenerC7481a());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                DataReportViewer dataReportViewer = DataReportViewer.this;
                dataReportViewer.J = z16;
                if (z16) {
                    dataReportViewer.g();
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f203315d;

        c(Context context) {
            this.f203315d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this, (Object) context);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DataReportViewer.this.h(this.f203315d, i3);
            } else {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WindowManager f203317d;

        d(WindowManager windowManager) {
            this.f203317d = windowManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this, (Object) windowManager);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f203317d.removeViewImmediate(DataReportViewer.this.I);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WindowManager f203319d;

        e(WindowManager windowManager) {
            this.f203319d = windowManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this, (Object) windowManager);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f203319d.removeViewImmediate(DataReportViewer.this.I);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WindowManager f203321d;

        f(WindowManager windowManager) {
            this.f203321d = windowManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this, (Object) windowManager);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f203321d.removeViewImmediate(DataReportViewer.this.I);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            DataReportViewer.this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DataReportViewer.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                DataReportViewer.this.C.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                DataReportViewer.this.f203306d.setVisibility(0);
                DataReportViewer.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            DataReportViewer.this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DataReportViewer.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class j extends BaseAdapter {
        static IPatchRedirector $redirector_;

        protected j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return DataReportViewer.this.D.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return DataReportViewer.this.D.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            k kVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(DataReportViewer.this.getContext()).inflate(R.layout.v_, viewGroup, false);
                    kVar = new k(view);
                    view.setTag(kVar);
                } else {
                    kVar = (k) view.getTag();
                }
                ReportData reportData = DataReportViewer.this.D.get(i3);
                kVar.f203327a.setText(reportData.table);
                kVar.f203328b.setText(reportData.mainAction);
                kVar.f203329c.setText(reportData.subAction);
                kVar.f203330d.setText(reportData.actionName);
                kVar.f203331e.setText(String.valueOf(reportData.opType));
                kVar.f203332f.setText(String.valueOf(reportData.result));
                kVar.f203333g.setText(reportData.f203338r2);
                kVar.f203334h.setText(reportData.f203339r3);
                kVar.f203335i.setText(reportData.f203340r4);
                kVar.f203336j.setText(reportData.f203341r5);
                if (reportData.isLightBlueBg) {
                    view.setBackgroundColor(DataReportViewer.this.getContext().getResources().getColor(R.color.a5n));
                } else {
                    view.setBackgroundColor(DataReportViewer.this.getContext().getResources().getColor(R.color.f158017al3));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f203327a;

        /* renamed from: b, reason: collision with root package name */
        TextView f203328b;

        /* renamed from: c, reason: collision with root package name */
        TextView f203329c;

        /* renamed from: d, reason: collision with root package name */
        TextView f203330d;

        /* renamed from: e, reason: collision with root package name */
        TextView f203331e;

        /* renamed from: f, reason: collision with root package name */
        TextView f203332f;

        /* renamed from: g, reason: collision with root package name */
        TextView f203333g;

        /* renamed from: h, reason: collision with root package name */
        TextView f203334h;

        /* renamed from: i, reason: collision with root package name */
        TextView f203335i;

        /* renamed from: j, reason: collision with root package name */
        TextView f203336j;

        k(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportViewer.this, (Object) view);
                return;
            }
            this.f203327a = (TextView) view.findViewById(R.id.f166940ja1);
            this.f203328b = (TextView) view.findViewById(R.id.elj);
            this.f203329c = (TextView) view.findViewById(R.id.j5x);
            this.f203330d = (TextView) view.findViewById(R.id.f163923ch);
            this.f203331e = (TextView) view.findViewById(R.id.fdh);
            this.f203332f = (TextView) view.findViewById(R.id.i96);
            this.f203333g = (TextView) view.findViewById(R.id.hux);
            this.f203334h = (TextView) view.findViewById(R.id.huy);
            this.f203335i = (TextView) view.findViewById(R.id.huz);
            this.f203336j = (TextView) view.findViewById(R.id.f166752hv0);
        }
    }

    public DataReportViewer(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = new ArrayList<>(10);
        this.G = 0.0f;
        this.H = new Handler(Looper.getMainLooper());
        this.J = true;
        LayoutInflater.from(context).inflate(R.layout.f168408va, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.g3y);
        this.f203306d = (LinearLayout) findViewById(R.id.ebg);
        this.C = (TextView) findViewById(R.id.g3x);
        this.f203308f = (Button) findViewById(R.id.f166290ey0);
        this.f203309h = (Button) findViewById(R.id.ayc);
        this.f203310i = (Button) findViewById(R.id.ipv);
        this.f203311m = (CheckBox) findViewById(R.id.a1m);
        this.f203307e = (ListView) findViewById(R.id.eaw);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.f156828cl));
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextColor(-1);
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
        }
        this.E = new j();
        new DefaultItemAnimator().setRemoveDuration(500L);
        this.f203307e.setAdapter((ListAdapter) this.E);
        setWillNotDraw(false);
        this.F = new Path();
        this.C.setVisibility(8);
        this.C.setOnClickListener(this);
        this.f203308f.setOnClickListener(this);
        this.f203309h.setOnClickListener(this);
        this.f203310i.setOnClickListener(this);
        this.f203311m.setOnCheckedChangeListener(new b());
        this.f203307e.setOnItemClickListener(new c(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context, int i3) {
        int i16;
        if (ContextCompat.checkSelfPermission(context, "android.permission.SYSTEM_ALERT_WINDOW") != 0) {
            QQToast.makeText(context, "\u6ca1\u6709\u6743\u9650\uff0c\u8bf7\u5f00\u542f\u6d6e\u7a97\u6743\u9650\uff01", 0).show();
            return;
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.I == null) {
            this.I = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.f168407v9, (ViewGroup) null);
        }
        k kVar = new k(this.I);
        ReportData reportData = this.D.get(i3);
        kVar.f203327a.setText(reportData.table);
        kVar.f203328b.setText(reportData.mainAction);
        kVar.f203329c.setText(reportData.subAction);
        kVar.f203330d.setText(reportData.actionName);
        kVar.f203331e.setText(String.valueOf(reportData.opType));
        kVar.f203332f.setText(String.valueOf(reportData.result));
        kVar.f203333g.setText(reportData.f203338r2);
        kVar.f203334h.setText(reportData.f203339r3);
        kVar.f203335i.setText(reportData.f203340r4);
        kVar.f203336j.setText(reportData.f203341r5);
        ((TextView) this.I.findViewById(R.id.dialogRightBtn)).setOnClickListener(new d(windowManager));
        ((TextView) this.I.findViewById(R.id.dialogLeftBtn)).setOnClickListener(new e(windowManager));
        if (Build.VERSION.SDK_INT >= 26) {
            i16 = 2038;
        } else {
            i16 = 2003;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, i16, 776, -2);
        layoutParams.gravity = 49;
        windowManager.addView(this.I, layoutParams);
        this.I.setOnClickListener(new f(windowManager));
    }

    public void b(ReportData reportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reportData);
            return;
        }
        this.D.add(reportData);
        this.C.setText(String.valueOf(this.D.size()));
        this.E.notifyDataSetChanged();
        if (this.D.size() == 1) {
            this.H.removeCallbacksAndMessages(null);
            g();
        } else if (this.D.size() > 1) {
            ArrayList<ReportData> arrayList = this.D;
            reportData.isLightBlueBg = !arrayList.get(arrayList.size() - 2).isLightBlueBg;
        }
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(x.c(getContext(), 25.0f), (float) ah.Z());
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new g());
        ofFloat.setTarget(this);
        ofFloat.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new h());
        this.C.startAnimation(alphaAnimation);
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) ah.Z(), x.c(getContext(), 25.0f));
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new i());
        ofFloat.setTarget(this);
        ofFloat.start();
        ofFloat.addListener(new a());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.F.reset();
        Path path = this.F;
        float c16 = x.c(getContext(), 25.0f);
        float c17 = x.c(getContext(), 25.0f);
        float f16 = this.G;
        if (f16 == 0.0f) {
            f16 = getWidth();
        }
        path.addCircle(c16, c17, f16, Path.Direction.CW);
        canvas.clipPath(this.F);
        super.draw(canvas);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.J) {
            this.H.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.datareportviewer.DataReportViewer.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!DataReportViewer.this.D.isEmpty()) {
                        DataReportViewer.this.D.remove(0);
                        DataReportViewer dataReportViewer = DataReportViewer.this;
                        dataReportViewer.C.setText(String.valueOf(dataReportViewer.D.size()));
                        DataReportViewer.this.E.notifyDataSetChanged();
                        DataReportViewer.this.g();
                        return;
                    }
                    if (com.tencent.mobileqq.datareportviewer.b.F) {
                        com.tencent.mobileqq.datareportviewer.b.i().j();
                    }
                }
            }, 3000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f166290ey0) {
                d();
            } else if (id5 == R.id.g3x) {
                c();
            } else if (id5 == R.id.ayc) {
                this.H.removeCallbacksAndMessages(null);
                this.D.clear();
                this.C.setText(String.valueOf(this.D.size()));
                this.E.notifyDataSetChanged();
                this.H.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.datareportviewer.DataReportViewer.11
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataReportViewer.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (com.tencent.mobileqq.datareportviewer.b.F) {
                            com.tencent.mobileqq.datareportviewer.b.i().j();
                        }
                    }
                }, 3000L);
            } else if (id5 == R.id.ipv) {
                PublicFragmentActivity.b.b(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

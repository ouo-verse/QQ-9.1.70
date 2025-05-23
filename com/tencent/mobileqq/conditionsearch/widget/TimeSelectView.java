package com.tencent.mobileqq.conditionsearch.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.utils.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TimeSelectView extends LinearLayout {
    static IPatchRedirector $redirector_;
    public static int I;
    private static int J;
    private i C;
    private j D;
    private boolean E;
    Vibrator F;
    private AdapterView.OnItemSelectedListener G;
    private VerticalGallery.OnSelectViewDataUpdateListener H;

    /* renamed from: d, reason: collision with root package name */
    private int f202025d;

    /* renamed from: e, reason: collision with root package name */
    private Button f202026e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f202027f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f202028h;

    /* renamed from: i, reason: collision with root package name */
    private WheelView[] f202029i;

    /* renamed from: m, reason: collision with root package name */
    private h[] f202030m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (TimeSelectView.this.C != null) {
                TimeSelectView.this.C.onConfirmBtClicked();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (TimeSelectView.this.C != null) {
                TimeSelectView.this.C.a(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (TimeSelectView.this.C != null) {
                TimeSelectView.this.C.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            Vibrator vibrator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TimeSelectView.this.k(view, 1);
                TimeSelectView.this.m(view, true);
                if (view != null && view.getTag() != null) {
                    int parseInt = Integer.parseInt(view.getTag().toString());
                    int childCount = adapterView.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        if (parseInt != i16) {
                            TimeSelectView.this.k(adapterView.getChildAt(i16), 0);
                            TimeSelectView.this.m(adapterView.getChildAt(i16), false);
                        }
                    }
                }
                if (!TimeSelectView.this.E && (vibrator = TimeSelectView.this.F) != null) {
                    vibrator.vibrate(q.f196674j, -1);
                    if (QLog.isColorLevel()) {
                        QLog.d("TimeSelectView", 1, "hasVibrator: " + TimeSelectView.this.F.hasVibrator() + "Vibrator vibrate! " + TimeSelectView.this.E);
                    }
                }
                TimeSelectView.this.E = false;
                return;
            }
            iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapterView);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements VerticalGallery.OnSelectViewDataUpdateListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this);
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TimeSelectView.this.k(view, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g implements VerticalGallery.OnEndMovementListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f202037d;

        public g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimeSelectView.this, i3);
            } else {
                this.f202037d = i3;
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) verticalGallery);
                return;
            }
            int selectedItemPosition = TimeSelectView.this.f202029i[this.f202037d].getSelectedItemPosition();
            if (TimeSelectView.this.C != null) {
                TimeSelectView.this.C.onItemSelected(this.f202037d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class h extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f202039d;

        /* renamed from: e, reason: collision with root package name */
        private int f202040e;

        public h(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, TimeSelectView.this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f202039d = 25;
            this.f202040e = i3;
            this.f202039d = (int) TypedValue.applyDimension(1, i16, TimeSelectView.this.getResources().getDisplayMetrics());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return TimeSelectView.this.D.getRowCount(this.f202040e);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = new WheelTextView(TimeSelectView.this.getContext());
                    view.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f202039d));
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TimeSelectView", 2, "getView column:" + this.f202040e + ", position: " + i3);
                }
                String text = TimeSelectView.this.D.getText(this.f202040e, i3);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = x.c(TimeSelectView.this.getContext(), 35.0f);
                if (QLog.isColorLevel()) {
                    QLog.d("TimeSelectView", 2, "view height 33dp -> " + layoutParams.height + "px");
                }
                view.setLayoutParams(layoutParams);
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(TimeSelectView.this.getResources().getColorStateList(R.color.qui_common_text_secondary));
                if (TimeSelectView.this.f202029i[0].getId() == viewGroup.getId()) {
                    wheelTextView.setGravity(8388613);
                } else {
                    wheelTextView.setGravity(8388611);
                }
                wheelTextView.setText(text);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface i {
        void a(View view);

        void b();

        void onConfirmBtClicked();

        void onItemSelected(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface j {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            I = -7829368;
            J = -12303292;
        }
    }

    public TimeSelectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f202025d = 0;
        this.G = new e();
        this.H = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    public void k(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(getResources().getColorStateList(R.color.qui_common_text_secondary));
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(20.0f);
                wheelTextView2.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
            }
        }
    }

    private void l(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        h hVar = new h(i3, 25);
        this.f202029i[i3] = wheelView;
        this.f202030m[i3] = hVar;
        wheelView.setAdapter((SpinnerAdapter) hVar);
        wheelView.setOnItemSelectedListener(this.G);
        wheelView.setOnSelectViewDataUpdateListener(this.H);
        wheelView.setOnEndMovementListener(new g(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, boolean z16) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f202029i;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void i(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
            return;
        }
        Resources resources = getContext().getResources();
        I = resources.getColor(R.color.skin_gray6);
        J = resources.getColor(R.color.skin_color_dark_gray);
        View findViewById = findViewById(R.id.jlt);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.skin_mode_normal_border_color));
        }
        View findViewById2 = findViewById(R.id.e_x);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(resources.getColor(R.color.skin_mode_normal_border_color));
        }
        View findViewById3 = findViewById(R.id.e_b);
        if (findViewById3 != null) {
            findViewById3.setBackgroundColor(resources.getColor(R.color.skin_mode_normal_border_color));
        }
        this.D = jVar;
        int columnCount = jVar.getColumnCount();
        this.f202025d = columnCount;
        if (columnCount > 0 && columnCount <= 2) {
            this.f202029i = new WheelView[columnCount];
            this.f202030m = new h[columnCount];
            this.F = (Vibrator) getContext().getSystemService("vibrator");
            if (FontSettingManager.getFontLevel() >= 21.24f) {
                findViewById(R.id.f81644eq).setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            }
            WheelView wheelView = (WheelView) findViewById(R.id.v77);
            WheelView wheelView2 = (WheelView) findViewById(R.id.f81714ex);
            this.f202026e = (Button) findViewById(R.id.jlr);
            this.f202027f = (TextView) findViewById(R.id.maf);
            this.f202028h = (TextView) findViewById(R.id.f97345k5);
            Button button = this.f202026e;
            if (button != null) {
                button.setOnClickListener(new a());
                this.f202026e.setOnTouchListener(new b());
            }
            TextView textView = this.f202027f;
            if (textView != null) {
                textView.setOnClickListener(new c());
            }
            TextView textView2 = this.f202028h;
            if (textView2 != null) {
                textView2.setOnClickListener(new d());
            }
            l(wheelView, 0);
            wheelView.setNeedTranslateCenter(true);
            wheelView.setNeedTranslateCenterToRight(true);
            if (this.f202025d < 2) {
                wheelView2.setVisibility(8);
                return;
            }
            wheelView2.setVisibility(0);
            l(wheelView2, 1);
            wheelView2.setNeedTranslateCenter(true);
            return;
        }
        throw new RuntimeException("Unsupportted column count " + this.f202025d);
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 >= 0) {
            h[] hVarArr = this.f202030m;
            if (i3 < hVarArr.length) {
                hVarArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iVar);
        } else {
            this.C = iVar;
        }
    }

    public void setSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f202029i;
            if (i3 < wheelViewArr.length) {
                this.E = true;
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public TimeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f202025d = 0;
        this.G = new e();
        this.H = new f();
    }
}

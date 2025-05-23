package com.tencent.mobileqq.remind.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* compiled from: P */
/* loaded from: classes18.dex */
public class IosTimepicker extends LinearLayout {
    static IPatchRedirector $redirector_;
    private static String R;
    private Button C;
    private TextView D;
    private LinearLayout E;
    private WheelView[] F;
    private BaseAdapter[] G;
    private int[] H;
    private long I;
    private long J;
    private int K;
    private int L;
    private e M;
    private AdapterView.OnItemSelectedListener N;
    private VerticalGallery.OnSelectViewDataUpdateListener P;
    private VerticalGallery.OnEndFlingListener Q;

    /* renamed from: d, reason: collision with root package name */
    private Context f280887d;

    /* renamed from: e, reason: collision with root package name */
    private ActionSheet f280888e;

    /* renamed from: f, reason: collision with root package name */
    private f f280889f;

    /* renamed from: h, reason: collision with root package name */
    private String[] f280890h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f280891i;

    /* renamed from: m, reason: collision with root package name */
    private View f280892m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IosTimepicker.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (IosTimepicker.this.f280888e != null && IosTimepicker.this.f280888e.isShowing()) {
                IosTimepicker.this.f280888e.dismiss();
                IosTimepicker.this.f280888e = null;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IosTimepicker.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IosTimepicker.this.h(view, 1);
                if (view != null && view.getTag() != null) {
                    int parseInt = Integer.parseInt(view.getTag().toString());
                    int childCount = adapterView.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        if (parseInt != i16) {
                            IosTimepicker.this.h(adapterView.getChildAt(i16), 0);
                        }
                    }
                    return;
                }
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
    /* loaded from: classes18.dex */
    class c implements VerticalGallery.OnSelectViewDataUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IosTimepicker.this);
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IosTimepicker.this.h(view, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements VerticalGallery.OnEndFlingListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IosTimepicker.this);
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndFlingListener
        public void onEndFling(VerticalGallery verticalGallery) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IosTimepicker.this.e();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) verticalGallery);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        long a(WheelView[] wheelViewArr, int[] iArr);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void a(long j3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50752);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            R = "remind";
        }
    }

    public IosTimepicker(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f280892m = null;
        this.C = null;
        this.D = null;
        this.N = new b();
        this.P = new c();
        this.Q = new d();
        this.f280887d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.M != null) {
            int length = this.H.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.H[i3] = this.F[i3].getSelectedItemPosition();
            }
            this.J = this.M.a(this.F, this.H);
        }
        f fVar = this.f280889f;
        if (fVar != null) {
            fVar.a(this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(this.K);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(20.0f);
                wheelTextView2.setTextColor(this.L);
            }
        }
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.J;
    }

    public void g(Context context, ActionSheet actionSheet, f fVar, View.OnClickListener onClickListener, BaseAdapter[] baseAdapterArr, int[] iArr, e eVar) {
        LinearLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, actionSheet, fVar, onClickListener, baseAdapterArr, iArr, eVar);
            return;
        }
        if (baseAdapterArr != null && baseAdapterArr.length != 0 && baseAdapterArr.length <= 3) {
            if (iArr != null && iArr.length != 0) {
                if (iArr.length == baseAdapterArr.length) {
                    this.f280887d = context;
                    this.f280888e = actionSheet;
                    this.f280889f = fVar;
                    this.G = baseAdapterArr;
                    this.H = iArr;
                    int length = baseAdapterArr.length;
                    int length2 = iArr.length;
                    this.F = new WheelView[length];
                    this.M = eVar;
                    for (int i3 = 0; i3 < length; i3++) {
                        this.F[i3] = new WheelView(this.f280887d);
                    }
                    Resources resources = this.f280887d.getResources();
                    this.K = resources.getColor(R.color.skin_gray6);
                    this.L = resources.getColor(R.color.skin_color_dark_gray);
                    this.f280890h = com.tencent.mobileqq.remind.e.f280885b;
                    this.f280891i = com.tencent.mobileqq.remind.e.f280886c;
                    this.f280892m = findViewById(R.id.dol);
                    this.E = (LinearLayout) findViewById(R.id.dok);
                    this.D = (TextView) findViewById(R.id.ima);
                    this.C = (Button) findViewById(R.id.jlr);
                    int color = resources.getColor(R.color.f157965ag0);
                    findViewById(R.id.doj).setBackgroundColor(color);
                    findViewById(R.id.doi).setBackgroundColor(color);
                    this.f280892m.setBackgroundColor(resources.getColor(R.color.skin_color_light_gray));
                    int color2 = resources.getColor(R.color.afz);
                    findViewById(R.id.e_x).setBackgroundColor(color2);
                    findViewById(R.id.e_b).setBackgroundColor(color2);
                    if (onClickListener != null) {
                        this.C.setOnClickListener(onClickListener);
                    } else {
                        this.C.setOnClickListener(new a());
                    }
                    if (length == 1) {
                        this.F[0].setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                        this.F[0].setAdapter((SpinnerAdapter) this.G[0]);
                        if (QLog.isColorLevel()) {
                            QLog.d(R, 2, "createTimePicker Time :" + com.tencent.mobileqq.remind.e.a(this.I));
                        }
                    } else {
                        for (int i16 = 0; i16 < length; i16++) {
                            WheelView wheelView = this.F[i16];
                            if (i16 == 0) {
                                layoutParams = new LinearLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.azm), -1);
                            } else {
                                layoutParams = new LinearLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.azo), -1);
                            }
                            layoutParams.setMargins(0, resources.getDimensionPixelSize(R.dimen.azr), 0, resources.getDimensionPixelSize(R.dimen.azp));
                            wheelView.setLayoutParams(layoutParams);
                            if (i16 != 0) {
                                wheelView.setScrollCycle(true);
                                wheelView.setmMaxRotationAngle(80);
                                wheelView.setmMaxSkew(0.1f);
                                wheelView.setNeedTranslate(true);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(R, 2, "createTimePicker Time :" + com.tencent.mobileqq.remind.e.a(this.I));
                        }
                    }
                    for (int i17 = 0; i17 < length2; i17++) {
                        WheelView wheelView2 = this.F[i17];
                        this.E.addView(wheelView2);
                        wheelView2.setAdapter((SpinnerAdapter) this.G[i17]);
                        wheelView2.setSelection(this.H[i17], true);
                        wheelView2.setOnItemSelectedListener(this.N);
                        wheelView2.setOnSelectViewDataUpdateListener(this.P);
                        wheelView2.setOnEndFlingListener(this.Q);
                    }
                    e();
                    return;
                }
                throw new IllegalArgumentException("selectionPos.length is not equal to adapters.length");
            }
            throw new IllegalArgumentException("selectionPos is null or empty, or its length is larger than 3");
        }
        throw new IllegalArgumentException("adapters is null or empty, or its length is larger than 3");
    }

    public void setFormatDataListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            this.M = eVar;
        }
    }

    public void setMaxDays(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.remind.e.f280884a = i3;
        if (QLog.isColorLevel()) {
            QLog.d(R, 2, "setMaxDays days = " + com.tencent.mobileqq.remind.e.f280884a);
        }
    }

    public void setOnTimePickerSelectListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fVar);
        } else {
            this.f280889f = fVar;
        }
    }

    public void setTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public IosTimepicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f280892m = null;
        this.C = null;
        this.D = null;
        this.N = new b();
        this.P = new c();
        this.Q = new d();
        this.f280887d = context;
    }

    @TargetApi(11)
    public IosTimepicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f280892m = null;
        this.C = null;
        this.D = null;
        this.N = new b();
        this.P = new c();
        this.Q = new d();
        this.f280887d = context;
    }
}

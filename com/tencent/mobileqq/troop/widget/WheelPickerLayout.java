package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes19.dex */
public class WheelPickerLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private AdapterView.OnItemSelectedListener C;
    private VerticalGallery.OnSelectViewDataUpdateListener D;

    /* renamed from: d, reason: collision with root package name */
    private f f302485d;

    /* renamed from: e, reason: collision with root package name */
    private int f302486e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView[] f302487f;

    /* renamed from: h, reason: collision with root package name */
    private d[] f302488h;

    /* renamed from: i, reason: collision with root package name */
    private g f302489i;

    /* renamed from: m, reason: collision with root package name */
    private e f302490m;

    /* loaded from: classes19.dex */
    class a implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WheelPickerLayout.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WheelPickerLayout.this.j(view, 1);
                WheelPickerLayout.this.l(view, true);
                if (view != null && view.getTag() != null) {
                    int parseInt = Integer.parseInt(view.getTag().toString());
                    int childCount = adapterView.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        if (parseInt != i16) {
                            WheelPickerLayout.this.j(adapterView.getChildAt(i16), 0);
                            WheelPickerLayout.this.l(adapterView.getChildAt(i16), false);
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

    /* loaded from: classes19.dex */
    class b implements VerticalGallery.OnSelectViewDataUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WheelPickerLayout.this);
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WheelPickerLayout.this.j(view, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class c implements VerticalGallery.OnEndMovementListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f302493d;

        public c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WheelPickerLayout.this, i3);
            } else {
                this.f302493d = i3;
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) verticalGallery);
                return;
            }
            int selectedItemPosition = WheelPickerLayout.this.f302487f[this.f302493d].getSelectedItemPosition();
            if (WheelPickerLayout.this.f302489i != null) {
                WheelPickerLayout.this.f302489i.onItemSelected(this.f302493d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f302495d;

        /* renamed from: e, reason: collision with root package name */
        private final int f302496e;

        public d(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WheelPickerLayout.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f302496e = i3;
                this.f302495d = (int) TypedValue.applyDimension(1, i16, WheelPickerLayout.this.getResources().getDisplayMetrics());
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return WheelPickerLayout.this.f302490m.getRowCount(this.f302496e);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return Integer.valueOf(i3);
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
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = new WheelTextView(WheelPickerLayout.this.getContext());
                    view.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f302495d));
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                }
                String text = WheelPickerLayout.this.f302490m.getText(this.f302496e, i3);
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(1, WheelPickerLayout.this.f302485d.f302499b);
                wheelTextView.setTextColor(WheelPickerLayout.this.f302485d.f302500c);
                wheelTextView.setGravity(WheelPickerLayout.this.f302485d.f302501d);
                wheelTextView.setText(text);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes19.dex */
    public interface e {
        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes19.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f302498a;

        /* renamed from: b, reason: collision with root package name */
        public int f302499b;

        /* renamed from: c, reason: collision with root package name */
        public int f302500c;

        /* renamed from: d, reason: collision with root package name */
        public int f302501d;

        /* renamed from: e, reason: collision with root package name */
        public int f302502e;

        /* renamed from: f, reason: collision with root package name */
        public int f302503f;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public interface g {
        void onItemSelected(int i3, int i16);
    }

    public WheelPickerLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302486e = 0;
        this.C = new a();
        this.D = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(1, this.f302485d.f302499b);
                wheelTextView.setTextColor(this.f302485d.f302500c);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(1, this.f302485d.f302502e);
                wheelTextView2.setTextColor(this.f302485d.f302503f);
            }
        }
    }

    private void k(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        d dVar = new d(i3, this.f302485d.f302498a);
        this.f302487f[i3] = wheelView;
        this.f302488h[i3] = dVar;
        wheelView.setAdapter((SpinnerAdapter) dVar);
        wheelView.setOnItemSelectedListener(this.C);
        wheelView.setOnSelectViewDataUpdateListener(this.D);
        wheelView.setOnEndMovementListener(new c(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view, boolean z16) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f302487f;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void h(e eVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar, (Object) fVar);
            return;
        }
        this.f302485d = fVar;
        if (fVar != null) {
            this.f302490m = eVar;
            int childCount = getChildCount();
            this.f302486e = childCount;
            if (childCount > 0) {
                this.f302487f = new WheelView[childCount];
                this.f302488h = new d[childCount];
                for (int i3 = 0; i3 < this.f302486e; i3++) {
                    k((WheelView) getChildAt(i3), i3);
                }
                return;
            }
            throw new RuntimeException("Unsupportted column count " + this.f302486e);
        }
        throw new RuntimeException("ViewStyle can not be null!");
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 >= 0) {
            d[] dVarArr = this.f302488h;
            if (i3 < dVarArr.length) {
                dVarArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gVar);
        } else {
            this.f302489i = gVar;
        }
    }

    public void setSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f302487f;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public WheelPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302486e = 0;
        this.C = new a();
        this.D = new b();
    }
}

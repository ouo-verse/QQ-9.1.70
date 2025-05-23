package com.tencent.mobileqq.wink.view.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes21.dex */
public class WinkPickerView extends LinearLayout {
    private AdapterView.OnItemSelectedListener C;
    private VerticalGallery.OnSelectViewDataUpdateListener D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f327126d;

    /* renamed from: e, reason: collision with root package name */
    private Context f327127e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView[] f327128f;

    /* renamed from: h, reason: collision with root package name */
    private d[] f327129h;

    /* renamed from: i, reason: collision with root package name */
    private e f327130i;

    /* renamed from: m, reason: collision with root package name */
    private f f327131m;

    /* loaded from: classes21.dex */
    class b implements VerticalGallery.OnSelectViewDataUpdateListener {
        b() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            WinkPickerView.this.l(view, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements VerticalGallery.OnEndMovementListener {

        /* renamed from: d, reason: collision with root package name */
        private int f327134d;

        public c(int i3) {
            this.f327134d = i3;
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            int selectedItemPosition = WinkPickerView.this.f327128f[this.f327134d].getSelectedItemPosition();
            if (WinkPickerView.this.f327131m != null) {
                WinkPickerView.this.f327131m.onItemSelected(this.f327134d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private int f327136d;

        public d(int i3) {
            this.f327136d = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WinkPickerView.this.f327130i.getRowCount(this.f327136d);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int i16;
            if (view == null) {
                view = new WheelTextView(WinkPickerView.this.getContext());
                view.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(40.0f)));
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            String text = WinkPickerView.this.f327130i.getText(this.f327136d, i3);
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setTextSize(2, 17.0f);
            if (WinkPickerView.this.f327126d) {
                i16 = DownloadCardView.COLOR_APP_VERSION;
            } else {
                i16 = -7829368;
            }
            wheelTextView.setTextColor(i16);
            wheelTextView.setGravity(17);
            wheelTextView.setSingleLine();
            wheelTextView.setMinEms(3);
            wheelTextView.setText(text);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes21.dex */
    public interface e {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes21.dex */
    public interface f {
        void onItemSelected(int i3, int i16);
    }

    public WinkPickerView(Context context) {
        this(context, null);
    }

    private View g(int i3) {
        if (i3 == 1) {
            return LayoutInflater.from(this.f327127e).inflate(R.layout.f168614g21, (ViewGroup) null);
        }
        if (i3 == 2) {
            return LayoutInflater.from(this.f327127e).inflate(R.layout.f168615g22, (ViewGroup) null);
        }
        if (i3 == 3) {
            return LayoutInflater.from(this.f327127e).inflate(R.layout.f168616g23, (ViewGroup) null);
        }
        if (i3 == 4) {
            return LayoutInflater.from(this.f327127e).inflate(R.layout.f168617g24, (ViewGroup) null);
        }
        return LayoutInflater.from(this.f327127e).inflate(R.layout.f168618g25, (ViewGroup) null);
    }

    private void h(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        d dVar = new d(i3);
        this.f327128f[i3] = wheelView;
        this.f327129h[i3] = dVar;
        wheelView.setAdapter((SpinnerAdapter) dVar);
        wheelView.setOnItemSelectedListener(this.C);
        wheelView.setOnSelectViewDataUpdateListener(this.D);
        wheelView.setOnEndMovementListener(new c(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view, int i3) {
        int i16;
        int i17;
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(17.0f);
                if (this.f327126d) {
                    i17 = DownloadCardView.COLOR_APP_VERSION;
                } else {
                    i17 = -7829368;
                }
                wheelTextView.setTextColor(i17);
                return;
            }
            WheelTextView wheelTextView2 = (WheelTextView) view;
            wheelTextView2.setTextSize(17.0f);
            if (this.f327126d) {
                i16 = -1;
            } else {
                i16 = -12303292;
            }
            wheelTextView2.setTextColor(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public void i(e eVar) {
        this.f327130i = eVar;
        int columnCount = eVar.getColumnCount();
        if (columnCount > 0 && columnCount <= 5) {
            this.f327128f = new WheelView[columnCount];
            this.f327129h = new d[columnCount];
            removeAllViewsInLayout();
            View g16 = g(columnCount);
            addView(g16, new LinearLayout.LayoutParams(-1, -1));
            int[] iArr = {R.id.f62012zo, R.id.f62042zr, R.id.f62052zs, R.id.f62022zp, R.id.f62002zn};
            for (int i3 = 0; i3 < columnCount; i3++) {
                h((WheelView) g16.findViewById(iArr[i3]), i3);
            }
            invalidate();
            return;
        }
        throw new RuntimeException("Unsupported columnCount count " + columnCount);
    }

    public void j(e eVar, boolean z16) {
        this.f327126d = z16;
        if (z16) {
            setBackgroundColor(-15592942);
        }
        i(eVar);
    }

    public void k(int i3) {
        if (i3 >= 0) {
            d[] dVarArr = this.f327129h;
            if (i3 < dVarArr.length) {
                dVarArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(f fVar) {
        this.f327131m = fVar;
    }

    public void setSelection(int i3, int i16) {
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f327128f;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public WinkPickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkPickerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f327126d = false;
        this.C = new a();
        this.D = new b();
        this.f327127e = context;
        setOrientation(1);
    }

    /* loaded from: classes21.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            WinkPickerView.this.l(view, 1);
            WinkPickerView.this.m(view);
            if (view != null && view.getTag() != null) {
                int parseInt = Integer.parseInt(view.getTag().toString());
                int childCount = adapterView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (parseInt != i16) {
                        WinkPickerView.this.l(adapterView.getChildAt(i16), 0);
                        WinkPickerView.this.m(adapterView.getChildAt(i16));
                    }
                }
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}

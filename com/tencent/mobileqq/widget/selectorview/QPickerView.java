package com.tencent.mobileqq.widget.selectorview;

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
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes20.dex */
public class QPickerView extends LinearLayout {
    private f C;
    private int D;
    private AdapterView.OnItemSelectedListener E;
    private VerticalGallery.OnSelectViewDataUpdateListener F;

    /* renamed from: d, reason: collision with root package name */
    private boolean f317364d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f317365e;

    /* renamed from: f, reason: collision with root package name */
    private Context f317366f;

    /* renamed from: h, reason: collision with root package name */
    private WheelView[] f317367h;

    /* renamed from: i, reason: collision with root package name */
    private d[] f317368i;

    /* renamed from: m, reason: collision with root package name */
    private e f317369m;

    /* loaded from: classes20.dex */
    class b implements VerticalGallery.OnSelectViewDataUpdateListener {
        b() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            QPickerView.this.n(view, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c implements VerticalGallery.OnEndMovementListener {

        /* renamed from: d, reason: collision with root package name */
        private int f317372d;

        public c(int i3) {
            this.f317372d = i3;
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            int selectedItemPosition = QPickerView.this.f317367h[this.f317372d].getSelectedItemPosition();
            if (QPickerView.this.C != null) {
                QPickerView.this.C.onItemSelected(this.f317372d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private int f317374d;

        public d(int i3) {
            this.f317374d = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return QPickerView.this.f317369m.getRowCount(this.f317374d);
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
                view = new WheelTextView(QPickerView.this.getContext());
                view.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(30.0f)));
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            String text = QPickerView.this.f317369m.getText(this.f317374d, i3);
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setTextSize(2, 16.0f);
            QPickerView qPickerView = QPickerView.this;
            if (qPickerView.f317365e) {
                wheelTextView.setTextColor(qPickerView.getResources().getColorStateList(R.color.qui_common_text_secondary));
            } else {
                if (qPickerView.f317364d) {
                    i16 = DownloadCardView.COLOR_APP_VERSION;
                } else {
                    i16 = -7829368;
                }
                wheelTextView.setTextColor(i16);
            }
            wheelTextView.setGravity(17);
            wheelTextView.setSingleLine();
            wheelTextView.setMinEms(3);
            wheelTextView.setText(text);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes20.dex */
    public interface e {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes20.dex */
    public interface f {
        void onItemSelected(int i3, int i16);
    }

    public QPickerView(Context context) {
        this(context, null);
    }

    private View g(int i3) {
        if (this.D != 0) {
            return LayoutInflater.from(this.f317366f).inflate(this.D, (ViewGroup) null);
        }
        if (i3 == 1) {
            return LayoutInflater.from(this.f317366f).inflate(R.layout.e3_, (ViewGroup) null);
        }
        if (i3 == 2) {
            return LayoutInflater.from(this.f317366f).inflate(R.layout.e3a, (ViewGroup) null);
        }
        return LayoutInflater.from(this.f317366f).inflate(R.layout.e3b, (ViewGroup) null);
    }

    private void i(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        d dVar = new d(i3);
        this.f317367h[i3] = wheelView;
        this.f317368i[i3] = dVar;
        wheelView.setAdapter((SpinnerAdapter) dVar);
        wheelView.setOnItemSelectedListener(this.E);
        wheelView.setOnSelectViewDataUpdateListener(this.F);
        wheelView.setOnEndMovementListener(new c(i3));
    }

    private void l(e eVar) {
        this.f317369m = eVar;
        int columnCount = eVar.getColumnCount();
        if (columnCount > 0 && columnCount <= 3) {
            this.f317367h = new WheelView[columnCount];
            this.f317368i = new d[columnCount];
            removeAllViewsInLayout();
            View g16 = g(columnCount);
            addView(g16, new LinearLayout.LayoutParams(-1, -1));
            int[] iArr = {R.id.f62012zo, R.id.f62042zr, R.id.f62052zs};
            for (int i3 = 0; i3 < columnCount; i3++) {
                i((WheelView) g16.findViewById(iArr[i3]), i3);
            }
            invalidate();
            return;
        }
        throw new RuntimeException("Unsupported columnCount count " + columnCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, int i3) {
        int i16;
        int i17;
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(16.0f);
                if (this.f317365e) {
                    wheelTextView.setTextColor(getResources().getColorStateList(R.color.qui_common_text_secondary));
                    return;
                }
                if (this.f317364d) {
                    i17 = DownloadCardView.COLOR_APP_VERSION;
                } else {
                    i17 = -7829368;
                }
                wheelTextView.setTextColor(i17);
                return;
            }
            WheelTextView wheelTextView2 = (WheelTextView) view;
            wheelTextView2.setTextSize(17.0f);
            if (this.f317365e) {
                wheelTextView2.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
                return;
            }
            if (this.f317364d) {
                i16 = -1;
            } else {
                i16 = -12303292;
            }
            wheelTextView2.setTextColor(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int h(int i3) {
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f317367h;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void j(e eVar) {
        l(eVar);
    }

    public void k(e eVar, boolean z16) {
        this.f317365e = false;
        this.f317364d = z16;
        if (z16) {
            setBackgroundColor(MiniChatConstants.COLOR_NIGHT);
        }
        j(eVar);
    }

    public void m(int i3) {
        if (i3 >= 0) {
            d[] dVarArr = this.f317368i;
            if (i3 < dVarArr.length) {
                dVarArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(f fVar) {
        this.C = fVar;
    }

    public void setSelection(int i3, int i16) {
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f317367h;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setSelectorViewId(int i3) {
        this.D = i3;
    }

    public QPickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QPickerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f317364d = false;
        this.f317365e = true;
        this.E = new a();
        this.F = new b();
        this.f317366f = context;
        setOrientation(1);
    }

    /* loaded from: classes20.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            QPickerView.this.n(view, 1);
            QPickerView.this.o(view);
            if (view != null && view.getTag() != null) {
                int parseInt = Integer.parseInt(view.getTag().toString());
                int childCount = adapterView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (parseInt != i16) {
                        QPickerView.this.n(adapterView.getChildAt(i16), 0);
                        QPickerView.this.o(adapterView.getChildAt(i16));
                    }
                }
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}

package com.tencent.mobileqq.guild.widget.selector;

import android.content.Context;
import android.graphics.Color;
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

/* loaded from: classes14.dex */
public class GuildEditPickerView extends LinearLayout {
    private f C;
    private AdapterView.OnItemSelectedListener D;
    private VerticalGallery.OnSelectViewDataUpdateListener E;

    /* renamed from: d, reason: collision with root package name */
    private boolean f236531d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f236532e;

    /* renamed from: f, reason: collision with root package name */
    private Context f236533f;

    /* renamed from: h, reason: collision with root package name */
    private WheelView[] f236534h;

    /* renamed from: i, reason: collision with root package name */
    private d[] f236535i;

    /* renamed from: m, reason: collision with root package name */
    private e f236536m;

    /* loaded from: classes14.dex */
    class b implements VerticalGallery.OnSelectViewDataUpdateListener {
        b() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            GuildEditPickerView.this.m(view, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class c implements VerticalGallery.OnEndMovementListener {

        /* renamed from: d, reason: collision with root package name */
        private int f236539d;

        public c(int i3) {
            this.f236539d = i3;
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            int selectedItemPosition = GuildEditPickerView.this.f236534h[this.f236539d].getSelectedItemPosition();
            if (GuildEditPickerView.this.C != null) {
                GuildEditPickerView.this.C.onItemSelected(this.f236539d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private int f236541d;

        public d(int i3) {
            this.f236541d = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GuildEditPickerView.this.f236536m.getRowCount(this.f236541d);
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
                view = new WheelTextView(GuildEditPickerView.this.getContext());
                view.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(30.0f)));
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            String text = GuildEditPickerView.this.f236536m.getText(this.f236541d, i3);
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setTextSize(2, 16.0f);
            if (GuildEditPickerView.this.f236531d) {
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

    /* loaded from: classes14.dex */
    public interface e {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes14.dex */
    public interface f {
        void onItemSelected(int i3, int i16);
    }

    public GuildEditPickerView(Context context) {
        this(context, null);
    }

    private View g(int i3) {
        if (i3 == 1) {
            return LayoutInflater.from(this.f236533f).inflate(R.layout.edj, (ViewGroup) null);
        }
        if (i3 == 2) {
            if (this.f236532e) {
                return LayoutInflater.from(this.f236533f).inflate(R.layout.edl, (ViewGroup) null);
            }
            return LayoutInflater.from(this.f236533f).inflate(R.layout.edk, (ViewGroup) null);
        }
        return LayoutInflater.from(this.f236533f).inflate(R.layout.edm, (ViewGroup) null);
    }

    private void i(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        d dVar = new d(i3);
        this.f236534h[i3] = wheelView;
        this.f236535i[i3] = dVar;
        wheelView.setAdapter((SpinnerAdapter) dVar);
        wheelView.setOnItemSelectedListener(this.D);
        wheelView.setOnSelectViewDataUpdateListener(this.E);
        wheelView.setOnEndMovementListener(new c(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, int i3) {
        int i16;
        int i17;
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(16.0f);
                if (this.f236531d) {
                    i17 = DownloadCardView.COLOR_APP_VERSION;
                } else {
                    i17 = -7829368;
                }
                wheelTextView.setTextColor(i17);
                return;
            }
            WheelTextView wheelTextView2 = (WheelTextView) view;
            wheelTextView2.setTextSize(17.0f);
            if (this.f236531d) {
                i16 = -1;
            } else {
                i16 = -12303292;
            }
            wheelTextView2.setTextColor(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int h(int i3) {
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.f236534h;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void j(e eVar) {
        this.f236536m = eVar;
        int columnCount = eVar.getColumnCount();
        if (columnCount > 0 && columnCount <= 3) {
            this.f236534h = new WheelView[columnCount];
            this.f236535i = new d[columnCount];
            removeAllViewsInLayout();
            View g16 = g(columnCount);
            addView(g16, new LinearLayout.LayoutParams(-1, -1));
            int[] iArr = {R.id.f122297dk, R.id.f122307dl, R.id.f122317dm};
            for (int i3 = 0; i3 < columnCount; i3++) {
                i((WheelView) g16.findViewById(iArr[i3]), i3);
            }
            invalidate();
            return;
        }
        throw new RuntimeException("Unsupported columnCount count " + columnCount);
    }

    public void k(e eVar, boolean z16) {
        this.f236531d = z16;
        if (z16) {
            setBackgroundColor(Color.parseColor("#1A1A1A"));
        }
        j(eVar);
    }

    public void l(int i3) {
        if (i3 >= 0) {
            d[] dVarArr = this.f236535i;
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
            WheelView[] wheelViewArr = this.f236534h;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public GuildEditPickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildEditPickerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236531d = false;
        this.f236532e = false;
        this.D = new a();
        this.E = new b();
        this.f236533f = context;
        setOrientation(1);
    }

    /* loaded from: classes14.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            GuildEditPickerView.this.m(view, 1);
            GuildEditPickerView.this.n(view);
            if (view != null && view.getTag() != null) {
                int parseInt = Integer.parseInt(view.getTag().toString());
                int childCount = adapterView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (parseInt != i16) {
                        GuildEditPickerView.this.m(adapterView.getChildAt(i16), 0);
                        GuildEditPickerView.this.n(adapterView.getChildAt(i16));
                    }
                }
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}

package com.tencent.mobileqq.guild.schedule.create.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes14.dex */
public class GuildScheduleIphonePickerView extends LinearLayout {
    private TextView C;
    private TextView D;
    private WheelView[] E;
    private f[] F;
    private g G;
    private h H;
    private AdapterView.OnItemSelectedListener I;
    private VerticalGallery.OnSelectViewDataUpdateListener J;

    /* renamed from: d, reason: collision with root package name */
    public final int f233104d;

    /* renamed from: e, reason: collision with root package name */
    public final int f233105e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f233106f;

    /* renamed from: h, reason: collision with root package name */
    private final int f233107h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f233108i;

    /* renamed from: m, reason: collision with root package name */
    private int f233109m;

    /* loaded from: classes14.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildScheduleIphonePickerView.this.G != null) {
                GuildScheduleIphonePickerView.this.G.onCancelBtClicked();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes14.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildScheduleIphonePickerView.this.G != null) {
                GuildScheduleIphonePickerView.this.G.onConfirmBtClicked();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes14.dex */
    class d implements VerticalGallery.OnSelectViewDataUpdateListener {
        d() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            GuildScheduleIphonePickerView.this.h(view, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class e implements VerticalGallery.OnEndMovementListener {

        /* renamed from: d, reason: collision with root package name */
        private int f233114d;

        public e(int i3) {
            this.f233114d = i3;
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            int selectedItemPosition = GuildScheduleIphonePickerView.this.E[this.f233114d].getSelectedItemPosition();
            if (GuildScheduleIphonePickerView.this.G != null) {
                GuildScheduleIphonePickerView.this.G.onItemSelected(this.f233114d, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class f extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private int f233116d;

        /* renamed from: e, reason: collision with root package name */
        private int f233117e;

        public f(int i3, int i16) {
            this.f233116d = 56;
            this.f233117e = i3;
            this.f233116d = (int) TypedValue.applyDimension(1, i16, GuildScheduleIphonePickerView.this.getResources().getDisplayMetrics());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GuildScheduleIphonePickerView.this.H.getRowCount(this.f233117e);
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
            if (view == null) {
                view = new WheelTextView(GuildScheduleIphonePickerView.this.getContext());
                view.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f233116d));
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            String text = GuildScheduleIphonePickerView.this.H.getText(this.f233117e, i3);
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setTextSize(17.0f);
            wheelTextView.setTextColor(GuildScheduleIphonePickerView.this.f233106f);
            wheelTextView.setGravity(17);
            wheelTextView.setText(text);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes14.dex */
    public interface g {
        void onCancelBtClicked();

        void onConfirmBtClicked();

        void onItemSelected(int i3, int i16);
    }

    /* loaded from: classes14.dex */
    public interface h {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    public GuildScheduleIphonePickerView(Context context) {
        super(context);
        this.f233104d = 56;
        this.f233105e = 17;
        this.f233107h = 17;
        this.f233109m = 0;
        this.I = new c();
        this.J = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(17.0f);
                wheelTextView.setTextColor(this.f233106f);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(17.0f);
                wheelTextView2.setTextColor(this.f233108i);
            }
        }
    }

    private void i(WheelView wheelView, int i3) {
        wheelView.setmMaxSkew(0.0f);
        wheelView.setmMaxRotationAngle(0);
        wheelView.setNeedTranslate(false);
        wheelView.setTag(Integer.valueOf(i3));
        f fVar = new f(i3, 56);
        this.E[i3] = wheelView;
        this.F[i3] = fVar;
        wheelView.setAdapter((SpinnerAdapter) fVar);
        wheelView.setOnItemSelectedListener(this.I);
        wheelView.setOnSelectViewDataUpdateListener(this.J);
        wheelView.setOnEndMovementListener(new e(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, boolean z16) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public void f(h hVar) {
        ColorStateList colorStateList = ResourcesCompat.getColorStateList(getContext().getResources(), R.color.guild_skin_content_text, getContext().getTheme());
        this.f233108i = colorStateList;
        this.f233106f = colorStateList;
        this.H = hVar;
        int columnCount = hVar.getColumnCount();
        this.f233109m = columnCount;
        if (columnCount > 0 && columnCount <= 3) {
            this.E = new WheelView[columnCount];
            this.F = new f[columnCount];
            WheelView wheelView = (WheelView) findViewById(R.id.bdy);
            WheelView wheelView2 = (WheelView) findViewById(R.id.d9j);
            WheelView wheelView3 = (WheelView) findViewById(R.id.f166292ey2);
            TextView textView = (TextView) findViewById(R.id.maf);
            this.C = textView;
            textView.setOnClickListener(new a());
            TextView textView2 = (TextView) findViewById(R.id.jlr);
            this.D = textView2;
            if (textView2 != null) {
                textView2.setOnClickListener(new b());
            }
            i(wheelView, 0);
            if (this.f233109m < 2) {
                wheelView2.setVisibility(8);
            } else {
                wheelView2.setVisibility(0);
                i(wheelView2, 1);
            }
            if (this.f233109m < 3) {
                wheelView3.setVisibility(8);
                return;
            } else {
                wheelView3.setVisibility(0);
                i(wheelView3, 2);
                return;
            }
        }
        throw new RuntimeException("Unsupportted column count " + this.f233109m);
    }

    public void g(int i3) {
        if (i3 >= 0) {
            f[] fVarArr = this.F;
            if (i3 < fVarArr.length) {
                fVarArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(g gVar) {
        this.G = gVar;
    }

    public void setSelection(int i3, int i16) {
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.E;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public GuildScheduleIphonePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f233104d = 56;
        this.f233105e = 17;
        this.f233107h = 17;
        this.f233109m = 0;
        this.I = new c();
        this.J = new d();
    }

    /* loaded from: classes14.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            GuildScheduleIphonePickerView.this.h(view, 1);
            GuildScheduleIphonePickerView.this.j(view, true);
            if (view != null && view.getTag() != null) {
                int parseInt = Integer.parseInt(view.getTag().toString());
                int childCount = adapterView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (parseInt != i16) {
                        GuildScheduleIphonePickerView.this.h(adapterView.getChildAt(i16), 0);
                        GuildScheduleIphonePickerView.this.j(adapterView.getChildAt(i16), false);
                    }
                }
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}

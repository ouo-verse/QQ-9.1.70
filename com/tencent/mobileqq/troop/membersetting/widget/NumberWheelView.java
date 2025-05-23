package com.tencent.mobileqq.troop.membersetting.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class NumberWheelView extends WheelView implements VerticalGallery.OnEndFlingListener, VerticalGallery.OnEndMovementListener, AdapterView.OnItemSelectedListener, VerticalGallery.OnSelectViewDataUpdateListener {

    /* renamed from: d, reason: collision with root package name */
    public int f297962d;

    /* renamed from: e, reason: collision with root package name */
    private b f297963e;

    /* renamed from: f, reason: collision with root package name */
    private Context f297964f;

    /* renamed from: h, reason: collision with root package name */
    private a f297965h;

    /* renamed from: i, reason: collision with root package name */
    private int f297966i;

    /* renamed from: m, reason: collision with root package name */
    private int f297967m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final Context f297968d;

        /* renamed from: e, reason: collision with root package name */
        private final int f297969e;

        /* renamed from: f, reason: collision with root package name */
        public List<Integer> f297970f;

        public a(Context context, int i3, int i16, int i17) {
            this.f297968d = context;
            this.f297969e = (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
            b(i16, i17);
        }

        public void b(int i3, int i16) {
            this.f297970f = new ArrayList();
            while (i3 <= i16) {
                this.f297970f.add(Integer.valueOf(i3));
                i3++;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f297970f.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View getItem(int i3) {
            return getView(i3, null, null);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            WheelTextView wheelTextView;
            if (view == null) {
                wheelTextView = new WheelTextView(this.f297968d);
                wheelTextView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f297969e));
                view2 = wheelTextView;
            } else {
                view2 = view;
                wheelTextView = null;
            }
            if (wheelTextView == null) {
                wheelTextView = (WheelTextView) view2;
            }
            String format = String.format("%d", this.f297970f.get(i3));
            wheelTextView.setTextSize(20.0f);
            wheelTextView.setTextColor(-7829368);
            wheelTextView.setGravity(5);
            wheelTextView.setVisibility(0);
            wheelTextView.setText(format);
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface b {
        void a(VerticalGallery verticalGallery);
    }

    public NumberWheelView(Context context) {
        super(context);
        initialize(context);
    }

    private void E(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(-7829368);
            } else if (i3 == 1) {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(23.0f);
                wheelTextView2.setTextColor(-16777216);
            }
        }
    }

    private void initialize(Context context) {
        this.f297964f = context;
        this.f297962d = 1;
        this.f297966i = 0;
        this.f297967m = 0;
        setNeedTranslate(true);
        setScrollCycle(true);
        setOnEndFlingListener(this);
        setOnEndMovementListener(this);
        setOnItemSelectedListener(this);
        setOnSelectViewDataUpdateListener(this);
    }

    public int D() {
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= this.f297965h.f297970f.size()) {
            return 0;
        }
        return this.f297965h.f297970f.get(selectedItemPosition).intValue();
    }

    @Override // com.tencent.widget.VerticalGallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        boolean onFling = super.onFling(motionEvent, motionEvent2, f16, f17);
        if (onFling) {
            this.f297962d = 0;
        }
        return onFling;
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        int count = this.f297965h.getCount();
        for (int i16 = 0; i16 < count; i16++) {
            E(adapterView.getChildAt(i16), 0);
        }
        E(view, 1);
    }

    @Override // com.tencent.widget.VerticalGallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f16, f17);
        if (onScroll) {
            this.f297962d = 0;
        }
        return onScroll;
    }

    public void setScrollStateListener(b bVar) {
        this.f297963e = bVar;
    }

    public void setValue(int i3) {
        int i16 = this.f297966i;
        if (i3 < i16 || i3 > this.f297967m) {
            return;
        }
        setSelection(i3 - i16);
    }

    @Override // com.tencent.widget.VerticalGallery.OnEndFlingListener
    public void onEndFling(VerticalGallery verticalGallery) {
        this.f297962d = 1;
        b bVar = this.f297963e;
        if (bVar != null) {
            bVar.a(verticalGallery);
        }
    }

    @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
    public void onEndMovement(VerticalGallery verticalGallery) {
        this.f297962d = 1;
        b bVar = this.f297963e;
        if (bVar != null) {
            bVar.a(verticalGallery);
        }
    }

    @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
    public void onSelectDataUpdate(View view, int i3) {
        E(view, 1);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public void setRange(int i3, int i16) {
        if (i3 > i16) {
            this.f297966i = i16;
            this.f297967m = i3;
        } else {
            this.f297967m = i16;
            this.f297966i = i3;
        }
        a aVar = this.f297965h;
        if (aVar == null) {
            a aVar2 = new a(this.f297964f, 30, this.f297966i, this.f297967m);
            this.f297965h = aVar2;
            setAdapter((SpinnerAdapter) aVar2);
            return;
        }
        aVar.b(i3, i16);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initialize(context);
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NumberWheelView extends WheelView implements VerticalGallery.OnEndFlingListener, VerticalGallery.OnEndMovementListener, AdapterView.OnItemSelectedListener, VerticalGallery.OnSelectViewDataUpdateListener {
    static IPatchRedirector $redirector_;
    private final int C;
    private final int D;
    private final int E;
    private b F;
    private Context G;
    private a H;
    private int I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    public int f196599d;

    /* renamed from: e, reason: collision with root package name */
    private final int f196600e;

    /* renamed from: f, reason: collision with root package name */
    private final int f196601f;

    /* renamed from: h, reason: collision with root package name */
    private final int f196602h;

    /* renamed from: i, reason: collision with root package name */
    private final int f196603i;

    /* renamed from: m, reason: collision with root package name */
    private final int f196604m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Context f196605d;

        /* renamed from: e, reason: collision with root package name */
        private int f196606e;

        /* renamed from: f, reason: collision with root package name */
        public List<Integer> f196607f;

        public a(Context context, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NumberWheelView.this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f196606e = 36;
            this.f196605d = context;
            this.f196606e = (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
            b(i16, i17);
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return getView(i3, null, null);
        }

        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f196607f = new ArrayList();
            while (i3 <= i16) {
                this.f196607f.add(Integer.valueOf(i3));
                i3++;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f196607f.size();
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
            WheelTextView wheelTextView;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    wheelTextView = new WheelTextView(this.f196605d);
                    wheelTextView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.f196606e));
                    view2 = wheelTextView;
                } else {
                    view2 = view;
                    wheelTextView = null;
                }
                if (wheelTextView == null) {
                    wheelTextView = (WheelTextView) view2;
                }
                String format = String.format("%d", this.f196607f.get(i3));
                wheelTextView.setTextSize(18.0f);
                wheelTextView.setTextColor(-7829368);
                wheelTextView.setGravity(5);
                wheelTextView.setVisibility(0);
                wheelTextView.setText(format);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void i(NumberWheelView numberWheelView, VerticalGallery verticalGallery);
    }

    public NumberWheelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f196600e = 0;
        this.f196601f = 36;
        this.f196602h = 18;
        this.f196603i = -7829368;
        this.f196604m = 5;
        this.C = 1;
        this.D = 19;
        this.E = -16777216;
        initialize(context);
    }

    private void E(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(18.0f);
                wheelTextView.setTextColor(-7829368);
            } else if (i3 == 1) {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(19.0f);
                wheelTextView2.setTextColor(-16777216);
            }
        }
    }

    private void initialize(Context context) {
        this.G = context;
        this.f196599d = 1;
        this.I = 0;
        this.J = 0;
        setNeedTranslate(true);
        setScrollCycle(true);
        setOnEndFlingListener(this);
        setOnEndMovementListener(this);
        setOnItemSelectedListener(this);
        setOnSelectViewDataUpdateListener(this);
    }

    public int D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0 && selectedItemPosition < this.H.f196607f.size()) {
            return this.H.f196607f.get(selectedItemPosition).intValue();
        }
        return 0;
    }

    @Override // com.tencent.widget.VerticalGallery.OnEndFlingListener
    public void onEndFling(VerticalGallery verticalGallery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) verticalGallery);
            return;
        }
        this.f196599d = 1;
        b bVar = this.F;
        if (bVar != null) {
            bVar.i(this, verticalGallery);
        }
    }

    @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
    public void onEndMovement(VerticalGallery verticalGallery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) verticalGallery);
            return;
        }
        this.f196599d = 1;
        b bVar = this.F;
        if (bVar != null) {
            bVar.i(this, verticalGallery);
        }
    }

    @Override // com.tencent.widget.VerticalGallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        boolean onFling = super.onFling(motionEvent, motionEvent2, f16, f17);
        if (onFling) {
            this.f196599d = 0;
        }
        return onFling;
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        int count = this.H.getCount();
        for (int i16 = 0; i16 < count; i16++) {
            E(adapterView.getChildAt(i16), 0);
        }
        E(view, 1);
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) adapterView);
        }
    }

    @Override // com.tencent.widget.VerticalGallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f16, f17);
        if (onScroll) {
            this.f196599d = 0;
        }
        return onScroll;
    }

    @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
    public void onSelectDataUpdate(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, i3);
        } else {
            E(view, 1);
        }
    }

    public void setRange(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 > i16) {
            this.I = i16;
            this.J = i3;
        } else {
            this.J = i16;
            this.I = i3;
        }
        a aVar = this.H;
        if (aVar == null) {
            a aVar2 = new a(this.G, 36, this.I, this.J);
            this.H = aVar2;
            setAdapter((SpinnerAdapter) aVar2);
            return;
        }
        aVar.b(i3, i16);
    }

    public void setScrollStateListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            this.F = bVar;
        }
    }

    public void setValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int i16 = this.I;
        if (i3 >= i16 && i3 <= this.J) {
            setSelection(i3 - i16);
        }
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f196600e = 0;
        this.f196601f = 36;
        this.f196602h = 18;
        this.f196603i = -7829368;
        this.f196604m = 5;
        this.C = 1;
        this.D = 19;
        this.E = -16777216;
        initialize(context);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f196600e = 0;
        this.f196601f = 36;
        this.f196602h = 18;
        this.f196603i = -7829368;
        this.f196604m = 5;
        this.C = 1;
        this.D = 19;
        this.E = -16777216;
        initialize(context);
    }
}

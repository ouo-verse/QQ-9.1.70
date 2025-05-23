package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes5.dex */
public class IphonePickerView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_GRAVITY = 17;
    public static final int DEFAULT_ITEM_HEIGHT = 25;
    public static int DEFAULT_TEXTCOLOR = 0;
    public static final int DEFAULT_TEXTSIZE = 20;
    public static final float MAXALPHA = 0.8f;
    public static final int MAXROTATION = 80;
    public static final float MAXSKEW = -0.1f;
    public static final float MAXTRANSLATE_OFFSET = -25.0f;
    public static final int MAXZOOM = -80;
    private static final int MODE_DEFAULT = 0;
    private static final int MODE_SELECTED = 1;
    private static int SELECT_TEXTCOLOR = 0;
    private static final int SELECT_TEXTSIZE = 20;
    private static final String TAG = "IphonePickerView";
    private int columnCount;
    private PickerViewAdapter mAdapter;
    private Button mConfirmBt;
    private VerticalGallery.OnSelectViewDataUpdateListener mDataUpdateListener;
    private InnerAdapter[] mInnerAdapters;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private IphonePickListener mListener;
    private TextView mTipsTv;
    private WheelView[] mWheelViews;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class EndMovementListener implements VerticalGallery.OnEndMovementListener {
        static IPatchRedirector $redirector_;
        private int column;

        public EndMovementListener(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IphonePickerView.this, i3);
            } else {
                this.column = i3;
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) verticalGallery);
                return;
            }
            int selectedItemPosition = IphonePickerView.this.mWheelViews[this.column].getSelectedItemPosition();
            if (IphonePickerView.this.mListener != null) {
                IphonePickerView.this.mListener.onItemSelected(this.column, selectedItemPosition);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface IphonePickListener {
        void onConfirmBtClicked();

        void onItemSelected(int i3, int i16);
    }

    /* loaded from: classes5.dex */
    public interface PickerViewAdapter {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IphonePickerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (IphonePickerView.this.mListener != null) {
                IphonePickerView.this.mListener.onConfirmBtClicked();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes5.dex */
    class b implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IphonePickerView.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IphonePickerView.this.setTextStyle(view, 1);
                IphonePickerView.this.updateWheelTextViewDesc(view, true);
                if (view != null && view.getTag() != null) {
                    int parseInt = Integer.parseInt(view.getTag().toString());
                    int childCount = adapterView.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        if (parseInt != i16) {
                            IphonePickerView.this.setTextStyle(adapterView.getChildAt(i16), 0);
                            IphonePickerView.this.updateWheelTextViewDesc(adapterView.getChildAt(i16), false);
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

    /* loaded from: classes5.dex */
    class c implements VerticalGallery.OnSelectViewDataUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IphonePickerView.this);
            }
        }

        @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
        public void onSelectDataUpdate(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IphonePickerView.this.setTextStyle(view, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            DEFAULT_TEXTCOLOR = -7829368;
            SELECT_TEXTCOLOR = -12303292;
        }
    }

    public IphonePickerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.columnCount = 0;
        this.mItemSelectedListener = new b();
        this.mDataUpdateListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextStyle(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(DEFAULT_TEXTCOLOR);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(20.0f);
                wheelTextView2.setTextColor(SELECT_TEXTCOLOR);
            }
        }
    }

    private void setupWheelView(WheelView wheelView, int i3) {
        wheelView.setTag(Integer.valueOf(i3));
        InnerAdapter innerAdapter = new InnerAdapter(i3, 25);
        this.mWheelViews[i3] = wheelView;
        this.mInnerAdapters[i3] = innerAdapter;
        wheelView.setAdapter((SpinnerAdapter) innerAdapter);
        wheelView.setOnItemSelectedListener(this.mItemSelectedListener);
        wheelView.setOnSelectViewDataUpdateListener(this.mDataUpdateListener);
        wheelView.setOnEndMovementListener(new EndMovementListener(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWheelTextViewDesc(View view, boolean z16) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int getSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.mWheelViews;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public View getViewByColumn(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.mWheelViews;
            if (i3 < wheelViewArr.length) {
                return wheelViewArr[i3];
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void hideTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            findViewById(R.id.mao).setVisibility(8);
        }
    }

    public void initialize(PickerViewAdapter pickerViewAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pickerViewAdapter);
            return;
        }
        Resources resources = getContext().getResources();
        DEFAULT_TEXTCOLOR = resources.getColor(R.color.skin_gray6);
        SELECT_TEXTCOLOR = resources.getColor(R.color.skin_color_dark_gray);
        setBackgroundColor(resources.getColor(R.color.skin_color_light_gray));
        View findViewById = findViewById(R.id.jls);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.f157965ag0));
        }
        View findViewById2 = findViewById(R.id.jlt);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(resources.getColor(R.color.f157965ag0));
        }
        View findViewById3 = findViewById(R.id.e_x);
        if (findViewById3 != null) {
            findViewById3.setBackgroundColor(resources.getColor(R.color.afz));
        }
        View findViewById4 = findViewById(R.id.e_b);
        if (findViewById4 != null) {
            findViewById4.setBackgroundColor(resources.getColor(R.color.afz));
        }
        this.mAdapter = pickerViewAdapter;
        int columnCount = pickerViewAdapter.getColumnCount();
        this.columnCount = columnCount;
        if (columnCount > 0 && columnCount <= 3) {
            this.mWheelViews = new WheelView[columnCount];
            this.mInnerAdapters = new InnerAdapter[columnCount];
            WheelView wheelView = (WheelView) findViewById(R.id.bdy);
            WheelView wheelView2 = (WheelView) findViewById(R.id.d9j);
            WheelView wheelView3 = (WheelView) findViewById(R.id.f166292ey2);
            this.mConfirmBt = (Button) findViewById(R.id.jlr);
            this.mTipsTv = (TextView) findViewById(R.id.jmn);
            Button button = this.mConfirmBt;
            if (button != null) {
                button.setOnClickListener(new a());
            }
            setupWheelView(wheelView, 0);
            if (this.columnCount < 2) {
                wheelView2.setVisibility(8);
            } else {
                wheelView2.setVisibility(0);
                setupWheelView(wheelView2, 1);
            }
            if (this.columnCount < 3) {
                wheelView3.setVisibility(8);
                return;
            } else {
                wheelView3.setVisibility(0);
                setupWheelView(wheelView3, 2);
                return;
            }
        }
        throw new RuntimeException("Unsupportted column count " + this.columnCount);
    }

    public void notifyDataSetChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 >= 0) {
            InnerAdapter[] innerAdapterArr = this.mInnerAdapters;
            if (i3 < innerAdapterArr.length) {
                innerAdapterArr[i3].notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setPickListener(IphonePickListener iphonePickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iphonePickListener);
        } else {
            this.mListener = iphonePickListener;
        }
    }

    public void setSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0) {
            WheelView[] wheelViewArr = this.mWheelViews;
            if (i3 < wheelViewArr.length) {
                wheelViewArr[i3].setSelection(i16, true);
                return;
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void setTips(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mTipsTv.setText(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class InnerAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;
        private int mColumn;
        private int mHeight;

        public InnerAdapter(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IphonePickerView.this, i3);
            } else {
                this.mHeight = 25;
                this.mColumn = i3;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return IphonePickerView.this.mAdapter.getRowCount(this.mColumn);
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
                    view = new WheelTextView(IphonePickerView.this.getContext());
                    view.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.mHeight));
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                }
                String text = IphonePickerView.this.mAdapter.getText(this.mColumn, i3);
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(20.0f);
                wheelTextView.setTextColor(IphonePickerView.DEFAULT_TEXTCOLOR);
                wheelTextView.setGravity(17);
                wheelTextView.setText(text);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public InnerAdapter(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, IphonePickerView.this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.mHeight = 25;
            this.mColumn = i3;
            this.mHeight = (int) TypedValue.applyDimension(1, i16, IphonePickerView.this.getResources().getDisplayMetrics());
        }
    }

    public IphonePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.columnCount = 0;
        this.mItemSelectedListener = new b();
        this.mDataUpdateListener = new c();
    }
}

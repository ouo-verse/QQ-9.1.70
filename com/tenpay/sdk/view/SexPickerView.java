package com.tenpay.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes27.dex */
public class SexPickerView extends LinearLayout {
    public static final int DEFAULT_ITEM_HEIGHT = 35;
    public static int DEFAULT_TEXT_COLOR = 1711276032;
    public static final int DEFAULT_TEXT_SIZE = 17;
    private static final int MODE_DEFAULT = 0;
    private static final int MODE_SELECTED = 1;
    private static final int SELECT_TEXT_SIZE = 17;
    private SexPickerViewAdapter mAdapter;
    private SexPickListener mListener;
    private WheelView mWheelView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class EndMovementListener implements VerticalGallery.OnEndMovementListener {
        public EndMovementListener() {
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(VerticalGallery verticalGallery) {
            int selectedItemPosition = SexPickerView.this.mWheelView.getSelectedItemPosition();
            if (SexPickerView.this.mListener != null) {
                SexPickerView.this.mListener.onItemSelected(selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public class InnerAdapter extends BaseAdapter {
        private final int heightInDp;

        public InnerAdapter(int i3) {
            this.heightInDp = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SexPickerView.this.mAdapter.getRowCount();
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
                view = new WheelTextView(SexPickerView.this.getContext());
                view.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(this.heightInDp)));
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
            String text = SexPickerView.this.mAdapter.getText(i3);
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setTextSize(17.0f);
            wheelTextView.setTextColor(SexPickerView.DEFAULT_TEXT_COLOR);
            wheelTextView.setGravity(17);
            wheelTextView.setText(text);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* loaded from: classes27.dex */
    public interface SexPickListener {
        void onCancelBtClicked();

        void onConfirmBtClicked();

        void onItemSelected(int i3);
    }

    /* loaded from: classes27.dex */
    public interface SexPickerViewAdapter {
        int getRowCount();

        String getText(int i3);
    }

    public SexPickerView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SexPickListener sexPickListener = this.mListener;
        if (sexPickListener != null) {
            sexPickListener.onConfirmBtClicked();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SexPickListener sexPickListener = this.mListener;
        if (sexPickListener != null) {
            sexPickListener.onCancelBtClicked();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupWheelView$2(View view, int i3) {
        setTextStyle(view, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextStyle(View view, int i3) {
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(17.0f);
                wheelTextView.setTextColor(DEFAULT_TEXT_COLOR);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(17.0f);
                wheelTextView2.setTextColor(-16777216);
            }
        }
    }

    private void setupWheelView(WheelView wheelView) {
        wheelView.setAdapter((SpinnerAdapter) new InnerAdapter(35));
        wheelView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.tenpay.sdk.view.SexPickerView.1
            @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
                SexPickerView.this.setTextStyle(view, 1);
                for (int i16 = 0; i16 < adapterView.getChildCount(); i16++) {
                    if (i3 != i16) {
                        SexPickerView.this.setTextStyle(adapterView.getChildAt(i16), 0);
                    }
                }
            }

            @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        wheelView.setOnSelectViewDataUpdateListener(new VerticalGallery.OnSelectViewDataUpdateListener() { // from class: com.tenpay.sdk.view.c
            @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
            public final void onSelectDataUpdate(View view, int i3) {
                SexPickerView.this.lambda$setupWheelView$2(view, i3);
            }
        });
        wheelView.setOnEndMovementListener(new EndMovementListener());
    }

    public int getSelection() {
        return this.mWheelView.getSelectedItemPosition();
    }

    public void hideTitle() {
        findViewById(R.id.mao).setVisibility(8);
    }

    public void initialize(SexPickerViewAdapter sexPickerViewAdapter) {
        this.mAdapter = sexPickerViewAdapter;
        this.mWheelView = (WheelView) findViewById(R.id.f122287dj);
        ((TextView) findViewById(R.id.b7m)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SexPickerView.this.lambda$initialize$0(view);
            }
        });
        ((TextView) findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SexPickerView.this.lambda$initialize$1(view);
            }
        });
        setupWheelView(this.mWheelView);
    }

    public void setPickListener(SexPickListener sexPickListener) {
        this.mListener = sexPickListener;
    }

    public void setSelection(int i3) {
        this.mWheelView.setSelection(i3, true);
    }

    public SexPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

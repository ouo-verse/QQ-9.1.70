package com.tencent.mobileqq.profilecard.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class ProfileEditPickerView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final int LINE_HEIGHT_DP = 30;
    private static final int MODE_DEFAULT = 0;
    private static final int MODE_SELECTED = 1;
    private static final int SELECT_TEXT_SIZE = 17;
    private final HashMap<Integer, Integer> initValueMap;
    private boolean isHide;
    private PickerViewAdapter mAdapter;
    private Context mContext;
    private VerticalGallery.OnSelectViewDataUpdateListener mDataUpdateListener;
    private InnerAdapter[] mInnerAdapters;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private ProfileEditPickListener mListener;
    private ProfileEditVerticalGallery[] mWheelViews;
    private boolean useCustomLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class EndMovementListener implements VerticalGallery.OnEndMovementListener {
        static IPatchRedirector $redirector_;
        private int column;

        public EndMovementListener(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditPickerView.this, i3);
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
            int selectedItemPosition = ProfileEditPickerView.this.mWheelViews[this.column].getSelectedItemPosition();
            if (ProfileEditPickerView.this.mListener != null) {
                ProfileEditPickerView.this.mListener.onItemSelected(this.column, selectedItemPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class InnerAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;
        private int mColumn;

        public InnerAdapter(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditPickerView.this, i3);
            } else {
                this.mColumn = i3;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return ProfileEditPickerView.this.mAdapter.getRowCount(this.mColumn);
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
                    view = new WheelTextView(ProfileEditPickerView.this.getContext());
                    view.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(30.0f)));
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                }
                String text = ProfileEditPickerView.this.mAdapter.getText(this.mColumn, i3);
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(2, 16.0f);
                wheelTextView.setGravity(17);
                wheelTextView.setSingleLine();
                wheelTextView.setMinEms(3);
                wheelTextView.setText(text);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes16.dex */
    public interface PickerViewAdapter {
        int getColumnCount();

        int getRowCount(int i3);

        String getText(int i3, int i16);
    }

    /* loaded from: classes16.dex */
    public interface ProfileEditPickListener {
        void onItemSelected(int i3, int i16);
    }

    public ProfileEditPickerView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private View getAddView(int i3) {
        if (i3 == 1) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.dq_, (ViewGroup) null);
        }
        if (i3 == 2) {
            if (this.useCustomLayout) {
                return LayoutInflater.from(this.mContext).inflate(R.layout.dqb, (ViewGroup) null);
            }
            return LayoutInflater.from(this.mContext).inflate(R.layout.dqa, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mContext).inflate(R.layout.dqc, (ViewGroup) null);
    }

    private void initWheelView(ProfileEditVerticalGallery profileEditVerticalGallery, int i3) {
        profileEditVerticalGallery.setTag(Integer.valueOf(i3));
        InnerAdapter innerAdapter = new InnerAdapter(i3);
        this.mWheelViews[i3] = profileEditVerticalGallery;
        this.mInnerAdapters[i3] = innerAdapter;
        profileEditVerticalGallery.setAdapter((SpinnerAdapter) innerAdapter);
        profileEditVerticalGallery.setOnItemSelectedListener(this.mItemSelectedListener);
        profileEditVerticalGallery.setOnSelectViewDataUpdateListener(this.mDataUpdateListener);
        profileEditVerticalGallery.setOnEndMovementListener(new EndMovementListener(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    public void setTextStyle(View view, int i3) {
        int defaultColor = getResources().getColorStateList(R.color.qui_common_text_secondary).getDefaultColor();
        int defaultColor2 = getResources().getColorStateList(R.color.qui_common_text_primary).getDefaultColor();
        if (view instanceof WheelTextView) {
            if (i3 == 0) {
                WheelTextView wheelTextView = (WheelTextView) view;
                wheelTextView.setTextSize(16.0f);
                wheelTextView.setTextColor(defaultColor);
            } else {
                WheelTextView wheelTextView2 = (WheelTextView) view;
                wheelTextView2.setTextSize(17.0f);
                if (!this.isHide) {
                    defaultColor = defaultColor2;
                }
                wheelTextView2.setTextColor(defaultColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWheelTextViewDesc(View view) {
        if (view instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) view;
            wheelTextView.setContentDescription(new StringBuilder(wheelTextView.getText()));
        }
    }

    public int getSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        if (i3 >= 0) {
            ProfileEditVerticalGallery[] profileEditVerticalGalleryArr = this.mWheelViews;
            if (i3 < profileEditVerticalGalleryArr.length) {
                return profileEditVerticalGalleryArr[i3].getSelectedItemPosition();
            }
        }
        throw new IllegalArgumentException("Error column index " + i3);
    }

    public void initialize(PickerViewAdapter pickerViewAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pickerViewAdapter);
            return;
        }
        this.mAdapter = pickerViewAdapter;
        int columnCount = pickerViewAdapter.getColumnCount();
        if (columnCount > 0 && columnCount <= 3) {
            this.mWheelViews = new ProfileEditVerticalGallery[columnCount];
            this.mInnerAdapters = new InnerAdapter[columnCount];
            removeAllViewsInLayout();
            View addView = getAddView(columnCount);
            addView(addView, new LinearLayout.LayoutParams(-1, -1));
            int[] iArr = {R.id.f122297dk, R.id.f122307dl, R.id.f122317dm};
            for (int i3 = 0; i3 < columnCount; i3++) {
                initWheelView((ProfileEditVerticalGallery) addView.findViewById(iArr[i3]), i3);
            }
            invalidate();
            return;
        }
        throw new RuntimeException("Unsupported columnCount count " + columnCount);
    }

    public void notifyDataSetChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
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

    public void onPrivacyChange(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isHide = z16;
        for (ProfileEditVerticalGallery profileEditVerticalGallery : this.mWheelViews) {
            profileEditVerticalGallery.setDisableScroll(this.isHide);
        }
        if (!this.isHide) {
            return;
        }
        Iterator<Integer> it = this.initValueMap.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            setSelection(intValue, this.initValueMap.get(Integer.valueOf(intValue)).intValue());
        }
    }

    public void setHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isHide = z16;
        }
    }

    public void setPickListener(ProfileEditPickListener profileEditPickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) profileEditPickListener);
        } else {
            this.mListener = profileEditPickListener;
        }
    }

    public void setSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 >= 0 && i3 < this.mWheelViews.length) {
            if (!this.initValueMap.containsKey(Integer.valueOf(i3))) {
                this.initValueMap.put(Integer.valueOf(i3), Integer.valueOf(i16));
            }
            this.mWheelViews[i3].setSelection(i16, true);
        } else {
            throw new IllegalArgumentException("Error column index " + i3);
        }
    }

    public void useCustomLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.useCustomLayout = true;
        }
    }

    public ProfileEditPickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ProfileEditPickerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.isHide = false;
        this.initValueMap = new HashMap<>();
        this.useCustomLayout = false;
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditPickerView.this);
                }
            }

            @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i16, long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileEditPickerView.this.setTextStyle(view, 1);
                    ProfileEditPickerView.this.updateWheelTextViewDesc(view);
                    if (view != null && view.getTag() != null) {
                        int parseInt = Integer.parseInt(view.getTag().toString());
                        int childCount = adapterView.getChildCount();
                        for (int i17 = 0; i17 < childCount; i17++) {
                            if (parseInt != i17) {
                                ProfileEditPickerView.this.setTextStyle(adapterView.getChildAt(i17), 0);
                                ProfileEditPickerView.this.updateWheelTextViewDesc(adapterView.getChildAt(i17));
                            }
                        }
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, adapterView, view, Integer.valueOf(i16), Long.valueOf(j3));
            }

            @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) adapterView);
                }
            }
        };
        this.mDataUpdateListener = new VerticalGallery.OnSelectViewDataUpdateListener() { // from class: com.tencent.mobileqq.profilecard.widget.ProfileEditPickerView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditPickerView.this);
                }
            }

            @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
            public void onSelectDataUpdate(View view, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileEditPickerView.this.setTextStyle(view, 1);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, i16);
                }
            }
        };
        this.mContext = context;
        setOrientation(1);
    }
}

package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes23.dex */
public class MutiPickerView extends ReportDialog implements View.OnClickListener, DialogInterface.OnCancelListener {
    private TextView mCancelTextView;
    private TextView mConfirmTextView;
    private LinearLayout mMutiPickerContainer;
    private ArrayList<NumberPicker> mNumberPicker;
    private OnConfirmListener mOnConfirmListener;
    private int[] mResult;
    private String[][] mValues;

    /* loaded from: classes23.dex */
    private class MutiOnValueChangeListener implements NumberPicker.OnValueChangeListener {
        private int index;

        public MutiOnValueChangeListener(int i3) {
            this.index = i3;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i3, int i16) {
            if (MutiPickerView.this.mResult != null && MutiPickerView.this.mResult.length > this.index) {
                MutiPickerView.this.mResult[this.index] = i16;
                MutiPickerView.this.mOnConfirmListener.onValChange(this.index, i16);
            }
        }
    }

    /* loaded from: classes23.dex */
    public interface OnConfirmListener {
        void onValCancel();

        void onValChange(int i3, int i16);

        void onValConfirm(int[] iArr);
    }

    public MutiPickerView(@NonNull Context context) {
        super(context, R.style.Theme_Light_NoTitle_Dialog);
        this.mNumberPicker = new ArrayList<>();
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_muti_dialog_picker, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
        }
        this.mMutiPickerContainer = (LinearLayout) inflate.findViewById(R.id.muti_picker_container);
        TextView textView = (TextView) inflate.findViewById(R.id.muti_tv_cancel);
        this.mCancelTextView = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.muti_tv_confirm);
        this.mConfirmTextView = textView2;
        textView2.setOnClickListener(this);
        setOnCancelListener(this);
    }

    private void setNumpickerDiverColor(NumberPicker numberPicker) {
        for (Field field : NumberPicker.class.getDeclaredFields()) {
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
                    return;
                } catch (Resources.NotFoundException e16) {
                    e16.printStackTrace();
                    return;
                } catch (IllegalAccessException e17) {
                    e17.printStackTrace();
                    return;
                } catch (IllegalArgumentException e18) {
                    e18.printStackTrace();
                    return;
                }
            }
        }
    }

    public void dismissDlg() {
        try {
            if (isShowing()) {
                dismiss();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnConfirmListener onConfirmListener = this.mOnConfirmListener;
        if (onConfirmListener != null) {
            onConfirmListener.onValCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.muti_tv_cancel) {
            OnConfirmListener onConfirmListener = this.mOnConfirmListener;
            if (onConfirmListener != null) {
                onConfirmListener.onValCancel();
            }
            dismissDlg();
        } else if (view.getId() == R.id.muti_tv_confirm) {
            OnConfirmListener onConfirmListener2 = this.mOnConfirmListener;
            if (onConfirmListener2 != null) {
                onConfirmListener2.onValConfirm(this.mResult);
            }
            dismissDlg();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCurrentIndex(int[] iArr) {
        ArrayList<NumberPicker> arrayList = this.mNumberPicker;
        if (arrayList != null && arrayList.size() != 0 && iArr != null && iArr.length == this.mNumberPicker.size()) {
            this.mResult = iArr;
            for (int i3 = 0; i3 < this.mNumberPicker.size(); i3++) {
                this.mNumberPicker.get(i3).setValue(iArr[i3]);
            }
        }
    }

    public void setDisplayedValues(int i3, int i16, String[] strArr) {
        ArrayList<NumberPicker> arrayList;
        if (strArr == null || strArr.length == 0 || (arrayList = this.mNumberPicker) == null || i3 >= arrayList.size()) {
            return;
        }
        NumberPicker numberPicker = this.mNumberPicker.get(i3);
        numberPicker.setDisplayedValues(null);
        numberPicker.setMaxValue(strArr.length - 1);
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setValue(i16);
        int[] iArr = this.mResult;
        if (i3 >= iArr.length || i3 < 0) {
            return;
        }
        iArr[i3] = i16;
    }

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
    }

    public void setDisplayedValues(String[][] strArr) {
        this.mValues = strArr;
        this.mNumberPicker.clear();
        if (this.mMutiPickerContainer.getChildCount() > 0) {
            this.mMutiPickerContainer.removeAllViews();
        }
        this.mResult = null;
        if (strArr != null) {
            this.mResult = new int[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                MiniNumberPicker miniNumberPicker = new MiniNumberPicker(getContext());
                String[] strArr2 = strArr[i3];
                if (strArr2.length > 0) {
                    miniNumberPicker.setDisplayedValues(strArr2);
                    miniNumberPicker.setMinValue(0);
                    miniNumberPicker.setMaxValue(strArr[i3].length - 1);
                }
                miniNumberPicker.setOnValueChangedListener(new MutiOnValueChangeListener(i3));
                setNumpickerDiverColor(miniNumberPicker);
                this.mNumberPicker.add(miniNumberPicker);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                layoutParams.setMargins(10, 10, 10, 10);
                this.mMutiPickerContainer.addView(miniNumberPicker, layoutParams);
            }
        }
    }
}

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
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;

/* loaded from: classes23.dex */
public class PickerView extends ReportDialog implements View.OnClickListener, DialogInterface.OnCancelListener {
    private TextView mCancelTextView;
    private TextView mConfirmTextView;
    private NumberPicker mNumPicker;
    private OnConfirmListener mOnConfirmListener;
    private int result;
    private String[] vals;

    /* loaded from: classes23.dex */
    public interface OnConfirmListener {
        void onValCancel();

        void onValConfirm(int i3);
    }

    public PickerView(@NonNull Context context) {
        super(context, R.style.Theme_Light_NoTitle_Dialog);
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_dialog_picker, (ViewGroup) null);
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
        this.mNumPicker = (NumberPicker) inflate.findViewById(R.id.numPicker);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.mCancelTextView = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.mConfirmTextView = textView2;
        textView2.setOnClickListener(this);
        setNumpickerDiverColor(this.mNumPicker);
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

    public void init(int i3, OnConfirmListener onConfirmListener) {
        this.result = i3;
        this.mNumPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.tencent.qqmini.miniapp.widget.PickerView.1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i16, int i17) {
                PickerView.this.result = i17;
            }
        });
        this.mOnConfirmListener = onConfirmListener;
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
        if (view.getId() == R.id.tv_cancel) {
            OnConfirmListener onConfirmListener = this.mOnConfirmListener;
            if (onConfirmListener != null) {
                onConfirmListener.onValCancel();
            }
            dismissDlg();
        } else if (view.getId() == R.id.tv_confirm) {
            OnConfirmListener onConfirmListener2 = this.mOnConfirmListener;
            if (onConfirmListener2 != null) {
                onConfirmListener2.onValConfirm(this.result);
            }
            dismissDlg();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setDisplayedValues(String[] strArr) {
        this.vals = strArr;
        this.mNumPicker.setDisplayedValues(strArr);
    }

    public void setMaxValues(int i3) {
        this.mNumPicker.setMaxValue(i3);
    }

    public void setMinValue(int i3) {
        this.mNumPicker.setMinValue(i3);
    }

    public void setValue(int i3) {
        this.mNumPicker.setValue(i3);
    }
}

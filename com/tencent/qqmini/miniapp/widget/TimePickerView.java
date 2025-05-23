package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;

/* loaded from: classes23.dex */
public class TimePickerView extends ReportDialog implements View.OnClickListener, DialogInterface.OnCancelListener {
    private int hour;
    private NumberPicker hourNumberPicker;
    private TextView mCancelTextView;
    private TextView mConfirmTextView;
    private OnConfirmListener mOnConfirmListener;
    private TimePicker mTimePicker;
    private int minute;
    private int minuteMaxValue;
    private int minuteMinValue;
    private NumberPicker minuteNumberPicker;

    /* loaded from: classes23.dex */
    public interface OnConfirmListener {
        void onTimeCancel();

        void onTimeConfirm(String str, String str2);
    }

    public TimePickerView(@NonNull Context context) {
        super(context, R.style.Theme_Light_NoTitle_Dialog);
        this.minuteMaxValue = 59;
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_dialog_date_picker, (ViewGroup) null);
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
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.picker_container);
        TimePicker timePicker = new TimePicker(new ContextThemeWrapper(getContext(), android.R.style.Theme.Holo.Light));
        this.mTimePicker = timePicker;
        frameLayout.addView(timePicker);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.mCancelTextView = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.mConfirmTextView = textView2;
        textView2.setOnClickListener(this);
        int identifier = Resources.getSystem().getIdentifier(WidgetCacheWeatherData.HOUR, "id", "android");
        int identifier2 = Resources.getSystem().getIdentifier("minute", "id", "android");
        int identifier3 = Resources.getSystem().getIdentifier("amPm", "id", "android");
        this.hourNumberPicker = (NumberPicker) this.mTimePicker.findViewById(identifier);
        this.minuteNumberPicker = (NumberPicker) this.mTimePicker.findViewById(identifier2);
        NumberPicker numberPicker = (NumberPicker) this.mTimePicker.findViewById(identifier3);
        setNumberPickerDividerColor(this.hourNumberPicker);
        setNumberPickerDividerColor(this.minuteNumberPicker);
        setNumberPickerDividerColor(numberPicker);
        setOnCancelListener(this);
    }

    private void setNumberPickerDividerColor(NumberPicker numberPicker) {
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

    public void init(int i3, int i16, OnConfirmListener onConfirmListener) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i3));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i16));
        this.mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.tencent.qqmini.miniapp.widget.TimePickerView.1
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, int i17, int i18) {
                TimePickerView.this.hour = i17;
                TimePickerView.this.minute = i18;
                if (i17 == TimePickerView.this.hourNumberPicker.getMinValue()) {
                    TimePickerView.this.minuteNumberPicker.setMinValue(TimePickerView.this.minuteMinValue);
                    TimePickerView.this.minuteNumberPicker.setMaxValue(59);
                } else if (i17 == TimePickerView.this.hourNumberPicker.getMaxValue()) {
                    TimePickerView.this.minuteNumberPicker.setMinValue(0);
                    TimePickerView.this.minuteNumberPicker.setMaxValue(TimePickerView.this.minuteMaxValue);
                } else {
                    TimePickerView.this.minuteNumberPicker.setMinValue(0);
                    TimePickerView.this.minuteNumberPicker.setMaxValue(59);
                }
            }
        });
        this.mOnConfirmListener = onConfirmListener;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnConfirmListener onConfirmListener = this.mOnConfirmListener;
        if (onConfirmListener != null) {
            onConfirmListener.onTimeCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.tv_cancel) {
            OnConfirmListener onConfirmListener = this.mOnConfirmListener;
            if (onConfirmListener != null) {
                onConfirmListener.onTimeCancel();
            }
            dismissDlg();
        } else if (view.getId() == R.id.tv_confirm) {
            if (this.mOnConfirmListener != null) {
                String valueOf = String.valueOf(this.hour);
                if (this.hour < 10) {
                    valueOf = "0" + valueOf;
                }
                String valueOf2 = String.valueOf(this.minute);
                if (this.minute < 10) {
                    valueOf2 = "0" + valueOf2;
                }
                this.mOnConfirmListener.onTimeConfirm(valueOf, valueOf2);
            }
            dismissDlg();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setHourMaxValue(int i3) {
        this.hourNumberPicker.setMaxValue(i3);
    }

    public void setHourMinValue(int i3) {
        this.hourNumberPicker.setMinValue(i3);
    }

    public void setIs24HourView(boolean z16) {
        this.mTimePicker.setIs24HourView(Boolean.valueOf(z16));
    }

    public void setMinuteMaxValue(int i3) {
        this.minuteMaxValue = i3;
    }

    public void setMinuteMinValue(int i3) {
        this.minuteMinValue = i3;
    }
}

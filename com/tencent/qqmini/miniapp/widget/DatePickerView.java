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
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;

/* loaded from: classes23.dex */
public class DatePickerView extends ReportDialog implements View.OnClickListener, DialogInterface.OnCancelListener {
    private static final String TAG = "DatePickerView";
    private int dayOfMonth;
    private TextView mCancelTextView;
    private TextView mConfirmTextView;
    private DatePicker mDatePicker;
    private OnConfirmListener mOnConfirmListener;
    private int monthOfYear;
    private int year;

    /* loaded from: classes23.dex */
    public interface OnConfirmListener {
        void onDateCancel();

        void onDateConfirm(String str, String str2, String str3);
    }

    public DatePickerView(Context context) {
        super(context, R.style.Theme_Light_NoTitle_Dialog);
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
        DatePicker datePicker = new DatePicker(new ContextThemeWrapper(getContext(), android.R.style.Theme.Holo.Light));
        this.mDatePicker = datePicker;
        datePicker.setCalendarViewShown(false);
        frameLayout.addView(this.mDatePicker);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.mCancelTextView = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.mConfirmTextView = textView2;
        textView2.setOnClickListener(this);
        setDatePickerDividerColor(this.mDatePicker);
        setOnCancelListener(this);
    }

    private void setDatePickerDividerColor(DatePicker datePicker) {
        LinearLayout linearLayout = (LinearLayout) ((LinearLayout) datePicker.getChildAt(0)).getChildAt(0);
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            NumberPicker numberPicker = (NumberPicker) linearLayout.getChildAt(i3);
            Field[] declaredFields = NumberPicker.class.getDeclaredFields();
            int length = declaredFields.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    Field field = declaredFields[i16];
                    if (field.getName().equals("mSelectionDivider")) {
                        field.setAccessible(true);
                        try {
                            field.set(numberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
                            break;
                        } catch (Resources.NotFoundException e16) {
                            e16.printStackTrace();
                        } catch (IllegalAccessException e17) {
                            e17.printStackTrace();
                        } catch (IllegalArgumentException e18) {
                            e18.printStackTrace();
                        }
                    } else {
                        i16++;
                    }
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

    public void init(int i3, int i16, int i17, OnConfirmListener onConfirmListener) {
        this.mDatePicker.init(i3, i16, i17, new DatePicker.OnDateChangedListener() { // from class: com.tencent.qqmini.miniapp.widget.DatePickerView.1
            @Override // android.widget.DatePicker.OnDateChangedListener
            public void onDateChanged(DatePicker datePicker, int i18, int i19, int i26) {
                if (datePicker == null) {
                    DatePickerView.this.year = i18;
                    DatePickerView.this.monthOfYear = i19;
                    DatePickerView.this.dayOfMonth = i26;
                } else {
                    DatePickerView.this.year = datePicker.getYear();
                    DatePickerView.this.monthOfYear = datePicker.getMonth();
                    DatePickerView.this.dayOfMonth = datePicker.getDayOfMonth();
                }
            }
        });
        this.mOnConfirmListener = onConfirmListener;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnConfirmListener onConfirmListener = this.mOnConfirmListener;
        if (onConfirmListener != null) {
            onConfirmListener.onDateCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String valueOf;
        String valueOf2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.tv_cancel) {
            OnConfirmListener onConfirmListener = this.mOnConfirmListener;
            if (onConfirmListener != null) {
                onConfirmListener.onDateCancel();
            }
            dismissDlg();
        } else if (view.getId() == R.id.tv_confirm) {
            if (this.mOnConfirmListener != null) {
                int i3 = this.monthOfYear + 1;
                if (i3 < 10) {
                    valueOf = "0" + i3;
                } else {
                    valueOf = String.valueOf(i3);
                }
                int i16 = this.dayOfMonth;
                if (i16 < 10) {
                    valueOf2 = "0" + i16;
                } else {
                    valueOf2 = String.valueOf(i16);
                }
                this.mOnConfirmListener.onDateConfirm(String.valueOf(this.year), valueOf, valueOf2);
            }
            dismissDlg();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setDayOfMonthVisible(int i3) {
        DatePicker datePicker = this.mDatePicker;
        if (datePicker != null) {
            ((ViewGroup) ((ViewGroup) datePicker.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(i3);
        }
    }

    public void setMaxDate(long j3) {
        try {
            this.mDatePicker.setMaxDate(j3);
        } catch (IllegalArgumentException e16) {
            QMLog.e(TAG, "setMaxDate error!", e16);
        }
    }

    public void setMinDate(long j3) {
        this.mDatePicker.setMinDate(j3);
    }

    public void setMonthOfYearVisible(int i3) {
        DatePicker datePicker = this.mDatePicker;
        if (datePicker != null) {
            ((ViewGroup) ((ViewGroup) datePicker.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(i3);
        }
    }

    public void setYearVisible(int i3) {
        DatePicker datePicker = this.mDatePicker;
        if (datePicker != null) {
            ((ViewGroup) ((ViewGroup) datePicker.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(i3);
        }
    }

    public void updateDate(int i3, int i16, int i17) {
        this.year = i3;
        this.monthOfYear = i16;
        this.dayOfMonth = i17;
        this.mDatePicker.updateDate(i3, i16, i17);
    }
}

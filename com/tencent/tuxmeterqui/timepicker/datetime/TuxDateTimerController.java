package com.tencent.tuxmeterqui.timepicker.datetime;

import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.tuxmeterqui.timepicker.TuxCalendarExtKt;
import com.tencent.tuxmeterqui.timepicker.TuxDateTimeConfig;
import com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u001e\u0010'\u001a\u00020\u000f2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016J \u0010)\u001a\u00020\u000f2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00192\u0006\u0010+\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxDateTimerController;", "Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxBaseTimeController;", "()V", QQPermissionConstants.Permission.CALENDAR_GROUP, "Ljava/util/Calendar;", ReadInJoyMMapKvStorage.NAME_DEFAULT, "", "mDaySpinner", "Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker;", "mHourSpinner", "mMinuteSpinner", "mMonthSpinner", "mOnDateTimeChangedListener", "Lkotlin/Function1;", "", "", "mSecondSpinner", "mYearSpinner", "maxCalendar", "minCalendar", "onChangeListener", "Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker$OnValueChangeListener;", "wrapSelectorWheel", "", "wrapSelectorWheelTypes", "", "applyDateData", "bindGlobal", "bindPicker", "type", "picker", "build", "getMillisecond", "limitMaxAndMin", "onDateTimeChanged", "setDefaultMillisecond", "time", "setMaxMillisecond", "setMinMillisecond", "setOnDateTimeChangedListener", "callback", "setWrapSelectorWheel", "types", "wrapSelector", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class TuxDateTimerController extends TuxBaseTimeController {
    static IPatchRedirector $redirector_;
    private Calendar calendar;
    private int global;

    @Nullable
    private NumberPicker mDaySpinner;

    @Nullable
    private NumberPicker mHourSpinner;

    @Nullable
    private NumberPicker mMinuteSpinner;

    @Nullable
    private NumberPicker mMonthSpinner;

    @Nullable
    private Function1<? super Long, Unit> mOnDateTimeChangedListener;

    @Nullable
    private NumberPicker mSecondSpinner;

    @Nullable
    private NumberPicker mYearSpinner;
    private Calendar maxCalendar;
    private Calendar minCalendar;

    @NotNull
    private final NumberPicker.OnValueChangeListener onChangeListener;
    private boolean wrapSelectorWheel;

    @Nullable
    private List<Integer> wrapSelectorWheelTypes;

    public TuxDateTimerController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.wrapSelectorWheel = true;
            this.onChangeListener = new NumberPicker.OnValueChangeListener() { // from class: com.tencent.tuxmeterqui.timepicker.datetime.a
                @Override // com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker.OnValueChangeListener
                public final void onValueChange(NumberPicker numberPicker, int i3, int i16) {
                    TuxDateTimerController.onChangeListener$lambda$6(TuxDateTimerController.this, numberPicker, i3, i16);
                }
            };
        }
    }

    private final void applyDateData() {
        Integer num;
        int i3;
        NumberPicker numberPicker;
        Calendar calendar = this.calendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar = null;
        }
        calendar.clear();
        NumberPicker numberPicker2 = this.mYearSpinner;
        if (numberPicker2 != null) {
            Calendar calendar3 = this.calendar;
            if (calendar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar3 = null;
            }
            calendar3.set(1, numberPicker2.getValue());
        }
        NumberPicker numberPicker3 = this.mMonthSpinner;
        if (numberPicker3 != null) {
            Calendar calendar4 = this.calendar;
            if (calendar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar4 = null;
            }
            calendar4.set(2, numberPicker3.getValue() - 1);
        }
        NumberPicker numberPicker4 = this.mYearSpinner;
        if (numberPicker4 != null) {
            num = Integer.valueOf(numberPicker4.getValue());
        } else {
            num = null;
        }
        NumberPicker numberPicker5 = this.mMonthSpinner;
        int i16 = 0;
        if (numberPicker5 != null) {
            i3 = numberPicker5.getValue();
        } else {
            i3 = 0;
        }
        int maxDayInMonth = getMaxDayInMonth(num, Integer.valueOf(i3 - 1));
        NumberPicker numberPicker6 = this.mDaySpinner;
        if (numberPicker6 != null) {
            i16 = numberPicker6.getValue();
        }
        if (i16 >= maxDayInMonth && (numberPicker = this.mDaySpinner) != null) {
            numberPicker.setValue(maxDayInMonth);
        }
        NumberPicker numberPicker7 = this.mDaySpinner;
        if (numberPicker7 != null) {
            Calendar calendar5 = this.calendar;
            if (calendar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar5 = null;
            }
            calendar5.set(5, numberPicker7.getValue());
        }
        NumberPicker numberPicker8 = this.mHourSpinner;
        if (numberPicker8 != null) {
            Calendar calendar6 = this.calendar;
            if (calendar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar6 = null;
            }
            calendar6.set(11, numberPicker8.getValue());
        }
        NumberPicker numberPicker9 = this.mMinuteSpinner;
        if (numberPicker9 != null) {
            Calendar calendar7 = this.calendar;
            if (calendar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar7 = null;
            }
            calendar7.set(12, numberPicker9.getValue());
        }
        NumberPicker numberPicker10 = this.mSecondSpinner;
        if (numberPicker10 != null) {
            Calendar calendar8 = this.calendar;
            if (calendar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            } else {
                calendar2 = calendar8;
            }
            calendar2.set(13, numberPicker10.getValue());
        }
    }

    private final void limitMaxAndMin() {
        NumberPicker numberPicker;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        Calendar calendar = this.calendar;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar = null;
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = this.minCalendar;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar2 = null;
        }
        if (timeInMillis < calendar2.getTimeInMillis()) {
            Calendar calendar3 = this.calendar;
            if (calendar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar3 = null;
            }
            calendar3.clear();
            Calendar calendar4 = this.calendar;
            if (calendar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar4 = null;
            }
            Calendar calendar5 = this.minCalendar;
            if (calendar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar5 = null;
            }
            calendar4.setTimeInMillis(calendar5.getTimeInMillis());
        }
        Calendar calendar6 = this.calendar;
        if (calendar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar6 = null;
        }
        long timeInMillis2 = calendar6.getTimeInMillis();
        Calendar calendar7 = this.maxCalendar;
        if (calendar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar7 = null;
        }
        if (timeInMillis2 > calendar7.getTimeInMillis()) {
            Calendar calendar8 = this.calendar;
            if (calendar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar8 = null;
            }
            calendar8.clear();
            Calendar calendar9 = this.calendar;
            if (calendar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar9 = null;
            }
            Calendar calendar10 = this.maxCalendar;
            if (calendar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar10 = null;
            }
            calendar9.setTimeInMillis(calendar10.getTimeInMillis());
        }
        Calendar calendar11 = this.calendar;
        if (calendar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar11 = null;
        }
        Integer valueOf = Integer.valueOf(calendar11.get(1));
        Calendar calendar12 = this.calendar;
        if (calendar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar12 = null;
        }
        int maxDayInMonth = getMaxDayInMonth(valueOf, Integer.valueOf(calendar12.get(2)));
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            Calendar calendar13 = this.calendar;
            if (calendar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar13 = null;
            }
            Calendar calendar14 = this.minCalendar;
            if (calendar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar14 = null;
            }
            if (TuxCalendarExtKt.isSameYear(calendar13, calendar14)) {
                Calendar calendar15 = this.minCalendar;
                if (calendar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                    calendar15 = null;
                }
                i28 = calendar15.get(2) + 1;
            } else {
                i28 = 1;
            }
            numberPicker2.setMinValue(i28);
            Calendar calendar16 = this.calendar;
            if (calendar16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar16 = null;
            }
            Calendar calendar17 = this.maxCalendar;
            if (calendar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar17 = null;
            }
            if (TuxCalendarExtKt.isSameYear(calendar16, calendar17)) {
                Calendar calendar18 = this.maxCalendar;
                if (calendar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                    calendar18 = null;
                }
                i29 = calendar18.get(2) + 1;
            } else {
                i29 = 12;
            }
            numberPicker2.setMaxValue(i29);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            Calendar calendar19 = this.calendar;
            if (calendar19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar19 = null;
            }
            Calendar calendar20 = this.minCalendar;
            if (calendar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar20 = null;
            }
            if (TuxCalendarExtKt.isSameMonth(calendar19, calendar20)) {
                Calendar calendar21 = this.minCalendar;
                if (calendar21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                    calendar21 = null;
                }
                i26 = calendar21.get(5);
            } else {
                i26 = 1;
            }
            numberPicker3.setMinValue(i26);
            Calendar calendar22 = this.calendar;
            if (calendar22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar22 = null;
            }
            Calendar calendar23 = this.maxCalendar;
            if (calendar23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar23 = null;
            }
            if (TuxCalendarExtKt.isSameMonth(calendar22, calendar23)) {
                Calendar calendar24 = this.maxCalendar;
                if (calendar24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                    calendar24 = null;
                }
                i27 = calendar24.get(5);
            } else {
                i27 = maxDayInMonth;
            }
            numberPicker3.setMaxValue(i27);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        int i36 = 0;
        if (numberPicker4 != null) {
            Calendar calendar25 = this.calendar;
            if (calendar25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar25 = null;
            }
            Calendar calendar26 = this.minCalendar;
            if (calendar26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar26 = null;
            }
            if (TuxCalendarExtKt.isSameDay(calendar25, calendar26)) {
                Calendar calendar27 = this.minCalendar;
                if (calendar27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                    calendar27 = null;
                }
                i18 = calendar27.get(11);
            } else {
                i18 = 0;
            }
            numberPicker4.setMinValue(i18);
            Calendar calendar28 = this.calendar;
            if (calendar28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar28 = null;
            }
            Calendar calendar29 = this.maxCalendar;
            if (calendar29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar29 = null;
            }
            if (TuxCalendarExtKt.isSameDay(calendar28, calendar29)) {
                Calendar calendar30 = this.maxCalendar;
                if (calendar30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                    calendar30 = null;
                }
                i19 = calendar30.get(11);
            } else {
                i19 = 23;
            }
            numberPicker4.setMaxValue(i19);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        int i37 = 59;
        if (numberPicker5 != null) {
            Calendar calendar31 = this.calendar;
            if (calendar31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar31 = null;
            }
            Calendar calendar32 = this.minCalendar;
            if (calendar32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar32 = null;
            }
            if (TuxCalendarExtKt.isSameHour(calendar31, calendar32)) {
                Calendar calendar33 = this.minCalendar;
                if (calendar33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                    calendar33 = null;
                }
                i16 = calendar33.get(12);
            } else {
                i16 = 0;
            }
            numberPicker5.setMinValue(i16);
            Calendar calendar34 = this.calendar;
            if (calendar34 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar34 = null;
            }
            Calendar calendar35 = this.maxCalendar;
            if (calendar35 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar35 = null;
            }
            if (TuxCalendarExtKt.isSameHour(calendar34, calendar35)) {
                Calendar calendar36 = this.maxCalendar;
                if (calendar36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                    calendar36 = null;
                }
                i17 = calendar36.get(12);
            } else {
                i17 = 59;
            }
            numberPicker5.setMaxValue(i17);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            Calendar calendar37 = this.calendar;
            if (calendar37 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar37 = null;
            }
            Calendar calendar38 = this.minCalendar;
            if (calendar38 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar38 = null;
            }
            if (TuxCalendarExtKt.isSameMinute(calendar37, calendar38)) {
                Calendar calendar39 = this.minCalendar;
                if (calendar39 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                    calendar39 = null;
                }
                i3 = calendar39.get(13);
            } else {
                i3 = 0;
            }
            numberPicker6.setMinValue(i3);
            Calendar calendar40 = this.calendar;
            if (calendar40 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar40 = null;
            }
            Calendar calendar41 = this.maxCalendar;
            if (calendar41 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar41 = null;
            }
            if (TuxCalendarExtKt.isSameMinute(calendar40, calendar41)) {
                Calendar calendar42 = this.maxCalendar;
                if (calendar42 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                    calendar42 = null;
                }
                i37 = calendar42.get(13);
            }
            numberPicker6.setMaxValue(i37);
        }
        NumberPicker numberPicker7 = this.mYearSpinner;
        if (numberPicker7 != null) {
            Calendar calendar43 = this.calendar;
            if (calendar43 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar43 = null;
            }
            numberPicker7.setValue(calendar43.get(1));
        }
        NumberPicker numberPicker8 = this.mMonthSpinner;
        if (numberPicker8 != null) {
            Calendar calendar44 = this.calendar;
            if (calendar44 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar44 = null;
            }
            numberPicker8.setValue(calendar44.get(2) + 1);
        }
        NumberPicker numberPicker9 = this.mDaySpinner;
        if (numberPicker9 != null) {
            Calendar calendar45 = this.calendar;
            if (calendar45 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar45 = null;
            }
            numberPicker9.setValue(calendar45.get(5));
        }
        NumberPicker numberPicker10 = this.mHourSpinner;
        if (numberPicker10 != null) {
            Calendar calendar46 = this.calendar;
            if (calendar46 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar46 = null;
            }
            numberPicker10.setValue(calendar46.get(11));
        }
        NumberPicker numberPicker11 = this.mMinuteSpinner;
        if (numberPicker11 != null) {
            Calendar calendar47 = this.calendar;
            if (calendar47 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar47 = null;
            }
            numberPicker11.setValue(calendar47.get(12));
        }
        NumberPicker numberPicker12 = this.mSecondSpinner;
        if (numberPicker12 != null) {
            Calendar calendar48 = this.calendar;
            if (calendar48 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar48 = null;
            }
            numberPicker12.setValue(calendar48.get(13));
        }
        NumberPicker numberPicker13 = this.mDaySpinner;
        if (numberPicker13 != null) {
            i36 = numberPicker13.getValue();
        }
        if (i36 >= maxDayInMonth && (numberPicker = this.mDaySpinner) != null) {
            numberPicker.setValue(maxDayInMonth);
        }
        setWrapSelectorWheel(this.wrapSelectorWheelTypes, this.wrapSelectorWheel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onChangeListener$lambda$6(TuxDateTimerController this$0, NumberPicker numberPicker, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.applyDateData();
        this$0.limitMaxAndMin();
        this$0.onDateTimeChanged();
    }

    private final void onDateTimeChanged() {
        Function1<? super Long, Unit> function1 = this.mOnDateTimeChangedListener;
        if (function1 != null && function1 != null) {
            Calendar calendar = this.calendar;
            if (calendar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar = null;
            }
            function1.invoke(Long.valueOf(calendar.getTimeInMillis()));
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxBaseTimeController
    @NotNull
    public TuxBaseTimeController bindPicker(int type, @Nullable NumberPicker picker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TuxBaseTimeController) iPatchRedirector.redirect((short) 2, (Object) this, type, (Object) picker);
        }
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            if (type == 5) {
                                this.mSecondSpinner = picker;
                            }
                        } else {
                            this.mMinuteSpinner = picker;
                        }
                    } else {
                        this.mHourSpinner = picker;
                    }
                } else {
                    this.mDaySpinner = picker;
                }
            } else {
                this.mMonthSpinner = picker;
            }
        } else {
            this.mYearSpinner = picker;
        }
        return this;
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public long getMillisecond() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        Calendar calendar = this.calendar;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar = null;
        }
        return calendar.getTimeInMillis();
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setDefaultMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, time);
            return;
        }
        if (time == 0) {
            return;
        }
        Calendar calendar = this.calendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar = null;
        }
        calendar.clear();
        Calendar calendar3 = this.calendar;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
        } else {
            calendar2 = calendar3;
        }
        calendar2.setTimeInMillis(time);
        limitMaxAndMin();
        onDateTimeChanged();
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setMaxMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, time);
            return;
        }
        if (time == 0) {
            return;
        }
        Calendar calendar = this.minCalendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar = null;
        }
        if (calendar.getTimeInMillis() > 0) {
            Calendar calendar3 = this.minCalendar;
            if (calendar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar3 = null;
            }
            if (time < calendar3.getTimeInMillis()) {
                return;
            }
        }
        Calendar calendar4 = this.maxCalendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar4 = null;
        }
        calendar4.setTimeInMillis(time);
        Calendar calendar5 = this.maxCalendar;
        if (calendar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar5 = null;
        }
        int i3 = calendar5.get(1);
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setMaxValue(i3);
        }
        Calendar calendar6 = this.calendar;
        if (calendar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
        } else {
            calendar2 = calendar6;
        }
        setDefaultMillisecond(calendar2.getTimeInMillis());
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setMinMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, time);
            return;
        }
        if (time == 0) {
            return;
        }
        Calendar calendar = this.maxCalendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar = null;
        }
        long timeInMillis = calendar.getTimeInMillis();
        boolean z16 = false;
        if (1 <= timeInMillis && timeInMillis < time) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Calendar calendar3 = this.minCalendar;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar3 = null;
        }
        calendar3.setTimeInMillis(time);
        Calendar calendar4 = this.minCalendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar4 = null;
        }
        int i3 = calendar4.get(1);
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setMinValue(i3);
        }
        Calendar calendar5 = this.calendar;
        if (calendar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
        } else {
            calendar2 = calendar5;
        }
        setDefaultMillisecond(calendar2.getTimeInMillis());
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setOnDateTimeChangedListener(@Nullable Function1<? super Long, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) callback);
        } else {
            this.mOnDateTimeChangedListener = callback;
            onDateTimeChanged();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r8.isEmpty() != false) goto L12;
     */
    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setWrapSelectorWheel(@Nullable List<Integer> types, boolean wrapSelector) {
        NumberPicker numberPicker;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, types, Boolean.valueOf(wrapSelector));
            return;
        }
        this.wrapSelectorWheelTypes = types;
        this.wrapSelectorWheel = wrapSelector;
        if (types != null) {
            Intrinsics.checkNotNull(types);
        }
        ArrayList arrayList = new ArrayList();
        this.wrapSelectorWheelTypes = arrayList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(0);
        List<Integer> list = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list);
        list.add(1);
        List<Integer> list2 = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list2);
        list2.add(2);
        List<Integer> list3 = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list3);
        list3.add(3);
        List<Integer> list4 = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list4);
        list4.add(4);
        List<Integer> list5 = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list5);
        list5.add(5);
        List<Integer> list6 = this.wrapSelectorWheelTypes;
        Intrinsics.checkNotNull(list6);
        Iterator<Integer> it = list6.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue != 4) {
                                if (intValue == 5 && (numberPicker = this.mSecondSpinner) != null) {
                                    numberPicker.setWrapSelectorWheel(wrapSelector);
                                }
                            } else {
                                NumberPicker numberPicker2 = this.mMinuteSpinner;
                                if (numberPicker2 != null) {
                                    numberPicker2.setWrapSelectorWheel(wrapSelector);
                                }
                            }
                        } else {
                            NumberPicker numberPicker3 = this.mHourSpinner;
                            if (numberPicker3 != null) {
                                numberPicker3.setWrapSelectorWheel(wrapSelector);
                            }
                        }
                    } else {
                        NumberPicker numberPicker4 = this.mDaySpinner;
                        if (numberPicker4 != null) {
                            numberPicker4.setWrapSelectorWheel(wrapSelector);
                        }
                    }
                } else {
                    NumberPicker numberPicker5 = this.mMonthSpinner;
                    if (numberPicker5 != null) {
                        numberPicker5.setWrapSelectorWheel(wrapSelector);
                    }
                }
            } else {
                NumberPicker numberPicker6 = this.mYearSpinner;
                if (numberPicker6 != null) {
                    numberPicker6.setWrapSelectorWheel(wrapSelector);
                }
            }
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxBaseTimeController
    @NotNull
    public TuxDateTimerController bindGlobal(int global) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TuxDateTimerController) iPatchRedirector.redirect((short) 3, (Object) this, global);
        }
        this.global = global;
        return this;
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxBaseTimeController
    @NotNull
    public TuxDateTimerController build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TuxDateTimerController) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.calendar = calendar;
        Calendar calendar2 = null;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar = null;
        }
        calendar.set(14, 0);
        Calendar calendar3 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar3, "getInstance()");
        this.minCalendar = calendar3;
        if (calendar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar3 = null;
        }
        calendar3.set(1, 1900);
        Calendar calendar4 = this.minCalendar;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar4 = null;
        }
        calendar4.set(2, 0);
        Calendar calendar5 = this.minCalendar;
        if (calendar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar5 = null;
        }
        calendar5.set(5, 1);
        Calendar calendar6 = this.minCalendar;
        if (calendar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar6 = null;
        }
        calendar6.set(11, 0);
        Calendar calendar7 = this.minCalendar;
        if (calendar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar7 = null;
        }
        calendar7.set(12, 0);
        Calendar calendar8 = this.minCalendar;
        if (calendar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
            calendar8 = null;
        }
        calendar8.set(13, 0);
        Calendar calendar9 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar9, "getInstance()");
        this.maxCalendar = calendar9;
        if (calendar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar9 = null;
        }
        Calendar calendar10 = this.calendar;
        if (calendar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            calendar10 = null;
        }
        calendar9.set(1, calendar10.get(1) + 1900);
        Calendar calendar11 = this.maxCalendar;
        if (calendar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar11 = null;
        }
        calendar11.set(2, 11);
        Calendar calendar12 = this.maxCalendar;
        if (calendar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar12 = null;
        }
        Calendar calendar13 = this.maxCalendar;
        if (calendar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar13 = null;
        }
        calendar12.set(5, TuxCalendarExtKt.getMaxDayInMonth(calendar13));
        Calendar calendar14 = this.maxCalendar;
        if (calendar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar14 = null;
        }
        calendar14.set(11, 23);
        Calendar calendar15 = this.maxCalendar;
        if (calendar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar15 = null;
        }
        calendar15.set(12, 59);
        Calendar calendar16 = this.maxCalendar;
        if (calendar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
            calendar16 = null;
        }
        calendar16.set(13, 59);
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            Calendar calendar17 = this.maxCalendar;
            if (calendar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar17 = null;
            }
            numberPicker.setMaxValue(calendar17.get(1));
            Calendar calendar18 = this.minCalendar;
            if (calendar18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar18 = null;
            }
            numberPicker.setMinValue(calendar18.get(1));
            Calendar calendar19 = this.calendar;
            if (calendar19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar19 = null;
            }
            numberPicker.setValue(calendar19.get(1));
            numberPicker.setFocusable(true);
            numberPicker.setFocusableInTouchMode(true);
            numberPicker.setDescendantFocusability(393216);
            numberPicker.setOnValueChangedListener(this.onChangeListener);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            Calendar calendar20 = this.maxCalendar;
            if (calendar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar20 = null;
            }
            numberPicker2.setMaxValue(calendar20.get(2) + 1);
            Calendar calendar21 = this.minCalendar;
            if (calendar21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar21 = null;
            }
            numberPicker2.setMinValue(calendar21.get(2) + 1);
            Calendar calendar22 = this.calendar;
            if (calendar22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar22 = null;
            }
            numberPicker2.setValue(calendar22.get(2) + 1);
            numberPicker2.setFocusable(true);
            numberPicker2.setFocusableInTouchMode(true);
            numberPicker2.setFormatter(TuxDateTimeConfig.INSTANCE.getFormatter());
            numberPicker2.setDescendantFocusability(393216);
            numberPicker2.setOnValueChangedListener(this.onChangeListener);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            Calendar calendar23 = this.maxCalendar;
            if (calendar23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar23 = null;
            }
            numberPicker3.setMaxValue(calendar23.get(5));
            Calendar calendar24 = this.minCalendar;
            if (calendar24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar24 = null;
            }
            numberPicker3.setMinValue(calendar24.get(5));
            Calendar calendar25 = this.calendar;
            if (calendar25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar25 = null;
            }
            numberPicker3.setValue(calendar25.get(5));
            numberPicker3.setFocusable(true);
            numberPicker3.setFocusableInTouchMode(true);
            numberPicker3.setFormatter(TuxDateTimeConfig.INSTANCE.getFormatter());
            numberPicker3.setDescendantFocusability(393216);
            numberPicker3.setOnValueChangedListener(this.onChangeListener);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            Calendar calendar26 = this.maxCalendar;
            if (calendar26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar26 = null;
            }
            numberPicker4.setMaxValue(calendar26.get(11));
            Calendar calendar27 = this.minCalendar;
            if (calendar27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar27 = null;
            }
            numberPicker4.setMinValue(calendar27.get(11));
            numberPicker4.setFocusable(true);
            numberPicker4.setFocusableInTouchMode(true);
            Calendar calendar28 = this.calendar;
            if (calendar28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar28 = null;
            }
            numberPicker4.setValue(calendar28.get(11));
            numberPicker4.setFormatter(TuxDateTimeConfig.INSTANCE.getFormatter());
            numberPicker4.setDescendantFocusability(393216);
            numberPicker4.setOnValueChangedListener(this.onChangeListener);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            Calendar calendar29 = this.maxCalendar;
            if (calendar29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar29 = null;
            }
            numberPicker5.setMaxValue(calendar29.get(12));
            Calendar calendar30 = this.minCalendar;
            if (calendar30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar30 = null;
            }
            numberPicker5.setMinValue(calendar30.get(12));
            numberPicker5.setFocusable(true);
            numberPicker5.setFocusableInTouchMode(true);
            Calendar calendar31 = this.calendar;
            if (calendar31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
                calendar31 = null;
            }
            numberPicker5.setValue(calendar31.get(12));
            numberPicker5.setFormatter(TuxDateTimeConfig.INSTANCE.getFormatter());
            numberPicker5.setDescendantFocusability(393216);
            numberPicker5.setOnValueChangedListener(this.onChangeListener);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            Calendar calendar32 = this.maxCalendar;
            if (calendar32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxCalendar");
                calendar32 = null;
            }
            numberPicker6.setMaxValue(calendar32.get(13));
            Calendar calendar33 = this.minCalendar;
            if (calendar33 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minCalendar");
                calendar33 = null;
            }
            numberPicker6.setMinValue(calendar33.get(13));
            numberPicker6.setFocusable(true);
            numberPicker6.setFocusableInTouchMode(true);
            Calendar calendar34 = this.calendar;
            if (calendar34 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQPermissionConstants.Permission.CALENDAR_GROUP);
            } else {
                calendar2 = calendar34;
            }
            numberPicker6.setValue(calendar2.get(13));
            numberPicker6.setFormatter(TuxDateTimeConfig.INSTANCE.getFormatter());
            numberPicker6.setDescendantFocusability(393216);
            numberPicker6.setOnValueChangedListener(this.onChangeListener);
        }
        return this;
    }
}

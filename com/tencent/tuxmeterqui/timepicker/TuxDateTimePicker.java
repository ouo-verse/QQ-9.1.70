package com.tencent.tuxmeterqui.timepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.timepicker.datetime.TuxBaseTimeController;
import com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface;
import com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimerController;
import com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000bJ\u0012\u00100\u001a\u0002012\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\bJ\b\u00105\u001a\u000201H\u0002J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u000203H\u0016J\u0010\u00108\u001a\u0002012\b\u00109\u001a\u0004\u0018\u00010\u0011J\u0010\u0010:\u001a\u0002012\b\b\u0001\u0010;\u001a\u00020\bJ\u000e\u0010<\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\bJB\u0010=\u001a\u0002012\b\b\u0002\u0010>\u001a\u00020\u000f2\b\b\u0002\u0010?\u001a\u00020\u000f2\b\b\u0002\u0010@\u001a\u00020\u000f2\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000fJ\u000e\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020\bJ\u0010\u0010F\u001a\u0002012\u0006\u00107\u001a\u000203H\u0016J\u0010\u0010G\u001a\u0002012\u0006\u00107\u001a\u000203H\u0016J\u001e\u0010H\u001a\u0002012\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000201\u0018\u00010JH\u0016J\u000e\u0010K\u001a\u0002012\u0006\u0010)\u001a\u00020*J\u000e\u0010L\u001a\u0002012\u0006\u0010,\u001a\u00020*J\u0010\u0010M\u001a\u0002012\b\b\u0001\u0010;\u001a\u00020\bJ\u001a\u0010N\u001a\u0002012\b\b\u0001\u0010O\u001a\u00020\b2\b\b\u0001\u0010P\u001a\u00020\bJ\u0010\u0010Q\u001a\u0002012\b\b\u0001\u0010;\u001a\u00020\bJ\u000e\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020*J\u001a\u0010R\u001a\u0002012\n\u00109\u001a\u00020\u0011\"\u00020\b2\u0006\u0010S\u001a\u00020*J \u0010R\u001a\u0002012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010T2\u0006\u0010S\u001a\u00020*H\u0016J\u000e\u0010+\u001a\u0002012\u0006\u0010U\u001a\u00020*R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDateTimePicker;", "Landroid/widget/FrameLayout;", "Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxDateTimeInterface;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "controller", "Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxBaseTimeController;", "dayLabel", "", "displayType", "", "dividerColor", ReadInJoyMMapKvStorage.NAME_DEFAULT, "hourLabel", "layoutResId", "mDayContainer", "Landroid/widget/LinearLayout;", "mDaySpinner", "Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker;", "mHourContainer", "mHourSpinner", "mMinuteContainer", "mMinuteSpinner", "mMonthContainer", "mMonthSpinner", "mSecondContainer", "mSecondSpinner", "mYearContainer", "mYearSpinner", "minLabel", "monthLabel", "normalTextSize", "secondLabel", "selectTextSize", "selectedTextBold", "", "showLabel", "textBold", "textColor", "themeColor", "yearLabel", "bindController", "", "getMillisecond", "", "getPicker", "init", "setDefaultMillisecond", "time", "setDisplayType", "types", "setDividerColor", "color", "setGlobal", "setLabelText", "year", "month", "day", WidgetCacheWeatherData.HOUR, Element.ELEMENT_NAME_MIN, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "setLayout", TtmlNode.TAG_LAYOUT, "setMaxMillisecond", "setMinMillisecond", "setOnDateTimeChangedListener", "callback", "Lkotlin/Function1;", "setSelectedTextBold", "setTextBold", "setTextColor", "setTextSize", "normal", "select", "setThemeColor", "setWrapSelectorWheel", "wrapSelector", "", "b", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TuxDateTimePicker extends FrameLayout implements TuxDateTimeInterface {
    static IPatchRedirector $redirector_;

    @Nullable
    private TuxBaseTimeController controller;

    @NotNull
    private String dayLabel;

    @NotNull
    private int[] displayType;
    private int dividerColor;
    private int global;

    @NotNull
    private String hourLabel;
    private int layoutResId;

    @Nullable
    private LinearLayout mDayContainer;

    @Nullable
    private NumberPicker mDaySpinner;

    @Nullable
    private LinearLayout mHourContainer;

    @Nullable
    private NumberPicker mHourSpinner;

    @Nullable
    private LinearLayout mMinuteContainer;

    @Nullable
    private NumberPicker mMinuteSpinner;

    @Nullable
    private LinearLayout mMonthContainer;

    @Nullable
    private NumberPicker mMonthSpinner;

    @Nullable
    private LinearLayout mSecondContainer;

    @Nullable
    private NumberPicker mSecondSpinner;

    @Nullable
    private LinearLayout mYearContainer;

    @Nullable
    private NumberPicker mYearSpinner;

    @NotNull
    private String minLabel;

    @NotNull
    private String monthLabel;
    private int normalTextSize;

    @NotNull
    private String secondLabel;
    private int selectTextSize;
    private boolean selectedTextBold;
    private boolean showLabel;
    private boolean textBold;
    private int textColor;
    private int themeColor;

    @NotNull
    private String yearLabel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TuxDateTimePicker(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    private final void bindController(TuxBaseTimeController controller) {
        TuxBaseTimeController bindPicker;
        TuxBaseTimeController bindPicker2;
        TuxBaseTimeController bindPicker3;
        TuxBaseTimeController bindPicker4;
        TuxBaseTimeController bindPicker5;
        TuxBaseTimeController bindPicker6;
        TuxBaseTimeController bindGlobal;
        this.controller = controller;
        if (controller == null) {
            this.controller = new TuxDateTimerController().bindPicker(0, this.mYearSpinner).bindPicker(1, this.mMonthSpinner).bindPicker(2, this.mDaySpinner).bindPicker(3, this.mHourSpinner).bindPicker(4, this.mMinuteSpinner).bindPicker(5, this.mSecondSpinner).bindGlobal(this.global).build();
            return;
        }
        if (controller != null && (bindPicker = controller.bindPicker(0, this.mYearSpinner)) != null && (bindPicker2 = bindPicker.bindPicker(1, this.mMonthSpinner)) != null && (bindPicker3 = bindPicker2.bindPicker(2, this.mDaySpinner)) != null && (bindPicker4 = bindPicker3.bindPicker(3, this.mHourSpinner)) != null && (bindPicker5 = bindPicker4.bindPicker(4, this.mMinuteSpinner)) != null && (bindPicker6 = bindPicker5.bindPicker(5, this.mSecondSpinner)) != null && (bindGlobal = bindPicker6.bindGlobal(this.global)) != null) {
            bindGlobal.build();
        }
    }

    private final void init() {
        removeAllViews();
        try {
            View.inflate(getContext(), this.layoutResId, this);
            this.mYearContainer = (LinearLayout) findViewById(R.id.f100725t_);
            this.mMonthContainer = (LinearLayout) findViewById(R.id.f100685t6);
            this.mDayContainer = (LinearLayout) findViewById(R.id.f100625t0);
            this.mHourContainer = (LinearLayout) findViewById(R.id.f100645t2);
            this.mMinuteContainer = (LinearLayout) findViewById(R.id.f100665t4);
            this.mSecondContainer = (LinearLayout) findViewById(R.id.f100705t8);
            NumberPicker numberPicker = (NumberPicker) findViewById(R.id.f100715t9);
            this.mYearSpinner = numberPicker;
            if (numberPicker == null) {
                this.mYearSpinner = (NumberPicker) findViewWithTag("tp_datetime_year");
            }
            NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.f100675t5);
            this.mMonthSpinner = numberPicker2;
            if (numberPicker2 == null) {
                this.mMonthSpinner = (NumberPicker) findViewWithTag("tp_datetime_month");
            }
            NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.f100615sz);
            this.mDaySpinner = numberPicker3;
            if (numberPicker3 == null) {
                this.mDaySpinner = (NumberPicker) findViewWithTag("tp_datetime_day");
            }
            NumberPicker numberPicker4 = (NumberPicker) findViewById(R.id.f100635t1);
            this.mHourSpinner = numberPicker4;
            if (numberPicker4 == null) {
                this.mHourSpinner = (NumberPicker) findViewWithTag("tp_datetime_hour");
            }
            NumberPicker numberPicker5 = (NumberPicker) findViewById(R.id.f100655t3);
            this.mMinuteSpinner = numberPicker5;
            if (numberPicker5 == null) {
                this.mMinuteSpinner = (NumberPicker) findViewWithTag("tp_datetime_minute");
            }
            NumberPicker numberPicker6 = (NumberPicker) findViewById(R.id.f100695t7);
            this.mSecondSpinner = numberPicker6;
            if (numberPicker6 == null) {
                this.mSecondSpinner = (NumberPicker) findViewWithTag("tp_datetime_second");
            }
            setThemeColor(this.themeColor);
            setTextSize(this.normalTextSize, this.selectTextSize);
            showLabel(this.showLabel);
            setDisplayType(this.displayType);
            setSelectedTextBold(this.selectedTextBold);
            setTextBold(this.textBold);
            setTextColor(this.textColor);
            setDividerColor(this.dividerColor);
            int screenWidthPx = TuxUIUtils.getScreenWidthPx(getContext());
            int pxToDp = TuxUIUtils.pxToDp(getContext(), (screenWidthPx - (TuxUIUtils.dpToPx(getContext(), 12) * 2)) / this.displayType.length);
            NumberPicker numberPicker7 = this.mYearSpinner;
            if (numberPicker7 != null) {
                numberPicker7.setDefaultMinWidth(pxToDp);
            }
            NumberPicker numberPicker8 = this.mMonthSpinner;
            if (numberPicker8 != null) {
                numberPicker8.setDefaultMinWidth(pxToDp);
            }
            NumberPicker numberPicker9 = this.mDaySpinner;
            if (numberPicker9 != null) {
                numberPicker9.setDefaultMinWidth(pxToDp);
            }
            NumberPicker numberPicker10 = this.mHourSpinner;
            if (numberPicker10 != null) {
                numberPicker10.setDefaultMinWidth(pxToDp);
            }
            NumberPicker numberPicker11 = this.mMinuteSpinner;
            if (numberPicker11 != null) {
                numberPicker11.setDefaultMinWidth(pxToDp);
            }
            NumberPicker numberPicker12 = this.mSecondSpinner;
            if (numberPicker12 != null) {
                numberPicker12.setDefaultMinWidth(pxToDp);
            }
            TuxBaseTimeController tuxBaseTimeController = this.controller;
            if (tuxBaseTimeController == null) {
                tuxBaseTimeController = new TuxDateTimerController();
            }
            bindController(tuxBaseTimeController);
        } catch (Exception unused) {
            throw new Exception("layoutResId is it right or not?");
        }
    }

    public static /* synthetic */ void setLabelText$default(TuxDateTimePicker tuxDateTimePicker, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tuxDateTimePicker.yearLabel;
        }
        if ((i3 & 2) != 0) {
            str2 = tuxDateTimePicker.monthLabel;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = tuxDateTimePicker.dayLabel;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = tuxDateTimePicker.hourLabel;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = tuxDateTimePicker.minLabel;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = tuxDateTimePicker.secondLabel;
        }
        tuxDateTimePicker.setLabelText(str, str7, str8, str9, str10, str6);
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public long getMillisecond() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            return tuxBaseTimeController.getMillisecond();
        }
        return 0L;
    }

    @Nullable
    public final NumberPicker getPicker(int displayType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (NumberPicker) iPatchRedirector.redirect((short) 15, (Object) this, displayType);
        }
        if (displayType != 0) {
            if (displayType != 1) {
                if (displayType != 2) {
                    if (displayType != 3) {
                        if (displayType != 4) {
                            if (displayType != 5) {
                                return null;
                            }
                            return this.mSecondSpinner;
                        }
                        return this.mMinuteSpinner;
                    }
                    return this.mHourSpinner;
                }
                return this.mDaySpinner;
            }
            return this.mMonthSpinner;
        }
        return this.mYearSpinner;
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setDefaultMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, time);
            return;
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            tuxBaseTimeController.setDefaultMillisecond(time);
        }
    }

    public final void setDisplayType(@Nullable int[] types) {
        boolean z16;
        boolean contains;
        boolean contains2;
        boolean contains3;
        boolean contains4;
        boolean contains5;
        boolean contains6;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) types);
            return;
        }
        if (types != null) {
            if (types.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.displayType = types;
                contains = ArraysKt___ArraysKt.contains(types, 0);
                if (!contains && (linearLayout6 = this.mYearContainer) != null) {
                    linearLayout6.setVisibility(8);
                }
                contains2 = ArraysKt___ArraysKt.contains(this.displayType, 1);
                if (!contains2 && (linearLayout5 = this.mMinuteContainer) != null) {
                    linearLayout5.setVisibility(8);
                }
                contains3 = ArraysKt___ArraysKt.contains(this.displayType, 2);
                if (!contains3 && (linearLayout4 = this.mDayContainer) != null) {
                    linearLayout4.setVisibility(8);
                }
                contains4 = ArraysKt___ArraysKt.contains(this.displayType, 3);
                if (!contains4 && (linearLayout3 = this.mHourContainer) != null) {
                    linearLayout3.setVisibility(8);
                }
                contains5 = ArraysKt___ArraysKt.contains(this.displayType, 4);
                if (!contains5 && (linearLayout2 = this.mMinuteContainer) != null) {
                    linearLayout2.setVisibility(8);
                }
                contains6 = ArraysKt___ArraysKt.contains(this.displayType, 5);
                if (!contains6 && (linearLayout = this.mSecondContainer) != null) {
                    linearLayout.setVisibility(8);
                }
            }
        }
    }

    public final void setDividerColor(@ColorInt int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, color);
            return;
        }
        if (color == 0) {
            return;
        }
        this.dividerColor = color;
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setDividerColor(color);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setDividerColor(color);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setDividerColor(color);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setDividerColor(color);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setDividerColor(color);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setDividerColor(color);
        }
    }

    public final void setGlobal(int global) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, global);
        } else {
            this.global = global;
            init();
        }
    }

    public final void setLabelText(@NotNull String year, @NotNull String month, @NotNull String day, @NotNull String hour, @NotNull String min, @NotNull String second) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, year, month, day, hour, min, second);
            return;
        }
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(hour, "hour");
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(second, "second");
        this.yearLabel = year;
        this.monthLabel = month;
        this.dayLabel = day;
        this.hourLabel = hour;
        this.minLabel = min;
        this.secondLabel = second;
        showLabel(this.showLabel);
    }

    public final void setLayout(int layout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, layout);
        } else {
            if (layout == 0) {
                return;
            }
            this.layoutResId = layout;
            init();
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setMaxMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, time);
            return;
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            tuxBaseTimeController.setMaxMillisecond(time);
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setMinMillisecond(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, time);
            return;
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            tuxBaseTimeController.setMinMillisecond(time);
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setOnDateTimeChangedListener(@Nullable Function1<? super Long, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) callback);
            return;
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            tuxBaseTimeController.setOnDateTimeChangedListener(callback);
        }
    }

    public final void setSelectedTextBold(boolean selectedTextBold) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, selectedTextBold);
            return;
        }
        this.selectedTextBold = selectedTextBold;
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setSelectedTextBold(selectedTextBold);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setSelectedTextBold(selectedTextBold);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setSelectedTextBold(selectedTextBold);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setSelectedTextBold(selectedTextBold);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setSelectedTextBold(selectedTextBold);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setSelectedTextBold(selectedTextBold);
        }
    }

    public final void setTextBold(boolean textBold) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, textBold);
            return;
        }
        this.textBold = textBold;
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setTextBold(textBold);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setTextBold(textBold);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setTextBold(textBold);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setTextBold(textBold);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setTextBold(textBold);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setTextBold(textBold);
        }
    }

    public final void setTextColor(@ColorInt int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, color);
            return;
        }
        if (color == 0) {
            return;
        }
        this.textColor = color;
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setTextColor(color);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setTextColor(this.textColor);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setTextColor(this.textColor);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setTextColor(this.textColor);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setTextColor(this.textColor);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setTextColor(this.textColor);
        }
    }

    public final void setTextSize(@Dimension int normal, @Dimension int select) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(normal), Integer.valueOf(select));
            return;
        }
        if (normal == 0 || select == 0) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        int dip2px = ContextExtKt.dip2px(context, select);
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        int dip2px2 = ContextExtKt.dip2px(context2, normal);
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setTextSize(dip2px2);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setTextSize(dip2px2);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setTextSize(dip2px2);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setTextSize(dip2px2);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setTextSize(dip2px2);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setTextSize(dip2px2);
        }
        NumberPicker numberPicker7 = this.mYearSpinner;
        if (numberPicker7 != null) {
            numberPicker7.setSelectedTextSize(dip2px);
        }
        NumberPicker numberPicker8 = this.mMonthSpinner;
        if (numberPicker8 != null) {
            numberPicker8.setSelectedTextSize(dip2px);
        }
        NumberPicker numberPicker9 = this.mDaySpinner;
        if (numberPicker9 != null) {
            numberPicker9.setSelectedTextSize(dip2px);
        }
        NumberPicker numberPicker10 = this.mHourSpinner;
        if (numberPicker10 != null) {
            numberPicker10.setSelectedTextSize(dip2px);
        }
        NumberPicker numberPicker11 = this.mMinuteSpinner;
        if (numberPicker11 != null) {
            numberPicker11.setSelectedTextSize(dip2px);
        }
        NumberPicker numberPicker12 = this.mSecondSpinner;
        if (numberPicker12 != null) {
            numberPicker12.setSelectedTextSize(dip2px);
        }
    }

    public final void setThemeColor(@ColorInt int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, color);
            return;
        }
        if (color == 0) {
            return;
        }
        this.themeColor = color;
        NumberPicker numberPicker = this.mYearSpinner;
        if (numberPicker != null) {
            numberPicker.setSelectedTextColor(color);
        }
        NumberPicker numberPicker2 = this.mMonthSpinner;
        if (numberPicker2 != null) {
            numberPicker2.setSelectedTextColor(this.themeColor);
        }
        NumberPicker numberPicker3 = this.mDaySpinner;
        if (numberPicker3 != null) {
            numberPicker3.setSelectedTextColor(this.themeColor);
        }
        NumberPicker numberPicker4 = this.mHourSpinner;
        if (numberPicker4 != null) {
            numberPicker4.setSelectedTextColor(this.themeColor);
        }
        NumberPicker numberPicker5 = this.mMinuteSpinner;
        if (numberPicker5 != null) {
            numberPicker5.setSelectedTextColor(this.themeColor);
        }
        NumberPicker numberPicker6 = this.mSecondSpinner;
        if (numberPicker6 != null) {
            numberPicker6.setSelectedTextColor(this.themeColor);
        }
    }

    public final void setWrapSelectorWheel(@NotNull int[] types, boolean wrapSelector) {
        List<Integer> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, types, Boolean.valueOf(wrapSelector));
            return;
        }
        Intrinsics.checkNotNullParameter(types, "types");
        mutableList = ArraysKt___ArraysKt.toMutableList(types);
        setWrapSelectorWheel(mutableList, wrapSelector);
    }

    public final void showLabel(boolean b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, b16);
            return;
        }
        this.showLabel = b16;
        if (b16) {
            NumberPicker numberPicker = this.mYearSpinner;
            if (numberPicker != null) {
                numberPicker.setLabel(this.yearLabel);
            }
            NumberPicker numberPicker2 = this.mMonthSpinner;
            if (numberPicker2 != null) {
                numberPicker2.setLabel(this.monthLabel);
            }
            NumberPicker numberPicker3 = this.mDaySpinner;
            if (numberPicker3 != null) {
                numberPicker3.setLabel(this.dayLabel);
            }
            NumberPicker numberPicker4 = this.mHourSpinner;
            if (numberPicker4 != null) {
                numberPicker4.setLabel(this.hourLabel);
            }
            NumberPicker numberPicker5 = this.mMinuteSpinner;
            if (numberPicker5 != null) {
                numberPicker5.setLabel(this.minLabel);
            }
            NumberPicker numberPicker6 = this.mSecondSpinner;
            if (numberPicker6 != null) {
                numberPicker6.setLabel(this.secondLabel);
                return;
            }
            return;
        }
        NumberPicker numberPicker7 = this.mYearSpinner;
        if (numberPicker7 != null) {
            numberPicker7.setLabel("");
        }
        NumberPicker numberPicker8 = this.mMonthSpinner;
        if (numberPicker8 != null) {
            numberPicker8.setLabel("");
        }
        NumberPicker numberPicker9 = this.mDaySpinner;
        if (numberPicker9 != null) {
            numberPicker9.setLabel("");
        }
        NumberPicker numberPicker10 = this.mHourSpinner;
        if (numberPicker10 != null) {
            numberPicker10.setLabel("");
        }
        NumberPicker numberPicker11 = this.mMinuteSpinner;
        if (numberPicker11 != null) {
            numberPicker11.setLabel("");
        }
        NumberPicker numberPicker12 = this.mSecondSpinner;
        if (numberPicker12 != null) {
            numberPicker12.setLabel("");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuxDateTimePicker(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.displayType = new int[]{0, 1, 2, 3, 4, 5};
        this.showLabel = true;
        this.yearLabel = "\u5e74";
        this.monthLabel = "\u6708";
        this.dayLabel = "\u65e5";
        this.hourLabel = "\u65f6";
        this.minLabel = "\u5206";
        this.secondLabel = "\u79d2";
        this.layoutResId = R.layout.i1n;
        this.textBold = true;
        this.selectedTextBold = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.tuxmeterqui.R.styleable.DateTimePicker);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026styleable.DateTimePicker)");
        this.showLabel = obtainStyledAttributes.getBoolean(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_showLabel, true);
        this.themeColor = obtainStyledAttributes.getColor(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_themeColor, ContextCompat.getColor(context, R.color.f156880ea));
        this.textColor = obtainStyledAttributes.getColor(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_textColor, ContextCompat.getColor(context, R.color.bcf));
        this.dividerColor = obtainStyledAttributes.getColor(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_dividerColor, ContextCompat.getColor(context, R.color.qui_common_border_standard));
        this.selectTextSize = ContextExtKt.px2dip(context, obtainStyledAttributes.getDimensionPixelSize(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_selectTextSize, ContextExtKt.dip2px(context, 0.0f)));
        this.normalTextSize = ContextExtKt.px2dip(context, obtainStyledAttributes.getDimensionPixelSize(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_normalTextSize, ContextExtKt.dip2px(context, 0.0f)));
        this.layoutResId = obtainStyledAttributes.getResourceId(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_layout, R.layout.i1n);
        this.textBold = obtainStyledAttributes.getBoolean(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_textBold, this.textBold);
        this.selectedTextBold = obtainStyledAttributes.getBoolean(com.tencent.tuxmeterqui.R.styleable.DateTimePicker_tt_selectedTextBold, this.selectedTextBold);
        obtainStyledAttributes.recycle();
        init();
    }

    public final void setWrapSelectorWheel(boolean wrapSelector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            setWrapSelectorWheel((List<Integer>) null, wrapSelector);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, wrapSelector);
        }
    }

    @Override // com.tencent.tuxmeterqui.timepicker.datetime.TuxDateTimeInterface
    public void setWrapSelectorWheel(@Nullable List<Integer> types, boolean wrapSelector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, types, Boolean.valueOf(wrapSelector));
            return;
        }
        TuxBaseTimeController tuxBaseTimeController = this.controller;
        if (tuxBaseTimeController != null) {
            tuxBaseTimeController.setWrapSelectorWheel(types, wrapSelector);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuxDateTimePicker(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.displayType = new int[]{0, 1, 2, 3, 4, 5};
        this.showLabel = true;
        this.yearLabel = "\u5e74";
        this.monthLabel = "\u6708";
        this.dayLabel = "\u65e5";
        this.hourLabel = "\u65f6";
        this.minLabel = "\u5206";
        this.secondLabel = "\u79d2";
        this.layoutResId = R.layout.i1n;
        this.textBold = true;
        this.selectedTextBold = true;
        init();
    }
}

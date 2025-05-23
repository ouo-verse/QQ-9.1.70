package com.tencent.tuxmeterqui.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDatePickerDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002\"!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010 J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0015J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog;", "Lcom/google/android/material/bottomsheet/a;", "Landroid/view/View$OnClickListener;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onStart", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Builder;", "builder", "Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Builder;", "Landroid/widget/TextView;", "tvCancel", "Landroid/widget/TextView;", "tvSubmit", "Lcom/tencent/tuxmeterqui/timepicker/TuxDateTimePicker;", "datePicker", "Lcom/tencent/tuxmeterqui/timepicker/TuxDateTimePicker;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "", "millisecond", "J", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Builder;)V", "Companion", "Builder", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class TuxDatePickerDialog extends com.google.android.material.bottomsheet.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private Builder builder;

    @Nullable
    private TuxDateTimePicker datePicker;

    @Nullable
    private BottomSheetBehavior<FrameLayout> mBehavior;
    private long millisecond;

    @Nullable
    private TextView tvCancel;

    @Nullable
    private TextView tvSubmit;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0006J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0011J\u0012\u0010:\u001a\u00020\u00002\n\u0010;\u001a\u00020\u0013\"\u00020\u0006J\u0016\u0010:\u001a\u00020\u00002\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/J\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u00020\u0006JB\u0010=\u001a\u00020\u00002\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000b2\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\u000b2\b\b\u0002\u0010C\u001a\u00020\u000bJ\u000e\u0010D\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0011J\u000e\u0010E\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0011J\u0018\u0010F\u001a\u00020\u00002\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"J\u001e\u0010H\u001a\u00020\u00002\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020#\u0018\u00010%J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0006J\u0010\u0010K\u001a\u00020\u00002\b\b\u0001\u0010*\u001a\u00020\u0006J\u000e\u0010L\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u000bJ\u0010\u0010M\u001a\u00020\u00002\b\b\u0002\u0010N\u001a\u00020\tJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\tJ\u001a\u0010O\u001a\u00020\u00002\n\u0010;\u001a\u00020\u0013\"\u00020\u00062\u0006\u0010P\u001a\u00020\tJ\u001e\u0010O\u001a\u00020\u00002\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\tJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\tR\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0012\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u0012\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R \u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020#\u0018\u00010%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u0012\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000f\u00a8\u0006T"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "assistColor", "", "chooseDateModel", "dateLabel", "", "dayLabel", "", "getDayLabel", "()Ljava/lang/String;", "setDayLabel", "(Ljava/lang/String;)V", "defaultMillisecond", "", "displayTypes", "", "dividerColor", "focusDateInfo", "hourLabel", "getHourLabel", "setHourLabel", "maxTime", "minLabel", "getMinLabel", "setMinLabel", "minTime", "monthLabel", "getMonthLabel", "setMonthLabel", "onCancelListener", "Lkotlin/Function0;", "", "onChooseListener", "Lkotlin/Function1;", "pickerLayoutResId", "secondLabel", "getSecondLabel", "setSecondLabel", "themeColor", "titleValue", "touchHideable", "wrapSelectorWheel", "wrapSelectorWheelTypes", "", "yearLabel", "getYearLabel", "setYearLabel", "build", "Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog;", "setAssistColor", "value", "setChooseDateModel", "setDefaultTime", "millisecond", "setDisplayType", "types", "setDividerColor", "setLabelText", "year", "month", "day", WidgetCacheWeatherData.HOUR, Element.ELEMENT_NAME_MIN, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "setMaxTime", "setMinTime", "setOnCancel", "listener", "setOnChoose", "setPickerLayout", "layoutResId", "setThemeColor", "setTitle", "setTouchHideAble", "touchHideAble", "setWrapSelectorWheel", "wrapSelector", "showDateLabel", "b", "showFocusDateInfo", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;

        @JvmField
        public int assistColor;

        @JvmField
        public int chooseDateModel;

        @NotNull
        private Context context;

        @JvmField
        public boolean dateLabel;

        @NotNull
        private String dayLabel;

        @JvmField
        public long defaultMillisecond;

        @JvmField
        @Nullable
        public int[] displayTypes;

        @JvmField
        public int dividerColor;

        @JvmField
        public boolean focusDateInfo;

        @NotNull
        private String hourLabel;

        @JvmField
        public long maxTime;

        @NotNull
        private String minLabel;

        @JvmField
        public long minTime;

        @NotNull
        private String monthLabel;

        @JvmField
        @Nullable
        public Function0<Unit> onCancelListener;

        @JvmField
        @Nullable
        public Function1<? super Long, Unit> onChooseListener;

        @JvmField
        public int pickerLayoutResId;

        @NotNull
        private String secondLabel;

        @JvmField
        public int themeColor;

        @JvmField
        @Nullable
        public String titleValue;

        @JvmField
        public boolean touchHideable;

        @JvmField
        public boolean wrapSelectorWheel;

        @JvmField
        @Nullable
        public List<Integer> wrapSelectorWheelTypes;

        @NotNull
        private String yearLabel;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.context = context;
            this.focusDateInfo = true;
            this.wrapSelectorWheel = true;
            this.wrapSelectorWheelTypes = new ArrayList();
            this.touchHideable = true;
            this.yearLabel = "\u5e74";
            this.monthLabel = "\u6708";
            this.dayLabel = "\u65e5";
            this.hourLabel = "\u65f6";
            this.minLabel = "\u5206";
            this.secondLabel = "\u79d2";
        }

        public static /* synthetic */ Builder setLabelText$default(Builder builder, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = builder.yearLabel;
            }
            if ((i3 & 2) != 0) {
                str2 = builder.monthLabel;
            }
            String str7 = str2;
            if ((i3 & 4) != 0) {
                str3 = builder.dayLabel;
            }
            String str8 = str3;
            if ((i3 & 8) != 0) {
                str4 = builder.hourLabel;
            }
            String str9 = str4;
            if ((i3 & 16) != 0) {
                str5 = builder.minLabel;
            }
            String str10 = str5;
            if ((i3 & 32) != 0) {
                str6 = builder.secondLabel;
            }
            return builder.setLabelText(str, str7, str8, str9, str10, str6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setOnCancel$default(Builder builder, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function0 = null;
            }
            return builder.setOnCancel(function0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setOnChoose$default(Builder builder, Function1 function1, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            return builder.setOnChoose(function1);
        }

        public static /* synthetic */ Builder setTouchHideAble$default(Builder builder, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            return builder.setTouchHideAble(z16);
        }

        @NotNull
        public final TuxDatePickerDialog build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return (TuxDatePickerDialog) iPatchRedirector.redirect((short) 34, (Object) this);
            }
            return new TuxDatePickerDialog(this.context, this);
        }

        @NotNull
        public final String getDayLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.dayLabel;
        }

        @NotNull
        public final String getHourLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.hourLabel;
        }

        @NotNull
        public final String getMinLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.minLabel;
        }

        @NotNull
        public final String getMonthLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.monthLabel;
        }

        @NotNull
        public final String getSecondLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.secondLabel;
        }

        @NotNull
        public final String getYearLabel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.yearLabel;
        }

        @NotNull
        public final Builder setAssistColor(@ColorInt int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return (Builder) iPatchRedirector.redirect((short) 32, (Object) this, value);
            }
            this.assistColor = value;
            return this;
        }

        @NotNull
        public final Builder setChooseDateModel(int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (Builder) iPatchRedirector.redirect((short) 31, (Object) this, value);
            }
            this.chooseDateModel = value;
            return this;
        }

        public final void setDayLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.dayLabel = str;
            }
        }

        @NotNull
        public final Builder setDefaultTime(long millisecond) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, millisecond);
            }
            this.defaultMillisecond = millisecond;
            return this;
        }

        @NotNull
        public final Builder setDisplayType(@NotNull int... types) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) types);
            }
            Intrinsics.checkNotNullParameter(types, "types");
            this.displayTypes = types;
            return this;
        }

        @NotNull
        public final Builder setDividerColor(@ColorInt int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (Builder) iPatchRedirector.redirect((short) 33, (Object) this, value);
            }
            this.dividerColor = value;
            return this;
        }

        public final void setHourLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.hourLabel = str;
            }
        }

        @NotNull
        public final Builder setLabelText(@NotNull String year, @NotNull String month, @NotNull String day, @NotNull String hour, @NotNull String min, @NotNull String second) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, this, year, month, day, hour, min, second);
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
            return this;
        }

        @NotNull
        public final Builder setMaxTime(long millisecond) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, millisecond);
            }
            this.maxTime = millisecond;
            return this;
        }

        public final void setMinLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.minLabel = str;
            }
        }

        @NotNull
        public final Builder setMinTime(long millisecond) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, millisecond);
            }
            this.minTime = millisecond;
            return this;
        }

        public final void setMonthLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.monthLabel = str;
            }
        }

        @NotNull
        public final Builder setOnCancel(@Nullable Function0<Unit> listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (Builder) iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
            }
            this.onCancelListener = listener;
            return this;
        }

        @NotNull
        public final Builder setOnChoose(@Nullable Function1<? super Long, Unit> listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (Builder) iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
            }
            this.onChooseListener = listener;
            return this;
        }

        @NotNull
        public final Builder setPickerLayout(int layoutResId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (Builder) iPatchRedirector.redirect((short) 29, (Object) this, layoutResId);
            }
            this.pickerLayoutResId = layoutResId;
            return this;
        }

        public final void setSecondLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.secondLabel = str;
            }
        }

        @NotNull
        public final Builder setThemeColor(@ColorInt int themeColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, themeColor);
            }
            this.themeColor = themeColor;
            return this;
        }

        @NotNull
        public final Builder setTitle(@NotNull String value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) value);
            }
            Intrinsics.checkNotNullParameter(value, "value");
            this.titleValue = value;
            return this;
        }

        @NotNull
        public final Builder setTouchHideAble(boolean touchHideAble) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (Builder) iPatchRedirector.redirect((short) 30, (Object) this, touchHideAble);
            }
            this.touchHideable = touchHideAble;
            return this;
        }

        @NotNull
        public final Builder setWrapSelectorWheel(@NotNull int[] types, boolean wrapSelector) {
            List<Integer> mutableList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, this, types, Boolean.valueOf(wrapSelector));
            }
            Intrinsics.checkNotNullParameter(types, "types");
            mutableList = ArraysKt___ArraysKt.toMutableList(types);
            return setWrapSelectorWheel(mutableList, wrapSelector);
        }

        public final void setYearLabel(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.yearLabel = str;
            }
        }

        @NotNull
        public final Builder showDateLabel(boolean b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, b16);
            }
            this.dateLabel = b16;
            return this;
        }

        @NotNull
        public final Builder showFocusDateInfo(boolean b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, b16);
            }
            this.focusDateInfo = b16;
            return this;
        }

        @NotNull
        public final Builder setDisplayType(@Nullable List<Integer> types) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) types);
            }
            this.displayTypes = types != null ? CollectionsKt___CollectionsKt.toIntArray(types) : null;
            return this;
        }

        @NotNull
        public final Builder setWrapSelectorWheel(boolean wrapSelector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? setWrapSelectorWheel((List<Integer>) null, wrapSelector) : (Builder) iPatchRedirector.redirect((short) 25, (Object) this, wrapSelector);
        }

        @NotNull
        public final Builder setWrapSelectorWheel(@Nullable List<Integer> types, boolean wrapSelector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (Builder) iPatchRedirector.redirect((short) 26, this, types, Boolean.valueOf(wrapSelector));
            }
            this.wrapSelectorWheelTypes = types;
            this.wrapSelectorWheel = wrapSelector;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Companion;", "", "()V", "builder", "Lcom/tencent/tuxmeterqui/timepicker/TuxDatePickerDialog$Builder;", "context", "Landroid/content/Context;", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Builder builder(@NotNull final Context context) {
            Lazy lazy;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Builder>(context) { // from class: com.tencent.tuxmeterqui.timepicker.TuxDatePickerDialog$Companion$builder$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TuxDatePickerDialog.Builder invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TuxDatePickerDialog.Builder(this.$context) : (TuxDatePickerDialog.Builder) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            return (Builder) lazy.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TuxDatePickerDialog(@NotNull Context context) {
        super(context, R.style.aiw);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.builder = INSTANCE.builder(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        Builder builder;
        Function0<Unit> function0;
        Function1<? super Long, Unit> function1;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            dismiss();
            int id5 = v3.getId();
            if (id5 == R.id.f164986ui1) {
                Builder builder2 = this.builder;
                if (builder2 != null && (function1 = builder2.onChooseListener) != null) {
                    function1.invoke(Long.valueOf(this.millisecond));
                }
            } else if (id5 == R.id.bjv && (builder = this.builder) != null && (function0 = builder.onCancelListener) != null) {
                function0.invoke();
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TuxDateTimePicker tuxDateTimePicker;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        setContentView(R.layout.i1m);
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) getDelegate().findViewById(R.id.ugk);
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setBackgroundColor(0);
        this.tvCancel = (TextView) findViewById(R.id.bjv);
        this.tvSubmit = (TextView) findViewById(R.id.f164986ui1);
        this.datePicker = (TuxDateTimePicker) findViewById(R.id.f164946ue0);
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
        this.mBehavior = from;
        Builder builder = this.builder;
        if (builder != null) {
            if (from != null) {
                from.setHideable(builder.touchHideable);
            }
            TuxDateTimePicker tuxDateTimePicker2 = this.datePicker;
            if (tuxDateTimePicker2 != null) {
                tuxDateTimePicker2.setLayout(builder.pickerLayoutResId);
            }
            TuxDateTimePicker tuxDateTimePicker3 = this.datePicker;
            if (tuxDateTimePicker3 != null) {
                tuxDateTimePicker3.showLabel(builder.dateLabel);
            }
            TuxDateTimePicker tuxDateTimePicker4 = this.datePicker;
            if (tuxDateTimePicker4 != null) {
                tuxDateTimePicker4.setLabelText(builder.getYearLabel(), builder.getMonthLabel(), builder.getDayLabel(), builder.getHourLabel(), builder.getMinLabel(), builder.getSecondLabel());
            }
            if (builder.displayTypes == null) {
                builder.displayTypes = new int[]{0, 1, 2, 3, 4, 5};
            }
            TuxDateTimePicker tuxDateTimePicker5 = this.datePicker;
            if (tuxDateTimePicker5 != null) {
                tuxDateTimePicker5.setDisplayType(builder.displayTypes);
            }
            TuxDateTimePicker tuxDateTimePicker6 = this.datePicker;
            if (tuxDateTimePicker6 != null) {
                tuxDateTimePicker6.setGlobal(1);
            }
            TuxDateTimePicker tuxDateTimePicker7 = this.datePicker;
            if (tuxDateTimePicker7 != null) {
                tuxDateTimePicker7.setMinMillisecond(builder.minTime);
            }
            TuxDateTimePicker tuxDateTimePicker8 = this.datePicker;
            if (tuxDateTimePicker8 != null) {
                tuxDateTimePicker8.setMaxMillisecond(builder.maxTime);
            }
            TuxDateTimePicker tuxDateTimePicker9 = this.datePicker;
            if (tuxDateTimePicker9 != null) {
                tuxDateTimePicker9.setDefaultMillisecond(builder.defaultMillisecond);
            }
            TuxDateTimePicker tuxDateTimePicker10 = this.datePicker;
            if (tuxDateTimePicker10 != null) {
                tuxDateTimePicker10.setWrapSelectorWheel(builder.wrapSelectorWheelTypes, builder.wrapSelectorWheel);
            }
            TuxDateTimePicker tuxDateTimePicker11 = this.datePicker;
            if (tuxDateTimePicker11 != null) {
                tuxDateTimePicker11.setTextSize(13, 15);
            }
            int i3 = builder.themeColor;
            if (i3 != 0) {
                TuxDateTimePicker tuxDateTimePicker12 = this.datePicker;
                if (tuxDateTimePicker12 != null) {
                    tuxDateTimePicker12.setThemeColor(i3);
                }
                TextView textView = this.tvSubmit;
                if (textView != null) {
                    textView.setTextColor(builder.themeColor);
                }
            }
            int i16 = builder.assistColor;
            if (i16 != 0) {
                TextView textView2 = this.tvCancel;
                if (textView2 != null) {
                    textView2.setTextColor(i16);
                }
                TuxDateTimePicker tuxDateTimePicker13 = this.datePicker;
                if (tuxDateTimePicker13 != null) {
                    tuxDateTimePicker13.setTextColor(builder.assistColor);
                }
            }
            int i17 = builder.dividerColor;
            if (i17 != 0 && (tuxDateTimePicker = this.datePicker) != null) {
                tuxDateTimePicker.setDividerColor(i17);
            }
        }
        TextView textView3 = this.tvCancel;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        TextView textView4 = this.tvSubmit;
        if (textView4 != null) {
            textView4.setOnClickListener(this);
        }
        TuxDateTimePicker tuxDateTimePicker14 = this.datePicker;
        if (tuxDateTimePicker14 != null) {
            tuxDateTimePicker14.setOnDateTimeChangedListener(new Function1<Long, Unit>() { // from class: com.tencent.tuxmeterqui.timepicker.TuxDatePickerDialog$onCreate$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxDatePickerDialog.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    TuxDatePickerDialog.this.millisecond = j3;
                    Calendar calendar = Calendar.getInstance();
                    calendar.clear();
                    calendar.setTimeInMillis(j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TuxDatePickerDialog(@NotNull Context context, @NotNull Builder builder) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.builder = builder;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) builder);
        }
    }
}

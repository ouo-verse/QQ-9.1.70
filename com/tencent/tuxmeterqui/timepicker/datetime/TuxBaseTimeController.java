package com.tencent.tuxmeterqui.timepicker.datetime;

import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.timepicker.TuxCalendarExtKt;
import com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0000H&J!\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0004\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxBaseTimeController;", "Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxDateTimeInterface;", "()V", "bindGlobal", ReadInJoyMMapKvStorage.NAME_DEFAULT, "", "bindPicker", "type", "picker", "Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker;", "build", "getMaxDayInMonth", "year", "month", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class TuxBaseTimeController implements TuxDateTimeInterface {
    static IPatchRedirector $redirector_;

    public TuxBaseTimeController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public abstract TuxBaseTimeController bindGlobal(int global);

    @NotNull
    public abstract TuxBaseTimeController bindPicker(int type, @Nullable NumberPicker picker);

    @NotNull
    public abstract TuxBaseTimeController build();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMaxDayInMonth(@Nullable Integer year, @Nullable Integer month) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) year, (Object) month)).intValue();
        }
        if (year != null && month != null && year.intValue() > 0 && month.intValue() >= 0) {
            try {
                Calendar calendar = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
                calendar.clear();
                calendar.set(1, year.intValue());
                calendar.set(2, month.intValue());
                return TuxCalendarExtKt.getMaxDayInMonth(calendar);
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}

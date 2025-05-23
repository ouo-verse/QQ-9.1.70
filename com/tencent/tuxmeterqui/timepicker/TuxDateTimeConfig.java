package com.tencent.tuxmeterqui.timepicker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/TuxDateTimeConfig;", "", "()V", "DATE_DEFAULT", "", "DATE_LUNAR", "DAY", "GLOBAL_CHINA", "GLOBAL_LOCAL", "HOUR", "MIN", "MONTH", "SECOND", "YEAR", "formatter", "Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker$Formatter;", "getFormatter", "()Lcom/tencent/tuxmeterqui/timepicker/number_picker/NumberPicker$Formatter;", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TuxDateTimeConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DATE_DEFAULT = 0;
    public static final int DATE_LUNAR = 1;
    public static final int DAY = 2;
    public static final int GLOBAL_CHINA = 1;
    public static final int GLOBAL_LOCAL = 0;
    public static final int HOUR = 3;

    @NotNull
    public static final TuxDateTimeConfig INSTANCE;
    public static final int MIN = 4;
    public static final int MONTH = 1;
    public static final int SECOND = 5;
    public static final int YEAR = 0;

    @NotNull
    private static final NumberPicker.Formatter formatter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new TuxDateTimeConfig();
            formatter = new NumberPicker.Formatter() { // from class: com.tencent.tuxmeterqui.timepicker.b
                @Override // com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker.Formatter
                public final String format(int i3) {
                    String formatter$lambda$0;
                    formatter$lambda$0 = TuxDateTimeConfig.formatter$lambda$0(i3);
                    return formatter$lambda$0;
                }
            };
        }
    }

    TuxDateTimeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatter$lambda$0(int i3) {
        String valueOf = String.valueOf(i3);
        if (i3 < 10) {
            return '0' + valueOf;
        }
        return valueOf;
    }

    @NotNull
    public final NumberPicker.Formatter getFormatter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NumberPicker.Formatter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return formatter;
    }
}

package com.tencent.bugly.common.looper;

import android.util.Printer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/bugly/common/looper/LooperPrinter;", "Landroid/util/Printer;", TtmlNode.ATTR_TTS_ORIGIN, "dispatch", "Lcom/tencent/bugly/common/looper/LooperPrinter$IDispatch;", "(Landroid/util/Printer;Lcom/tencent/bugly/common/looper/LooperPrinter$IDispatch;)V", "isHasChecked", "", AppConstants.Key.COLUMN_IS_VALID, "getOrigin", "()Landroid/util/Printer;", "println", "", HippyTKDListViewAdapter.X, "", "Companion", "IDispatch", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class LooperPrinter implements Printer {
    private static final String START_PREFIX = ">>";
    private static final String STOP_PREFIX = "<<";
    private static final String TAG = "RMonitor_looper_Printer";
    private final IDispatch dispatch;
    private boolean isHasChecked;
    private boolean isValid;

    @Nullable
    private final Printer origin;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/bugly/common/looper/LooperPrinter$IDispatch;", "", "checkValid", "", "printer", "Landroid/util/Printer;", "dispatch", "", "isBegin", "log", "", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public interface IDispatch {
        boolean checkValid(@NotNull Printer printer);

        void dispatch(boolean isBegin, @NotNull String log);
    }

    public LooperPrinter(@Nullable Printer printer, @NotNull IDispatch dispatch) {
        Intrinsics.checkParameterIsNotNull(dispatch, "dispatch");
        this.origin = printer;
        this.dispatch = dispatch;
    }

    @Nullable
    public final Printer getOrigin() {
        return this.origin;
    }

    @Override // android.util.Printer
    public void println(@NotNull String x16) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean z16;
        boolean startsWith$default3;
        Intrinsics.checkParameterIsNotNull(x16, "x");
        Printer printer = this.origin;
        if (printer != null && printer != this && !(printer instanceof LooperPrinter)) {
            printer.println(x16);
        }
        if (!this.dispatch.checkValid(this)) {
            return;
        }
        if (!this.isHasChecked) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(x16, ">>", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(x16, "<<", false, 2, null);
                if (!startsWith$default3) {
                    z16 = false;
                    this.isValid = z16;
                    this.isHasChecked = true;
                    if (!z16 && Logger.debug) {
                        Logger.f365497g.d("RMonitor_looper_Printer [println] Printer is inValid! x: " + x16);
                    }
                }
            }
            z16 = true;
            this.isValid = z16;
            this.isHasChecked = true;
            if (!z16) {
                Logger.f365497g.d("RMonitor_looper_Printer [println] Printer is inValid! x: " + x16);
            }
        }
        if (this.isValid) {
            IDispatch iDispatch = this.dispatch;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(x16, ">>", false, 2, null);
            iDispatch.dispatch(startsWith$default, x16);
        }
    }
}

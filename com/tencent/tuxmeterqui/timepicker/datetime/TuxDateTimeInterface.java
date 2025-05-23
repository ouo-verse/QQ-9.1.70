package com.tencent.tuxmeterqui.timepicker.datetime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH&J$\u0010\f\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tuxmeterqui/timepicker/datetime/TuxDateTimeInterface;", "", "getMillisecond", "", "setDefaultMillisecond", "", "time", "setMaxMillisecond", "setMinMillisecond", "setOnDateTimeChangedListener", "callback", "Lkotlin/Function1;", "setWrapSelectorWheel", "types", "", "", "wrapSelector", "", "tuxmeterQUI_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface TuxDateTimeInterface {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setOnDateTimeChangedListener$default(TuxDateTimeInterface tuxDateTimeInterface, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function1 = null;
                }
                tuxDateTimeInterface.setOnDateTimeChangedListener(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnDateTimeChangedListener");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setWrapSelectorWheel$default(TuxDateTimeInterface tuxDateTimeInterface, List list, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    list = null;
                }
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                tuxDateTimeInterface.setWrapSelectorWheel(list, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWrapSelectorWheel");
        }
    }

    long getMillisecond();

    void setDefaultMillisecond(long time);

    void setMaxMillisecond(long time);

    void setMinMillisecond(long time);

    void setOnDateTimeChangedListener(@Nullable Function1<? super Long, Unit> callback);

    void setWrapSelectorWheel(@Nullable List<Integer> types, boolean wrapSelector);
}

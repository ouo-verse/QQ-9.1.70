package com.tencent.richframework.thread.defend;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/thread/defend/RFWConfigExceptionDefender;", "Lcom/tencent/richframework/thread/defend/IExceptionDefender;", "()V", "canDefendException", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "throwable", "", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWConfigExceptionDefender implements IExceptionDefender {
    @Override // com.tencent.richframework.thread.defend.IExceptionDefender
    public boolean canDefendException(@NotNull Thread thread, @NotNull Throwable throwable) {
        boolean z16;
        String message;
        boolean contains$default;
        boolean z17;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator<DefenderRule> it = ExceptionDefenderConfigManager.INSTANCE.getConfig().getDefenderRule().iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            DefenderRule next = it.next();
            if (next.getThreadName().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String name = thread.getName();
                Intrinsics.checkNotNullExpressionValue(name, "thread.name");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) next.getThreadName(), false, 2, (Object) null);
                if (!contains$default2) {
                    continue;
                }
            }
            if (throwable.getClass().getName().equals(next.getExceptionClassName()) && (message = throwable.getMessage()) != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) next.getExceptionMessage(), false, 2, (Object) null);
                if (contains$default) {
                    if (next.getMajorStackClassName().length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return true;
                    }
                    for (StackTraceElement stackElement : throwable.getStackTrace()) {
                        Intrinsics.checkNotNullExpressionValue(stackElement, "stackElement");
                        if (stackElement.getClassName().equals(next.getMajorStackClassName())) {
                            return true;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }
}

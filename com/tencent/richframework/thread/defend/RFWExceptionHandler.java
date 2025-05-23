package com.tencent.richframework.thread.defend;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/thread/defend/RFWExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "()V", "delegateHandler", "uncaughtException", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "throwable", "", "Companion", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final List<IExceptionDefender> exceptionDefenders;

    @NotNull
    private static final Handler handler;
    private Thread.UncaughtExceptionHandler delegateHandler = Thread.getDefaultUncaughtExceptionHandler();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/thread/defend/RFWExceptionHandler$Companion;", "", "", "Lcom/tencent/richframework/thread/defend/IExceptionDefender;", "collectExceptionDefenders", "()[Lcom/tencent/richframework/thread/defend/IExceptionDefender;", "exceptionDefender", "", "registerExceptionDefender", "", "TAG", "Ljava/lang/String;", "", "exceptionDefenders", "Ljava/util/List;", "<init>", "()V", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IExceptionDefender[] collectExceptionDefenders() {
            IExceptionDefender[] iExceptionDefenderArr;
            synchronized (RFWExceptionHandler.exceptionDefenders) {
                if (RFWExceptionHandler.exceptionDefenders.size() > 0) {
                    Object[] array = RFWExceptionHandler.exceptionDefenders.toArray(new IExceptionDefender[0]);
                    if (array != null) {
                        iExceptionDefenderArr = (IExceptionDefender[]) array;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    iExceptionDefenderArr = null;
                }
                Unit unit = Unit.INSTANCE;
            }
            return iExceptionDefenderArr;
        }

        public final void registerExceptionDefender(@NotNull IExceptionDefender exceptionDefender) {
            Intrinsics.checkNotNullParameter(exceptionDefender, "exceptionDefender");
            synchronized (RFWExceptionHandler.exceptionDefenders) {
                RFWExceptionHandler.exceptionDefenders.add(exceptionDefender);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ArrayList arrayListOf;
        Handler handler2 = new Handler(Looper.getMainLooper());
        handler = handler2;
        ExceptionDefenderConfigManager exceptionDefenderConfigManager = ExceptionDefenderConfigManager.INSTANCE;
        if (exceptionDefenderConfigManager.getConfig().getDelegateDefault()) {
            handler2.postDelayed(new Runnable() { // from class: com.tencent.richframework.thread.defend.RFWExceptionHandler.Companion.1
                @Override // java.lang.Runnable
                public final void run() {
                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    RFWExceptionHandler rFWExceptionHandler = new RFWExceptionHandler();
                    rFWExceptionHandler.delegateHandler = defaultUncaughtExceptionHandler;
                    Thread.setDefaultUncaughtExceptionHandler(rFWExceptionHandler);
                }
            }, exceptionDefenderConfigManager.getConfig().getDelegateDefaultPostTime());
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new RFWConfigExceptionDefender());
        exceptionDefenders = arrayListOf;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NotNull Thread thread, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            IExceptionDefender[] collectExceptionDefenders = INSTANCE.collectExceptionDefenders();
            if (collectExceptionDefenders != null) {
                for (IExceptionDefender iExceptionDefender : collectExceptionDefenders) {
                    if (iExceptionDefender.canDefendException(thread, throwable)) {
                        RFWLog.e("RFWExceptionDefender", RFWLog.USR, "thread:" + thread.getName(), throwable);
                        if (Looper.myLooper() != null) {
                            Looper.loop();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Exception e16) {
            RFWLog.e("RFWExceptionDefender", RFWLog.USR, e16);
        }
        RFWLog.e("RFWExceptionDefender", RFWLog.USR, "delegateHandler");
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.delegateHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }
}

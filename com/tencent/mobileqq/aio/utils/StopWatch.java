package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001f\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u0019\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/utils/StopWatch;", "", "", "event", tl.h.F, "", "nanoSecond", "f", "decimal", "a", "i", "", "g", "e", "b", "Lkotlin/Function0;", "j", "Ljava/lang/String;", "tag", "", "Z", NodeProps.ENABLED, "c", "J", "startTime", "d", "prevTime", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/Lazy;", "()Ljava/lang/StringBuilder;", "logString", "<init>", "(Ljava/lang/String;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class StopWatch {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean enabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long prevTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy logString;

    public StopWatch(@NotNull String tag, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tag, Boolean.valueOf(z16));
            return;
        }
        this.tag = tag;
        this.enabled = z16;
        lazy = LazyKt__LazyJVMKt.lazy(StopWatch$logString$2.INSTANCE);
        this.logString = lazy;
    }

    private final String a(long decimal) {
        if (decimal < 10) {
            return "00" + decimal;
        }
        if (decimal < 100) {
            return "0" + decimal;
        }
        if (decimal < 1000) {
            return String.valueOf(decimal);
        }
        return "error";
    }

    public static /* synthetic */ void c(StopWatch stopWatch, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        stopWatch.b(str);
    }

    private final StringBuilder d() {
        return (StringBuilder) this.logString.getValue();
    }

    private final String f(long nanoSecond) {
        long j3 = nanoSecond / 1000;
        return (j3 / 1000) + "." + a(j3 % 1000);
    }

    private final String h(String event) {
        long nanoTime = System.nanoTime();
        String f16 = f(nanoTime - this.prevTime);
        String f17 = f(nanoTime - this.startTime);
        this.prevTime = nanoTime;
        return event + MsgSummary.STR_COLON + f16 + " (" + f17 + ")";
    }

    public final void b(@NotNull String event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enabled) {
            e(event);
            String f16 = f(System.nanoTime() - this.startTime);
            String str = this.tag + "-total: " + f16 + " ms\n" + ((Object) d());
            if (QLog.isColorLevel()) {
                QLog.i(this.tag, 2, str);
            }
        }
        StringsKt__StringBuilderJVMKt.clear(d());
    }

    public final void e(@NotNull String event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enabled) {
            StringBuilder d16 = d();
            d16.append("  ");
            d16.append(h(event));
            d16.append('\n');
        }
    }

    public final void g(@NotNull String event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enabled) {
            QLog.i(this.tag, 1, h(event));
        }
    }

    @NotNull
    public final StopWatch i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StopWatch) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long nanoTime = System.nanoTime();
        this.startTime = nanoTime;
        this.prevTime = nanoTime;
        StringsKt__StringBuilderJVMKt.clear(d());
        return this;
    }

    public final void j(@NotNull Function0<Unit> event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        i();
        event.invoke();
        g("total");
    }

    public /* synthetic */ StopWatch(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

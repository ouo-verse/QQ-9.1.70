package com.tencent.mobileqq.qcoroutine.api;

import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001BE\u0012,\u0010\u0014\u001a(\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\u0002\b\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&R=\u0010\u0014\u001a(\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\u0002\b\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/c;", "", "Landroid/os/Message;", "msg", "", "delay", "", "f", "e", "", "what", "d", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "a", "Lkotlin/jvm/functions/Function2;", "b", "()Lkotlin/jvm/functions/Function2;", "handleMessage", "", "Ljava/lang/String;", "()Ljava/lang/String;", "groupId", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "c", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "()Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "<init>", "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<c, Message, Unit> handleMessage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i type;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function2<? super c, ? super Message, Unit> handleMessage, @NotNull String groupId, @NotNull i type) {
        Intrinsics.checkNotNullParameter(handleMessage, "handleMessage");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, handleMessage, groupId, type);
            return;
        }
        this.handleMessage = handleMessage;
        this.groupId = groupId;
        this.type = type;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupId;
    }

    @NotNull
    public final Function2<c, Message, Unit> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Function2) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.handleMessage;
    }

    @NotNull
    public final i c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    public abstract void d(int what);

    public abstract void e(@NotNull Message msg2);

    public abstract void f(@NotNull Message msg2, long delay);
}

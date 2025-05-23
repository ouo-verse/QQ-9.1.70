package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qcoroutine.api.d;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.ThemeConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/a;", "Lcom/tencent/mobileqq/qcoroutine/api/d;", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/RunnableType;", "g", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/RunnableType;", "j", "()Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/RunnableType;", "runnableType", "", ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, "Lcom/tencent/mobileqq/qcoroutine/api/i;", "_type", "Lcom/tencent/mobileqq/qcoroutine/api/a;", "_callback", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/RunnableType;Lcom/tencent/mobileqq/qcoroutine/api/a;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RunnableType runnableType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String _name, @NotNull i _type, @NotNull RunnableType runnableType, @Nullable com.tencent.mobileqq.qcoroutine.api.a aVar) {
        super(_name, _type, false, 4, null);
        Intrinsics.checkNotNullParameter(_name, "_name");
        Intrinsics.checkNotNullParameter(_type, "_type");
        Intrinsics.checkNotNullParameter(runnableType, "runnableType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.runnableType = runnableType;
        } else {
            iPatchRedirector.redirect((short) 2, this, _name, _type, runnableType, aVar);
        }
    }

    @NotNull
    public final RunnableType j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RunnableType) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.runnableType;
    }

    public /* synthetic */ a(String str, i iVar, RunnableType runnableType, com.tencent.mobileqq.qcoroutine.api.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iVar, runnableType, (i3 & 8) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, iVar, runnableType, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

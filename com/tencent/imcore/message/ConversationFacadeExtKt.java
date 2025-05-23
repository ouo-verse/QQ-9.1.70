package com.tencent.imcore.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a)\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0003H\u0002\"\u001b\u0010\n\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u001b\u0010\r\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/imcore/message/k;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "ext", "f", "a", "Lkotlin/Lazy;", "d", "()Lcom/tencent/imcore/message/k;", "toggleInterceptCalculateMsgBoxConfig", "b", "e", "toggleRawQuaryConfig", "IMCore_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ConversationFacadeExtKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f116417a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f116418b;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34004);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ConversationFacadeExtKt$toggleInterceptCalculateMsgBoxConfig$2.INSTANCE);
            f116417a = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(ConversationFacadeExtKt$toggleRawQuaryConfig$2.INSTANCE);
            f116418b = lazy2;
            return;
        }
        redirector.redirect((short) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k d() {
        return (k) f116417a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k e() {
        return (k) f116418b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k f(k kVar, Function1<? super k, String> function1) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("config[");
        sb5.append(kVar.b());
        sb5.append("]-> isOpen ");
        sb5.append(kVar.e());
        sb5.append(" ext ");
        if (function1 != null) {
            str = function1.invoke(kVar);
        } else {
            str = null;
        }
        sb5.append(str);
        QLog.d("ConversationFacadeExt", 1, sb5.toString());
        return kVar;
    }
}

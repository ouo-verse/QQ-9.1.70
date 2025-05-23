package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/QMMKVSplitHelper;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "kv", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QMMKVSplitHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QMMKVSplitHelper f194966a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy kv;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f194966a = new QMMKVSplitHelper();
        lazy = LazyKt__LazyJVMKt.lazy(QMMKVSplitHelper$kv$2.INSTANCE);
        kv = lazy;
    }

    QMMKVSplitHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final MMKVOptionEntity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MMKVOptionEntity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (MMKVOptionEntity) kv.getValue();
    }
}

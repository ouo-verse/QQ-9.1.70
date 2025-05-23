package com.tencent.qqnt.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R;\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\b0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u000eR-\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\b8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/push/TroopPushCMD;", "", "Lcom/tencent/qqnt/push/processor/a;", "b", "Lkotlin/Lazy;", "d", "()Lcom/tencent/qqnt/push/processor/a;", "troop0x2dcCommonProcessor", "", "", "", "Lkotlin/Lazy;", "Lcom/tencent/qqnt/push/a;", "c", "()Ljava/util/Map;", "pushCmd", "Lcom/tencent/qqnt/push/b;", "troop0x10Map", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class TroopPushCMD {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopPushCMD f360703a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy troop0x2dcCommonProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy pushCmd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy troop0x10Map;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f360703a = new TroopPushCMD();
        lazy = LazyKt__LazyJVMKt.lazy(TroopPushCMD$troop0x2dcCommonProcessor$2.INSTANCE);
        troop0x2dcCommonProcessor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopPushCMD$pushCmd$2.INSTANCE);
        pushCmd = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(TroopPushCMD$troop0x10Map$2.INSTANCE);
        troop0x10Map = lazy3;
    }

    TroopPushCMD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.push.processor.a d() {
        return (com.tencent.qqnt.push.processor.a) troop0x2dcCommonProcessor.getValue();
    }

    @NotNull
    public final Map<Integer, Map<Long, Lazy<a>>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (Map) pushCmd.getValue();
    }

    @NotNull
    public final Map<Integer, Lazy<b>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (Map) troop0x10Map.getValue();
    }
}

package com.tencent.mobileqq.pskey.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd2.a;
import sd2.b;

@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000b\u0010\nJ'\u0010\f\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\f\u0010\nJ'\u0010\r\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\r\u0010\nJ\b\u0010\u000e\u001a\u00020\bH&J-\u0010\u0011\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H'\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0019\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\bH&J\b\u0010\u001b\u001a\u00020\bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "Lmqq/app/api/IRuntimeService;", "Lmqq/manager/TicketManager$IPskeyManager;", "", "", "domains", "Lsd2/a;", "callback", "", "getPskey", "([Ljava/lang/String;Lsd2/a;)V", "getUskey", "replacePskey", "replaceUskey", "updateAllPskeyAndUskey", "", "keyType", "getPskeyFromRequest", "([Ljava/lang/String;ILsd2/a;)V", "clearLocalPskey", "([Ljava/lang/String;)V", "Lsd2/b;", "listener", "registerPskeyListener", "unregisterPskeyListener", "attackUpdatePskey", "onNTKernelSessionCreated", "onAppDestory", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface IPskeyManager extends IRuntimeService, TicketManager.IPskeyManager {
    void attackUpdatePskey();

    void clearLocalPskey(@Nullable String[] domains);

    void getPskey(@NotNull String[] domains, @NotNull a callback);

    @Deprecated(message = "\u4ec5\u4f9b\u5185\u90e8\u8c03\u7528\u4f7f\u7528\uff0c\u4e1a\u52a1\u8bf7\u4f7f\u7528getPskey")
    void getPskeyFromRequest(@NotNull String[] domains, int keyType, @NotNull a callback);

    void getUskey(@NotNull String[] domains, @NotNull a callback);

    void onAppDestory();

    void onNTKernelSessionCreated();

    void registerPskeyListener(@Nullable b listener);

    void replacePskey(@Nullable String[] domains, @NotNull a callback);

    void replaceUskey(@Nullable String[] domains, @NotNull a callback);

    void unregisterPskeyListener(@Nullable b listener);

    void updateAllPskeyAndUskey();
}

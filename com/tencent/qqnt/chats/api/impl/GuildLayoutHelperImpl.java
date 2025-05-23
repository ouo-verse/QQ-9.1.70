package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IGuildLayoutHelper;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/GuildLayoutHelperImpl;", "Lcom/tencent/qqnt/chats/api/IGuildLayoutHelper;", "()V", "lastStatus", "", "setGuildDisplayStatus", "", "status", "guildId", "", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class GuildLayoutHelperImpl implements IGuildLayoutHelper {
    static IPatchRedirector $redirector_;
    private long lastStatus;

    public GuildLayoutHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lastStatus = -1L;
        }
    }

    @Override // com.tencent.qqnt.chats.api.IGuildLayoutHelper
    public void setGuildDisplayStatus(long status, @Nullable String guildId) {
        IKernelService iKernelService;
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(status), guildId);
            return;
        }
        if (this.lastStatus != status) {
            this.lastStatus = status;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (recentContactService = iKernelService.getRecentContactService()) != null) {
                recentContactService.setGuildDisplayStatus(status, guildId);
            }
        }
    }
}

package com.tencent.mobileqq.channel.node.unread;

import com.tencent.mobileqq.guild.GuildChatUtils;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/channel/node/unread/ChannelRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase$a;", "params", "", "interestedIn", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelRedDotDragUseCase extends IRedDotDragUseCase {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChannelRedDotDragUseCase";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/channel/node/unread/ChannelRedDotDragUseCase$Companion;", "", "()V", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelRedDotDragUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    public boolean interestedIn(@NotNull IRedDotDragUseCase.a params) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        b a16 = params.a();
        if (a16 instanceof g) {
            gVar = (g) a16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(@NotNull IRedDotDragUseCase.a params) {
        g gVar;
        RecentContactInfo s16;
        GuildContactInfo guildContactInfo;
        boolean z16;
        boolean z17;
        List<String> listOf;
        AppRuntime peekAppRuntime;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        b a16 = params.a();
        IRuntimeService iRuntimeService = null;
        if (a16 instanceof g) {
            gVar = (g) a16;
        } else {
            gVar = null;
        }
        if (gVar != null && (s16 = gVar.s()) != null && (guildContactInfo = s16.guildContactInfo) != null) {
            String str = guildContactInfo.guildId;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = guildContactInfo.channelId;
                if (str2 != null && str2.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    z17 = true;
                    if (!z17) {
                        guildContactInfo = null;
                    }
                    if (guildContactInfo != null) {
                        GuildChatUtils guildChatUtils = GuildChatUtils.f213838a;
                        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                            iRuntimeService = peekAppRuntime.getRuntimeService(IGuildUnreadService.class, "");
                        }
                        IGuildUnreadService iGuildUnreadService = (IGuildUnreadService) iRuntimeService;
                        if (iGuildUnreadService != null) {
                            String str3 = guildContactInfo.guildId;
                            Intrinsics.checkNotNullExpressionValue(str3, "it.guildId");
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(guildContactInfo.channelId);
                            iGuildUnreadService.setChannelRead(str3, listOf, false);
                        }
                    }
                }
            }
            z17 = false;
            if (!z17) {
            }
            if (guildContactInfo != null) {
            }
        }
        return true;
    }
}

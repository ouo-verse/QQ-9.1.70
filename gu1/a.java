package gu1;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgAdapter;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lgu1/a;", "", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessage", "c", "", "e", "lastMessageNew", "", "d", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "b", "getChannelId", "channelId", "Z", "()Z", "isDirect", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "()Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "setLastMessage", "(Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isDirect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LastMessage lastMessage;

    public a(@NotNull String guildId, @NotNull String channelId, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.isDirect = z16;
    }

    private final LastMessage c(LastMessage lastMessage) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        String str;
        LastMessage a16;
        if (!at.c()) {
            return lastMessage;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str2 = iGPSService.getGuildUserDisplayNameInternal(lastMessage.getGuildId(), lastMessage.getSenderUin());
        }
        boolean z17 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str2 = lastMessage.getSenderNickname();
        }
        if (str2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            str2 = HardCodeUtil.qqStr(R.string.f143020ky);
        }
        if (Intrinsics.areEqual(str2, lastMessage.getSenderNickname())) {
            return lastMessage;
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        a16 = lastMessage.a((r24 & 1) != 0 ? lastMessage.guildId : null, (r24 & 2) != 0 ? lastMessage.channelId : null, (r24 & 4) != 0 ? lastMessage.type : 0, (r24 & 8) != 0 ? lastMessage.subType : null, (r24 & 16) != 0 ? lastMessage.senderUin : null, (r24 & 32) != 0 ? lastMessage.senderNickname : str, (r24 & 64) != 0 ? lastMessage.content : null, (r24 & 128) != 0 ? lastMessage.sendState : null, (r24 & 256) != 0 ? lastMessage.time : 0L, (r24 & 512) != 0 ? lastMessage.customData : null);
        return a16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final LastMessage getLastMessage() {
        return this.lastMessage;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDirect() {
        return this.isDirect;
    }

    public final boolean d(@NotNull LastMessage lastMessageNew) {
        Intrinsics.checkNotNullParameter(lastMessageNew, "lastMessageNew");
        if (!this.isDirect) {
            lastMessageNew = c(lastMessageNew);
        }
        if (Intrinsics.areEqual(lastMessageNew, this.lastMessage)) {
            return false;
        }
        this.lastMessage = lastMessageNew;
        return true;
    }

    public final void e() {
        ArrayList<String> arrayListOf;
        GuildLastMsgAdapter guildLastMsgAdapter = GuildLastMsgAdapter.f230618a;
        String str = this.guildId;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.channelId);
        guildLastMsgAdapter.m(str, arrayListOf);
    }
}

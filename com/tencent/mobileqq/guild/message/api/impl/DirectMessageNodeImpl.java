package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/message/api/impl/DirectMessageNodeImpl;", "Lcom/tencent/mobileqq/guild/message/api/IDirectMessageNode;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "node", "", "getPeerName", "curFriendUin", "getSrcGuildName", "getSrcGuildId", "getSrcTinyId", "", "isDisturb", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getDisplayName", "getRemarkName", "", "getChannelUnreadCnt", "", "guildId", "isCurGuild", "getGuildPeerName", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "", "addObserver", "removeObserver", "findResourceGuildIdByGuildId", "getMessageSourceGuildIdByGuildId", "isDirectMessageNodeNotNull", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DirectMessageNodeImpl implements IDirectMessageNode {
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getPeerName(DirectMessageNode node) {
        boolean z16;
        boolean isBlank;
        String remarkName = node.getSource().getRemarkName();
        String nickName = node.getSource().getNickName();
        if (remarkName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(remarkName);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return nickName;
                }
                return remarkName;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    public void addObserver(@NotNull GPServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(observer);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String findResourceGuildIdByGuildId(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return DirectMessageNodeRepository.F(guildId);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    public int getChannelUnreadCnt(@NotNull String curFriendUin) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C != null) {
            return C.b();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getDisplayName(@NotNull String curFriendUin) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C == null) {
            return "";
        }
        return ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName(C.getSource().getGuildId(), C.getSource().getTinyId());
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @NotNull
    public String getGuildPeerName(@NotNull Object node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!(node instanceof DirectMessageNode)) {
            return "";
        }
        DirectMessageNode directMessageNode = (DirectMessageNode) node;
        String guildUserDisplayName = ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName(directMessageNode.getSource().getGuildId(), directMessageNode.getSource().getTinyId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "runtimeService(IGPSServi\u2026ldId, node.source.tinyId)");
        return guildUserDisplayName;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getMessageSourceGuildIdByGuildId(@NotNull String guildId) {
        MessageSource source;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        DirectMessageNode D = DirectMessageNodeRepository.D(guildId);
        if (D != null && (source = D.getSource()) != null) {
            return source.getGuildId();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getRemarkName(@NotNull String curFriendUin) {
        MessageSource source;
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C != null && (source = C.getSource()) != null) {
            return source.getRemarkName();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getSrcGuildId(@NotNull String curFriendUin) {
        MessageSource source;
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C != null && (source = C.getSource()) != null) {
            return source.getGuildId();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getSrcGuildName(@NotNull String curFriendUin) {
        MessageSource source;
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C != null && (source = C.getSource()) != null) {
            return source.getGuildName();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public String getSrcTinyId(@NotNull String curFriendUin) {
        MessageSource source;
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        if (C != null && (source = C.getSource()) != null) {
            return source.getTinyId();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    public boolean isCurGuild(@NotNull Object node, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!(node instanceof DirectMessageNode)) {
            return false;
        }
        return Intrinsics.areEqual(((DirectMessageNode) node).getGuildId(), guildId);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    public boolean isDirectMessageNodeNotNull(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (DirectMessageNodeRepository.D(guildId) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    @Nullable
    public Boolean isDisturb(@NotNull String curFriendUin) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        DirectMessageNode C = DirectMessageNodeRepository.C(curFriendUin);
        boolean z16 = false;
        if (C != null && C.getNotifyType() == 3) {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IDirectMessageNode
    public void removeObserver(@NotNull GPServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(observer);
    }
}

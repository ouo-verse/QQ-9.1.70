package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.api.IGuildChatApi;
import com.tencent.mobileqq.guildhelper.GuildHelperFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildChatApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildChatApi;", "", "chatsListPart", "Lcom/tencent/mobileqq/guild/s;", "getGuildConversationSummaryHelper", "", "highLightText", "", "isContainHighLight", "Landroid/content/Context;", "context", "", "openGuildHelper", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChatApiImpl implements IGuildChatApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildChatApi
    @NotNull
    public com.tencent.mobileqq.guild.s getGuildConversationSummaryHelper(@NotNull Object chatsListPart) {
        com.tencent.qqnt.chats.biz.main.part.c cVar;
        Intrinsics.checkNotNullParameter(chatsListPart, "chatsListPart");
        if (chatsListPart instanceof com.tencent.qqnt.chats.biz.main.part.c) {
            cVar = (com.tencent.qqnt.chats.biz.main.part.c) chatsListPart;
        } else {
            cVar = null;
        }
        return new com.tencent.mobileqq.guild.i(cVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChatApi
    public boolean isContainHighLight(@NotNull String highLightText) {
        Intrinsics.checkNotNullParameter(highLightText, "highLightText");
        return new Regex(IGuildChatApi.REGEX_HIGH_LIGHT).containsMatchIn(highLightText);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChatApi
    public void openGuildHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GuildHelperFragment.INSTANCE.a(context);
    }
}

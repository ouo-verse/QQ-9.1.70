package com.tencent.qqguild.directmessage.aio.input;

import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.util.ch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sz1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "channelId", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    public static final int a(@NotNull String channelId) {
        String str;
        MessageSource source;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        DirectMessageNode C = DirectMessageNodeRepository.C(channelId);
        if (C == null || (source = C.getSource()) == null || (str = source.getGuildId()) == null) {
            str = "";
        }
        int i3 = 0;
        if (d.l(str)) {
            i3 = 0 | GuildC2CPermissions.SPEAK_THRESHOLD.getPermission();
        }
        if (ch.m0(str)) {
            return i3 | GuildC2CPermissions.ADMIN.getPermission();
        }
        return i3;
    }
}

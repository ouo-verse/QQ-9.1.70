package com.tencent.guild.aio.halfpop.menu;

import androidx.annotation.ColorRes;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/k;", "", "", "aioFactoryName", "", "applicationId", "", "b", "(Ljava/lang/String;Ljava/lang/Long;)Z", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "c", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Ljava/lang/String;Ljava/lang/Long;)Z", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f110719a = new k();

    k() {
    }

    private final boolean b(String aioFactoryName, Long applicationId) {
        boolean z16;
        if ((applicationId == null || applicationId.longValue() != 1000001) && (applicationId == null || applicationId.longValue() != 1000137)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if ((!Intrinsics.areEqual(aioFactoryName, com.tencent.guild.aio.factory.a.class.getName()) && !Intrinsics.areEqual(qn0.a.class.getName(), aioFactoryName) && !Intrinsics.areEqual(hn0.a.class.getName(), aioFactoryName)) || z16) {
            return false;
        }
        return true;
    }

    @ColorRes
    public final int a() {
        if (UIUtil.f112434a.A()) {
            return R.color.qui_common_text_primary;
        }
        return R.color.qui_common_icon_primary;
    }

    public final boolean c(@NotNull GuildMsgItem data, @NotNull String aioFactoryName, @Nullable Long applicationId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(aioFactoryName, "aioFactoryName");
        boolean isGuildEmojiReactionEnable = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).isGuildEmojiReactionEnable();
        boolean b16 = b(aioFactoryName, applicationId);
        boolean R = MsgExtKt.R(data.getMsgRecord());
        boolean U = MsgExtKt.U(data.getMsgRecord());
        QLog.i("EmoticonItemVisibleUtil", 4, "switchEnable=" + isGuildEmojiReactionEnable + ", isSupportChannelType=" + b16 + " isRomaMsg=" + R + " sendSuccess=" + U);
        if (isGuildEmojiReactionEnable && b16 && R && U) {
            return true;
        }
        return false;
    }
}

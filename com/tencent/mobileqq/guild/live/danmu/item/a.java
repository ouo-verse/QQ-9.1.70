package com.tencent.mobileqq.guild.live.danmu.item;

import android.text.TextUtils;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "f", "", "b", "a", "", "i", "Lcom/tencent/mobileqq/guild/live/danmu/item/GLiveDanmuPriority;", "priority", "", "j", h.F, "g", "", "e", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "c", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/mobileqq/guild/live/danmu/item/GLiveDanmuPriority;", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GLiveDanmuPriority priority;

    public a(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.msgItem = msgItem;
        this.priority = GLiveDanmuPriority.NORMAL;
    }

    private final String f(GuildMsgItem msgItem) {
        String guildId = msgItem.getMsgRecord().guildId;
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class);
        String str = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        long sourceGuildId = iGuildDirectMsgUtilApi.getSourceGuildId(str);
        if (sourceGuildId != 0) {
            guildId = String.valueOf(sourceGuildId);
        }
        String str2 = msgItem.getMsgRecord().senderUid.toString();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return iq0.a.u(str2, guildId);
    }

    @NotNull
    public abstract String a();

    public abstract int b();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildMsgItem getMsgItem() {
        return this.msgItem;
    }

    @NotNull
    public final String d() {
        String nickFromMsg = this.msgItem.getMsgRecord().sendMemberName;
        if (com.tencent.guild.aio.util.h.f112401a.a(this.msgItem) && !TextUtils.isEmpty(nickFromMsg)) {
            Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
            return nickFromMsg;
        }
        String f16 = f(this.msgItem);
        if (TextUtils.isEmpty(f16)) {
            if (!TextUtils.isEmpty(nickFromMsg)) {
                Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
                return nickFromMsg;
            }
            String str = this.msgItem.getMsgRecord().sendNickName;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.sendNickName");
            return str;
        }
        return f16;
    }

    public final long e() {
        return this.msgItem.getMsgSeq();
    }

    @NotNull
    public final GuildMsgItem g() {
        return this.msgItem;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final GLiveDanmuPriority getPriority() {
        return this.priority;
    }

    public final boolean i() {
        QLog.d("GuildLiveBaseDanmuItem", 4, "isMySelf " + this.msgItem.isSelf());
        return this.msgItem.isSelf();
    }

    public final void j(@NotNull GLiveDanmuPriority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.priority = priority;
    }
}

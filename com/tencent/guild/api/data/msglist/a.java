package com.tencent.guild.api.data.msglist;

import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0000\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "b", "c", "d", "e", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "f", "", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "a", "nt-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    @Nullable
    public static final ReplyElement a(@NotNull GuildMsgItem guildMsgItem) {
        ReplyElement replyElement;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 9) {
            return null;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    public static final boolean b(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().sendType != 3 && guildMsgItem.getMsgRecord().sendType != 6) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().fromAppid == GuildMsgItem.ROBOT_MSG_FLAG) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull GuildMsgItem guildMsgItem) {
        String extInfoFromExtStr$default;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (c(guildMsgItem) && (extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_TYPE, null, 2, null)) != null && !extInfoFromExtStr$default.equals("")) {
            try {
                if (Integer.parseInt(extInfoFromExtStr$default) != 1) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static final boolean e(@NotNull GuildMsgItem guildMsgItem) {
        String extInfoFromExtStr$default;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (!c(guildMsgItem) || (extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING, null, 2, null)) == null || extInfoFromExtStr$default.equals("")) {
            return false;
        }
        return Boolean.parseBoolean(extInfoFromExtStr$default);
    }

    @NotNull
    public static final nt_im_msg_general_flags_body$ResvAttr f(@NotNull GuildMsgItem guildMsgItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
        nt_im_msg_general_flags_body$ResvAttr nt_im_msg_general_flags_body_resvattr = new nt_im_msg_general_flags_body$ResvAttr();
        try {
            byte[] bArr = guildMsgItem.getMsgRecord().generalFlags;
            Intrinsics.checkNotNullExpressionValue(bArr, "msgRecord.generalFlags");
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                nt_im_msg_body_generalflags.mergeFrom(guildMsgItem.getMsgRecord().generalFlags);
                if (nt_im_msg_body_generalflags.bytes_pb_reserve.has()) {
                    nt_im_msg_general_flags_body_resvattr.mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                }
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "generalFlags parse ERROR " + guildMsgItem.getMsgRecord().generalFlags;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMsgItemExt", 1, (String) it.next(), null);
            }
        }
        return nt_im_msg_general_flags_body_resvattr;
    }

    public static final void g(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (!c(guildMsgItem)) {
            return;
        }
        nt_im_msg_general_flags_body$ResvAttr f16 = f(guildMsgItem);
        if (f16.bot_meta_data.has()) {
            int i3 = f16.bot_meta_data.uint32_msg_type.get();
            guildMsgItem.saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_TYPE, String.valueOf(i3));
            guildMsgItem.saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING, String.valueOf(f16.bot_meta_data.bool_show_msg_setting.get()));
            String valueOf = String.valueOf(f16.bot_meta_data.source_guild.guild_id.get());
            guildMsgItem.saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_ID, valueOf);
            String str = f16.bot_meta_data.source_guild.guild_name.get().toString();
            guildMsgItem.saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_NAME, str);
            if (QLog.isColorLevel()) {
                QLog.d(GuildMsgItem.TAG, 2, "decodeRobotMetaFlag : botMsgType = " + i3 + ", srcGuildId = " + valueOf + ", srcGuildName = " + str);
            }
        }
    }
}

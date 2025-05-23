package com.tencent.guild.aio.util.ex;

import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "c", "", "a", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {
    public static final boolean a(@NotNull MsgRecord msgRecord) {
        MsgElement c16;
        GrayTipElement grayTipElement;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.msgType;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 5 && (c16 = iq0.a.c(8, msgRecord)) != null && (grayTipElement = c16.grayTipElement) != null && grayTipElement.subElementType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Contact c(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return new Contact(msgRecord.chatType, msgRecord.channelId, msgRecord.guildId);
    }
}

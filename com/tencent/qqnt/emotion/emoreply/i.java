package com.tencent.qqnt.emotion.emoreply;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "qqemoticonpanel-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i {
    @NotNull
    public static final Contact a(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
    }
}

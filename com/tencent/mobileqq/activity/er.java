package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/QQLSActivity;", "Lcom/tencent/mobileqq/data/MessageRecord;", "newMr", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "orgMrReminder", "", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class er {
    public static final void a(@NotNull QQLSActivity qQLSActivity, @NotNull MessageRecord newMr, @Nullable com.tencent.mobileqq.reminder.db.entity.b bVar) {
        Intrinsics.checkNotNullParameter(qQLSActivity, "<this>");
        Intrinsics.checkNotNullParameter(newMr, "newMr");
        if (bVar == null) {
            return;
        }
        Object a16 = bVar.a();
        if (a16 instanceof MessageRecord) {
            MessageRecord.copyMessageRecordBaseField(newMr, (MessageRecord) a16);
            return;
        }
        if (!(a16 instanceof com.tencent.mobileqq.reminder.db.b)) {
            return;
        }
        com.tencent.mobileqq.reminder.db.b bVar2 = (com.tencent.mobileqq.reminder.db.b) a16;
        newMr.selfuin = bVar2.getSelfuin();
        newMr.senderuin = bVar2.getSenderuin();
        newMr.msgtype = bVar2.getMsgtype();
        newMr.f203106msg = bVar2.getMsg();
        newMr.time = bVar2.getTime();
        newMr.isread = bVar2.getIsread();
        newMr.frienduin = bVar2.getFrienduin();
        newMr.istroop = bVar2.getIstroop();
        newMr.uniseq = bVar2.getUniseq();
        newMr.extLong = bVar2.getExtLong();
        newMr.extStr = bVar2.getExtStr();
        newMr.mExJsonObject = bVar2.getMExJsonObject();
        newMr.msgData = bVar2.getMsgData();
    }
}

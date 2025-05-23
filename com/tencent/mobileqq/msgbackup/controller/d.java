package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface d {
    boolean a(MessageRecord messageRecord);

    k b(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity);

    boolean c(MsgBackupResEntity msgBackupResEntity);

    void d(MessageRecord messageRecord);

    String e(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity);

    void f(MessageRecord messageRecord, List<MsgBackupResEntity> list);

    void g(MsgBackupResEntity msgBackupResEntity);
}

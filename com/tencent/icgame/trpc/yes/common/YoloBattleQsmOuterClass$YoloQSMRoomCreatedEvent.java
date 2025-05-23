package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleQsmOuterClass$YoloQSMRoomCreatedEvent extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMRoomCreatedEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"event", "join_schema"}, new Object[]{null, null}, YoloBattleQsmOuterClass$YoloQSMRoomCreatedEvent.class);
    public QsmDataOuterClass$QSMRoomCreatedEvent event = new QsmDataOuterClass$QSMRoomCreatedEvent();
    public YoloBattleQsmOuterClass$YoloQSMSchema join_schema = new YoloBattleQsmOuterClass$YoloQSMSchema();
}

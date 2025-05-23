package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryGreetCardReply extends MessageMicro<GameMsgGreeting$QueryGreetCardReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56}, new String[]{"allowFriendGreeting", "allowStrangerGreeting", "allowFriendVisitProfile", "allowStrangerVisitProfile", "noticeType", "noticeInfo", "isShowUserGuide"}, new Object[]{0, 0, 0, 0, 0, "", 0}, GameMsgGreeting$QueryGreetCardReply.class);
    public final PBInt32Field allowFriendGreeting = PBField.initInt32(0);
    public final PBInt32Field allowStrangerGreeting = PBField.initInt32(0);
    public final PBInt32Field allowFriendVisitProfile = PBField.initInt32(0);
    public final PBInt32Field allowStrangerVisitProfile = PBField.initInt32(0);
    public final PBInt32Field noticeType = PBField.initInt32(0);
    public final PBStringField noticeInfo = PBField.initString("");
    public final PBInt32Field isShowUserGuide = PBField.initInt32(0);
}

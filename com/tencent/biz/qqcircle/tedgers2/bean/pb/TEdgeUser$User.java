package com.tencent.biz.qqcircle.tedgers2.bean.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class TEdgeUser$User extends MessageMicro<TEdgeUser$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"user_id", "profile", "actions", "context"}, new Object[]{"", null, null, null}, TEdgeUser$User.class);
    public final PBStringField user_id = PBField.initString("");
    public TEdgeUserProfile$UserProfile profile = new TEdgeUserProfile$UserProfile();
    public final PBRepeatMessageField<TEdgeAction$Action> actions = PBField.initRepeatMessage(TEdgeAction$Action.class);
    public final PBRepeatMessageField<TEdgeCommon$MapEntry> context = PBField.initRepeatMessage(TEdgeCommon$MapEntry.class);
}

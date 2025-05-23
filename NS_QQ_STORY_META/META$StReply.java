package NS_QQ_STORY_META;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StReply extends MessageMicro<META$StReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "targetUser", "vecAtUin"}, new Object[]{"", null, 0L, "", null, 0L}, META$StReply.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f25066id = PBField.initString("");
    public META$StUser postUser = new META$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public META$StUser targetUser = new META$StUser();
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}

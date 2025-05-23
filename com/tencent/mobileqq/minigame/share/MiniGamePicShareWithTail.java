package com.tencent.mobileqq.minigame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes33.dex */
public final class MiniGamePicShareWithTail {
    public static final int C2C = 1;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final int f247019GROUP = 2;
    public static final int UNKNOW = 0;

    /* loaded from: classes33.dex */
    public static final class SendMiniGamePicWithTailMsgReq extends MessageMicro<SendMiniGamePicWithTailMsgReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"appid", "picUrl", "scene", "receiver"}, new Object[]{"", "", 0, 0L}, SendMiniGamePicWithTailMsgReq.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField picUrl = PBField.initString("");
        public final PBEnumField scene = PBField.initEnum(0);
        public final PBUInt64Field receiver = PBField.initUInt64(0);
    }

    /* loaded from: classes33.dex */
    public static final class SendMiniGamePicWithTailMsgRsp extends MessageMicro<SendMiniGamePicWithTailMsgRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isSuccess"}, new Object[]{0}, SendMiniGamePicWithTailMsgRsp.class);
        public final PBInt32Field isSuccess = PBField.initInt32(0);
    }

    MiniGamePicShareWithTail() {
    }
}

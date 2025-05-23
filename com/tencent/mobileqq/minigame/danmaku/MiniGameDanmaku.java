package com.tencent.mobileqq.minigame.danmaku;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameDanmaku {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Element extends MessageMicro<Element> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "content", "textcolor"}, new Object[]{0, "", ""}, Element.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBStringField content = PBField.initString("");
        public final PBStringField textcolor = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class GetLoadingTipsReq extends MessageMicro<GetLoadingTipsReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetLoadingTipsReq.class);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class GetLoadingTipsRsp extends MessageMicro<GetLoadingTipsRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tips_list"}, new Object[]{null}, GetLoadingTipsRsp.class);
        public final PBRepeatMessageField<Tips> tips_list = PBField.initRepeatMessage(Tips.class);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Tips extends MessageMicro<Tips> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"element_list", "uid"}, new Object[]{null, 0L}, Tips.class);
        public final PBRepeatMessageField<Element> element_list = PBField.initRepeatMessage(Element.class);
        public final PBUInt64Field uid = PBField.initUInt64(0);
    }

    MiniGameDanmaku() {
    }
}

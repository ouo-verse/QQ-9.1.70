package com.tencent.mobileqq.minigame.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.raft.measure.utils.MeasureConst;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameMetaGuideBubble {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class NoticeFarmEntryByTabBubbleReq extends MessageMicro<NoticeFarmEntryByTabBubbleReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], NoticeFarmEntryByTabBubbleReq.class);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class NoticeFarmEntryByTabBubbleRsp extends MessageMicro<NoticeFarmEntryByTabBubbleRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{MeasureConst.SLI_TYPE_SUCCESS}, new Object[]{Boolean.FALSE}, NoticeFarmEntryByTabBubbleRsp.class);
        public final PBBoolField succ = PBField.initBool(false);
    }

    MiniGameMetaGuideBubble() {
    }
}

package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$FollowUnFollowRsp extends MessageMicro<clientbusilogic$FollowUnFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"detail"}, new Object[]{null}, clientbusilogic$FollowUnFollowRsp.class);
    public Detail detail = new Detail();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Detail extends MessageMicro<Detail> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_ret_info"}, new Object[]{null}, Detail.class);
        public clientbusilogic$RetInfo msg_ret_info = new clientbusilogic$RetInfo();
    }
}

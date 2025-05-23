package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomUserWhiteList extends MessageMicro<YoloRoomOuterClass$YoloRoomUserWhiteList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_community_host"}, new Object[]{Boolean.FALSE}, YoloRoomOuterClass$YoloRoomUserWhiteList.class);
    public final PBBoolField is_community_host = PBField.initBool(false);
}

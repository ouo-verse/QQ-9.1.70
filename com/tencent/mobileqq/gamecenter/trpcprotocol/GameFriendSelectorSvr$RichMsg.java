package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$RichMsg extends MessageMicro<GameFriendSelectorSvr$RichMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "text_content", PreDetect.FACE_DETECT}, new Object[]{0, "", 0}, GameFriendSelectorSvr$RichMsg.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField text_content = PBField.initString("");

    /* renamed from: face, reason: collision with root package name */
    public final PBInt32Field f213222face = PBField.initInt32(0);
}

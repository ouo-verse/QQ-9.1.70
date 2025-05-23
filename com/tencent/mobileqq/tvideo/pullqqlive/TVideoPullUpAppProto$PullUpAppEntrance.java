package com.tencent.mobileqq.tvideo.pullqqlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes19.dex */
public final class TVideoPullUpAppProto$PullUpAppEntrance extends MessageMicro<TVideoPullUpAppProto$PullUpAppEntrance> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"isShown", "downloadPageLink", "pullUpAppLink", "isAutoPull"}, new Object[]{Boolean.FALSE, "", ""}, TVideoPullUpAppProto$PullUpAppEntrance.class);
    public final PBBoolField isShown = PBField.initBool(false);
    public final PBStringField downloadPageLink = PBField.initString("");
    public final PBStringField pullUpAppLink = PBField.initString("");
    public final PBBoolField isAutoPull = PBField.initBool(false);
}

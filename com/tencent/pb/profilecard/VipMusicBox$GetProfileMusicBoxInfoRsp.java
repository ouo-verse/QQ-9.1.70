package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes22.dex */
public final class VipMusicBox$GetProfileMusicBoxInfoRsp extends MessageMicro<VipMusicBox$GetProfileMusicBoxInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"music", "is_visible"}, new Object[]{null, Boolean.FALSE}, VipMusicBox$GetProfileMusicBoxInfoRsp.class);
    public VipMusicBox$ProfileMusicInfo music = new VipMusicBox$ProfileMusicInfo();
    public final PBBoolField is_visible = PBField.initBool(false);
}

package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetVisibleRangeRequest extends MessageMicro<GameDataAuthorizeSvr$GetVisibleRangeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"app_id", "source", "pkg_info"}, new Object[]{"", 0, null}, GameDataAuthorizeSvr$GetVisibleRangeRequest.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(0);
    public GameDataAuthorizeSvr$PkgInfo pkg_info = new GameDataAuthorizeSvr$PkgInfo();
}

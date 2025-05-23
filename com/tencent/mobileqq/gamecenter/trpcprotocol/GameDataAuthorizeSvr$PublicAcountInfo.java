package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$PublicAcountInfo extends MessageMicro<GameDataAuthorizeSvr$PublicAcountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"text", IPublicAccountBrowser.KEY_PUB_UIN, "type"}, new Object[]{"", 0L, 0}, GameDataAuthorizeSvr$PublicAcountInfo.class);
    public final PBStringField text = PBField.initString("");
    public final PBInt64Field puin = PBField.initInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
}

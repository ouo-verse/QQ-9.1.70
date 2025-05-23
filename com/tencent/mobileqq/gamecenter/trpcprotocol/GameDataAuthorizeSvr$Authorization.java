package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$Authorization extends MessageMicro<GameDataAuthorizeSvr$Authorization> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"type", DownloaderConstant.KEY_RANGE, "title", "text"}, new Object[]{0, 0, "", ""}, GameDataAuthorizeSvr$Authorization.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBEnumField range = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField text = PBField.initString("");
}

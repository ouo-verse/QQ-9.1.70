package guild;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildCommon$StCommonExt extends MessageMicro<GuildCommon$StCommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{ThirdPartyMiniApiImpl.KEY_MAP_INFO, "attachInfo", "mapBytesInfo"}, new Object[]{null, "", null}, GuildCommon$StCommonExt.class);
    public final PBRepeatMessageField<GuildCommon$Entry> mapInfo = PBField.initRepeatMessage(GuildCommon$Entry.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<GuildCommon$BytesEntry> mapBytesInfo = PBField.initRepeatMessage(GuildCommon$BytesEntry.class);
}

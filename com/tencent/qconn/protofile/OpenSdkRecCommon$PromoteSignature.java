package com.tencent.qconn.protofile;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$PromoteSignature extends MessageMicro<OpenSdkRecCommon$PromoteSignature> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"uin", "appid", SessionDbHelper.SESSION_ID, AlbumCacheData.CREATE_TIME, "official_accounts", "channels"}, new Object[]{0L, 0, null, 0L, null, null}, OpenSdkRecCommon$PromoteSignature.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public OpenSdkRecCommon$Session session = new OpenSdkRecCommon$Session();
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBRepeatMessageField<OpenSdkRecCommon$OfficialAccountInfo> official_accounts = PBField.initRepeatMessage(OpenSdkRecCommon$OfficialAccountInfo.class);
    public final PBRepeatMessageField<OpenSdkRecCommon$ChannelInfo> channels = PBField.initRepeatMessage(OpenSdkRecCommon$ChannelInfo.class);
}

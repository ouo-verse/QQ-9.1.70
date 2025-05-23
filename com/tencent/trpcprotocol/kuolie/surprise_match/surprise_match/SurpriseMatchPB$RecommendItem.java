package com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;

/* loaded from: classes38.dex */
public final class SurpriseMatchPB$RecommendItem extends MessageMicro<SurpriseMatchPB$RecommendItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_info", "recom_trace", "reason"}, new Object[]{null, "", ""}, SurpriseMatchPB$RecommendItem.class);
    public QqstrangerUserInfoPB$UserInfo user_info = new QqstrangerUserInfoPB$UserInfo();
    public final PBStringField recom_trace = PBField.initString("");
    public final PBStringField reason = PBField.initString("");
}

package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$GetAuthPhonePanelRsp extends MessageMicro<QWalletAuthorize$GetAuthPhonePanelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{CGNonAgeReport.EVENT_CHANNEL, "title", "content", "phones", "contracts"}, new Object[]{null, "", "", null, null}, QWalletAuthorize$GetAuthPhonePanelRsp.class);
    public QWalletAuthorize$ChannelInfo channel_info = new QWalletAuthorize$ChannelInfo();
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBRepeatMessageField<QWalletAuthorize$PhoneNo> phones = PBField.initRepeatMessage(QWalletAuthorize$PhoneNo.class);
    public final PBRepeatMessageField<QWalletAuthorize$Contract> contracts = PBField.initRepeatMessage(QWalletAuthorize$Contract.class);
}

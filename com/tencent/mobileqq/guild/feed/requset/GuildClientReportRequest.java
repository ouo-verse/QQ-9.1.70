package com.tencent.mobileqq.guild.feed.requset;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import guild.GuildClientReport$SingleTableData;
import guild.GuildClientReport$StDataReportReq;
import guild.GuildClientReport$StDataReportRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildClientReportRequest extends GuildBaseRequest {
    private GuildClientReport$StDataReportReq mReq;

    public GuildClientReportRequest(List<GuildClientReport$SingleTableData> list) {
        GuildClientReport$StDataReportReq guildClientReport$StDataReportReq = new GuildClientReport$StDataReportReq();
        this.mReq = guildClientReport$StDataReportReq;
        guildClientReport$StDataReportReq.data.set(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QChannelSvr.trpc.qchannel.clientreport.ClientReport.DataReport";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<GuildClientReport$StDataReportRsp> messageMicro = new MessageMicro<GuildClientReport$StDataReportRsp>() { // from class: guild.GuildClientReport$StDataReportRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, GuildClientReport$StDataReportRsp.class);
            public GuildCommon$Result result = new MessageMicro<GuildCommon$Result>() { // from class: guild.GuildCommon$Result
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", "msg"}, new Object[]{0, ""}, GuildCommon$Result.class);
                public final PBInt32Field retCode = PBField.initInt32(0);

                /* renamed from: msg, reason: collision with root package name */
                public final PBStringField f403414msg = PBField.initString("");
            };
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}

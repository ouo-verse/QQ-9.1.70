package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import qbattle.QQBattleInfo$BattleID;
import qbattle.QQBattleInfo$GetShareBattleVideoInfoReq;
import qbattle.QQBattleInfo$GetShareBattleVideoInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkGetHokBattleInfoReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.shadow_qq.hok_battleinfo.HokBattleInfo.GetSharedBattleVideoInfo";
    private final QQBattleInfo$GetShareBattleVideoInfoReq mRequest;

    public QQWinkGetHokBattleInfoReq(String str, String str2, String str3) {
        QQBattleInfo$GetShareBattleVideoInfoReq qQBattleInfo$GetShareBattleVideoInfoReq = new QQBattleInfo$GetShareBattleVideoInfoReq();
        this.mRequest = qQBattleInfo$GetShareBattleVideoInfoReq;
        try {
            String[] split = str.split("_");
            if (split != null && split.length == 3) {
                QQBattleInfo$BattleID qQBattleInfo$BattleID = new QQBattleInfo$BattleID();
                qQBattleInfo$BattleID.desk_id.set(Integer.valueOf(split[1]).intValue());
                qQBattleInfo$BattleID.entity_id.set(Integer.valueOf(split[2]).intValue());
                qQBattleInfo$BattleID.desk_seq.set(Integer.valueOf(split[0]).intValue());
                qQBattleInfo$GetShareBattleVideoInfoReq.battle_id.set(qQBattleInfo$BattleID);
            }
            qQBattleInfo$GetShareBattleVideoInfoReq.zonearea_id.set("0");
            qQBattleInfo$GetShareBattleVideoInfoReq.authen_id.set(str2);
            qQBattleInfo$GetShareBattleVideoInfoReq.open_id.set(str3);
        } catch (Exception e16) {
            QLog.e("QQWinkGetHokBattleInfoReq", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQBattleInfo$GetShareBattleVideoInfoRsp qQBattleInfo$GetShareBattleVideoInfoRsp = new QQBattleInfo$GetShareBattleVideoInfoRsp();
        try {
            qQBattleInfo$GetShareBattleVideoInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQBattleInfo$GetShareBattleVideoInfoRsp;
    }
}

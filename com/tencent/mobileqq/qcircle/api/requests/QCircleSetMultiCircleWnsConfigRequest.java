package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleSwitch$SetMultiCircleSwitchReq;
import qqcircle.QQCircleSwitch$SetMultiCircleSwitchRsp;
import qqcircle.QQCircleSwitch$StSwitch;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSetMultiCircleWnsConfigRequest extends QCircleBaseRequest {
    private QQCircleSwitch$SetMultiCircleSwitchReq mReq = new QQCircleSwitch$SetMultiCircleSwitchReq();

    public QCircleSetMultiCircleWnsConfigRequest(HashMap<String, HashMap<String, String>> hashMap) {
        HashMap<String, String> value;
        try {
            for (Map.Entry<String, HashMap<String, String>> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null && !value.isEmpty()) {
                    for (Map.Entry<String, String> entry2 : value.entrySet()) {
                        if (entry2 != null && !TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                            String key2 = entry2.getKey();
                            String value2 = entry2.getValue();
                            QQCircleSwitch$StSwitch qQCircleSwitch$StSwitch = new QQCircleSwitch$StSwitch();
                            qQCircleSwitch$StSwitch.key.set(key + "." + key2);
                            qQCircleSwitch$StSwitch.value.set(value2);
                            this.mReq.sws.add(qQCircleSwitch$StSwitch);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetMultiCircleSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleSwitch$SetMultiCircleSwitchRsp> messageMicro = new MessageMicro<QQCircleSwitch$SetMultiCircleSwitchRsp>() { // from class: qqcircle.QQCircleSwitch$SetMultiCircleSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleSwitch$SetMultiCircleSwitchRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}

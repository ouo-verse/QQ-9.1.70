package com.tencent.mobileqq.guild.feed.requset;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.text.TextUtils;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.richframework.common.RFWCommonGlobalInfo;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class GuildBaseRequest extends VSBaseRequest {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(byteStringMicro));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set("96");
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("environment_id");
        entry2.value.set(RFWCommonGlobalInfo.getCurMsfServerId());
        stQWebReq.Extinfo.add(entry2);
        COMM.Entry entry3 = new COMM.Entry();
        entry3.key.set(INetChannelCallback.KEY_TINY_ID);
        String u16 = ax.u();
        if (TextUtils.equals(u16, "0")) {
            u16 = "";
        }
        entry3.value.set(u16);
        stQWebReq.Extinfo.add(entry3);
        return stQWebReq.toByteArray();
    }
}

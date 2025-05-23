package com.qzone.reborn.intimate.request;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "requestBizData", "", "getRequestWrapper", "", "getRetryRetCodes", "", "retCode", "", "isNeedRetry", "", "", "", "getSSOAttributes", "<init>", "()V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneIntimateBaseRequest extends VSBaseRequest {
    public static final String QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY = "fc-appid";
    public static final String QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE = "98";
    public static final String TAG = "QZoneIntimateBaseRequest";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro requestBizData) {
        Intrinsics.checkNotNullParameter(requestBizData, "requestBizData");
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(requestBizData));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set(QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE);
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("environment_id");
        entry2.value.set("");
        stQWebReq.Extinfo.add(entry2);
        byte[] byteArray = stQWebReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public final long[] getRetryRetCodes() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public Map<String, Object> getSSOAttributes() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG, 32));
        return hashMapOf;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public boolean isNeedRetry(long retCode) {
        boolean z16 = retCode != -2;
        long[] retryRetCodes = getRetryRetCodes();
        if (retryRetCodes != null) {
            if (!(retryRetCodes.length == 0)) {
                int length = retryRetCodes.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z16 = false;
                        break;
                    }
                    if (retryRetCodes[i3] == retCode) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            }
        }
        QLog.d(TAG, 1, "CmdName:", getCmdName(), ",retCode:", Long.valueOf(retCode), "isNeedRetry:" + z16);
        return z16;
    }
}

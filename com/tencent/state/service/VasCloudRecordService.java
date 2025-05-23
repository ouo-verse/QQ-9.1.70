package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import cu4.a;
import cu4.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/service/VasCloudRecordService;", "", "()V", "CMD_SERVICE", "", "METHOD_CREATE_RECORD_TASK", "METHOD_DELETE_ALL_TASK_CACHE", "METHOD_DELETE_Z1_TASK_CACHE", "TAG", "UN_KNOW_ERROR", "", "deleteAllTaskCache", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "deleteZ1TaskCache", "uin", "", "actionId", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasCloudRecordService {
    private static final String CMD_SERVICE = "trpc.qmeta.user_record_task_svr.UserRecordTaskSvr";
    public static final VasCloudRecordService INSTANCE = new VasCloudRecordService();
    private static final String METHOD_CREATE_RECORD_TASK = "CreateRecordTask";
    private static final String METHOD_DELETE_ALL_TASK_CACHE = "DeleteAllTaskCache";
    private static final String METHOD_DELETE_Z1_TASK_CACHE = "DeleteZ1TaskCache";
    private static final String TAG = "VasCloudRecordService";
    private static final int UN_KNOW_ERROR = -1;

    VasCloudRecordService() {
    }

    public final void deleteAllTaskCache(final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        a aVar = new a();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_DELETE_ALL_TASK_CACHE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasCloudRecordService$deleteAllTaskCache$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                    SquareBaseKt.getSquareLog().d("VasCloudRecordService", "deleteAllTaskCache error:" + data.getErrCode() + ", msg:" + data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        resultCallback.onResultSuccess(Boolean.TRUE);
                    }
                    SquareBaseKt.getSquareLog().d("VasCloudRecordService", "deleteAllTaskCache success");
                }
            });
        }
    }

    public final void deleteZ1TaskCache(final long uin, final int actionId, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        b bVar = new b();
        bVar.f391868a = uin;
        bVar.f391869b = actionId;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(bVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_DELETE_Z1_TASK_CACHE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasCloudRecordService$deleteZ1TaskCache$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                    SquareBaseKt.getSquareLog().d("VasCloudRecordService", "deleteZ1TaskCache error, uin:" + uin + ", actionId:" + actionId + ", error:" + data.getErrCode() + ", msg:" + data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        resultCallback.onResultSuccess(Boolean.TRUE);
                    }
                    SquareBaseKt.getSquareLog().d("VasCloudRecordService", "deleteZ1TaskCache success, uin:" + uin + ", actionId:" + actionId);
                }
            });
        }
    }
}

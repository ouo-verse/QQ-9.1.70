package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.QZoneFeedsInfo;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import hs4.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ut4.a;
import ut4.b;
import ut4.c;
import ut4.d;
import ut4.e;
import ut4.f;
import ut4.g;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eJ0\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ(\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u001c\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/service/VasSquareQZoneService;", "", "()V", "CMD_SERVICE", "", "METHOD_GET_QZONE_PRIVACY_STATUS", "METHOD_QUERY_QZONE_RED_DOT", "METHOD_SET_BUBBLE_EXPOSURE", "METHOD_SET_BUBBLE_REPORT", "METHOD_SET_QZONE_PRIVACY_STATUS", "TAG", "queryQZonePrivacyStatus", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "queryQZoneRedDot", "toUin", "", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "reportQZoneBubbleClick", "feedsId", "source", "", "reportQZoneBubbleExposure", "setQZonePrivacyStatus", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareQZoneService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_qzone_svr.StatusSquareQzoneSvr";
    public static final VasSquareQZoneService INSTANCE = new VasSquareQZoneService();
    private static final String METHOD_GET_QZONE_PRIVACY_STATUS = "GetQzonePrivacyStatus";
    private static final String METHOD_QUERY_QZONE_RED_DOT = "GetQzoneReddot";
    private static final String METHOD_SET_BUBBLE_EXPOSURE = "SetBubbleExposure";
    private static final String METHOD_SET_BUBBLE_REPORT = "SetBubbleReport";
    private static final String METHOD_SET_QZONE_PRIVACY_STATUS = "SetQzonePrivacyStatus";
    private static final String TAG = "VasSquareQZoneService";

    VasSquareQZoneService() {
    }

    public final void queryQZonePrivacyStatus(final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_QZONE_PRIVACY_STATUS, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareQZoneService$queryQZonePrivacyStatus$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareQZoneService", "queryQZonePrivacyStatus on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        b c16 = b.c(rspData);
                        SquareBaseKt.getSquareLog().d("VasSquareQZoneService", "queryQZonePrivacyStatus on receive " + c16.f440022a);
                        ResultCallback.this.onResultSuccess(Boolean.valueOf(c16.f440022a));
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasSquareQZoneService", "queryQZonePrivacyStatus on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "queryQZonePrivacyStatus parse error");
                    }
                }
            });
        }
    }

    public final void queryQZoneRedDot(long toUin, final ResultCallback<QZoneFeedsInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = new c();
        cVar.f440023a = toUin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_QUERY_QZONE_RED_DOT, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareQZoneService$queryQZoneRedDot$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareQZoneService", "queryQZoneRedDot on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    QZoneFeedsInfo qZoneFeedsInfo;
                    try {
                        d c16 = d.c(rspData);
                        SquareBaseKt.getSquareLog().d("VasSquareQZoneService", "queryQZoneRedDot on receive " + c16);
                        q qVar = c16.f440025b;
                        if (qVar != null && (qZoneFeedsInfo = UserFormatKt.formatQZoneFeedInfo(qVar)) != null) {
                            qZoneFeedsInfo.setHasNew(c16.f440024a);
                        } else {
                            qZoneFeedsInfo = new QZoneFeedsInfo(null, 0, null, null, null, c16.f440024a, 31, null);
                        }
                        ResultCallback.this.onResultSuccess(qZoneFeedsInfo);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasSquareQZoneService", "queryQZoneRedDot on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "queryQZonePrivacyStatus parse error");
                    }
                }
            });
        }
    }

    public final void reportQZoneBubbleClick(String feedsId, long toUin, int source, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        f fVar = new f();
        fVar.f440028a = feedsId;
        fVar.f440030c = source;
        fVar.f440029b = toUin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(fVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_SET_BUBBLE_REPORT, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareQZoneService$reportQZoneBubbleClick$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareQZoneService", "reportQZoneBubbleClick on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().d("VasSquareQZoneService", "reportQZoneBubbleClick on onReceive");
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        resultCallback.onResultSuccess(Boolean.TRUE);
                    }
                }
            });
        }
    }

    public final void reportQZoneBubbleExposure(final String feedsId, final long toUin, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        e eVar = new e();
        eVar.f440026a = feedsId;
        eVar.f440027b = toUin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_SET_BUBBLE_EXPOSURE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareQZoneService$reportQZoneBubbleExposure$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareQZoneService", "reportQZoneBubbleExposure on error, feedsId:" + feedsId + ", toUin:" + toUin + ", " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        resultCallback.onResultSuccess(Boolean.TRUE);
                    }
                }
            });
        }
    }

    public final void setQZonePrivacyStatus(boolean canShow, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        g gVar = new g();
        gVar.f440031a = canShow;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(gVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_SET_QZONE_PRIVACY_STATUS, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareQZoneService$setQZonePrivacyStatus$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareQZoneService", "setQZonePrivacyStatus on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().d("VasSquareQZoneService", "setQZonePrivacyStatus success");
                    ResultCallback.this.onResultSuccess(Boolean.TRUE);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportQZoneBubbleExposure$default(VasSquareQZoneService vasSquareQZoneService, String str, long j3, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            resultCallback = null;
        }
        vasSquareQZoneService.reportQZoneBubbleExposure(str, j3, resultCallback);
    }

    public static /* synthetic */ void reportQZoneBubbleClick$default(VasSquareQZoneService vasSquareQZoneService, String str, long j3, int i3, ResultCallback resultCallback, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            resultCallback = null;
        }
        vasSquareQZoneService.reportQZoneBubbleClick(str, j3, i3, resultCallback);
    }
}

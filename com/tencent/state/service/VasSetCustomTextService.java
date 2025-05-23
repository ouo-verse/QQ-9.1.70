package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import hs4.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import rt4.o;
import rt4.p;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/service/VasSetCustomTextService;", "", "()V", "requestSetCustomText", "", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "motionId", "", "customText", "", "avatarLocation", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "callback", "Lcom/tencent/state/service/ResultCallback;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSetCustomTextService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_panel_svr.StatusPanel";
    private static final String METHOD = "Publish";
    public static final int SECURITY_ERROR_CODE = -10032;
    public static final int SHOW_ERROR_MESSAGE_CODE = -23252;
    private static final String TAG = "VasSetCustomTextService";

    public final void requestSetCustomText(OnlineStatus onlineStatus, int motionId, String customText, AvatarLocationInfo avatarLocation, final ResultCallback<Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(avatarLocation, "avatarLocation");
        Intrinsics.checkNotNullParameter(callback, "callback");
        o oVar = new o();
        oVar.f432441f = SquareFragment.INSTANCE.getChatLandAppId();
        oVar.f432436a = onlineStatus.getTopStatusId();
        oVar.f432437b = onlineStatus.getId() == onlineStatus.getTopStatusId() ? 0 : onlineStatus.getId();
        byte[] bytes = customText.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        oVar.f432438c = bytes;
        oVar.f432439d = motionId;
        j jVar = new j();
        jVar.f406153a = avatarLocation.getLongitude();
        jVar.f406154b = avatarLocation.getLatitude();
        jVar.f406155c = avatarLocation.getPoi();
        jVar.f406156d = avatarLocation.getPoiId();
        jVar.f406157e = avatarLocation.getPoiAddress();
        oVar.f432440e = jVar;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(oVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSetCustomTextService$requestSetCustomText$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSetCustomTextService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        p c16 = p.c(rspData);
                        SquareBaseKt.getSquareLog().i("VasSetCustomTextService", "SetCustomText success: gotSeed=" + c16.f432442a);
                        ResultCallback.this.onResultSuccess(Unit.INSTANCE);
                    } catch (Throwable th5) {
                        ResultCallback.this.onResultFailure(-1, "SetCustomText response parse error: " + th5.getMessage());
                    }
                }
            });
        }
    }
}

package com.tencent.mobileqq.icgame.api.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.icgame.common.api.IQQLiveHEVCAbility;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.util.QQDeviceInfo;
import d32.a;
import iz0.b;
import iz0.c;
import iz0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t42.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000 #*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0004H&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "T", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "wantAppId", "", "(Ljava/lang/String;)V", "loginInfo", "Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "getLoginInfo", "()Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "setLoginInfo", "(Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;)V", "getAppId", "getClientType", "", "getCmdName", "getMainCmd", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "", "getRequestWrapper", "requestBizData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "getSubCmd", "isPushCmd", "", "mainCmd", "subCmd", "needLogin", "parseResponseHeadInfo", "", "", "responseBytes", "([B)[Ljava/lang/Object;", "Companion", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class LiveBaseRequest<T> extends VSBaseRequest {

    @NotNull
    public static final String LOG_TAG = "ICGameVSRequest|ICGameLiveBaseRequest";
    private static final int PLAT_ID = 109;

    @NotNull
    public static final String QQ_LIVE_MSG_PUSH_CMD = "trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr";

    @NotNull
    public static final String QQ_LIVE_MSG_PUSH_SUBCMD = "PullMsgProxy";
    public static final int UNKNOWN_CLIENT_TYPE = -1;

    @Nullable
    private LiveLoginInfo loginInfo;

    @NotNull
    private final String wantAppId;

    public LiveBaseRequest(@NotNull String wantAppId) {
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        this.wantAppId = wantAppId;
        setRequestUin(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
    }

    private final int getClientType() {
        a a16 = a.INSTANCE.a(getWantAppId());
        int clientType = a16.a().getClientType();
        if (isPushCmd(getMainCmd(), getSubCmd()) && a16.a().getPullMsgClientType() != -1) {
            return a16.a().getPullMsgClientType();
        }
        return clientType;
    }

    private final boolean isPushCmd(String mainCmd, String subCmd) {
        if (!Intrinsics.areEqual("trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr", mainCmd) && !Intrinsics.areEqual("PullMsgProxy", subCmd)) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: getAppId, reason: from getter */
    public String getWantAppId() {
        return this.wantAppId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.icgame.gateway.gatewayTrpc.Sso*";
    }

    @Nullable
    public final LiveLoginInfo getLoginInfo() {
        return this.loginInfo;
    }

    @NotNull
    public abstract String getMainCmd();

    @NotNull
    public abstract MessageNano getMessageNano();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = MessageNano.toByteArray(getMessageNano());
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(getMessageNano())");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public byte[] getRequestWrapper(@NotNull ByteStringMicro requestBizData) {
        int i3;
        long j3;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(requestBizData, "requestBizData");
        b bVar = new b();
        bVar.f408997d = getClientType();
        String str4 = AppSetting.f99551k;
        bVar.f408998e = str4;
        bVar.f408999f = requestBizData.toByteArray();
        bVar.f409000g = TVKEventId.PLAYER_STATE_SWITCHDEF_START;
        bVar.f409001h = 0;
        String qimei = QQDeviceInfo.getQIMEI();
        Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
        byte[] bytes = qimei.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        bVar.f409009p = bytes;
        bVar.C = f.a();
        bVar.f409007n = 0;
        bVar.f409010q = 37;
        LiveLoginInfo liveLoginInfo = this.loginInfo;
        if (liveLoginInfo == null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        bVar.f409004k = i3;
        long j16 = 0;
        if (liveLoginInfo != null) {
            j3 = liveLoginInfo.getUid();
        } else {
            j3 = 0;
        }
        bVar.f408994a = j3;
        if (liveLoginInfo != null) {
            j16 = liveLoginInfo.getTinyId();
        }
        bVar.f408995b = j16;
        if (liveLoginInfo == null || (str = liveLoginInfo.getA2()) == null) {
            str = "";
        }
        bVar.f408996c = str;
        if (liveLoginInfo == null || (str2 = liveLoginInfo.getAccessToken()) == null) {
            str2 = "";
        }
        bVar.f409003j = str2;
        if (liveLoginInfo == null || (str3 = liveLoginInfo.getOpenId()) == null) {
            str3 = "";
        }
        bVar.f409002i = str3;
        bVar.f409013t = "0.0.1-snapshot";
        bVar.f409014u = str4;
        bVar.f409015v = getMainCmd();
        bVar.f409016w = getSubCmd();
        bVar.f409017z = 109;
        bVar.A = 0;
        bVar.f409006m = "";
        bVar.f409011r = "";
        bVar.f409008o = new iz0.a[0];
        bVar.f409012s = new d[0];
        bVar.E = ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo();
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(proxyReq)");
        return byteArray;
    }

    @NotNull
    public abstract String getSubCmd();

    public boolean needLogin() {
        return true;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public Object[] parseResponseHeadInfo(@Nullable byte[] responseBytes) {
        Object[] objArr = {-1, "\u5e8f\u5217\u5316\u5f02\u5e38", new byte[0]};
        try {
            c c16 = c.c(fh.a(responseBytes));
            int i3 = c16.f409018a;
            if (i3 != 0) {
                objArr[0] = Long.valueOf(i3);
                String str = c16.f409019b;
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.errMsg");
                objArr[1] = str;
                rt0.a.INSTANCE.q(LOG_TAG, "", "proxy error, " + getMainCmd() + "." + getSubCmd() + ", retCode=" + c16.f409018a + ", errMsg=" + c16.f409019b);
            } else {
                int i16 = c16.f409023f;
                if (i16 != 0) {
                    objArr[0] = Long.valueOf(i16);
                    String str2 = c16.f409024g;
                    Intrinsics.checkNotNullExpressionValue(str2, "proxyRsp.busiErrorMsg");
                    objArr[1] = str2;
                    rt0.a.INSTANCE.q(LOG_TAG, "", "busi error, " + getMainCmd() + "." + getSubCmd() + ", retCode=" + c16.f409023f + ", errMsg=" + c16.f409024g);
                } else {
                    objArr[0] = 0L;
                    objArr[1] = "";
                }
            }
            byte[] bArr = c16.f409020c;
            Intrinsics.checkNotNullExpressionValue(bArr, "proxyRsp.busiBuf");
            objArr[2] = bArr;
        } catch (InvalidProtocolBufferNanoException e16) {
            rt0.a.INSTANCE.h(LOG_TAG, "parseResponseHeadInfo", "cmd=" + getMainCmd() + "." + getSubCmd() + ", " + e16);
        }
        return objArr;
    }

    public final void setLoginInfo(@Nullable LiveLoginInfo liveLoginInfo) {
        this.loginInfo = liveLoginInfo;
    }
}

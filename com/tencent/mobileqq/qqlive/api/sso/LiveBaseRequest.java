package com.tencent.mobileqq.qqlive.api.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.a;
import com.tencent.mobileqq.qqlive.huya.c;
import com.tencent.mobileqq.qqlive.huya.m;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.utils.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.util.QQDeviceInfo;
import dr4.b;
import dr4.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000 #*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0004H&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "T", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "wantAppId", "", "(Ljava/lang/String;)V", "loginInfo", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "getLoginInfo", "()Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "setLoginInfo", "(Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;)V", "getAppId", "getClientType", "", "getCmdName", "getMainCmd", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "", "getRequestWrapper", "requestBizData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "getSubCmd", "isPushCmd", "", "mainCmd", "subCmd", "needLogin", "parseResponseHeadInfo", "", "", "responseBytes", "([B)[Ljava/lang/Object;", "Companion", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public abstract class LiveBaseRequest<T> extends VSBaseRequest {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String LOG_TAG = "VSRequest|LiveBaseRequest";
    private static final int PLAT_ID = 109;

    @NotNull
    public static final String QQ_LIVE_MSG_PUSH_CMD = "trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr";

    @NotNull
    public static final String QQ_LIVE_MSG_PUSH_SUBCMD = "PullMsgProxy";
    public static final int UNKNOWN_CLIENT_TYPE = -1;

    @Nullable
    private LiveLoginInfo loginInfo;

    @NotNull
    private final String wantAppId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest$Companion;", "", "()V", "LOG_TAG", "", "PLAT_ID", "", "QQ_LIVE_MSG_PUSH_CMD", "QQ_LIVE_MSG_PUSH_SUBCMD", "UNKNOWN_CLIENT_TYPE", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30532);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveBaseRequest(@NotNull String wantAppId) {
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wantAppId);
        } else {
            this.wantAppId = wantAppId;
        }
    }

    private final int getClientType() {
        a a16 = a.INSTANCE.a(getAppId());
        int e16 = a16.a().e();
        if (isPushCmd(getMainCmd(), getSubCmd()) && a16.a().i() != -1) {
            return a16.a().i();
        }
        return e16;
    }

    private final boolean isPushCmd(String mainCmd, String subCmd) {
        if (!Intrinsics.areEqual("trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr", mainCmd) && !Intrinsics.areEqual("PullMsgProxy", subCmd)) {
            return false;
        }
        return true;
    }

    @NotNull
    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.wantAppId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "trpc.qlive.qlive_proxy_svr.TrpcProxy.*";
    }

    @Nullable
    public final LiveLoginInfo getLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveLoginInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.loginInfo;
    }

    @NotNull
    public abstract String getMainCmd();

    @NotNull
    public abstract MessageNano getMessageNano();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public byte[] getRequestByteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) requestBizData);
        }
        Intrinsics.checkNotNullParameter(requestBizData, "requestBizData");
        b bVar = new b();
        bVar.f394694d = getClientType();
        String str4 = AppSetting.f99551k;
        bVar.f394695e = str4;
        bVar.f394696f = requestBizData.toByteArray();
        bVar.f394697g = TVKEventId.PLAYER_STATE_SWITCHDEF_START;
        bVar.f394698h = 0;
        String qimei = QQDeviceInfo.getQIMEI();
        Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
        byte[] bytes = qimei.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        bVar.f394706p = bytes;
        bVar.C = h.a();
        bVar.f394704n = 0;
        bVar.f394707q = 37;
        LiveLoginInfo liveLoginInfo = this.loginInfo;
        if (liveLoginInfo == null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        bVar.f394701k = i3;
        long j16 = 0;
        if (liveLoginInfo != null) {
            j3 = liveLoginInfo.q();
        } else {
            j3 = 0;
        }
        bVar.f394691a = j3;
        if (liveLoginInfo != null) {
            j16 = liveLoginInfo.p();
        }
        bVar.f394692b = j16;
        if (liveLoginInfo == null || (str = liveLoginInfo.c()) == null) {
            str = "";
        }
        bVar.f394693c = str;
        if (liveLoginInfo == null || (str2 = liveLoginInfo.f()) == null) {
            str2 = "";
        }
        bVar.f394700j = str2;
        if (liveLoginInfo == null || (str3 = liveLoginInfo.n()) == null) {
            str3 = "";
        }
        bVar.f394699i = str3;
        bVar.f394710t = "0.0.1-snapshot";
        bVar.f394711u = str4;
        bVar.f394712v = getMainCmd();
        bVar.f394713w = getSubCmd();
        bVar.f394714z = 109;
        bVar.A = 0;
        bVar.f394703m = "";
        bVar.f394708r = "";
        bVar.f394705o = new dr4.a[0];
        bVar.f394709s = new d[0];
        bVar.E = ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo();
        ArrayList arrayList = new ArrayList();
        c g16 = m.f271359a.g();
        if (g16 != null) {
            dr4.a aVar = new dr4.a();
            aVar.f394688a = g16.b();
            aVar.f394689b = g16.a();
            aVar.f394690c = 100;
            arrayList.add(aVar);
        }
        Object[] array = arrayList.toArray(new dr4.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.F = (dr4.a[]) array;
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(proxyReq)");
        return byteArray;
    }

    @NotNull
    public abstract String getSubCmd();

    public boolean needLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public Object[] parseResponseHeadInfo(@Nullable byte[] responseBytes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Object[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) responseBytes);
        }
        Object[] objArr = {-1, "\u5e8f\u5217\u5316\u5f02\u5e38", new byte[0]};
        try {
            dr4.c c16 = dr4.c.c(fh.a(responseBytes));
            int i3 = c16.f394715a;
            if (i3 != 0) {
                objArr[0] = Long.valueOf(i3);
                String str = c16.f394716b;
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.errMsg");
                objArr[1] = str;
                AegisLogger.INSTANCE.w(LOG_TAG, "", "proxy error, " + getMainCmd() + "." + getSubCmd() + ", retCode=" + c16.f394715a + ", errMsg=" + c16.f394716b);
            } else {
                int i16 = c16.f394720f;
                if (i16 != 0) {
                    objArr[0] = Long.valueOf(i16);
                    String str2 = c16.f394721g;
                    Intrinsics.checkNotNullExpressionValue(str2, "proxyRsp.busiErrorMsg");
                    objArr[1] = str2;
                    AegisLogger.INSTANCE.w(LOG_TAG, "", "busi error, " + getMainCmd() + "." + getSubCmd() + ", retCode=" + c16.f394720f + ", errMsg=" + c16.f394721g);
                } else {
                    objArr[0] = 0L;
                    objArr[1] = "";
                }
            }
            byte[] bArr = c16.f394717c;
            Intrinsics.checkNotNullExpressionValue(bArr, "proxyRsp.busiBuf");
            objArr[2] = bArr;
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e(LOG_TAG, "parseResponseHeadInfo", "cmd=" + getMainCmd() + "." + getSubCmd() + ", " + e16);
        }
        return objArr;
    }

    public final void setLoginInfo(@Nullable LiveLoginInfo liveLoginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) liveLoginInfo);
        } else {
            this.loginInfo = liveLoginInfo;
        }
    }
}

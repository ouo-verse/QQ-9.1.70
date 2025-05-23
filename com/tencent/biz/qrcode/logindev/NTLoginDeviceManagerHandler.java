package com.tencent.biz.qrcode.logindev;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqlogin.nt_ldm.NTLoginDeviceManager$AutoLoginSwitch;
import qqlogin.nt_ldm.NTLoginDeviceManager$GetAutoLoginSwitchesReq;
import qqlogin.nt_ldm.NTLoginDeviceManager$GetAutoLoginSwitchesRsp;
import qqlogin.nt_ldm.NTLoginDeviceManager$UpdateAutoLoginSwitchReq;
import qqlogin.nt_ldm.NTLoginDeviceManager$UpdateAutoLoginSwitchRsp;
import rd0.i;
import rd0.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002*+B\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0015\u001a\u00020\b2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0019\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016R\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/NTLoginDeviceManagerHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", Constants.MMCCID, "H2", "I2", "", "F2", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/Integer;", "onReceive", "", "Lrd0/i;", "deviceList", "Lrd0/j;", "callback", "J2", "loginApp", "", "autoLogin", "K2", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "", "getCommandList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isGettingTrustedDevices", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class NTLoginDeviceManagerHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isGettingTrustedDevices;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static String f94942f = "NTLoginDeviceManagerHandler";

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static String f94943h = "OidbSvcTrpcTcp.0x1270";

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static String f94944i = "OidbSvcTrpcTcp.0x1277";

    /* renamed from: m, reason: collision with root package name */
    private static int f94945m = 1;
    private static int C = 2;
    private static long D = 10000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/NTLoginDeviceManagerHandler$a;", "", "", "TYPE_GET_TRUSTED_DEVICE_LIST", "I", "a", "()I", "setTYPE_GET_TRUSTED_DEVICE_LIST", "(I)V", "TYPE_UPDATE_AUTO_LOGIN_SWITCH", "b", "setTYPE_UPDATE_AUTO_LOGIN_SWITCH", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qrcode.logindev.NTLoginDeviceManagerHandler$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return NTLoginDeviceManagerHandler.f94945m;
        }

        public final int b() {
            return NTLoginDeviceManagerHandler.C;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/NTLoginDeviceManagerHandler$b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lrd0/j;", "d", "Lrd0/j;", "callback", "<init>", "(Lrd0/j;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    private static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final j callback;

        public b(@NotNull j callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            Companion companion = NTLoginDeviceManagerHandler.INSTANCE;
            if (type == companion.a()) {
                this.callback.a(isSuccess, data);
            } else if (type == companion.b()) {
                this.callback.b(isSuccess, data);
            }
        }
    }

    public NTLoginDeviceManagerHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        this.isGettingTrustedDevices = new AtomicBoolean(false);
    }

    private final Integer F2(FromServiceMsg res) {
        Integer num;
        Integer num2 = null;
        if (res != null) {
            num = Integer.valueOf(res.getTrpcRspFuncRetCode());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (res != null) {
                num = Integer.valueOf(res.getTrpcRspRetCode());
            } else {
                num = null;
            }
        }
        if (num != null && num.intValue() == 0) {
            if (res != null) {
                num2 = Integer.valueOf(res.getResultCode());
            }
            return num2;
        }
        return num;
    }

    private final void G2(ToServiceMsg req, FromServiceMsg res, Object data) {
        NTLoginDeviceManager$GetAutoLoginSwitchesRsp nTLoginDeviceManager$GetAutoLoginSwitchesRsp = new NTLoginDeviceManager$GetAutoLoginSwitchesRsp();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, nTLoginDeviceManager$GetAutoLoginSwitchesRsp);
        this.isGettingTrustedDevices.set(false);
        if (parseOIDBPkg == 0) {
            List<NTLoginDeviceManager$AutoLoginSwitch> list = nTLoginDeviceManager$GetAutoLoginSwitchesRsp.auto_login_switches.get();
            ArrayList arrayList = new ArrayList();
            for (NTLoginDeviceManager$AutoLoginSwitch nTLoginDeviceManager$AutoLoginSwitch : list) {
                i iVar = new i();
                iVar.c(nTLoginDeviceManager$AutoLoginSwitch);
                QLog.d(f94942f, 1, "handleTrustedDeviceListRsp, " + iVar);
                arrayList.add(iVar);
            }
            notifyUI(req, f94945m, true, (Object) arrayList);
            return;
        }
        QLog.i(f94942f, 1, "handleTrustedDeviceListRsp failed.");
        I2(res);
        notifyUI(req, f94945m, false, (Object) F2(res));
    }

    private final void H2(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (OidbWrapper.parseOIDBPkg(res, data, new MessageMicro<NTLoginDeviceManager$UpdateAutoLoginSwitchRsp>() { // from class: qqlogin.nt_ldm.NTLoginDeviceManager$UpdateAutoLoginSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], NTLoginDeviceManager$UpdateAutoLoginSwitchRsp.class);
        }) == 0) {
            QLog.i(f94942f, 1, "handleUpdateAutoLoginSwitchRsp success.");
            notifyUI(req, C, true, (Object) null);
        } else {
            QLog.i(f94942f, 1, "handleUpdateAutoLoginSwitchRsp failed.");
            I2(res);
            notifyUI(req, C, false, (Object) F2(res));
        }
    }

    private final void I2(FromServiceMsg res) {
        Integer num;
        Integer num2;
        Integer num3;
        String str;
        byte[] trpcRspErrorMsg;
        String str2 = f94942f;
        String str3 = null;
        if (res != null) {
            num = Integer.valueOf(res.getResultCode());
        } else {
            num = null;
        }
        if (res != null) {
            num2 = Integer.valueOf(res.getTrpcRspRetCode());
        } else {
            num2 = null;
        }
        if (res != null) {
            num3 = Integer.valueOf(res.getTrpcRspFuncRetCode());
        } else {
            num3 = null;
        }
        if (res != null && (trpcRspErrorMsg = res.getTrpcRspErrorMsg()) != null) {
            str = new String(trpcRspErrorMsg, Charsets.UTF_8);
        } else {
            str = null;
        }
        if (res != null) {
            str3 = res.getBusinessFailMsg();
        }
        QLog.i(str2, 1, "[ret = " + num + ", trpcRspRetCode = " + num2 + ", trpcRspFuncRetCode = " + num3 + ", trpcRspErrorMsg = " + str + ", msg = " + str3 + "]");
    }

    public final void J2(@Nullable List<i> deviceList, @Nullable j callback) {
        if (deviceList != null && callback != null) {
            if (this.isGettingTrustedDevices.get()) {
                QLog.i(f94942f, 1, "requestGetTrustDeviceList, repeat request, ignore.");
                return;
            }
            this.isGettingTrustedDevices.set(true);
            NTLoginDeviceManager$GetAutoLoginSwitchesReq nTLoginDeviceManager$GetAutoLoginSwitchesReq = new NTLoginDeviceManager$GetAutoLoginSwitchesReq();
            ArrayList arrayList = new ArrayList();
            Iterator<i> it = deviceList.iterator();
            while (it.hasNext()) {
                NTLoginDeviceManager$AutoLoginSwitch a16 = it.next().a();
                Intrinsics.checkNotNullExpressionValue(a16, "item.convertToAutoLoginSwitch()");
                arrayList.add(a16);
            }
            if (arrayList.size() == 0) {
                return;
            }
            nTLoginDeviceManager$GetAutoLoginSwitchesReq.auto_login_switches.set(arrayList);
            nTLoginDeviceManager$GetAutoLoginSwitchesReq.setHasFlag(true);
            sendPbReq(makeOIDBPkg(f94943h, 4720, 0, nTLoginDeviceManager$GetAutoLoginSwitchesReq.toByteArray(), D, new b(callback), false));
            return;
        }
        QLog.i(f94942f, 1, "requestGetTrustDeviceList, invalid params");
    }

    public final void K2(@Nullable i loginApp, boolean autoLogin, @Nullable j callback) {
        if (loginApp != null && !loginApp.b() && callback != null) {
            QLog.i(f94942f, 1, "requestUpdateAutoLoginSwitch start, autoLogin = " + autoLogin);
            NTLoginDeviceManager$UpdateAutoLoginSwitchReq nTLoginDeviceManager$UpdateAutoLoginSwitchReq = new NTLoginDeviceManager$UpdateAutoLoginSwitchReq();
            NTLoginDeviceManager$AutoLoginSwitch a16 = loginApp.a();
            if (autoLogin) {
                a16.auto_login.set(1);
            } else {
                a16.auto_login.set(2);
            }
            nTLoginDeviceManager$UpdateAutoLoginSwitchReq.auto_login_switch.set(a16);
            nTLoginDeviceManager$UpdateAutoLoginSwitchReq.setHasFlag(true);
            sendPbReq(makeOIDBPkg(f94944i, 4727, 0, nTLoginDeviceManager$UpdateAutoLoginSwitchReq.toByteArray(), D, new b(callback), false));
            return;
        }
        QLog.i(f94942f, 1, "requestUpdateAutoLoginSwitch, invalid params");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(f94943h);
            this.allowCmdSet.add(f94944i);
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        if (res != null) {
            str = res.getServiceCmd();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(f94943h, str)) {
            G2(req, res, data);
        } else if (Intrinsics.areEqual(f94944i, str)) {
            H2(req, res, data);
        }
    }
}

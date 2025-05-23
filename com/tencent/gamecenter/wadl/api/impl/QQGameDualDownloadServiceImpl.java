package com.tencent.gamecenter.wadl.api.impl;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.i;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqgame.QQGameSwitch$QuerySwitchReq;
import tencent.im.qqgame.QQGameSwitch$SetSwitchReq;
import tencent.im.qqgame.QQGameSwitch$SsoQuerySwitchRsp;
import tencent.im.qqgame.QQGameSwitch$SsoSwitch;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0016\u0010\u0016\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/impl/QQGameDualDownloadServiceImpl;", "Lcom/tencent/gamecenter/wadl/api/IQQGameDualDownloadService;", "", "isMobileEnable", "getKingCardStatus", "isKingCard", "", "status", "covertToSvrSwitchStatus", "covertToFrontSwitchStatus", "statusVal", "switchId", "", "setDualSwitchAsync", "setDualSwitch", "", "Ljl0/a;", "callback", "getAutoDualGameSwitch", "getCacheDualSwitch", "", "switchIds", "getDualSwitchAsync", "jsonParams", "doDualDownload", "isFlowSwitchOn", "hasSimCard", "Lmqq/app/NewIntent;", "intent", "sendReq", "autoDualSwitch", "I", "<init>", "()V", "Companion", "a", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQGameDualDownloadServiceImpl implements IQQGameDualDownloadService {
    public static final int AUTO_DUAL_SWITCH_CLOSE = 0;
    public static final int AUTO_DUAL_SWITCH_ID = 27;
    public static final int AUTO_DUAL_SWITCH_OPEN = 1;
    public static final int AUTO_DUAL_SWITCH_UNKNOWN = -1;
    public static final int KINGCARD_STATUS_OK = 1;

    @NotNull
    public static final String TAG = "Wadl_QQGameDualDownloadServiceImpl";
    private int autoDualSwitch = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAutoDualGameSwitch$lambda$7(QQGameDualDownloadServiceImpl this$0, jl0.a callback, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            try {
                if (bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
                    QQGameSwitch$SsoQuerySwitchRsp qQGameSwitch$SsoQuerySwitchRsp = new QQGameSwitch$SsoQuerySwitchRsp();
                    qQGameSwitch$SsoQuerySwitchRsp.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
                    List<QQGameSwitch$SsoSwitch> list = qQGameSwitch$SsoQuerySwitchRsp.switches.get();
                    if (list != null && (!list.isEmpty())) {
                        int i16 = list.get(0).status.get();
                        QLog.i(TAG, 2, "status=" + i16 + ", switchId=" + list.get(0).switch_id.get());
                        int covertToFrontSwitchStatus = this$0.covertToFrontSwitchStatus(i16);
                        this$0.autoDualSwitch = covertToFrontSwitchStatus;
                        callback.a(covertToFrontSwitchStatus);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "[getAutoDualGameSwitch], error: " + th5);
                return;
            }
        }
        QLog.i(TAG, 2, "isSuccess " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDualSwitchAsync$lambda$8(QQGameDualDownloadServiceImpl this$0, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
            QQGameSwitch$SsoQuerySwitchRsp qQGameSwitch$SsoQuerySwitchRsp = new QQGameSwitch$SsoQuerySwitchRsp();
            qQGameSwitch$SsoQuerySwitchRsp.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
            List<QQGameSwitch$SsoSwitch> list = qQGameSwitch$SsoQuerySwitchRsp.switches.get();
            if (list != null && (!list.isEmpty())) {
                int i16 = list.get(0).status.get();
                QLog.i(TAG, 2, "isSuccess=" + z16 + ", swithValue=" + i16 + ", switchId=" + list.get(0).switch_id.get());
                i.o(this$0.covertToFrontSwitchStatus(i16));
                return;
            }
            return;
        }
        QLog.i(TAG, 2, "isSuccess " + z16);
    }

    private final boolean isMobileEnable() {
        Object systemService = MobileQQ.sMobileQQ.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            Method method = connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(connectivityManager, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDualSwitchAsync$lambda$3(int i3, QQGameDualDownloadServiceImpl this$0, int i16, int i17, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 2, "isSuccess=" + z16);
        if (i3 == 27) {
            this$0.autoDualSwitch = i16;
            QLog.i(TAG, 1, "update autoDualSwitch value, autoDualSwitch:" + i16);
        }
    }

    public final int covertToFrontSwitchStatus(int status) {
        if (status == 1) {
            return 1;
        }
        if (status != 2) {
            return 2;
        }
        return 0;
    }

    public final int covertToSvrSwitchStatus(int status) {
        if (status == 0 || status != 1) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public void doDualDownload(@Nullable String jsonParams) {
        WadlParams wadlParams = new WadlParams(jsonParams);
        wadlParams.from = 0;
        wadlParams.isDualDownload = true;
        WadlProxyServiceUtil.getProxyService().dispatchAction(wadlParams);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public void getAutoDualGameSwitch(int switchId, @NotNull final jl0.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = this.autoDualSwitch;
        if (i3 != -1) {
            QLog.i(TAG, 1, "[getAutoDualGameSwitch], cached value:" + i3);
            callback.a(this.autoDualSwitch);
            return;
        }
        QQGameSwitch$QuerySwitchReq qQGameSwitch$QuerySwitchReq = new QQGameSwitch$QuerySwitchReq();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(switchId));
        qQGameSwitch$QuerySwitchReq.switch_ids.set(arrayList);
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_QUERY_SWITCH);
        newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, qQGameSwitch$QuerySwitchReq.toByteArray());
        newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.gamecenter.wadl.api.impl.a
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i16, boolean z16, Bundle bundle) {
                QQGameDualDownloadServiceImpl.getAutoDualGameSwitch$lambda$7(QQGameDualDownloadServiceImpl.this, callback, i16, z16, bundle);
            }
        });
        sendReq(newIntent);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public int getCacheDualSwitch() {
        return i.h();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public void getDualSwitchAsync(@NotNull List<Integer> switchIds) {
        Intrinsics.checkNotNullParameter(switchIds, "switchIds");
        QQGameSwitch$QuerySwitchReq qQGameSwitch$QuerySwitchReq = new QQGameSwitch$QuerySwitchReq();
        qQGameSwitch$QuerySwitchReq.switch_ids.set(switchIds);
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_QUERY_SWITCH);
        newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, qQGameSwitch$QuerySwitchReq.toByteArray());
        newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.gamecenter.wadl.api.impl.b
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                QQGameDualDownloadServiceImpl.getDualSwitchAsync$lambda$8(QQGameDualDownloadServiceImpl.this, i3, z16, bundle);
            }
        });
        sendReq(newIntent);
    }

    public final boolean getKingCardStatus() {
        int a16 = com.tencent.mobileqq.vip.e.a();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "kingStatus: " + a16);
        }
        if (a16 == 1 && NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public boolean hasSimCard() {
        try {
            Object systemService = MobileQQ.sMobileQQ.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int simState = ((TelephonyManager) systemService).getSimState();
            if (simState == 0 || simState == 1) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[hasSimCard] error: ", th5);
            return false;
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public boolean isFlowSwitchOn() {
        return isMobileEnable();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public boolean isKingCard() {
        Object m476constructorimpl;
        boolean z16;
        if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ) && !isMobileEnable()) {
            QLog.e(TAG, 1, "only wifi connected\uff01\uff01\uff01");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(getKingCardStatus()));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            z16 = ((Boolean) m476constructorimpl).booleanValue();
        } else {
            z16 = false;
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(TAG, 1, m479exceptionOrNullimpl, new Object[0]);
            return false;
        }
        return z16;
    }

    public final void sendReq(@NotNull NewIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 2, "[getAutoDownloadTask] appRuntime is null");
        } else {
            peekAppRuntime.startServlet(intent);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public void setDualSwitch(int status, int switchId) {
        setDualSwitchAsync(status, switchId);
    }

    public final void setDualSwitchAsync(final int statusVal, final int switchId) {
        QLog.i(TAG, 1, "[setDualSwitchAsync], statusVal=" + statusVal + "\uff0c switchId=" + switchId);
        QQGameSwitch$SetSwitchReq qQGameSwitch$SetSwitchReq = new QQGameSwitch$SetSwitchReq();
        qQGameSwitch$SetSwitchReq.switch_id.set(switchId);
        qQGameSwitch$SetSwitchReq.status.set(covertToSvrSwitchStatus(statusVal));
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_SET_SWITCH);
        newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, qQGameSwitch$SetSwitchReq.toByteArray());
        newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.gamecenter.wadl.api.impl.c
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                QQGameDualDownloadServiceImpl.setDualSwitchAsync$lambda$3(switchId, this, statusVal, i3, z16, bundle);
            }
        });
        sendReq(newIntent);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService
    public void setDualSwitch(@NotNull String status) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(status, "status");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(Integer.parseInt(status)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        int intValue = Result.m479exceptionOrNullimpl(m476constructorimpl) == null ? Result.m483isSuccessimpl(m476constructorimpl) ? ((Number) m476constructorimpl).intValue() : 0 : 0;
        i.o(intValue);
        setDualSwitchAsync(intValue, 5);
    }
}

package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$GetEncryptedUinReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$GetEncryptedUinRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$GetNewWidgetReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$GetNewWidgetRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private HashSet<String> f212321a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private WadlTrpcListener f212322b = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements WadlTrpcListener {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return f.this.f212321a;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            if (QLog.isColorLevel()) {
                QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[onTrpcRsp] onTrpcRsp cmd:" + str + " ret:" + j3);
            }
            if ("/v1/1119".equals(str)) {
                f.this.f(intent, j3, trpcInovkeRsp);
            } else if ("/v1/1120".equals(str)) {
                f.this.e(intent, j3, trpcInovkeRsp);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f212324a;

        b(int i3) {
            this.f212324a = i3;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[onFail],errMsg: " + str);
            f.this.h("", this.f212324a);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[onSuccess]");
            if (map == null || map.size() == 0) {
                f.this.h("", this.f212324a);
                return;
            }
            String str = map.get("gamecenter.qq.com");
            if (TextUtils.isEmpty(str)) {
                QLog.w("GCWidget.WidgetUpdateProtoHandler", 1, "pskey is empty==========");
            }
            f.this.h(str, this.f212324a);
        }
    }

    public f() {
        this.f212321a.add("/v1/1119");
        this.f212321a.add("/v1/1120");
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f212322b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        String str;
        boolean z16;
        QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetEncryptedUin], retCode:" + j3);
        try {
            if (j3 == 0 && trpcInovkeRsp != null) {
                QQWidgetSvr$GetEncryptedUinRsp qQWidgetSvr$GetEncryptedUinRsp = new QQWidgetSvr$GetEncryptedUinRsp();
                qQWidgetSvr$GetEncryptedUinRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                if (qQWidgetSvr$GetEncryptedUinRsp.encrypted_uin.get() == null) {
                    str = "";
                } else {
                    str = qQWidgetSvr$GetEncryptedUinRsp.encrypted_uin.get();
                }
                QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("gamecenter_appwidget_widget_encrypted_uin", str);
                if (!TextUtils.isEmpty(str)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetEncryptedUin] is valid:" + z16);
                IGameCenterWidgetMgrApi iGameCenterWidgetMgrApi = (IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class);
                if (z16 && iGameCenterWidgetMgrApi.isPullConfigTimeUpV2() && iGameCenterWidgetMgrApi.hasWidgetV2()) {
                    QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetEncryptedUin] req after handleGetEncryptedUin");
                    iGameCenterWidgetMgrApi.fetchWidgetConfigFromSvrV2();
                    return;
                }
                return;
            }
            QLog.w("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetEncryptedUin] rsp errors!");
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetEncryptedUin], th:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Intent intent, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetWidgetConfigV2], retCode:" + j3);
        try {
            if (j3 == 0 && trpcInovkeRsp != null) {
                QQWidgetSvr$GetNewWidgetRsp qQWidgetSvr$GetNewWidgetRsp = new QQWidgetSvr$GetNewWidgetRsp();
                qQWidgetSvr$GetNewWidgetRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).updateWidgetConfigV3(qQWidgetSvr$GetNewWidgetRsp.widget_type.get(), qQWidgetSvr$GetNewWidgetRsp.battlepass_widget.get(), qQWidgetSvr$GetNewWidgetRsp.widget.get(), qQWidgetSvr$GetNewWidgetRsp.next_pull_time.get());
                return;
            }
            QLog.w("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetWidgetConfigV2] rsp errors!");
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[handleGetWidgetConfigV2], th:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, int i3) {
        String str2 = "";
        try {
            String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("gamecenter_appwidget_widget_encrypted_uin", "");
            if (TextUtils.isEmpty(decodeString)) {
                QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[sendWidgetRequestV2] encryptedUin is empty");
                return;
            }
            QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[sendWidgetRequestV2] scene:" + i3);
            QQWidgetSvr$GetNewWidgetReq qQWidgetSvr$GetNewWidgetReq = new QQWidgetSvr$GetNewWidgetReq();
            qQWidgetSvr$GetNewWidgetReq.source.set(0);
            qQWidgetSvr$GetNewWidgetReq.encrypted_uin.set(decodeString);
            qQWidgetSvr$GetNewWidgetReq.device_type.set(Build.BRAND);
            qQWidgetSvr$GetNewWidgetReq.pskey.set(str);
            qQWidgetSvr$GetNewWidgetReq.platform.set(1);
            qQWidgetSvr$GetNewWidgetReq.mobile_version.set(String.valueOf(Build.VERSION.SDK_INT));
            PBStringField pBStringField = qQWidgetSvr$GetNewWidgetReq.device_number;
            if (o.b() != null) {
                str2 = o.b();
            }
            pBStringField.set(str2);
            qQWidgetSvr$GetNewWidgetReq.qq_version.set(AppSetting.f99551k);
            qQWidgetSvr$GetNewWidgetReq.scene.set(i3);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1119", false, qQWidgetSvr$GetNewWidgetReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WadlProxyConsts.PARAM_WEBSSO_IS_WITHOUT_LOGIN, true);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[sendWidgetRequestV2], th:" + th5);
        }
    }

    public void g() {
        try {
            QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[sendGetEncryptedUinReq]");
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/1120", false, new MessageMicro<QQWidgetSvr$GetEncryptedUinReq>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$GetEncryptedUinReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQWidgetSvr$GetEncryptedUinReq.class);
            }.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, new Bundle());
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[sendGetEncryptedUinReq], th:" + th5);
        }
    }

    public void i(int i3) {
        try {
            QLog.i("GCWidget.WidgetUpdateProtoHandler", 1, "[getPskey]");
            IPskeyManager iPskeyManager = (IPskeyManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPskeyManager.class, "");
            if (iPskeyManager == null) {
                h("", i3);
            } else {
                iPskeyManager.getPskey(new String[]{"gamecenter.qq.com"}, new b(i3));
            }
        } catch (Throwable th5) {
            QLog.e("GCWidget.WidgetUpdateProtoHandler", 1, "[getPskey], th:" + th5);
            h("", i3);
        }
    }
}

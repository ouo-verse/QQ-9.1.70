package com.tencent.mobileqq.qqgamepub.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$ResourcePermitReq;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$URLResourceItem;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$URLResourcePermitReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameFlowControlServiceImpl implements IQQGameFlowControlService {
    static IPatchRedirector $redirector_ = null;
    private static final String CMD_RES_FLOW_CONTROL = "/v1/63";
    private static final String JSON_KEY_CAN_REQ_TIME = "canReqTime";
    private static final String JSON_KEY_RES_STATE = "resState";
    private static final String SP_FLOW_CONTROL = "sp_game_res_flow_control";
    private static final String SP_KEY_HOST = "host_";
    public static final String TAG = "QQGamePub_QQGameFlowControlServiceImpl";

    public QQGameFlowControlServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getFileLength(String str) {
        int i3;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            i3 = httpURLConnection.getContentLength();
            try {
                httpURLConnection.disconnect();
            } catch (IOException e16) {
                e = e16;
                QLog.e(TAG, 1, e, new Object[0]);
                return i3;
            }
        } catch (IOException e17) {
            e = e17;
            i3 = 0;
        }
        return i3;
    }

    public static String getHost(String str) {
        if (str == null) {
            return "";
        }
        if (!URLUtil.isValidUrl(str)) {
            str = "https://" + str;
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    private QQGameResFlowControl$URLResourcePermitReq getResourcePermitReq(int i3, List<String> list) {
        QQGameResFlowControl$URLResourcePermitReq qQGameResFlowControl$URLResourcePermitReq = new QQGameResFlowControl$URLResourcePermitReq();
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < list.size(); i16++) {
            String str = list.get(i16);
            int fileLength = getFileLength(str);
            if (fileLength <= 0) {
                QLog.e(TAG, 1, "[checkResFlowControl] resSize is invalid,url:" + str);
            } else {
                QQGameResFlowControl$URLResourceItem qQGameResFlowControl$URLResourceItem = new QQGameResFlowControl$URLResourceItem();
                qQGameResFlowControl$URLResourceItem.res_size.set(fileLength);
                qQGameResFlowControl$URLResourceItem.res_url.set(str);
                arrayList.add(qQGameResFlowControl$URLResourceItem);
            }
        }
        qQGameResFlowControl$URLResourcePermitReq.resource_list.set(arrayList);
        qQGameResFlowControl$URLResourcePermitReq.scene_id.set(i3);
        return qQGameResFlowControl$URLResourcePermitReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkResFlowControl$0(List list, WadlTrpcListener wadlTrpcListener, int i3) {
        if (list != null && !list.isEmpty() && wadlTrpcListener != null) {
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(IQQGameFlowControlService.CMD_RES_FLOW_CONTROL_BATCH, false, getResourcePermitReq(i3, list).toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(wadlTrpcListener);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, null);
            return;
        }
        QLog.e(TAG, 1, "[checkResFlowControl] urlList or ls is empty");
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
    public void checkResFlowControl(String str, WadlTrpcListener wadlTrpcListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            checkResFlowControl(str, (String) null, wadlTrpcListener);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) wadlTrpcListener);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
    public com.tencent.mobileqq.qqgamepub.data.e getFlowControlConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.qqgamepub.data.e) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        String host = getHost(str);
        if (!TextUtils.isEmpty(host)) {
            try {
                String string = BaseApplication.getContext().getSharedPreferences(SP_FLOW_CONTROL, 4).getString(SP_KEY_HOST + host, "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    com.tencent.mobileqq.qqgamepub.data.e eVar = new com.tencent.mobileqq.qqgamepub.data.e();
                    eVar.f264507a = jSONObject.optInt(JSON_KEY_RES_STATE);
                    eVar.f264508b = jSONObject.optLong(JSON_KEY_CAN_REQ_TIME);
                    return eVar;
                }
                return null;
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
    public void saveFlowControlConfig(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        String host = getHost(str);
        if (!TextUtils.isEmpty(host)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JSON_KEY_RES_STATE, j3);
                jSONObject.put(JSON_KEY_CAN_REQ_TIME, j16);
                BaseApplication.getContext().getSharedPreferences(SP_FLOW_CONTROL, 4).edit().putString(SP_KEY_HOST + host, jSONObject.toString()).apply();
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
    public void checkResFlowControl(String str, String str2, WadlTrpcListener wadlTrpcListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            ThreadManagerV2.excute(new Runnable(str, wadlTrpcListener, str2) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlowControlServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f264408d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ WadlTrpcListener f264409e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f264410f;

                {
                    this.f264408d = str;
                    this.f264409e = wadlTrpcListener;
                    this.f264410f = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQGameFlowControlServiceImpl.this, str, wadlTrpcListener, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int fileLength = QQGameFlowControlServiceImpl.getFileLength(this.f264408d);
                    if (QLog.isColorLevel()) {
                        QLog.i(QQGameFlowControlServiceImpl.TAG, 1, "checkResFlowControl...resSize:" + fileLength + ",resUrl:" + this.f264408d);
                    }
                    if (fileLength > 0 && !TextUtils.isEmpty(this.f264408d) && this.f264409e != null) {
                        QQGameResFlowControl$ResourcePermitReq qQGameResFlowControl$ResourcePermitReq = new QQGameResFlowControl$ResourcePermitReq();
                        qQGameResFlowControl$ResourcePermitReq.res_size.set(fileLength);
                        qQGameResFlowControl$ResourcePermitReq.res_url.set(this.f264408d);
                        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(QQGameFlowControlServiceImpl.CMD_RES_FLOW_CONTROL, false, qQGameResFlowControl$ResourcePermitReq.toByteArray());
                        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
                        trpcListReq.list.add(createTrpcInvokeReq);
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f264409e);
                        Bundle bundle = new Bundle();
                        bundle.putString(WadlProxyConsts.RES_URL, this.f264408d);
                        if (!TextUtils.isEmpty(this.f264410f)) {
                            bundle.putString("appName", this.f264410f);
                        }
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
                    }
                }
            }, 128, null, false);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, wadlTrpcListener);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService
    public void checkResFlowControl(final int i3, final List<String> list, final WadlTrpcListener wadlTrpcListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQGameFlowControlServiceImpl.this.lambda$checkResFlowControl$0(list, wadlTrpcListener, i3);
                }
            }, 128, null, false);
        } else {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), list, wadlTrpcListener);
        }
    }
}

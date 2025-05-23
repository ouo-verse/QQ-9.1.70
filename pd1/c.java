package pd1;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.am;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import pd1.b;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ISPlayerPreDownloader.Listener {
        a() {
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onInfo(int i3, long j3, long j16, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("RequestPreloader", 2, "onInfo what\uff1a", Integer.valueOf(i3), " arg1:", Long.valueOf(j3), " arg2:", Long.valueOf(j16), " extInfo:", obj);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("RequestPreloader", 2, "onPrepareDownloadProgressUpdate taskId:", Integer.valueOf(i3), " playableDurationMS:", Integer.valueOf(i16), " downloadSpeedKBs:", Integer.valueOf(i17), " currentDownloadSizeByte:", Long.valueOf(j3));
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareError(int i3, int i16, int i17, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("RequestPreloader", 2, "onPrepareError taskId\uff1a", Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareSuccess(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("RequestPreloader", 2, "onPrepareSuccess taskId\uff1a", Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.C11004b f425930d;

        b(b.C11004b c11004b) {
            this.f425930d = c11004b;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            c.this.c(this.f425930d, z16, bundle);
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            jSONObject.put("model", DeviceInfoMonitor.getModel());
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("product", Build.PRODUCT);
            jSONObject.put("id", Build.ID);
            jSONObject.put("level", Build.VERSION.SDK_INT);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("cpu_abi2", Build.CPU_ABI2);
        } catch (Throwable th5) {
            QLog.e("RequestPreloader", 1, "getRomData e:" + th5);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.C11004b c11004b, boolean z16, Bundle bundle) {
        long j3;
        long j16;
        String str;
        String str2;
        if (c11004b != null && bundle != null) {
            if (!z16) {
                int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
                if (i3 == 1001) {
                    h(c11004b, 201, 0, HardCodeUtil.qqStr(R.string.f238617k9));
                    return;
                } else if (i3 != 1002 && i3 != 1013) {
                    h(c11004b, 255, 0, HardCodeUtil.qqStr(R.string.f238637ka));
                    return;
                } else {
                    h(c11004b, 202, 0, HardCodeUtil.qqStr(R.string.f238627k_));
                    return;
                }
            }
            try {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray == null) {
                    h(c11004b, 255, 0, "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                    return;
                }
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                if (webSSOAgent$UniSsoServerRsp.comm.has() && webSSOAgent$UniSsoServerRsp.comm.proctime.has()) {
                    j3 = webSSOAgent$UniSsoServerRsp.comm.proctime.get();
                } else {
                    j3 = -1;
                }
                if (webSSOAgent$UniSsoServerRsp.ret.has()) {
                    j16 = webSSOAgent$UniSsoServerRsp.ret.get();
                } else {
                    j16 = 0;
                }
                if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                    str = webSSOAgent$UniSsoServerRsp.errmsg.get();
                } else {
                    str = "SSO\u53d1\u9001\u6210\u529f";
                }
                if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                    str2 = webSSOAgent$UniSsoServerRsp.rspdata.get();
                } else {
                    str2 = null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, j16);
                jSONObject.put("msg", str);
                jSONObject.put("data", str2);
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("RequestPreloader", 2, "uniAgent callback svrCostTime:" + j3 + ", Json string=" + jSONObject);
                }
                c11004b.f425925h = jSONObject.toString();
                c11004b.f425924g = 2;
                c11004b.b(c11004b.f425920c, jSONObject.toString());
            } catch (Throwable th5) {
                QLog.e("RequestPreloader", 1, "onUniAgent, onReceive, Exception: " + th5);
                h(c11004b, 255, 0, "parse error");
            }
        }
    }

    private void f(b.C11004b c11004b, String str) {
        SuperPlayerVideoInfo createVideoInfoForUrl;
        if (TextUtils.isEmpty(c11004b.f425927j) && TextUtils.isEmpty(c11004b.f425928k)) {
            return;
        }
        ISPlayerPreDownloader createPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplication.getContext(), 106);
        createPreDownloader.setOnPreDownloadListener(new a());
        if (QLog.isColorLevel()) {
            QLog.d("RequestPreloader", 2, "preloadVideo url\uff1a", c11004b.f425927j);
        }
        if (!TextUtils.isEmpty(c11004b.f425928k)) {
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForTVideo(c11004b.f425928k);
        } else {
            createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(c11004b.f425927j, 101, (String) null);
        }
        createPreDownloader.startPreDownload(createVideoInfoForUrl, SafeBitmapFactory.PX_THRESHOID_DEFAULTS);
    }

    private void h(b.C11004b c11004b, int i3, int i16, String str) {
        if (c11004b == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, i3);
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, i16);
            jSONObject.put("msg", str);
            c11004b.f425925h = jSONObject.toString();
            c11004b.f425924g = 2;
            c11004b.b(c11004b.f425920c, jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d("RequestPreloader", 2, "uniAgentCallBack ssoRet:" + i3 + " businessRet:" + i16 + " msg:" + str);
            }
        } catch (Throwable th5) {
            QLog.e("RequestPreloader", 1, "uniAgentCallBack e:" + th5);
        }
    }

    public void d(pd1.b bVar, int i3, String str, pd1.a aVar) {
        if (bVar == null || !bVar.f425912a) {
            return;
        }
        Iterator<b.C11004b> it = bVar.f425914c.iterator();
        while (it.hasNext()) {
            b.C11004b next = it.next();
            if (next.f425919b == i3) {
                int i16 = next.f425918a;
                if (i16 == 0) {
                    e(next, str, aVar);
                } else if (i16 == 2) {
                    f(next, str);
                }
            }
        }
    }

    public void e(b.C11004b c11004b, String str, pd1.a aVar) {
        if (c11004b != null && !TextUtils.isEmpty(c11004b.f425922e) && !TextUtils.isEmpty(c11004b.f425923f)) {
            if (aVar != null) {
                c11004b.a(aVar);
            }
            if (1 == c11004b.f425924g) {
                QLog.i("RequestPreloader", 1, "preloadSSO is loading:" + c11004b);
                return;
            }
            c11004b.f425924g = 1;
            b bVar = new b(c11004b);
            try {
                JSONObject jSONObject = new JSONObject(c11004b.c(str));
                jSONObject.put("option", b());
                g(MobileQQ.sMobileQQ.peekAppRuntime(), c11004b.f425922e, 10000L, jSONObject.toString(), bVar);
            } catch (JSONException e16) {
                QLog.e("RequestPreloader", 1, e16, new Object[0]);
            }
        }
    }

    protected void g(AppRuntime appRuntime, String str, long j3, String str2, BusinessObserver businessObserver) {
        WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
        webSSOAgent$UniSsoServerReqComm.platform.set(109L);
        webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
        webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
        webSSOAgent$UniSsoServerReq.reqdata.set(str2);
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), am.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, str);
        newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
        newIntent.putExtra("extra_callbackid", "0");
        newIntent.putExtra("extra_timeout", j3);
        newIntent.setObserver(businessObserver);
        if (QLog.isColorLevel()) {
            QLog.d("RequestPreloader", 2, "sendUniAgentRequest, req, cmd=" + str + ", reqData=" + str2);
        }
        appRuntime.startServlet(newIntent);
    }
}

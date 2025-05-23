package com.tencent.mobileqq.haoliyou.sso;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bigbrother.ServerApi$ReqDownloadCheckRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi$ReqJumpCheckRecmd;
import com.tencent.mobileqq.bigbrother.a;
import com.tencent.mobileqq.bigbrother.c;
import com.tencent.mobileqq.bigbrother.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.e;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$CheckShareExtensionReq;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CheckForwardManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTENT_TYPE_FILE = 4;
    public static final int CONTENT_TYPE_IMG = 2;
    public static final int CONTENT_TYPE_LINE = 5;
    public static final int CONTENT_TYPE_TEXT = 1;
    public static final int CONTENT_TYPE_VIDEO = 3;
    private static final String TAG = "TeleScreen|CheckForwardManager";
    private CheckForwardObserver mObserver;

    public CheckForwardManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addLog(ServerApi$ReqJumpCheckRecmd serverApi$ReqJumpCheckRecmd) {
        if (serverApi$ReqJumpCheckRecmd.pkg_name.isEmpty() && TextUtils.isEmpty(serverApi$ReqJumpCheckRecmd.scheme.get()) && TextUtils.isEmpty(serverApi$ReqJumpCheckRecmd.action.get()) && TextUtils.isEmpty(serverApi$ReqJumpCheckRecmd.url.get())) {
            e.b();
            QLog.e(TAG, 1, "openthirdappnullinfo" + QLog.getStackTraceString(new Throwable()));
        }
    }

    public static void sendCheckDownloadReq(Context context, String str, String str2, String str3, String str4, a aVar) {
        QLog.i(TAG, 1, "dl src: " + str + ", refId: " + str4);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        NewIntent newIntent = new NewIntent(application.getApplicationContext(), CheckForwardServlet.class);
        ServerApi$ReqDownloadCheckRecmd serverApi$ReqDownloadCheckRecmd = new ServerApi$ReqDownloadCheckRecmd();
        serverApi$ReqDownloadCheckRecmd.uin.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        if (str2 != null) {
            serverApi$ReqDownloadCheckRecmd.pkg_name.set(str2);
        }
        if (str3 != null) {
            serverApi$ReqDownloadCheckRecmd.url.set(str3);
        }
        if (str != null) {
            serverApi$ReqDownloadCheckRecmd.source.set(str);
        }
        if (str4 != null) {
            serverApi$ReqDownloadCheckRecmd.ref_source.set(str4);
        }
        serverApi$ReqDownloadCheckRecmd.platform.set("android");
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, "QQApkSvc.check_download_apk");
        newIntent.putExtra("RequestBytes", serverApi$ReqDownloadCheckRecmd.toByteArray());
        f d16 = f.d();
        if (aVar != null) {
            int a16 = d16.a(context, aVar);
            newIntent.putExtra(CheckForwardServlet.KEY_REQ_ID, a16);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "add req with id: " + a16);
            }
        }
        newIntent.setObserver(f.d());
        application.getRuntime().startServlet(newIntent);
    }

    public static void startServlet(String str, byte[] bArr, BusinessObserver businessObserver) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        NewIntent newIntent = new NewIntent(application.getApplicationContext(), CheckForwardServlet.class);
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, str);
        newIntent.putExtra("RequestBytes", bArr);
        newIntent.setObserver(businessObserver);
        application.getRuntime().startServlet(newIntent);
    }

    public static void thirdAppIntercept(Context context, String str, String str2, String str3, String str4, String str5, List<ResolveInfo> list, String str6, c cVar) {
        QLog.i(TAG, 1, "jump src: " + str + ", pkg: " + str3 + ", scheme: " + str4 + ", action: " + str5 + "\uff0c refId: " + str6);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        NewIntent newIntent = new NewIntent(application.getApplicationContext(), CheckForwardServlet.class);
        ServerApi$ReqJumpCheckRecmd serverApi$ReqJumpCheckRecmd = new ServerApi$ReqJumpCheckRecmd();
        serverApi$ReqJumpCheckRecmd.uin.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        if (str3 != null) {
            serverApi$ReqJumpCheckRecmd.pkg_name.add(str3);
        } else if (list != null) {
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    serverApi$ReqJumpCheckRecmd.pkg_name.add(activityInfo.packageName);
                } else {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null) {
                        serverApi$ReqJumpCheckRecmd.pkg_name.add(serviceInfo.packageName);
                    } else {
                        ProviderInfo providerInfo = resolveInfo.providerInfo;
                        if (providerInfo != null) {
                            serverApi$ReqJumpCheckRecmd.pkg_name.add(providerInfo.packageName);
                        }
                    }
                }
            }
            if (QLog.isColorLevel() && serverApi$ReqJumpCheckRecmd.pkg_name.has() && !serverApi$ReqJumpCheckRecmd.pkg_name.isEmpty()) {
                QLog.d(TAG, 2, "resolve pkg: " + serverApi$ReqJumpCheckRecmd.pkg_name.get(0));
            }
        }
        if (str4 != null) {
            serverApi$ReqJumpCheckRecmd.scheme.set(str4);
        }
        if (str5 != null) {
            serverApi$ReqJumpCheckRecmd.action.set(str5);
        }
        if (str2 != null) {
            serverApi$ReqJumpCheckRecmd.url.set(str2);
        }
        if (str != null) {
            serverApi$ReqJumpCheckRecmd.source.set(str);
        }
        if (str6 != null) {
            serverApi$ReqJumpCheckRecmd.ref_source.set(str6);
        }
        serverApi$ReqJumpCheckRecmd.caller.set(context.getClass().getName());
        QLog.d(TAG, 1, "caller: " + context.getClass().getName());
        serverApi$ReqJumpCheckRecmd.platform.set("android");
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, "QQApkSvc.check_jump_apk");
        newIntent.putExtra("RequestBytes", serverApi$ReqJumpCheckRecmd.toByteArray());
        int b16 = f.d().b(context, cVar);
        newIntent.putExtra(CheckForwardServlet.KEY_REQ_ID, b16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "add req with id: " + b16);
        }
        newIntent.setObserver(f.d());
        application.getRuntime().startServlet(newIntent);
        addLog(serverApi$ReqJumpCheckRecmd);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void sendCheckShareReq(QQAppInterface qQAppInterface, oidb_cmd0xc78$CheckShareExtensionReq oidb_cmd0xc78_checkshareextensionreq, String str, OnCheckShareListener onCheckShareListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, oidb_cmd0xc78_checkshareextensionreq, str, onCheckShareListener);
            return;
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), CheckForwardServlet.class);
        newIntent.putExtra(CheckForwardServlet.KEY_CMD, "OidbSvc.0xc78_1");
        newIntent.putExtra("ext_info", str);
        oidb_cmd0xc78$ReqBody oidb_cmd0xc78_reqbody = new oidb_cmd0xc78$ReqBody();
        oidb_cmd0xc78_reqbody.check_share_extension_req.set(oidb_cmd0xc78_checkshareextensionreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3192);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc78_reqbody.toByteArray()));
        newIntent.putExtra("RequestBytes", oidb_sso_oidbssopkg.toByteArray());
        if (this.mObserver == null) {
            this.mObserver = new CheckForwardObserver();
        }
        int addOnCheckShareListener = this.mObserver.addOnCheckShareListener(onCheckShareListener);
        newIntent.setObserver(this.mObserver);
        newIntent.putExtra(CheckForwardServlet.KEY_REQ_ID, addOnCheckShareListener);
        qQAppInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendCheckShareReq");
        }
    }
}

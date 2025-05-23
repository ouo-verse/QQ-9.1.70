package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    private void a(c cVar, int i3) {
        n.a("WXOpenHandler", "callbackFailure, errCode:" + i3);
        if (cVar != null) {
            cVar.a(false, i3);
        }
    }

    private void b(c cVar) {
        n.a("WXOpenHandler", "callbackWillLaunch");
        if (cVar != null) {
            cVar.b();
        }
    }

    private int c(d dVar) {
        if (dVar == null) {
            return 4;
        }
        f b16 = dVar.b();
        if (b16 == null) {
            n.b("WXOpenHandler", "openMiniProgram, wxMiniProgramData is null, return.");
            return 4;
        }
        String a16 = dVar.a();
        int b17 = b16.b();
        n.e("WXOpenHandler", "openMiniProgram, userName: " + b16.d() + ", path: " + b16.c() + ", env: " + b17 + ", openType: " + a16 + ", extMsg: " + b16.a());
        OpenSdkManager openSdkManager = OpenSdkManager.INSTANCE;
        if (openSdkManager.getWxApi() == null) {
            Toast.makeText(qv2.b.a(), "\u7cfb\u7edf\u9519\u8bef\uff0c\u8bf7\u9000\u51faapp\u91cd\u8fdb!", 1).show();
            n.b("WXOpenHandler", "openMiniProgram, system error, wxApi is null, return.");
            return 1;
        }
        if (!openSdkManager.isWXInstalled()) {
            Toast.makeText(qv2.b.a(), "\u8bf7\u5148\u5b89\u88c5\u6700\u65b0\u7248\u5fae\u4fe1!", 1).show();
            n.e("WXOpenHandler", "openMiniProgram, WX not installed, return.");
            return 3;
        }
        if (!openSdkManager.isWXAppSupportAPI()) {
            Toast.makeText(qv2.b.a(), "\u8bf7\u5148\u5347\u7ea7\u5fae\u4fe1\u5230\u6700\u65b0\u7248!", 1).show();
            n.e("WXOpenHandler", "openMiniProgram, WX version not supported, return.");
            return 2;
        }
        if ("MiniGame".equals(a16) && !openSdkManager.isSupportMiniGame()) {
            Toast.makeText(qv2.b.a(), "\u8bf7\u5148\u5347\u7ea7\u5fae\u4fe1\u5230\u6700\u65b0\u7248!", 1).show();
            n.e("WXOpenHandler", "openMiniProgram, WX version not supported, return.");
            return 2;
        }
        return 0;
    }

    private int e(IWXAPI iwxapi, String str, int i3, String str2, String str3, c cVar) {
        n.e("WXOpenHandler", "openMiniProgramSendReq, open mini outline, userName:" + str + ",env:" + i3 + ",path:" + str2 + ",extMsg:" + str3);
        if (iwxapi == null) {
            return 1;
        }
        if (TextUtils.isEmpty(str)) {
            n.e("WXOpenHandler", "openMiniProgramSendReq, invalid userName = " + str);
            return 5;
        }
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.miniprogramType = i3;
        req.userName = str;
        if (!TextUtils.isEmpty(str2)) {
            req.path = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            req.extData = str3;
        }
        b(cVar);
        try {
            if (!iwxapi.sendReq(req)) {
                return 6;
            }
            return 0;
        } catch (Throwable th5) {
            n.d("WXOpenHandler", th5, "sendReq error");
            return 6;
        }
    }

    private void f(IWXAPI iwxapi, d dVar, String str, int i3, String str2, String str3, c cVar) {
        int e16 = e(iwxapi, str, i3, str2, str3, cVar);
        if (e16 != 0) {
            a(cVar, e16);
        } else if (cVar != null) {
            cVar.a(true, e16);
        }
    }

    public void d(d dVar, c cVar) {
        int c16 = c(dVar);
        if (c16 != 0) {
            a(cVar, c16);
            return;
        }
        f b16 = dVar.b();
        if (b16 == null) {
            n.b("WXOpenHandler", "openMiniProgram, wxMiniProgramData is null, return.");
            a(cVar, 4);
            return;
        }
        int b17 = b16.b();
        f(OpenSdkManager.INSTANCE.getWxApi(), dVar, b16.d(), b17, b16.c(), b16.a(), cVar);
    }
}

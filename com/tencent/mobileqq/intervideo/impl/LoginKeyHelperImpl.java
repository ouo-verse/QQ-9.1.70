package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.m;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.appcommon.d;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeRequest;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize$AuthorizeResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LoginKeyHelperImpl implements ILoginKeyHelper {
    private static final String TAG = "LoginKeyHelperImpl";
    boolean isUpdating;
    ILoginKeyHelper.a mAccountInfo = new ILoginKeyHelper.a();
    long mLastUpdatedTime = 0;
    List<ILoginKeyHelper.b> mListenerList = new ArrayList();
    WtloginHelper wtloginHelper;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends WtloginListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f238278b;

        a(String str) {
            this.f238278b = str;
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
            super.OnException(errMsg, i3, wUserSigInfo);
            if (QLog.isColorLevel()) {
                QLog.i("XProxy", 2, "\u83b7\u53d6Now\u7ed3\u5408\u7248A1\u7968\u636e\u8fd4\u56de\u5f02\u5e38\uff0ccmd = " + i3 + " errmsg = " + errMsg.getMessage());
            }
            LoginKeyHelperImpl.this.notifyResult(this.f238278b, false, i3);
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
            if (i16 == 0) {
                LoginKeyHelperImpl loginKeyHelperImpl = LoginKeyHelperImpl.this;
                loginKeyHelperImpl.mAccountInfo.f238095d = loginKeyHelperImpl.wtloginHelper.PrepareQloginResult(str, j18, j19, i16, wFastLoginInfo);
                LoginKeyHelperImpl.this.mLastUpdatedTime = System.currentTimeMillis();
                LoginKeyHelperImpl.this.notifyResult(this.f238278b, true, 0);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("XProxy", 2, "\u83b7\u53d6Now\u7ed3\u5408\u7248A1\u7968\u636e\u8fd4\u56de\u5931\u8d25\uff0cretCode = " + i16);
            }
            LoginKeyHelperImpl.this.notifyResult(this.f238278b, false, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238280a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoginKeyHelper.b f238281b;

        b(String str, ILoginKeyHelper.b bVar) {
            this.f238280a = str;
            this.f238281b = bVar;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e(LoginKeyHelperImpl.TAG, 1, "psKeyManager.getPskey, domain " + this.f238280a + ". error " + str);
            ILoginKeyHelper.b bVar = this.f238281b;
            if (bVar != null) {
                bVar.a("", false, -1);
            }
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            QLog.e(LoginKeyHelperImpl.TAG, 1, "psKeyManager.getPskey onSuccess, domain: " + this.f238280a);
            String str = map.get(this.f238280a);
            if (!TextUtils.isEmpty(str)) {
                ILoginKeyHelper.a aVar = LoginKeyHelperImpl.this.mAccountInfo;
                aVar.f238099h = str;
                aVar.f238100i = 10;
                ILoginKeyHelper.b bVar = this.f238281b;
                if (bVar != null) {
                    bVar.a("", true, 0);
                    return;
                }
                return;
            }
            onFail("onSuccess but domainToKeyMap is empty!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ILoginKeyHelper.b f238283d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238284e;

        c(ILoginKeyHelper.b bVar, String str) {
            this.f238283d = bVar;
            this.f238284e = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            new Bundle();
            byte[] byteArray = bundle.getByteArray("data");
            if (byteArray == null) {
                this.f238283d.a(this.f238284e, false, -10002);
                return;
            }
            FastAuthorize$AuthorizeResponse fastAuthorize$AuthorizeResponse = new FastAuthorize$AuthorizeResponse();
            try {
                fastAuthorize$AuthorizeResponse.mergeFrom(byteArray);
                if (fastAuthorize$AuthorizeResponse.ret.get().equals("0") && fastAuthorize$AuthorizeResponse.apk_name.has()) {
                    LoginKeyHelperImpl.this.mAccountInfo.f238100i = 1;
                    if (fastAuthorize$AuthorizeResponse.access_token.has()) {
                        LoginKeyHelperImpl.this.mAccountInfo.f238092a = fastAuthorize$AuthorizeResponse.access_token.get();
                    }
                    if (fastAuthorize$AuthorizeResponse.openid.has()) {
                        LoginKeyHelperImpl.this.mAccountInfo.f238093b = fastAuthorize$AuthorizeResponse.openid.get();
                    }
                    if (fastAuthorize$AuthorizeResponse.pay_token.has()) {
                        LoginKeyHelperImpl.this.mAccountInfo.f238094c = fastAuthorize$AuthorizeResponse.pay_token.get();
                    }
                    LoginKeyHelperImpl.this.mAccountInfo.f238096e = System.currentTimeMillis();
                    this.f238283d.a(this.f238284e, true, 0);
                    return;
                }
                QLog.e("XProxy", 2, "\u83b7\u53d6\u7968\u636e\u5931\u8d25");
                try {
                    this.f238283d.a(this.f238284e, false, Integer.parseInt(fastAuthorize$AuthorizeResponse.ret.get()));
                } catch (NumberFormatException unused) {
                    this.f238283d.a(this.f238284e, false, 0);
                    QLog.e("XProxy", 2, "\u83b7\u53d6\u7968\u636e\u9519\u8bef\u7801\u4e0d\u4e3aint");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                this.f238283d.a(this.f238284e, false, -10003);
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResult(String str, boolean z16, int i3) {
        for (ILoginKeyHelper.b bVar : this.mListenerList) {
            if (bVar != null) {
                bVar.a(str, z16, i3);
            }
        }
        this.mListenerList.clear();
        this.isUpdating = false;
    }

    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    public void cancelRequest() {
        WtloginHelper wtloginHelper = this.wtloginHelper;
        if (wtloginHelper != null) {
            wtloginHelper.CancelRequest();
        }
        this.mAccountInfo.f238095d = null;
    }

    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    public void clearAccount() {
        this.mAccountInfo = new ILoginKeyHelper.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean getA1(String str, String str2, String str3, String str4, ILoginKeyHelper.b bVar, boolean z16, String str5) {
        byte[] hexStr2Bytes;
        String str6;
        boolean z17;
        boolean z18;
        QLog.i("XProxy", 2, "\u5f00\u59cb\u62c9\u53d6A1\uff0cuin = " + str + " appid = " + str4);
        if (this.mAccountInfo.f238095d != null && !z16 && System.currentTimeMillis() - this.mLastUpdatedTime < 43200000) {
            if (bVar != null) {
                bVar.a(str2, true, 0);
            }
            return true;
        }
        if (this.isUpdating) {
            this.mListenerList.add(bVar);
            return true;
        }
        this.isUpdating = true;
        if (this.wtloginHelper == null) {
            QLog.i("XProxy", 2, "new WtloginHelper");
            WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
            WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
            this.wtloginHelper = new WtloginHelper((Context) BaseApplication.getContext(), (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
        }
        if (str3.equals("com.tencent.huayang")) {
            hexStr2Bytes = new byte[]{-33, 11, -29, -119, 66, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 87, 53, -16, -77, -121, -112, 46, 51, -96, 62};
        } else {
            hexStr2Bytes = str3.equals(INowUtil.Now_PKG_NAME) ? new byte[]{-51, 50, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -105, -54, -19, PublicAccountH5AbilityPluginImpl.OPENCAMERA, -124, -125, -52, -72, -101, -27, 33, 65, Byte.MIN_VALUE} : HexUtil.hexStr2Bytes(str5);
        }
        byte[] bArr = hexStr2Bytes;
        this.wtloginHelper.SetListener(new a(str2));
        this.mListenerList.add(bVar);
        int GetA1WithA1 = this.wtloginHelper.GetA1WithA1(str, 16L, 16L, str3.getBytes(), 1L, Long.valueOf(str4).longValue(), 1L, "5.2".getBytes(), bArr, new WUserSigInfo(), new WFastLoginInfo());
        try {
            HashMap hashMap = new HashMap();
            str6 = TAG;
            try {
                hashMap.put("source", str6);
                QQBeaconReport.report(str, "wtlogin_invalid_init", hashMap);
                z17 = false;
                z18 = true;
            } catch (Exception e16) {
                e = e16;
                z17 = false;
                z18 = true;
                QLog.e(str6, 1, e, new Object[0]);
                if (GetA1WithA1 != -1001) {
                }
                return z18;
            }
        } catch (Exception e17) {
            e = e17;
            str6 = TAG;
        }
        if (GetA1WithA1 != -1001) {
            if (QLog.isColorLevel()) {
                QLog.i("XProxy", 2, "\u83b7\u53d6Now\u7ed3\u5408\u7248A1\u7968\u636e\u5931\u8d25\uff0cretCode = " + GetA1WithA1);
            }
            notifyResult(str2, z17, GetA1WithA1);
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    public ILoginKeyHelper.a getAccountInfo() {
        return this.mAccountInfo;
    }

    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    public void getPSkey(AppInterface appInterface, String str, ILoginKeyHelper.b bVar) {
        ILoginKeyHelper.a aVar = this.mAccountInfo;
        aVar.f238098g = str;
        try {
            aVar.f238097f = Long.parseLong(appInterface.getCurrentAccountUin());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Long.parseLong uin error! ", e16);
        }
        if (!TextUtils.isEmpty(this.mAccountInfo.f238099h)) {
            if (bVar != null) {
                bVar.a("", true, 0);
            }
        } else if (!TextUtils.isEmpty(str)) {
            ((IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{str}, new b(str, bVar));
        } else if (bVar != null) {
            bVar.a("", false, -1);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper
    public void getAccessToken(AppInterface appInterface, String str, Context context, String str2, ILoginKeyHelper.b bVar) {
        String str3;
        try {
            this.mAccountInfo.f238097f = Long.parseLong(appInterface.getCurrentAccountUin());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Long.parseLong uin error! ", e16);
        }
        if (!TextUtils.isEmpty(this.mAccountInfo.f238093b)) {
            if (bVar != null) {
                bVar.a(str, true, 0);
                return;
            }
            return;
        }
        c cVar = new c(bVar, str);
        FastAuthorize$AuthorizeRequest fastAuthorize$AuthorizeRequest = new FastAuthorize$AuthorizeRequest();
        fastAuthorize$AuthorizeRequest.uin.set(Long.parseLong(appInterface.getCurrentAccountUin()));
        fastAuthorize$AuthorizeRequest.client_id.set(Long.parseLong(str2));
        fastAuthorize$AuthorizeRequest.f342472pf.set("");
        fastAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.business.base.a.f(context));
        fastAuthorize$AuthorizeRequest.sdkp.set("a");
        fastAuthorize$AuthorizeRequest.f342471os.set(Build.DISPLAY);
        if (appInterface instanceof QQAppInterface) {
            str3 = ((QQAppInterface) appInterface).getvKeyStr();
        } else if (!(appInterface instanceof BrowserAppInterface)) {
            str3 = "";
        } else {
            str3 = ((BrowserAppInterface) appInterface).k();
        }
        if (str3 == null) {
            str3 = "";
        }
        fastAuthorize$AuthorizeRequest.vkey.set(str3);
        fastAuthorize$AuthorizeRequest.flags.set(7);
        NewIntent newIntent = new NewIntent(context, m.class);
        fastAuthorize$AuthorizeRequest.apk_sign.set("");
        newIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try {
            newIntent.putExtra("data", fastAuthorize$AuthorizeRequest.toByteArray());
        } catch (Exception unused) {
            bVar.a(str, false, -10001);
        }
        newIntent.setObserver(cVar);
        appInterface.startServlet(newIntent);
    }
}

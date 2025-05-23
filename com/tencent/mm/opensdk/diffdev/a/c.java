package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f151788a;

    /* renamed from: b, reason: collision with root package name */
    private String f151789b;

    /* renamed from: c, reason: collision with root package name */
    private OAuthListener f151790c;

    /* renamed from: d, reason: collision with root package name */
    private int f151791d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f151792a;

        /* renamed from: b, reason: collision with root package name */
        public String f151793b;

        /* renamed from: c, reason: collision with root package name */
        public int f151794c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f151788a = str;
        this.f151790c = oAuthListener;
        this.f151789b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x00bf. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0178 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        String format;
        JSONObject jSONObject;
        int i3;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.f151788a;
        if (str2 != null && str2.length() != 0) {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f151789b);
                if (this.f151791d == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f151791d;
                }
                sb5.append(str);
                String sb6 = sb5.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a16 = com.tencent.mm.opensdk.channel.a.a.a(sb6, 60000);
                long currentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (a16 != null && a16.length != 0) {
                    try {
                        try {
                            jSONObject = new JSONObject(new String(a16, "utf-8"));
                            int i16 = jSONObject.getInt("wx_errcode");
                            aVar.f151794c = i16;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i16)));
                            i3 = aVar.f151794c;
                        } catch (Exception e16) {
                            format = String.format("parse json fail, ex = %s", e16.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", format);
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.f151792a = oAuthErrCode2;
                            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb6, aVar.f151792a.toString(), Integer.valueOf(aVar.f151794c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.f151792a;
                            if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                            }
                            return aVar;
                        }
                    } catch (Exception e17) {
                        format = String.format("parse fail, build String fail, ex = %s", e17.getMessage());
                    }
                    if (i3 != 408) {
                        if (i3 != 500) {
                            switch (i3) {
                                case 402:
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    aVar.f151792a = oAuthErrCode4;
                                    break;
                                case 403:
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    aVar.f151792a = oAuthErrCode4;
                                    break;
                                case 405:
                                    aVar.f151792a = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.f151793b = jSONObject.getString("wx_code");
                                    break;
                            }
                            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb6, aVar.f151792a.toString(), Integer.valueOf(aVar.f151794c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.f151792a;
                            if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                                int i17 = aVar.f151794c;
                                this.f151791d = i17;
                                if (i17 == d.UUID_SCANED.a()) {
                                    this.f151790c.onQrcodeScanned();
                                } else if (aVar.f151794c != d.UUID_KEEP_CONNECT.a() && aVar.f151794c == d.UUID_CONFIRM.a()) {
                                    String str3 = aVar.f151793b;
                                    if (str3 == null || str3.length() == 0) {
                                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                    }
                                }
                            } else {
                                Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.f151794c)));
                            }
                            return aVar;
                        }
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f151792a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb6, aVar.f151792a.toString(), Integer.valueOf(aVar.f151794c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                        oAuthErrCode3 = aVar.f151792a;
                        if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                        }
                        return aVar;
                    }
                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                    aVar.f151792a = oAuthErrCode4;
                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb6, aVar.f151792a.toString(), Integer.valueOf(aVar.f151794c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    oAuthErrCode3 = aVar.f151792a;
                    if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                    }
                    return aVar;
                }
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.f151792a = oAuthErrCode2;
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb6, aVar.f151792a.toString(), Integer.valueOf(aVar.f151794c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                oAuthErrCode3 = aVar.f151792a;
                if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.f151792a = oAuthErrCode;
            return aVar;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.f151792a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f151790c.onAuthFinish(aVar2.f151792a, aVar2.f151793b);
    }
}

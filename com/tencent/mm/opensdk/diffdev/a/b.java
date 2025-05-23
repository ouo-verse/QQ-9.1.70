package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Base64;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f151776a;

    /* renamed from: b, reason: collision with root package name */
    private String f151777b;

    /* renamed from: c, reason: collision with root package name */
    private String f151778c;

    /* renamed from: d, reason: collision with root package name */
    private String f151779d;

    /* renamed from: e, reason: collision with root package name */
    private String f151780e;

    /* renamed from: f, reason: collision with root package name */
    private OAuthListener f151781f;

    /* renamed from: g, reason: collision with root package name */
    private c f151782g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f151783a;

        /* renamed from: b, reason: collision with root package name */
        public String f151784b;

        /* renamed from: c, reason: collision with root package name */
        public String f151785c;

        /* renamed from: d, reason: collision with root package name */
        public String f151786d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f151787e;

        a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i3 = jSONObject.getInt("errcode");
                        if (i3 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i3)));
                            aVar.f151783a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                aVar.f151783a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f151787e = decode;
                                aVar.f151784b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                aVar.f151785c = string2;
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f151784b, string2, Integer.valueOf(aVar.f151787e.length)));
                                return aVar;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.f151783a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.f151783a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e16) {
                        format = String.format("parse json fail, ex = %s", e16.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f151783a = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e17) {
                    format = String.format("parse fail, build String fail, ex = %s", e17.getMessage());
                }
            } else {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            }
            aVar.f151783a = oAuthErrCode;
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f151776a = str;
        this.f151777b = str2;
        this.f151778c = str3;
        this.f151779d = str4;
        this.f151780e = str5;
        this.f151781f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f151782g;
        if (cVar == null) {
            return cancel(true);
        }
        return cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f151776a, this.f151778c, this.f151779d, this.f151777b, this.f151780e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a16 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a16);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f151783a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f151787e.length);
            this.f151781f.onAuthGotQrcode(aVar2.f151786d, aVar2.f151787e);
            c cVar = new c(aVar2.f151784b, this.f151781f);
            this.f151782g = cVar;
            cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f151781f.onAuthFinish(aVar2.f151783a, null);
    }
}

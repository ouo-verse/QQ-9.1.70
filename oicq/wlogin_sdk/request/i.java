package oicq.wlogin_sdk.request;

import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public u f422895a;

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = util.get_rand_16byte(u.f422943t);
        byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr2);
        byte[] bArr3 = new byte[encrypt.length + bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(encrypt, 0, bArr3, bArr2.length, encrypt.length);
        return bArr3;
    }

    public int b(byte[] bArr) {
        int i3 = 0;
        if (bArr.length == 0) {
            return 0;
        }
        util.LOGI(getClass().getName() + ":snd_rcv_req_error ...", "" + this.f422895a.f422957d);
        int i16 = 0;
        while (i16 < 2) {
            util.LOGI("try http connect " + i16 + " ...", "" + this.f422895a.f422957d);
            try {
                URL url = new URL("https://ssl.log.wtlogin.qq.com/cgi-bin/wlogin_proxy_log");
                util.LOGI("url=" + url, "" + this.f422895a.f422957d);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty(HttpHeader.RSP.CONTENT_DISPOSITION, "attachment; filename=micromsgresp.dat");
                httpURLConnection.setRequestProperty("Content-Length", new Integer(bArr.length).toString());
                httpURLConnection.setConnectTimeout(this.f422895a.f422963j);
                httpURLConnection.setReadTimeout(this.f422895a.f422963j);
                httpURLConnection.setDoOutput(true);
                util.LOGI("http request connect ...", "" + this.f422895a.f422957d);
                if (!h.a(httpURLConnection, this.f422895a.f422963j)) {
                    util.LOGI("http request connect failed", "" + this.f422895a.f422957d);
                } else {
                    util.LOGI("http request write ...", "" + this.f422895a.f422957d);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr, 0, bArr.length);
                    outputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    util.LOGI("http request response code=" + responseCode, "" + this.f422895a.f422957d);
                    if (200 == responseCode) {
                        break;
                    }
                }
            } catch (Exception e16) {
                util.printException(e16, "" + this.f422895a.f422957d);
            }
            i16++;
        }
        if (i16 >= 1) {
            i3 = -1000;
        }
        util.LOGI(getClass().getName() + ":snd_rcv_req_error ret=" + i3, "" + this.f422895a.f422957d);
        return i3;
    }
}

package com.tencent.mobileqq.tts.data;

import com.google.gson.Gson;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.tts.api.impl.TtsAbilityImpl;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f303378a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f303378a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_tts_use_test_env", false);
        }
    }

    private String b() {
        if (this.f303378a) {
            return "http://qqrichmediatts.woa.com/cgi-bin/tts";
        }
        return "https://textts.qq.com/cgi-bin/tts";
    }

    private HttpURLConnection c(TtsNetStreamParam ttsNetStreamParam) throws IOException {
        SSLContext sSLContext;
        URL url = new URL(b());
        if (QLog.isDevelopLevel()) {
            QLog.d("TtsNetDataSource", 4, "[initConnection] url: " + url + " appId:" + ttsNetStreamParam.appId + " businessID:" + ttsNetStreamParam.businessID + " voiceType:" + ttsNetStreamParam.voiceType + " model:" + ttsNetStreamParam.model);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        String str = "uin=" + ttsNetStreamParam.uin + ";skey=" + ttsNetStreamParam.sKey;
        if (TtsAbilityImpl.getUsePskeyInsteadOfSkey()) {
            str = "uin=" + ttsNetStreamParam.uin + ";p_uin=" + ttsNetStreamParam.uin + ";p_skey=" + ttsNetStreamParam.sKey;
        }
        httpURLConnection.setRequestProperty("Cookie", str);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        try {
            sSLContext = SSLContext.getDefault();
        } catch (NoSuchAlgorithmException e16) {
            QLog.e("TtsNetDataSource", 2, e16, new Object[0]);
            sSLContext = null;
        }
        if (sSLContext != null && (httpURLConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
        }
        return httpURLConnection;
    }

    private void d(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("playSuccess", str);
        hashMap.put("playError", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "TTSPlayMonitor", true, 0L, 0L, hashMap, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:
    
        if (r4 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    @Override // com.tencent.mobileqq.tts.data.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputStream a(TtsNetStreamParam ttsNetStreamParam) throws IOException {
        DataOutputStream dataOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InputStream) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ttsNetStreamParam);
        }
        HttpURLConnection c16 = c(ttsNetStreamParam);
        String json = new Gson().toJson(ttsNetStreamParam);
        DataOutputStream dataOutputStream2 = null;
        boolean z16 = true;
        try {
            try {
                dataOutputStream = new DataOutputStream(c16.getOutputStream());
            } catch (Exception e16) {
                e = e16;
                dataOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (dataOutputStream2 != null) {
                }
                throw th;
            }
            try {
                dataOutputStream.write(json.getBytes());
                dataOutputStream.flush();
            } catch (Exception e17) {
                e = e17;
                QLog.w("TtsNetDataSource", 1, "[getUrlStream] write error: ", e);
                c16.disconnect();
            }
            dataOutputStream.close();
            if (c16.getResponseCode() == 200) {
                if (ttsNetStreamParam.businessID == 1) {
                    d("0", "0");
                }
                g gVar = (g) e.a();
                InputStream inputStream = c16.getInputStream();
                String j3 = gVar.j(gVar.i(ttsNetStreamParam.text, ttsNetStreamParam.voiceType), ttsNetStreamParam.sendUin.toString());
                if (ttsNetStreamParam.autoTTS.intValue() != 0) {
                    z16 = false;
                }
                return new a(c16, inputStream, j3, z16);
            }
            if (ttsNetStreamParam.businessID == 1) {
                String valueOf = String.valueOf(c16.getResponseCode());
                d(valueOf, valueOf);
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                dataOutputStream2.close();
            }
            throw th;
        }
    }
}

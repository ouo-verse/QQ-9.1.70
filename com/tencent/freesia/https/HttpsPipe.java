package com.tencent.freesia.https;

import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.ILogger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Cipher;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes6.dex */
public class HttpsPipe {
    static IPatchRedirector $redirector_ = null;
    private static final String FREESIA_SERVER = "https://clmc.qq.com/trpc.group_pro.configdistribution.ConfigDistributionHttpSvr/GetRecoverConfig";
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA38otU2N4hIeSaHF4/fvPvYHMOnZSTOE/WZ213Q+1OPvnqNUbbtL0pz/JvJkvmemt6apoIib27JWw8U/lsTL/yJ57K8d7qPmK8UX3OCkUYv7iJMIuLo+Fmv4nOMXBy8/In3SZZvTEtHyUo/WhOrEJBPp9RQFTilGZk/76UGmeV1SQL8RqaGj5i+UivTwHehGNwd3y5NQ4jGrKp3WL8sTSwAyD2p/MxlZONkUwjL58U6MhqZkuOaaPah1vT4AO50YsqAY6TRCL/wXQOBPpcGi6Fz668mvKgCOj2cHD6U5+4IuaOiTo3LKAoMCzpOMPFj1XBdwW3yfyQfcz2d+Ha1QQgwIDAQAB";
    private static final String TAG = "FreesiaHttpsPipe";
    private final ILogger logger;

    public HttpsPipe(@NonNull ILogger iLogger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iLogger);
        } else {
            this.logger = iLogger;
        }
    }

    private static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    private static byte[] decryptByPrivateKey(byte[] bArr, byte[] bArr2) {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    private static byte[] encrypt(byte[] bArr) {
        PublicKey publicKey = getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    @NonNull
    private static configDistributionSvr.GetRecoverConfigReq getGetRecoverConfigReq(String str, int i3, String str2, String str3, String str4, String str5) {
        configDistributionSvr.RecoverConfigReq recoverConfigReq = new configDistributionSvr.RecoverConfigReq();
        try {
            recoverConfigReq.uin.set(Long.parseLong(str3));
        } catch (NumberFormatException unused) {
        }
        recoverConfigReq.client_appid.set(i3);
        recoverConfigReq.client_version.set(str2);
        recoverConfigReq.timestamp.set((int) (System.currentTimeMillis() / 1000));
        recoverConfigReq.client_plat.set(2);
        recoverConfigReq.client_plat_id.set(109);
        recoverConfigReq.client_sub_plat.set("Android");
        recoverConfigReq.qimei.set(str4);
        configDistributionSvr.GetConfigReq getConfigReq = new configDistributionSvr.GetConfigReq();
        ArrayList arrayList = new ArrayList();
        configDistributionSvr.ProjectInfo projectInfo = new configDistributionSvr.ProjectInfo();
        projectInfo.f381455id.set(str);
        arrayList.add(projectInfo);
        getConfigReq.project_infos.addAll(arrayList);
        configDistributionSvr.DeviceInfo deviceInfo = new configDistributionSvr.DeviceInfo();
        deviceInfo.brand.set(Build.MANUFACTURER);
        deviceInfo.model.set(DeviceInfoMonitor.getModel());
        configDistributionSvr.OS os5 = new configDistributionSvr.OS();
        os5.type.set(2);
        os5.version.set(Build.VERSION.SDK_INT + "");
        deviceInfo.f381454os.set(os5);
        getConfigReq.fetch_type.set(2);
        configDistributionSvr.GroupInfo groupInfo = new configDistributionSvr.GroupInfo();
        groupInfo.group.set(str5);
        getConfigReq.group_infos.addAll(Collections.singleton(groupInfo));
        recoverConfigReq.config_req.set(getConfigReq);
        configDistributionSvr.GetRecoverConfigReq getRecoverConfigReq = new configDistributionSvr.GetRecoverConfigReq();
        getRecoverConfigReq.version.set(0);
        getRecoverConfigReq.req_bytes.set(ByteStringMicro.copyFrom(encrypt(recoverConfigReq.toByteArray())));
        return getRecoverConfigReq;
    }

    private static PublicKey getPublicKey() {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY, 0)));
    }

    public static void test() {
        try {
            encrypt("test".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static boolean verify(byte[] bArr, byte[] bArr2) {
        PublicKey publicKey = getPublicKey();
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0168  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public configDistributionSvr.GetConfigRsp fetch(String str, int i3, String str2, String str3, String str4, String str5) {
        InputStream inputStream;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (configDistributionSvr.GetConfigRsp) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, str3, str4, str5);
        }
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(FREESIA_SERVER).openConnection();
            try {
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestProperty("Content-Type", "application/proto");
                outputStream = httpsURLConnection.getOutputStream();
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                outputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            outputStream = null;
        }
        try {
            outputStream.write(getGetRecoverConfigReq(str, i3, str2, str3, str4, str5).toByteArray());
            outputStream.flush();
            if (httpsURLConnection.getResponseCode() != 200) {
                this.logger.e(TAG, "https response: " + httpsURLConnection.getResponseCode());
                close(outputStream);
                close(null);
            } else {
                String headerField = httpsURLConnection.getHeaderField("Trpc-Func-Ret");
                String headerField2 = httpsURLConnection.getHeaderField("Trpc-Error-Msg");
                this.logger.e(TAG, "trpc ret: " + headerField + ", msg: " + headerField2);
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    configDistributionSvr.GetRecoverConfigRsp getRecoverConfigRsp = new configDistributionSvr.GetRecoverConfigRsp();
                    getRecoverConfigRsp.mergeFrom(byteArrayOutputStream.toByteArray());
                    configDistributionSvr.GetConfigRsp getConfigRsp = new configDistributionSvr.GetConfigRsp();
                    if (!getRecoverConfigRsp.rsp_bytes.has() && !getRecoverConfigRsp.rsp_sign.has()) {
                        this.logger.d(TAG, "rsp empty");
                    } else if (!verify(getRecoverConfigRsp.rsp_bytes.get().toByteArray(), getRecoverConfigRsp.rsp_sign.get().toByteArray())) {
                        this.logger.e(TAG, "verify error");
                        close(outputStream);
                        close(inputStream2);
                    } else {
                        getConfigRsp.mergeFrom(getRecoverConfigRsp.rsp_bytes.get().toByteArray());
                    }
                    close(outputStream);
                    close(inputStream2);
                    httpsURLConnection.disconnect();
                    return getConfigRsp;
                } catch (Throwable th7) {
                    httpsURLConnection2 = httpsURLConnection;
                    inputStream = inputStream2;
                    th = th7;
                    close(outputStream);
                    close(inputStream);
                    if (httpsURLConnection2 != null) {
                    }
                    throw th;
                }
            }
            httpsURLConnection.disconnect();
            return null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            httpsURLConnection2 = httpsURLConnection;
            close(outputStream);
            close(inputStream);
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
    }
}

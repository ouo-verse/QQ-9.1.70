package com.tencent.luggage.wxa.bf;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f122550a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122551b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122552c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122553d;

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, String str2) {
            this.f122550a = dVar;
            this.f122551b = str;
            this.f122552c = i3;
            this.f122553d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String b16;
            if (!this.f122550a.isRunning()) {
                return;
            }
            com.tencent.luggage.wxa.cp.v absoluteFile = this.f122550a.getFileSystem().getAbsoluteFile(this.f122551b);
            if (absoluteFile == null) {
                this.f122550a.a(this.f122552c, o.this.makeReturnJson("fail:file doesn't exist"));
                return;
            }
            com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(absoluteFile.g());
            String str = this.f122553d;
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -903629273:
                    if (str.equals("sha256")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 107902:
                    if (str.equals("md5")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 3528965:
                    if (str.equals("sha1")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    b16 = o.b(new com.tencent.luggage.wxa.cp.v(vVar.g()), KeyPropertiesCompact.DIGEST_SHA256);
                    break;
                case 1:
                    b16 = com.tencent.luggage.wxa.y8.c.a(vVar.g());
                    break;
                case 2:
                    b16 = o.b(new com.tencent.luggage.wxa.cp.v(vVar.g()), "SHA1");
                    break;
                default:
                    b16 = "";
                    break;
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("size", Long.valueOf(vVar.s()));
            hashMap.put(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, b16);
            this.f122550a.a(this.f122552c, o.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    public static String b(com.tencent.luggage.wxa.cp.v vVar, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            try {
                InputStream a16 = com.tencent.luggage.wxa.cp.x.a(vVar);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        try {
                            int read = a16.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (IOException unused) {
                            a16.close();
                            return "";
                        } catch (Throwable th5) {
                            try {
                                a16.close();
                            } catch (IOException e16) {
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e16);
                            }
                            throw th5;
                        }
                    } catch (IOException e17) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e17);
                        return "";
                    }
                }
                String a17 = a(messageDigest.digest());
                try {
                    a16.close();
                } catch (IOException e18) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e18);
                }
                return a17;
            } catch (FileNotFoundException e19) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", e19);
                return "";
            }
        } catch (NoSuchAlgorithmException e26) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", e26);
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    @Override // com.tencent.luggage.wxa.xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String str;
        String optString = jSONObject.optString("filePath", "");
        String optString2 = jSONObject.optString("digestAlgorithm", "md5");
        String str2 = "sha256";
        if (!"sha256".equalsIgnoreCase(optString2)) {
            str2 = "sha1";
            if (!"sha1".equalsIgnoreCase(optString2)) {
                str = "md5";
                if (!com.tencent.luggage.wxa.tn.w0.c(optString)) {
                    dVar.a(i3, makeReturnJson("fail:invalid data"));
                    return;
                } else {
                    b.f122521b.execute(new a(dVar, optString, i3, str));
                    return;
                }
            }
        }
        str = str2;
        if (!com.tencent.luggage.wxa.tn.w0.c(optString)) {
        }
    }

    public static final String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toLowerCase());
        }
        return stringBuffer.toString();
    }
}

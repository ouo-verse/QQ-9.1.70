package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class q0 implements Callable<HonorPushDataMsg> {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f36421a;

    public q0(Intent intent) {
        this.f36421a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HonorPushDataMsg call() throws Exception {
        byte[] bArr;
        String str;
        Intent intent = this.f36421a;
        if (intent == null) {
            return null;
        }
        long j3 = 0;
        try {
            j3 = intent.getLongExtra("msg_id", 0L);
        } catch (Exception e16) {
            c.a("PassByMsgIntentParser", "parserMsgId", e16);
        }
        try {
            bArr = this.f36421a.getByteArrayExtra("msg_content");
        } catch (Exception e17) {
            c.a("PassByMsgIntentParser", "parseMsgContent", e17);
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = inflaterInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                str = byteArrayOutputStream.toString("UTF-8");
            } catch (IOException e18) {
                c.a("DeflateUtil", "unZipString", e18);
            } finally {
                b.a(byteArrayInputStream);
                b.a(inflaterInputStream);
                b.a(byteArrayOutputStream);
            }
            if (str != null) {
                return null;
            }
            String optString = new JSONObject(str).optString("data");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
            honorPushDataMsg.setMsgId(j3);
            honorPushDataMsg.setData(optString);
            return honorPushDataMsg;
        }
        Log.w("DeflateUtil", "un zip data is empty");
        str = null;
        if (str != null) {
        }
    }
}

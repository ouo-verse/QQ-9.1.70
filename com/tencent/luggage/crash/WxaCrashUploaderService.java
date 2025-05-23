package com.tencent.luggage.crash;

import android.app.IntentService;
import android.content.Intent;
import com.tencent.luggage.wxa.jq.e;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.p1.a;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.x3.i;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.xweb.internal.ConstValue;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/luggage/crash/WxaCrashUploaderService;", "Landroid/app/IntentService;", "Landroid/content/Intent;", "intent", "", "onHandleIntent", "a", "Ljava/io/File;", "file", "", "uin", "", "productId", ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class WxaCrashUploaderService extends IntentService {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b implements g, e {
        @Override // com.tencent.luggage.wxa.jq.e
        public boolean a() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "";
        }

        @Override // java.lang.Runnable
        public void run() {
            i.f144579a.a();
        }
    }

    public WxaCrashUploaderService() {
        super("WxaCrashUploader");
    }

    public final void a(Intent intent) {
        int a16 = r.a(intent, "KEY_CRASH_TYPE", -1);
        if (a16 == 0) {
            i.a(i.f144579a, 365, 31, 0, 4, null);
        } else if (a16 == 1) {
            i.a(i.f144579a, 365, 33, 0, 4, null);
        } else if (a16 != 2) {
            return;
        } else {
            i.a(i.f144579a, 365, 32, 0, 4, null);
        }
        h.f146825d.d(new b());
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        boolean z16;
        w.d("Luggage.WxaCrashUploader", "onHandleIntent");
        if (intent == null) {
            w.b("Luggage.WxaCrashUploader", "intent is null, return");
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_CRASH_LOG_PATH");
        String stringExtra2 = intent.getStringExtra("KEY_CRASH_UIN");
        int intExtra = intent.getIntExtra("KEY_CRASH_PRODUCT_ID", -1);
        int intExtra2 = intent.getIntExtra("KEY_CLIENT_VERSION", -1);
        boolean z17 = false;
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.b("Luggage.WxaCrashUploader", "log path is null, return");
            return;
        }
        if (stringExtra2 == null || stringExtra2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            w.b("Luggage.WxaCrashUploader", "uin is null, return");
            return;
        }
        if (intExtra == -1) {
            w.b("Luggage.WxaCrashUploader", "product id not found, return");
            return;
        }
        if (intExtra2 == -1) {
            w.b("Luggage.WxaCrashUploader", "client version not found, return");
            return;
        }
        File file = new File(stringExtra);
        if (!file.exists()) {
            w.b("Luggage.WxaCrashUploader", "file not exist, return");
        } else {
            a(intent);
            a(file, stringExtra2, intExtra, intExtra2);
        }
    }

    public final void a(File file, String uin, int productId, int clientVersion) {
        byte[] bArr;
        try {
            bArr = FileUtils.readFileToByteArray(file);
        } catch (IOException unused) {
            w.b("Luggage.WxaCrashUploader", "read log file fail");
            bArr = new byte[0];
        }
        byte[] logData = bArr;
        FileUtils.deleteQuietly(file);
        HashMap hashMap = new HashMap();
        hashMap.put("reporttype", "9999");
        a aVar = a.f137108a;
        Intrinsics.checkNotNullExpressionValue(logData, "logData");
        aVar.a(productId, uin, clientVersion, logData, hashMap);
    }
}

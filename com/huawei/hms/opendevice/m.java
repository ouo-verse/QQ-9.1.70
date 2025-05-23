package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Map;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class m extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f37355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f37356b;

    public m(Context context, String str) {
        this.f37355a = context;
        this.f37356b = str;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean b16;
        boolean d16;
        String c16;
        if (p.b()) {
            b16 = n.b(this.f37355a);
            if (b16) {
                return;
            }
            String a16 = o.a(this.f37355a);
            if (!TextUtils.isEmpty(a16)) {
                d16 = n.d(this.f37355a, a16, this.f37356b);
                if (!d16) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                    return;
                }
                String string = AGConnectServicesConfig.fromContext(this.f37355a).getString(TtmlNode.TAG_REGION);
                if (TextUtils.isEmpty(string)) {
                    HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String a17 = e.a(this.f37355a, "com.huawei.hms.opendevicesdk", Logger.ROOT_LOGGER_NAME, null, string);
                if (!TextUtils.isEmpty(a17)) {
                    c16 = n.c(this.f37355a, a16, this.f37356b);
                    n.b(this.f37355a, d.a(this.f37355a, a17 + "/rest/appdata/v1/aaid/report", c16, (Map<String, String>) null), a16, this.f37356b);
                    return;
                }
                return;
            }
            HMSLog.w("ReportAaidToken", "AAID is empty.");
            return;
        }
        HMSLog.d("ReportAaidToken", "Not HW Phone.");
    }
}

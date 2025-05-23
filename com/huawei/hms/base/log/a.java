package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final HMSExtLogger f36764a;

    /* renamed from: b, reason: collision with root package name */
    private d f36765b;

    public a(HMSExtLogger hMSExtLogger) {
        this.f36764a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f36765b;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f36765b = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i3, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f36764a;
        if (hMSExtLogger != null) {
            if (i3 == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i3 == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i3 != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        d dVar = this.f36765b;
        if (dVar != null) {
            dVar.a(str, i3, str2, str3);
        }
    }
}

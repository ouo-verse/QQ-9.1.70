package com.qq.e.tg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WebReporter {

    /* renamed from: a, reason: collision with root package name */
    private WRI f40444a;

    public WebReporter(Context context, String str, String str2, long j3) {
        String str3;
        if (StringUtil.isEmpty(str)) {
            str3 = "init web reporter fail with error params";
        } else {
            try {
                if (!GDTADManager.getInstance().initWith(context, str)) {
                    GDTLogger.e("SDK is not ready!");
                    return;
                } else {
                    this.f40444a = GDTADManager.getInstance().getPM().getPOFactory().getWebReporterDelegate(str2, j3);
                    return;
                }
            } catch (com.qq.e.comm.managers.plugin.a unused) {
                str3 = "Web reporter created by factory return null";
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        GDTLogger.e(str3);
    }

    public void report(String str, int i3) {
        WRI wri = this.f40444a;
        if (wri != null) {
            wri.report(str, i3);
        }
    }
}

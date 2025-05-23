package com.tencent.mobileqq.kandian.base.image;

import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RIJImageOptMonitor {
    public static void a(final b bVar) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                b bVar2 = b.this;
                if (bVar2 == null || bVar2.f239011h <= 0) {
                    return;
                }
                if (bVar2.f239018o == 0 || !(bVar2.f239007d || b.this.f239020q == 0)) {
                    QLog.d("RIJImageOptMonitor", 1, "image load too slow: " + b.this);
                    RIJImageOptReport.i(b.this);
                    RIJImageOptMonitor.c(b.this);
                }
            }
        }, RIJImageOptConfig.INSTANCE.getMonitorTime());
    }

    public static void c(final b bVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                URL url;
                b bVar2 = b.this;
                if (bVar2 == null || (url = bVar2.f239004a) == null) {
                    return;
                }
                String url2 = url.toString();
                String[] b16 = RIJImageOptMonitor.b(b.this.f239004a.getHost());
                QLog.d("RIJImageOptMonitor", 1, "ping url: " + url2 + " ip: " + Arrays.toString(b16) + " time: " + SignalStrengthReport.a.b(url2));
            }
        }, 2, null, true);
    }

    public static String[] b(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length <= 0) {
                return null;
            }
            String[] strArr = new String[allByName.length];
            for (int i3 = 0; i3 < allByName.length; i3++) {
                strArr[i3] = allByName[i3].getHostAddress();
            }
            return strArr;
        } catch (UnknownHostException e16) {
            QLog.e("RIJImageOptMonitor", 1, e16.getMessage());
            return null;
        }
    }
}

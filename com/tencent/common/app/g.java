package com.tencent.common.app;

import android.app.ActivityManager;
import android.os.Build;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinEngineLog;
import com.tencent.theme.SkinEngineHandler;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g implements SkinEngineHandler, ISkinEngineLog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BaseApplicationImpl f99538a;

    /* renamed from: b, reason: collision with root package name */
    private int f99539b;

    public g(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
        } else {
            this.f99539b = -1;
            this.f99538a = baseApplicationImpl;
        }
    }

    @Override // com.tencent.theme.SkinEngineHandler
    public boolean onDecodeOOM(OutOfMemoryError outOfMemoryError, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, outOfMemoryError, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f99539b == -1) {
            this.f99539b = ((ActivityManager) this.f99538a.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
        }
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        StringBuffer stringBuffer = new StringBuffer("decode resources oom, fileName: ");
        stringBuffer.append(str);
        stringBuffer.append(", is skin file: ");
        stringBuffer.append(z16);
        stringBuffer.append(", memory used:");
        stringBuffer.append(freeMemory);
        stringBuffer.append(" , heap size: ");
        stringBuffer.append(this.f99539b);
        stringBuffer.append(", api level:");
        int i3 = Build.VERSION.SDK_INT;
        stringBuffer.append(i3);
        stringBuffer.append(", imageCache size:");
        stringBuffer.append(com.tencent.cache.core.manager.api.c.f98725d.g());
        QLog.e("res-OOM", 1, stringBuffer.toString());
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("param_FailCode", Integer.toString(89100));
        hashMap.put("param_heapSize", Integer.toString(this.f99539b));
        hashMap.put("param_apiLevel", Integer.toString(i3));
        hashMap.put("param_cacheUsed", Long.toString(freeMemory));
        try {
            StatisticCollector.getInstance(this.f99538a).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ImageCacheHelper.f98636a.e();
        System.gc();
        Thread.yield();
        System.gc();
        return true;
    }

    @Override // com.tencent.theme.SkinEngineHandler
    public boolean onDecodeReturnNullBitmap(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f99539b == -1) {
            this.f99539b = ((ActivityManager) this.f99538a.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
        }
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        StringBuffer stringBuffer = new StringBuffer("decode resources return null, fileName: ");
        stringBuffer.append(str);
        stringBuffer.append(", is skin file: ");
        stringBuffer.append(z16);
        stringBuffer.append(", memory used:");
        stringBuffer.append(freeMemory);
        stringBuffer.append(" , heap size: ");
        stringBuffer.append(this.f99539b);
        stringBuffer.append(", api level:");
        int i3 = Build.VERSION.SDK_INT;
        stringBuffer.append(i3);
        stringBuffer.append(", imageCache size:");
        stringBuffer.append(com.tencent.cache.core.manager.api.c.f98725d.g());
        QLog.e("res-OOM", 1, stringBuffer.toString());
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("param_FailCode", Integer.toString(89102));
        hashMap.put("param_heapSize", Integer.toString(this.f99539b));
        hashMap.put("param_apiLevel", Integer.toString(i3));
        hashMap.put("param_cacheUsed", Long.toString(freeMemory));
        try {
            StatisticCollector.getInstance(this.f99538a).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            QLog.e("res-OOM", 1, "collectPerformance fail", e16);
        }
        ImageCacheHelper.f98636a.e();
        System.gc();
        Thread.yield();
        System.gc();
        return true;
    }

    @Override // com.tencent.theme.SkinEngineHandler
    public boolean onSecondDecodeOOM(OutOfMemoryError outOfMemoryError, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, outOfMemoryError, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f99539b == -1) {
            this.f99539b = ((ActivityManager) this.f99538a.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
        }
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        StringBuffer stringBuffer = new StringBuffer("decode resources second oom, fileName: ");
        stringBuffer.append(str);
        stringBuffer.append(", is skin file: ");
        stringBuffer.append(z16);
        stringBuffer.append(", memory used:");
        stringBuffer.append(freeMemory);
        stringBuffer.append(" , heap size: ");
        stringBuffer.append(this.f99539b);
        stringBuffer.append(", api level:");
        int i3 = Build.VERSION.SDK_INT;
        stringBuffer.append(i3);
        stringBuffer.append(", imageCache size:");
        stringBuffer.append(com.tencent.cache.core.manager.api.c.f98725d.g());
        QLog.e("res-OOM", 1, stringBuffer.toString(), outOfMemoryError);
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("param_FailCode", Integer.toString(89101));
        hashMap.put("param_heapSize", Integer.toString(this.f99539b));
        hashMap.put("param_apiLevel", Integer.toString(i3));
        hashMap.put("param_cacheUsed", Long.toString(freeMemory));
        try {
            StatisticCollector.getInstance(this.f99538a).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            QLog.e("res-OOM", 1, "collectPerformance fail", e16);
        }
        ImageCacheHelper.f98636a.e();
        System.gc();
        Thread.yield();
        System.gc();
        return true;
    }

    @Override // com.tencent.theme.ISkinEngineLog
    public void trace(int i3, String str, int i16, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16), str2, th5);
            return;
        }
        if (1 == i16 || QLog.isColorLevel()) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        QLog.i(str, i16, str2, th5);
                        return;
                    } else {
                        QLog.e(str, i16, str2, th5);
                        return;
                    }
                }
                QLog.w(str, i16, str2, th5);
                return;
            }
            QLog.d(str, i16, str2, th5);
        }
    }
}

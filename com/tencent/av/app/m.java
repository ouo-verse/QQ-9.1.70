package com.tencent.av.app;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f73185a;

    /* renamed from: b, reason: collision with root package name */
    ComponentCallbacks f73186b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements ComponentCallbacks2 {
        a() {
        }

        private void a(int i3) {
            int i16;
            if (com.tencent.av.r.h0() != null) {
                com.tencent.av.r.h0().L3("lowMemoryLevel", String.valueOf(i3));
                try {
                    ActivityManager activityManager = (ActivityManager) BaseApplicationImpl.getApplication().getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    com.tencent.av.r.h0().L3("availMem", String.valueOf(memoryInfo.availMem / 1048576));
                    com.tencent.av.r.h0().L3("threshold", String.valueOf(memoryInfo.threshold / 1048576));
                    com.tencent.av.r h06 = com.tencent.av.r.h0();
                    if (memoryInfo.lowMemory) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    h06.L3(HippyReporter.RemoveEngineReason.LOW_MEMORY, String.valueOf(i16));
                } catch (Throwable th5) {
                    AVCoreLog.printErrorLog("GMemoryMonitor", th5.getMessage());
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            if (QLog.isColorLevel()) {
                QLog.d("GMemoryMonitor", 2, "onConfigurationChanged called");
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            QLog.d("GMemoryMonitor", 1, "onLowMemory called");
            m mVar = m.this;
            mVar.b(-10, mVar.f73185a.f73120h0);
            a(-10);
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            if (i3 == 15) {
                if (QLog.isColorLevel()) {
                    QLog.d("GMemoryMonitor", 2, "onTrimMemory called ,level = " + i3);
                }
                m mVar = m.this;
                mVar.b(i3, mVar.f73185a.f73120h0);
                ((VideoNodeReporter) m.this.f73185a.B(4)).v(27, i3);
                a(i3);
            }
        }
    }

    public m(VideoAppInterface videoAppInterface) {
        this.f73185a = videoAppInterface;
    }

    public void a() {
        try {
            if (this.f73186b == null) {
                this.f73186b = new a();
                BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.f73186b);
            }
        } catch (Throwable th5) {
            QLog.d("GMemoryMonitor", 1, "registerComponentCallbacks failed", th5);
        }
    }

    void b(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("GMemoryMonitor", 2, "reportLowMemory  level = " + i3 + ",isExit = " + z16);
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("lowMemoryLevel", String.valueOf(i3));
            hashMap.put("isExit", String.valueOf(z16));
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "av_qua_low_memory", true, 0L, 0L, hashMap, "", true);
            String model = DeviceInfoMonitor.getModel();
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            try {
                String currentAccountUin = this.f73185a.getCurrentAccountUin();
                StringBuilder sb5 = new StringBuilder();
                SessionInfo f16 = com.tencent.av.n.e().f();
                if (f16 != null) {
                    String str = f16.f73091w;
                    String str2 = f16.f73030h;
                    String str3 = com.tencent.av.r.h0().J(str) + "";
                    if (QLog.isColorLevel()) {
                        QLog.d("GMemoryMonitor", 2, "reportLowMemory  ,roomID = " + str3);
                    }
                    sb5.append("Android");
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(model);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(valueOf);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(valueOf);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(currentAccountUin);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(str);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(str3);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(str2);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(i3);
                }
                String sb6 = sb5.toString();
                if (QLog.isColorLevel()) {
                    QLog.d("GMemoryMonitor", 2, "reportLowMemory  dcDetail = " + sb6);
                }
                DcReportUtil.b(null, "dc02660", sb6);
            } catch (Exception e16) {
                e = e16;
                QLog.d("GMemoryMonitor", 1, "reportLowMemory  Exception", e);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public void c() {
        try {
            if (this.f73186b != null) {
                this.f73185a.getApplication().unregisterComponentCallbacks(this.f73186b);
                this.f73186b = null;
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("GMemoryMonitor", 2, "onDestroy unregisterComponentCallbacks failed", th5);
            }
        }
    }
}

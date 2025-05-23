package com.qzone.common.tool;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ReportUtils {

    /* compiled from: P */
    /* renamed from: com.qzone.common.tool.ReportUtils$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f46126d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f46127e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f46128f;

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(this.f46126d, Integer.valueOf(this.f46127e));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.f46128f, true, 0L, 0L, hashMap, null);
        }
    }

    public static void a(final String str, final String str2, final String str3, final int i3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.common.tool.ReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(str2, str3);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, i3, 0L, hashMap, null);
            }
        });
    }

    public static void b(final String str, final HashMap<String, String> hashMap) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.common.tool.ReportUtils.3
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, (String) null, true);
            }
        });
    }
}

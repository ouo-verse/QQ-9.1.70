package com.tencent.mobileqq.guild.live.livemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes14.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static BroadcastReceiver f226936a;

    /* renamed from: b, reason: collision with root package name */
    private static LinkedList<b> f226937b;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!StringUtil.isEmpty(action) && action == IECScreenReceiver.ACTION_SCREEN_OFF && s.f226937b == null) {
                s.f226937b = new LinkedList();
                s.d(s.f226937b);
                s.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        long f226938a;

        /* renamed from: b, reason: collision with root package name */
        long f226939b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(LinkedList<b> linkedList) {
        if (linkedList != null) {
            b bVar = new b();
            bVar.f226938a = System.currentTimeMillis();
            linkedList.add(bVar);
        }
    }

    public static long e(long j3, long j16) {
        long j17;
        LinkedList<b> linkedList = f226937b;
        if (linkedList == null || linkedList.isEmpty()) {
            return 0L;
        }
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(f226937b);
        f226937b.clear();
        f226937b = null;
        Iterator it = linkedList2.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            long j19 = bVar.f226938a;
            long j26 = bVar.f226939b;
            if (j26 == 0) {
                QLog.e("QQGuildLiveScreenOffOnManager", 2, "screenOnTime == 0");
                j26 = j16;
            }
            if (j26 <= j19) {
                QLog.e("QQGuildLiveScreenOffOnManager", 2, "invalid data");
            } else if (j26 >= j3 && j19 <= j16) {
                if (j19 < j3) {
                    j17 = j26 - j3;
                    QLog.w("QQGuildLiveScreenOffOnManager", 2, "screenOffTime < startPlayTime span=" + j17);
                } else if (j26 > j16) {
                    j17 = j16 - j19;
                    QLog.w("QQGuildLiveScreenOffOnManager", 2, "screenOnTime > firstFrameComeTime span=" + j17);
                } else {
                    j17 = j26 - j19;
                    QLog.w("QQGuildLiveScreenOffOnManager", 2, "span=" + j17);
                }
                j18 += j17;
            } else {
                QLog.e("QQGuildLiveScreenOffOnManager", 2, "useless data");
            }
        }
        return j18;
    }

    public static void f() {
        LinkedList<b> linkedList = f226937b;
        if (linkedList != null) {
            d(linkedList);
        }
    }

    public static void g() {
        LinkedList<b> linkedList = f226937b;
        if (linkedList == null) {
            QLog.e("QQGuildLiveScreenOffOnManager", 2, "init events");
            f226937b = new LinkedList<>();
        } else if (linkedList.size() > 0) {
            f226937b.getLast().f226939b = System.currentTimeMillis();
            QLog.e("QQGuildLiveScreenOffOnManager", 2, "screenOffOnEvents:" + f226937b.size());
        }
    }

    public static void h() {
        if (!Foreground.isCurrentProcessForeground()) {
            if (f226937b == null) {
                LinkedList<b> linkedList = new LinkedList<>();
                f226937b = linkedList;
                d(linkedList);
                return;
            }
            return;
        }
        try {
            if (!((PowerManager) BaseApplication.getContext().getSystemService("power")).isScreenOn()) {
                if (f226937b == null) {
                    LinkedList<b> linkedList2 = new LinkedList<>();
                    f226937b = linkedList2;
                    d(linkedList2);
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        if (f226936a == null) {
            f226936a = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            BaseApplication.getContext().registerReceiver(f226936a, intentFilter);
        }
    }

    public static void i() {
        if (f226936a != null) {
            BaseApplication.getContext().unregisterReceiver(f226936a);
            f226936a = null;
        }
        LinkedList<b> linkedList = f226937b;
        if (linkedList != null) {
            linkedList.clear();
            f226937b = null;
        }
    }
}

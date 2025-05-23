package com.tencent.mobileqq.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ad implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final a f306535d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedList<ae> f306536e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private final LinkedList<ae> f306537f = new LinkedList<>();

    /* renamed from: h, reason: collision with root package name */
    private final Handler f306538h = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);

    /* renamed from: i, reason: collision with root package name */
    private long f306539i = 0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(int i3, List<ae> list);

        void b(ae aeVar);
    }

    public ad(a aVar) {
        this.f306535d = aVar;
    }

    private void a(ae aeVar) {
        if (aeVar != null && !this.f306537f.contains(aeVar)) {
            aeVar.f306545f = SystemClock.elapsedRealtime();
            this.f306537f.add(aeVar);
            if (!this.f306538h.hasMessages(2)) {
                this.f306538h.sendEmptyMessageDelayed(2, 30000L);
            }
        }
    }

    private void c(ae aeVar) {
        if (!aeVar.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("FetchInfoListManager", 2, StringUtil.makeLogMsg("addToNeedFetchInfoListInner() ", aeVar.toString(), "\u975e\u6cd5\u8bf7\u6c42"));
                return;
            }
            return;
        }
        if (!this.f306536e.contains(aeVar) && !this.f306537f.contains(aeVar)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg("addToNeedFetchInfoListInner()", aeVar.toString()));
            }
            this.f306536e.addFirst(aeVar);
            if (!this.f306538h.hasMessages(1)) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f306539i;
                if (elapsedRealtime >= 0 && elapsedRealtime <= 2000) {
                    this.f306538h.sendEmptyMessageDelayed(1, 300L);
                    return;
                } else {
                    this.f306538h.sendEmptyMessage(1);
                    return;
                }
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg("addToNeedFetchInfoListInner()", aeVar.toString(), "\u5df2\u7ecf\u5728\u961f\u5217\u4e2d\u4e86"));
        }
    }

    private void e() {
        StringBuilder sb5;
        if (QLog.isDevelopLevel()) {
            sb5 = new StringBuilder(200);
            sb5.append("dealTimeOut  size:");
            sb5.append(this.f306537f.size());
            sb5.append(" {");
        } else {
            sb5 = null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = 30000;
        for (int size = this.f306537f.size() - 1; size >= 0; size--) {
            ae aeVar = this.f306537f.get(size);
            if (aeVar == null) {
                this.f306537f.remove(aeVar);
            } else {
                long j16 = elapsedRealtime - aeVar.f306545f;
                if (j16 >= 0 && j16 < 30000) {
                    if (j16 < j3) {
                        j3 = j16;
                    }
                } else {
                    this.f306537f.remove(aeVar);
                    if (sb5 != null) {
                        sb5.append(", [");
                        sb5.append(aeVar.f306540a);
                        sb5.append(",");
                        sb5.append(aeVar.f306541b);
                        sb5.append("]");
                    }
                }
            }
        }
        if (!this.f306537f.isEmpty()) {
            this.f306538h.sendEmptyMessageDelayed(2, Math.max(1000L, j3));
        }
        if (QLog.isDevelopLevel() && sb5 != null) {
            sb5.append("}");
            sb5.append(" isEmpty: ");
            sb5.append(this.f306537f.isEmpty());
            QLog.d("FetchInfoListManager", 4, sb5.toString());
        }
    }

    private void f() {
        ae removeFirst;
        if (this.f306536e.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FetchInfoListManager", 4, "doFetchInfo fetch list is empty!");
                return;
            }
            return;
        }
        do {
            removeFirst = this.f306536e.removeFirst();
            if (removeFirst != null) {
                break;
            }
        } while (!this.f306536e.isEmpty());
        if (removeFirst == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
                return;
            }
            return;
        }
        this.f306539i = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", Integer.valueOf(removeFirst.f306540a), removeFirst.f306541b, Long.valueOf(this.f306539i)));
        }
        if (removeFirst.f306540a == 1) {
            ArrayList arrayList = new ArrayList();
            a(removeFirst);
            arrayList.add(removeFirst);
            for (int min = Math.min(this.f306536e.size(), 20) - 1; min >= 0; min--) {
                ae aeVar = this.f306536e.get(min);
                if (aeVar != null && aeVar.f306540a == 1) {
                    this.f306536e.remove(min);
                    a(aeVar);
                    arrayList.add(aeVar);
                }
            }
            this.f306535d.a(1, arrayList);
        } else {
            a(removeFirst);
            this.f306535d.b(removeFirst);
        }
        if (!this.f306536e.isEmpty()) {
            this.f306538h.sendEmptyMessage(1);
        }
    }

    public void b(int i3, String str, String str2, Object obj, Bundle bundle) {
        this.f306538h.sendMessage(this.f306538h.obtainMessage(3, new ae(i3, str, str2, obj, bundle)));
        if (QLog.isDevelopLevel()) {
            QLog.i("FetchInfoListManager", 4, String.format(Locale.getDefault(), "addToNeedFetchInfoList [%d, %s]", Integer.valueOf(i3), str));
        }
    }

    public void d() {
        this.f306536e.clear();
        this.f306537f.clear();
        this.f306538h.removeCallbacksAndMessages(null);
        if (QLog.isDevelopLevel()) {
            QLog.i("FetchInfoListManager", 4, QCircleLpReportDc05507.KEY_CLEAR);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 3) {
            Object obj = message.obj;
            if (obj instanceof ae) {
                c((ae) obj);
            }
        } else if (i3 == 1) {
            f();
        } else if (i3 == 2) {
            e();
        }
        return true;
    }
}

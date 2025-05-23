package com.qzone.reborn.feedx.video.process;

import android.os.Looper;
import com.qzone.reborn.feedx.video.c;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.LinkedList;

/* loaded from: classes37.dex */
public class QZonePlayerOptionsProcessManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QZonePlayerOptionsProcessManager f55835a;

    /* loaded from: classes37.dex */
    public interface b {
        void a(c cVar, boolean z16);
    }

    QZonePlayerOptionsProcessManager() {
    }

    public static QZonePlayerOptionsProcessManager d() {
        if (f55835a == null) {
            synchronized (QZonePlayerOptionsProcessManager.class) {
                if (f55835a == null) {
                    f55835a = new QZonePlayerOptionsProcessManager();
                }
            }
        }
        return f55835a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkedList f55838a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f55839b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.feedx.video.process.a f55840c;

        a(LinkedList linkedList, b bVar, com.qzone.reborn.feedx.video.process.a aVar) {
            this.f55838a = linkedList;
            this.f55839b = bVar;
            this.f55840c = aVar;
        }

        @Override // com.qzone.reborn.feedx.video.process.QZonePlayerOptionsProcessManager.b
        public void a(c cVar, boolean z16) {
            if (z16) {
                QZonePlayerOptionsProcessManager qZonePlayerOptionsProcessManager = QZonePlayerOptionsProcessManager.this;
                qZonePlayerOptionsProcessManager.f(qZonePlayerOptionsProcessManager.e(this.f55838a), cVar, this.f55839b);
                return;
            }
            RFWLog.d("QZonePlayerOptionsProcessManager_" + cVar.s(), RFWLog.USR, "startProcess() | end by process:" + this.f55840c.getClass().getSimpleName() + "currentOption:" + cVar);
            QZonePlayerOptionsProcessManager.this.c(cVar, this.f55839b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<com.qzone.reborn.feedx.video.process.a> e(LinkedList<com.qzone.reborn.feedx.video.process.a> linkedList) {
        if (linkedList != null && linkedList.size() != 0) {
            linkedList.remove(0);
            return linkedList;
        }
        return new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final c cVar, final b bVar) {
        if (bVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bVar.a(cVar, false);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.process.QZonePlayerOptionsProcessManager.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.a(cVar, false);
                }
            });
        }
    }

    public void f(LinkedList<com.qzone.reborn.feedx.video.process.a> linkedList, c cVar, b bVar) {
        if (cVar == null || linkedList == null || bVar == null) {
            return;
        }
        if (linkedList.size() == 0) {
            RFWLog.d("QZonePlayerOptionsProcessManager_" + cVar.s(), RFWLog.USR, "startProcess()| end order empty| current option" + cVar);
            c(cVar, bVar);
            return;
        }
        com.qzone.reborn.feedx.video.process.a aVar = linkedList.get(0);
        if (aVar == null) {
            RFWLog.d("QZonePlayerOptionsProcessManager_" + cVar.s(), RFWLog.USR, "startProcess()|  edn error key");
            c(cVar, bVar);
            return;
        }
        aVar.a(cVar, new a(linkedList, bVar, aVar));
    }
}

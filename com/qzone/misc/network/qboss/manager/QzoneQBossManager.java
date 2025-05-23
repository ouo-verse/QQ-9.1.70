package com.qzone.misc.network.qboss.manager;

import BOSSStrategyCenter.tAdvDesc;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.qboss.model.QBossDBData;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.misc.network.qboss.util.JsonORM;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneQBossManager {

    /* renamed from: a, reason: collision with root package name */
    private AbsCompatRequest.b f48439a = new a();

    /* renamed from: b, reason: collision with root package name */
    private AbsCompatRequest.a f48440b = new b();

    /* compiled from: P */
    /* renamed from: com.qzone.misc.network.qboss.manager.QzoneQBossManager$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f48442d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Class f48443e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ q7.a f48444f;
        final /* synthetic */ QzoneQBossManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            p7.a e16 = this.this$0.e(this.f48442d, this.f48443e);
            q7.a aVar = this.f48444f;
            if (aVar != null) {
                aVar.b(e16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.misc.network.qboss.manager.QzoneQBossManager$5, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f48445d;
        final /* synthetic */ QzoneQBossManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("QzoneQBossManager", 2, "deleteQbossData count = ", Integer.valueOf(com.qzone.misc.network.qboss.manager.a.c().a(this.f48445d)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsCompatRequest.b {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, s sVar) {
            if (sVar.getData() instanceof QzoneQBossAdvRequest.a) {
                QzoneQBossAdvRequest.a aVar = (QzoneQBossAdvRequest.a) sVar.getData();
                if (aVar.f48460a == 0) {
                    sVar.setSucceed(true);
                } else {
                    sVar.setSucceed(false);
                    QZLog.e("QzoneQBossManager", "on Qboss fail return code: " + aVar.f48460a);
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AbsCompatRequest.a {
        b() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QzoneQBossManager.this.g(absCompatRequest, sVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f48448a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f48449b = true;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final QzoneQBossManager f48451a = new QzoneQBossManager();
    }

    QzoneQBossManager() {
    }

    public static QzoneQBossManager c() {
        return d.f48451a;
    }

    private com.qzone.album.base.Service.b d() {
        return u4.a.z().D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends p7.a> T e(int i3, Class<T> cls) {
        QBossDBData f16 = com.qzone.misc.network.qboss.manager.a.c().f(i3);
        T t16 = null;
        if (f16 == null) {
            return null;
        }
        try {
            T t17 = (T) JsonORM.d(new JSONObject(f16.jString), cls);
            try {
                t17.f425442a = f16.qbossId;
                t17.f425443b = f16.writeInTime;
                t17.f425444c = f16.jString;
                return t17;
            } catch (Exception e16) {
                e = e16;
                t16 = t17;
                QZLog.e("QzoneQBossManager", "getQbossCache Exception", e);
                return t16;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private QzoneBaseThread f() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends p7.a> void g(AbsCompatRequest absCompatRequest, s sVar) {
        int intValue = ((Integer) absCompatRequest.getParam("qboss_id")).intValue();
        Class cls = (Class) absCompatRequest.getParam("qboss_class");
        q7.a aVar = (q7.a) absCompatRequest.getParam("qboss_data_callback");
        boolean booleanValue = ((Boolean) absCompatRequest.getParam("save_to_db_cache")).booleanValue();
        T t16 = null;
        if (!sVar.getSucceed() || !(sVar.getData() instanceof QzoneQBossAdvRequest.a)) {
            if (aVar != null) {
                aVar.a(null, false);
                return;
            }
            return;
        }
        try {
            ArrayList<tAdvDesc> arrayList = ((QzoneQBossAdvRequest.a) sVar.getData()).f48461b.get(Integer.valueOf(intValue));
            if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                tAdvDesc tadvdesc = arrayList.get(0);
                p7.a aVar2 = (p7.a) JsonORM.d(new JSONObject(tadvdesc.res_data), cls);
                aVar2.f425442a = intValue;
                aVar2.f425444c = tadvdesc.res_data;
                aVar2.f425443b = System.currentTimeMillis();
                if (booleanValue) {
                    i(aVar2.a());
                }
                t16 = aVar2;
            }
        } catch (Exception e16) {
            QZLog.e("QzoneQBossManager", "handleVideoTabBanner Exception", e16);
        }
        if (aVar != null) {
            aVar.a(t16, true);
        }
    }

    private void i(final QBossDBData qBossDBData) {
        f().post(new Runnable() { // from class: com.qzone.misc.network.qboss.manager.QzoneQBossManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.qzone.misc.network.qboss.manager.a.c().g(qBossDBData)) {
                    QZLog.i("QzoneQBossManager", 2, "saveQbossData result succeed");
                } else {
                    QZLog.i("QzoneQBossManager", 2, "saveQbossData result failed");
                }
            }
        });
    }

    public <T extends p7.a> void h(int i3, c cVar, Class<T> cls, q7.a<T> aVar) {
        if (cVar == null) {
            cVar = new c();
        }
        QzoneQBossAdvRequest qzoneQBossAdvRequest = new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), i3, cVar.f48448a);
        qzoneQBossAdvRequest.setOnJceParseListener(this.f48439a).setCallback(this.f48440b).addParam("qboss_data_callback", aVar).addParam("qboss_id", Integer.valueOf(i3)).addParam("qboss_class", cls).addParam("save_to_db_cache", Boolean.valueOf(cVar.f48449b));
        d().c(qzoneQBossAdvRequest, null);
    }
}

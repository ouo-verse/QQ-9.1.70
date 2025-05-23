package k0;

import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.open.pcpush.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    DataLineHandler f411314a;

    /* renamed from: b, reason: collision with root package name */
    private c.a f411315b = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements c.a {
        a() {
        }

        @Override // com.tencent.open.pcpush.c.a
        public void a(int i3, String str) {
            List<DataLineMsgRecord> r16 = b.this.f411314a.f194539a0.getDataLineMsgProxy(0).r(str);
            switch (i3) {
                case 1:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.START(" + str + ")");
                    }
                    if (r16 == null) {
                        return;
                    }
                    for (DataLineMsgRecord dataLineMsgRecord : r16) {
                        dataLineMsgRecord.issuc = true;
                        dataLineMsgRecord.fileMsgStatus = 0L;
                        b.this.f411314a.f194539a0.getMessageFacade().t1(0).j(dataLineMsgRecord.msgId);
                        b.this.f411314a.N3(6, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path, (byte) 0, Boolean.FALSE, Boolean.TRUE, Long.valueOf(dataLineMsgRecord.filesize)});
                    }
                    return;
                case 2:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.PAUSE(" + str + ")");
                    }
                    if (r16 == null) {
                        return;
                    }
                    for (DataLineMsgRecord dataLineMsgRecord2 : r16) {
                        if (!dataLineMsgRecord2.issuc || dataLineMsgRecord2.progress != 1.0f) {
                            dataLineMsgRecord2.issuc = false;
                            dataLineMsgRecord2.fileMsgStatus = 2L;
                            b.this.f411314a.f194539a0.getMessageFacade().t1(0).j(dataLineMsgRecord2.msgId);
                            b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                            b.this.f411314a.N3(3, false, new Object[]{0L, Long.valueOf(dataLineMsgRecord2.sessionid), dataLineMsgRecord2.path});
                        }
                    }
                    return;
                case 3:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.WAIT(" + str + ")");
                        return;
                    }
                    return;
                case 4:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.FINISH(" + str + ")");
                    }
                    if (r16 == null) {
                        return;
                    }
                    for (DataLineMsgRecord dataLineMsgRecord3 : r16) {
                        com.dataline.util.b.a(b.this.f411314a.f194539a0);
                        dataLineMsgRecord3.issuc = true;
                        dataLineMsgRecord3.progress = 1.0f;
                        dataLineMsgRecord3.path = c.i().f(dataLineMsgRecord3.strMoloKey);
                        if (QLog.isColorLevel()) {
                            if (dataLineMsgRecord3.path != null) {
                                QLog.d("dataline.MoloHandler", 2, "PCPushProxy.getDownloadPath(" + dataLineMsgRecord3.strMoloKey + ") \"" + dataLineMsgRecord3.path + "'");
                            } else {
                                QLog.d("dataline.MoloHandler", 2, "PCPushProxy.getDownloadPath(" + dataLineMsgRecord3.strMoloKey + ") NULL");
                            }
                        }
                        b.this.f411314a.f194539a0.getDataLineMsgProxy(0).E(dataLineMsgRecord3.msgId, dataLineMsgRecord3.path);
                        b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                        b.this.f411314a.N3(3, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord3.sessionid), dataLineMsgRecord3.path});
                        b.this.f411314a.w3().getMessageFacade().t1(0).n(dataLineMsgRecord3.msgId);
                    }
                    return;
                case 5:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.CANCEL(" + str + ")");
                    }
                    if (r16 == null) {
                        return;
                    }
                    for (DataLineMsgRecord dataLineMsgRecord4 : r16) {
                        if (!dataLineMsgRecord4.issuc || dataLineMsgRecord4.progress != 1.0f) {
                            dataLineMsgRecord4.issuc = false;
                            b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                            b.this.f411314a.N3(3, false, new Object[]{0L, Long.valueOf(dataLineMsgRecord4.sessionid), dataLineMsgRecord4.path});
                        }
                    }
                    return;
                case 6:
                    if (QLog.isColorLevel()) {
                        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.INSTALLED(" + str + ")");
                    }
                    com.dataline.util.b.c(b.this.f411314a.f194539a0);
                    b.this.f411314a.N3(9, true, new Object[]{str});
                    return;
                default:
                    return;
            }
        }

        @Override // com.tencent.open.pcpush.c.a
        public void b(c.b bVar, int i3, String str, int i16) {
            if (bVar != null && i3 != -25) {
                if (QLog.isColorLevel()) {
                    QLog.d("dataline.MoloHandler", 2, "onDownloadError(" + bVar.toString() + "), key[" + bVar.f341705a + "], errorCode" + i3 + "], state[" + i16);
                }
                List<DataLineMsgRecord> r16 = b.this.f411314a.f194539a0.getDataLineMsgProxy(0).r(bVar.f341705a);
                if (r16 == null) {
                    return;
                }
                for (DataLineMsgRecord dataLineMsgRecord : r16) {
                    com.dataline.util.b.b(b.this.f411314a.f194539a0);
                    dataLineMsgRecord.issuc = false;
                    b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                    b.this.f411314a.N3(3, false, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path});
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("dataline.MoloHandler", 2, "onDownloadError( tm exit)");
            }
            DataLineMsgSetList f16 = b.this.f411314a.w3().getProxyManager().g(0).f();
            DataLineMsgSetList o16 = b.this.f411314a.w3().getProxyManager().g(0).o(true);
            Iterator<DataLineMsgSet> it = f16.iterator();
            while (it.hasNext()) {
                Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
                while (it5.hasNext()) {
                    DataLineMsgRecord next = it5.next();
                    if (next.strMoloKey != null && (!next.issuc || next.progress != 1.0f)) {
                        next.issuc = false;
                        b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                        b.this.f411314a.N3(3, false, new Object[]{0L, Long.valueOf(next.sessionid), next.path});
                    }
                }
            }
            if (o16 != null) {
                Iterator<DataLineMsgSet> it6 = o16.iterator();
                while (it6.hasNext()) {
                    Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                    while (it7.hasNext()) {
                        DataLineMsgRecord next2 = it7.next();
                        if (next2.strMoloKey != null && (!next2.issuc || next2.progress != 1.0f)) {
                            next2.issuc = false;
                            b.this.f411314a.f194539a0.getMessageFacade().t1(0).b();
                            b.this.f411314a.N3(3, false, new Object[]{0L, Long.valueOf(next2.sessionid), next2.path});
                        }
                    }
                }
            }
        }

        @Override // com.tencent.open.pcpush.c.a
        public void onDownloadUpdate(List<c.b> list) {
            for (c.b bVar : list) {
                if (QLog.isColorLevel()) {
                    QLog.d("dataline.MoloHandler", 2, "onDownloadUpdatem key[" + bVar.f341705a + "], appName[" + bVar.f341710f + "], progress[" + bVar.f341720p);
                }
                List<DataLineMsgRecord> r16 = b.this.f411314a.f194539a0.getDataLineMsgProxy(0).r(bVar.f341705a);
                if (r16 != null) {
                    for (DataLineMsgRecord dataLineMsgRecord : r16) {
                        float f16 = bVar.f341720p / 100.0f;
                        if (dataLineMsgRecord.progress < f16) {
                            dataLineMsgRecord.progress = f16;
                        }
                        b.this.f411314a.N3(4, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), Float.valueOf(f16)});
                    }
                }
            }
        }
    }

    public b(DataLineHandler dataLineHandler) {
        this.f411314a = dataLineHandler;
        c.i().m(this.f411315b);
    }

    public void a() {
        c.i().q(this.f411315b);
    }

    public boolean b(String str) {
        c.i().l(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy pause(" + str + ")");
            return true;
        }
        return true;
    }

    public boolean c() {
        DataLineHandler dataLineHandler = this.f411314a;
        if (dataLineHandler != null && dataLineHandler.w3() != null && this.f411314a.w3().getProxyManager() != null) {
            DataLineMsgSetList f16 = this.f411314a.w3().getProxyManager().g(0).f();
            DataLineMsgSetList o16 = this.f411314a.w3().getProxyManager().g(0).o(true);
            Iterator<DataLineMsgSet> it = f16.iterator();
            while (it.hasNext()) {
                Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
                while (it5.hasNext()) {
                    String str = it5.next().strMoloKey;
                    if (str != null) {
                        b(str);
                    }
                }
            }
            if (o16 != null) {
                Iterator<DataLineMsgSet> it6 = o16.iterator();
                while (it6.hasNext()) {
                    Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                    while (it7.hasNext()) {
                        String str2 = it7.next().strMoloKey;
                        if (str2 != null) {
                            b(str2);
                        }
                    }
                }
            }
            return true;
        }
        QLog.e("dataline.MoloHandler", 1, "cancelAll app about = null");
        return false;
    }

    public boolean d(String str) {
        c.i().d(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy delete(" + str + ")");
            return true;
        }
        return true;
    }

    public boolean e(String str) {
        com.dataline.util.b.d(this.f411314a.f194539a0);
        c.i().h(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy install : " + str);
            return true;
        }
        return true;
    }

    public boolean f(String str) {
        boolean j3 = c.i().j(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy isInstalled(" + str + "):" + j3);
        }
        return j3;
    }

    public int g(String str) {
        com.dataline.util.b.h(this.f411314a.f194539a0);
        int k3 = c.i().k(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy open(" + str + "):" + k3);
        }
        return k3;
    }

    public void h(int i3) {
        c.i().n(i3);
    }

    public void i(int i3) {
        c.i().o(i3);
    }

    public boolean j(String str) {
        boolean p16 = c.i().p(str);
        if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "PCPushProxy start(" + str + "):" + p16);
        }
        if (p16) {
            List<DataLineMsgRecord> r16 = this.f411314a.f194539a0.getDataLineMsgProxy(0).r(str);
            if (r16 == null) {
                return p16;
            }
            for (DataLineMsgRecord dataLineMsgRecord : r16) {
                dataLineMsgRecord.issuc = true;
                dataLineMsgRecord.fileMsgStatus = 0L;
                this.f411314a.f194539a0.getMessageFacade().t1(0).j(dataLineMsgRecord.msgId);
                this.f411314a.N3(6, true, new Object[]{0L, Long.valueOf(dataLineMsgRecord.sessionid), dataLineMsgRecord.path, (byte) 0, Boolean.FALSE, Boolean.TRUE, Long.valueOf(dataLineMsgRecord.filesize)});
            }
        }
        return p16;
    }
}

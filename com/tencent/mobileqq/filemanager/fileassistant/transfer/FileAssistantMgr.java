package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.k;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileAssistantMgr implements yb1.a {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f208004a;

    /* renamed from: b, reason: collision with root package name */
    List<FileAssistantSender> f208005b;

    /* renamed from: c, reason: collision with root package name */
    List<FileAssistantRecver> f208006c;

    /* renamed from: d, reason: collision with root package name */
    Handler f208007d;

    private synchronized void k() {
        QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed START----");
        List<FileAssistantSender> list = this.f208005b;
        if (list != null) {
            for (FileAssistantSender fileAssistantSender : list) {
                QLog.i("FileAssistantMgrNDL", 1, "remove sender:" + fileAssistantSender.z());
                fileAssistantSender.E();
            }
            this.f208005b.clear();
        }
        List<FileAssistantRecver> list2 = this.f208006c;
        if (list2 != null) {
            for (FileAssistantRecver fileAssistantRecver : list2) {
                QLog.i("FileAssistantMgrNDL", 1, "remove recver:" + fileAssistantRecver.m());
                fileAssistantRecver.s();
            }
            this.f208006c.clear();
        }
        QLog.i("FileAssistantMgrNDL", 1, "----setAllFailed END----");
    }

    @Override // yb1.a
    public synchronized void a(final FileAssistantRecver fileAssistantRecver) {
        if (this.f208006c.size() == 0) {
            QLog.i("FileAssistantMgrNDL", 1, "mRecvQueue is empty!");
        } else {
            this.f208007d.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.2
                @Override // java.lang.Runnable
                public void run() {
                    if (fileAssistantRecver != null) {
                        QLog.i("FileAssistantMgrNDL", 1, "remove recver:" + fileAssistantRecver.m());
                        fileAssistantRecver.g();
                        FileAssistantMgr.this.f208006c.remove(fileAssistantRecver);
                    }
                }
            });
        }
    }

    @Override // yb1.a
    public synchronized void b(final FileAssistantSender fileAssistantSender) {
        if (this.f208005b.size() == 0) {
            QLog.i("FileAssistantMgrNDL", 1, "mSendQueue is empty!");
        } else {
            this.f208007d.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (fileAssistantSender != null) {
                        QLog.i("FileAssistantMgrNDL", 1, "remove sender:" + fileAssistantSender.z());
                        fileAssistantSender.t();
                        FileAssistantMgr.this.f208005b.remove(fileAssistantSender);
                    }
                }
            });
        }
    }

    public synchronized boolean c(FileManagerEntity fileManagerEntity) {
        QLog.i("FileAssistantMgrNDL", 1, "cancelRecv : " + fileManagerEntity.nSessionId);
        List<FileAssistantRecver> list = this.f208006c;
        if (list != null && list.size() != 0) {
            for (FileAssistantRecver fileAssistantRecver : this.f208006c) {
                if (fileAssistantRecver.l(fileManagerEntity.nSessionId)) {
                    fileAssistantRecver.u();
                    return true;
                }
            }
            return false;
        }
        QLog.i("FileAssistantMgrNDL", 1, "mRecvQueue is null or size is 0");
        return false;
    }

    public synchronized boolean d(FileManagerEntity fileManagerEntity) {
        QLog.i("FileAssistantMgrNDL", 1, "cancelSend : " + fileManagerEntity.nSessionId);
        List<FileAssistantSender> list = this.f208005b;
        if (list != null && list.size() != 0) {
            for (FileAssistantSender fileAssistantSender : this.f208005b) {
                if (fileAssistantSender.y(fileManagerEntity.nSessionId)) {
                    fileAssistantSender.F();
                    return true;
                }
            }
            return false;
        }
        QLog.i("FileAssistantMgrNDL", 1, "mSendQueue is null or size is 0");
        return false;
    }

    public void e() {
        k();
    }

    public void f(QQAppInterface qQAppInterface) {
        this.f208004a = qQAppInterface;
        this.f208007d = ThreadManagerV2.getUIHandlerV2();
    }

    public synchronized void g(FileManagerEntity fileManagerEntity) {
        FileAssistantRecver fileAssistantRecver;
        if (this.f208006c == null) {
            this.f208006c = new ArrayList();
        }
        Iterator<FileAssistantRecver> it = this.f208006c.iterator();
        while (true) {
            if (it.hasNext()) {
                fileAssistantRecver = it.next();
                if (fileAssistantRecver.l(fileManagerEntity.nSessionId)) {
                    break;
                }
            } else {
                fileAssistantRecver = null;
                break;
            }
        }
        if (fileAssistantRecver == null) {
            fileAssistantRecver = new FileAssistantRecver(this.f208004a, this, fileManagerEntity);
        }
        QLog.i("FileAssistantMgrNDL", 1, "add new recver :" + fileManagerEntity.nSessionId);
        this.f208006c.add(fileAssistantRecver);
        fileAssistantRecver.i();
    }

    public synchronized void h(FileManagerEntity fileManagerEntity) {
        if (this.f208006c == null) {
            this.f208006c = new ArrayList();
        }
        QLog.i("FileAssistantMgrNDL", 1, "retryRecv:" + fileManagerEntity.nSessionId);
        FileAssistantRecver fileAssistantRecver = new FileAssistantRecver(this.f208004a, this, fileManagerEntity);
        this.f208006c.add(fileAssistantRecver);
        fileAssistantRecver.j();
    }

    public synchronized void i(FileManagerEntity fileManagerEntity) {
        if (this.f208005b == null) {
            this.f208005b = new ArrayList();
        }
        QLog.i("FileAssistantMgrNDL", 1, "retrySend:" + fileManagerEntity.nSessionId);
        FileAssistantSender fileAssistantSender = new FileAssistantSender(this.f208004a, this, fileManagerEntity);
        this.f208005b.add(fileAssistantSender);
        fileAssistantSender.w(true);
    }

    public synchronized FileManagerEntity j(String str, Bundle bundle) {
        FileManagerEntity u16;
        if (this.f208005b == null) {
            this.f208005b = new ArrayList();
        }
        FileAssistantSender fileAssistantSender = new FileAssistantSender(this.f208004a, this, str);
        u16 = fileAssistantSender.u(bundle);
        if (u16 != null) {
            k.a(u16, bundle);
            this.f208005b.add(fileAssistantSender);
            QLog.i("FileAssistantMgrNDL", 1, "add new sender :" + u16.nSessionId);
            fileAssistantSender.w(false);
        }
        return u16;
    }
}

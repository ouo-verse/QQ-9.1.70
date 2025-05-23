package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.filemanager.fileviewer.model.b {
    private k Z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7570a extends k {
        C7570a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(long j3, float f16) {
            FileBrowserModelBase.f fVar;
            FileManagerEntity entity = a.this.Q.getEntity();
            if (entity == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onProgress : opType[" + a.this.Q.a() + "], uniseq[" + entity.uniseq + "], nSessionId[" + entity.nSessionId + "], peerType[" + a.this.Q.b() + "]");
            }
            DataLineMsgRecord d16 = a.this.N.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(entity.uniseq)).d(entity.uniseq);
            if (d16 != null && j3 == d16.sessionid && (fVar = a.this.E) != null) {
                fVar.a(f16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(boolean z16, long j3, String str) {
            FileManagerEntity entity = a.this.Q.getEntity();
            if (QLog.isColorLevel()) {
                QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onRecvFile : isSuccess[" + z16 + "], uniseq[" + entity.uniseq + "], nSessionId[" + entity.nSessionId + "], peerType[" + a.this.Q.b() + "]");
            }
            DataLineMsgRecord d16 = a.this.N.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(entity.uniseq)).d(entity.uniseq);
            if (d16 == null) {
                return;
            }
            if (j3 != d16.sessionid) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("DatalineFileModel<FileAssistant>", 1, "this recv file done is not current visit file");
                    return;
                }
                return;
            }
            entity.setFilePath(str);
            FileBrowserModelBase.f fVar = a.this.E;
            if (fVar != null) {
                if (z16) {
                    entity.status = 1;
                    fVar.f();
                } else {
                    entity.status = 3;
                    fVar.e();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void l(boolean z16, long j3, String str) {
            FileManagerEntity entity = a.this.Q.getEntity();
            if (QLog.isColorLevel()) {
                QLog.d("DatalineFileModel<FileAssistant>", 2, "DataLine onSendFile : isSuccess[" + z16 + "], uniseq[" + entity.uniseq + "], nSessionId[" + entity.nSessionId + "], peerType[" + a.this.Q.b() + "]");
            }
            DataLineMsgRecord d16 = a.this.N.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(entity.uniseq)).d(entity.uniseq);
            if (d16 == null) {
                return;
            }
            if (j3 != d16.sessionid) {
                QLog.i("DatalineFileModel<FileAssistant>", 1, "this send file done is not current visit file");
                return;
            }
            FileBrowserModelBase.f fVar = a.this.E;
            if (fVar != null) {
                if (z16) {
                    entity.status = 1;
                    fVar.f();
                } else {
                    fVar.e();
                }
            }
        }
    }

    public a(QQAppInterface qQAppInterface, Activity activity, List<j> list, int i3) {
        super(qQAppInterface, activity);
        if (QLog.isColorLevel()) {
            QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
        }
        l1(list, i3);
    }

    private void r1() {
        FileManagerEntity entity = this.Q.getEntity();
        DataLineHandler dataLineHandler = (DataLineHandler) this.N.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(this.Q.getEntity().uniseq);
        DataLineMsgRecord d16 = this.N.getMessageFacade().t1(devTypeBySeId).d(entity.uniseq);
        if (d16 == null) {
            return;
        }
        if (d16.strMoloKey != null) {
            dataLineHandler.x4(111);
            if (d16.fileMsgStatus == 1) {
                if (DataLineMsgSet.isSingle(d16)) {
                    com.dataline.util.b.f(this.N);
                } else {
                    com.dataline.util.b.e(this.N);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(d16.sessionid));
        if (dataLineHandler.c4(arrayList)) {
            entity.status = 2;
            d16.fileMsgStatus = 0L;
            if (Float.compare(d16.progress, 1.0f) == 0) {
                d16.progress = 0.0f;
            }
            this.N.getMessageFacade().t1(devTypeBySeId).j(d16.msgId);
            return;
        }
        com.tencent.mobileqq.filemanager.util.d.e(R.string.c4x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        if (!NetworkUtil.isNetSupport(this.f208346d)) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
            return;
        }
        FileManagerEntity entity = this.Q.getEntity();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface == null) {
            QLog.e("DatalineFileModel<FileAssistant>", 1, "app is null");
            return;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(entity.uniseq);
        DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(devTypeBySeId).d(entity.uniseq);
        if (d16 != null && O() == 6000 && O() == 6003) {
            d16.bIsResendOrRecvFile = true;
            switch (V()) {
                case -1:
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    if (FileUtils.fileExists(N())) {
                        dataLineHandler.n4(N(), d16.thumbPath, 0, d16.sessionid, d16.groupId, d16.groupSize, d16.groupIndex, true);
                        return;
                    } else if (d16.nOpType == 35) {
                        dataLineHandler.X3(d16);
                        return;
                    } else {
                        dataLineHandler.y3().k(d16, devTypeBySeId, 2);
                        return;
                    }
                case 0:
                    dataLineHandler.n4(N(), d16.thumbPath, 1, d16.sessionid, d16.groupId, d16.groupSize, d16.groupIndex, true);
                    return;
                case 2:
                    dataLineHandler.n4(N(), d16.thumbPath, 2, d16.sessionid, d16.groupId, d16.groupSize, d16.groupIndex, true);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity.getCloudType() == 6 && entity.peerDin == 0) {
            DataLineHandler dataLineHandler = (DataLineHandler) this.N.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            DataLineMsgRecord d16 = this.N.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(entity.uniseq)).d(entity.uniseq);
            if (d16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
                    return;
                }
                return;
            }
            if (d16.strMoloKey != null && DataLineMsgSet.isSingle(d16)) {
                if (!d16.isReportPause) {
                    d16.isReportPause = true;
                    com.dataline.util.b.j(this.N);
                }
            } else if (!d16.isReportPause && d16.msgtype == -2335) {
                d16.isReportPause = true;
                com.dataline.util.b.i(this.N);
            }
            dataLineHandler.j3(d16.groupId, d16.sessionid, false);
        }
        entity.status = 3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        int V = V();
        int A = super.A();
        if (A != 0) {
            return A;
        }
        if (V != 0) {
            return 1;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    protected void B0() {
        if (this.Z != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
            }
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.Z);
            this.Z = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.a D() {
        if (this.C == null) {
            this.C = new c();
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int G() {
        if (FileManagerUtil.fileExist(N())) {
            return 3;
        }
        return super.G();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public com.tencent.mobileqq.colornote.f H() {
        FileManagerEntity entity = this.Q.getEntity();
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(entity.uniseq);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            return new bc1.b(qQAppInterface.getMessageFacade().t1(devTypeBySeId).d(entity.uniseq));
        }
        QLog.e("DatalineFileModel<FileAssistant>", 1, "app is null");
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String J() {
        j jVar;
        FileManagerEntity entity;
        String J = super.J();
        int T = T();
        if (T == 5 || ((T == 0 || T == 6) && (jVar = this.Q) != null && (entity = jVar.getEntity()) != null && !FileManagerUtil.isLocalFile(entity.getFilePath()) && FileManagerUtil.fileWhetherExpire(entity))) {
            return "";
        }
        return J;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int T() {
        j jVar;
        FileManagerEntity entity;
        int T = super.T();
        if ((T == 0 || T == 6) && (jVar = this.Q) != null && (entity = jVar.getEntity()) != null && !FileManagerUtil.isLocalFile(entity.getFilePath()) && FileManagerUtil.fileWhetherExpire(entity)) {
            return 5;
        }
        return T;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y = super.Y();
        if (!q.f(N())) {
            return null;
        }
        return Y;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean d() {
        if (M() == 35) {
            return false;
        }
        return super.d();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.d g0() {
        if (this.D == null) {
            this.D = new b();
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void l0() {
        if (this.Z != null) {
            return;
        }
        this.Z = new C7570a();
        if (QLog.isDevelopLevel()) {
            QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
        }
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.Z);
    }

    public void u1() {
        int M = M();
        int O = O();
        if (O != 6000 && O != 6003) {
            if (QLog.isColorLevel()) {
                QLog.i("DatalineFileModel<FileAssistant>", 2, "DatalineFileModel doStartDownload : error, this file is not from dataline");
            }
        } else if (M == 0) {
            if (U() == 2) {
                r1();
            } else {
                s1();
            }
        } else {
            r1();
        }
        FileBrowserModelBase.f fVar = this.E;
        if (fVar != null) {
            fVar.j();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String x() {
        return "biz_src_jc_file";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int y() {
        boolean z16;
        int V = V();
        if (V != 0 && V != 2 && V != 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null && entity.uniseq != 0) {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
            if (gVar != null && gVar.g2()) {
                return 2;
            }
            if (z16) {
                return 1;
            }
        }
        return 0;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements cc1.d {
        b() {
        }

        @Override // cc1.d
        public void e() {
            a aVar = a.this;
            aVar.Z0(true, kc1.a.c(aVar.Q.getEntity()), a.this.Q(), new C7571a());
        }

        @Override // cc1.d
        public void f() {
            a.this.t1();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7571a implements FMDialogUtil.c {
            C7571a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                a.this.s1();
                FileBrowserModelBase.f fVar = a.this.E;
                if (fVar != null) {
                    fVar.j();
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements cc1.a {
        c() {
        }

        @Override // cc1.a
        public void a() {
            a aVar = a.this;
            aVar.Z0(false, kc1.a.c(aVar.Q.getEntity()), a.this.Q(), new C7572a());
        }

        @Override // cc1.a
        public void b() {
            a.this.t1();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7572a implements FMDialogUtil.c {
            C7572a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                a.this.u1();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}

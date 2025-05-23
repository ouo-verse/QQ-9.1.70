package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.n;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFileReportApi;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.v;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class C2CFileModel extends com.tencent.mobileqq.filemanager.fileviewer.model.b {
    private FMObserver Z;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IFileReportApi iFileReportApi = (IFileReportApi) QRoute.api(IFileReportApi.class);
            C2CFileModel c2CFileModel = C2CFileModel.this;
            iFileReportApi.reportFile(c2CFileModel.N, c2CFileModel.Q.getEntity(), C2CFileModel.this.Q.getPeerUin(), null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public C2CFileModel(QQAppInterface qQAppInterface, Activity activity, List<j> list, int i3) {
        super(qQAppInterface, activity);
        if (QLog.isColorLevel()) {
            QLog.i("C2CFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
        }
        l1(list, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        int G = G();
        if (G == 0) {
            return 9;
        }
        String Z = Z();
        if (!FileManagerUtil.fileExist(N()) && com.tencent.mobileqq.filemanager.fileassistant.util.h.k(Z)) {
            return 1;
        }
        int A = super.A();
        if (A != 0) {
            return A;
        }
        int V = V();
        if (V != 0) {
            if (V == 1) {
                return 1;
            }
            int i3 = 2;
            if (V != 2) {
                i3 = 5;
                if (V != 4) {
                    if (V != 5) {
                        return 7;
                    }
                    return 11;
                }
                if (!FileManagerUtil.canPreviewZip(this.N, this.Q, false) || !FileManagerUtil.canPreview(this.f208346d, L(), Q())) {
                    return 7;
                }
            } else if (G == 2 || u0()) {
                return 1;
            }
            return i3;
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    protected void B0() {
        if (this.Z != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
            }
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.Z);
            this.Z = null;
        }
        this.Q.getEntity();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.a D() {
        if (this.C == null) {
            this.C = new a();
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String E() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.mExcitingSpeed;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public com.tencent.mobileqq.colornote.f H() {
        Bundle bundle;
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            try {
                entity = FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(N()));
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
            }
        }
        if (entity == null) {
            return new bc1.c();
        }
        if (this.H == 14 && (bundle = this.I) != null && bundle.containsKey("file_color_note_subType")) {
            int i3 = this.I.getInt("file_color_note_subType", -1);
            String N = N();
            if (i3 == 4 && FileUtils.fileExistsAndNotEmpty(N)) {
                return new bc1.d(entity.getFilePath());
            }
        }
        String N2 = N();
        if (TextUtils.isEmpty(entity.Uuid) && FileUtils.fileExistsAndNotEmpty(N2)) {
            return new bc1.e(entity.getFilePath());
        }
        if (!TextUtils.isEmpty(entity.Uuid)) {
            return new bc1.f(this.Q.getEntity());
        }
        if (!TextUtils.isEmpty(entity.WeiYunFileId)) {
            return new bc1.a(entity);
        }
        return new bc1.c();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String K() {
        FileManagerEntity entity;
        if (V() == 5 && (entity = this.Q.getEntity()) != null) {
            return entity.yybApkIconUrl;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int T() {
        int T = super.T();
        if (M() == 10) {
            return 6;
        }
        return T;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int U() {
        if (M() == 51) {
            return 1;
        }
        return super.U();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public void U0(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        Bundle bundle;
        int D;
        if (fileManagerEntity.cloudType == 15 || (bundle = this.I) == null || bundle.getBoolean("file_location_pos_entrance_multiseq", false) || (D = QFileUtils.D(this.H, 0)) == 0) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("file_location_pos_entrance_type", D);
        arrayList.add(QFileUtils.c(54, com.tencent.mobileqq.filemanager.fileviewer.c.g(this.f208346d, bundle2, fileManagerEntity)));
        ReportController.o(null, "dc00898", "", "", "0X800B450", "0X800B450", D, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        int G = G();
        if (G != 0 && G != 11 && G != 13) {
            return super.Y();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    protected boolean Y0() {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean d() {
        M();
        if (G() == 0 || G() == 13 || G() == 17) {
            return false;
        }
        return super.d();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    protected ShareActionSheetBuilder.ActionSheetItem d1() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null && this.Q.getEntity().nOpType == 58) {
            return QFileUtils.c(11, new c());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.d g0() {
        if (this.D == null) {
            this.D = new b();
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean h() {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public com.tencent.mobileqq.filemanager.fileviewer.data.b j0() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return null;
        }
        int i3 = entity.peerType;
        if (i3 == 0) {
            return new VideoForC2C(this.N, entity);
        }
        if (i3 == 3000) {
            return new com.tencent.mobileqq.filemanager.fileviewer.data.g(this.N, entity);
        }
        QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + entity.peerType);
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public void j1() {
        super.j1();
        FileManagerEntity entity = this.Q.getEntity();
        if (G() == 1) {
            if (O() == 3000) {
                this.N.getFileManagerDataCenter().Q(new com.tencent.mobileqq.filemanageraux.core.a(this.N, entity.Uuid, entity.peerUin));
            } else {
                this.N.getFileManagerDataCenter().Q(new n(this.N, entity.Uuid, entity.fileIdCrc));
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void k0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        FileManagerEntity entity;
        boolean z16;
        int i3;
        if (actionSheetItem == null || (entity = this.Q.getEntity()) == null) {
            return;
        }
        int i16 = actionSheetItem.action;
        if (i16 == 52) {
            int cloudType = entity.getCloudType();
            z16 = true;
            if (cloudType == 2) {
                i3 = -1006;
            } else if (cloudType == 1) {
                i3 = -1001;
            } else {
                i3 = -1004;
            }
            int i17 = i3;
            String str = entity.strFileMd5;
            if (TextUtils.isEmpty(str)) {
                str = entity.str10Md5;
            }
            String str2 = str;
            String N = N();
            if (!FileUtils.fileExistsAndNotEmpty(N)) {
                N = entity.strLargeThumPath;
            }
            String str3 = N;
            if (FileUtils.fileExistsAndNotEmpty(str3)) {
                ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(this.f208346d, str3, 1, i17, str2, false);
            }
        } else {
            super.k0(actionSheetItem);
            z16 = false;
        }
        if (z16) {
            D0(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void l0() {
        if (this.Z != null) {
            return;
        }
        this.Z = new C2CFileObserver();
        if (QLog.isDevelopLevel()) {
            QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
        }
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.Z);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void m() {
        super.m();
        if (FileManagerUtil.isZipFile(this.N, this.Q, true) && FileManagerUtil.canPreviewZip(this.N, this.Q, true)) {
            this.N.getFileManagerDataCenter().g();
        }
    }

    public void p1() {
        int T = T();
        int G = G();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (T == 6) {
            if (G == 0) {
                qQAppInterface.getOnlineFileSessionCenter().x(P());
            } else if (G == 17) {
                v d16 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
                if (d16 != null) {
                    d16.a(this.Q.getEntity());
                }
            } else {
                qQAppInterface.getFileManagerEngine().o0(P());
            }
        } else if (G == 0) {
            qQAppInterface.getOnlineFileSessionCenter().v(P());
        } else if (G == 17) {
            v d17 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
            if (d17 != null) {
                d17.a(this.Q.getEntity());
            }
        } else {
            qQAppInterface.getFileManagerEngine().t0(this.Q.getEntity());
        }
        FileBrowserModelBase.f fVar = this.E;
        if (fVar != null) {
            fVar.j();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String r() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.yybApkPackageName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void v0() {
        if (FileManagerUtil.isZipFile(this.N, this.Q, true) && FileManagerUtil.canPreviewZip(this.N, this.Q, true)) {
            long P = P();
            if (G() == 2) {
                P = FileManagerUtil.getWeiyunZipTargetId(Q());
            }
            this.N.getFileManagerDataCenter().e(P, this.Q.getEntity().WeiYunFileId);
        }
        super.v0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String w() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.yybApkName;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String x() {
        return "biz_src_jc_file";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int y() {
        boolean z16;
        int R;
        int V = V();
        if (V != 0 && V != 2 && V != 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        String N = N();
        boolean f16 = q.f(N);
        FileManagerEntity entity = this.Q.getEntity();
        if (f16 && entity == null) {
            try {
                entity = FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(N));
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
            }
        }
        if (entity == null || entity.status == 16) {
            return 0;
        }
        if (M() == 0 && ((R = R()) == 0 || R == 3 || R == 2)) {
            return 0;
        }
        if (TextUtils.isEmpty(entity.Uuid) && TextUtils.isEmpty(entity.WeiYunFileId) && !FileUtils.fileExistsAndNotEmpty(N)) {
            return 0;
        }
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
        if (gVar == null || !gVar.g2()) {
            return 1;
        }
        return 2;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements cc1.a {
        a() {
        }

        @Override // cc1.a
        public void a() {
            C2CFileModel c2CFileModel = C2CFileModel.this;
            c2CFileModel.Z0(false, kc1.a.c(c2CFileModel.Q.getEntity()), C2CFileModel.this.Q(), new C7567a());
        }

        @Override // cc1.a
        public void b() {
            C2CFileModel.this.k1();
            int G = C2CFileModel.this.G();
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
            if (G == 0) {
                qQAppInterface.getOnlineFileSessionCenter().u(C2CFileModel.this.P());
                return;
            }
            if (G == 17) {
                v d16 = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFlashTransferFileBrowser().d();
                if (d16 != null) {
                    d16.b(C2CFileModel.this.Q.getEntity());
                    return;
                }
                return;
            }
            qQAppInterface.getFileManagerEngine().i0(C2CFileModel.this.Q.getSessionId());
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7567a implements FMDialogUtil.c {
            C7567a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                C2CFileModel.this.p1();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements cc1.d {
        b() {
        }

        @Override // cc1.d
        public void e() {
            C2CFileModel c2CFileModel = C2CFileModel.this;
            c2CFileModel.Z0(true, kc1.a.c(c2CFileModel.Q.getEntity()), C2CFileModel.this.Q(), new a());
        }

        @Override // cc1.d
        public void f() {
            C2CFileModel.this.k1();
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerEngine().i0(C2CFileModel.this.P());
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerEngine().o0(C2CFileModel.this.P());
                FileBrowserModelBase.f fVar = C2CFileModel.this.E;
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
    private class C2CFileObserver extends FMObserver {
        C2CFileObserver() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void B0(com.tencent.mobileqq.filemanager.data.n nVar) {
            if (!TextUtils.isEmpty(nVar.f207830a) && !TextUtils.isEmpty(nVar.f207833d)) {
                FileBrowserModelBase.e eVar = C2CFileModel.this.G;
                if (eVar != null) {
                    eVar.k(nVar.f207830a, nVar.f207833d);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + nVar.f207830a + " [path] = " + nVar.f207833d);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + z16 + "], uniseq[" + j3 + "], nSessionId[" + j16 + str + "], peerType[" + i3 + "]");
            }
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(C2CFileModel.this.f208346d, i16);
            if (j16 != C2CFileModel.this.Q.getSessionId()) {
                return;
            }
            C2CFileModel c2CFileModel = C2CFileModel.this;
            if (c2CFileModel.E == null) {
                return;
            }
            if (!z16) {
                FileManagerUtil.dealWithTransFileFaild(j16, i16, str2);
                C2CFileModel.this.E.e();
            } else if (c2CFileModel.V() == 2) {
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileBrowserModelBase.f fVar = C2CFileModel.this.E;
                        if (fVar != null) {
                            fVar.f();
                        }
                    }
                }, 1000L);
            } else {
                C2CFileModel.this.E.f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean z16, long j3, long j16, String str, int i3) {
            FileManagerEntity entity;
            FileBrowserModelBase.f fVar;
            if (j16 != C2CFileModel.this.Q.getSessionId() || (entity = C2CFileModel.this.Q.getEntity()) == null) {
                return;
            }
            if ((entity.getCloudType() != 0 || entity.nOpType != 10) && (fVar = C2CFileModel.this.E) != null) {
                fVar.a(entity.fProgress);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void T0(Integer num, long j3, String str) {
            FileManagerUtil.dealWithTransFileFaild(j3, num.intValue(), str);
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void U(long j3, long j16, String str, int i3) {
            FileBrowserModelBase.f fVar;
            if (j16 == C2CFileModel.this.Q.getSessionId() && (fVar = C2CFileModel.this.E) != null) {
                fVar.j();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void W(Object[] objArr) {
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            int intValue = ((Integer) objArr2[1]).intValue();
            ((Long) objArr2[2]).longValue();
            if (longValue != C2CFileModel.this.Q.getSessionId()) {
                return;
            }
            float f16 = intValue / 100.0f;
            C2CFileModel.this.Q.getEntity().fProgress = f16;
            FileBrowserModelBase.f fVar = C2CFileModel.this.E;
            if (fVar != null) {
                fVar.a(f16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void X(Object[] objArr) {
            Object[] objArr2 = (Object[]) objArr[2];
            long longValue = ((Long) objArr2[0]).longValue();
            boolean booleanValue = ((Boolean) objArr2[1]).booleanValue();
            String str = (String) objArr2[2];
            QLog.i("C2CFileModel<FileAssistant>", 1, "onFlashTransferDownloadResult: sessionId: " + longValue + ", isSuccess: " + booleanValue + ", targetPath: " + str);
            if (longValue != C2CFileModel.this.Q.getSessionId()) {
                return;
            }
            C2CFileModel.this.Q.getEntity().setFilePath(str);
            C2CFileModel c2CFileModel = C2CFileModel.this;
            if (c2CFileModel.E == null) {
                return;
            }
            if (!booleanValue) {
                c2CFileModel.Q.getEntity().status = 0;
                C2CFileModel.this.E.e();
                return;
            }
            c2CFileModel.Q.getEntity().status = 1;
            if (C2CFileModel.this.V() == 2) {
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FileBrowserModelBase.f fVar = C2CFileModel.this.E;
                        if (fVar != null) {
                            fVar.f();
                        }
                    }
                }, 1000L);
            } else {
                C2CFileModel.this.E.f();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void Y(boolean z16, int i3, String str, long j3, long j16, String str2, long j17) {
            if (!z16) {
                FileManagerUtil.dealWithTransFileFaild(j17, i3, str);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void Y0(boolean z16, int i3, long j3, String str, String str2) {
            FileBrowserModelBase.e eVar;
            if (!z16) {
                return;
            }
            int V = C2CFileModel.this.V();
            if (V == 4) {
                FileBrowserModelBase.e eVar2 = C2CFileModel.this.G;
                if (eVar2 != null) {
                    eVar2.k(String.valueOf(j3), str2);
                    return;
                }
                return;
            }
            if (V == 0) {
                if (C2CFileModel.this.P() == j3 && (eVar = C2CFileModel.this.G) != null) {
                    eVar.k(String.valueOf(j3), str2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + j3 + "]  thumbPath[" + str2 + "] but current file browser can not handle");
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void d0(long j3, int i3, int i16, String str, String str2, Bundle bundle) {
            FileBrowserModelBase.c cVar;
            if (j3 == C2CFileModel.this.Q.getEntity().nSessionId && (cVar = C2CFileModel.this.M) != null && i3 == 0) {
                cVar.h(i16, str, str2, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void j0(int i3, long j3, String str) {
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(C2CFileModel.this.f208346d, i3);
            if (j3 != C2CFileModel.this.Q.getEntity().nSessionId) {
                return;
            }
            FileManagerUtil.dealWithTransFileFaild(j3, i3, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void k0(long j3, String str, int i3, String str2) {
            if (j3 == C2CFileModel.this.Q.getEntity().nSessionId && str2 != null && str2.length() > 0 && i3 != 0) {
                FileManagerUtil.dealWithErrCode(str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void o0(long j3, long j16) {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar;
            super.o0(j3, j16);
            if (j3 == C2CFileModel.this.Q.getSessionId() && (gVar = C2CFileModel.this.f208348f) != null) {
                gVar.h2();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void u0(int i3, String str) {
            FileManagerUtil.dealWithErrCode(str);
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void U0() {
        }
    }
}

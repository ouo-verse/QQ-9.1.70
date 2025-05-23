package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cc1.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.core.n;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.c;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.b;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.v;
import com.tencent.mobileqq.teamwork.w;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.QbSdk;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DocsExportFileModel extends b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private v Z;

    /* renamed from: a0, reason: collision with root package name */
    private MqqHandler f209609a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f209610b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f209611c0;

    /* renamed from: d0, reason: collision with root package name */
    private FileManagerEntity f209612d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f209613e0;

    /* renamed from: f0, reason: collision with root package name */
    public long f209614f0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements cc1.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocsExportFileModel.this);
            }
        }

        @Override // cc1.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                DocsExportFileModel.this.F1();
            }
        }

        @Override // cc1.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public DocsExportFileModel(QQAppInterface qQAppInterface, Activity activity, List<j> list, int i3) {
        super(qQAppInterface, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, activity, list, Integer.valueOf(i3));
            return;
        }
        this.f209610b0 = 1000;
        this.f209611c0 = 60000;
        this.f209613e0 = 0L;
        this.f209614f0 = 0L;
        l1(list, i3);
        this.f209612d0 = this.Q.getEntity();
        this.f209609a0 = new MqqHandler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(String str, String str2) {
        FileManagerEntity fileManagerEntity;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (qQAppInterface != null && str2 != null && (fileManagerEntity = this.f209612d0) != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 2, "", "", w.b(fileManagerEntity.nFileType), str2);
        }
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.lp6);
        }
        QQToast.makeText(this.f208346d, 1, str, 0).show();
        m();
        this.f208346d.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(String str, String str2, String str3, String str4) {
        this.f209614f0 = System.currentTimeMillis();
        this.f209609a0.removeMessages(8001);
        this.f209609a0.removeMessages(8002);
        this.f209609a0.post(new Runnable() { // from class: com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocsExportFileModel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (((FileBrowserModelBase) DocsExportFileModel.this).E != null) {
                    ((FileBrowserModelBase) DocsExportFileModel.this).E.a(50.0f);
                }
            }
        });
        ((ITeamWorkFileExportHandler) this.N.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER)).fileExportDownloadRequest(str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 10;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    protected void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        v vVar = this.Z;
        if (vVar != null && qQAppInterface != null) {
            qQAppInterface.removeObserver(vVar);
        }
        MqqHandler mqqHandler = this.f209609a0;
        if (mqqHandler != null) {
            mqqHandler.removeMessages(8001);
            this.f209609a0.removeMessages(8002);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.a D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (cc1.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.C == null) {
            this.C = new a();
        }
        return this.C;
    }

    public void F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f209613e0 = System.currentTimeMillis();
        this.f209609a0.sendEmptyMessageDelayed(8001, this.f209610b0);
        this.f209609a0.sendEmptyMessageDelayed(8002, this.f209611c0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void O0(FileBrowserModelBase.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
            return;
        }
        super.O0(fVar);
        Bundle bundle = this.I;
        if (bundle != null && bundle.containsKey("isSuccess")) {
            boolean z16 = this.I.getBoolean("isSuccess");
            String string = this.I.getString("docUrl");
            if (z16) {
                E1(this.I.getString("url"), this.I.getString(WadlProxyConsts.PARAM_FILENAME), string, this.I.getString("cookie"));
            } else {
                D1(HardCodeUtil.qqStr(R.string.u0t), string);
            }
            this.I.remove("isSuccess");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int T = super.T();
        if (M() == 10) {
            return 6;
        }
        return T;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public Intent X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Intent) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        ShareActionSheetBuilder.ActionSheetItem c16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        boolean f16 = q.f(N);
        if ((entity == null && TextUtils.isEmpty(N)) || R() == 16) {
            return null;
        }
        if (!f16 && entity != null && entity.isZipInnerFile) {
            return null;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        if (f16) {
            if (entity == null) {
                try {
                    entity = FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(N));
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
            c16 = QFileUtils.c(2, null);
        } else {
            c16 = QFileUtils.c(2, null);
        }
        arrayList.add(c16);
        if (entity != null && !TextUtils.isEmpty(entity.WeiYunFileId) && !TextUtils.isEmpty(entity.WeiYunDirKey)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (f16) {
                c16 = QFileUtils.c(27, null);
            } else if (G() == 1) {
                c16 = QFileUtils.c(27, null);
            }
            arrayList.add(c16);
        }
        WXShareHelper b06 = WXShareHelper.b0();
        if (f16 && b06.e0() && b06.d0()) {
            arrayList.add(QFileUtils.c(9, c.o(this.f208346d, N)));
        }
        if (f16) {
            arrayList.add(QFileUtils.c(64, c.t(this.f208346d, N)));
        }
        if (FileManagerUtil.isSupportFavorite(entity)) {
            arrayList2.add(QFileUtils.c(6, null));
        }
        boolean o16 = TencentDocConvertConfigProcessor.a().o();
        long docsImportFileMaxSize = FileManagerUtil.getDocsImportFileMaxSize(this.f209612d0.fileName);
        String e17 = TencentDocImportFileInfoProcessor.c().e();
        if (TextUtils.isEmpty(e17)) {
            e17 = ITeamWorkUtils.FILE_WORD_XLS;
        }
        if (o16 && entity != null && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsSupport(entity.getFilePath(), entity.fileName, e17) && entity.fileSize <= docsImportFileMaxSize) {
            ShareActionSheetBuilder.ActionSheetItem c17 = QFileUtils.c(119, c.e(entity, this.f208346d));
            ReportController.o(this.N, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
            arrayList2.add(c17);
        }
        if (com.tencent.mobileqq.filemanageraux.link.b.h(entity, f16)) {
            arrayList2.add(QFileUtils.c(122, c.p(this.f208346d, entity, N)));
            arrayList2.add(QFileUtils.c(123, c.q(this.f208346d, entity, N)));
        }
        if (((IPrintApi) QRoute.api(IPrintApi.class)).isSupportOnlinePrint(L(), false) && !ae.h(entity)) {
            arrayList2.add(QFileUtils.c(121, ((IPrintApi) QRoute.api(IPrintApi.class)).getLocalFilePrintClick(this.f208348f.getActivity(), entity, false)));
        }
        if (f16 && QbSdk.isInDefaultBrowser(this.f208346d, N)) {
            arrayList2.add(QFileUtils.c(132, null));
            ReportController.o(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public d g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 8001) {
            if (i3 == 8002) {
                D1(HardCodeUtil.qqStr(R.string.lp9), "");
                return true;
            }
            return true;
        }
        FileManagerEntity fileManagerEntity = this.f209612d0;
        if (fileManagerEntity != null) {
            float f16 = fileManagerEntity.fProgress;
            if (f16 <= 45.0f) {
                FileBrowserModelBase.f fVar = this.E;
                if (fVar != null) {
                    float f17 = f16 + 5.0f;
                    fileManagerEntity.fProgress = f17;
                    fVar.a(f17);
                }
                this.f209609a0.sendEmptyMessageDelayed(8001, this.f209610b0);
                return true;
            }
        }
        this.f209609a0.removeMessages(8001);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b
    public void j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) actionSheetItem);
            return;
        }
        if (actionSheetItem == null) {
            return;
        }
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        boolean f16 = q.f(N);
        if ((entity == null && TextUtils.isEmpty(N)) || R() == 16) {
            return;
        }
        if (!f16 && entity != null && entity.isZipInnerFile) {
            return;
        }
        int i3 = actionSheetItem.action;
        if (i3 == 2) {
            c.d(this.f208348f, entity, this.f208346d).onClick(null);
            ReportController.o(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
            return;
        }
        if (i3 == 27) {
            if (entity != null) {
                c.h(entity.nSessionId, this.f208348f, N).onClick(null);
            }
            ReportController.o(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        } else if (i3 == 6) {
            c.c(this.f208348f, entity).onClick(null);
            ReportController.o(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
        } else if (i3 == 132) {
            QbSdk.clearDefaultBrowser(this.f208346d, N());
            FileManagerUtil.openWithOtherApp(this.f208346d, N());
            ReportController.o(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void l0() {
        v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.Z != null) {
            return;
        }
        this.Z = new v() { // from class: com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocsExportFileModel.this);
                }
            }

            @Override // com.tencent.mobileqq.teamwork.v
            public void a(boolean z16, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                DocsExportFileModel docsExportFileModel = DocsExportFileModel.this;
                long j3 = docsExportFileModel.f209614f0;
                long j16 = currentTimeMillis - j3;
                long j17 = j3 - docsExportFileModel.f209613e0;
                if (!z16) {
                    DocsExportFileModel.this.D1(HardCodeUtil.qqStr(R.string.lp8), str2);
                    return;
                }
                if (((FileBrowserModelBase) docsExportFileModel).I != null && ((FileBrowserModelBase) DocsExportFileModel.this).I.getBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, false)) {
                    lr2.a.j(((b) DocsExportFileModel.this).N, "0X800A4B3");
                }
                if (DocsExportFileModel.this.f209612d0 != null) {
                    DocsExportFileModel.this.f209612d0.setFilePath(str);
                    DocsExportFileModel.this.f209612d0.fileSize = FileManagerUtil.getFileSizes(str);
                    String b16 = w.b(DocsExportFileModel.this.f209612d0.nFileType);
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                    if (qQAppInterface != null && str2 != null) {
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, j17 + "", j16 + "", b16, str2);
                    }
                }
                if (((FileBrowserModelBase) DocsExportFileModel.this).E != null) {
                    DocsExportFileModel.this.f209609a0.removeMessages(8001);
                    DocsExportFileModel.this.f209609a0.removeMessages(8002);
                    DocsExportFileModel.this.f209609a0.post(new Runnable() { // from class: com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ((FileBrowserModelBase) DocsExportFileModel.this).E.a(100.0f);
                                ((FileBrowserModelBase) DocsExportFileModel.this).E.f();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.teamwork.v
            public void b(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, i3);
                } else if (((FileBrowserModelBase) DocsExportFileModel.this).E != null && i3 <= 100) {
                    DocsExportFileModel.this.f209609a0.post(new Runnable(i3) { // from class: com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f209617d;

                        {
                            this.f209617d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ((FileBrowserModelBase) DocsExportFileModel.this).E.a((this.f209617d / 2) + 50);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.teamwork.v
            public void c(String str, String str2, String str3, String str4) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    DocsExportFileModel.this.E1(str, str2, str3, str4);
                } else {
                    iPatchRedirector2.redirect((short) 3, this, str, str2, str3, str4);
                }
            }

            @Override // com.tencent.mobileqq.teamwork.v
            public void d(String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DocsExportFileModel.this.D1(str, str2);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                }
            }
        };
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        if (qQAppInterface != null && (vVar = this.Z) != null) {
            qQAppInterface.addObserver(vVar);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.b, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.m();
        }
    }
}

package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.troop.file.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFileDataReporter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.n;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.b;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.au;
import com.tencent.mobileqq.filemanager.util.bb;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.URLUtil;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ta1.k;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class b extends FileBrowserModelBase {
    protected QQAppInterface N;
    protected List<j> P;
    protected j Q;
    protected String R;
    protected String S;
    protected String T;
    protected String U;
    protected String V;
    private TeamWorkFileImportInfo W;
    private String X;
    private QQPermission Y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements com.tencent.mobileqq.filemanager.core.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f208399a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7573a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f208401a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f208402b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ short f208403c;

            C7573a(boolean z16, String str, short s16) {
                this.f208401a = z16;
                this.f208402b = str;
                this.f208403c = s16;
            }

            @Override // com.tencent.biz.troop.file.a.b
            public void a(List<ZipFilePresenter.f> list) {
                QLog.d("FileBrowserModelBase", 1, "loadZipFilesForOthers onGetZipFileList");
                if (b.this.f208351m != null) {
                    if (list != null && !list.isEmpty()) {
                        b bVar = b.this;
                        bVar.f208351m.g(list, bVar.R, bVar.S, bVar.T, bVar.U, this.f208401a, this.f208402b, this.f208403c);
                    } else {
                        b.this.f208351m.c(-1000L);
                    }
                }
                if (list != null) {
                    ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportZipPreviewListResult(!list.isEmpty());
                    ReportController.o(b.this.N, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, "" + b.this.Q.getEntity().TroopUin, "", FileManagerUtil.getFileSuffix(b.this.L()), "1");
                    return;
                }
                ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportZipPreviewListResult(false);
                ReportController.o(b.this.N, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, "" + b.this.Q.getEntity().TroopUin, "-1", FileManagerUtil.getFileSuffix(b.this.L()), "1");
            }
        }

        a(int i3) {
            this.f208399a = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.core.b
        public void a(boolean z16, String str, String str2, long j3, String str3, String str4, String str5, String str6, Bundle bundle) {
            String str7;
            boolean z17;
            boolean isEnableHttpsDownload4C2C_ZipInner;
            boolean z18 = true;
            QLog.d("FileBrowserModelBase", 1, "loadZipFilesForOthers onCSReplay");
            short s16 = 0;
            if (!z16) {
                ((IFileDataReporter) QRoute.api(IFileDataReporter.class)).reportZipPreviewListResult(false);
                QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + j3 + "], retMeg[" + str3 + "]");
                FileBrowserModelBase.g gVar = b.this.f208351m;
                if (gVar != null) {
                    gVar.c(j3);
                }
                com.tencent.mobileqq.filemanager.fileviewer.g gVar2 = b.this.f208348f;
                if (gVar2 != null) {
                    gVar2.K1();
                }
                b.this.N.getFileManagerDataCenter().f0(b.this.Q.getEntity());
                return;
            }
            b bVar = b.this;
            bVar.R = str;
            bVar.S = str2;
            bVar.T = str4;
            bVar.U = str5;
            String str8 = null;
            if (bundle == null) {
                str7 = "";
                z17 = false;
            } else {
                if (this.f208399a == 3000) {
                    isEnableHttpsDownload4C2C_ZipInner = ((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc_ZipInner(b.this.N);
                } else {
                    isEnableHttpsDownload4C2C_ZipInner = ((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C_ZipInner(b.this.N);
                }
                String string = bundle.getString("httpsdomain");
                if (!TextUtils.isEmpty(string) && isEnableHttpsDownload4C2C_ZipInner) {
                    s16 = bundle.getShort("httpsport");
                    str8 = string;
                } else {
                    z18 = false;
                }
                str7 = bundle.getString("ipv6domain", "");
                z17 = z18;
            }
            b bVar2 = b.this;
            String str9 = bVar2.R;
            String str10 = bVar2.S;
            String str11 = bVar2.T;
            int chechZipFileType = FileManagerUtil.chechZipFileType(bVar2.Q.getEntity());
            b bVar3 = b.this;
            bVar2.f1(str9, str10, str11, chechZipFileType, "/", bVar3.U, bVar3.Q.getEntity(), z17, str8, s16, str7, new C7573a(z17, str8, s16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7574b implements e.a {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ short E;
        final /* synthetic */ String F;
        final /* synthetic */ int G;
        final /* synthetic */ String H;
        final /* synthetic */ a.b I;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f208405d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f208406e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208407f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f208408h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f208409i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f208410m;

        C7574b(List list, String str, FileManagerEntity fileManagerEntity, boolean z16, String str2, boolean z17, String str3, String str4, short s16, String str5, int i3, String str6, a.b bVar) {
            this.f208405d = list;
            this.f208406e = str;
            this.f208407f = fileManagerEntity;
            this.f208408h = z16;
            this.f208409i = str2;
            this.f208410m = z17;
            this.C = str3;
            this.D = str4;
            this.E = s16;
            this.F = str5;
            this.G = i3;
            this.H = str6;
            this.I = bVar;
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            StringBuilder sb5;
            QLog.d("FileBrowserModelBase", 1, "getZipFilesForOthers onResult");
            this.f208405d.clear();
            if (jSONObject != null) {
                try {
                    if (!jSONObject.isNull("dirs")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("dirs");
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            ZipFilePresenter.f fVar = new ZipFilePresenter.f();
                            fVar.f208516a = true;
                            fVar.f208518c = jSONArray.getString(i16);
                            this.f208405d.add(fVar);
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            if (jSONObject != null && !jSONObject.isNull("files")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("files");
                for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                    ZipFilePresenter.f fVar2 = new ZipFilePresenter.f();
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                    fVar2.f208518c = jSONObject2.getString("filename");
                    fVar2.f208517b = jSONObject2.getLong("size");
                    if (this.f208406e.equals("/")) {
                        sb5 = new StringBuilder();
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(this.f208406e);
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    }
                    String sb6 = sb5.toString();
                    FileManagerEntity fileManagerEntity = new FileManagerEntity();
                    fileManagerEntity.fileName = fVar2.f208518c;
                    fileManagerEntity.fileSize = fVar2.f208517b;
                    FileManagerEntity fileManagerEntity2 = this.f208407f;
                    fileManagerEntity.nRelatedSessionId = fileManagerEntity2.nSessionId;
                    fileManagerEntity.mContext = fileManagerEntity2.Uuid;
                    fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
                    if (this.f208408h) {
                        fileManagerEntity.WeiYunFileId = this.f208409i;
                        FileManagerEntity fileManagerEntity3 = this.f208407f;
                        fileManagerEntity.mContext = fileManagerEntity3.WeiYunFileId;
                        fileManagerEntity.nRelatedSessionId = FileManagerUtil.getWeiyunZipTargetId(fileManagerEntity3.fileSize);
                    }
                    fileManagerEntity.zipFileId = this.f208407f.WeiYunFileId;
                    if (fileManagerEntity.mContext == null) {
                        QLog.i("FileBrowserModelBase", 1, "zip list file content is empty. zipSessionId[" + this.f208407f.nSessionId + "] zipIsWeiyunFile[" + this.f208408h + "] zipCouldType[" + this.f208407f.cloudType + "] fileSessionId[" + fileManagerEntity.nSessionId + "]");
                    }
                    if (!this.f208408h && this.f208410m && !TextUtils.isEmpty(this.C)) {
                        fileManagerEntity.strServerPath = "https://" + this.D + ":" + ((int) this.E) + "/ftn_compress_getfile/rkey=" + this.F + "&filetype=" + this.G + "&path=" + URLUtil.encodeUrl(sb6) + ContainerUtils.FIELD_DELIMITER;
                        fileManagerEntity.httpsDomain = this.C;
                    } else {
                        fileManagerEntity.strServerPath = "http://" + this.D + ":" + this.H + "/ftn_compress_getfile/rkey=" + this.F + "&filetype=" + this.G + "&path=" + URLUtil.encodeUrl(sb6) + ContainerUtils.FIELD_DELIMITER;
                    }
                    fileManagerEntity.zipInnerPath = sb6;
                    FileManagerEntity fileManagerEntity4 = this.f208407f;
                    fileManagerEntity.selfUin = fileManagerEntity4.selfUin;
                    fileManagerEntity.peerUin = fileManagerEntity4.peerUin;
                    fileManagerEntity.peerType = fileManagerEntity4.peerType;
                    fileManagerEntity.busId = fileManagerEntity4.busId;
                    fileManagerEntity.cloudType = 1;
                    fileManagerEntity.isZipInnerFile = true;
                    fileManagerEntity.zipFilePath = fileManagerEntity4.strTroopFilePath;
                    fileManagerEntity.zipType = this.G;
                    fileManagerEntity.TroopUin = fileManagerEntity4.TroopUin;
                    fVar2.f208519d = fileManagerEntity.nSessionId;
                    b.this.N.getFileManagerProxy().x(fileManagerEntity);
                    this.f208405d.add(fVar2);
                }
            }
            a.b bVar = this.I;
            if (bVar != null) {
                bVar.a(this.f208405d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements cc1.c {
        c() {
        }

        @Override // cc1.c
        public void a(FileBrowserModelBase.b bVar) {
            String str;
            FileBrowserModelBase.e eVar;
            FileBrowserModelBase.e eVar2;
            FileBrowserModelBase.e eVar3;
            j g16 = ((com.tencent.mobileqq.filemanager.fileviewer.data.c) bVar).g();
            if (g16 != null) {
                if (1 == g16.v()) {
                    if (g16.getEntity().isZipInnerFile) {
                        String q16 = b.this.N.getFileManagerEngine().q(g16.getEntity());
                        if (q16 != null && (eVar3 = b.this.G) != null) {
                            eVar3.k(String.valueOf(g16.getSessionId()), q16);
                            return;
                        }
                        return;
                    }
                    String m3 = b.this.N.getFileManagerEngine().m(g16.getEntity(), 7);
                    if (m3 != null && (eVar2 = b.this.G) != null) {
                        eVar2.k(g16.getUuid(), m3);
                        return;
                    }
                    return;
                }
                if (2 == g16.v()) {
                    FileManagerEngine fileManagerEngine = b.this.N.getFileManagerEngine();
                    String fileId = g16.getFileId();
                    if (g16.s() == null) {
                        str = null;
                    } else {
                        str = g16.s().E;
                    }
                    String Z = fileManagerEngine.Z(fileId, str, 7, g16);
                    if (Z != null && (eVar = b.this.G) != null) {
                        eVar.k(g16.getFileId(), Z);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements u.d {
        d() {
        }

        @Override // com.tencent.mobileqq.teamwork.u.d
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            b.this.W = teamWorkFileImportInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = b.this;
            FileManagerUtil.openWithOtherApp(bVar.f208346d, bVar.N());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f extends QQPermission.BasePermissionsListener {
        f() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            b bVar = b.this;
            FileManagerUtil.saveToAlbum(bVar.f208346d, bVar.N());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f208417d;

        h(int i3) {
            this.f208417d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = b.this;
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = bVar.f208348f;
            if (gVar != null) {
                int i3 = this.f208417d;
                if (i3 == 1) {
                    ReportController.o(null, "dc00898", "", "", "0X800A745", "0X800A745", QFileUtils.H(bVar.V()), 0, "", "", "", "");
                    if (b.this.f208348f.s()) {
                        b.this.f208348f.P0();
                    }
                } else if (i3 == 2) {
                    gVar.t2();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(QQAppInterface qQAppInterface, Activity activity) {
        super(activity);
        this.X = "";
        this.N = qQAppInterface;
        this.Y = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_MY_FILE_SAVE));
    }

    private boolean S0(FileManagerEntity fileManagerEntity, int i3) {
        if (fileManagerEntity.nOpType != 58) {
            return true;
        }
        return ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).canAddMenu(fileManagerEntity, i3);
    }

    private void T0(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        com.tencent.mobileqq.filemanager.fileviewer.g gVar;
        int y16 = y();
        if (y16 != 0 && (gVar = this.f208348f) != null && gVar.shouldDisplayColorNote()) {
            int i3 = 70;
            if (y16 != 1 && y16 == 2) {
                i3 = 82;
            }
            o1(fileManagerEntity, arrayList, QFileUtils.c(i3, new h(y16)));
        }
    }

    private void W0(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        k c16 = TencentDocImportFileInfoProcessor.c();
        ta1.f a16 = TencentDocConvertConfigProcessor.a();
        if (c16 != null && a16 != null) {
            String e16 = c16.e();
            boolean o16 = a16.o();
            if (TextUtils.isEmpty(e16)) {
                e16 = ITeamWorkUtils.FILE_WORD_XLS;
            }
            long docsImportFileMaxSize = FileManagerUtil.getDocsImportFileMaxSize(fileManagerEntity.fileName);
            if (o16 && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsSupport(fileManagerEntity.getFilePath(), fileManagerEntity.fileName, e16) && fileManagerEntity.fileSize <= docsImportFileMaxSize) {
                ShareActionSheetBuilder.ActionSheetItem c17 = QFileUtils.c(119, com.tencent.mobileqq.filemanager.fileviewer.c.e(fileManagerEntity, this.f208346d));
                ReportController.o(this.N, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
                o1(fileManagerEntity, arrayList, c17);
            }
        }
    }

    private QQAppInterface a1() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private j e1() {
        if (this.f208347e > this.P.size() - 1) {
            QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.f208347e + "], size[" + this.P.size() + "]");
            return this.P.get(0);
        }
        return this.P.get(this.f208347e);
    }

    private void h1() {
        String str;
        int G = G();
        int O = O();
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null && !TextUtils.isEmpty(entity.WeiYunFileId)) {
            this.N.getFileManagerDataCenter().Q(((IWeiyunApi) QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.N, this.Q.getFileId(), this.Q.getEntity().WeiYunDirKey));
        } else if (G == 2) {
            if (this.Q.s() == null) {
                str = "";
            } else {
                str = this.Q.s().f209604e;
            }
            this.N.getFileManagerDataCenter().Q(((IWeiyunApi) QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.N, this.Q.getFileId(), str));
        } else if (G != 1 && G != 3) {
            if (QLog.isColorLevel()) {
                QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
            }
        } else if (O == 3000) {
            this.N.getFileManagerDataCenter().Q(new com.tencent.mobileqq.filemanageraux.core.a(this.N, this.Q.getUuid(), this.Q.getPeerUin()));
        } else {
            this.N.getFileManagerDataCenter().Q(new n(this.N, this.Q.getUuid(), this.Q.getFileId()));
        }
        if (this.f208349h == null) {
            this.f208349h = this.N.getFileManagerDataCenter().l();
        }
        if (this.f208350i == null) {
            this.f208350i = new a(O);
        }
        com.tencent.mobileqq.filemanager.core.f fVar = this.f208349h;
        if (fVar != null) {
            fVar.d(this.f208350i);
            this.f208349h.c();
        }
    }

    private long i1(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e("FileBrowserModelBase", 1, e16, "parseLong illegal uin: " + str);
            return -1L;
        }
    }

    private void n1(boolean z16) {
        FileManagerEntity entity;
        String N = N();
        if (!FileUtils.fileExistsAndNotEmpty(N) && (entity = this.Q.getEntity()) != null) {
            N = entity.strLargeThumPath;
        }
        String str = N;
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(this.f208346d, str, 1, -1004, null, z16);
        }
    }

    private void o1(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (S0(fileManagerEntity, actionSheetItem.action)) {
            arrayList.add(actionSheetItem);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String B() {
        QQAppInterface qQAppInterface = this.N;
        if (qQAppInterface != null) {
            return qQAppInterface.getCurrentAccountUin();
        }
        return super.B();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void C0(FileManagerEntity fileManagerEntity) {
        j jVar = this.Q;
        if (jVar != null) {
            jVar.d(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int G() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.v();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String I() {
        return q.g(Q());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String J() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.x();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void K0(int i3) {
        if (i3 == this.f208347e) {
            return;
        }
        this.f208347e = i3;
        j e16 = e1();
        this.Q = e16;
        FileManagerEntity entity = e16.getEntity();
        if (entity != null && entity.isZipInnerFile && q.f(entity.getFilePath())) {
            entity.status = 1;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String L() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getFileName();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void L0(int i3) {
        j jVar = this.Q;
        if (jVar != null) {
            jVar.getEntity().status = i3;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int M() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.a();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String N() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getFilePath();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int O() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.b();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void O0(FileBrowserModelBase.f fVar) {
        this.E = fVar;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public long P() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getSessionId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public long Q() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getFileSize();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void Q0(boolean z16) {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            this.Q.getEntity().bCannotPlay = true;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int R() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.c();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public float S() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            return this.Q.getEntity().fProgress;
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int T() {
        int R = R();
        String N = N();
        int i3 = 2;
        if (R != 2 && R != 14) {
            if (R == 16) {
                i3 = 5;
            } else if (R != 0 && R != 3) {
                if (!q.f(N)) {
                    i3 = 0;
                }
            } else {
                i3 = 6;
            }
        } else {
            i3 = 4;
        }
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getFileTransStatus " + i3 + ",status: " + R + ", strFilePath: " + N);
        return i3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int U() {
        int M = M();
        if (G() == 0 && M != 10) {
            return 4;
        }
        if (M != 0) {
            if (M == 35) {
                return 1;
            }
            if (M != 52 && M != 54) {
                if (M == 3) {
                    return 1;
                }
                if (M != 4) {
                    if (M == 6) {
                        return 1;
                    }
                    if (M != 7 && M != 28) {
                        if (M == 29) {
                            return 1;
                        }
                        switch (M) {
                            case 20:
                            case 21:
                            case 22:
                                break;
                            default:
                                if (QLog.isColorLevel()) {
                                    QLog.w("FileBrowserModelBase<FileAssistant>", 2, "error. a unknow transfer type:" + M);
                                }
                                return 2;
                        }
                    }
                }
            }
        }
        if (q.f(N())) {
            return 1;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int V() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getFileType();
        }
        return -1;
    }

    public void V0(Entity entity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        if (!(entity instanceof FileManagerEntity)) {
            QLog.e("FileBrowserModelBase", 1, "fileEntity is not FileManagerEntity type!");
            return;
        }
        FileManagerEntity fileManagerEntity = (FileManagerEntity) entity;
        int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
        if (fileType != 0 && fileType != 2) {
            if (!au.g().k()) {
                QLog.i("FileBrowserModelBase", 1, "not show save other path item!");
                return;
            } else {
                o1(fileManagerEntity, arrayList, QFileUtils.c(229, com.tencent.mobileqq.filemanager.fileviewer.c.n(this.f208346d, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.strFilePath)));
                return;
            }
        }
        QLog.e("FileBrowserModelBase", 1, "image or video file not show item!");
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public List<FileBrowserModelBase.b> W() {
        ArrayList arrayList = new ArrayList();
        List<j> list = this.P;
        if (list != null) {
            Iterator<j> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mobileqq.filemanager.fileviewer.data.c(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public Intent X() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return null;
        }
        return QFileUtils.J(this.N, this.f208346d, entity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean X0(String str) {
        return QbSdk.isInDefaultBrowser(this.f208346d, str);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] Y() {
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        boolean f16 = q.f(N);
        if ((entity == null && TextUtils.isEmpty(N)) || R() == 16) {
            return null;
        }
        if (!f16 && entity != null && entity.isZipInnerFile) {
            return null;
        }
        if (entity == null && f16) {
            try {
                entity = FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(N));
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
            }
        }
        if (entity == null) {
            return null;
        }
        g();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> b16 = b1(entity);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> c16 = c1(entity);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        if (b16 != null && !b16.isEmpty()) {
            arrayList.addAll(b16);
        }
        if (c16 != null && !c16.isEmpty()) {
            arrayList2.addAll(c16);
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    protected boolean Y0() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String Z() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getPeerUin();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z0(boolean z16, kc1.b bVar, long j3, FMDialogUtil.c cVar) {
        bVar.d(z16, this.f208346d, cVar);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String b0() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return "";
        }
        int fileType = FileManagerUtil.getFileType(entity.fileName);
        if (fileType == 0) {
            if (FileUtils.fileExistsAndNotEmpty(N())) {
                return N();
            }
        } else if (fileType == 2 && FileUtils.fileExistsAndNotEmpty(this.L)) {
            return this.L;
        }
        return super.b0();
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b1(FileManagerEntity fileManagerEntity) {
        boolean z16;
        String N = N();
        boolean f16 = q.f(N);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        o1(fileManagerEntity, arrayList, QFileUtils.c(2, com.tencent.mobileqq.filemanager.fileviewer.c.d(this.f208348f, fileManagerEntity, this.f208346d)));
        o1(fileManagerEntity, arrayList, QFileUtils.c(26, null));
        ta1.a c16 = TenDocDirectShareConfigProcessor.c();
        boolean z17 = false;
        if (c16 != null && fileManagerEntity != null && c16.a().contains(q.j(fileManagerEntity.fileName).replace(".", "").toLowerCase())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(120, com.tencent.mobileqq.filemanager.fileviewer.c.f(fileManagerEntity, this.f208346d, true, new d())));
            lr2.a.j(a1(), "0X800A21C");
        }
        if (fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.WeiYunFileId) && !TextUtils.isEmpty(fileManagerEntity.WeiYunDirKey)) {
            z17 = true;
        }
        if (fileManagerEntity != null && !z17 && O() != 10014) {
            if (f16) {
                o1(fileManagerEntity, arrayList, QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.h(fileManagerEntity.nSessionId, this.f208348f, N)));
            } else if (G() == 1) {
                o1(fileManagerEntity, arrayList, QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.j(this.f208348f, fileManagerEntity)));
            }
        }
        WXShareHelper c06 = WXShareHelper.c0(true);
        if (f16 && c06.e0() && c06.d0()) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(9, com.tencent.mobileqq.filemanager.fileviewer.c.o(this.f208346d, N)));
        }
        if (Y0() && S0(fileManagerEntity, 166)) {
            a(arrayList, f16);
        }
        if (f16) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(64, com.tencent.mobileqq.filemanager.fileviewer.c.t(this.f208346d, N)));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public TeamWorkFileImportInfo c0() {
        return this.W;
    }

    public ArrayList<ShareActionSheetBuilder.ActionSheetItem> c1(FileManagerEntity fileManagerEntity) {
        String N = N();
        boolean f16 = q.f(N);
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        if (f16) {
            V0(fileManagerEntity, arrayList);
        }
        T0(fileManagerEntity, arrayList);
        if (fileManagerEntity != null && FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0 && f16) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(39, null));
        }
        if (FileManagerUtil.isSupportFavorite(fileManagerEntity) && O() != 10014) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(6, com.tencent.mobileqq.filemanager.fileviewer.c.c(this.f208348f, fileManagerEntity)));
        }
        U0(fileManagerEntity, arrayList);
        if (fileManagerEntity != null) {
            W0(fileManagerEntity, arrayList);
        }
        if (com.tencent.mobileqq.filemanageraux.link.b.h(fileManagerEntity, f16)) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(122, com.tencent.mobileqq.filemanager.fileviewer.c.p(this.f208346d, fileManagerEntity, N)));
            o1(fileManagerEntity, arrayList, QFileUtils.c(123, com.tencent.mobileqq.filemanager.fileviewer.c.q(this.f208346d, fileManagerEntity, N)));
        }
        IOCRService iOCRService = (IOCRService) this.N.getRuntimeService(IOCRService.class, "");
        boolean z16 = true;
        if (iOCRService.isSupportOcr(this.N.getCurrentAccountUin(), 1) && V() == 0 && fileManagerEntity != null && (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath) || FileUtils.fileExistsAndNotEmpty(N))) {
            if (iOCRService.isSupportOcrAutoTranslate()) {
                o1(fileManagerEntity, arrayList, QFileUtils.c(220, null));
            }
            o1(fileManagerEntity, arrayList, QFileUtils.c(52, null));
        }
        if (V() == 0) {
            b(arrayList);
        }
        IPrintApi iPrintApi = (IPrintApi) QRoute.api(IPrintApi.class);
        String L = L();
        if (fileManagerEntity == null || fileManagerEntity.TroopUin == 0) {
            z16 = false;
        }
        if (iPrintApi.isSupportPrint(L, false, z16) && !ae.h(fileManagerEntity)) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(121, ((IPrintApi) QRoute.api(IPrintApi.class)).getLocalFilePrintClick(this.f208348f.getActivity(), fileManagerEntity, false)));
        }
        if (f16 && X0(N)) {
            o1(fileManagerEntity, arrayList, QFileUtils.c(132, null));
            ReportController.o(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
        }
        ShareActionSheetBuilder.ActionSheetItem d16 = d1();
        if (d16 != null) {
            o1(fileManagerEntity, arrayList, d16);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean d() {
        if (this.N == null) {
            return false;
        }
        int T = T();
        if (T != 5 && T != 2) {
            if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
                return false;
            }
            com.tencent.mobileqq.filemanager.data.c fileAutoDownloadConfig = ((IQFileConfigManager) this.N.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(L()));
            long fileSize = this.Q.getFileSize();
            if ((!NetworkUtil.isWifiConnected(BaseApplication.getContext()) || fileSize > fileAutoDownloadConfig.f207737a) && fileSize > fileAutoDownloadConfig.f207739c) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserModelBase", 2, "can not auto download file : [fileStatus] = " + T);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public cc1.c d0() {
        if (this.F == null) {
            this.F = new c();
        }
        return this.F;
    }

    protected ShareActionSheetBuilder.ActionSheetItem d1() {
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean e() {
        if ((T() != 2 && U() == 1) || !FileManagerUtil.canPreviewZip(this.N, this.Q, true) || !FileManagerUtil.canPreview(this.f208346d, L(), Q())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public long f0() {
        return 0L;
    }

    protected void f1(String str, String str2, String str3, int i3, String str4, String str5, FileManagerEntity fileManagerEntity, boolean z16, String str6, short s16, String str7, a.b bVar) {
        String str8;
        boolean z17;
        if (z16) {
            str8 = "https://";
        } else {
            str8 = "http://";
        }
        String str9 = str8 + str + ":" + ((int) s16) + "/ftn_compress_list/rkey=" + str3 + "&filetype=" + i3 + "&path=" + URLUtil.encodeUrl(str4) + ContainerUtils.FIELD_DELIMITER;
        if (QFileUtils.f0() && !TextUtils.isEmpty(str7)) {
            str9 = str8 + str7 + "/ftn_compress_list/rkey=" + str3 + "&filetype=" + i3 + "&path=" + URLUtil.encodeUrl(str4) + ContainerUtils.FIELD_DELIMITER;
        }
        String str10 = str9;
        if (fileManagerEntity.getCloudType() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.mobileqq.troop.utils.f fVar = new com.tencent.mobileqq.troop.utils.f(str10, "GET", new C7574b(new ArrayList(), str4, fileManagerEntity, z17, str5, z16, str6, str, s16, str3, i3, str2, bVar), 1000, null);
        Bundle bundle = new Bundle();
        bundle.putString("version", ah.P());
        bundle.putString("Cookie", "FTN5K=" + str5);
        if (z16) {
            bundle.putString("Referer", "https://" + str6);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", this.N.getApp().getApplicationContext());
        fVar.b(hashMap);
    }

    public boolean g1() {
        if (this.Q == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String h0() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.getUuid();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] i0() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        boolean f16 = q.f(N);
        o1(entity, arrayList, QFileUtils.c(2, com.tencent.mobileqq.filemanager.fileviewer.c.d(this.f208348f, entity, this.f208346d)));
        o1(entity, arrayList, QFileUtils.c(26, null));
        if (!f16) {
            o1(entity, arrayList, QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.j(this.f208348f, entity)));
        } else {
            o1(entity, arrayList, QFileUtils.c(27, com.tencent.mobileqq.filemanager.fileviewer.c.h(entity.nSessionId, this.f208348f, N)));
        }
        WXShareHelper c06 = WXShareHelper.c0(true);
        if (f16 && c06.e0() && c06.d0()) {
            o1(entity, arrayList, QFileUtils.c(9, com.tencent.mobileqq.filemanager.fileviewer.c.o(this.f208346d, N)));
        }
        if (Y0()) {
            a(arrayList, f16);
        }
        if (f16) {
            o1(entity, arrayList, QFileUtils.c(64, new e()));
        }
        if (f16) {
            o1(entity, arrayList2, QFileUtils.c(39, null));
        }
        if (FileManagerUtil.isSupportFavorite(this.Q.getEntity())) {
            o1(entity, arrayList2, QFileUtils.c(6, com.tencent.mobileqq.filemanager.fileviewer.c.c(this.f208348f, entity)));
        }
        U0(entity, arrayList2);
        if (com.tencent.mobileqq.filemanageraux.link.b.h(entity, f16)) {
            o1(entity, arrayList2, QFileUtils.c(122, com.tencent.mobileqq.filemanager.fileviewer.c.p(this.f208346d, entity, N)));
            o1(entity, arrayList2, QFileUtils.c(123, com.tencent.mobileqq.filemanager.fileviewer.c.q(this.f208346d, entity, N)));
        }
        i(arrayList2);
        if (f16 && X0(N)) {
            o1(entity, arrayList2, QFileUtils.c(132, null));
            ReportController.o(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean j() {
        j jVar = this.Q;
        if (jVar == null) {
            return false;
        }
        FileManagerEntity entity = jVar.getEntity();
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        this.W = teamWorkFileImportInfo;
        teamWorkFileImportInfo.N = false;
        if (a1() == null || entity == null || !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForEdit(N(), L(), Q()) || !NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return false;
        }
        if (TextUtils.isEmpty(entity.Uuid) && TextUtils.isEmpty(entity.strTroopFilePath) && TextUtils.isEmpty(entity.getFilePath())) {
            return false;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.W;
        teamWorkFileImportInfo2.f292074f = entity.fileName;
        teamWorkFileImportInfo2.f292078h0 = entity.fileSize;
        teamWorkFileImportInfo2.f292077h = entity.getFilePath();
        this.W.R = entity.nFileType;
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserModelBase", 2, "file size:" + entity.fileSize + " isTroopFile:" + TextUtils.isEmpty(entity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(entity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(entity.getFilePath()));
        }
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
        if (gVar != null) {
            this.W.K = gVar.N();
        }
        if (!TextUtils.isEmpty(entity.peerUin)) {
            TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.W;
            teamWorkFileImportInfo3.f292070d = entity.peerType;
            teamWorkFileImportInfo3.f292072e = entity.peerUin;
            teamWorkFileImportInfo3.F = String.valueOf(entity.TroopUin);
            TeamWorkFileImportInfo teamWorkFileImportInfo4 = this.W;
            teamWorkFileImportInfo4.D = entity.busId;
            teamWorkFileImportInfo4.C = entity.strTroopFilePath;
            teamWorkFileImportInfo4.f292079i = entity.uniseq;
            if (entity.status != 16) {
                teamWorkFileImportInfo4.I = true;
            }
        }
        return true;
    }

    public void j1() {
        String str;
        FileManagerEntity entity = this.Q.getEntity();
        if (G() == 2) {
            if (this.Q.getEntity() == null) {
                if (this.Q.s() == null) {
                    str = "";
                } else {
                    str = this.Q.s().f209604e;
                }
            } else {
                str = this.Q.getEntity().WeiYunDirKey;
            }
            this.N.getFileManagerDataCenter().Q(((IWeiyunApi) QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.N, entity.WeiYunFileId, str));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void k0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return;
        }
        FileManagerEntity entity = this.Q.getEntity();
        String N = N();
        if (entity == null && TextUtils.isEmpty(N)) {
            return;
        }
        int i3 = actionSheetItem.action;
        D0(i3);
        if (i3 == 73) {
            com.tencent.mobileqq.filemanager.fileviewer.c.d(this.f208348f, entity, this.f208346d).onClick(null);
            return;
        }
        if (i3 == 72) {
            int i16 = actionSheetItem.uinType;
            String str = actionSheetItem.uin;
            if (!TextUtils.isEmpty(str)) {
                QFileUtils.z(this.N, this.f208346d, entity, true, str, i16);
                return;
            }
            return;
        }
        if (i3 == 39) {
            QQPermission qQPermission = this.Y;
            if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                this.Y.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new f());
                return;
            } else {
                FileManagerUtil.saveToAlbum(this.f208346d, N());
                return;
            }
        }
        if (i3 == 52) {
            n1(false);
            return;
        }
        if (i3 == 220) {
            n1(true);
            return;
        }
        if (i3 == 55) {
            String b06 = b0();
            if (FileUtils.fileExistsAndNotEmpty(b06)) {
                QFileUtils.d0(this.f208346d, b06, actionSheetItem.argus, null, 1);
                ReportController.o(null, "dc00898", "", "", "0X800AD47", "0X800AD47", com.tencent.mobileqq.filemanager.fileviewer.n.a(this.H), 0, "", "", "", "");
                return;
            }
            return;
        }
        if (i3 == 56) {
            String b07 = b0();
            if (FileUtils.fileExistsAndNotEmpty(b07)) {
                QFileUtils.d0(this.f208346d, b07, actionSheetItem.argus, null, 2);
                ReportController.o(null, "dc00898", "", "", "0X800AD48", "0X800AD48", com.tencent.mobileqq.filemanager.fileviewer.n.a(this.H), 0, "", "", "", "");
                return;
            }
            return;
        }
        if (i3 == 132) {
            QbSdk.clearDefaultBrowser(this.f208346d, N());
            FileManagerUtil.openWithOtherApp(this.f208346d, N());
            ReportController.o(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
        } else if (i3 == 26) {
            ReportController.o(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
            com.tencent.mobileqq.filemanager.fileassistant.util.b.i(entity).a(this.f208346d, this.N, new g(entity));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k1() {
        com.tencent.mobileqq.filemanager.fileviewer.g gVar;
        ComponentCallbacks2 componentCallbacks2 = this.f208346d;
        String str = null;
        if (componentCallbacks2 instanceof FileBrowserActivity) {
            gVar = (com.tencent.mobileqq.filemanager.fileviewer.g) componentCallbacks2;
        } else {
            gVar = null;
        }
        FileManagerEntity entity = this.Q.getEntity();
        if (entity == null) {
            return;
        }
        int i3 = entity.nOpType;
        if (i3 != 0) {
            if (i3 != 1 && i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 == 9 || i3 == 12) {
                            if (gVar != null && gVar.N()) {
                                str = "0X8004BB9";
                            } else {
                                str = "0X8004BCF";
                            }
                        }
                        if (str != null) {
                            FileManagerReporter.addData(str);
                            return;
                        }
                        return;
                    }
                }
            }
            if (gVar != null && gVar.N()) {
                str = "0X8004BB7";
            } else {
                str = "0X8004BCD";
            }
            if (str != null) {
            }
        }
        if (gVar != null && gVar.N()) {
            str = "0X8004BB8";
        } else {
            str = "0X8004BCE";
        }
        if (str != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l1(List<j> list, int i3) {
        this.P = list;
        this.f208347e = i3;
        this.Q = e1();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void m() {
        super.m();
        com.tencent.mobileqq.filemanager.core.f fVar = this.f208349h;
        if (fVar != null) {
            fVar.a();
            this.f208349h = null;
        }
    }

    public void m1() {
        j jVar = this.Q;
        if (jVar != null) {
            jVar.p(true);
            this.Q.r(false);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void n() {
        com.tencent.mobileqq.filemanager.core.f fVar = this.f208349h;
        if (fVar != null) {
            fVar.a();
            this.f208349h = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean n0() {
        if (this.Q == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void o() {
        super.o();
        l0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean o0() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            return this.Q.getEntity().isSend();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean p() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            return FileManagerUtil.fileWhetherExpire(this.Q.getEntity());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void q(int i3) {
        boolean z16;
        if (this.Q == null) {
            return;
        }
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208348f;
        if (gVar != null && gVar.N()) {
            z16 = true;
        } else {
            z16 = false;
        }
        TeamWorkFileImportInfo generateTencentDocImportInfo = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).generateTencentDocImportInfo(this.Q.getEntity(), z16);
        this.W = generateTencentDocImportInfo;
        generateTencentDocImportInfo.J = i3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean q0() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            return this.Q.getEntity().isFromProcessingForward2c2cOrDiscItem();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String s() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.e();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean s0() {
        j jVar = this.Q;
        if (jVar != null) {
            return jVar.y();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String t() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.apkSafeDetailUrl;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public int u() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.apkSafeLevel;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public boolean u0() {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            return this.Q.getEntity().isZipInnerFile;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String v() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            return entity.apkSafeMsg;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void v0() {
        String str;
        if (this.Q.getEntity().bSend) {
            str = this.N.getCurrentNickname();
        } else if (this.Q.getEntity().peerType == 3000) {
            str = ac.n(this.N, this.Q.getEntity().peerUin, this.Q.getEntity().selfUin);
        } else {
            str = this.Q.getEntity().peerNick;
        }
        String str2 = " \u4e8e" + new SimpleDateFormat("yyyy.MM.dd").format(new Date(this.Q.getEntity().srvTime)) + "\u4e0a\u4f20";
        FileBrowserModelBase.g gVar = this.f208351m;
        if (gVar != null) {
            gVar.i(str, str2);
        }
        if (!NetworkUtil.isNetworkAvailable(this.f208346d)) {
            Activity activity = this.f208346d;
            QQToast.makeText(activity, 1, activity.getString(R.string.b3j), 1).show(e0());
        } else {
            h1();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void w0(int i3, FileBrowserModelBase.b bVar) {
        j g16 = ((com.tencent.mobileqq.filemanager.fileviewer.data.c) bVar).g();
        if (g16 == null) {
            com.tencent.mobileqq.filemanager.util.d.h(BaseApplication.getContext().getString(R.string.b7d));
            return;
        }
        if (FileManagerUtil.fileWhetherExpire(g16.getEntity()) && 1 == g16.v()) {
            com.tencent.mobileqq.filemanager.util.d.h(BaseApplication.getContext().getString(R.string.b7d));
        }
        if (g16.q() == null) {
            g16.setState(1);
            bVar.setState(1);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String x() {
        return "biz_src_jc_file";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void x0(int i3, String str) {
        j jVar = this.Q;
        if (jVar != null && jVar.getEntity() != null) {
            FileManagerEntity entity = this.Q.getEntity();
            entity.status = 16;
            entity.mContext = "showed";
            this.N.getFileManagerDataCenter().f0(entity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void y0() {
        FileManagerEntity entity = this.Q.getEntity();
        if (entity != null) {
            pb1.a.a(this.N, this.f208346d, entity, null);
            return;
        }
        try {
            pb1.a.a(this.N, this.f208346d, FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(N())), null);
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public String z() {
        if (A() == 2) {
            if (TextUtils.isEmpty(this.X) && this.Q != null) {
                this.X = this.Q.getSessionId() + "_" + System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getContextId: default video file random contextId: ");
                sb5.append(this.X);
                QLog.i("FileBrowserModelBase", 1, sb5.toString());
            }
            if (!TextUtils.isEmpty(this.X)) {
                return this.X;
            }
        }
        if (this.Q != null) {
            return this.Q.getSessionId() + "";
        }
        return super.z();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void z0() {
        boolean z16;
        int i3;
        long j3;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.mobileqq.filemanager.util.d.f(BaseApplication.getContext().getString(R.string.b_o));
            return;
        }
        m1();
        j1();
        if (!g1()) {
            FileManagerEntity entity = this.Q.getEntity();
            if (entity.TroopUin == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            if (!TextUtils.isEmpty(entity.fileName) && bb.p(a1(), i3, entity.fileName)) {
                t o16 = TroopFileUtils.o(a1(), entity, true);
                if (o16 == null) {
                    o16 = TroopFileUtils.k(a1(), entity.TroopUin, entity.strTroopFileID, entity.strTroopFilePath, entity.fileName, entity.fileSize, entity.busId);
                    if (TextUtils.isEmpty(o16.f294985s)) {
                        o16.f294985s = entity.Uuid;
                    }
                }
                t tVar = o16;
                if (z16) {
                    if (entity.bSend) {
                        j3 = i1(entity.selfUin);
                    } else {
                        j3 = i1(entity.peerUin);
                    }
                } else {
                    j3 = entity.TroopUin;
                }
                if (j3 < 0) {
                    QLog.d("FileBrowserModelBase", 1, "previewBigFile illegal sendId:" + j3 + ", stop preview");
                    return;
                }
                bb.q(a1(), this.f208346d, tVar, 3, 2, entity.lastTime, String.valueOf(j3), false, z16, entity.bSend, j3, entity.strFileMd5);
                return;
            }
        }
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(N(), L(), Q())) {
            if (c0() == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileBrowserModelBase", 2, "previewBigFile getTeamWorkFileImportInfo() == null");
                }
                q(7);
            }
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryOpenWithTencentDoc(a1(), this.f208346d, "FileBrowserModelBase", c0());
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(c0(), null, "0X8009ECE");
            return;
        }
        Intent intent = new Intent(this.f208346d, (Class<?>) FilePreviewActivity.class);
        intent.putExtra("offline_file_type", 0);
        intent.putExtra("offline_file_name", L());
        intent.putExtra("offline_file_size", Q());
        if (j()) {
            intent.putExtra("offline_file_show_team_work_menu", true);
            intent.putExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, this.W);
        }
        this.f208346d.startActivity(intent);
        this.f208346d.overridePendingTransition(R.anim.f154892f3, R.anim.f154893f4);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208415a;

        g(FileManagerEntity fileManagerEntity) {
            this.f208415a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            QFileAssistantForwardManager qFileAssistantForwardManager = new QFileAssistantForwardManager(b.this.N);
            qFileAssistantForwardManager.c(true);
            qFileAssistantForwardManager.b(this.f208415a);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            b bVar = b.this;
            QFileUtils.l0(bVar.N, bVar.f208346d, this.f208415a);
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void E0(int i3) {
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
    public void F0(FileBrowserModelBase.d dVar) {
    }

    protected void U0(FileManagerEntity fileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
    }
}

package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.OnlineVideoPreviewUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends com.tencent.mobileqq.filemanager.openbrowser.b {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f208996a;

    /* renamed from: b, reason: collision with root package name */
    private SoftReference<QQAppInterface> f208997b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f208998c;

    /* renamed from: d, reason: collision with root package name */
    private int f208999d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.filebrowser.c f209000e;

    /* renamed from: f, reason: collision with root package name */
    private j f209001f;

    /* renamed from: g, reason: collision with root package name */
    private FileBrowserModelBase f209002g;

    /* renamed from: n, reason: collision with root package name */
    private e.c f209009n;

    /* renamed from: o, reason: collision with root package name */
    private e.d f209010o;

    /* renamed from: r, reason: collision with root package name */
    private e.f f209013r;

    /* renamed from: s, reason: collision with root package name */
    private e.f f209014s;

    /* renamed from: u, reason: collision with root package name */
    private e.InterfaceC7518e f209016u;

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.biz.troop.file.b f209018w;

    /* renamed from: x, reason: collision with root package name */
    private e.g f209019x;

    /* renamed from: h, reason: collision with root package name */
    private boolean f209003h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f209004i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f209005j = false;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f209006k = null;

    /* renamed from: l, reason: collision with root package name */
    private FileManagerEntity f209007l = null;

    /* renamed from: m, reason: collision with root package name */
    private OnlineVideoPreviewUtil f209008m = new OnlineVideoPreviewUtil();

    /* renamed from: p, reason: collision with root package name */
    private final FileBrowserModelBase.c f209011p = new a();

    /* renamed from: q, reason: collision with root package name */
    private final com.tencent.mobileqq.filemanager.fileviewer.g f209012q = new b();

    /* renamed from: t, reason: collision with root package name */
    private final FileBrowserModelBase.f f209015t = new c();

    /* renamed from: v, reason: collision with root package name */
    private final FileBrowserModelBase.e f209017v = new C7582d();

    /* renamed from: y, reason: collision with root package name */
    private final FileBrowserModelBase.g f209020y = new e();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements FileBrowserModelBase.c {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.c
        public void h(int i3, String str, String str2, Bundle bundle) {
            if (d.this.f209010o != null) {
                d.this.f209010o.h(i3, str, str2, bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements FileBrowserModelBase.f {
        c() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void a(float f16) {
            if (d.this.f209013r != null) {
                d.this.f209013r.a(f16);
            }
            if (d.this.f209014s != null) {
                d.this.f209014s.a(f16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void e() {
            if (d.this.f209013r != null) {
                d.this.f209013r.e();
            }
            if (d.this.f209014s != null) {
                d.this.f209014s.e();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void f() {
            if (d.this.f209013r != null) {
                d.this.f209013r.f();
            }
            if (d.this.f209014s != null) {
                d.this.f209014s.f();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void j() {
            if (d.this.f209013r != null) {
                d.this.f209013r.j();
            }
            if (d.this.f209014s != null) {
                d.this.f209014s.j();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
        public void l() {
            if (d.this.f209013r != null) {
                d.this.f209013r.l();
            }
            if (d.this.f209014s != null) {
                d.this.f209014s.l();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.openbrowser.d$d, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7582d implements FileBrowserModelBase.e {
        C7582d() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.e
        public void k(String str, String str2) {
            if (d.this.f209016u != null) {
                d.this.f209016u.k(str, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements FileBrowserModelBase.g {
        e() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
        public void c(long j3) {
            if (d.this.f209019x != null) {
                d.this.f209019x.c(j3);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
        public void g(List<ZipFilePresenter.f> list, String str, String str2, String str3, String str4, boolean z16, String str5, short s16) {
            QLog.d("FileModelAdapter<FileAssistant>", 1, "onGetZipFileList this :" + d.this);
            if (d.this.f209019x != null) {
                FileBrowserModelBase fileBrowserModelBase = d.this.f209002g;
                if (fileBrowserModelBase == null) {
                    QLog.d("FileModelAdapter<FileAssistant>", 1, "onGetZipFileList localFM null");
                    d.this.f209019x.c(-1000L);
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (ZipFilePresenter.f fVar : list) {
                    e.h hVar = new e.h();
                    hVar.f205934a = fVar.f208516a;
                    hVar.f205936c = fVar.f208518c;
                    hVar.f205937d = fVar.f208519d;
                    hVar.f205935b = fVar.f208517b;
                    arrayList.add(hVar);
                }
                d.this.f209018w = new com.tencent.biz.troop.file.b(list, d.this.f208996a);
                d.this.f209018w.C = "/";
                d.this.f209018w.E = fileBrowserModelBase.P();
                d.this.f209018w.D = fileBrowserModelBase.f0();
                d.this.f209018w.f96849h = str2;
                d.this.f209018w.f96850i = str3;
                d.this.f209018w.f96851m = str4;
                d.this.f209018w.f96848f = str;
                d.this.f209018w.e(z16, str5, s16);
                d.this.f209019x.g(arrayList, str, str2, str3, str4, z16, str5, s16);
                return;
            }
            QLog.d("FileModelAdapter<FileAssistant>", 1, "onGetZipFileList zipEventListener null");
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
        public void i(String str, String str2) {
            if (d.this.f209019x != null) {
                d.this.f209019x.i(str, str2);
            }
        }
    }

    public d(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        int cloudType = fileManagerEntity.getCloudType();
        QLog.d("FileModelAdapter<FileAssistant>", 1, "FileModelAdapter cloudType " + cloudType + " entity.peerType " + fileManagerEntity.peerType);
        if (cloudType == 9) {
            v0(qQAppInterface, fileManagerEntity, 4);
            return;
        }
        if (cloudType != 14) {
            String str = fileManagerEntity.guildId;
            if (str != null && fileManagerEntity.channelId != null && !str.isEmpty() && !fileManagerEntity.channelId.isEmpty()) {
                v0(qQAppInterface, fileManagerEntity, 5);
                return;
            } else {
                v0(qQAppInterface, fileManagerEntity, 1);
                return;
            }
        }
        v0(qQAppInterface, fileManagerEntity, 6);
    }

    private QQAppInterface u0() {
        QQAppInterface qQAppInterface = this.f208997b.get();
        if (qQAppInterface == null) {
            QQAppInterface qQAppInterface2 = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            this.f208997b = new SoftReference<>(qQAppInterface2);
            return qQAppInterface2;
        }
        return qQAppInterface;
    }

    private void v0(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, int i3) {
        QLog.d("FileModelAdapter<FileAssistant>", 1, "init modelType : " + i3);
        this.f208997b = new SoftReference<>(qQAppInterface);
        this.f208999d = i3;
        this.f209007l = fileManagerEntity;
        switch (i3) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                this.f209001f = new ac1.a(qQAppInterface, fileManagerEntity);
                this.f209000e = new com.tencent.mobileqq.filemanager.openbrowser.a(qQAppInterface, fileManagerEntity);
                return;
            case 2:
                this.f209001f = new ac1.c(qQAppInterface, fileManagerEntity);
                this.f209000e = new i(qQAppInterface, fileManagerEntity);
                return;
            default:
                this.f209001f = null;
                this.f209000e = null;
                return;
        }
    }

    private void w0() {
        if (this.f209006k != null) {
            u0().getApp().unregisterReceiver(this.f209006k);
            this.f209006k = null;
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String A() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return "";
        }
        return bundle.getString("qq_ref_pgid", "");
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public MsgRecordParams B() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return null;
        }
        return (MsgRecordParams) bundle.getParcelable("file_browser_extra_msg_record_params");
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void C(e.g gVar) {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        this.f209019x = gVar;
        fileBrowserModelBase.P0(this.f209020y);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String D() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return "";
        }
        return fileBrowserModelBase.r();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean E() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return false;
        }
        return fileBrowserModelBase.h();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public float F() {
        if (this.f209001f.getEntity() != null) {
            return this.f209001f.getEntity().fProgress;
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void G(int i3) {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.q(i3);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public FileManagerEntity I() {
        return this.f209001f.getEntity();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean J() {
        return this.f209005j;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public TeamWorkFileImportInfo K() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null && fileBrowserModelBase.c0() != null) {
            return this.f209002g.c0();
        }
        return new TeamWorkFileImportInfo();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String L() {
        FileManagerEntity entity = this.f209001f.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.mExcitingSpeed;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public int M() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.A();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void N(e.a aVar) {
        this.f209008m.m(this.f209007l, aVar);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public int O() {
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "fileModel is null");
        if (this.f209002g != null) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "getFileTransStatus fileModel.getFileTransStatus() " + this.f209002g.T());
            return this.f209002g.T();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void P(e.f fVar) {
        this.f209013r = fVar;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String Q() {
        return q.g(this.f209001f.getFileSize());
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean R() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.a0();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void S(Bundle bundle) {
        this.f208998c = bundle;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void T() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.v0();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] U() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return null;
        }
        return fileBrowserModelBase.Y();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean V() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return false;
        }
        return fileBrowserModelBase.d();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void W(Context context) {
        this.f209008m.o(context, u0(), this.f209007l);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void X(e.c cVar) {
        this.f209009n = cVar;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void Y(e.InterfaceC7518e interfaceC7518e) {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        this.f209016u = interfaceC7518e;
        fileBrowserModelBase.N0(this.f209017v);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean Z() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return false;
        }
        return fileBrowserModelBase.u0();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void a() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.D().a();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void b() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.D().b();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String b0() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return "0";
        }
        return bundle.getString("file_status", "0");
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void c() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.y0();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void d(FileManagerEntity fileManagerEntity) {
        this.f209007l = fileManagerEntity;
        j jVar = this.f209001f;
        if (jVar != null) {
            jVar.d(fileManagerEntity);
        }
        com.tencent.mobileqq.filebrowser.c cVar = this.f209000e;
        if (cVar != null) {
            cVar.h(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public com.tencent.mobileqq.filebrowser.c d0() {
        return this.f209000e;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void doOnDestroy() {
        QLog.d("FileModelAdapter<FileAssistant>", 1, "doOnDestroy cloudType " + this);
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.m();
        }
        this.f209002g = null;
        this.f209000e = null;
        this.f209013r = null;
        this.f209009n = null;
        this.f208996a = null;
        w0();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void doOnPause() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.n();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void doOnResume() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            fileBrowserModelBase.o();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void e() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.g0().e();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean e0() {
        if (this.f209001f.getEntity() != null) {
            return FileManagerUtil.fileWhetherExpire(this.f209001f.getEntity());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void f() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.g0().f();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String g() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return "";
        }
        return fileBrowserModelBase.K();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean g0() {
        if (this.f209001f.getEntity() != null) {
            return this.f209001f.getEntity().isFromProcessingForward2c2cOrDiscItem();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String getCurrentAccountUin() {
        if (u0() == null) {
            return "";
        }
        return u0().getCurrentAccountUin();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean h() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return false;
        }
        if (!(fileBrowserModelBase instanceof C2CFileModel) && !(fileBrowserModelBase instanceof TroopFileModel)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public int i() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt("aio_type", 0);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void k() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        fileBrowserModelBase.z0();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void l(e.d dVar) {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return;
        }
        this.f209010o = dVar;
        fileBrowserModelBase.M0(this.f209011p);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String m() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return "";
        }
        return fileBrowserModelBase.w();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public int n() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null) {
            return fileBrowserModelBase.U();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public boolean o() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase == null) {
            return false;
        }
        return fileBrowserModelBase.j();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public String p() {
        return this.f209001f.x();
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void r(e.f fVar) {
        this.f209014s = fVar;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public BaseAdapter s() {
        return this.f209018w;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void setActivity(Activity activity) {
        this.f208996a = activity;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f209001f);
        QLog.d("FileModelAdapter<FileAssistant>", 1, "setActivity modelType: " + this.f208999d + ", this: " + this);
        int i3 = this.f208999d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            this.f209002g = null;
                        } else {
                            this.f209002g = new com.tencent.mobileqq.filemanageraux.fileviewer.model.a(u0(), activity, arrayList, 0);
                        }
                    } else {
                        this.f209002g = (FileBrowserModelBase) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewGuildFileModel(u0(), activity, arrayList, 0);
                    }
                } else {
                    this.f209002g = new DocsExportFileModel(u0(), activity, arrayList, 0);
                }
            } else {
                this.f209002g = new TroopFileModel(u0(), activity, arrayList, 0);
            }
        } else {
            this.f209002g = new C2CFileModel(u0(), activity, arrayList, 0);
        }
        if (this.f209002g != null) {
            QLog.d("FileModelAdapter<FileAssistant>", 1, "setActivity fileModel: " + this.f209002g);
            this.f209002g.H0(this.f208998c);
            this.f209002g.O0(this.f209015t);
            this.f209002g.I0(this.f209012q);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public Intent t() {
        FileManagerEntity entity = this.f209001f.getEntity();
        if (entity == null) {
            return null;
        }
        return QFileUtils.J(u0(), this.f208996a, entity);
    }

    public Activity t0() {
        return this.f208996a;
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void u(e.a aVar) {
        this.f209008m.n(u0(), this.f209007l, aVar);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public void w(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        FileBrowserModelBase fileBrowserModelBase;
        if (actionSheetItem == null || (fileBrowserModelBase = this.f209002g) == null) {
            return;
        }
        fileBrowserModelBase.k0(actionSheetItem);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public long[] x() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return null;
        }
        return bundle.getLongArray("forward_root_msg_ids");
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public int y() {
        Bundle bundle = this.f208998c;
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt("qq_pgstp", 0);
    }

    @Override // com.tencent.mobileqq.filebrowser.e
    public com.tencent.mobileqq.colornote.f z() {
        FileBrowserModelBase fileBrowserModelBase = this.f209002g;
        if (fileBrowserModelBase != null && fileBrowserModelBase.H() != null) {
            return this.f209002g.H();
        }
        return new bc1.c();
    }

    public d(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, int i3) {
        v0(qQAppInterface, fileManagerEntity, i3);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements com.tencent.mobileqq.filemanager.fileviewer.g {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public boolean N() {
            return d.this.f209004i;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void P0() {
            if (d.this.f209009n != null) {
                d.this.f209009n.onFinished();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public boolean g2() {
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public Activity getActivity() {
            return d.this.f208996a;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void h2() {
            r2(false);
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void r2(boolean z16) {
            if (d.this.f209009n != null) {
                d.this.f209009n.A();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public boolean s() {
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public boolean shouldDisplayColorNote() {
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void K1() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void R1() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void t2() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void b(boolean z16) {
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.g
        public void d(View view) {
        }
    }
}

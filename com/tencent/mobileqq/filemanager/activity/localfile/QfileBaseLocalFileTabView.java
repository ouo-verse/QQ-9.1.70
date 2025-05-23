package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.d;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.n;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.DelFileHolderRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.guild.api.IGuildFileApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QfileBaseLocalFileTabView extends QfileBaseTabView {

    /* renamed from: e0, reason: collision with root package name */
    static String f206616e0 = "QfileBaseLocalFileTabView<FileAssistant>";
    protected LinkedHashMap<String, List<FileInfo>> E;
    protected List<QfileTabBarView.h> F;
    protected boolean G;
    public ViewerMoreRelativeLayout H;
    NoFileRelativeLayout I;
    protected QfilePinnedHeaderExpandableListView J;
    boolean K;
    LayoutInflater L;
    protected boolean M;
    protected ArrayList<FileInfo> N;
    protected ob1.d P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    BubblePopupWindow T;
    public View.OnClickListener U;
    public View.OnClickListener V;
    public View.OnLongClickListener W;

    /* renamed from: a0, reason: collision with root package name */
    public View.OnClickListener f206617a0;

    /* renamed from: b0, reason: collision with root package name */
    public View.OnClickListener f206618b0;

    /* renamed from: c0, reason: collision with root package name */
    private FMObserver f206619c0;

    /* renamed from: d0, reason: collision with root package name */
    t f206620d0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        List<FileInfo> f206621d = null;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f206622e;

        AnonymousClass1(List list) {
            this.f206622e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<FileInfo> b06 = QfileBaseLocalFileTabView.this.b0(this.f206622e);
            this.f206621d = b06;
            if (b06.size() > 0) {
                QfileBaseLocalFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator<FileInfo> it = AnonymousClass1.this.f206621d.iterator();
                        while (it.hasNext()) {
                            QfileBaseLocalFileTabView.this.Y(it.next());
                        }
                        QfileBaseLocalFileTabView.this.C();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileBaseLocalFileTabView.this.f206603d.U2().g0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileBaseLocalFileTabView.this.f206603d.U2().p();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileBaseLocalFileTabView.this.f206603d.U2().n();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileBaseLocalFileTabView.this.f206603d.U2().P();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileBaseLocalFileTabView.this.f206603d.U2().Y();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileBaseLocalFileTabView.this.f206603d.U2().b0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(QfileBaseLocalFileTabView.f206616e0, 2, "qfilebaserecenttabview del error, tag is null");
                }
            } else {
                FileInfo fileInfo = (FileInfo) view.getTag();
                if (fileInfo != null) {
                    ob1.d dVar = QfileBaseLocalFileTabView.this.P;
                    if (dVar != null) {
                        dVar.e(null);
                    }
                    if (FileUtils.fileExists(fileInfo.k()) && !fileInfo.k().startsWith(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.zye);
                    } else if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteFile(fileInfo.k())) {
                        QfileBaseLocalFileTabView.this.W(fileInfo);
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.f(ah.y(fileInfo.j()) + QfileBaseLocalFileTabView.this.o().getString(R.string.b5x));
                    }
                }
                ob1.d dVar2 = QfileBaseLocalFileTabView.this.P;
                if (dVar2 != null) {
                    dVar2.e(-1);
                }
                view.setVisibility(4);
                QfileBaseLocalFileTabView.this.l0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileBaseLocalFileTabView.this.i0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements View.OnLongClickListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206639d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            class C7536a implements ActionSheet.OnButtonClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FileInfo f206641d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ActionSheet f206642e;

                C7536a(FileInfo fileInfo, ActionSheet actionSheet) {
                    this.f206641d = fileInfo;
                    this.f206642e = actionSheet;
                }

                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    if (FileUtils.fileExists(this.f206641d.k()) && !this.f206641d.k().startsWith(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.zye);
                        return;
                    }
                    if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isFileExists(this.f206641d.k()) && !((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteFile(this.f206641d.k())) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b5v);
                        return;
                    }
                    ah.F(this.f206641d.k());
                    QfileBaseLocalFileTabView.this.W(this.f206641d);
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(new File(this.f206641d.k())));
                        QfileBaseLocalFileTabView.this.f206603d.sendBroadcast(intent);
                    } catch (Exception unused) {
                    }
                    QfileBaseLocalFileTabView.this.l0();
                    if (this.f206642e.isShowing()) {
                        this.f206642e.dismiss();
                    }
                }
            }

            a(View view) {
                this.f206639d = view;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FileInfo fileInfo;
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = this.f206639d.getTag();
                if (tag instanceof ob1.c) {
                    fileInfo = (FileInfo) ((ob1.c) this.f206639d.getTag()).f422335j;
                } else if (tag instanceof d.b) {
                    fileInfo = (FileInfo) ((d.b) this.f206639d.getTag()).F;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e(QfileBaseLocalFileTabView.f206616e0, 2, "unknow Object");
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
                if (view.getId() == R.id.bf5) {
                    ActionSheet create = ActionSheet.create(QfileBaseLocalFileTabView.this.f206603d);
                    create.setMainTitle(HardCodeUtil.qqStr(R.string.f186943sn));
                    create.addButton(HardCodeUtil.qqStr(R.string.f186873sg), 3);
                    create.addCancelButton(HardCodeUtil.qqStr(R.string.b5j));
                    create.setOnButtonClickListener(new C7536a(fileInfo, create));
                    create.show();
                } else if (view.getId() == R.id.cju) {
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).forwardFile(QfileBaseLocalFileTabView.this.f206603d, ah.k1(fileInfo));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements BubblePopupWindow.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206644d;

            b(View view) {
                this.f206644d = view;
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                this.f206644d.setSelected(false);
            }
        }

        d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            FileInfo fileInfo;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view != null && !QfileBaseLocalFileTabView.this.v()) {
                z16 = true;
                view.setSelected(true);
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.a(R.id.cju, view.getContext().getString(R.string.b_f));
                if (view.getTag() instanceof ob1.c) {
                    fileInfo = (FileInfo) ((ob1.c) view.getTag()).f422335j;
                } else if (view.getTag() instanceof d.b) {
                    fileInfo = (FileInfo) ((d.b) view.getTag()).F;
                } else {
                    fileInfo = null;
                }
                if (fileInfo != null && fileInfo.p()) {
                    aVar.a(R.id.bf5, view.getContext().getString(R.string.b_d));
                }
                QfileBaseLocalFileTabView.this.T = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).showAsDropDown(view, aVar, new a(view), new b(view));
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FileInfo fileInfo;
            AsyncImageView asyncImageView;
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            boolean z16 = true;
            if (tag instanceof d.b) {
                d.b bVar = (d.b) view.getTag();
                fileInfo = (FileInfo) bVar.F;
                asyncImageView = bVar.C;
            } else if (tag instanceof ob1.c) {
                ob1.c cVar = (ob1.c) view.getTag();
                fileInfo = (FileInfo) cVar.f422335j;
                AsyncImageView asyncImageView2 = cVar.f422326a;
                if (QfileBaseLocalFileTabView.this.f206603d.u3() || QfileBaseLocalFileTabView.this.f206603d.s3()) {
                    SharedPreferences.Editor edit = QfileBaseLocalFileTabView.this.f206603d.getSharedPreferences("LAST_CHOOSE_", 0).edit();
                    edit.putInt("GROUP", cVar.f422334i);
                    edit.putInt("CHILD", (cVar.f422333h + 1) / 4);
                    edit.commit();
                }
                asyncImageView = asyncImageView2;
            } else {
                fileInfo = null;
                asyncImageView = null;
            }
            if (view.getId() == R.id.c_5 && QfileBaseLocalFileTabView.this.v()) {
                ReportController.o(((QfileBaseTabView) QfileBaseLocalFileTabView.this).f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
            }
            if (fileInfo != null) {
                QfileBaseLocalFileTabView qfileBaseLocalFileTabView = QfileBaseLocalFileTabView.this;
                if (view.getId() != R.id.c_5) {
                    z16 = false;
                }
                qfileBaseLocalFileTabView.q0(fileInfo, asyncImageView, z16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.b bVar = (d.b) view.getTag();
            FileInfo fileInfo = (FileInfo) bVar.F;
            if (bVar.f206697i == 0) {
                QfileBaseLocalFileTabView.this.f206603d.U2().onPreviewClick();
                QfileBaseLocalFileTabView.this.q0(fileInfo, bVar.C, false);
            }
            QfileBaseLocalFileTabView.this.C();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QfileBaseLocalFileTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context);
        this.E = null;
        this.I = null;
        this.L = null;
        this.N = null;
        this.P = null;
        this.R = true;
        this.S = true;
        this.T = null;
        this.U = new b();
        this.V = new c();
        this.W = new d();
        this.f206617a0 = new e();
        this.f206618b0 = new f();
        this.f206619c0 = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void B0(n nVar) {
                if (nVar == null) {
                    return;
                }
                Object obj = nVar.f207832c;
                if (obj instanceof FileManagerEntity) {
                    FileManagerEntity fileManagerEntity = (FileManagerEntity) obj;
                    String str = nVar.f207833d;
                    if (str != null && str.length() > 0) {
                        fileManagerEntity.strThumbPath = nVar.f207833d;
                        ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseLocalFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(fileManagerEntity);
                        QfileBaseLocalFileTabView.this.C();
                    }
                }
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void S(final boolean z17, long j3, final long j16, String str, int i3, final int i16, final String str2) {
                QfileBaseLocalFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseLocalFileTabView.this.l0();
                        if (!z17) {
                            ah.C(j16, i16, str2);
                            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseLocalFileTabView.this.f206603d, i16);
                        } else {
                            ah.D(j16);
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void T(boolean z17, long j3, long j16, String str, int i3) {
                QfileBaseLocalFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseLocalFileTabView.this.l0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void j0(int i3, long j3, String str) {
                super.j0(i3, j3, str);
                ah.C(j3, i3, str);
                ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(QfileBaseLocalFileTabView.this.f206603d, i3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void k0(long j3, String str, int i3, String str2) {
                super.k0(j3, str, i3, str2);
                ah.D(j3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void s0() {
                super.s0();
                QfileBaseLocalFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.8.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseLocalFileTabView.this.l0();
                    }
                });
            }
        };
        this.f206620d0 = null;
        this.F = list;
        this.G = z16;
        this.E = new LinkedHashMap<>();
        this.N = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(FileInfo fileInfo) {
        try {
            if (com.tencent.mobileqq.filemanager.data.f.C(fileInfo)) {
                com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
            }
            Iterator<String> it = this.E.keySet().iterator();
            boolean z16 = false;
            while (it.hasNext() && !z16) {
                List<FileInfo> list = this.E.get(it.next());
                if (list.size() > 0) {
                    Iterator<FileInfo> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (it5.next().k() == fileInfo.k()) {
                            it5.remove();
                            z16 = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception unused) {
            QLog.e(f206616e0, 2, "qfilebaserecenttabview deleteCacheFile error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<FileInfo> b0(List<FileInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (FileInfo fileInfo : list) {
            if (fileInfo.k() != null && fileInfo.k().length() > 0 && !new File(fileInfo.k()).exists()) {
                arrayList.add(fileInfo);
            }
        }
        return arrayList;
    }

    private List<FileInfo> d0() {
        Iterator<String> it = this.E.keySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            List<FileInfo> list = this.E.get(it.next());
            if (list.size() > 0) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    private void g0() {
        try {
            this.I = new NoFileRelativeLayout(o());
            this.J.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.2
                @Override // java.lang.Runnable
                public void run() {
                    NoFileRelativeLayout noFileRelativeLayout;
                    QfileBaseLocalFileTabView qfileBaseLocalFileTabView = QfileBaseLocalFileTabView.this;
                    QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = qfileBaseLocalFileTabView.J;
                    if (qfilePinnedHeaderExpandableListView != null && (noFileRelativeLayout = qfileBaseLocalFileTabView.I) != null) {
                        noFileRelativeLayout.setLayoutParams(qfilePinnedHeaderExpandableListView.getWidth(), QfileBaseLocalFileTabView.this.J.getHeight());
                    }
                }
            });
            ViewerMoreRelativeLayout viewerMoreRelativeLayout = new ViewerMoreRelativeLayout(o());
            this.H = viewerMoreRelativeLayout;
            viewerMoreRelativeLayout.setOnClickListener(this.V);
            this.J.addFooterView(this.H);
            QLog.d(f206616e0, 1, "create two footView");
            if (j()) {
                QLog.d(f206616e0, 1, "create two footView success");
                this.J.addFooterView(new DelFileHolderRelativeLayout(o()));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void h0() {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = (QfilePinnedHeaderExpandableListView) findViewById(R.id.c_r);
        this.J = qfilePinnedHeaderExpandableListView;
        qfilePinnedHeaderExpandableListView.setSelection(0);
        this.J.setFocusable(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        this.S = true;
        if (this.E.size() > 0) {
            l0();
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        this.S = false;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void C() {
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.9
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseLocalFileTabView.this.l0();
                QfileBaseLocalFileTabView qfileBaseLocalFileTabView = QfileBaseLocalFileTabView.this;
                if (qfileBaseLocalFileTabView.S) {
                    qfileBaseLocalFileTabView.V();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int U(List<FileInfo> list, long j3) {
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) >>> 1;
            FileInfo fileInfo = list.get(i16);
            if (fileInfo.e() > j3) {
                i3 = i16 + 1;
            } else if (fileInfo.e() < j3) {
                size = i16 - 1;
            } else {
                return i16;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        LinkedHashMap<String, List<FileInfo>> linkedHashMap = this.E;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            this.f206603d.D3(true);
        } else {
            this.f206603d.D3(false);
        }
    }

    public boolean W(FileInfo fileInfo) {
        if (fileInfo == null) {
            return false;
        }
        return X(fileInfo);
    }

    protected abstract boolean X(FileInfo fileInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(boolean z16) {
        String str = "";
        if (this.f206603d.v3()) {
            if (this instanceof QfileLocalFileMediaTabView) {
                str = "0x8009DAF";
            } else if (this instanceof QfileLocalFilePicTabView) {
                str = "0x8009DB1";
            } else if (this instanceof QfileLocalFileDocTabView) {
                str = "0x8009DB3";
            } else if (this instanceof QfileLocalFileAppTabView) {
                str = "0x8009DB5";
            } else if (this instanceof QfileLocalFileOtherTabView) {
                str = "0x8009DB7";
            }
            String str2 = str;
            ReportController.o(this.f206604e, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            return;
        }
        if (this.f206603d.t3() && !z16) {
            if (this instanceof QfileLocalFileMediaTabView) {
                str = "0X8009E49";
            } else if (this instanceof QfileLocalFilePicTabView) {
                str = "0X8009E46";
            } else if (this instanceof QfileLocalFileDocTabView) {
                str = "0X8009E44";
            } else if (this instanceof QfileLocalFileAppTabView) {
                str = "0X8009E4C";
            } else if (this instanceof QfileLocalFileOtherTabView) {
                str = "0X8009E48";
            }
        } else if (!this.f206603d.t3()) {
            if (this instanceof QfileLocalFileMediaTabView) {
                str = "0X8009E5B";
            } else if (this instanceof QfileLocalFilePicTabView) {
                str = "0X8009E58";
            } else if (this instanceof QfileLocalFileDocTabView) {
                str = "0X8009E56";
            } else if (this instanceof QfileLocalFileAppTabView) {
                str = "0X8009E5E";
            } else if (this instanceof QfileLocalFileOtherTabView) {
                str = "0X8009E5A";
            }
        }
        String str3 = str;
        if (!TextUtils.isEmpty(str3)) {
            ReportController.o(this.f206604e, "dc00898", "", "", str3, str3, 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(int i3) {
        if (i3 >= this.P.getGroupCount()) {
            QLog.d(f206616e0, 1, "group out of bounds, pos:" + i3);
            return;
        }
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = this.J;
        if (qfilePinnedHeaderExpandableListView != null) {
            qfilePinnedHeaderExpandableListView.expandGroup(i3);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void b() {
        Iterator<List<FileInfo>> it = this.E.values().iterator();
        while (it.hasNext()) {
            Iterator<FileInfo> it5 = it.next().iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.filemanager.data.f.G(it5.next());
            }
        }
        k();
        this.P.notifyDataSetChanged();
    }

    protected abstract ob1.d c0();

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, qb1.f
    public void d(FileInfo fileInfo) {
        if (fileInfo == null) {
            return;
        }
        n0(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void e() {
        if (this.E == null) {
            return;
        }
        Iterator it = new ArrayList(this.E.values()).iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.filemanager.data.f.f((List) it.next());
        }
        int size = this.E.keySet().size();
        for (int i3 = 0; i3 < size; i3++) {
            this.J.expandGroup(i3);
        }
        k();
        this.P.notifyDataSetChanged();
    }

    protected abstract void e0();

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void f() {
        if (!j0()) {
            return;
        }
        try {
            ThreadManagerV2.excute(new AnonymousClass1(d0()), 64, null, true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0() {
        t tVar = this.f206620d0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206620d0 = aVar;
        this.f206603d.P3(aVar);
    }

    public boolean j0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0() {
        LinkedHashMap<String, List<FileInfo>> linkedHashMap = this.E;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            if (this.J.getHeaderViewsCount() > 0) {
                this.J.removeHeaderView(this.I);
            }
        } else {
            if (this.f206603d.t3()) {
                this.I.setTopViewHeight(0.5f);
            }
            if (this.J.getHeaderViewsCount() == 0) {
                this.J.addHeaderView(this.I);
            }
            ViewerMoreRelativeLayout viewerMoreRelativeLayout = this.H;
            if (viewerMoreRelativeLayout != null) {
                viewerMoreRelativeLayout.setGone();
            }
        }
        this.P.notifyDataSetChanged();
        p0();
        if (this.Q) {
            QLog.d("NTScanSpaceManager", 1, "refreshList updateRefreshTabCount");
            this.f206603d.V2().u0();
        } else {
            this.f206603d.V2().F();
        }
    }

    protected abstract void n0(FileInfo fileInfo);

    public void o0(int i3) {
        this.Q = true;
        QLog.d("NTScanSpaceManager", 1, "reloadData mReload is " + this.Q + ", fileType is " + i3);
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.10
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("NTScanSpaceManager", 1, "reloadData getRecentFileRecords");
                QfileBaseLocalFileTabView.this.e0();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        LinkedHashMap<String, List<FileInfo>> linkedHashMap = this.E;
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            e0();
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int p() {
        return this.H.getHeight();
    }

    protected void p0() {
        NoFileRelativeLayout noFileRelativeLayout = this.I;
        if (noFileRelativeLayout != null) {
            noFileRelativeLayout.setLayoutParams(this.J.getWidth(), this.J.getHeight());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public ListView q() {
        return this.J;
    }

    public void q0(FileInfo fileInfo, View view, boolean z16) {
        if (v() && !z16) {
            if (com.tencent.mobileqq.filemanager.data.f.C(fileInfo)) {
                com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
                k0(fileInfo, false);
            } else {
                com.tencent.mobileqq.filemanager.data.f.c(fileInfo);
                k0(fileInfo, true);
                if (this.f206603d.j3() && !com.tencent.mobileqq.filemanager.data.f.w(com.tencent.mobileqq.filemanager.data.f.f207765k) && !com.tencent.mobileqq.filemanager.data.f.z(fileInfo)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0g);
                    createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                    com.tencent.mobileqq.filemanager.data.f.L(com.tencent.mobileqq.filemanager.data.f.f207765k);
                    FileManagerReporter.addData("0X800942D");
                }
            }
            this.f206603d.G3(true);
            if (this.f206603d.f206192z0 && !FileUtils.fileExistsAndNotEmpty(fileInfo.k())) {
                com.tencent.mobileqq.filemanager.util.d.f(ah.y(fileInfo.j()) + HardCodeUtil.qqStr(R.string.f187013su));
                com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
            } else if (this.f206603d.A0 && !((IGuildFileApi) QRoute.api(IGuildFileApi.class)).isLegalForSelectedFileName(fileInfo.j())) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.f187133t6));
                com.tencent.mobileqq.filemanager.data.f.G(fileInfo);
            }
            l0();
            k();
            V();
        } else {
            if (!w()) {
                if (QLog.isColorLevel()) {
                    QLog.i(f206616e0, 2, "click too fast , wait a minute.");
                    return;
                }
                return;
            }
            G();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.f206603d, this.E, fileInfo, view, ah.k1(fileInfo));
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "file_viewer_in";
            aVar.f209158c = 80;
            aVar.f209159d = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(fileInfo.j());
            aVar.f209160e = fileInfo.l();
            FileManagerReporter.addData(this.f206604e.getCurrentAccountUin(), aVar);
            FileManagerReporter.addData("0X8004AE5");
        }
        Z(v());
    }

    public void setLoadAllRecord(boolean z16) {
        if (z16) {
            ViewerMoreRelativeLayout viewerMoreRelativeLayout = this.H;
            if (viewerMoreRelativeLayout != null) {
                viewerMoreRelativeLayout.setGone();
            }
        } else {
            ViewerMoreRelativeLayout viewerMoreRelativeLayout2 = this.H;
            if (viewerMoreRelativeLayout2 != null) {
                viewerMoreRelativeLayout2.setVisible();
            }
        }
        this.K = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setPos(final int i3, final int i16) {
        if (i3 < 0 || i16 < 0 || this.P.getGroupCount() <= i3) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.11
            @Override // java.lang.Runnable
            public void run() {
                QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = QfileBaseLocalFileTabView.this.J;
                if (qfilePinnedHeaderExpandableListView != null) {
                    qfilePinnedHeaderExpandableListView.expandGroup(i3);
                    int i17 = i16;
                    if (i17 - 2 < 0) {
                        return;
                    }
                    QfileBaseLocalFileTabView.this.J.setSelectedChild(i3, i17 - 2, true);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSelect(final int i3) {
        if (this.P.getGroupCount() <= i3) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.12
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseLocalFileTabView qfileBaseLocalFileTabView = QfileBaseLocalFileTabView.this;
                qfileBaseLocalFileTabView.f206603d.U3(qfileBaseLocalFileTabView);
                QfileBaseLocalFileTabView qfileBaseLocalFileTabView2 = QfileBaseLocalFileTabView.this;
                if (qfileBaseLocalFileTabView2.J != null && ((QfileBaseTabView) qfileBaseLocalFileTabView2).f206606h) {
                    QfileBaseLocalFileTabView.this.J.expandGroup(i3);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void y() {
        F(R.layout.alw);
        this.f206603d.V2().s0();
        this.L = LayoutInflater.from(o());
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.f206619c0);
        h0();
        ob1.d c06 = c0();
        this.P = c06;
        c06.f(this.J);
        g0();
        ob1.d dVar = this.P;
        int i3 = 0;
        if (!(dVar instanceof ob1.e) && !(dVar instanceof QFileDelDownloadAdapter)) {
            this.J.setSelector(R.color.ajr);
            this.J.setAdapter(this.P);
            this.J.setTranscriptMode(0);
            this.J.setWhetherImageTab(false);
            while (i3 < this.P.getGroupCount()) {
                this.J.expandGroup(i3);
                i3++;
            }
        } else {
            this.J.setSelector(R.color.ajr);
            this.J.setAdapter(this.P);
            this.J.setTranscriptMode(0);
            this.J.setWhetherImageTab(true);
            this.J.setGridSize(((ob1.e) this.P).l());
            while (i3 < this.P.getGroupCount()) {
                this.J.expandGroup(i3);
                i3++;
            }
        }
        setLoadAllRecord(true);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        super.z();
        this.M = true;
        Runnable runnable = this.D;
        if (runnable != null) {
            ThreadManagerV2.removeJobFromThreadPool(runnable, 64);
        }
        this.N.clear();
        this.E.clear();
        H();
        if (this.f206619c0 != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206619c0);
        }
    }

    protected void i0() {
    }

    public void m0(boolean z16) {
    }

    public void setTabType(int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(FileInfo fileInfo, boolean z16) {
    }
}

package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.a;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.n;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QfileBaseCloudFileTabView extends QfileBaseTabView {

    /* renamed from: e0, reason: collision with root package name */
    static String f206414e0 = "QfileRecentFileActivity<FileAssistant>";
    public String E;
    protected LinkedHashMap<String, List<WeiYunFileInfo>> F;
    public ViewerMoreRelativeLayout G;
    NoFileRelativeLayout H;
    private PullRefreshHeader I;
    QfilePinnedHeaderExpandableListView J;
    long K;
    LayoutInflater L;
    protected ArrayList<WeiYunFileInfo> M;
    protected ob1.d N;
    int P;
    volatile boolean Q;
    BubblePopupWindow R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    TextView U;
    Drawable V;
    boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public View.OnLongClickListener f206415a0;

    /* renamed from: b0, reason: collision with root package name */
    public View.OnClickListener f206416b0;

    /* renamed from: c0, reason: collision with root package name */
    public View.OnClickListener f206417c0;

    /* renamed from: d0, reason: collision with root package name */
    private FMObserver f206418d0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnLongClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class ViewOnClickListenerC7527a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206424d;

            ViewOnClickListenerC7527a(View view) {
                this.f206424d = view;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeiYunFileInfo weiYunFileInfo;
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = this.f206424d.getTag();
                if (tag instanceof ob1.c) {
                    weiYunFileInfo = (WeiYunFileInfo) ((ob1.c) this.f206424d.getTag()).f422335j;
                } else if (tag instanceof a.C7528a) {
                    weiYunFileInfo = (WeiYunFileInfo) ((a.C7528a) this.f206424d.getTag()).G;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e(QfileBaseCloudFileTabView.f206414e0, 2, "unknow Object");
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
                if (((IWeiyunApi) QRoute.api(IWeiyunApi.class)).isDeletingCloudFile(weiYunFileInfo.f209603d) && QLog.isColorLevel()) {
                    QLog.d(QfileBaseCloudFileTabView.f206414e0, 2, "there is a bug ");
                }
                ((IQQFileEngine) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class, "")).deleteWeiYunFile(weiYunFileInfo);
                QfileBaseCloudFileTabView.this.p0();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements BubblePopupWindow.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f206426d;

            b(View view) {
                this.f206426d = view;
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                this.f206426d.setSelected(false);
            }
        }

        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view != null && !QfileBaseCloudFileTabView.this.v()) {
                z16 = true;
                view.setSelected(true);
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.a(R.id.bf5, view.getContext().getString(R.string.f186873sg));
                QfileBaseCloudFileTabView.this.R = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).showAsDropDown(view, aVar, new ViewOnClickListenerC7527a(view), new b(view));
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WeiYunFileInfo weiYunFileInfo;
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            boolean z16 = false;
            if (tag instanceof a.C7528a) {
                a.C7528a c7528a = (a.C7528a) view.getTag();
                i3 = c7528a.f206471i;
                weiYunFileInfo = (WeiYunFileInfo) c7528a.G;
            } else if (tag instanceof ob1.c) {
                weiYunFileInfo = (WeiYunFileInfo) ((ob1.c) view.getTag()).f422335j;
                i3 = -1;
            } else {
                weiYunFileInfo = null;
                i3 = 0;
            }
            if (weiYunFileInfo != null) {
                if (view.getId() == R.id.c_5 && QfileBaseCloudFileTabView.this.v()) {
                    ReportController.o(((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
                }
                QfileBaseCloudFileTabView qfileBaseCloudFileTabView = QfileBaseCloudFileTabView.this;
                if (view.getId() == R.id.c_5) {
                    z16 = true;
                }
                qfileBaseCloudFileTabView.s0(weiYunFileInfo, i3, z16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements ExpandableListView.OnGroupExpandListener {
        e() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i3) {
            if (i3 == QfileBaseCloudFileTabView.this.N.getGroupCount() - 1) {
                QfileBaseCloudFileTabView qfileBaseCloudFileTabView = QfileBaseCloudFileTabView.this;
                if (qfileBaseCloudFileTabView.G != null) {
                    if (!qfileBaseCloudFileTabView.m0()) {
                        QfileBaseCloudFileTabView.this.G.setVisible();
                    } else {
                        QfileBaseCloudFileTabView.this.G.setGone();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements ExpandableListView.OnGroupCollapseListener {
        f() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupCollapseListener
        public void onGroupCollapse(int i3) {
            ViewerMoreRelativeLayout viewerMoreRelativeLayout;
            if (i3 == QfileBaseCloudFileTabView.this.N.getGroupCount() - 1 && (viewerMoreRelativeLayout = QfileBaseCloudFileTabView.this.G) != null) {
                viewerMoreRelativeLayout.setGone();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QfileBaseCloudFileTabView.this.r0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class h implements ViewTreeObserver.OnGlobalLayoutListener {
        h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QfileBaseCloudFileTabView.this.r0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(QfileBaseCloudFileTabView.f206414e0, 2, "qfilebaserecenttabview del error, tag is null");
                }
            } else {
                WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) view.getTag();
                if (weiYunFileInfo != null) {
                    ob1.d dVar = QfileBaseCloudFileTabView.this.N;
                    if (dVar != null) {
                        dVar.e(null);
                    }
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class, "")).deleteWeiYunFile(weiYunFileInfo);
                }
                ob1.d dVar2 = QfileBaseCloudFileTabView.this.N;
                if (dVar2 != null) {
                    dVar2.e(-1);
                }
                view.setVisibility(4);
                QfileBaseCloudFileTabView.this.setListFooter();
                QfileBaseCloudFileTabView.this.p0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QfileBaseCloudFileTabView.this.w()) {
                QfileBaseCloudFileTabView.this.G();
                QfileBaseCloudFileTabView.this.t0();
                if (QfileBaseCloudFileTabView.this.N.getGroupCount() > 0) {
                    QfileBaseCloudFileTabView.this.J.expandGroup(r0.N.getGroupCount() - 1);
                }
                QfileBaseCloudFileTabView.this.J.setSelection(r0.getAdapter().getCount() - 1);
                ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206606h = false;
                QfileBaseCloudFileTabView.this.o0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QfileBaseCloudFileTabView(Context context) {
        super(context);
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.K = -1L;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = 0;
        this.Q = false;
        this.R = null;
        this.S = new i();
        this.T = new j();
        this.f206415a0 = new a();
        this.f206416b0 = new b();
        this.f206417c0 = new c();
        this.f206418d0 = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.14
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
                        ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(fileManagerEntity);
                        QfileBaseCloudFileTabView.this.C();
                        return;
                    }
                    return;
                }
                if (obj instanceof WeiYunFileInfo) {
                    QfileBaseCloudFileTabView.this.C();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void L(String str, String str2, Integer num, String str3, boolean z16) {
                ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(str);
                ah.A(num.intValue(), str2);
                QfileBaseCloudFileTabView.this.f206603d.X3(false);
            }

            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void M(String str, String str2, boolean z16) {
                ArrayList<WeiYunFileInfo> arrayList;
                if (!QfileBaseCloudFileTabView.this.e0(((IWeiyunApi) QRoute.api(IWeiyunApi.class)).removeDeletedCloudFile(str)) && (arrayList = QfileBaseCloudFileTabView.this.M) != null && arrayList.size() > 0) {
                    Iterator<WeiYunFileInfo> it = QfileBaseCloudFileTabView.this.M.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WeiYunFileInfo next = it.next();
                        if (next.f209603d.equalsIgnoreCase(str)) {
                            QfileBaseCloudFileTabView.this.e0(next);
                            break;
                        }
                    }
                }
                QfileBaseCloudFileTabView.this.f206603d.X3(false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void T(boolean z16, long j3, long j16, String str, int i3) {
                QfileBaseCloudFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseCloudFileTabView.this.p0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            public void s0() {
                super.s0();
                QfileBaseCloudFileTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.14.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileBaseCloudFileTabView.this.p0();
                    }
                });
            }
        };
        this.F = new LinkedHashMap<>();
        this.M = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(WeiYunFileInfo weiYunFileInfo) {
        FileManagerEntity m16 = ah.m1(weiYunFileInfo);
        ((IQQFileEngine) this.f206604e.getRuntimeService(IQQFileEngine.class)).reciveFile(m16);
        ((IQQFileDataCenter) this.f206604e.getRuntimeService(IQQFileDataCenter.class)).insertToFMList(m16);
        h(m16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(FileManagerEntity fileManagerEntity) {
        kc1.a.c(fileManagerEntity).d(false, this.f206603d, new d(fileManagerEntity));
    }

    private void k0() {
        try {
            NoFileRelativeLayout noFileRelativeLayout = new NoFileRelativeLayout(o());
            this.H = noFileRelativeLayout;
            this.J.addHeaderView(noFileRelativeLayout);
            ViewerMoreRelativeLayout viewerMoreRelativeLayout = new ViewerMoreRelativeLayout(o());
            this.G = viewerMoreRelativeLayout;
            viewerMoreRelativeLayout.setOnClickListener(this.T);
            this.G.setGone();
            this.U = (TextView) this.G.findViewById(R.id.kxk);
            this.J.addFooterView(this.G);
            r0();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void l0() {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView = (QfilePinnedHeaderExpandableListView) findViewById(R.id.c_r);
        this.J = qfilePinnedHeaderExpandableListView;
        qfilePinnedHeaderExpandableListView.setSelection(0);
        this.J.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(WeiYunFileInfo weiYunFileInfo, FMDialogUtil.c cVar) {
        if (weiYunFileInfo.f209606h > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize() && ah.X0()) {
            ah.Q1(false, this.f206603d, cVar);
        } else {
            cVar.b();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        if (this.F.size() > 0) {
            p0();
        }
        this.f206603d.G3(false);
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void C() {
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.15
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseCloudFileTabView.this.p0();
            }
        });
    }

    protected abstract boolean d0(WeiYunFileInfo weiYunFileInfo);

    public boolean e0(WeiYunFileInfo weiYunFileInfo) {
        if (weiYunFileInfo == null) {
            return false;
        }
        return d0(weiYunFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0(boolean z16) {
        String str;
        if (this.f206603d.t3() && !z16) {
            if ("document".equals(this.E)) {
                str = "0X8009E6E";
            } else if ("picture".equals(this.E)) {
                str = "0X8009E6F";
            } else if ("video".equals(this.E)) {
                str = "0X8009E70";
            } else if ("music".equals(this.E)) {
                str = "0X8009E71";
            } else {
                str = "0X8009E72";
            }
        } else if (!this.f206603d.t3()) {
            if ("document".equals(this.E)) {
                str = "0X8009E61";
            } else if ("picture".equals(this.E)) {
                str = "0X8009E62";
            } else if ("video".equals(this.E)) {
                str = "0X8009E63";
            } else if ("music".equals(this.E)) {
                str = "0X8009E64";
            } else {
                str = "0X8009E65";
            }
        } else {
            str = "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(this.f206604e, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    protected abstract ob1.d i0();

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<WeiYunFileInfo> j0(WeiYunFileInfo weiYunFileInfo) {
        if (this.M.size() <= 250) {
            return this.M;
        }
        int indexOf = this.M.indexOf(weiYunFileInfo);
        int i3 = 0;
        if (indexOf == -1) {
            if (QLog.isColorLevel()) {
                QLog.i(f206414e0, 1, "can not find the clicked weiYunFileInfo. targetInfo fileId[" + weiYunFileInfo.f209603d + "]");
            }
            indexOf = 0;
        }
        if (indexOf >= 100) {
            i3 = indexOf - 100;
        }
        int i16 = indexOf + 100;
        if (this.M.size() - 1 < i16) {
            i16 = this.M.size() - 1;
        }
        return new ArrayList<>(this.M.subList(i3, i16));
    }

    public abstract boolean m0();

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int p() {
        return this.G.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0() {
        LinkedHashMap<String, List<WeiYunFileInfo>> linkedHashMap = this.F;
        if ((linkedHashMap == null || linkedHashMap.size() == 0) && m0()) {
            if (this.f206603d.t3()) {
                this.H.setTopViewHeight(1.0f);
            }
            this.H.setVisible(true);
            this.G.setGone();
        } else {
            NoFileRelativeLayout noFileRelativeLayout = this.H;
            if (noFileRelativeLayout != null) {
                noFileRelativeLayout.setGone();
                this.J.removeHeaderView(this.H);
            }
        }
        this.N.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public ListView q() {
        return this.J;
    }

    protected void r0() {
        this.H.setLayoutParams(this.J.getWidth(), this.f206603d.getWindow().getDecorView().getHeight() / 2);
    }

    public void s0(WeiYunFileInfo weiYunFileInfo, int i3, boolean z16) {
        if (v() && !z16) {
            if (com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo)) {
                com.tencent.mobileqq.filemanager.data.f.I(weiYunFileInfo);
            } else {
                com.tencent.mobileqq.filemanager.data.f.e(weiYunFileInfo);
                this.f206603d.G3(true);
                if (this.f206603d.j3() && !com.tencent.mobileqq.filemanager.data.f.w(com.tencent.mobileqq.filemanager.data.f.f207766l)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0i);
                    createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                    com.tencent.mobileqq.filemanager.data.f.L(com.tencent.mobileqq.filemanager.data.f.f207766l);
                    FileManagerReporter.addData("0X800942F");
                }
            }
            k();
            p0();
        } else if (!w()) {
            if (QLog.isColorLevel()) {
                QLog.i(f206414e0, 2, "click too fast , wait a minute.");
                return;
            }
            return;
        } else {
            G();
            ((IFileManagerReporter) QRoute.api(IFileManagerReporter.class)).addData("0X8004AE6");
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openWeiYunFileBrowser(this.f206603d, j0(weiYunFileInfo), weiYunFileInfo);
        }
        f0(v());
    }

    public void setListFooter() {
        ob1.d dVar = this.N;
        if (!(dVar instanceof ob1.g) && dVar.getGroupCount() > 0 && this.J.isGroupExpanded(this.N.getGroupCount() - 1) && this.G != null) {
            if (!m0()) {
                this.G.setVisible();
            } else {
                this.G.setGone();
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSelect(final int i3) {
        if (this.N.getGroupCount() <= i3) {
            if (QLog.isColorLevel()) {
                QLog.e(f206414e0, 1, "setSelect[" + i3 + "] faild,becouse GroupCount[" + this.N.getGroupCount() + "]");
                return;
            }
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.16
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseCloudFileTabView qfileBaseCloudFileTabView = QfileBaseCloudFileTabView.this;
                qfileBaseCloudFileTabView.f206603d.U3(qfileBaseCloudFileTabView);
                QfileBaseCloudFileTabView qfileBaseCloudFileTabView2 = QfileBaseCloudFileTabView.this;
                if (qfileBaseCloudFileTabView2.J != null && ((QfileBaseTabView) qfileBaseCloudFileTabView2).f206606h) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QfileBaseCloudFileTabView.f206414e0, 2, "setSelect[" + i3 + "] success mFileListView");
                    }
                    QfileBaseCloudFileTabView.this.J.expandGroup(i3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t0() {
        if (this.U != null && this.V == null) {
            Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
            this.V = drawable;
            this.U.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ((Animatable) this.V).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0() {
        Object obj;
        this.W = false;
        if (this.U != null && (obj = this.V) != null) {
            ((Animatable) obj).stop();
            this.V = null;
            this.U.setCompoundDrawables(null, null, null, null);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void y() {
        F(R.layout.alw);
        this.L = LayoutInflater.from(o());
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.f206418d0);
        l0();
        ob1.d i06 = i0();
        this.N = i06;
        i06.f(this.J);
        k0();
        if (this.N instanceof ob1.g) {
            this.J.setSelector(R.color.ajr);
            this.J.setAdapter(this.N);
            this.J.setTranscriptMode(0);
            this.J.setWhetherImageTab(true);
            this.J.setGridSize(((ob1.g) this.N).l());
            for (int i3 = 0; i3 < this.N.getGroupCount(); i3++) {
                this.J.expandGroup(i3);
            }
        } else {
            this.J.setOnGroupExpandListener(new e());
            this.J.setOnGroupCollapseListener(new f());
            this.J.setSelector(R.color.ajr);
            this.J.setAdapter(this.N);
            this.J.setTranscriptMode(0);
            this.J.setWhetherImageTab(false);
            for (int i16 = 0; i16 < this.N.getGroupCount(); i16++) {
                this.J.expandGroup(i16);
            }
        }
        this.J.smoothScrollToPosition(0);
        this.J.setStackFromBottom(false);
        this.J.setTranscriptMode(0);
        if (this.N instanceof ob1.g) {
            this.J.getViewTreeObserver().addOnGlobalLayoutListener(new g());
            if (this.G == null) {
                this.G = new ViewerMoreRelativeLayout(getContext());
            }
            this.U = (TextView) this.G.findViewById(R.id.kxk);
            this.G.setOnClickListener(this.T);
            this.G.setGone();
            return;
        }
        this.J.getViewTreeObserver().addOnGlobalLayoutListener(new h());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        super.z();
        B();
        this.M.clear();
        this.F.clear();
        H();
        if (this.f206418d0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f206414e0, 2, "onDestroy, del fmObserver");
            }
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206418d0);
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
            a.C7528a c7528a = (a.C7528a) view.getTag();
            WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) c7528a.G;
            FileManagerEntity queryByFileIdForMemory = ((IQQFileDataCenter) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileDataCenter.class, "")).queryByFileIdForMemory(weiYunFileInfo.f209603d);
            if (queryByFileIdForMemory != null) {
                int i3 = c7528a.f206471i;
                if (i3 == 1) {
                    QfileBaseCloudFileTabView.this.f206603d.U2().a();
                    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                    } else {
                        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).doWithWifiChecked(queryByFileIdForMemory, false, QfileBaseCloudFileTabView.this.f206603d, new a(queryByFileIdForMemory));
                    }
                } else if (i3 == 3) {
                    QfileBaseCloudFileTabView.this.f206603d.U2().j0();
                    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        QfileBaseCloudFileTabView.this.h0(queryByFileIdForMemory);
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
                    }
                } else if (i3 == 0) {
                    QfileBaseCloudFileTabView.this.f206603d.U2().onPreviewClick();
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "file_viewer_in";
                    aVar.f209158c = 73;
                    aVar.f209159d = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(queryByFileIdForMemory.fileName);
                    aVar.f209160e = queryByFileIdForMemory.fileSize;
                    FileManagerReporter.addData(((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getCurrentAccountUin(), aVar);
                    ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                    forwardFileInfo.w(queryByFileIdForMemory.getCloudType());
                    forwardFileInfo.N(10001);
                    forwardFileInfo.E(queryByFileIdForMemory.nSessionId);
                    forwardFileInfo.V(queryByFileIdForMemory.uniseq);
                    forwardFileInfo.y(queryByFileIdForMemory.fileName);
                    forwardFileInfo.z(queryByFileIdForMemory.fileSize);
                    forwardFileInfo.Z(queryByFileIdForMemory.Uuid);
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openRencentFileBrowser(QfileBaseCloudFileTabView.this.o(), forwardFileInfo);
                } else if (i3 == 2) {
                    QfileBaseCloudFileTabView.this.f206603d.U2().e();
                    ((IQQFileEngine) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class, "")).pause(queryByFileIdForMemory.nSessionId);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            QfileBaseCloudFileTabView.this.f206603d.U2().a();
            QfileBaseCloudFileTabView.this.n0(weiYunFileInfo, new b(weiYunFileInfo));
            QfileBaseCloudFileTabView.this.C();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FileManagerEntity f206430a;

            a(FileManagerEntity fileManagerEntity) {
                this.f206430a = fileManagerEntity;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                ((IQQFileEngine) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class, "")).resume(this.f206430a.nSessionId);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeiYunFileInfo f206432a;

            b(WeiYunFileInfo weiYunFileInfo) {
                this.f206432a = weiYunFileInfo;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                QfileBaseCloudFileTabView.this.g0(this.f206432a);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f206434a;

        d(FileManagerEntity fileManagerEntity) {
            this.f206434a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ((IQQFileEngine) ((QfileBaseTabView) QfileBaseCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).resume(this.f206434a.nSessionId);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    protected void o0() {
    }

    public void q0(boolean z16) {
    }
}

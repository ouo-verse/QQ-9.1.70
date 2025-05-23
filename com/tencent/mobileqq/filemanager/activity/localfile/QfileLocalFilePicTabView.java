package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.m;
import com.tencent.mobileqq.filemanager.util.p;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.guild.api.IGuildFileApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import ob1.d;
import ob1.e;

/* loaded from: classes12.dex */
public class QfileLocalFilePicTabView extends QfileBaseLocalFileTabView {

    /* renamed from: f0, reason: collision with root package name */
    private t f206673f0;

    /* renamed from: g0, reason: collision with root package name */
    e f206674g0;

    /* renamed from: h0, reason: collision with root package name */
    d.InterfaceC10897d f206675h0;

    /* renamed from: i0, reason: collision with root package name */
    protected QfilePinnedHeaderExpandableListView.a f206676i0;

    /* renamed from: j0, reason: collision with root package name */
    private View.OnClickListener f206677j0;

    /* renamed from: k0, reason: collision with root package name */
    private View.OnClickListener f206678k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements Function2<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(HashMap<String, ArrayList<FileInfo>> hashMap, ArrayList<FileInfo> arrayList) {
            QfileLocalFilePicTabView qfileLocalFilePicTabView = QfileLocalFilePicTabView.this;
            qfileLocalFilePicTabView.N = arrayList;
            SharedPreferences sharedPreferences = qfileLocalFilePicTabView.f206603d.getSharedPreferences("LAST_CHOOSE_", 0);
            int i3 = sharedPreferences.getInt("GROUP", -1);
            int i16 = sharedPreferences.getInt("CHILD", -1);
            QfileLocalFilePicTabView.this.E.clear();
            QfileLocalFilePicTabView.this.E.putAll(hashMap);
            QfileLocalFilePicTabView.this.C();
            if (i3 != -1 && i16 != -1) {
                if (!QfileLocalFilePicTabView.this.f206603d.u3() && !QfileLocalFilePicTabView.this.f206603d.s3()) {
                    QfileLocalFilePicTabView.this.setSelect(0);
                } else {
                    QfileLocalFilePicTabView.this.setPos(i3, i16);
                }
                return null;
            }
            QfileLocalFilePicTabView.this.setSelect(0);
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class b implements QfilePinnedHeaderExpandableListView.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f206685a;

        /* renamed from: b, reason: collision with root package name */
        private int f206686b;

        /* renamed from: c, reason: collision with root package name */
        private int f206687c;

        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void a(int i3, int i16) {
            if (QfileLocalFilePicTabView.this.f206603d.u3() || QfileLocalFilePicTabView.this.f206603d.s3()) {
                SharedPreferences.Editor edit = QfileLocalFilePicTabView.this.f206603d.getSharedPreferences("LAST_CHOOSE_", 0).edit();
                edit.putInt("GROUP", i3);
                edit.putInt("CHILD", (i16 + 1) / 4);
                edit.commit();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void b(int i3, int i16) {
            this.f206685a = false;
            this.f206686b = Integer.MIN_VALUE;
            this.f206687c = Integer.MAX_VALUE;
            FileInfo fileInfo = (FileInfo) QfileLocalFilePicTabView.this.P.getChild(i3, i16);
            if (fileInfo == null) {
                return;
            }
            boolean z16 = !f.C(fileInfo);
            this.f206685a = z16;
            if (QfileLocalFilePicTabView.this.x0(fileInfo, z16)) {
                QfileLocalFilePicTabView.this.C0();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void c(boolean z16) {
            if (z16) {
                URLDrawable.pause();
            } else {
                URLDrawable.resume();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void d(int i3, int i16, int i17, int i18) {
            if (i3 != i17) {
                return;
            }
            int min = Math.min(i16, i18);
            int max = Math.max(i16, i18);
            if (i18 < i16) {
                this.f206687c = Math.min(i18, this.f206687c);
            } else {
                this.f206686b = Math.max(i18, this.f206686b);
            }
            for (int i19 = min; i19 <= max; i19++) {
                QfileLocalFilePicTabView qfileLocalFilePicTabView = QfileLocalFilePicTabView.this;
                qfileLocalFilePicTabView.x0((FileInfo) qfileLocalFilePicTabView.P.getChild(i3, i19), this.f206685a);
            }
            for (int i26 = this.f206687c; i26 < min; i26++) {
                QfileLocalFilePicTabView qfileLocalFilePicTabView2 = QfileLocalFilePicTabView.this;
                qfileLocalFilePicTabView2.x0((FileInfo) qfileLocalFilePicTabView2.P.getChild(i3, i26), !this.f206685a);
            }
            while (true) {
                max++;
                if (max <= this.f206686b) {
                    QfileLocalFilePicTabView qfileLocalFilePicTabView3 = QfileLocalFilePicTabView.this;
                    qfileLocalFilePicTabView3.x0((FileInfo) qfileLocalFilePicTabView3.P.getChild(i3, max), !this.f206685a);
                } else {
                    QfileLocalFilePicTabView.this.C0();
                    return;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileLocalFilePicTabView.this.y0(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileLocalFilePicTabView.this.y0(view, true);
            view.sendAccessibilityEvent(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QfileLocalFilePicTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        this.f206673f0 = null;
        this.f206675h0 = null;
        this.f206676i0 = new b();
        this.f206677j0 = new c();
        this.f206678k0 = new d();
        setEditbarButton(true, false, true, true, true);
        this.D = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<FileInfo> B0 = QfileLocalFilePicTabView.this.B0();
                final Map A0 = QfileLocalFilePicTabView.this.A0(B0);
                QfileLocalFilePicTabView qfileLocalFilePicTabView = QfileLocalFilePicTabView.this;
                qfileLocalFilePicTabView.N = B0;
                SharedPreferences sharedPreferences = qfileLocalFilePicTabView.f206603d.getSharedPreferences("LAST_CHOOSE_", 0);
                final int i3 = sharedPreferences.getInt("GROUP", -1);
                final int i16 = sharedPreferences.getInt("CHILD", -1);
                QfileLocalFilePicTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileLocalFilePicTabView.this.E.clear();
                        QfileLocalFilePicTabView.this.E.putAll(A0);
                        QfileLocalFilePicTabView.this.C();
                        if (i3 != -1 && i16 != -1) {
                            if (!QfileLocalFilePicTabView.this.f206603d.u3() && !QfileLocalFilePicTabView.this.f206603d.s3()) {
                                QfileLocalFilePicTabView.this.setSelect(0);
                                return;
                            } else {
                                QfileLocalFilePicTabView.this.setPos(i3, i16);
                                return;
                            }
                        }
                        QfileLocalFilePicTabView.this.setSelect(0);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<FileInfo>> A0(ArrayList<FileInfo> arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HardCodeUtil.qqStr(R.string.f187103t3), new ArrayList());
        linkedHashMap.put(HardCodeUtil.qqStr(R.string.f186993ss), new ArrayList());
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            if (next.getType() == 0) {
                String f16 = next.f();
                if (TextUtils.isEmpty(f16) || f16.equalsIgnoreCase("QQfile_recv") || f16.equalsIgnoreCase("QQ")) {
                    f16 = HardCodeUtil.qqStr(R.string.f186993ss);
                }
                if (f16.equalsIgnoreCase("camera")) {
                    f16 = HardCodeUtil.qqStr(R.string.f187103t3);
                }
                if (!linkedHashMap.containsKey(f16)) {
                    linkedHashMap.put(f16, new ArrayList());
                }
                ((List) linkedHashMap.get(f16)).add(next);
            }
        }
        if (((FMActivity) this.f206603d).p4() == 1) {
            String qqStr = HardCodeUtil.qqStr(R.string.f187293tl);
            linkedHashMap.put(qqStr, new ArrayList());
            HashMap hashMap = new HashMap();
            FileCategoryUtil.u(true, ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(AppConstants.SDCARD_PATH) + "/chatpic/chatimg/", "", "", hashMap, null);
            Iterator it5 = hashMap.keySet().iterator();
            while (it5.hasNext()) {
                ((List) linkedHashMap.get(qqStr)).addAll((List) hashMap.get((String) it5.next()));
            }
        }
        Iterator it6 = linkedHashMap.keySet().iterator();
        while (it6.hasNext()) {
            if (((List) linkedHashMap.get((String) it6.next())).size() == 0) {
                it6.remove();
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<FileInfo> B0() {
        HashMap hashMap;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.G) {
            hashMap = (HashMap) FileCategoryUtil.o(this.f206603d);
        } else {
            hashMap = null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Iterator<QfileTabBarView.h> it = this.F.iterator();
        while (it.hasNext()) {
            FileCategoryUtil.u(true, it.next().a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", hashMap, this);
        }
        long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
        p.d(uptimeMillis2, uptimeMillis3 - uptimeMillis2, uptimeMillis3, false);
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.N);
        if (c()) {
            return arrayList;
        }
        FileCategoryUtil.v(hashMap);
        for (String str : hashMap.keySet()) {
            if (!"QQfile_recv".equalsIgnoreCase(str)) {
                arrayList.addAll((List) hashMap.get(str));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x0(FileInfo fileInfo, boolean z16) {
        if (fileInfo == null) {
            return false;
        }
        if (v() && ((f.C(fileInfo) && z16) || (!f.C(fileInfo) && !z16))) {
            return false;
        }
        if (v()) {
            if (z16) {
                d.InterfaceC10897d interfaceC10897d = this.f206675h0;
                if (interfaceC10897d != null) {
                    interfaceC10897d.a(fileInfo, true);
                }
                f.c(fileInfo);
            } else {
                d.InterfaceC10897d interfaceC10897d2 = this.f206675h0;
                if (interfaceC10897d2 != null) {
                    interfaceC10897d2.a(fileInfo, false);
                }
                f.G(fileInfo);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(View view, boolean z16) {
        ob1.c cVar = (ob1.c) view.getTag();
        FileInfo fileInfo = (FileInfo) cVar.f422335j;
        AsyncImageView asyncImageView = cVar.f422326a;
        if (fileInfo == null) {
            return;
        }
        if (this.f206603d.u3() || this.f206603d.s3()) {
            SharedPreferences.Editor edit = this.f206603d.getSharedPreferences("LAST_CHOOSE_", 0).edit();
            edit.putInt("GROUP", cVar.f422334i);
            edit.putInt("CHILD", (cVar.f422333h + 1) / 4);
            edit.commit();
        }
        if (z16) {
            if (f.C(fileInfo)) {
                f.G(fileInfo);
                k0(fileInfo, false);
            } else {
                f.c(fileInfo);
                k0(fileInfo, true);
                if (this.f206603d.j3() && !f.w(f.f207765k) && !f.z(fileInfo)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0g);
                    createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                    f.L(f.f207765k);
                    FileManagerReporter.addData("0X800942D");
                }
            }
            this.f206603d.G3(true);
            if (this.f206603d.f206192z0 && !FileUtils.fileExistsAndNotEmpty(fileInfo.k())) {
                com.tencent.mobileqq.filemanager.util.d.f(ah.y(fileInfo.j()) + HardCodeUtil.qqStr(R.string.f187013su));
                f.G(fileInfo);
            } else if (this.f206603d.A0 && !((IGuildFileApi) QRoute.api(IGuildFileApi.class)).isLegalForSelectedFileName(fileInfo.j())) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.f187133t6));
                f.G(fileInfo);
            }
            l0();
            k();
            V();
        } else {
            if (!w()) {
                if (QLog.isColorLevel()) {
                    QLog.i(QfileBaseLocalFileTabView.f206616e0, 2, "click too fast , wait a minute.");
                    return;
                }
                return;
            }
            if (v()) {
                ReportController.o(this.f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
            }
            G();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.f206603d, this.E, fileInfo, asyncImageView, ah.k1(fileInfo));
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

    private void z0() {
        boolean z16 = true;
        if (((FMActivity) this.f206603d).p4() != 1) {
            z16 = false;
        }
        FileInfoLoader.f206609a.r(z16, new LoadParam(this.F, this.G, 0), new a());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(true, false, true, true, true);
        if (!this.f206603d.v3()) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().q0();
            } else {
                this.f206603d.U2().R();
            }
        }
        f0();
        this.J.setOnIndexChangedListener(this.f206676i0);
    }

    public void C0() {
        this.f206603d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.4
            @Override // java.lang.Runnable
            public void run() {
                QfileLocalFilePicTabView.this.k();
                QfileLocalFilePicTabView.this.l0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D0(d.InterfaceC10897d interfaceC10897d) {
        this.f206675h0 = interfaceC10897d;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected boolean X(FileInfo fileInfo) {
        String f16 = fileInfo.f();
        this.N.remove(fileInfo);
        if (!this.E.containsKey(f16)) {
            QLog.e(QfileBaseLocalFileTabView.f206616e0, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
            return false;
        }
        this.E.get(f16).remove(fileInfo);
        C();
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected ob1.d c0() {
        e eVar = new e(o(), this.E, this.U, this.f206678k0, this.f206677j0, this.W, this.f206618b0);
        this.f206674g0 = eVar;
        return eVar;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void e0() {
        boolean c16 = m.c();
        QLog.d(QfileBaseLocalFileTabView.f206616e0, 1, "getRecentFileRecords isUseNewTech=" + c16);
        if (c16) {
            z0();
            return;
        }
        Runnable runnable = this.D;
        if (runnable != null) {
            ThreadManagerV2.excute(runnable, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    public boolean j0() {
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void n(Set<FileInfo> set) {
        if (set != null && set.size() != 0) {
            Iterator<FileInfo> it = set.iterator();
            while (it.hasNext()) {
                X(it.next());
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void n0(final FileInfo fileInfo) {
        if (!this.N.contains(fileInfo)) {
            this.N.add(fileInfo);
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.3
            @Override // java.lang.Runnable
            public void run() {
                String f16 = fileInfo.f();
                if (!QfileLocalFilePicTabView.this.E.containsKey(f16)) {
                    QfileLocalFilePicTabView.this.E.put(f16, new ArrayList());
                }
                List<FileInfo> list = QfileLocalFilePicTabView.this.E.get(fileInfo.f());
                if (list.contains(fileInfo)) {
                    return;
                }
                int U = QfileLocalFilePicTabView.this.U(list, fileInfo.e());
                if (U < 0) {
                    U = 0;
                }
                list.add(U, fileInfo);
                QfileLocalFilePicTabView.this.C();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView;
        super.onConfigurationChanged(configuration);
        ob1.d dVar = this.P;
        if (dVar != null && (qfilePinnedHeaderExpandableListView = this.J) != null && (dVar instanceof e)) {
            e eVar = (e) dVar;
            qfilePinnedHeaderExpandableListView.setGridSize(eVar.l());
            eVar.p();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, qb1.f
    public void d(FileInfo fileInfo) {
    }
}

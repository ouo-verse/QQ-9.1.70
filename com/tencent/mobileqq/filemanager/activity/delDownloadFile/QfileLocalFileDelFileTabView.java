package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.Context;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.filescan.api.IStorageScanApi;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileLocalFileDelFileTabView extends QfileLocalFileDocTabView implements d.InterfaceC10897d {

    /* renamed from: f0, reason: collision with root package name */
    LinkedHashMap<String, List<FileInfo>> f206478f0;

    /* renamed from: g0, reason: collision with root package name */
    LinkedHashMap<String, List<FileInfo>> f206479g0;

    /* renamed from: h0, reason: collision with root package name */
    List<FileInfo> f206480h0;

    /* renamed from: i0, reason: collision with root package name */
    List<String> f206481i0;

    /* renamed from: j0, reason: collision with root package name */
    int f206482j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f206483k0;

    /* renamed from: l0, reason: collision with root package name */
    int f206484l0;

    /* renamed from: m0, reason: collision with root package name */
    final int f206485m0;

    /* renamed from: n0, reason: collision with root package name */
    List<FileInfo> f206486n0;

    /* renamed from: o0, reason: collision with root package name */
    private HighFreqLogUtil f206487o0;

    /* renamed from: p0, reason: collision with root package name */
    private Runnable f206488p0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements Runnable {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView$1$a */
        /* loaded from: classes12.dex */
        class a implements Comparator<Long> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Long l3, Long l16) {
                if (l3.equals(l16)) {
                    return 1;
                }
                return (int) (l3.longValue() - l16.longValue());
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView = QfileLocalFileDelFileTabView.this;
            if (qfileLocalFileDelFileTabView.f206483k0) {
                QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView getRecentFileRecords isRunning mSearchType is " + QfileLocalFileDelFileTabView.this.f206482j0);
                return;
            }
            qfileLocalFileDelFileTabView.f206483k0 = true;
            ((QfileBaseLocalFileTabView) qfileLocalFileDelFileTabView).R = true;
            QfileLocalFileDelFileTabView.this.f206484l0 = 0;
            final TreeMap treeMap = new TreeMap(new a());
            ArrayList arrayList = new ArrayList();
            Iterator it = ((QfileBaseLocalFileTabView) QfileLocalFileDelFileTabView.this).F.iterator();
            while (it.hasNext()) {
                arrayList.add(((QfileTabBarView.h) it.next()).a());
            }
            QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView getRecentFileRecords begin loadFileDataByType mSearchType is " + QfileLocalFileDelFileTabView.this.f206482j0);
            IStorageScanApi iStorageScanApi = (IStorageScanApi) QRoute.api(IStorageScanApi.class);
            QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView2 = QfileLocalFileDelFileTabView.this;
            iStorageScanApi.loadFileDataByType(arrayList, qfileLocalFileDelFileTabView2.f206482j0, ((QfileBaseTabView) qfileLocalFileDelFileTabView2).f206607i, new t81.a() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.1.2
                @Override // t81.a
                public void a(List<String> list, List<Long> list2, int i3) {
                    QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView type:" + i3 + " ,filePathList size:" + list.size() + " ,fileSizeList size: " + list2.size());
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        FileInfo b16 = FileInfo.b(list.get(i16));
                        if (b16 == null) {
                            QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView FileInfo is null. path:" + list.get(i16));
                        } else {
                            b16.w(true);
                            b16.A(list2.get(i16).longValue());
                            treeMap.put(Long.valueOf(b16.l()), b16);
                            if (treeMap.size() > 1000) {
                                treeMap.pollFirstEntry();
                                ((QfileBaseLocalFileTabView) QfileLocalFileDelFileTabView.this).R = false;
                            }
                        }
                    }
                    QfileLocalFileDelFileTabView.this.f206478f0.clear();
                    QfileLocalFileDelFileTabView.this.f206479g0.clear();
                    QfileLocalFileDelFileTabView.this.f206480h0.clear();
                    TreeMap treeMap2 = treeMap;
                    QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView3 = QfileLocalFileDelFileTabView.this;
                    ah.E0(treeMap2, qfileLocalFileDelFileTabView3.f206482j0, qfileLocalFileDelFileTabView3.f206478f0, qfileLocalFileDelFileTabView3.f206479g0, qfileLocalFileDelFileTabView3.f206480h0);
                    QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView4 = QfileLocalFileDelFileTabView.this;
                    qfileLocalFileDelFileTabView4.f206483k0 = false;
                    qfileLocalFileDelFileTabView4.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.1.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView5 = QfileLocalFileDelFileTabView.this;
                            qfileLocalFileDelFileTabView5.setSortType(((QfileBaseTabView) qfileLocalFileDelFileTabView5).f206607i);
                        }
                    });
                }
            });
        }
    }

    public QfileLocalFileDelFileTabView(Context context, List<QfileTabBarView.h> list, int i3) {
        super(context, list, false);
        this.f206478f0 = new LinkedHashMap<>();
        this.f206479g0 = new LinkedHashMap<>();
        this.f206480h0 = new ArrayList();
        this.f206481i0 = new ArrayList();
        this.f206483k0 = false;
        this.f206484l0 = 0;
        this.f206485m0 = 1000;
        this.f206486n0 = new ArrayList();
        this.f206487o0 = new HighFreqLogUtil(2);
        this.f206488p0 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView del success, reloadData mSearchType is " + QfileLocalFileDelFileTabView.this.f206482j0);
                QfileLocalFileDelFileTabView qfileLocalFileDelFileTabView = QfileLocalFileDelFileTabView.this;
                qfileLocalFileDelFileTabView.o0(qfileLocalFileDelFileTabView.f206482j0);
            }
        };
        this.f206607i = 1;
        this.f206482j0 = i3;
        e0();
    }

    private boolean A0(FileInfo fileInfo) {
        try {
            String g16 = g(fileInfo);
            if (new File(g16).exists()) {
                return true;
            }
            String str = "file not exists";
            if (QLog.isColorLevel()) {
                str = "file not exists" + ProgressTracer.SEPARATOR + g16;
            }
            this.f206487o0.w("delDownloadFiles<FileAssistant>", 1, str);
            return false;
        } catch (Exception e16) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + e16.toString());
            return false;
        }
    }

    private String B0() {
        int i3 = this.f206482j0;
        if (i3 == 3) {
            return HardCodeUtil.qqStr(R.string.bab);
        }
        if (i3 == 5) {
            return HardCodeUtil.qqStr(R.string.baa);
        }
        return HardCodeUtil.qqStr(R.string.f1354701j);
    }

    private int C0() {
        int i3 = this.f206482j0;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 == 11) {
                    return 5;
                }
                return -1;
            }
            return 4;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        int i3;
        super.A();
        this.f206603d.U3(this);
        this.J.setOnGroupClickListener(null);
        List<FileInfo> list = this.f206480h0;
        boolean z16 = false;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        BaseFileAssistantActivity o16 = o();
        if (i3 == 0 || this.f206484l0 < i3) {
            z16 = true;
        }
        o16.S3(z16);
    }

    @Override // ob1.d.InterfaceC10897d
    public void a(FileInfo fileInfo, boolean z16) {
        boolean z17 = true;
        if (z16) {
            this.f206484l0++;
            this.f206486n0.add(fileInfo);
        } else {
            this.f206484l0--;
            this.f206486n0.remove(fileInfo);
        }
        BaseFileAssistantActivity o16 = o();
        int i3 = this.f206484l0;
        if (i3 != 0 && i3 >= this.f206480h0.size()) {
            z17 = false;
        }
        o16.S3(z17);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void b() {
        this.f206484l0 = 0;
        this.f206486n0.clear();
        super.b();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected d c0() {
        com.tencent.mobileqq.filemanager.activity.localfile.d dVar = new com.tencent.mobileqq.filemanager.activity.localfile.d(o(), this.E, o(), this.U, this.f206617a0, this.W, this.f206618b0);
        dVar.h(this);
        return dVar;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void e() {
        this.f206484l0 = this.f206480h0.size();
        this.f206486n0.addAll(this.f206480h0);
        long t16 = f.t() / 1048576;
        ReportController.o(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", C0(), 0, "" + this.f206484l0, "" + t16, "", "");
        super.e();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void e0() {
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView getRecentFileRecords mSearchType is " + this.f206482j0);
        setEditbarButton(false, false, false, false, true);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.D = anonymousClass1;
        ThreadManagerV2.executeOnFileThread(anonymousClass1);
    }

    @Override // ob1.d.InterfaceC10897d
    public String g(FileInfo fileInfo) {
        if (fileInfo == null) {
            return "";
        }
        String k3 = fileInfo.k();
        if (fileInfo.o()) {
            try {
                return this.f206481i0.get(Integer.parseInt(k3)) + fileInfo.j();
            } catch (Exception unused) {
            }
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public boolean j() {
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView addFootViewHolder");
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void k0(FileInfo fileInfo, boolean z16) {
        super.k0(fileInfo, z16);
        a(fileInfo, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void n(Set<FileInfo> set) {
        if (this.f206486n0.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j16 = 0;
        for (FileInfo fileInfo : this.f206486n0) {
            if (A0(fileInfo)) {
                set.remove(fileInfo);
                arrayList.add(fileInfo.k());
                j3 += fileInfo.l();
                j16++;
            }
        }
        ((IStorageScanApi) QRoute.api(IStorageScanApi.class)).onNTFileDelete(arrayList, this.f206488p0);
        this.f206486n0.clear();
        ReportController.o(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", C0(), 0, "" + j16, "" + (j3 / 1048576), "", "");
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        V();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int[] s() {
        if (this.f206482j0 == 5) {
            return new int[]{1, 0};
        }
        return new int[]{1, 0, 2};
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSortType(int i3) {
        super.setSortType(i3);
        this.E.clear();
        int i16 = this.f206607i;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    ReportController.o(null, "dc00898", "", "", "0X800A0CA", "0X800A0CA", C0(), 0, "", "", "", "");
                    this.E.putAll(this.f206479g0);
                }
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", C0(), 0, "", "", "", "");
                if (this.f206480h0.size() > 0) {
                    this.E.put(FileCategoryUtil.h(this.R, this.Q, this.f206480h0.size(), B0(), HardCodeUtil.qqStr(R.string.zyo)), this.f206480h0);
                }
            }
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", C0(), 0, "", "", "", "");
            this.E.putAll(this.f206478f0);
        }
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView setSortType refreshUI mSearchType is " + this.f206482j0);
        C();
        a0(0);
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView setSortType refreshUI done mSearchType is " + this.f206482j0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public boolean x(Set<FileInfo> set) {
        if (this.f206486n0.size() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        super.z();
        this.f206488p0 = null;
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelFileTabView onDestroy");
        ((IStorageScanApi) QRoute.api(IStorageScanApi.class)).clearFilePathKeyMap("QfileLocalFileDelFileTabView");
    }
}

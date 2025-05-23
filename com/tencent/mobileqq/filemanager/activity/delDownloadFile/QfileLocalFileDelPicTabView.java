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
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.w;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import ob1.d;

/* loaded from: classes12.dex */
public class QfileLocalFileDelPicTabView extends QfileLocalFilePicTabView implements d.InterfaceC10897d {

    /* renamed from: l0, reason: collision with root package name */
    LinkedHashMap<String, List<FileInfo>> f206504l0;

    /* renamed from: m0, reason: collision with root package name */
    List<FileInfo> f206505m0;

    /* renamed from: n0, reason: collision with root package name */
    List<String> f206506n0;

    /* renamed from: o0, reason: collision with root package name */
    boolean f206507o0;

    /* renamed from: p0, reason: collision with root package name */
    int f206508p0;

    /* renamed from: q0, reason: collision with root package name */
    final int f206509q0;

    /* renamed from: r0, reason: collision with root package name */
    List<FileInfo> f206510r0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView$1$a */
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
            if (QfileLocalFileDelPicTabView.this.f206507o0) {
                QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView getRecentFileRecords isRunning");
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            QfileLocalFileDelPicTabView qfileLocalFileDelPicTabView = QfileLocalFileDelPicTabView.this;
            qfileLocalFileDelPicTabView.f206507o0 = true;
            ((QfileBaseLocalFileTabView) qfileLocalFileDelPicTabView).R = true;
            QfileLocalFileDelPicTabView.this.f206508p0 = 0;
            final TreeMap treeMap = new TreeMap(new a());
            ArrayList arrayList = new ArrayList();
            Iterator it = ((QfileBaseLocalFileTabView) QfileLocalFileDelPicTabView.this).F.iterator();
            while (it.hasNext()) {
                arrayList.add(((QfileTabBarView.h) it.next()).a());
            }
            QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView getRecentFileRecords begin loadFileDataByType");
            ((IStorageScanApi) QRoute.api(IStorageScanApi.class)).loadFileDataByType(arrayList, 0, ((QfileBaseTabView) QfileLocalFileDelPicTabView.this).f206607i, new t81.a() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1.2
                @Override // t81.a
                public void a(List<String> list, List<Long> list2, int i3) {
                    QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView, type:" + i3 + " ,filePathList size:" + list.size() + " ,fileSizeList size: " + list2.size());
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        FileInfo b16 = FileInfo.b(list.get(i16));
                        if (b16 == null) {
                            QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView, FileInfo is null. path:" + list.get(i16));
                        } else {
                            b16.v();
                            b16.w(true);
                            b16.A(list2.get(i16).longValue());
                            treeMap.put(Long.valueOf(b16.l()), b16);
                            if (treeMap.size() > 10000) {
                                treeMap.pollFirstEntry();
                                ((QfileBaseLocalFileTabView) QfileLocalFileDelPicTabView.this).R = false;
                            }
                        }
                    }
                    QfileLocalFileDelPicTabView.this.f206504l0.clear();
                    QfileLocalFileDelPicTabView.this.f206505m0.clear();
                    TreeMap treeMap2 = treeMap;
                    QfileLocalFileDelPicTabView qfileLocalFileDelPicTabView2 = QfileLocalFileDelPicTabView.this;
                    ah.E0(treeMap2, 0, qfileLocalFileDelPicTabView2.f206504l0, null, qfileLocalFileDelPicTabView2.f206505m0);
                    QfileLocalFileDelPicTabView qfileLocalFileDelPicTabView3 = QfileLocalFileDelPicTabView.this;
                    qfileLocalFileDelPicTabView3.f206507o0 = false;
                    qfileLocalFileDelPicTabView3.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QfileLocalFileDelPicTabView qfileLocalFileDelPicTabView4 = QfileLocalFileDelPicTabView.this;
                            qfileLocalFileDelPicTabView4.setSortType(((QfileBaseTabView) qfileLocalFileDelPicTabView4).f206607i);
                        }
                    });
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j3 = currentTimeMillis;
                    w.a("storageChatFile", currentTimeMillis2 - j3, j3, currentTimeMillis2, ((QfileBaseTabView) QfileLocalFileDelPicTabView.this).f206604e.getCurrentAccountUin());
                }
            });
        }
    }

    public QfileLocalFileDelPicTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        this.f206504l0 = new LinkedHashMap<>();
        this.f206505m0 = new CopyOnWriteArrayList();
        this.f206506n0 = new CopyOnWriteArrayList();
        this.f206507o0 = false;
        this.f206508p0 = 0;
        this.f206509q0 = 10000;
        this.f206510r0 = new CopyOnWriteArrayList();
        this.f206607i = 1;
        e0();
        D0(this);
    }

    private boolean L0(FileInfo fileInfo) {
        try {
            String g16 = g(fileInfo);
            if (new File(g16).exists()) {
                return true;
            }
            String str = "file not exists";
            if (QLog.isColorLevel()) {
                str = "file not exists" + ProgressTracer.SEPARATOR + g16;
            }
            QLog.w("delDownloadFiles<FileAssistant>", 1, str);
            return false;
        } catch (Exception e16) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + e16.toString());
            return false;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        int i3;
        this.f206603d.U3(this);
        this.f206603d.I2();
        this.J.setOnIndexChangedListener(this.f206676i0);
        List<FileInfo> list = this.f206505m0;
        boolean z16 = false;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        BaseFileAssistantActivity o16 = o();
        if (i3 == 0 || this.f206508p0 < i3) {
            z16 = true;
        }
        o16.S3(z16);
    }

    @Override // ob1.d.InterfaceC10897d
    public void a(FileInfo fileInfo, boolean z16) {
        boolean z17 = true;
        if (z16) {
            this.f206508p0++;
            this.f206510r0.add(fileInfo);
        } else {
            this.f206508p0--;
            this.f206510r0.remove(fileInfo);
        }
        BaseFileAssistantActivity o16 = o();
        int i3 = this.f206508p0;
        if (i3 != 0 && i3 >= this.f206505m0.size()) {
            z17 = false;
        }
        o16.S3(z17);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void b() {
        this.f206508p0 = 0;
        this.f206510r0.clear();
        super.b();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected d c0() {
        QFileDelDownloadAdapter qFileDelDownloadAdapter = new QFileDelDownloadAdapter(o(), this.E, 0);
        qFileDelDownloadAdapter.h(this);
        return qFileDelDownloadAdapter;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void e() {
        this.f206508p0 = this.f206505m0.size();
        this.f206510r0.addAll(this.f206505m0);
        long t16 = f.t() / 1048576;
        ReportController.o(null, "dc00898", "", "", "0X800A0CB", "0X800A0CB", 3, 0, "" + this.f206508p0, "" + t16, "", "");
        super.e();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView, com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void e0() {
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView getRecentFileRecords");
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
                return this.f206506n0.get(Integer.parseInt(k3)) + fileInfo.j();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public boolean j() {
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView addFootViewHolder");
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void n(Set<FileInfo> set) {
        if (this.f206510r0.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j16 = 0;
        for (FileInfo fileInfo : this.f206510r0) {
            if (L0(fileInfo)) {
                arrayList.add(fileInfo.k());
                j3 += fileInfo.l();
                j16++;
            }
        }
        ((IStorageScanApi) QRoute.api(IStorageScanApi.class)).onNTFileDelete(arrayList, new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView del success, reloadData");
                QfileLocalFileDelPicTabView.this.o0(0);
            }
        });
        this.f206510r0.clear();
        ReportController.o(null, "dc00898", "", "", "0X800A0CC", "0X800A0CC", 3, 0, "" + j16, "" + (j3 / 1048576), "", "");
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        V();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int[] s() {
        return new int[]{1, 0};
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSortType(int i3) {
        super.setSortType(i3);
        this.E.clear();
        if (i3 != 0) {
            if (i3 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 3, 0, "", "", "", "");
                if (this.f206505m0.size() > 0) {
                    this.E.put(FileCategoryUtil.h(this.R, this.Q, this.f206505m0.size(), HardCodeUtil.qqStr(R.string.baf), HardCodeUtil.qqStr(R.string.zyp)), this.f206505m0);
                }
            }
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800A0C9", "0X800A0C9", 3, 0, "", "", "", "");
            this.E.putAll(this.f206504l0);
        }
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView setSortType refreshUI");
        C();
        a0(0);
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView setSortType refreshUI done");
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public boolean x(Set<FileInfo> set) {
        if (this.f206510r0.size() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        super.z();
        QLog.d("NTScanSpaceManager", 1, "QfileLocalFileDelPicTabView onDestroy");
        ((IStorageScanApi) QRoute.api(IStorageScanApi.class)).clearFilePathKeyMap("QfileLocalFileDelPicTabView");
    }
}

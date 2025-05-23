package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileLocalFileAppTabView extends QfileBaseLocalFileTabView {

    /* renamed from: f0, reason: collision with root package name */
    protected LinkedHashMap<String, List<FileInfo>> f206648f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f206649g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f206650h0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QfileLocalFileAppTabView.this.v0()) {
                QfileLocalFileAppTabView.this.x0();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView$1$1$a */
                    /* loaded from: classes12.dex */
                    class a implements DialogInterface.OnClickListener {
                        a() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            QfileLocalFileAppTabView.this.x0();
                            QfileLocalFileAppTabView.this.y0(true);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView$1$1$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        b() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        BaseFileAssistantActivity baseFileAssistantActivity = QfileLocalFileAppTabView.this.f206603d;
                        if (baseFileAssistantActivity != null && !baseFileAssistantActivity.isFinishing()) {
                            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(QfileLocalFileAppTabView.this.o(), 230).setMessage(R.string.ipg).setNegativeButton(R.string.cancel, new b()).setPositiveButton(R.string.iph, new a());
                            positiveButton.setOnDismissListener(new c());
                            positiveButton.setTitle(R.string.ipi);
                            positiveButton.setCancelable(false);
                            positiveButton.setCanceledOnTouchOutside(false);
                            positiveButton.show();
                            QfileLocalFileAppTabView.this.C();
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView$1$1$c */
                    /* loaded from: classes12.dex */
                    class c implements DialogInterface.OnDismissListener {
                        c() {
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                        }
                    }
                });
            }
        }
    }

    public QfileLocalFileAppTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        this.f206648f0 = new LinkedHashMap<>();
        this.f206649g0 = false;
        this.f206650h0 = false;
        setEditbarButton(false, false, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(FileInfo fileInfo) {
        if (!this.N.contains(fileInfo)) {
            this.N.add(fileInfo);
        }
        String f16 = fileInfo.f();
        if (f16 == null || f16.length() == 0) {
            f16 = HardCodeUtil.qqStr(R.string.zyt);
        }
        if (!this.f206648f0.containsKey(f16)) {
            this.f206648f0.put(f16, new ArrayList());
        }
        List<FileInfo> list = this.f206648f0.get(f16);
        if (list.contains(fileInfo)) {
            return;
        }
        int U = U(list, fileInfo.e());
        if (U < 0) {
            U = 0;
        }
        list.add(U, fileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.f206648f0.clear();
        if (this.G) {
            this.f206648f0.put(HardCodeUtil.qqStr(R.string.zyj), new ArrayList());
        }
        this.f206648f0.put(HardCodeUtil.qqStr(R.string.zyt), new ArrayList());
        this.f206603d.U3(this);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                QfileLocalFileAppTabView qfileLocalFileAppTabView = QfileLocalFileAppTabView.this;
                if (qfileLocalFileAppTabView.G) {
                    FileCategoryUtil.t(qfileLocalFileAppTabView.f206603d, qfileLocalFileAppTabView);
                    FileCategoryUtil.u(true, AppConstants.SDCARD_FILE_SAVE_PATH, ".apk", "", hashMap, QfileLocalFileAppTabView.this);
                } else {
                    Iterator<QfileTabBarView.h> it = qfileLocalFileAppTabView.F.iterator();
                    while (it.hasNext()) {
                        FileCategoryUtil.u(true, it.next().a(), ".apk", "", hashMap, QfileLocalFileAppTabView.this);
                    }
                }
                FileCategoryUtil.v(hashMap);
                QfileLocalFileAppTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinkedHashMap<String, List<FileInfo>> linkedHashMap = QfileLocalFileAppTabView.this.f206648f0;
                        if (linkedHashMap != null) {
                            Iterator<String> it5 = linkedHashMap.keySet().iterator();
                            while (it5.hasNext()) {
                                if (QfileLocalFileAppTabView.this.f206648f0.get(it5.next()).size() == 0) {
                                    it5.remove();
                                }
                            }
                        }
                        QfileLocalFileAppTabView qfileLocalFileAppTabView2 = QfileLocalFileAppTabView.this;
                        qfileLocalFileAppTabView2.E.putAll(qfileLocalFileAppTabView2.f206648f0);
                        QfileLocalFileAppTabView.this.C();
                        QfileLocalFileAppTabView.this.setSelect(0);
                        LinkedHashMap<String, List<FileInfo>> linkedHashMap2 = QfileLocalFileAppTabView.this.f206648f0;
                        if (linkedHashMap2 != null) {
                            linkedHashMap2.clear();
                        }
                        QfileLocalFileAppTabView.this.m0(true);
                    }
                });
            }
        };
        this.D = runnable;
        ThreadManagerV2.excute(runnable, 64, null, true);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, false, true, true, false);
        if (!this.f206603d.v3()) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().S();
            } else {
                this.f206603d.U2().H();
            }
        }
        f0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected boolean X(FileInfo fileInfo) {
        String f16 = fileInfo.f();
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
        return new d(o(), this.E, o(), this.U, this.f206617a0, this.W, this.f206618b0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView
    protected void e0() {
        ThreadManagerV2.executeOnSubThread(new AnonymousClass1());
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
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper.getThread() != currentThread) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.3
                @Override // java.lang.Runnable
                public void run() {
                    QfileLocalFileAppTabView.this.w0(fileInfo);
                }
            });
        } else {
            w0(fileInfo);
        }
    }

    protected boolean v0() {
        if (this.f206650h0) {
            return this.f206649g0;
        }
        boolean z16 = this.f206603d.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
        this.f206649g0 = z16;
        this.f206650h0 = true;
        return z16;
    }

    protected void y0(final boolean z16) {
        this.f206649g0 = z16;
        this.f206650h0 = true;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = QfileLocalFileAppTabView.this.f206603d.getSharedPreferences("qfile_permission", 0).edit();
                edit.putBoolean("qfile_permission_access_apps", z16);
                edit.apply();
            }
        });
    }
}

package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileLocalFileDocTabView extends QfileBaseLocalFileTabView {
    public QfileLocalFileDocTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        setEditbarButton(false, false, true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t0(String str) {
        String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(str);
        if (extension != null && extension.length() != 0) {
            String lowerCase = extension.toLowerCase();
            if (".doc|.docx|.wps|.pages|".indexOf(lowerCase) >= 0) {
                return "WORD";
            }
            if (".ppt|.pptx|.dps|.keynote|".indexOf(lowerCase) >= 0) {
                return "PPT";
            }
            if (".xls|.xlsx|.et|.numbers|".indexOf(lowerCase) >= 0) {
                return "EXCEL";
            }
            if (".pdf|".indexOf(lowerCase) >= 0) {
                return "PDF";
            }
            return HardCodeUtil.qqStr(R.string.bae);
        }
        return HardCodeUtil.qqStr(R.string.bae);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        if (this.f206603d.p3()) {
            if (!this.f206603d.v3()) {
                this.f206603d.U2().A();
            }
            this.f206603d.G3(true);
        } else if (!this.f206603d.v3()) {
            this.f206603d.U2().f();
        }
        setEditbarButton(false, false, true, true, true);
        f0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        this.f206603d.G3(false);
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
        this.f206603d.U3(this);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                HashMap hashMap = new HashMap();
                if (QfileLocalFileDocTabView.this.f206603d.getTabType() != 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z17 = z16;
                Iterator<QfileTabBarView.h> it = QfileLocalFileDocTabView.this.F.iterator();
                while (it.hasNext()) {
                    FileCategoryUtil.u(z17, it.next().a(), ".doc|.docx|.wps|.pages|.ppt|.pptx|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", hashMap, null);
                }
                final HashMap hashMap2 = new HashMap();
                for (String str : hashMap.keySet()) {
                    String t06 = QfileLocalFileDocTabView.this.t0(str);
                    List list = (List) hashMap.get(str);
                    if (!hashMap2.containsKey(t06)) {
                        hashMap2.put(t06, new ArrayList());
                    }
                    ((List) hashMap2.get(t06)).addAll(list);
                }
                FileCategoryUtil.v(hashMap2);
                QfileLocalFileDocTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileLocalFileDocTabView.this.E.clear();
                        for (String str2 : hashMap2.keySet()) {
                            List<FileInfo> list2 = (List) hashMap2.get(str2);
                            if (list2.size() != 0) {
                                QfileLocalFileDocTabView.this.E.put(str2, list2);
                            }
                        }
                        QfileLocalFileDocTabView.this.C();
                        QfileLocalFileDocTabView.this.setSelect(0);
                    }
                });
            }
        };
        this.D = runnable;
        ThreadManagerV2.excute(runnable, 64, null, true);
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
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.2
            @Override // java.lang.Runnable
            public void run() {
                String t06 = QfileLocalFileDocTabView.this.t0(fileInfo.j());
                if (!QfileLocalFileDocTabView.this.E.containsKey(t06)) {
                    QfileLocalFileDocTabView.this.E.put(t06, new ArrayList());
                }
                List<FileInfo> list = QfileLocalFileDocTabView.this.E.get(t06);
                if (list.contains(fileInfo)) {
                    return;
                }
                list.add(fileInfo);
                QfileLocalFileDocTabView.this.C();
                if (QfileLocalFileDocTabView.this.N.size() == 1) {
                    QfileLocalFileDocTabView.this.setSelect(0);
                }
            }
        });
    }
}

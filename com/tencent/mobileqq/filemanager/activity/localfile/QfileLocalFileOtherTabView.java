package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileLocalFileOtherTabView extends QfileBaseLocalFileTabView {

    /* renamed from: f0, reason: collision with root package name */
    private t f206669f0;

    public QfileLocalFileOtherTabView(Context context, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        this.f206669f0 = null;
        setEditbarButton(false, false, true, true, true);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, false, true, true, true);
        if (!this.f206603d.v3()) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().b();
            } else {
                this.f206603d.U2().Z();
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
        this.f206603d.U3(this);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                HashMap hashMap = new HashMap();
                if (QfileLocalFileOtherTabView.this.f206603d.getTabType() != 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z17 = z16;
                Iterator<QfileTabBarView.h> it = QfileLocalFileOtherTabView.this.F.iterator();
                while (it.hasNext()) {
                    FileCategoryUtil.u(z17, it.next().a(), "", ".doc|.docx|.wps|.pages|.ppt|.pptx|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|.swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.apk|.jpg|.bmp|.jpeg|.gif|.png|.ico|", hashMap, null);
                }
                FileCategoryUtil.v(hashMap);
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(HardCodeUtil.qqStr(R.string.f187283tk), new ArrayList());
                linkedHashMap.put(HardCodeUtil.qqStr(R.string.f186763s6), new ArrayList());
                linkedHashMap.put(HardCodeUtil.qqStr(R.string.f186733s3), new ArrayList());
                for (String str : hashMap.keySet()) {
                    ((List) linkedHashMap.get(QfileLocalFileOtherTabView.this.s0(str))).addAll((Collection) hashMap.get(str));
                }
                Iterator it5 = linkedHashMap.keySet().iterator();
                while (it5.hasNext()) {
                    if (((List) linkedHashMap.get((String) it5.next())).size() == 0) {
                        it5.remove();
                    }
                }
                QfileLocalFileOtherTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileLocalFileOtherTabView.this.E.clear();
                        QfileLocalFileOtherTabView.this.E.putAll(linkedHashMap);
                        QfileLocalFileOtherTabView.this.C();
                        QfileLocalFileOtherTabView.this.setSelect(0);
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
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.2
            @Override // java.lang.Runnable
            public void run() {
                String s06 = QfileLocalFileOtherTabView.this.s0(fileInfo.j());
                if (!QfileLocalFileOtherTabView.this.E.containsKey(s06)) {
                    QfileLocalFileOtherTabView.this.E.put(s06, new ArrayList());
                }
                List<FileInfo> list = QfileLocalFileOtherTabView.this.E.get(s06);
                if (list.contains(fileInfo)) {
                    return;
                }
                list.add(0, fileInfo);
                QfileLocalFileOtherTabView.this.C();
            }
        });
    }

    String s0(String str) {
        String extension = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(str);
        if (extension != null && extension.length() != 0) {
            String lowerCase = extension.toLowerCase();
            if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(lowerCase) >= 0) {
                return HardCodeUtil.qqStr(R.string.f187283tk);
            }
            if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(lowerCase) >= 0) {
                return HardCodeUtil.qqStr(R.string.f186763s6);
            }
            return HardCodeUtil.qqStr(R.string.f186733s3);
        }
        return HardCodeUtil.qqStr(R.string.f186733s3);
    }
}

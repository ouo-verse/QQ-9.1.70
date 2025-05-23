package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LoadParam;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.p;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileLocalFileMediaTabView extends QfileBaseLocalFileTabView {

    /* renamed from: f0, reason: collision with root package name */
    private int f206661f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Function4<HashMap<String, ArrayList<FileInfo>>, ArrayList<FileInfo>, ArrayList<FileInfo>, ArrayList<FileInfo>, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(HashMap<String, ArrayList<FileInfo>> hashMap, ArrayList<FileInfo> arrayList, ArrayList<FileInfo> arrayList2, ArrayList<FileInfo> arrayList3) {
            QfileLocalFileMediaTabView.this.N.clear();
            QfileLocalFileMediaTabView.this.N.addAll(arrayList);
            QfileLocalFileMediaTabView.this.E.clear();
            QfileLocalFileMediaTabView qfileLocalFileMediaTabView = QfileLocalFileMediaTabView.this;
            if (qfileLocalFileMediaTabView.G && (qfileLocalFileMediaTabView.f206661f0 & 2) > 0) {
                QfileLocalFileMediaTabView.this.E.put("Camera", new ArrayList());
            }
            String qqStr = HardCodeUtil.qqStr(R.string.f186983sr);
            if (!arrayList3.isEmpty()) {
                QfileLocalFileMediaTabView.this.E.put(qqStr, arrayList3);
            }
            if (!arrayList2.isEmpty()) {
                QfileLocalFileMediaTabView.this.E.put(HardCodeUtil.qqStr(R.string.f186963sp), arrayList2);
            }
            if (hashMap.containsKey(qqStr) && QfileLocalFileMediaTabView.this.E.containsKey(qqStr)) {
                hashMap.get(qqStr).addAll(QfileLocalFileMediaTabView.this.E.get(qqStr));
            }
            QfileLocalFileMediaTabView.this.E.putAll(hashMap);
            QfileLocalFileMediaTabView.this.C();
            QfileLocalFileMediaTabView.this.setSelect(0);
            return null;
        }
    }

    public QfileLocalFileMediaTabView(Context context, int i3, List<QfileTabBarView.h> list, boolean z16) {
        super(context, list, z16);
        this.f206661f0 = 3;
        setEditbarButton(false, false, true, true, true);
        this.f206661f0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ArrayList<FileInfo> arrayList) {
        Map<String, List<FileInfo>> l3;
        if (arrayList != null && this.G && (this.f206661f0 & 1) > 0 && (l3 = FileCategoryUtil.l(this.f206603d)) != null) {
            for (String str : l3.keySet()) {
                if (!"QQfile_recv".equalsIgnoreCase(str)) {
                    arrayList.addAll(l3.get(str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(ArrayList<FileInfo> arrayList) {
        Map<String, List<FileInfo>> r16;
        if (arrayList != null && this.G && (this.f206661f0 & 2) > 0 && (r16 = FileCategoryUtil.r(this.f206603d)) != null) {
            for (String str : r16.keySet()) {
                if (!"QQfile_recv".equalsIgnoreCase(str)) {
                    arrayList.addAll(r16.get(str));
                }
            }
        }
    }

    private void x0() {
        FileInfoLoader.f206609a.q(new LoadParam(this.F, this.G, this.f206661f0), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<FileInfo>> y0() {
        HashMap<String, List<FileInfo>> hashMap = new HashMap<>();
        if ((this.f206661f0 & 1) > 0) {
            Iterator<QfileTabBarView.h> it = this.F.iterator();
            while (it.hasNext()) {
                FileCategoryUtil.u(true, it.next().a(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", hashMap, null);
            }
            FileCategoryUtil.v(hashMap);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<FileInfo>> z0() {
        HashMap<String, List<FileInfo>> hashMap = new HashMap<>();
        if ((this.f206661f0 & 2) > 0) {
            Iterator<QfileTabBarView.h> it = this.F.iterator();
            while (it.hasNext()) {
                FileCategoryUtil.u(true, it.next().a(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", hashMap, null);
            }
            FileCategoryUtil.v(hashMap);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, false, true, true, true);
        if (!this.f206603d.v3()) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().h();
            } else {
                this.f206603d.U2().a0();
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
        if (FileInfoLoader.f206609a.y()) {
            x0();
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                long uptimeMillis = SystemClock.uptimeMillis();
                QfileLocalFileMediaTabView.this.A0(arrayList);
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                QfileLocalFileMediaTabView.this.B0(arrayList);
                long uptimeMillis3 = (SystemClock.uptimeMillis() - uptimeMillis) - uptimeMillis2;
                final HashMap y06 = QfileLocalFileMediaTabView.this.y0();
                long uptimeMillis4 = ((SystemClock.uptimeMillis() - uptimeMillis) - uptimeMillis2) - uptimeMillis3;
                HashMap z06 = QfileLocalFileMediaTabView.this.z0();
                long uptimeMillis5 = (((SystemClock.uptimeMillis() - uptimeMillis) - uptimeMillis2) - uptimeMillis3) - uptimeMillis4;
                QfileLocalFileMediaTabView.this.N.addAll(arrayList);
                Iterator it = y06.keySet().iterator();
                while (it.hasNext()) {
                    arrayList.addAll((Collection) y06.get((String) it.next()));
                }
                Iterator it5 = z06.keySet().iterator();
                while (it5.hasNext()) {
                    arrayList.addAll((Collection) z06.get((String) it5.next()));
                }
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    HashMap hashMap = y06;
                    FileInfo fileInfo = (FileInfo) it6.next();
                    if (fileInfo == null) {
                        it6.remove();
                    } else {
                        Iterator it7 = it6;
                        String f16 = fileInfo.f();
                        if (f16 != null && f16.length() != 0) {
                            HashMap hashMap2 = z06;
                            ArrayList arrayList2 = arrayList;
                            if (!"camera".equalsIgnoreCase(f16) && !ComponentFactory.ComponentType.VIDEO.equalsIgnoreCase(f16)) {
                                if ("QQ".equalsIgnoreCase(f16)) {
                                    f16 = HardCodeUtil.qqStr(R.string.f186983sr);
                                }
                            } else {
                                f16 = "Camera";
                            }
                            if (!linkedHashMap.containsKey(f16)) {
                                linkedHashMap.put(f16, new ArrayList());
                            }
                            if (!((List) linkedHashMap.get(f16)).contains(fileInfo)) {
                                ((List) linkedHashMap.get(f16)).add(fileInfo);
                            }
                            it6 = it7;
                            y06 = hashMap;
                            z06 = hashMap2;
                            arrayList = arrayList2;
                        } else {
                            it6 = it7;
                        }
                    }
                    y06 = hashMap;
                }
                final ArrayList arrayList3 = arrayList;
                final HashMap hashMap3 = z06;
                long uptimeMillis6 = SystemClock.uptimeMillis() - uptimeMillis;
                p.c(uptimeMillis2, uptimeMillis3, uptimeMillis4, uptimeMillis5, uptimeMillis6, (((uptimeMillis6 - uptimeMillis2) - uptimeMillis3) - uptimeMillis4) - uptimeMillis5, false);
                QfileLocalFileMediaTabView.this.E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QfileLocalFileMediaTabView.this.N.clear();
                        QfileLocalFileMediaTabView.this.N.addAll(arrayList3);
                        QfileLocalFileMediaTabView.this.E.clear();
                        QfileLocalFileMediaTabView qfileLocalFileMediaTabView = QfileLocalFileMediaTabView.this;
                        if (qfileLocalFileMediaTabView.G && (qfileLocalFileMediaTabView.f206661f0 & 2) > 0) {
                            QfileLocalFileMediaTabView.this.E.put("Camera", new ArrayList());
                        }
                        for (String str : hashMap3.keySet()) {
                            if (!QfileLocalFileMediaTabView.this.E.containsKey(HardCodeUtil.qqStr(R.string.f186983sr))) {
                                QfileLocalFileMediaTabView.this.E.put(HardCodeUtil.qqStr(R.string.f186983sr), new ArrayList());
                            }
                            QfileLocalFileMediaTabView.this.E.get(HardCodeUtil.qqStr(R.string.f186983sr)).addAll((Collection) hashMap3.get(str));
                        }
                        for (String str2 : y06.keySet()) {
                            if (!QfileLocalFileMediaTabView.this.E.containsKey(HardCodeUtil.qqStr(R.string.f186963sp))) {
                                QfileLocalFileMediaTabView.this.E.put(HardCodeUtil.qqStr(R.string.f186963sp), new ArrayList());
                            }
                            QfileLocalFileMediaTabView.this.E.get(HardCodeUtil.qqStr(R.string.f186963sp)).addAll((Collection) y06.get(str2));
                        }
                        String qqStr = HardCodeUtil.qqStr(R.string.f186983sr);
                        if (linkedHashMap.containsKey(qqStr) && QfileLocalFileMediaTabView.this.E.containsKey(qqStr)) {
                            ((List) linkedHashMap.get(qqStr)).addAll(QfileLocalFileMediaTabView.this.E.get(qqStr));
                        }
                        QfileLocalFileMediaTabView.this.E.putAll(linkedHashMap);
                        QfileLocalFileMediaTabView.this.C();
                        QfileLocalFileMediaTabView.this.setSelect(0);
                    }
                });
            }
        };
        this.D = runnable;
        ThreadManagerV2.excute(runnable, 64, null, true);
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
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.3
            @Override // java.lang.Runnable
            public void run() {
                String p06 = ah.p0(fileInfo.getType());
                if (!QfileLocalFileMediaTabView.this.E.containsKey(p06)) {
                    QfileLocalFileMediaTabView.this.E.put(p06, new ArrayList());
                }
                List<FileInfo> list = QfileLocalFileMediaTabView.this.E.get(p06);
                if (list.contains(fileInfo)) {
                    return;
                }
                list.add(0, fileInfo);
                QfileLocalFileMediaTabView.this.C();
            }
        });
    }
}

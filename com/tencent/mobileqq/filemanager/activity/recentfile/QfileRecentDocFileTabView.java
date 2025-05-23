package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.bp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentDocFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206744g0;

    /* renamed from: h0, reason: collision with root package name */
    private HashMap<String, String> f206745h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentDocFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentDocFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentDocFileTabView.this.f206603d.U2().e0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentDocFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentDocFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentDocFileTabView.this.f206603d.U2().g();
        }
    }

    public QfileRecentDocFileTabView(Context context) {
        super(context);
        this.f206744g0 = null;
        this.f206745h0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private List<String> O0() {
        ArrayList arrayList = new ArrayList();
        if (this.f206745h0 == null) {
            S0();
        }
        HashMap<String, String> hashMap = this.f206745h0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    private String P0(String str) {
        if (this.f206745h0 == null) {
            S0();
        }
        HashMap<String, String> hashMap = this.f206745h0;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value) && value.indexOf(str) >= 0) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private String Q0(String str) {
        String lowerCase;
        if (str != null && (lowerCase = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(str).toLowerCase()) != null && lowerCase.length() != 0) {
            if (ah.a1(this.f206603d)) {
                String P0 = P0(lowerCase);
                if (!TextUtils.isEmpty(P0)) {
                    return P0;
                }
            } else {
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
            }
        }
        return null;
    }

    private void R0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().U();
        } else {
            this.f206603d.U2().y();
        }
        t tVar = this.f206744g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206744g0 = aVar;
        this.f206603d.P3(aVar);
    }

    private void S0() {
        if (this.f206745h0 == null) {
            String b16 = TencentDocImportFileInfoProcessor.c().b();
            if (!TextUtils.isEmpty(b16)) {
                this.f206745h0 = bp.a(b16);
            }
            if (this.f206745h0 == null) {
                this.f206745h0 = new HashMap<>();
            }
            if (!this.f206745h0.containsKey("WORD")) {
                this.f206745h0.put("WORD", ".doc|.docx|.wps|.pages|");
            }
            if (!this.f206745h0.containsKey("PPT")) {
                this.f206745h0.put("PPT", ".ppt|.pptx|.dps|.keynote|");
            }
            if (!this.f206745h0.containsKey("EXCEL")) {
                this.f206745h0.put("EXCEL", ".xls|.xlsx|.et|.numbers|");
            }
            if (!this.f206745h0.containsKey("PDF")) {
                this.f206745h0.put("PDF", ".pdf|");
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        this.f206603d.G3(true);
        setEditbarButton(false, true, true, true, true);
        R0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        this.f206603d.G3(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    public void K0(final FileManagerEntity fileManagerEntity) {
        if (!this.P.contains(fileManagerEntity)) {
            String str = this.E;
            if (str != null && str.trim().length() != 0 && !this.E.equals(fileManagerEntity.peerUin)) {
                return;
            }
            this.P.add(fileManagerEntity);
            Collections.sort(this.P, this.V);
        }
        final String Q0 = Q0(fileManagerEntity.fileName);
        if (Q0 == null) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!QfileRecentDocFileTabView.this.G.containsKey(Q0)) {
                    QfileRecentDocFileTabView.this.G.put(Q0, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentDocFileTabView.this.G.get(Q0);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentDocFileTabView.this.C();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void l(ArrayList<FileManagerEntity> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<FileManagerEntity> it = arrayList.iterator();
            while (it.hasNext()) {
                s0(it.next());
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected boolean s0(FileManagerEntity fileManagerEntity) {
        String Q0 = Q0(fileManagerEntity.fileName);
        if (!this.G.containsKey(Q0)) {
            QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
            return false;
        }
        synchronized (this.G) {
            Iterator<FileManagerEntity> it = this.G.get(Q0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (fileManagerEntity == it.next()) {
                    it.remove();
                    break;
                }
            }
        }
        C();
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected d y0() {
        return new com.tencent.mobileqq.filemanager.activity.recentfile.a(o(), this.G, o(), this.f206700a0, this.f206702c0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void z0() {
        List<String> O0;
        this.G.clear();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("WORD", new ArrayList());
        linkedHashMap.put("EXCEL", new ArrayList());
        linkedHashMap.put("PDF", new ArrayList());
        linkedHashMap.put("PPT", new ArrayList());
        if (ah.a1(this.f206603d) && (O0 = O0()) != null && O0.size() > 0) {
            for (String str : O0) {
                if (!TextUtils.isEmpty(str) && !str.equals("WORD") && !str.equals("EXCEL") && !str.equals("PDF") && !str.equals("PPT")) {
                    linkedHashMap.put(str, new ArrayList());
                }
            }
        }
        for (FileManagerEntity fileManagerEntity : this.P) {
            if (!fileManagerEntity.bDelInFM && ((!this.f206603d.A0 && fileManagerEntity.peerType != 10014) || ah.I(fileManagerEntity.getFilePath()))) {
                String Q0 = Q0(fileManagerEntity.fileName);
                if (Q0 != null || linkedHashMap.containsKey(Q0)) {
                    ((List) linkedHashMap.get(Q0)).add(fileManagerEntity);
                }
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            if (((List) linkedHashMap.get((String) it.next())).size() == 0) {
                it.remove();
            }
        }
        this.G.putAll(linkedHashMap);
        C();
        setSelect(0);
        J0(true);
        this.U = false;
    }

    public QfileRecentDocFileTabView(Context context, String str) {
        super(context, str);
        this.f206744g0 = null;
        this.f206745h0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }
}

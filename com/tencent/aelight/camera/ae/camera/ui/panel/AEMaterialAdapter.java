package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements yq2.c, View.OnClickListener, com.tencent.aelight.camera.download.a {
    public String D;
    private AEMaterialPanel.e E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private final LayoutInflater f62897d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f62898e;

    /* renamed from: f, reason: collision with root package name */
    private AEGridView f62899f;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<AEMaterialMetaData> f62901i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Boolean> f62902m = new HashMap<>();
    public AEMaterialMetaData C = null;

    /* renamed from: h, reason: collision with root package name */
    private AEMaterialManager f62900h = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);

    public AEMaterialAdapter(Context context, AEGridView aEGridView, AEMaterialPanel.e eVar, boolean z16) {
        this.F = false;
        this.f62898e = context;
        this.f62897d = LayoutInflater.from(context);
        this.E = eVar;
        this.f62899f = aEGridView;
        this.F = z16;
    }

    private void B(boolean z16, Object obj) {
        VideoMaterial videoMaterial = (VideoMaterial) obj;
        if (videoMaterial == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f62901i.size(); i3++) {
            if (videoMaterial.getId() != null && videoMaterial.getId().equals(this.f62901i.get(i3).f69050id)) {
                this.f62901i.get(i3).editablewatermark = z16;
                notifyItemChanged(i3, 1);
                return;
            }
        }
    }

    private void t(AEMaterialMetaData aEMaterialMetaData) {
        AEMaterialManager aEMaterialManager = this.f62900h;
        aEMaterialManager.E0(aEMaterialManager.getApp(), aEMaterialMetaData, this);
    }

    private void y(AEMaterialMetaData aEMaterialMetaData) {
        AEMaterialMetaData aEMaterialMetaData2 = this.C;
        if (aEMaterialMetaData2 != null && !aEMaterialMetaData2.equals(aEMaterialMetaData)) {
            AEMaterialMetaData aEMaterialMetaData3 = this.C;
            aEMaterialMetaData3.ischoose = false;
            aEMaterialMetaData3.isdoubleclick = false;
        }
        this.C = aEMaterialMetaData;
    }

    public void C(List<AEMaterialMetaData> list) {
        this.f62901i.clear();
        this.f62902m.clear();
        this.f62901i.add(AEMaterialMetaData.MATERIAL_NONE);
        this.f62901i.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<AEMaterialMetaData> arrayList = this.f62901i;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        AEMaterialMetaData aEMaterialMetaData = this.f62901i.get(i3);
        if (aEMaterialMetaData == null) {
            return;
        }
        if (viewHolder instanceof bx) {
            bx bxVar = (bx) viewHolder;
            if (AEMaterialManager.H() != null && !aEMaterialMetaData.equals(AEMaterialManager.H())) {
                bxVar.c();
                return;
            } else {
                bxVar.b();
                return;
            }
        }
        if (viewHolder instanceof bz) {
            bz bzVar = (bz) viewHolder;
            if (aEMaterialMetaData.equals(AEMaterialManager.H()) && aEMaterialMetaData.usable) {
                bzVar.e(2, aEMaterialMetaData);
            } else {
                aEMaterialMetaData.editablewatermark = false;
                bzVar.e(1, aEMaterialMetaData);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int childAdapterPosition = this.f62899f.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            AEMaterialMetaData aEMaterialMetaData = this.f62901i.get(childAdapterPosition);
            y(aEMaterialMetaData);
            if (aEMaterialMetaData.ischoose) {
                aEMaterialMetaData.isdoubleclick = true;
            } else {
                aEMaterialMetaData.ischoose = true;
            }
            A(aEMaterialMetaData, childAdapterPosition);
            if (gq.a.r(((Activity) this.f62898e).getIntent())) {
                HashMap hashMap = new HashMap();
                hashMap.put("ext2", aEMaterialMetaData.f69050id);
                com.tencent.aelight.camera.aebase.c.b(5, hashMap);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
        final int v3 = v(aEMaterialMetaData);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialAdapter.this.notifyItemChanged(v3, 1);
            }
        });
    }

    public void w(boolean z16, int i3) {
        AEMaterialMetaData aEMaterialMetaData;
        HashMap<String, Boolean> hashMap;
        ArrayList<AEMaterialMetaData> arrayList = this.f62901i;
        if (arrayList != null && !arrayList.isEmpty()) {
            ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList position" + i3);
            if (i3 >= this.f62901i.size() || (aEMaterialMetaData = this.f62901i.get(i3)) == null || (hashMap = this.f62902m) == null) {
                return;
            }
            if (hashMap.containsKey(aEMaterialMetaData.f69050id)) {
                boolean booleanValue = this.f62902m.get(aEMaterialMetaData.f69050id).booleanValue();
                ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList data.id" + aEMaterialMetaData.f69050id + " vis" + booleanValue);
                if (booleanValue || !z16) {
                    return;
                }
                ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList report ~~~~data.id" + aEMaterialMetaData.f69050id);
                com.tencent.aelight.camera.ae.report.b.b().G0(aEMaterialMetaData.f69050id);
                return;
            }
            this.f62902m.put(aEMaterialMetaData.f69050id, Boolean.TRUE);
            ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList report ~~~~~data.id" + aEMaterialMetaData.f69050id);
            com.tencent.aelight.camera.ae.report.b.b().G0(aEMaterialMetaData.f69050id);
            return;
        }
        ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList is null");
    }

    public void x(List<AEMaterialMetaData> list) {
        ms.a.a("AEMaterialAdapter", "dtexpose reportFirstItems");
        if (list == null || list.isEmpty() || this.f62902m == null) {
            return;
        }
        int size = list.size() < 15 ? list.size() - 1 : 14;
        for (int i3 = 0; i3 < size; i3++) {
            AEMaterialMetaData aEMaterialMetaData = list.get(i3);
            if (aEMaterialMetaData != null) {
                this.f62902m.put(aEMaterialMetaData.f69050id, Boolean.TRUE);
                ms.a.a("AEMaterialAdapter", "dtexpose mTemplateList report ~~~~~ data.id" + aEMaterialMetaData.f69050id);
                com.tencent.aelight.camera.ae.report.b.b().G0(aEMaterialMetaData.f69050id);
            }
        }
    }

    public void z(AEMaterialMetaData aEMaterialMetaData) {
        A(aEMaterialMetaData, v(aEMaterialMetaData));
    }

    private int v(AEMaterialMetaData aEMaterialMetaData) {
        for (int i3 = 0; i3 < this.f62901i.size(); i3++) {
            if (this.f62901i.get(i3).f69050id.equals(aEMaterialMetaData.f69050id)) {
                return i3;
            }
        }
        return 0;
    }

    public void D(int[] iArr) {
        ArrayList<AEMaterialMetaData> arrayList;
        AEMaterialMetaData aEMaterialMetaData;
        if (iArr == null || iArr.length != 2 || this.f62902m == null || (arrayList = this.f62901i) == null || arrayList.isEmpty()) {
            return;
        }
        int i3 = iArr[0];
        int i16 = iArr[1];
        ms.a.a("AEMaterialAdapter", "dtexpose begin" + i3 + " end " + i16);
        for (int i17 = 0; i17 < this.f62901i.size(); i17++) {
            if ((i17 < i3 || i17 > i16) && (aEMaterialMetaData = this.f62901i.get(i17)) != null && this.f62902m.containsKey(aEMaterialMetaData.f69050id)) {
                ms.a.a("AEMaterialAdapter", "dtexpose materialMetaData.id" + aEMaterialMetaData.f69050id + " gone ");
                this.f62902m.put(aEMaterialMetaData.f69050id, Boolean.FALSE);
            }
        }
    }

    private void A(AEMaterialMetaData aEMaterialMetaData, int i3) {
        if (aEMaterialMetaData == null) {
            this.D = null;
            return;
        }
        String str = aEMaterialMetaData.f69050id;
        this.D = str;
        this.f62900h.x0(str);
        AEBaseReportParam.U().j1(aEMaterialMetaData.recommendReason);
        AEBaseReportParam.U().a(aEMaterialMetaData.f69050id);
        AEBaseReportParam.U().R0(-1);
        AEBaseReportParam.U().S0("none");
        AEBaseReportParam.U().Q0("1");
        AEBaseReportParam.U().T0(0);
        com.tencent.aelight.camera.ae.report.b.b().L0(aEMaterialMetaData.f69050id);
        ms.a.f("AEMaterialAdapter", "\u3010Select Material\u3011\uff1a" + aEMaterialMetaData.f69050id);
        ms.a.f("AEMaterialAdapter", "\u3010Select Material\u3011Usable :" + aEMaterialMetaData.usable);
        if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && !AEMaterialMetaData.isNoneMaterial(aEMaterialMetaData)) {
            if (aEMaterialMetaData.isWsBanner()) {
                com.tencent.biz.qqstory.utils.l.g(this.f62898e, aEMaterialMetaData, 1);
                return;
            }
            if (aEMaterialMetaData.usable) {
                if (!AEResUtil.R()) {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.qdv), 0).show();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
                            if (com.tencent.aelight.camera.ae.d.j()) {
                                com.tencent.aelight.camera.ae.d.u();
                            }
                        }
                    }, 64, null, true);
                    return;
                }
                this.f62900h.w0(aEMaterialMetaData, !this.F);
                AEMaterialPanel.e eVar = this.E;
                if (eVar != null) {
                    eVar.a(aEMaterialMetaData);
                }
                QLog.d("AEMaterialAdapter", 4, "### [material panel] select material " + aEMaterialMetaData.f69050id);
            } else {
                u(aEMaterialMetaData);
            }
            if (this.F) {
                return;
            }
            Context context = this.f62898e;
            if ((context instanceof Activity) && gq.a.r(((Activity) context).getIntent())) {
                this.f62900h.s0(aEMaterialMetaData);
                return;
            } else {
                this.f62900h.t0(aEMaterialMetaData);
                return;
            }
        }
        AEMaterialPanel.e eVar2 = this.E;
        if (eVar2 != null) {
            eVar2.c();
        }
        this.f62900h.w0(AEMaterialMetaData.MATERIAL_NONE, !this.F);
        QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
        ((Activity) this.f62898e).getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
    }

    private void u(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null || aEMaterialMetaData.downloading || TextUtils.isEmpty(aEMaterialMetaData.f69050id) || this.f62900h == null) {
            return;
        }
        t(aEMaterialMetaData);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate;
        RecyclerView.ViewHolder viewHolder;
        if (i3 == 0) {
            inflate = this.f62897d.inflate(R.layout.f167494dm3, viewGroup, false);
            viewHolder = new bx(inflate);
        } else {
            inflate = this.f62897d.inflate(R.layout.f167493dm2, viewGroup, false);
            bz bzVar = new bz(inflate);
            bzVar.c(this.f62898e);
            viewHolder = bzVar;
        }
        inflate.setOnClickListener(this);
        return viewHolder;
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onDownloadFinish(final AEMaterialMetaData aEMaterialMetaData, final boolean z16, int i3) {
        final int v3;
        if (aEMaterialMetaData != null && (v3 = v(aEMaterialMetaData)) > 0) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    AEMaterialMetaData aEMaterialMetaData2 = AEMaterialAdapter.this.f62901i.get(v3);
                    String I = AEMaterialAdapter.this.f62900h.I();
                    if (!TextUtils.isEmpty(AEMaterialAdapter.this.D) && AEMaterialAdapter.this.D.equals(aEMaterialMetaData.f69050id) && I.equals(aEMaterialMetaData.f69050id) && aEMaterialMetaData2 != null && aEMaterialMetaData2.f69050id.equals(aEMaterialMetaData.f69050id) && z16) {
                        if (AEMaterialManager.f63518v) {
                            ms.a.f("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
                            AEMaterialAdapter.this.notifyDataSetChanged();
                            return;
                        }
                        if (AEMaterialManager.f63519w) {
                            if (AEMaterialAdapter.this.E != null) {
                                AEMaterialAdapter.this.f62900h.w0(aEMaterialMetaData, !AEMaterialAdapter.this.F);
                                QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + aEMaterialMetaData.f69050id);
                                AEMaterialAdapter.this.E.a(aEMaterialMetaData);
                                return;
                            }
                            return;
                        }
                        ms.a.f("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
                        AEMaterialAdapter.this.notifyDataSetChanged();
                    }
                }
            });
            if (z16) {
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(AEMaterialAdapter.this.f62898e, HardCodeUtil.qqStr(R.string.qdx), 0).show();
                }
            });
        }
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        if (i3 == 113) {
            if (AEMaterialManager.H() != null) {
                notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i3 == 1024) {
            QLog.d("AEMaterialAdapter", 4, "current watermark has change");
            notifyDataSetChanged();
            return;
        }
        if (i3 == 111) {
            if (objArr != null && objArr.length == 1 && this.F) {
                C(((AEMaterialCategory) objArr[0]).f69044d);
                notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i3 == 114) {
            if (objArr == null || objArr.length != 1) {
                return;
            }
            B(true, objArr[0]);
            return;
        }
        if (i3 == 115 && objArr != null && objArr.length == 1) {
            B(false, objArr[0]);
        }
    }
}

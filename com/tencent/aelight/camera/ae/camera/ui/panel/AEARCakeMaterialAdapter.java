package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEARCakeMaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements com.tencent.aelight.camera.download.a, yq2.c {

    /* renamed from: d, reason: collision with root package name */
    AEARCakePanel.g f62792d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f62793e;

    /* renamed from: f, reason: collision with root package name */
    private Context f62794f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f62795h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<com.tencent.aelight.camera.ae.data.a> f62796i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private AEMaterialManager f62797m = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
    private AEARCakeMaterialManager C = AEARCakeMaterialManager.i();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.ae.camera.ui.panel.a f62805d;

        a(com.tencent.aelight.camera.ae.camera.ui.panel.a aVar) {
            this.f62805d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEARCakeMaterialAdapter.this.x(this.f62805d.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AEARCakeMaterialAdapter(Context context, AEARCakePanel.g gVar) {
        this.f62792d = gVar;
        this.f62793e = LayoutInflater.from(context);
        this.f62794f = context;
    }

    private boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<com.tencent.aelight.camera.ae.data.a> it = this.f62796i.iterator();
        while (it.hasNext()) {
            com.tencent.aelight.camera.ae.data.a next = it.next();
            if (next != null) {
                AEARCakeMaterial b16 = next.b();
                ms.a.a("AEARCakeMaterialAdapter", "arcake same downloading :" + b16.cakeId + " downloading " + b16.downloading);
                if (str.equals(b16.f69050id) && b16.downloading) {
                    ms.a.a("AEARCakeMaterialAdapter", "arcake same downloading :" + str);
                    return false;
                }
            }
        }
        return true;
    }

    private void u(AEMaterialMetaData aEMaterialMetaData) {
        ms.a.f("AEARCakeMaterialAdapter", "arcake : doRealDownload" + aEMaterialMetaData.cakeId);
        if (AEMaterialManager.W(aEMaterialMetaData)) {
            aEMaterialMetaData.usable = AEMaterialManager.W(aEMaterialMetaData);
            ms.a.a("AEARCakeMaterialAdapter", "arcake : already download " + aEMaterialMetaData.cakeId);
            onDownloadFinish(aEMaterialMetaData, true, 200);
            return;
        }
        AEMaterialManager aEMaterialManager = this.f62797m;
        aEMaterialManager.E0(aEMaterialManager.getApp(), aEMaterialMetaData, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        ms.a.a("AEARCakeMaterialAdapter", "arcake : onClick postion" + i3);
        if (i3 == -1) {
            return;
        }
        if (this.f62792d == null) {
            ms.a.c("AEARCakeMaterialAdapter", "MaterialPanelListener is null");
            return;
        }
        com.tencent.aelight.camera.ae.data.a aVar = this.f62796i.get(i3);
        if (aVar == null) {
            ms.a.c("AEARCakeMaterialAdapter", "giftMaterial is null");
            return;
        }
        AEARCakeMaterial b16 = aVar.b();
        if (b16 == null) {
            return;
        }
        if (!t(b16.f69050id)) {
            ms.a.a("AEARCakeMaterialAdapter", "arcake downing can not click");
            return;
        }
        ms.a.a("AEARCakeMaterialAdapter", "arcake :onclick :" + b16.toString() + "downloading : " + b16.downloading + " usable " + b16.usable);
        if (!NetworkUtil.isNetworkAvailable(this.f62794f) && !b16.usable) {
            ms.a.c("AEARCakeMaterialAdapter", "arcake net work not available");
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f169902y80), 1).show();
            return;
        }
        this.C.z(aVar, i3);
        if (b16.usable) {
            if (!AEResUtil.R()) {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.qdv), 0).show();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("AEARCakeMaterialAdapter", QLog._DEFAULT_REPORTLOG_LEVEL, "use material failed because of so load failed");
                        if (com.tencent.aelight.camera.ae.d.j()) {
                            com.tencent.aelight.camera.ae.d.u();
                        }
                    }
                }, 64, null, true);
                return;
            }
            this.f62792d.a(b16);
        } else {
            this.C.w(b16);
            v(b16);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3) {
        notifyDataSetChanged();
        x(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<com.tencent.aelight.camera.ae.data.a> arrayList = this.f62796i;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f62795h = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        AEARCakeMaterial b16;
        com.tencent.aelight.camera.ae.data.a aVar = this.f62796i.get(i3);
        if (aVar == null || viewHolder == null || (b16 = aVar.b()) == null) {
            return;
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.a aVar2 = (com.tencent.aelight.camera.ae.camera.ui.panel.a) viewHolder;
        aVar2.b(b16);
        aVar2.g(b16.usable ? 8 : 0);
        aVar2.f(aVar.c());
        aVar2.c(aVar.a());
        if (this.C.o() == i3) {
            aVar2.h(0);
        } else {
            aVar2.h(8);
        }
        if (this.f62796i.size() <= 1) {
            aVar2.g(8);
        }
        aVar2.itemView.setOnClickListener(new a(aVar2));
        aVar2.i(b16);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new com.tencent.aelight.camera.ae.camera.ui.panel.a(this.f62794f, this.f62793e.inflate(R.layout.dkw, viewGroup, false));
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onDownloadFinish(final AEMaterialMetaData aEMaterialMetaData, final boolean z16, final int i3) {
        ms.a.a("AEARCakeMaterialAdapter", "arcake : onDownloadFinish " + z16 + "resCode " + i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (i3 != 200) {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f169902y80), 1).show();
                    return;
                }
                if (aEMaterialMetaData == null) {
                    return;
                }
                ms.a.a("AEARCakeMaterialAdapter", "arcake : onDownloadFinish " + z16 + "cake id " + aEMaterialMetaData.cakeId);
                int w3 = AEARCakeMaterialAdapter.this.w(aEMaterialMetaData);
                if (w3 <= 0) {
                    return;
                }
                ms.a.a("AEARCakeMaterialAdapter", "arcake : onDownloadFinish position" + w3);
                AEARCakeMaterial b16 = AEARCakeMaterialAdapter.this.f62796i.get(w3).b();
                com.tencent.aelight.camera.ae.data.a n3 = AEARCakeMaterialAdapter.this.C.n();
                if (n3 == null) {
                    return;
                }
                AEARCakeMaterial b17 = n3.b();
                AEARCakeMaterialAdapter.this.notifyItemChanged(w3);
                String str = b17.f69050id;
                if (!TextUtils.isEmpty(str) && str.equals(aEMaterialMetaData.f69050id) && b16 != null && b16.f69050id.equals(aEMaterialMetaData.f69050id) && z16) {
                    if (AEMaterialManager.f63518v) {
                        ms.a.f("AEARCakeMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
                        AEARCakeMaterialAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    if (!AEMaterialManager.f63519w) {
                        ms.a.f("AEARCakeMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
                        AEARCakeMaterialAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    if (AEARCakeMaterialAdapter.this.f62792d != null) {
                        ms.a.a("AEARCakeMaterialAdapter", "### [material panel] download finish, select material " + aEMaterialMetaData.f69050id);
                        AEARCakeMaterialAdapter.this.f62792d.a(aEMaterialMetaData);
                    }
                    AEARCakeMaterialManager.b j3 = AEARCakeMaterialAdapter.this.C.j();
                    if (j3 != null) {
                        j3.b(aEMaterialMetaData);
                    }
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.download.a
    public void onProgressUpdate(final AEMaterialMetaData aEMaterialMetaData, final int i3) {
        final int w3 = w(aEMaterialMetaData);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                AEARCakeMaterialAdapter.this.notifyItemChanged(w3, 1);
                AEARCakeMaterialManager.b j3 = AEARCakeMaterialAdapter.this.C.j();
                if (j3 != null) {
                    j3.a(aEMaterialMetaData, i3);
                }
            }
        });
    }

    public void y(List<com.tencent.aelight.camera.ae.data.a> list, final int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("arcake : updateMaterialList");
        sb5.append(list != null ? list.size() : -1);
        ms.a.a("AEARCakeMaterialAdapter", sb5.toString());
        this.f62796i.clear();
        this.f62796i.addAll(list);
        this.f62795h.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                AEARCakeMaterialAdapter.this.z(i3);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(AEMaterialMetaData aEMaterialMetaData) {
        for (int i3 = 0; i3 < this.f62796i.size(); i3++) {
            String str = this.f62796i.get(i3).b().cakeId;
            if (str != null && str.equals(aEMaterialMetaData.cakeId)) {
                return i3;
            }
        }
        return 0;
    }

    private void v(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null || aEMaterialMetaData.downloading || TextUtils.isEmpty(aEMaterialMetaData.f69050id) || this.f62797m == null) {
            return;
        }
        u(aEMaterialMetaData);
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
    }
}

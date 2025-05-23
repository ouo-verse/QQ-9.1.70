package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.e;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEBottomListAdapter extends RecyclerView.Adapter<b> {
    public static int J = 0;
    public static int K = 0;
    public static int L = 2131231115;
    private static List<String> M;
    private static boolean N;
    private static int P;
    private static int Q;
    private a D;
    public AEPituCameraUnit E;
    private com.tencent.aelight.camera.ae.mode.c F;

    /* renamed from: e, reason: collision with root package name */
    private AEBottomListScrollView f62473e;

    /* renamed from: f, reason: collision with root package name */
    private AECaptureController f62474f;

    /* renamed from: h, reason: collision with root package name */
    private e f62475h;

    /* renamed from: i, reason: collision with root package name */
    private AEMaterialMetaData f62476i;
    private boolean G = false;
    private INetEventHandler H = new INetEventHandler() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.1
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    int netWorkType = HttpUtil.getNetWorkType();
                    if (netWorkType != 0) {
                        AEBottomListAdapter.this.notifyDataSetChanged();
                    }
                    if (netWorkType != 1 || AEBottomListAdapter.this.f62472d.size() <= 1) {
                        return;
                    }
                    AEBottomListAdapter.this.J();
                }
            });
        }
    };
    private com.tencent.aelight.camera.download.a I = new com.tencent.aelight.camera.download.a() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4
        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(final AEMaterialMetaData aEMaterialMetaData, final int i3) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id) != null) {
                        if (i3 < 100) {
                            AEMaterialMetaData aEMaterialMetaData2 = aEMaterialMetaData;
                            if (!aEMaterialMetaData2.usable && aEMaterialMetaData2.downloading) {
                                ((b) AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id)).d(1);
                                return;
                            }
                        }
                        ((b) AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id)).d(2);
                    }
                }
            });
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(final AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            if (z16 && AEBottomListAdapter.this.f62476i != null) {
                if (aEMaterialMetaData.f69050id.equals(AEBottomListAdapter.this.f62477m.I()) && aEMaterialMetaData.f69050id.equals(AEBottomListAdapter.this.f62476i.f69050id)) {
                    AEBottomListAdapter.this.E();
                    AEBottomListAdapter aEBottomListAdapter = AEBottomListAdapter.this;
                    aEBottomListAdapter.K(aEBottomListAdapter.f62476i);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AEBottomListAdapter.this.notifyDataSetChanged();
                        if (AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id) != null) {
                            ((b) AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id)).d(2);
                        }
                    }
                });
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id) != null) {
                            ((b) AEBottomListAdapter.this.C.get(aEMaterialMetaData.f69050id)).d(0);
                        }
                    }
                });
            }
            VSReporter.q("record_decoration_download", VSReporter.d(!z16 ? 1 : 0, System.currentTimeMillis() - aEMaterialMetaData.startDownloadTime, aEMaterialMetaData.resurl, aEMaterialMetaData.totalLen, aEMaterialMetaData.f69050id));
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private List<AEMaterialMetaData> f62472d = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private AEMaterialManager f62477m = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
    private Map<String, b> C = new HashMap();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a();
    }

    static {
        ArrayList arrayList = new ArrayList();
        M = arrayList;
        P = 65;
        Q = 65;
        arrayList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
        M.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
        M.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
        M.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
        M.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
        M.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
        M.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
    }

    public AEBottomListAdapter(AEPituCameraUnit aEPituCameraUnit, AEBottomListScrollView aEBottomListScrollView, AECaptureController aECaptureController) {
        this.E = aEPituCameraUnit;
        this.f62473e = aEBottomListScrollView;
        this.f62474f = aECaptureController;
        this.f62475h = (e) n.a(aEPituCameraUnit).get(e.class);
        AppNetConnInfo.registerNetChangeReceiver(this.f62473e.getContext(), this.H);
        this.F = (com.tencent.aelight.camera.ae.mode.c) n.a(this.E).get(com.tencent.aelight.camera.ae.mode.c.class);
        if (gq.a.s(aEPituCameraUnit)) {
            P = 69;
            Q = 53;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        AEMaterialPanel aEMaterialPanel;
        AECaptureController aECaptureController = this.f62474f;
        if (aECaptureController == null || (aEMaterialPanel = aECaptureController.f62315c) == null || !aEMaterialPanel.v()) {
            return;
        }
        AEMaterialPanel aEMaterialPanel2 = this.f62474f.f62315c;
        AEMaterialMetaData aEMaterialMetaData = this.f62476i;
        aEMaterialPanel2.B(aEMaterialMetaData.firstcategoryname, aEMaterialMetaData.f69050id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final AEMaterialMetaData aEMaterialMetaData) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (AEBottomListAdapter.this.f62473e.getVisibility() == 0) {
                    QLog.d("AEBottomListAdapter", 4, "### [bottom list] visible, select material " + aEMaterialMetaData.f69050id);
                    AEBottomListAdapter.this.f62477m.w0(aEMaterialMetaData, true);
                }
                if (AEBottomListAdapter.this.f62473e.getVisibility() == 0) {
                    if (AEBottomListAdapter.this.F.O1()) {
                        if (AEBottomListAdapter.this.f62475h != null) {
                            AEBottomListAdapter.this.f62475h.S1(0, aEMaterialMetaData);
                            return;
                        } else {
                            AEBottomListAdapter.this.f62474f.v(aEMaterialMetaData);
                            return;
                        }
                    }
                    ms.a.c("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
                    return;
                }
                ms.a.c("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
            }
        });
    }

    public static void L(int i3) {
        L = i3;
    }

    public void B(AEMaterialMetaData aEMaterialMetaData) {
        AEMaterialManager aEMaterialManager;
        if (!AEResUtil.R()) {
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.v7t), 0).show();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("AEBottomListAdapter", QLog._DEFAULT_REPORTLOG_LEVEL, "use watermark failed because of so load failed");
                    if (com.tencent.aelight.camera.ae.d.j()) {
                        com.tencent.aelight.camera.ae.d.u();
                    }
                }
            }, 64, null, true);
            return;
        }
        if (aEMaterialMetaData == null) {
            int l3 = this.f62473e.l();
            if (l3 >= getItemCount()) {
                return;
            } else {
                aEMaterialMetaData = C(l3);
            }
        }
        this.f62476i = aEMaterialMetaData;
        if (aEMaterialMetaData != null && (aEMaterialManager = this.f62477m) != null) {
            aEMaterialManager.x0(aEMaterialMetaData.f69050id);
        }
        AEMaterialMetaData aEMaterialMetaData2 = this.f62476i;
        if (aEMaterialMetaData2 == null || "stub_placeholder_material_id".equals(aEMaterialMetaData2.f69050id)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f62476i.f69050id) && !this.f62476i.isWsBanner() && !this.f62476i.equals(AEMaterialMetaData.MATERIAL_NONE)) {
            if (this.f62476i.f69050id.equals("call_material_id")) {
                a aVar = this.D;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            AEMaterialMetaData aEMaterialMetaData3 = this.f62476i;
            boolean z16 = aEMaterialMetaData3.usable;
            if (z16) {
                K(aEMaterialMetaData3);
                return;
            }
            if (aEMaterialMetaData3.downloading || z16 || TextUtils.isEmpty(aEMaterialMetaData3.f69050id) || this.f62477m == null) {
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(this.f62473e.getContext())) {
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.v7o));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEBottomListAdapter", 2, "start download template runnable");
            }
            AEMaterialManager aEMaterialManager2 = this.f62477m;
            aEMaterialManager2.E0(aEMaterialManager2.getApp(), this.f62476i, this.I);
            return;
        }
        AEMaterialManager aEMaterialManager3 = this.f62477m;
        if (aEMaterialManager3 != null) {
            aEMaterialManager3.w0(this.f62476i, false);
        }
        QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
        AECaptureController aECaptureController = this.f62474f;
        if (aECaptureController != null) {
            e eVar = this.f62475h;
            if (eVar != null) {
                eVar.S1(0, null);
            } else {
                aECaptureController.v(null);
            }
        }
        this.E.z().getIntent().removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
    }

    public AEMaterialMetaData C(int i3) {
        List<AEMaterialMetaData> list = this.f62472d;
        if (list == null || list.size() <= i3) {
            return null;
        }
        return this.f62472d.get(i3);
    }

    public boolean D() {
        return this.G;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        bVar.b(this.f62472d.get(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate;
        boolean s16 = gq.a.s(this.E);
        if (s16) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dl_, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dow, viewGroup, false);
        }
        return new b(inflate, this.f62473e, s16);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(b bVar) {
        super.onViewAttachedToWindow(bVar);
        AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
        if (aEMaterialMetaData == null || TextUtils.isEmpty(aEMaterialMetaData.f69050id)) {
            return;
        }
        this.C.put(bVar.f62489d.f69050id, bVar);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(b bVar) {
        super.onViewDetachedFromWindow(bVar);
        AEMaterialMetaData aEMaterialMetaData = bVar.f62489d;
        if (aEMaterialMetaData == null || TextUtils.isEmpty(aEMaterialMetaData.f69050id)) {
            return;
        }
        this.C.remove(bVar.f62489d.f69050id);
    }

    public void M(boolean z16) {
        this.G = z16;
    }

    public void N(a aVar) {
        this.D = aVar;
    }

    public void O() {
        this.f62472d.clear();
        this.f62472d.add(AEMaterialMetaData.MATERIAL_NONE);
        AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.f69050id = "stub_placeholder_material_id";
        for (int i3 = 0; i3 < 10; i3++) {
            this.f62472d.add(aEMaterialMetaData);
        }
        N = false;
        notifyDataSetChanged();
    }

    public void P(List<AEMaterialMetaData> list) {
        this.f62472d.clear();
        this.f62472d.add(AEMaterialMetaData.MATERIAL_NONE);
        this.f62472d.addAll(list);
        if (!list.isEmpty()) {
            AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
            aEMaterialMetaData.f69050id = "call_material_id";
            this.f62472d.add(aEMaterialMetaData);
        }
        N = false;
        notifyDataSetChanged();
        J();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<AEMaterialMetaData> list = this.f62472d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return super.getItemViewType(i3);
    }

    public void onDestroy() {
        AppNetConnInfo.unregisterNetEventHandler(this.H);
        this.I = null;
    }

    public void A(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null || this.f62472d.size() < 1) {
            return;
        }
        if (N) {
            this.f62472d.remove(1);
            this.f62472d.add(1, aEMaterialMetaData);
            notifyDataSetChanged();
        } else {
            this.f62472d.add(1, aEMaterialMetaData);
            notifyDataSetChanged();
            N = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RelativeLayout C;
        private AEBottomListScrollView D;
        private boolean E;

        /* renamed from: d, reason: collision with root package name */
        public AEMaterialMetaData f62489d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f62490e;

        /* renamed from: f, reason: collision with root package name */
        private View f62491f;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f62492h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f62493i;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f62494m;

        public b(View view, AEBottomListScrollView aEBottomListScrollView, boolean z16) {
            super(view);
            this.f62490e = (ImageView) view.findViewById(R.id.s4b);
            this.f62494m = (ImageView) view.findViewById(R.id.s4i);
            this.f62491f = view.findViewById(R.id.s4o);
            this.f62492h = (ImageView) view.findViewById(R.id.s4p);
            this.f62493i = (ImageView) view.findViewById(R.id.s4k);
            this.C = (RelativeLayout) view.findViewById(R.id.s4r);
            this.D = aEBottomListScrollView;
            this.E = z16;
        }

        public void c(AEMaterialMetaData aEMaterialMetaData) {
            this.f62489d = aEMaterialMetaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            int adapterPosition = getAdapterPosition();
            AEBottomListScrollView aEBottomListScrollView = this.D;
            if (aEBottomListScrollView != null && adapterPosition >= 0) {
                AEBottomListAdapter.J = AEBottomListAdapter.K;
                AEBottomListAdapter.K = adapterPosition;
                aEBottomListScrollView.smoothScrollToPosition(adapterPosition);
                if (this.D.getAdapter() instanceof AEBottomListAdapter) {
                    ((AEBottomListAdapter) this.D.getAdapter()).M(true);
                }
            }
            AEMaterialMetaData aEMaterialMetaData = this.f62489d;
            if (aEMaterialMetaData != null && "call_material_id".equals(aEMaterialMetaData.f69050id)) {
                com.tencent.aelight.camera.ae.report.b.b().M0();
            } else {
                AEBaseReportParam.U().S0("none");
                AEBaseReportParam.U().Q0("2");
                AEBaseReportParam.U().T0(0);
                if (adapterPosition == 0) {
                    AEBaseReportParam.U().R0(-1);
                } else {
                    AEBaseReportParam.U().R0(adapterPosition);
                }
                com.tencent.aelight.camera.ae.report.b b16 = com.tencent.aelight.camera.ae.report.b.b();
                AEMaterialMetaData aEMaterialMetaData2 = this.f62489d;
                Object obj = "";
                if (aEMaterialMetaData2 == null) {
                    str = "";
                } else {
                    str = aEMaterialMetaData2.f69050id;
                }
                b16.L0(str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u3010Click\u3011Item :");
                AEMaterialMetaData aEMaterialMetaData3 = this.f62489d;
                if (aEMaterialMetaData3 == null) {
                    str2 = "";
                } else {
                    str2 = aEMaterialMetaData3.f69050id;
                }
                sb5.append(str2);
                ms.a.f("AEBottomListAdapter", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("\u3010Click\u3011Usable :");
                AEMaterialMetaData aEMaterialMetaData4 = this.f62489d;
                if (aEMaterialMetaData4 != null) {
                    obj = Boolean.valueOf(aEMaterialMetaData4.usable);
                }
                sb6.append(obj);
                ms.a.f("AEBottomListAdapter", sb6.toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void b(AEMaterialMetaData aEMaterialMetaData) {
            this.f62489d = aEMaterialMetaData;
            if (aEMaterialMetaData != null) {
                this.C.setVisibility(4);
                if (!"0".equals(this.f62489d.f69050id) && !"call_material_id".equals(this.f62489d.f69050id)) {
                    if ("stub_placeholder_material_id".equals(this.f62489d.f69050id)) {
                        this.f62490e.setVisibility(0);
                        this.f62491f.setVisibility(8);
                        this.f62492h.setVisibility(8);
                        this.f62494m.setVisibility(0);
                        this.f62494m.setImageResource(R.drawable.iz5);
                    } else if (this.f62489d.isWsBanner()) {
                        this.f62490e.setVisibility(8);
                        this.f62494m.setVisibility(0);
                        this.f62494m.setTag(R.id.jb9, this.f62489d.iconurl);
                        this.f62494m.setTag(R.id.jai, Boolean.FALSE);
                        v.c(this.f62494m, this.f62489d.iconurl, v.a(this.itemView.getContext(), AEBottomListAdapter.Q), v.a(this.itemView.getContext(), AEBottomListAdapter.Q), this.itemView.getContext().getResources().getDrawable(R.drawable.iz5), null);
                        this.f62494m.setVisibility(0);
                        this.f62491f.setVisibility(8);
                        this.f62492h.setVisibility(0);
                        this.f62492h.setImageResource(R.drawable.f6x);
                    } else {
                        this.f62490e.setVisibility(0);
                        this.f62494m.setVisibility(0);
                        this.f62494m.setTag(R.id.jb9, this.f62489d.iconurl);
                        this.f62494m.setTag(R.id.jai, Boolean.FALSE);
                        v.c(this.f62494m, this.f62489d.iconurl, v.a(this.itemView.getContext(), AEBottomListAdapter.Q), v.a(this.itemView.getContext(), AEBottomListAdapter.Q), this.itemView.getContext().getResources().getDrawable(R.drawable.iz5), null);
                        AEMaterialMetaData aEMaterialMetaData2 = this.f62489d;
                        if (aEMaterialMetaData2.usable) {
                            d(2);
                        } else if (aEMaterialMetaData2.downloading) {
                            d(1);
                        } else {
                            d(0);
                        }
                        this.f62492h.setVisibility(8);
                    }
                } else {
                    this.f62491f.setVisibility(8);
                    this.f62492h.setVisibility(8);
                    this.f62494m.setVisibility(8);
                    if (this.E) {
                        if ("0".equals(this.f62489d.f69050id)) {
                            this.f62490e.setVisibility(8);
                        } else {
                            this.f62494m.setVisibility(0);
                            v.c(this.f62494m, AECameraConstants.AE_CAMERA_MATERIAL_MORE_ICON_URL, v.a(this.itemView.getContext(), AEBottomListAdapter.Q), v.a(this.itemView.getContext(), AEBottomListAdapter.Q), this.itemView.getContext().getResources().getDrawable(R.drawable.iux), null);
                        }
                    } else {
                        this.f62490e.setVisibility(0);
                    }
                }
                if (this.f62489d.needDisplayType()) {
                    this.f62492h.setVisibility(0);
                    this.f62492h.setImageResource(this.f62489d.getDisplayIconByType());
                } else if (this.f62489d.isWsBanner()) {
                    this.f62492h.setVisibility(0);
                    this.f62492h.setImageResource(R.drawable.f6x);
                } else {
                    this.f62492h.setVisibility(8);
                }
                this.itemView.setOnClickListener(this);
                if (this.E) {
                    this.f62490e.setImageResource(AEBottomListAdapter.L);
                    return;
                }
                if ("call_material_id".equals(this.f62489d.f69050id)) {
                    this.f62490e.setVisibility(0);
                    this.f62494m.setVisibility(8);
                    v.c(this.f62490e, "https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png", v.a(this.itemView.getContext(), 52.0f), v.a(this.itemView.getContext(), 52.0f), ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.iux, null), null);
                } else {
                    this.f62490e.setVisibility(0);
                    this.f62494m.setVisibility(0);
                    if ("0".equals(this.f62489d.f69050id)) {
                        this.f62494m.setImageResource(R.drawable.iyg);
                    }
                    this.f62490e.setBackgroundResource("0".equals(this.f62489d.f69050id) ? R.drawable.ir8 : R.drawable.ir7);
                }
            }
        }

        public void d(int i3) {
            if (i3 == 0) {
                View view = this.f62491f;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (i3 == 1) {
                View view2 = this.f62491f;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                View view3 = this.f62491f;
                if (view3 != null) {
                    view3.setVisibility(8);
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.f62490e.setSelected(false);
                this.C.setVisibility(4);
                return;
            }
            this.f62490e.setSelected(true);
            AEMaterialMetaData aEMaterialMetaData = this.f62489d;
            if (aEMaterialMetaData.editablewatermark && !this.E && !"0".equals(aEMaterialMetaData.f69050id)) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(4);
            }
        }
    }

    public void J() {
    }
}

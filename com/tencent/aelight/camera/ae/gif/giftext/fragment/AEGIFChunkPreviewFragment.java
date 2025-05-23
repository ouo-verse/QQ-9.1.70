package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.aelight.camera.ae.gif.video.b;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.light.device.LightDeviceUtils;
import rq.c;
import sq.a;

/* loaded from: classes32.dex */
public class AEGIFChunkPreviewFragment extends ReportFragment implements a.e {
    public static List<PTFaceAttr> N;
    private String D;
    private AEGIFMaterialViewModel E;
    private com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b F;
    private TextView G;
    private PngsCreateWorkingQueue H;
    private String I;
    private b.a J;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f65354d;

    /* renamed from: e, reason: collision with root package name */
    private BaseVMPeakActivity f65355e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, String> f65356f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f65357h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f65358i;

    /* renamed from: m, reason: collision with root package name */
    private sq.a f65359m;
    private List<rq.a> C = new ArrayList();
    private boolean K = false;
    private long L = Long.MAX_VALUE;
    private boolean M = i.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEGIFChunkPreviewFragment.this.f65355e.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEGIFChunkPreviewFragment.this.K = true;
            Set<Integer> x16 = AEGIFChunkPreviewFragment.this.f65359m.x();
            QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + x16);
            AEBaseReportParam U = AEBaseReportParam.U();
            U.e1();
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < AEGIFChunkPreviewFragment.this.C.size(); i3++) {
                if (x16.contains(Integer.valueOf(i3))) {
                    if (((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431893d != null) {
                        U.N0(((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431893d.f30533id);
                        U.Z0("none");
                        U.r1("none");
                        linkedList.add(((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431893d.f30533id);
                    } else if (!((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431894e.equals("")) {
                        U.N0("none");
                        List<c.a> list = rq.c.f431900b;
                        int[] iArr = rq.c.f431899a;
                        U.Z0(list.get(iArr[i3 % iArr.length]).f431901a);
                        U.r1(((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431894e);
                        linkedList.add("none");
                    } else {
                        U.N0("none");
                        U.Z0("none");
                        U.r1("none");
                        linkedList.add("none");
                    }
                    com.tencent.aelight.camera.ae.report.b.b().F1();
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < linkedList.size(); i16++) {
                sb5.append((String) linkedList.get(i16));
                if (i16 != linkedList.size() - 1) {
                    sb5.append(",");
                }
            }
            com.tencent.aelight.camera.ae.report.b.b().X0(x16.size(), sb5.toString());
            AEGIFChunkPreviewFragment.this.H.l(false);
            com.tencent.aelight.camera.ae.gif.video.b j3 = AEGIFChunkPreviewFragment.this.H.j();
            QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + j3.f65543a + ", texts = " + j3.f65544b);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i17 = 0; i17 < j3.f65543a.size(); i17++) {
                Integer num = j3.f65546d.get(i17);
                if (x16.contains(num)) {
                    if (i17 == 0 && AEGIFChunkPreviewFragment.this.J != null) {
                        arrayList.add(AEGIFChunkPreviewFragment.this.J.f65547a);
                        arrayList2.add(AEGIFChunkPreviewFragment.this.J.f65548b);
                        arrayList3.add(AEGIFChunkPreviewFragment.this.J.f65549c);
                    } else {
                        arrayList.add(j3.f65543a.get(i17));
                        arrayList2.add(j3.f65544b.get(i17));
                        arrayList3.add(j3.f65545c.get(i17));
                    }
                    String v3 = AEGIFChunkPreviewFragment.this.v(num.intValue());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("gif^");
                    if (v3 == null) {
                        v3 = "";
                    }
                    sb6.append(v3);
                    String sb7 = sb6.toString();
                    arrayList4.add(sb7);
                    ms.a.f("AEGIFChunkPreviewFragment", "save gif, index=" + i17 + ", widgetInfo=" + sb7 + ", originIndex=" + num);
                }
            }
            AEGIFChunkPreviewFragment.this.t(arrayList, arrayList2, arrayList3, arrayList4);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % 2;
            int screenWidth = (int) (LightDeviceUtils.getScreenWidth(AEGIFChunkPreviewFragment.this.f65355e) * 0.04f);
            rect.left = screenWidth - ((childAdapterPosition * screenWidth) / 2);
            rect.right = ((childAdapterPosition + 1) * screenWidth) / 2;
            rect.bottom = screenWidth;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<com.tencent.aelight.camera.ae.gif.c> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a implements Observer<com.tencent.aelight.camera.ae.download.a> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.aelight.camera.ae.gif.c f65369d;

            a(com.tencent.aelight.camera.ae.gif.c cVar) {
                this.f65369d = cVar;
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(com.tencent.aelight.camera.ae.download.a aVar) {
                MetaMaterial metaMaterial;
                String str;
                QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
                if (aVar == null || AEGIFChunkPreviewFragment.this.C == null) {
                    return;
                }
                for (int i3 = this.f65369d.f65340c + 1; i3 < AEGIFChunkPreviewFragment.this.C.size(); i3++) {
                    rq.a aVar2 = (rq.a) AEGIFChunkPreviewFragment.this.C.get(i3);
                    if (aVar2 != null && (metaMaterial = aVar2.f431893d) != null && metaMaterial.f30533id.equals(aVar.f63646a.f30533id)) {
                        int i16 = aVar2.f431892c;
                        int i17 = aVar.f63647b;
                        if (i16 != i17) {
                            aVar2.f431892c = i17;
                        }
                        if (aVar2.f431892c == 2) {
                            aVar2.f431895f = AEGifMaterialManager.o().p(aVar2.f431893d);
                            QLog.d("AEGIFChunkPreviewFragment", 4, "Downloaded material", "path===" + aVar2.f431895f);
                            com.tencent.aelight.camera.ae.gif.video.a aVar3 = new com.tencent.aelight.camera.ae.gif.video.a();
                            aVar3.f65539a = i3;
                            aVar3.f65540b = aVar2.f431895f;
                            if (aVar2.f431893d != null && ((str = aVar2.f431894e) == null || str.equals(""))) {
                                if (aVar2.f431893d.additionalFields.get("savename") != null) {
                                    aVar3.f65541c = "";
                                    aVar3.f65542d = aVar2.f431893d.additionalFields.get("savename");
                                } else {
                                    aVar3.f65541c = "";
                                    aVar3.f65542d = "";
                                }
                            } else {
                                String str2 = aVar2.f431894e;
                                if (str2 == null) {
                                    aVar3.f65541c = "";
                                } else {
                                    aVar3.f65541c = str2;
                                }
                            }
                            AEGIFChunkPreviewFragment.this.H.g(aVar3);
                            aVar2.f431891b = 12;
                            AEGIFChunkPreviewFragment.this.f65359m.notifyItemChanged(i3);
                            return;
                        }
                        return;
                    }
                }
            }
        }

        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.gif.c cVar) {
            String str;
            com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().removeObservers(AEGIFChunkPreviewFragment.this.f65355e);
            if (cVar != null) {
                int i3 = 0;
                QLog.d("AEGIFChunkPreviewFragment", 4, "Obtained recognizedEmotion", "=====" + cVar);
                QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + cVar.f65339b + "text ===" + cVar.f65340c + "material ====" + cVar.f65341d);
                if (cVar.f65339b == null) {
                    cVar.f65340c = 0;
                    cVar.f65341d = 6;
                    cVar.f65339b = "default";
                }
                List<String> list = cVar.f65338a;
                if (list != null && list.size() == 0) {
                    cVar.f65338a.addAll(rq.e.f431913o);
                }
                if (cVar.f65339b.equals("default")) {
                    str = HardCodeUtil.qqStr(R.string.j7c);
                } else {
                    str = HardCodeUtil.qqStr(R.string.j78) + ((String) AEGIFChunkPreviewFragment.this.f65356f.get(cVar.f65339b)) + HardCodeUtil.qqStr(R.string.j7e);
                }
                AEGIFChunkPreviewFragment.this.G.setText(str);
                while (i3 < cVar.f65340c) {
                    rq.a aVar = new rq.a();
                    aVar.f431893d = null;
                    List<String> list2 = cVar.f65338a;
                    aVar.f431894e = list2.get(i3 % list2.size());
                    aVar.f431892c = 2;
                    if (AEGIFChunkPreviewFragment.this.C.size() >= AEGIFChunkPreviewFragment.this.L) {
                        break;
                    }
                    AEGIFChunkPreviewFragment.this.C.add(aVar);
                    AEGIFChunkPreviewFragment.this.f65359m.notifyItemInserted(AEGIFChunkPreviewFragment.this.C.size() - 1);
                    com.tencent.aelight.camera.ae.gif.video.a aVar2 = new com.tencent.aelight.camera.ae.gif.video.a();
                    aVar2.f65541c = aVar.f431894e;
                    i3++;
                    aVar2.f65539a = i3;
                    AEGIFChunkPreviewFragment.this.H.g(aVar2);
                }
                AEGIFChunkPreviewFragment.this.E.N1().observe(AEGIFChunkPreviewFragment.this.f65355e, new a(cVar));
                AEGIFChunkPreviewFragment.this.B(cVar);
                return;
            }
            QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
            rq.a aVar3 = new rq.a();
            aVar3.f431895f = "";
            aVar3.f431894e = "";
            aVar3.f431892c = 2;
            aVar3.f431891b = 11;
            AEGIFChunkPreviewFragment.this.C.add(aVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements EIPCResultCallback {
        f() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD onCallback");
            int i3 = eIPCResult.code;
            if (i3 == 0) {
                QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code == 0");
            } else {
                QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code != 0, eipcResult.code == ", Integer.valueOf(i3), ", msg = ", eIPCResult.f396321e.getMessage());
            }
        }
    }

    public static AEGIFChunkPreviewFragment A(String str, long j3, String str2) {
        AEGIFChunkPreviewFragment aEGIFChunkPreviewFragment = new AEGIFChunkPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_PREVIEW_SOURCE_PATH", str);
        bundle.putLong("KEY_AVAILABLE_EMO_COUNT", j3);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("KEY_FONT_ID", str2);
        }
        aEGIFChunkPreviewFragment.setArguments(bundle);
        return aEGIFChunkPreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(com.tencent.aelight.camera.ae.gif.c cVar) {
        List<AEMaterialWrapper> list;
        ms.a.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
        Iterator<AEGifCategoryWrapper> it = AEGifMaterialManager.o().w(3).iterator();
        while (true) {
            if (!it.hasNext()) {
                list = null;
                break;
            }
            AEGifCategoryWrapper next = it.next();
            if (next != null && !TextUtils.isEmpty(next.categoryName) && !CollectionUtils.isEmpty(next.materialWrapperList) && next.categoryName.equals(cVar.f65339b)) {
                list = next.materialWrapperList;
                break;
            }
        }
        if (list == null) {
            ms.a.c("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList == null");
        } else if (list.isEmpty()) {
            ms.a.c("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], aeMaterialWrappers is empty");
        }
        if (list != null && this.C != null) {
            ms.a.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList.size() = " + list.size());
            int min = Math.min(list.size(), cVar.f65341d);
            Collections.shuffle(list);
            for (int i3 = 0; i3 < min; i3++) {
                AEMaterialWrapper aEMaterialWrapper = list.get(i3);
                rq.a aVar = new rq.a();
                aVar.f431893d = aEMaterialWrapper.f63554b;
                ms.a.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], sssigning material to item index = " + i3 + "material id = " + aEMaterialWrapper.f63554b.f30533id);
                aVar.f431892c = 0;
                aVar.f431891b = 10;
                aVar.f431894e = "";
                com.tencent.aelight.camera.ae.report.b.b().j1(aEMaterialWrapper.f63553a);
                if (this.C.size() >= this.L) {
                    break;
                }
                this.C.add(aVar);
                this.f65359m.notifyItemInserted(this.C.size() - 1);
                this.E.M1(com.tencent.aelight.camera.aebase.a.a(), aVar);
            }
        }
        ms.a.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
    }

    private void C() {
        getFragmentManager().beginTransaction().add(R.id.ru8, AEGIFTextEditFragment.H(this.I, true, this.f65357h.getChildAt(0), this.D)).addToBackStack(null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("qipc_param_camera_emo_png_dirs", arrayList);
        bundle.putStringArrayList("qipc_param_camera_emo_texts", arrayList2);
        bundle.putStringArrayList("qipc_param_camera_emo_snapshots", arrayList3);
        bundle.putStringArrayList("qipc_param_emo_widget_infos", arrayList4);
        QIPCClientHelper.getInstance().callServer(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME, "qipc_action_camera_emo_create_gif_and_upload", bundle, new f());
        getActivity().setResult(201);
        getActivity().finish();
        final Context applicationContext = getActivity().getApplicationContext();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.8
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(applicationContext, R.string.y4x, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v(int i3) {
        List<rq.a> list = this.C;
        if (list == null || i3 < 0 || i3 >= list.size() || this.C.get(i3) == null || this.C.get(i3).f431893d == null) {
            return null;
        }
        return this.C.get(i3).f431893d.f30533id;
    }

    private void w() {
        rq.a aVar = new rq.a();
        aVar.f431893d = null;
        aVar.f431894e = null;
        aVar.f431892c = 2;
        this.C.add(0, new rq.a());
        sq.a aVar2 = new sq.a(this.f65355e, this.C, this.D);
        this.f65359m = aVar2;
        aVar2.C(this);
        this.f65359m.v(this.f65358i);
        this.f65357h.setAdapter(this.f65359m);
        com.tencent.aelight.camera.ae.gif.video.a aVar3 = new com.tencent.aelight.camera.ae.gif.video.a();
        aVar3.f65539a = 0;
        this.H.g(aVar3);
    }

    private void x() {
        RecyclerView recyclerView = (RecyclerView) this.f65354d.findViewById(R.id.s0b);
        this.f65357h = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this.f65355e, 2));
        this.f65357h.addItemDecoration(new c());
        w();
    }

    private void y() {
        com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b bVar = (com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b) n.a(this.f65355e).get(com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b.class);
        this.F = bVar;
        this.f65359m.w(bVar, this.f65355e);
        this.F.O1().postValue("");
        this.F.N1().postValue(new c.a("#ccffffff", "#000000"));
        this.F.M1().observe(this.f65355e, new d());
        this.F.L1();
        this.E = (AEGIFMaterialViewModel) n.a(this.f65355e).get(AEGIFMaterialViewModel.class);
        com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().observe(this.f65355e, new e());
    }

    private void z() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f65354d.findViewById(R.id.f163786s03);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) (LightDeviceUtils.getScreenHeight(this.f65355e) * 0.08f);
        relativeLayout.setLayoutParams(layoutParams);
        this.f65354d.findViewById(R.id.ruc).setOnClickListener(new a());
        this.G = (TextView) this.f65354d.findViewById(R.id.f163809s42);
        this.G.setPadding((int) (LightDeviceUtils.getScreenWidth(this.f65355e) * 0.04f), x.c(this.f65355e, 9.0f), 0, x.c(this.f65355e, 9.0f));
        TextView textView = (TextView) this.f65354d.findViewById(R.id.s0c);
        this.f65358i = textView;
        textView.setEnabled(false);
        this.f65358i.setOnClickListener(new b());
        x();
    }

    @Override // sq.a.e
    public void b() {
        C();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f65355e = (BaseVMPeakActivity) getActivity();
        String string = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
        this.L = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
        QLog.d("AEGIFChunkPreviewFragment", 4, "availableEmoCount = " + this.L);
        if (getArguments().containsKey("KEY_FONT_ID")) {
            this.D = getArguments().getString("KEY_FONT_ID");
        }
        PngsCreateWorkingQueue pngsCreateWorkingQueue = new PngsCreateWorkingQueue(string, N, this.D, getActivity());
        this.H = pngsCreateWorkingQueue;
        pngsCreateWorkingQueue.k(new PngsCreateWorkingQueue.b() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1
            @Override // com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue.b
            public void onComplete(final int i3, String str) {
                if (i3 == 0) {
                    AEGIFChunkPreviewFragment.this.I = str;
                }
                ((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431896g = str;
                ((rq.a) AEGIFChunkPreviewFragment.this.C.get(i3)).f431891b = 13;
                AEGIFChunkPreviewFragment.this.f65355e.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AEGIFChunkPreviewFragment.this.f65359m != null) {
                            AEGIFChunkPreviewFragment.this.f65359m.notifyItemChanged(i3);
                        }
                    }
                });
            }
        });
        HashMap<String, String> hashMap = new HashMap<>();
        this.f65356f = hashMap;
        hashMap.put("happy", HardCodeUtil.qqStr(R.string.j75));
        this.f65356f.put("neutral", HardCodeUtil.qqStr(R.string.j76));
        this.f65356f.put("sad", HardCodeUtil.qqStr(R.string.j7a));
        this.f65356f.put("anger", HardCodeUtil.qqStr(R.string.j79));
        this.f65356f.put("disgust", HardCodeUtil.qqStr(R.string.j77));
        this.f65356f.put("fear", HardCodeUtil.qqStr(R.string.j7d));
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f65354d = (ViewGroup) layoutInflater.inflate(u(), viewGroup, false);
        z();
        y();
        ViewGroup viewGroup2 = this.f65354d;
        FragmentCollector.onFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PngsCreateWorkingQueue pngsCreateWorkingQueue = this.H;
        if (pngsCreateWorkingQueue != null) {
            pngsCreateWorkingQueue.l(!this.K);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.aelight.camera.ae.report.b.b().V0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.K = false;
        AEBaseReportParam.U().v1();
    }

    protected int u() {
        return this.M ? R.layout.f167502do1 : R.layout.f167501do0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<b.a> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(b.a aVar) {
            if (aVar != null) {
                AEGIFChunkPreviewFragment.this.J = aVar;
            }
        }
    }
}

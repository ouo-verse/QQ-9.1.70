package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FavFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.e;
import com.tencent.aelight.camera.favemoticon.api.IFavEmoticonIPCServerApi;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.favroaming.o;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCResult;
import fr.d;
import hd0.c;
import hr.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes32.dex */
public class FaceListPage extends RelativeLayout implements View.OnClickListener {
    private ViewGroup C;
    private ViewGroup D;
    private TextView E;
    private TextView F;
    private com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b G;
    private NormalFaceAdapter H;
    private e I;
    private InformationFaceAdapter J;
    private FavFaceAdapter K;
    private hr.a L;
    private a M;
    private k N;
    private b P;
    public int Q;
    private int R;
    public boolean S;
    private Handler T;
    private boolean U;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f68481d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f68482e;

    /* renamed from: f, reason: collision with root package name */
    private ProgressBar f68483f;

    /* renamed from: h, reason: collision with root package name */
    private ListView f68484h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f68485i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f68486m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage$4, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ hr.b f68491d;

        AnonymousClass4(hr.b bVar) {
            this.f68491d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON, "ACTION_GET_FAV_EMOTION_DATA_FROM_DB", new Bundle());
            if (callServer == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceListPage", 2, "IPC server exception and EIPCResult is null\uff0c return");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FaceListPage", 2, "result.code:" + callServer.code + ", result.data:" + callServer.data);
            }
            if (callServer.code != 0 || (bundle = callServer.data) == null) {
                return;
            }
            final ArrayList parcelableArrayList = bundle.getParcelableArrayList("fav_emoticon_data");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceListPage", 2, "favEmoticonList size=" + parcelableArrayList.size());
                }
                FaceListPage.this.T.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.4.1

                    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage$4$1$a */
                    /* loaded from: classes32.dex */
                    class a implements com.tencent.mobileqq.emosm.favroaming.a {
                        a() {
                        }

                        @Override // com.tencent.mobileqq.emosm.favroaming.a
                        public void a(HashMap<Integer, String> hashMap) {
                            AnonymousClass4.this.f68491d.j(hashMap);
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FaceListPage.this.u(anonymousClass4.f68491d);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4.this.f68491d.k(parcelableArrayList);
                        AnonymousClass4.this.f68491d.f406006q.set(2);
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        FaceListPage.this.u(anonymousClass4.f68491d);
                        if (AppSetting.f99565y) {
                            d.c().getAccessibilityData(new a());
                        }
                    }
                });
                return;
            }
            this.f68491d.f406006q.set(3);
            FaceListPage.this.q(this.f68491d);
        }
    }

    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);

        void b();

        void cancel(String str);
    }

    /* loaded from: classes32.dex */
    public interface b {
        void c(hr.b bVar);
    }

    public FaceListPage(Context context, k kVar, a aVar) {
        super(context);
        this.S = false;
        this.T = new Handler(Looper.getMainLooper());
        this.M = aVar;
        this.N = kVar;
        s();
    }

    private void B(hr.a aVar) {
        if (aVar instanceof hr.b) {
            if (this.K == null) {
                this.K = new FavFaceAdapter(super.getContext(), this);
            }
            this.G = this.K;
        } else if (aVar instanceof f) {
            if (this.H == null) {
                this.H = new NormalFaceAdapter(super.getContext(), this);
            }
            this.G = this.H;
        } else if (aVar instanceof hr.e) {
            if (this.I == null) {
                this.I = new e(super.getContext(), this);
            }
            this.G = this.I;
        } else if (aVar instanceof hr.d) {
            if (this.J == null) {
                this.J = new InformationFaceAdapter(super.getContext(), this);
            }
            this.G = this.J;
        } else {
            c.g("FaceListPage", "FacePackage is illegal.");
        }
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b bVar = this.G;
        if (bVar != null) {
            bVar.f68566h = this.Q;
            bVar.c(this.N);
            this.G.b(aVar);
            this.f68484h.setAdapter((ListAdapter) this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        final ProgressBar progressBar = this.f68483f;
        if (progressBar == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceListPage", 2, "updateFavProgress:" + progressBar.getProgress());
                }
                if (progressBar.getVisibility() == 0 && progressBar.getMax() == hr.b.f406002t && progressBar.getProgress() < hr.b.f406001s) {
                    int progress = progressBar.getProgress() + 20;
                    ProgressBar progressBar2 = progressBar;
                    if (progress >= hr.b.f406002t) {
                        progress = hr.b.f406001s;
                    }
                    progressBar2.setProgress(progress);
                    progressBar.postDelayed(this, 200L);
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final hr.a aVar) {
        this.T.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.7
            @Override // java.lang.Runnable
            public void run() {
                FaceListPage.this.f68483f.setMax(1);
                FaceListPage.this.f68483f.setProgress(0);
                FaceListPage.this.E.setBackgroundResource(R.drawable.akh);
                FaceListPage.this.f68483f.setVisibility(4);
                if (StringUtil.isEmpty(aVar.f405993f)) {
                    return;
                }
                FaceListPage.this.E.setText(aVar.f405993f);
            }
        });
    }

    private void E() {
        this.T.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.6
            @Override // java.lang.Runnable
            public void run() {
                FaceListPage.this.f68485i.setVisibility(4);
                FaceListPage.this.F.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final hr.b bVar) {
        if (!bVar.f406005p.compareAndSet(true, false)) {
            QLog.d("FaceListPage", 1, "do not permit to sync from server, return directly");
            if (bVar.f406006q.get() == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceListPage", 2, "no favorite emoticon data");
                }
                E();
                return;
            }
            return;
        }
        bVar.f406006q.set(4);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.5

            /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage$5$a */
            /* loaded from: classes32.dex */
            class a implements o {
                a() {
                }

                @Override // com.tencent.mobileqq.emosm.favroaming.o
                public void a() {
                    if (QLog.isColorLevel()) {
                        QLog.d("FaceListPage", 2, "sync favorite emoticon data from server success");
                    }
                    bVar.f406006q.set(5);
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    FaceListPage.this.u(bVar);
                }

                @Override // com.tencent.mobileqq.emosm.favroaming.o
                public void notifySyncFail() {
                    if (QLog.isColorLevel()) {
                        QLog.d("FaceListPage", 2, "sync favorite emoticon data from server fail");
                    }
                    bVar.f406006q.set(6);
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    FaceListPage.this.D(bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                d.c().b(new a());
            }
        }, 5, null, true);
    }

    private boolean r() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private void s() {
        this.R = BaseAIOUtils.f(130.0f, super.getContext().getResources());
        LayoutInflater.from(super.getContext()).inflate(R.layout.b5y, this);
        this.f68481d = (ImageView) super.findViewById(R.id.c1n);
        this.f68482e = (TextView) super.findViewById(R.id.c1o);
        this.f68483f = (ProgressBar) super.findViewById(R.id.g1f);
        this.f68484h = (ListView) super.findViewById(R.id.c1b);
        this.f68485i = (RelativeLayout) super.findViewById(R.id.f165125c15);
        this.f68486m = (RelativeLayout) super.findViewById(R.id.egb);
        this.C = (LinearLayout) super.findViewById(R.id.egf);
        this.D = (LinearLayout) super.findViewById(R.id.eg9);
        TextView textView = (TextView) findViewById(R.id.bow);
        this.E = textView;
        textView.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.F = (TextView) super.findViewById(R.id.v0s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(hr.b bVar) {
        b bVar2 = this.P;
        if (bVar2 != null) {
            bVar2.c(bVar);
        }
    }

    private void v() {
        hr.a aVar = this.L;
        if (aVar instanceof hr.b) {
            final hr.b bVar = (hr.b) aVar;
            this.T.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (bVar.i()) {
                        FaceListPage.this.p(bVar);
                        FaceListPage.this.f68484h.setVisibility(4);
                        FaceListPage.this.f68486m.setVisibility(4);
                        FaceListPage.this.f68485i.setVisibility(0);
                        FaceListPage.this.F.setVisibility(4);
                        String str2 = (String) FaceListPage.this.f68481d.getTag(R.id.jb9);
                        if (TextUtils.isEmpty(str2) || !str2.equals(bVar.f405991d)) {
                            FaceListPage.this.f68481d.setTag(R.id.jb9, bVar.f405991d);
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            obtain.mRequestWidth = FaceListPage.this.R;
                            obtain.mRequestHeight = FaceListPage.this.R;
                            obtain.mFailedDrawable = URLDrawableHelper.getStickerFailedDrawable();
                            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                            obtain.mUseAutoScaleParams = false;
                            FaceListPage.this.f68481d.setImageDrawable(URLDrawable.getDrawable(bVar.f405991d, obtain));
                        }
                        TextView textView = FaceListPage.this.f68482e;
                        if (TextUtils.isEmpty(bVar.f405989b)) {
                            str = "";
                        } else {
                            str = bVar.f405989b;
                        }
                        textView.setText(str);
                        if (bVar.f406006q.get() == 0 && bVar.f406006q.get() == 6) {
                            FaceListPage.this.D(bVar);
                            return;
                        }
                        FaceListPage.this.f68483f.setMax(hr.b.f406002t);
                        FaceListPage.this.f68483f.setProgress(bVar.f406007r);
                        FaceListPage.this.E.setText(HardCodeUtil.qqStr(R.string.mcj));
                        FaceListPage.this.f68483f.setVisibility(0);
                        FaceListPage.this.C();
                        return;
                    }
                    bVar.f406006q.set(0);
                    c.a("FaceListPage", "favFaceList data is get suc");
                    FaceListPage.this.f68483f.setMax(1);
                    FaceListPage.this.f68483f.setProgress(1);
                    FaceListPage.this.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FaceListPage.this.f68485i.setVisibility(4);
                            FaceListPage.this.f68486m.setVisibility(4);
                            FaceListPage.this.F.setVisibility(4);
                            FaceListPage.this.f68484h.setVisibility(0);
                            FaceListPage.this.G.notifyDataSetChanged();
                        }
                    }, 30L);
                }
            });
        }
    }

    private void w() {
        c.a("FaceListPage", "FacePackage is InformationFacePackage");
        hr.a aVar = this.L;
        if (aVar instanceof hr.d) {
            if (!((hr.d) aVar).f406011n.isEmpty()) {
                this.f68485i.setVisibility(4);
                this.f68486m.setVisibility(4);
                this.F.setVisibility(4);
                this.f68484h.setVisibility(0);
                this.G.notifyDataSetChanged();
                return;
            }
            this.f68485i.setVisibility(4);
            this.F.setVisibility(4);
            this.f68484h.setVisibility(4);
            this.f68486m.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(4);
        }
    }

    private void x() {
        c.a("FaceListPage", "FacePackage is LocationFacePackage");
        hr.a aVar = this.L;
        if (aVar instanceof hr.e) {
            hr.e eVar = (hr.e) aVar;
            if (!eVar.f406043n.isEmpty()) {
                this.f68485i.setVisibility(4);
                this.f68486m.setVisibility(4);
                this.F.setVisibility(4);
                this.f68484h.setVisibility(0);
                this.G.notifyDataSetChanged();
                return;
            }
            if (eVar.f406044o) {
                this.f68485i.setVisibility(4);
                this.F.setVisibility(4);
                this.f68484h.setVisibility(4);
                this.f68486m.setVisibility(0);
                this.C.setVisibility(4);
                this.D.setVisibility(0);
                return;
            }
            this.f68485i.setVisibility(4);
            this.F.setVisibility(4);
            this.f68484h.setVisibility(4);
            this.f68486m.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(4);
        }
    }

    private void y() {
        final boolean z16;
        final List<f.b> list;
        c.a("FaceListPage", "FacePackage is NormalFacePackage " + this.L);
        hr.a aVar = this.L;
        if (aVar != null && (aVar instanceof f)) {
            final f fVar = (f) aVar;
            List<f.b> list2 = fVar.f406066p;
            if (list2 == null || list2.isEmpty()) {
                z16 = false;
            } else {
                c.a("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
                z16 = true;
            }
            if (z16 || TextUtils.isEmpty(fVar.f406065o)) {
                list = null;
            } else {
                c.a("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
                list = fVar.k();
                z16 = (list == null || list.isEmpty()) ? false : true;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.8
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    fVar.l(list);
                    if (z16) {
                        c.a("FaceListPage", "FacePkg is already download.show face list.");
                        FaceListPage.this.f68483f.setMax(1);
                        FaceListPage.this.f68483f.setProgress(1);
                        FaceListPage.this.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FaceListPage.this.f68485i.setVisibility(4);
                                FaceListPage.this.f68486m.setVisibility(4);
                                FaceListPage.this.F.setVisibility(4);
                                FaceListPage.this.f68484h.setVisibility(0);
                                FaceListPage.this.G.notifyDataSetChanged();
                            }
                        }, 30L);
                        return;
                    }
                    FaceListPage.this.f68484h.setVisibility(4);
                    FaceListPage.this.f68486m.setVisibility(4);
                    FaceListPage.this.f68485i.setVisibility(0);
                    FaceListPage.this.F.setVisibility(4);
                    String str2 = (String) FaceListPage.this.f68481d.getTag(R.id.jb9);
                    if (TextUtils.isEmpty(str2) || !str2.equals(fVar.f405991d)) {
                        FaceListPage.this.f68481d.setTag(R.id.jb9, fVar.f405991d);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = FaceListPage.this.R;
                        obtain.mRequestHeight = FaceListPage.this.R;
                        obtain.mFailedDrawable = URLDrawableHelper.getStickerFailedDrawable();
                        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                        obtain.mUseAutoScaleParams = false;
                        FaceListPage.this.f68481d.setImageDrawable(URLDrawable.getDrawable(fVar.f405991d, obtain));
                    }
                    TextView textView = FaceListPage.this.f68482e;
                    if (TextUtils.isEmpty(fVar.f405989b)) {
                        str = "";
                    } else {
                        str = fVar.f405989b;
                    }
                    textView.setText(str);
                    f fVar2 = fVar;
                    if (!fVar2.f406067q) {
                        FaceListPage.this.D(fVar2);
                        return;
                    }
                    FaceListPage.this.f68483f.setMax(fVar.f406068r);
                    FaceListPage.this.f68483f.setProgress(fVar.f406069s);
                    FaceListPage.this.E.setText(HardCodeUtil.qqStr(R.string.mcj));
                    FaceListPage.this.f68483f.setVisibility(0);
                }
            });
        }
    }

    public void A(String str) {
        hr.a aVar = this.L;
        int i3 = 0;
        if (aVar != null) {
            int a16 = aVar.a();
            int i16 = 0;
            while (true) {
                if (i16 >= aVar.b()) {
                    break;
                }
                String d16 = aVar.d(i16);
                c.a("FaceListPage", "selectByName : " + str + d16);
                if (d16 != null && d16.contains(str)) {
                    i3 = i16 / a16;
                    break;
                }
                i16++;
            }
        }
        this.f68484h.setSelection(i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.E) {
            hr.a aVar = this.L;
            if (aVar instanceof hr.b) {
                hr.b bVar = (hr.b) aVar;
                bVar.f406005p.set(true);
                if (bVar.f406006q.get() == 0 || bVar.f406006q.get() == 6) {
                    QLog.d("FaceListPage", 1, "Download favorite emoticon data");
                    q(bVar);
                }
            } else {
                a aVar2 = this.M;
                if (aVar2 != null) {
                    if (!((f) aVar).f406067q) {
                        c.a("FaceListPage", "Download pkg:" + this.L.f405988a);
                        this.M.a(this.L.f405988a);
                        this.E.setText(HardCodeUtil.qqStr(R.string.mci));
                    } else {
                        aVar2.cancel(aVar.f405988a);
                    }
                }
            }
        } else if (view == this.C && this.M != null) {
            this.f68486m.setVisibility(0);
            this.C.setVisibility(4);
            this.D.setVisibility(0);
            this.M.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(hr.b bVar) {
        bVar.f406006q.set(1);
        ThreadManagerV2.post(new AnonymousClass4(bVar), 5, null, true);
    }

    public void setFavUIEventCb(b bVar) {
        this.P = bVar;
    }

    public void t(final hr.a aVar) {
        if (!r()) {
            this.T.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.1
                @Override // java.lang.Runnable
                public void run() {
                    FaceListPage.this.t(aVar);
                }
            });
            return;
        }
        if (aVar != null) {
            c.a("FaceListPage", "onChange,FacePkgInfo:" + aVar.toString());
            hr.a aVar2 = this.L;
            if (aVar2 == null || !aVar2.e().equals(aVar.e())) {
                B(aVar);
            }
            this.L = aVar;
            if ("FavFacePackage".equals(aVar.e())) {
                v();
                return;
            }
            if ("NormalFacePackage".equals(this.L.e())) {
                y();
                return;
            } else if ("LocationFacePackage".equals(this.L.e())) {
                x();
                return;
            } else {
                if ("InformationFacePackage".equals(this.L.e())) {
                    w();
                    return;
                }
                return;
            }
        }
        c.a("FaceListPage", "onChange, null.");
        this.L = null;
        this.G.b(null);
        this.f68484h.setVisibility(4);
        this.f68485i.setVisibility(4);
        this.f68486m.setVisibility(4);
        this.F.setVisibility(4);
        this.f68482e.setText("");
        this.f68483f.setMax(1);
        this.f68483f.setProgress(0);
    }

    public void z() {
        hr.a aVar = this.L;
        if (aVar == null) {
            c.a("FaceListPage", "onShow : FacePackage is null.");
            return;
        }
        if ("LocationFacePackage".equals(aVar.e())) {
            hr.e eVar = (hr.e) this.L;
            if (!eVar.f406043n.isEmpty() || eVar.f406044o || this.U) {
                return;
            }
            if (NetworkUtil.isNetworkAvailable(super.getContext())) {
                id0.a.n("video_shoot", "fail_poi", 0, 0, "1");
            } else {
                id0.a.n("video_shoot", "fail_poi", 0, 0, "2");
            }
            this.U = true;
            return;
        }
        if ("NormalFacePackage".equals(this.L.e())) {
            f fVar = (f) this.L;
            if (!NetworkUtil.isWifiEnabled(getContext()) || this.M == null || fVar.f406067q || !fVar.f406066p.isEmpty()) {
                return;
            }
            c.b("FaceListPage", "network is wifi. download automatically : %s .", fVar);
            this.M.a(fVar.f405988a);
            id0.a.n("video_edit", "auto_down_sticker", 0, 0, new String[0]);
            return;
        }
        if ("FavFacePackage".equals(this.L.e())) {
            hr.b bVar = (hr.b) this.L;
            bVar.f406005p.set(true);
            if (bVar.i() && bVar.f406006q.get() == 3) {
                QLog.d("FaceListPage", 1, "trigger to sync favData from server: " + bVar);
                q(bVar);
            }
        }
    }
}

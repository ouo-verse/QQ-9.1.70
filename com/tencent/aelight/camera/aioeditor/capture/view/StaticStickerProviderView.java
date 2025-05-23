package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.d;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import fr.f;
import hr.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import zr.c;

/* loaded from: classes32.dex */
public class StaticStickerProviderView extends ProviderView implements QIMSlidingTabView.c, BounceViewPager.b, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.a {
    BounceViewPager N;
    FacePagerAdapter P;
    d Q;
    private k R;
    public ArrayList<String> S;
    private int T;
    private volatile boolean U;
    com.tencent.aelight.camera.aioeditor.capture.music.b V;

    /* loaded from: classes32.dex */
    class a implements FaceListPage.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f67330a;

        a(WeakReference weakReference) {
            this.f67330a = weakReference;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.a
        public void a(String str) {
            hd0.c.a("StaticStickerProviderView", "\u7528\u6237\u70b9\u51fb\u4e0b\u8f7d\uff1a" + str);
            id0.b.f("0X80075DD");
            if (((wr.a) f.c(14)).g(str, true)) {
                return;
            }
            hd0.c.t("StaticStickerProviderView", "\u7528\u6237\u70b9\u51fb\u4e0b\u8f7d\u542f\u52a8\u5931\u8d25");
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.a
        public void b() {
            hd0.c.a("StaticStickerProviderView", "\u7528\u6237\u70b9\u51fb\u91cd\u65b0\u62c9\u53d6\u5730\u7406\u8d34\u7eb8");
            ((PasterDataManager) f.c(4)).u(true, (Activity) this.f67330a.get());
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.a
        public void cancel(String str) {
            hd0.c.a("StaticStickerProviderView", "\u7528\u6237\u70b9\u51fb\u4e0b\u8f7d\u53d6\u6d88\uff1a" + str);
        }
    }

    /* loaded from: classes32.dex */
    class b extends com.tencent.aelight.camera.aioeditor.capture.music.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.b
        public void e() {
            if (QLog.isColorLevel()) {
                QLog.i("StaticStickerProviderView", 2, "paster config get notify");
            }
            StaticStickerProviderView.this.M();
        }
    }

    public StaticStickerProviderView(Context context) {
        super(context);
        this.T = 0;
        this.V = new b();
    }

    private void E() {
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long maxMemory = (long) (Runtime.getRuntime().maxMemory() * 0.8d);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("clearMemory ");
            sb5.append(freeMemory > maxMemory);
            QLog.d("StaticStickerProviderView", 2, sb5.toString());
        }
        if (freeMemory > maxMemory) {
            ImageCacheHelper.f98636a.e();
        }
    }

    private void J(PasterDataManager pasterDataManager, EditVideoDoodle.f fVar) {
        fVar.g(new ArrayList(pasterDataManager.n()));
    }

    public static void K(Collection<hr.a> collection) {
        if (QLog.isColorLevel()) {
            QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
        }
        for (hr.a aVar : collection) {
            if (aVar.f405994g) {
                if (aVar instanceof hr.f) {
                    Collections.shuffle(((hr.f) aVar).f406066p);
                } else if (aVar instanceof e) {
                    Collections.shuffle(((e) aVar).f406043n);
                }
            }
        }
    }

    private void L(int i3) {
        if (!(this.Q.getItem(i3) instanceof hr.d) || this.U) {
            return;
        }
        ((PasterDataManager) f.c(4)).u(true, (Activity) new WeakReference((Activity) getContext()).get());
        this.U = true;
    }

    public void G() {
        if (this.P == null || !PasterDataManager.K.compareAndSet(true, false)) {
            return;
        }
        M();
    }

    public void H(int i3) {
        ArrayList<String> arrayList = this.S;
        if (arrayList == null || i3 < 0 || i3 >= arrayList.size()) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C1FE", "0X800C1FE", 0, 0, "", "", this.S.get(i3), "");
    }

    public void I(c.a aVar) {
        if (!(aVar instanceof FaceLayer.b) || this.S == null) {
            return;
        }
        FaceLayer.b bVar = (FaceLayer.b) aVar;
        final String str = bVar.A;
        String str2 = bVar.f67965z;
        for (final int i3 = 0; i3 < this.S.size(); i3++) {
            if (TextUtils.equals(this.S.get(i3), str2)) {
                onTabChecked(i3);
                postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FaceListPage f16 = StaticStickerProviderView.this.P.f(i3);
                        if (f16 != null) {
                            f16.A(str);
                        }
                    }
                }, 200L);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StaticStickerProviderView", 2, "selectPosition category=" + str2 + " name=" + str);
        }
    }

    public void M() {
        F(this.N.getCurrentItem());
        PasterDataManager pasterDataManager = (PasterDataManager) f.c(4);
        EditVideoDoodle.f p16 = pasterDataManager.p();
        if (p16 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("StaticStickerProviderView", 2, "paster config updateData");
            }
            J(pasterDataManager, p16);
            setAdapter(p16);
            i();
            this.C.onTabChecked(this.N.getCurrentItem());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.a
    public void c(int i3) {
        this.P.i(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.a
    public void i() {
        this.P.h();
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrollStateChanged(int i3) {
        this.T = i3;
        if (i3 == 0) {
            this.P.e(this.N.getCurrentItem());
        }
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrolled(int i3, float f16, int i16) {
        if (this.T == 1) {
            if (i3 < this.N.getCurrentItem()) {
                this.P.g(i3);
            } else if (i3 == this.N.getCurrentItem()) {
                this.P.g(i3 + 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageSelected(int i3) {
        this.C.onTabChecked(i3);
        this.P.onPageSelected(i3);
        H(i3);
        L(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int i3) {
        String str;
        hr.a item;
        this.N.setCurrentItem(i3);
        String[] strArr = new String[1];
        if (DoodleLayout.Q0) {
            str = "2";
        } else {
            str = "1";
        }
        strArr[0] = str;
        DoodleLayout.Q1("change_face", 0, 0, strArr);
        d dVar = this.Q;
        if (dVar != null && (item = dVar.getItem(i3)) != null) {
            id0.b.j("0X80076C7", "", "", item.f405988a, "");
            id0.b.g("0X80075DC", item.f405988a);
        }
        if (i3 == 1) {
            id0.b.i("0X80076CC");
            id0.b.f("0X80075E1");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return R.layout.apm;
    }

    public void setAdapter(d dVar) {
        d dVar2 = this.Q;
        if (dVar2 != null) {
            dVar2.d(this);
            this.Q = null;
        }
        if (dVar != null) {
            dVar.d(this);
            this.Q = dVar;
            dVar.c(this);
            this.P.k(this.Q);
        }
    }

    public void setCurrentItem(int i3) {
        this.N.setCurrentItem(i3);
    }

    public void setDownloadListener(FaceListPage.a aVar) {
        this.P.j(aVar);
    }

    public void setOnFaceSelectedListener(k kVar) {
        this.R = kVar;
        this.P.l(kVar);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        super.u();
        k kVar = this.R;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        super.v(bundle);
        if (this.D == null) {
            this.D = LayoutInflater.from(getContext()).inflate(R.layout.apm, (ViewGroup) this, false);
        }
        l(this.D);
        this.N = (BounceViewPager) findViewById(R.id.c1h);
        FacePagerAdapter facePagerAdapter = new FacePagerAdapter(super.getContext());
        this.P = facePagerAdapter;
        this.N.setAdapter(facePagerAdapter);
        this.N.g(this);
        this.C.setTabCheckListener(this);
        F(0);
        PasterDataManager pasterDataManager = (PasterDataManager) f.c(4);
        pasterDataManager.h();
        EditVideoDoodle.f p16 = pasterDataManager.p();
        J(pasterDataManager, p16);
        setAdapter(p16);
        Activity activity = (Activity) getContext();
        setDownloadListener(new a(new WeakReference(activity)));
        DoodleLayout doodleLayout = (DoodleLayout) activity.findViewById(R.id.f163743rs0);
        if (doodleLayout == null) {
            ms.a.c("StaticStickerProviderView", "doodleLayout is null.");
        } else {
            setOnFaceSelectedListener(doodleLayout.m0());
            this.f67277e.registObserver(this.V);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        super.w();
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager != null) {
            bounceViewPager.h(this);
        }
        d dVar = this.Q;
        if (dVar != null) {
            dVar.d(this);
        }
        EditVideoDoodle.f p16 = ((PasterDataManager) f.c(4)).p();
        if (p16 != null) {
            p16.d(this);
        }
        AppInterface appInterface = this.f67277e;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.V);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void x() {
        super.x();
        this.N.removeAllViews();
        E();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void y() {
        super.y();
        this.P.notifyDataSetChanged();
        int currentItem = this.N.getCurrentItem();
        H(currentItem);
        L(currentItem);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        super.z();
        if (QLog.isColorLevel()) {
            QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
        }
        G();
    }

    private void F(int i3) {
        ArrayList<DoodleEmojiItem> f16 = ((com.tencent.aelight.camera.aioeditor.capture.paster.e) f.c(1)).f();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i16 = 0; i16 < f16.size(); i16++) {
            if (f16.get(i16).hide != 1) {
                String str = f16.get(i16).name;
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        this.C.initTabItemsWithString(arrayList, i3);
        this.S = arrayList;
    }
}

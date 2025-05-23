package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.adapter.g;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.takevideo.z;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.f;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import fr.f;
import java.util.ArrayList;
import java.util.List;
import qs.e;

/* loaded from: classes32.dex */
public class TransitionProviderView extends ProviderView implements AdapterView.OnItemClickListener, BounceViewPager.b, QIMSlidingTabView.c, Handler.Callback {
    private BounceViewPager N;
    private g P;
    public ArrayList<FilterCategory> Q;
    public int R;
    public int S;
    public MusicItemInfo T;
    WeakReferenceHandler U;
    public int V;
    e W;

    public TransitionProviderView(Context context) {
        super(context);
        this.R = 0;
        this.S = -1;
        this.U = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.V = 0;
        this.W = new a();
    }

    public ArrayList<QIMSlidingTabView.d> E() {
        ArrayList<QIMSlidingTabView.d> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            QIMSlidingTabView.d dVar = new QIMSlidingTabView.d();
            dVar.f67316a = this.Q.get(i3).f66686e;
            dVar.f67317b = false;
            dVar.f67318c = HardCodeUtil.qqStr(R.string.u8k) + dVar.f67316a + HardCodeUtil.qqStr(R.string.u8l);
            arrayList.add(dVar);
        }
        return arrayList;
    }

    public void G() {
        if (this.I) {
            if (QLog.isColorLevel()) {
                QLog.d("TransitionProviderView", 2, "TransitionProviderView updateSelectedState");
            }
            g gVar = this.P;
            if (gVar != null) {
                gVar.f();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        F(this.T);
        return false;
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageSelected(int i3) {
        this.C.onTabChecked(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "TransitionProviderView onCreate");
        }
        super.v(bundle);
        this.C.setTabCheckListener(this);
        View view = this.D;
        if (view == null) {
            this.N = (BounceViewPager) LayoutInflater.from(getContext()).inflate(R.layout.ap7, (ViewGroup) this, false);
        } else {
            this.N = (BounceViewPager) view;
        }
        this.N.g(this);
        l(this.N);
        m.a aVar = ((d) f.c(5)).I;
        if (aVar == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "comboFilterData null");
                return;
            }
            return;
        }
        setup(aVar.f());
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        g gVar = this.P;
        if (gVar != null) {
            gVar.onDestroy();
        }
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager != null) {
            bounceViewPager.h(this);
        }
        super.w();
    }

    /* loaded from: classes32.dex */
    class a extends e {
        a() {
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            MusicItemInfo musicItemInfo;
            if (z16 && (musicItemInfo = TransitionProviderView.this.T) != null && musicItemInfo.getLocalPath().equals(str)) {
                TransitionProviderView.this.U.sendEmptyMessage(1);
            }
        }

        @Override // qs.e
        public void b(String str) {
        }

        @Override // qs.e
        public void d(int i3) {
        }

        @Override // qs.e
        public void e(String str, int i3) {
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
        }
    }

    private void F(MusicItemInfo musicItemInfo) {
        if (musicItemInfo != null) {
            com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) f.d().g(8);
            if (gVar == null || !gVar.h(musicItemInfo)) {
                if (gVar != null) {
                    gVar.v(musicItemInfo, this.W);
                }
            } else {
                gVar.u(musicItemInfo);
                ProviderView.a aVar = this.M;
                if (aVar != null) {
                    aVar.H(true);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        ApngImage.pauseByTag(16);
        super.A();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int i3) {
        if (i3 < 0 || i3 > this.Q.size()) {
            return;
        }
        this.N.setCurrentItem(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        ApngImage.playByTag(16);
        super.z();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (view != null && this.N.getCurrentItem() < this.Q.size()) {
            FilterCategory filterCategory = this.Q.get(this.N.getCurrentItem());
            if (i3 >= filterCategory.f66687f.size()) {
                return;
            }
            TransitionCategoryItem transitionCategoryItem = (TransitionCategoryItem) filterCategory.f66687f.get(i3);
            if (transitionCategoryItem != null && !transitionCategoryItem.equals(m.n().v())) {
                m.n().T(transitionCategoryItem);
                G();
                if (this.M != null) {
                    this.M.n(Integer.parseInt(transitionCategoryItem.f66697d));
                }
                id0.a.n("video_edit_transition", "clk_effects", z.k0(this.S), 0, transitionCategoryItem.Q, transitionCategoryItem.T, transitionCategoryItem.R, transitionCategoryItem.S);
            }
            if (SlideShowPhotoListManager.n().m() == 22) {
                if (transitionCategoryItem != null && Integer.valueOf(transitionCategoryItem.f66697d).intValue() < 0) {
                    LpReportInfo_pf00064.allReport(680, 7, 2);
                } else if (transitionCategoryItem != null && Integer.valueOf(transitionCategoryItem.f66697d).intValue() == 4) {
                    LpReportInfo_pf00064.allReport(680, 7, 1);
                } else if (transitionCategoryItem != null && Integer.valueOf(transitionCategoryItem.f66697d).intValue() > 0) {
                    LpReportInfo_pf00064.allReport(680, 7, 3);
                }
            }
            if (transitionCategoryItem != null) {
                MusicItemInfo musicItemInfo = new MusicItemInfo();
                musicItemInfo.mType = 2;
                List<f.a> b16 = com.tencent.biz.qqstory.takevideo.slideshow.f.a(getContext()).b(transitionCategoryItem.Q);
                if (b16 != null && b16.size() > 0) {
                    MusicItemInfo A = ((QIMMusicConfigManager) fr.f.c(2)).A(b16.get(0).f94400a, b16.get(0).f94401b);
                    this.T = A;
                    if (A != null) {
                        F(A);
                        return;
                    } else {
                        F(musicItemInfo);
                        return;
                    }
                }
                F(musicItemInfo);
            }
        }
    }

    public void setup(ArrayList<FilterCategory> arrayList) {
        if (arrayList == null) {
            return;
        }
        ArrayList<FilterCategory> arrayList2 = new ArrayList<>(5);
        this.Q = arrayList2;
        arrayList2.addAll(arrayList);
        this.C.initTabItemsWithRedDot(E());
        g gVar = new g(this.f67276d, this.K);
        this.P = gVar;
        gVar.e(this.Q);
        this.P.d(this);
        this.N.setAdapter(this.P);
        this.P.notifyDataSetChanged();
        int size = this.Q.size();
        int i3 = this.V;
        if (size > i3) {
            this.N.setCurrentItem(i3);
            this.C.onTabChecked(this.V);
        }
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}

package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSSetViewPagerOrientationEvent;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    private View C;
    private ViewPager2 D;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.f E;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r F;
    private final QFSPersonalDetailsFragment G;
    private ViewPager2.OnPageChangeCallback H = new a();

    /* renamed from: d, reason: collision with root package name */
    private View f89373d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89374e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89375f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f89376h;

    /* renamed from: i, reason: collision with root package name */
    private View f89377i;

    /* renamed from: m, reason: collision with root package name */
    private View f89378m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            k.this.H9(i3);
            if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.g()) {
                k.this.F.j3("qfs_personal_tab_collected_box");
            } else if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.i()) {
                k.this.F.j3("qfs_personal_tab_collected_feed");
            } else if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.h()) {
                k.this.F.j3("qfs_personal_tab_collected_album");
            }
        }
    }

    public k(@NonNull QFSPersonalDetailsFragment qFSPersonalDetailsFragment) {
        this.G = qFSPersonalDetailsFragment;
        initViewModel();
    }

    private void B9(View view, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void C9(@NonNull QFSSetViewPagerOrientationEvent qFSSetViewPagerOrientationEvent) {
        ViewPager2 viewPager2;
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.G;
        if (qFSPersonalDetailsFragment != null && qFSPersonalDetailsFragment.hashCode() == qFSSetViewPagerOrientationEvent.getHashCode() && (viewPager2 = this.D) != null) {
            viewPager2.setOrientation(qFSSetViewPagerOrientationEvent.getOrientation());
        }
    }

    private void D9() {
        int i3;
        if (this.f89373d == null) {
            if (com.tencent.biz.qqcircle.immersive.personal.utils.j.a()) {
                i3 = R.id.f1204979p;
            } else {
                i3 = R.id.f1205079q;
            }
            this.f89373d = ((ViewStub) getPartRootView().findViewById(i3)).inflate();
            this.f89375f = (TextView) getPartRootView().findViewById(R.id.f56002jf);
            this.f89376h = (TextView) getPartRootView().findViewById(R.id.f55962jb);
            if (com.tencent.biz.qqcircle.immersive.personal.utils.j.a()) {
                TextView textView = (TextView) getPartRootView().findViewById(R.id.f55972jc);
                this.f89374e = textView;
                textView.setOnClickListener(this);
                this.f89375f.setOnClickListener(this);
                this.f89376h.setOnClickListener(this);
                this.C = getPartRootView().findViewById(R.id.f47561xm);
                View findViewById = getPartRootView().findViewById(R.id.f44471p_);
                View findViewById2 = getPartRootView().findViewById(R.id.f56512kt);
                if (this.F.v2().z()) {
                    this.C.setVisibility(0);
                    findViewById.setOnClickListener(this);
                    findViewById2.setOnClickListener(this);
                } else {
                    this.C.setVisibility(8);
                }
                B9(findViewById, QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_BUTTON);
                B9(findViewById2, QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_BUTTON);
                B9(this.f89374e, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_TAB);
                B9(this.f89375f, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_COLLECT_TAB);
                B9(this.f89376h, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_PRODUCT_TAB);
            } else {
                this.f89377i = getPartRootView().findViewById(R.id.f57292mx);
                this.f89378m = getPartRootView().findViewById(R.id.f57282mw);
                this.f89377i.setOnClickListener(this);
                this.f89378m.setOnClickListener(this);
                B9(this.f89377i, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_COLLECT_TAB);
                B9(this.f89378m, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_PRODUCT_TAB);
            }
        }
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            this.f89373d.setVisibility(8);
        }
        ViewPager2 viewPager2 = (ViewPager2) getPartRootView().findViewById(R.id.f57382n6);
        this.D = viewPager2;
        if (viewPager2.getChildAt(0) instanceof RecyclerView) {
            ((RecyclerView) this.D.getChildAt(0)).setNestedScrollingEnabled(true);
        }
        this.D.registerOnPageChangeCallback(this.H);
        com.tencent.biz.qqcircle.immersive.personal.adapter.f fVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.f(this.G);
        this.E = fVar;
        this.D.setAdapter(fVar);
    }

    private void E9() {
        if (this.G.getQCircleInitBean() == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = this.G.getQCircleInitBean();
        if (qCircleInitBean.getExtraTypeInfo() == null) {
            return;
        }
        int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
        RFWLog.i("QFSPersonalCollectPart", RFWLog.DEV, "[initViewPagerPos] -> sourceType = " + i3);
        if (i3 == 20109) {
            this.D.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.F9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9() {
        this.D.setCurrentItem(com.tencent.biz.qqcircle.immersive.personal.utils.j.h(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int, boolean] */
    public void H9(int i3) {
        int i16;
        int i17;
        boolean z16;
        ?? r06;
        int i18;
        boolean z17 = true;
        if (com.tencent.biz.qqcircle.immersive.personal.utils.j.a()) {
            if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.g()) {
                r06 = 1;
            } else {
                r06 = 0;
            }
            this.f89374e.setTypeface(Typeface.defaultFromStyle(r06));
            this.f89374e.setSelected(r06);
            View view = this.C;
            if (r06 != 0 && this.F.v2().z()) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            view.setVisibility(i18);
        }
        TextView textView = this.f89375f;
        if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.i()) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        textView.setTypeface(Typeface.defaultFromStyle(i16));
        TextView textView2 = this.f89376h;
        if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.h()) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        textView2.setTypeface(Typeface.defaultFromStyle(i17));
        TextView textView3 = this.f89375f;
        if (i3 == com.tencent.biz.qqcircle.immersive.personal.utils.j.i()) {
            z16 = true;
        } else {
            z16 = false;
        }
        textView3.setSelected(z16);
        TextView textView4 = this.f89376h;
        if (i3 != com.tencent.biz.qqcircle.immersive.personal.utils.j.h()) {
            z17 = false;
        }
        textView4.setSelected(z17);
    }

    private void initViewModel() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.G;
        if (qFSPersonalDetailsFragment == null) {
            QLog.i("QFSPersonalCollectPart", 1, "fsPersonalHomeFragment is null");
        } else {
            this.F = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) qFSPersonalDetailsFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
    }

    public void G9(Bundle bundle) {
        if (bundle == null) {
            this.D.setCurrentItem(com.tencent.biz.qqcircle.immersive.personal.utils.j.i(), false);
            E9();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSetViewPagerOrientationEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f57292mx && id5 != R.id.f56002jf) {
            if (id5 != R.id.f57282mw && id5 != R.id.f55962jb) {
                if (id5 == R.id.f55972jc) {
                    this.D.setCurrentItem(com.tencent.biz.qqcircle.immersive.personal.utils.j.g());
                } else if (id5 == R.id.f44471p_ || id5 == R.id.f56512kt) {
                    new QFSPersonalNewCollectBoxBottomSheet(getContext(), getPartRootView(), new com.tencent.biz.qqcircle.immersive.personal.bean.n(1), getReportBean()).show();
                }
            } else {
                this.D.setCurrentItem(com.tencent.biz.qqcircle.immersive.personal.utils.j.h());
            }
        } else {
            this.D.setCurrentItem(com.tencent.biz.qqcircle.immersive.personal.utils.j.i());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.D.unregisterOnPageChangeCallback(this.H);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSetViewPagerOrientationEvent) {
            C9((QFSSetViewPagerOrientationEvent) simpleBaseEvent);
        }
    }
}

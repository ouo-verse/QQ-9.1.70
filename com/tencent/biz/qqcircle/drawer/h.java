package com.tencent.biz.qqcircle.drawer;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.drawer.QFSBannerRoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.drawer.h;
import com.tencent.biz.qqcircle.immersive.adapter.QFSDrawerBannerAdapter;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedBannerIndicator;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;
import trpcprotocol.feedcloud.sidebar.DrawerType;
import trpcprotocol.feedcloud.sidebar.JumpInfo;
import trpcprotocol.feedcloud.sidebar.Navbar;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends AbsListItemAdapterDelegate<f, f, a> implements com.tencent.biz.qqcircle.drawer.a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f84398f = cx.a(24.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final int f84399h = cx.a(24.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final int f84400i = cx.a(6.0f);

    /* renamed from: d, reason: collision with root package name */
    private f f84401d;

    /* renamed from: e, reason: collision with root package name */
    private a f84402e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder implements QFSBannerRoundCorneredFrameLayout.a {
        private View E;
        private QFSImageBanner F;
        private QFSDrawerBannerAdapter G;
        private QFSMixFeedBannerIndicator H;
        private QFSBannerRoundCorneredFrameLayout I;
        private int J;
        private com.tencent.biz.qqcircle.drawer.a K;
        private f L;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.drawer.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0868a extends ViewPager2.OnPageChangeCallback {
            C0868a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                super.onPageScrollStateChanged(i3);
                if (i3 == 0) {
                    VideoReport.traversePage(a.this.F);
                }
            }
        }

        public a(@NonNull View view) {
            super(view);
            this.J = 0;
            s(view);
            this.I.setChildTouchEventDelegate(this);
            this.F.q0(new C0868a());
        }

        private void o() {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams == null) {
                QLog.e("QFSDrawerOperationsBannerViewHolder", 1, "[adjustImageBannerSize] layout params == null");
            } else {
                layoutParams.height = ((int) (cx.a(231.4f) * 0.562f)) + cx.a(32.0f);
                this.itemView.setLayoutParams(layoutParams);
            }
        }

        private com.tencent.biz.qqcircle.drawer.a q(View view) {
            if (this.K == null) {
                this.K = (com.tencent.biz.qqcircle.drawer.a) RFWIocAbilityProvider.g().getIocInterface(com.tencent.biz.qqcircle.drawer.a.class, view, null);
            }
            return this.K;
        }

        private void r(final List<Navbar> list) {
            if (list == null) {
                QLog.d("QFSDrawerOperationsBannerViewHolder", 1, "[initBanner] navbarList is null");
                return;
            }
            this.I.setVisibility(0);
            if (this.G == null) {
                QFSDrawerBannerAdapter qFSDrawerBannerAdapter = new QFSDrawerBannerAdapter();
                this.G = qFSDrawerBannerAdapter;
                this.F.setAdapter(qFSDrawerBannerAdapter);
            }
            this.G.setData(list);
            this.G.notifyDataSetChanged();
            this.G.s0(3000L);
            this.F.setEnableOperate(true);
            this.G.setEnableLoop(true);
            this.F.setEnableLoopAfterUserSlide(true);
            QLog.d("QFSDrawerOperationsBannerViewHolder", 1, "[initBanner] navbarList is " + list.size());
            this.H.setCount(list.size());
            this.J = list.size();
            this.F.setOnItemClickListener(new QFSImageBanner.c() { // from class: com.tencent.biz.qqcircle.drawer.g
                @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
                public final void onItemClick(int i3) {
                    h.a.this.u(list, i3);
                }
            });
            w(0);
        }

        private void s(View view) {
            this.E = view;
            this.I = (QFSBannerRoundCorneredFrameLayout) view.findViewById(R.id.f3664154);
            this.F = (QFSImageBanner) view.findViewById(R.id.f3666156);
            QFSMixFeedBannerIndicator qFSMixFeedBannerIndicator = (QFSMixFeedBannerIndicator) view.findViewById(R.id.f3665155);
            this.H = qFSMixFeedBannerIndicator;
            qFSMixFeedBannerIndicator.b(this.F);
            this.I.setClickable(true);
            float a16 = cx.a(4.0f);
            this.I.setRadius(a16, a16, a16, a16);
            o();
        }

        private boolean t() {
            if (this.F == null) {
                QLog.e("QFSDrawerOperationsBannerViewHolder", 1, "[isIllegalBannerOrSingleBanner] mImageBanner is null");
                return true;
            }
            if (this.J <= 1) {
                QLog.d("QFSDrawerOperationsBannerViewHolder", 1, "[isIllegalBannerOrSingleBanner] mBannerCount = " + this.J);
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(List list, int i3) {
            QLog.i("QFSDrawerOperationsBannerViewHolder", 1, "[setOnItemClickListener] -> position = " + i3 + ", itemInfos.size() = " + list.size());
            if (list.size() <= i3) {
                return;
            }
            com.tencent.biz.qqcircle.drawer.a q16 = q(this.E);
            if (q16 == null) {
                QLog.d("QFSDrawerOperationsBannerViewHolder", 1, "[onClick] ioc is null");
            } else {
                q16.a(this.E, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(int i3) {
            QFSImageBanner qFSImageBanner = this.F;
            if (qFSImageBanner == null) {
                return;
            }
            qFSImageBanner.setCurrentItem(i3, false);
            this.F.v0();
        }

        @Override // com.tencent.biz.qqcircle.drawer.QFSBannerRoundCorneredFrameLayout.a
        public boolean f(View view, MotionEvent motionEvent) {
            f fVar = this.L;
            if (fVar == null || fVar.d() == null || this.L.d().size() <= 1) {
                return false;
            }
            return true;
        }

        public void p(f fVar) {
            this.L = fVar;
            if (fVar == null) {
                return;
            }
            r(fVar.d());
        }

        public void v() {
            if (t()) {
                return;
            }
            if (!this.F.l0()) {
                QLog.e("QFSDrawerOperationsBannerViewHolder", 1, "[stopBanner] mImageBanner is not playing");
            } else {
                this.F.y0();
            }
        }
    }

    private void e(View view, Navbar navbar, int i3) {
        String str;
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_DRAWER_BANNER);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_item_index", Integer.valueOf(i3 + 1));
        if (navbar != null) {
            str = navbar.clientReportInfo;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            buildElementParams.put("xsj_task_id", str);
        } else {
            QLog.e("QFSDrawerOperationsBannerItemDelegate", 1, "[reportBannerItemClickDT] taskId is empty");
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.drawer.a
    public void a(View view, int i3) {
        List<Navbar> d16;
        String str;
        JumpInfo jumpInfo;
        if (view == null) {
            QLog.e("QFSDrawerOperationsBannerItemDelegate", 1, "[handleBannerPicClick] view is null");
            return;
        }
        f fVar = this.f84401d;
        if (fVar == null) {
            d16 = null;
        } else {
            d16 = fVar.d();
        }
        if (d16 == null) {
            QLog.e("QFSDrawerOperationsBannerItemDelegate", 1, "[handleBannerPicClick] navBar is null");
            return;
        }
        if (d16.size() < i3) {
            QLog.e("QFSDrawerOperationsBannerItemDelegate", 1, "[handleBannerPicClick] navBar data error, size:" + d16.size() + ", pos:" + i3);
            return;
        }
        Navbar navbar = d16.get(i3);
        if (navbar != null && (jumpInfo = navbar.jumpInfo) != null) {
            str = jumpInfo.link;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSDrawerOperationsBannerItemDelegate", 1, "[handleBannerPicClick] jumpUrl is empty, pos:" + i3);
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), str);
        e(view, navbar, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull f fVar, @NonNull List<f> list, int i3) {
        if (fVar.b() == DrawerType.DRAWER_TYPE_NAVBAR) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull f fVar, @NonNull a aVar, int i3, @NonNull List<Object> list) {
        this.f84401d = fVar;
        aVar.p(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        RFWIocAbilityProvider.g().registerIoc(viewGroup, this, com.tencent.biz.qqcircle.drawer.a.class);
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_o, viewGroup, false));
        this.f84402e = aVar;
        return aVar;
    }

    public void f() {
        a aVar = this.f84402e;
        if (aVar == null) {
            return;
        }
        aVar.v();
    }

    public void g(int i3) {
        a aVar = this.f84402e;
        if (aVar != null) {
            aVar.w(i3);
        }
    }
}

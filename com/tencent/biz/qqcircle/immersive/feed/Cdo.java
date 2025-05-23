package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSFeedPymkBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* renamed from: com.tencent.biz.qqcircle.immersive.feed.do, reason: invalid class name */
/* loaded from: classes4.dex */
public class Cdo extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: d0, reason: collision with root package name */
    private static final int f86114d0 = com.tencent.biz.qqcircle.utils.cx.a(12.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f86115e0 = com.tencent.biz.qqcircle.utils.cx.a(1.0f);

    /* renamed from: f0, reason: collision with root package name */
    private static final int f86116f0 = com.tencent.biz.qqcircle.utils.cx.a(15.0f);

    /* renamed from: g0, reason: collision with root package name */
    private static final int f86117g0 = com.tencent.biz.qqcircle.utils.cx.a(2.0f);

    /* renamed from: h0, reason: collision with root package name */
    private static final int f86118h0 = com.tencent.biz.qqcircle.utils.cx.a(2.0f);

    /* renamed from: i0, reason: collision with root package name */
    private static final int f86119i0 = com.tencent.biz.qqcircle.utils.cx.a(6.0f);

    /* renamed from: j0, reason: collision with root package name */
    private static final int f86120j0 = com.tencent.biz.qqcircle.utils.cx.a(16.0f);

    /* renamed from: k0, reason: collision with root package name */
    private static final int f86121k0 = com.tencent.biz.qqcircle.utils.cx.a(12.0f);

    /* renamed from: l0, reason: collision with root package name */
    private static final int f86122l0 = com.tencent.biz.qqcircle.utils.cx.a(20.0f);
    private ViewStub I;
    private LinearLayout J;
    private QCircleAvatarView K;
    private TextView L;
    private TextView M;
    private View N;
    private TextView P;
    private TextView Q;
    private QCircleAvatarListView R;
    private LinearLayout S;
    private LinearLayout T;
    private ImageView U;
    private QFSFollowView V;
    private Button W;
    private com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a X;
    private Observer<QFSFeedPymkBean> Y;
    private Size Z;

    /* renamed from: b0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f86124b0;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f86123a0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private int f86125c0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$a */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSFeedPymkBean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSFeedPymkBean qFSFeedPymkBean) {
            Cdo.this.D1(qFSFeedPymkBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$c */
    /* loaded from: classes4.dex */
    public class c implements QFSPersonalFeedBaseAdapter.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.b
        public void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
            if (!fb0.a.a("fast_click_layer_feed_pymk")) {
                Cdo.this.o1(i3, eVar, qCircleBaseWidgetView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$d */
    /* loaded from: classes4.dex */
    public class d implements QFSFollowView.c {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
        public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
            String str;
            if (Cdo.this.X != null && z16) {
                int i3 = 2;
                Cdo.this.q1(2);
                QFSFeedPymkBean L1 = Cdo.this.X.L1();
                if (L1 == null) {
                    return;
                }
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, L1.getUin());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, L1.getDatongJsonData());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, L1.getWorksNum());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_FANS_NUM, L1.getFansNum());
                if (uq3.c.s()) {
                    str = QCircleDaTongConstant.ElementParamValue.NEW;
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
                if (!Cdo.this.f86123a0) {
                    i3 = 1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, Integer.valueOf(i3));
                Cdo cdo = Cdo.this;
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_TRIGGER, cdo.x1(cdo.E));
                VideoReport.setElementId(Cdo.this.V, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, Cdo.this.V, buildElementParams);
                Cdo.this.X.S1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$e */
    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Cdo> f86132a;

        e(Cdo cdo) {
            this.f86132a = new WeakReference<>(cdo);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            int i3;
            if (this.f86132a.get() == null) {
                return null;
            }
            Cdo cdo = this.f86132a.get();
            QFSFeedPymkBean L1 = cdo.X.L1();
            if (L1 == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, L1.getUin());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, L1.getDatongJsonData());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, L1.getWorksNum());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_FANS_NUM, L1.getFansNum());
            T t16 = cdo.f85017h;
            if (t16 != 0) {
                if (((FeedCloudMeta$StFeed) t16).dittoFeed.dittoId.get() == 34) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, Integer.valueOf(i3));
            }
            if (uq3.c.s()) {
                str2 = QCircleDaTongConstant.ElementParamValue.NEW;
            } else {
                str2 = QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
            return buildElementParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$f */
    /* loaded from: classes4.dex */
    public static class f implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Cdo> f86133a;

        f(Cdo cdo) {
            this.f86133a = new WeakReference<>(cdo);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            if (this.f86133a.get() == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_CHANGE_TMS, Integer.valueOf(this.f86133a.get().u1()));
            return buildElementParams;
        }
    }

    private void A1() {
        int i3;
        if (this.I.getParent() == null) {
            return;
        }
        View inflate = this.I.inflate();
        this.J = (LinearLayout) inflate.findViewById(R.id.f46011tf);
        this.K = (QCircleAvatarView) inflate.findViewById(R.id.f44221ol);
        this.L = (TextView) inflate.findViewById(R.id.f56092jo);
        this.T = (LinearLayout) inflate.findViewById(R.id.f41131g9);
        this.M = (TextView) inflate.findViewById(R.id.f56102jp);
        this.N = inflate.findViewById(R.id.f57302my);
        this.P = (TextView) inflate.findViewById(R.id.f56082jn);
        this.Q = (TextView) inflate.findViewById(R.id.f56112jq);
        this.R = (QCircleAvatarListView) inflate.findViewById(R.id.f41121g8);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f41111g7);
        this.U = imageView;
        if (uq3.c.s()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.U.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.K.setOnClickListener(this);
        VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
        VideoReport.setEventDynamicParams(this.J, new e(this));
        VideoReport.setElementId(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_NAME);
        VideoReport.setElementId(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_AVATAR);
        VideoReport.setElementId(this.U, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_NEW_CLOSE_BUTTON);
    }

    private void B1() {
        this.X = (com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a) A0(com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a.class);
        w20.a.j().registerDisplaySurface(this.X.hashCode() + "", this.X);
        this.Y = new a();
        this.X.M1().observeForever(this.Y);
    }

    private void C1() {
        com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a aVar = this.X;
        if (aVar != null && aVar.L1() != null && !TextUtils.isEmpty(this.X.L1().getUin())) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(this.X.L1().getUin());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(QFSFeedPymkBean qFSFeedPymkBean) {
        if (qFSFeedPymkBean == null) {
            s1();
            return;
        }
        VideoReport.setElementReuseIdentifier(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM + qFSFeedPymkBean.getUin());
        VideoReport.traverseExposure();
        q1(1);
        if (qFSFeedPymkBean.getIsFirstData()) {
            I1(qFSFeedPymkBean);
        } else {
            F1(qFSFeedPymkBean);
        }
    }

    private void F1(QFSFeedPymkBean qFSFeedPymkBean) {
        LinearLayout linearLayout = this.J;
        if (linearLayout == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.J, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setStartDelay(120L);
        ofFloat2.setDuration(200L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.J, BasicAnimation.KeyPath.SCALE_X, 0.6f, 1.0f);
        ofFloat3.setDuration(320L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.J, BasicAnimation.KeyPath.SCALE_Y, 0.6f, 1.0f);
        ofFloat4.setDuration(320L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat3).with(ofFloat4).with(ofFloat2).after(ofFloat);
        animatorSet.start();
        ofFloat.addListener(new b(qFSFeedPymkBean, ofFloat));
    }

    private void G1(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void H1(@NonNull QFSFeedPymkBean qFSFeedPymkBean) {
        if (this.V == null) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(qFSFeedPymkBean.getUin());
        feedCloudMeta$StUser.followState.set(qFSFeedPymkBean.getFollowState());
        this.V.setUserData(feedCloudMeta$StUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(QFSFeedPymkBean qFSFeedPymkBean) {
        if (qFSFeedPymkBean == null) {
            return;
        }
        M1(qFSFeedPymkBean);
        if (uq3.c.s()) {
            G1(this.T, false);
            N1(qFSFeedPymkBean);
        } else {
            G1(this.S, false);
            J1(qFSFeedPymkBean);
        }
        K1(qFSFeedPymkBean.getFeedBlockData());
        L1(qFSFeedPymkBean.getRelationUserList(), qFSFeedPymkBean.getRecommend());
        H1(qFSFeedPymkBean);
    }

    private void J1(@NonNull QFSFeedPymkBean qFSFeedPymkBean) {
        if (this.M != null && this.N != null && this.P != null) {
            G1(this.T, true);
            try {
                this.M.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(Long.parseLong(qFSFeedPymkBean.getWorksNum())) + " " + com.tencent.biz.qqcircle.utils.h.a(R.string.f184183l7));
                if (TextUtils.isEmpty(qFSFeedPymkBean.getFansNum())) {
                    this.P.setText("");
                    this.N.setVisibility(8);
                } else {
                    this.P.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(Long.parseLong(qFSFeedPymkBean.getFansNum())) + " " + com.tencent.biz.qqcircle.utils.h.a(R.string.f183163if));
                    this.N.setVisibility(0);
                }
            } catch (NumberFormatException e16) {
                QLog.e("QFSLayerFeedNewPYMKItemPresenter", 1, "parse fansNum or worksNum error ! " + e16.getMessage());
                this.M.setText("");
                this.P.setText("");
                this.N.setVisibility(8);
            }
        }
    }

    private void K1(List<e30.b> list) {
        LinearLayout linearLayout;
        if (list != null && !list.isEmpty() && (linearLayout = this.J) != null) {
            View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
            if (childAt instanceof RecyclerView) {
                this.J.removeView(childAt);
            }
            List<com.tencent.biz.qqcircle.immersive.personal.bean.e> arrayList = new ArrayList<>();
            Iterator<e30.b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.e(it.next()));
            }
            if (arrayList.size() > 3) {
                arrayList = arrayList.subList(0, 3);
            }
            int j3 = com.tencent.biz.qqcircle.utils.cx.j(com.tencent.biz.qqcircle.utils.bz.j()) - 56;
            int size = (j3 - ((arrayList.size() * (j3 - 32)) / 3)) / 2;
            com.tencent.biz.qqcircle.adapter.al alVar = new com.tencent.biz.qqcircle.adapter.al(null);
            alVar.p0(new c());
            RecyclerView recyclerView = new RecyclerView(m0());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            float f16 = size;
            layoutParams.setMargins(com.tencent.biz.qqcircle.utils.cx.a(f16), f86122l0, com.tencent.biz.qqcircle.utils.cx.a(f16), 0);
            recyclerView.setLayoutParams(layoutParams);
            this.J.addView(recyclerView);
            recyclerView.setLayoutManager(new SafeGridLayoutManager(m0(), arrayList.size()));
            recyclerView.setAdapter(alVar);
            alVar.setDatas(arrayList);
        }
    }

    private void L1(List<FeedCloudMeta$StUser> list, String str) {
        QCircleAvatarListView qCircleAvatarListView;
        int i3;
        String sb5;
        String str2;
        if (list != null && !TextUtils.isEmpty(str) && (qCircleAvatarListView = this.R) != null && this.Q != null) {
            if (list.isEmpty()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            qCircleAvatarListView.setVisibility(i3);
            if (list.isEmpty()) {
                this.Q.setText(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb6 = new StringBuilder();
            for (int i16 = 0; i16 < list.size(); i16++) {
                arrayList.add(list.get(i16).f398463id.get());
                sb6.append(list.get(i16).nick.get());
                if (i16 < list.size() - 1) {
                    str2 = "\u3001";
                } else {
                    str2 = "";
                }
                sb6.append(str2);
            }
            this.R.setData(arrayList);
            if (sb6.length() > 10) {
                sb5 = sb6.substring(0, 9) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            } else {
                sb5 = sb6.toString();
            }
            this.Q.setText(sb5 + str);
        }
    }

    private void M1(@NonNull QFSFeedPymkBean qFSFeedPymkBean) {
        QCircleAvatarView qCircleAvatarView = this.K;
        if (qCircleAvatarView != null && this.L != null) {
            qCircleAvatarView.setAvatar(qFSFeedPymkBean.getAvatarUrl(), qFSFeedPymkBean.getUin(), this.Z);
            this.K.setIsAuth(qFSFeedPymkBean.getAuthType());
            this.L.setText(qFSFeedPymkBean.getName());
        }
    }

    private void N1(@NonNull QFSFeedPymkBean qFSFeedPymkBean) {
        List<FeedCloudCommon$Entry> tagList = qFSFeedPymkBean.getTagList();
        if (this.J != null && tagList != null) {
            if (this.S == null) {
                this.S = new LinearLayout(m0());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i3 = f86120j0;
                layoutParams.leftMargin = i3;
                layoutParams.rightMargin = i3;
                layoutParams.topMargin = f86121k0;
                this.S.setLayoutParams(layoutParams);
                this.S.setOrientation(0);
                this.J.addView(this.S, 2);
            }
            this.S.removeAllViews();
            if (tagList.isEmpty()) {
                G1(this.S, false);
                J1(qFSFeedPymkBean);
                return;
            }
            G1(this.S, true);
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : tagList) {
                LinearLayout linearLayout = new LinearLayout(m0());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                int i16 = f86117g0;
                layoutParams2.leftMargin = i16;
                layoutParams2.rightMargin = i16;
                linearLayout.setLayoutParams(layoutParams2);
                int i17 = f86119i0;
                int i18 = f86118h0;
                linearLayout.setPadding(i17, i18, i17, i18);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.l8a));
                TextView w16 = w1(feedCloudCommon$Entry.key.get());
                ImageView v16 = v1(feedCloudCommon$Entry.value.get());
                if (v16 != null) {
                    linearLayout.addView(v16);
                }
                if (w16 != null) {
                    linearLayout.addView(w16);
                }
                this.S.addView(linearLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (eVar != null && qCircleBaseWidgetView != null && this.X != null) {
            QCircleLayerBean p16 = p1(i3, eVar);
            int[] iArr = new int[2];
            qCircleBaseWidgetView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            p16.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], qCircleBaseWidgetView.getWidth() + i16, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(eVar.a()));
            if (qCircleBaseWidgetView.getChildCount() > 0 && (qCircleBaseWidgetView.getChildAt(0) instanceof FrameLayout) && ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildCount() > 0 && (((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0) instanceof ImageView)) {
                p16.getTransitionAnimBean().setCoverDrawable(((ImageView) ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0)).getDrawable());
            }
            com.tencent.biz.qqcircle.launcher.c.u(m0(), p16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(int i3) {
        r1(608, i3);
    }

    private void r1(int i3, int i16) {
        com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a aVar = this.X;
        if (aVar != null && aVar.L1() != null) {
            QFSFeedPymkBean L1 = this.X.L1();
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(L1.getUin()).setExt1(L1.getWorksNum()).setExt2(L1.getFansNum()).setExt10(L1.getTraceId()).setPageId(y0()).setActTime(System.currentTimeMillis()).setFirstFeedId(w20.a.j().h());
            if (L1.getBusiReport() != null) {
                dataBuilder.setReportInfo(L1.getBusiReport());
            }
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s1() {
        if (this.f85017h == 0) {
            RFWLog.e("QFSLayerFeedNewPYMKItemPresenter", RFWLog.USR, "[deletePymkItem] feed is null. ");
            return;
        }
        QCircleFeedEvent qCircleFeedEvent = new QCircleFeedEvent(3);
        qCircleFeedEvent.mTargetId = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
        SimpleEventBus.getInstance().dispatchEvent(qCircleFeedEvent);
    }

    private void t1(View view, String str, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(str, buildElementParams);
    }

    private ImageView v1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ImageView imageView = new ImageView(m0());
        int i3 = f86114d0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.rightMargin = f86115e0;
        imageView.setLayoutParams(layoutParams);
        Option loadingDrawableColor = Option.obtain().setUrl(str).setRequestWidth(i3).setRequestHeight(i3).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
        return imageView;
    }

    private TextView w1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextView textView = new TextView(m0());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, f86116f0));
        textView.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.cmd));
        textView.setTextSize(1, 11.0f);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(str);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x1(e30.b bVar) {
        if (bVar == null) {
            return "";
        }
        return QCirclePluginUtil.getValueFromListEntry(((QQCircleDitto$StCircleDittoDataNew) bVar.b(String.valueOf(bVar.g().dittoFeed.dittoId.get()))).itemContainter.get().busiInfo.get(), "pymk_trigger_event");
    }

    private void y1(View view) {
        this.W = (Button) view.findViewById(R.id.f44911qg);
        this.V = (QFSFollowView) view.findViewById(R.id.f44891qe);
    }

    private void z1() {
        QFSFollowView qFSFollowView = this.V;
        if (qFSFollowView == null) {
            return;
        }
        qFSFollowView.setFollowStateChangeListener(new d());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        this.f86124b0 = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 34) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f86123a0 = z16;
        if (!z16) {
            LinearLayout linearLayout = this.J;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.V.setVisibility(8);
            return;
        }
        VideoReport.setEventDynamicParams(this.C, new f(this));
        this.W.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1913144g));
        this.W.setOnClickListener(this);
        A1();
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()))).itemContainter.get();
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        if (this.X != null && list != null && list.size() > 0) {
            this.X.Q1(qQCircleDitto$StItemContainer.busiInfo.get());
            this.X.R1(this.f86124b0, list.get(0), true);
            this.V.setVisibility(0);
            this.J.setVisibility(0);
        } else {
            this.V.setVisibility(8);
            this.J.setVisibility(8);
        }
        z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a aVar = this.X;
        if (aVar != null) {
            aVar.M1().observeForever(this.Y);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        com.tencent.biz.qqcircle.immersive.viewmodel.pymk.a aVar = this.X;
        if (aVar != null) {
            aVar.M1().removeObserver(this.Y);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        y1(view);
        this.Z = com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.f159410d35);
        this.I = (ViewStub) view.findViewById(R.id.f57412n9);
        B1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f44911qg) {
            if (this.f86123a0 && this.X != null) {
                this.f86125c0++;
                r1(607, 3);
                t1(view, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CHANGE_ITEM_LIST, null);
                this.X.S1();
            }
        } else if (id5 == R.id.f41111g7) {
            this.X.S1();
            r1(609, 3);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f184673mi), 0);
        } else if (id5 == R.id.f44221ol) {
            q1(10);
            C1();
        } else if (id5 == R.id.f56092jo) {
            q1(11);
            C1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.f86125c0 = 0;
    }

    public QCircleLayerBean p1(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        if (getReportBean() != null) {
            qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        }
        if (eVar != null) {
            qCircleLayerBean.setFeed(eVar.b());
        }
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.X.hashCode() + "");
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }

    public int u1() {
        return this.f86125c0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLayerFeedNewPYMKItemPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.do$b */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSFeedPymkBean f86127d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f86128e;

        b(QFSFeedPymkBean qFSFeedPymkBean, ObjectAnimator objectAnimator) {
            this.f86127d = qFSFeedPymkBean;
            this.f86128e = objectAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Cdo.this.I1(this.f86127d);
            this.f86128e.removeAllListeners();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

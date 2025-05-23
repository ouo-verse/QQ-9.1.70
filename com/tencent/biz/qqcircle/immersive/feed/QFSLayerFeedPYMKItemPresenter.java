package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFriendFooterViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleMultiFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSLayerFeedPYMKItemPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ImageView I;
    private TextView J;
    private TextView K;
    private Button L;
    private Button M;
    private QFSFollowView N;
    private RecyclerView P;
    private Button Q;
    private ImageView R;
    private View S;
    private View T;
    private View U;
    private LinearLayout V;
    private LinearLayout W;
    private ViewStub X;
    private ViewStub Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f85302a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f85303b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<QQCircleDitto$StItemInfo> f85304c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.i f85305d0;

    /* renamed from: e0, reason: collision with root package name */
    private View.OnClickListener f85306e0;

    /* renamed from: f0, reason: collision with root package name */
    private View.OnClickListener f85307f0;

    /* renamed from: g0, reason: collision with root package name */
    private View.OnClickListener f85308g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.manager.j f85309h0;

    /* renamed from: i0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f85310i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f85311j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f85312k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f85313l0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends SafeLinearLayoutManager {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!fb0.a.a("QCirclePYMKFeedFollowBtnClick")) {
                QFSLayerFeedPYMKItemPresenter.this.w1();
                QFSLayerFeedPYMKItemPresenter.this.v1(view, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_FOLLOW_ALL_ITEM, null);
                QFSLayerFeedPYMKItemPresenter.this.s1(4, 0L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!fb0.a.a("QCirclePYMKFeedGetNewBtnClick")) {
                QFSLayerFeedPYMKItemPresenter.this.f85312k0++;
                int i3 = 0;
                QFSLayerFeedPYMKItemPresenter.this.O1(false);
                Button button = QFSLayerFeedPYMKItemPresenter.this.M;
                if (!QFSLayerFeedPYMKItemPresenter.this.L1()) {
                    i3 = 8;
                }
                button.setVisibility(i3);
                QFSLayerFeedPYMKItemPresenter.this.v1(view, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_CHANGE_ITEM_LIST, null);
                QFSLayerFeedPYMKItemPresenter.this.s1(3, 0L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!fb0.a.a("QCirclePYMKFeedEmptyLayoutBtnClick")) {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(6).needScrollTop().needSmoothScroll());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSLayerFeedPYMKItemPresenter> f85318a;

        e(QFSLayerFeedPYMKItemPresenter qFSLayerFeedPYMKItemPresenter) {
            this.f85318a = new WeakReference<>(qFSLayerFeedPYMKItemPresenter);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            if (this.f85318a.get() == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_CHANGE_TMS, Integer.valueOf(this.f85318a.get().x1()));
            return buildElementParams;
        }
    }

    private View.OnClickListener A1() {
        View.OnClickListener onClickListener = this.f85308g0;
        if (onClickListener != null) {
            return onClickListener;
        }
        d dVar = new d();
        this.f85308g0 = dVar;
        return dVar;
    }

    private String B1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer == null) {
            return "";
        }
        return QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemContainer.busiInfo.get(), "load_more_guide_text");
    }

    private View.OnClickListener C1() {
        View.OnClickListener onClickListener = this.f85306e0;
        if (onClickListener != null) {
            return onClickListener;
        }
        c cVar = new c();
        this.f85306e0 = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        if (this.M == null) {
            return;
        }
        O1(true);
        P1();
    }

    private void E1(QFSFriendFooterViewEvent qFSFriendFooterViewEvent) {
        LinearLayout linearLayout;
        if (y0() == 504 && (linearLayout = this.W) != null) {
            if (qFSFriendFooterViewEvent.mIsPulling) {
                linearLayout.setVisibility(4);
            } else {
                linearLayout.setVisibility(0);
            }
        }
    }

    private void F1() {
        View view = this.U;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.S;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.T.setVisibility(0);
        this.P.setVisibility(0);
    }

    private void G1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (this.I != null && qQCircleDitto$StItemContainer != null) {
            String a16 = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemContainer.urlInfo.get(), IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL);
            if (TextUtils.isEmpty(a16)) {
                RFWLog.i("QFSLayerFeedPYMKItemPresenter", RFWLog.USR, "[initBg] -> bgUrl is empty");
                a16 = QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg");
            }
            Option loadingDrawableColor = Option.obtain().setUrl(a16).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.g()).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.f()).setTargetView(this.I).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
            loadingDrawableColor.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
        }
    }

    private void H1(View view) {
        this.T = view.findViewById(R.id.f44921qh);
        this.L = (Button) view.findViewById(R.id.f44911qg);
        this.M = (Button) view.findViewById(R.id.f44901qf);
        this.N = (QFSFollowView) view.findViewById(R.id.f44891qe);
        this.Z = (ImageView) view.findViewById(R.id.f46731vd);
        this.W = (LinearLayout) view.findViewById(R.id.f44971qm);
        this.M.setOnClickListener(y1());
        q1();
    }

    private void I1() {
        ImageView imageView = this.Z;
        if (imageView == null) {
            return;
        }
        imageView.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.Z.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void J1() {
        if (this.X != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f44991qo);
        this.X = viewStub;
        View inflate = viewStub.inflate();
        this.S = inflate;
        this.V = (LinearLayout) inflate.findViewById(R.id.f45021qr);
        this.J = (TextView) this.S.findViewById(R.id.f45011qq);
    }

    private void K1(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f45041qt);
        this.P = recyclerView;
        a aVar = new a(recyclerView.getContext());
        aVar.setOrientation(1);
        this.P.setLayoutManager(aVar);
        com.tencent.biz.qqcircle.immersive.adapter.i iVar = new com.tencent.biz.qqcircle.immersive.adapter.i();
        this.f85305d0 = iVar;
        this.P.setAdapter(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L1() {
        List<QQCircleDitto$StItemInfo> list = this.f85304c0;
        if (list == null || list.size() < 3 || (y0() == 504 && com.tencent.biz.qqcircle.immersive.tab.c.f90017a.a())) {
            return false;
        }
        Iterator<QQCircleDitto$StItemInfo> it = this.f85304c0.iterator();
        while (it.hasNext()) {
            if (!com.tencent.biz.qqcircle.manager.j.e(it.next(), y0())) {
                return true;
            }
        }
        return false;
    }

    private boolean M1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer == null) {
            return false;
        }
        return TextUtils.equals("1", QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemContainer.busiInfo.get(), "not_show_empty_page"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(boolean z16) {
        this.f85309h0.g(z16);
        List<QQCircleDitto$StItemInfo> b16 = this.f85309h0.b();
        this.f85304c0 = b16;
        if (b16.size() < 3) {
            S1();
        }
        this.f85305d0.setData(this.f85304c0);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSLayerFeedPYMKItemPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.traversePage(QFSLayerFeedPYMKItemPresenter.this.P);
            }
        });
    }

    private void P1() {
        int i3;
        if (this.M != null && m0() != null) {
            this.M.setText(R.string.f1912444_);
            this.M.setTextColor(m0().getColor(R.color.cla));
            this.M.setBackgroundResource(R.drawable.qvideo_skin_bg_btn_primary_normal);
            this.M.setClickable(true);
            Button button = this.M;
            if (L1()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            button.setVisibility(i3);
        }
    }

    private void Q1() {
        if (this.M != null && m0() != null) {
            this.M.setText(R.string.f1905342c);
            this.M.setTextColor(m0().getColor(R.color.cmc));
            this.M.setBackgroundResource(R.drawable.qvideo_skin_bg_btn_primary_pressed);
            this.M.setClickable(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        T t16;
        if (uq3.c.s() && (t16 = this.f85017h) != 0 && ((FeedCloudMeta$StFeed) t16).dittoFeed.dittoId.get() == 34) {
            return;
        }
        J1();
        if (this.J == null) {
            QLog.e("QFSLayerFeedPYMKItemPresenter", 1, "[setTitle] pymk single title should not null.");
            return;
        }
        String str = qQCircleDitto$StItemContainer.title.get();
        QLog.d("QFSLayerFeedPYMKItemPresenter", 1, "[setTitle] title: " + str);
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
            this.J.setText(qQCircleDitto$StItemContainer.title.get());
        }
    }

    private void S1() {
        ViewStub viewStub;
        if (this.f85303b0) {
            t1();
            return;
        }
        if (this.U == null && (viewStub = this.Y) != null) {
            this.U = viewStub.inflate();
        }
        View view = this.U;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this.U.getContext(), R.anim.f155107wd);
        this.U.clearAnimation();
        this.U.startAnimation(alphaAnimation);
        View findViewById = this.U.findViewById(R.id.f44961ql);
        this.U = findViewById;
        this.R = (ImageView) findViewById.findViewById(R.id.f44951qk);
        Button button = (Button) this.U.findViewById(R.id.f44931qi);
        this.Q = button;
        button.setOnClickListener(A1());
        Option loadingDrawableColor = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("pymk_feed_defaultpic")).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(152.0f)).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(223.0f)).setTargetView(this.R).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
        View view2 = this.S;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.T.setVisibility(8);
        this.P.setVisibility(8);
        this.f85309h0.d();
    }

    private void T1() {
        if (TextUtils.isEmpty(this.f85302a0)) {
            RFWLog.i("QFSLayerFeedPYMKItemPresenter", RFWLog.USR, "[showGuideHint] -> mGuideHint is empty");
            this.W.setVisibility(4);
        } else {
            this.W.setVisibility(0);
            this.K.setText(this.f85302a0);
            I1();
        }
    }

    private void U1(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        if (this.f85313l0) {
            return;
        }
        QCircleFollowManager.getInstance().setUinFollowed(qCircleFollowUpdateEvent.mUserId, qCircleFollowUpdateEvent.mFollowStatus);
        r1();
    }

    private void q1() {
        TextView z16 = z1();
        this.K = z16;
        LinearLayout linearLayout = this.W;
        linearLayout.addView(z16, linearLayout.indexOfChild(this.Z) + 1);
        if (y0() == 504 || uq3.c.s()) {
            this.Z.setRotation(180.0f);
        }
    }

    private void r1() {
        List<QQCircleDitto$StItemInfo> list = this.f85304c0;
        if (list != null && !list.isEmpty()) {
            Iterator<QQCircleDitto$StItemInfo> it = this.f85304c0.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (QCircleFollowManager.getInstance().isUinFollowed(it.next().f429300id.get())) {
                    i3++;
                }
            }
            if (i3 == 3) {
                u1();
                return;
            }
            return;
        }
        QLog.e("QFSLayerFeedPYMKItemPresenter", 1, "[checkHasFollowedAllUser] item list should not be null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(int i3, long j3) {
        if (this.f85310i0 == null) {
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
        dataBuilder.setActionType(607).setSubActionType(i3).setPosition(this.f85311j0).setVideoPlayTime(j3).setVideoTotalTime((this.f85312k0 * 5000) + 5000).setPageId(y0()).setfpageid(Integer.parseInt(t0())).setFirstFeedId(w20.a.j().h());
        if (this.f85310i0.busiReport.has()) {
            dataBuilder.setReportInfo(this.f85310i0.busiReport.get().toByteArray());
        }
        QCircleLpReportDc05507.report(dataBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t1() {
        QCircleFeedEvent qCircleFeedEvent = new QCircleFeedEvent(3);
        qCircleFeedEvent.mTargetId = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
        SimpleEventBus.getInstance().dispatchEvent(qCircleFeedEvent);
    }

    private void u1() {
        if (fb0.a.a("doFollowAllBtnTransform")) {
            return;
        }
        Q1();
        this.M.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSLayerFeedPYMKItemPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerFeedPYMKItemPresenter.this.D1();
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(View view, String str, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(str, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        HashMap hashMap = new HashMap();
        for (QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo : this.f85304c0) {
            if (!QCircleFollowManager.getInstance().isUinFollowed(qQCircleDitto$StItemInfo.f429300id.get())) {
                hashMap.put(qQCircleDitto$StItemInfo.f429300id.get(), 1);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleMultiFollowUpdateEvent(hashMap));
        u1();
    }

    private View.OnClickListener y1() {
        View.OnClickListener onClickListener = this.f85307f0;
        if (onClickListener != null) {
            return onClickListener;
        }
        b bVar = new b();
        this.f85307f0 = bVar;
        return bVar;
    }

    private TextView z1() {
        TextView textView = new TextView(m0());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ImmersiveUtils.dpToPx(6.0f);
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(24.0f);
        layoutParams.topMargin = ImmersiveUtils.dpToPx(15.0f);
        textView.setTextColor(m0().getResources().getColor(R.color.czi, null));
        textView.setTextSize(1, 14.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.Y = (ViewStub) view.findViewById(R.id.f44981qn);
        H1(view);
        K1(view);
        this.I = (ImageView) view.findViewById(R.id.f44881qd);
        this.f85309h0 = new com.tencent.biz.qqcircle.manager.j(3, y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85310i0 = feedCloudMeta$StFeed;
        this.f85311j0 = i3;
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()));
        if (qQCircleDitto$StCircleDittoDataNew != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() != 0) {
            QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = qQCircleDitto$StCircleDittoDataNew.itemContainter.get();
            G1(qQCircleDitto$StItemContainer);
            R1(qQCircleDitto$StItemContainer);
            F1();
            this.f85302a0 = B1(qQCircleDitto$StItemContainer);
            this.f85303b0 = M1(qQCircleDitto$StItemContainer);
            T1();
            int i16 = 0;
            if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 34) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f85313l0 = z16;
            if (z16) {
                this.P.setVisibility(8);
                Button button = this.M;
                if (button != null) {
                    button.setVisibility(8);
                    return;
                }
                return;
            }
            VideoReport.setEventDynamicParams(this.C, new e(this));
            this.L.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1912544a));
            this.L.setOnClickListener(C1());
            this.P.setVisibility(0);
            this.M.setVisibility(0);
            this.N.setVisibility(8);
            this.f85309h0.f(qQCircleDitto$StItemContainer.items.get());
            List<QQCircleDitto$StItemInfo> b16 = this.f85309h0.b();
            this.f85304c0 = b16;
            if (b16.size() < 3) {
                S1();
                return;
            }
            Button button2 = this.M;
            if (!L1()) {
                i16 = 8;
            }
            button2.setVisibility(i16);
            this.f85305d0.setData(this.f85304c0);
            this.f85305d0.i0(this.f85310i0);
            return;
        }
        S1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleFollowUpdateEvent.class);
        eventClass.add(QFSFollowTabLiveListEvent.class);
        eventClass.add(QFSFriendFooterViewEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSFollowView qFSFollowView;
        super.onFeedSelected(rFWFeedSelectInfo);
        this.f85312k0 = 0;
        if (!this.f85313l0 && (qFSFollowView = this.N) != null) {
            qFSFollowView.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            U1((QCircleFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFriendFooterViewEvent) {
            E1((QFSFriendFooterViewEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLayerFeedPYMKItemPresenter";
    }

    public int x1() {
        return this.f85312k0;
    }
}

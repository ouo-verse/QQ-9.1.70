package com.tencent.biz.qqcircle.immersive.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAdItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedBigCardItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedContractItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedEcommerceItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedHobbyLabelItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedHotTagItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedInterestTagItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedLiveItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedMulHotTagItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedODItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedOuterItemViewContainer;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedPYMKItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedPropItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedPublishTemplateItemView;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedTemplateItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends com.tencent.biz.qqcircle.immersive.adapter.a<e30.b> {
    public static final int C = ImmersiveUtils.dpToPx(56.0f);

    /* renamed from: m, reason: collision with root package name */
    private boolean f84725m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends v30.a {
        a() {
        }

        @Override // v30.a, androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            if (!bVar.g().f398449id.get().equals(bVar2.g().f398449id.get()) && !d(bVar, bVar2)) {
                return false;
            }
            return true;
        }

        @Override // v30.a
        public boolean c(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            if (m.this.f84725m || d(bVar, bVar2)) {
                return true;
            }
            if (!com.tencent.biz.qqcircle.rerank.util.a.b(bVar.g()) && com.tencent.biz.qqcircle.rerank.util.a.b(bVar2.g())) {
                return true;
            }
            return false;
        }

        public boolean d(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            return com.tencent.biz.qqcircle.immersive.utils.r.g0(bVar2.g(), bVar.g());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            if (d(bVar, bVar2)) {
                bVar.m(bVar2);
                return bVar2;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        private e30.b E;

        public b(@NonNull View view) {
            super(view);
        }

        private void l(e30.b bVar, int i3) {
            if (bVar != null && bVar.g() != null) {
                FeedCloudMeta$StFeed g16 = bVar.g();
                QLog.d("QFSLayerPageAdapter", 1, "FeedLine_ printBindData feed id:" + g16.f398449id.get() + ", traceId:" + ba.c(bVar) + ",position:" + i3);
                return;
            }
            QLog.e("QFSLayerPageAdapter", 1, "FeedLine_ printBindData feedBlockData is null");
        }

        public void m(e30.b bVar, int i3) {
            if (!(this.itemView instanceof BaseWidgetView)) {
                QLog.e("QFSLayerPageAdapter", 1, "setData  itemView != FSLayerFeedItemView");
                return;
            }
            this.E = bVar;
            l(bVar, i3);
            ((BaseWidgetView) this.itemView).setData(bVar, i3);
        }
    }

    public m() {
        this.f84725m = false;
    }

    private View A0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedBigCardItemView qFSLayerFeedBigCardItemView = new QFSLayerFeedBigCardItemView(viewGroup.getContext(), i3);
        qFSLayerFeedBigCardItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedBigCardItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedBigCardItemView.setReportBean(getReportBean());
        return qFSLayerFeedBigCardItemView;
    }

    private View B0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedItemView qFSLayerFeedItemView = new QFSLayerFeedItemView(viewGroup.getContext(), i3);
        qFSLayerFeedItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedItemView.setReportBean(getReportBean());
        return qFSLayerFeedItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F0(Runnable runnable) {
        RFWThreadManager.getUIHandler().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(List list) {
        setDatasDefault(list);
    }

    private boolean J0(View view) {
        Activity b16 = bk.b(view);
        if (!(b16 instanceof QCircleFolderActivity) && !QCirclePluginUtil.isQFSTabNativeFragmentMode(b16)) {
            return false;
        }
        return true;
    }

    private void K0(int i3, e30.b bVar) {
        int i16;
        FeedCloudMeta$StFeed g16;
        if (i3 == 0 && bVar != null) {
            boolean z16 = true;
            try {
                i16 = Integer.parseInt(getUniquePageId());
            } catch (NumberFormatException e16) {
                QLog.e("QFSLayerPageAdapter", 1, "[onBindViewHolder] pageId parse error: ", e16);
                i16 = 0;
            }
            if (i16 != 301 && i16 != 503) {
                z16 = false;
            }
            if (z16 && (g16 = bVar.g()) != null) {
                w20.a.j().u(g16.f398449id.get());
            }
        }
    }

    private View l0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedAdItemView qFSLayerFeedAdItemView = new QFSLayerFeedAdItemView(viewGroup.getContext(), i3);
        qFSLayerFeedAdItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        QCircleReportBean reportBean = getReportBean();
        if (J0(viewGroup)) {
            qFSLayerFeedAdItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedAdItemView.setReportBean(reportBean);
        return qFSLayerFeedAdItemView;
    }

    private View m0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedContractItemView qFSLayerFeedContractItemView = new QFSLayerFeedContractItemView(viewGroup.getContext(), i3);
        qFSLayerFeedContractItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedContractItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedContractItemView.setReportBean(getReportBean());
        return qFSLayerFeedContractItemView;
    }

    private View n0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedEcommerceItemView qFSLayerFeedEcommerceItemView = new QFSLayerFeedEcommerceItemView(viewGroup.getContext(), i3);
        qFSLayerFeedEcommerceItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        QCircleReportBean reportBean = getReportBean();
        if (J0(viewGroup)) {
            qFSLayerFeedEcommerceItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedEcommerceItemView.setReportBean(reportBean);
        return qFSLayerFeedEcommerceItemView;
    }

    private View o0(ViewGroup viewGroup, int i3) {
        QCircleDefaultFeedItemView qCircleDefaultFeedItemView = new QCircleDefaultFeedItemView(viewGroup.getContext(), i3);
        qCircleDefaultFeedItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return qCircleDefaultFeedItemView;
    }

    private View p0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedPYMKItemView qFSLayerFeedPYMKItemView = new QFSLayerFeedPYMKItemView(viewGroup.getContext(), i3);
        qFSLayerFeedPYMKItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedPYMKItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedPYMKItemView.setReportBean(getReportBean());
        return qFSLayerFeedPYMKItemView;
    }

    private View q0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedPublishTemplateItemView qFSLayerFeedPublishTemplateItemView = new QFSLayerFeedPublishTemplateItemView(viewGroup.getContext(), i3);
        qFSLayerFeedPublishTemplateItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedPublishTemplateItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedPublishTemplateItemView.setReportBean(getReportBean());
        return qFSLayerFeedPublishTemplateItemView;
    }

    private View r0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedHobbyLabelItemView qFSLayerFeedHobbyLabelItemView = new QFSLayerFeedHobbyLabelItemView(viewGroup.getContext(), i3);
        qFSLayerFeedHobbyLabelItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedHobbyLabelItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedHobbyLabelItemView.setReportBean(getReportBean());
        return qFSLayerFeedHobbyLabelItemView;
    }

    private View s0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedHotTagItemView qFSLayerFeedHotTagItemView = new QFSLayerFeedHotTagItemView(viewGroup.getContext(), i3);
        qFSLayerFeedHotTagItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedHotTagItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedHotTagItemView.setReportBean(getReportBean());
        return qFSLayerFeedHotTagItemView;
    }

    private View t0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedInterestTagItemView qFSLayerFeedInterestTagItemView = new QFSLayerFeedInterestTagItemView(viewGroup.getContext(), i3);
        qFSLayerFeedInterestTagItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedInterestTagItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedInterestTagItemView.setReportBean(getReportBean());
        return qFSLayerFeedInterestTagItemView;
    }

    private View u0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedLiveItemView qFSLayerFeedLiveItemView = new QFSLayerFeedLiveItemView(viewGroup.getContext(), i3);
        qFSLayerFeedLiveItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerFeedLiveItemView.setReportBean(getReportBean());
        return qFSLayerFeedLiveItemView;
    }

    private View v0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedMulHotTagItemView qFSLayerFeedMulHotTagItemView = new QFSLayerFeedMulHotTagItemView(viewGroup.getContext(), i3);
        qFSLayerFeedMulHotTagItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedMulHotTagItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedMulHotTagItemView.setReportBean(getReportBean());
        return qFSLayerFeedMulHotTagItemView;
    }

    private View w0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedODItemView qFSLayerFeedODItemView = new QFSLayerFeedODItemView(viewGroup.getContext(), i3);
        qFSLayerFeedODItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerFeedODItemView.setReportBean(getReportBean());
        return qFSLayerFeedODItemView;
    }

    private View x0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedOuterItemViewContainer qFSLayerFeedOuterItemViewContainer = new QFSLayerFeedOuterItemViewContainer(viewGroup.getContext(), i3);
        qFSLayerFeedOuterItemViewContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedOuterItemViewContainer.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedOuterItemViewContainer.setReportBean(getReportBean());
        return qFSLayerFeedOuterItemViewContainer;
    }

    private View y0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedPropItemView qFSLayerFeedPropItemView = new QFSLayerFeedPropItemView(viewGroup.getContext(), i3);
        qFSLayerFeedPropItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedPropItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedPropItemView.setReportBean(getReportBean());
        return qFSLayerFeedPropItemView;
    }

    private View z0(ViewGroup viewGroup, int i3) {
        QFSLayerFeedTemplateItemView qFSLayerFeedTemplateItemView = new QFSLayerFeedTemplateItemView(viewGroup.getContext(), i3);
        qFSLayerFeedTemplateItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (J0(viewGroup)) {
            qFSLayerFeedTemplateItemView.setPadding(0, 0, 0, QCirclePluginUtil.getBottomMarginHeight(viewGroup.getContext()));
        }
        qFSLayerFeedTemplateItemView.setReportBean(getReportBean());
        return qFSLayerFeedTemplateItemView;
    }

    public e30.b C0(int i3) {
        if (getDataList() != null && !ab0.a.a(i3, getDataList())) {
            return getDataList().get(i3);
        }
        return null;
    }

    protected View D0(ViewGroup viewGroup, int i3) {
        switch (i3) {
            case 1002:
            case 1003:
                return B0(viewGroup, i3);
            case 2001:
                return u0(viewGroup, i3);
            case 2002:
                return w0(viewGroup, i3);
            case 3002:
            case 3003:
                return n0(viewGroup, i3);
            case 4003:
                return l0(viewGroup, i3);
            case 100015:
                return p0(viewGroup, i3);
            case 100032:
                return q0(viewGroup, i3);
            case 100035:
                return v0(viewGroup, i3);
            case 100036:
                return y0(viewGroup, i3);
            case 100037:
                return z0(viewGroup, i3);
            case 100038:
                return s0(viewGroup, i3);
            case 100041:
                return r0(viewGroup, i3);
            case 100044:
                return m0(viewGroup, i3);
            case 100047:
                return A0(viewGroup, i3);
            case 100048:
                return t0(viewGroup, i3);
            default:
                if (j30.f.a(i3)) {
                    return x0(viewGroup, i3);
                }
                return o0(viewGroup, i3);
        }
    }

    public boolean E0() {
        if (getNUM_BACKGOURND_ICON() == 0) {
            return true;
        }
        if (getNUM_BACKGOURND_ICON() == 1 && getDataList().get(0) != null && getDataList().get(0).g() != null && getDataList().get(0).g().f398449id.get().startsWith("share_fake_")) {
            return true;
        }
        return false;
    }

    public void I0(final List<e30.b> list, boolean z16, final Runnable runnable) {
        if (list == null) {
            list = new ArrayList<>();
        }
        QLog.d("FDC-QFSLayerPageAdapter", 1, "[setDataList] list: " + list.size());
        this.f84725m = z16;
        if (this.mDiffer != null) {
            submitList(list, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.adapter.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.F0(runnable);
                }
            });
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.adapter.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.H0(list);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public String getDataSingleKey(int i3) {
        if (getDataList() != null && !ab0.a.a(i3, getDataList())) {
            return getDataList().get(i3).g().f398449id.get();
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    protected DiffUtil.ItemCallback<e30.b> getDiffCallBack() {
        return new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() != null && !ab0.a.a(i3, getDataList())) {
            return n.e(getDataList().get(i3).g());
        }
        QLog.d("QFSLayerPageAdapter", 1, "getItemViewType()  return 0");
        return 0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public String getSourceType() {
        return com.tencent.biz.qqcircle.immersive.manager.g.e().i(getReportBean());
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public boolean isSimpleFeed(int i3) {
        e30.b C0 = C0(i3);
        if (C0 == null) {
            return false;
        }
        return com.tencent.biz.qqcircle.immersive.repository.foldertab.j.g(C0.g());
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public boolean mayPreloadPreVideo() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_player_slid_back_render", true);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter
    protected boolean needScrollManger() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        e30.b bVar = getDataList().get(i3);
        K0(i3, bVar);
        ((b) viewHolder).m(bVar, i3);
        super.onBindViewHolder(viewHolder, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(D0(viewGroup, i3));
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public boolean showReNotify(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (!(view instanceof QFSLayerFeedAbsItemView)) {
            return false;
        }
        while (true) {
            boolean z16 = false;
            for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : ((QFSLayerFeedAbsItemView) view).s0().values()) {
                if (z16 || qFSBaseFeedChildPresenter.f1()) {
                    z16 = true;
                }
            }
            return z16;
        }
    }

    public m(Fragment fragment) {
        super(fragment);
        this.f84725m = false;
    }
}

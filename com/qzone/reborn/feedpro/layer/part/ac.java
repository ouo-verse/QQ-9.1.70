package com.qzone.reborn.feedpro.layer.part;

import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/ac;", "Lcom/qzone/reborn/feedpro/layer/part/QzoneFeedProBaseLayerControlPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "T9", "Lge/g;", "na", "Lq9/a;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "L9", "Lo9/e;", "layerStateBean", "", "isRefreshByDeleteEvent", "V9", "fetchLeft", "fetchRight", "X9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "R9", "Landroidx/recyclerview/widget/RecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ac extends QzoneFeedProBaseLayerControlPart {

    /* renamed from: Q, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/layer/part/ac$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f53933d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ac f53934e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RFWLayerState f53935f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ UIStateData<RFWLayerState> f53936h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f53937i;

        a(RecyclerView recyclerView, ac acVar, RFWLayerState rFWLayerState, UIStateData<RFWLayerState> uIStateData, boolean z16) {
            this.f53933d = recyclerView;
            this.f53934e = acVar;
            this.f53935f = rFWLayerState;
            this.f53936h = uIStateData;
            this.f53937i = z16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                this.f53933d.removeOnScrollListener(this);
                QLog.i(this.f53934e.getTAG(), 1, "scroll is idle start setData");
                this.f53934e.ba(this.f53935f, this.f53936h, this.f53937i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(ac this$0, o9.e layerStateBean, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layerStateBean, "$layerStateBean");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView != null) {
            RFWLayerState newLayerState = layerStateBean.getNewLayerState();
            UIStateData<RFWLayerState> b16 = layerStateBean.b();
            if (recyclerView.getScrollState() == 0) {
                this$0.ba(newLayerState, b16, z16);
            } else {
                QLog.i(this$0.getTAG(), 1, "isScrolling add listener");
                recyclerView.addOnScrollListener(new a(recyclerView, this$0, newLayerState, b16, z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<QzoneFeedProLayerListBean> L9() {
        ViewModel viewModel = getViewModel(ke.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026yerViewModel::class.java)");
        return (q9.a) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<QzoneFeedProLayerListBean> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        o9.e eVar = new o9.e();
        QzoneFeedProLayerListBean data = uiStateData.getData();
        if (data == null) {
            return eVar;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data.getMediumSum());
        rFWLayerState.setRichMediaDataList(data.g());
        Y9(true);
        aa(true);
        Z9(true);
        UIStateData<RFWLayerState> rfwLayerInfoUIStateData = UIStateData.obtainSuccess(false);
        eVar.c(rFWLayerState);
        Intrinsics.checkNotNullExpressionValue(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        eVar.d(rfwLayerInfoUIStateData);
        String tag = getTAG();
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerState.getRichMediaDataList();
        Integer valueOf = richMediaDataList != null ? Integer.valueOf(richMediaDataList.size()) : null;
        QLog.i(tag, 1, "media list size is " + valueOf + " is refresh " + data.getIsRefresh());
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void V9(final o9.e layerStateBean, final boolean isRefreshByDeleteEvent) {
        Intrinsics.checkNotNullParameter(layerStateBean, "layerStateBean");
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedpro.layer.part.ab
            @Override // java.lang.Runnable
            public final void run() {
                ac.Ea(ac.this, layerStateBean, isRefreshByDeleteEvent);
            }
        });
    }

    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
        ke.b ma5 = ma();
        ge.g na5 = na();
        na5.h(true);
        na5.i(true);
        na5.l(true);
        ma5.d2(na5);
    }

    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart
    protected ge.g na() {
        String str;
        ge.g gVar = new ge.g();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        gVar.j(str);
        return gVar;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void T9(View rootView) {
        this.recyclerView = rootView != null ? (RecyclerView) rootView.findViewById(R.id.neg) : null;
    }
}

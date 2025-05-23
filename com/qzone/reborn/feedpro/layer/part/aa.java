package com.qzone.reborn.feedpro.layer.part;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/aa;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "", "J9", "M9", "", "Lge/i;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "shareIcon", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa extends c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView shareIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    private final List<ge.i> I9() {
        MutableLiveData<UIStateData<QzoneFeedProLayerListBean>> M1;
        UIStateData<QzoneFeedProLayerListBean> value;
        QzoneFeedProLayerListBean data;
        ArrayList arrayList = new ArrayList();
        ke.g gVar = (ke.g) getViewModel(ke.g.class);
        ArrayList<RFWLayerItemMediaInfo> g16 = (gVar == null || (M1 = gVar.M1()) == null || (value = M1.getValue()) == null || (data = value.getData()) == null) ? null : data.g();
        if (g16 == null || g16.isEmpty()) {
            return arrayList;
        }
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : g16) {
            if (rFWLayerItemMediaInfo.getExtraData() instanceof QzoneFeedProLayerExtraInfoBean) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean");
                arrayList.add(new ge.i(rFWLayerItemMediaInfo, (QzoneFeedProLayerExtraInfoBean) extraData));
            }
        }
        return arrayList;
    }

    private final void J9() {
        fo.c.b("dt_clck", this.shareIcon, "em_qz_more", new fo.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K9(aa this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
        tk.h.S(20L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(aa this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        this$0.M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M9() {
        re.a aVar = (re.a) getViewModel(re.a.class);
        if (aVar == null) {
            return;
        }
        ge.h hVar = new ge.h();
        hVar.d(new ge.i(this.mCurrentSelectedItem, x9()));
        hVar.f(I9());
        ke.g gVar = (ke.g) getViewModel(ke.g.class);
        hVar.e(gVar != null ? gVar.getCommonFeed() : null);
        aVar.U1(hVar);
        aVar.O1().setValue(Boolean.TRUE);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RecyclerView recyclerView = rootView != null ? (RecyclerView) rootView.findViewById(R.id.neg) : null;
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.y
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean K9;
                    K9 = aa.K9(aa.this, view);
                    return K9;
                }
            });
        }
        ImageView imageView = rootView != null ? (ImageView) rootView.findViewById(R.id.f162840mx1) : null;
        this.shareIcon = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aa.L9(aa.this, view);
                }
            });
        }
    }
}

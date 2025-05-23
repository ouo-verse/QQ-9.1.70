package com.qzone.reborn.feedpro.part;

import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0014B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/part/k;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "", "getLogTag", "onInitView", "d", "Landroid/view/View;", "floatPlusIconContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "floatPlusIcon", "<init>", "()V", "f", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View floatPlusIconContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView floatPlusIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedpro/part/k$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            if (Intrinsics.areEqual(event, "clck")) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
            }
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eo.c.f396879a.b();
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("2");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.o0(bool);
        ho.i.w().c(this$0.getContext(), qZonePublishMoodInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProFloatPlusIconPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        D9(rootView);
    }

    private final void D9(View rootView) {
        this.floatPlusIconContainer = rootView != null ? rootView.findViewById(R.id.n26) : null;
        ImageView imageView = rootView != null ? (ImageView) rootView.findViewById(R.id.f162871n25) : null;
        this.floatPlusIcon = imageView;
        if (imageView != null) {
            com.tencent.mobileqq.qzone.picload.c.a().m(imageView, getActivity().getColor(R.color.qui_common_icon_allwhite_primary));
        }
        AccessibilityUtil.p(this.floatPlusIconContainer, "\u53d1\u8868\u52a8\u6001");
        View view = this.floatPlusIconContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.floatPlusIconContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    k.E9(k.this, view3);
                }
            });
        }
        View view3 = this.floatPlusIconContainer;
        if (view3 != null) {
            fo.c.o(view3, "em_qz_plus_suspend", new fo.b().h(new b()));
        }
    }
}

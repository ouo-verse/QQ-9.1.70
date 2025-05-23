package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b,\u00100B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u00020\n\u00a2\u0006\u0004\b,\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R*\u0010)\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFriendFeedProPublishEntranceView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "q0", "", "pickMediaFirst", "v0", "Landroid/view/View;", "view", "", "clickPosition", "p0", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "iconPickMediaContainer", tl.h.F, "iconAIPublishContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "iconPickMedia", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "iconAIPublish", "Lcom/qzone/reborn/feedpro/widget/header/l;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/header/l;", "bgDrawable", "value", "D", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFriendFeedProPublishEntranceView extends QZoneBaseWidgetView<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private l bgDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private int strokeColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View iconPickMediaContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View iconAIPublishContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView iconPickMedia;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView iconAIPublish;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedpro/widget/header/QzoneFriendFeedProPublishEntranceView$a", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements IDynamicParams {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            if (Intrinsics.areEqual(event, "clck")) {
                hashMap.put("is_top", Integer.valueOf(!(QzoneFriendFeedProPublishEntranceView.this instanceof com.qzone.reborn.feedpro.widget.header.a) ? 1 : 0));
            }
            return hashMap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProPublishEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(QzoneFriendFeedProPublishEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v0(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(QzoneFriendFeedProPublishEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v0(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(QzoneFriendFeedProPublishEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.g w3 = ho.i.w();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        w3.a(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cio;
    }

    public final void setStrokeColor(int i3) {
        this.strokeColor = i3;
        l lVar = this.bgDrawable;
        if (lVar != null) {
            lVar.c(i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProPublishEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    private final void v0(boolean pickMediaFirst) {
        if (pickMediaFirst && com.qzone.reborn.util.l.f59550a.U(getHostActivity(), null)) {
            return;
        }
        eo.c.f396879a.b();
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("1");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.o0(Boolean.valueOf(pickMediaFirst));
        ho.i.w().c(getContext(), qZonePublishMoodInitBean);
    }

    private final void p0(View view, int clickPosition) {
        if (view == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("click_location", Integer.valueOf(clickPosition));
        fo.c.o(view, "em_qz_input_box", new fo.b().l(linkedHashMap).h(new a()).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE));
    }

    private final void q0() {
        this.rootView = findViewById(R.id.n9u);
        this.iconPickMedia = (ImageView) findViewById(R.id.n9s);
        this.iconAIPublish = (ImageView) findViewById(R.id.n9q);
        this.iconPickMediaContainer = findViewById(R.id.n9t);
        this.iconAIPublishContainer = findViewById(R.id.n9r);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        l lVar = new l(context, 0, 0, 0, 0, 0.0f, 0.0f, 126, null);
        this.bgDrawable = lVar;
        View view = this.rootView;
        if (view != null) {
            view.setBackground(lVar.a());
        }
        ImageView imageView = this.iconPickMedia;
        if (imageView != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView, 0.0f, 1, null);
        }
        ImageView imageView2 = this.iconAIPublish;
        if (imageView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView2, 0.0f, 1, null);
        }
        View view2 = this.rootView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QzoneFriendFeedProPublishEntranceView.r0(QzoneFriendFeedProPublishEntranceView.this, view3);
                }
            });
        }
        View view3 = this.iconPickMediaContainer;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QzoneFriendFeedProPublishEntranceView.s0(QzoneFriendFeedProPublishEntranceView.this, view4);
                }
            });
        }
        View view4 = this.iconAIPublishContainer;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    QzoneFriendFeedProPublishEntranceView.u0(QzoneFriendFeedProPublishEntranceView.this, view5);
                }
            });
        }
        p0(this.rootView, 0);
        p0(this.iconPickMediaContainer, 1);
        p0(this.iconAIPublishContainer, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFriendFeedProPublishEntranceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
    }
}

package com.qzone.reborn.feedx.widget.halfscreen;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.tianshu.j;
import com.qzone.business.tianshu.model.QZoneFeedGuideTianshuInfo;
import com.qzone.reborn.feedx.widget.halfscreen.QZoneFeedxGuideFloatingView;
import com.qzone.reborn.util.m;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import fo.b;
import ho.i;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pl.a;
import sh.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0019\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxGuideFloatingView;", "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "p0", "y0", "u0", "q0", "v0", "r0", "", "w0", "x0", "getLayoutId", "", "objData", c.G, "bindData", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "f", "tvContentDes", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundImageLayout", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "imageIcon", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "selectBtn", "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "guideInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxGuideFloatingView extends QZoneFeedxBaseFloatingView implements View.OnClickListener {
    private static final int E = ar.e(16.0f) * 2;
    private static final int F = ar.e(120.0f);
    private static final int G = ar.e(100.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneFeedGuideTianshuInfo guideInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView tvContentDes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final RoundCorneredFrameLayout roundImageLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final QUIButton selectBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxGuideFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.nii);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_content_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.nih);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_content_desc)");
        this.tvContentDes = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.mg_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_image_layout)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById3;
        this.roundImageLayout = roundCorneredFrameLayout;
        View findViewById4 = findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_image_icon)");
        ImageView imageView = (ImageView) findViewById4;
        this.imageIcon = imageView;
        View findViewById5 = findViewById(R.id.njz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_select_button)");
        QUIButton qUIButton = (QUIButton) findViewById5;
        this.selectBtn = qUIButton;
        qUIButton.setOnClickListener(this);
        roundCorneredFrameLayout.setRadius(ar.e(4.0f));
        m0();
        p0(imageView);
        y0();
    }

    private final void p0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int w06 = w0();
            layoutParams.width = w06;
            layoutParams.height = w06;
            view.setLayoutParams(layoutParams);
        }
    }

    private final void q0() {
        this.selectBtn.setVisibility(0);
        QUIButton qUIButton = this.selectBtn;
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo = this.guideInfo;
        qUIButton.setText(qZoneFeedGuideTianshuInfo != null ? qZoneFeedGuideTianshuInfo.getButtonText() : null);
        v0();
    }

    private final void r0() {
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo = this.guideInfo;
        final Option url = Option.obtain().setUrl(qZoneFeedGuideTianshuInfo != null ? qZoneFeedGuideTianshuInfo.getPic() : null);
        url.setTargetView(this.imageIcon);
        m mVar = m.f59551a;
        url.setLoadingDrawable(mVar.b(getContext()));
        url.setFailDrawable(mVar.a(getContext()));
        if (this.imageIcon.getLayoutParams() != null) {
            url.setRequestWidth(this.imageIcon.getLayoutParams().width);
            url.setRequestHeight(this.imageIcon.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(url, new IPicLoadStateListener() { // from class: sh.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedxGuideFloatingView.s0(Option.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Option option, LoadState loadState, Option option2) {
        if (!loadState.isFinishSuccess()) {
            QLog.e("QZoneFeedxGuideFloatingView", 1, "[bindIcon] loadImage fail:" + loadState);
            return;
        }
        Animatable animatable = option.getAnimatable();
        if (animatable != null) {
            animatable.start();
        }
    }

    private final void u0() {
        TextView textView = this.tvTitle;
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo = this.guideInfo;
        textView.setText(qZoneFeedGuideTianshuInfo != null ? qZoneFeedGuideTianshuInfo.getTitle() : null);
        TextView textView2 = this.tvContentDes;
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo2 = this.guideInfo;
        textView2.setText(qZoneFeedGuideTianshuInfo2 != null ? qZoneFeedGuideTianshuInfo2.getText() : null);
    }

    private final void v0() {
        fo.c.o(this.selectBtn, "em_qz_repair_immediately", new b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE));
    }

    private final int w0() {
        int o16;
        int i3;
        a aVar = a.f426446a;
        if (aVar.y()) {
            d.Companion companion = d.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            o16 = companion.a(context) - F;
            i3 = G;
        } else {
            o16 = aVar.o(getContext());
            i3 = E;
        }
        return o16 - i3;
    }

    private final void x0() {
        QZoneFeedGuideTianshuInfo qZoneFeedGuideTianshuInfo = this.guideInfo;
        String url = qZoneFeedGuideTianshuInfo != null ? qZoneFeedGuideTianshuInfo.getUrl() : null;
        if (TextUtils.isEmpty(url)) {
            QLog.e("QZoneFeedxGuideFloatingView", 1, "[bindIcon] schema is " + url);
            return;
        }
        i.q(getContext(), url);
        j.INSTANCE.a().n();
        n0();
    }

    private final void y0() {
        VideoReport.setPageId(getRootView(), "pg_qz_updates_pic_repair_float");
        VideoReport.setPageParams(getRootView(), new fo.a().d("QZoneFeedxGuideFloatingView", new LinkedHashMap()));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
        if (!(objData instanceof QZoneFeedGuideTianshuInfo)) {
            QLog.e("QZoneFeedxGuideFloatingView", 1, "[bindData] objData is not instanceof");
            return;
        }
        this.guideInfo = (QZoneFeedGuideTianshuInfo) objData;
        u0();
        r0();
        q0();
        j.INSTANCE.a().o();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cbq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.njz) {
            x0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

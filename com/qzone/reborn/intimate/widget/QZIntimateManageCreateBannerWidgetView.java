package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$CreateMoreSpaceGuide;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateManageCreateBannerWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lqzone/QZIntimateProfileReader$CreateMoreSpaceGuide;", "Landroid/view/View$OnClickListener;", "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "", "m0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "llCreateSpaceLayout", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "ivCreateIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvCreateText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvCreateBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateManageCreateBannerWidgetView extends QZoneBaseWidgetView<QZIntimateProfileReader$CreateMoreSpaceGuide> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout llCreateSpaceLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivCreateIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView tvCreateText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView tvCreateBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageCreateBannerWidgetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QZIntimateManageCreateBannerWidgetView";
        View findViewById = findViewById(R.id.f162753mg1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_create_space_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.llCreateSpaceLayout = linearLayout;
        View findViewById2 = findViewById(R.id.kvv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_create_icon)");
        this.ivCreateIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.nil);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_create_text)");
        this.tvCreateText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.nik);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_create_btn)");
        TextView textView = (TextView) findViewById4;
        this.tvCreateBtn = textView;
        textView.setOnClickListener(this);
        mk.g.f416876a.a(linearLayout, Color.parseColor("#AFAFAF"), ImmersiveUtils.dpToPx(4.0f), false);
        fo.c.n(textView, "em_qz_boot_create_banner");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cju;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.nik && getData() != null && !com.qzone.reborn.util.e.b(this.TAG, 1000L)) {
            com.tencent.mobileqq.webview.util.f fVar = com.tencent.mobileqq.webview.util.f.f314875a;
            String str = getData().button.actionurl.get();
            Intrinsics.checkNotNullExpressionValue(str, "data.button.actionurl.get()");
            ho.i.q(getContext(), fVar.b(0.85f, str));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZIntimateProfileReader$CreateMoreSpaceGuide objData, int pos) {
        if (objData != null && !TextUtils.isEmpty(objData.guide_text.get())) {
            this.llCreateSpaceLayout.setVisibility(0);
            setVisibility(0);
            rn.h.a(this.ivCreateIcon, objData.icontoken.get(), R.color.qui_common_icon_primary);
            this.tvCreateText.setText(objData.guide_text.get());
            this.tvCreateBtn.setText(objData.button.text.get());
            QLog.d(this.TAG, 1, "bindData  | actionurl = " + objData.button.actionurl.get() + " | icontoken = " + objData.icontoken.get() + " | guide_text = " + objData.guide_text.get() + " | btnText = " + objData.button.text.get());
            return;
        }
        this.llCreateSpaceLayout.setVisibility(8);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageCreateBannerWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QZIntimateManageCreateBannerWidgetView";
        View findViewById = findViewById(R.id.f162753mg1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ll_create_space_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.llCreateSpaceLayout = linearLayout;
        View findViewById2 = findViewById(R.id.kvv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_create_icon)");
        this.ivCreateIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.nil);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_create_text)");
        this.tvCreateText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.nik);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_create_btn)");
        TextView textView = (TextView) findViewById4;
        this.tvCreateBtn = textView;
        textView.setOnClickListener(this);
        mk.g.f416876a.a(linearLayout, Color.parseColor("#AFAFAF"), ImmersiveUtils.dpToPx(4.0f), false);
        fo.c.n(textView, "em_qz_boot_create_banner");
    }
}

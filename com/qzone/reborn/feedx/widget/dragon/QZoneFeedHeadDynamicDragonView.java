package com.qzone.reborn.feedx.widget.dragon;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadDynamicDragonView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0014J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadDynamicDragonView;", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "Landroid/view/View$OnClickListener;", "", "v0", "", "getLogTag", "", "getLayoutId", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "objData", c.G, "u0", "m0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivDynamicDragonView", "Landroid/graphics/drawable/Animatable;", h.F, "Landroid/graphics/drawable/Animatable;", "dynamicAnimatable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedHeadDynamicDragonView extends QZoneFeedHeadBaseDragonView implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivDynamicDragonView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Animatable dynamicAnimatable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadDynamicDragonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.mzb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026dynamic_dragon_container)");
        ImageView imageView = (ImageView) findViewById;
        this.ivDynamicDragonView = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QZoneFeedHeadDynamicDragonView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishSuccess()) {
            QLog.e("QZoneFeedHeadDynamicDragonView", 1, "[loadDragonPic] loadImage fail:" + loadState);
            return;
        }
        QLog.i("QZoneFeedHeadDynamicDragonView", 4, "[loadDragonPic] loadPic success:" + option.getAnimatable());
        Animatable animatable = option.getAnimatable();
        this$0.dynamicAnimatable = animatable;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cdh;
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    protected String getLogTag() {
        return "QZoneFeedHeadDynamicDragonView";
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    public String m0() {
        String resourceId;
        FeedResourceInfo fusionBadge = getData().getFusionBadge();
        return (fusionBadge == null || (resourceId = fusionBadge.getResourceId()) == null) ? "" : resourceId;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Animatable animatable = this.dynamicAnimatable;
        if (animatable == null || animatable.isRunning()) {
            return;
        }
        animatable.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.mzb) {
            FeedResourceInfo fusionBadge = getData().getFusionBadge();
            o0(fusionBadge != null ? fusionBadge.getJumpUrl() : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animatable animatable = this.dynamicAnimatable;
        if (animatable == null || !animatable.isRunning()) {
            return;
        }
        animatable.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneDragonUserInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        if (objData.isValidDynamicResInfo()) {
            v0();
            r0();
        }
    }

    private final void v0() {
        this.dynamicAnimatable = null;
        p0(this.ivDynamicDragonView, getData().getFusionBadge(), new IPicLoadStateListener() { // from class: ph.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedHeadDynamicDragonView.w0(QZoneFeedHeadDynamicDragonView.this, loadState, option);
            }
        });
    }
}

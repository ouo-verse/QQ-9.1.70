package com.qzone.reborn.feedx.widget.dragon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadUpgradeDragonView;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadUpgradeDragonView;", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "Landroid/view/View$OnClickListener;", "", "v0", "", "getLogTag", "", "getLayoutId", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "objData", c.G, "u0", "m0", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivUpgradeDragonView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedHeadUpgradeDragonView extends QZoneFeedHeadBaseDragonView implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivUpgradeDragonView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadUpgradeDragonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.n1u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026upgrade_dragon_container)");
        ImageView imageView = (ImageView) findViewById;
        this.ivUpgradeDragonView = imageView;
        imageView.setOnClickListener(this);
    }

    private final void v0() {
        p0(this.ivUpgradeDragonView, getData().getDragonResInfo(), new IPicLoadStateListener() { // from class: ph.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneFeedHeadUpgradeDragonView.w0(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null) {
            QLog.i("QZoneFeedHeadComposeDragonView", 4, "[loadDragonPic] loadPic success");
            return;
        }
        QLog.e("QZoneFeedHeadComposeDragonView", 1, "[loadDragonPic] loadImage fail:" + loadState);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cdt;
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    protected String getLogTag() {
        return "QZoneFeedHeadComposeDragonView";
    }

    @Override // com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView
    public String m0() {
        String resourceId;
        FeedResourceInfo dragonResInfo = getData().getDragonResInfo();
        return (dragonResInfo == null || (resourceId = dragonResInfo.getResourceId()) == null) ? "" : resourceId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n1u) {
            FeedResourceInfo dragonResInfo = getData().getDragonResInfo();
            o0(dragonResInfo != null ? dragonResInfo.getJumpUrl() : null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneDragonUserInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        if (objData.isValidGrowthResInfo()) {
            v0();
            r0();
        }
    }
}

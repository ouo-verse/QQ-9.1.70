package com.tencent.ecommerce.biz.detail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.detail.repo.shop.data.f;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/view/ECProductDetailLiveEntryView;", "Landroid/widget/LinearLayout;", "", "b", "c", "d", "", "visibility", "setVisibility", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "info", "setLiveStatusInfo", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "livingAnimationContent", "Landroid/view/View;", "e", "Landroid/view/View;", "livingAnimation", "f", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "statusInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductDetailLiveEntryView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout livingAnimationContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View livingAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private f statusInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f fVar = ECProductDetailLiveEntryView.this.statusInfo;
            ECScheme.g(fVar != null ? fVar.roomUrl : null, null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductDetailLiveEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ImageView imageView;
        LayoutInflater.from(context).inflate(R.layout.f167329cq2, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.nwp);
        this.livingAnimationContent = relativeLayout;
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSo()) {
            PAGView pAGView = new PAGView(context);
            pAGView.setPath("assets://pag/ecommerce_product_detail_live_entry.pag");
            pAGView.setRepeatCount(-1);
            Unit unit = Unit.INSTANCE;
            imageView = pAGView;
        } else {
            ImageView imageView2 = new ImageView(context);
            imageView2.setBackgroundResource(R.drawable.di9);
            Unit unit2 = Unit.INSTANCE;
            imageView = imageView2;
        }
        this.livingAnimation = imageView;
        relativeLayout.addView(imageView, new LinearLayout.LayoutParams(e.c(16.0f), e.c(16.0f)));
        b();
    }

    private final void c() {
        View view = this.livingAnimation;
        if (view instanceof PAGView) {
            ((PAGView) view).play();
        } else if (view instanceof ImageView) {
            ECViewUtilKt.c(view);
        }
    }

    private final void d() {
        View view = this.livingAnimation;
        if (view instanceof PAGView) {
            ((PAGView) view).stop();
        } else if (view instanceof ImageView) {
            view.clearAnimation();
        }
    }

    public final void setLiveStatusInfo(f info) {
        this.statusInfo = info;
        setVisibility((info != null ? Boolean.valueOf(info.a()) : null).booleanValue() ? 0 : 8);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0) {
            c();
        } else {
            d();
        }
    }

    private final void b() {
        ((LinearLayout) findViewById(R.id.nws)).setOnClickListener(new a());
    }
}

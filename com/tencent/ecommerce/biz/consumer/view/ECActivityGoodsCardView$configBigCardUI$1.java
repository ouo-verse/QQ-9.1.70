package com.tencent.ecommerce.biz.consumer.view;

import android.view.View;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.view.bigcard.ECActivityGoodsBigCardView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECActivityGoodsCardView$configBigCardUI$1 implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECActivityGoodsCardView f101671d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECActivityGoodsCardView$configBigCardUI$1(ECActivityGoodsCardView eCActivityGoodsCardView) {
        this.f101671d = eCActivityGoodsCardView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        ECContentInfo eCContentInfo;
        this.f101671d.getSmallCardLayout().setVisibility(4);
        this.f101671d.post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$configBigCardUI$1.1

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$configBigCardUI$1$1$a */
            /* loaded from: classes31.dex */
            static final class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ECActivityGoodsCardView eCActivityGoodsCardView = ECActivityGoodsCardView$configBigCardUI$1.this.f101671d;
                    eCActivityGoodsCardView.S(eCActivityGoodsCardView.I());
                    ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.getSmallCardLayout().setVisibility(0);
                    ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.getSmallTitleView().setVisibility(0);
                    ECActivityGoodsBigCardView eCActivityGoodsBigCardView = ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.bigCardView;
                    if (eCActivityGoodsBigCardView != null) {
                        eCActivityGoodsBigCardView.setVisibility(8);
                    }
                    View.OnClickListener onCloseAnimEndListener = ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.getOnCloseAnimEndListener();
                    if (onCloseAnimEndListener != null) {
                        onCloseAnimEndListener.onClick(view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                ECActivityGoodsBigCardView eCActivityGoodsBigCardView = ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.bigCardView;
                if (eCActivityGoodsBigCardView != null) {
                    eCActivityGoodsBigCardView.h(ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.getSmallCardLayout(), ECActivityGoodsCardView$configBigCardUI$1.this.f101671d.getOnCloseAnimStartListener(), new a());
                }
            }
        });
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.f101671d.bigCardView;
            if (eCActivityGoodsBigCardView == null || (eCContentInfo = eCActivityGoodsBigCardView.contentInfo) == null || (str = eCContentInfo.getContentId()) == null) {
                str = "";
            }
            videoControl.sendVideoInfoViewShowEvent(str, true, true);
        }
    }
}

package com.tencent.ecommerce.biz.consumer.view.mediumcard;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.view.ECNGCardView;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/mediumcard/ECNGVideoMediumCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/ECNGCardView;", "", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "", NodeProps.MARGIN_RIGHT, "", "d0", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNGVideoMediumCardView extends ECNGCardView {
    public ECNGVideoMediumCardView(Context context) {
        super(context);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void I(ECContentInfo contentInfo, UIInfo uiInfo) {
        super.I(contentInfo, uiInfo);
        ViewGroup.LayoutParams layoutParams = getMediumCardLayout().getLayoutParams();
        ECNGCardView.Companion companion = ECNGCardView.INSTANCE;
        layoutParams.height = companion.k();
        ViewGroup.LayoutParams layoutParams2 = getMediumCardImageViewLayout().getLayoutParams();
        if (layoutParams2 != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            layoutParams3.leftMargin = companion.j();
            layoutParams3.topMargin = companion.j();
            layoutParams3.bottomMargin = companion.j();
            getMediumCardVideoImageView().setVisibility(0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int N() {
        return ECNGCardView.INSTANCE.g();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int Q() {
        return ECNGCardView.INSTANCE.h();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int U() {
        return 10600;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void d0(UIInfo uiInfo, float marginRight) {
        l0(getBIGCARD_TEXT_MARGIN_TO_LEFT() - ECNGCardView.INSTANCE.j());
        super.d0(uiInfo, marginRight + r1.f() + r1.l());
    }
}

package com.tencent.mobileqq.profilecard.component.pymk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/pymk/ProfileRecReasonComponentOld;", "Lcom/tencent/mobileqq/profilecard/component/pymk/ProfileRecReasonComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "reasonIcon", "Landroid/widget/ImageView;", "getReasonIcon", "()Landroid/widget/ImageView;", "setReasonIcon", "(Landroid/widget/ImageView;)V", "initView", "", "reason", "", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileRecReasonComponentOld extends ProfileRecReasonComponent {
    private ImageView reasonIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRecReasonComponentOld(IComponentCenter componentCenter, ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
    }

    public final ImageView getReasonIcon() {
        return this.reasonIcon;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.component.pymk.ProfileRecReasonComponent
    public void initView(String reason) {
        QBaseActivity qBaseActivity;
        if (getRootView() == null && (qBaseActivity = this.mActivity) != null) {
            setRootView(LayoutInflater.from(qBaseActivity).inflate(R.layout.czj, (ViewGroup) null));
            View rootView = getRootView();
            setReasonText(rootView != null ? (TextView) rootView.findViewById(R.id.owg) : null);
            View rootView2 = getRootView();
            this.reasonIcon = rootView2 != null ? (ImageView) rootView2.findViewById(R.id.owf) : null;
        }
        TextView reasonText = getReasonText();
        if (reasonText != null) {
            reasonText.setText("\u53ef\u80fd\u8ba4\u8bc6\u7684\u4eba\uff1a" + reason);
        }
        this.mViewContainer = getRootView();
        updateItemTheme(getRootView(), getReasonText(), this.reasonIcon, null, null);
    }

    public final void setReasonIcon(ImageView imageView) {
        this.reasonIcon = imageView;
    }
}

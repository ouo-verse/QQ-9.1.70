package com.tencent.mobileqq.profilecard.component.content;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileTabUtils;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

/* loaded from: classes35.dex */
public class ElegantProfileGuideComponent extends AbsQQProfileContentComponent {
    private static final String TAG = "ElegantProfileGuideComponent";

    public ElegantProfileGuideComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View, VIEW] */
    private boolean makeOrRefreshUi(ProfileCardInfo profileCardInfo) {
        Card card = profileCardInfo.card;
        boolean z16 = false;
        if (card == null) {
            return false;
        }
        boolean z17 = !this.mApp.getCurrentAccountUin().equals(card.uin);
        boolean shouldShowGuide = shouldShowGuide(profileCardInfo, z17);
        if (shouldShowGuide && this.mViewContainer == 0) {
            ?? inflate = View.inflate(this.mActivity, R.layout.cz4, null);
            this.mViewContainer = inflate;
            View findViewById = inflate.findViewById(R.id.out);
            if (!z17) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.content.ElegantProfileGuideComponent.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.a().b()) {
                            return;
                        }
                        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileEdit(((AbsComponent) ElegantProfileGuideComponent.this).mActivity, ((ProfileCardInfo) ((AbsComponent) ElegantProfileGuideComponent.this).mData).allInOne, false);
                    }
                });
            } else {
                findViewById.setOnClickListener(null);
            }
            updateItemTheme(findViewById, (TextView) ((View) this.mViewContainer).findViewById(R.id.our), null, (ImageView) ((View) this.mViewContainer).findViewById(R.id.ouq));
        } else {
            if (!shouldShowGuide && this.mViewContainer != 0) {
                this.mViewContainer = null;
            }
            updateUI(z17);
            return z16;
        }
        z16 = true;
        updateUI(z17);
        return z16;
    }

    private boolean shouldShowGuide(ProfileCardInfo profileCardInfo, boolean z16) {
        List<TabContainer.Tab> mergedTab = ProfileTabUtils.getMergedTab(ProfileTabUtils.getBaseAccountTab(profileCardInfo), ProfileTabUtils.getPersonalityLabelTab(profileCardInfo, this.mApp));
        if (mergedTab.size() == 0 && z16) {
            mergedTab = ProfileTabUtils.getPresentAndMedalList(profileCardInfo);
        }
        return mergedTab.size() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateUI(boolean z16) {
        if (this.mViewContainer == 0) {
            return;
        }
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.our);
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.ouq);
        if (z16) {
            textView.setText("\u8fd8\u672a\u586b\u5199\u4efb\u4f55\u8d44\u6599\u4fe1\u606f");
            textView.setVisibility(0);
            imageView.setVisibility(8);
        } else {
            textView.setText("\u5b8c\u5584\u8d44\u6599\uff0c\u8ba9\u66f4\u591a\u4eba\u4e86\u89e3\u4f60");
            textView.setVisibility(0);
            imageView.setVisibility(0);
        }
        textView.setTextColor(isNowThemeIsNight ? -1 : -16777216);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1029;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_GUIDE;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        return makeOrRefreshUi(profileCardInfo) | super.lambda$checkValidComponent$3((ElegantProfileGuideComponent) profileCardInfo);
    }
}

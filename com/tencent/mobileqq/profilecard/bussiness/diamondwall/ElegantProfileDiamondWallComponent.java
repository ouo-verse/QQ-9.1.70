package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ElegantProfileDiamondWallComponent extends BaseProfileDiamondWallComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ElegantProfileDiamondWallComponent";

    public ElegantProfileDiamondWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [VIEW] */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v34 */
    @Override // com.tencent.mobileqq.profilecard.bussiness.diamondwall.BaseProfileDiamondWallComponent
    public boolean makeOrRefreshMedalAndDiamond(ProfileCardInfo profileCardInfo, boolean z16) {
        Card card;
        boolean z17;
        ?? r06;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, profileCardInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (profileCardInfo == null) {
            card = null;
        } else {
            card = profileCardInfo.card;
        }
        if (card == null) {
            if (this.mViewContainer == null) {
                z18 = false;
            }
            this.mViewContainer = null;
            return z18;
        }
        if (card.switchPrivilege == 0 && !Utils.G(profileCardInfo.allInOne.uin) && !ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, String.format("makeAccountLineThree, , diamond: %s", Boolean.valueOf(z17)));
        }
        if (!z17) {
            if (this.mViewContainer == null) {
                z18 = false;
            }
            this.mViewContainer = null;
            return z18;
        }
        if (this.mViewContainer == null) {
            IComponentCenter iComponentCenter = this.mComponentCenter;
            if (iComponentCenter != null) {
                r06 = iComponentCenter.getViewLoader().getViewById(R.layout.b07);
            } else {
                r06 = 0;
            }
            if (r06 == 0) {
                r06 = LayoutInflater.from(this.mActivity).inflate(R.layout.b07, (ViewGroup) null);
            }
            this.mViewContainer = r06;
        } else {
            z18 = false;
        }
        ((View) this.mViewContainer).findViewById(R.id.icon).setVisibility(8);
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.bkm);
        updateDiamondView(profileCardInfo, findViewById);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).leftMargin = ViewUtils.dpToPx(15.0f);
        ((View) this.mViewContainer).setTag(new b(26, null));
        ((View) this.mViewContainer).setOnClickListener(this.mOnClickListener);
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            diyMoreInfoManager.updateMetalForDeepDiy((View) this.mViewContainer);
        }
        ((View) this.mViewContainer).setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
        return z18;
    }
}

package com.tencent.mobileqq.profilecard.component;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import java.util.List;

/* loaded from: classes35.dex */
public abstract class BaseProfileFavorComponent extends AbsProfileContentComponent implements View.OnClickListener {
    private static final String TAG = "BaseProfileFavorComponent";
    public static final String URL = "url";
    private boolean isInitDtReport;

    public BaseProfileFavorComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isInitDtReport = false;
    }

    public abstract void addFavorItem(ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry, LinearLayout linearLayout, Resources resources);

    public int fillUpFavorItem(LinearLayout linearLayout, Card card) {
        int i3;
        IProfileConfig iProfileConfig;
        IProfileConfig iProfileConfig2;
        List<ProfileSummaryHobbiesEntry> bigOrderEntrys = card.getBigOrderEntrys();
        if (bigOrderEntrys == null) {
            return 0;
        }
        linearLayout.removeAllViews();
        int i16 = 0;
        for (int i17 = 0; i17 < bigOrderEntrys.size(); i17++) {
            ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry = bigOrderEntrys.get(i17);
            if (!TextUtils.isEmpty(profileSummaryHobbiesEntry.strName) && profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem != null && (i3 = profileSummaryHobbiesEntry.serviceType) != 5 && ((i3 != 4 || (iProfileConfig2 = this.mConfigHelper) == null || iProfileConfig2.isSwitchEnable(5)) && (profileSummaryHobbiesEntry.serviceType != 2 || (iProfileConfig = this.mConfigHelper) == null || iProfileConfig.isSwitchEnable(4)))) {
                addFavorItem(profileSummaryHobbiesEntry, linearLayout, this.mActivity.getResources());
                i16++;
            }
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1006;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_FAVOR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [android.widget.LinearLayout, android.view.View, VIEW] */
    public boolean makeOrRefreshFavor(Card card, boolean z16) {
        LinearLayout linearLayout;
        boolean isPaTypeStrangerInContact = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne);
        boolean z17 = false;
        if (card != null && !isPaTypeStrangerInContact) {
            VIEW view = this.mViewContainer;
            if (view == 0) {
                ?? r65 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.cyv, (ViewGroup) null, false);
                r65.setTag(R.id.oud, Boolean.TRUE);
                this.mViewContainer = r65;
                z17 = true;
                linearLayout = r65;
            } else {
                linearLayout = (LinearLayout) view;
            }
            if (fillUpFavorItem(linearLayout, card) > 0) {
                return true;
            }
            if (this.mViewContainer != 0) {
                this.mViewContainer = null;
                return true;
            }
        } else if (this.mViewContainer != 0) {
            this.mViewContainer = null;
            return true;
        }
        return z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileFavorComponent) profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshFavor = lambda$checkValidComponent$3 | makeOrRefreshFavor(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        if (makeOrRefreshFavor && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_MUSIC);
        }
        return makeOrRefreshFavor;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}

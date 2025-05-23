package com.tencent.mobileqq.vas.qid;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.ui.CoolTextView;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QidCoolTextView extends CoolTextView {
    public QidCoolTextView(Context context) {
        this(context, null);
    }

    private boolean checkDataReady(ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        if (profileCardInfo != null && profileCardInfo.card != null && (allInOne = profileCardInfo.allInOne) != null && !TextUtils.isEmpty(allInOne.uin)) {
            return true;
        }
        return false;
    }

    private boolean isQIdVisible() {
        return QVipQidProcessor.get().isEnableQid();
    }

    private CoolTextView.CoolBuilder prepareQidBuilder(Card card) {
        int i3;
        boolean z16 = true;
        if (PrettyAccountUtil.isPrettyOpenForCard(card) != 1) {
            z16 = false;
        }
        CoolTextView.CoolBuilder coolBuilder = new CoolTextView.CoolBuilder();
        coolBuilder.txtColor = card.qidColor;
        coolBuilder.logoUrl = card.qidLogoUrl;
        coolBuilder.bgUrl = card.qidBgUrl;
        if (!TextUtils.isEmpty(card.qid)) {
            coolBuilder.infoStr = card.qid;
            int i16 = 18;
            if (isVipStyle(coolBuilder.logoUrl, coolBuilder.bgUrl)) {
                coolBuilder.infoStr = card.qid;
                coolBuilder.logoWidth = 21;
                coolBuilder.logoHeight = 18;
                coolBuilder.bgHeight = 18;
                coolBuilder.txtSize = 11;
            } else {
                coolBuilder.infoStr = "(ID\uff1a" + card.qid + ")";
                coolBuilder.logoWidth = 0;
                if (z16) {
                    i3 = 18;
                } else {
                    i3 = 14;
                }
                coolBuilder.logoHeight = i3;
                if (!z16) {
                    i16 = 14;
                }
                coolBuilder.bgHeight = i16;
                coolBuilder.txtSize = 11;
            }
        } else {
            coolBuilder.logoWidth = 24;
            coolBuilder.logoHeight = 12;
            coolBuilder.bgHeight = 12;
        }
        if (QLog.isColorLevel()) {
            QLog.d(CoolTextView.TAG, 2, "QID_LOG,qid_cool," + card.uin + "," + TextUtils.isEmpty(coolBuilder.infoStr) + "," + TextUtils.isEmpty(coolBuilder.logoUrl) + "," + TextUtils.isEmpty(coolBuilder.bgUrl));
        }
        return coolBuilder;
    }

    public void adapterQidMargin(float f16, float f17) {
        setMargins(ScreenUtil.dip2px(5.0f), 0, ScreenUtil.dip2px(f16), ScreenUtil.dip2px(f17));
    }

    public int baseCardBottomMargin(ProfileCardInfo profileCardInfo) {
        Card card;
        boolean z16;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            if (PrettyAccountUtil.isPrettyOpenForCard(card) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (TextUtils.isEmpty(profileCardInfo.card.qidBgUrl)) {
                if (TextUtils.isEmpty(profileCardInfo.card.qidLogoUrl) || !z16) {
                    return 3;
                }
                return 4;
            }
            if (!TextUtils.isEmpty(profileCardInfo.card.qidLogoUrl)) {
                if (!z16) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    public boolean isVipStyle(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return false;
        }
        return isVipStyle(card.qidLogoUrl, card.qidBgUrl);
    }

    public void updateQidView(AppRuntime appRuntime, ProfileCardInfo profileCardInfo) {
        String str;
        if (appRuntime == null) {
            return;
        }
        if (!checkDataReady(profileCardInfo)) {
            setVisibility(8);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("QID_LOG,data_check_state:");
                sb5.append(!checkDataReady(profileCardInfo));
                QLog.d(CoolTextView.TAG, 2, sb5.toString());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(profileCardInfo.card.qid) && !isQIdVisible()) {
            setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(profileCardInfo.card.qid) && !profileCardInfo.allInOne.uin.equals(appRuntime.getCurrentAccountUin())) {
            setVisibility(8);
            return;
        }
        if (ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
            setVisibility(8);
            return;
        }
        adapterDrawablesDiff(-1);
        CoolTextView.CoolBuilder prepareQidBuilder = prepareQidBuilder(profileCardInfo.card);
        setCoolBuilder(prepareQidBuilder);
        setVisibility(0);
        if (TextUtils.isEmpty(prepareQidBuilder.infoStr)) {
            str = getResources().getString(R.string.zqk);
        } else {
            str = prepareQidBuilder.infoStr;
        }
        setContentDescription(str);
        VipQidHelper.reportQIdEvent("0X800B60C", profileCardInfo);
    }

    public QidCoolTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isVipStyle(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }
}

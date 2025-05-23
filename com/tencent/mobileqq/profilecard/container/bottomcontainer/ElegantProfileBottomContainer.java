package com.tencent.mobileqq.profilecard.container.bottomcontainer;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardElegantConfig;
import com.tencent.mobileqq.profilecard.utils.ProfileCardReportUtil;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ReportConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

/* loaded from: classes35.dex */
public class ElegantProfileBottomContainer extends BaseProfileBottomContainer {
    private static HashMap<Integer, String> DTREPORTMAP = null;
    private static int ONE_BTN = 1;
    private static final String TAG = "ElegantProfileBottomContainer";
    private static int THREE_BTN = 3;
    private static int TWO_BTN = 2;
    private boolean isNeedShowGitBtn;
    private LinearLayout mBottomBtnLayout;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        DTREPORTMAP = hashMap;
        hashMap.put(20, ProfileCardDtReportUtil.DT_REPORT_VIDEO_CALL);
        DTREPORTMAP.put(77, ProfileCardDtReportUtil.DT_REPORT_GIFT);
        DTREPORTMAP.put(95, ProfileCardDtReportUtil.DT_REPORT_GIFT);
        DTREPORTMAP.put(8, ProfileCardDtReportUtil.DT_REPORT_SEED);
        DTREPORTMAP.put(7, ProfileCardDtReportUtil.DT_REPORT_ADD_FRIEND);
        DTREPORTMAP.put(81, ProfileCardDtReportUtil.DT_REPORT_EDIT);
    }

    public ElegantProfileBottomContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isNeedShowGitBtn = false;
    }

    private void adjustMarginBtn(LinearLayout linearLayout) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            QLog.e(TAG, 1, "adjustMarginBtn is error! mActivity is null!");
            return;
        }
        Resources resources = qBaseActivity.getResources();
        int childCount = linearLayout.getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            if (this.mBtnsContainer.getChildAt(i16).getVisibility() == 0) {
                i3++;
            }
        }
        if (i3 == ONE_BTN || i3 == TWO_BTN || i3 == THREE_BTN) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.d9o);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f159470d81);
            boolean z16 = true;
            for (int i17 = 0; i17 < childCount; i17++) {
                if (this.mBtnsContainer.getChildAt(i17).getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnsContainer.getChildAt(i17).getLayoutParams();
                    if (z16) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                        z16 = false;
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = i3 == 1 ? dimensionPixelSize2 : dimensionPixelSize;
                    i3--;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void contactProfileReport(QQAppInterface qQAppInterface) {
        if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne)) {
            ReportController.o(qQAppInterface, "dc00898", "", "", ReportConstants.CONTACT_PROFILE_BE_FRIEND_CLICK, ReportConstants.CONTACT_PROFILE_BE_FRIEND_CLICK, ProfileCardReportUtil.getProfileSourceType(((ProfileCardInfo) this.mData).allInOne), 0, "", "", "", "");
        }
    }

    private void removeButtonByDataTag(LinearLayout linearLayout, int i3) {
        int childCount = linearLayout.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            Button button = (Button) linearLayout.getChildAt(i16).findViewById(R.id.txt);
            if (button != null && button.getTag() != null && !TextUtils.isEmpty(button.getText().toString()) && ((com.tencent.mobileqq.profile.b) button.getTag()).f260135a == i3) {
                linearLayout.getChildAt(i16).setVisibility(8);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer
    public void initBottomBtns(LinearLayout linearLayout) {
        super.initBottomBtns(linearLayout);
        this.mBottomBtnLayout = (LinearLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.acy);
        Resources resources = this.mActivity.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBtnsContainer.getLayoutParams();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f159471d82);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.topMargin = dimensionPixelSize;
        this.mBtnsContainer.setPadding(0, 0, 0, 0);
        ((FrameLayout) this.mViewContainer).findViewById(R.id.uj_).setVisibility(8);
        this.mBottomBtnLayout.setBackground(resources.getDrawable(R.drawable.qui_common_fill_light_primary_bg));
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            if (DTREPORTMAP.get(Integer.valueOf(bVar.f260135a)) != null) {
                ProfileCardDtReportUtil.initElementNoExposure(view, DTREPORTMAP.get(Integer.valueOf(bVar.f260135a)));
            }
            QLog.i(TAG, 1, "[onClick] data.nType=" + bVar.f260135a);
            int i3 = bVar.f260135a;
            if (i3 == 7) {
                dtReport(view);
                contactProfileReport((QQAppInterface) this.mApp);
                handleAddFriendClick();
                return;
            }
            if (i3 == 8) {
                dtReport(view);
                handleChatClick();
                return;
            }
            if (i3 == 20) {
                dtReport(view);
                handleFreeCallClick();
                return;
            }
            if (i3 == 23) {
                handleTemplateClick(view, bVar);
                return;
            }
            if (i3 == 59) {
                handleSaveContactClick();
                return;
            }
            if (i3 == 77) {
                dtReport(view);
                handleTroopSendGiftClick();
                return;
            }
            if (i3 == 81) {
                dtReport(view);
                handleEditClick();
                return;
            }
            if (i3 == 92) {
                handleTemplateClickForDiy(view, bVar);
                return;
            }
            if (i3 == 95) {
                dtReport(view);
                handleGivePresentClick();
            } else {
                if (i3 != 115) {
                    return;
                }
                dtReport(view);
                handleAgreeToAddFriendClick();
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void setProfileActivityDelegate(IProfileActivityDelegate iProfileActivityDelegate) {
        super.setProfileActivityDelegate(iProfileActivityDelegate);
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null) {
            this.isNeedShowGitBtn = ((ProfileCardElegantConfig) iProfileActivityDelegate2.getProfileCardMultiple().getMultiConfig()).isShowGiftBtn();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer
    public void updateBtnGroupInner(int i3) {
        super.updateBtnGroupInner(i3);
        LinearLayout linearLayout = this.mBtnsContainer;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        if (!this.isNeedShowGitBtn && (i3 == 12 || i3 == 4)) {
            removeButtonByDataTag(this.mBtnsContainer, 95);
            removeButtonByDataTag(this.mBtnsContainer, 77);
        }
        adjustMarginBtn(this.mBtnsContainer);
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        LinearLayout linearLayout = this.mBtnsContainer;
        if (linearLayout != null) {
            initBottomBtns(linearLayout);
        }
        return super.lambda$checkValidComponent$3(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer
    public void initDtReport(final LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        linearLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.bottomcontainer.ElegantProfileBottomContainer.1
            @Override // java.lang.Runnable
            public void run() {
                LinearLayout linearLayout2 = linearLayout;
                if (linearLayout2 == null) {
                    return;
                }
                int childCount = linearLayout2.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    Button button = (Button) linearLayout.getChildAt(i3).findViewById(R.id.ouc);
                    if (button != null && button.getTag() != null && !TextUtils.isEmpty(button.getText().toString())) {
                        com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) button.getTag();
                        if (ElegantProfileBottomContainer.DTREPORTMAP.get(Integer.valueOf(bVar.f260135a)) != null) {
                            ProfileCardDtReportUtil.initElementNoExposure(button, (String) ElegantProfileBottomContainer.DTREPORTMAP.get(Integer.valueOf(bVar.f260135a)));
                            HashMap hashMap = new HashMap();
                            hashMap.put("dt_eid", (String) ElegantProfileBottomContainer.DTREPORTMAP.get(Integer.valueOf(bVar.f260135a)));
                            VideoReport.reportEvent("imp", button, hashMap);
                        }
                    }
                }
            }
        }, 100L);
    }
}

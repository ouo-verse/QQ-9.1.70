package com.tencent.mobileqq.profilecard.container.bottomcontainer;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

/* loaded from: classes35.dex */
public class OldProfileBottomContainer extends BaseProfileBottomContainer {
    private static final String TAG = "DeafultProfileBottomContainer";

    public OldProfileBottomContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer
    public void initDtReport(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Button button = (Button) linearLayout.getChildAt(i3).findViewById(R.id.txt);
            if (button != null && button.getTag() != null && !TextUtils.isEmpty(button.getText().toString())) {
                int i16 = ((com.tencent.mobileqq.profile.b) button.getTag()).f260135a;
                if (i16 == 8) {
                    initElement(button, ProfileCardDtReportUtil.DT_REPORT_SEED);
                } else if (i16 == 7) {
                    initElement(button, ProfileCardDtReportUtil.DT_REPORT_ADD_FRIEND);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.container.bottomcontainer.BaseProfileBottomContainer, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 == 7) {
                dtReport(view);
                handleAddFriendClick();
                return;
            }
            if (i3 == 8) {
                dtReport(view);
                handleChatClick();
                return;
            }
            if (i3 == 20) {
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
                handleTroopSendGiftClick();
                return;
            }
            if (i3 == 81) {
                handleEditClick();
                return;
            }
            if (i3 == 92) {
                handleTemplateClickForDiy(view, bVar);
                return;
            }
            if (i3 == 95) {
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
}

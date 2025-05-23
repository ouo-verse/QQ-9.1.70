package com.tencent.mobileqq.profilecard.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardStateListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.StrongSimilarityData;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.container.bottomcontainer.ElegantProfileBottomContainer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

/* loaded from: classes35.dex */
public class ProfileInStepBubbleTips {
    private static final int BUBBLE_HORIZONTAL_PADDING_DP = 2;
    private static final int BUBBLE_TEXT_DOUBLE_LINE_THRESHOLD = 5;
    private static final int BUBBLE_VERTICAL_PADDING_DP = 5;
    private static final long ONE_SEC = 1000;
    private static final int SHADOW_COLOR = Color.parseColor("#24000000");
    private static final int SHADOW_OFFSET_X_DP = 0;
    private static final int SHADOW_OFFSET_Y_DP = 2;
    private static final int SHADOW_RADIUS_DP = 6;
    private static final int SHADOW_RESERVE_DP = 5;
    private static final String TAG = "ProfileInStepBubbleTips";
    private Activity activity;
    private Card card;
    private IComponentCenter componentCenter;
    private boolean hasPostBubbleTask = false;
    private boolean isFullScreenMode = false;
    private boolean isBubbleTipsShowTaskBlocked = false;
    Runnable bubbleTipsShowTask = new Runnable() { // from class: com.tencent.mobileqq.profilecard.utils.k
        @Override // java.lang.Runnable
        public final void run() {
            ProfileInStepBubbleTips.this.lambda$new$2();
        }
    };

    private String getBubbleText(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("\n") || (length = str.length()) <= 5) {
            return str;
        }
        int i3 = (length + 1) / 2;
        return str.substring(0, i3) + "\n" + str.substring(i3, length);
    }

    private CalloutPopupWindow getCalloutPopupWindow(Activity activity, StrongSimilarityData strongSimilarityData) {
        Resources resources = activity.getResources();
        return new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(activity).setText(getBubbleText(strongSimilarityData.content)).setTextSize(resources.getDimensionPixelSize(R.dimen.f10672p)).setTextColor(resources.getColor(R.color.qui_common_bubble_guest_text_primary)).setIconDrawable(getIconDrawable(strongSimilarityData.icon, resources)).setPosition(49).setLifetime(strongSimilarityData.displayDuration).setVerticalPaddingDp(5).setHorizontalPaddingDp(2).setShadowParams(getShadowParams())).setBackgroundColor(resources.getColor(R.color.qui_common_bubble_guest)).setBackgroundRadius(4).build().build();
    }

    private Drawable getIconDrawable(String str, Resources resources) {
        if (TextUtils.isEmpty(str)) {
            return resources.getDrawable(R.drawable.g5t);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.getScreenWidth();
        obtain.mRequestHeight = ViewUtils.getScreenHeight();
        Drawable drawable = resources.getDrawable(R.drawable.g5t);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseApngImage = true;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        return drawable2;
    }

    private CalloutPopupWindow.ShadowParams getShadowParams() {
        return new CalloutPopupWindow.ShadowParams(0.0f, 2.0f, 6.0f, 5.0f, SHADOW_COLOR);
    }

    private void initCardListStateListener(RFWCardExtension rFWCardExtension) {
        rFWCardExtension.setStateListener(new RFWCardStateListener() { // from class: com.tencent.mobileqq.profilecard.utils.l
            @Override // com.tencent.biz.richframework.widget.listview.card.api.RFWCardStateListener
            public final void onChange(int i3) {
                ProfileInStepBubbleTips.this.lambda$initCardListStateListener$0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view, CalloutPopupWindow calloutPopupWindow) {
        View findAddFriendButton = findAddFriendButton(view);
        if (findAddFriendButton == null) {
            return;
        }
        calloutPopupWindow.showAsPointer(findAddFriendButton);
        com.tencent.relation.common.utils.i.c().k(this.card.uin);
        ProfileInStepReportHelper.reportBubbleTipsExpose(calloutPopupWindow.getContentView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        final FrameLayout containerView;
        Activity activity = this.activity;
        if (activity == null || activity.isFinishing() || this.componentCenter == null) {
            return;
        }
        if (this.isFullScreenMode) {
            this.isBubbleTipsShowTaskBlocked = true;
            return;
        }
        final CalloutPopupWindow calloutPopupWindow = getCalloutPopupWindow(this.activity, this.card.strongSimilarityData);
        ProfileInStepReportHelper.registerBubbleTipsElement(this.activity, calloutPopupWindow.getContentView(), this.card.strongSimilarityData);
        IComponent component = this.componentCenter.getComponent(107);
        if (component instanceof ElegantProfileBottomContainer) {
            containerView = ((ElegantProfileBottomContainer) component).getContainerView();
        } else {
            containerView = component instanceof ProfileBottomContainer ? ((ProfileBottomContainer) component).getContainerView() : null;
        }
        if (containerView == null) {
            return;
        }
        containerView.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.utils.j
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInStepBubbleTips.this.lambda$new$1(containerView, calloutPopupWindow);
            }
        });
    }

    private View findAddFriendButton(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.al_);
        if (viewGroup == null) {
            QLog.e(TAG, 1, "findAddFriendButton fail, buttonsView is null");
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                QUIButton qUIButton = (QUIButton) childAt.findViewById(R.id.txt);
                if (qUIButton == null) {
                    qUIButton = (QUIButton) childAt.findViewById(R.id.ouc);
                }
                if (qUIButton != null && (qUIButton.getTag() instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) qUIButton.getTag()).f260135a == 7) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void showBubbleTipsView(StrongSimilarityData strongSimilarityData, boolean z16) {
        if (strongSimilarityData == null) {
            QLog.e(TAG, 1, "showBubbleTipsView fail, data is null");
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.bubbleTipsShowTask, z16 ? 0L : strongSimilarityData.delayDisplayTime * 1000);
        }
    }

    public void checkShowBubbleTips(Activity activity, RFWCardExtension rFWCardExtension, Card card, IComponentCenter iComponentCenter) {
        if (card != null && !TextUtils.isEmpty(card.uin) && card.isStrongSimilarity && card.strongSimilarityData != null) {
            if (com.tencent.relation.common.utils.i.c().g(card.uin, card.strongSimilarityData.timeThread)) {
                return;
            }
            this.activity = activity;
            this.card = card;
            this.componentCenter = iComponentCenter;
            initCardListStateListener(rFWCardExtension);
            if (this.hasPostBubbleTask) {
                return;
            }
            this.hasPostBubbleTask = true;
            showBubbleTipsView(card.strongSimilarityData, false);
            return;
        }
        QLog.e(TAG, 1, "checkShowBubbleTips fail, param is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCardListStateListener$0(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            this.isFullScreenMode = true;
        } else {
            this.isFullScreenMode = false;
            if (this.isBubbleTipsShowTaskBlocked) {
                showBubbleTipsView(this.card.strongSimilarityData, true);
                this.isBubbleTipsShowTaskBlocked = false;
            }
        }
    }
}

package com.tencent.mobileqq.profilecard.view.head;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileNickUpgradeSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ElegantQQProfileHeadView extends AbsElegantProfileHeadView {
    private static final String TAG = "ElegantQQProfileHeadView";
    private boolean mIsNeedHideStatusBubble;
    private boolean mIsShowingBubble;
    private FrameLayout mOnlineStatusBubbleLayout;
    private hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> mOnlineStatusCallback;
    private TextView mOnlineStatusTextView;
    private WeakReference<QBaseActivity> mRefActivity;
    private volatile long updateSeq;

    public ElegantQQProfileHeadView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        super(qBaseActivity, profileCardInfo, iProfileActivityDelegate);
        this.updateSeq = 0L;
        this.mIsShowingBubble = false;
        this.mIsNeedHideStatusBubble = false;
        this.mRefActivity = new WeakReference<>(qBaseActivity);
    }

    private void addOnlineStatusChangedCallback() {
        String currentUid = getCurrentUid();
        if (currentUid == null || currentUid.isEmpty() || this.mOnlineStatusCallback != null) {
            return;
        }
        this.mOnlineStatusCallback = new hx3.b() { // from class: com.tencent.mobileqq.profilecard.view.head.ae
            @Override // hx3.b
            public final void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                ElegantQQProfileHeadView.this.lambda$addOnlineStatusChangedCallback$5(eVar);
            }
        };
        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(currentUid, TAG, this.mOnlineStatusCallback);
    }

    private String getCurrentUid() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUid();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOnlineStatusChangedCallback$4(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        updateOnlineStatusView(cVar.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRemarkView$0(long j3, TroopMemberInfo troopMemberInfo, Card card, ProfileCardInfo profileCardInfo) {
        if (this.updateSeq > j3) {
            QLog.e(TAG, 1, "initRemarkView return, updateSeq=" + this.updateSeq + ", localUpdateSeq=" + j3);
            return;
        }
        if (ProfileNickUpgradeSwitch.getInstance().isEnable()) {
            initRemarkViewNewLogic(troopMemberInfo, card, profileCardInfo);
        } else {
            initRemarkViewOldLogic(troopMemberInfo, card);
        }
        this.updateSeq = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRemarkView$1(final long j3, final Card card, final ProfileCardInfo profileCardInfo, final TroopMemberInfo troopMemberInfo) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.af
            @Override // java.lang.Runnable
            public final void run() {
                ElegantQQProfileHeadView.this.lambda$initRemarkView$0(j3, troopMemberInfo, card, profileCardInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMyDialog$2(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3, View view) {
        if (getContext() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "showMyDialog popup Window");
        }
        com.tencent.mobileqq.activity.aio.l.V((Activity) getContext(), dVar, cVar, 6, false);
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C41D", "0X800C41D", 0, 0, String.valueOf(i3), "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateOnlineStatusView$3(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, int i3, View view) {
        if (getContext() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "showMyDialog popup Window");
        }
        com.tencent.mobileqq.activity.aio.l.V((Activity) getContext(), dVar, cVar, 6, false);
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C41D", "0X800C41D", 0, 0, String.valueOf(i3), "", "", "");
    }

    private void removeOnlineStatusCallback() {
        String currentUid;
        if (this.mOnlineStatusCallback == null || (currentUid = getCurrentUid()) == null || currentUid.isEmpty()) {
            return;
        }
        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(currentUid, TAG, this.mOnlineStatusCallback);
        this.mOnlineStatusCallback = null;
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView
    protected void hiddeMyDialog() {
        if (!be.k()) {
            QLog.d(TAG, 1, "[hiddeMyDialog]: return switch close");
            return;
        }
        this.mIsNeedHideStatusBubble = true;
        FrameLayout frameLayout = this.mOnlineStatusBubbleLayout;
        if (frameLayout == null) {
            QLog.d(TAG, 1, "hiddeMyDialog mOnlineStatusBubbleLayout == null");
            return;
        }
        frameLayout.removeAllViews();
        this.mOnlineStatusBubbleLayout.setVisibility(8);
        this.mOnlineStatusBubbleLayout = null;
        removeOnlineStatusCallback();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "hiddeMyDialog");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsElegantProfileHeadView
    public void initRemarkView(final ProfileCardInfo profileCardInfo) {
        ContactCard contactCard;
        if (this.mRemarkView == null) {
            return;
        }
        final Card card = profileCardInfo.card;
        if (card == null && (contactCard = profileCardInfo.contactCard) != null) {
            setMarkName(contactCard.nickName);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (card == null) {
            QLog.e(TAG, 1, "initRemarkView fail, card is null");
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, card.uin, false, this.mRefActivity.get(), TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.view.head.ah
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    ElegantQQProfileHeadView.this.lambda$initRemarkView$1(currentTimeMillis, card, profileCardInfo, troopMemberInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView
    protected void showMyDialog() {
        if (this.mZplanCoverView != null && this.mApp != null && !this.mIsShowingBubble && !this.mIsNeedHideStatusBubble && getContext() != null) {
            AllInOne allInOne = this.mCardInfo.allInOne;
            String str = allInOne != null ? allInOne.uin : null;
            if (TextUtils.isEmpty(str)) {
                QLog.d(TAG, 1, "showMyDialog uin == null");
                return;
            }
            if (be.k() && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                if (TextUtils.isEmpty(uidFromUin) || !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
                    return;
                }
                addOnlineStatusChangedCallback();
                final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
                final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, TAG);
                if (friendsSimpleInfoWithUid != null && onlineStatusSimpleInfoWithUid != null) {
                    final int i3 = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfo(this.mApp, str).f256383a;
                    AppRuntime.Status translateNT = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).translateNT(onlineStatusSimpleInfoWithUid);
                    au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(translateNT, onlineStatusSimpleInfoWithUid.e0(), false);
                    this.mOnlineStatusBubbleLayout = new FrameLayout(getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = ViewUtils.dip2px(76.0f);
                    layoutParams.leftMargin = ViewUtils.dip2px(39.0f);
                    TextView textView = new TextView(getContext());
                    textView.setGravity(16);
                    String str2 = onlineStatusItem.f255490c;
                    if (onlineStatusSimpleInfoWithUid.e0() == 2000) {
                        str2 = onlineStatusSimpleInfoWithUid.v();
                    }
                    if (str2 != null && str2.length() > 4) {
                        str2 = str2.substring(0, 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    textView.setText(str2);
                    Drawable selfStatusDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(onlineStatusSimpleInfoWithUid.e0(), translateNT, 1, onlineStatusSimpleInfoWithUid, 0);
                    if (selfStatusDrawable == null) {
                        return;
                    }
                    int dip2px = ViewUtils.dip2px(2.0f);
                    Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.qui_chevron_right_icon_secondary_01);
                    int dip2px2 = ViewUtils.dip2px(16.0f);
                    if (drawable != null) {
                        drawable.setBounds(0, 0, dip2px2, dip2px2);
                    }
                    textView.setBackgroundResource(QQTheme.isNowThemeIsNight() ? R.drawable.g5r : R.drawable.g5q);
                    textView.setCompoundDrawablePadding(dip2px);
                    textView.setCompoundDrawables(selfStatusDrawable, null, drawable, null);
                    textView.setTextColor(QQTheme.isNowThemeIsNight() ? -1 : -16777216);
                    textView.setTextSize(14.0f);
                    textView.setPadding(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(5.0f), ViewUtils.dip2px(8.0f), ViewUtils.dip2px(5.0f));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ac
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElegantQQProfileHeadView.this.lambda$showMyDialog$2(friendsSimpleInfoWithUid, onlineStatusSimpleInfoWithUid, i3, view);
                        }
                    });
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.rightMargin = ViewUtils.dip2px(8.0f);
                    this.mOnlineStatusBubbleLayout.addView(textView, layoutParams2);
                    this.mOnlineStatusTextView = textView;
                    ImageView imageView = new ImageView(getContext());
                    imageView.setImageResource(QQTheme.isNowThemeIsNight() ? R.drawable.g5p : R.drawable.g5o);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ViewUtils.dip2px(15.5f), ViewUtils.dip2px(17.5f));
                    layoutParams3.gravity = 8388613;
                    layoutParams3.topMargin = ViewUtils.dip2px(28.0f);
                    this.mOnlineStatusBubbleLayout.addView(imageView, layoutParams3);
                    this.mZplanCoverView.addView(this.mOnlineStatusBubbleLayout, layoutParams);
                    this.mIsShowingBubble = true;
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C41C", "0X800C41C", 0, 0, String.valueOf(i3), "", "", "");
                    if (FontSettingManager.getFontLevel() > 16.0f) {
                        FontSettingManager.resetViewSize2Normal(this.mActivity, this.mOnlineStatusBubbleLayout);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "showMyDialog");
                        return;
                    }
                    return;
                }
                QLog.d(TAG, 1, "showMyDialog friendInfo == null or statusInfo == null");
                return;
            }
            QLog.d(TAG, 1, "showMyDialog return switch close");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showMyDialog mZplanCoverView: ");
        sb5.append(this.mZplanCoverView == null);
        sb5.append(" mApp: ");
        sb5.append(this.mApp == null);
        sb5.append(" isShowBubble: ");
        sb5.append(this.mIsShowingBubble);
        sb5.append(" getContext(): ");
        sb5.append(getContext() == null);
        QLog.d(TAG, 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateOnlineStatusView(String str) {
        if (!OnlineStatusToggleUtils.t() || this.mOnlineStatusTextView == null || TextUtils.isEmpty(str)) {
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return;
        }
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, TAG);
        if (friendsSimpleInfoWithUid != null && onlineStatusSimpleInfoWithUid != null) {
            final int i3 = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfo(this.mApp, str).f256383a;
            AppRuntime.Status translateNT = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).translateNT(onlineStatusSimpleInfoWithUid);
            String str2 = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(translateNT, onlineStatusSimpleInfoWithUid.e0(), false).f255490c;
            if (onlineStatusSimpleInfoWithUid.e0() == 2000) {
                str2 = onlineStatusSimpleInfoWithUid.v();
            }
            if (str2 != null && str2.length() > 4) {
                str2 = str2.substring(0, 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.mOnlineStatusTextView.setText(str2);
            Drawable selfStatusDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(onlineStatusSimpleInfoWithUid.e0(), translateNT, 1, onlineStatusSimpleInfoWithUid, 0);
            if (selfStatusDrawable == null) {
                return;
            }
            int dip2px = ViewUtils.dip2px(2.0f);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.qui_chevron_right_icon_secondary_01);
            int dip2px2 = ViewUtils.dip2px(16.0f);
            if (drawable != null) {
                drawable.setBounds(0, 0, dip2px2, dip2px2);
            }
            this.mOnlineStatusTextView.setBackgroundResource(QQTheme.isNowThemeIsNight() ? R.drawable.g5r : R.drawable.g5q);
            this.mOnlineStatusTextView.setCompoundDrawablePadding(dip2px);
            this.mOnlineStatusTextView.setCompoundDrawables(selfStatusDrawable, null, drawable, null);
            this.mOnlineStatusTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ElegantQQProfileHeadView.this.lambda$updateOnlineStatusView$3(friendsSimpleInfoWithUid, onlineStatusSimpleInfoWithUid, i3, view);
                }
            });
            return;
        }
        QLog.d(TAG, 1, "updateOnlineStatusView friendInfo == null or statusInfo == null");
    }

    private void initRemarkViewOldLogic(TroopMemberInfo troopMemberInfo, Card card) {
        if (card == null) {
            QLog.e(TAG, 1, "initRemarkViewOldLogic fail, card is null");
            return;
        }
        if (card.isForbidAccount) {
            QLog.i(TAG, 1, "initRemarkViewOldLogic but isForbidAccount");
            return;
        }
        if (troopMemberInfo != null && TextUtils.isEmpty(troopMemberInfo.troopnick) && !TextUtils.isEmpty(card.strReMark)) {
            setMarkName(card.strNick);
            return;
        }
        if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.troopnick) && !TextUtils.isEmpty(card.strReMark)) {
            setMarkName(card.strReMark);
            return;
        }
        if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.troopnick) && TextUtils.isEmpty(card.strReMark)) {
            setMarkName(card.strNick);
        } else if (troopMemberInfo == null && !TextUtils.isEmpty(card.strReMark)) {
            setMarkName(card.strNick);
        } else {
            this.mRemarkView.setVisibility(8);
        }
    }

    private void initRemarkViewNewLogic(TroopMemberInfo troopMemberInfo, Card card, ProfileCardInfo profileCardInfo) {
        String str;
        if (card != null && card.isForbidAccount) {
            QLog.i(TAG, 1, "initRemarkViewNewLogic but isForbidAccount");
            return;
        }
        String buddyRemark = getBuddyRemark(profileCardInfo);
        if (TextUtils.isEmpty(buddyRemark) && card != null) {
            buddyRemark = card.strReMark;
        }
        if (card != null && !TextUtils.isEmpty(buddyRemark)) {
            setMarkName(card.strNick);
        } else {
            dismissRemarkView();
        }
        if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.troopColorNick)) {
            str = troopMemberInfo.troopColorNick;
        } else {
            str = (troopMemberInfo == null || TextUtils.isEmpty(troopMemberInfo.troopnick)) ? null : troopMemberInfo.troopnick;
        }
        if (str != null) {
            setTroopRemarkName(str);
        } else {
            dismissTroopRemarkView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOnlineStatusChangedCallback$5(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
        final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        if (eVar == null || eVar.a() != 0 || eVar.b() == null || eVar.b().isEmpty() || (cVar = (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) eVar.b().get(0)) == null || !TextUtils.equals(cVar.getUid(), getCurrentUid())) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.ad
            @Override // java.lang.Runnable
            public final void run() {
                ElegantQQProfileHeadView.this.lambda$addOnlineStatusChangedCallback$4(cVar);
            }
        });
    }
}

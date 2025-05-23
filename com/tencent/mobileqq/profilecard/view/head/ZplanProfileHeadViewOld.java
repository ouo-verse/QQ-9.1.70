package com.tencent.mobileqq.profilecard.view.head;

import android.content.Intent;
import android.graphics.Outline;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreFragment;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.UnicodeEmojiUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;

/* loaded from: classes35.dex */
public class ZplanProfileHeadViewOld extends AbsQCircleProfileHeaderView {
    private static final int QID_DEFAULT_UIN_MARGIN_TOP = 0;
    private static final int QID_PRETTY_UIN_MARGIN_TOP = -3;
    private static final int QID_SVIP_UIN_MARGIN_TOP = -2;
    private QBaseActivity mActivity;
    public TextView mNickView;
    private TextView mNickViewExt;
    public TextView mRemarkPreView;
    protected TextView mRemarkView;
    private TroopMemberInfo tmi;
    private static final int BG_VIEW_RADIUS = ViewUtils.dip2px(20.0f);
    private static final int REMARK_NAME_MARGIN_TOP = ViewUtils.dip2px(56.0f);
    private static final int REMARK_NAME_MARGIN_TOP_NO_EXT = ViewUtils.dip2px(28.0f);

    public ZplanProfileHeadViewOld(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        super(qBaseActivity, profileCardInfo);
        this.mActivity = qBaseActivity;
        this.mIsShowZplanCover = iProfileActivityDelegate != null && iProfileActivityDelegate.getIsShowZplanCover();
        this.mIsShowQCircleCover = iProfileActivityDelegate != null && iProfileActivityDelegate.isShowQCircleCover();
        this.mDelegate = iProfileActivityDelegate;
    }

    private void adaptBgViewNightMode() {
        if (this.mContentBgView == null) {
            return;
        }
        if (ThemeUtil.isInNightMode(this.mApp)) {
            this.mContentBgView.setBackgroundColor(-16777216);
        } else {
            this.mContentBgView.setBackgroundResource(R.drawable.qq_profilecard_info_bg);
        }
    }

    private int getFirstNickTextFixEmojiNum(int i3) {
        TextView textView = this.mNickView;
        if (textView != null && textView.getText() != null && !TextUtils.isEmpty(this.mNickView.getText().toString())) {
            int i16 = i3 - 1;
            if (UnicodeEmojiUtil.isEmojiFirstCharacter(this.mNickView.getText().toString(), i16)) {
                return i16;
            }
        }
        return i3;
    }

    private int getFirstNickViewTextNum(int i3) {
        int length = this.mNickView.getText().toString().length();
        int i16 = 1;
        while (i16 < length) {
            i16++;
            if (((int) this.mNickView.getPaint().measureText(this.mNickView.getText().toString().substring(0, i16))) > i3) {
                return getFirstNickTextFixEmojiNum(i16 - 1);
            }
        }
        return getFirstNickTextFixEmojiNum(i16);
    }

    private int getNickViewMaxWidth() {
        DisplayMetrics displayMetrics;
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || qBaseActivity.getResources() == null || (displayMetrics = this.mActivity.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        float dimension = this.mActivity.getResources().getDimension(R.dimen.cap);
        float dimension2 = this.mActivity.getResources().getDimension(R.dimen.cak);
        float dimension3 = this.mActivity.getResources().getDimension(R.dimen.cal);
        return min - ((int) (((((dimension + dimension2) + dimension3) + this.mActivity.getResources().getDimension(R.dimen.cao)) + this.mActivity.getResources().getDimension(R.dimen.cam)) + this.mActivity.getResources().getDimension(R.dimen.can)));
    }

    private void initNickView(ProfileCardInfo profileCardInfo) {
        ProfileNameView profileNameView = (ProfileNameView) this.mHeaderChildMap.get("map_key_profile_nick_name");
        if (profileNameView != null) {
            profileNameView.setVisibility(8);
        }
        Card card = profileCardInfo.card;
        if (card != null) {
            if (this.tmi == null) {
                this.tmi = getTroopMember(profileCardInfo);
            }
            TroopMemberInfo troopMemberInfo = this.tmi;
            if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.troopnick)) {
                this.mNickView.setText(this.tmi.troopnick);
            } else if (!TextUtils.isEmpty(card.strReMark)) {
                this.mNickView.setText(card.strReMark);
            } else {
                this.mNickView.setText(getNickText(profileCardInfo));
            }
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.mNickView, card);
        } else {
            ContactCard contactCard = profileCardInfo.contactCard;
            if (contactCard != null) {
                this.mNickView.setText(contactCard.nickName);
                ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.mNickView, profileCardInfo.contactCard.uin, false);
            } else {
                this.mNickView.setText("");
            }
        }
        this.mNickView.setTag(new com.tencent.mobileqq.profile.b(88, this.mNickView.getText().toString()));
        this.mNickView.setOnClickListener(this.mOnClickListener);
        initNickTroopView(profileCardInfo);
        updateNickView(profileCardInfo);
    }

    private void setCoverMask() {
        RandomCoverView randomCoverView = this.mCoverView;
        if (randomCoverView == null || randomCoverView.b() == null || ThemeUtil.isInNightMode(this.mApp)) {
            return;
        }
        this.mCoverView.b().setVisibility(8);
    }

    private void setMarkName(ProfileCardInfo profileCardInfo, String str) {
        if (isTwoLineNick(profileCardInfo)) {
            ((RelativeLayout.LayoutParams) this.mRemarkView.getLayoutParams()).setMargins(0, REMARK_NAME_MARGIN_TOP, 0, 0);
        } else {
            ((RelativeLayout.LayoutParams) this.mRemarkView.getLayoutParams()).setMargins(0, REMARK_NAME_MARGIN_TOP_NO_EXT, 0, 0);
        }
        this.mRemarkView.setText(String.format("\u6635\u79f0\uff1a%s", str));
        this.mRemarkView.setVisibility(0);
        LongClickCopyAction.attachCopyAction(this.mRemarkView, getResources().getString(R.string.f203254zp), str);
    }

    private void setNickLongClickAction(String str) {
        final LongClickCopyAction attachCopyAction = LongClickCopyAction.attachCopyAction(this.mNickView, getResources().getString(R.string.f203254zp), str);
        attachCopyAction.setCopyListener(new LongClickCopyAction.ICopyListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld.3
            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onCopyContent(String str2) {
                attachCopyAction.cleanCopyContent(ZplanProfileHeadViewOld.this.mNickViewExt);
            }

            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onDismiss() {
                attachCopyAction.cleanCopyContent(ZplanProfileHeadViewOld.this.mNickViewExt);
            }

            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onShowCopyMenu() {
                attachCopyAction.markTextViewCopyContent(ZplanProfileHeadViewOld.this.mNickViewExt);
            }
        });
        final LongClickCopyAction attachCopyAction2 = LongClickCopyAction.attachCopyAction(this.mNickViewExt, getResources().getString(R.string.f203254zp), str);
        attachCopyAction2.setCopyListener(new LongClickCopyAction.ICopyListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld.4
            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onCopyContent(String str2) {
                attachCopyAction2.cleanCopyContent(ZplanProfileHeadViewOld.this.mNickView);
            }

            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onDismiss() {
                attachCopyAction.cleanCopyContent(ZplanProfileHeadViewOld.this.mNickViewExt);
            }

            @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
            public void onShowCopyMenu() {
                attachCopyAction2.markTextViewCopyContent(ZplanProfileHeadViewOld.this.mNickView);
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected View initContentView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.hhc, (ViewGroup) this, true);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected void initCustomView() {
        QidCoolTextView qidCoolTextView = (QidCoolTextView) this.mContentView.findViewById(R.id.f61892zc);
        this.mQidInfoView = qidCoolTextView;
        this.mHeaderChildMap.put("map_key_qid_info", qidCoolTextView);
        this.mQidInfoView.setOnClickListener(this.mOnClickListener);
        this.mRemarkPreView = (TextView) this.mContentView.findViewById(R.id.gmx);
        this.mRemarkView = (TextView) this.mContentView.findViewById(R.id.f72723rm);
        this.mNickView = (TextView) this.mContentView.findViewById(R.id.f166411zr4);
        this.mNickViewExt = (TextView) this.mContentView.findViewById(R.id.f166410zr3);
        this.mAvatarPendant.setVisibility(8);
        setCoverMask();
        if (this.mContentBgView == null) {
            return;
        }
        adaptBgViewNightMode();
        this.mContentBgView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null || view == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + ZplanProfileHeadViewOld.BG_VIEW_RADIUS, ZplanProfileHeadViewOld.BG_VIEW_RADIUS);
            }
        });
        this.mContentBgView.setClipToOutline(true);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected int initHeadViewResource() {
        return R.layout.hhe;
    }

    public void initRemarkView(ProfileCardInfo profileCardInfo) {
        ContactCard contactCard;
        if (this.mRemarkView == null) {
            return;
        }
        Card card = profileCardInfo.card;
        if (card == null && (contactCard = profileCardInfo.contactCard) != null) {
            setMarkName(profileCardInfo, contactCard.nickName);
            return;
        }
        if (this.tmi == null) {
            this.tmi = getTroopMember(profileCardInfo);
        }
        String str = card != null ? card.strNick : null;
        TroopMemberInfo troopMemberInfo = this.tmi;
        String str2 = troopMemberInfo != null ? troopMemberInfo.troopnick : null;
        String str3 = card != null ? card.strReMark : null;
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            setMarkName(profileCardInfo, str3);
            return;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            setMarkName(profileCardInfo, str3);
        } else if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            setMarkName(profileCardInfo, str);
        } else {
            this.mRemarkView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo) {
        super.onCoverModeChange(i3, profileCardInfo);
        if (QLog.isColorLevel()) {
            QLog.i(AbsProfileHeaderView.TAG, 2, String.format("onCoverModeChange mode: %s", Integer.valueOf(i3)));
        }
        updateQidViewMargin(profileCardInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        super.onInit(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        super.onUpdate(profileCardInfo, z16);
        initRemarkView(profileCardInfo);
        adaptBgViewNightMode();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateHead(ProfileCardInfo profileCardInfo) {
        super.updateHead(profileCardInfo);
        initNickView(profileCardInfo);
        initRemarkView(profileCardInfo);
        updateQidViewMargin(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLike(ProfileCardInfo profileCardInfo) {
        if (((VoteViewV2) this.mHeaderChildMap.get("map_key_like")) != null) {
            this.mVoteView.d(1);
        }
        super.updateLike(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateUinInfo(final ProfileCardInfo profileCardInfo, String str) {
        super.updateUinInfo(profileCardInfo, str);
        TextView textView = (TextView) this.mHeaderChildMap.get("map_key_uin_info");
        if (textView == null || profileCardInfo == null || profileCardInfo.allInOne == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(ProfileCardMoreConstants.KEY_ALL_IN_ONE, profileCardInfo.allInOne);
                ProfileCardMoreFragment.openProfileCardMore(ZplanProfileHeadViewOld.this.mActivity, intent, 1038);
                ProfileCardDtReportUtil.dtReportClick(view);
            }
        });
        LongClickCopyAction.attachCopyAction(textView, getResources().getString(R.string.f203284zs), profileCardInfo.allInOne.uin);
    }

    private String getNickText(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            String str = card.strNick;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne != null && ProfilePAUtils.isPaTypeShowAccount(allInOne)) {
                return String.valueOf(profileCardInfo.allInOne.uin);
            }
            return " ";
        }
        return "";
    }

    private TroopMemberInfo getTroopMember(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null || profileCardInfo.card == null) {
            return null;
        }
        return ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(profileCardInfo.troopUin, profileCardInfo.card.uin, this.mActivity, AbsQCircleProfileHeaderView.TAG);
    }

    private void adaptTwoLineNick(int i3, String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((RelativeLayout) findViewById(R.id.f102635yf)).getLayoutParams();
        layoutParams.addRule(1, 0);
        layoutParams.addRule(3, R.id.f166411zr4);
        View findViewById = findViewById(R.id.gru);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams2.topMargin = ViewUtils.dip2px(21.0f);
        findViewById.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) findViewById(R.id.gmy).getLayoutParams();
        layoutParams3.topMargin = ViewUtils.dip2px(8.0f);
        layoutParams3.bottomMargin = 0;
        ((RelativeLayout.LayoutParams) ((TroopMemberNewLevelView) findViewById(R.id.f102615yd)).getLayoutParams()).leftMargin = str.substring(i3).length() != 0 ? ViewUtils.dip2px(8.0f) : 0;
    }

    private void initNickTroopView(ProfileCardInfo profileCardInfo) {
        TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) findViewById(R.id.f102615yd);
        if (troopMemberNewLevelView == null || !profileCardInfo.isTroopMemberCard) {
            return;
        }
        updateTroopMemberNewLevelView(this.mApp, profileCardInfo, troopMemberNewLevelView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) troopMemberNewLevelView.getLayoutParams();
        layoutParams.addRule(15, 1);
        layoutParams.leftMargin = ViewUtils.dip2px(8.0f);
    }

    private void updateNickView(ProfileCardInfo profileCardInfo) {
        TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) findViewById(R.id.f102615yd);
        int nickViewMaxWidth = getNickViewMaxWidth();
        int b16 = profileCardInfo.isTroopMemberCard ? ((int) troopMemberNewLevelView.b()) + ViewUtils.dip2px(8.0f) : 0;
        String charSequence = this.mNickView.getText().toString();
        if (this.mNickView.getPaint().measureText(charSequence) + b16 > nickViewMaxWidth) {
            this.mNickView.setEllipsize(null);
            int firstNickViewTextNum = getFirstNickViewTextNum(nickViewMaxWidth);
            this.mNickView.setText(charSequence.substring(0, firstNickViewTextNum));
            this.mNickView.setWidth(nickViewMaxWidth);
            this.mNickViewExt.setVisibility(0);
            this.mNickViewExt.setText(charSequence.substring(firstNickViewTextNum));
            this.mNickViewExt.setMaxWidth(nickViewMaxWidth - b16);
            adaptTwoLineNick(firstNickViewTextNum, charSequence);
        } else {
            this.mNickView.setMaxWidth(nickViewMaxWidth - b16);
            this.mNickViewExt.setVisibility(8);
            this.mNickViewExt.setWidth(0);
        }
        setNickLongClickAction(charSequence);
    }

    boolean isTwoLineNick(ProfileCardInfo profileCardInfo) {
        TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) findViewById(R.id.f102615yd);
        int nickViewMaxWidth = getNickViewMaxWidth();
        return this.mNickView.getPaint().measureText(this.mNickView.getText().toString()) + ((float) (profileCardInfo.isTroopMemberCard ? ((int) troopMemberNewLevelView.b()) + ViewUtils.dip2px(8.0f) : 0)) > ((float) nickViewMaxWidth);
    }

    private void updateTroopMemberNewLevelView(final QQAppInterface qQAppInterface, final ProfileCardInfo profileCardInfo, TroopMemberNewLevelView troopMemberNewLevelView) {
        if (qQAppInterface == null || profileCardInfo == null || troopMemberNewLevelView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "call updateTroopMemberNewLevelView troopUin : " + profileCardInfo.troopUin);
        }
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo B = troopManager != null ? troopManager.B(profileCardInfo.troopUin) : null;
        if (B == null) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsProfileHeaderView.TAG, 2, "updateTroopMemberNewLevelView troopInfo is null. troopUin : " + profileCardInfo.troopUin);
                return;
            }
            return;
        }
        int i3 = profileCardInfo.troopMemberCard.realLevel;
        ITroopMemberLevelUtilsApi iTroopMemberLevelUtilsApi = (ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class);
        String str = profileCardInfo.allInOne.uin;
        TroopMemberCard troopMemberCard = profileCardInfo.troopMemberCard;
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = iTroopMemberLevelUtilsApi.getTroopMemberRankItem(B, str, i3, troopMemberCard.titleId, troopMemberCard.mUniqueTitle, troopMemberCard.honorRichTag);
        if (troopMemberRankItem != null) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsProfileHeaderView.TAG, 2, "troopMemberRankItem :" + troopMemberRankItem.toString());
            }
            troopMemberNewLevelView.setTroopMemberNewLevel(troopMemberRankItem);
            troopMemberNewLevelView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i16;
                    String str2 = "https://qun.qq.com/interactive/userhonor?gc=" + profileCardInfo.troopUin + "&uin=" + profileCardInfo.allInOne.uin + "&_wv=3&&_wwv=128";
                    Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str2);
                    view.getContext().startActivity(intent);
                    TroopMemberNewLevelView troopMemberNewLevelView2 = view instanceof TroopMemberNewLevelView ? (TroopMemberNewLevelView) view : null;
                    if (troopMemberNewLevelView2 != null) {
                        if (troopMemberNewLevelView2.c() && troopMemberNewLevelView2.d()) {
                            i16 = 3;
                        } else if (troopMemberNewLevelView2.c()) {
                            i16 = 1;
                        } else if (troopMemberNewLevelView2.d()) {
                            i16 = 2;
                        }
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B201", "0X800B201", i16, 0, "", "", "", "");
                    }
                    i16 = 0;
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B201", "0X800B201", i16, 0, "", "", "", "");
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "updateTroopMemberNewLevelView failed - troopUin : " + profileCardInfo.troopUin);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void updateLayoutMargin(int i3) {
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateNickInfo(String str) {
    }
}

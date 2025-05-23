package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.j;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.c;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.utils.HalfTransPressedListener;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantFileUtil;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* loaded from: classes16.dex */
public abstract class ProfileBaseView extends AbsProfileHeaderView implements IProfileBaseView {
    static IPatchRedirector $redirector_;
    protected AvatarLayout mAvatar;
    protected ImageView mAvatarPendant;
    private boolean mClipChild;
    private Paint mClipPaint;
    private RectF mClipRect;
    private int mClipTop;
    protected View mContentBgView;
    protected View mContentView;
    protected RandomCoverView mCoverView;
    protected boolean mCurrentNightMode;
    protected View mFakeView;
    private ViewGroup mHeadContainer;
    private boolean mIsFromArkBabyQ;
    protected PullToZoomHeaderListView mListView;
    protected View mNameLayout;
    protected ProfileNameView mNameView;
    protected TextView mRemarkName;
    protected TextView mUinInfoView;
    protected LinearLayout mUinLayout;
    protected HeartLayout mVoteHeartLayout;
    protected VoteViewV2 mVoteView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.base.view.ProfileBaseView$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ProfileCardInfo val$cardInfo;
        final /* synthetic */ boolean val$isInit;

        AnonymousClass1(ProfileCardInfo profileCardInfo, boolean z16) {
            this.val$cardInfo = profileCardInfo;
            this.val$isInit = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileBaseView.this, profileCardInfo, Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((IQQVasInfoApi) QRoute.api(IQQVasInfoApi.class)).getVasInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.val$cardInfo.allInOne.uin), AbsProfileHeaderView.TAG, new hx3.b<kx3.a>() { // from class: com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // hx3.b
                    public void onQueryResult(@Nullable e<kx3.a> eVar) {
                        kx3.a aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                            return;
                        }
                        if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                            aVar = eVar.b().get(0);
                        } else {
                            aVar = null;
                        }
                        ThreadManager.getUIHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.profilecard.base.view.ProfileBaseView.1.1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ kx3.a val$finalInfo;

                            {
                                this.val$finalInfo = aVar;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) C82551.this, (Object) aVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (this.val$finalInfo == null) {
                                    ProfileBaseView.this.mAvatarPendant.setVisibility(4);
                                    ProfileBaseView.this.mPendantId = 0L;
                                    return;
                                }
                                ProfileBaseView.this.mAvatarPendant.setVisibility(0);
                                ProfileBaseView.this.mPendantId = this.val$finalInfo.getPendantId();
                                com.tencent.mobileqq.vas.b bVar = (com.tencent.mobileqq.vas.b) ProfileBaseView.this.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
                                if (bVar != null) {
                                    IPendantInfo pendantInfo = bVar.getPendantInfo(ProfileBaseView.this.mPendantId);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    pendantInfo.setDrawable(ProfileBaseView.this.mAvatarPendant, 2, PendantConstant.PENDANT_TARGET_ID_PROFILE, anonymousClass1.val$cardInfo.allInOne.uin, this.val$finalInfo.getPendantDiyId());
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                if (anonymousClass12.val$isInit) {
                                    ReportController.o(ProfileBaseView.this.mApp, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
                                }
                            }
                        });
                        if (AnonymousClass1.this.val$isInit && aVar != null && AvatarPendantFileUtil.isDiyPendant(aVar.getPendantId())) {
                            ProfileBaseView profileBaseView = ProfileBaseView.this;
                            profileBaseView.mApp.addObserver(profileBaseView.mDiyPendantObserver);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AvatarPendantUtil.e(ProfileBaseView.this.mApp, anonymousClass1.val$cardInfo.allInOne.uin);
                        }
                    }
                });
            }
        }
    }

    public ProfileBaseView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) profileCardInfo);
            return;
        }
        this.mClipChild = true;
        this.mCurrentNightMode = false;
        this.mNewVoteAnimHelper = new j(qBaseActivity, this.mApp, 3, 1);
    }

    private void initHeadUI() {
        String string;
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "initHeadUI");
        }
        this.mCurrentNightMode = QQTheme.isNowThemeIsNight();
        Context context = getContext();
        this.mHeadContainer = (ViewGroup) this.mContentView.findViewById(R.id.dk9);
        AvatarLayout avatarLayout = (AvatarLayout) this.mContentView.findViewById(R.id.f165801dk3);
        this.mAvatar = avatarLayout;
        avatarLayout.setVisibility(0);
        com.tencent.mobileqq.profile.b bVar = new com.tencent.mobileqq.profile.b(1, null);
        if (this.mCardInfo.allInOne.f260789pa == 0) {
            string = context.getString(R.string.abp);
        } else {
            string = context.getString(R.string.abo);
        }
        this.mAvatar.setTag(bVar);
        this.mAvatar.setOnClickListener(this.mOnClickListener);
        this.mAvatar.setContentDescription(string);
        AvatarLayout avatarLayout2 = this.mAvatar;
        avatarLayout2.d(0, avatarLayout2.findViewById(R.id.a6e), false);
        this.mAvatar.findViewById(R.id.a6e).setTransitionName("avatar");
        this.mHeaderChildMap.put("map_key_face", this.mAvatar);
        this.mHeaderChildMap.put("map_key_face_stoke", this.mContentView.findViewById(R.id.dk7));
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.dfv);
        this.mAvatarPendant = imageView;
        this.mHeaderChildMap.put("map_key_avatar_pendant", imageView);
        this.mAvatarPendant.setVisibility(8);
        this.mAvatarPendant.setTag(bVar);
        this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
        this.mAvatarPendant.setContentDescription(string);
        AccessibilityUtil.n(this.mAvatarPendant, false);
        this.mNameLayout = this.mContentView.findViewById(R.id.gru);
        ProfileNameView profileNameView = (ProfileNameView) this.mContentView.findViewById(R.id.f9c);
        this.mNameView = profileNameView;
        this.mHeaderChildMap.put("map_key_profile_nick_name", profileNameView);
        this.mNameView.setVisibility(0);
        this.mNameView.setClickable(true);
        this.mNameView.setClickListener(this.mOnClickListener);
        TextView textView = (TextView) this.mContentView.findViewById(R.id.f72723rm);
        this.mRemarkName = textView;
        this.mHeaderChildMap.put("map_key_profile_remark_name", textView);
        VoteViewV2 voteViewV2 = (VoteViewV2) this.mContentView.findViewById(R.id.l0b);
        this.mVoteView = voteViewV2;
        voteViewV2.setOnTouchListener(new HalfTransPressedListener());
        this.mVoteHeartLayout = (HeartLayout) this.mContentView.findViewById(R.id.f165689d53);
        this.mHeaderChildMap.put("map_key_like", this.mVoteView);
        this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
        this.mVoteHeartLayout.setEnabled(false);
        this.mUinLayout = (LinearLayout) this.mContentView.findViewById(R.id.gmy);
        TextView textView2 = (TextView) this.mContentView.findViewById(R.id.gmx);
        this.mUinInfoView = textView2;
        this.mHeaderChildMap.put("map_key_uin_info", textView2);
        initCustomView();
        ProfileCardDtReportUtil.initElementWithExposureClick(this.mUinInfoView, ProfileCardDtReportUtil.DT_REPORT_NUMBER);
    }

    private void showVoteInner(ProfileCardInfo profileCardInfo, VoteViewV2 voteViewV2, boolean z16, int i3) {
        boolean z17;
        String format;
        com.tencent.mobileqq.profile.b bVar;
        int i16;
        boolean z18;
        String str;
        int i17 = 0;
        voteViewV2.setVisibility(0);
        if (profileCardInfo.card == null) {
            str = this.mActivity.getString(R.string.acw);
            bVar = null;
            z18 = false;
            i16 = 0;
        } else {
            if (this.mNewVoteAnimHelper == null) {
                this.mNewVoteAnimHelper = new j(this.mActivity, this.mApp, 1, 1);
            }
            Card card = profileCardInfo.card;
            int i18 = (int) card.lVoteCount;
            int i19 = card.iVoteIncrement;
            if (1 == card.bVoted) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.mNewVoteAnimHelper.M = card.getLastPraiseInfoList();
            if (i19 <= this.mNewVoteAnimHelper.M.size()) {
                j jVar = this.mNewVoteAnimHelper;
                jVar.M = jVar.M.subList(0, i19);
            }
            j jVar2 = this.mNewVoteAnimHelper;
            jVar2.M = c.b(jVar2.M);
            com.tencent.mobileqq.profile.b bVar2 = new com.tencent.mobileqq.profile.b(10, profileCardInfo.card);
            if (z16) {
                format = String.format(this.mActivity.getString(R.string.acu), String.valueOf(i18));
            } else {
                format = String.format(this.mActivity.getString(R.string.aap), String.valueOf(i18));
                if (profileCardInfo.card.bAvailVoteCnt == 0) {
                    voteViewV2.m();
                }
            }
            if (i19 > 0) {
                str = format.concat(String.format("\uff0c\u65b0\u589e%d\u8d5e", Integer.valueOf(i19)));
                bVar = bVar2;
                i16 = i18;
                i17 = i19;
                z18 = z17;
            } else {
                bVar = bVar2;
                i16 = i18;
                i17 = i19;
                z18 = z17;
                str = format;
            }
        }
        int i26 = i17 - i3;
        j jVar3 = this.mNewVoteAnimHelper;
        Card card2 = profileCardInfo.card;
        voteViewV2.r(z16, z18, i16, i26, jVar3, false, card2.likeAreaId, Boolean.valueOf(card2.isLuckyVip()), profileCardInfo.card.uin);
        voteViewV2.setTag(bVar);
        voteViewV2.setOnClickListener(this.mOnClickListener);
        voteViewV2.setContentDescription(str);
        AccessibilityUtil.d(voteViewV2, Button.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
            return;
        }
        if (!this.mClipChild) {
            if (this.mClipRect == null) {
                this.mClipRect = new RectF();
            }
            if (this.mClipPaint == null) {
                this.mClipPaint = new Paint();
            }
            this.mClipRect.set(getLeft(), this.mClipTop, getRight(), getBottom());
            canvas.save();
            canvas.clipRect(this.mClipRect);
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    protected abstract View initContentView();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCover(ProfileCardInfo profileCardInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo, i3);
            return;
        }
        this.mCoverView = (RandomCoverView) this.mContentView.findViewById(R.id.dkn);
        this.mContentBgView = this.mContentView.findViewById(R.id.f165798dk0);
        this.mHeaderChildMap.put("map_key_qzonecover", this.mCoverView);
        boolean z16 = false;
        this.mCoverView.setVisibility(0);
        RandomCoverView randomCoverView = this.mCoverView;
        QQAppInterface qQAppInterface = this.mApp;
        String str = profileCardInfo.allInOne.uin;
        String str2 = this.mCoverUrl;
        if (this.mCoverTimeStamp == 0) {
            z16 = true;
        }
        randomCoverView.e(qQAppInterface, str, i3, str2, z16);
        this.mListView.setHeaderImage(this.mCoverView.d());
        this.mListView.setHeaderMask(this.mCoverView.b());
        this.mListView.setProfileBaseView(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (r0 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int initCoverMode(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).intValue();
        }
        int i3 = 1;
        if (!ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
            Card card = profileCardInfo.card;
            if (card != null) {
                Object[] coverData = card.getCoverData(this.mCoverTimeStamp);
                if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isForbidByAnyType(profileCardInfo)) {
                    coverData = new Object[]{null, 0};
                }
                String str = (String) coverData[0];
                if (!TextUtils.isEmpty(str)) {
                    this.mCoverUrl = str;
                    this.mCoverTimeStamp = ((Integer) coverData[1]).intValue();
                }
                if (!TextUtils.isEmpty(this.mCoverUrl) && !profileCardInfo.card.isNoCover()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            i3 = 0;
        }
        if (profileCardInfo.card != null && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isVasCustomBg(profileCardInfo, this.mApp)) {
            return 4;
        }
        return i3;
    }

    protected abstract void initCustomView();

    protected abstract int initHeadViewResource();

    public boolean isInNoCoverMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        RandomCoverView randomCoverView = this.mCoverView;
        if (randomCoverView == null || randomCoverView.c() == 1) {
            return true;
        }
        return false;
    }

    protected void loadHeadLayout(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "loadHeadLayout mode=" + i3);
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        int initHeadViewResource = initHeadViewResource();
        IProfileViewLoader iProfileViewLoader = this.mViewLoader;
        if (iProfileViewLoader != null) {
            view = iProfileViewLoader.getViewById(initHeadViewResource);
        } else {
            view = null;
        }
        if (view == null) {
            view = from.inflate(initHeadViewResource, this.mHeadContainer, false);
        }
        if (view != null) {
            this.mHeadContainer.removeAllViews();
            this.mHeadContainer.addView(view);
        }
    }

    public abstract void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) profileCardInfo);
            return;
        }
        View initContentView = initContentView();
        this.mContentView = initContentView;
        this.mHeadContainer = (ViewGroup) initContentView.findViewById(R.id.dk9);
        this.mCurrentNightMode = QQTheme.isNowThemeIsNight();
        int initCoverMode = initCoverMode(profileCardInfo);
        initCover(profileCardInfo, initCoverMode);
        loadHeadLayout(initCoverMode);
        initHeadUI();
        updateAvatar(profileCardInfo.allInOne);
        updateAvatarPendantImage(profileCardInfo, true);
        updateDetail(profileCardInfo);
        updateLike(profileCardInfo);
        updateUinInfo(profileCardInfo, this.mApp.getCurrentAccountUin());
        updateQidInfo(profileCardInfo);
        updateOnlineStatusLayout(profileCardInfo);
        updateVipMedal(profileCardInfo);
        updateHead(profileCardInfo);
        super.onInit(profileCardInfo);
        onCoverModeChange(initCoverMode, profileCardInfo);
        adaptNightTheme(this.mCurrentNightMode);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        View view = this.mContentBgView;
        if (view != null) {
            this.mContentBgView.layout(view.getLeft(), this.mContentBgView.getTop(), this.mContentBgView.getRight(), i18);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null) {
            updateAvatarPendantImage(profileCardInfo, false);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, profileCardInfo, Boolean.valueOf(z16));
            return;
        }
        updateCover(profileCardInfo);
        updateAvatarPendantImage(profileCardInfo, false);
        boolean g16 = com.tencent.relation.common.config.toggle.c.R.g(false);
        if (g16 && (!g16 || !z16)) {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "isIntercept = " + g16 + " isNetRet = " + z16 + " isUpdateAvatar = " + z17);
        }
        if (z17) {
            updateAvatar(profileCardInfo.allInOne);
        }
        updateHead(profileCardInfo);
        updateDetail(profileCardInfo);
        updateLike(profileCardInfo);
        updateUinInfo(profileCardInfo, this.mApp.getCurrentAccountUin());
        updateQidInfo(profileCardInfo);
        updateVipMedal(profileCardInfo);
        updateOnlineStatusLayout(profileCardInfo);
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        this.mCurrentNightMode = isNowThemeIsNight;
        adaptNightTheme(isNowThemeIsNight);
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mClipChild = z16;
            super.setClipChildren(z16);
        }
    }

    public void setProfileArgs(PullToZoomHeaderListView pullToZoomHeaderListView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, pullToZoomHeaderListView, Boolean.valueOf(z16));
        } else {
            this.mListView = pullToZoomHeaderListView;
            this.mIsFromArkBabyQ = z16;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateAvatarPendantImage(ProfileCardInfo profileCardInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, profileCardInfo, Boolean.valueOf(z16));
            return;
        }
        if (ProAvatarComponentUtils.m() || this.mAvatarPendant == null) {
            return;
        }
        if (!ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
            this.mAvatarPendant.setVisibility(4);
            this.mPendantId = 0L;
        } else {
            ThreadManagerV2.post(new AnonymousClass1(profileCardInfo, z16), 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.IProfileBaseView
    public void updateClipTop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mClipTop = i3;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCover(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) profileCardInfo);
            return;
        }
        RandomCoverView randomCoverView = this.mCoverView;
        if (randomCoverView == null) {
            return;
        }
        int c16 = randomCoverView.c();
        Card card = profileCardInfo.card;
        if (card != null) {
            Object[] coverData = card.getCoverData(this.mCoverTimeStamp);
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isForbidByAnyType(profileCardInfo)) {
                coverData = new Object[]{null, 0};
                this.mCoverUrl = "";
            }
            String str = (String) coverData[0];
            if (!TextUtils.isEmpty(str) && !str.equals(this.mCoverUrl)) {
                this.mCoverUrl = str;
                int intValue = ((Integer) coverData[1]).intValue();
                this.mCoverTimeStamp = intValue;
                RandomCoverView randomCoverView2 = this.mCoverView;
                if (intValue == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                randomCoverView2.g(str, z16);
            }
            this.mCoverView.setCoverMaskColor();
            if (!TextUtils.isEmpty(this.mCoverUrl) && !profileCardInfo.card.isNoCover()) {
                c16 = 0;
            } else {
                c16 = 1;
            }
            if (((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isVasCustomBg(profileCardInfo, this.mApp)) {
                c16 = 4;
            }
        }
        if (this.mCoverView.c() != c16 || this.mCurrentNightMode != QQTheme.isNowThemeIsNight()) {
            this.mCoverView.a(c16);
            onCoverModeChange(c16, profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateHead(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) profileCardInfo);
            return;
        }
        ProfileNameView profileNameView = this.mNameView;
        if (profileNameView != null) {
            profileNameView.k(this.mApp, profileCardInfo);
        }
        RandomCoverView randomCoverView = this.mCoverView;
        if (randomCoverView != null) {
            updateLayoutMargin(randomCoverView.c());
        }
    }

    public abstract void updateLayoutMargin(int i3);

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLike(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) profileCardInfo);
            return;
        }
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (profileCardInfo.isTroopMemberCard && troopManager != null && troopManager.V(profileCardInfo.troopUin)) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            boolean isShowZan = isShowZan(profileCardInfo);
            if (this.mIsFromArkBabyQ) {
                isShowZan = false;
            }
            boolean equals = TextUtils.equals(profileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
            if (isShowZan) {
                showVoteInner(profileCardInfo, voteViewV2, equals, 0);
            } else {
                voteViewV2.setVisibility(4);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLiked(ProfileCardInfo profileCardInfo, long j3, boolean z16) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, profileCardInfo, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            if (j3 == -1) {
                j16 = voteViewV2.f316533e;
            } else {
                j16 = j3;
            }
            Card card = profileCardInfo.card;
            if (card == null) {
                return;
            }
            if (card.bAvailVoteCnt == 0) {
                voteViewV2.m();
            }
            Card card2 = profileCardInfo.card;
            voteViewV2.r(false, true, (int) j16, 0, null, z16, card2.likeAreaId, Boolean.valueOf(card2.isLuckyVip()), profileCardInfo.card.uin);
            voteViewV2.setContentDescription(String.format(this.mActivity.getString(R.string.f170791ab1), String.valueOf(j16)));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateSexAgeArea(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) profileCardInfo);
        }
    }

    private void adaptNightTheme(boolean z16) {
    }
}

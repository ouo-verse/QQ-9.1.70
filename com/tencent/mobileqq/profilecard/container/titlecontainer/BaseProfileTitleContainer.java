package com.tencent.mobileqq.profilecard.container.titlecontainer;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.intimate.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.HalfTransPressedListener;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.ITroopMemberCardApi;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.AnimateUtils;
import com.tencent.util.TokenResUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.PerfTracer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public abstract class BaseProfileTitleContainer extends AbsQQProfileContainer implements View.OnClickListener, AbsListView.OnScrollListener, IZPlanChangeTitleStatusListener {
    private static final int MSG_UPDATE_RIGHT_MORE_RED_TOUCH = 100;
    private static final String TAG = "BaseProfileTitleContainer";
    public static final int TITLE_MODE_DEFAULT = 0;
    public static final int TITLE_MODE_NOCOVER = 2;
    public static final int TITLE_MODE_TRANS = 1;
    private StateListDrawable mBackDrawable;
    protected String mCallback4TroopFee;
    public TextView mCenterTextView;
    private com.tencent.mobileqq.phonecontact.observer.b mContactObserver;
    private int mContentScrollOffset;
    private Rect mContentVisibleRect;
    private int mCurTitleMode;
    private AlphaAnimation mFadeInAnimation;
    private int mFadeInOutLine;
    private AlphaAnimation mFadeOutAnimation;
    protected boolean mHasReportSettingExpose;
    private QQProgressDialog mHideContactSettingDialog;
    public boolean mIsFromArkBabyQ;
    public boolean mIsShowQCircle;
    public boolean mIsShowZPlan;
    public boolean mIsShowZplanSetting;
    public ImageView mLeftBackView;
    public RelativeLayout mLeftBackViewBg;
    private PullToZoomHeaderListView mListView;
    private LinearLayout mProfileCardTitleBar;
    public RelativeLayout mRightImageBg;
    public ImageView mRightImageView;
    public RelativeLayout mRightMsgImageBg;
    public ImageView mRightMsgImageView;
    public RelativeLayout mRightSettingImageBg;
    public ImageView mRightSettingImageView;
    public TextView mRightTextView;
    public RedTouch mRightViewRedTouch;
    public RelativeLayout mTitleBg;
    private Animation.AnimationListener mTitleFadeAnimListener;
    public int mTroopFromFlag;
    protected Intent mTroopOperationIntent;
    private Handler.Callback mUICallback;
    private WeakReferenceHandler mUIHandler;
    public long mUin;

    /* loaded from: classes35.dex */
    public static class TitleRightStatus {
        int imageTagType;
        boolean showImageView;
        boolean showTextView;
        int textResId;
        int textTagType;
    }

    public BaseProfileTitleContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mIsShowZPlan = false;
        this.mIsShowQCircle = false;
        this.mIsShowZplanSetting = false;
        this.mUin = 0L;
        this.mCurTitleMode = 0;
        this.mTitleFadeAnimListener = new AnimateUtils.AnimationAdapter() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.1
            @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseProfileTitleContainer baseProfileTitleContainer = BaseProfileTitleContainer.this;
                if (baseProfileTitleContainer.mCenterTextView != null) {
                    if (animation == baseProfileTitleContainer.mFadeOutAnimation) {
                        BaseProfileTitleContainer.this.updateTitleMode(1);
                    }
                    BaseProfileTitleContainer.this.mCenterTextView.clearAnimation();
                }
                RelativeLayout relativeLayout = BaseProfileTitleContainer.this.mTitleBg;
                if (relativeLayout != null) {
                    relativeLayout.clearAnimation();
                }
            }

            @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BaseProfileTitleContainer baseProfileTitleContainer = BaseProfileTitleContainer.this;
                if (baseProfileTitleContainer.mCenterTextView == null || animation != baseProfileTitleContainer.mFadeInAnimation) {
                    return;
                }
                BaseProfileTitleContainer.this.updateTitleMode(0);
            }
        };
        this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return false;
                }
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo) message.obj;
                int i3 = FontSettingManager.getFontLevel() < 20.0f ? 5 : 1;
                BaseProfileTitleContainer baseProfileTitleContainer = BaseProfileTitleContainer.this;
                if (baseProfileTitleContainer.mRightViewRedTouch == null) {
                    if (baseProfileTitleContainer.mRightMsgImageBg.getVisibility() == 0) {
                        BaseProfileTitleContainer baseProfileTitleContainer2 = BaseProfileTitleContainer.this;
                        View expandRedTouchTargetView = baseProfileTitleContainer2.expandRedTouchTargetView(baseProfileTitleContainer2.mRightMsgImageBg, i3, 0, i3, 0);
                        if (expandRedTouchTargetView != null) {
                            BaseProfileTitleContainer.this.mRightViewRedTouch = new RedTouch(((AbsComponent) BaseProfileTitleContainer.this).mActivity, expandRedTouchTargetView).setGravity(53).setTopMargin(3.0f).applyTo();
                        }
                    } else {
                        BaseProfileTitleContainer baseProfileTitleContainer3 = BaseProfileTitleContainer.this;
                        View expandRedTouchTargetView2 = baseProfileTitleContainer3.expandRedTouchTargetView(baseProfileTitleContainer3.mRightTextView, i3, 0, i3, 0);
                        if (expandRedTouchTargetView2 != null) {
                            BaseProfileTitleContainer.this.mRightViewRedTouch = new RedTouch(((AbsComponent) BaseProfileTitleContainer.this).mActivity, expandRedTouchTargetView2).setGravity(53).setTopMargin(3.0f).applyTo();
                        }
                    }
                }
                RedTouch redTouch = BaseProfileTitleContainer.this.mRightViewRedTouch;
                if (redTouch == null) {
                    return false;
                }
                redTouch.parseRedTouch(redTypeInfo);
                return false;
            }
        };
        this.mTroopFromFlag = -1;
        this.mTroopOperationIntent = new Intent();
        this.mCallback4TroopFee = "";
        this.mContactObserver = new com.tencent.mobileqq.phonecontact.observer.b() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.3
            @Override // com.tencent.mobileqq.phonecontact.observer.b
            protected void onHideContact(boolean z16) {
                BaseProfileTitleContainer.this.dismissHideContactDialog();
                if (z16) {
                    return;
                }
                QQToast.makeText(((AbsComponent) BaseProfileTitleContainer.this).mActivity, 1, HardCodeUtil.qqStr(R.string.mtf), 1000).show();
            }
        };
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            this.mUin = waitAppRuntime.getLongAccountUin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissHideContactDialog() {
        try {
            QQProgressDialog qQProgressDialog = this.mHideContactSettingDialog;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.mHideContactSettingDialog.dismiss();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dismissHideContactDialog fail.", e16);
        }
        this.mHideContactSettingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View expandRedTouchTargetView(View view, int i3, int i16, int i17, int i18) {
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            return null;
        }
        Resources resources = qBaseActivity.getResources();
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float f16 = i3;
        float f17 = i17;
        layoutParams.width += BaseAIOUtils.f(f16, resources) + BaseAIOUtils.f(f17, resources);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(BaseAIOUtils.f(f16, resources), BaseAIOUtils.f(i16, resources), BaseAIOUtils.f(f17, resources), BaseAIOUtils.f(i18, resources));
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int indexOfChild = viewGroup.indexOfChild(view);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        viewGroup.removeView(view);
        frameLayout.addView(view, layoutParams2);
        viewGroup.addView(frameLayout, indexOfChild);
        return frameLayout;
    }

    private Drawable getBackDrawable() {
        if (this.mBackDrawable == null) {
            try {
                Resources resources = this.mActivity.getResources();
                Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.skin_header_btn_back_normal);
                Bitmap decodeResource2 = BitmapFactory.decodeResource(resources, R.drawable.skin_header_btn_back_press);
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(resources, decodeResource, decodeResource.getNinePatchChunk(), new Rect(), null);
                NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(resources, decodeResource2, decodeResource2.getNinePatchChunk(), new Rect(), null);
                StateListDrawable stateListDrawable = new StateListDrawable();
                this.mBackDrawable = stateListDrawable;
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, ninePatchDrawable2);
                this.mBackDrawable.addState(new int[0], ninePatchDrawable);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getBackDrawable fail.", e16);
            }
        }
        return this.mBackDrawable;
    }

    private String getContactStrangerUin(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        PhoneContact queryContactByCodeNumber;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null || (queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(profileCardInfo.allInOne))) == null) {
            return null;
        }
        return queryContactByCodeNumber.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getDIYTemplateTitleBarColorResource() {
        VasDiyData vasDiyData = (VasDiyData) ((ProfileCardInfo) this.mData).getBusinessInfo(VasDiyData.class);
        return (vasDiyData == null || vasDiyData.getTitleStyle() != 0) ? R.color.f157887a54 : R.color.a8u;
    }

    private void initTitleRightPressedState() {
        RelativeLayout relativeLayout = this.mRightMsgImageBg;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(new HalfTransPressedListener());
        }
        RelativeLayout relativeLayout2 = this.mRightSettingImageBg;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnTouchListener(new HalfTransPressedListener());
        }
    }

    private boolean isTitleRightQRCode() {
        RelativeLayout relativeLayout = this.mRightImageBg;
        if (relativeLayout == null) {
            return false;
        }
        Object tag = relativeLayout.getTag();
        return (tag instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) tag).f260135a == 65;
    }

    private boolean isTitleRightSetting() {
        RelativeLayout relativeLayout = this.mRightImageBg;
        if (relativeLayout == null) {
            return false;
        }
        Object tag = relativeLayout.getTag();
        return (tag instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) tag).f260135a == 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isVasProfileCard() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).card == null || ProfileTemplateApi.isVasCustomBgTemplateStyleID(((ProfileCardInfo) data).card.lCurrentStyleId)) {
            return false;
        }
        DATA data2 = this.mData;
        return ((ProfileCardInfo) data2).currentTemplate != null || ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo) data2).card.lCurrentStyleId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$openTroopMore$1(final View view) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "[openTroopMore] app is null");
            return;
        }
        final TroopInfo k3 = ((TroopManager) peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        if (k3 == null) {
            QLog.e(TAG, 1, "[openTroopMore] troopInfo is null");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseProfileTitleContainer.this.lambda$openTroopMore$0(view, k3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$openTroopMoreInner$3(final Intent intent, final View view) {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        final FriendsManager friendsManager = (FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
        final boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG);
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileTitleContainer.this.lambda$openTroopMoreInner$2(intent, view, friendsManager, isFriend, friendsSimpleInfoWithUid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: openTroopMoreInner, reason: merged with bridge method [inline-methods] */
    public void lambda$openTroopMore$0(final View view, TroopInfo troopInfo) {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).card == null) {
            return;
        }
        ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).checkAndUpdateTroopInfo(troopInfo, ((ProfileCardInfo) this.mData).allInOne);
        final Intent intent = new Intent();
        intent.putExtra("troopUin", ((ProfileCardInfo) this.mData).troopUin);
        intent.putExtra("memberUin", ((ProfileCardInfo) this.mData).card.uin);
        intent.putExtra("fromFlag", this.mTroopFromFlag);
        intent.putExtra("troopMemberCard", ((ProfileCardInfo) this.mData).troopMemberCard);
        intent.putExtra(IProfileProtocolConst.PARAM_TROOP_CODE, troopInfo.troopcode);
        intent.putExtra("troopName", troopInfo.getTroopDisplayName());
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            QLog.e(TAG, 1, "[openTroopMoreInner] mApp is null");
            return;
        }
        IBizTroopMemberInfoService iBizTroopMemberInfoService = (IBizTroopMemberInfoService) appInterface.getRuntimeService(IBizTroopMemberInfoService.class, "");
        DATA data2 = this.mData;
        intent.putExtra("hwCard", iBizTroopMemberInfoService.getHWTroopMemberCard(((ProfileCardInfo) data2).troopUin, ((ProfileCardInfo) data2).card.uin));
        intent.putExtra("qidian_private_troop", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).isQiDianPrivateTroop(((ProfileCardInfo) this.mData).troopUin));
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, ((ProfileCardInfo) this.mData).allInOne);
        intent.putExtra("detailProfileUrl", ProfileCardUtil.t(this.mQQAppInterface, this.mActivity, (ProfileCardInfo) this.mData));
        intent.putExtra("qidianshowUin", QidianManager.w(this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne.uin));
        intent.putExtra("hasGatherFriend", ac.n0(this.mApp));
        if (TextUtils.isEmpty(((ProfileCardInfo) this.mData).allInOne.nickname)) {
            DATA data3 = this.mData;
            ((ProfileCardInfo) data3).allInOne.nickname = ac.f(this.mQQAppInterface, ((ProfileCardInfo) data3).allInOne.uin);
        }
        intent.putExtra("isQidianMaster", ((QidianManager) this.mApp.getManager(QQManagerFactory.QIDIAN_MANAGER)).R(((ProfileCardInfo) this.mData).allInOne.uin));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileTitleContainer.this.lambda$openTroopMoreInner$3(intent, view);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: openTroopMoreInnerFinal, reason: merged with bridge method [inline-methods] */
    public void lambda$openTroopMoreInner$2(final Intent intent, View view, FriendsManager friendsManager, boolean z16, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        String str;
        int i3;
        Map<String, String> buddyRemark;
        if (this.mApp == null) {
            return;
        }
        intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, z16);
        if (!z16) {
            ArrayList<String> arrayList = new ArrayList<>();
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).card.uin);
            if (!TextUtils.isEmpty(uidFromUin)) {
                arrayList.add(uidFromUin);
            } else {
                QLog.e(TAG, 1, "openTroopMoreInnerFinal, uid is empty, " + ((ProfileCardInfo) this.mData).card.uin);
            }
            m b16 = f.b();
            if (b16 != null && !arrayList.isEmpty() && (buddyRemark = b16.getBuddyRemark(arrayList)) != null && buddyRemark.containsKey(uidFromUin)) {
                intent.putExtra("key_remark", buddyRemark.get(uidFromUin));
            }
        }
        if (dVar != null) {
            intent.putExtra("specialFlag", (int) dVar.e().byteValue());
            if (dVar.B()) {
                intent.putExtra("key_remark", dVar.r());
                intent.putExtra(MiniAppTranRoomIdServlet.KEY_GROUP_ID, dVar.f());
                intent.putExtra("key_current_nick", ac.y(this.mQQAppInterface, this.mApp.getCurrentAccountUin()));
                intent.putExtra("key_group_name", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).getGroupName(dVar.f()));
                intent.putExtra("key_not_disturb", FriendsStatusUtil.k(((ProfileCardInfo) this.mData).allInOne.uin, this.mQQAppInterface));
                intent.putExtra("key_is_shield", ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(dVar.getUid(), TAG));
                intent.putExtra("key_type_gather", dVar.n());
                intent.putExtra("key_is_has_interaction", com.tencent.mobileqq.mutualmark.c.l(this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne.uin, true));
                intent.putExtra("key_is_specialcare", ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin), TAG));
            }
        }
        intent.putExtra("businessCard", BusinessCardUtils.a(this.mQQAppInterface, (ProfileCardInfo) this.mData));
        DATA data = this.mData;
        boolean z17 = false;
        if (((ProfileCardInfo) data).profileName != null && ((ProfileCardInfo) data).profileName.f305806b.size() > 0) {
            intent.putExtra("SHARE_NICK_NAME", ((ProfileCardInfo) this.mData).profileName.f305806b.get(0).f305804b);
        }
        DATA data2 = this.mData;
        if (((ProfileCardInfo) data2).card != null && !TextUtils.isEmpty(((ProfileCardInfo) data2).card.addSrcName)) {
            intent.putExtra("cur_add_source", ((ProfileCardInfo) this.mData).card.addSrcName);
        }
        DATA data3 = this.mData;
        if (((ProfileCardInfo) data3).card != null) {
            intent.putExtra("key_nick_name", ((ProfileCardInfo) data3).card.strNick);
        }
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                intent.putExtra("title", charSequence);
            }
        }
        if (z16) {
            intent.putExtra("friend_intimate_open", FriendIntimateRelationshipHelper.m(this.mApp.getCurrentUin()));
            intent.putExtra("friend_intimate_bind_url", FriendIntimateRelationshipHelper.b(((ProfileCardInfo) this.mData).allInOne.uin));
            com.tencent.mobileqq.mutualmark.info.c e16 = com.tencent.mobileqq.mutualmark.c.e(this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne.uin, true);
            if (e16 != null) {
                str = e.b(this.mActivity, e16.f252085a);
                int i16 = e16.f252101q;
                z17 = e16.d();
                i3 = i16;
            } else {
                str = "";
                i3 = 0;
            }
            intent.putExtra("friend_intimate_bind_name", str);
            intent.putExtra("friend_intimate_isExtinguish", z17);
            intent.putExtra("friend_intimate_bind_res_icon", i3);
        }
        intent.putExtra("isMsgShielded", isMsgShielded(this.mQQAppInterface, (ProfileCardInfo) this.mData));
        intent.putExtra("isGather", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).isGatherFriend((ProfileCardInfo) this.mData));
        intent.putExtra("isForbidAccount", ProfileCardForbidAccountHelper.isForbidByAnyType((ProfileCardInfo) this.mData));
        String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin);
        QLog.i(TAG, 1, "[openTroopMoreInnerFinal] getFriendsDetailInfoWithUid");
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(uidFromUin2, TAG, new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c>() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.9
            @Override // hx3.b
            public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                QLog.i(BaseProfileTitleContainer.TAG, 1, "[openTroopMoreInnerFinal] getFriendsDetailInfoWithUid onQueryResult");
                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty() && ((AbsComponent) BaseProfileTitleContainer.this).mData != null && ((ProfileCardInfo) ((AbsComponent) BaseProfileTitleContainer.this).mData).allInOne.f260789pa != 1) {
                    intent.putExtra("isGather", eVar.b().get(0).n().byteValue() == 1);
                } else {
                    intent.putExtra("isGather", false);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((AbsComponent) BaseProfileTitleContainer.this).mActivity != null && !((AbsComponent) BaseProfileTitleContainer.this).mActivity.isFinishing() && ((AbsComponent) BaseProfileTitleContainer.this).mApp != null) {
                            intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
                            ((ITroopMemberSettingApi) QRoute.api(ITroopMemberSettingApi.class)).openMemberSetting(((AbsComponent) BaseProfileTitleContainer.this).mActivity, intent, 8);
                            return;
                        }
                        QLog.i(BaseProfileTitleContainer.TAG, 1, "openTroopMoreInnerFinal end. activity destroyed");
                    }
                });
            }
        });
    }

    private void showHideContactProgressDialog() {
        try {
            if (this.mActivity.isFinishing()) {
                return;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mActivity);
            this.mHideContactSettingDialog = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
            this.mHideContactSettingDialog.setMessage(R.string.d3y);
            this.mHideContactSettingDialog.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showHideContactProgressDialog fail.", e16);
        }
    }

    private void updateIconDrawable(ImageView imageView, int i3, int i16, boolean z16) {
        Resources resources;
        Drawable drawable;
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null || imageView == null || (resources = qBaseActivity.getResources()) == null) {
            return;
        }
        if (z16) {
            drawable = resources.getDrawable(i3);
        } else {
            drawable = resources.getDrawable(i16);
        }
        imageView.setImageDrawable(drawable);
    }

    private void updateTitleForTroop(boolean z16, TitleRightStatus titleRightStatus, boolean z17) {
        titleRightStatus.showTextView = z17;
        titleRightStatus.textTagType = z16 ? 98 : 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateTitleIconBg(boolean z16) {
        ImageView imageView = this.mLeftBackView;
        if (imageView != null) {
            updateIconDrawable(imageView, R.drawable.qui_chevron_left_icon_white_selector, R.drawable.qui_chevron_left_icon_navigation_02_selector, z16);
        }
        RelativeLayout relativeLayout = this.mLeftBackViewBg;
        int i3 = R.drawable.f161203k73;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(z16 ? R.drawable.f161203k73 : 0);
        }
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null || ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) data).allInOne)) {
            return;
        }
        if (this.mRightImageView != null) {
            if (isTitleRightSetting()) {
                updateIconDrawable(this.mRightImageView, R.drawable.qui_setting_icon_white_selector, R.drawable.qui_setting_icon_nav_secondary_selector, z16);
            } else if (isTitleRightQRCode()) {
                updateIconDrawable(this.mRightImageView, R.drawable.qui_qrcode_icon_white_selector, R.drawable.qui_qrcode_icon_nav_secondary_selector, z16);
            }
        }
        RelativeLayout relativeLayout2 = this.mRightImageBg;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(z16 ? R.drawable.f161203k73 : 0);
        }
        ImageView imageView2 = this.mRightMsgImageView;
        if (imageView2 != null) {
            updateIconDrawable(imageView2, R.drawable.qui_remind_white_selector, R.drawable.qui_remind_icon_nav_secondary_selector, z16);
        }
        RelativeLayout relativeLayout3 = this.mRightMsgImageBg;
        if (relativeLayout3 != null) {
            relativeLayout3.setBackgroundResource(z16 ? R.drawable.f161203k73 : 0);
        }
        ImageView imageView3 = this.mRightSettingImageView;
        if (imageView3 != null) {
            updateIconDrawable(imageView3, R.drawable.qui_setting_icon_white_selector, R.drawable.qui_setting_icon_nav_secondary_selector, z16);
        }
        RelativeLayout relativeLayout4 = this.mRightSettingImageBg;
        if (relativeLayout4 != null) {
            if (!z16) {
                i3 = 0;
            }
            relativeLayout4.setBackgroundResource(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateTitleMode() {
        if (this.mIsShowZPlan) {
            updateTitleMode(this.mCurTitleMode);
            return;
        }
        boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 33;
        boolean isInNoCoverMode = isInNoCoverMode();
        boolean z17 = this.mContentScrollOffset >= this.mFadeInOutLine;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateTitleMode contactStranger=%s isInNoCoverMode=%s titleHasFadeIn=%s", Boolean.valueOf(z16), Boolean.valueOf(isInNoCoverMode), Boolean.valueOf(z17)));
        }
        if (z16 || isInNoCoverMode) {
            updateTitleMode(2);
        } else if (z17) {
            updateTitleMode(0);
        } else {
            updateTitleMode(1);
        }
    }

    private void updateTitleRedTouch() {
        RelativeLayout relativeLayout = this.mRightMsgImageBg;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0 && (this.mRightMsgImageBg.getTag() instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) this.mRightMsgImageBg.getTag()).f260135a == 108) {
            this.mUIHandler.obtainMessage(100, ProfileCardUtil.z()).sendToTarget();
            return;
        }
        TextView textView = this.mRightTextView;
        if (textView == null || !(textView.getTag() instanceof com.tencent.mobileqq.profile.b)) {
            return;
        }
        int i3 = ((com.tencent.mobileqq.profile.b) this.mRightTextView.getTag()).f260135a;
        if (i3 == 98 || i3 == 99) {
            this.mUIHandler.obtainMessage(100, ProfileCardUtil.z()).sendToTarget();
        }
    }

    public void dtReport(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 106;
    }

    public abstract void initDtReport();

    /* JADX WARN: Multi-variable type inference failed */
    public void initViews() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((FrameLayout) view).removeAllViews();
            ty4.b.g(this.mActivity.getLayoutInflater(), R.layout.czl, "qq_profilecard_title_layout_impl", (ViewGroup) this.mViewContainer);
            this.mLeftBackView = (ImageView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovb);
            this.mLeftBackViewBg = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovc);
            this.mCenterTextView = (TextView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovk);
            this.mTitleBg = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.oxf);
            RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.oxh);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.setMargins(0, RFWImmersiveUtils.getStatusBarHeight(), 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
            this.mRightTextView = (TextView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovj);
            this.mRightImageView = (ImageView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovd);
            this.mRightImageBg = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.ove);
            this.mRightMsgImageView = (ImageView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovf);
            this.mRightMsgImageBg = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovg);
            this.mRightSettingImageView = (ImageView) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovh);
            this.mRightSettingImageBg = (RelativeLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.ovi);
            initTitleRightPressedState();
            LinearLayout linearLayout = (LinearLayout) ((FrameLayout) this.mViewContainer).findViewById(R.id.ow5);
            this.mProfileCardTitleBar = linearLayout;
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            layoutParams2.height = RFWImmersiveUtils.getStatusBarHeight() + BaseAIOUtils.f(44.0f, this.mActivity.getResources());
            this.mProfileCardTitleBar.setLayoutParams(layoutParams2);
            this.mProfileCardTitleBar.setClickable(true);
            this.mProfileCardTitleBar.setImportantForAccessibility(2);
            Resources resources = this.mActivity.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.mFadeInOutLine = (resources.getDimensionPixelSize(R.dimen.a0m) - resources.getDimensionPixelSize(R.dimen.title_bar_height)) - ((int) (displayMetrics.density * 66.0f));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.mFadeInAnimation = alphaAnimation;
            alphaAnimation.setDuration(300L);
            this.mFadeInAnimation.setInterpolator(this.mActivity, android.R.anim.accelerate_interpolator);
            this.mFadeInAnimation.setAnimationListener(this.mTitleFadeAnimListener);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.mFadeOutAnimation = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.mFadeOutAnimation.setInterpolator(this.mActivity, android.R.anim.accelerate_interpolator);
            this.mFadeOutAnimation.setAnimationListener(this.mTitleFadeAnimListener);
        }
    }

    public boolean isInNoCoverMode() {
        AbsProfileHeaderComponent absProfileHeaderComponent = (AbsProfileHeaderComponent) this.mComponentCenter.getComponent(1002);
        if (absProfileHeaderComponent != null) {
            AbsProfileHeaderView headerView = absProfileHeaderComponent.getHeaderView();
            if ((headerView instanceof ProfileBaseView) && ((ProfileBaseView) headerView).isInNoCoverMode()) {
                return true;
            }
        }
        return false;
    }

    boolean isMsgShielded(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        String contactStrangerUin;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin);
        int i3 = profileCardInfo.allInOne.f260789pa;
        if (i3 == 1) {
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(uidFromUin, TAG);
        }
        if (i3 != 86 && i3 != 41 && i3 != 42) {
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
                return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(uidFromUin, TAG);
            }
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) qQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if (shieldMsgManger == null) {
                return false;
            }
            if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
                contactStrangerUin = profileCardInfo.allInOne.uin;
            } else {
                contactStrangerUin = ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne) ? getContactStrangerUin(qQAppInterface, profileCardInfo) : null;
            }
            if (TextUtils.isEmpty(contactStrangerUin)) {
                return false;
            }
            return shieldMsgManger.h(contactStrangerUin);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
        return friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() == -1002;
    }

    public boolean isPaTypeStrangerShowTitleRight(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        return i3 == 72 || i3 == 71 || i3 == 70 || i3 == 21 || i3 == 58 || i3 == 22 || i3 == 46 || i3 == 47 || i3 == 41 || i3 == 42 || i3 == 86 || i3 == 56 || i3 == 57 || i3 == 2 || i3 == 74 || i3 == 96 || i3 == 95;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 8) {
            handleTroopMoreActivityResult(intent);
        } else if (i3 == 21) {
            handleRecommendContactActivityResult(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            int i3 = ((com.tencent.mobileqq.profile.b) view.getTag()).f260135a;
            if (i3 == 16) {
                if (((ProfileCardInfo) this.mData).isTroopMemberCard()) {
                    openTroopMore(view);
                    return;
                } else {
                    openProfileMore();
                    return;
                }
            }
            if (i3 == 44) {
                showContactActionSheet();
                return;
            }
            if (i3 == 65) {
                openQRCode();
                ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
                return;
            }
            if (i3 == 108) {
                dtReport(view);
                ProfileCardUtil.U(this.mActivity);
                return;
            }
            if (i3 != 98) {
                if (i3 != 99) {
                    return;
                }
                ProfileCardUtil.U(this.mActivity);
            } else if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                showMoreActionSheet();
                RedTouch redTouch = this.mRightViewRedTouch;
                ReportController.o(this.mApp, "dc00898", "", "", "0X800A97C", "0X800A97C", (redTouch == null || !redTouch.hasRedTouch()) ? 2 : 1, 0, "0", "0", "", "");
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        checkToSwitchTitle(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener
    public void onSetTitleStatus(boolean z16) {
        AlphaAnimation alphaAnimation;
        TextView textView = this.mCenterTextView;
        if (textView == null) {
            return;
        }
        int visibility = textView.getVisibility();
        if (z16 && visibility == 4) {
            alphaAnimation = this.mFadeInAnimation;
        } else {
            alphaAnimation = (z16 || visibility != 0) ? null : this.mFadeOutAnimation;
        }
        if (alphaAnimation != null) {
            this.mCenterTextView.startAnimation(alphaAnimation);
            this.mTitleBg.startAnimation(alphaAnimation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openProfileMore() {
        Intent intent = new Intent(this.mActivity, (Class<?>) ProfileCardMoreActivity.class);
        BusinessCard a16 = BusinessCardUtils.a(this.mQQAppInterface, (ProfileCardInfo) this.mData);
        DATA data = this.mData;
        Intent q06 = ProfileCardUtil.q0(intent, ((ProfileCardInfo) data).allInOne.uin, this.mQQAppInterface, ((ProfileCardInfo) data).allInOne, a16);
        DATA data2 = this.mData;
        if (((ProfileCardInfo) data2).profileName != null && ((ProfileCardInfo) data2).profileName.f305806b.size() > 0) {
            q06.putExtra("SHARE_NICK_NAME", ((ProfileCardInfo) this.mData).profileName.f305806b.get(0).f305804b);
        }
        DATA data3 = this.mData;
        if (((ProfileCardInfo) data3).card != null && !TextUtils.isEmpty(((ProfileCardInfo) data3).card.addSrcName)) {
            q06.putExtra("cur_add_source", ((ProfileCardInfo) this.mData).card.addSrcName);
        }
        DATA data4 = this.mData;
        if (((ProfileCardInfo) data4).card != null) {
            q06.putExtra("key_nick_name", ((ProfileCardInfo) data4).card.strNick);
            q06.putExtra("key_is_personal_card", isVasProfileCard());
        }
        q06.addFlags(536870912);
        this.mActivity.startActivityForResult(q06, 1012);
        ReportController.o(this.mApp, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
    }

    public void openQRCode() {
        String string = this.mActivity.getString(R.string.g2w);
        String currentAccountUin = this.mApp.getCurrentAccountUin();
        String f16 = ac.f(this.mQQAppInterface, currentAccountUin);
        Intent intent = new Intent(this.mActivity, (Class<?>) QRDisplayActivity.class);
        intent.putExtra("my_qrcode_pg_source", "3");
        intent.putExtra("title", string);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("nick", f16);
        intent.putExtra("type", 1);
        intent.putExtra("reportFlag", 1);
        com.tencent.biz.qrcode.util.f.c(intent, this.mActivity);
    }

    public void openTroopMore(final View view) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.8
            @Override // java.lang.Runnable
            public void run() {
                new q(((AbsQQProfileContainer) BaseProfileTitleContainer.this).mQQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("more_clk").b(((ProfileCardInfo) ((AbsComponent) BaseProfileTitleContainer.this).mData).troopUin).g();
            }
        }, 128, null, false);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseProfileTitleContainer.this.lambda$openTroopMore$1(view);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportForZplan(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_action_type", str);
        hashMap.put("zplan_qq_pageid", "0");
        VideoReport.reportEvent("ev_zplan_avatar_dropdown_setting", hashMap);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void setProfileActivityDelegate(IProfileActivityDelegate iProfileActivityDelegate) {
        super.setProfileActivityDelegate(iProfileActivityDelegate);
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null) {
            this.mListView = iProfileActivityDelegate2.getListView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setTroopOperationResult(int i3) {
        int i16 = this.mTroopFromFlag;
        if (i16 == 1 || i16 == 7) {
            this.mTroopOperationIntent.putExtra("memberOperationFlag", i3 | this.mTroopOperationIntent.getIntExtra("memberOperationFlag", 0));
            this.mTroopOperationIntent.putExtra("memberOperateUin", ((ProfileCardInfo) this.mData).allInOne.uin);
            this.mActivity.setResult(-1, this.mTroopOperationIntent);
        }
    }

    public void showMoreActionSheet() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mActivity, null);
        actionSheet.addButton(R.string.f20340504, 1);
        actionSheet.addButton(R.string.f20339503, 1);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.5
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 == 0) {
                    BaseProfileTitleContainer.this.openProfileMore();
                    ReportController.o(((AbsComponent) BaseProfileTitleContainer.this).mApp, "dc00898", "", "", "0X800A97D", "0X800A97D", 1, 0, "0", "0", "", "");
                } else if (i3 == 1) {
                    ProfileCardUtil.U(((AbsComponent) BaseProfileTitleContainer.this).mActivity);
                    ReportController.o(((AbsComponent) BaseProfileTitleContainer.this).mApp, "dc00898", "", "", "0X800A97D", "0X800A97D", 2, 0, "0", "0", "", "");
                } else if (i3 == 2) {
                    ReportController.o(((AbsComponent) BaseProfileTitleContainer.this).mApp, "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
                }
                try {
                    actionSheet.dismiss();
                    actionSheet.setOnPreShowListener(null);
                } catch (Exception e16) {
                    QLog.e(BaseProfileTitleContainer.TAG, 1, "showMoreActionSheet actionSheet dismiss fail.", e16);
                }
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReportController.o(((AbsComponent) BaseProfileTitleContainer.this).mApp, "dc00898", "", "", "0X800A97D", "0X800A97D", 3, 0, "0", "0", "", "");
                actionSheet.mDefaultDismissListener.onClick(null);
            }
        });
        actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.7
            @Override // com.tencent.widget.ActionSheet.onPreShowListener
            public void onPreShow() {
                View expandRedTouchTargetView;
                View findViewById = actionSheet.mContentContainer.findViewById(1);
                View findViewById2 = findViewById == null ? null : findViewById.findViewById(R.id.action_sheet_button);
                if (findViewById2 != null && (expandRedTouchTargetView = BaseProfileTitleContainer.this.expandRedTouchTargetView(findViewById2, 5, 5, 7, 5)) != null) {
                    new RedTouch(((AbsComponent) BaseProfileTitleContainer.this).mActivity, expandRedTouchTargetView).setGravity(53).applyTo().parseRedTouch(ProfileCardUtil.z());
                }
                actionSheet.setOnPreShowListener(null);
            }
        });
        try {
            if (this.mActivity.isFinishing()) {
                return;
            }
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showMoreActionSheet actionSheet show fail.", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateTitle() {
        this.mLeftBackViewBg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AppSetting.t(((AbsComponent) BaseProfileTitleContainer.this).mActivity) && !(((AbsComponent) BaseProfileTitleContainer.this).mActivity instanceof FriendProfileCardActivity)) {
                    ((AbsComponent) BaseProfileTitleContainer.this).mActivity.onKeyDown(4, new KeyEvent(4, 4));
                } else {
                    ((AbsComponent) BaseProfileTitleContainer.this).mActivity.finish();
                }
            }
        });
        boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
        if (z16) {
            this.mCenterTextView.setText(R.string.bwm);
        } else {
            this.mCenterTextView.setText(R.string.bwj);
        }
        updateTitleRight(z16);
        updateTitleLeft(z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateTitleRight(boolean z16) {
        Resources resources = this.mActivity.getResources();
        TitleRightStatus updateTitleRightStatus = updateTitleRightStatus(z16, (ProfileCardInfo) this.mData);
        if (updateTitleRightStatus.showTextView) {
            this.mRightTextView.setVisibility(0);
            this.mRightTextView.setTag(new com.tencent.mobileqq.profile.b(updateTitleRightStatus.textTagType, null));
            this.mRightTextView.setOnClickListener(this);
            this.mRightTextView.setText(updateTitleRightStatus.textResId);
            TextView textView = this.mRightTextView;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(HardCodeUtil.qqStr(z16 ? R.string.bwm : R.string.bwj));
            sb5.append(HardCodeUtil.qqStr(updateTitleRightStatus.textResId));
            sb5.append(HardCodeUtil.qqStr(R.string.f212705o9));
            textView.setContentDescription(sb5.toString());
        } else {
            this.mRightTextView.setVisibility(8);
        }
        if (updateTitleRightStatus.showImageView) {
            this.mRightImageBg.setVisibility(0);
            this.mRightImageBg.setTag(new com.tencent.mobileqq.profile.b(updateTitleRightStatus.imageTagType, null));
            this.mRightImageBg.setOnClickListener(this);
            if (z16) {
                this.mRightImageView.setImageResource(R.drawable.qui_qrcode_icon_nav_secondary_selector);
                this.mRightImageBg.setContentDescription(HardCodeUtil.qqStr(R.string.msm));
            } else {
                this.mRightImageView.setImageResource(R.drawable.qui_more_icon_nav_secondary_selector);
                this.mRightImageBg.setContentDescription(HardCodeUtil.qqStr(R.string.mtk));
            }
            if (SimpleUIUtil.isNowElderMode()) {
                this.mRightImageBg.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.cai));
                this.mRightImageBg.setMinimumWidth(resources.getDimensionPixelSize(R.dimen.cai));
                return;
            }
            return;
        }
        this.mRightImageBg.setVisibility(8);
    }

    public TitleRightStatus updateTitleRightStatus(boolean z16, ProfileCardInfo profileCardInfo) {
        ContactCard contactCard;
        TitleRightStatus titleRightStatus = new TitleRightStatus();
        titleRightStatus.showTextView = false;
        titleRightStatus.showImageView = false;
        titleRightStatus.textTagType = 16;
        titleRightStatus.textResId = R.string.d3u;
        titleRightStatus.imageTagType = 16;
        if (profileCardInfo.isTroopMemberCard()) {
            QLog.iAsync(TAG, 1, "updateTitleRightStatus " + profileCardInfo.allInOne.uin + " cardInfo.allInOne.pa" + profileCardInfo.allInOne.f260789pa + "titleRightStatus.showTextView" + titleRightStatus.showTextView + "cardInfo.troopShowMoreBtn" + profileCardInfo.troopShowMoreBtn + "cardInfo.isTroopMemberCard: " + profileCardInfo.isTroopMemberCard);
            updateTitleForTroop(z16, titleRightStatus, profileCardInfo.troopShowMoreBtn);
            return titleRightStatus;
        }
        if (z16) {
            if (profileCardInfo.isTroopMemberCard) {
                titleRightStatus.showTextView = true;
                titleRightStatus.showImageView = false;
                titleRightStatus.textTagType = 98;
            } else {
                titleRightStatus.showTextView = true;
                titleRightStatus.showImageView = true;
                titleRightStatus.textTagType = 98;
                titleRightStatus.textResId = R.string.d4o;
                titleRightStatus.imageTagType = 65;
            }
        } else if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
            if (!this.mIsFromArkBabyQ) {
                titleRightStatus.showTextView = true;
            }
        } else if (!isPaTypeStrangerShowTitleRight(profileCardInfo.allInOne) && !ProfilePAUtils.isPaTypeShowAccount(profileCardInfo.allInOne)) {
            AllInOne allInOne = profileCardInfo.allInOne;
            int i3 = allInOne.f260789pa;
            if (i3 == 3) {
                titleRightStatus.showTextView = allInOne.chatAbility != 0;
            } else if (i3 != 32 && i3 != 31 && i3 != 50 && i3 != 51 && i3 != 34) {
                if (i3 == 53 && (contactCard = profileCardInfo.contactCard) != null && !TextUtils.equals(contactCard.uin, this.mApp.getCurrentAccountUin())) {
                    titleRightStatus.showImageView = !ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo);
                    titleRightStatus.imageTagType = 44;
                }
            } else {
                titleRightStatus.showImageView = !ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo);
                titleRightStatus.imageTagType = 44;
            }
        } else {
            titleRightStatus.showTextView = true;
        }
        if (profileCardInfo.isTroopMemberCard && titleRightStatus.showTextView) {
            titleRightStatus.showTextView = profileCardInfo.troopShowMoreBtn;
        }
        return titleRightStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleHideContact(IPhoneContactService iPhoneContactService, boolean z16) {
        String str;
        String str2;
        if (NetworkUtil.isNetSupport(this.mApp.getApplication().getApplicationContext())) {
            iPhoneContactService.hideContact(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) this.mData).allInOne), !z16);
            showHideContactProgressDialog();
            AppInterface appInterface = this.mApp;
            if (z16) {
                str = "0X800603E";
            } else {
                str = "0X800603D";
            }
            if (z16) {
                str2 = "0X800603E";
            } else {
                str2 = "0X800603D";
            }
            ReportController.o(appInterface, "CliOper", "", "", str, str2, 0, 0, "", "", "", "");
            return;
        }
        QQToast.makeText(this.mActivity, 1, HardCodeUtil.qqStr(R.string.msu), 1000).show();
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer, com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        QLog.i(TAG, 1, "onCreate");
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
            int intExtra = intent.getIntExtra("fromFlag", -1);
            this.mTroopFromFlag = intExtra;
            if (intExtra == 8) {
                this.mCallback4TroopFee = intent.getStringExtra("callback");
            }
        }
        this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.addProfileScrollListener(this);
            this.mDelegate.setZPlanChangeTitleStatusListener(this);
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.registObserver(this.mContactObserver);
        }
        initViews();
        updateTitle();
        updateTitleMode();
        this.mLeftBackViewBg.setContentDescription(HardCodeUtil.qqStr(R.string.mtc));
        AccessibilityUtil.d(this.mLeftBackViewBg, Button.class.getName());
        AccessibilityUtil.m(this.mLeftBackViewBg);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        if (this.mUin != 0 && ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(profileCardInfo)) {
            this.mIsShowZplanSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, this.mUin);
        }
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        boolean z16 = false;
        this.mIsShowZPlan = iProfileActivityDelegate != null && iProfileActivityDelegate.getIsShowZplanCover();
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null && iProfileActivityDelegate2.isShowQCircleCover()) {
            z16 = true;
        }
        this.mIsShowQCircle = z16;
        updateTitle();
        updateTitleMode();
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.removeProfileScrollListener(this);
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.mContactObserver);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        QLog.i(TAG, 1, "onResume");
        super.onResume();
        updateTitleRedTouch();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkToSwitchTitle(int i3) {
        AlphaAnimation alphaAnimation;
        if (i3 != 0 || this.mCenterTextView == null || this.mIsShowZPlan) {
            return;
        }
        if ((((ProfileCardInfo) this.mData).allInOne.f260789pa == 33) || isInNoCoverMode()) {
            return;
        }
        if (this.mContentVisibleRect == null) {
            this.mContentVisibleRect = new Rect();
        }
        View childAt = this.mListView.getChildAt(0);
        if (childAt != null) {
            childAt.getLocalVisibleRect(this.mContentVisibleRect);
        }
        int i16 = this.mContentVisibleRect.top;
        int visibility = this.mCenterTextView.getVisibility();
        if (i16 >= 0 && i16 > this.mContentScrollOffset && i16 >= this.mFadeInOutLine && visibility == 4) {
            alphaAnimation = this.mFadeInAnimation;
        } else {
            alphaAnimation = (i16 < 0 || i16 >= this.mContentScrollOffset || i16 > this.mFadeInOutLine || visibility != 0 || this.mIsShowQCircle) ? null : this.mFadeOutAnimation;
        }
        if (alphaAnimation != null && alphaAnimation != this.mCenterTextView.getAnimation()) {
            alphaAnimation.reset();
            this.mCenterTextView.startAnimation(alphaAnimation);
            this.mTitleBg.startAnimation(alphaAnimation);
        }
        this.mContentScrollOffset = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleRecommendContact() {
        if (NetworkUtil.isNetSupport(this.mApp.getApplication().getApplicationContext())) {
            String str = ((ProfileCardInfo) this.mData).nameArray[3];
            if (TextUtils.isEmpty(str) || str.equals(((ProfileCardInfo) this.mData).contactCard.mobileNo)) {
                str = ((ProfileCardInfo) this.mData).allInOne.contactName;
            }
            if (TextUtils.isEmpty(str) || str.equals(((ProfileCardInfo) this.mData).contactCard.mobileNo)) {
                str = ((ProfileCardInfo) this.mData).contactCard.nickName;
            }
            if (com.tencent.mobileqq.profile.util.b.m()) {
                QQAppInterface qQAppInterface = this.mQQAppInterface;
                DATA data = this.mData;
                com.tencent.mobileqq.profile.util.b.o(this.mApp, this.mActivity, ForwardShareCardOption.N(qQAppInterface, ((ProfileCardInfo) data).allInOne.uin, str, ((ProfileCardInfo) data).contactCard.bindQQ));
                return;
            }
            QQAppInterface qQAppInterface2 = this.mQQAppInterface;
            QBaseActivity qBaseActivity = this.mActivity;
            DATA data2 = this.mData;
            AbsShareMsg O = ForwardShareCardOption.O(qQAppInterface2, qBaseActivity, ((ProfileCardInfo) data2).allInOne.uin, str, ((ProfileCardInfo) data2).contactCard.bindQQ);
            Bundle bundle = new Bundle();
            bundle.putString("uin", ((ProfileCardInfo) this.mData).contactCard.mobileNo);
            bundle.putInt("uintype", 1006);
            bundle.putInt("forward_type", 20);
            bundle.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, O.mMsgServiceID);
            bundle.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, O.getBytes());
            bundle.putBoolean("k_dataline", false);
            bundle.putInt("pa_type", ((ProfileCardInfo) this.mData).allInOne.f260789pa);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(this.mActivity, intent, 21);
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 53) {
                ReportController.o(this.mApp, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
                return;
            } else {
                ReportController.o(this.mApp, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
                return;
            }
        }
        QQToast.makeText(this.mActivity, 1, HardCodeUtil.qqStr(R.string.mt9), 1000).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showContactActionSheet() {
        final IPhoneContactService iPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
        PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) this.mData).allInOne));
        final boolean z16 = queryContactByCodeNumber != null && queryContactByCodeNumber.isHiden;
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mActivity, null);
        actionSheet.addButton(R.string.bvl);
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 53) {
            ReportController.o(this.mApp, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
        } else {
            if (!TextUtils.isEmpty(getContactStrangerUin(this.mQQAppInterface, (ProfileCardInfo) data)) && queryContactByCodeNumber != null) {
                if (queryContactByCodeNumber.isHiden) {
                    actionSheet.addButton(R.string.bvn);
                } else if (!ac.M(this.mApp)) {
                    actionSheet.addButton(R.string.bvk);
                }
            }
            ReportController.o(this.mApp, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer.10
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 == 0) {
                    BaseProfileTitleContainer.this.handleRecommendContact();
                } else if (i3 == 1) {
                    BaseProfileTitleContainer.this.handleHideContact(iPhoneContactService, z16);
                }
                actionSheet.superDismiss();
            }
        });
        try {
            if (this.mActivity.isFinishing()) {
                return;
            }
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private void handleRecommendContactActivityResult(Intent intent) {
        if (intent == null || intent.getExtras() == null || intent.getExtras().isEmpty() || intent.getExtras().getInt("uintype", 0) == 10027) {
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        BaseAIOUtils.m(aliasIntent, null);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.mActivity.getString(R.string.hvn));
        aliasIntent.putExtras(new Bundle(intent.getExtras()));
        ForwardUtils.p(this.mQQAppInterface, this.mActivity, ForwardUtils.n0(aliasIntent), aliasIntent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTroopMoreActivityResult(Intent intent) {
        TroopMemberCard troopMemberCard;
        if (intent == null) {
            return;
        }
        if (intent.getExtras() != null && (troopMemberCard = (TroopMemberCard) intent.getSerializableExtra("troopMemberCard")) != null) {
            ((ProfileCardInfo) this.mData).troopMemberCard = troopMemberCard;
        }
        boolean booleanExtra = intent.getBooleanExtra("extra_is_deleted", false);
        boolean booleanExtra2 = intent.getBooleanExtra("extra_is_msg_tip_modify", false);
        boolean booleanExtra3 = intent.getBooleanExtra("extra_is_admin_modify", false);
        boolean booleanExtra4 = intent.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false);
        boolean booleanExtra5 = intent.getBooleanExtra("extra_is_level_modify", false);
        if (booleanExtra2 || booleanExtra5) {
            setTroopOperationResult(2);
        }
        if (booleanExtra3) {
            setTroopOperationResult(4);
        }
        if (booleanExtra) {
            setTroopOperationResult(1);
        }
        if (booleanExtra4) {
            Intent intent2 = new Intent();
            if (!booleanExtra) {
                intent2.putExtra(AppConstants.Key.IS_NEED_FINISH, booleanExtra4);
                this.mActivity.setResult(-1, intent2);
            } else if (this.mTroopFromFlag == 8) {
                intent2.putExtra("key_troop_fee_notify_js_data_changed", true);
                intent2.putExtra("callback", this.mCallback4TroopFee);
                this.mActivity.setResult(-1, intent2);
            }
            if (AppSetting.t(this.mActivity)) {
                QBaseActivity qBaseActivity = this.mActivity;
                if (!(qBaseActivity instanceof FriendProfileCardActivity)) {
                    qBaseActivity.onKeyDown(4, new KeyEvent(4, 4));
                    return;
                }
            }
            this.mActivity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateTitleMode(int i3) {
        int color;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateTitleMode mode=%s", Integer.valueOf(i3)));
        }
        this.mCurTitleMode = i3;
        Resources resources = this.mActivity.getResources();
        int i16 = R.color.skin_bar_btn;
        if (i3 == 1) {
            if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo) this.mData).curUseStyleId)) {
                int dIYTemplateTitleBarColorResource = getDIYTemplateTitleBarColorResource();
                color = resources.getColor(dIYTemplateTitleBarColorResource);
                this.mRightTextView.setTextColor(resources.getColorStateList(dIYTemplateTitleBarColorResource));
            } else {
                if (!ThemeUtil.isInNightMode(this.mApp)) {
                    i16 = R.color.a8u;
                }
                color = resources.getColor(i16);
            }
            this.mCenterTextView.setVisibility(4);
            this.mTitleBg.setVisibility(4);
            ImmersiveUtils.setStatusTextColorNew(false, this.mActivity.getWindow());
            updateTitleIconBg(true);
        } else if (i3 == 0 || i3 == 2) {
            color = resources.getColor(R.color.skin_bar_btn);
            this.mCenterTextView.setVisibility(0);
            this.mTitleBg.setVisibility(0);
            updateTitleIconBg(false);
        } else {
            color = 0;
        }
        if (!TokenResUtils.useTokenIcon()) {
            this.mRightImageView.setColorFilter(color);
            this.mRightMsgImageView.setColorFilter(color);
        }
        DATA data = this.mData;
        boolean z16 = (data == 0 || ((ProfileCardInfo) data).allInOne == null || ((ProfileCardInfo) data).allInOne.f260789pa != 0) ? false : true;
        boolean z17 = data != 0 && ((ProfileCardInfo) data).isTroopMemberCard;
        if (z16) {
            int i17 = i3 != 0 ? 0 : 4;
            this.mRightImageBg.setVisibility(isTitleRightSetting() ? 0 : i17);
            if (z17) {
                this.mRightImageBg.setVisibility(8);
            }
            RedTouch redTouch = this.mRightViewRedTouch;
            if (redTouch != null) {
                redTouch.setVisibility(i17);
            }
        }
        if (this.mRightSettingImageView != null && !TokenResUtils.useTokenIcon()) {
            this.mRightSettingImageView.setColorFilter(color);
        }
        QUIImmersiveHelper.s(this.mActivity, true, false);
    }

    public void updateTitleLeft(boolean z16) {
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
    }
}

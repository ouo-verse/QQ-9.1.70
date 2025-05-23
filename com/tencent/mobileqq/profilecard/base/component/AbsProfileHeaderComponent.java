package com.tencent.mobileqq.profilecard.base.component;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.nearby.i;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.au;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.j;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public abstract class AbsProfileHeaderComponent extends AbsQQProfileComponent<FrameLayout> implements View.OnClickListener, IProfileHeaderContainer {
    static IPatchRedirector $redirector_ = null;
    private static final int SUB_THREAD_MSG_REQ_FAVORITE = 10;
    private static final Object S_CACHE_VOTE_LOCK;
    private static final String TAG = "AbsProfileHeaderComponent";
    private static final int UI_THREAD_MSG_SHOW_VOTE_RED_DOT = 1;
    private static final long VOTE_FAIL_TOAST_INTERVAL = 2000;
    private final com.tencent.mobileqq.avatar.observer.a mAvatarObserver;
    private final BroadcastReceiver mAvatarReceiver;
    private final AtomicInteger mCacheVoteNum;
    protected AbsProfileHeaderView mHeaderView;
    private long mLastToastVoteFailTime;
    private AtomicBoolean mNeedSVipDialog;
    private IProfileEditApi.OnTakePhotoListener mOnTakePhotoListener;
    private final hx3.b<c> mOnlineStatusCallback;
    private AtomicBoolean mOpenSVipPay;
    protected ViewGroup mRootView;
    private SVIPObserver mSVipObserver;
    private final Handler.Callback mSubCallback;
    protected WeakReferenceHandler mSubHandler;
    private final Handler.Callback mUICallback;
    protected WeakReferenceHandler mUIHandler;
    private Uri mUploadPhotoUri;
    private j mVipDataChangedCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent$5, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass5 implements hx3.b<c> {
        static IPatchRedirector $redirector_;

        AnonymousClass5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onQueryResult$0() {
            AbsProfileHeaderComponent absProfileHeaderComponent = AbsProfileHeaderComponent.this;
            absProfileHeaderComponent.mHeaderView.updateHead((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent).mData);
            AbsProfileHeaderComponent absProfileHeaderComponent2 = AbsProfileHeaderComponent.this;
            absProfileHeaderComponent2.mHeaderView.updateOnlineStatusLayout((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent2).mData);
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable e<c> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (OnlineStatusToggleUtils.t() && ((AbsComponent) AbsProfileHeaderComponent.this).mData != null && AbsProfileHeaderComponent.this.mHeaderView != null && eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.component.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbsProfileHeaderComponent.AnonymousClass5.this.lambda$onQueryResult$0();
                    }
                });
                QLog.d(AbsProfileHeaderComponent.TAG, 1, "onQueryResult");
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent$6, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass6 extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        AnonymousClass6() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (IProfileCardConst.ACTION_AVATAR_FROM_PHOTO_EDIT.equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                ThreadManager.getFileThreadHandler().post(new Runnable(stringExtra, intent, context) { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.6.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ Intent val$intent;
                    final /* synthetic */ String val$path;

                    {
                        this.val$path = stringExtra;
                        this.val$intent = intent;
                        this.val$context = context;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass6.this, stringExtra, intent, context);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (!(peekAppRuntime instanceof QQAppInterface)) {
                            return;
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(ProfileCardUtil.h0((QQAppInterface) peekAppRuntime, this.val$path, this.val$intent)) { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.6.1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ boolean val$success;

                            {
                                this.val$success = r6;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(r6));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else if (this.val$success) {
                                    AbsProfileHeaderComponent absProfileHeaderComponent = AbsProfileHeaderComponent.this;
                                    absProfileHeaderComponent.mHeaderView.updateAvatar(((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent).mData).allInOne);
                                } else {
                                    QQToast.makeText(AnonymousClass1.this.val$context, 1, R.string.hfc, 0).show();
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent$9, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass9 implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ActionSheet val$actionSheet;
        final /* synthetic */ int val$editAction;
        final /* synthetic */ boolean val$isEditTroopCardTemp;
        final /* synthetic */ boolean val$showColorName;
        final /* synthetic */ String val$strDefault;
        final /* synthetic */ String val$tipsTemp;

        AnonymousClass9(String str, String str2, int i3, boolean z16, boolean z17, ActionSheet actionSheet) {
            this.val$tipsTemp = str;
            this.val$strDefault = str2;
            this.val$editAction = i3;
            this.val$isEditTroopCardTemp = z16;
            this.val$showColorName = z17;
            this.val$actionSheet = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AbsProfileHeaderComponent.this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), actionSheet);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(String str, String str2, int i3, boolean z16, TroopMemberInfo troopMemberInfo) {
            AbsProfileHeaderComponent.this.openEditInfoActivity(troopMemberInfo, str, str2, i3, z16);
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0 && ((AbsComponent) AbsProfileHeaderComponent.this).mActivity != null) {
                ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopMemberInfoService.class, "");
                String str = ((ProfileCardInfo) ((AbsComponent) AbsProfileHeaderComponent.this).mData).allInOne.troopCode;
                String str2 = ((ProfileCardInfo) ((AbsComponent) AbsProfileHeaderComponent.this).mData).allInOne.uin;
                final String str3 = this.val$tipsTemp;
                final String str4 = this.val$strDefault;
                final int i16 = this.val$editAction;
                final boolean z16 = this.val$isEditTroopCardTemp;
                iTroopMemberInfoService.getTroopMemberInfoAsync(str, str2, AbsProfileHeaderComponent.TAG, new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.profilecard.base.component.b
                    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                    public final void a(TroopMemberInfo troopMemberInfo) {
                        AbsProfileHeaderComponent.AnonymousClass9.this.lambda$onClick$0(str3, str4, i16, z16, troopMemberInfo);
                    }
                });
            }
            if (i3 == 1 && ((AbsComponent) AbsProfileHeaderComponent.this).mActivity != null && this.val$showColorName) {
                ((IVipColorName) QRoute.api(IVipColorName.class)).openChangeColorNamePage(view.getContext());
                ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "data_card", "nickname_float", "", "nickname_color", "4", 102, 0);
            }
            this.val$actionSheet.dismiss();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73948);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            S_CACHE_VOTE_LOCK = new Object();
        }
    }

    public AbsProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.mCacheVoteNum = new AtomicInteger(0);
        this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                AbsProfileHeaderComponent.this.handleUIMessage(message);
                return true;
            }
        };
        this.mSubCallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                AbsProfileHeaderComponent.this.handleSubMessage(message);
                return true;
            }
        };
        this.mOpenSVipPay = new AtomicBoolean(false);
        this.mNeedSVipDialog = new AtomicBoolean(true);
        this.mSVipObserver = new SVIPObserver() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.app.SVIPObserver
            public void onVipStatusChanged() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((AbsComponent) AbsProfileHeaderComponent.this).mApp != null && VasUtil.getSignedService(((AbsComponent) AbsProfileHeaderComponent.this).mApp).getVipStatus().isSVip()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AbsProfileHeaderComponent.TAG, 2, String.format("onVipStatusChanged mOpenSVipPay=%s", AbsProfileHeaderComponent.this.mOpenSVipPay));
                    }
                    IProfileActivityDelegate iProfileActivityDelegate = AbsProfileHeaderComponent.this.mDelegate;
                    if (iProfileActivityDelegate != null) {
                        iProfileActivityDelegate.requestUpdateCard();
                    }
                    if (AbsProfileHeaderComponent.this.mNeedSVipDialog.compareAndSet(true, false) && AbsProfileHeaderComponent.this.mOpenSVipPay.get()) {
                        DialogUtil.createCustomDialog(((AbsComponent) AbsProfileHeaderComponent.this).mActivity, 232, (String) null, HardCodeUtil.qqStr(R.string.msk), (String) null, HardCodeUtil.qqStr(R.string.mss), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.3.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                } else {
                                    dialogInterface.dismiss();
                                }
                            }
                        }, (DialogInterface.OnClickListener) null).show();
                    }
                    ((AbsComponent) AbsProfileHeaderComponent.this).mApp.removeObserver(AbsProfileHeaderComponent.this.mSVipObserver);
                }
            }
        };
        this.mAvatarObserver = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                AbsProfileHeaderComponent absProfileHeaderComponent;
                AbsProfileHeaderView absProfileHeaderView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str);
                } else if (z16 && str.equals(((ProfileCardInfo) ((AbsComponent) AbsProfileHeaderComponent.this).mData).allInOne.uin) && (absProfileHeaderView = (absProfileHeaderComponent = AbsProfileHeaderComponent.this).mHeaderView) != null) {
                    absProfileHeaderView.updateAvatar(((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent).mData).allInOne);
                }
            }

            @Override // com.tencent.mobileqq.avatar.observer.a
            protected void onUpdateMobileQQHead(boolean z16, String str) {
                String mobileNumberWithNationCode;
                AbsProfileHeaderComponent absProfileHeaderComponent;
                AbsProfileHeaderView absProfileHeaderView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AbsProfileHeaderComponent.TAG, 2, String.format("onUpdateMobileQQHead isSuccess=%s mobileNumber=%s", Boolean.valueOf(z16), str));
                }
                if (z16 && ((ProfileCardInfo) ((AbsComponent) AbsProfileHeaderComponent.this).mData).allInOne != null && (mobileNumberWithNationCode = ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) ((AbsComponent) AbsProfileHeaderComponent.this).mData).allInOne)) != null && mobileNumberWithNationCode.equals(str) && (absProfileHeaderView = (absProfileHeaderComponent = AbsProfileHeaderComponent.this).mHeaderView) != null) {
                    absProfileHeaderView.updateAvatar(((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent).mData).allInOne, 1, mobileNumberWithNationCode, false);
                }
            }
        };
        this.mOnlineStatusCallback = new AnonymousClass5();
        this.mAvatarReceiver = new AnonymousClass6();
        this.mVipDataChangedCallback = new j() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.vip.api.j
            public void changed(@NonNull VipData vipData, @Nullable VipData vipData2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vipData, (Object) vipData2);
                } else if (vipData.getSpecialAvatarId() != vipData2.getSpecialAvatarId()) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.7.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AbsProfileHeaderComponent absProfileHeaderComponent = AbsProfileHeaderComponent.this;
                                absProfileHeaderComponent.mHeaderView.updateAvatar(((ProfileCardInfo) ((AbsComponent) absProfileHeaderComponent).mData).allInOne);
                            }
                        }
                    });
                }
            }
        };
        this.mOnTakePhotoListener = new IProfileEditApi.OnTakePhotoListener() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.OnTakePhotoListener
            public void onSetSourceFrom(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.OnTakePhotoListener
            public void onStartTakePhoto(Uri uri) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AbsProfileHeaderComponent.this.mUploadPhotoUri = uri;
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uri);
                }
            }
        };
    }

    private void checkVoteRedTouch() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) ((AbsComponent) AbsProfileHeaderComponent.this).mApp.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                    RedTouchItem j3 = localRedTouchManager.j(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
                    if (localRedTouchManager.d(j3, false) && j3.passThroughLevel > 0) {
                        Message obtainMessage = AbsProfileHeaderComponent.this.mUIHandler.obtainMessage();
                        obtainMessage.what = 1;
                        obtainMessage.arg1 = 2;
                        AbsProfileHeaderComponent.this.mUIHandler.sendMessageDelayed(obtainMessage, 300L);
                    }
                } catch (Exception e16) {
                    QLog.e(AbsProfileHeaderComponent.TAG, 1, "checkVoteRedTouch fail.", e16);
                }
            }
        }, 5, null, false);
    }

    private boolean doHandleViewDynamic(View view) {
        if (view instanceof QQProAvatarView) {
            String n3 = ((QQProAvatarView) view).n();
            if (!TextUtils.isEmpty(n3)) {
                ProfileCardUtil.F0(this.mActivity, view, n3);
                return true;
            }
            return false;
        }
        return false;
    }

    private String getGenderString(ProfileCardInfo profileCardInfo) {
        Card card = profileCardInfo.card;
        if (card != null && card.shGender == 1) {
            return HardCodeUtil.qqStr(R.string.f159991tt);
        }
        return HardCodeUtil.qqStr(R.string.f160001tu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int guestAvatarClickReport() {
        DATA data = this.mData;
        int i3 = 1;
        if (((ProfileCardInfo) data).allInOne.f260789pa != 1) {
            if (((ProfileCardInfo) data).allInOne.f260789pa == 20) {
                i3 = 2;
            } else if (((ProfileCardInfo) data).allInOne.f260789pa == 21) {
                i3 = 3;
            } else if (((ProfileCardInfo) data).allInOne.f260789pa == 45) {
                i3 = 4;
            } else if (((ProfileCardInfo) data).allInOne.f260789pa == 46) {
                i3 = 5;
            } else if (((ProfileCardInfo) data).allInOne.f260789pa == 41) {
                i3 = 6;
            } else if (((ProfileCardInfo) data).allInOne.f260789pa == 42) {
                i3 = 7;
            } else {
                i3 = 0;
            }
        }
        ReportController.o(this.mApp, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i3, 0, "", "", "", "");
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleAvatarClick() {
        AbsProfileHeaderView absProfileHeaderView;
        View childView;
        DATA data = this.mData;
        Card card = ((ProfileCardInfo) data).card;
        if (card != null && card.isForbidAccount) {
            QLog.e(TAG, 1, "handleAvatarClick isForbidAccount");
            return;
        }
        View view = null;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                View childView2 = this.mHeaderView.getChildView("map_key_face");
                if (childView2 instanceof AvatarLayout) {
                    view = ((AvatarLayout) childView2).c(0);
                }
                ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).showAvatarActionSheet(this.mApp, this.mActivity, view, ((ProfileCardInfo) this.mData).allInOne, this.mOnTakePhotoListener, 1, IProfileCardConst.ACTION_AVATAR_FROM_PHOTO_EDIT);
                return;
            }
            if (this.mHeaderView != null) {
                ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(this.mActivity, "1", this.mHeaderView.findViewById(R.id.a6e));
            } else {
                ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(this.mActivity, "1");
            }
        } else {
            if (((ProfileCardInfo) data).allInOne.f260789pa == 33) {
                return;
            }
            if (!ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo) data).allInOne)) {
                String mobileNumberWithNationCode = ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) this.mData).allInOne);
                DATA data2 = this.mData;
                if ((((ProfileCardInfo) data2).allInOne.f260789pa != 53 || ((ProfileCardInfo) data2).allInOne.bindQQ) && mobileNumberWithNationCode != null && (absProfileHeaderView = this.mHeaderView) != null && (childView = absProfileHeaderView.getChildView("map_key_face")) != null) {
                    ProfileCardUtil.A0(this.mActivity, childView, mobileNumberWithNationCode);
                }
            } else {
                handleAvatarClickInner();
            }
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
        } else {
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
        }
        AbsProfileHeaderView absProfileHeaderView2 = this.mHeaderView;
        if (absProfileHeaderView2 != null) {
            VideoReport.reportEvent("clck", absProfileHeaderView2.getChildView("map_key_face"), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleAvatarClickInner() {
        View c16;
        AppInterface appInterface = this.mApp;
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null && appInterface != null) {
            View childView = absProfileHeaderView.getChildView("map_key_face");
            if (childView == null) {
                c16 = null;
            } else {
                c16 = ((AvatarLayout) childView).c(0);
            }
            View view = c16;
            long pendantId = this.mHeaderView.getPendantId();
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne.f260789pa != 0 && ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo) data).allInOne) && view != null && pendantId != 0) {
                int guestAvatarClickReport = guestAvatarClickReport();
                if (!doHandleViewDynamic(view)) {
                    ProfileCardUtil.E0(this.mActivity, view, ((ProfileCardInfo) this.mData).allInOne.uin, pendantId, guestAvatarClickReport, new AllInOne(appInterface.getAccount(), 1));
                    return;
                }
                return;
            }
            if (!doHandleViewDynamic(view)) {
                DATA data2 = this.mData;
                if (((ProfileCardInfo) data2).allInOne.f260789pa == 41 && !TextUtils.isEmpty(((ProfileCardInfo) data2).allInOne.uin) && ((ProfileCardInfo) this.mData).allInOne.uin.equals("0")) {
                    ProfileCardUtil.C0(this.mActivity, view, ((ProfileCardInfo) this.mData).allInOne.uid, false, false, null);
                } else {
                    ProfileCardUtil.C0(this.mActivity, view, ((ProfileCardInfo) this.mData).allInOne.uin, false, false, new AllInOne(appInterface.getAccount(), 1));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleEditNickActivityResult(int i3, Intent intent) {
        if (i3 == -1) {
            int intExtra = intent.getIntExtra(QZoneContant.KEY_EDIT_TYPE, 0);
            String stringExtra = intent.getStringExtra("result");
            if (intExtra == 5) {
                ((ProfileCardInfo) this.mData).nameArray[1] = stringExtra;
            } else if (intExtra == 3) {
                ((ProfileCardInfo) this.mData).nameArray[0] = stringExtra;
            } else if (intExtra == 4) {
                ((ProfileCardInfo) this.mData).nameArray[4] = stringExtra;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleEditNickClick() {
        if (Utils.G(((ProfileCardInfo) this.mData).allInOne.uin)) {
            return;
        }
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileNickUpgradeEnable() && ((ProfileCardInfo) this.mData).isTroopMemberCard) {
            showEditNickActionSheetForTroop();
        } else {
            showEditNickActionSheet();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleEditTroopNickClick() {
        if (Utils.G(((ProfileCardInfo) this.mData).allInOne.uin)) {
            return;
        }
        showEditNickActionSheetForTroop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTemplateOutOfDateClick(int i3) {
        int i16;
        if (i3 == 101107 || i3 == 101108) {
            if (i3 == 101108) {
                i16 = 5;
            } else {
                i16 = 2;
            }
            if (i3 == 101108) {
                ff.Q(this.mActivity, 3, ProfileCardUtil.o(i16));
            } else {
                ff.R(this.mActivity, 3, ProfileCardUtil.o(i16));
            }
        }
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        ReportController.o(this.mApp, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileEntryUtils.getProfileEntryType(((ProfileCardInfo) this.mData).allInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo) this.mData).allInOne)), "", "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleVoteBtnClick(Card card) {
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa != 0 && !((ProfileCardInfo) data).allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
            handleVoteBtnClickForGuestProfile(card);
        } else {
            handleVoteBtnClickForMyProfile(card);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleVoteBtnClickForGuestProfile(Card card) {
        boolean z16;
        String str;
        int i3 = 1;
        if (card == null) {
            notifyUser(this.mActivity.getString(R.string.bwo), 1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleVoteBtnClickForGuestProfile availVoteCnt=%s haveVotedCnt=%s voteLimitedNotice=%s", Short.valueOf(card.bAvailVoteCnt), Short.valueOf(card.bHaveVotedCnt), card.strVoteLimitedNotice));
        }
        if (card.bAvailVoteCnt <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                card.lVoteCount++;
                card.bVoted = (byte) 1;
                card.bAvailVoteCnt = (short) (card.bAvailVoteCnt - 1);
                synchronized (S_CACHE_VOTE_LOCK) {
                    this.mCacheVoteNum.incrementAndGet();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, String.format("handleVoteBtnClick uin=%s voteCount=%s mCacheVoteNum=%s", card.uin, Long.valueOf(card.lVoteCount), this.mCacheVoteNum));
                    }
                }
                if (!this.mSubHandler.hasMessages(10)) {
                    Message obtain = Message.obtain();
                    obtain.what = 10;
                    this.mSubHandler.sendMessageDelayed(obtain, 2000L);
                }
                AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
                if (absProfileHeaderView != null) {
                    absProfileHeaderView.updateLiked((ProfileCardInfo) this.mData, card.lVoteCount, true);
                    return;
                }
                return;
            }
            notifyUser(this.mActivity.getString(R.string.ihg), 1);
            return;
        }
        if (!VasUtil.getSignedService(this.mQQAppInterface).getVipStatus().isSVip()) {
            showSVipVotePrivilegeTips();
            return;
        }
        if (SystemClock.uptimeMillis() - this.mLastToastVoteFailTime > 2000) {
            String str2 = card.strVoteLimitedNotice;
            if (str2 != null) {
                i3 = 0;
            } else {
                str2 = this.mActivity.getString(R.string.bwo);
            }
            notifyUser(str2, i3);
            this.mLastToastVoteFailTime = SystemClock.uptimeMillis();
        }
        if (this.mActivity.getIntent().hasExtra("troopUin")) {
            str = "1";
        } else {
            str = "0";
        }
        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", str, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleVoteBtnClickForMyProfile(Card card) {
        int i3;
        int i16;
        boolean z16;
        if (card == null) {
            i3 = 0;
        } else {
            i3 = (int) card.lVoteCount;
        }
        if (card == null) {
            i16 = 0;
        } else {
            i16 = card.likeAreaId;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) VisitorsActivity.class);
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("toUin", Long.valueOf(((ProfileCardInfo) this.mData).allInOne.uin).longValue());
            bundle.putLong("totalVoters", i3);
            bundle.putBoolean("isStartedByProfileCard", true);
            bundle.putBoolean("votersOnly", true);
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bundle.putBoolean("hasVoters", z16);
            bundle.putBoolean("extra_show_rank", true);
            bundle.putInt("extra_from", 1);
            bundle.putInt("frome_where", 5);
            intent.putExtras(bundle);
            this.mActivity.startActivity(intent);
            i.a(this.mQQAppInterface);
            AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
            if (absProfileHeaderView != null && card != null) {
                View childView = absProfileHeaderView.getChildView("map_key_like");
                boolean isLuckyVip = card.isLuckyVip();
                if (childView instanceof VoteView) {
                    VoteView voteView = (VoteView) childView;
                    voteView.j(true, false, i3, 0, null, false, i16, isLuckyVip, card.uin);
                    voteView.g(false);
                } else if (childView instanceof VoteViewV2) {
                    VoteViewV2 voteViewV2 = (VoteViewV2) childView;
                    voteViewV2.r(true, false, i3, 0, null, false, i16, Boolean.valueOf(isLuckyVip), card.uin);
                    voteViewV2.n(false);
                }
            }
            if (card != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("update_local_vote_count", true)) {
                card.iVoteIncrement = 0;
            }
            ReportController.o(this.mApp, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(((ProfileCardInfo) this.mData).allInOne)), "", "", "");
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void openEditInfoActivity(TroopMemberInfo troopMemberInfo, String str, String str2, int i3, boolean z16) {
        String str3 = troopMemberInfo != null ? troopMemberInfo.troopnick : "";
        if (TextUtils.isEmpty(str3)) {
            str3 = ((ProfileCardInfo) this.mData).allInOne.nickname;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = ((ProfileCardInfo) this.mData).card.strNick;
        }
        openEditInfoActivity(str, str2, str3, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reqFavorite() {
        DATA data;
        int i3;
        CardHandler cardHandler = (CardHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null && (data = this.mData) != 0 && ((ProfileCardInfo) data).card != null) {
            synchronized (S_CACHE_VOTE_LOCK) {
                i3 = this.mCacheVoteNum.get();
                this.mCacheVoteNum.set(0);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("reqFavorite cacheVoteNum=%s", Integer.valueOf(i3)));
            }
            if (i3 > 0) {
                long longAccountUin = this.mApp.getLongAccountUin();
                long parseLong = Long.parseLong(((ProfileCardInfo) this.mData).allInOne.uin);
                DATA data2 = this.mData;
                if (data2 != 0 && ((ProfileCardInfo) data2).card != null) {
                    cardHandler.Q4(longAccountUin, parseLong, ((ProfileCardInfo) data2).card.vCookies, ((ProfileCardInfo) data2).card.favoriteSource, i3, 0);
                }
            }
        }
    }

    private void reqFavoriteImmediately() {
        WeakReferenceHandler weakReferenceHandler = this.mSubHandler;
        if (weakReferenceHandler != null && weakReferenceHandler.hasMessages(10)) {
            this.mSubHandler.removeMessages(10);
            reqFavorite();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showEditNickActionSheet() {
        String string;
        String str;
        boolean z16;
        int i3;
        String str2;
        DATA data = this.mData;
        String str3 = ((ProfileCardInfo) data).nameArray[0];
        String str4 = ((ProfileCardInfo) data).nameArray[4];
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("showEditNickActionSheet nickName=%s, remark=%s", str3, str4));
        }
        DATA data2 = this.mData;
        if (((ProfileCardInfo) data2).allInOne.f260789pa == 0) {
            String string2 = this.mActivity.getString(R.string.bu8);
            ReportController.o(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
            i3 = 3;
            str = string2;
            str2 = str3;
            z16 = true;
        } else {
            if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) data2).allInOne)) {
                if (!TextUtils.isEmpty(str4)) {
                    string = this.mActivity.getString(R.string.f171033bu4);
                } else {
                    string = this.mActivity.getString(R.string.bw8);
                }
                ReportController.o(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
            } else if (!TextUtils.isEmpty(((ProfileCardInfo) this.mData).allInOne.uid)) {
                m b16 = f.b();
                if (b16 == null) {
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(((ProfileCardInfo) this.mData).allInOne.uid);
                Map<String, String> buddyRemark = b16.getBuddyRemark(arrayList);
                if (buddyRemark != null) {
                    str4 = buddyRemark.get(((ProfileCardInfo) this.mData).allInOne.uid);
                } else {
                    str4 = "";
                }
                if (TextUtils.isEmpty(str4)) {
                    string = this.mActivity.getString(R.string.f160451v2);
                } else {
                    string = this.mActivity.getString(R.string.f160021tw);
                }
            } else {
                String genderString = getGenderString((ProfileCardInfo) this.mData);
                notifyUser(this.mActivity.getString(R.string.bu5, genderString, genderString), 1);
                return;
            }
            str = string;
            z16 = false;
            i3 = 4;
            str2 = str4;
        }
        showEditNickActionSheetInner(false, i3, str2, str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showEditNickActionSheetForTroop() {
        boolean z16;
        String string;
        String str = ((ProfileCardInfo) this.mData).nameArray[1];
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("showEditNickActionSheetForTroop troopNick=%s", str));
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            string = this.mActivity.getString(R.string.bu9);
            ReportController.o(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
        } else {
            String currentUin = this.mApp.getCurrentUin();
            TroopInfo B = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).B(((ProfileCardInfo) this.mData).troopUin);
            if (B != null && (B.isTroopAdmin(currentUin) || B.isTroopOwner(currentUin))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (!TextUtils.isEmpty(str)) {
                    string = this.mActivity.getString(R.string.bub, getGenderString((ProfileCardInfo) this.mData));
                } else {
                    string = this.mActivity.getString(R.string.bw9, getGenderString((ProfileCardInfo) this.mData));
                }
                ReportController.o(this.mApp, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
            } else {
                notifyUser(this.mActivity.getString(R.string.bud, getGenderString((ProfileCardInfo) this.mData)), 1);
                return;
            }
        }
        showEditNickActionSheetInner(true, 5, str, string, false);
    }

    private void showEditNickActionSheetInner(boolean z16, int i3, String str, String str2, boolean z17) {
        if (!TextUtils.isEmpty(str2)) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mActivity, null);
            actionSheet.addButton(str2, 1);
            UnitedProxy a16 = ar.a("linkliang", "2024-03-07", "vas_colorfulnick_profile");
            if (z17 && a16.isEnable(true)) {
                actionSheet.addButton(a16.getJson().optString("nickname_float", this.mActivity.getString(R.string.f160011tv)), 1);
                ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "data_card", "nickname_float", "", "nickname_color", "4", 101, 0);
            }
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new AnonymousClass9(str2, str, i3, z16, z17, actionSheet));
            try {
                actionSheet.show();
            } catch (Throwable th5) {
                QLog.d(TAG, 1, "showEditNickActionSheet fail.", th5);
            }
        }
    }

    private void showSVipVotePrivilegeTips() {
        String str;
        String str2;
        if (VoteHelper.n(this.mQQAppInterface)) {
            au auVar = new au(this.mActivity);
            auVar.N(new au.b() { // from class: com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsProfileHeaderComponent.this);
                    }
                }

                @Override // com.tencent.mobileqq.vas.au.b
                public void onLeftClick() {
                    String str3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AbsProfileHeaderComponent.TAG, 2, "ZanDoubleDialog: onLeftClick: ");
                    }
                    if (((AbsComponent) AbsProfileHeaderComponent.this).mActivity == null) {
                        QLog.e(AbsProfileHeaderComponent.TAG, 2, "ZanDoubleDialog: onLeftClick: mActivity = null");
                        return;
                    }
                    if (((AbsComponent) AbsProfileHeaderComponent.this).mActivity.getIntent().hasExtra("troopUin")) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    VasWebviewUtil.reportCommercialDrainage(((AbsComponent) AbsProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", str3, "");
                    Intent intent = new Intent(((AbsComponent) AbsProfileHeaderComponent.this).mActivity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("fragmentStyle", 3);
                    intent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
                    intent.putExtra("isTransparentTitle", true);
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((AbsComponent) AbsProfileHeaderComponent.this).mActivity.startActivity(intent);
                }

                @Override // com.tencent.mobileqq.vas.au.b
                public void onRightClick() {
                    String str3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(AbsProfileHeaderComponent.TAG, 2, "ZanDoubleDialog: onRightClick: ");
                    }
                    if (((AbsComponent) AbsProfileHeaderComponent.this).mActivity.getIntent().hasExtra("troopUin")) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    VasWebviewUtil.reportCommercialDrainage(((AbsComponent) AbsProfileHeaderComponent.this).mApp.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str3, "");
                    VasH5PayUtil.openH5Pay((Context) ((AbsComponent) AbsProfileHeaderComponent.this).mActivity, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
                    AbsProfileHeaderComponent.this.mOpenSVipPay.set(true);
                }
            });
            auVar.show();
            if (this.mActivity.getIntent().hasExtra("troopUin")) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", str2, "");
            return;
        }
        if (this.mActivity.getIntent().hasExtra("troopUin")) {
            str = "1";
        } else {
            str = "0";
        }
        VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", str, "");
        notifyUser("\u975eSVIP\u7528\u6237\u6bcf\u5929\u53ea\u80fd\u70b910\u4e2a\u8d5e\u54e6\uff5e", 0);
    }

    private void showVoteRedDot(Message message) {
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            View childView = absProfileHeaderView.getChildView("map_key_like");
            if (childView instanceof VoteView) {
                ((VoteView) childView).g(true);
                return;
            } else {
                if (childView instanceof VoteViewV2) {
                    ((VoteViewV2) childView).n(true);
                    return;
                }
                return;
            }
        }
        if (message.arg1 > 0) {
            Message obtainMessage = this.mUIHandler.obtainMessage();
            obtainMessage.what = message.what;
            obtainMessage.arg1 = message.arg1 - 1;
            this.mUIHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    private void startVoteAnimation() {
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            View childView = absProfileHeaderView.getChildView("map_key_like");
            if (childView instanceof VoteView) {
                ((VoteView) childView).h(true);
            } else if (childView instanceof VoteViewV2) {
                ((VoteViewV2) childView).o(true);
            }
        }
    }

    private void stopVoteAnimation() {
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            View childView = absProfileHeaderView.getChildView("map_key_like");
            if (childView instanceof VoteView) {
                ((VoteView) childView).h(false);
            } else if (childView instanceof VoteViewV2) {
                ((VoteViewV2) childView).o(false);
            }
        }
    }

    public void dtReport(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
        } else {
            VideoReport.reportEvent("clck", view, null);
        }
    }

    public AbsProfileHeaderView getHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AbsProfileHeaderView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mHeaderView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleSubMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message);
        } else if (message.what == 10) {
            reqFavorite();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleUIMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) message);
        } else if (message.what == 1) {
            showVoteRedDot(message);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer
    public boolean hasPhotoWall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    protected abstract void initHeaderView();

    protected void notifyUser(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        } else {
            QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1034) {
            handleEditNickActivityResult(i16, intent);
        } else if (i3 == 5 && i16 == -1) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).startCropPhoto(this.mActivity, this.mUploadPhotoUri, 0, IProfileCardConst.ACTION_AVATAR_FROM_PHOTO_EDIT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Card card;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 10) {
                        if (i3 != 24) {
                            if (i3 != 88) {
                                if (i3 != 97) {
                                    if (i3 == 112) {
                                        handleEditTroopNickClick();
                                    }
                                } else {
                                    Pair pair = (Pair) bVar.f260136b;
                                    ProfileSignatureUtils.handleSignatureCommonClick(view, ((Integer) pair.first).intValue(), (String) pair.second, this.mActivity, this.mQQAppInterface);
                                }
                            } else {
                                handleEditNickClick();
                            }
                        } else {
                            handleTemplateOutOfDateClick(((Integer) bVar.f260136b).intValue());
                        }
                    } else {
                        Object obj = bVar.f260136b;
                        if (obj instanceof Card) {
                            card = (Card) obj;
                        } else {
                            card = null;
                        }
                        handleVoteBtnClick(card);
                    }
                } else {
                    ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo) this.mData, this.mActivity, this.mQQAppInterface);
                }
            } else {
                handleAvatarClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
        this.mSubHandler = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this.mSubCallback);
        this.mApp.addObserver(this.mSVipObserver);
        this.mApp.addObserver(this.mAvatarObserver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IProfileCardConst.ACTION_AVATAR_FROM_PHOTO_EDIT);
        try {
            qBaseActivity.registerReceiver(this.mAvatarReceiver, intentFilter);
        } catch (AssertionError e16) {
            QLog.i(TAG, 1, "register mAvatarReceiver error" + e16);
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).registerVipDataChangedCallback(((ProfileCardInfo) this.mData).allInOne.uin, this.mVipDataChangedCallback);
        }
        initHeaderView();
        if (this.mHeaderView != null) {
            this.mHeaderView.addChildView("map_key_tag_jueban", this.mRootView.findViewById(R.id.dzj));
            this.mHeaderView.updateJueban((ProfileCardInfo) this.mData);
        }
        if (OnlineStatusToggleUtils.t() && this.mData != 0 && this.mApp.getCurrentUin().equals(((ProfileCardInfo) this.mData).allInOne.uin) && this.mApp.getCurrentUid() != null) {
            ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(this.mApp.getCurrentUid(), TAG, this.mOnlineStatusCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        WeakReferenceHandler weakReferenceHandler = this.mUIHandler;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.mUIHandler = null;
        }
        WeakReferenceHandler weakReferenceHandler2 = this.mSubHandler;
        if (weakReferenceHandler2 != null) {
            weakReferenceHandler2.removeCallbacksAndMessages(null);
            this.mSubHandler = null;
        }
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            absProfileHeaderView.onDestroy();
        }
        this.mApp.removeObserver(this.mSVipObserver);
        this.mApp.removeObserver(this.mAvatarObserver);
        if (this.mApp.getCurrentUid() != null) {
            ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(this.mApp.getCurrentUid(), TAG, this.mOnlineStatusCallback);
        }
        try {
            this.mActivity.unregisterReceiver(this.mAvatarReceiver);
        } catch (IllegalArgumentException unused) {
            QLog.e(TAG, 1, "mAvatarReceiver is not receiver");
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).unRegisterVipDataChangedCallback(((ProfileCardInfo) this.mData).allInOne.uin, this.mVipDataChangedCallback);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer
    public void onGetQZoneCover(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        AbsProfileHeaderView headerView = getHeaderView();
        if (headerView != null) {
            headerView.onGetQZoneCover(z16, str, mobile_sub_get_photo_wall_rspVar);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onPause();
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            absProfileHeaderView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onResume();
        checkVoteRedTouch();
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            absProfileHeaderView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onStart();
            startVoteAnimation();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onStop();
        stopVoteAnimation();
        reqFavoriteImmediately();
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void setProfileActivityDelegate(IProfileActivityDelegate iProfileActivityDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProfileActivityDelegate);
            return;
        }
        super.setProfileActivityDelegate(iProfileActivityDelegate);
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null) {
            this.mRootView = iProfileActivityDelegate2.getRootView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((AbsProfileHeaderComponent) profileCardInfo);
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            DATA data = this.mData;
            absProfileHeaderView.onUpdate((ProfileCardInfo) data, ((ProfileCardInfo) data).isNetRet);
        }
        return lambda$checkValidComponent$3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void openEditInfoActivity(String str, String str2, String str3, int i3, boolean z16) {
        Intent intent = new Intent();
        intent.putExtra("title", str);
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str2);
        intent.putExtra("default_hint", str3);
        intent.putExtra("uin", ((ProfileCardInfo) this.mData).card.uin);
        intent.putExtra("uid", ((ProfileCardInfo) this.mData).allInOne.uid);
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, i3);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("edit_mode", 2);
        if (z16) {
            intent.putExtra("max_num", 60);
        } else {
            intent.putExtra("max_num", i3 == 4 ? 96 : 36);
        }
        intent.putExtra("from", ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).getSourceTypeFromeProfileType(((ProfileCardInfo) this.mData).allInOne.f260789pa));
        if (!TextUtils.isEmpty(((ProfileCardInfo) this.mData).allInOne.troopCode)) {
            intent.putExtra("troopUin", ((ProfileCardInfo) this.mData).allInOne.troopCode);
        } else {
            intent.putExtra("troopUin", ((ProfileCardInfo) this.mData).allInOne.troopUin);
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null) {
            RouteUtils.startActivityForResult(qBaseActivity, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 1034);
        }
    }
}

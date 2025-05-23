package com.tencent.mobileqq.profilecard.fragment;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.dataline.util.j;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.ProfileEditDateUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfileEditPrivacyHelper;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.widget.AvatarContainer;
import com.tencent.mobileqq.profilecard.widget.CoverDialog;
import com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet;
import com.tencent.mobileqq.profilecard.widget.selector.AgeSelectorView;
import com.tencent.mobileqq.profilecard.widget.selector.BirthDaySelectorView;
import com.tencent.mobileqq.profilecard.widget.selector.SexSelectorView;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class ProfileEditFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String BIRTHDAY_SET_ERROR_MESSAGE = "\u751f\u65e5\u5e94\u65e9\u4e8e\u5f53\u524d\u65e5\u671f";
    private static final String CARD_URL_KEY = "card_url_key";
    private static final int DEFAULT_BIRTHDAY = 0;
    private static final byte DEFAULT_SEX = -1;
    private static final String DTDTREPORT_KEY_EDIT_CASUALPOST = "em_user_profile_edit_casualpost";
    private static final String DTDTREPORT_KEY_EDIT_MUSICBOX = "em_user_profile_edit_musicbox";
    private static final String DTDTREPORT_KEY_EDIT_PICTURE = "em_user_profile_edit_picture";
    private static final String DTDTREPORT_KEY_EDIT_QUESTION = "em_user_profile_edit_question";
    private static final String DTDTREPORT_KEY_EDIT_TAG = "em_user_profile_edit_tag";
    private static final String DTREPORT_KEY_AGE = "em_user_profile_edit_age";
    private static final String DTREPORT_KEY_AVATAR = "em_user_profile_edit_avatar";
    private static final String DTREPORT_KEY_BIRTH = "em_user_profile_edit_birth";
    private static final String DTREPORT_KEY_COVER = "em_user_profile_edit_cover";
    private static final String DTREPORT_KEY_LOCAL = "em_user_profile_edit_local";
    private static final String DTREPORT_KEY_MORE = "em_user_profile_edit_more";
    private static final String DTREPORT_KEY_NAME = "em_user_profile_edit_name";
    private static final String DTREPORT_KEY_SEX = "em_user_profile_edit_sex";
    private static final String DTREPORT_KEY_SIGNATURE = "em_user_profile_edit_signature";
    private static final String DTREPORT_PAGE_PARAMS_PROFILE_VERSION = "profile_version";
    private static final String DTREPORT_PROFILE_EDIT_FRAGMENT = "pg_user_profile_edit";
    private static final long ITEM_HIGH_LIGHT_ANIMATION_GAP = 3000;
    private static final long ITEM_HIGH_LIGHT_DURATION = 100;
    private static final String PHOTO_PATHS = "PhotoConst.PHOTO_PATHS";
    private static final int REQUEST_CODE_SET_COVER_SUCCESS = 2002;
    private static final int REQUEST_CODE_SIGNATURE = 1002;
    private static final String REQ_CODE_KEY = "req_code_key";
    private static final int SIGNATURE_RESULT_CODE_ERROR = 1001;
    private static final String TAG = "ProfileEditFragment";
    private static final String UPLOAD_URI_KEY = "upload_uri_key";
    private static final int[] dividerIds;
    private AgeSelectorView ageSelectorView;
    private int[] baseFieldList;
    private BirthDaySelectorView birthDaySelectorView;
    private CoverDialog coverDialog;
    private Map<Integer, Integer> fieldPrivacyMap;
    private boolean isAgeHide;
    private boolean isBirthdayHide;
    private boolean isGenderHide;
    private boolean isLocationHide;
    private final ITaskListener.Stub listener;
    private ProfileLocationActionSheet locationActionSheet;
    private Activity mActivity;
    private int mAge;
    private View mAgeLayout;
    private TextView mAgePrivacyText;
    private TextView mAgeTitle;
    private TextView mAgeTxt;
    private AllInOne mAllInOne;
    private View mAnonymousAnswerLayout;
    private TextView mAnonymousAnswerTitle;
    private BaseQQAppInterface mApp;
    private AvatarContainer mAvatarContainer;
    private int[] mBirthday;
    private View mBirthdayLayout;
    private TextView mBirthdayPrivacyText;
    private TextView mBirthdayTitle;
    private TextView mBirthdayTxt;
    private Card mCard;
    private final com.tencent.mobileqq.profilesetting.a mCardSettingObserver;
    private Context mContext;
    private byte[] mCoverData;
    private RoundCornerImageView mCoverImg;
    private View mCoverLayout;
    private final BroadcastReceiver mCoverReceiver;
    private TextView mCoverTitle;
    private TextView mCoverTxt;
    private Handler mHandler;
    private View mLocationLayout;
    private TextView mLocationPrivacyText;
    private TextView mLocationTitle;
    private TextView mLocationTxt;
    private View mMoreLayout;
    private TextView mMoreTitle;
    private View mMusicBoxLayout;
    private TextView mMusicBoxTitle;
    private View mNickNameLayout;
    private TextView mNickNameText;
    private TextView mNickNameTitle;
    private View mPersonalityLabelsLayout;
    private TextView mPersonalityLabelsTitle;
    private TextView mPersonalityLabelsTxt;
    private View mPhotoWallLayout;
    private PhotoWallObserver mPhotoWallObserver;
    private TextView mPhotoWallTitle;
    private TextView mPhotoWallTxt;
    private final ProfileCardObserver mProfileCardObserver;
    private int mSex;
    private View mSexLayout;
    private TextView mSexPrivacyText;
    private TextView mSexTitle;
    private TextView mSexTxt;
    private View mSignLayout;
    private TextView mSignTitle;
    private TextView mSignTxt;
    private final ProfileEditPrivacyHelper privacyHelper;
    private SexSelectorView sexSelectorView;
    private WinkPublishServiceProxy2 winkPublishService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment$5, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass5 extends ITaskListener.Stub {
        static IPatchRedirector $redirector_;

        AnonymousClass5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskChange$0(TaskInfo taskInfo, String str) {
            if (taskInfo.isSuccess()) {
                QLog.d(ProfileEditFragment.TAG, 1, "success");
                ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(WinkCommonUtil.getCurrentAccountLong(), taskInfo.getMissionId());
                QQToast.makeText(BaseApplication.getContext(), 2, j.d(BaseApplication.getContext().getString(R.string.f238917l2)), 1).show();
                HashMap hashMap = new HashMap();
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, str);
                VideoReport.reportEvent(EventKey.ACT, ProfileEditFragment.this.getView(), hashMap);
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.hit, 1).show();
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(final TaskInfo taskInfo) {
            final String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskInfo);
                return;
            }
            if (!taskInfo.isFinish()) {
                return;
            }
            QLog.d(ProfileEditFragment.TAG, 1, "isFinish true");
            Bundle transParams = taskInfo.getTransParams();
            if (transParams == null || (string = transParams.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, null)) == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileEditFragment.AnonymousClass5.this.lambda$onTaskChange$0(taskInfo, string);
                }
            });
        }
    }

    /* loaded from: classes16.dex */
    public interface OnLocationUpdateListener {
        void onLocationStrUpdate(String str, String[] strArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            dividerIds = new int[]{R.id.f165049uq1, R.id.f165050uq2, R.id.f165051uq3, R.id.f165052uq4, R.id.uq5, R.id.uq6, R.id.uq7};
        }
    }

    public ProfileEditFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isGenderHide = false;
        this.isAgeHide = false;
        this.isBirthdayHide = false;
        this.isLocationHide = false;
        this.baseFieldList = new int[]{41611, 41610, 41607, 41614};
        this.fieldPrivacyMap = new HashMap();
        this.privacyHelper = new ProfileEditPrivacyHelper();
        this.mPhotoWallObserver = new PhotoWallObserver() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
            protected void onDelQZonePhotoWall(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileEditFragment.TAG, 2, String.format("onDelQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str));
                }
                ProfileEditFragment.this.freshQZonePhotoWall();
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
            protected void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar, str2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileEditFragment.TAG, 2, String.format("onGetQZonePhotoWall isSuc=%s uin=%s", Boolean.valueOf(z16), str2));
                }
                ProfileEditFragment.this.updatePhotoWall(mobile_sub_get_photo_wall_rspVar);
            }
        };
        this.mProfileCardObserver = new ProfileCardObserver() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            public void onGetProfileDetail(boolean z16, String str, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
                    return;
                }
                super.onGetProfileDetail(z16, str, card);
                if (z16 && card != null && Utils.p(ProfileEditFragment.this.mApp.getCurrentAccountUin(), card.uin)) {
                    ProfileEditFragment.this.mApp.runOnUiThread(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.2.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$profileCard;

                        {
                            this.val$profileCard = card;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) card);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileEditFragment.this.updateData(this.val$profileCard);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onSetProfileDetail(boolean z16, int i3, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), card);
                } else if (z16 && card != null && Utils.p(ProfileEditFragment.this.mApp.getCurrentAccountUin(), card.uin)) {
                    ProfileEditFragment.this.mApp.runOnUiThread(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.2.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$profileCard;

                        {
                            this.val$profileCard = card;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) card);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileEditFragment.this.updateData(this.val$profileCard);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
        this.mCoverReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList<String> stringArrayListExtra;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (IProfileCardConst.ACTION_COVER_FROM_PHOTO_EDIT.equals(intent.getAction()) && (stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS")) != null && stringArrayListExtra.size() > 0) {
                    intent.putExtra(ProfileEditFragment.REQ_CODE_KEY, 1025);
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).onResultOfRequestCustomCover(-1, intent);
                    ProfileEditFragment.this.mCoverImg.setImageDrawable(Drawable.createFromPath(stringArrayListExtra.get(0)));
                    ProfileEditFragment.this.mCoverImg.setVisibility(0);
                    ProfileEditFragment.this.mCoverTxt.setVisibility(8);
                }
            }
        };
        this.mCardSettingObserver = new com.tencent.mobileqq.profilesetting.a() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilesetting.a
            public void onGetCardDisplaySetting(boolean z16, String str, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(ProfileEditFragment.TAG, 2, "onGetCardDisplaySetting isSuccess=" + z16 + " uin=" + str);
                }
                if (TextUtils.equals(ProfileEditFragment.this.mApp.getCurrentAccountUin(), str) && z16) {
                    ProfileEditFragment.this.mApp.runOnUiThread(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.4.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$card;

                        {
                            this.val$card = card;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) card);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileEditFragment.this.updateData(this.val$card);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.profilesetting.a
            public void onSetCardDisplaySetting(boolean z16, String str, Card card, ArrayList<ReqSetSettingItem> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str, card, arrayList);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(ProfileEditFragment.TAG, 2, "onSetCardDisplaySetting isSuccess=" + z16 + " uin=" + str);
                }
                if (!TextUtils.equals(ProfileEditFragment.this.mApp.getCurrentAccountUin(), str)) {
                    return;
                }
                if (!z16) {
                    QQToast.makeText(ProfileEditFragment.this.mContext, R.string.huv, 0).show();
                    return;
                }
                if (arrayList != null) {
                    Iterator<ReqSetSettingItem> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ReqSetSettingItem next = it.next();
                        ProfileEditFragment.this.fieldPrivacyMap.put(Integer.valueOf(next.a()), Integer.valueOf(next.c()));
                    }
                }
                ProfileEditFragment.this.mApp.runOnUiThread(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.4.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Card val$card;

                    {
                        this.val$card = card;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) card);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            ProfileEditFragment.this.updateData(this.val$card);
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        };
        this.winkPublishService = null;
        this.listener = new AnonymousClass5();
    }

    private void adaptEmptyItemFold() {
        int i3;
        int i16;
        View findViewById = findViewById(R.id.xnj);
        ProfileCardFeatureSwitch profileCardFeatureSwitch = ProfileCardFeatureSwitch.INSTANCE;
        int i17 = 0;
        if (profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        View findViewById2 = findViewById(R.id.xnk);
        if (profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        findViewById2.setVisibility(i16);
        View findViewById3 = findViewById(R.id.xnl);
        if (!profileCardFeatureSwitch.isMusicBoxEmptyItemFoldEnable()) {
            i17 = 8;
        }
        findViewById3.setVisibility(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCoverDialog() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (ProfileEditFragment.this.coverDialog != null) {
                    ProfileEditFragment.this.coverDialog.dismiss();
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDoubleHighLight() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null || !intent.getBooleanExtra(IProfileCardConst.PROFILE_JUMP_WITH_BUBBLE, false)) {
            return;
        }
        doubleHighLight(getHighLightViews(intent));
    }

    private void doubleHighLight(List<View> list) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(resetHighLightAnimate(list)).after(3000L).after(highLightAnimate(list));
        animatorSet.start();
    }

    private void dtReportElement(Object obj, String str) {
        if (obj == null) {
            return;
        }
        VideoReport.setElementId(obj, str);
        VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", obj, null);
    }

    private <T extends View> T findViewById(int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freshQZonePhotoWall() {
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            ((PhotoWallHandler) baseQQAppInterface.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(this.mApp.getCurrentAccountUin(), "");
        }
    }

    private Map<String, String> getElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("profile_version", "2");
        return hashMap;
    }

    private List<View> getHighLightViews(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent == null) {
            return arrayList;
        }
        int intExtra = intent.getIntExtra(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 0);
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra == 3) {
                    arrayList.add(this.mPhotoWallLayout);
                    arrayList.add(this.mPersonalityLabelsLayout);
                }
            } else {
                arrayList.add(this.mPersonalityLabelsLayout);
            }
        } else {
            arrayList.add(this.mPhotoWallLayout);
        }
        return arrayList;
    }

    private int getPrivacy(int i3) {
        Integer num = this.fieldPrivacyMap.get(Integer.valueOf(i3));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPrivacyInfo() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 : this.baseFieldList) {
            int profileSettingStateFromCard = ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(i3, this.mCard);
            if (profileSettingStateFromCard == -1) {
                arrayList.add(Integer.valueOf(profileSettingStateFromCard));
            } else {
                this.fieldPrivacyMap.put(Integer.valueOf(i3), Integer.valueOf(profileSettingStateFromCard));
            }
        }
        if (arrayList.size() > 0) {
            ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).requestProfileSettingState(this.mApp, arrayList);
        }
        updatePrivacyText();
    }

    private Animator highLightAnimate(List<View> list) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(this.mContext.getResources().getColor(R.color.c9b), this.mContext.getResources().getColor(R.color.c9c));
        ofArgb.setDuration(100L);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ List val$views;

            {
                this.val$views = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this, (Object) list);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                Iterator it = this.val$views.iterator();
                while (it.hasNext() && (view = (View) it.next()) != null) {
                    view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        return ofArgb;
    }

    private void initDtReport() {
        if (this.titleRoot == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, DTREPORT_PROFILE_EDIT_FRAGMENT);
        VideoReport.setPageParams(this.titleRoot, new PageParams(getElementParams()));
        VideoReport.setPageContentId(this.titleRoot, ProfileEditFragment.class.getName());
        dtReportElement(this.mAvatarContainer, DTREPORT_KEY_AVATAR);
        dtReportElement(this.mNickNameLayout, DTREPORT_KEY_NAME);
        dtReportElement(this.mCoverLayout, DTREPORT_KEY_COVER);
        dtReportElement(this.mSignLayout, DTREPORT_KEY_SIGNATURE);
        dtReportElement(this.mSexLayout, DTREPORT_KEY_SEX);
        dtReportElement(this.mAgeLayout, DTREPORT_KEY_AGE);
        dtReportElement(this.mBirthdayLayout, DTREPORT_KEY_BIRTH);
        dtReportElement(this.mLocationLayout, DTREPORT_KEY_LOCAL);
        dtReportElement(this.mMoreLayout, DTREPORT_KEY_MORE);
        dtReportElement(this.mPersonalityLabelsLayout, DTDTREPORT_KEY_EDIT_TAG);
        dtReportElement(this.mPhotoWallLayout, DTDTREPORT_KEY_EDIT_PICTURE);
        dtReportElement(this.mAnonymousAnswerLayout, DTDTREPORT_KEY_EDIT_QUESTION);
        dtReportElement(this.mMusicBoxLayout, DTDTREPORT_KEY_EDIT_MUSICBOX);
    }

    private void initUI() {
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setBackgroundDrawable(null);
        this.mLeftBackIcon.setImageDrawable(getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_01_selector));
        View findViewById = this.titleRoot.findViewById(R.id.e89);
        if (findViewById != null) {
            findViewById.setContentDescription(getResources().getString(R.string.rgh));
        }
        findViewById(R.id.m78);
        AvatarContainer avatarContainer = (AvatarContainer) findViewById(R.id.f164548a32);
        this.mAvatarContainer = avatarContainer;
        avatarContainer.setOnClickListener(this);
        this.mAvatarContainer.onCreate(this.mApp, getQBaseActivity(), this.mAllInOne);
        AccessibilityUtil.d(this.mAvatarContainer, Button.class.getName());
        this.mCoverLayout = findViewById(R.id.u_y);
        this.mCoverTitle = (TextView) findViewById(R.id.u_z);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.bb6);
        this.mCoverImg = roundCornerImageView;
        roundCornerImageView.setCorner(ViewUtils.dpToPx(2.0f));
        this.mCoverTxt = (TextView) findViewById(R.id.bbb);
        this.mCoverLayout.setOnClickListener(this);
        updateCover();
        View findViewById2 = findViewById(R.id.ivn);
        this.mSignLayout = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mSignTitle = (TextView) findViewById(R.id.f85334oo);
        this.mSignTxt = (TextView) findViewById(R.id.iw9);
        updateSign(null);
        View findViewById3 = findViewById(R.id.f9y);
        this.mNickNameLayout = findViewById3;
        findViewById3.setOnClickListener(this);
        this.mNickNameTitle = (TextView) findViewById(R.id.zre);
        this.mNickNameText = (TextView) findViewById(R.id.zrf);
        updateNickName(null);
        View findViewById4 = findViewById(R.id.iqg);
        this.mSexLayout = findViewById4;
        findViewById4.setOnClickListener(this);
        this.mSexTitle = (TextView) findViewById(R.id.f83994l2);
        this.mSexTxt = (TextView) findViewById(R.id.iqh);
        this.mSexPrivacyText = (TextView) findViewById(R.id.f84004l3);
        updateSex(-1);
        View findViewById5 = findViewById(R.id.f164063ix);
        this.mAgeLayout = findViewById5;
        findViewById5.setOnClickListener(this);
        this.mAgeTitle = (TextView) findViewById(R.id.sf6);
        this.mAgeTxt = (TextView) findViewById(R.id.sf8);
        this.mAgePrivacyText = (TextView) findViewById(R.id.sf7);
        View findViewById6 = findViewById(R.id.t89);
        this.mBirthdayLayout = findViewById6;
        findViewById6.setOnClickListener(this);
        this.mBirthdayTitle = (TextView) findViewById(R.id.t8_);
        this.mBirthdayTxt = (TextView) findViewById(R.id.t8b);
        this.mBirthdayPrivacyText = (TextView) findViewById(R.id.t8a);
        updateAgeAndBirthday(0);
        View findViewById7 = findViewById(R.id.egi);
        this.mLocationLayout = findViewById7;
        findViewById7.setOnClickListener(this);
        this.mLocationTitle = (TextView) findViewById(R.id.yth);
        this.mLocationTxt = (TextView) findViewById(R.id.ego);
        this.mLocationPrivacyText = (TextView) findViewById(R.id.ytl);
        updateLocation(null);
        if (getQBaseActivity().getIntent().getBooleanExtra(IProfileCardConst.KEY_SHOW_ACTION_SHEET, false)) {
            this.mAvatarContainer.showActionSheet();
        }
        View findViewById8 = findViewById(R.id.f242508m);
        this.mPersonalityLabelsLayout = findViewById8;
        findViewById8.setOnClickListener(this);
        this.mPersonalityLabelsTitle = (TextView) findViewById(R.id.f242608n);
        this.mPersonalityLabelsTxt = (TextView) findViewById(R.id.f242708o);
        updatePersonalityLabels();
        this.mPersonalityLabelsLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileEditFragment.this.doDoubleHighLight();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 100L);
        View findViewById9 = findViewById(R.id.fqu);
        this.mPhotoWallLayout = findViewById9;
        findViewById9.setOnClickListener(this);
        this.mPhotoWallTitle = (TextView) findViewById(R.id.f247009u);
        this.mPhotoWallTxt = (TextView) findViewById(R.id.f247109v);
        updatePhotoWall(null);
        View findViewById10 = findViewById(R.id.f164338sq1);
        this.mAnonymousAnswerLayout = findViewById10;
        findViewById10.setOnClickListener(this);
        this.mAnonymousAnswerTitle = (TextView) findViewById(R.id.f164339sq2);
        View findViewById11 = findViewById(R.id.f166355zk0);
        this.mMusicBoxLayout = findViewById11;
        findViewById11.setOnClickListener(this);
        this.mMusicBoxTitle = (TextView) findViewById(R.id.f166356zk1);
        this.mMoreLayout = findViewById(R.id.f0b);
        this.mMoreTitle = (TextView) findViewById(R.id.zeu);
        this.mMoreLayout.setOnClickListener(this);
        this.privacyHelper.addView(41611, this.mSexTxt).addView(41610, this.mAgeTxt).addView(41607, this.mBirthdayTxt).addView(41614, this.mLocationTxt);
        adaptEmptyItemFold();
    }

    private void jump2AnonymousAnswerPage() {
        BaseQQAppInterface baseQQAppInterface;
        if (getActivity() != null && (baseQQAppInterface = this.mApp) != null) {
            AnonymousViewHelper.jumpToQuestionListAndAnswer(getActivity(), baseQQAppInterface.getCurrentAccountUin(), 1);
        }
    }

    private void jump2MusicBoxPage() {
        BaseQQAppInterface baseQQAppInterface;
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && (baseQQAppInterface = this.mApp) != null) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).jump2MusicBoxPage(getActivity(), baseQQAppInterface.getCurrentAccountUin());
        }
    }

    private void jump2PersonalityLabelEditPage() {
        BaseQQAppInterface baseQQAppInterface;
        if (getActivity() != null && (baseQQAppInterface = this.mApp) != null) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).jump2PersonalityLabelEditPage(getActivity(), baseQQAppInterface.getCurrentAccountUin());
        }
    }

    private void jump2PhotoWallEditPage() {
        if (getActivity() != null && this.mApp != null) {
            String str = IProfileCardConst.URL_PHOTO_WALL;
            Intent intent = new Intent();
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("url", str);
            RouteUtils.startActivityForResult(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerAvatarPublishListener$0(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        QLog.d(TAG, 1, "bind success :$service");
        winkPublishServiceProxy2.addTaskListener(this.listener);
        this.winkPublishService = winkPublishServiceProxy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onActionSheetButtonClick(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).chooseFromTakingPics(getQBaseActivity(), this.mApp);
                    return;
                }
                return;
            }
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).chooseFromGallery(getQBaseActivity(), this.mApp);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_personal_album_enter_model", 2);
        bundle.putInt("_input_max", 1);
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, true);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this.mApp.getCurrentAccountUin();
        bundle.putString("keyAction", "actionSelectPicture");
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
        QZoneHelper.forwardToPersonalAlbumSelect(getQBaseActivity(), userInfo, bundle, 1020);
    }

    private void onClickAge() {
        if (this.ageSelectorView == null) {
            AgeSelectorView ageSelectorView = new AgeSelectorView(getActivity());
            this.ageSelectorView = ageSelectorView;
            ageSelectorView.setTitle("\u9009\u62e9\u5e74\u9f84");
        }
        AgeSelectorView ageSelectorView2 = this.ageSelectorView;
        int[] iArr = this.mBirthday;
        ageSelectorView2.init(iArr[0], iArr[1], iArr[2]);
        this.ageSelectorView.setPrivacy(getPrivacy(41610));
        if (this.ageSelectorView.getOnActionSheetListener() == null) {
            this.ageSelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.18
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    ProfileEditFragment profileEditFragment = ProfileEditFragment.this;
                    profileEditFragment.isAgeHide = profileEditFragment.ageSelectorView.isHide();
                    if (!ProfileEditFragment.this.isAgeHide) {
                        int birthdayCode = ProfileEditFragment.this.ageSelectorView.getBirthdayCode();
                        int[] parseBirthdayCode = ProfileEditDateUtils.parseBirthdayCode(birthdayCode);
                        if (ProfileEditDateUtils.checkBirthDayValid(parseBirthdayCode[0], parseBirthdayCode[1], parseBirthdayCode[2])) {
                            ProfileEditFragment.this.mBirthday = parseBirthdayCode;
                            ProfileEditFragment profileEditFragment2 = ProfileEditFragment.this;
                            profileEditFragment2.mAge = ProfileEditDateUtils.getAge(profileEditFragment2.mBirthday[0], ProfileEditFragment.this.mBirthday[1], ProfileEditFragment.this.mBirthday[2]);
                            Bundle bundle = new Bundle();
                            bundle.putInt("birthday", birthdayCode);
                            bundle.putInt("age", ProfileEditFragment.this.mAge);
                            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setDetailUserInfo(ProfileEditFragment.this.mApp, bundle);
                        } else {
                            QQToastUtil.showQQToastInUiThread(1, ProfileEditFragment.BIRTHDAY_SET_ERROR_MESSAGE);
                            ProfileEditFragment.this.dismissCoverDialog();
                            return;
                        }
                    } else {
                        ProfileEditFragment.this.privacyHelper.onHide(41610);
                    }
                    ProfileEditFragment.this.dismissCoverDialog();
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.dismissCoverDialog();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (this.ageSelectorView.getOnPrivacyListener() == null) {
            this.ageSelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.19
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public void onConfirm(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.setPrivacy(41610, i3);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                }
            });
        }
        showCoverDialog();
        this.ageSelectorView.show();
    }

    private void onClickBirthday() {
        if (this.birthDaySelectorView == null) {
            BirthDaySelectorView birthDaySelectorView = new BirthDaySelectorView(getActivity());
            this.birthDaySelectorView = birthDaySelectorView;
            birthDaySelectorView.setTitle("\u9009\u62e9\u751f\u65e5");
        }
        BirthDaySelectorView birthDaySelectorView2 = this.birthDaySelectorView;
        int[] iArr = this.mBirthday;
        birthDaySelectorView2.init(iArr[0], iArr[1], iArr[2]);
        this.birthDaySelectorView.setPrivacy(getPrivacy(41607));
        if (this.birthDaySelectorView.getOnActionSheetListener() == null) {
            this.birthDaySelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.20
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    ProfileEditFragment profileEditFragment = ProfileEditFragment.this;
                    profileEditFragment.isBirthdayHide = profileEditFragment.birthDaySelectorView.isHide();
                    if (!ProfileEditFragment.this.isBirthdayHide) {
                        int birthdayCode = ProfileEditFragment.this.birthDaySelectorView.getBirthdayCode();
                        int[] parseBirthdayCode = ProfileEditDateUtils.parseBirthdayCode(birthdayCode);
                        if (ProfileEditDateUtils.checkBirthDayValid(parseBirthdayCode[0], parseBirthdayCode[1], parseBirthdayCode[2])) {
                            ProfileEditFragment.this.mBirthday = parseBirthdayCode;
                            ProfileEditFragment profileEditFragment2 = ProfileEditFragment.this;
                            profileEditFragment2.mAge = ProfileEditDateUtils.getAge(profileEditFragment2.mBirthday[0], ProfileEditFragment.this.mBirthday[1], ProfileEditFragment.this.mBirthday[2]);
                            Bundle bundle = new Bundle();
                            bundle.putInt("birthday", birthdayCode);
                            bundle.putInt("age", ProfileEditFragment.this.mAge);
                            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setDetailUserInfo(ProfileEditFragment.this.mApp, bundle);
                        } else {
                            QQToastUtil.showQQToastInUiThread(1, ProfileEditFragment.BIRTHDAY_SET_ERROR_MESSAGE);
                            ProfileEditFragment.this.dismissCoverDialog();
                            return;
                        }
                    } else {
                        ProfileEditFragment.this.privacyHelper.onHide(41607);
                    }
                    ProfileEditFragment.this.dismissCoverDialog();
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.dismissCoverDialog();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (this.birthDaySelectorView.getOnPrivacyListener() == null) {
            this.birthDaySelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.21
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public void onConfirm(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.setPrivacy(41607, i3);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                }
            });
        }
        showCoverDialog();
        this.birthDaySelectorView.show();
    }

    private void onClickCover() {
        if (this.mCoverTxt.getVisibility() == 8 && this.mCoverImg.getVisibility() == 0) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).previewProfileCover(getQBaseActivity(), this.mCard);
            return;
        }
        ActionSheet create = ActionSheet.create(getContext());
        create.addButton(R.string.f159881ti);
        create.addButton(R.string.f159861tg);
        create.addButton(R.string.f159871th);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener(create) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ ActionSheet val$actionSheet;

            {
                this.val$actionSheet = create;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this, (Object) create);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileEditFragment.this.onActionSheetButtonClick(i3);
                    this.val$actionSheet.dismiss();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                }
            }
        });
        create.setOnBottomCancelListener(new View.OnClickListener(create) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.12
            static IPatchRedirector $redirector_;
            final /* synthetic */ ActionSheet val$actionSheet;

            {
                this.val$actionSheet = create;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this, (Object) create);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ReportController.o(ProfileEditFragment.this.mApp, "dc00898", "", "", "0X800A88C", "0X800A88C", 4, 0, "1", "", "", "");
                    this.val$actionSheet.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        create.show();
    }

    private void onClickLocation() {
        if (this.mCard == null) {
            return;
        }
        OnLocationUpdateListener onLocationUpdateListener = new OnLocationUpdateListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.OnLocationUpdateListener
            public void onLocationStrUpdate(String str, String[] strArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ProfileEditFragment.this.updateLocation(str);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) strArr);
                }
            }
        };
        ProfileLocationActionSheet profileLocationActionSheet = new ProfileLocationActionSheet();
        this.locationActionSheet = profileLocationActionSheet;
        profileLocationActionSheet.init(getQBaseActivity(), this.mApp, this.mCard, onLocationUpdateListener);
        if (this.locationActionSheet.getOnPrivacyListener() == null) {
            this.locationActionSheet.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public void onConfirm(int i3) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.setPrivacy(41614, i3);
                        ProfileEditFragment profileEditFragment = ProfileEditFragment.this;
                        if (i3 == 2) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        profileEditFragment.isLocationHide = z16;
                        if (ProfileEditFragment.this.isLocationHide) {
                            ProfileEditFragment.this.privacyHelper.onHide(41614);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
            });
        }
        this.locationActionSheet.setPrivacy(getPrivacy(41614));
        this.locationActionSheet.show();
    }

    private void onClickSex() {
        if (this.sexSelectorView == null) {
            SexSelectorView sexSelectorView = new SexSelectorView(getActivity());
            this.sexSelectorView = sexSelectorView;
            sexSelectorView.setTitle("\u9009\u62e9\u6027\u522b");
        }
        this.sexSelectorView.init(this.mSex);
        this.sexSelectorView.setPrivacy(getPrivacy(41611));
        if (this.sexSelectorView.getOnActionSheetListener() == null) {
            this.sexSelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.16
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    ProfileEditFragment profileEditFragment = ProfileEditFragment.this;
                    profileEditFragment.isGenderHide = profileEditFragment.sexSelectorView.isHide();
                    if (!ProfileEditFragment.this.isGenderHide) {
                        ProfileEditFragment profileEditFragment2 = ProfileEditFragment.this;
                        profileEditFragment2.mSex = profileEditFragment2.sexSelectorView.getSex();
                        ProfileEditFragment profileEditFragment3 = ProfileEditFragment.this;
                        profileEditFragment3.updateSex(profileEditFragment3.mSex);
                        Bundle bundle = new Bundle();
                        bundle.putByte("sex", (byte) ProfileEditFragment.this.mSex);
                        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setDetailUserInfo(ProfileEditFragment.this.mApp, bundle);
                    } else {
                        ProfileEditFragment.this.privacyHelper.onHide(41611);
                    }
                    ProfileEditFragment.this.dismissCoverDialog();
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.dismissCoverDialog();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (this.sexSelectorView.getOnPrivacyListener() == null) {
            this.sexSelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.17
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public void onConfirm(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditFragment.this.setPrivacy(41611, i3);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    }
                }
            });
        }
        showCoverDialog();
        this.sexSelectorView.show();
    }

    private void preLoadData() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).preLoadModelData(this.mApp);
    }

    private void registerAvatarPublishListener() {
        WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.mobileqq.profilecard.fragment.b
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                ProfileEditFragment.this.lambda$registerAvatarPublishListener$0(winkPublishServiceProxy2);
            }
        });
    }

    private Animator resetHighLightAnimate(List<View> list) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(this.mContext.getResources().getColor(R.color.c9c), this.mContext.getResources().getColor(R.color.c9b));
        ofArgb.setDuration(100L);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ List val$views;

            {
                this.val$views = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this, (Object) list);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                Iterator it = this.val$views.iterator();
                while (it.hasNext() && (view = (View) it.next()) != null) {
                    view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        return ofArgb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrivacy(int i3, int i16) {
        int privacy = getPrivacy(i3);
        ArrayList<ReqSetSettingItem> arrayList = new ArrayList<>();
        arrayList.add(new ReqSetSettingItem(i3, privacy, i16));
        ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).requestSetCardDisplaySetting(this.mApp, arrayList);
    }

    private void showCoverDialog() {
        if (this.coverDialog == null) {
            this.coverDialog = new CoverDialog(this.mContext);
        }
        this.coverDialog.show();
    }

    private void unregisterAvatarPublishListener() {
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.winkPublishService;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(this.listener);
        }
    }

    private void updateAgeAndBirthday(int i3) {
        if (i3 != 0) {
            this.mBirthday = ProfileEditDateUtils.parseBirthdayCode(i3);
        } else {
            this.mBirthday = ProfileEditDateUtils.getDefaultBirthday();
        }
        int[] iArr = this.mBirthday;
        int age = ProfileEditDateUtils.getAge(iArr[0], iArr[1], iArr[2]);
        this.mAge = age;
        String valueOf = String.valueOf(age);
        updateTextView(this.mAgeTxt, valueOf);
        String str = "";
        if (this.mAge == 0) {
            valueOf = "";
        }
        String privacyText = PrivacyTextUtils.getPrivacyText(getPrivacy(41610));
        updateItemContentDescription(this.mAgeLayout, this.mAgeTxt, this.mContext.getString(R.string.d0j), valueOf.concat("\uff0c" + privacyText));
        String str2 = this.mBirthday[1] + "\u6708" + this.mBirthday[2] + "\u65e5";
        updateTextView(this.mBirthdayTxt, str2);
        if (i3 != 0) {
            str = str2;
        }
        String privacyText2 = PrivacyTextUtils.getPrivacyText(getPrivacy(41607));
        updateItemContentDescription(this.mBirthdayLayout, this.mBirthdayTxt, this.mContext.getString(R.string.f175332y_), str.concat("\uff0c" + privacyText2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateCover() {
        boolean z16;
        Card card = this.mCard;
        String str = null;
        if (card != null && !card.isNoCover()) {
            byte[] bArr = this.mCoverData;
            if (bArr != null && this.mCard.checkCoverUrl(bArr)) {
                this.mCard.updateCoverData(this.mCoverData);
            }
            str = (String) this.mCard.getCoverData(0)[0];
            z16 = true;
            QLog.d(TAG, 1, "coverUrl = " + str);
        }
        z16 = false;
        if (!z16) {
            this.mCoverImg.setVisibility(8);
            this.mCoverTxt.setVisibility(0);
            updateItemContentDescription(this.mCoverLayout, this.mCoverTxt, this.mContext.getString(R.string.zoy), (String) this.mCoverTxt.getText());
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.mCoverImg.getWidth();
        obtain.mRequestHeight = this.mCoverImg.getHeight();
        this.mCoverImg.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        this.mCoverImg.setVisibility(0);
        this.mCoverTxt.setVisibility(8);
        updateItemContentDescription(this.mCoverLayout, this.mCoverImg, this.mContext.getString(R.string.zoy), this.mContext.getString(R.string.zoy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateData(Card card) {
        if (card == null) {
            return;
        }
        this.mCard = card;
        this.mAvatarContainer.updateAvatar();
        updateNickName(card.strNick);
        updateSign(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getRichStatus(card));
        updateSex(card.shGender);
        updateAgeAndBirthday((int) card.lBirthday);
        updateLocation(card.strLocationDesc);
        updateCover();
        updatePrivacyText();
        updatePersonalityLabels();
        freshQZonePhotoWall();
    }

    private void updateDivider(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = dividerIds;
            if (i16 < iArr.length) {
                findViewById(iArr[i16]).setBackgroundColor(i3);
                i16++;
            } else {
                return;
            }
        }
    }

    private void updateItemContentDescription(View view, View view2, String str, String str2) {
        String str3 = str + "," + str2 + ",";
        view.setContentDescription(str3);
        if (view2 instanceof EditText) {
            str3 = str + HardCodeUtil.qqStr(R.string.ztq) + str2 + ",";
        }
        view2.setContentDescription(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(String str) {
        boolean z16 = true;
        QLog.i(TAG, 1, "updateLocation " + str + " " + QLog.getStackTraceString(new Throwable()));
        if (!TextUtils.isEmpty(str) && !str.equals(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getNoLimitText())) {
            z16 = false;
        } else {
            str = this.mContext.getString(R.string.d27);
        }
        updateTextView(this.mLocationTxt, str);
        if (z16) {
            str = "";
        }
        String privacyText = PrivacyTextUtils.getPrivacyText(getPrivacy(41614));
        updateItemContentDescription(this.mLocationLayout, this.mLocationTxt, this.mContext.getString(R.string.d28), str.concat("\uff0c" + privacyText));
    }

    private void updateNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mNickNameText.setText(str);
        updateItemContentDescription(this.mNickNameLayout, this.mNickNameText, this.mContext.getString(R.string.nickname), str);
    }

    private void updatePersonalityLabels() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (this.mCard == null) {
            updateTextView(this.mPersonalityLabelsTxt, context.getString(R.string.f237317gq));
            return;
        }
        String loadPersonalityLabels = ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadPersonalityLabels(this.mCard);
        if (TextUtils.isEmpty(loadPersonalityLabels)) {
            updateTextView(this.mPersonalityLabelsTxt, this.mContext.getString(R.string.f237317gq));
        } else {
            updateTextView(this.mPersonalityLabelsTxt, loadPersonalityLabels);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePhotoWall(mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        ArrayList<PhotoWall> arrayList;
        if (this.mContext == null) {
            return;
        }
        if (mobile_sub_get_photo_wall_rspVar != null && (arrayList = mobile_sub_get_photo_wall_rspVar.vecUrls) != null && arrayList.size() != 0) {
            updateTextView(this.mPhotoWallTxt, String.format("%d\u5f20", Integer.valueOf(mobile_sub_get_photo_wall_rspVar.vecUrls.size())));
        } else {
            updateTextView(this.mPhotoWallTxt, this.mContext.getString(R.string.f237317gq));
        }
    }

    private void updatePrivacyText() {
        if (this.fieldPrivacyMap.size() == 0) {
            return;
        }
        for (int i3 : this.baseFieldList) {
            int privacy = getPrivacy(i3);
            if (privacy == 2) {
                this.privacyHelper.onHide(i3);
            }
            String privacyText = PrivacyTextUtils.getPrivacyText(privacy);
            switch (i3) {
                case 41607:
                    updateTextView(this.mBirthdayPrivacyText, privacyText);
                    break;
                case 41610:
                    updateTextView(this.mAgePrivacyText, privacyText);
                    break;
                case 41611:
                    updateTextView(this.mSexPrivacyText, privacyText);
                    break;
                case 41614:
                    updateTextView(this.mLocationPrivacyText, privacyText);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSex(int i3) {
        this.mSex = i3;
        String string = this.mContext.getString(R.string.f171199d31);
        if (i3 == 0) {
            string = this.mContext.getString(R.string.c7_);
        } else if (i3 == 1) {
            string = this.mContext.getString(R.string.b5e);
        }
        updateTextView(this.mSexTxt, string);
        if (i3 != 0 && i3 != 1) {
            string = "";
        }
        String privacyText = PrivacyTextUtils.getPrivacyText(getPrivacy(41611));
        updateItemContentDescription(this.mSexLayout, this.mSexTxt, this.mContext.getString(R.string.f171200d32), string.concat("\uff0c" + privacyText));
    }

    private void updateSign(RichStatus richStatus) {
        String qqStr;
        if (richStatus != null) {
            qqStr = richStatus.toSpannableString("").toString();
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f173154hn3);
        }
        updateTextView(this.mSignTxt, qqStr);
        updateItemContentDescription(this.mSignLayout, this.mSignTxt, this.mContext.getString(R.string.f175532yt), qqStr);
    }

    private void updateTextView(TextView textView, CharSequence charSequence) {
        updateTextView(textView, charSequence, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initUI();
        preLoadData();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h0b;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            intent = new Intent();
        }
        if (i3 == 1020) {
            if (i16 == -1) {
                intent.putExtra(REQ_CODE_KEY, i3);
                ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).onResultOfRequestCustomCover(i16, intent);
                return;
            }
            return;
        }
        if (i3 == 1021) {
            if (i16 == -1) {
                intent.putExtra(REQ_CODE_KEY, i3);
                intent.putExtra(UPLOAD_URI_KEY, ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getUpLoadUrl());
                ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).onResultOfRequestCustomCover(i16, intent);
                return;
            }
            return;
        }
        if (i3 == 5) {
            if (i16 == -1) {
                this.mAvatarContainer.startCropPhoto();
                return;
            }
            return;
        }
        if (i3 == 1002) {
            if (i16 != 1001) {
                ((IProfileProtocolService) this.mApp.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
            }
        } else if (i3 == 1034) {
            if (i16 == -1) {
                updateNickName(intent.getStringExtra("result"));
            }
        } else if (i3 == 100) {
            freshQZonePhotoWall();
        } else if (i3 == 1029 && i16 == -1) {
            updatePersonalityLabels(intent.getStringExtra(IProfileCardConst.KEY_PERSONALITY_LABEL_GALLERY_RESULT));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (!u.a().b()) {
            int id5 = view.getId();
            if (id5 == R.id.f0b) {
                VideoReport.reportEvent("dt_clck", this.mMoreLayout, null);
                QPublicFragmentActivity.start(getContext(), getActivity().getIntent(), ProfileCardNewMoreFragment.class);
            } else if (id5 == R.id.u_y) {
                VideoReport.reportEvent("dt_clck", this.mCoverLayout, null);
                onClickCover();
            } else if (id5 == R.id.f164548a32) {
                VideoReport.reportEvent("dt_clck", this.mAvatarContainer, null);
                this.mAvatarContainer.showActionSheet();
            } else if (id5 == R.id.iqg) {
                VideoReport.reportEvent("dt_clck", this.mSexLayout, null);
                onClickSex();
            } else if (id5 == R.id.f164063ix) {
                VideoReport.reportEvent("dt_clck", this.mAgeLayout, null);
                onClickAge();
            } else if (id5 == R.id.t89) {
                VideoReport.reportEvent("dt_clck", this.mBirthdayLayout, null);
                onClickBirthday();
            } else if (id5 == R.id.egi) {
                VideoReport.reportEvent("dt_clck", this.mLocationLayout, null);
                onClickLocation();
            } else if (id5 == R.id.ivn) {
                VideoReport.reportEvent("dt_clck", this.mSignLayout, null);
                ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).enterSignaturePage(getQBaseActivity(), this.mApp);
            } else if (id5 == R.id.f9y) {
                if (this.mCard != null) {
                    VideoReport.reportEvent("dt_clck", this.mNickNameLayout, null);
                    IProfileEditBusinessApi iProfileEditBusinessApi = (IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class);
                    QBaseActivity qBaseActivity = getQBaseActivity();
                    Card card = this.mCard;
                    iProfileEditBusinessApi.enterNicknamePage(qBaseActivity, card.strNick, card.uin);
                }
            } else if (id5 == R.id.f242508m) {
                VideoReport.reportEvent("dt_clck", this.mPersonalityLabelsLayout, null);
                jump2PersonalityLabelEditPage();
            } else if (id5 == R.id.fqu) {
                VideoReport.reportEvent("dt_clck", this.mPhotoWallLayout, null);
                jump2PhotoWallEditPage();
            } else if (id5 == R.id.f164338sq1) {
                VideoReport.reportEvent("dt_clck", this.mAnonymousAnswerLayout, null);
                jump2AnonymousAnswerPage();
            } else if (id5 == R.id.f166355zk0) {
                VideoReport.reportEvent("dt_clck", this.mMusicBoxLayout, null);
                jump2MusicBoxPage();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) getQBaseActivity().getAppRuntime();
        this.mApp = baseQQAppInterface;
        baseQQAppInterface.addObserver(this.mProfileCardObserver);
        this.mApp.addObserver(this.mCardSettingObserver);
        this.mApp.addObserver(this.mPhotoWallObserver);
        this.mContext = getQBaseActivity();
        this.mActivity = getActivity();
        this.mHandler = new Handler(Looper.getMainLooper());
        AllInOne allInOne = (AllInOne) getQBaseActivity().getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
        this.mAllInOne = allInOne;
        if (allInOne == null) {
            this.mAllInOne = new AllInOne(this.mApp.getCurrentUin(), 0);
        }
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadAndUpdateProfileData(this.mApp, new IProfileEditBusinessApi.OnProfileCacheLoadedListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnProfileCacheLoadedListener
            public void onProfileCacheLoaded(Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) card);
                } else {
                    ProfileEditFragment.this.mApp.runOnUiThread(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.6.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$card;

                        {
                            this.val$card = card;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) card);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ProfileEditFragment.this.updateData(this.val$card);
                                ProfileEditFragment.this.getPrivacyInfo();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        });
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).initFriendProfileHelper(getQBaseActivity(), new IProfileEditBusinessApi.OnCoverUploadListener() { // from class: com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCoverUploadListener
            public void onCoverUploadSuccess(byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ProfileEditFragment.this.mCoverData = bArr;
                    ProfileEditFragment.this.updateCover();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bArr);
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IProfileCardConst.ACTION_COVER_FROM_PHOTO_EDIT);
        getContext().registerReceiver(this.mCoverReceiver, intentFilter);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mApp.removeObserver(this.mProfileCardObserver);
        this.mApp.removeObserver(this.mCardSettingObserver);
        this.mApp.removeObserver(this.mPhotoWallObserver);
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).destroyFriendProfileHelper();
        this.mAvatarContainer.onDestroy();
        getContext().unregisterReceiver(this.mCoverReceiver);
        ProfileLocationActionSheet profileLocationActionSheet = this.locationActionSheet;
        if (profileLocationActionSheet != null) {
            profileLocationActionSheet.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNewIntent(Intent intent) {
        Drawable createFromPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(REQ_CODE_KEY, 0);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (intExtra != 1020) {
            createFromPath = null;
            if (intExtra != 1021) {
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    intent.putExtra(REQ_CODE_KEY, 1025);
                    ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).onResultOfRequestCustomCover(-1, intent);
                    createFromPath = Drawable.createFromPath(stringArrayListExtra.get(0));
                }
                if (createFromPath == null) {
                    this.mCoverImg.setImageDrawable(createFromPath);
                    this.mCoverImg.setVisibility(0);
                    this.mCoverTxt.setVisibility(8);
                    return;
                }
                return;
            }
        } else {
            createFromPath = Drawable.createFromPath(intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH));
        }
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).doUploadPhoto(intent, stringArrayListExtra);
        }
        if (createFromPath == null) {
            createFromPath = Drawable.createFromPath(((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).getRealPathFromContentURI(getQBaseActivity(), (Uri) intent.getParcelableExtra(UPLOAD_URI_KEY)));
        }
        if (createFromPath == null) {
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
            unregisterAvatarPublishListener();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            registerAvatarPublishListener();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void updateTextView(TextView textView, CharSequence charSequence, int i3) {
        if (!isAdded()) {
            QLog.e(TAG, 1, "updateTextView fail, fragment is not added");
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        textView.setText(charSequence);
        textView.setContentDescription(charSequence);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private void updatePersonalityLabels(String str) {
        if (this.mContext == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            updateTextView(this.mPersonalityLabelsTxt, this.mContext.getString(R.string.f237317gq));
        } else {
            updateTextView(this.mPersonalityLabelsTxt, str);
        }
    }
}

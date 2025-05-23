package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.av.service.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.data.AddressInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.URLUtil;
import com.tencent.util.UiThreadUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class ProfileEditBusinessApiImpl implements IProfileEditBusinessApi {
    static IPatchRedirector $redirector_ = null;
    private static final int FROM_PHOTO_LIST = 11;
    private static final int FROM_SNAP_SHOT = 10;
    private static final int MAX_PERSONAL_NOTE_BYTES = 383;
    private static final String[] PERMISSIONS_TAKE_PHOTO;
    private static final int REQUEST_CODE_DEFAULT = 1000;
    private static final int REQUEST_CODE_HOMETOWN = 1006;
    private static final int REQUEST_CODE_PERSONAL_NOTE = 1007;
    private static final int REQUEST_CODE_PROFESSION = 1004;
    private static final int REQUEST_CODE_SIGNATURE = 1002;
    private static final String TAG = "ProfileEditBusinessApiImpl";
    private FriendProfilePhotoHelper mPhotoHelper;
    private Uri mUploadCoverUri;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 63)) {
            redirector.redirect((short) 63);
        } else {
            PERMISSIONS_TAKE_PHOTO = new String[]{QQPermissionConstants.Permission.CAMERA};
        }
    }

    public ProfileEditBusinessApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ConditionSearchManager.c createCsmConfigListener(IProfileEditBusinessApi.OnCheckCSMListener onCheckCSMListener) {
        return new ConditionSearchManager.c(onCheckCSMListener) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ IProfileEditBusinessApi.OnCheckCSMListener val$onCheckCSMListener;

            {
                this.val$onCheckCSMListener = onCheckCSMListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this, (Object) onCheckCSMListener);
                }
            }

            @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
            public void onGetConfig(int i3, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                } else if (!z16) {
                    this.val$onCheckCSMListener.onCheckDone(false);
                } else if (i3 == 2) {
                    this.val$onCheckCSMListener.onCheckDone(true);
                }
            }
        };
    }

    private void decodeAvatar(AppInterface appInterface, AvatarLayout avatarLayout) {
        ThreadManager.getFileThreadHandler().post(new Runnable(avatarLayout, appInterface) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ AppInterface val$app;
            final /* synthetic */ AvatarLayout val$avatarLayout;

            {
                this.val$avatarLayout = avatarLayout;
                this.val$app = appInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ProfileEditBusinessApiImpl.this, avatarLayout, appInterface);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Exception e16;
                Bitmap bitmap;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Bitmap bitmap2 = null;
                if (FaceUtil.isUploadingAvatar()) {
                    try {
                        String tempAvatarFilePath = FaceUtil.getTempAvatarFilePath();
                        File file = new File(tempAvatarFilePath);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, this.val$avatarLayout.getWidth(), this.val$avatarLayout.getHeight());
                        bufferedInputStream.close();
                        bitmap = j.d(tempAvatarFilePath, options);
                        if (bitmap != null) {
                            try {
                                bitmap = QQAppInterface.getCircleFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
                            } catch (Exception e17) {
                                e16 = e17;
                                QLog.e(ProfileEditBusinessApiImpl.TAG, 1, "decodeAvatar error", e16);
                                bitmap2 = bitmap;
                                if (bitmap2 == null) {
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("decode Avatar, bitmap is null:");
                                if (bitmap2 != null) {
                                }
                                sb5.append(z16);
                                QLog.i(ProfileEditBusinessApiImpl.TAG, 1, sb5.toString());
                            }
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        bitmap = null;
                    }
                    bitmap2 = bitmap;
                }
                if (bitmap2 == null) {
                    UiThreadUtil.runOnUiThread(new Runnable(bitmap2) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.4.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Bitmap val$faceBitMap;

                        {
                            this.val$faceBitMap = bitmap2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) bitmap2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass4.this.val$avatarLayout.setStaticAvatar(this.val$faceBitMap);
                            }
                        }
                    });
                } else {
                    ProfileEditBusinessApiImpl.this.setAvatarDrawable(this.val$app, this.val$avatarLayout);
                }
                StringBuilder sb52 = new StringBuilder();
                sb52.append("decode Avatar, bitmap is null:");
                if (bitmap2 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb52.append(z16);
                QLog.i(ProfileEditBusinessApiImpl.TAG, 1, sb52.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterSnapshot(Activity activity, BaseQQAppInterface baseQQAppInterface) {
        this.mUploadCoverUri = ProfileCardUtils.enterSnapshot(activity, 1021);
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(baseQQAppInterface.getCurrentAccountUin(), "defaultcard", "photo_takeaphoto", "", 1, 0, 0, "", "", "");
    }

    private void notifyUser(Context context, int i3, int i16) {
        new QQToastNotifier(context).notifyUser(i3, getTitleBarHeight(context), 0, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCover(byte[] bArr) {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.k(bArr);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            updateCoverEntryLayout(null);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ProfileEditBusinessApiImpl.this.updateCoverEntryLayout(null);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private void sendUserInfoChange(BaseQQAppInterface baseQQAppInterface, Context context, Bundle bundle) {
        if (!NetworkUtil.isNetSupport(context)) {
            notifyUser(context, R.string.f171139ci4, 0);
        } else if (bundle != null && !bundle.isEmpty()) {
            ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).setDetailUserInfo(baseQQAppInterface, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCoverEntryLayout(Card card) {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.m(card);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void chooseFromGallery(Activity activity, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, (Object) baseQQAppInterface);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 44);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationProfileCustomCover.F);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        int s16 = ProfileCardUtil.s(activity);
        int q16 = ProfileCardUtil.q(activity);
        intent.putExtra(PeakConstants.CLIP_WIDTH, s16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, q16);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        intent.putExtra(PeakConstants.TARGET_WIDTH, s16);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, q16);
        intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.r());
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, true);
        intent.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, IProfileCardConst.ACTION_COVER_FROM_PHOTO_EDIT);
        activity.startActivity(intent);
        QAlbumUtil.anim(activity, false, true);
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(baseQQAppInterface.getCurrentAccountUin(), "defaultcard", "photo_album", "", 1, 0, 0, "", "", "");
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void chooseFromTakingPics(AppActivity appActivity, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appActivity, (Object) baseQQAppInterface);
        } else if (appActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            QQPermissionFactory.getQQPermission(appActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.PROFILE_CARD_EDIT_PICK_COVER_PHOTO)).requestPermissions(PERMISSIONS_TAKE_PHOTO, 2, new QQPermission.BasePermissionsListener(appActivity, baseQQAppInterface) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseQQAppInterface val$app;
                final /* synthetic */ AppActivity val$appActivity;

                {
                    this.val$appActivity = appActivity;
                    this.val$app = baseQQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileEditBusinessApiImpl.this, appActivity, baseQQAppInterface);
                    }
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        super.onAllGranted();
                        ProfileEditBusinessApiImpl.this.enterSnapshot(this.val$appActivity, this.val$app);
                    }
                }
            });
        } else {
            enterSnapshot(appActivity, baseQQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public FrameLayout createAvatarLayout(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
        }
        AvatarLayout avatarLayout = new AvatarLayout(context);
        avatarLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        DynamicAvatarView dynamicAvatarView = new DynamicAvatarView(context);
        dynamicAvatarView.setId(R.id.a6e);
        dynamicAvatarView.setScaleType(ImageView.ScaleType.FIT_XY);
        avatarLayout.addView(dynamicAvatarView);
        dynamicAvatarView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        dynamicAvatarView.setImageResource(R.drawable.cop);
        avatarLayout.d(0, dynamicAvatarView, false);
        return avatarLayout;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public BusinessObserver createLBSObserver(IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 47, (Object) this, (Object) onGetUserLocationListener);
        }
        return new bh(onGetUserLocationListener) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ IProfileEditBusinessApi.OnGetUserLocationListener val$listener;

            {
                this.val$listener = onGetUserLocationListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this, (Object) onGetUserLocationListener);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.bh
            public void onGetUserLocation(boolean z16, LBSInfo lBSInfo) {
                String[] strArr;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), lBSInfo);
                    return;
                }
                super.onGetUserLocation(z16, lBSInfo);
                if (lBSInfo != null) {
                    strArr = lBSInfo.a();
                } else {
                    strArr = null;
                }
                IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener2 = this.val$listener;
                if (onGetUserLocationListener2 != null) {
                    onGetUserLocationListener2.onGetUserLocation(z16, strArr, false);
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void destroyFriendProfileHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.c();
            this.mPhotoHelper = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void destroyLocationSearchManager(BaseQQAppInterface baseQQAppInterface, Context context, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, baseQQAppInterface, context, obj);
            return;
        }
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        conditionSearchManager.o(context);
        if (obj instanceof ConditionSearchManager.c) {
            conditionSearchManager.S(obj);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void doUploadPhoto(Intent intent, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent, (Object) arrayList);
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.f(intent, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void enterCustomCover() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            if (friendProfilePhotoHelper.f176062k == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            friendProfilePhotoHelper.h(z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void enterNicknamePage(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, activity, str, str2);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("title", activity.getString(R.string.bu8));
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
        intent.putExtra("uin", str2);
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 3);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("max_num", 36);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 1034);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void enterSignaturePage(Activity activity, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity, (Object) baseQQAppInterface);
        } else {
            a33.b.e(activity, baseQQAppInterface, 0, "signature_ziliaoka", 1002);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String generateLocationString(AppInterface appInterface, String[] strArr) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, (Object) this, (Object) appInterface, (Object) strArr);
        }
        try {
            str = ((ConditionSearchManager) appInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).O(strArr);
        } catch (Exception unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.equals(IProfileCardConst.NAME_NO_LIMIT)) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public View getAvatar(FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this, (Object) frameLayout);
        }
        if (!(frameLayout instanceof AvatarLayout)) {
            return null;
        }
        return ((AvatarLayout) frameLayout).c(0);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public Card getCard(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (Card) iPatchRedirector.redirect((short) 41, (Object) this, (Object) baseQQAppInterface);
        }
        return ((FriendsManager) baseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(baseQQAppInterface.getCurrentAccountUin());
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public AddressInfo getCountryByCode(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (AddressInfo) iPatchRedirector.redirect((short) 59, (Object) this, (Object) appInterface, (Object) str);
        }
        BaseAddress w3 = ((ConditionSearchManager) appInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).w(str);
        if (w3 == null) {
            return null;
        }
        AddressInfo addressInfo = new AddressInfo(w3.name, w3.code, w3.getColumnNember(), w3.addressType);
        LinkedHashMap<String, BaseAddress> linkedHashMap = w3.dataMap;
        if (linkedHashMap != null) {
            for (Map.Entry<String, BaseAddress> entry : linkedHashMap.entrySet()) {
                BaseAddress value = entry.getValue();
                if (value != null) {
                    AddressInfo addressInfo2 = new AddressInfo(value.name, value.code, value.getColumnNember(), value.addressType);
                    LinkedHashMap<String, BaseAddress> linkedHashMap2 = value.dataMap;
                    if (linkedHashMap2 != null) {
                        for (Map.Entry<String, BaseAddress> entry2 : linkedHashMap2.entrySet()) {
                            BaseAddress value2 = entry2.getValue();
                            if (value2 != null) {
                                AddressInfo addressInfo3 = new AddressInfo(value2.name, value2.code, value2.getColumnNember(), value2.addressType);
                                LinkedHashMap<String, BaseAddress> linkedHashMap3 = value2.dataMap;
                                if (linkedHashMap3 != null) {
                                    for (Map.Entry<String, BaseAddress> entry3 : linkedHashMap3.entrySet()) {
                                        BaseAddress value3 = entry3.getValue();
                                        if (value3 != null) {
                                            addressInfo3.dataMap.put(entry3.getKey(), new AddressInfo(value3.name, value3.code, value3.getColumnNember(), value3.addressType));
                                        }
                                    }
                                }
                                addressInfo2.dataMap.put(entry2.getKey(), addressInfo3);
                            }
                        }
                    }
                    addressInfo.dataMap.put(entry.getKey(), addressInfo2);
                }
            }
        }
        return addressInfo;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public ArrayList<i> getEducationList(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ArrayList) iPatchRedirector.redirect((short) 33, (Object) this, (Object) baseQQAppInterface);
        }
        return ((BusinessCardManager) baseQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).n();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void getGroupInfoNT(AllInOne allInOne, hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) allInOne, (Object) bVar);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(allInOne.uin), TAG);
        if (friendsSimpleInfoWithUid == null) {
            if (bVar != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
                eVar.d(-1);
                bVar.onQueryResult(eVar);
                return;
            }
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), TAG, new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>(bVar) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ hx3.b val$cb;

            {
                this.val$cb = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this, (Object) bVar);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar2);
                    return;
                }
                hx3.b bVar2 = this.val$cb;
                if (bVar2 != null) {
                    bVar2.onQueryResult(eVar2);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String getJob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this, i3);
        }
        return NearbyProfileUtil.d(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public int getNearbyProfileUtilTagLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return NearbyProfileUtil.f306397f.length;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String getNoLimitText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return IProfileCardConst.NAME_NO_LIMIT;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String getRealPathFromContentURI(Activity activity, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) uri);
        }
        return BaseImageUtil.getRealPathFromContentURI(activity, uri);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public RichStatus getRichStatus(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RichStatus) iPatchRedirector.redirect((short) 16, (Object) this, (Object) card);
        }
        return RichStatusUtils.INSTANCE.getRichStatus(card);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String getSelectTag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this, i3);
        }
        return NearbyProfileUtil.f306397f[i3];
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public int getTitleBarHeight(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) context)).intValue();
        }
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public Uri getUpLoadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Uri) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mUploadCoverUri;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void handleInterestLayoutClick(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) context);
        } else {
            ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) InterestSwitchEditActivity.class), 1008);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void initFriendProfileHelper(Activity activity, IProfileEditBusinessApi.OnCoverUploadListener onCoverUploadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) onCoverUploadListener);
            return;
        }
        if (activity == null) {
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null && friendProfilePhotoHelper.f176053b.hashCode() == activity.hashCode()) {
            return;
        }
        this.mPhotoHelper = new FriendProfilePhotoHelper((QBaseActivity) activity, new FriendProfilePhotoHelper.b(onCoverUploadListener) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ IProfileEditBusinessApi.OnCoverUploadListener val$listener;

            {
                this.val$listener = onCoverUploadListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this, (Object) onCoverUploadListener);
                }
            }

            @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
            public void notifyUser(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
                }
            }

            @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
            public void onUploadResult(byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) bArr);
                    return;
                }
                if (bArr != null) {
                    ProfileEditBusinessApiImpl.this.saveCover(bArr);
                    IProfileEditBusinessApi.OnCoverUploadListener onCoverUploadListener2 = this.val$listener;
                    if (onCoverUploadListener2 != null) {
                        onCoverUploadListener2.onCoverUploadSuccess(bArr);
                    }
                }
            }

            @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
            public void updateCover(byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr);
                    return;
                }
                if (bArr != null) {
                    ProfileEditBusinessApiImpl.this.saveCover(bArr);
                    IProfileEditBusinessApi.OnCoverUploadListener onCoverUploadListener2 = this.val$listener;
                    if (onCoverUploadListener2 != null) {
                        onCoverUploadListener2.onCoverUploadSuccess(bArr);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void initSearchManager(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            ((ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).h(context);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public boolean isFirstPickLocation(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((ConditionSearchManager) appInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).F();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public boolean isJobIdInValid(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, i3)).booleanValue();
        }
        return NearbyProfileUtil.g(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public boolean isNeedGuideForNewSchoolData(Card card, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) card, (Object) baseQQAppInterface)).booleanValue();
        }
        return ProfileCardUtil.O(card, (QQAppInterface) baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void jump2MusicBoxPage(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) activity, (Object) str);
        } else if (activity != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", URLUtil.addParameter(QVipProfileMusicBoxProcessor.getConfig().musicBoxUrl, "uin", str));
            activity.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void jump2PersonalityLabelEditPage(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) activity, (Object) str);
            return;
        }
        if (activity != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, (Class<?>) PersonalityLabelGalleryActivity.class);
            intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
            intent.putExtra("uin", str);
            activity.startActivityForResult(intent, 1029);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void loadAndUpdateProfileData(AppRuntime appRuntime, IProfileEditBusinessApi.OnProfileCacheLoadedListener onProfileCacheLoadedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) onProfileCacheLoadedListener);
        } else {
            ThreadManagerV2.post(new Runnable(appRuntime, onProfileCacheLoadedListener) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppRuntime val$app;
                final /* synthetic */ IProfileEditBusinessApi.OnProfileCacheLoadedListener val$listener;

                {
                    this.val$app = appRuntime;
                    this.val$listener = onProfileCacheLoadedListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileEditBusinessApiImpl.this, appRuntime, onProfileCacheLoadedListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Card q16 = ((FriendsManager) this.val$app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.val$app.getCurrentAccountUin());
                    IProfileEditBusinessApi.OnProfileCacheLoadedListener onProfileCacheLoadedListener2 = this.val$listener;
                    if (onProfileCacheLoadedListener2 != null) {
                        onProfileCacheLoadedListener2.onProfileCacheLoaded(q16);
                    }
                    ((IProfileProtocolService) this.val$app.getRuntimeService(IProfileProtocolService.class, "all")).getProfileDetailForEdit();
                }
            }, 5, null, true);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void loadCountryInfo(AppRuntime appRuntime, IProfileEditBusinessApi.OnCountryCacheLoadedListener onCountryCacheLoadedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) appRuntime, (Object) onCountryCacheLoadedListener);
            return;
        }
        List<BaseAddress> x16 = ((ConditionSearchManager) appRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).x();
        if (onCountryCacheLoadedListener != null) {
            onCountryCacheLoadedListener.onCountryInfoLoaded(x16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String loadPersonalityLabels(Card card) {
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (String) iPatchRedirector.redirect((short) 60, (Object) this, (Object) card);
        }
        if (card == null || (profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) card.getBusinessInfo(ProfilePersonalityLabelInfo.class)) == null || profilePersonalityLabelInfo.personalityLabelInfos == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<PersonalityLabelInfo> it = profilePersonalityLabelInfo.personalityLabelInfos.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().text);
            if (it.hasNext()) {
                sb5.append("\u3001");
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void loadProvinceInfo(AppRuntime appRuntime, String str, IProfileEditBusinessApi.OnAreaInfoLoadedListener onAreaInfoLoadedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, appRuntime, str, onAreaInfoLoadedListener);
            return;
        }
        BaseAddress w3 = ((ConditionSearchManager) appRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).w(str);
        if (onAreaInfoLoadedListener != null) {
            onAreaInfoLoadedListener.onAreaInfoLoaded(w3);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void moveToNewGroup(Context context, AppInterface appInterface, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, context, appInterface, allInOne);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(allInOne.uin), TAG);
        if (friendsSimpleInfoWithUid != null) {
            ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", allInOne.uin).putExtra("mgid", (byte) friendsSimpleInfoWithUid.f()), 0);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void onResultOfRequestCustomCover(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) intent);
            return;
        }
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.mPhotoHelper;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.j(i3, intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public String parseCodeArrayToSimpleAdress(BaseQQAppInterface baseQQAppInterface, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this, (Object) baseQQAppInterface, (Object) strArr);
        }
        return ((ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).O(strArr);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void preLoadModelData(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) baseQQAppInterface);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(baseQQAppInterface) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileEditBusinessApiImpl.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseQQAppInterface val$app;

                {
                    this.val$app = baseQQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileEditBusinessApiImpl.this, (Object) baseQQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((CardHandler) this.val$app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a3(this.val$app.getCurrentUin());
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void previewProfileCover(Activity activity, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity, (Object) card);
            return;
        }
        if (card == null) {
            return;
        }
        String str = (String) card.getCoverData(0)[0];
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        int i3 = card.defaultCardId;
        Intent intent = new Intent(activity, (Class<?>) CardPicGalleryActivity.class);
        intent.putExtra("extra_mode", 2);
        intent.putExtra("is_from_mine_profile", true);
        intent.putStringArrayListExtra("business_card_pics", arrayList);
        intent.putExtra("default_card_id", i3);
        intent.putExtra("is_from_profile_edit", true);
        intent.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, IProfileCardConst.ACTION_COVER_FROM_PHOTO_EDIT);
        if (TextUtils.isEmpty(str)) {
            intent.putExtra("extra_default", R.drawable.f2v);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.f155013gl, 0);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void requestEducationList(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        CardHandler cardHandler = (CardHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.U2(baseQQAppInterface.getLongAccountUin());
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void requestUserLocation(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) appInterface);
        } else {
            ((LBSHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).J2();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void saveLocationInfo(BaseQQAppInterface baseQQAppInterface, Context context, String[] strArr, String str, String[] strArr2) {
        String[] strArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, baseQQAppInterface, context, strArr, str, strArr2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("location", strArr);
        bundle.putString(IProfileProtocolConst.KEY_LOCATION_DESC, str);
        try {
            strArr3 = ((ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).N(strArr2);
        } catch (Exception unused) {
            strArr3 = null;
        }
        bundle.putStringArray(IProfileProtocolConst.KEY_LOCATION_NAME, strArr3);
        sendUserInfoChange(baseQQAppInterface, context, bundle);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void setAvatarDrawable(AppInterface appInterface, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) appInterface, (Object) frameLayout);
        } else if (appInterface != null && (frameLayout instanceof AvatarLayout)) {
            ((AvatarLayout) frameLayout).setFaceDrawable(appInterface, 1, appInterface.getCurrentUin(), 640, true, true, true, false, 7);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void setDetailUserInfo(BaseQQAppInterface baseQQAppInterface, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) baseQQAppInterface, (Object) bundle);
            return;
        }
        CardHandler cardHandler = (CardHandler) baseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            cardHandler.g5(bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void setFirstShowGuideForNewSchoolData(Card card, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) card, (Object) baseQQAppInterface);
        } else {
            ProfileCardUtil.u0(card, (QQAppInterface) baseQQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public Drawable setNightModeFilterForDrawable(BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Drawable) iPatchRedirector.redirect((short) 37, (Object) this, (Object) baseQQAppInterface, i3);
        }
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(NearbyProfileUtil.f306398g[i3]);
        ProfileCardUtils.setNightModeFilterForDrawable(baseQQAppInterface, drawable);
        return drawable;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public boolean shouldShowHistoryAvatar(Context context, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) appRuntime)).booleanValue();
        }
        int h06 = ea.h0(context, appRuntime.getCurrentAccountUin());
        if (h06 != -1 && h06 != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startAvatarPendantActivity(Activity activity, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity, (Object) allInOne);
        } else {
            ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(activity, "4");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startCropPhoto(Activity activity, Uri uri, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, activity, uri, Integer.valueOf(i3), str);
            return;
        }
        String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(activity, uri);
        int x16 = ProfileCardUtil.x(activity);
        Intent intent = new Intent();
        intent.putExtra("fromWhereClick", 10);
        intent.putExtra("AVATAR_TO_CIRCLE_PUBLISH_PHOTO", true);
        intent.putExtra("AVATAR_TO_EXPERIENCE_FROM_TYPE", i3);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
        intent.setClass(activity, PhotoCropForPortraitActivity.class);
        intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(100));
        intent.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, str);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", realPathFromContentURI);
        intent.putExtra(PeakConstants.TARGET_PATH, FaceUtil.getUploadAvatarTempPath());
        intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, 1080);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
        activity.startActivity(intent);
        QAlbumUtil.anim(activity, false, true);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startEditPersonalNote(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) context, (Object) str);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) EditActivity.class);
        intent.putExtra("title", R.string.d2t).putExtra("limit", MAX_PERSONAL_NOTE_BYTES).putExtra("canPostNull", true).putExtra("hint", R.string.d2s).putExtra("multiLine", true).putExtra("current", str).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
        ((Activity) context).startActivityForResult(intent, 1007);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startJobSelectActivity(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) context, i3);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) JobSelectionActivity.class);
        intent.putExtra("param_id", i3);
        ((Activity) context).startActivityForResult(intent, 1004);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startLocationSelectActivity(BaseQQAppInterface baseQQAppInterface, Context context, String[] strArr, String[] strArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, baseQQAppInterface, context, strArr, strArr2);
            return;
        }
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        if (strArr2 == null || strArr2.length != 4) {
            strArr2 = new String[]{"0", "0", "0", "0"};
        }
        Intent intent = new Intent(context, (Class<?>) LocationSelectActivity.class);
        intent.putExtra("param_is_popup", false);
        intent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 3);
        intent.putExtra(IProfileCardConst.PARAM_LOCATION_CODE, strArr2);
        intent.putExtra("param_location_param", conditionSearchManager.Q(strArr2));
        ((Activity) context).startActivityForResult(intent, 1006);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startPhotoPicker(Activity activity, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, activity, Integer.valueOf(i3), str);
            return;
        }
        Intent intent = new Intent();
        int x16 = ProfileCardUtil.x(activity);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 100);
        intent.putExtra("BUSINESS_ORIGIN_NEW", 100);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        intent.putExtra("fromWhereClick", 11);
        intent.putExtra("AVATAR_TO_CIRCLE_PUBLISH_ALBUM", true);
        intent.putExtra("AVATAR_TO_EXPERIENCE_FROM_TYPE", i3);
        intent.setClass(activity, NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 50);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationCrop.F);
        intent.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, str);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.TARGET_PATH, FaceUtil.getUploadAvatarTempPath());
        intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, 1080);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
        intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        IAvatarPhotoPickerHelperApi iAvatarPhotoPickerHelperApi = (IAvatarPhotoPickerHelperApi) QRoute.api(IAvatarPhotoPickerHelperApi.class);
        if (iAvatarPhotoPickerHelperApi.useNewPhotoPicker()) {
            iAvatarPhotoPickerHelperApi.startPhotoPicker(activity, new Bundle(intent.getExtras()));
        } else {
            activity.startActivity(intent);
        }
        QAlbumUtil.anim(activity, false, true);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void startProfileImageActivity(AppRuntime appRuntime, Activity activity, View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, appRuntime, activity, view, str);
        } else {
            if (!(appRuntime instanceof QQAppInterface)) {
                return;
            }
            ProfileCardUtil.G0((QQAppInterface) appRuntime, activity, view, str, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public Uri startTakePhoto(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Uri) iPatchRedirector.redirect((short) 20, (Object) this, (Object) activity);
        }
        return ProfileCardUtils.enterSnapshot(activity, 5);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public int updateModel(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) baseQQAppInterface)).intValue();
        }
        return BaseApplicationImpl.getApplication().getSharedPreferences(String.format(Locale.getDefault(), "%s%s", "medal_wall_", baseQQAppInterface.getAccount()), 4).getInt("medal_total_number", 0);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void uploadAvatar(AppInterface appInterface, Context context, Intent intent, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, appInterface, context, intent, frameLayout);
            return;
        }
        if ((appInterface instanceof QQAppInterface) && intent != null && (frameLayout instanceof AvatarLayout)) {
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (ProfileCardUtil.h0((QQAppInterface) appInterface, stringExtra, intent)) {
                decodeAvatar(appInterface, (AvatarLayout) frameLayout);
            } else {
                QQToast.makeText(context, 1, R.string.hfc, 0).show();
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public Object initSearchManager(BaseQQAppInterface baseQQAppInterface, Context context, IProfileEditBusinessApi.OnCheckCSMListener onCheckCSMListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return iPatchRedirector.redirect((short) 29, this, baseQQAppInterface, context, onCheckCSMListener);
        }
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) baseQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        conditionSearchManager.h(context);
        int j3 = conditionSearchManager.j();
        if (j3 == 0) {
            onCheckCSMListener.onCheckDone(true);
            return null;
        }
        int h06 = conditionSearchManager.h0(j3, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startLocationSelectActivity | update result = " + h06);
        }
        if (h06 == 2) {
            onCheckCSMListener.onUpdateResult(-1);
            return null;
        }
        if (h06 == 0) {
            ConditionSearchManager.c createCsmConfigListener = createCsmConfigListener(onCheckCSMListener);
            onCheckCSMListener.onUpdateResult(0);
            conditionSearchManager.g(createCsmConfigListener);
            return createCsmConfigListener;
        }
        onCheckCSMListener.onUpdateResult(-2);
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi
    public void setDetailUserInfo(AppInterface appInterface, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) appInterface, (Object) bundle);
            return;
        }
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) appInterface.getRuntimeService(IProfileProtocolService.class, "all");
        if (iProfileProtocolService != null) {
            iProfileProtocolService.setProfileDetail(bundle);
        }
    }
}

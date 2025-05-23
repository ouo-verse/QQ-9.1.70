package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.profilecard.data.AddressInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richstatus.RichStatus;
import hx3.b;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileEditBusinessApi extends QRouteApi {

    /* loaded from: classes16.dex */
    public interface OnAreaInfoLoadedListener {
        void onAreaInfoLoaded(Object obj);
    }

    /* loaded from: classes16.dex */
    public interface OnCheckCSMListener {
        public static final int UPDATE_FAILED = -2;
        public static final int UPDATE_NET_UNAVAILABLE = -1;
        public static final int UPDATE_OK = 0;

        void onCheckDone(boolean z16);

        void onUpdateResult(int i3);
    }

    /* loaded from: classes16.dex */
    public interface OnCountryCacheLoadedListener {
        void onCountryInfoLoaded(List<Object> list);
    }

    /* loaded from: classes16.dex */
    public interface OnCoverUploadListener {
        void onCoverUploadSuccess(byte[] bArr);
    }

    /* loaded from: classes16.dex */
    public interface OnGetUserLocationListener {
        void onGetUserLocation(boolean z16, String[] strArr, boolean z17);
    }

    /* loaded from: classes16.dex */
    public interface OnLocationUpdateListener {
        void OnLocationUpdate(boolean z16, String str, String str2, String str3);
    }

    /* loaded from: classes16.dex */
    public interface OnProfileCacheLoadedListener {
        void onProfileCacheLoaded(Card card);
    }

    void chooseFromGallery(Activity activity, BaseQQAppInterface baseQQAppInterface);

    void chooseFromTakingPics(AppActivity appActivity, BaseQQAppInterface baseQQAppInterface);

    FrameLayout createAvatarLayout(Context context);

    BusinessObserver createLBSObserver(OnGetUserLocationListener onGetUserLocationListener);

    void destroyFriendProfileHelper();

    void destroyLocationSearchManager(BaseQQAppInterface baseQQAppInterface, Context context, Object obj);

    void doUploadPhoto(Intent intent, ArrayList<String> arrayList);

    void enterCustomCover();

    void enterNicknamePage(Activity activity, String str, String str2);

    void enterSignaturePage(Activity activity, BaseQQAppInterface baseQQAppInterface);

    String generateLocationString(AppInterface appInterface, String[] strArr);

    View getAvatar(FrameLayout frameLayout);

    Card getCard(BaseQQAppInterface baseQQAppInterface);

    AddressInfo getCountryByCode(AppInterface appInterface, String str);

    ArrayList<i> getEducationList(BaseQQAppInterface baseQQAppInterface);

    void getGroupInfoNT(AllInOne allInOne, b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar);

    String getJob(int i3);

    int getNearbyProfileUtilTagLength();

    String getNoLimitText();

    String getRealPathFromContentURI(Activity activity, Uri uri);

    RichStatus getRichStatus(Card card);

    String getSelectTag(int i3);

    int getTitleBarHeight(Context context);

    Uri getUpLoadUrl();

    void handleInterestLayoutClick(Context context);

    void initFriendProfileHelper(Activity activity, OnCoverUploadListener onCoverUploadListener);

    Object initSearchManager(BaseQQAppInterface baseQQAppInterface, Context context, OnCheckCSMListener onCheckCSMListener);

    void initSearchManager(BaseQQAppInterface baseQQAppInterface, Context context);

    boolean isFirstPickLocation(AppInterface appInterface);

    boolean isJobIdInValid(int i3);

    boolean isNeedGuideForNewSchoolData(Card card, BaseQQAppInterface baseQQAppInterface);

    void jump2MusicBoxPage(Activity activity, String str);

    void jump2PersonalityLabelEditPage(Activity activity, String str);

    void loadAndUpdateProfileData(AppRuntime appRuntime, OnProfileCacheLoadedListener onProfileCacheLoadedListener);

    void loadCountryInfo(AppRuntime appRuntime, OnCountryCacheLoadedListener onCountryCacheLoadedListener);

    String loadPersonalityLabels(Card card);

    void loadProvinceInfo(AppRuntime appRuntime, String str, OnAreaInfoLoadedListener onAreaInfoLoadedListener);

    void moveToNewGroup(Context context, AppInterface appInterface, AllInOne allInOne);

    void onResultOfRequestCustomCover(int i3, Intent intent);

    String parseCodeArrayToSimpleAdress(BaseQQAppInterface baseQQAppInterface, String[] strArr);

    void preLoadModelData(BaseQQAppInterface baseQQAppInterface);

    void previewProfileCover(Activity activity, Card card);

    void requestEducationList(BaseQQAppInterface baseQQAppInterface);

    void requestUserLocation(AppInterface appInterface);

    void saveLocationInfo(BaseQQAppInterface baseQQAppInterface, Context context, String[] strArr, String str, String[] strArr2);

    void setAvatarDrawable(AppInterface appInterface, FrameLayout frameLayout);

    void setDetailUserInfo(AppInterface appInterface, Bundle bundle);

    void setDetailUserInfo(BaseQQAppInterface baseQQAppInterface, Bundle bundle);

    void setFirstShowGuideForNewSchoolData(Card card, BaseQQAppInterface baseQQAppInterface);

    Drawable setNightModeFilterForDrawable(BaseQQAppInterface baseQQAppInterface, int i3);

    boolean shouldShowHistoryAvatar(Context context, AppRuntime appRuntime);

    void startAvatarPendantActivity(Activity activity, AllInOne allInOne);

    void startCropPhoto(Activity activity, Uri uri, int i3, String str);

    void startEditPersonalNote(Context context, String str);

    void startJobSelectActivity(Context context, int i3);

    void startLocationSelectActivity(BaseQQAppInterface baseQQAppInterface, Context context, String[] strArr, String[] strArr2);

    void startPhotoPicker(Activity activity, int i3, String str);

    void startProfileImageActivity(AppRuntime appRuntime, Activity activity, View view, String str);

    Uri startTakePhoto(Activity activity);

    int updateModel(BaseQQAppInterface baseQQAppInterface);

    void uploadAvatar(AppInterface appInterface, Context context, Intent intent, FrameLayout frameLayout);
}

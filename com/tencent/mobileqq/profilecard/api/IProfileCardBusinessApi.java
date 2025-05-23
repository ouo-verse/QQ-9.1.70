package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardBusinessApi extends QRouteApi {

    /* loaded from: classes16.dex */
    public interface CommonCallback {
        void onResult(int i3, Bundle bundle);
    }

    String addNationCodeIfNeeded(AppRuntime appRuntime, String str);

    void batchFetchFriendNick(ArrayList<String> arrayList, CommonCallback commonCallback);

    IProfileConfig createProfileConfig(AppInterface appInterface);

    AbsProfileComponent createVasProfileComponent(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo);

    void dealTextViewForCopyAction(TextView textView, String str, String str2);

    Intent getBabyQProfileCardIntent(Context context, AllInOne allInOne);

    String getConstellation(int i3);

    String getJob(int i3);

    String getJobTag(int i3);

    Intent getKPLProfileCardIntent(Context context);

    Class<?> getQQBrowserActivityClass();

    void initContactCardInfoList(AppInterface appInterface, ProfileCardInfo profileCardInfo, boolean z16);

    boolean isBindedIgnoreUpload(AppRuntime appRuntime);

    boolean isDefaultProfile(ProfileCardInfo profileCardInfo);

    void jumpProfileOpenDetails(ProfileCardInfo profileCardInfo, AppInterface appInterface, Activity activity);

    SpannableString makeSchoolAuthenticationIcon(String str, boolean z16, int i3, int i16, int i17, Context context, AppInterface appInterface);

    String makeSexAgeArea(Context context, int i3, int i16, String str, String str2, String str3);

    byte needReqMedalWall(Context context, AppRuntime appRuntime);

    boolean needReqOCRCard(AppRuntime appRuntime);

    void onProfileRedTouchClick(AppRuntime appRuntime);

    boolean openRobotProfileCard(Context context, AllInOne allInOne);

    void setFriendComment(AppInterface appInterface, String str, String str2, boolean z16);

    String syncFetchFriendNick(String str);
}

package com.tencent.mobileqq.profilecard.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileEditApi extends QRouteApi {

    /* loaded from: classes16.dex */
    public interface BirthdayEditListener {
        void onConfirm(int i3, int i16, int i17);

        void onPrivacyUpdate(int i3);
    }

    /* loaded from: classes16.dex */
    public interface GenderEditListener {
        void onConfirm(int i3);

        void onPrivacyUpdate(int i3);
    }

    /* loaded from: classes16.dex */
    public interface LocationEditListener {
        void onPrivacyUpdate(int i3);

        void onUpdate(String str, String[] strArr);
    }

    /* loaded from: classes16.dex */
    public interface OnTakePhotoListener {
        void onSetSourceFrom(int i3);

        void onStartTakePhoto(Uri uri);
    }

    boolean checkoutBirthDayValid(int i3, int i16, int i17);

    void downloadHDAvatar(String str, AppRuntime appRuntime);

    int getSourceTypeFromeProfileType(int i3);

    void openProfileAgeSelector(Context context, int i3, int i16, BirthdayEditListener birthdayEditListener);

    void openProfileBirthdaySelector(Context context, int i3, int i16, BirthdayEditListener birthdayEditListener);

    void openProfileEdit(Context context, AllInOne allInOne, boolean z16);

    void openProfileEdit(Context context, AllInOne allInOne, boolean z16, Bundle bundle);

    void openProfileGenderSelector(Context context, int i3, int i16, GenderEditListener genderEditListener);

    void openProfileLocationSelector(Context context, Card card, int i3, LocationEditListener locationEditListener);

    boolean shouldOpenNewProfileEdit();

    void showAvatarActionSheet(AppRuntime appRuntime, QBaseActivity qBaseActivity, View view, AllInOne allInOne, OnTakePhotoListener onTakePhotoListener, int i3, String str);
}

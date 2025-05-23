package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneRouteApi extends QRouteApi {
    Intent getPassiveIntent();

    Fragment getQZoneAIOUserHomeFragment(long j3);

    Intent getQZoneDetailIntent(Context context, String str);

    Class<?> getQZonePublishMoodActivityClass();

    Intent getQZoneUserHomeIntent(Context context, String str);

    boolean isAIOLongPressExptOn();

    boolean isAIOPanelShareSwitch();

    boolean isChatRecordExpOn();

    boolean isGroupAlbumEntry(String str);

    boolean isMediaPickFirstExpOn();

    boolean isNativeGroupAlbumExpOpen();

    boolean isNewAIOGroupAlbumEnable();

    boolean isOpenQZAlbumx();

    void launchDetailPage(Context context, Bundle bundle);

    void launchFeedDetailWithData(Context context, String str, String str2);

    boolean launchMediaPickToPublishMood(Activity activity);

    void launchPublishMoodPage(Context context);

    void launchQZAlbumxMainPage(Context context, String str, Bundle bundle, String str2);

    void launchQZonePage(Context context, String str, Intent intent, String str2);

    void launchQZoneScheme(Context context, String str);

    void launchUserHome(Context context, long j3, boolean z16, int i3);
}

package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopCardApi extends QRouteApi {
    void ForwardSdkShareOption_startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2);

    @Deprecated
    void FreezedLiangGroup(Activity activity, Object obj);

    void JoinTroopSecurityTipsHelper_showTips(AppInterface appInterface, int i3, long j3, Activity activity);

    Intent addFriendLogicActivity_startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7);

    Intent addFriendLogicActivity_startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    void addRecentTroopItemIntoRecentMsgList(AppInterface appInterface, String str, String str2, long j3);

    void addRecentTroopItemIntoRecentMsgList(AppRuntime appRuntime, Object obj);

    byte[] base64Decode(String str);

    void bnrReport(AppInterface appInterface, int i3);

    int[] buildCustomClipDecoderParams(int i3, int i16, int i17, int i18, int i19, int i26);

    Dialog createQuestionDialog(Activity activity);

    Bitmap exifBitmapCreator_createBitmap(Bitmap bitmap, String str);

    void freezedLiangGroup(Activity activity, Object obj);

    Intent getChatActivityIntent(Activity activity, int i3);

    String getFriendDisplayName(AppInterface appInterface, String str);

    void getFriendInfo(AppInterface appInterface, String str);

    Object getHighwayConfig();

    void getOpenID(AppInterface appInterface, String str);

    Object getOpenIDFromCacheAndDB(AppInterface appInterface, String str);

    Class<?> getTroopAdminListClass();

    Class<?> getTroopAvatarWallEditActivityClass();

    String getTroopCardTipsContent(Context context);

    Class<?> getTroopClassChoiceActivtiyClass();

    String getTroopGameCardResDownloadPath();

    Class<?> getTroopTagViewActivityClass();

    Object get_CUSTOM_CLIP_DECODER();

    void goToMsgList(Activity activity);

    void handleAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent);

    void handleEditClosed(boolean z16, View view, Bundle bundle);

    @Deprecated
    void handleModiftyTroopHeadFreezed(Object obj, Context context);

    @Deprecated
    void handleModifyNameFreezed(Object obj, Context context);

    void handleModifyNameFreezedByTroopInfo(Object obj, Context context);

    void handleModifyTroopHeadFreezedByTroopInfo(Object obj, Context context);

    boolean isFastDoubleClick();

    boolean isInstanceOfTroopAvatarWallEditActivity(Activity activity);

    void jionTroopFromTroopAssociation(Context context, Object obj);

    URL nearbyImgDownloader_convertURL(String str) throws MalformedURLException;

    boolean needAnswerQuestion(String str);

    void openAddTroopWebInfo(Activity activity, String str, String str2);

    void openGameRankPage(Context context, Map<String, String> map);

    void openTroopAssociationWebPage(Context context, String str);

    void openTroopInfoFromTroopAssociation(Context context, Object obj);

    int parseColor(String str);

    Uri profileCardUtils_enterSnapshot(Activity activity, int i3);

    void refreshTroopFace(AppInterface appInterface, String str);

    void reportGameCardStatus(AppRuntime appRuntime);

    void reportTask(AppInterface appInterface, String str, int i3);

    void secRecognize(boolean z16, View view);

    void setNightModeFilterForDrawable(AppInterface appInterface, Drawable drawable);

    boolean shouldShowGameRankEntrance();

    void startModifyHomeworkTroopNickname(Context context, String str, String str2, String str3);

    void startModifyLocationActivityForResultEx(Activity activity, String str, String str2, int i3);

    void startPhotoEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3);

    void startPhotoEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3, int i19);

    void startPhotoList(Activity activity, Bundle bundle);

    void startPhotoListEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2);

    void startPhotoListEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, int i19);

    void storyReportor(Activity activity);
}

package com.tencent.mobileqq.matchfriend.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendEntryApi extends QRouteApi {
    void enterChatSetting(Context context, AppInterface appInterface);

    void enterFeedDetail(@NonNull Context context, int i3, @NonNull String str, @NonNull String str2, int i16, int i17);

    void enterLittleAssistantAIO(Context context);

    void enterMatchFriendAIO(Context context, long j3, String str, int i3);

    void enterMatchFriendAIO(Context context, long j3, String str, int i3, Bundle bundle);

    void enterMatchFriendAIO(AppInterface appInterface, Context context, String str, int i3);

    void enterMatchFriendAIO(AppInterface appInterface, Context context, String str, int i3, Bundle bundle);

    void enterMatchPage(Context context, AppRuntime appRuntime, com.tencent.mobileqq.matchfriend.data.a aVar);

    void enterMatchingFriend(Context context);

    void enterMsgListPage(Context context, AppInterface appInterface, int i3, int i16);

    void enterOfficialAccount(Context context);

    void enterProfileCard(Context context, String str, int i3);

    void enterProfileCard(Context context, String str, int i3, int i16);

    void enterProfileCard(Context context, String str, int i3, int i16, String str2);

    void enterProfileCard(Context context, String str, Intent intent);

    void enterProfileCard(AppInterface appInterface, Context context, long j3, int i3);

    void enterProfileCard(AppInterface appInterface, Context context, long j3, int i3, int i16);

    void enterProfileCard(AppInterface appInterface, Context context, long j3, Intent intent);

    void enterProfileEdit(Context context, String str);

    void enterSignalSquare(Context context);

    void enterSignalSquare(Context context, long j3);

    void enterVoiceChat(Context context, RoomInfo roomInfo);

    int getAddContactEntryDTID();

    String getAddContactsMatchFriendEntryTitle(AppInterface appInterface);

    boolean getMatchFriendEntrance(AppInterface appInterface);

    void launchAddFriend(Context context, long j3);

    void launchAddFriend(Context context, long j3, String str);

    void launchAddFriend(Context context, String str, String str2, int i3);

    void launchAddFriend(Context context, String str, String str2, int i3, String str3);

    void launchAgeSelectFragment(Context context);

    void openSignalPublisher(Context context, boolean z16);

    void openSignalPublisher(Context context, boolean z16, long j3, long j16);

    boolean showAddContactsMatchFriendEntry(AppInterface appInterface);

    boolean showMatchFriendEntry(AppInterface appInterface);
}

package com.tencent.mobileqq.addfriend.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAddFriendApi extends QRouteApi {
    void addOpenId(String str, OpenID openID, AppRuntime appRuntime);

    boolean couldAddFriendSuccessDirectly(int i3, int i16, boolean z16);

    int countByByte(String str);

    String getGroupName(AppInterface appInterface, int i3);

    int getLocalSelfAddFriendSetting(AppRuntime appRuntime);

    String getRemark(String str);

    void getSelfAddFriendSetting(AppRuntime appRuntime);

    String getsOpenId();

    boolean isIfShowAFDlg();

    void launchAddFriend(Context context, Intent intent);

    void launchAddFriendForResult(Activity activity, Intent intent, int i3);

    void setIfShowAFDlg(boolean z16);

    void setsOpenId(String str);

    boolean shouldReqAutoInfo(int i3, String str);

    boolean shouldUseLocalRemark(int i3);

    Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5);

    Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7);

    Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7, @Nullable byte[] bArr);

    Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, String str3, byte[] bArr);

    Intent startAddFriend(Context context, int i3, String str, String str2, int i16, int i17, byte[] bArr, String str3, String str4, String str5, String str6, String str7);

    Intent startMultiAddContact(Context context, List<PhoneContact> list, int i3, String str, String str2, String str3, int i16);
}

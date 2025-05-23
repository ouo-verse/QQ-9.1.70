package com.tencent.mobileqq.friend.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IFriendHandlerService extends IRuntimeService {
    void addFriendGroup(byte b16, String str);

    void cacheToken(String str, int i3, int i16, byte[] bArr);

    void deleteFriendGroup(byte b16);

    void getOnlyChatPermissionBatchByPage(int i3);

    void getPermissionSelectFriend(List<String> list, int i3, int i16);

    void getSingleFriendPermission(String str);

    boolean isRequestingFriendList();

    void renameFriendGroup(byte b16, String str);

    void requestAddBatchPhoneFriend(ArrayList<PhoneContact> arrayList, String str, int i3, int i16, ArrayList<AddBatchPhoneFriendResult> arrayList2);

    void requestAddFriend(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5);

    void requestAddFriend(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5, Bundle bundle, boolean z18);

    void requestAddFriendWithMyCard(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5, byte b17, String str6, Bundle bundle, boolean z18);

    void requestAddFriendWithMyCard(String str, String str2, int i3, byte b16, String str3, int i16, int i17, byte[] bArr, boolean z16, byte[] bArr2, boolean z17, String str4, String str5, byte b17, String str6, Bundle bundle, boolean z18, byte[] bArr3);

    void requestAutoInfo(String str, int i3, int i16);

    void requestFriendInfo(String str);

    void requestFriendList(boolean z16);

    void requestFriendList(boolean z16, int i3);

    void requestInfoWithOpenId(String str, String str2);

    void requestUinSafetyFlag(long j3);

    void requestUserAddFriendSetting(String str, int i3, int i16, String str2);

    void requestUserAddFriendSetting(String str, int i3, int i16, String str2, int i17);

    void resortFriendGroup(byte[] bArr, byte[] bArr2);

    void setBatchFriendPermission(List<String> list, int i3);

    void setFriendPermission(String str, int i3);
}

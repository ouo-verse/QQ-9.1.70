package com.tencent.mobileqq.friend.alphabet.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.alphabet.NTAlphabetFriendFragment;
import com.tencent.mobileqq.friend.alphabet.api.INTFriendApi;
import com.tencent.mobileqq.friend.device.DeviceFragment;
import com.tencent.mobileqq.friend.group.GroupFragment;
import com.tencent.mobileqq.friend.group.GroupListFriend;
import com.tencent.mobileqq.friend.permissionmanager.FriendPermissionSettingFragment;
import com.tencent.mobileqq.friend.phone.PhoneContactFragment;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/friend/alphabet/api/impl/NTFriendApiImpl;", "Lcom/tencent/mobileqq/friend/alphabet/api/INTFriendApi;", "", "getNtAlphabetFriendFragment", "getGroupFragment", "getDeviceFragment", "getPhoneContactFragment", "", "childType", "Landroid/content/Context;", "ctx", "", "uid", "getBuddyItem", "context", "groupId", "", "startFriendPermissionSetting", "<init>", "()V", "Companion", "a", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NTFriendApiImpl implements INTFriendApi {
    public static final String TAG = "NTFriendApiImpl";

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public Object getBuddyItem(int childType, Context ctx, String uid) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (childType == 4) {
            return new GroupListFriend(qQAppInterface, ctx, uid);
        }
        return new GroupListFriend(qQAppInterface, ctx, uid);
    }

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public Object getDeviceFragment() {
        return new DeviceFragment();
    }

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public Object getGroupFragment() {
        return new GroupFragment();
    }

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public Object getNtAlphabetFriendFragment() {
        return new NTAlphabetFriendFragment();
    }

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public Object getPhoneContactFragment() {
        return new PhoneContactFragment();
    }

    @Override // com.tencent.mobileqq.friend.alphabet.api.INTFriendApi
    public void startFriendPermissionSetting(Context context, int groupId) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        Intent intent = new Intent();
        intent.putExtra("groupId", groupId);
        QPublicFragmentActivity.start(context, intent, FriendPermissionSettingFragment.class);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C115", "0X800C115", 0, 0, "", "", "", "");
    }
}

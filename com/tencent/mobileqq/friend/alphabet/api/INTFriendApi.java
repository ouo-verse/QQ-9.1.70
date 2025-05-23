package com.tencent.mobileqq.friend.alphabet.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/friend/alphabet/api/INTFriendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBuddyItem", "", "childType", "", "ctx", "Landroid/content/Context;", "uid", "", "getDeviceFragment", "getGroupFragment", "getNtAlphabetFriendFragment", "getPhoneContactFragment", "startFriendPermissionSetting", "", "context", "groupId", "qqfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface INTFriendApi extends QRouteApi {
    @NotNull
    Object getBuddyItem(int childType, @NotNull Context ctx, @NotNull String uid);

    @NotNull
    Object getDeviceFragment();

    @NotNull
    Object getGroupFragment();

    @NotNull
    Object getNtAlphabetFriendFragment();

    @NotNull
    Object getPhoneContactFragment();

    void startFriendPermissionSetting(@NotNull Context context, int groupId);
}

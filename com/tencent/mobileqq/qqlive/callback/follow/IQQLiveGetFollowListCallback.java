package com.tencent.mobileqq.qqlive.callback.follow;

import com.tencent.mobileqq.qqlive.data.follow.FollowListUser;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveGetFollowListCallback {
    void onFail(int i3, String str);

    void onSuccess(String str, boolean z16, ArrayList<FollowListUser> arrayList);
}

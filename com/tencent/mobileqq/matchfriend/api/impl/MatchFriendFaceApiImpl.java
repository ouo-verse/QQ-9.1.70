package com.tencent.mobileqq.matchfriend.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.matchfriend.drawable.MatchFriendFaceDrawable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendFaceApiImpl implements IMatchFriendFaceApi {
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi
    public Drawable getMatchFriendFaceDrawable(AppInterface appInterface, long j3) {
        return MatchFriendFaceDrawable.j(appInterface, j3, null);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi
    public Drawable getMatchFriendFaceDrawable(AppInterface appInterface, String str) {
        return MatchFriendFaceDrawable.l(appInterface, str);
    }
}

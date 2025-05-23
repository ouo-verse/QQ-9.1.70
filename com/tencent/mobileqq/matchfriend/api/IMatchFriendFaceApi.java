package com.tencent.mobileqq.matchfriend.api;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendFaceApi extends QRouteApi {
    Drawable getMatchFriendFaceDrawable(AppInterface appInterface, long j3);

    Drawable getMatchFriendFaceDrawable(AppInterface appInterface, String str);
}

package com.tencent.mobileqq.wxapi.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWXShareHelper extends QRouteApi {
    int ERR_AUTH_DENIED();

    int ERR_OK();

    int ERR_USER_CANCEL();

    int WXSceneFavorite();

    int WXSceneSession();

    int WXSceneSpecifiedContact();

    int WXSceneTimeline();

    void addObserver(IWXShareHelperListener iWXShareHelperListener);

    boolean isWXInstalled();

    boolean isWXsupportApi();

    void removeObserver(IWXShareHelperListener iWXShareHelperListener);

    void shareImageToWX(String str, Bitmap bitmap, int i3);

    void shareQcircleToWX(String str, String str2, Bitmap bitmap, String str3, String str4, int i3);

    void shareTroopToWXFriend(String str, String str2, Bitmap bitmap, String str3, String str4);

    void shareTroopToWXFriendCircle(String str, String str2, Bitmap bitmap, String str3, String str4);

    void shareWebPageToWXFriend(String str, String str2, Bitmap bitmap, String str3, String str4);

    void shareWebPageToWXFriendCircle(String str, String str2, Bitmap bitmap, String str3, String str4);
}

package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IProfileCardUtil extends QRouteApi {
    void decodeAvatar(String str, ImageView imageView);

    void enterClipPage(Activity activity, Uri uri);

    Card findFriendCardByUin(AppRuntime appRuntime);

    Card initCard(AppRuntime appRuntime, String str);

    void selectPhotoFromAlum(Activity activity);

    Uri takePhoto(Activity activity);
}

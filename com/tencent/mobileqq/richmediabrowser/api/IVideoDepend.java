package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IVideoDepend extends QRouteApi {
    VideoPlayParam buildVideoPlayParam(MessageRecord messageRecord, VideoPlayParam videoPlayParam);

    void dealAddFavorite(Intent intent, Activity activity, AppRuntime appRuntime, int i3, int i16, int i17);

    String getCameraMaterialName();

    String getCameraVideoParam();

    int getVideoIpType();

    Pair<Boolean, Boolean> hasCode(Bitmap bitmap);

    void onQRDecodeSucceed(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7);

    void sendToQZone(Activity activity, String str, String str2);

    void stopPttMsgPlay(AppRuntime appRuntime);
}

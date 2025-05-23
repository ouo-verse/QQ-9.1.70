package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShortVideoDepend extends QRouteApi {
    void dealSendToFriend(Activity activity, Intent intent, String str, String str2, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem);

    void dealSendToGuild(Activity activity, Intent intent, String str, String str2, int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem);

    String getLocalShortVideoPath();

    String getShortVideoSavePath(MessageRecord messageRecord, String str);

    URL getThumbUrl(String str);

    Runnable getVideoFileSaveRunnable(String str, MqqHandler mqqHandler, String str2, boolean z16);

    int getVideoSaveFailCode();

    int getVideoSaveSuccessCode();

    boolean isAEPituTakeSameOpen();

    void reportVideoPlayEvent(int i3, String str, int i16, int i17, long j3, long j16);
}

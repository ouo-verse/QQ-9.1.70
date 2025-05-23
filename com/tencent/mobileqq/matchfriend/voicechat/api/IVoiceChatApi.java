package com.tencent.mobileqq.matchfriend.voicechat.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVoiceChatApi extends QRouteApi {
    void enterVoiceMatchOnlinePage(Context context, RoomInfo roomInfo);

    void exitRoom();

    boolean isInVoiceChat();

    void onQQStrangerProcessCreate();

    void onQQStrangerProcessDestroy();

    void restoreVoiceChatPage(Context context, int i3);

    void setRestoreVoiceChatIntent(Intent intent);
}

package com.tencent.mobileqq.reminder.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQReminderChats extends QRouteApi {
    int getAvatarResId();

    void reportDTMsgList(@NonNull String str, @NonNull String str2);

    void updateMessageList();
}

package com.tencent.mobileqq.qcircle.api.data;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

/* compiled from: P */
@PluginInterface
/* loaded from: classes16.dex */
public interface QCircleRecentDataInterface {
    long getContactId();

    String getDataString();

    long getDisplayTime();

    String getExtraInfo();

    byte[] getGiftInfo();

    CharSequence getLastMsg(Context context);

    MessageRecord getMessageRecord();

    CharSequence getMsgExtraInfo();

    String getRecentUserUid();

    String getRecentUserUin();

    String getShowTime();

    String getTitleName();

    int getUnreadNum();

    void setGiftInfo(byte[] bArr);

    void update();
}

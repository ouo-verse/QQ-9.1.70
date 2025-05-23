package com.tencent.mobileqq.qqlive.callback.announce;

import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;

/* loaded from: classes17.dex */
public interface IQQLiveAnnouncePushListener {
    void onAnnounceReceive(AnnouncePushMessage announcePushMessage);

    void onFail(int i3, String str);
}

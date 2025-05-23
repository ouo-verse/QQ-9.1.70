package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface IMiniMsgUnreadCallback {
    void destroy();

    void hide();

    void hideUnread();

    boolean show(int i3);

    void updateOnBackFromMiniAIO(Bundle bundle);

    void updateUnreadCount(int i3, boolean z16);
}

package com.tencent.mobileqq.minigame.publicaccount.view;

import android.app.Activity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IHeaderView {
    String getAppName();

    void init(MessageRecord messageRecord, Activity activity);

    void init(QQGameMsgInfo qQGameMsgInfo, Activity activity, int i3, String str);

    void onDestory();

    void onPause();

    void onResume();

    void onStop();
}

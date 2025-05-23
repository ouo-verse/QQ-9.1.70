package com.tencent.mobileqq.troop.api;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopSysMsgDependApiService extends IRuntimeService {
    TextView getAnimationTextInstance(Context context);

    void getFriendInfo(String str);

    String getSubscriptName(AppRuntime appRuntime, Context context);

    boolean isBrowserAppInterface(AppRuntime appRuntime);

    boolean isQQAppInterface(AppRuntime appRuntime);

    void openTroopProfile(Context context, Bundle bundle);
}

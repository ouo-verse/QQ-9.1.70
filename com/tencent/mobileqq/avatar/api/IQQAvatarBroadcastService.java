package com.tencent.mobileqq.avatar.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes11.dex */
public interface IQQAvatarBroadcastService extends IRuntimeService {
    void headQQHeadBroadcast(Intent intent);

    void sendQQHeadBroadcast(int i3, String str, int i16, String str2);

    void sendSelfQQHeadBroadcast(int i3, String str, int i16, String str2);
}

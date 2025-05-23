package com.tencent.mobileqq.activity.aio.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAIOApi extends QRouteApi {
    void startChatAndRecordTask(Activity activity, String str, int i3, String str2, Bundle bundle, int i16);

    void startChatAndRecordTask(Context context, String str, int i3, String str2, Bundle bundle, int i16);

    void startChatAndRecordTask(Fragment fragment, String str, int i3, String str2, Bundle bundle, int i16);
}

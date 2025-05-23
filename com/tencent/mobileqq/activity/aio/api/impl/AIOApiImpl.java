package com.tencent.mobileqq.activity.aio.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.activity.aio.l;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOApiImpl implements IAIOApi {
    @Override // com.tencent.mobileqq.activity.aio.api.IAIOApi
    public void startChatAndRecordTask(Activity activity, String str, int i3, String str2, Bundle bundle, int i16) {
        l.Z(activity, str, i3, str2, bundle, i16);
    }

    @Override // com.tencent.mobileqq.activity.aio.api.IAIOApi
    public void startChatAndRecordTask(Fragment fragment, String str, int i3, String str2, Bundle bundle, int i16) {
        Context context;
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        l.Z(context, str, i3, str2, bundle, i16);
    }

    @Override // com.tencent.mobileqq.activity.aio.api.IAIOApi
    public void startChatAndRecordTask(Context context, String str, int i3, String str2, Bundle bundle, int i16) {
        l.Y(context, str, i3, str2, bundle, i16);
    }
}

package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes25.dex */
public class ShadowPendingIntent {
    public static PendingIntent getActivity(Context context, int i3, Intent intent, int i16) {
        return getActivity(context, i3, intent, i16, null);
    }

    public static PendingIntent getService(Context context, int i3, Intent intent, int i16) {
        return PendingIntent.getService(context, i3, intent, i16);
    }

    @TargetApi(16)
    public static PendingIntent getActivity(Context context, int i3, Intent intent, int i16, Bundle bundle) {
        if ((context instanceof ShadowContext) && intent.getComponent() != null) {
            ShadowContext shadowContext = (ShadowContext) context;
            if (shadowContext.getPendingIntentConverter() != null) {
                intent = shadowContext.getPendingIntentConverter().convertPluginActivityIntent(intent);
            }
            context = shadowContext.getBaseContext();
        }
        return PendingIntent.getActivity(context, i3, intent, i16, bundle);
    }
}

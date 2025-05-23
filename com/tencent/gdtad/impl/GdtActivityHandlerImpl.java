package com.tencent.gdtad.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ad.tangram.util.AdActivityHandler;
import com.tencent.gdtad.IGdtActivityHandler;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtActivityHandlerImpl implements IGdtActivityHandler {
    @Override // com.tencent.gdtad.IGdtActivityHandler
    public void onActivityResult(WeakReference<Activity> weakReference, int i3, int i16, Intent intent) {
        AdActivityHandler.onActivityResult(weakReference, i3, i16, intent);
    }

    @Override // com.tencent.gdtad.IGdtActivityHandler
    public void onTopResumedActivityChanged(WeakReference<Activity> weakReference, boolean z16) {
        AdActivityHandler.onTopResumedActivityChanged(weakReference, z16);
    }
}

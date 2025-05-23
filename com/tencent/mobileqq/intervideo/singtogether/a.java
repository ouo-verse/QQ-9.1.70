package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 1) {
            a(z16, bundle.getInt("appId"), bundle.getLong("uin", 0L), bundle.getString("openId"), bundle.getString("error_msg"));
        }
    }

    public void a(boolean z16, int i3, long j3, String str, String str2) {
    }
}

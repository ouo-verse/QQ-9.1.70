package com.tencent.luggage.wxa.fa;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a(Object obj) {
        if (!(obj instanceof Activity) && !(obj instanceof Context) && !(obj instanceof Fragment) && !(obj instanceof android.app.Fragment)) {
            return false;
        }
        return true;
    }
}

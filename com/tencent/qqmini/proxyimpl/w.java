package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pad.SplitViewState;

/* compiled from: P */
/* loaded from: classes34.dex */
public class w {
    public static boolean a(Context context) {
        return context != null && AppSetting.t(context) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT;
    }
}

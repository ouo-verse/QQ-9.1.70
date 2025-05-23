package com.tencent.gdtad.net;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtNetUtil {
    public static boolean isNetValid(Context context) {
        return NetworkUtil.isNetSupport(context);
    }
}

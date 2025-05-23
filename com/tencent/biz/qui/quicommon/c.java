package com.tencent.biz.qui.quicommon;

import android.content.Context;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    public static boolean a() {
        return b(ud0.b.a());
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return a.b(context.getResources().getColor(R.color.qui_common_bg_bottom_standard, null));
    }
}

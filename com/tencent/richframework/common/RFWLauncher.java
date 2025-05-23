package com.tencent.richframework.common;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.richframework.common.fragment.RFWChangeMsfServerFragment;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWLauncher {
    public static void launchChangeMsfServerPage(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, CompatPublicActivity.class);
        intent.putExtra("public_fragment_class", RFWChangeMsfServerFragment.class.getCanonicalName());
        intent.putExtra("public_fragment_window_feature", 1);
        context.startActivity(intent);
    }
}

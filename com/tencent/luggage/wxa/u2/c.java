package com.tencent.luggage.wxa.u2;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.m;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static Intent a(Activity activity, String str, int i3, int i16, int i17, boolean z16) {
        v vVar = new v(str);
        if (vVar.e()) {
            vVar.d();
        }
        v k3 = vVar.k();
        if (!k3.e()) {
            k3.w();
        }
        Intent intent = new Intent();
        intent.putExtra("output", m.a(activity, vVar));
        intent.putExtra("android.intent.extra.videoQuality", i17);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z16 ? 1 : 0);
        if (i3 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i3);
        }
        if (i16 > 0) {
            intent.putExtra("android.intent.extra.sizeLimit", i16);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        return intent;
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.hq;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aa {
    public static <T extends hq<T, ?>> void a(Context context, kz4.a aVar) {
        if (aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", aVar.g());
        intent.putExtra("action_cr_event_frequency", aVar.c());
        intent.putExtra("action_cr_perf_switch", aVar.h());
        intent.putExtra("action_cr_perf_frequency", aVar.e());
        intent.putExtra("action_cr_event_en", aVar.f());
        intent.putExtra("action_cr_max_file_size", aVar.d());
        ag.h(context).r(intent);
    }
}

package com.tencent.mapsdk.shell.events;

import android.support.annotation.Keep;
import com.tencent.mapsdk.internal.tf;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class ReportEvent {
    public String code;
    public boolean isSucceed;
    public Map<String, String> params;
    public String appKey = tf.f150444k;
    public boolean realtime = false;

    public ReportEvent(String str, Map<String, String> map) {
        this.code = str;
        this.params = map;
    }
}

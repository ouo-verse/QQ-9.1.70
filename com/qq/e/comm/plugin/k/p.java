package com.qq.e.comm.plugin.k;

import com.qq.e.comm.plugin.base.media.video.GDTVideoView;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {
    public static boolean a(GDTVideoView gDTVideoView, String str, com.qq.e.comm.plugin.m.b bVar) {
        if (gDTVideoView == null) {
            return false;
        }
        if (!gDTVideoView.a(str, bVar)) {
            StatTracer.trackEvent(1600056, new JSONObject(), new JSONObject());
            return false;
        }
        StatTracer.trackEvent(1600057, new JSONObject(), new JSONObject());
        return true;
    }

    public static void a(boolean z16, int i3, int i16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("screen", Integer.valueOf(i16));
        if (z16) {
            GDTLogger.d("DownloadingWithPlayUtil downloadingWithPlay, costTime is " + i3);
            StatTracer.trackEvent(1600055, i3, (String) null, cVar.a());
            return;
        }
        GDTLogger.d("DownloadingWithPlayUtil play after download, costTime is " + i3);
        StatTracer.trackEvent(1600054, i3, (String) null, cVar.a());
    }
}

package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, IHuayangPluginNewDownloader> f238257a = new HashMap<>();

    public static File a(Context context) {
        return context.getFilesDir();
    }

    public static synchronized IHuayangPluginNewDownloader b(Context context, String str, String str2) {
        IHuayangPluginNewDownloader iHuayangPluginNewDownloader;
        synchronized (c.class) {
            String str3 = str2 + str;
            iHuayangPluginNewDownloader = f238257a.get(str3);
            if (iHuayangPluginNewDownloader == null) {
                iHuayangPluginNewDownloader = (IHuayangPluginNewDownloader) QRoute.api(IHuayangPluginNewDownloader.class);
                iHuayangPluginNewDownloader.init(context.getApplicationContext(), a(context), str2);
                f238257a.put(str3, iHuayangPluginNewDownloader);
            }
        }
        return iHuayangPluginNewDownloader;
    }
}

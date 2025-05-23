package com.tencent.smtt.sdk.plugin;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static b f369491a;

    b(Context context) {
        super(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f369491a == null) {
                f369491a = new b(context);
            }
            bVar = f369491a;
        }
        return bVar;
    }

    public synchronized boolean b() {
        File c16 = c("tbs_plugin_filereader.zip");
        String a16 = a.a(c16);
        if (a(a16, "tbs_plugin_filereader_md5_key")) {
            a.a("installFileReaderPlugin, already installed");
            return true;
        }
        if (!a(c16, a16)) {
            a.a("installFileReaderPlugin, prepare fail.");
            return false;
        }
        boolean a17 = a("tbs_plugin_filereader_prepared_path_key", "tbs_plugin_filereader_prepared_md5_key", "tbs_plugin_filereader_path_key", "tbs_plugin_filereader_md5_key");
        a.a("installFileReaderPlugin, result:" + a17);
        return a17;
    }

    private boolean a(File file, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a16 = a(file, str, "com.tencent.qb.plugin.filereader.prepared_", "tbs_plugin_filereader_prepared_md5_key", "tbs_plugin_filereader_prepared_path_key");
        a.a("filereader:prepareFileReaderPlugin consume time:" + (System.currentTimeMillis() - currentTimeMillis) + ", prepareSuccess:" + a16);
        return a16;
    }
}

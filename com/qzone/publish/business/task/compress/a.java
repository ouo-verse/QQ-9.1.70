package com.qzone.publish.business.task.compress;

import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static boolean a() {
        return LocalMultiProcConfig.getInt(LocalMultiProcConfig.Constants.KEY_UPLOAD_KEEP_VIDEO_CACHE, 0) == 1;
    }
}

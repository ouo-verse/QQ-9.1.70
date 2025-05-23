package com.tencent.turingcam;

import android.media.MediaDrm;
import android.os.Build;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public class wBKEO {
    public static String a(long j3, long j16) {
        MediaDrm mediaDrm;
        try {
            UUID uuid = new UUID(j3, j16);
            mediaDrm = new MediaDrm(uuid);
            try {
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                if (propertyByteArray.length == 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            mediaDrm.close();
                        } else {
                            mediaDrm.release();
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
                String str = uuid + ":" + Ckq8l.a(propertyByteArray);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.close();
                    } else {
                        mediaDrm.release();
                    }
                } catch (Throwable unused2) {
                }
                return str;
            } catch (Throwable unused3) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (mediaDrm != null) {
                            mediaDrm.close();
                        }
                    } else if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } catch (Throwable unused4) {
                }
                return null;
            }
        } catch (Throwable unused5) {
            mediaDrm = null;
        }
    }
}

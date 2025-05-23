package com.tencent.luggage.wxa.s9;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends MediaPlayer {
    public h() {
        d.a(hashCode());
    }

    @Override // android.media.MediaPlayer
    public void release() {
        super.release();
        d.b(hashCode());
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(String str) {
        try {
            ParcelFileDescriptor c16 = x.c(str, "r");
            try {
                setDataSource(c16.getFileDescriptor());
                c16.close();
            } finally {
            }
        } catch (FileNotFoundException e16) {
            w.f("MicroMsg.MediaPlayerWrapper", "Cannot find path: " + str + ", " + e16.getMessage());
            super.setDataSource(str);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri) {
        if (com.tencent.luggage.wxa.aa.a.c(26)) {
            setDataSource(context, uri, null, null);
        } else {
            setDataSource(context, uri, (Map) null);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map map) {
        if (com.tencent.luggage.wxa.aa.a.c(26)) {
            setDataSource(context, uri, map, null);
            return;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file") && !scheme.equals("wcf") && !scheme.equals("assets")) {
            super.setDataSource(context, uri, (Map<String, String>) map);
            return;
        }
        ParcelFileDescriptor a16 = x.a(uri, "r");
        try {
            setDataSource(a16.getFileDescriptor());
            a16.close();
        } catch (Throwable th5) {
            if (a16 != null) {
                try {
                    a16.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map map, List list) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file") && !scheme.equals("wcf") && !scheme.equals("assets")) {
            super.setDataSource(context, uri, map, list);
            return;
        }
        ParcelFileDescriptor a16 = x.a(uri, "r");
        try {
            setDataSource(a16.getFileDescriptor());
            a16.close();
        } catch (Throwable th5) {
            if (a16 != null) {
                try {
                    a16.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }
}

package com.tencent.luggage.wxa.ba;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.x;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends MediaMetadataRetriever {
    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str) {
        try {
            ParcelFileDescriptor c16 = x.c(str, "r");
            try {
                setDataSource(c16.getFileDescriptor());
                c16.close();
            } finally {
            }
        } catch (IOException e16) {
            com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSMediaMetadataRetriever", "Cannot find path: " + str + ", " + e16.getMessage());
            super.setDataSource(str);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str, Map map) {
        String scheme = Uri.parse(str).getScheme();
        if (scheme == null || scheme.equals("file") || scheme.equals("wcf") || scheme.equals("assets")) {
            try {
                ParcelFileDescriptor c16 = x.c(str, "r");
                try {
                    setDataSource(c16.getFileDescriptor());
                    c16.close();
                    return;
                } finally {
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSMediaMetadataRetriever", "Cannot open URI: " + str + ", " + e16.getMessage());
            }
        }
        super.setDataSource(str, (Map<String, String>) map);
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("file") || scheme.equals("wcf") || scheme.equals("assets")) {
            try {
                ParcelFileDescriptor a16 = x.a(uri, "r");
                try {
                    setDataSource(a16.getFileDescriptor());
                    a16.close();
                    return;
                } finally {
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSMediaMetadataRetriever", "Cannot open URI: " + uri + ", " + e16.getMessage());
            }
        }
        super.setDataSource(context, uri);
    }
}

package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ro extends UrlTileProvider {

    /* renamed from: a, reason: collision with root package name */
    static int f150110a = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f150111c = 256;

    /* renamed from: b, reason: collision with root package name */
    TileOverlayOptions f150112b;

    public ro(TileOverlayOptions tileOverlayOptions) {
        super(256, 256);
        this.f150112b = tileOverlayOptions;
        int a16 = rm.a();
        f150110a = a16;
        TileOverlayOptions tileOverlayOptions2 = this.f150112b;
        if (tileOverlayOptions2 != null) {
            tileOverlayOptions2.versionInfo(Integer.toString(a16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return Integer.toString(f150110a);
    }

    private void b() {
        int a16 = rm.a();
        f150110a = a16;
        TileOverlayOptions tileOverlayOptions = this.f150112b;
        if (tileOverlayOptions != null) {
            tileOverlayOptions.versionInfo(Integer.toString(a16));
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public final URL getTileUrl(int i3, int i16, int i17) {
        String sketchTileUrl = ((dj) ((dy) cr.a(dy.class)).i()).sketchTileUrl(i3, (int) ((Math.pow(2.0d, i17) - 1.0d) - i16), i17, f150110a);
        try {
            if (!TextUtils.isEmpty(sketchTileUrl)) {
                return new URL(sketchTileUrl);
            }
            return null;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

package com.tencent.richframework.widget.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class ImageSource {
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    ImageSource(@NonNull Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    @NonNull
    public static ImageSource asset(@NonNull String str) {
        if (str != null) {
            return uri("file:///android_asset/" + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    @NonNull
    public static ImageSource resource(int i3) {
        return new ImageSource(i3);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    @NonNull
    public static ImageSource uri(@NonNull String str) {
        if (str != null) {
            if (!str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = "file:///" + str;
            }
            return new ImageSource(Uri.parse(str));
        }
        throw new NullPointerException("Uri must not be null");
    }

    @NonNull
    public ImageSource dimensions(int i3, int i16) {
        if (this.bitmap == null) {
            this.sWidth = i3;
            this.sHeight = i16;
        }
        setInvariants();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Integer getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSHeight() {
        return this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Rect getSRegion() {
        return this.sRegion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSWidth() {
        return this.sWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getTile() {
        return this.tile;
    }

    public Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isCached() {
        return this.cached;
    }

    @NonNull
    public ImageSource tiling(boolean z16) {
        this.tile = z16;
        return this;
    }

    @NonNull
    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    ImageSource(int i3) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i3);
        this.tile = true;
    }
}

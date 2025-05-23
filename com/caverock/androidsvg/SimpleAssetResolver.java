package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Log;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public class SimpleAssetResolver extends SVGExternalFileResolver {
    private static final String TAG = "SimpleAssetResolver";
    private static final Set<String> supportedFormats = new HashSet(8);
    private AssetManager assetManager;

    public SimpleAssetResolver(AssetManager assetManager) {
        Set<String> set = supportedFormats;
        set.add("image/svg+xml");
        set.add("image/jpeg");
        set.add("image/png");
        set.add("image/pjpeg");
        set.add("image/gif");
        set.add(MimeHelper.IMAGE_BMP);
        set.add("image/x-windows-bmp");
        set.add("image/webp");
        this.assetManager = assetManager;
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public boolean isFormatSupported(String str) {
        return supportedFormats.contains(str);
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Typeface resolveFont(String str, int i3, String str2) {
        Log.i(TAG, "resolveFont(" + str + "," + i3 + "," + str2 + ")");
        try {
            try {
                return Typeface.createFromAsset(this.assetManager, String.valueOf(str) + ".ttf");
            } catch (Exception unused) {
                return Typeface.createFromAsset(this.assetManager, String.valueOf(str) + ".otf");
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Bitmap resolveImage(String str) {
        Log.i(TAG, "resolveImage(" + str + ")");
        try {
            return BitmapFactory.decodeStream(this.assetManager.open(str));
        } catch (IOException unused) {
            return null;
        }
    }
}

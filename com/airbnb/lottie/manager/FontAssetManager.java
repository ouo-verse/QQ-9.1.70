package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class FontAssetManager {
    private final AssetManager assetManager;

    @Nullable
    private FontAssetDelegate delegate;
    private final MutablePair<String> tempPair = new MutablePair<>();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final Map<String, Typeface> fontFamilies = new HashMap();
    private String defaultFontFileExtension = ".ttf";

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
        } else {
            this.assetManager = ((View) callback).getContext().getAssets();
        }
    }

    private Typeface getFontFamily(String str) {
        Typeface typeface;
        String fontPath;
        Typeface typeface2 = this.fontFamilies.get(str);
        if (typeface2 != null) {
            return typeface2;
        }
        FontAssetDelegate fontAssetDelegate = this.delegate;
        if (fontAssetDelegate != null) {
            typeface = fontAssetDelegate.fetchFont(str);
        } else {
            typeface = null;
        }
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (fontAssetDelegate2 != null && typeface == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            typeface = Typeface.createFromAsset(this.assetManager, fontPath);
        }
        if (typeface == null) {
            String str2 = "fonts/" + str + this.defaultFontFileExtension;
            if (g.f211804a) {
                typeface = Typeface.createFromAsset(this.assetManager, str2);
            } else {
                try {
                    typeface = Typeface.createFromAsset(this.assetManager, str2);
                } catch (Exception e16) {
                    Log.e("Lottie.FontAssetManager", "path " + str2 + ProgressTracer.SEPARATOR + e16.getMessage());
                    typeface = Typeface.DEFAULT;
                }
            }
        }
        this.fontFamilies.put(str, typeface);
        return typeface;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        int i3;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i3 = 3;
        } else if (contains) {
            i3 = 2;
        } else if (contains2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (typeface.getStyle() == i3) {
            return typeface;
        }
        return Typeface.create(typeface, i3);
    }

    public Typeface getTypeface(String str, String str2) {
        this.tempPair.set(str, str2);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceForStyle = typefaceForStyle(getFontFamily(str), str2);
        this.fontMap.put(this.tempPair, typefaceForStyle);
        return typefaceForStyle;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}

package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.tavsticker.constant.TAVStickerConst;
import java.io.File;
import org.libpag.PAGFont;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVFontManager {
    private static final int CACHE_SIZE = 10;
    private static final String TAG = "TAVFontManager";
    private static volatile TAVFontManager sInstance;
    private LruCache<String, PAGFont> mapPagFont;

    TAVFontManager() {
        this.mapPagFont = null;
        this.mapPagFont = new LruCache<>(10);
    }

    private void checkPAGFontMap() {
        if (this.mapPagFont == null) {
            this.mapPagFont = new LruCache<>(10);
        }
    }

    public static TAVFontManager getInstance() {
        if (sInstance == null) {
            synchronized (TAVFontManager.class) {
                if (sInstance == null) {
                    sInstance = new TAVFontManager();
                }
            }
        }
        return sInstance;
    }

    private boolean registerFontWithPath(String str) {
        PAGFont RegisterFont;
        checkPAGFontMap();
        if (this.mapPagFont.get(str) != null) {
            return true;
        }
        if (!new File(str).exists() || (RegisterFont = PAGFont.RegisterFont(str)) == null) {
            return false;
        }
        this.mapPagFont.put(str, RegisterFont);
        return true;
    }

    public PAGFont fontWithAssetPath(Context context, String str) {
        checkPAGFontMap();
        PAGFont pAGFont = this.mapPagFont.get(TAVStickerConst.ASSET_FILE_PATH_PREFIX + str);
        if (pAGFont != null) {
            return pAGFont;
        }
        if (context != null && !TextUtils.isEmpty(str) && (pAGFont = PAGFont.RegisterFont(context.getAssets(), str)) != null) {
            this.mapPagFont.put(TAVStickerConst.ASSET_FILE_PATH_PREFIX + str, pAGFont);
        }
        return pAGFont;
    }

    public PAGFont fontWithPath(String str) {
        if (registerFontWithPath(str)) {
            return this.mapPagFont.get(str);
        }
        return null;
    }
}

package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.tavsticker.constant.TAVStickerConst;
import java.io.File;
import org.libpag.PAGFile;

/* loaded from: classes26.dex */
public class TAVPAGFileManager {
    private static final int CACHE_SIZE = 10;
    private static final String TAG = "TAVPAGFileManager";
    private static volatile TAVPAGFileManager sInstance;
    private LruCache<String, PAGFile> mapPagFile;

    TAVPAGFileManager() {
        this.mapPagFile = null;
        this.mapPagFile = new LruCache<>(10);
    }

    private void checkPAGFileMap() {
        if (this.mapPagFile == null) {
            this.mapPagFile = new LruCache<>(10);
        }
    }

    public static TAVPAGFileManager getInstance() {
        if (sInstance == null) {
            synchronized (TAVPAGFileManager.class) {
                if (sInstance == null) {
                    sInstance = new TAVPAGFileManager();
                }
            }
        }
        return sInstance;
    }

    public void clearCache() {
        try {
            checkPAGFileMap();
            this.mapPagFile.evictAll();
            System.gc();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public PAGFile getPAGFileFromAsset(Context context, String str) {
        checkPAGFileMap();
        if (context != null && !TextUtils.isEmpty(str)) {
            PAGFile pAGFile = this.mapPagFile.get(TAVStickerConst.ASSET_FILE_PATH_PREFIX + str);
            if (pAGFile != null) {
                return pAGFile.copyOriginal();
            }
            PAGFile Load = PagViewMonitor.Load(context.getAssets(), str);
            if (Load != null) {
                this.mapPagFile.put(TAVStickerConst.ASSET_FILE_PATH_PREFIX + str, Load);
                return Load;
            }
            return Load;
        }
        return null;
    }

    public PAGFile getPAGFileFromByteArray(byte[] bArr) {
        checkPAGFileMap();
        if (bArr != null && bArr.length > 0) {
            return PAGFile.Load(bArr);
        }
        return null;
    }

    public PAGFile getPAGFileFromPath(String str) {
        checkPAGFileMap();
        if (!TextUtils.isEmpty(str)) {
            PAGFile pAGFile = this.mapPagFile.get(str);
            if (pAGFile != null) {
                return pAGFile.copyOriginal();
            }
            if (new File(str).exists()) {
                PAGFile Load = PagViewMonitor.Load(str);
                if (Load != null) {
                    this.mapPagFile.put(str, Load);
                    return Load;
                }
                return Load;
            }
            return pAGFile;
        }
        return null;
    }
}

package com.qzone.widget.util;

import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.qzone.util.m;
import com.qzone.widget.util.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ZipLoadBitmapGenerator implements c.b, QzoneZipCacheHelperCallBack {
    private static final String TAG = "ZipLoadBitmapGenerator";
    private final Map<String, Bitmap> bitmapMap = new HashMap();
    private List<String> fileNameList;
    private boolean isDownload;
    private volatile boolean isPreLoadImg;
    private a loadListener;
    private String path;
    private final String url;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void onLoad(boolean z16);
    }

    public ZipLoadBitmapGenerator(String str) {
        this.url = str;
        loadUrl();
    }

    private int getImgSize() {
        List<String> list = this.fileNameList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getZipDrawableDirSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.valueOf(str.hashCode());
    }

    private void loadUrl() {
        if (URLUtil.isNetworkUrl(this.url)) {
            loadZip();
        } else {
            updatePath(this.url);
        }
    }

    @Override // com.qzone.widget.util.c.b
    public Bitmap generateBitmap(String str, String str2) {
        if (getImgSize() == 0) {
            return m.e();
        }
        Bitmap bitmap = this.bitmapMap.get(str);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap a16 = m.a(this.path + File.separator + str);
        if (a16 != null) {
            this.bitmapMap.put(str, a16);
            return a16;
        }
        return m.e();
    }

    public List<String> getBitmapIdList() {
        return this.fileNameList;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isLoadFailed() {
        return this.isDownload && getImgSize() == 0;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
    public void onResultOfNativeRequest(boolean z16, final String str, String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            updatePath(str);
        } else {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.widget.util.ZipLoadBitmapGenerator.3
                @Override // java.lang.Runnable
                public void run() {
                    ZipLoadBitmapGenerator.this.updatePath(str);
                }
            });
        }
    }

    public void preLoadImg() {
        if (this.isPreLoadImg || !this.isDownload || getImgSize() == 0) {
            return;
        }
        this.isPreLoadImg = true;
        preLoadImg(0);
    }

    public void reLoad() {
        if (this.isDownload) {
            recycle();
            this.fileNameList = null;
            loadUrl();
        }
    }

    private void loadZip() {
        this.isDownload = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.widget.util.ZipLoadBitmapGenerator.1
            @Override // java.lang.Runnable
            public void run() {
                IQzoneZipCacheHelper iQzoneZipCacheHelper = (IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class);
                String str = ZipLoadBitmapGenerator.this.url;
                ZipLoadBitmapGenerator zipLoadBitmapGenerator = ZipLoadBitmapGenerator.this;
                iQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str, ZipDrawableLoader.DEFAULT_BUSINESS, zipLoadBitmapGenerator.getZipDrawableDirSuffix(zipLoadBitmapGenerator.url), -1, ZipLoadBitmapGenerator.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePath(String str) {
        this.isDownload = true;
        this.path = str;
        String[] fileList = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getFileList(str);
        if (fileList != null && fileList.length != 0) {
            this.fileNameList = Arrays.asList(fileList);
        } else {
            this.fileNameList = Collections.emptyList();
        }
        a aVar = this.loadListener;
        if (aVar != null) {
            aVar.onLoad(getImgSize() > 0);
        }
    }

    public void recycle() {
        this.isPreLoadImg = false;
        for (Bitmap bitmap : this.bitmapMap.values()) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        this.bitmapMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preLoadImg(final int i3) {
        if (!this.isPreLoadImg) {
            Log.i(TAG, "preLoadImg: interrupt " + i3);
            return;
        }
        if (i3 >= this.fileNameList.size()) {
            this.isPreLoadImg = false;
            Log.i(TAG, "preLoadImg: all pre load " + i3);
        }
        final String str = this.fileNameList.get(0);
        if (this.bitmapMap.get(str) != null) {
            this.isPreLoadImg = false;
            Log.i(TAG, "preLoadImg: over " + i3);
            return;
        }
        final String str2 = this.path + File.separator + str;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.widget.util.ZipLoadBitmapGenerator.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ZipLoadBitmapGenerator.this.isPreLoadImg) {
                    Log.i(ZipLoadBitmapGenerator.TAG, "preLoadImg: interrupt run " + i3);
                    return;
                }
                final Bitmap a16 = m.a(str2);
                QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.widget.util.ZipLoadBitmapGenerator.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ZipLoadBitmapGenerator.this.isPreLoadImg) {
                            Log.i(ZipLoadBitmapGenerator.TAG, "preLoadImg: interrupt run run " + i3);
                            return;
                        }
                        if (ZipLoadBitmapGenerator.this.bitmapMap.get(str) != null) {
                            Log.i(ZipLoadBitmapGenerator.TAG, "preLoadImg: over run " + i3);
                            ZipLoadBitmapGenerator.this.isPreLoadImg = false;
                            return;
                        }
                        if (a16 != null) {
                            ZipLoadBitmapGenerator.this.bitmapMap.put(str, a16);
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ZipLoadBitmapGenerator.this.preLoadImg(i3 + 1);
                    }
                });
            }
        });
    }

    public void setLoadListener(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.isDownload) {
            aVar.onLoad(getImgSize() > 0);
        } else {
            this.loadListener = aVar;
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
    public void onResult(boolean z16) {
    }
}

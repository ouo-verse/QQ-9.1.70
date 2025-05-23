package com.tenpay.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.download.HttpOpGetFile;
import com.tenpay.util.Utils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageDownLoader {
    private static final String TAG = "ImageDownLoader";
    private int height;
    protected Context mContext;
    public String mImagePath;
    protected HashMap<String, SoftReference<Bitmap>> mLocalImageMap;
    private boolean onlyTop;
    private int radiusInPx;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LoadImgTask extends AsyncTask<String, Void, Bitmap> {
        String imageUrl;
        OnGetResult mCallback;

        public LoadImgTask(String str, OnGetResult onGetResult) {
            this.imageUrl = str;
            this.mCallback = onGetResult;
        }

        private synchronized void addImageToCache(String str, Bitmap bitmap) {
            ImageDownLoader.this.mLocalImageMap.put(str, new SoftReference<>(bitmap));
            QwLog.i("\u672c\u5730\u4fdd\u5b58\u4e86\u56fe\u7247\uff0c\u4ece\u672c\u5730\u52a0\u8f7d" + str);
        }

        private Bitmap loadFromLocal(String str, String str2) {
            String str3 = str + str2;
            File file = new File(str3);
            if (file.exists()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str3);
                if (decodeFile == null) {
                    file.delete();
                    return decodeFile;
                }
                addImageToCache(str2, decodeFile);
                return decodeFile;
            }
            return null;
        }

        private void loadFromServer(String str, String str2) {
            QwLog.i("\u7f13\u5b58\u6ca1\u6709\uff0c\u5f00\u59cb\u4e0b\u8f7d:" + str2);
            HttpOpGetFile httpOpGetFile = new HttpOpGetFile();
            httpOpGetFile.setFilePathName(str, str2);
            httpOpGetFile.startRun(ImageDownLoader.this.mContext, this.imageUrl);
            QwLog.i("\u4e0b\u8f7d\u5b8c\u6210");
        }

        protected Bitmap handleLogic(String... strArr) {
            try {
                String str = strArr[1];
                Bitmap loadFromLocal = loadFromLocal(strArr[0], str);
                if (loadFromLocal == null) {
                    if (strArr.length > 2) {
                        for (int i3 = 2; i3 < strArr.length && (loadFromLocal = loadFromLocal(strArr[i3], str)) == null; i3++) {
                        }
                    }
                }
                if (loadFromLocal == null) {
                    loadFromServer(strArr[0], str);
                    return loadFromLocal(strArr[0], str);
                }
                return loadFromLocal;
            } catch (Exception e16) {
                QLog.e(ImageDownLoader.TAG, 1, "", e16);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            File file = new File(strArr[0]);
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            return handleLogic(strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            this.mCallback.getResult(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class OnDownloadedListener implements OnGetResult {
        private Object defFile;
        private View view;

        public OnDownloadedListener(View view, Object obj) {
            this.view = view;
            this.defFile = obj;
        }

        @Override // com.tenpay.sdk.util.OnGetResult
        public void getResult(Object obj) {
            if (obj == null) {
                obj = this.defFile;
            }
            this.defFile = obj;
            if (obj instanceof Bitmap) {
                ImageDownLoader.this.setViewBackground(this.view, (Bitmap) obj);
            }
        }
    }

    public ImageDownLoader(Context context) {
        String str;
        if (context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mLocalImageMap = new HashMap<>();
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            str = cacheDir.getAbsolutePath() + "/";
        } else {
            str = Cgi.DEFAULT_CACHE_ROOT;
        }
        this.mImagePath = str;
        QwLog.i(str);
        this.radiusInPx = 0;
        this.onlyTop = false;
        this.height = 0;
        this.width = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void setViewBackground(View view, Bitmap bitmap) {
        int i3;
        int i16 = this.width;
        if (i16 != 0 && (i3 = this.height) != 0) {
            bitmap = Utils.zoomBitmap(bitmap, i16, i3);
        }
        int i17 = this.radiusInPx;
        if (i17 > 0) {
            bitmap = Utils.getRoundedCornerBitmap(bitmap, i17, this.onlyTop);
        }
        if (bitmap != null) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
            } else {
                view.setBackground(new BitmapDrawable(this.mContext.getResources(), bitmap));
            }
        }
    }

    public void setImage(String str, OnGetResult onGetResult) {
        setImage(str, null, null, onGetResult, null, false);
    }

    private void setImage(String str, View view, Bitmap bitmap, OnGetResult onGetResult, String[] strArr, boolean z16) {
        Bitmap bitmap2;
        SoftReference<Bitmap> softReference;
        String md5 = QFuncProxy.toMD5(str);
        if (!this.mLocalImageMap.containsKey(md5) || (softReference = this.mLocalImageMap.get(md5)) == null) {
            bitmap2 = null;
        } else {
            bitmap2 = softReference.get();
            QwLog.i("\u7f13\u5b58\u6709\uff0c\u76f4\u63a5\u7f13\u5b58\u52a0\u8f7d:" + md5);
        }
        if (bitmap2 != null) {
            if (view != null) {
                setViewBackground(view, bitmap2);
            }
            if (onGetResult != null) {
                onGetResult.getResult(bitmap2);
                return;
            }
            return;
        }
        if (onGetResult == null) {
            onGetResult = new OnDownloadedListener(view, bitmap);
        }
        if (strArr == null) {
            strArr = new String[]{this.mImagePath, md5};
        }
        if (z16) {
            new LoadImgTask(str, onGetResult).executeOnExecutor(ProxyExecutors.newCachedThreadPool(), strArr);
        } else {
            new LoadImgTask(str, onGetResult).execute(strArr);
        }
    }
}

package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MediaUtils {
    private static final String TAG = "MediaUtils";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LoadVideoImageTask extends AsyncTask<String, Integer, File> {
        private OnLoadVideoImageListener listener;
        private IMiniAppContext miniAppContext;

        public LoadVideoImageTask(IMiniAppContext iMiniAppContext, OnLoadVideoImageListener onLoadVideoImageListener) {
            this.listener = onLoadVideoImageListener;
            this.miniAppContext = iMiniAppContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x0004, B:5:0x0015, B:8:0x001f, B:9:0x002b, B:13:0x0034, B:15:0x0050, B:23:0x0067, B:18:0x007c, B:24:0x0023, B:17:0x0053), top: B:2:0x0004, inners: #1 }] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public File doInBackground(String... strArr) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    mediaMetadataRetriever.setDataSource(str);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    if (this.miniAppContext != null) {
                        return null;
                    }
                    File file = new File(((MiniAppFileManager) this.miniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
                    if (file.exists()) {
                        file.delete();
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e16) {
                        Log.i(MediaUtils.TAG, "doInBackground: " + str, e16);
                    }
                    mediaMetadataRetriever.release();
                    return file;
                }
                mediaMetadataRetriever.setDataSource(str, new HashMap());
                Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime();
                if (this.miniAppContext != null) {
                }
            } catch (Exception e17) {
                QMLog.e(MediaUtils.TAG, "getImageForVideo error." + e17);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(File file) {
            super.onPostExecute((LoadVideoImageTask) file);
            OnLoadVideoImageListener onLoadVideoImageListener = this.listener;
            if (onLoadVideoImageListener != null) {
                onLoadVideoImageListener.onLoadImage(file);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnLoadVideoImageListener {
        void onLoadImage(File file);
    }

    public static void getImageForVideo(IMiniAppContext iMiniAppContext, String str, OnLoadVideoImageListener onLoadVideoImageListener) {
        new LoadVideoImageTask(iMiniAppContext, onLoadVideoImageListener).execute(str);
    }
}

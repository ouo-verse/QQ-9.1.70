package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ScreenCapture {
    static IPatchRedirector $redirector_ = null;
    public static final String SNAP_CACHE_FILE = "snap_cache";
    public static final String SNAP_CACHE_FILE_SUCCESS_KEY = "snap_cache_file_success_key";
    private static final String TAG = "ScreenCapture";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class AsyncCaptureSnapTask extends AsyncTask<String, Void, Boolean> {
        static IPatchRedirector $redirector_;
        private Bitmap mCache;
        private WeakReference<View> mWillCachedView;

        public AsyncCaptureSnapTask(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            if (view != null) {
                Context context = view.getContext();
                this.mWillCachedView = new WeakReference<>(view);
                view.setDrawingCacheEnabled(true);
                this.mCache = view.getDrawingCache();
                ScreenCapture.setSnapFile(context, false);
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            }
            Boolean bool = Boolean.FALSE;
            if (isCancelled() || this.mWillCachedView.get() == null || (bitmap = this.mCache) == null || bitmap.isRecycled()) {
                return bool;
            }
            Bitmap bitmap2 = this.mCache;
            File file = new File(strArr[0]);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return Boolean.TRUE;
            } catch (IOException e16) {
                e16.printStackTrace();
                return bool;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bool);
                return;
            }
            WeakReference<View> weakReference = this.mWillCachedView;
            if (weakReference == null || (view = weakReference.get()) == null) {
                return;
            }
            if (bool.booleanValue()) {
                ScreenCapture.setSnapFile(view.getContext(), true);
            }
            this.mCache = null;
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();
        }
    }

    public ScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void captureViewToFile(String str, View view) {
        if (str != null && view != null) {
            QLog.i("sethmao", 4, "path is " + str);
            new AsyncCaptureSnapTask(view).execute(str);
        }
    }

    public static void clearSnapCacheFile(Context context) {
        ThreadManagerV2.excute(new Runnable(context) { // from class: com.tencent.mobileqq.activity.fling.ScreenCapture.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f182249d;

            {
                this.f182249d = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ScreenCapture.deleteDir(new File(ScreenCapture.getSnapDir(this.f182249d)));
                }
            }
        }, 64, null, false);
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String getSnapDir(Context context) {
        return context.getFilesDir() + "/snap";
    }

    public static String getSnapPath(Context context, int i3) {
        return context.getFilesDir() + "/snap/" + i3;
    }

    public static boolean hasSnapFile(Context context) {
        return context.getSharedPreferences(SNAP_CACHE_FILE, 0).getBoolean(SNAP_CACHE_FILE_SUCCESS_KEY, false);
    }

    public static void setSnapFile(Context context, boolean z16) {
        QLog.i("sethmao", 4, "captured is " + z16 + ", success is " + context.getSharedPreferences(SNAP_CACHE_FILE, 0).edit().putBoolean(SNAP_CACHE_FILE_SUCCESS_KEY, z16).commit() + ", has snap file is " + hasSnapFile(context));
    }
}

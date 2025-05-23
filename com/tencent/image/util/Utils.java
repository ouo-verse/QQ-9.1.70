package com.tencent.image.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Utils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "URLDrawable.Utils";

    Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @TargetApi(11)
    public static <Params, Progress, Result> void executeAsyncTaskOnSerialExcuter(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramsArr);
    }

    @SuppressLint({"NewApi"})
    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getByteCount();
    }

    public static boolean hasExternalCacheDir() {
        return true;
    }

    public static boolean hasHttpConnectionBug() {
        return false;
    }
}

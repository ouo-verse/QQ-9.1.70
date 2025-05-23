package com.tencent.mobileqq.videocodec.ffmpeg;

import android.annotation.TargetApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import hd0.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(14)
/* loaded from: classes20.dex */
public class Util {
    static IPatchRedirector $redirector_;

    Util() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] concatenate(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String convertInputStreamToString(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (IOException e16) {
            c.h(FFmpeg.TAG, "error converting input stream to string", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void destroyProcess(Process process) {
        if (process != null) {
            process.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isProcessCompleted(Process process) {
        if (process == null) {
            return true;
        }
        try {
            process.exitValue();
            if (QLog.isColorLevel()) {
                QLog.d(FFmpeg.TAG, 2, "isProcessCompleted: true  in  process.exitValue()");
            }
            return true;
        } catch (IllegalThreadStateException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(FFmpeg.TAG, 2, "IllegalThreadStateException e, ", e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void killFFmpegProcess(FFmpegExecuteAsyncTask fFmpegExecuteAsyncTask) {
        if (fFmpegExecuteAsyncTask != null && !fFmpegExecuteAsyncTask.isProcessCompleted()) {
            Process process = fFmpegExecuteAsyncTask.mProcess;
            if (process != null) {
                process.destroy();
                fFmpegExecuteAsyncTask.mProcess = null;
            }
            if (!fFmpegExecuteAsyncTask.isCancelled()) {
                fFmpegExecuteAsyncTask.cancel(true);
            }
            c.i(FFmpeg.TAG, "kill ffmpeg task", Arrays.toString(fFmpegExecuteAsyncTask.cmd));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean setFileExecutable(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (!file.canExecute() && !file.setExecutable(true)) {
            return false;
        }
        return true;
    }
}

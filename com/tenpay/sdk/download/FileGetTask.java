package com.tenpay.sdk.download;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileGetTask extends AsyncTask<String, Void, String> {
    private static final String TAG = "FileGetTask";
    private Context ctx;

    /* renamed from: l, reason: collision with root package name */
    private Listener f386852l;
    private String url;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Listener {
        void onDownload(String str);
    }

    public FileGetTask(Context context, String str, Listener listener) {
        this.ctx = context;
        this.url = str;
        this.f386852l = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        QwLog.i("start download...");
        if (strArr.length < 2) {
            QwLog.i("parameters error...");
            return null;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            HttpOpGetFile httpOpGetFile = new HttpOpGetFile();
            httpOpGetFile.setFilePathName(strArr[0], strArr[1]);
            httpOpGetFile.startRun(this.ctx, this.url);
            return strArr[0] + strArr[1];
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        QwLog.i("download over filePath = " + str);
        Listener listener = this.f386852l;
        if (listener != null) {
            listener.onDownload(str);
        }
    }
}

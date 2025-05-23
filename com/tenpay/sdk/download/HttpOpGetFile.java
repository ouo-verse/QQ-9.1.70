package com.tenpay.sdk.download;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.proxy.DataProxy;
import com.tenpay.util.Utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpOpGetFile extends HttpOp {
    private static final String TAG = "HttpOpGetFile";
    private String mTempFilePath = DataProxy.getTenpayExternalPath();
    private String mFileName = "download.tmp";
    private String mFilePath = null;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    private boolean saveFile(Bundle bundle, InputStream inputStream) {
        ?? r26;
        if (inputStream == null) {
            return false;
        }
        String str = this.mTempFilePath + this.mFileName;
        this.mFilePath = str;
        QwLog.i(str);
        File file = new File(this.mFilePath);
        if (file.exists() || file.isDirectory()) {
            file.delete();
        }
        Closeable closeable = null;
        Closeable closeable2 = null;
        try {
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        r26 = this.mIsNeedStop;
                        if (r26 != 0 || (r26 = inputStream.read(bArr)) <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, r26);
                    }
                    Utils.closeObject(fileOutputStream);
                    closeable = r26;
                } catch (Exception unused) {
                    closeable2 = fileOutputStream;
                    QwLog.i("save image exception");
                    Utils.closeObject(closeable2);
                    closeable = closeable2;
                    Utils.closeObject(inputStream);
                    op_ok(bundle);
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    closeable = fileOutputStream;
                    Utils.closeObject(closeable);
                    Utils.closeObject(inputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            }
            Utils.closeObject(inputStream);
            op_ok(bundle);
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tenpay.sdk.download.HttpOp
    protected void addHttpBody(Bundle bundle, InputStream inputStream) {
        QwLog.i("-------------heads-------------------");
        if (saveFile(bundle, inputStream)) {
            bundle.putString(HttpOp.HTTP_TMP_FNAME, this.mFilePath);
        } else {
            bundle.putString(HttpOp.HTTP_TMP_FNAME, null);
        }
    }

    public void setFileName(String str) {
        if (str != null) {
            this.mFileName = str;
        }
    }

    public void setFilePathName(String str, String str2) {
        if (str2 != null) {
            this.mFileName = str2;
        }
        if (str != null) {
            this.mTempFilePath = str;
        }
    }

    @Override // com.tenpay.sdk.download.HttpOp
    public Bundle startRun(Context context, String str) {
        return startRun(context, str, true);
    }

    public Bundle startRun(Context context, String str, boolean z16) {
        InputStream inputStream;
        int i3;
        HttpURLConnection createHttp;
        QwLog.i("startRun()!");
        Bundle bundle = new Bundle();
        op_failed(bundle);
        InputStream inputStream2 = null;
        try {
            try {
                createHttp = createHttp(str, context);
                this.mHttp = createHttp;
            } catch (SocketTimeoutException e16) {
                e = e16;
                inputStream = null;
                i3 = 0;
            }
        } catch (Throwable th5) {
            try {
                QLog.e(TAG, 1, "", th5);
                op_failed(bundle);
            } catch (Throwable th6) {
                th = th6;
                Utils.closeObject(inputStream2);
                throw th;
            }
        }
        if (createHttp == null) {
            Utils.closeObject(null);
            return null;
        }
        createHttp.setRequestMethod("GET");
        int responseCode = this.mHttp.getResponseCode();
        try {
            bundle.putInt("status", responseCode);
            QwLog.i("http status = " + responseCode);
        } catch (SocketTimeoutException e17) {
            e = e17;
            inputStream = null;
            i3 = responseCode;
            try {
                QLog.e(TAG, 1, "", e);
                op_timeout(bundle);
                try {
                } catch (Throwable th7) {
                    QLog.e(TAG, 1, "", th7);
                }
                if (isV6Ip(this.mRecord.mInnerIp) && isRetryWhenIpFailed(z16, context, str, i3, e)) {
                    Bundle startRun = startRun(context, str, false);
                    Utils.closeObject(inputStream);
                    return startRun;
                }
                QwLog.i("no need to retry...e:" + e.toString());
                Utils.closeObject(inputStream);
                return bundle;
            } catch (Throwable th8) {
                th = th8;
                inputStream2 = inputStream;
                Utils.closeObject(inputStream2);
                throw th;
            }
        }
        if (responseCode != 200 && responseCode != 206) {
            this.mHttp.disconnect();
            Utils.closeObject(null);
            return bundle;
        }
        addHttpHeader(context, bundle, this.mHttp);
        inputStream2 = this.mHttp.getInputStream();
        addHttpBody(bundle, inputStream2);
        Utils.closeObject(inputStream2);
        return bundle;
    }
}

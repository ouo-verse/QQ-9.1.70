package com.tencent.qqlive.tvkplayer.logo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.tencent.qqlive.tvkplayer.thirdparties.FileSystem;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKIOUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKImageLoader;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoDownloader extends AsyncTask<String, Void, Bitmap> {
    public static final int NET_ERROR = 10001;
    public static final int OTHER_ERROR = 10002;
    private static final String TAG = "TVKLogoDownloader";
    private int errCode;
    private CallBack mCallback;
    private final Context mContext;
    private String mHttpsImageUrl;
    private String mMd5;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface CallBack {
        void onFailure(int i3);

        void onSuccess(Bitmap bitmap);
    }

    public TVKLogoDownloader(Context context, CallBack callBack) {
        this.errCode = 0;
        this.mCallback = callBack;
        this.mContext = context;
    }

    private void deleteImageFile(File file) {
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e16) {
                TVKLogUtil.w(TAG, e16.toString());
            }
        }
    }

    private boolean downloadFromPath() {
        return false;
    }

    private boolean downloadImage(String str, boolean z16) {
        File file;
        HttpsURLConnection httpsURLConnection;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        HttpURLConnection httpURLConnection2;
        FileOutputStream fileOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        HttpsURLConnection httpsURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpsURLConnection httpsURLConnection3 = null;
        try {
            try {
                try {
                    file = FileSystem.getProperFile(this.mContext, "logo", this.mMd5);
                    try {
                        if (TVKIOUtil.createFile(file)) {
                            URL url = new URL(str);
                            if (str.contains("https")) {
                                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                                try {
                                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                                    httpsURLConnection.setConnectTimeout(5000);
                                    httpsURLConnection.setReadTimeout(15000);
                                    if (z16) {
                                        httpsURLConnection.setDoInput(true);
                                        httpsURLConnection.setDoOutput(true);
                                    }
                                    bufferedInputStream3 = new BufferedInputStream(httpsURLConnection.getInputStream());
                                    httpURLConnection3 = null;
                                    httpsURLConnection2 = httpsURLConnection;
                                } catch (Exception e16) {
                                    e = e16;
                                    bufferedInputStream = null;
                                    fileOutputStream2 = bufferedInputStream;
                                    bufferedOutputStream2 = fileOutputStream2;
                                    deleteImageFile(file);
                                    TVKLogUtil.e(TAG, e);
                                    this.errCode = 10001;
                                    HttpsURLConnection httpsURLConnection4 = httpsURLConnection3;
                                    httpsURLConnection3 = httpsURLConnection;
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    downloadImageFinally(httpsURLConnection4, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                    return false;
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                    bufferedInputStream = null;
                                    fileOutputStream2 = bufferedInputStream;
                                    bufferedOutputStream2 = fileOutputStream2;
                                    deleteImageFile(file);
                                    TVKLogUtil.e(TAG, e);
                                    this.errCode = 10001;
                                    HttpsURLConnection httpsURLConnection42 = httpsURLConnection3;
                                    httpsURLConnection3 = httpsURLConnection;
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    downloadImageFinally(httpsURLConnection42, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                    return false;
                                } catch (Throwable th5) {
                                    th = th5;
                                    httpURLConnection = null;
                                    fileOutputStream = null;
                                    bufferedInputStream = null;
                                    httpsURLConnection3 = httpsURLConnection;
                                    bufferedOutputStream = bufferedInputStream;
                                    downloadImageFinally(httpURLConnection, httpsURLConnection3, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                    throw th;
                                }
                            } else {
                                HttpURLConnection httpURLConnection4 = (HttpURLConnection) url.openConnection();
                                try {
                                    httpURLConnection4.setConnectTimeout(5000);
                                    httpURLConnection4.setReadTimeout(15000);
                                    if (z16) {
                                        httpURLConnection4.setDoInput(true);
                                        httpURLConnection4.setDoOutput(true);
                                    }
                                    bufferedInputStream3 = new BufferedInputStream(httpURLConnection4.getInputStream());
                                    httpsURLConnection2 = null;
                                    httpURLConnection3 = httpURLConnection4;
                                } catch (Exception e18) {
                                    e = e18;
                                    bufferedInputStream = null;
                                    fileOutputStream2 = null;
                                    bufferedOutputStream2 = null;
                                    httpsURLConnection3 = httpURLConnection4;
                                    httpsURLConnection = null;
                                    deleteImageFile(file);
                                    TVKLogUtil.e(TAG, e);
                                    this.errCode = 10001;
                                    HttpsURLConnection httpsURLConnection422 = httpsURLConnection3;
                                    httpsURLConnection3 = httpsURLConnection;
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    downloadImageFinally(httpsURLConnection422, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                    return false;
                                } catch (OutOfMemoryError e19) {
                                    e = e19;
                                    bufferedInputStream = null;
                                    fileOutputStream2 = null;
                                    bufferedOutputStream2 = null;
                                    httpsURLConnection3 = httpURLConnection4;
                                    httpsURLConnection = null;
                                    deleteImageFile(file);
                                    TVKLogUtil.e(TAG, e);
                                    this.errCode = 10001;
                                    HttpsURLConnection httpsURLConnection4222 = httpsURLConnection3;
                                    httpsURLConnection3 = httpsURLConnection;
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    downloadImageFinally(httpsURLConnection4222, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                    return false;
                                } catch (Throwable th6) {
                                    th = th6;
                                    fileOutputStream = null;
                                    bufferedInputStream = null;
                                    httpURLConnection = httpURLConnection4;
                                    bufferedOutputStream = bufferedInputStream;
                                    downloadImageFinally(httpURLConnection, httpsURLConnection3, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                    throw th;
                                }
                            }
                            BufferedInputStream bufferedInputStream4 = bufferedInputStream3;
                            try {
                                fileOutputStream2 = new FileOutputStream(file);
                            } catch (Exception e26) {
                                e = e26;
                                fileOutputStream2 = null;
                                bufferedOutputStream2 = null;
                            } catch (OutOfMemoryError e27) {
                                e = e27;
                                fileOutputStream2 = null;
                                bufferedOutputStream2 = null;
                            } catch (Throwable th7) {
                                th = th7;
                                fileOutputStream = null;
                                httpURLConnection = httpURLConnection3;
                                bufferedInputStream = bufferedInputStream4;
                                httpsURLConnection3 = httpsURLConnection2;
                                bufferedOutputStream = null;
                            }
                            try {
                                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2);
                            } catch (Exception e28) {
                                e = e28;
                                bufferedOutputStream2 = null;
                            } catch (OutOfMemoryError e29) {
                                e = e29;
                                bufferedOutputStream2 = null;
                            } catch (Throwable th8) {
                                th = th8;
                                httpURLConnection = httpURLConnection3;
                                fileOutputStream = fileOutputStream2;
                                bufferedInputStream = bufferedInputStream4;
                                bufferedOutputStream = null;
                                httpsURLConnection3 = httpsURLConnection2;
                                downloadImageFinally(httpURLConnection, httpsURLConnection3, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = bufferedInputStream4.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream2.write(bArr, 0, read);
                                    bufferedOutputStream2.flush();
                                }
                                httpURLConnection2 = httpURLConnection3;
                                httpsURLConnection3 = httpsURLConnection2;
                                fileOutputStream3 = fileOutputStream2;
                                bufferedInputStream2 = bufferedInputStream4;
                                bufferedOutputStream4 = bufferedOutputStream2;
                            } catch (Exception e36) {
                                e = e36;
                                httpsURLConnection3 = httpURLConnection3;
                                bufferedInputStream = bufferedInputStream4;
                                httpsURLConnection = httpsURLConnection2;
                                deleteImageFile(file);
                                TVKLogUtil.e(TAG, e);
                                this.errCode = 10001;
                                HttpsURLConnection httpsURLConnection42222 = httpsURLConnection3;
                                httpsURLConnection3 = httpsURLConnection;
                                bufferedOutputStream3 = bufferedOutputStream2;
                                downloadImageFinally(httpsURLConnection42222, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                return false;
                            } catch (OutOfMemoryError e37) {
                                e = e37;
                                httpsURLConnection3 = httpURLConnection3;
                                bufferedInputStream = bufferedInputStream4;
                                httpsURLConnection = httpsURLConnection2;
                                deleteImageFile(file);
                                TVKLogUtil.e(TAG, e);
                                this.errCode = 10001;
                                HttpsURLConnection httpsURLConnection422222 = httpsURLConnection3;
                                httpsURLConnection3 = httpsURLConnection;
                                bufferedOutputStream3 = bufferedOutputStream2;
                                downloadImageFinally(httpsURLConnection422222, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                                return false;
                            } catch (Throwable th9) {
                                th = th9;
                                httpURLConnection = httpURLConnection3;
                                httpsURLConnection3 = httpsURLConnection2;
                                fileOutputStream = fileOutputStream2;
                                bufferedInputStream = bufferedInputStream4;
                                bufferedOutputStream = bufferedOutputStream2;
                                downloadImageFinally(httpURLConnection, httpsURLConnection3, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                throw th;
                            }
                        } else {
                            httpURLConnection2 = null;
                            fileOutputStream3 = null;
                            bufferedOutputStream4 = null;
                            bufferedInputStream2 = null;
                        }
                        downloadImageFinally(httpURLConnection2, httpsURLConnection3, fileOutputStream3, bufferedOutputStream4, bufferedInputStream2);
                        return true;
                    } catch (Exception e38) {
                        e = e38;
                        httpsURLConnection = null;
                        bufferedInputStream = httpsURLConnection;
                        fileOutputStream2 = bufferedInputStream;
                        bufferedOutputStream2 = fileOutputStream2;
                        deleteImageFile(file);
                        TVKLogUtil.e(TAG, e);
                        this.errCode = 10001;
                        HttpsURLConnection httpsURLConnection4222222 = httpsURLConnection3;
                        httpsURLConnection3 = httpsURLConnection;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        downloadImageFinally(httpsURLConnection4222222, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                        return false;
                    } catch (OutOfMemoryError e39) {
                        e = e39;
                        httpsURLConnection = null;
                        bufferedInputStream = httpsURLConnection;
                        fileOutputStream2 = bufferedInputStream;
                        bufferedOutputStream2 = fileOutputStream2;
                        deleteImageFile(file);
                        TVKLogUtil.e(TAG, e);
                        this.errCode = 10001;
                        HttpsURLConnection httpsURLConnection42222222 = httpsURLConnection3;
                        httpsURLConnection3 = httpsURLConnection;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        downloadImageFinally(httpsURLConnection42222222, httpsURLConnection3, fileOutputStream2, bufferedOutputStream3, bufferedInputStream);
                        return false;
                    }
                } catch (Exception e46) {
                    e = e46;
                    file = null;
                    httpsURLConnection = null;
                } catch (OutOfMemoryError e47) {
                    e = e47;
                    file = null;
                    httpsURLConnection = null;
                }
            } catch (Throwable th10) {
                th = th10;
                httpURLConnection = null;
                fileOutputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Throwable th11) {
            th = th11;
            httpURLConnection = httpsURLConnection3;
            httpsURLConnection3 = bufferedOutputStream3;
            fileOutputStream = fileOutputStream2;
        }
    }

    private void downloadImageFinally(HttpURLConnection httpURLConnection, HttpsURLConnection httpsURLConnection, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream, BufferedInputStream bufferedInputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e16) {
                TVKLogUtil.e(TAG, e16);
                this.errCode = 10001;
                return;
            }
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    private Bitmap loadImage(String str) {
        File properFile = FileSystem.getProperFile(this.mContext, "logo", this.mMd5);
        if (properFile != null && !properFile.exists()) {
            boolean downloadFromPath = downloadFromPath();
            if (!downloadFromPath) {
                downloadFromPath = downloadImage(str, false);
            }
            if (!downloadFromPath) {
                downloadFromPath = downloadImage(str, true);
            }
            if (!downloadFromPath) {
                downloadImage(this.mHttpsImageUrl, false);
            }
        }
        return loadImageToBitmap(properFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedInputStream] */
    private Bitmap loadImageToBitmap(File file) {
        BufferedInputStream bufferedInputStream;
        Bitmap decodeStream;
        String str = this.mMd5;
        ?? r26 = 0;
        if (str != null) {
            try {
                try {
                    if (file != null) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            bufferedInputStream = null;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            bufferedInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (r26 != 0) {
                                try {
                                    r26.close();
                                } catch (Exception e18) {
                                    TVKLogUtil.e("MediaplayerMgr", e18.toString());
                                }
                            }
                            throw th;
                        }
                        try {
                            decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            TVKLogUtil.e("MediaplayerMgr", e);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return null;
                        } catch (OutOfMemoryError e26) {
                            e = e26;
                            TVKLogUtil.e("MediaplayerMgr", e);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return null;
                        }
                        if (decodeStream != null) {
                            TVKImageLoader.getInstance().addBitmapToMemoryCache(this.mMd5, decodeStream);
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e27) {
                                TVKLogUtil.e("MediaplayerMgr", e27.toString());
                            }
                            return decodeStream;
                        }
                        bufferedInputStream.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r26 = str;
                }
            } catch (Exception e28) {
                TVKLogUtil.e("MediaplayerMgr", e28.toString());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.mHttpsImageUrl = strArr[1];
        String str2 = strArr[2];
        this.mMd5 = str2;
        if (str2 == null) {
            return null;
        }
        Bitmap bitmapFromMemoryCache = TVKImageLoader.getInstance().getBitmapFromMemoryCache(this.mMd5);
        return bitmapFromMemoryCache == null ? loadImage(str) : bitmapFromMemoryCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            CallBack callBack = this.mCallback;
            if (callBack != null) {
                callBack.onSuccess(bitmap);
            }
        } else {
            CallBack callBack2 = this.mCallback;
            if (callBack2 != null) {
                callBack2.onFailure(this.errCode);
            }
        }
        this.errCode = 0;
    }

    public TVKLogoDownloader(Context context) {
        this.errCode = 0;
        this.mCallback = null;
        this.mContext = context;
    }
}

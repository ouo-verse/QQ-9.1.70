package com.tencent.gcloud.qr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.gcloud.qr.defines.QRResult;
import com.tencent.gcloud.qr.zxing.EncodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;

/* loaded from: classes6.dex */
public class QRCodeAPI {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_TAG = 0;
    private static final String TAG = "ApolloQR";
    private static QRCodeAPI mInstance;
    private String mAppPath;
    private Handler mHandler;
    private String mLaunchURL;
    private EncodeUtil mQREncodeUtil;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            mInstance = null;
        }
    }

    public QRCodeAPI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mQREncodeUtil = null;
        this.mAppPath = null;
        this.mLaunchURL = "AUTOSTART";
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.gcloud.qr.QRCodeAPI.2
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QRCodeAPI.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                super.handleMessage(message);
                Object obj = message.obj;
                if (obj != null) {
                    if (message.what == 0) {
                        QRResult qRResult = (QRResult) obj;
                        QRCodeAPI.this.OnGenerateQRImage(qRResult.getTag(), qRResult.getRetCode(), qRResult.getImagePath());
                        return;
                    }
                    return;
                }
                Log.e(QRCodeAPI.TAG, "QRCodeAPI handler Message is null");
            }
        };
    }

    private native void genQRImgNotify(int i3, int i16, String str);

    public static QRCodeAPI getInstance() {
        if (mInstance == null) {
            mInstance = new QRCodeAPI();
        }
        return mInstance;
    }

    private native void launchNotify(String str);

    public synchronized void GenerateQRImage(int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
            return;
        }
        if (this.mQREncodeUtil != null && str != null) {
            if (str2 == null) {
                Log.d(TAG, "QRCodeAPI GenerateQRLogoImage logoPath is null");
                GenerateQRImage(i3, true, str, (Bitmap) null);
                return;
            }
            if (!new File(str2).exists()) {
                Log.e(TAG, "QRCodeAPI GenerateQRLogoImage logoFile not exists");
                GenerateQRImage(i3, true, str, (Bitmap) null);
                return;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
            if (decodeFile == null) {
                Log.e(TAG, "QRCodeAPI GenerateQRLogoImage Bitmap logo is null");
                OnGenerateQRImage(i3, 10, "error");
                return;
            } else {
                this.mQREncodeUtil.setQRCodeSize(i16);
                GenerateQRImage(i3, true, str, decodeFile);
                return;
            }
        }
        Log.e(TAG, "QRCodeAPI GenerateQRLogoImage content is null");
        OnGenerateQRImage(i3, 10, "error");
    }

    public boolean Initialize(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity)).booleanValue();
        }
        if (activity == null) {
            Log.e(TAG, "QRCodeAPI Initialize Activity is null");
            return false;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted")) {
            File externalCacheDir = activity.getApplicationContext().getExternalCacheDir();
            if (externalCacheDir != null) {
                this.mAppPath = externalCacheDir.getPath();
            } else {
                this.mAppPath = activity.getApplicationContext().getFilesDir().getPath();
            }
            Log.d(TAG, "QRCodeAPI Initialize mAppPath: " + this.mAppPath);
        } else {
            Log.e(TAG, "QRCodeAPI Initialize getExternalCacheDir failed");
            this.mAppPath = activity.getApplicationContext().getFilesDir().getPath();
        }
        if (this.mQREncodeUtil == null) {
            this.mQREncodeUtil = new EncodeUtil();
        }
        return RefreshLaunch(activity.getIntent());
    }

    public void OnGenerateQRImage(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        try {
            genQRImgNotify(i3, i16, str);
        } catch (Exception e16) {
            Log.e(TAG, "QRCodeAPI OnGenerateQRImage Exception:" + e16.toString());
        }
    }

    public void QRCodeInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            qrCodeInit();
        } catch (Throwable th5) {
            Log.e(TAG, "QRCodeAPI QRCoceInit jni error=" + th5.toString());
        }
    }

    public boolean RefreshLaunch(Intent intent) {
        String uri;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent)).booleanValue();
        }
        if (intent == null) {
            Log.e(TAG, "QRCodeAPI RefreshLaunch Intent is null");
            return false;
        }
        Uri data = intent.getData();
        if (data == null) {
            uri = "";
        } else {
            uri = data.toString();
        }
        this.mLaunchURL = uri;
        Log.d(TAG, "QRCodeAPI RefreshLaunch mLaunchURL:" + this.mLaunchURL);
        if (!this.mLaunchURL.equals("")) {
            try {
                launchNotify(this.mLaunchURL);
                return true;
            } catch (Throwable th5) {
                Log.e(TAG, "QRCodeAPI RefreshLaunch launchNotify jni error:" + th5.toString());
            }
        }
        return false;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (mInstance == null) {
            mInstance = new QRCodeAPI();
        }
    }

    public native void qrCodeInit();

    private synchronized void GenerateQRImage(int i3, boolean z16, String str, Bitmap bitmap) {
        if (this.mAppPath == null) {
            Log.e(TAG, "QRCodeAPI GenerateQRImage savePath is null");
            OnGenerateQRImage(i3, 23, "");
        } else {
            new BaseThread(new Runnable(i3, str, bitmap) { // from class: com.tencent.gcloud.qr.QRCodeAPI.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$content;
                final /* synthetic */ Bitmap val$logo;
                final /* synthetic */ int val$tag;

                {
                    this.val$tag = i3;
                    this.val$content = str;
                    this.val$logo = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QRCodeAPI.this, Integer.valueOf(i3), str, bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    int i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str2 = "QR_" + String.valueOf((System.currentTimeMillis() / 1000) + "_" + this.val$tag);
                    String str3 = QRCodeAPI.this.mAppPath + "/" + str2 + ".jpg";
                    try {
                        bitmap2 = QRCodeAPI.this.mQREncodeUtil.createQRCode(this.val$content, this.val$logo);
                    } catch (Exception e16) {
                        Log.e(QRCodeAPI.TAG, "QRCodeAPI GenerateQRImage error=" + e16.toString());
                        bitmap2 = null;
                    }
                    if (bitmap2 != null) {
                        if (QRCodeAPI.this.mQREncodeUtil.writeToFile(bitmap2, QRCodeAPI.this.mAppPath, str2)) {
                            i16 = 0;
                        } else {
                            Log.e(QRCodeAPI.TAG, "QRCodeAPI GenerateQRImage QRRetCode.SystemError: 11");
                            i16 = 11;
                        }
                    } else {
                        i16 = 1;
                    }
                    QRResult qRResult = new QRResult(this.val$tag, i16, 0, str3);
                    Message obtain = Message.obtain();
                    obtain.obj = qRResult;
                    obtain.what = 0;
                    QRCodeAPI.this.mHandler.sendMessage(obtain);
                }
            }).start();
        }
    }
}

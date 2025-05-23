package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.utils.b;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes17.dex */
public class StoreFileTask {
    static IPatchRedirector $redirector_ = null;
    private static final int COMPRESS_QUALITY = 80;
    private static final String TAG = "StoreFileTask";
    private Bitmap photoBitmap;
    private String targetPath;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface OnStorePhotoCallback {
        void onFail(String str);

        void onSuccess(String str);
    }

    public StoreFileTask(Bitmap bitmap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap, (Object) str);
        } else {
            this.photoBitmap = bitmap;
            this.targetPath = str;
        }
    }

    private File createNewFile(String str) {
        if (str == null) {
            QLog.i(TAG, 1, "createNewFile but filepath is null");
            return null;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf > 0 && lastIndexOf < str.length() - 1) {
                    File file2 = new File(str.substring(0, lastIndexOf));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
            } else {
                file.delete();
            }
            file.createNewFile();
            return file;
        } catch (IOException e16) {
            QLog.e(TAG, 1, "createNewFile IOException " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String storeImageToFile(Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        String str;
        Closeable closeable = null;
        if (bitmap == null) {
            QLog.i(TAG, 1, "storeImageToFile but bitmap is null");
            return null;
        }
        String str2 = this.targetPath;
        File file = new File(str2);
        try {
            try {
                if (!file.exists()) {
                    file = createNewFile(this.targetPath);
                }
                if (file != null && file.exists()) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        String str3 = this.targetPath;
                        b.a(fileOutputStream);
                        return str3;
                    } catch (IOException e16) {
                        e = e16;
                        QLog.e(TAG, 1, "storeImageToFile IOException, ", e);
                        b.a(fileOutputStream);
                        return null;
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("storeImageToFile but ");
                if (file == null) {
                    str = "file is null";
                } else {
                    str = "file not exists";
                }
                sb5.append(str);
                QLog.i(TAG, 1, sb5.toString());
                b.a(null);
                return null;
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                b.a(closeable);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = str2;
            b.a(closeable);
            throw th;
        }
    }

    public void start(OnStorePhotoCallback onStorePhotoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onStorePhotoCallback);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable(onStorePhotoCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ OnStorePhotoCallback val$callback;

                {
                    this.val$callback = onStorePhotoCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StoreFileTask.this, (Object) onStorePhotoCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String storeImageToFile;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
                        storeImageToFile = "sdcardfull";
                    } else {
                        StoreFileTask storeFileTask = StoreFileTask.this;
                        storeImageToFile = storeFileTask.storeImageToFile(storeFileTask.photoBitmap);
                    }
                    ThreadManager.getUIHandler().post(new Runnable(storeImageToFile) { // from class: com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String val$finalTargetFile;

                        {
                            this.val$finalTargetFile = storeImageToFile;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) storeImageToFile);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (AnonymousClass1.this.val$callback != null) {
                                if (!"oom".equals(this.val$finalTargetFile) && (str = this.val$finalTargetFile) != null) {
                                    if ("sdcardfull".equals(str)) {
                                        AnonymousClass1.this.val$callback.onFail("SD\u5361\u7a7a\u95f4\u4e0d\u8db3");
                                        return;
                                    } else {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        anonymousClass1.val$callback.onSuccess(StoreFileTask.this.targetPath);
                                        return;
                                    }
                                }
                                AnonymousClass1.this.val$callback.onFail("\u5185\u5b58\u4e0d\u8db3");
                            }
                        }
                    });
                }
            });
        }
    }
}

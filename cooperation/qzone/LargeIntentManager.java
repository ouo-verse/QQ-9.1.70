package cooperation.qzone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LargeIntentManager {
    public static final String TAG = "LargeIntentManager";
    private static final String TEMP_FILE_FILENAME = "tmp.dat";
    private static final String TEMP_FILE_FOLDERNAME = "largeIntentTmp";
    private static final String TEMP_FILE_PATH = CacheManager.getCacheDir(TEMP_FILE_FOLDERNAME);

    private static File getBundleSaveFile(Context context) {
        return new File(TEMP_FILE_PATH, TEMP_FILE_FILENAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[Catch: IOException -> 0x008d, TRY_LEAVE, TryCatch #5 {IOException -> 0x008d, blocks: (B:40:0x0089, B:33:0x0091), top: B:39:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.Parcel] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent readSavedIntent(Context context) {
        BufferedInputStream bufferedInputStream;
        Parcel parcel = 0;
        parcel = 0;
        try {
            try {
                File bundleSaveFile = getBundleSaveFile(context);
                if (!bundleSaveFile.exists()) {
                    return new Intent();
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(bundleSaveFile));
                try {
                    int available = bufferedInputStream.available();
                    byte[] bArr = new byte[available];
                    bufferedInputStream.read(bArr);
                    parcel = Parcel.obtain();
                    parcel.unmarshall(bArr, 0, available);
                    parcel.setDataPosition(0);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.readFromParcel(parcel);
                    intent.putExtras(bundle);
                    try {
                        OaidMonitor.parcelRecycle(parcel);
                        bufferedInputStream.close();
                    } catch (IOException e16) {
                        QZLog.e(TAG, 2, "saveIntent", e16);
                    }
                    return intent;
                } catch (Exception e17) {
                    e = e17;
                    QZLog.e(TAG, 2, "saveIntent", e);
                    Intent intent2 = new Intent();
                    if (parcel != 0) {
                        try {
                            OaidMonitor.parcelRecycle(parcel);
                        } catch (IOException e18) {
                            QZLog.e(TAG, 2, "saveIntent", e18);
                            return intent2;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return intent2;
                }
            } catch (Exception e19) {
                e = e19;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    OaidMonitor.parcelRecycle(null);
                } catch (IOException e26) {
                    QZLog.e(TAG, 2, "saveIntent", e26);
                    throw th;
                }
            }
            if (0 != 0) {
                parcel.close();
            }
            throw th;
        }
    }

    public static void removeSavedIntent(Context context) {
        File bundleSaveFile = getBundleSaveFile(context);
        if (bundleSaveFile.exists()) {
            bundleSaveFile.delete();
        }
    }

    public static void saveIntent(Intent intent, Context context) {
        Parcel obtain = Parcel.obtain();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.writeToParcel(obtain, 0);
        }
        byte[] marshall = obtain.marshall();
        File bundleSaveFile = getBundleSaveFile(context);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (bundleSaveFile.exists()) {
                    bundleSaveFile.delete();
                }
                bundleSaveFile.getParentFile().mkdirs();
                bundleSaveFile.createNewFile();
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(bundleSaveFile));
                try {
                    bufferedOutputStream2.write(marshall);
                    OaidMonitor.parcelRecycle(obtain);
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        QZLog.e(TAG, 2, "saveIntent", e16);
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    QZLog.e(TAG, 2, "saveIntent", e);
                    OaidMonitor.parcelRecycle(obtain);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            QZLog.e(TAG, 2, "saveIntent", e18);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    OaidMonitor.parcelRecycle(obtain);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            QZLog.e(TAG, 2, "saveIntent", e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }
}

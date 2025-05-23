package com.tencent.luggage.wxa.ar;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f121765a = false;

    public static boolean a() {
        return XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName());
    }

    public static boolean b() {
        return "com.tencent.mm".equalsIgnoreCase(XWalkEnvironment.getPackageName());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:17|(2:18|19)|(4:(2:20|21)|33|34|36)|22|23|24|(2:26|27)(6:51|52|53|54|(1:56)(1:58)|57)|(2:45|46)|(2:40|41)|(1:32)) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00cc, code lost:
    
        r6 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00cd, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #9 {all -> 0x00cc, blocks: (B:24:0x005f, B:26:0x008b), top: B:23:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        File file;
        RandomAccessFile randomAccessFile;
        boolean z18;
        if (f121765a) {
            return;
        }
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.f("XWebChoreHandler", "setDataDirSuffix, invalid context");
            return;
        }
        if (XWalkEnvironment.getApplicationContext().getApplicationInfo() != null && XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion < 28) {
            x0.d("XWebChoreHandler", "setDataDirSuffix, below target 28, no need to setDataDirSuffix");
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            RandomAccessFile randomAccessFile2 = null;
            FileLock tryLock = null;
            try {
                str = XWalkEnvironment.getProcessName();
            } catch (Throwable th5) {
                th = th5;
                str = null;
            }
            try {
                try {
                    str = str.replace(":", "_");
                    str2 = str.replace(".", "_");
                } catch (Throwable th6) {
                    th = th6;
                    x0.a("XWebChoreHandler", "setDataDirSuffix, failed to get suffix dir, error", th);
                    str2 = str;
                    file = new File(XWalkEnvironment.getApplicationContext().getDir("webview_" + str2, 0).getAbsolutePath(), "webview_data.lock");
                    if (file.exists()) {
                    }
                    if (tryLock != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    if (z16) {
                    }
                    x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                    h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                    f121765a = true;
                    return;
                }
                x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                f121765a = true;
                return;
            } catch (Throwable th7) {
                x0.a("XWebChoreHandler", "setDataDirSuffix, error", th7);
                n0.a(577L, 232L, 1L);
                return;
            }
            file = new File(XWalkEnvironment.getApplicationContext().getDir("webview_" + str2, 0).getAbsolutePath(), "webview_data.lock");
            if (file.exists()) {
                x0.d("XWebChoreHandler", "setDataDirSuffix, webview_data.lock not exist");
                randomAccessFile = null;
                z17 = false;
                z16 = false;
            } else {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Throwable th8) {
                    th = th8;
                    boolean z19 = true;
                    z16 = z19;
                    try {
                        x0.a("XWebChoreHandler", "setDataDirSuffix, try lock webview_data.lock failed, error", th);
                        n0.a(577L, 230L, 1L);
                        if (randomAccessFile2 != null) {
                        }
                        z17 = false;
                        if (z16) {
                        }
                        x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                        h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                        f121765a = true;
                        return;
                    } catch (Throwable th9) {
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th10) {
                                x0.a("XWebChoreHandler", "setDataDirSuffix, try release sLockFile failed, error", th10);
                            }
                        }
                        throw th9;
                    }
                }
                try {
                    tryLock = randomAccessFile.getChannel().tryLock();
                    if (tryLock != null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z16 = true;
                    z17 = z18;
                } catch (Throwable th11) {
                    z16 = true;
                    th = th11;
                    randomAccessFile2 = randomAccessFile;
                    x0.a("XWebChoreHandler", "setDataDirSuffix, try lock webview_data.lock failed, error", th);
                    n0.a(577L, 230L, 1L);
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th12) {
                            th = th12;
                            z17 = false;
                            x0.a("XWebChoreHandler", "setDataDirSuffix, try release sLockFile failed, error", th);
                            if (z16) {
                            }
                            x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                            h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                            f121765a = true;
                            return;
                        }
                    }
                    z17 = false;
                    if (z16) {
                    }
                    x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                    h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                    f121765a = true;
                    return;
                }
            }
            if (tryLock != null) {
                try {
                    tryLock.release();
                    tryLock.close();
                } catch (Throwable th13) {
                    x0.a("XWebChoreHandler", "setDataDirSuffix, try release exclusiveFileLock failed, error", th13);
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th14) {
                    th = th14;
                    x0.a("XWebChoreHandler", "setDataDirSuffix, try release sLockFile failed, error", th);
                    if (z16) {
                        str2 = str2 + v0.b();
                        n0.a(577L, 231L, 1L);
                    }
                    x0.d("XWebChoreHandler", "setDataDirSuffix, suffix:" + str2);
                    h0.a("android.webkit.WebView", "setDataDirectorySuffix", new Class[]{String.class}, str2);
                    f121765a = true;
                    return;
                }
            }
            if (z16 && !z17) {
                str2 = str2 + v0.b();
                n0.a(577L, 231L, 1L);
            }
        } else {
            x0.d("XWebChoreHandler", "setDataDirSuffix, Build.VERSION.SDK_INT(" + i3 + ") too low");
        }
    }

    public static void a(Context context, String str, String str2) {
        ClipboardManager clipboardManager;
        if (TextUtils.isEmpty(str2) || (clipboardManager = (ClipboardManager) context.getSystemService("clipboard")) == null) {
            return;
        }
        ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(str, str2));
    }

    public static void a(Context context, String str, boolean z16) {
        x0.d("XWebChoreHandler", "showAlert, shouldAlert:" + z16 + ", message:" + str);
        try {
            if (z16) {
                new AlertDialog.Builder(context).setTitle("\u63d0\u793a").setMessage(str).setPositiveButton("\u786e\u5b9a", new a()).show();
            } else {
                Toast.makeText(context, str, 0).show();
            }
        } catch (Exception e16) {
            x0.a("XWebChoreHandler", "showAlert, error:", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static String a(Context context, String str) {
        BufferedReader bufferedReader;
        ?? r06 = 0;
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
                boolean z16 = true;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (z16) {
                                z16 = false;
                            } else {
                                sb5.append('\n');
                            }
                            sb5.append(readLine);
                        } else {
                            String sb6 = sb5.toString();
                            w.a(bufferedReader);
                            return sb6;
                        }
                    } catch (IOException e16) {
                        e = e16;
                        x0.a("XWebChoreHandler", "loadAssetTextAsString, error:", e);
                        w.a(bufferedReader);
                        return null;
                    }
                }
            } catch (IOException e17) {
                e = e17;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                w.a((Closeable) r06);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = str;
            w.a((Closeable) r06);
            throw th;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

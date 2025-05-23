package com.tencent.rfix.lib.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.lib.config.PatchConfig;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.tls.Tls12SocketFactory;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.PatchMD5Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes25.dex */
public class PatchDownloadTask implements Runnable {
    static IPatchRedirector $redirector_;
    public static int C;

    /* renamed from: h, reason: collision with root package name */
    public static int f364961h;

    /* renamed from: i, reason: collision with root package name */
    public static int f364962i;

    /* renamed from: m, reason: collision with root package name */
    public static int f364963m;

    /* renamed from: d, reason: collision with root package name */
    private final Context f364964d;

    /* renamed from: e, reason: collision with root package name */
    private final PatchConfig f364965e;

    /* renamed from: f, reason: collision with root package name */
    private final b f364966f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f364961h = 1;
        f364962i = 0;
        f364963m = -1;
        C = -2;
    }

    public PatchDownloadTask(Context context, PatchConfig patchConfig, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, patchConfig, bVar);
            return;
        }
        this.f364964d = context;
        this.f364965e = patchConfig;
        this.f364966f = bVar;
    }

    protected boolean a(File file, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) file, (Object) str)).booleanValue();
        }
        if (!file.exists()) {
            return false;
        }
        String md5 = PatchMD5Utils.getMD5(file);
        if (TextUtils.isEmpty(md5) || !md5.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int b(PatchConfig patchConfig, String str) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) patchConfig, (Object) str)).intValue();
        }
        int i3 = C;
        InputStream inputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(patchConfig.patchUrl).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            Tls12SocketFactory.enableTls12OnPreKitkat(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream = inputStream2;
                    i3 = f364962i;
                } catch (Exception e17) {
                    e = e17;
                    inputStream = inputStream2;
                    try {
                        RFixLog.e("RFix.PatchDownloadTask", "downloadFile exception!", e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } else {
                i3 = responseCode;
                fileOutputStream = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    protected int c(PatchConfig patchConfig, String str) {
        int b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) patchConfig, (Object) str)).intValue();
        }
        int i3 = 0;
        while (true) {
            b16 = b(patchConfig, str);
            if (b16 != f364962i && (i3 = i3 + 1) <= 2) {
                RFixLog.w("RFix.PatchDownloadTask", "downloadFileWithRetry download failed, retry once.");
            }
        }
        return b16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r0 != com.tencent.rfix.lib.download.PatchDownloadTask.f364962i) goto L35;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int i3 = C;
        PatchConfig patchConfig = this.f364965e;
        RFixLog.d("RFix.PatchDownloadTask", String.format("PatchDownloadTask running! url=%s md5=%s", patchConfig.patchUrl, patchConfig.patchMD5));
        TimeTracker.beginTrack(TimeTrackType.PATCH_DOWNLOAD_TOTAL);
        String str = null;
        try {
            File patchTempDirectory = PatchFileUtils.getPatchTempDirectory(this.f364964d);
            if (!patchTempDirectory.exists()) {
                patchTempDirectory.mkdirs();
            }
            File file = new File(patchTempDirectory, "download_patch.apk");
            String absolutePath = file.getAbsolutePath();
            try {
                if (a(file, this.f364965e.patchMD5)) {
                    i3 = f364961h;
                    z16 = true;
                } else {
                    i3 = c(this.f364965e, absolutePath);
                    try {
                        if (i3 == f364962i) {
                            if (!a(file, this.f364965e.patchMD5)) {
                                file.delete();
                                i3 = f364963m;
                                RFixLog.e("RFix.PatchDownloadTask", "PatchDownloadTask download file md5 not match.");
                            } else {
                                z16 = true;
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        RFixLog.e("RFix.PatchDownloadTask", "PatchDownloadTask exception!", e);
                        TimeTracker.endTrack(TimeTrackType.PATCH_DOWNLOAD_TOTAL);
                        RFixLog.d("RFix.PatchDownloadTask", String.format("PatchDownloadTask resultCode=%s path=%s", Integer.valueOf(i3), str));
                        this.f364966f.b(z16, i3, str, this.f364965e);
                    }
                    z16 = false;
                }
                str = absolutePath;
            } catch (Exception e17) {
                e = e17;
                z16 = true;
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
        }
        TimeTracker.endTrack(TimeTrackType.PATCH_DOWNLOAD_TOTAL);
        RFixLog.d("RFix.PatchDownloadTask", String.format("PatchDownloadTask resultCode=%s path=%s", Integer.valueOf(i3), str));
        this.f364966f.b(z16, i3, str, this.f364965e);
    }
}

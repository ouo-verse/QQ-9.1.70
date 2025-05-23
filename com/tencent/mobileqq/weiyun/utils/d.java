package com.tencent.mobileqq.weiyun.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f315292a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f315293b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f315294c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements y43.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f315295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f315296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ y43.e f315297c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f315298d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f315299e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f315300f;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.weiyun.utils.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        class C8983a implements y43.b {
            static IPatchRedirector $redirector_;

            C8983a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // y43.b
            public void onDownloadFinished(String str, String str2, boolean z16, String str3, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3));
                    return;
                }
                if (z16) {
                    File file = new File(a.this.f315296b);
                    int g16 = d.g(a.this.f315295a);
                    if (g16 == 0) {
                        d.c(file, a.this.f315295a);
                        y43.e eVar = a.this.f315297c;
                        if (eVar != null) {
                            eVar.onLoadFailed(str3);
                            return;
                        }
                        return;
                    }
                    if (file.length() != g16) {
                        d.c(file, a.this.f315295a);
                        y43.e eVar2 = a.this.f315297c;
                        if (eVar2 != null) {
                            eVar2.onLoadFailed(str3);
                            return;
                        }
                        return;
                    }
                    try {
                        ZipUtils.unZipFile(file, a.this.f315298d.getFilesDir() + File.separator);
                        boolean exists = new File(a.this.f315298d.getFilesDir(), "libwlc_upload_uni_v1.0.1.so").exists();
                        if (new File(a.this.f315298d.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so").exists()) {
                            z17 = exists;
                        }
                        if (file.exists()) {
                            d.c(file, a.this.f315295a);
                        }
                        a aVar = a.this;
                        y43.e eVar3 = aVar.f315297c;
                        if (eVar3 != null) {
                            if (z17) {
                                eVar3.i(aVar.f315299e.getAbsolutePath(), a.this.f315300f.getAbsolutePath());
                            } else {
                                eVar3.onLoadFailed(HardCodeUtil.qqStr(R.string.tlo));
                            }
                        }
                        if (!z17) {
                            return;
                        }
                    } catch (ZipException unused) {
                        boolean exists2 = new File(a.this.f315298d.getFilesDir(), "libwlc_upload_uni_v1.0.1.so").exists();
                        if (new File(a.this.f315298d.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so").exists()) {
                            z17 = exists2;
                        }
                        if (file.exists()) {
                            d.c(file, a.this.f315295a);
                        }
                        a aVar2 = a.this;
                        y43.e eVar4 = aVar2.f315297c;
                        if (eVar4 != null) {
                            if (z17) {
                                eVar4.i(aVar2.f315299e.getAbsolutePath(), a.this.f315300f.getAbsolutePath());
                            } else {
                                eVar4.onLoadFailed(HardCodeUtil.qqStr(R.string.tlo));
                            }
                        }
                        if (!z17) {
                            return;
                        }
                    } catch (IOException unused2) {
                        boolean exists3 = new File(a.this.f315298d.getFilesDir(), "libwlc_upload_uni_v1.0.1.so").exists();
                        if (new File(a.this.f315298d.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so").exists()) {
                            z17 = exists3;
                        }
                        if (file.exists()) {
                            d.c(file, a.this.f315295a);
                        }
                        a aVar3 = a.this;
                        y43.e eVar5 = aVar3.f315297c;
                        if (eVar5 != null) {
                            if (z17) {
                                eVar5.i(aVar3.f315299e.getAbsolutePath(), a.this.f315300f.getAbsolutePath());
                            } else {
                                eVar5.onLoadFailed(HardCodeUtil.qqStr(R.string.tlo));
                            }
                        }
                        if (!z17) {
                            return;
                        }
                    } catch (Throwable th5) {
                        boolean exists4 = new File(a.this.f315298d.getFilesDir(), "libwlc_upload_uni_v1.0.1.so").exists();
                        if (new File(a.this.f315298d.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so").exists()) {
                            z17 = exists4;
                        }
                        if (file.exists()) {
                            d.c(file, a.this.f315295a);
                        }
                        a aVar4 = a.this;
                        y43.e eVar6 = aVar4.f315297c;
                        if (eVar6 != null) {
                            if (z17) {
                                eVar6.i(aVar4.f315299e.getAbsolutePath(), a.this.f315300f.getAbsolutePath());
                            } else {
                                eVar6.onLoadFailed(HardCodeUtil.qqStr(R.string.tlo));
                            }
                        }
                        if (z17) {
                            c.i(a.this.f315298d, "0", "key_local_so_version", String.valueOf(1005));
                        }
                        throw th5;
                    }
                    c.i(a.this.f315298d, "0", "key_local_so_version", String.valueOf(1005));
                    return;
                }
                y43.e eVar7 = a.this.f315297c;
                if (eVar7 != null) {
                    eVar7.onLoadFailed(str3);
                }
            }

            @Override // y43.b
            public void onDownloadProgress(String str, long j3, float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Float.valueOf(f16));
                }
            }
        }

        a(String str, String str2, y43.e eVar, Context context, File file, File file2) {
            this.f315295a = str;
            this.f315296b = str2;
            this.f315297c = eVar;
            this.f315298d = context;
            this.f315299e = file;
            this.f315300f = file2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, eVar, context, file, file2);
            }
        }

        @Override // y43.b
        public void onDownloadFinished(String str, String str2, boolean z16, String str3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3));
                return;
            }
            if (z16) {
                com.tencent.mobileqq.weiyun.sdk.download.c.u().q(d.f315294c, this.f315295a, "SoHelper", new C8983a());
                return;
            }
            y43.e eVar = this.f315297c;
            if (eVar != null) {
                eVar.onLoadFailed(str3);
            }
        }

        @Override // y43.b
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Float.valueOf(f16));
                return;
            }
            y43.e eVar = this.f315297c;
            if (eVar != null) {
                eVar.h(j3, f16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String e16 = e();
        f315292a = e16;
        f315293b = "https://dlied5sdk.myapp.com/weiyun/android/qq/" + e16 + "/weiyunLibrary1005.zip";
        f315294c = "https://dlied5sdk.myapp.com/weiyun/android/qq/" + e16 + "/librarySize1005.txt";
    }

    public static boolean b(Context context) {
        File h16 = h(context);
        File f16 = f(context);
        File file = new File(context.getFilesDir(), "libWeiyunSDK.so");
        String a16 = c.a(context, "0", "key_local_so_version");
        if (!h16.exists() || (!f16.exists() && !file.exists())) {
            return false;
        }
        if (!String.valueOf(1005).equals(a16)) {
            h16.delete();
            f16.delete();
            file.delete();
            return false;
        }
        return true;
    }

    static void c(File file, String str) {
        file.delete();
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public static void d(Context context, y43.e eVar) {
        File h16 = h(context);
        File f16 = f(context);
        if (h16.exists() && f16.exists()) {
            if (eVar != null) {
                eVar.i(h16.getAbsolutePath(), f16.getAbsolutePath());
                return;
            }
            return;
        }
        String b16 = f.b(123L);
        String str = b16 + "weiyunLibrary.zip";
        com.tencent.mobileqq.weiyun.sdk.download.c.u().q(f315293b, str, "SoHelper", new a(b16 + "sizeLibrary.txt", str, eVar, context, h16, f16));
    }

    private static String e() {
        String str;
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0) {
            str = strArr[0];
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("arm64-v8a")) {
                return "arm64-v8a";
            }
            if (str.contains("armeabi-v7a")) {
                return "armeabi-v7a";
            }
            return "armeabi";
        }
        return "armeabi";
    }

    public static File f(Context context) {
        return new File(context.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r4 != null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int g(String str) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        File file;
        String str2 = "";
        FileInputStream fileInputStream = null;
        try {
            try {
                file = new File(str);
            } catch (FileNotFoundException unused) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (IOException unused2) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (IOException unused3) {
        }
        if (!file.exists()) {
            return 0;
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        try {
            inputStreamReader = new InputStreamReader(fileInputStream2);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (FileNotFoundException unused4) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (IOException unused5) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        return 0;
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                inputStreamReader.close();
            } catch (FileNotFoundException unused7) {
                bufferedReader = null;
            } catch (IOException unused8) {
                bufferedReader = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
        } catch (FileNotFoundException unused9) {
            inputStreamReader = null;
            bufferedReader = null;
        } catch (IOException unused10) {
            inputStreamReader = null;
            bufferedReader = null;
        } catch (Throwable th8) {
            th = th8;
            inputStreamReader = null;
            bufferedReader = null;
        }
        bufferedReader.close();
        if (!TextUtils.isEmpty(str2)) {
            try {
                return Integer.parseInt(str2);
            } catch (NumberFormatException unused11) {
            }
        }
        return 0;
    }

    public static File h(Context context) {
        return new File(context.getFilesDir(), "libwlc_upload_uni_v1.0.1.so");
    }
}

package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a implements PluginManagerUpdater {

    /* renamed from: a, reason: collision with root package name */
    private File f238107a;

    /* renamed from: b, reason: collision with root package name */
    private String f238108b;

    /* renamed from: c, reason: collision with root package name */
    private String f238109c;

    /* renamed from: d, reason: collision with root package name */
    private Context f238110d;

    /* renamed from: e, reason: collision with root package name */
    private String f238111e;

    /* renamed from: f, reason: collision with root package name */
    private String f238112f;

    /* renamed from: g, reason: collision with root package name */
    private final SharedPreferences f238113g = BaseApplication.getContext().getSharedPreferences("IVShadowAssetsPmUpdater", 0);

    public a(Context context, String str, String str2) {
        this.f238108b = "";
        this.f238112f = str2;
        this.f238110d = context;
        this.f238111e = str;
        File file = new File(context.getFilesDir(), "IVShadowCdnPmUpdater/assets");
        if (!file.exists()) {
            file.mkdirs();
        }
        if ("Now".equals(str)) {
            this.f238108b = "NowPluginManager.apk";
            this.f238109c = "shadow/NowPluginManager.apk";
        }
        this.f238107a = new File(file, this.f238108b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        ?? r56;
        InputStream open;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        InputStream inputStream = null;
        try {
            open = context.getAssets().open(str);
            try {
                bufferedInputStream = new BufferedInputStream(open);
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream3 = new FileOutputStream(file);
                    try {
                        r56 = new BufferedOutputStream(fileOutputStream3);
                    } catch (IOException e16) {
                        inputStream = open;
                        fileOutputStream = fileOutputStream3;
                        e = e16;
                        r56 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        r56 = 0;
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream2 = null;
                    inputStream = open;
                    fileOutputStream = fileOutputStream2;
                    r56 = fileOutputStream2;
                    try {
                        QLog.e("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal error, e=" + e.toString());
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (r56 != 0) {
                        }
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e18) {
                                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e18.toString());
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e19.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e26.toString());
                            }
                        }
                        if (r56 != 0) {
                            try {
                                r56.close();
                                throw th;
                            } catch (IOException e27) {
                                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e27.toString());
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    r56 = 0;
                    inputStream = open;
                    fileOutputStream = r56;
                    if (inputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (r56 != 0) {
                    }
                }
            } catch (IOException e28) {
                e = e28;
                bufferedInputStream = null;
                fileOutputStream2 = null;
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream = null;
                r56 = 0;
            }
        } catch (IOException e29) {
            e = e29;
            fileOutputStream = null;
            bufferedInputStream = null;
            r56 = 0;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
            bufferedInputStream = null;
            r56 = 0;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                r56.write(bArr, 0, read);
            }
            r56.flush();
            this.f238113g.edit().putBoolean("assets_pm" + this.f238112f, true).apply();
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e36) {
                    QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e36.toString());
                }
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e37) {
                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e37.toString());
            }
            try {
                fileOutputStream3.close();
            } catch (IOException e38) {
                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e38.toString());
            }
            try {
                r56.close();
            } catch (IOException e39) {
                QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e39.toString());
            }
            return true;
        } catch (IOException e46) {
            inputStream = open;
            fileOutputStream = fileOutputStream3;
            e = e46;
            r56 = r56;
            QLog.e("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal error, e=" + e.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e47) {
                    QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e47.toString());
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e48) {
                    QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e48.toString());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e49) {
                    QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e49.toString());
                }
            }
            if (r56 != 0) {
                try {
                    r56.close();
                } catch (IOException e56) {
                    QLog.i("shadow::AssetsPmUpdater", 1, "copyAssetsToLocal close error, e=" + e56.toString());
                }
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            inputStream = open;
            fileOutputStream = fileOutputStream3;
            th = th;
            if (inputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            if (r56 != 0) {
            }
        }
    }

    public boolean b() {
        return "Now".equals(this.f238111e);
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public File getLatest() {
        String str;
        if (!b()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean a16 = a(this.f238110d, this.f238109c, this.f238107a.getAbsolutePath());
        com.tencent.mobileqq.intervideo.now.a f16 = PluginManagerInterfaceImpl.i().h().f("copy_pm");
        if (a16) {
            str = "0";
        } else {
            str = "1";
        }
        f16.b(str).h();
        if (a16) {
            QLog.i("shadow::AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        } else {
            QLog.i("shadow::AssetsPmUpdater", 1, "copy asset pm fail");
        }
        return this.f238107a;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future isAvailable(File file) {
        return null;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future update() {
        return null;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public boolean wasUpdating() {
        return false;
    }
}

package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.videocut.model.TransitionModel;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import w53.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TransitionResourceManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f322546a = new ArrayList<>(Arrays.asList("ZC_jichu_huadong"));

    /* renamed from: b, reason: collision with root package name */
    private static volatile TransitionResourceManager f322547b;

    public static TransitionResourceManager c() {
        if (f322547b == null) {
            synchronized (TransitionResourceManager.class) {
                if (f322547b == null) {
                    f322547b = new TransitionResourceManager();
                }
            }
        }
        return f322547b;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf(".pag"));
        }
        return null;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("winktranspag");
        sb5.append(str2);
        sb5.append(str);
        sb5.append(".pag");
        return sb5.toString();
    }

    public static String f(Context context) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "winktranspag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).exists();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean j(Context context, String str) {
        FileOutputStream fileOutputStream;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            File file = new File(f(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (file.exists() && !file2.exists()) {
                AssetManager assets = context.getAssets();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("pag");
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                InputStream open = assets.open(sb5.toString());
                try {
                    b.a("TransitionResourceManager", "releasePagFileToData, pagName = pag" + str2 + str);
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e16) {
                    inputStream = open;
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    inputStream = open;
                    th = th5;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    open.close();
                    inputStream = open;
                } catch (Exception e17) {
                    inputStream = open;
                    e = e17;
                    try {
                        b.a("TransitionResourceManager", "releasePagFileToData, exception = " + e.toString());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    inputStream = open;
                    th = th7;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } else {
                fileOutputStream = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e28) {
                    e28.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e29) {
                    e29.printStackTrace();
                }
            }
            return true;
        } catch (Exception e36) {
            e = e36;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public void h(final Context context, final Collection<TransitionModel> collection, final Runnable runnable) {
        if (context != null && collection != null && runnable != null) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16 = false;
                    for (TransitionModel transitionModel : collection) {
                        if (transitionModel != null) {
                            String e16 = TransitionResourceManager.e(context, transitionModel.resId);
                            String str = transitionModel.resId + ".pag";
                            if (!TransitionResourceManager.this.g(e16)) {
                                b.a("TransitionResourceManager", "loadLocalTransResource, pagFilePath = " + e16 + "not exists, need reload.");
                                z16 = TransitionResourceManager.this.j(context, str);
                            } else {
                                b.a("TransitionResourceManager", "loadLocalTransResource, pagFilePath = " + e16 + "exists, not need reload.");
                                z16 = true;
                            }
                        }
                    }
                    if (z16) {
                        ThreadManager.getUIHandler().post(runnable);
                    }
                }
            });
        }
    }

    public void i(final Context context) {
        if (context == null || !QzoneConfig.getWinkTransitionSwitch()) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String[] list = context.getAssets().list("pag");
                    if (list != null && list.length > 0) {
                        for (String str : list) {
                            if (TransitionResourceManager.f322546a.contains(TransitionResourceManager.d(str))) {
                                TransitionResourceManager.this.j(context, str);
                            }
                        }
                    }
                } catch (Exception e16) {
                    b.a("TransitionResourceManager", "releasePagFilesToData, exception = " + e16.toString());
                }
            }
        });
    }
}

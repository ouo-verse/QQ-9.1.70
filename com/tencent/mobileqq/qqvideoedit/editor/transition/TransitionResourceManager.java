package com.tencent.mobileqq.qqvideoedit.editor.transition;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TransitionModel;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import mj2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TransitionResourceManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f275832a = new ArrayList<>(Arrays.asList("ZC_jichu_huadong"));

    /* renamed from: b, reason: collision with root package name */
    private static volatile TransitionResourceManager f275833b;

    public static TransitionResourceManager c() {
        if (f275833b == null) {
            synchronized (TransitionResourceManager.class) {
                if (f275833b == null) {
                    f275833b = new TransitionResourceManager();
                }
            }
        }
        return f275833b;
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
        sb5.append("videotranspag");
        sb5.append(str2);
        sb5.append(str);
        sb5.append(".pag");
        return sb5.toString();
    }

    public static String f(Context context) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "videotranspag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).exists();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(f(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (file.exists() && !file2.exists()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("releasePagFileToData, pagName = pag");
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                a.a("TransitionResourceManager", sb5.toString());
                InputStream open = context.getAssets().open("pag" + str2 + str);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
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
                        fileOutputStream.close();
                        open.close();
                    } finally {
                    }
                } finally {
                }
            }
            return true;
        } catch (Exception e16) {
            a.a("TransitionResourceManager", "releasePagFileToData, exception = " + e16.toString());
            return false;
        }
    }

    public void h(final Context context, final Collection<TransitionModel> collection, final Runnable runnable) {
        if (context != null && collection != null && runnable != null) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionResourceManager.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16 = false;
                    for (TransitionModel transitionModel : collection) {
                        String e16 = TransitionResourceManager.e(context, transitionModel.resId);
                        String str = transitionModel.resId + ".pag";
                        if (!TransitionResourceManager.this.g(e16)) {
                            a.a("TransitionResourceManager", "loadLocalTransResource, pagFilePath = " + e16 + "not exists, need reload.");
                            z16 = TransitionResourceManager.this.j(context, str);
                        } else {
                            a.a("TransitionResourceManager", "loadLocalTransResource, pagFilePath = " + e16 + "exists, not need reload.");
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
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionResourceManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String[] list = context.getAssets().list("pag");
                    if (list != null && list.length > 0) {
                        for (String str : list) {
                            if (TransitionResourceManager.f275832a.contains(TransitionResourceManager.d(str))) {
                                TransitionResourceManager.this.j(context, str);
                            }
                        }
                    }
                } catch (Exception e16) {
                    a.a("TransitionResourceManager", "releasePagFilesToData, exception = " + e16.toString());
                }
            }
        });
    }
}

package com.tencent.aelight.camera.ae.font;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.File;
import java.util.HashMap;
import org.light.Config;
import org.light.FontAsset;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFontManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f65234b = false;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Typeface> f65235a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final AEFontManager f65240a = new AEFontManager();
    }

    AEFontManager() {
    }

    public static AEFontManager d() {
        return a.f65240a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AEEditorDownloadResBean aEEditorDownloadResBean) {
        final String id5 = aEEditorDownloadResBean.getId();
        final String fontFamily = aEEditorDownloadResBean.getFontFamily();
        if (d().e(id5) == Typeface.DEFAULT) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.font.AEFontManager.2
                @Override // java.lang.Runnable
                public void run() {
                    String D = AEEditorResourceManager.J().D(id5, 1);
                    if (TextUtils.isEmpty(D)) {
                        return;
                    }
                    if (d.t()) {
                        Config.registerFont(new FontAsset(fontFamily, "Regular"), D);
                    }
                    AEFontManager.d().c(id5, D);
                }
            }, 64, null, false);
        }
    }

    public void b(String str, Typeface typeface) {
        if (TextUtils.isEmpty(str) || typeface == null) {
            return;
        }
        this.f65235a.put(str, typeface);
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || e(str) != Typeface.DEFAULT) {
            return;
        }
        File file = new File(str2);
        if (!file.exists()) {
            ms.a.c("AEFontManager", "[cacheTypeface], fontFile not exists, path=" + file.getAbsolutePath());
            return;
        }
        try {
            Typeface createFromFile = Typeface.createFromFile(file);
            if (createFromFile != null) {
                b(str, createFromFile);
            }
        } catch (Throwable th5) {
            ms.a.d("AEFontManager", "[cacheTypeface], create typeface raised exception, e=", th5);
        }
    }

    public Typeface e(String str) {
        if (TextUtils.isEmpty(str)) {
            return Typeface.DEFAULT;
        }
        Typeface typeface = this.f65235a.get(str);
        return typeface == null ? Typeface.DEFAULT : typeface;
    }

    public void f() {
        if (f65234b) {
            ms.a.f("AEFontManager", "[preDownloadAndRegisterGifFonts] already triggered");
        } else {
            f65234b = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.font.AEFontManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f("AEFontManager", "[preDownloadAndRegisterGifFonts] run");
                    for (AEEditorDownloadResBean aEEditorDownloadResBean : AEEditorResourceManager.J().G().values()) {
                        if (AEEditorResourceManager.J().g(aEEditorDownloadResBean)) {
                            AEFontManager.this.g(aEEditorDownloadResBean);
                        } else if (aEEditorDownloadResBean.getPreDownload() == 1) {
                            AEEditorResourceManager.J().c(aEEditorDownloadResBean, new a(aEEditorDownloadResBean));
                        }
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.aelight.camera.ae.font.AEFontManager$1$a */
                /* loaded from: classes32.dex */
                class a implements AEEditorResourceDownloader.c {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ AEEditorDownloadResBean f65236a;

                    a(AEEditorDownloadResBean aEEditorDownloadResBean) {
                        this.f65236a = aEEditorDownloadResBean;
                    }

                    @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
                    public void onDownloadFinish(boolean z16) {
                        if (z16) {
                            AEFontManager.this.g(this.f65236a);
                        }
                    }

                    @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
                    public void onProgressUpdate(int i3) {
                    }
                }
            }, 128, null, false);
        }
    }
}

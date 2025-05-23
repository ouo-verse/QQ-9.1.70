package com.tencent.mobileqq.vasgift.mvvm.business.anim;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.common.util.k;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vasgift.utils.j;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/anim/c;", "", "", "zipFilePath", "dstDir", "Lcom/tencent/mobileqq/vasgift/mvvm/business/anim/c$a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dirPath", "", "b", "parentDir", "zipMd5", "c", "Landroid/content/Context;", "context", "j", "k", "g", h.F, "i", "d", "f", "e", "l", "Lcom/tencent/mobileqq/vasgift/utils/j;", "Lcom/tencent/mobileqq/vasgift/utils/j;", QDLog.TAG_DOWNLOAD, "<init>", "()V", "a", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f311706a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final j downloader = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/anim/c$a;", "", "", "onStart", "", "path", "onComplete", "", "errorCode", "errorMsg", "onError", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void onComplete(@NotNull String path);

        void onError(int errorCode, @NotNull String errorMsg);

        void onStart();
    }

    c() {
    }

    private final boolean b(String dirPath) {
        File file = new File(dirPath);
        if (file.exists() && file.isDirectory() && file.list() != null) {
            return true;
        }
        return false;
    }

    private final String c(String parentDir, String zipMd5) {
        if (parentDir != null && zipMd5 != null) {
            return parentDir + File.separator + zipMd5;
        }
        return "";
    }

    private final String j(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath() + "/tencent/qqlive/gift";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String zipFilePath, String dstDir, a callback) {
        try {
            try {
                ZipUtils.unZipFile(new File(zipFilePath), dstDir + File.separator, false);
                k.c(zipFilePath);
                QLog.i("QQGiftComboResDownloader", 1, "unZip success");
                if (callback != null) {
                    callback.onComplete(dstDir);
                }
            } catch (Exception e16) {
                QLog.i("QQGiftComboResDownloader", 1, "unZip fail, errorMsg=" + e16.getMessage());
                if (callback != null) {
                    callback.onError(1002, "unzipError");
                }
                k.c(zipFilePath);
            }
        } catch (Throwable th5) {
            k.c(zipFilePath);
            throw th5;
        }
    }

    public final void d(@NotNull Context context, @Nullable a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (callback != null) {
            callback.onStart();
        }
        String d16 = ht3.a.d("qqlive_gift_combo_res_url", "https://down.qq.com/video_story/wezone_url/defaultmode/zhibo/comboAnimation/animationV3.zip");
        String j3 = j(context);
        String d17 = g.d(d16);
        String c16 = c(j3, d17);
        if (TextUtils.isEmpty(c16)) {
            QLog.i("QQGiftComboResDownloader", 1, "\u76ee\u6807\u5730\u5740\u5f02\u5e38");
            if (callback != null) {
                callback.onError(1001, "error unzipPath");
                return;
            }
            return;
        }
        if (b(c16)) {
            QLog.i("QQGiftComboResDownloader", 1, "\u672c\u5730\u8d44\u6e90\u53ef\u7528");
            if (callback != null) {
                callback.onComplete(c16);
                return;
            }
            return;
        }
        File file = new File(c16);
        if (!file.exists()) {
            file.mkdirs();
        }
        QLog.i("QQGiftComboResDownloader", 1, "start download, downloadUrl=" + d16 + ", unzipDirPath=" + c16);
        j jVar = downloader;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d17);
        sb5.append(".zip");
        jVar.c(d16, c16, sb5.toString(), new b(callback, c16, d17));
    }

    @NotNull
    public final String e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context) + File.separator + "number";
    }

    @NotNull
    public final String f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c(j(context), g.d("https://down.qq.com/video_story/wezone_url/defaultmode/zhibo/comboAnimation/animationV3.zip")) + File.separator + "animation";
    }

    @NotNull
    public final String g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context) + File.separator + "qqlive_combo_btn_longpress.pag";
    }

    @NotNull
    public final String h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context) + File.separator + "qqlive_combo_btn.pag";
    }

    @NotNull
    public final String i(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context) + File.separator + "qqlive_combo_pillar_android.png";
    }

    @NotNull
    public final String k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f(context) + File.separator + "qqlive_combo_start_ripple.pag";
    }

    public final boolean l(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return b(c(j(context), g.d(ht3.a.d("qqlive_gift_combo_res_url", "https://down.qq.com/video_story/wezone_url/defaultmode/zhibo/comboAnimation/animationV3.zip"))));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/anim/c$b", "Lcom/tencent/mobileqq/vasgift/utils/j$b;", "", "onStart", "", "progress", "onProgress", "errorCode", "", "errorMsg", "onError", "from", "onSuccess", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements j.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f311708a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311709b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f311710c;

        b(a aVar, String str, String str2) {
            this.f311708a = aVar;
            this.f311709b = str;
            this.f311710c = str2;
        }

        @Override // com.tencent.mobileqq.vasgift.utils.j.b
        public void onError(int errorCode, @Nullable String errorMsg) {
            a aVar = this.f311708a;
            if (aVar != null) {
                if (errorMsg == null) {
                    errorMsg = "nekworkError";
                }
                aVar.onError(errorCode, errorMsg);
            }
        }

        @Override // com.tencent.mobileqq.vasgift.utils.j.b
        public void onSuccess(int from) {
            String str = this.f311709b + File.separator + this.f311710c + ".zip";
            QLog.i("QQGiftComboResDownloader", 1, "start unZip, zipFilePath=" + str + ", unzipDirPath=" + this.f311709b);
            c.f311706a.m(str, this.f311709b, this.f311708a);
        }

        @Override // com.tencent.mobileqq.vasgift.utils.j.b
        public void onStart() {
        }

        @Override // com.tencent.mobileqq.vasgift.utils.j.b
        public void onProgress(int progress) {
        }
    }
}

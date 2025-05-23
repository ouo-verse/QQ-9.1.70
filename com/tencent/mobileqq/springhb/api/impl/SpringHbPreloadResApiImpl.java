package com.tencent.mobileqq.springhb.api.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.a;
import com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi;
import com.tencent.mobileqq.springhb.interf.b;
import com.tencent.mobileqq.springhb.preload.SpringResApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0002H\u0017J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002H\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/impl/SpringHbPreloadResApiImpl;", "Lcom/tencent/mobileqq/springhb/api/ISpringHbPreloadResApi;", "", "src", "getScrDir", "toMD5", "", "getFilePos", "url", "Lcom/tencent/mobileqq/springhb/interf/a;", "getSpringFileRes", "defaultDrawableKey", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/springhb/interf/b;", "getPreloadDrawableRes", "Landroid/content/Context;", "context", "", "copyKuiklyPagFile", "copyKuiklyFontFile", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringHbPreloadResApiImpl implements ISpringHbPreloadResApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SpringHbPreloadResApi";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/impl/SpringHbPreloadResApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.api.impl.SpringHbPreloadResApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringHbPreloadResApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int getFilePos() {
        return a.f278999a ? 1 : 0;
    }

    private final String getScrDir(String src) {
        String substringAfterLast;
        String substringBefore;
        substringAfterLast = StringsKt__StringsKt.substringAfterLast(src, '/', "");
        substringBefore = StringsKt__StringsKt.substringBefore(substringAfterLast, '.', "");
        return substringBefore;
    }

    private final String toMD5(String str) {
        int checkRadix;
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : digest) {
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            String num = Integer.toString(b16 & 255, checkRadix);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            if (num.length() == 1) {
                sb5.append('0');
            }
            sb5.append(num);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply {\n\u2026   }\n        }.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi
    @WorkerThread
    public void copyKuiklyFontFile(@NotNull String url) {
        String substringAfterLast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String g16 = a.g(url, getFilePos());
            String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
            substringAfterLast = StringsKt__StringsKt.substringAfterLast(url, '/', "");
            String str = hippyFontRootDir + substringAfterLast;
            File file = new File(str);
            if (file.exists()) {
                QLog.d(TAG, 1, "copyKuiklyFontFile: exists!");
                return;
            }
            QLog.i("QQKuiklyFontAdapter", 1, "useQQFontFile file:" + file);
            FileUtils.copyFile(g16, str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "copyKuiklyPagFile: error: ", th5);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi
    @WorkerThread
    public void copyKuiklyPagFile(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String g16 = a.g(url, getFilePos());
            String str = context.getFilesDir().getAbsolutePath() + "/ec_resource/" + getScrDir(url) + "/" + toMD5(url) + ".pag";
            if (new File(str).exists()) {
                QLog.d(TAG, 1, "copyKuiklyPagFile: exists!");
                return;
            }
            FileUtils.createDirectory(new File(str).getParent());
            FileUtils.copyFile(g16, str);
            QLog.d(TAG, 1, "copyKuiklyPagFile: completed!");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "copyKuiklyPagFile: error: ", th5);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi
    @NotNull
    public b getPreloadDrawableRes(@NotNull String url, @NotNull String defaultDrawableKey, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, url, defaultDrawableKey, bundle);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(defaultDrawableKey, "defaultDrawableKey");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return SpringResApi.k(url, SpringResApi.i(defaultDrawableKey, bundle).b(), bundle);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbPreloadResApi
    @NotNull
    public com.tencent.mobileqq.springhb.interf.a getSpringFileRes(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.springhb.interf.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return SpringResApi.l(url);
    }
}

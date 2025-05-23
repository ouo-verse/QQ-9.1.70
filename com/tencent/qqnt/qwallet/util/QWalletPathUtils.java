package com.tencent.qqnt.qwallet.util;

import android.os.Environment;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\f\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qwallet/util/QWalletPathUtils;", "", "", "url", "f", "b", "Lkotlin/Lazy;", "c", "()Ljava/lang/String;", "externalPath", "d", "internalPath", "e", "preloadPath", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QWalletPathUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletPathUtils f361901a = new QWalletPathUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy externalPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy internalPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy preloadPath;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.qwallet.util.QWalletPathUtils$externalPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) {
                    return "";
                }
                File externalFilesDir = BaseApplication.getContext().getExternalFilesDir("QWallet");
                String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
                return absolutePath == null ? "" : absolutePath;
            }
        });
        externalPath = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.qwallet.util.QWalletPathUtils$internalPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "QWallet";
            }
        });
        internalPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.qwallet.util.QWalletPathUtils$preloadPath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String c16;
                StringBuilder sb5 = new StringBuilder();
                QWalletPathUtils qWalletPathUtils = QWalletPathUtils.f361901a;
                c16 = qWalletPathUtils.c();
                if (c16.length() == 0) {
                    c16 = qWalletPathUtils.d();
                }
                sb5.append(c16);
                String str = File.separator;
                sb5.append(str);
                sb5.append(IPreloadServiceAbs.PRELOAD_DIR_NAME_HIDE);
                sb5.append(str);
                return sb5.toString();
            }
        });
        preloadPath = lazy3;
    }

    QWalletPathUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        return (String) externalPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        return (String) internalPath.getValue();
    }

    private final String e() {
        return (String) preloadPath.getValue();
    }

    @NotNull
    public final String f(@NotNull String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        return e() + MD5.toMD5(url);
    }
}

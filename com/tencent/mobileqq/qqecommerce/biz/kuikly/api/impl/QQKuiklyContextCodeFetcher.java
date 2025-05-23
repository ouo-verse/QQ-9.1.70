package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import d01.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002JT\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007H\u0002JL\u0010\u000f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J4\u0010\u0019\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\f0\u0007R\u001b\u0010\u001d\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyContextCodeFetcher;", "", "", "ip", "filename", "f", "pageName", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "contextCode", "assetsPath", "", "result", "c", "d", BrowserPlugin.KEY_REQUEST_URL, "Ljava/io/File;", "outputFile", "", "e", "bundleFile", "unzipDir", "", "i", "b", "Lkotlin/Lazy;", "g", "()Ljava/lang/String;", "userFileServer", "Lkotlin/text/Regex;", h.F, "()Lkotlin/text/Regex;", "userRegex", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyContextCodeFetcher {

    /* renamed from: a, reason: collision with root package name */
    public static final QQKuiklyContextCodeFetcher f262815a = new QQKuiklyContextCodeFetcher();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy userFileServer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy userRegex;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyContextCodeFetcher$userFileServer$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ar.INSTANCE.a("kenaiyu", "", "vas_kuikly_debug_file_server").getStringData("");
            }
        });
        userFileServer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Regex>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyContextCodeFetcher$userRegex$2
            @Override // kotlin.jvm.functions.Function0
            public final Regex invoke() {
                return new Regex("[a-zA-Z]+");
            }
        });
        userRegex = lazy2;
    }

    QQKuiklyContextCodeFetcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String ip5, String pageName, Function2<? super String, ? super String, Unit> result) {
        File file = new File(BaseApplication.getContext().getFilesDir(), "kuikly");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, pageName);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String f16 = f(ip5, "kuikly_dynamic.zip");
        File file3 = new File(file2, "kuikly_dynamic.zip");
        File file4 = new File(file2, "bundle");
        if (file4.exists()) {
            FilesKt__UtilsKt.deleteRecursively(file4);
        }
        file4.mkdirs();
        int e16 = e(f16, file3);
        if (e16 == 200) {
            if (i(file3, file4)) {
                File file5 = new File(file4, "dynamic_kuikly.apk");
                File file6 = new File(file4, "assets");
                if (file6.exists()) {
                    String absolutePath = file5.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "apkFile.absolutePath");
                    result.invoke(absolutePath, file6.getAbsolutePath());
                    return;
                } else {
                    String absolutePath2 = file5.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "apkFile.absolutePath");
                    result.invoke(absolutePath2, null);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQKuiklyContextCodeFetcher", 2, "[fetchDexBundle] unzip " + file3.getAbsolutePath() + " fail!");
                return;
            }
            return;
        }
        if (e16 == 404) {
            d(ip5, result);
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQKuiklyContextCodeFetcher", 2, "[fetchDexBundle] fetch " + f16 + " fail!");
        }
    }

    private final void d(String ip5, Function2<? super String, ? super String, Unit> result) {
        String f16 = f(ip5, "dynamic_kuikly.apk");
        File file = new File(BaseApplication.getContext().getFilesDir(), "kuikly");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "dynamic_kuikly.apk");
        if (e(f16, file2) == 200) {
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "apkFile.absolutePath");
            result.invoke(absolutePath, null);
        } else if (QLog.isColorLevel()) {
            QLog.e("QQKuiklyContextCodeFetcher", 2, "[fetchDynamicApk] fetch " + f16 + " fail!");
        }
    }

    private final int e(String requestUrl, File outputFile) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder().url(requestUrl).build();
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();
        Response execute = okHttpClient.newCall(build).execute();
        if (execute.isSuccessful()) {
            ResponseBody body = execute.body();
            InputStream byteStream = body != null ? body.byteStream() : null;
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            byte[] bArr = new byte[1024];
            while (true) {
                Integer valueOf = byteStream != null ? Integer.valueOf(byteStream.read(bArr)) : null;
                int intValue = valueOf != null ? valueOf.intValue() : 0;
                if (valueOf != null && valueOf.intValue() == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, intValue);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (byteStream != null) {
                byteStream.close();
            }
            w.f392617a.a("QQKuiklyContextCodeFetcher", "fetchFile " + requestUrl + " successful");
            return 200;
        }
        QLog.e("QQKuiklyContextCodeFetcher", 1, "fetch file " + requestUrl + " fail! " + execute.code());
        return execute.code();
    }

    private final String g() {
        return (String) userFileServer.getValue();
    }

    private final Regex h() {
        return (Regex) userRegex.getValue();
    }

    private final boolean i(File bundleFile, File unzipDir) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(bundleFile)));
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                String str = unzipDir.getAbsolutePath() + File.separator + nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str).mkdirs();
                } else {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    byte[] bArr = new byte[1024];
                    for (int read = zipInputStream.read(bArr); read != -1; read = zipInputStream.read(bArr)) {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.close();
                }
            }
            zipInputStream.close();
            w.f392617a.a("QQKuiklyContextCodeFetcher", "unzip " + bundleFile.getAbsolutePath() + " to " + unzipDir.getAbsolutePath() + " successful");
            return true;
        } catch (Exception e16) {
            w wVar = w.f392617a;
            wVar.b("QQKuiklyContextCodeFetcher", "Error while unzipBundle file: " + e16);
            wVar.b("QQKuiklyContextCodeFetcher", "unzip " + bundleFile.getAbsolutePath() + " to " + unzipDir.getAbsolutePath() + " fail");
            return false;
        }
    }

    public final void b(final String ip5, final String pageName, final Function2<? super String, ? super String, Unit> result) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(result, "result");
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyContextCodeFetcher$fetchContextCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    QQKuiklyContextCodeFetcher.f262815a.c(ip5, pageName, result);
                } catch (Throwable th5) {
                    QLog.e("QQKuiklyContextCodeFetcher", 1, "fetchContextCode error: " + th5);
                    result.invoke("", null);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f(String ip5, String filename) {
        boolean z16;
        if (ip5 != null) {
            if (ip5.length() > 0) {
                z16 = true;
                if (!z16) {
                    ip5 = ((IQQKuiklyLocalConfig) QRoute.api(IQQKuiklyLocalConfig.class)).getKuiklyLocalIp();
                }
                if (!(ip5.length() != 0)) {
                    return "http://www.kuikly.com/kuikly/" + filename;
                }
                if ((g().length() > 0) && h().matches(ip5)) {
                    return g() + "/" + ip5 + "/" + filename;
                }
                return "http://" + ip5 + ":8083/" + filename;
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (!(ip5.length() != 0)) {
        }
    }
}

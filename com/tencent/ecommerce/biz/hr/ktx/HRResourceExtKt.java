package com.tencent.ecommerce.biz.hr.ktx;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.IECHttpDownloader;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a0\u0010\b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0002\u00a8\u0006\u000b"}, d2 = {"Landroid/content/Context;", "", "src", "filePostfix", "Lkotlin/Function1;", "Ljava/io/File;", "", "resultBlock", "a", "b", "c", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRResourceExtKt {
    public static final void a(Context context, String str, String str2, Function1<? super File, Unit> function1) {
        final String str3 = context.getFilesDir().getAbsolutePath() + "/ec_resource/" + b(str) + "/" + c(str) + str2;
        final File file = new File(str3);
        try {
            if (file.exists()) {
                a aVar = a.f102564b;
                if (aVar.b(str3)) {
                    aVar.c(str3, function1);
                    return;
                } else {
                    function1.invoke(file);
                    return;
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            a.f102564b.c(str3, function1);
            IECHttpDownloader httpDownloader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHttpDownloader();
            if (httpDownloader != null) {
                httpDownloader.downloadFileAsync(str, file, new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.hr.ktx.HRResourceExtKt$fetchResourceFile$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (z16) {
                            a.f102564b.a(str3, file);
                        } else {
                            file.delete();
                            a.f102564b.a(str3, null);
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            cg0.a.b("fetchResourceFile", "fetchResourceFile error: " + th5);
            file.deleteOnExit();
            function1.invoke(null);
        }
    }

    private static final String c(String str) {
        int checkRadix;
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                String num = Integer.toString(b16 & 255, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
                if (num.length() == 1) {
                    sb5.append('0');
                }
                sb5.append(num);
            }
            return sb5.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private static final String b(String str) {
        String substringAfterLast;
        String substringBefore;
        substringAfterLast = StringsKt__StringsKt.substringAfterLast(str, '/', "");
        substringBefore = StringsKt__StringsKt.substringBefore(substringAfterLast, '.', "");
        return substringBefore;
    }
}

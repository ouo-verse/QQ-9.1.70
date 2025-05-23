package com.tencent.mobileqq.zplan.aigc.helper;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rJ\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0010J\"\u0010 \u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/h;", "", "", "key", "g", "Ljava/io/Closeable;", "closeable", "", "a", "apiMethodName", "eTag", "", "bytes", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Ljava/io/File;", "c", "k", WadlProxyConsts.PARAM_FILENAME, "d", RemoteHandleConst.PARAM_DEFAULT_VALUE, tl.h.F, "value", "p", "e", "o", "file", DomainData.DOMAIN_NAME, "b", "", com.tencent.luggage.wxa.c8.c.E, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f330325a = new h();

    h() {
    }

    private final String g(String key) {
        return "apic_api_cache_" + key;
    }

    public final byte[] b(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i3 = (int) length;
            byte[] bArr = new byte[i3];
            m(file, bArr, i3);
            return bArr;
        }
        throw new IllegalArgumentException(("file too large, path:" + file.getPath()).toString());
    }

    public final File c(String apiMethodName) {
        Intrinsics.checkNotNullParameter(apiMethodName, "apiMethodName");
        return new File(d(apiMethodName, i(this, apiMethodName, null, 2, null)));
    }

    public final String d(String apiMethodName, String fileName) {
        Intrinsics.checkNotNullParameter(apiMethodName, "apiMethodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (!TextUtils.isEmpty(apiMethodName) && !TextUtils.isEmpty(fileName)) {
            String h16 = v.h(v.f328299a, "aigc_cache", false, 2, null);
            String str = File.separator;
            String c16 = com.tencent.zplan.common.utils.d.c(apiMethodName + fileName);
            Intrinsics.checkNotNullExpressionValue(c16, "toMD5(\n                a\u2026 + fileName\n            )");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String upperCase = c16.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return h16 + str + upperCase;
        }
        return "";
    }

    public final boolean e(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(key, defaultValue);
    }

    public final String h(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(g(key), defaultValue);
    }

    public final byte[] j(String apiMethodName) {
        Intrinsics.checkNotNullParameter(apiMethodName, "apiMethodName");
        File c16 = c(apiMethodName);
        if (c16.exists()) {
            return b(c16);
        }
        return null;
    }

    public final boolean k(String apiMethodName) {
        Intrinsics.checkNotNullParameter(apiMethodName, "apiMethodName");
        return c(apiMethodName).exists();
    }

    public final boolean l(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
    }

    public final void m(File file, byte[] bytes, int len) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i3 = 0;
        while (i3 < len) {
            try {
                int read = randomAccessFile.read(bytes, i3, len - i3);
                if (read < 0) {
                    break;
                } else {
                    i3 += read;
                }
            } finally {
                a(randomAccessFile);
            }
        }
    }

    public final boolean n(File file, byte[] bytes) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception e16) {
            QLog.e("ZPlanAIGCCacheHelper", 1, "Save Bytes exception", e16);
        }
        if (!l(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bytes.length);
            randomAccessFile.write(bytes);
            a(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th5) {
            a(randomAccessFile);
            throw th5;
        }
    }

    public final void o(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(key, value);
    }

    public final void p(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(g(key), value);
    }

    public final boolean q(String apiMethodName, String eTag, byte[] bytes) {
        Intrinsics.checkNotNullParameter(apiMethodName, "apiMethodName");
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        File file = new File(d(apiMethodName, eTag));
        p(apiMethodName, "");
        if (file.exists()) {
            file.delete();
        }
        if (TextUtils.isEmpty(eTag) || bytes == null || !n(file, bytes)) {
            return false;
        }
        p(apiMethodName, eTag);
        QLog.i("ZPlanAIGCCacheHelper", 1, "saveETag success : eTagKey:" + apiMethodName + ", eTagValue:" + eTag);
        return true;
    }

    private final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static /* synthetic */ String i(h hVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return hVar.h(str, str2);
    }

    public static /* synthetic */ boolean f(h hVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return hVar.e(str, z16);
    }
}

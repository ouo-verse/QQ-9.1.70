package com.tencent.filament.zplanservice.cpp;

import androidx.annotation.Keep;
import com.tencent.filament.zplanservice.util.a;
import com.tencent.filament.zplanservice.util.b;
import com.tencent.filament.zplanservice.util.g;
import com.tencent.filament.zplanservice.util.log.FLog;
import dl0.c;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/filament/zplanservice/cpp/ZPlanInterface;", "", "()V", "TAG", "", "getEtagInfo", "url", "getResourcePath", "isPublicVersion", "", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanInterface {

    @NotNull
    public static final ZPlanInterface INSTANCE = new ZPlanInterface();

    @NotNull
    public static final String TAG = "ZPlanAvatarResourceInterface";

    ZPlanInterface() {
    }

    @JvmStatic
    @NativeMethodProxy
    @NotNull
    public static final String getEtagInfo(@NotNull String url) {
        String b16;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        String b17 = new a(url).b();
        if (b17 == null) {
            b17 = url;
        }
        String a16 = g.f106447a.a(b17);
        if (a16 != null) {
            boolean z16 = false;
            String substring = a16.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String substring2 = a16.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            c cVar = (c) fl0.a.f399763a.a(c.class);
            if (cVar == null || (b16 = cVar.b()) == null) {
                return "";
            }
            File file = new File(com.tencent.filament.zplanservice.util.c.d(com.tencent.filament.zplanservice.util.c.d(com.tencent.filament.zplanservice.util.c.d(b16, "avatarDownload"), substring + '/' + substring2), "etag.json"));
            if (!file.exists()) {
                FLog.INSTANCE.e(TAG, "getEtagInfo etagFile " + file + " no exists, url:" + url);
                return "";
            }
            try {
                str = b.b(file);
            } catch (IOException e16) {
                FLog.INSTANCE.e(TAG, "getEtagInfo readFileToString fail. url:" + url, e16);
                str = "";
            }
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (z16) {
                FLog.INSTANCE.e(TAG, "getEtagInfo readFileToString fail. etagInfo is NullOrEmpty. etagInfo:" + str + ", url:" + url);
                return "";
            }
            FLog.INSTANCE.e(TAG, "getEtagInfo etagFile " + file + ", content: " + str + ", url:" + url);
            return str;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmStatic
    @NativeMethodProxy
    @NotNull
    public static final String getResourcePath() {
        String str;
        c cVar = (c) fl0.a.f399763a.a(c.class);
        if (cVar != null) {
            str = cVar.b();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str + "/Resource";
    }

    @JvmStatic
    @NativeMethodProxy
    public static final boolean isPublicVersion() {
        dl0.a aVar = (dl0.a) fl0.a.f399763a.a(dl0.a.class);
        if (aVar != null) {
            return aVar.isPublicVersion();
        }
        return true;
    }
}

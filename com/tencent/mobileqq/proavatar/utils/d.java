package com.tencent.mobileqq.proavatar.utils;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/d;", "", "", "url", "", "b", "", "faceInfoMap", "", "targetSize", "a", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f259720a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33927);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f259720a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final String a(@NotNull Map<String, ? extends Object> faceInfoMap, int targetSize) {
        String str;
        Byte b16;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) faceInfoMap, targetSize);
        }
        Intrinsics.checkNotNullParameter(faceInfoMap, "faceInfoMap");
        Object obj = faceInfoMap.get("url");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Object obj2 = faceInfoMap.get(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG);
        if (obj2 instanceof Byte) {
            b16 = (Byte) obj2;
        } else {
            b16 = null;
        }
        if (b16 == null) {
            return null;
        }
        byte byteValue = b16.byteValue();
        Object obj3 = faceInfoMap.get(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP);
        if (obj3 instanceof Long) {
            l3 = (Long) obj3;
        } else {
            l3 = null;
        }
        if (l3 == null) {
            return null;
        }
        long longValue = l3.longValue();
        if (!b(str)) {
            return null;
        }
        return str + AvatarDownloadUtil.getQQHeadImageSize(byteValue, targetSize) + "&t=" + longValue;
    }
}

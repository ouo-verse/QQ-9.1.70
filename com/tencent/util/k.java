package com.tencent.util;

import android.os.Bundle;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J \u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/util/k;", "", "", "str", "d", "", WidgetCacheConstellationData.NUM, "b", "Landroid/os/Bundle;", "bundle", "a", "obj", "c", "", "keywords", "f", "e", "key", "", tl.h.F, "g", "", "Ljava/util/Set;", "SENSITIVE_BUNDLE_KEYS", "SENSITIVE_KEYWORDS", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f383983a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> SENSITIVE_BUNDLE_KEYS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> SENSITIVE_KEYWORDS;

    static {
        Set<String> of5;
        Set<String> of6;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383983a = new k();
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"uinname", AppConstants.Key.FORWARD_TEXT, AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE});
        SENSITIVE_BUNDLE_KEYS = of5;
        of6 = SetsKt__SetsKt.setOf((Object[]) new String[]{"uin", "uid", "code", "nick", "name", "title", "summary", "desc", "latitude", "longitude"});
        SENSITIVE_KEYWORDS = of6;
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String bundle2 = f383983a.e(bundle).toString();
        Intrinsics.checkNotNullExpressionValue(bundle2, "{\n            filterSens\u2026dle).toString()\n        }");
        return bundle2;
    }

    @JvmStatic
    @NotNull
    public static final String b(@Nullable Number num) {
        if (num == null) {
            return "";
        }
        return d(String.valueOf(num.longValue()));
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return d((String) obj);
        }
        if (obj instanceof Number) {
            return b((Number) obj);
        }
        if (obj instanceof Bundle) {
            return a((Bundle) obj);
        }
        return obj.toString();
    }

    @JvmStatic
    @NotNull
    public static final String d(@Nullable String str) {
        String take;
        String takeLast;
        String repeat;
        if (str == null) {
            return "";
        }
        if (str.length() > 2) {
            take = StringsKt___StringsKt.take(str, 1);
            takeLast = StringsKt___StringsKt.takeLast(str, 1);
            repeat = StringsKt__StringsJVMKt.repeat("*", str.length() - 2);
            return take + repeat + takeLast;
        }
        return str;
    }

    private final Bundle e(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        for (String key : bundle2.keySet()) {
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (h(key) || g(key)) {
                bundle2.putString(key, c(bundle2.get(key)));
            }
        }
        return bundle2;
    }

    @JvmStatic
    @NotNull
    public static final String f(@Nullable Object obj, @NotNull Iterable<String> keywords) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        if (obj == null) {
            return "";
        }
        return h.f383982a.b(obj.toString(), keywords);
    }

    private final boolean g(String key) {
        return SENSITIVE_BUNDLE_KEYS.contains(key);
    }

    private final boolean h(String key) {
        boolean contains;
        Iterator<String> it = SENSITIVE_KEYWORDS.iterator();
        while (it.hasNext()) {
            contains = StringsKt__StringsKt.contains((CharSequence) key, (CharSequence) it.next(), true);
            if (contains) {
                return true;
            }
        }
        return false;
    }
}

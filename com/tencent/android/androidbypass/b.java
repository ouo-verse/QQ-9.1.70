package com.tencent.android.androidbypass;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000\u001aG\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00072*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00030\u0005\"\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003H\u0007\u00a2\u0006\u0004\b\b\u0010\t\"\u0014\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011\"\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0011\"\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\u0011\"\u0017\u0010\u0017\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\u0011\"\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\r\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"", "key", "value", "Lkotlin/Pair;", "a", "", "pairs", "", "g", "([Lkotlin/Pair;)Ljava/util/Map;", "Lcom/tencent/android/androidbypass/d;", "Lcom/tencent/android/androidbypass/d;", "BypassMarkdownParseRecorder", "b", "BypassMarkdownCodeParseRecorder", "c", "f", "()Lcom/tencent/android/androidbypass/d;", "BypassMarkdownMeasureParseRecorder", "d", "e", "BypassMarkdownLayoutParseRecorder", "BypassMarkdownDrawRecorder", "BypassCodeSpanMeasureRecorder", "BypassCodeSpanDrawRecorder", "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f71942a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f71943b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final d f71944c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final d f71945d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final d f71946e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final d f71947f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final d f71948g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f71942a = new a("mkd_parse_time");
        f71943b = new a("mkd_code_parse_time");
        f71944c = new a("mkd_measure_time");
        f71945d = new a("mkd_layout_time");
        f71946e = new a("mkd_draw_time");
        f71947f = new a("mkd_code_measure_time");
        f71948g = new a("mkd_code_draw_time");
    }

    @NotNull
    public static final Pair<String, String> a(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return TuplesKt.to(key, value);
    }

    @NotNull
    public static final d b() {
        return f71948g;
    }

    @NotNull
    public static final d c() {
        return f71947f;
    }

    @NotNull
    public static final d d() {
        return f71946e;
    }

    @NotNull
    public static final d e() {
        return f71945d;
    }

    @NotNull
    public static final d f() {
        return f71944c;
    }

    @SafeVarargs
    @NotNull
    public static final Map<String, String> g(@NotNull Pair<String, String>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pairs.length);
        MapsKt__MapsKt.putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }
}

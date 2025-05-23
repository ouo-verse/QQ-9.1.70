package com.tencent.mobileqq.guild.share.shorturl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import dq1.c;
import dq1.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0003R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001d\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u001f\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010 \u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010!\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/share/shorturl/a;", "", "", "", "keys", "", "o", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "i", DomainData.DOMAIN_NAME, "l", "Ldq1/c;", "a", "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "d", "()Lkotlin/text/Regex;", "PATH_PATTERN_HOME", "c", "PATH_PATTERN_FEED", "f", "PATH_PATTERN_POST", "e", "g", "PATH_PATTERN_TEXT", h.F, "PATH_PATTERN_VOICE", "PATH_PATTERN_LIVE", "PATH_PATTERN_EVENT", "Ljava/util/Set;", "domainList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f235094a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_HOME = new Regex("^/g/(\\w+)");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_FEED = new Regex("^/g/(\\w+)");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_POST = new Regex("^/g/(\\w+)/post/(\\w+)");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_TEXT = new Regex("^/g/(\\w+)/text/(\\w+)");

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_VOICE = new Regex("^/g/(\\w+)/voice/(\\w+)");

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_LIVE = new Regex("^/g/(\\w+)/live/(\\w+)");

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Regex PATH_PATTERN_EVENT = new Regex("^/g/(\\w+)/event/(\\w+)");

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Set<String> domainList = new HashSet();

    a() {
    }

    private final Set<String> i() {
        Set<String> decodeStringSet = bw.L().decodeStringSet("MMKV_KEY_GUILD_URL_DAMINE", new HashSet());
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "getMMKVEntity().decodeSt\u2026LD_URL_DAMINE, HashSet())");
        domainList = decodeStringSet;
        return decodeStringSet;
    }

    private final boolean j(String url) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        if (!TextUtils.isEmpty(url)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "://qun.qq.com/qqweb/qunpro/share", false, 2, (Object) null);
            if (!contains$default) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "://pd.qq.com/qqweb/qunpro/share", false, 2, (Object) null);
                if (!contains$default3) {
                    return false;
                }
            }
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "inviteCode", false, 2, (Object) null);
            if (!contains$default2) {
                return false;
            }
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean k(@NotNull String url) {
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator<T> it = f235094a.i().iterator();
        while (it.hasNext()) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) it.next(), false, 2, (Object) null);
            if (contains$default2) {
                return true;
            }
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "://pd.qq.com/s", false, 2, (Object) null);
        return contains$default;
    }

    @JvmStatic
    public static final boolean m(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!k(url)) {
            a aVar = f235094a;
            if (!aVar.j(url) && !aVar.l(url) && !aVar.n(url)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final void o(@NotNull Set<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        if (Intrinsics.areEqual(domainList, keys)) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.share", 2, "saveShortUrlDomainList " + keys);
        }
        domainList = keys;
        bw.L().encodeStringSet("MMKV_KEY_GUILD_URL_DAMINE", keys);
    }

    @Nullable
    public final c a(@NotNull String url) {
        boolean equals$default;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        boolean z16 = false;
        equals$default = StringsKt__StringsJVMKt.equals$default(parse.getHost(), "pd.qq.com", false, 2, null);
        if (!equals$default) {
            return null;
        }
        String path = parse.getPath();
        if (path != null) {
            str = StringsKt__StringsKt.trim(path, '/');
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return new i();
        }
        if (Intrinsics.areEqual(str, "explore")) {
            return new i();
        }
        if (!Intrinsics.areEqual(str, "inbox")) {
            return null;
        }
        return new dq1.h();
    }

    @NotNull
    public final Regex b() {
        return PATH_PATTERN_EVENT;
    }

    @NotNull
    public final Regex c() {
        return PATH_PATTERN_FEED;
    }

    @NotNull
    public final Regex d() {
        return PATH_PATTERN_HOME;
    }

    @NotNull
    public final Regex e() {
        return PATH_PATTERN_LIVE;
    }

    @NotNull
    public final Regex f() {
        return PATH_PATTERN_POST;
    }

    @NotNull
    public final Regex g() {
        return PATH_PATTERN_TEXT;
    }

    @NotNull
    public final Regex h() {
        return PATH_PATTERN_VOICE;
    }

    public final boolean l(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (a(url) != null) {
            return true;
        }
        return false;
    }

    public final boolean n(@NotNull String url) {
        boolean contains$default;
        List listOf;
        Intrinsics.checkNotNullParameter(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "://pd.qq.com/g", false, 2, (Object) null);
        if (contains$default) {
            try {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Regex[]{PATH_PATTERN_HOME, PATH_PATTERN_FEED, PATH_PATTERN_POST, PATH_PATTERN_TEXT, PATH_PATTERN_VOICE, PATH_PATTERN_LIVE, PATH_PATTERN_EVENT});
                Uri parse = Uri.parse(url);
                String path = parse.getPath();
                if (path == null) {
                    return false;
                }
                List<Regex> list = listOf;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return false;
                }
                for (Regex regex : list) {
                    boolean matches = regex.matches(path);
                    if (Intrinsics.areEqual(regex, PATH_PATTERN_POST) && parse.getQueryParameter("subc") == null) {
                        matches = false;
                    }
                    if (matches) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.share.web_share", 2, "decode url failed: " + e16);
                }
                return false;
            }
        }
        return false;
    }
}

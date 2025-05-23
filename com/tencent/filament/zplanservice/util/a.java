package com.tencent.filament.zplanservice.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplanservice/util/a;", "", "", "a", "", "c", "b", "Lkotlin/text/MatchResult;", "Lkotlin/text/MatchResult;", "getMatchResult", "()Lkotlin/text/MatchResult;", "matchResult", "url", "<init>", "(Ljava/lang/String;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MatchResult matchResult;

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:9)|10|11))|15|6|7|(0)|10|11) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(@NotNull String url) {
        boolean startsWith$default;
        String str;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://pre.cdn-go.cn", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://pre.cdn-go.cn", false, 2, null);
            if (!startsWith$default2) {
                str = "^https?://([^/]+)/([^/]+)/([^/]+)/([^?]+)(?:\\?(.*))?$";
                Regex regex = new Regex(str);
                this.matchResult = regex != null ? Regex.find$default(regex, url, 0, 2, null) : null;
            }
        }
        str = "^https?://([^/]+)/[^/]+/([^/]+)/([^/]+)/([^?]+)(\\?.*)?$";
        Regex regex2 = new Regex(str);
        this.matchResult = regex2 != null ? Regex.find$default(regex2, url, 0, 2, null) : null;
    }

    public final boolean a() {
        if (this.matchResult != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String b() {
        MatchResult matchResult = this.matchResult;
        if (matchResult == null) {
            return null;
        }
        List<String> groupValues = matchResult.getGroupValues();
        if (groupValues.size() != 6) {
            return null;
        }
        return groupValues.get(4);
    }

    @Nullable
    public final String c() {
        MatchResult matchResult = this.matchResult;
        if (matchResult == null) {
            return null;
        }
        List<String> groupValues = matchResult.getGroupValues();
        if (groupValues.size() != 6) {
            return null;
        }
        return groupValues.get(3);
    }
}

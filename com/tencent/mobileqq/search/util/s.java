package com.tencent.mobileqq.search.util;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/util/s;", "", "", "keyword", "", "g", "dtAppKey", "Lorg/json/JSONObject;", "a", "", "d", "userSource", "isAddFriend", "", "tabMask", "e", "c", "f", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f285072a = new s();

    s() {
    }

    public static /* synthetic */ JSONObject b(s sVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return sVar.a(str);
    }

    private final boolean g(String keyword) {
        boolean z16;
        if (!new Regex("\\d+").matches(keyword)) {
            return false;
        }
        int length = keyword.length();
        if (5 <= length && length < 11) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @NotNull
    public final JSONObject a(@Nullable String dtAppKey) {
        JSONObject jSONObject = new JSONObject();
        if (dtAppKey == null) {
            dtAppKey = "0S200MNJT807V3GE";
        }
        jSONObject.put(DTParamKey.REPORT_KEY_APPKEY, dtAppKey);
        jSONObject.put("pageId", "pg_qq_network_search_result_level2_page");
        return jSONObject;
    }

    public final int c(long tabMask, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        boolean f16 = f(keyword);
        boolean g16 = g(keyword);
        if (!f16 && !g16) {
            if (tabMask == 1) {
                return 13;
            }
            if (tabMask != 5) {
                return 3;
            }
            return 14;
        }
        if (tabMask == 1) {
            return 11;
        }
        if (tabMask != 5) {
            return 3;
        }
        return 12;
    }

    public final int d(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (f(keyword)) {
            return 3014;
        }
        return 3020;
    }

    public final int e(int userSource, boolean isAddFriend, long tabMask, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return c(tabMask, keyword);
    }

    public final boolean f(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return new Regex("^1[0-9]{10}$").matches(keyword);
    }
}

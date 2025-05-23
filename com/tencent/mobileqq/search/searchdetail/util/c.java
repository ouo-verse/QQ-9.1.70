package com.tencent.mobileqq.search.searchdetail.util;

import android.text.TextUtils;
import com.tencent.libra.request.Option;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/c;", "", "", "url", "", "width", "height", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f284739a = new c();

    c() {
    }

    public static /* synthetic */ void b(c cVar, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        cVar.a(str, i3, i16);
    }

    public final void a(@NotNull String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Option option = Option.obtain().setUrl(url).setPredecode(false);
        SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        searchPicLoader.e(option, null);
    }
}

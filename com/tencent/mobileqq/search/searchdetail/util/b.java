package com.tencent.mobileqq.search.searchdetail.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/b;", "", "", "text", "keyword", "Landroid/text/SpannableString;", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f284738a = new b();

    b() {
    }

    @NotNull
    public final SpannableString a(@NotNull String text, @NotNull String keyword) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SpannableString spannableString = new SpannableString(text);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) text, keyword, 0, true, 2, (Object) null);
        if (indexOf$default != -1) {
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mobileqq.webview.view.b.a(R.color.qui_common_brand_standard)), indexOf$default, keyword.length() + indexOf$default, 33);
        }
        return spannableString;
    }
}

package com.tencent.mobileqq.search.fragment;

import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/fragment/SearchEntryFragment;", "Lkotlin/Function1;", "", "", "", "", "callback", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchEntryFragmentExtKt {
    public static final void a(@NotNull SearchEntryFragment searchEntryFragment, @NotNull Function1<? super Map<Integer, String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(searchEntryFragment, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(searchEntryFragment), "SearchEntryFragmentExt loadModHashMap", Boolean.FALSE, null, Boolean.TRUE, new SearchEntryFragmentExtKt$loadModHashMap$1(searchEntryFragment, callback, null), 4, null);
    }
}

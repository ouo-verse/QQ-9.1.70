package com.tencent.mobileqq.search.searchdetail.content;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupSearchFilterCondition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "", "callback", "e", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupSearchFilterCondition;", "sdkFilter", h.F, "g", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "condition", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchGroupFilterManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SearchGroupFilterManager f283869a = new SearchGroupFilterManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SearchGroupFilterConditionLocal condition;

    SearchGroupFilterManager() {
    }

    private final void e(final Function1<? super SearchGroupFilterConditionLocal, Unit> callback) {
        SearchGroupFilterConditionLocal searchGroupFilterConditionLocal = condition;
        if (searchGroupFilterConditionLocal != null) {
            callback.invoke(searchGroupFilterConditionLocal);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.b
                @Override // java.lang.Runnable
                public final void run() {
                    SearchGroupFilterManager.f(Function1.this);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(ah.f284994a.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SearchGroupFilterConditionLocal condition2) {
        Intrinsics.checkNotNullParameter(condition2, "$condition");
        ah.f284994a.p(condition2);
    }

    public final void d(@NotNull Function1<? super SearchGroupFilterConditionLocal, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e(new SearchGroupFilterManager$getCondition$1(this, callback));
    }

    public final void g() {
        condition = null;
    }

    public final void h(@Nullable SearchGroupSearchFilterCondition sdkFilter) {
        if (sdkFilter != null) {
            final SearchGroupFilterConditionLocal a16 = SearchGroupFilterConditionLocal.INSTANCE.a(sdkFilter);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.c
                @Override // java.lang.Runnable
                public final void run() {
                    SearchGroupFilterManager.i(SearchGroupFilterConditionLocal.this);
                }
            }, 16, null, false);
            condition = a16;
        }
    }
}

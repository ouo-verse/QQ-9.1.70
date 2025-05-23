package com.tencent.mobileqq.search.searchdetail.util;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1 extends Lambda implements Function1<ArrayList<String>, Unit> {
    final /* synthetic */ Function1<ArrayList<String>, Unit> $getSugWordsCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1(Function1<? super ArrayList<String>, Unit> function1) {
        super(1);
        this.$getSugWordsCallback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 getSugWordsCallback, ArrayList list) {
        Intrinsics.checkNotNullParameter(getSugWordsCallback, "$getSugWordsCallback");
        Intrinsics.checkNotNullParameter(list, "$list");
        getSugWordsCallback.invoke(list);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
        invoke2(arrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final ArrayList<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Function1<ArrayList<String>, Unit> function1 = this.$getSugWordsCallback;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.util.j
            @Override // java.lang.Runnable
            public final void run() {
                SearchBoxWordsUtil$getSearchBoxSugWords$proxyCb$1.b(Function1.this, list);
            }
        });
    }
}

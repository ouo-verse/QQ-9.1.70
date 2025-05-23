package com.tencent.mobileqq.search.searchdetail.content;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "condition", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SearchGroupFilterManager$getCondition$1 extends Lambda implements Function1<SearchGroupFilterConditionLocal, Unit> {
    final /* synthetic */ Function1<SearchGroupFilterConditionLocal, Unit> $callback;
    final /* synthetic */ SearchGroupFilterManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchGroupFilterManager$getCondition$1(SearchGroupFilterManager searchGroupFilterManager, Function1<? super SearchGroupFilterConditionLocal, Unit> function1) {
        super(1);
        this.this$0 = searchGroupFilterManager;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchGroupFilterConditionLocal searchGroupFilterConditionLocal, SearchGroupFilterManager this$0, Function1 callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (searchGroupFilterConditionLocal != null) {
            SearchGroupFilterManager.condition = searchGroupFilterConditionLocal;
            callback.invoke(searchGroupFilterConditionLocal);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(new SearchGroupFilterConditionLocal());
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("SearchGroupFilterManager", " empty cache condition");
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchGroupFilterConditionLocal searchGroupFilterConditionLocal) {
        invoke2(searchGroupFilterConditionLocal);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final SearchGroupFilterConditionLocal searchGroupFilterConditionLocal) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final SearchGroupFilterManager searchGroupFilterManager = this.this$0;
        final Function1<SearchGroupFilterConditionLocal, Unit> function1 = this.$callback;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.d
            @Override // java.lang.Runnable
            public final void run() {
                SearchGroupFilterManager$getCondition$1.b(SearchGroupFilterConditionLocal.this, searchGroupFilterManager, function1);
            }
        });
    }
}

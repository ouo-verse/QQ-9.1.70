package com.tencent.mobileqq.search;

import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.model.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisResult;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class BaseSearchEntryModel$loadDataFromRepo$1 extends Lambda implements Function1<Triple<? extends Integer, ? extends String, ? extends UfsDisRspBody>, Unit> {
    final /* synthetic */ SearchEntryDataModel $model;
    final /* synthetic */ BaseSearchEntryModel<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSearchEntryModel$loadDataFromRepo$1(SearchEntryDataModel searchEntryDataModel, BaseSearchEntryModel<T> baseSearchEntryModel) {
        super(1);
        this.$model = searchEntryDataModel;
        this.this$0 = baseSearchEntryModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseSearchEntryModel this$0, SearchEntryDataModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        this$0.S(model);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Integer, ? extends String, ? extends UfsDisRspBody> triple) {
        invoke2((Triple<Integer, String, UfsDisRspBody>) triple);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Triple<Integer, String, UfsDisRspBody> triple) {
        Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
        int intValue = triple.component1().intValue();
        String component2 = triple.component2();
        UfsDisRspBody component3 = triple.component3();
        QLog.d("QQSearch.Local.entry.BaseSearchEntryModel", 2, "loadDataFromRepo rcv " + intValue + " " + component2);
        if (com.tencent.mobileqq.search.util.n.e(intValue)) {
            ArrayList<UfsDisResult> arrayList = component3.resultItems;
            QLog.d("QQSearch.Local.entry.BaseSearchEntryModel", 2, "result size: " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
            ak.b(component3, this.$model);
            final BaseSearchEntryModel<T> baseSearchEntryModel = this.this$0;
            final SearchEntryDataModel searchEntryDataModel = this.$model;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.search.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSearchEntryModel$loadDataFromRepo$1.b(BaseSearchEntryModel.this, searchEntryDataModel);
                }
            });
            return;
        }
        QLog.e("QQSearch.Local.entry.BaseSearchEntryModel", 1, "loadDataFromRepo failed " + intValue + " ," + component2 + "," + component3);
    }
}

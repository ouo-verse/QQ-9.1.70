package com.tencent.sqshow.zootopia.samestyle;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "cats", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class TemplateEntranceViewModel$fetchTemplateCats$1$2 extends Lambda implements Function1<List<? extends ZPlanTemplateCat>, Unit> {
    final /* synthetic */ TemplateEntranceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateEntranceViewModel$fetchTemplateCats$1$2(TemplateEntranceViewModel templateEntranceViewModel) {
        super(1);
        this.this$0 = templateEntranceViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TemplateEntranceViewModel this$0, List cats) {
        MutableLiveData mutableLiveData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cats, "$cats");
        mutableLiveData = this$0._templateCats;
        mutableLiveData.setValue(cats);
        this$0.isRequestTemplateCats = false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZPlanTemplateCat> list) {
        invoke2((List<ZPlanTemplateCat>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<ZPlanTemplateCat> cats) {
        Intrinsics.checkNotNullParameter(cats, "cats");
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final TemplateEntranceViewModel templateEntranceViewModel = this.this$0;
        uIHandler.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.d
            @Override // java.lang.Runnable
            public final void run() {
                TemplateEntranceViewModel$fetchTemplateCats$1$2.b(TemplateEntranceViewModel.this, cats);
            }
        });
    }
}

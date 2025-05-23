package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import com.tencent.mobileqq.matchfriend.reborn.publish.config.TipsBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "it", "", "invoke", "(Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishTipsPart$updateTips$1 extends Lambda implements Function1<TipsBean, Unit> {
    final /* synthetic */ SquareFeedPublishTipsPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFeedPublishTipsPart$updateTips$1(SquareFeedPublishTipsPart squareFeedPublishTipsPart) {
        super(1);
        this.this$0 = squareFeedPublishTipsPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TipsBean tipsBean, SquareFeedPublishTipsPart this$0) {
        r82.a D9;
        List list;
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (tipsBean == null) {
            this$0.H9(false);
            QLog.i("SquareFeedPublishTipsPart", 1, "[updateTips] config is null");
            return;
        }
        this$0.tipsDataList = tipsBean.b();
        D9 = this$0.D9();
        list = this$0.tipsDataList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        D9.setData(mutableList);
        this$0.H9(true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TipsBean tipsBean) {
        invoke2(tipsBean);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final TipsBean tipsBean) {
        final SquareFeedPublishTipsPart squareFeedPublishTipsPart = this.this$0;
        squareFeedPublishTipsPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.i
            @Override // java.lang.Runnable
            public final void run() {
                SquareFeedPublishTipsPart$updateTips$1.b(TipsBean.this, squareFeedPublishTipsPart);
            }
        });
    }
}

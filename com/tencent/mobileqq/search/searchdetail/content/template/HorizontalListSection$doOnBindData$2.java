package com.tencent.mobileqq.search.searchdetail.content.template;

import android.view.View;
import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchListItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public /* synthetic */ class HorizontalListSection$doOnBindData$2 extends FunctionReferenceImpl implements Function1<QSearchListItemModel, View> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HorizontalListSection$doOnBindData$2(Object obj) {
        super(1, obj, HorizontalListSection.class, "buildCircleItem", "buildCircleItem(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/QSearchListItemModel;)Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final View invoke(@NotNull QSearchListItemModel p06) {
        View b06;
        Intrinsics.checkNotNullParameter(p06, "p0");
        b06 = ((HorizontalListSection) this.receiver).b0(p06);
        return b06;
    }
}

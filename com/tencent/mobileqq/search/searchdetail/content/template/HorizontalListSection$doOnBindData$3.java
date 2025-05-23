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
public /* synthetic */ class HorizontalListSection$doOnBindData$3 extends FunctionReferenceImpl implements Function1<QSearchListItemModel, View> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HorizontalListSection$doOnBindData$3(Object obj) {
        super(1, obj, HorizontalListSection.class, "buildRectItem", "buildRectItem(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/QSearchListItemModel;)Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final View invoke(@NotNull QSearchListItemModel p06) {
        View c06;
        Intrinsics.checkNotNullParameter(p06, "p0");
        c06 = ((HorizontalListSection) this.receiver).c0(p06);
        return c06;
    }
}

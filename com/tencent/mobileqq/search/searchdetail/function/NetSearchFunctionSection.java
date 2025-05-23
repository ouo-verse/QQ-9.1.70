package com.tencent.mobileqq.search.searchdetail.function;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import hp2.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/function/NetSearchFunctionSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/function/d;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "y", "data", "", "position", "", "", "payload", "X", "Lcom/tencent/mobileqq/search/searchdetail/function/b;", "D", "Lcom/tencent/mobileqq/search/searchdetail/function/b;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "()V", "E", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchFunctionSection extends BaseSearchTemplateSection<NetSearchFunctionItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b card;

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull NetSearchFunctionItem data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        b bVar = this.card;
        if (bVar != null) {
            bVar.d(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        View view;
        boolean z16;
        if (containerView != null) {
            view = containerView.findViewById(R.id.toe);
        } else {
            view = null;
        }
        if (view == null) {
            if (containerView == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.e("QQSearch.NetDetail.NetSearchFunctionSection", 1, "onInitView failed for rootView got null,container null:" + z16);
            return;
        }
        n e16 = n.e(view);
        Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView)");
        this.card = new b(e16, new Function1<SearchJump, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.function.NetSearchFunctionSection$doOnInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchJump searchJump) {
                invoke2(searchJump);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SearchJump it) {
                Intrinsics.checkNotNullParameter(it, "it");
                g.a.a(NetSearchFunctionSection.this, it, null, 2, null);
            }
        });
    }
}

package com.tencent.mobileqq.wink.publish.part;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishRecommendTagPart$observeData$2 extends Lambda implements Function1<PublishTagViewModel.TagData, Unit> {
    final /* synthetic */ PublishRecommendTagPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishRecommendTagPart$observeData$2(PublishRecommendTagPart publishRecommendTagPart) {
        super(1);
        this.this$0 = publishRecommendTagPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View this_run, PublishTagViewModel.TagData tagData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        com.tencent.mobileqq.wink.f.l(this_run.getContext(), tagData.getTagTipsJumpUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PublishTagViewModel.TagData tagData) {
        invoke2(tagData);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(final PublishTagViewModel.TagData tagData) {
        View view;
        com.tencent.mobileqq.wink.publish.adapter.c cVar;
        RecyclerView recyclerView;
        com.tencent.mobileqq.wink.publish.adapter.c cVar2;
        RecyclerView recyclerView2;
        boolean isBlank;
        TextView T9;
        View S9;
        TextView T92;
        final View S92;
        boolean isBlank2;
        PartsStateViewModel Q9;
        View view2;
        RecyclerView recyclerView3;
        com.tencent.mobileqq.wink.publish.adapter.c cVar3;
        View view3;
        if (tagData.b().isEmpty()) {
            view3 = this.this$0.tagLayoutContainer;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
            return;
        }
        this.this$0.tagRecomType = tagData.getRecomType();
        view = this.this$0.tagLayoutContainer;
        if (view != null && view.getVisibility() == 8) {
            Q9 = this.this$0.Q9();
            PublishSettingItemState value = Q9.h2().getValue();
            if (value != null && value.getVisible()) {
                view2 = this.this$0.tagLayoutContainer;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                recyclerView3 = this.this$0.tagRecyclerView;
                if (recyclerView3 != null) {
                    recyclerView3.scrollToPosition(0);
                }
                cVar3 = this.this$0.tagAdapter;
                if (cVar3 != null) {
                    cVar3.l0(tagData.b());
                }
                this.this$0.aa();
                isBlank = StringsKt__StringsJVMKt.isBlank(tagData.getTagTips());
                if (!(!isBlank)) {
                    T92 = this.this$0.T9();
                    T92.setVisibility(0);
                    T92.setText(tagData.getTagTips());
                    S92 = this.this$0.S9();
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(tagData.getTagTipsJumpUrl());
                    if (isBlank2) {
                        S92.setVisibility(8);
                        return;
                    } else {
                        S92.setVisibility(0);
                        S92.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.bc
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                PublishRecommendTagPart$observeData$2.b(S92, tagData, view4);
                            }
                        });
                        return;
                    }
                }
                T9 = this.this$0.T9();
                T9.setVisibility(8);
                S9 = this.this$0.S9();
                S9.setVisibility(8);
                return;
            }
        }
        if (tagData.getUpdateSize() > 0) {
            recyclerView = this.this$0.tagRecyclerView;
            RecyclerView.ItemAnimator itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
            if (itemAnimator != null) {
                itemAnimator.setAddDuration(tagData.getUpdateSize() >= 2 ? 400L : 200L);
            }
            cVar2 = this.this$0.tagAdapter;
            if (cVar2 != null) {
                cVar2.m0(tagData.b(), 0, tagData.getUpdateSize());
            }
            recyclerView2 = this.this$0.tagRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.scrollToPosition(0);
            }
        } else {
            cVar = this.this$0.tagAdapter;
            if (cVar != null) {
                cVar.l0(tagData.b());
            }
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(tagData.getTagTips());
        if (!(!isBlank)) {
        }
    }
}

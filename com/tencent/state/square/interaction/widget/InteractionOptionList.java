package com.tencent.state.square.interaction.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.square.interaction.InteractionSettingOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J-\u0010\u0014\u001a\u00020\r2%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u000eJ-\u0010\u0016\u001a\u00020\r2%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u000eJ-\u0010\u0017\u001a\u00020\r2%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u000eJ\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bR1\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionOptionList;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "changeOptionCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "Lcom/tencent/state/square/interaction/widget/CallbackFunc;", "clickOptionCallback", "deleteOptionCallback", "itemViews", "", "Lcom/tencent/state/square/interaction/widget/InteractionOptionItem;", "onChangeOption", "cb", "onClickOption", "onDeleteOption", "reportItemDestroy", "updateData", "options", "", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionOptionList extends LinearLayout {
    private Function1<? super Integer, Unit> changeOptionCallback;
    private Function1<? super Integer, Unit> clickOptionCallback;
    private Function1<? super Integer, Unit> deleteOptionCallback;
    private List<InteractionOptionItem> itemViews;

    public /* synthetic */ InteractionOptionList(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void onChangeOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.changeOptionCallback = cb5;
    }

    public final void onClickOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.clickOptionCallback = cb5;
    }

    public final void onDeleteOption(Function1<? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.deleteOptionCallback = cb5;
    }

    public final void reportItemDestroy() {
        Iterator<T> it = this.itemViews.iterator();
        while (it.hasNext()) {
            ((InteractionOptionItem) it.next()).reportDestroy();
        }
    }

    public final void updateData(List<InteractionSettingOption> options) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(options, "options");
        List<InteractionSettingOption> list = options;
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
        final int i3 = 0;
        final boolean z16 = filterNotNull.size() == 1;
        if (this.itemViews.size() == 0) {
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                InteractionOptionItem interactionOptionItem = new InteractionOptionItem(context, null, 2, 0 == true ? 1 : 0);
                interactionOptionItem.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                interactionOptionItem.updateData(i3, (InteractionSettingOption) obj, z16);
                interactionOptionItem.onClickOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionList$updateData$$inlined$forEachIndexed$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
                    
                        r2 = r2.clickOptionCallback;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(int i17) {
                        Function1 function1;
                        Function1 function12;
                        function1 = this.clickOptionCallback;
                        if (function1 == null || function12 == null) {
                            return;
                        }
                    }
                });
                interactionOptionItem.onDeleteOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionList$updateData$$inlined$forEachIndexed$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
                    
                        r2 = r2.deleteOptionCallback;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(int i17) {
                        Function1 function1;
                        Function1 function12;
                        function1 = this.deleteOptionCallback;
                        if (function1 == null || function12 == null) {
                            return;
                        }
                    }
                });
                interactionOptionItem.onChangeOption(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionOptionList$updateData$$inlined$forEachIndexed$lambda$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
                    
                        r2 = r2.changeOptionCallback;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(int i17) {
                        Function1 function1;
                        Function1 function12;
                        function1 = this.changeOptionCallback;
                        if (function1 == null || function12 == null) {
                            return;
                        }
                    }
                });
                addView(interactionOptionItem);
                this.itemViews.add(interactionOptionItem);
                i3 = i16;
            }
            return;
        }
        for (Object obj2 : list) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            this.itemViews.get(i3).updateData(i3, (InteractionSettingOption) obj2, z16);
            i3 = i17;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionOptionList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemViews = new ArrayList();
        setOrientation(1);
    }
}

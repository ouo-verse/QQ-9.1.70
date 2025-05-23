package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.util.Consumer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.view.TVideoSettingChooseItemView;
import com.tencent.mobileqq.tvideo.view.TVideoSettingDefinitionView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vx2.Definition;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB1\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/TVideoSettingDefinitionView;", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView;", "Landroidx/core/util/Consumer;", "Lvx2/a;", "callback", "", "setOnDefinitionChangedCallback", "", "c", "", "definitionList", "f", "definition", "setCurrentDefinition", h.F, "Landroidx/core/util/Consumer;", "definitionConsumer", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoSettingDefinitionView extends TVideoSettingChooseView {

    @NotNull
    private static final List<String> C;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Consumer<Definition> definitionConsumer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<Definition> definitionList;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sd", "hd", "shd"});
        C = listOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingDefinitionView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TVideoSettingChooseItemView itemView, TVideoSettingDefinitionView this$0, Definition definition, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(definition, "$definition");
        if (!itemView.getIsChosen()) {
            Consumer<Definition> consumer = this$0.definitionConsumer;
            if (consumer != null) {
                consumer.accept(definition);
            }
            this$0.setCurrentDefinition(definition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.tvideo.view.TVideoSettingChooseView
    @NotNull
    protected String c() {
        return "\u6e05\u6670\u5ea6";
    }

    public final void f(@Nullable List<Definition> definitionList) {
        if (definitionList == null) {
            return;
        }
        LinearLayout itemContainerView = getItemContainerView();
        if (itemContainerView != null) {
            itemContainerView.removeAllViews();
        }
        b().clear();
        this.definitionList = new ArrayList<>();
        for (final Definition definition : definitionList) {
            if (C.contains(definition.getDefinitionId())) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                final TVideoSettingChooseItemView tVideoSettingChooseItemView = new TVideoSettingChooseItemView(context, null, 0, 6, null);
                tVideoSettingChooseItemView.setContent(definition.getShowName());
                tVideoSettingChooseItemView.setOnClickListener(new View.OnClickListener() { // from class: ky2.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TVideoSettingDefinitionView.g(TVideoSettingChooseItemView.this, this, definition, view);
                    }
                });
                LinearLayout itemContainerView2 = getItemContainerView();
                if (itemContainerView2 != null) {
                    itemContainerView2.addView(tVideoSettingChooseItemView);
                }
                b().add(tVideoSettingChooseItemView);
                ArrayList<Definition> arrayList = this.definitionList;
                if (arrayList != null) {
                    arrayList.add(definition);
                }
            }
        }
    }

    public final void setCurrentDefinition(@Nullable Definition definition) {
        int i3;
        String str;
        Definition definition2;
        if (definition == null) {
            return;
        }
        ArrayList<Definition> arrayList = this.definitionList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            TVideoSettingChooseItemView tVideoSettingChooseItemView = b().get(i16);
            String definitionId = definition.getDefinitionId();
            ArrayList<Definition> arrayList2 = this.definitionList;
            if (arrayList2 != null && (definition2 = arrayList2.get(i16)) != null) {
                str = definition2.getDefinitionId();
            } else {
                str = null;
            }
            tVideoSettingChooseItemView.setChosen(Intrinsics.areEqual(definitionId, str));
        }
    }

    public final void setOnDefinitionChangedCallback(@NotNull Consumer<Definition> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.definitionConsumer = callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingDefinitionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingDefinitionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TVideoSettingDefinitionView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingDefinitionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        d();
    }
}

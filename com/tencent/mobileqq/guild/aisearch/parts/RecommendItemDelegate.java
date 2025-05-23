package com.tencent.mobileqq.guild.aisearch.parts;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B*\u0012!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0011\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0014R2\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u00128\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/RecommendItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "", "items", "", "position", "", "j", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "payloads", "", "k", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RecommendItemDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends Object>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> onItemClick;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendItemDelegate(@NotNull Function1<? super AISearchRecommendRepository.RecommendItem.RecommendWord, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = View.inflate(parent.getContext(), R.layout.edz, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new g(view, this.onItemClick);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends Object> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof AISearchRecommendRepository.RecommendItem.RecommendWord;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends Object> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        AISearchRecommendRepository.RecommendItem.RecommendWord recommendWord;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof g) {
            Object obj = items.get(position);
            if (obj instanceof AISearchRecommendRepository.RecommendItem.RecommendWord) {
                recommendWord = (AISearchRecommendRepository.RecommendItem.RecommendWord) obj;
            } else {
                recommendWord = null;
            }
            if (recommendWord == null) {
                return;
            }
            ((g) holder).n(recommendWord);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

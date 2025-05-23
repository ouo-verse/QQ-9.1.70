package com.tencent.mobileqq.guild.aisearch.parts;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/aisearch/parts/d$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "oldItem", "newItem", "", "areItemsTheSame", "areContentsTheSame", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends DiffUtil.ItemCallback<Object> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof AISearchRecommendRepository.RecommendItem.RecommendWord) && (newItem instanceof AISearchRecommendRepository.RecommendItem.RecommendWord)) {
                if (((AISearchRecommendRepository.RecommendItem.RecommendWord) oldItem).getIndex() == ((AISearchRecommendRepository.RecommendItem.RecommendWord) newItem).getIndex()) {
                    return true;
                }
                return false;
            }
            if ((oldItem instanceof AISearchRecommendRepository.RecommendItem.TitleText) && (newItem instanceof AISearchRecommendRepository.RecommendItem.TitleText)) {
                return true;
            }
            return false;
        }
    }

    @NotNull
    public static final DiffUtil.ItemCallback<Object> a() {
        return new a();
    }
}

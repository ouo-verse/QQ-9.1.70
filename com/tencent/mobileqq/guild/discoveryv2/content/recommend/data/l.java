package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "", "getItemId", "getRecommendItem", "()Ljava/lang/Object;", "recommendItem", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface l<T> extends com.tencent.mobileqq.guild.discoveryv2.content.base.h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static <T> boolean a(@NotNull l<T> lVar, @NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (lVar.getClass().isInstance(newItem) && newItem.getItemId() == lVar.getItemId()) {
                return true;
            }
            return false;
        }

        public static <T> boolean b(@NotNull l<T> lVar, @NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (lVar.getClass().isInstance(newItem) && newItem.getItemId() == lVar.getItemId()) {
                return true;
            }
            return false;
        }

        @Nullable
        public static <T> Object c(@NotNull l<T> lVar, @NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return null;
        }

        public static <T> long d(@NotNull l<T> lVar) {
            int i3;
            T recommendItem = lVar.getRecommendItem();
            if (recommendItem != null) {
                i3 = recommendItem.hashCode();
            } else {
                i3 = 0;
            }
            return i3 + lVar.getRecommendExtData().hashCode();
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    long getItemId();

    @NotNull
    RecommendExtData getRecommendExtData();

    T getRecommendItem();
}

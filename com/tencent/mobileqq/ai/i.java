package com.tencent.mobileqq.ai;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ai.b;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarSubCategoryInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u0017\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/ai/i;", "Lcom/tencent/mobileqq/ai/b;", "T", "D", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "feedsInfo", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;)Ljava/lang/Object;", "", com.tencent.luggage.wxa.c8.c.G, "data", "c", "(ILcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;Ljava/lang/Object;)I", "Landroid/content/Context;", "context", "itemViewType", "b", "(Landroid/content/Context;I)Lcom/tencent/mobileqq/ai/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "(Lcom/tencent/mobileqq/ai/b;ILcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;Ljava/lang/Object;)V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface i<T extends b, D> {
    D a(@NotNull AiAvatarSubCategoryInfo feedsInfo);

    @NotNull
    T b(@NotNull Context context, int itemViewType);

    int c(int pos, @NotNull AiAvatarSubCategoryInfo feedsInfo, D data);

    void d(@NotNull T item, int pos, @NotNull AiAvatarSubCategoryInfo feedsInfo, D data);
}

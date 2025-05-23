package com.tencent.mobileqq.guild.widget.adapterdelegates;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/e;", "T", "", "newItem", "", "areItemsTheSame", "(Ljava/lang/Object;)Z", "areContentsTheSame", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e<T> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        @Nullable
        public static <T> Object a(@NotNull e<T> eVar, T t16) {
            return null;
        }
    }

    boolean areContentsTheSame(T newItem);

    boolean areItemsTheSame(T newItem);
}

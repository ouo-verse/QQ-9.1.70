package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/api/ISquarePagViewListener;", "", "onAnimationCancel", "", "squarePagView", "Lcom/tencent/state/square/api/ISquarePagView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquarePagViewListener {
    void onAnimationCancel(@Nullable ISquarePagView squarePagView);

    void onAnimationEnd(@Nullable ISquarePagView squarePagView);

    void onAnimationRepeat(@Nullable ISquarePagView squarePagView);

    void onAnimationStart(@Nullable ISquarePagView squarePagView);

    void onAnimationUpdate(@Nullable ISquarePagView squarePagView);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static void onAnimationCancel(@NotNull ISquarePagViewListener iSquarePagViewListener, @Nullable ISquarePagView iSquarePagView) {
        }

        public static void onAnimationEnd(@NotNull ISquarePagViewListener iSquarePagViewListener, @Nullable ISquarePagView iSquarePagView) {
        }

        public static void onAnimationRepeat(@NotNull ISquarePagViewListener iSquarePagViewListener, @Nullable ISquarePagView iSquarePagView) {
        }

        public static void onAnimationStart(@NotNull ISquarePagViewListener iSquarePagViewListener, @Nullable ISquarePagView iSquarePagView) {
        }

        public static void onAnimationUpdate(@NotNull ISquarePagViewListener iSquarePagViewListener, @Nullable ISquarePagView iSquarePagView) {
        }
    }
}

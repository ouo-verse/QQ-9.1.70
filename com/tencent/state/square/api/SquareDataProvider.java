package com.tencent.state.square.api;

import com.tencent.state.data.Image;
import com.tencent.state.map.MapItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0085\u0001\u0010\u0002\u001a\u00020\u00032{\u0010\u0004\u001aw\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/api/SquareDataProvider;", "", "getSquareNextPage", "", "callback", "Lkotlin/Function5;", "", "Lcom/tencent/state/map/MapItem;", "Lkotlin/ParameterName;", "name", "list", "", "hasNext", "Lcom/tencent/state/data/Image;", "map", "uesCache", "isForbid", "isFirstPage", "isLastPage", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface SquareDataProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static boolean isFirstPage(@NotNull SquareDataProvider squareDataProvider) {
            return true;
        }

        public static boolean isLastPage(@NotNull SquareDataProvider squareDataProvider) {
            return false;
        }
    }

    void getSquareNextPage(@NotNull Function5<? super List<? extends MapItem>, ? super Boolean, ? super Image, ? super Boolean, ? super Boolean, Unit> callback);

    boolean isFirstPage();

    boolean isLastPage();
}

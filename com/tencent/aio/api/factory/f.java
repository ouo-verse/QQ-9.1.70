package com.tencent.aio.api.factory;

import com.tencent.aio.api.factory.h;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J \u0010\u0011\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u00100\u0002\u0018\u00010\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/api/factory/h;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "buildTopTipVB", "buildShortcutBarVB", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "buildBottomBarVB", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "buildBusinessVB", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface f extends h {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static com.tencent.aio.base.mvvm.a<Object, Object> a(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> b(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> c(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.base.mvvm.a<Object, Object> d(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> e(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> f(@NotNull f fVar) {
            return null;
        }

        @Nullable
        public static com.tencent.aio.api.b g(@NotNull f fVar) {
            return h.a.a(fVar);
        }
    }

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB();

    @Nullable
    List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB();

    @Nullable
    com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB();

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB();

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB();

    @Nullable
    com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB();
}

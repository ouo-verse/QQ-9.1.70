package com.tencent.richframework.compat.immersive.color;

import android.util.Pair;
import android.view.View;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/IColorFetcher;", "", "Landroid/view/View;", "view", "", "canHandle", "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher$Area;", GdtGetUserInfoHandler.KEY_AREA, "Landroid/util/Pair;", "", "getColor", "Area", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IColorFetcher {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/IColorFetcher$Area;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum Area {
        TOP,
        BOTTOM
    }

    boolean canHandle(@NotNull View view);

    @NotNull
    Pair<Boolean, Integer> getColor(@NotNull View view, @NotNull Area area);
}

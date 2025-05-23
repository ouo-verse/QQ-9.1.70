package com.tencent.richframework.compat.immersive.color;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/ColorFetcherManager;", "", "Landroid/view/View;", "view", "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher;", "findTargetColorFetcher", "", "sColorFetcher", "Ljava/util/List;", "<init>", "()V", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ColorFetcherManager {

    @NotNull
    public static final ColorFetcherManager INSTANCE = new ColorFetcherManager();
    private static final List<IColorFetcher> sColorFetcher;

    static {
        ArrayList arrayList = new ArrayList();
        sColorFetcher = arrayList;
        arrayList.add(new BitmapDrawableColorFetcher());
        arrayList.add(new ColorDrawableFetcher());
        arrayList.add(new GradientDrawableFetcher());
        arrayList.add(new DrawableDrawColorFetcher());
    }

    ColorFetcherManager() {
    }

    @Nullable
    public final synchronized IColorFetcher findTargetColorFetcher(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        for (IColorFetcher iColorFetcher : sColorFetcher) {
            if (iColorFetcher.canHandle(view)) {
                return iColorFetcher;
            }
        }
        return null;
    }
}

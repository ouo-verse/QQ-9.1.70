package com.tencent.state.decode;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"defaultRegionConfig", "Lcom/tencent/state/decode/RegionConfig;", "Landroid/content/Context;", "mapName", "", "url", "mapWidth", "", "mapHeight", "initRect", "Landroid/graphics/Rect;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class ILargeImageViewKt {
    public static final RegionConfig defaultRegionConfig(Context defaultRegionConfig, String mapName, String url, int i3, int i16, Rect initRect) {
        Intrinsics.checkNotNullParameter(defaultRegionConfig, "$this$defaultRegionConfig");
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(initRect, "initRect");
        return new RegionConfig(mapName, url, i3, i16, ViewExtensionsKt.calPx(defaultRegionConfig, 300), ViewExtensionsKt.calPx(defaultRegionConfig, 400), initRect, null, 128, null);
    }

    public static /* synthetic */ RegionConfig defaultRegionConfig$default(Context context, String str, String str2, int i3, int i16, Rect rect, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            str2 = "";
        }
        return defaultRegionConfig(context, str, str2, i3, i16, rect);
    }
}

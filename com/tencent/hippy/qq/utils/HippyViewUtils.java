package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippy/qq/utils/HippyViewUtils;", "", "()V", "getBackgroundColor", "", "view", "Landroid/view/View;", "getViewRenderNodeValue", "", "key", "hasBackgroundColor", "", "isViewScreenHidden", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyViewUtils {

    @NotNull
    public static final HippyViewUtils INSTANCE = new HippyViewUtils();

    HippyViewUtils() {
    }

    private final String getViewRenderNodeValue(View view, String key) {
        HippyMap hippyMap;
        if (!(view.getContext() instanceof HippyInstanceContext)) {
            return "";
        }
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mtt.hippy.HippyInstanceContext");
        RenderNode renderNode = ((HippyInstanceContext) context).getEngineContext().getRenderManager().getRenderNode(view.getId());
        String str = null;
        if (renderNode != null) {
            hippyMap = renderNode.getProps();
        } else {
            hippyMap = null;
        }
        if (hippyMap != null) {
            str = hippyMap.getString(key);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final long getBackgroundColor(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view.getContext() instanceof HippyInstanceContext)) {
            return 0L;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mtt.hippy.HippyInstanceContext");
        HippyMap map = ((HippyInstanceContext) context).getEngineContext().getRenderManager().getRenderNode(view.getId()).getProps().getMap("style");
        if (map == null) {
            return 0L;
        }
        return map.getLong("backgroundColor");
    }

    public final boolean hasBackgroundColor(@NotNull View view) {
        HippyMap hippyMap;
        HippyMap props;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view.getContext() instanceof HippyInstanceContext)) {
            return false;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mtt.hippy.HippyInstanceContext");
        RenderNode renderNode = ((HippyInstanceContext) context).getEngineContext().getRenderManager().getRenderNode(view.getId());
        if (renderNode != null && (props = renderNode.getProps()) != null) {
            hippyMap = props.getMap("style");
        } else {
            hippyMap = null;
        }
        if (hippyMap == null) {
            return false;
        }
        return hippyMap.containsKey("backgroundColor");
    }

    public final boolean isViewScreenHidden(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Boolean.parseBoolean(getViewRenderNodeValue(view, ScreenShotHelper.SCREEN_HIDDEN));
    }
}

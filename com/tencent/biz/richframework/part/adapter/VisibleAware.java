package com.tencent.biz.richframework.part.adapter;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/part/adapter/VisibleAware;", "", "", NodeProps.VISIBLE, "", "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "part-adapter_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface VisibleAware {
    void onAttachedChanged(boolean attached);

    void onDestroy();

    void onVisibleChanged(boolean visible);
}

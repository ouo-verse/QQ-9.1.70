package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface DomActionInterceptor {
    HippyMap onCreateNode(int i3, HippyRootView hippyRootView, HippyMap hippyMap);

    void onDeleteNode(int i3);

    HippyMap onUpdateNode(int i3, HippyRootView hippyRootView, HippyMap hippyMap);
}

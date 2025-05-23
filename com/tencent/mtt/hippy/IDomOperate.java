package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.runtime.builtins.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IDomOperate {
    void callUIFunction(HippyArray hippyArray, Promise promise);

    void createNode(int i3, HippyArray hippyArray);

    void deleteNode(int i3, HippyArray hippyArray);

    void endBatch();

    void flushBatch(int i3, HippyArray hippyArray);

    void getBoundingClientRect(int i3, e eVar, Promise promise);

    void getNodeForLocation(HippyMap hippyMap, Promise promise);

    void measureInWindow(int i3, Promise promise);

    void startBatch();

    void updateNode(int i3, HippyArray hippyArray);
}

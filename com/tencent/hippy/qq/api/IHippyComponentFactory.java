package com.tencent.hippy.qq.api;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IHippyComponentFactory {
    HippyAPIProvider getApiProvider();

    HippyCustomViewCreator getViewCreator();

    boolean matchName(String str);
}

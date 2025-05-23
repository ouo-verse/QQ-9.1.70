package com.tencent.mtt.hippy.uimanager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyCustomViewCreator {
    public static final String HIPPY_CUSTOM_VIEW_CREATOR = "CustomViewCreator";

    View createCustomView(String str, Context context, HippyMap hippyMap);
}

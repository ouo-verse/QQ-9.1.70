package com.tencent.comic.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQCustomViewCreator implements HippyCustomViewCreator {
    @Override // com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator
    public View createCustomView(String str, Context context, HippyMap hippyMap) {
        if (TextUtils.equals("WebView", str)) {
            return new QQHippyWebView(context);
        }
        return null;
    }
}

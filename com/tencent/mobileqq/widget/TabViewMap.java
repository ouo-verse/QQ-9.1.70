package com.tencent.mobileqq.widget;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabViewMap extends HashMap<String, View> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public View put(String str, View view) {
        if (QLog.isDebugVersion()) {
            QLog.e("TabViewMap", 4, "put  key:" + str + ", view:" + view);
        }
        return (View) super.put((TabViewMap) str, (String) view);
    }
}

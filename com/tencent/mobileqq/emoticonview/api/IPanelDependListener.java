package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

/* loaded from: classes12.dex */
public interface IPanelDependListener {
    void hidePopupWindow(Context context, EmoticonCallback emoticonCallback);

    void showPopupEmo(View view, EmoticonInfo emoticonInfo, Rect rect, Context context, EmoticonCallback emoticonCallback);
}

package com.tencent.av.utils.api.impl;

import android.content.Context;
import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.avcore.util.AVCoreUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class UIToolsTempApiImpl extends AVCoreUtil implements IUIToolsTempApi {
    private static final String TAG = "UIToolsApiImpl";

    @Override // com.tencent.av.utils.api.IUIToolsTempApi
    public float dp2px(Context context, float f16) {
        return (f16 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // com.tencent.av.utils.api.IUIToolsTempApi
    public int uinType2AVRelationType(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            if (i3 != 1011) {
                if (i3 != 3000) {
                    return 0;
                }
                return 2;
            }
            return 7;
        }
        return 3;
    }
}

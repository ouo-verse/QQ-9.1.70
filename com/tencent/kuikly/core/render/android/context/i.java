package com.tencent.kuikly.core.render.android.context;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"", "Lcom/tencent/kuikly/core/render/android/context/KRKValue;", "b", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class i {
    /* JADX INFO: Access modifiers changed from: private */
    public static final KRKValue b(Object obj) {
        int i3 = 0;
        if (obj != null) {
            if (obj instanceof Integer) {
                i3 = 1;
            } else if (obj instanceof Long) {
                i3 = 2;
            } else if (obj instanceof Float) {
                i3 = 3;
            } else if (obj instanceof Double) {
                i3 = 4;
            } else if (obj instanceof Boolean) {
                i3 = 5;
            } else if (obj instanceof String) {
                i3 = 6;
            }
        }
        if (i3 == 0) {
            return null;
        }
        KRKValue kRKValue = new KRKValue();
        kRKValue.setType(i3);
        kRKValue.setValue(obj);
        return kRKValue;
    }
}

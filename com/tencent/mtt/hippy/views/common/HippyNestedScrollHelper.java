package com.tencent.mtt.hippy.views.common;

import android.view.View;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyNestedScrollHelper {
    public static HippyNestedScrollComponent.Priority priorityOf(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -995424086:
                if (str.equals(HippyNestedScrollComponent.PRIORITY_PARENT)) {
                    c16 = 0;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3526476:
                if (str.equals("self")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return HippyNestedScrollComponent.Priority.PARENT;
            case 1:
                return HippyNestedScrollComponent.Priority.NONE;
            case 2:
                return HippyNestedScrollComponent.Priority.SELF;
            default:
                throw new RuntimeException("Invalid priority: " + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HippyNestedScrollComponent.Priority priorityOfX(View view, int i3) {
        int i16;
        if (i3 == 0) {
            return HippyNestedScrollComponent.Priority.NONE;
        }
        if (!(view instanceof HippyNestedScrollComponent.HippyNestedScrollTarget)) {
            return HippyNestedScrollComponent.Priority.SELF;
        }
        HippyNestedScrollComponent.HippyNestedScrollTarget hippyNestedScrollTarget = (HippyNestedScrollComponent.HippyNestedScrollTarget) view;
        if (i3 > 0) {
            i16 = 1;
        } else {
            i16 = 3;
        }
        return hippyNestedScrollTarget.getNestedScrollPriority(i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HippyNestedScrollComponent.Priority priorityOfY(View view, int i3) {
        int i16;
        if (i3 == 0) {
            return HippyNestedScrollComponent.Priority.NONE;
        }
        if (!(view instanceof HippyNestedScrollComponent.HippyNestedScrollTarget)) {
            return HippyNestedScrollComponent.Priority.SELF;
        }
        HippyNestedScrollComponent.HippyNestedScrollTarget hippyNestedScrollTarget = (HippyNestedScrollComponent.HippyNestedScrollTarget) view;
        if (i3 > 0) {
            i16 = 2;
        } else {
            i16 = 4;
        }
        return hippyNestedScrollTarget.getNestedScrollPriority(i16);
    }
}

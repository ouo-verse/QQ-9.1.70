package com.qzone.module.feedcomponent.util;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.area.DittoArea;

/* loaded from: classes39.dex */
public class PressStateUtils {
    private static final float ALPHA_AFTER_PRESS = 0.5f;
    private static final float ALPHA_BEFORE_PRESS = 1.0f;
    private static final String COLOR_AFTER_PRESS = "#CCCCCC";
    private static final String COLOR_AFTER_PRESS_SIMPLE = "#B0B3BF";

    public static void setAlphaAfterPress(View view) {
        if (view.isEnabled() && view.isClickable()) {
            view.setAlpha(0.5f);
        }
    }

    public static void setAlphaBeforePress(View view) {
        if (view.isEnabled() && view.isClickable()) {
            view.setAlpha(1.0f);
        }
    }

    public static void setColorAfterPress(DittoArea dittoArea) {
        if (dittoArea == null) {
            return;
        }
        if (SimpleModelUtils.isSimpleModeFeed()) {
            dittoArea.setBackgroundColor(Color.parseColor(COLOR_AFTER_PRESS_SIMPLE));
        } else {
            dittoArea.setBackgroundColor(Color.parseColor(COLOR_AFTER_PRESS));
        }
    }

    public static void setPressState(final View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.module.feedcomponent.util.PressStateUtils.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PressStateUtils.setAlphaAfterPress(view);
                    return false;
                }
                if (motionEvent.getAction() == 3) {
                    PressStateUtils.setAlphaBeforePress(view);
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                PressStateUtils.setAlphaBeforePress(view);
                return false;
            }
        });
    }

    public static void setColorBeforePress(DittoArea dittoArea) {
        if (dittoArea == null) {
            return;
        }
        dittoArea.setAlpha(1.0f);
    }
}

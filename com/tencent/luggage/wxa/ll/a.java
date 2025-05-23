package com.tencent.luggage.wxa.ll;

import android.view.MotionEvent;
import com.tencent.luggage.wxa.tn.w;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(String str, String str2, MotionEvent motionEvent) {
        if (w.d() >= 1) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append(TokenParser.SP);
        sb5.append("[apptouch] MotionEvent { action=");
        sb5.append(a(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            sb5.append(", x[");
            sb5.append(i3);
            sb5.append("]=");
            sb5.append(motionEvent.getX(i3));
            sb5.append(", y[");
            sb5.append(i3);
            sb5.append("]=");
            sb5.append(motionEvent.getY(i3));
        }
        sb5.append(", downTime=");
        sb5.append(motionEvent.getDownTime());
        sb5.append(" }");
        w.e(str, sb5.toString());
    }

    public static String a(MotionEvent motionEvent) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MotionEvent { action=");
        sb5.append(a(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            sb5.append(", x[");
            sb5.append(i3);
            sb5.append("]=");
            sb5.append(motionEvent.getX(i3));
            sb5.append(", y[");
            sb5.append(i3);
            sb5.append("]=");
            sb5.append(motionEvent.getY(i3));
        }
        sb5.append(", downTime=");
        sb5.append(motionEvent.getDownTime());
        sb5.append(" }");
        return sb5.toString();
    }

    public static String a(int i3) {
        switch (i3) {
            case 0:
                return "ACTION_DOWN";
            case 1:
                return "ACTION_UP";
            case 2:
                return "ACTION_MOVE";
            case 3:
                return "ACTION_CANCEL";
            case 4:
                return "ACTION_OUTSIDE";
            case 5:
            case 6:
            default:
                int i16 = (65280 & i3) >> 8;
                int i17 = i3 & 255;
                if (i17 == 5) {
                    return "ACTION_POINTER_DOWN(" + i16 + ")";
                }
                if (i17 != 6) {
                    return Integer.toString(i3);
                }
                return "ACTION_POINTER_UP(" + i16 + ")";
            case 7:
                return "ACTION_HOVER_MOVE";
            case 8:
                return "ACTION_SCROLL";
            case 9:
                return "ACTION_HOVER_ENTER";
            case 10:
                return "ACTION_HOVER_EXIT";
            case 11:
                return "ACTION_BUTTON_PRESS";
            case 12:
                return "ACTION_BUTTON_RELEASE";
        }
    }
}

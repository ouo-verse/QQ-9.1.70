package jx1;

import com.tencent.qqmini.minigame.action.OperateCustomButton;

/* compiled from: P */
/* loaded from: classes14.dex */
public final class b {
    public static String a(int i3) {
        if (i3 != 14) {
            if (i3 != 15) {
                switch (i3) {
                    case 0:
                        return OperateCustomButton.OPERATE_CREATE;
                    case 1:
                        return "function_start";
                    case 2:
                        return "function_show";
                    case 3:
                        return "function_dismiss";
                    case 4:
                        return "function_action";
                    case 5:
                        return "inline_observe";
                    case 6:
                        return "inline_start";
                    case 7:
                        return "inline_show";
                    case 8:
                        return "inline_dismiss";
                    case 9:
                        return "inline_action";
                    default:
                        return "no definition event";
                }
            }
            return "destroy";
        }
        return "stop";
    }
}

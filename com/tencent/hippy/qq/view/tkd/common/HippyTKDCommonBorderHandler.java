package com.tencent.hippy.qq.view.tkd.common;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDCommonBorderHandler {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface HippyQBCommonBorder {
        void setBackgroundColors(HippyArray hippyArray);

        void setBorderBottomColors(HippyArray hippyArray);

        void setBorderColors(HippyArray hippyArray);

        void setBorderLeftColors(HippyArray hippyArray);

        void setBorderRightColors(HippyArray hippyArray);

        void setBorderTopColors(HippyArray hippyArray);
    }

    public static void handleCommonBorderColor(HippyQBCommonBorder hippyQBCommonBorder, String str, Object obj) {
        HippyArray hippyArray = null;
        if (NodeProps.BACKGROUND_COLORS.equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBackgroundColors(hippyArray);
            return;
        }
        if ("borderColors".equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBorderColors(hippyArray);
            return;
        }
        if ("borderLeftColors".equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBorderLeftColors(hippyArray);
            return;
        }
        if ("borderRightColors".equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBorderRightColors(hippyArray);
        } else if ("borderTopColors".equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBorderTopColors(hippyArray);
        } else if ("borderBottomColors".equals(str)) {
            if (obj instanceof HippyArray) {
                hippyArray = (HippyArray) obj;
            }
            hippyQBCommonBorder.setBorderBottomColors(hippyArray);
        }
    }
}

package com.tencent.ditto.shell;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LayoutAttrDefine {

    @DittoJsonElement
    public static final String ALIGN_PARENT_BOTTOM = "alignParentBottom";

    @DittoJsonElement
    public static final String ALIGN_PARENT_LEFT = "alignParentLeft";

    @DittoJsonElement
    public static final String ALIGN_PARENT_RIGHT = "alignParentRight";

    @DittoJsonElement
    public static final String ALIGN_PARENT_TOP = "alignParentTop";

    @DittoJsonElement
    public static final String ALIGN_WITH_PARENT_IF_MISSING = "alignWithParentIfMissing";

    @DittoJsonElement(value = "\u80cc\u666f\u8272", valueStyles = {"#AARRGGBB", "#RRGGBB"})
    public static final String BG_Color = "bg_color";

    @DittoJsonElement("\u80cc\u666f\u6e10\u53d8\u8272\u65b9\u5411")
    public static final String BG_GRADIENT_DIRECTION = "bgGradientDir";

    @DittoJsonElement("\u80cc\u666f\u6e10\u53d8\u8272\u7ed3\u675f\u8272")
    public static final String BG_GRADIENT_END_COLOR = "bgGradientEndColor";

    @DittoJsonElement("\u80cc\u666f\u6e10\u53d8\u8272\u5f00\u59cb\u8272")
    public static final String BG_GRADIENT_START_COLOR = "bgGradientStartColor";

    @DittoJsonElement
    public static final String BorderColor = "border_color";

    @DittoJsonElement
    public static final String BorderRadii4 = "border_radii4";

    @DittoJsonElement
    public static final String BorderRadius = "border_radius";

    @DittoJsonElement
    public static final String BorderWidth = "border_width";

    @DittoJsonElement
    public static final String CENTER_HORIZONTAL = "centerHorizontal";

    @DittoJsonElement
    public static final String CENTER_IN_PARENT = "centerInParent";

    @DittoJsonElement
    public static final String CENTER_VERTICAL = "centerVertical";

    @DittoJsonElement("\u5982\u679c\u8d4b\u503c, \u70b9\u51fb\u540e\u4f1a\u89e6\u53d1handleUri\u65b9\u6cd5, \u8bbe\u7f6e\u6b64\u5c5e\u6027\u540e@CanvasOnClick\u56de\u8c03\u4f1a\u5931\u6548, \u5728\u540c\u65f6\u6709silent_uri\u548curi\u65f6, uri\u4f18\u5148\u7ea7\u66f4\u9ad8")
    public static final String CLICK_URI = "uri";

    @DittoJsonElement("\u9759\u9ed8wns\u8bf7\u6c42\u547d\u4ee4\u5b57")
    public static final String CMD = "cmd";

    @DittoJsonElement("\u9759\u9ed8wns\u8bf7\u6c42\u53c2\u6570buffer (\u53ea\u662f\u4e00\u4e2akey, \u4ececellUniverse.BgReqData\u53d6)")
    public static final String CMD_BUFFER = "cmd_buffer";

    @DittoJsonElement("\u9759\u9ed8wns\u8bf7\u6c42\u53c2\u6570buffer\u7684\u7c7b\u578b (\u7531JCE\u5b9a\u4e49\u7684\u90a3\u4e2a)")
    public static final String CMD_BUFFER_TYPE = "cmd_buffer_type";

    @DittoJsonElement
    public static final String COMPASS_CLICK_KEY = "compassClickKey";

    @DittoJsonElement
    public static final String COMPASS_EXPOSURE_KEY = "compassExposureKey";

    @DittoJsonElement(valueStyles = {"px", "dp", ParseCommon.LAYOUT_PARAMS_MATCH_PARENT, ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT})
    public static final String Height = "height";

    @DittoJsonElement("\u7ec4\u4ef6id")
    public static final String ID = "id";

    @DittoJsonElement("\u5ffd\u7565\u70b9\u51fb\u4e8b\u4ef6, \u4f18\u5148\u7ea7\u6700\u9ad8")
    public static final String IGNORE_CLICK = "ignore_click";

    @DittoJsonElement("\u89e6\u53d1\u5bf9\u5e94\u63a7\u4ef6id\u7684\u70b9\u51fb\u4e8b\u4ef6, \u672c\u63a7\u4ef6\u5b9a\u4e49\u7684\u70b9\u51fb\u76f8\u5173\u53c2\u6570\u968f\u5373\u5931\u6548")
    public static final String INVOKE_AREA_CLICK = "invoke_area_click";

    @DittoJsonElement
    public static final String MARGIN = "margin";

    @DittoJsonElement
    public static final String MARGIN_BOTTOM = "margin_bottom";

    @DittoJsonElement
    public static final String MARGIN_LEFT = "margin_left";

    @DittoJsonElement
    public static final String MARGIN_RIGHT = "margin_right";

    @DittoJsonElement
    public static final String MARGIN_TOP = "margin_top";
    public static final int MatchParent = -1;

    @DittoJsonElement
    public static final String PADDING = "padding";

    @DittoJsonElement
    public static final String PADDING_BOTTOM = "padding_bottom";

    @DittoJsonElement
    public static final String PADDING_LEFT = "padding_left";

    @DittoJsonElement
    public static final String PADDING_RIGHT = "padding_right";

    @DittoJsonElement
    public static final String PADDING_TOP = "padding_top";

    @DittoJsonElement("\u9759\u9ed8wns\u8bf7\u6c42\u8fd4\u56de\u7ed3\u679c\u5982\u679c\u662f\u4fee\u6539\u5b57\u6bb5, \u8fd9\u4e2a\u53c2\u6570\u6807\u8bc6\u4e86\u4fee\u6539\u5b57\u6bb5\u7684keyPath")
    public static final String POST_CLICK_KEY_PATH = "post_click_key_path";

    @DittoJsonElement("\u70b9\u51fb\u6001\u900f\u660e\u5ea6")
    public static final String PRESSED_ALPHA = "pressedAlpha";

    @DittoJsonElement
    public static final String SHRINK_COLUMNS = "shrinkColumns";

    @DittoJsonElement("\u5982\u679c\u8d4b\u503c, \u70b9\u51fb\u540e\u4f1a\u89e6\u53d1handleSilentUri\u65b9\u6cd5, \u8bbe\u7f6e\u6b64\u5c5e\u6027\u540e@CanvasOnClick\u56de\u8c03\u4f1a\u5931\u6548")
    public static final String SILENT_URI = "silent_uri";

    @DittoJsonElement("\u9759\u9ed8\u8bf7\u6c42\u5b8c\u6210\u540e\u7684\u6587\u6848 (813\u540e\u5e9f\u5f03)")
    public static final String SILENT_URI_SENT_TOAST = "silent_uri_sent_toast";

    @DittoJsonElement
    public static final String STRETCH_COLUMNS = "stretchColumns";

    @DittoJsonElement(value = "\u88c5\u9970\u533a\u8d44\u6e90id", valueStyles = {"@drawable/id"})
    public static final String ShadowResourceId = "shadow_id";

    @DittoJsonElement(value = "\u88c5\u9970\u533a\u5927\u5c0f, \u8d77\u70b9\u4ecepadding\u5185\u8fb9\u754c\u5f00\u59cb\u8ba1\u7b97", valueStyles = {"\u56db\u4e2a\u65b9\u5411\u5206\u522b\u6307\u5b9a(l, t, r, b): 1 px, 2 dp, 3 px, 4 px", "\u6240\u6709\u65b9\u5411\u4e00\u81f4: \"1px\""})
    public static final String ShadowSize = "shadow_size";

    @DittoJsonElement
    public static final String TTT_CLICK_REPORT_KEY = "ttt_report_area";

    @DittoJsonElement(valueStyles = {"gone - \u4e0d\u53ef\u89c1, \u4e0d\u53c2\u4e0e\u5e03\u5c40", NodeProps.VISIBLE, "invisible - \u4e0d\u53ef\u89c1, \u4f46\u662f\u6709\u5360\u4f4d"})
    public static final String VISIBILITY = "visibility";

    @DittoJsonElement("Linear Area Layout \u4e2d\u7a7a\u767d\u5360\u6bd4\u7684\u6743\u91cd")
    public static final String WEIGHT = "weight";

    @DittoJsonElement(valueStyles = {"px", "dp", ParseCommon.LAYOUT_PARAMS_MATCH_PARENT, ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT})
    public static final String Width = "width";
    public static final int WrapContent = -2;

    @DittoJsonElement
    public static final String ABOVE = "above";

    @DittoJsonElement
    public static final String BELOW = "below";

    @DittoJsonElement
    public static final String ALIGN_TOP = "alignTop";

    @DittoJsonElement
    public static final String ALIGN_BOTTOM = "alignBottom";
    public static final String[] RULES_VERTICAL = {ABOVE, BELOW, ALIGN_TOP, ALIGN_BOTTOM};

    @DittoJsonElement
    public static final String TO_LEFT_OF = "toLeftOf";

    @DittoJsonElement
    public static final String TO_RIGHT_OF = "toRightOf";

    @DittoJsonElement
    public static final String ALIGN_LEFT = "alignLeft";

    @DittoJsonElement
    public static final String ALIGN_RIGHT = "alignRight";
    public static final String[] RULES_HORIZONTAL = {TO_LEFT_OF, TO_RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT};

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Gravity {
        public static final int BOTTOM = 80;
        public static final int CENTER = 17;
        public static final int CENTER_HORIZONTAL = 1;
        public static final int CENTER_VERTICAL = 16;
        public static final String DEF_BOTTOM = "bottom";
        public static final String DEF_CENTER = "center";
        public static final String DEF_CENTER_HORIZONTAL = "center_horizontal";
        public static final String DEF_CENTER_VERTICAL = "center_vertical";
        public static final String DEF_LEFT = "left";
        public static final String DEF_RIGHT = "right";
        public static final String DEF_TOP = "top";
        public static final String Gravity = "gravity";
        public static final int LEFT = 3;
        public static final String Layout_Gravity = "layout_gravity";
        public static final int NONE = 0;
        public static final int RIGHT = 5;
        public static final int TOP = 48;

        public static int parse(String str) {
            if ("top".equals(str)) {
                return 48;
            }
            if ("bottom".equals(str)) {
                return 80;
            }
            if ("left".equals(str)) {
                return 3;
            }
            if ("right".equals(str)) {
                return 5;
            }
            if ("center_vertical".equals(str)) {
                return 16;
            }
            if ("center_horizontal".equals(str)) {
                return 1;
            }
            if (!"center".equals(str)) {
                return 3;
            }
            return 17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Orientation {
        public static final String DEF_Horizontal = "horizontal";
        public static final String DEF_Vertical = "vertical";
        public static final int Horizontal = 0;
        public static final String KEY = "orientation";
        public static final int Vertical = 1;

        public static int parse(String str) {
            if ("horizontal".equals(str)) {
                return 0;
            }
            return 1;
        }
    }
}

package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes20.dex */
public class NodeProps {
    public static final String ATTRIBUTES = "attributes";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BACKGROUND_COLORS = "backgroundColors";
    public static final String BACKGROUND_IMAGE = "backgroundImage";
    public static final String BACKGROUND_POSITION_X = "backgroundPositionX";
    public static final String BACKGROUND_POSITION_Y = "backgroundPositionY";
    public static final String BACKGROUND_RIPPLE = "nativeBackgroundAndroid";
    public static final String BACKGROUND_SIZE = "backgroundSize";
    public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
    public static final String BORDER_COLOR = "borderColor";
    public static final String BORDER_LEFT_COLOR = "borderLeftColor";
    public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_RIGHT_COLOR = "borderRightColor";
    public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
    public static final String BORDER_STYLES = "borderStyle";
    public static final String BORDER_TOP_COLOR = "borderTopColor";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String BORDER_TOP_WIDTH = "borderTopWidth";
    public static final String BORDER_WIDTH = "borderWidth";
    public static final String BOTTOM = "bottom";
    public static final String BREAK_STRATEGY = "breakStrategy";
    public static final String COLOR = "color";
    public static final String COLORS = "colors";
    public static final String CUSTOM_PROP = "customProp";
    public static final String CUSTOM_PROP_IMAGE_TYPE = "imageType";
    public static final String CUSTOM_PROP_ISGIF = "isGif";
    public static final String DIRECTION = "direction";
    public static final String DISPLAY = "display";
    public static final String ELLIPSIZE_MODE = "ellipsizeMode";
    public static final String ENABLED = "enabled";
    public static final String FLEX_BASIS = "flexBasis";
    public static final String FLEX_GROW = "flexGrow";
    public static final String FLEX_SHRINK = "flexShrink";
    public static final String FOCUSABLE = "focusable";
    public static final String FONT_FAMILY = "fontFamily";
    public static final String FONT_SIZE = "fontSize";
    public static final float FONT_SIZE_SP = 14.0f;
    public static final String FONT_STYLE = "fontStyle";
    public static final String FONT_WEIGHT = "fontWeight";
    public static final String GAUSSIAN_BLUR = "gaussianBlur";
    public static final String HEIGHT = "height";
    public static final String HIDDEN = "hidden";
    public static final String IMAGE_CLASS_NAME = "Image";
    public static final String LEFT = "left";
    public static final String LETTER_SPACING = "letterSpacing";
    public static final String LINEAR_GRADIENT = "linearGradient";
    public static final String LINE_HEIGHT = "lineHeight";
    public static final String LINE_SPACING_EXTRA = "lineSpacingExtra";
    public static final String LINE_SPACING_MULTIPLIER = "lineSpacingMultiplier";
    public static final String MARGIN = "margin";
    public static final String NEXT_FOCUS_DOWN_ID = "nextFocusDownId";
    public static final String NEXT_FOCUS_LEFT_ID = "nextFocusLeftId";
    public static final String NEXT_FOCUS_RIGHT_ID = "nextFocusRightId";
    public static final String NEXT_FOCUS_UP_ID = "nextFocusUpId";
    public static final String NUMBER_OF_LINES = "numberOfLines";
    public static final String ON = "on";
    public static final String ON_ATTACHED_TO_WINDOW = "onAttachedToWindow";
    public static final String ON_DETACHED_FROM_WINDOW = "onDetachedFromWindow";
    public static final String ON_INTERCEPT_PULL_UP_EVENT = "onInterceptPullUpEvent";
    public static final String ON_INTERCEPT_TOUCH_EVENT = "onInterceptTouchEvent";
    public static final String ON_TOUCH_CANCEL = "onTouchCancel";
    public static final String ON_TOUCH_END = "onTouchEnd";
    public static final String ON_TOUCH_MOVE = "onTouchMove";
    public static final String OPACITY = "opacity";
    public static final String OVERFLOW = "overflow";
    public static final String OVER_PULL = "bounces";
    public static final String PADDING = "padding";
    public static final String POSITION = "position";
    public static final String PROPS = "props";
    public static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
    public static final String REPEAT_COUNT = "repeatCount";
    public static final String REQUEST_FOCUS = "requestFocus";
    public static final String RESIZE_METHOD = "resizeMethod";
    public static final String RESIZE_MODE = "resizeMode";
    public static final String RIGHT = "right";
    public static final String ROOT_NODE = "RootNode";
    public static final String SHADOW_COLOR = "shadowColor";
    public static final String SHADOW_OFFSET = "shadowOffset";
    public static final String SHADOW_OFFSET_X = "shadowOffsetX";
    public static final String SHADOW_OFFSET_Y = "shadowOffsetY";
    public static final String SHADOW_OPACITY = "shadowOpacity";
    public static final String SHADOW_RADIUS = "shadowRadius";
    public static final String SHADOW_SPREAD = "shadowSpread";
    public static final String STYLE = "style";
    public static final String TEXT_ALIGN = "textAlign";
    public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
    public static final String TEXT_CLASS_NAME = "Text";
    public static final String TEXT_DECORATION_LINE = "textDecorationLine";
    public static final String TOP = "top";
    public static final String TRANSFORM = "transform";
    public static final String VIEW_CLASS_NAME = "View";
    public static final String VISIBLE = "visible";
    public static final String WIDTH = "width";
    public static final String Z_INDEX = "zIndex";
    public static final String ALIGN_SELF = "alignSelf";
    public static final String ALIGN_ITEMS = "alignItems";
    public static final String COLLAPSABLE = "collapsable";
    public static final String FLEX = "flex";
    public static final String FLEX_DIRECTION = "flexDirection";
    public static final String FLEX_WRAP = "flexWrap";
    public static final String JUSTIFY_CONTENT = "justifyContent";
    public static final String MIN_WIDTH = "minWidth";
    public static final String MAX_WIDTH = "maxWidth";
    public static final String MIN_HEIGHT = "minHeight";
    public static final String MAX_HEIGHT = "maxHeight";
    public static final String MARGIN_VERTICAL = "marginVertical";
    public static final String MARGIN_HORIZONTAL = "marginHorizontal";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_TOP = "marginTop";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String PADDING_VERTICAL = "paddingVertical";
    public static final String PADDING_HORIZONTAL = "paddingHorizontal";
    public static final String PADDING_LEFT = "paddingLeft";
    public static final String PADDING_RIGHT = "paddingRight";
    public static final String PADDING_TOP = "paddingTop";
    public static final String PADDING_BOTTOM = "paddingBottom";
    private static final HashSet<String> JUST_LAYOUT_PROPS = new HashSet<>(Arrays.asList(ALIGN_SELF, ALIGN_ITEMS, COLLAPSABLE, FLEX, FLEX_DIRECTION, FLEX_WRAP, JUSTIFY_CONTENT, "position", "right", "top", "bottom", "left", "width", "height", MIN_WIDTH, MAX_WIDTH, MIN_HEIGHT, MAX_HEIGHT, "margin", MARGIN_VERTICAL, MARGIN_HORIZONTAL, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM, "padding", PADDING_VERTICAL, PADDING_HORIZONTAL, PADDING_LEFT, PADDING_RIGHT, PADDING_TOP, PADDING_BOTTOM));
    public static final String ON_CLICK = "onClick";
    public static final String ON_LONG_CLICK = "onLongClick";
    public static final String ON_PRESS_IN = "onPressIn";
    public static final String ON_PRESS_OUT = "onPressOut";
    public static final String ON_TOUCH_DOWN = "onTouchDown";
    private static final HashSet<String> TOUCH_EVENT_PROPS = new HashSet<>(Arrays.asList(ON_CLICK, ON_LONG_CLICK, ON_PRESS_IN, ON_PRESS_OUT, "onTouchCancel", ON_TOUCH_DOWN, "onTouchEnd", "onTouchMove"));

    public static boolean isJustLayout(HippyMap hippyMap, String str) {
        if (JUST_LAYOUT_PROPS.contains(str)) {
            return true;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(BORDER_RIGHT_COLOR)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(BORDER_RIGHT_WIDTH)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(BORDER_TOP_COLOR)) {
                    c16 = 2;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(BORDER_TOP_WIDTH)) {
                    c16 = 3;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(BORDER_BOTTOM_COLOR)) {
                    c16 = 4;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(BORDER_BOTTOM_WIDTH)) {
                    c16 = 5;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c16 = 6;
                    break;
                }
                break;
            case -242276144:
                if (str.equals(BORDER_LEFT_COLOR)) {
                    c16 = 7;
                    break;
                }
                break;
            case -223992013:
                if (str.equals(BORDER_LEFT_WIDTH)) {
                    c16 = '\b';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 741115130:
                if (str.equals(BORDER_WIDTH)) {
                    c16 = '\n';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(BORDER_RADIUS)) {
                    c16 = 11;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (hippyMap.getInt(BORDER_RIGHT_COLOR) == 0) {
                    return true;
                }
                return false;
            case 1:
                if (hippyMap.isNull(BORDER_RIGHT_WIDTH) || hippyMap.getDouble(BORDER_RIGHT_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            case 2:
                if (hippyMap.getInt(BORDER_TOP_COLOR) == 0) {
                    return true;
                }
                return false;
            case 3:
                if (hippyMap.isNull(BORDER_TOP_WIDTH) || hippyMap.getDouble(BORDER_TOP_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            case 4:
                if (hippyMap.getInt(BORDER_BOTTOM_COLOR) == 0) {
                    return true;
                }
                return false;
            case 5:
                if (hippyMap.isNull(BORDER_BOTTOM_WIDTH) || hippyMap.getDouble(BORDER_BOTTOM_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            case 6:
                if (hippyMap.isNull("opacity") || hippyMap.getDouble("opacity") == 1.0d) {
                    return true;
                }
                return false;
            case 7:
                if (hippyMap.getInt(BORDER_LEFT_COLOR) == 0) {
                    return true;
                }
                return false;
            case '\b':
                if (hippyMap.isNull(BORDER_LEFT_WIDTH) || hippyMap.getDouble(BORDER_LEFT_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            case '\t':
                if (hippyMap.isNull("overflow") || VISIBLE.equals(hippyMap.getString("overflow"))) {
                    return true;
                }
                return false;
            case '\n':
                if (hippyMap.isNull(BORDER_WIDTH) || hippyMap.getDouble(BORDER_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            case 11:
                if (hippyMap.containsKey("backgroundColor") && hippyMap.getInt("backgroundColor") != 0) {
                    return false;
                }
                if (!hippyMap.containsKey(BORDER_WIDTH) || hippyMap.isNull(BORDER_WIDTH) || hippyMap.getDouble(BORDER_WIDTH) == 0.0d) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static boolean isTouchEventProp(String str) {
        return TOUCH_EVENT_PROPS.contains(str);
    }
}

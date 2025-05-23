package lk0;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexAlign;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexDirection;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexJustifyContent;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexPositionType;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexWrap;
import com.tencent.ecommerce.richtext.ui.dom.style.font.TextDecoration;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements Map<String, Object>, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final ConcurrentHashMap<String, Object> f414943d;

    public h() {
        this.f414943d = new ConcurrentHashMap<>();
    }

    public int A(int i3) {
        int b16 = (int) com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.LINE_HEIGHT), i3);
        if (b16 <= 0) {
            return -1;
        }
        return b16;
    }

    public int B(int i3) {
        int b16 = (int) com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("lineSpacing"), i3);
        if (b16 <= 0) {
            return -1;
        }
        return b16;
    }

    public int C() {
        return com.tencent.ecommerce.richtext.utils.e.m(get("lines"));
    }

    public float D(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("margin"), i3);
    }

    public float E(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MARGIN_BOTTOM), i3);
    }

    public float F(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MARGIN_LEFT), i3);
    }

    public float G(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MARGIN_RIGHT), i3);
    }

    public float H(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MARGIN_TOP), i3);
    }

    public float I(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MAX_HEIGHT), i3);
    }

    public float J(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MAX_WIDTH), i3);
    }

    public float K(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MIN_HEIGHT), i3);
    }

    public float L(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.MIN_WIDTH), i3);
    }

    public float M(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("padding"), i3);
    }

    public float N(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.PADDING_BOTTOM), i3);
    }

    public float O(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.PADDING_LEFT), i3);
    }

    public float P(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.PADDING_RIGHT), i3);
    }

    public float Q(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.PADDING_TOP), i3);
    }

    public FlexPositionType R() {
        Object obj = get("position");
        if (obj == null) {
            return FlexPositionType.RELATIVE;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.a(obj.toString().trim());
    }

    public float S(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("right"), i3);
    }

    public Layout.Alignment T() {
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        String str = (String) get("textAlign");
        if (TextUtils.equals("left", str)) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextUtils.equals("center", str)) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (TextUtils.equals("right", str)) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return alignment;
    }

    public String U() {
        Object obj = get("color");
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public TextDecoration V() {
        Object obj = get(TtmlNode.ATTR_TTS_TEXT_DECORATION);
        TextDecoration textDecoration = TextDecoration.NONE;
        if (obj == null) {
            return textDecoration;
        }
        String obj2 = obj.toString();
        obj2.hashCode();
        char c16 = '\uffff';
        switch (obj2.hashCode()) {
            case -1171789332:
                if (obj2.equals(PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (obj2.equals("underline")) {
                    c16 = 1;
                    break;
                }
                break;
            case 0:
                if (obj2.equals("")) {
                    c16 = 2;
                    break;
                }
                break;
            case 3387192:
                if (obj2.equals("none")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return TextDecoration.LINETHROUGH;
            case 1:
                return TextDecoration.UNDERLINE;
            case 2:
            case 3:
                return textDecoration;
            default:
                return TextDecoration.INVALID;
        }
    }

    public TextUtils.TruncateAt W() {
        if (TextUtils.equals("ellipsis", (String) get("textOverflow"))) {
            return TextUtils.TruncateAt.END;
        }
        return null;
    }

    public Paint.Align X() {
        Paint.Align align = Paint.Align.LEFT;
        String str = (String) get("textAlign");
        if (TextUtils.equals("left", str)) {
            return Paint.Align.LEFT;
        }
        if (TextUtils.equals("center", str)) {
            return Paint.Align.CENTER;
        }
        if (TextUtils.equals("right", str)) {
            return Paint.Align.RIGHT;
        }
        return align;
    }

    public float Y(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("top"), i3);
    }

    public float Z(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("width"), i3);
    }

    @Override // java.util.Map
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f414943d.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h clone() {
        h hVar = new h();
        hVar.f414943d.putAll(this.f414943d);
        return hVar;
    }

    @Override // java.util.Map
    public void clear() {
        this.f414943d.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f414943d.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f414943d.containsValue(obj);
    }

    public FlexAlign d() {
        Object obj = get(NodeProps.ALIGN_ITEMS);
        if (obj == null) {
            return FlexAlign.STRETCH;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.c(obj.toString().trim());
    }

    public FlexAlign e() {
        Object obj = get(NodeProps.ALIGN_SELF);
        if (obj == null) {
            return FlexAlign.STRETCH;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.d(obj.toString().trim());
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f414943d.entrySet();
    }

    public float f(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.BORDER_BOTTOM_WIDTH), i3);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f414943d.get(obj);
    }

    public float h(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.BORDER_LEFT_WIDTH), i3);
    }

    public float i(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.BORDER_RIGHT_WIDTH), i3);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f414943d.isEmpty();
    }

    public float j(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.BORDER_TOP_WIDTH), i3);
    }

    public float k(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.BORDER_WIDTH), i3);
    }

    @Override // java.util.Map
    @NonNull
    public Set<String> keySet() {
        return this.f414943d.keySet();
    }

    public float l(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("bottom"), i3);
    }

    public FlexWrap m() {
        Object obj = get(NodeProps.FLEX_WRAP);
        if (obj == null) {
            return FlexWrap.NOWRAP;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.g(obj.toString().trim());
    }

    public float n(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("defaultHeight"), i3);
    }

    public float o(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("defaultWidth"), i3);
    }

    public String p() {
        Object obj = get("ellipsisColor");
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends String, ? extends Object> map) {
        this.f414943d.putAll(map);
    }

    public float q() {
        return com.tencent.ecommerce.richtext.utils.e.j(get(NodeProps.FLEX));
    }

    public FlexDirection r() {
        Object obj = get(NodeProps.FLEX_DIRECTION);
        if (obj == null) {
            return FlexDirection.COLUMN;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.e(obj.toString().trim());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f414943d.remove(obj);
    }

    public String s() {
        Object obj = get("fontFamily");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return this.f414943d.size();
    }

    public int t(int i3) {
        float b16;
        Object obj = get("fontSize");
        if (obj == null) {
            b16 = com.tencent.ecommerce.richtext.ui.dom.style.g.b("12dp", i3);
        } else {
            b16 = com.tencent.ecommerce.richtext.ui.dom.style.g.b(obj, i3);
        }
        return (int) b16;
    }

    public int u() {
        Object obj = get("fontStyle");
        if (obj == null || !obj.toString().equals("italic")) {
            return 0;
        }
        return 2;
    }

    public int v() {
        Object obj = get("fontWeight");
        if (obj == null) {
            return 0;
        }
        String obj2 = obj.toString();
        obj2.hashCode();
        char c16 = '\uffff';
        switch (obj2.hashCode()) {
            case 53430:
                if (obj2.equals(IndividuationPlugin.Business_Theme)) {
                    c16 = 0;
                    break;
                }
                break;
            case 54391:
                if (obj2.equals(IndividuationPlugin.Business_Profilecard)) {
                    c16 = 1;
                    break;
                }
                break;
            case 55352:
                if (obj2.equals(IndividuationPlugin.Business_Suit)) {
                    c16 = 2;
                    break;
                }
                break;
            case 56313:
                if (obj2.equals("900")) {
                    c16 = 3;
                    break;
                }
                break;
            case 3029637:
                if (obj2.equals("bold")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Override // java.util.Map
    @NonNull
    public Collection<Object> values() {
        return this.f414943d.values();
    }

    public float w(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("height"), i3);
    }

    public FlexJustifyContent x() {
        Object obj = get(NodeProps.JUSTIFY_CONTENT);
        if (obj == null) {
            return FlexJustifyContent.FLEX_START;
        }
        return com.tencent.ecommerce.richtext.ui.dom.style.g.f(obj.toString().trim());
    }

    public float y(int i3) {
        return com.tencent.ecommerce.richtext.ui.dom.style.g.b(get("left"), i3);
    }

    public int z(int i3) {
        int b16 = (int) com.tencent.ecommerce.richtext.ui.dom.style.g.b(get(NodeProps.LETTER_SPACING), i3);
        if (b16 <= 0) {
            return -1;
        }
        return b16;
    }

    public h(JSONObject jSONObject) {
        this();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                put(str, jSONObject.get(str));
            } catch (JSONException unused) {
            }
        }
    }
}

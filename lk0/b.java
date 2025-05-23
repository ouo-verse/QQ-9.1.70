package lk0;

import android.graphics.LinearGradient;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexNode;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends FlexNode implements Cloneable {
    public static final Set<String> Z;
    private String L;
    protected lk0.a Q;
    public b R;
    private ArrayList<String> N = new ArrayList<>();
    private h P = new h();
    private boolean S = false;
    private int T = 750;
    private AtomicBoolean U = new AtomicBoolean();
    public boolean V = false;
    private Map<String, Object> W = new ArrayMap();
    private final Object X = new Object();
    private boolean Y = false;
    public List<b> M = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(b bVar);
    }

    static {
        HashSet hashSet = new HashSet();
        Z = hashSet;
        hashSet.add("defaultHeight");
        hashSet.add("defaultWidth");
        hashSet.add("width");
        hashSet.add(NodeProps.MIN_WIDTH);
        hashSet.add(NodeProps.MAX_WIDTH);
        hashSet.add("height");
        hashSet.add(NodeProps.MIN_HEIGHT);
        hashSet.add(NodeProps.MAX_HEIGHT);
        hashSet.add(NodeProps.ALIGN_ITEMS);
        hashSet.add(NodeProps.ALIGN_SELF);
        hashSet.add(NodeProps.FLEX);
        hashSet.add(NodeProps.FLEX_DIRECTION);
        hashSet.add(NodeProps.JUSTIFY_CONTENT);
        hashSet.add(NodeProps.FLEX_WRAP);
        hashSet.add("margin");
        hashSet.add(NodeProps.MARGIN_TOP);
        hashSet.add(NodeProps.MARGIN_LEFT);
        hashSet.add(NodeProps.MARGIN_RIGHT);
        hashSet.add(NodeProps.MARGIN_BOTTOM);
        hashSet.add("padding");
        hashSet.add(NodeProps.PADDING_TOP);
        hashSet.add(NodeProps.PADDING_LEFT);
        hashSet.add(NodeProps.PADDING_RIGHT);
        hashSet.add(NodeProps.PADDING_BOTTOM);
        hashSet.add("left");
        hashSet.add("top");
        hashSet.add("right");
        hashSet.add("bottom");
        hashSet.add(NodeProps.BORDER_WIDTH);
        hashSet.add(NodeProps.BORDER_TOP_WIDTH);
        hashSet.add(NodeProps.BORDER_RIGHT_WIDTH);
        hashSet.add(NodeProps.BORDER_BOTTOM_WIDTH);
        hashSet.add(NodeProps.BORDER_LEFT_WIDTH);
        hashSet.add("position");
        hashSet.add(TtmlNode.ATTR_TTS_TEXT_DECORATION);
        hashSet.add("textAlign");
        hashSet.add("fontWeight");
        hashSet.add("fontStyle");
        hashSet.add("fontSize");
        hashSet.add("color");
        hashSet.add("lines");
        hashSet.add("fontFamily");
        hashSet.add("textOverflow");
        hashSet.add("ellipsis");
        hashSet.add(NodeProps.LINE_HEIGHT);
        hashSet.add("value");
        hashSet.add("values");
    }

    @Nullable
    public static b o0(JSONObject jSONObject, fk0.c cVar, b bVar) {
        Object obj;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (!jSONObject.has("type")) {
                return null;
            }
            String str = (String) jSONObject.get("type");
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("type", "div");
            }
            b a16 = c.a(str);
            if (a16 == null) {
                return null;
            }
            a16.t0(750);
            a16.q0(jSONObject);
            a16.R = bVar;
            if (jSONObject.has(Node.CHILDREN_ATTR) && (obj = jSONObject.get(Node.CHILDREN_ATTR)) != null && (obj instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    a16.U(o0(jSONArray.getJSONObject(i3), cVar, a16), -1);
                }
            }
            return a16;
        } catch (JSONException unused) {
            return null;
        }
    }

    private void p0(Object obj) {
        LinearGradient u16 = com.tencent.ecommerce.richtext.utils.c.u(obj, this);
        if (u16 != null) {
            this.P.put("background_image_parse", u16);
        }
    }

    private void s0(b bVar) {
        List<b> list;
        int indexOf;
        if (bVar == null || (list = this.M) == null || (indexOf = list.indexOf(bVar)) == -1) {
            return;
        }
        this.M.remove(indexOf).R = null;
    }

    public static boolean u0(Map<String, Object> map) {
        if (map.size() == 0) {
            return false;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (Z.contains(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    public void U(b bVar, int i3) {
        if (bVar != null && i3 >= -1) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            if (i3 >= this.M.size()) {
                i3 = -1;
            }
            if (i3 == -1) {
                this.M.add(bVar);
                super.a(bVar, super.h());
            } else {
                this.M.add(i3, bVar);
                super.a(bVar, i3);
            }
            bVar.R = this;
        }
    }

    public void V() {
        x0(g0());
    }

    public int W() {
        return this.M.size();
    }

    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b clone() {
        b bVar = null;
        if (this.U.get()) {
            return null;
        }
        if (k0()) {
            return this;
        }
        try {
            bVar = c.a(this.L);
            Y(bVar);
            return bVar;
        } catch (Exception unused) {
            return bVar;
        }
    }

    protected final void Y(b bVar) {
        h clone;
        bVar.f105336e.a(this.f105336e);
        bVar.F = this.F;
        bVar.L = this.L;
        h hVar = this.P;
        lk0.a aVar = null;
        if (hVar == null) {
            clone = null;
        } else {
            clone = hVar.clone();
        }
        bVar.P = clone;
        lk0.a aVar2 = this.Q;
        if (aVar2 != null) {
            aVar = aVar2.clone();
        }
        bVar.Q = aVar;
        bVar.f105335d.a(this.f105335d);
    }

    public lk0.a Z() {
        if (this.Q == null) {
            this.Q = new lk0.a();
        }
        return this.Q;
    }

    public b a0(int i3) {
        synchronized (this.X) {
            List<b> list = this.M;
            if (list != null && list.size() > i3) {
                return this.M.get(i3);
            }
            return null;
        }
    }

    public int b0() {
        List<b> list = this.M;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public b c0() {
        return this.R;
    }

    public ArrayList<String> d0() {
        return this.N;
    }

    public Object e0() {
        return null;
    }

    public String f0() {
        return this.F;
    }

    public h g0() {
        if (this.P == null) {
            this.P = new h();
        }
        return this.P;
    }

    public String h0() {
        return this.L;
    }

    public int i0() {
        return this.T;
    }

    public final boolean j0() {
        if (!o() && !p()) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        return this.Y;
    }

    public void l0() {
        if (this.P.containsKey("backgroundImage")) {
            p0(this.P.get("backgroundImage"));
        }
    }

    public final void n0() {
        if (o()) {
            t();
        }
    }

    public void q0(JSONObject jSONObject) {
        Object obj;
        Object obj2;
        Object obj3;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("type")) {
                this.L = String.valueOf(jSONObject.get("type"));
            }
            if (jSONObject.has("ref")) {
                this.F = String.valueOf(jSONObject.get("ref"));
            }
            if (jSONObject.has("style") && (obj3 = jSONObject.get("style")) != null && (obj3 instanceof JSONObject)) {
                h hVar = this.P;
                if (hVar != null) {
                    hVar.putAll(new h((JSONObject) obj3));
                } else {
                    this.P = new h((JSONObject) obj3);
                }
            }
            if (jSONObject.has("attr") && (obj2 = jSONObject.get("attr")) != null && (obj2 instanceof JSONObject)) {
                this.Q = new lk0.a((JSONObject) obj2);
            }
            if (jSONObject.has(LinkReportConstant$GlobalKey.EVENTS) && (obj = jSONObject.get(LinkReportConstant$GlobalKey.EVENTS)) != null && (obj instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    this.N.add(jSONArray.get(i3).toString());
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            Log.e("DomObject", e16.getMessage());
        }
    }

    public int r0(b bVar) {
        synchronized (this.X) {
            if (bVar != null) {
                List<b> list = this.M;
                if (list != null) {
                    int indexOf = list.indexOf(bVar);
                    s0(bVar);
                    if (indexOf != -1) {
                        super.v(indexOf);
                    }
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public void t0(int i3) {
        this.T = i3;
    }

    @Override // com.tencent.ecommerce.richtext.ui.dom.style.FlexNode
    public String toString() {
        return this.L + ", " + this.M.size();
    }

    public int v0(a... aVarArr) {
        System.nanoTime();
        if (aVarArr == null) {
            return 0;
        }
        for (a aVar : aVarArr) {
            aVar.a(this);
        }
        int h16 = h();
        int i3 = 0;
        for (int i16 = 0; i16 < h16; i16++) {
            b a06 = a0(i16);
            if (a06 == null) {
                return i3;
            }
            int v06 = a06.v0(aVarArr);
            if (i3 <= v06) {
                i3 = v06;
            }
        }
        return i3 + 1;
    }

    public void w0(Map<String, Object> map) {
        if (this.P == null) {
            this.P = new h();
        }
        this.P.putAll(map);
        if (u0(map)) {
            super.c();
        }
        x0(map);
    }

    public synchronized void x0(Map<String, Object> map) {
        char c16;
        float n3;
        float o16;
        if (map.size() == 0) {
            return;
        }
        h g06 = g0();
        int i06 = i0();
        if (!g06.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                switch (key.hashCode()) {
                    case -1971292586:
                        if (key.equals(NodeProps.BORDER_RIGHT_WIDTH)) {
                            c16 = 26;
                            break;
                        }
                        break;
                    case -1501175880:
                        if (key.equals(NodeProps.PADDING_LEFT)) {
                            c16 = 30;
                            break;
                        }
                        break;
                    case -1452542531:
                        if (key.equals(NodeProps.BORDER_TOP_WIDTH)) {
                            c16 = 25;
                            break;
                        }
                        break;
                    case -1383228885:
                        if (key.equals("bottom")) {
                            c16 = 18;
                            break;
                        }
                        break;
                    case -1375815020:
                        if (key.equals(NodeProps.MIN_WIDTH)) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case -1290574193:
                        if (key.equals(NodeProps.BORDER_BOTTOM_WIDTH)) {
                            c16 = 27;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (key.equals("height")) {
                            c16 = 11;
                            break;
                        }
                        break;
                    case -1081309778:
                        if (key.equals("margin")) {
                            c16 = 19;
                            break;
                        }
                        break;
                    case -1063257157:
                        if (key.equals(NodeProps.ALIGN_ITEMS)) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1044792121:
                        if (key.equals(NodeProps.MARGIN_TOP)) {
                            c16 = 21;
                            break;
                        }
                        break;
                    case -975171706:
                        if (key.equals(NodeProps.FLEX_DIRECTION)) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case -906066005:
                        if (key.equals(NodeProps.MAX_HEIGHT)) {
                            c16 = '\t';
                            break;
                        }
                        break;
                    case -806339567:
                        if (key.equals("padding")) {
                            c16 = 29;
                            break;
                        }
                        break;
                    case -657971195:
                        if (key.equals("defaultWidth")) {
                            c16 = '\r';
                            break;
                        }
                        break;
                    case -289173127:
                        if (key.equals(NodeProps.MARGIN_BOTTOM)) {
                            c16 = 23;
                            break;
                        }
                        break;
                    case -223992013:
                        if (key.equals(NodeProps.BORDER_LEFT_WIDTH)) {
                            c16 = 28;
                            break;
                        }
                        break;
                    case -133587431:
                        if (key.equals(NodeProps.MIN_HEIGHT)) {
                            c16 = 7;
                            break;
                        }
                        break;
                    case 115029:
                        if (key.equals("top")) {
                            c16 = 16;
                            break;
                        }
                        break;
                    case 3145721:
                        if (key.equals(NodeProps.FLEX)) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 3317767:
                        if (key.equals("left")) {
                            c16 = 15;
                            break;
                        }
                        break;
                    case 90130308:
                        if (key.equals(NodeProps.PADDING_TOP)) {
                            c16 = 31;
                            break;
                        }
                        break;
                    case 108511772:
                        if (key.equals("right")) {
                            c16 = 17;
                            break;
                        }
                        break;
                    case 113126854:
                        if (key.equals("width")) {
                            c16 = '\f';
                            break;
                        }
                        break;
                    case 202355100:
                        if (key.equals(NodeProps.PADDING_BOTTOM)) {
                            c16 = '!';
                            break;
                        }
                        break;
                    case 400381634:
                        if (key.equals(NodeProps.MAX_WIDTH)) {
                            c16 = '\b';
                            break;
                        }
                        break;
                    case 644734664:
                        if (key.equals("defaultHeight")) {
                            c16 = '\n';
                            break;
                        }
                        break;
                    case 713848971:
                        if (key.equals(NodeProps.PADDING_RIGHT)) {
                            c16 = TokenParser.SP;
                            break;
                        }
                        break;
                    case 741115130:
                        if (key.equals(NodeProps.BORDER_WIDTH)) {
                            c16 = 24;
                            break;
                        }
                        break;
                    case 747804969:
                        if (key.equals("position")) {
                            c16 = 14;
                            break;
                        }
                        break;
                    case 975087886:
                        if (key.equals(NodeProps.MARGIN_RIGHT)) {
                            c16 = 22;
                            break;
                        }
                        break;
                    case 1292595405:
                        if (key.equals("backgroundImage")) {
                            c16 = '\"';
                            break;
                        }
                        break;
                    case 1744216035:
                        if (key.equals(NodeProps.FLEX_WRAP)) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 1767100401:
                        if (key.equals(NodeProps.ALIGN_SELF)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 1860657097:
                        if (key.equals(NodeProps.JUSTIFY_CONTENT)) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 1970934485:
                        if (key.equals(NodeProps.MARGIN_LEFT)) {
                            c16 = 20;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        w(g06.d());
                        break;
                    case 1:
                        x(g06.e());
                        break;
                    case 2:
                        z(g06.q());
                        break;
                    case 3:
                        A(g06.r());
                        break;
                    case 4:
                        B(g06.x());
                        break;
                    case 5:
                        Q(g06.m());
                        break;
                    case 6:
                        H(g06.L(i06));
                        break;
                    case 7:
                        G(g06.K(i06));
                        break;
                    case '\b':
                        E(g06.J(i06));
                        break;
                    case '\t':
                        D(g06.I(i06));
                        break;
                    case '\n':
                    case 11:
                        if (g06.containsKey("height")) {
                            n3 = g06.w(i06);
                        } else {
                            n3 = g06.n(i06);
                        }
                        O(n3);
                        break;
                    case '\f':
                    case '\r':
                        if (g06.containsKey("width")) {
                            o16 = g06.Z(i06);
                        } else {
                            o16 = g06.o(i06);
                        }
                        P(o16);
                        break;
                    case 14:
                        N(g06.R());
                        break;
                    case 15:
                        K(g06.y(i06));
                        break;
                    case 16:
                        M(g06.Y(i06));
                        break;
                    case 17:
                        L(g06.S(i06));
                        break;
                    case 18:
                        J(g06.l(i06));
                        break;
                    case 19:
                        C(8, g06.D(i06));
                        break;
                    case 20:
                        C(0, g06.F(i06));
                        break;
                    case 21:
                        C(1, g06.H(i06));
                        break;
                    case 22:
                        C(2, g06.G(i06));
                        break;
                    case 23:
                        C(3, g06.E(i06));
                        break;
                    case 24:
                        y(8, g06.k(i06));
                        break;
                    case 25:
                        y(1, g06.j(i06));
                        break;
                    case 26:
                        y(2, g06.i(i06));
                        break;
                    case 27:
                        y(3, g06.f(i06));
                        break;
                    case 28:
                        y(0, g06.h(i06));
                        break;
                    case 29:
                        I(8, g06.M(i06));
                        break;
                    case 30:
                        I(0, g06.O(i06));
                        break;
                    case 31:
                        I(1, g06.Q(i06));
                        break;
                    case ' ':
                        I(2, g06.P(i06));
                        break;
                    case '!':
                        I(3, g06.N(i06));
                        break;
                    case '\"':
                        p0(entry.getValue());
                        break;
                }
            }
        }
    }

    public void y0() {
        this.V = true;
    }

    public void m0() {
    }
}

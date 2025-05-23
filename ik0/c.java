package ik0;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexNode;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.ecommerce.richtext.ui.view.VTextView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Map;
import lk0.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c<T extends View> {

    /* renamed from: a, reason: collision with root package name */
    public T f407890a;

    /* renamed from: b, reason: collision with root package name */
    protected fk0.c f407891b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f407892c;

    /* renamed from: d, reason: collision with root package name */
    public volatile lk0.b f407893d;

    /* renamed from: e, reason: collision with root package name */
    public d f407894e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.ecommerce.richtext.ui.dom.style.b f407895f;

    /* renamed from: g, reason: collision with root package name */
    private int f407896g;

    /* renamed from: h, reason: collision with root package name */
    private int f407897h;

    /* renamed from: i, reason: collision with root package name */
    private int f407898i;

    /* renamed from: j, reason: collision with root package name */
    private int f407899j;

    public c(fk0.c cVar, lk0.b bVar, d dVar) {
        this(cVar, bVar, dVar, 0);
    }

    private void F(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            o().o(i3, str);
        }
    }

    private void J(Object obj) {
        if (obj instanceof LinearGradient) {
            o().r((Shader) obj);
        }
    }

    private void L(float f16) {
        K(f16);
    }

    private void s() {
        d dVar;
        if (this.f407892c == null && (dVar = this.f407894e) != null) {
            this.f407892c = dVar.l();
        }
        Context context = this.f407892c;
        if (context != null) {
            T q16 = q(context);
            this.f407890a = q16;
            if (q16 == null && !v()) {
                r();
            }
            T t16 = this.f407890a;
            if (t16 != null) {
                t16.setId(e.a());
            }
        }
    }

    public void A(float f16) {
        E(3, f16);
    }

    public void B(float f16) {
        E(1, f16);
    }

    public void C(float f16) {
        E(2, f16);
    }

    public void D(int i3, String str) {
        int g16;
        if (!TextUtils.isEmpty(str) && (g16 = com.tencent.ecommerce.richtext.utils.e.g(str)) != 0) {
            o().m(i3, g16);
        }
    }

    public void E(int i3, float f16) {
        o().n(i3, f16);
    }

    public void G(int i3, float f16) {
        o().p(i3, f16);
    }

    protected void H() {
        if (n() != null && u()) {
            float[] f16 = o().f();
            if (f16[0] != 0.0f) {
                n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[0], k(), 0));
                n().setClipToOutline(true);
                return;
            }
            float f17 = f16[1];
            if (f17 != 0.0f && f17 == f16[2] && f17 != f16[4]) {
                n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[1], k(), 1));
                n().setClipToOutline(true);
                return;
            }
            float f18 = f16[3];
            if (f18 != 0.0f && f18 == f16[4] && f18 != f17) {
                n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[3], k(), 2));
                n().setClipToOutline(true);
            }
        }
    }

    public void I(T t16, int i3, int i16, int i17, int i18, int i19, int i26) {
        ViewGroup.LayoutParams layoutParams;
        int i27 = i16;
        T t17 = this.f407890a;
        if (t17 == null) {
            return;
        }
        d dVar = this.f407894e;
        if (dVar == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i16);
            layoutParams2.setMargins(i17, i19, i18, i26);
            layoutParams = layoutParams2;
        } else {
            if ((t17 instanceof VTextView) && ((VTextView) t17).f105428h) {
                i27 += 5;
            }
            layoutParams = dVar.X(this, t16, i3, i27, i17, i18, i19, i26);
        }
        if (layoutParams != null) {
            this.f407890a.setLayoutParams(layoutParams);
        }
    }

    public void K(float f16) {
        if (f16 >= 0.0f && f16 <= 1.0f && n() != null && n().getAlpha() != f16) {
            this.f407890a.setAlpha(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean M(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(NodeProps.BORDER_RIGHT_COLOR)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals("borderRightStyle")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(NodeProps.BORDER_RIGHT_WIDTH)) {
                    c16 = 2;
                    break;
                }
                break;
            case -1629228116:
                if (str.equals("clipChild")) {
                    c16 = 3;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(NodeProps.BORDER_TOP_COLOR)) {
                    c16 = 4;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals("borderTopStyle")) {
                    c16 = 5;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(NodeProps.BORDER_TOP_WIDTH)) {
                    c16 = 6;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(NodeProps.BORDER_BOTTOM_COLOR)) {
                    c16 = 7;
                    break;
                }
                break;
            case -1293920646:
                if (str.equals("borderBottomStyle")) {
                    c16 = '\b';
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(NodeProps.BORDER_BOTTOM_WIDTH)) {
                    c16 = '\t';
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c16 = '\n';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(NodeProps.BORDER_TOP_LEFT_RADIUS)) {
                    c16 = 11;
                    break;
                }
                break;
            case -242276144:
                if (str.equals(NodeProps.BORDER_LEFT_COLOR)) {
                    c16 = '\f';
                    break;
                }
                break;
            case -227338466:
                if (str.equals("borderLeftStyle")) {
                    c16 = '\r';
                    break;
                }
                break;
            case -223992013:
                if (str.equals(NodeProps.BORDER_LEFT_WIDTH)) {
                    c16 = 14;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(BasicAnimation.KeyPath.ROTATION)) {
                    c16 = 15;
                    break;
                }
                break;
            case 333432965:
                if (str.equals(NodeProps.BORDER_TOP_RIGHT_RADIUS)) {
                    c16 = 16;
                    break;
                }
                break;
            case 581268560:
                if (str.equals(NodeProps.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c16 = 17;
                    break;
                }
                break;
            case 588239831:
                if (str.equals(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c16 = 18;
                    break;
                }
                break;
            case 722830999:
                if (str.equals(NodeProps.BORDER_COLOR)) {
                    c16 = 19;
                    break;
                }
                break;
            case 737768677:
                if (str.equals(NodeProps.BORDER_STYLES)) {
                    c16 = 20;
                    break;
                }
                break;
            case 741115130:
                if (str.equals(NodeProps.BORDER_WIDTH)) {
                    c16 = 21;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c16 = 22;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(NodeProps.BORDER_RADIUS)) {
                    c16 = 23;
                    break;
                }
                break;
            case 1511773502:
                if (str.equals("background_image_parse")) {
                    c16 = 24;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c16 = 25;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                String p16 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p16 != null) {
                    D(3, p16);
                }
                return true;
            case 1:
                String p17 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p17 != null) {
                    F(3, p17);
                }
                return true;
            case 2:
                G(3, g.b(obj, m().i0()));
                return true;
            case 3:
                H();
                return true;
            case 4:
                String p18 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p18 != null) {
                    D(2, p18);
                }
                return true;
            case 5:
                String p19 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p19 != null) {
                    F(2, p19);
                }
                return true;
            case 6:
                G(2, g.b(obj, m().i0()));
                return true;
            case 7:
                String p26 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p26 != null) {
                    D(4, p26);
                }
                return true;
            case '\b':
                String p27 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p27 != null) {
                    F(4, p27);
                }
                return true;
            case '\t':
                G(4, g.b(obj, m().i0()));
                return true;
            case '\n':
                Float valueOf = Float.valueOf(com.tencent.ecommerce.richtext.utils.e.k(obj, Float.valueOf(-1.0f)));
                if (valueOf != null && !valueOf.equals(Float.valueOf(-1.0f))) {
                    L(valueOf.floatValue());
                }
                return true;
            case 11:
                String p28 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p28 != null) {
                    B(g.j(p28, m().i0()));
                }
                return true;
            case '\f':
                String p29 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p29 != null) {
                    D(1, p29);
                }
                return true;
            case '\r':
                String p36 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p36 != null) {
                    F(1, p36);
                }
                return true;
            case 14:
                G(1, g.b(obj, m().i0()));
                return true;
            case 15:
                n().setRotation(com.tencent.ecommerce.richtext.utils.e.k(obj, Float.valueOf(90.0f)));
                return true;
            case 16:
                String p37 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p37 != null) {
                    C(g.j(p37, m().i0()));
                }
                return true;
            case 17:
                String p38 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p38 != null) {
                    z(g.j(p38, m().i0()));
                }
                return true;
            case 18:
                String p39 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p39 != null) {
                    A(g.j(p39, m().i0()));
                }
                return true;
            case 19:
                String p46 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p46 != null) {
                    D(0, p46);
                }
                return true;
            case 20:
                String p47 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p47 != null) {
                    F(0, p47);
                }
                return true;
            case 21:
                G(0, g.j(obj, m().i0()));
                return true;
            case 22:
                String p48 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p48 != null) {
                    x(p48);
                }
                return true;
            case 23:
                String p49 = com.tencent.ecommerce.richtext.utils.e.p(obj, null);
                if (p49 != null) {
                    E(0, g.j(p49, m().i0()));
                }
                return true;
            case 24:
                J(obj);
                return true;
            case 25:
                if (n() != null) {
                    if (NodeProps.VISIBLE.equals(com.tencent.ecommerce.richtext.utils.e.p(obj, NodeProps.VISIBLE))) {
                        n().setVisibility(0);
                    } else {
                        n().setVisibility(4);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public void N(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                M(entry.getKey(), entry.getValue());
            }
        }
    }

    public void P(Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                M(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b() {
        c();
    }

    public void c() {
        if (t()) {
            return;
        }
        lk0.b bVar = this.f407893d;
        synchronized (FlexNode.K) {
            int k3 = (int) bVar.k();
            int G = (int) bVar.g0().G(750);
            int l3 = (int) bVar.l();
            int E = (int) bVar.g0().E(750);
            int j3 = (int) bVar.j();
            int i3 = (int) bVar.i();
            if (this.f407896g == j3 && this.f407897h == i3 && this.f407898i == k3 && this.f407899j == l3) {
                return;
            }
            this.f407896g = j3;
            this.f407897h = i3;
            this.f407898i = k3;
            this.f407899j = l3;
            I(this.f407890a, j3, i3, k3, G, l3, E);
        }
    }

    public void d() {
        e();
    }

    public void e() {
        if (!t()) {
            P(this.f407893d.g0());
            N(this.f407893d.Z());
            O(this.f407893d.e0());
            y();
            f();
        }
    }

    protected void f() {
        if (n() != null) {
            n().setOutlineProvider(null);
            n().setClipToOutline(false);
            if (m().Z() != null && m().Z().containsKey("clipChild") && u()) {
                float[] f16 = o().f();
                if (f16[0] != 0.0f) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[0], k(), 0));
                    n().setClipToOutline(true);
                    return;
                }
                float f17 = f16[1];
                if (f17 != 0.0f && f17 == f16[2] && f17 != f16[4]) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[1], k(), 1));
                    n().setClipToOutline(true);
                    return;
                }
                float f18 = f16[3];
                if (f18 != 0.0f && f18 == f16[4] && f18 != f17) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[3], k(), 2));
                    n().setClipToOutline(true);
                }
            }
        }
    }

    public final void g() {
        if (!t()) {
            i();
        }
    }

    public final void h(Context context) {
        if (!t()) {
            j(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Context context) {
        this.f407892c = context;
        s();
    }

    public int k() {
        return (int) this.f407893d.i();
    }

    public Context l() {
        return this.f407892c;
    }

    public lk0.b m() {
        return this.f407893d;
    }

    public T n() {
        return this.f407890a;
    }

    public com.tencent.ecommerce.richtext.ui.dom.style.b o() {
        if (this.f407895f == null) {
            this.f407895f = new com.tencent.ecommerce.richtext.ui.dom.style.b();
        }
        return this.f407895f;
    }

    public View p() {
        return this.f407890a;
    }

    protected T q(@NonNull Context context) {
        return null;
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        if (m() == null || m().g0() == null) {
            return false;
        }
        if (!m().g0().containsKey(NodeProps.BORDER_RADIUS) && !m().g0().containsKey(NodeProps.BORDER_TOP_LEFT_RADIUS) && !m().g0().containsKey(NodeProps.BORDER_TOP_RIGHT_RADIUS) && !m().g0().containsKey(NodeProps.BORDER_BOTTOM_LEFT_RADIUS) && !m().g0().containsKey(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public boolean w() {
        if (this.f407893d != null && this.f407893d.Z().containsKey("disableTouchPenetrate") && com.tencent.ecommerce.richtext.utils.e.f(this.f407893d.Z().get("disableTouchPenetrate"))) {
            return true;
        }
        return false;
    }

    public void x(String str) {
        if (!TextUtils.isEmpty(str)) {
            int g16 = com.tencent.ecommerce.richtext.utils.e.g(str);
            if (g16 != 0 || this.f407895f != null) {
                o().q(g16);
            }
            if (g16 == 0 && p() != null && this.f407893d != null) {
                this.f407893d.d0();
            }
        }
    }

    public void y() {
        if (n() != null) {
            com.tencent.ecommerce.richtext.ui.dom.style.b bVar = this.f407895f;
            if (bVar != null) {
                bVar.invalidateSelf();
            }
            n().setBackground(this.f407895f);
            if (m().Z() != null && m().Z().containsKey("clipChild") && u()) {
                float[] f16 = o().f();
                if (f16[0] != 0.0f) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[0], k(), 0));
                    n().setClipToOutline(true);
                    return;
                }
                float f17 = f16[1];
                if (f17 != 0.0f && f17 == f16[2] && f17 != f16[4]) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[1], k(), 1));
                    n().setClipToOutline(true);
                    return;
                }
                float f18 = f16[3];
                if (f18 != 0.0f && f18 == f16[4] && f18 != f17) {
                    n().setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(f16[3], k(), 2));
                    n().setClipToOutline(true);
                }
            }
        }
    }

    public void z(float f16) {
        E(4, f16);
    }

    public c(fk0.c cVar, lk0.b bVar, d dVar, int i3) {
        this.f407896g = 0;
        this.f407897h = 0;
        this.f407898i = 0;
        this.f407899j = 0;
        this.f407891b = cVar;
        this.f407893d = bVar;
        this.f407894e = dVar;
        this.f407892c = cVar.b();
    }

    public void r() {
    }

    public void O(Object obj) {
    }
}

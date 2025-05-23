package bp3;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.aj;
import com.tencent.ntcompose.material.al;
import com.tencent.ntcompose.material.ao;
import com.tencent.ntcompose.material.n;
import com.tencent.ntcompose.material.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zo3.Shadow;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u00b2\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u000b\u0010\u001cR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\"\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u00101\u001a\u0004\u0018\u00010,8\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00102\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b!\u0010\u000eR\u0019\u00104\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b'\u0010\u000eR\u0019\u00108\u001a\u0004\u0018\u0001058\u0006\u00a2\u0006\f\n\u0004\b/\u00106\u001a\u0004\b3\u00107R\u0019\u00109\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b-\u0010\u000eR\u0019\u0010;\u001a\u0004\u0018\u00010:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006A"}, d2 = {"Lbp3/k;", "", "other", "", "equals", "Lcom/tencent/kuikly/core/base/h;", "a", "Lcom/tencent/kuikly/core/base/h;", "()Lcom/tencent/kuikly/core/base/h;", "color", "", "b", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "fontSize", "Lbp3/c;", "Lbp3/c;", "e", "()Lbp3/c;", "fontWeight", "Lcom/tencent/ntcompose/material/o;", "d", "Lcom/tencent/ntcompose/material/o;", "()Lcom/tencent/ntcompose/material/o;", "fontStyle", "Lcom/tencent/ntcompose/material/n;", "Lcom/tencent/ntcompose/material/n;", "()Lcom/tencent/ntcompose/material/n;", "fontFamily", "f", NodeProps.LETTER_SPACING, "Lcom/tencent/ntcompose/material/aj;", "g", "Lcom/tencent/ntcompose/material/aj;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/ntcompose/material/aj;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Lzo3/f;", tl.h.F, "Lzo3/f;", "j", "()Lzo3/f;", "shadow", "Lcom/tencent/ntcompose/material/ai;", "i", "Lcom/tencent/ntcompose/material/ai;", "l", "()Lcom/tencent/ntcompose/material/ai;", "textAlign", NodeProps.LINE_HEIGHT, "k", "lineSpacing", "Lcom/tencent/ntcompose/material/ao;", "Lcom/tencent/ntcompose/material/ao;", "()Lcom/tencent/ntcompose/material/ao;", "stroke", "paragraphSpacing", "Lcom/tencent/ntcompose/material/al;", "textIndent", "Lcom/tencent/ntcompose/material/al;", DomainData.DOMAIN_NAME, "()Lcom/tencent/ntcompose/material/al;", "<init>", "(Lcom/tencent/kuikly/core/base/h;Ljava/lang/Float;Lbp3/c;Lcom/tencent/ntcompose/material/o;Lcom/tencent/ntcompose/material/n;Ljava/lang/Float;Lcom/tencent/ntcompose/material/aj;Lzo3/f;Lcom/tencent/ntcompose/material/ai;Ljava/lang/Float;Lcom/tencent/ntcompose/material/al;Ljava/lang/Float;Lcom/tencent/ntcompose/material/ao;Ljava/lang/Float;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class k {

    /* renamed from: n, reason: collision with root package name */
    public static final int f28903n = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h color;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Float fontSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c fontWeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final o fontStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final n fontFamily;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Float letterSpacing;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final aj textDecoration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Shadow shadow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ai textAlign;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Float lineHeight;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Float lineSpacing;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final ao stroke;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Float paragraphSpacing;

    public /* synthetic */ k(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, f16, cVar, oVar, nVar, f17, ajVar, shadow, aiVar, f18, alVar, f19, aoVar, f26);
    }

    /* renamed from: a, reason: from getter */
    public final com.tencent.kuikly.core.base.h getColor() {
        return this.color;
    }

    /* renamed from: b, reason: from getter */
    public final n getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: c, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: d, reason: from getter */
    public final o getFontStyle() {
        return this.fontStyle;
    }

    /* renamed from: e, reason: from getter */
    public final c getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: f, reason: from getter */
    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    /* renamed from: g, reason: from getter */
    public final Float getLineHeight() {
        return this.lineHeight;
    }

    /* renamed from: h, reason: from getter */
    public final Float getLineSpacing() {
        return this.lineSpacing;
    }

    /* renamed from: i, reason: from getter */
    public final Float getParagraphSpacing() {
        return this.paragraphSpacing;
    }

    /* renamed from: j, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    /* renamed from: k, reason: from getter */
    public final ao getStroke() {
        return this.stroke;
    }

    /* renamed from: l, reason: from getter */
    public final ai getTextAlign() {
        return this.textAlign;
    }

    /* renamed from: m, reason: from getter */
    public final aj getTextDecoration() {
        return this.textDecoration;
    }

    public final al n() {
        return null;
    }

    k(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26) {
        this.color = hVar;
        this.fontSize = f16;
        this.fontWeight = cVar;
        this.fontStyle = oVar;
        this.fontFamily = nVar;
        this.letterSpacing = f17;
        this.textDecoration = ajVar;
        this.shadow = shadow;
        this.textAlign = aiVar;
        this.lineHeight = f18;
        this.lineSpacing = f19;
        this.stroke = aoVar;
        this.paragraphSpacing = f26;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (!Intrinsics.areEqual(this.color, kVar.color) || !Intrinsics.areEqual(this.fontSize, kVar.fontSize) || !Intrinsics.areEqual(this.fontWeight, kVar.fontWeight) || !Intrinsics.areEqual(this.fontStyle, kVar.fontStyle) || !Intrinsics.areEqual(this.fontFamily, kVar.fontFamily) || !Intrinsics.areEqual(this.letterSpacing, kVar.letterSpacing) || !Intrinsics.areEqual(this.textDecoration, kVar.textDecoration) || !Intrinsics.areEqual(this.shadow, kVar.shadow) || !Intrinsics.areEqual(this.textAlign, kVar.textAlign) || !Intrinsics.areEqual(this.lineHeight, kVar.lineHeight)) {
            return false;
        }
        kVar.getClass();
        return Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.lineSpacing, kVar.lineSpacing) && Intrinsics.areEqual(this.stroke, kVar.stroke) && Intrinsics.areEqual(this.paragraphSpacing, kVar.paragraphSpacing);
    }

    public /* synthetic */ k(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : hVar, (i3 & 2) != 0 ? null : f16, (i3 & 4) != 0 ? null : cVar, (i3 & 8) != 0 ? null : oVar, (i3 & 16) != 0 ? null : nVar, (i3 & 32) != 0 ? null : f17, (i3 & 64) != 0 ? null : ajVar, (i3 & 128) != 0 ? null : shadow, (i3 & 256) != 0 ? null : aiVar, (i3 & 512) != 0 ? null : f18, (i3 & 1024) != 0 ? null : alVar, (i3 & 2048) != 0 ? null : f19, (i3 & 4096) != 0 ? null : aoVar, (i3 & 8192) == 0 ? f26 : null, null);
    }
}

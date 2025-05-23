package bp3;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.aj;
import com.tencent.ntcompose.material.al;
import com.tencent.ntcompose.material.ao;
import com.tencent.ntcompose.material.n;
import com.tencent.ntcompose.material.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import zo3.Shadow;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u00d9\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0012\u0012%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R4\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lbp3/j;", "Lbp3/k;", "", "other", "", "equals", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "Lkotlin/ParameterName;", "name", "e", "", "o", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", NodeProps.ON_CLICK, "Lcom/tencent/kuikly/core/base/h;", "color", "", "fontSize", "Lbp3/c;", "fontWeight", "Lcom/tencent/ntcompose/material/o;", "fontStyle", "Lcom/tencent/ntcompose/material/n;", "fontFamily", NodeProps.LETTER_SPACING, "Lcom/tencent/ntcompose/material/aj;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Lzo3/f;", "shadow", "Lcom/tencent/ntcompose/material/ai;", "textAlign", NodeProps.LINE_HEIGHT, "Lcom/tencent/ntcompose/material/al;", "textIndent", "lineSpacing", "Lcom/tencent/ntcompose/material/ao;", "stroke", "paragraphSpacing", "<init>", "(Lcom/tencent/kuikly/core/base/h;Ljava/lang/Float;Lbp3/c;Lcom/tencent/ntcompose/material/o;Lcom/tencent/ntcompose/material/n;Ljava/lang/Float;Lcom/tencent/ntcompose/material/aj;Lzo3/f;Lcom/tencent/ntcompose/material/ai;Ljava/lang/Float;Lcom/tencent/ntcompose/material/al;Ljava/lang/Float;Lcom/tencent/ntcompose/material/ao;Ljava/lang/Float;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class j extends k {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Function1<ClickParams, Unit> onClick;

    public /* synthetic */ j(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, f16, cVar, oVar, nVar, f17, ajVar, shadow, aiVar, f18, alVar, f19, aoVar, f26, function1);
    }

    public final Function1<ClickParams, Unit> o() {
        return this.onClick;
    }

    public /* synthetic */ j(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : hVar, (i3 & 2) != 0 ? null : f16, (i3 & 4) != 0 ? null : cVar, (i3 & 8) != 0 ? null : oVar, (i3 & 16) != 0 ? null : nVar, (i3 & 32) != 0 ? null : f17, (i3 & 64) != 0 ? null : ajVar, (i3 & 128) != 0 ? null : shadow, (i3 & 256) != 0 ? null : aiVar, (i3 & 512) != 0 ? null : f18, (i3 & 1024) != 0 ? null : alVar, (i3 & 2048) != 0 ? null : f19, (i3 & 4096) != 0 ? null : aoVar, (i3 & 8192) != 0 ? null : f26, (i3 & 16384) == 0 ? function1 : null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    j(com.tencent.kuikly.core.base.h hVar, Float f16, c cVar, o oVar, n nVar, Float f17, aj ajVar, Shadow shadow, ai aiVar, Float f18, al alVar, Float f19, ao aoVar, Float f26, Function1<? super ClickParams, Unit> function1) {
        super(hVar, f16, cVar, oVar, nVar, f17, ajVar, shadow, aiVar, f18, alVar, f19, aoVar, f26, null);
        this.onClick = function1;
    }

    @Override // bp3.k
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        Function1<ClickParams, Unit> function1 = this.onClick;
        if ((function1 == null || ((j) other).onClick != null) && (function1 != null || ((j) other).onClick == null)) {
            return super.equals(other);
        }
        return false;
    }
}

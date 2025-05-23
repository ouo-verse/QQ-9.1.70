package com.tencent.android.androidbypass.codeblock.utils;

import android.graphics.Paint;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010 \u001a\u0004\b\u0015\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b\u001b\u0010!\"\u0004\b%\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/utils/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "f", "()Landroid/graphics/Paint;", "paint", "", "b", UserInfo.SEX_FEMALE, "()F", NodeProps.MAX_WIDTH, "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "c", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "()Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "highlightConfig", "", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", "nodeList", "I", "()I", "g", "(I)V", "nodeIndex", h.F, "nodeInternalIndex", "<init>", "(Landroid/graphics/Paint;FLcom/tencent/android/androidbypass/codeblock/config/highlight/a;Ljava/util/List;II)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float maxWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.codeblock.config.highlight.a highlightConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<CodeNode> nodeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int nodeIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int nodeInternalIndex;

    public a(@NotNull Paint paint, float f16, @NotNull com.tencent.android.androidbypass.codeblock.config.highlight.a highlightConfig, @NotNull List<CodeNode> nodeList, int i3, int i16) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(highlightConfig, "highlightConfig");
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, paint, Float.valueOf(f16), highlightConfig, nodeList, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.paint = paint;
        this.maxWidth = f16;
        this.highlightConfig = highlightConfig;
        this.nodeList = nodeList;
        this.nodeIndex = i3;
        this.nodeInternalIndex = i16;
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.config.highlight.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.codeblock.config.highlight.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.highlightConfig;
    }

    public final float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.maxWidth;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.nodeIndex;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.nodeInternalIndex;
    }

    @NotNull
    public final List<CodeNode> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nodeList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.paint, aVar.paint) || Float.compare(this.maxWidth, aVar.maxWidth) != 0 || !Intrinsics.areEqual(this.highlightConfig, aVar.highlightConfig) || !Intrinsics.areEqual(this.nodeList, aVar.nodeList) || this.nodeIndex != aVar.nodeIndex || this.nodeInternalIndex != aVar.nodeInternalIndex) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Paint f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Paint) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.paint;
    }

    public final void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.nodeIndex = i3;
        }
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.nodeInternalIndex = i3;
        }
    }

    public int hashCode() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        Paint paint = this.paint;
        int i17 = 0;
        if (paint != null) {
            i3 = paint.hashCode();
        } else {
            i3 = 0;
        }
        int floatToIntBits = ((i3 * 31) + Float.floatToIntBits(this.maxWidth)) * 31;
        com.tencent.android.androidbypass.codeblock.config.highlight.a aVar = this.highlightConfig;
        if (aVar != null) {
            i16 = aVar.hashCode();
        } else {
            i16 = 0;
        }
        int i18 = (floatToIntBits + i16) * 31;
        List<CodeNode> list = this.nodeList;
        if (list != null) {
            i17 = list.hashCode();
        }
        return ((((i18 + i17) * 31) + this.nodeIndex) * 31) + this.nodeInternalIndex;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "BuildBreakTextArgs(paint=" + this.paint + ", maxWidth=" + this.maxWidth + ", highlightConfig=" + this.highlightConfig + ", nodeList=" + this.nodeList + ", nodeIndex=" + this.nodeIndex + ", nodeInternalIndex=" + this.nodeInternalIndex + ")";
    }
}

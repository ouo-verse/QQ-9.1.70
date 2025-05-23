package com.tencent.ntcompose.foundation.layout;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/a;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f339244a = new a();

    a() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.DivView");
        t tVar = (t) ((v) b16).getViewAttr();
        switch (propKey.hashCode()) {
            case -2064085737:
                if (propKey.equals("al_mainAxisAlign")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.MainAxisAlign");
                    MainAxisAlign mainAxisAlign = (MainAxisAlign) propArg0;
                    if (mainAxisAlign.ordinal() == MainAxisAlign.CENTER.ordinal()) {
                        tVar.justifyContentCenter();
                        return;
                    }
                    if (mainAxisAlign.ordinal() == MainAxisAlign.START.ordinal()) {
                        tVar.justifyContentFlexStart();
                        return;
                    }
                    if (mainAxisAlign.ordinal() == MainAxisAlign.END.ordinal()) {
                        tVar.justifyContentFlexEnd();
                        return;
                    }
                    if (mainAxisAlign.ordinal() == MainAxisAlign.SPACE_AROUND.ordinal()) {
                        tVar.justifyContentSpaceAround();
                        return;
                    } else if (mainAxisAlign.ordinal() == MainAxisAlign.SPACE_BETWEEN.ordinal()) {
                        tVar.justifyContentSpaceBetween();
                        return;
                    } else {
                        if (mainAxisAlign.ordinal() == MainAxisAlign.SPACE_EVENLY.ordinal()) {
                            tVar.justifyContentSpaceEvenly();
                            return;
                        }
                        return;
                    }
                }
                return;
            case -1415254207:
                if (propKey.equals("al_top")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.m150top(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -923455589:
                if (propKey.equals("al_left")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.m142left(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1340773567:
                if (propKey.equals("al_bottom")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.m138bottom(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1435275068:
                if (propKey.equals("al_isRow")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue = ((Boolean) propArg0).booleanValue();
                    tVar.positionAbsolute();
                    if (booleanValue) {
                        tVar.flexDirectionRow();
                        return;
                    } else {
                        tVar.flexDirectionColumn();
                        return;
                    }
                }
                return;
            case 1443308808:
                if (propKey.equals("al_right")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.m149right(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1447923890:
                if (propKey.equals("al_width")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.mo153width(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1502972859:
                if (propKey.equals("al_height")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    tVar.mo141height(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1754354200:
                if (propKey.equals("al_crossAxisAlign")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.CrossAxisAlign");
                    CrossAxisAlign crossAxisAlign = (CrossAxisAlign) propArg0;
                    if (crossAxisAlign.ordinal() == CrossAxisAlign.CENTER.ordinal()) {
                        tVar.alignItemsCenter();
                        return;
                    }
                    if (crossAxisAlign.ordinal() == CrossAxisAlign.STRETCH.ordinal()) {
                        tVar.alignItemsStretch();
                        return;
                    } else if (crossAxisAlign.ordinal() == CrossAxisAlign.START.ordinal()) {
                        tVar.alignItemsFlexStart();
                        return;
                    } else {
                        if (crossAxisAlign.ordinal() == CrossAxisAlign.END.ordinal()) {
                            tVar.alignItemsFlexEnd();
                            return;
                        }
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}

package com.tencent.ntcompose.foundation.layout;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u001a\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a&\u0010\f\u001a\u00020\u0000*\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0001j\u0002`\t2\f\b\u0002\u0010\u000b\u001a\u00060\u0001j\u0002`\t\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0001\u001a4\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u0007\u001a\u0012\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001\u001a2\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u0014\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0001\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0001\u001a\u0014\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0001\u001a\n\u0010\u001a\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u001b\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u001c\u001a\u00020\u0000*\u00020\u0000\u001a \u0010\u001e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u001a \u0010\u001f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007\u001a\f\u0010!\u001a\u00020 *\u00020\u0000H\u0007\u001a\f\u0010\"\u001a\u00020 *\u00020\u0000H\u0007\u001a\f\u0010#\u001a\u00020\u0000*\u00020\u0000H\u0001\u00a8\u0006$"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "", "width", "w", "height", "k", "size", "u", "v", "Lcom/tencent/ntcompose/ui/unit/Dp;", Element.ELEMENT_NAME_MIN, "max", HippyTKDListViewAdapter.X, "all", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "start", "top", "end", "bottom", "r", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fraction", "i", "e", "g", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "o", "a", "", "d", "c", "t", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeLayoutPropUpdaterKt {
    public static final com.tencent.ntcompose.core.i A(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "wrap_content_size", null, null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i B(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "wrap_content_width", null, null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i a(com.tencent.ntcompose.core.i iVar, float f16, float f17) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return o(iVar, f16, f17);
    }

    public static final boolean c(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        iVar.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt$containHeightModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit) {
                invoke2(cVar, unit);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                if (mod instanceof com.tencent.ntcompose.core.k) {
                    String g16 = ((com.tencent.ntcompose.core.k) mod).g();
                    switch (g16.hashCode()) {
                        case -2092291620:
                            if (!g16.equals("wrap_content_size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -1221029593:
                            if (!g16.equals("height")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -966668222:
                            if (!g16.equals("wrap_content_height")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -874270562:
                            if (!g16.equals("fill_max_height")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -115006108:
                            if (!g16.equals("aspect_ratio")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 3530753:
                            if (!g16.equals("size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 759198008:
                            if (!g16.equals("fill_max_size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        return booleanRef.element;
    }

    public static final boolean d(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        iVar.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt$containWidthModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit) {
                invoke2(cVar, unit);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                if (mod instanceof com.tencent.ntcompose.core.k) {
                    String g16 = ((com.tencent.ntcompose.core.k) mod).g();
                    switch (g16.hashCode()) {
                        case -2092291620:
                            if (!g16.equals("wrap_content_size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -432857269:
                            if (!g16.equals("wrap_content_width")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case -115006108:
                            if (!g16.equals("aspect_ratio")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 3530753:
                            if (!g16.equals("size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 113126854:
                            if (!g16.equals("width")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 759198008:
                            if (!g16.equals("fill_max_size")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        case 2063975279:
                            if (!g16.equals("fill_max_width")) {
                                return;
                            }
                            Ref.BooleanRef.this.element = true;
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        return booleanRef.element;
    }

    public static final com.tencent.ntcompose.core.i e(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "fill_max_height", Float.valueOf(f16), null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i g(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "fill_max_size", Float.valueOf(f16), null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i i(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "fill_max_width", Float.valueOf(f16), null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i k(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "height", Float.valueOf(f16), null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i l(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return m(iVar, f16, f16, f16, f16);
    }

    public static final com.tencent.ntcompose.core.i m(com.tencent.ntcompose.core.i iVar, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "margin", Float.valueOf(f17), Float.valueOf(f16), Float.valueOf(f19), Float.valueOf(f18), null, f.f339284a, 32, null);
    }

    public static final com.tencent.ntcompose.core.i o(com.tencent.ntcompose.core.i iVar, float f16, float f17) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "offset", Float.valueOf(f16), Float.valueOf(f17), null, null, null, f.f339284a, 56, null);
    }

    public static final com.tencent.ntcompose.core.i q(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return r(iVar, f16, f16, f16, f16);
    }

    public static final com.tencent.ntcompose.core.i r(com.tencent.ntcompose.core.i iVar, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "padding", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), null, f.f339284a, 32, null);
    }

    public static final com.tencent.ntcompose.core.i t(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        com.tencent.ntcompose.core.i B = !d(iVar) ? B(iVar) : iVar;
        return !c(iVar) ? z(B) : B;
    }

    public static final com.tencent.ntcompose.core.i u(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return v(iVar, f16, f16);
    }

    public static final com.tencent.ntcompose.core.i v(com.tencent.ntcompose.core.i iVar, float f16, float f17) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "size", Float.valueOf(f16), Float.valueOf(f17), null, null, null, f.f339284a, 56, null);
    }

    public static final com.tencent.ntcompose.core.i w(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "width", Float.valueOf(f16), null, null, null, null, f.f339284a, 60, null);
    }

    public static final com.tencent.ntcompose.core.i x(com.tencent.ntcompose.core.i iVar, float f16, float f17) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "widthIn", Float.valueOf(f16), Float.valueOf(f17), null, null, null, f.f339284a, 56, null);
    }

    public static final com.tencent.ntcompose.core.i z(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "wrap_content_height", null, null, null, null, null, f.f339284a, 60, null);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i f(com.tencent.ntcompose.core.i iVar, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        return e(iVar, f16);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i h(com.tencent.ntcompose.core.i iVar, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        return g(iVar, f16);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i j(com.tencent.ntcompose.core.i iVar, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        return i(iVar, f16);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i y(com.tencent.ntcompose.core.i iVar, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            f16 = Float.NaN;
        }
        if ((i3 & 2) != 0) {
            FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
            f17 = Float.NaN;
        }
        return x(iVar, f16, f17);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i b(com.tencent.ntcompose.core.i iVar, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        return a(iVar, f16, f17);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i p(com.tencent.ntcompose.core.i iVar, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        return o(iVar, f16, f17);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i n(com.tencent.ntcompose.core.i iVar, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f19 = 0.0f;
        }
        return m(iVar, f16, f17, f18, f19);
    }

    public static /* synthetic */ com.tencent.ntcompose.core.i s(com.tencent.ntcompose.core.i iVar, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f19 = 0.0f;
        }
        return r(iVar, f16, f17, f18, f19);
    }
}

package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.quibadge.QUIRichBadge;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.aa;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "w", HippyTKDListViewAdapter.X, "u", "v", "Landroid/widget/ImageView;", "view", "", "url", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "drawableId", "B", "D", "E", "leftConfig", "rightConfig", "setConfig", DownloadInfo.spKey_Config, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/widget/listitem/aa$a;", "I", "Lcom/tencent/mobileqq/widget/listitem/aa$a;", "touchExplorationRegistry", "J", "Lcom/tencent/mobileqq/widget/listitem/x;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QUISingleLineListItem extends QUIListItem<x<x.b, x.c>> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private aa.a touchExplorationRegistry;

    /* renamed from: J, reason: from kotlin metadata */
    private x<x.b, x.c> config;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(ImageView view, String url) {
        x<x.b, x.c> xVar = this.config;
        Unit unit = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        Function2<ImageView, String, Unit> L = xVar.L();
        if (L != null) {
            L.invoke(view, url);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CapabilityInjector.f316927a.d(view, url);
        }
    }

    private final void B(ImageView view, int drawableId) {
        x<x.b, x.c> xVar = this.config;
        Unit unit = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        Function2<ImageView, Integer, Unit> M = xVar.M();
        if (M != null) {
            M.invoke(view, Integer.valueOf(drawableId));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CapabilityInjector.f316927a.e(view, drawableId);
        }
    }

    private final void C(ImageView view, String url) {
        x<x.b, x.c> xVar = this.config;
        Unit unit = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        Function2<ImageView, String, Unit> N = xVar.N();
        if (N != null) {
            N.invoke(view, url);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CapabilityInjector.f316927a.f(view, url);
        }
    }

    private final void D() {
        if (this.config == null || !isAttachedToWindow()) {
            return;
        }
        E();
        x<x.b, x.c> xVar = this.config;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        x.c O = xVar.O();
        if (!(O instanceof x.c.f)) {
            return;
        }
        aa aaVar = aa.f316999a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.touchExplorationRegistry = aaVar.c(context, new QUISingleLineListItem$registerAccessibilityTouchExplorationStateChange$2(this, O));
    }

    private final void E() {
        aa.a aVar = this.touchExplorationRegistry;
        if (aVar != null) {
            aVar.a();
        }
        this.touchExplorationRegistry = null;
    }

    private final void u() {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        int i17;
        int i18;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i19;
        int i26;
        int i27;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i28;
        int i29;
        int i36;
        x<x.b, x.c> xVar = this.config;
        ViewGroup.MarginLayoutParams marginLayoutParams4 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        x.b K = xVar.K();
        int i37 = -2;
        if (K instanceof x.b.a) {
            ImageView g16 = l().g();
            int dp12 = getDp12();
            ViewGroup.LayoutParams layoutParams = g16.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams3 = null;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams2 = g16.getLayoutParams();
                if (layoutParams2 != null) {
                    i29 = layoutParams2.width;
                } else {
                    i29 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = g16.getLayoutParams();
                if (layoutParams3 != null) {
                    i36 = layoutParams3.height;
                } else {
                    i36 = -2;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i29, i36);
            }
            if (dp12 != marginLayoutParams3.leftMargin) {
                marginLayoutParams3.leftMargin = dp12;
                g16.setLayoutParams(marginLayoutParams3);
            }
            TextView m3 = l().m();
            int dp122 = getDp12();
            ViewGroup.LayoutParams layoutParams4 = m3.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams5 = m3.getLayoutParams();
                if (layoutParams5 != null) {
                    i28 = layoutParams5.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = m3.getLayoutParams();
                if (layoutParams6 != null) {
                    i37 = layoutParams6.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i28, i37);
            }
            if (dp122 != marginLayoutParams4.leftMargin) {
                marginLayoutParams4.leftMargin = dp122;
                m3.setLayoutParams(marginLayoutParams4);
            }
            a(l().m(), 0);
            a(l().g(), 0);
            return;
        }
        if (K instanceof x.b.C8996b) {
            ImageView i38 = l().i();
            int dp123 = getDp12();
            ViewGroup.LayoutParams layoutParams7 = i38.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams7;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams8 = i38.getLayoutParams();
                if (layoutParams8 != null) {
                    i26 = layoutParams8.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = i38.getLayoutParams();
                if (layoutParams9 != null) {
                    i27 = layoutParams9.height;
                } else {
                    i27 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i26, i27);
            }
            if (dp123 != marginLayoutParams2.leftMargin) {
                marginLayoutParams2.leftMargin = dp123;
                i38.setLayoutParams(marginLayoutParams2);
            }
            TextView m16 = l().m();
            int dp124 = getDp12();
            ViewGroup.LayoutParams layoutParams10 = m16.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams10;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams11 = m16.getLayoutParams();
                if (layoutParams11 != null) {
                    i19 = layoutParams11.width;
                } else {
                    i19 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = m16.getLayoutParams();
                if (layoutParams12 != null) {
                    i37 = layoutParams12.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i19, i37);
            }
            if (dp124 != marginLayoutParams4.leftMargin) {
                marginLayoutParams4.leftMargin = dp124;
                m16.setLayoutParams(marginLayoutParams4);
            }
            a(l().m(), 0);
            a(l().i(), 0);
            return;
        }
        if (K instanceof x.b.c) {
            ImageView j3 = l().j();
            int dp125 = getDp12();
            ViewGroup.LayoutParams layoutParams13 = j3.getLayoutParams();
            if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams13;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams14 = j3.getLayoutParams();
                if (layoutParams14 != null) {
                    i17 = layoutParams14.width;
                } else {
                    i17 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = j3.getLayoutParams();
                if (layoutParams15 != null) {
                    i18 = layoutParams15.height;
                } else {
                    i18 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i18);
            }
            if (dp125 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dp125;
                j3.setLayoutParams(marginLayoutParams);
            }
            TextView m17 = l().m();
            int dp126 = getDp12();
            ViewGroup.LayoutParams layoutParams16 = m17.getLayoutParams();
            if (layoutParams16 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams16;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams17 = m17.getLayoutParams();
                if (layoutParams17 != null) {
                    i16 = layoutParams17.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = m17.getLayoutParams();
                if (layoutParams18 != null) {
                    i37 = layoutParams18.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i16, i37);
            }
            if (dp126 != marginLayoutParams4.leftMargin) {
                marginLayoutParams4.leftMargin = dp126;
                m17.setLayoutParams(marginLayoutParams4);
            }
            a(l().m(), 0);
            a(l().j(), 0);
            return;
        }
        if (K instanceof x.b.d) {
            TextView m18 = l().m();
            int dp127 = getDp12();
            ViewGroup.LayoutParams layoutParams19 = m18.getLayoutParams();
            if (layoutParams19 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams19;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams20 = m18.getLayoutParams();
                if (layoutParams20 != null) {
                    i3 = layoutParams20.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams21 = m18.getLayoutParams();
                if (layoutParams21 != null) {
                    i37 = layoutParams21.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i3, i37);
            }
            if (dp127 != marginLayoutParams4.leftMargin) {
                marginLayoutParams4.leftMargin = dp127;
                m18.setLayoutParams(marginLayoutParams4);
            }
            a(l().m(), 0);
        }
    }

    private final void v() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i3;
        int i16;
        int i17;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        int i18;
        int i19;
        int i26;
        ViewGroup.MarginLayoutParams marginLayoutParams5;
        ViewGroup.MarginLayoutParams marginLayoutParams6;
        ViewGroup.MarginLayoutParams marginLayoutParams7;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        ViewGroup.MarginLayoutParams marginLayoutParams8;
        int i38;
        ViewGroup.MarginLayoutParams marginLayoutParams9;
        int i39;
        ViewGroup.MarginLayoutParams marginLayoutParams10;
        ViewGroup.MarginLayoutParams marginLayoutParams11;
        ViewGroup.MarginLayoutParams marginLayoutParams12;
        ViewGroup.MarginLayoutParams marginLayoutParams13;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        ViewGroup.MarginLayoutParams marginLayoutParams14;
        ViewGroup.MarginLayoutParams marginLayoutParams15;
        int i59;
        int i65;
        int i66;
        ViewGroup.MarginLayoutParams marginLayoutParams16;
        ViewGroup.MarginLayoutParams marginLayoutParams17;
        ViewGroup.MarginLayoutParams marginLayoutParams18;
        ViewGroup.MarginLayoutParams marginLayoutParams19;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        int i78;
        x<x.b, x.c> xVar = this.config;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        x.c O = xVar.O();
        int i79 = -2;
        if (O instanceof x.c.a) {
            TextView q16 = n().q();
            int dp8 = getDp8();
            ViewGroup.LayoutParams layoutParams = q16.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams16 = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams16 = null;
            }
            if (marginLayoutParams16 == null) {
                ViewGroup.LayoutParams layoutParams2 = q16.getLayoutParams();
                if (layoutParams2 != null) {
                    i77 = layoutParams2.width;
                } else {
                    i77 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = q16.getLayoutParams();
                if (layoutParams3 != null) {
                    i78 = layoutParams3.height;
                } else {
                    i78 = -2;
                }
                marginLayoutParams16 = new ViewGroup.MarginLayoutParams(i77, i78);
            }
            if (dp8 != marginLayoutParams16.rightMargin) {
                marginLayoutParams16.rightMargin = dp8;
                q16.setLayoutParams(marginLayoutParams16);
            }
            ImageView h16 = n().h();
            int dp82 = getDp8();
            ViewGroup.LayoutParams layoutParams4 = h16.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams17 = (ViewGroup.MarginLayoutParams) layoutParams4;
            } else {
                marginLayoutParams17 = null;
            }
            if (marginLayoutParams17 == null) {
                ViewGroup.LayoutParams layoutParams5 = h16.getLayoutParams();
                if (layoutParams5 != null) {
                    i75 = layoutParams5.width;
                } else {
                    i75 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = h16.getLayoutParams();
                if (layoutParams6 != null) {
                    i76 = layoutParams6.height;
                } else {
                    i76 = -2;
                }
                marginLayoutParams17 = new ViewGroup.MarginLayoutParams(i75, i76);
            }
            if (dp82 != marginLayoutParams17.rightMargin) {
                marginLayoutParams17.rightMargin = dp82;
                h16.setLayoutParams(marginLayoutParams17);
            }
            ImageView g16 = n().g();
            int dp83 = getDp8();
            ViewGroup.LayoutParams layoutParams7 = g16.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams18 = (ViewGroup.MarginLayoutParams) layoutParams7;
            } else {
                marginLayoutParams18 = null;
            }
            if (marginLayoutParams18 == null) {
                ViewGroup.LayoutParams layoutParams8 = g16.getLayoutParams();
                if (layoutParams8 != null) {
                    i68 = layoutParams8.width;
                } else {
                    i68 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = g16.getLayoutParams();
                if (layoutParams9 != null) {
                    i69 = layoutParams9.height;
                } else {
                    i69 = -2;
                }
                marginLayoutParams18 = new ViewGroup.MarginLayoutParams(i68, i69);
            }
            if (dp83 != marginLayoutParams18.rightMargin) {
                marginLayoutParams18.rightMargin = dp83;
                g16.setLayoutParams(marginLayoutParams18);
            }
            QUIListItem.b(this, n().q(), 0, 2, null);
            QUIListItem.b(this, n().h(), 0, 2, null);
            View n3 = n().n();
            int dp84 = getDp8();
            ViewGroup.LayoutParams layoutParams10 = n3.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams19 = (ViewGroup.MarginLayoutParams) layoutParams10;
            } else {
                marginLayoutParams19 = null;
            }
            if (marginLayoutParams19 == null) {
                ViewGroup.LayoutParams layoutParams11 = n3.getLayoutParams();
                if (layoutParams11 != null) {
                    i67 = layoutParams11.width;
                } else {
                    i67 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = n3.getLayoutParams();
                if (layoutParams12 != null) {
                    i79 = layoutParams12.height;
                }
                marginLayoutParams19 = new ViewGroup.MarginLayoutParams(i67, i79);
            }
            if (dp84 != marginLayoutParams19.rightMargin) {
                marginLayoutParams19.rightMargin = dp84;
                n3.setLayoutParams(marginLayoutParams19);
            }
            QUIListItem.b(this, n().n(), 0, 2, null);
            QUIListItem.b(this, n().g(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.b) {
            Button i85 = n().i();
            int dp85 = getDp8();
            ViewGroup.LayoutParams layoutParams13 = i85.getLayoutParams();
            if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams14 = (ViewGroup.MarginLayoutParams) layoutParams13;
            } else {
                marginLayoutParams14 = null;
            }
            if (marginLayoutParams14 == null) {
                ViewGroup.LayoutParams layoutParams14 = i85.getLayoutParams();
                if (layoutParams14 != null) {
                    i65 = layoutParams14.width;
                } else {
                    i65 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = i85.getLayoutParams();
                if (layoutParams15 != null) {
                    i66 = layoutParams15.height;
                } else {
                    i66 = -2;
                }
                marginLayoutParams14 = new ViewGroup.MarginLayoutParams(i65, i66);
            }
            if (dp85 != marginLayoutParams14.rightMargin) {
                marginLayoutParams14.rightMargin = dp85;
                i85.setLayoutParams(marginLayoutParams14);
            }
            QUIListItem.b(this, n().i(), 0, 2, null);
            ImageView j3 = n().j();
            int dp86 = getDp8();
            ViewGroup.LayoutParams layoutParams16 = j3.getLayoutParams();
            if (layoutParams16 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams15 = (ViewGroup.MarginLayoutParams) layoutParams16;
            } else {
                marginLayoutParams15 = null;
            }
            if (marginLayoutParams15 == null) {
                ViewGroup.LayoutParams layoutParams17 = j3.getLayoutParams();
                if (layoutParams17 != null) {
                    i59 = layoutParams17.width;
                } else {
                    i59 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = j3.getLayoutParams();
                if (layoutParams18 != null) {
                    i79 = layoutParams18.height;
                }
                marginLayoutParams15 = new ViewGroup.MarginLayoutParams(i59, i79);
            }
            if (dp86 != marginLayoutParams15.rightMargin) {
                marginLayoutParams15.rightMargin = dp86;
                j3.setLayoutParams(marginLayoutParams15);
            }
            QUIListItem.b(this, n().j(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.d) {
            TextView q17 = n().q();
            int dp87 = getDp8();
            ViewGroup.LayoutParams layoutParams19 = q17.getLayoutParams();
            if (layoutParams19 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams19;
            } else {
                marginLayoutParams10 = null;
            }
            if (marginLayoutParams10 == null) {
                ViewGroup.LayoutParams layoutParams20 = q17.getLayoutParams();
                if (layoutParams20 != null) {
                    i57 = layoutParams20.width;
                } else {
                    i57 = -2;
                }
                ViewGroup.LayoutParams layoutParams21 = q17.getLayoutParams();
                if (layoutParams21 != null) {
                    i58 = layoutParams21.height;
                } else {
                    i58 = -2;
                }
                marginLayoutParams10 = new ViewGroup.MarginLayoutParams(i57, i58);
            }
            if (dp87 != marginLayoutParams10.rightMargin) {
                marginLayoutParams10.rightMargin = dp87;
                q17.setLayoutParams(marginLayoutParams10);
            }
            ImageView k3 = n().k();
            int dp88 = getDp8();
            ViewGroup.LayoutParams layoutParams22 = k3.getLayoutParams();
            if (layoutParams22 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams22;
            } else {
                marginLayoutParams11 = null;
            }
            if (marginLayoutParams11 == null) {
                ViewGroup.LayoutParams layoutParams23 = k3.getLayoutParams();
                if (layoutParams23 != null) {
                    i49 = layoutParams23.width;
                } else {
                    i49 = -2;
                }
                ViewGroup.LayoutParams layoutParams24 = k3.getLayoutParams();
                if (layoutParams24 != null) {
                    i56 = layoutParams24.height;
                } else {
                    i56 = -2;
                }
                marginLayoutParams11 = new ViewGroup.MarginLayoutParams(i49, i56);
            }
            if (dp88 != marginLayoutParams11.rightMargin) {
                marginLayoutParams11.rightMargin = dp88;
                k3.setLayoutParams(marginLayoutParams11);
            }
            ImageView g17 = n().g();
            int dp89 = getDp8();
            ViewGroup.LayoutParams layoutParams25 = g17.getLayoutParams();
            if (layoutParams25 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams25;
            } else {
                marginLayoutParams12 = null;
            }
            if (marginLayoutParams12 == null) {
                ViewGroup.LayoutParams layoutParams26 = g17.getLayoutParams();
                if (layoutParams26 != null) {
                    i47 = layoutParams26.width;
                } else {
                    i47 = -2;
                }
                ViewGroup.LayoutParams layoutParams27 = g17.getLayoutParams();
                if (layoutParams27 != null) {
                    i48 = layoutParams27.height;
                } else {
                    i48 = -2;
                }
                marginLayoutParams12 = new ViewGroup.MarginLayoutParams(i47, i48);
            }
            if (dp89 != marginLayoutParams12.rightMargin) {
                marginLayoutParams12.rightMargin = dp89;
                g17.setLayoutParams(marginLayoutParams12);
            }
            QUIListItem.b(this, n().q(), 0, 2, null);
            QUIListItem.b(this, n().k(), 0, 2, null);
            View n16 = n().n();
            int dp810 = getDp8();
            ViewGroup.LayoutParams layoutParams28 = n16.getLayoutParams();
            if (layoutParams28 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams28;
            } else {
                marginLayoutParams13 = null;
            }
            if (marginLayoutParams13 == null) {
                ViewGroup.LayoutParams layoutParams29 = n16.getLayoutParams();
                if (layoutParams29 != null) {
                    i46 = layoutParams29.width;
                } else {
                    i46 = -2;
                }
                ViewGroup.LayoutParams layoutParams30 = n16.getLayoutParams();
                if (layoutParams30 != null) {
                    i79 = layoutParams30.height;
                }
                marginLayoutParams13 = new ViewGroup.MarginLayoutParams(i46, i79);
            }
            if (dp810 != marginLayoutParams13.rightMargin) {
                marginLayoutParams13.rightMargin = dp810;
                n16.setLayoutParams(marginLayoutParams13);
            }
            QUIListItem.b(this, n().n(), 0, 2, null);
            QUIListItem.b(this, n().g(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.i) {
            ImageView s16 = n().s();
            int dp811 = getDp8();
            ViewGroup.LayoutParams layoutParams31 = s16.getLayoutParams();
            if (layoutParams31 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams31;
            } else {
                marginLayoutParams9 = null;
            }
            if (marginLayoutParams9 == null) {
                ViewGroup.LayoutParams layoutParams32 = s16.getLayoutParams();
                if (layoutParams32 != null) {
                    i39 = layoutParams32.width;
                } else {
                    i39 = -2;
                }
                ViewGroup.LayoutParams layoutParams33 = s16.getLayoutParams();
                if (layoutParams33 != null) {
                    i79 = layoutParams33.height;
                }
                marginLayoutParams9 = new ViewGroup.MarginLayoutParams(i39, i79);
            }
            if (dp811 != marginLayoutParams9.rightMargin) {
                marginLayoutParams9.rightMargin = dp811;
                s16.setLayoutParams(marginLayoutParams9);
            }
            QUIListItem.b(this, n().s(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.f) {
            CompoundButton p16 = n().p();
            int dp812 = getDp8();
            ViewGroup.LayoutParams layoutParams34 = p16.getLayoutParams();
            if (layoutParams34 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams34;
            } else {
                marginLayoutParams8 = null;
            }
            if (marginLayoutParams8 == null) {
                ViewGroup.LayoutParams layoutParams35 = p16.getLayoutParams();
                if (layoutParams35 != null) {
                    i38 = layoutParams35.width;
                } else {
                    i38 = -2;
                }
                ViewGroup.LayoutParams layoutParams36 = p16.getLayoutParams();
                if (layoutParams36 != null) {
                    i79 = layoutParams36.height;
                }
                marginLayoutParams8 = new ViewGroup.MarginLayoutParams(i38, i79);
            }
            if (dp812 != marginLayoutParams8.rightMargin) {
                marginLayoutParams8.rightMargin = dp812;
                p16.setLayoutParams(marginLayoutParams8);
            }
            QUIListItem.b(this, n().p(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.g) {
            TextView q18 = n().q();
            int dp813 = getDp8();
            ViewGroup.LayoutParams layoutParams37 = q18.getLayoutParams();
            if (layoutParams37 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams37;
            } else {
                marginLayoutParams5 = null;
            }
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams38 = q18.getLayoutParams();
                if (layoutParams38 != null) {
                    i36 = layoutParams38.width;
                } else {
                    i36 = -2;
                }
                ViewGroup.LayoutParams layoutParams39 = q18.getLayoutParams();
                if (layoutParams39 != null) {
                    i37 = layoutParams39.height;
                } else {
                    i37 = -2;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i36, i37);
            }
            if (dp813 != marginLayoutParams5.rightMargin) {
                marginLayoutParams5.rightMargin = dp813;
                q18.setLayoutParams(marginLayoutParams5);
            }
            ImageView g18 = n().g();
            int dp814 = getDp8();
            ViewGroup.LayoutParams layoutParams40 = g18.getLayoutParams();
            if (layoutParams40 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams40;
            } else {
                marginLayoutParams6 = null;
            }
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams41 = g18.getLayoutParams();
                if (layoutParams41 != null) {
                    i28 = layoutParams41.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams42 = g18.getLayoutParams();
                if (layoutParams42 != null) {
                    i29 = layoutParams42.height;
                } else {
                    i29 = -2;
                }
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i28, i29);
            }
            if (dp814 != marginLayoutParams6.rightMargin) {
                marginLayoutParams6.rightMargin = dp814;
                g18.setLayoutParams(marginLayoutParams6);
            }
            QUIListItem.b(this, n().q(), 0, 2, null);
            View n17 = n().n();
            int dp815 = getDp8();
            ViewGroup.LayoutParams layoutParams43 = n17.getLayoutParams();
            if (layoutParams43 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams43;
            } else {
                marginLayoutParams7 = null;
            }
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams44 = n17.getLayoutParams();
                if (layoutParams44 != null) {
                    i27 = layoutParams44.width;
                } else {
                    i27 = -2;
                }
                ViewGroup.LayoutParams layoutParams45 = n17.getLayoutParams();
                if (layoutParams45 != null) {
                    i79 = layoutParams45.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i27, i79);
            }
            if (dp815 != marginLayoutParams7.rightMargin) {
                marginLayoutParams7.rightMargin = dp815;
                n17.setLayoutParams(marginLayoutParams7);
            }
            QUIListItem.b(this, n().n(), 0, 2, null);
            QUIListItem.b(this, n().g(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.e) {
            QUIRichBadge o16 = n().o();
            int dp816 = getDp8();
            ViewGroup.LayoutParams layoutParams46 = o16.getLayoutParams();
            if (layoutParams46 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams46;
            } else {
                marginLayoutParams3 = null;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams47 = o16.getLayoutParams();
                if (layoutParams47 != null) {
                    i19 = layoutParams47.width;
                } else {
                    i19 = -2;
                }
                ViewGroup.LayoutParams layoutParams48 = o16.getLayoutParams();
                if (layoutParams48 != null) {
                    i26 = layoutParams48.height;
                } else {
                    i26 = -2;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i19, i26);
            }
            if (dp816 != marginLayoutParams3.rightMargin) {
                marginLayoutParams3.rightMargin = dp816;
                o16.setLayoutParams(marginLayoutParams3);
            }
            QUIListItem.b(this, n().o(), 0, 2, null);
            ImageView g19 = n().g();
            int dp817 = getDp8();
            ViewGroup.LayoutParams layoutParams49 = g19.getLayoutParams();
            if (layoutParams49 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams49;
            } else {
                marginLayoutParams4 = null;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams50 = g19.getLayoutParams();
                if (layoutParams50 != null) {
                    i18 = layoutParams50.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams51 = g19.getLayoutParams();
                if (layoutParams51 != null) {
                    i79 = layoutParams51.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i18, i79);
            }
            if (dp817 != marginLayoutParams4.rightMargin) {
                marginLayoutParams4.rightMargin = dp817;
                g19.setLayoutParams(marginLayoutParams4);
            }
            QUIListItem.b(this, n().g(), 0, 2, null);
            return;
        }
        if (O instanceof x.c.h) {
            View r16 = n().r();
            int dp818 = getDp8();
            ViewGroup.LayoutParams layoutParams52 = r16.getLayoutParams();
            if (layoutParams52 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams52;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams53 = r16.getLayoutParams();
                if (layoutParams53 != null) {
                    i16 = layoutParams53.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams54 = r16.getLayoutParams();
                if (layoutParams54 != null) {
                    i17 = layoutParams54.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (dp818 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = dp818;
                r16.setLayoutParams(marginLayoutParams);
            }
            QUIListItem.b(this, n().r(), 0, 2, null);
            ImageView g26 = n().g();
            int dp819 = getDp8();
            ViewGroup.LayoutParams layoutParams55 = g26.getLayoutParams();
            if (layoutParams55 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams55;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams56 = g26.getLayoutParams();
                if (layoutParams56 != null) {
                    i3 = layoutParams56.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams57 = g26.getLayoutParams();
                if (layoutParams57 != null) {
                    i79 = layoutParams57.height;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i3, i79);
            }
            if (dp819 != marginLayoutParams2.rightMargin) {
                marginLayoutParams2.rightMargin = dp819;
                g26.setLayoutParams(marginLayoutParams2);
            }
            QUIListItem.b(this, n().g(), 0, 2, null);
            return;
        }
        boolean z16 = O instanceof x.c.C8997c;
    }

    private final void w() {
        x<x.b, x.c> xVar = this.config;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        x.b K = xVar.K();
        int i3 = 8;
        boolean z16 = true;
        if (K instanceof x.b.a) {
            x.b.a aVar = (x.b.a) K;
            l().m().setText(aVar.getText());
            TextView m3 = l().m();
            if (aVar.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            m3.setVisibility(i3);
            A(l().g(), aVar.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
            return;
        }
        if (K instanceof x.b.C8996b) {
            x.b.C8996b c8996b = (x.b.C8996b) K;
            l().m().setText(c8996b.getText());
            TextView m16 = l().m();
            if (c8996b.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            m16.setVisibility(i3);
            if (c8996b.getIconDrawable() != null) {
                l().i().setImageDrawable(c8996b.getIconDrawable());
                return;
            } else {
                B(l().i(), c8996b.getIconDrawableResId());
                return;
            }
        }
        if (K instanceof x.b.c) {
            x.b.c cVar = (x.b.c) K;
            l().m().setText(cVar.getText());
            TextView m17 = l().m();
            if (cVar.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            m17.setVisibility(i3);
            C(l().j(), cVar.getUrl());
            return;
        }
        if (K instanceof x.b.d) {
            x.b.d dVar = (x.b.d) K;
            l().m().setText(dVar.getText());
            TextView m18 = l().m();
            if (dVar.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            m18.setVisibility(i3);
        }
    }

    private final void x() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        getFlexboxLayout().setOnClickListener(null);
        int i27 = 0;
        getFlexboxLayout().setClickable(false);
        x<x.b, x.c> xVar = this.config;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        final x.c O = xVar.O();
        boolean z16 = true;
        if (O instanceof x.c.a) {
            ImageView g16 = n().g();
            x.c.a aVar = (x.c.a) O;
            if (aVar.getShowArrow()) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            g16.setVisibility(i19);
            View n3 = n().n();
            if (aVar.getShowRedPoint()) {
                i26 = 0;
            } else {
                i26 = 8;
            }
            n3.setVisibility(i26);
            n().q().setText(aVar.getText());
            TextView q16 = n().q();
            if (aVar.getText().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                i27 = 8;
            }
            q16.setVisibility(i27);
            p(n().q(), getResources().getDimensionPixelSize(R.dimen.dao));
            A(n().h(), aVar.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
        } else if (O instanceof x.c.b) {
            x.c.b bVar = (x.c.b) O;
            n().i().setText(bVar.getButtonText());
            n().i().setOnClickListener(bVar.getClickListener());
            ImageView j3 = n().j();
            if (!bVar.getShowCloseButton()) {
                i27 = 8;
            }
            j3.setVisibility(i27);
            n().j().setOnClickListener(bVar.getCloseButtonClickListener());
            n().j().setContentDescription(bVar.getCloseButtonDescription());
        } else if (O instanceof x.c.d) {
            ImageView g17 = n().g();
            x.c.d dVar = (x.c.d) O;
            if (dVar.getShowArrow()) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            g17.setVisibility(i17);
            n().q().setText(dVar.getText());
            TextView q17 = n().q();
            if (dVar.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            q17.setVisibility(i18);
            p(n().q(), getResources().getDimensionPixelSize(R.dimen.dao));
            View n16 = n().n();
            if (!dVar.getShowRedPoint()) {
                i27 = 8;
            }
            n16.setVisibility(i27);
            C(n().k(), dVar.getImageUrl());
        } else if (O instanceof x.c.i) {
            ImageView s16 = n().s();
            if (!((x.c.i) O).getIsSelected()) {
                i27 = 8;
            }
            s16.setVisibility(i27);
            getFlexboxLayout().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.listitem.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QUISingleLineListItem.y(x.c.this, this, view);
                }
            });
            O.a(getFlexboxLayout());
        } else if (O instanceof x.c.f) {
            n().p().setOnCheckedChangeListener(null);
            x.c.f fVar = (x.c.f) O;
            n().p().setChecked(fVar.getIsChecked());
            n().p().setEnabled(fVar.getIsEnabled());
            n().p().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.widget.listitem.s
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    QUISingleLineListItem.z(x.c.this, compoundButton, z17);
                }
            });
            O.a(n().p());
        } else if (O instanceof x.c.g) {
            ImageView g18 = n().g();
            x.c.g gVar = (x.c.g) O;
            if (gVar.getShowArrow()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            g18.setVisibility(i3);
            View n17 = n().n();
            if (gVar.getShowRedPoint()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            n17.setVisibility(i16);
            n().q().setText(gVar.getText());
            TextView q18 = n().q();
            if (gVar.getText().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                i27 = 8;
            }
            q18.setVisibility(i27);
            p(n().q(), getResources().getDimensionPixelSize(R.dimen.dao));
        } else if (O instanceof x.c.e) {
            x.c.e eVar = (x.c.e) O;
            if (eVar.getRichRedPointModel() != null) {
                QUIRichBadge o16 = n().o();
                com.tencent.mobileqq.quibadge.c richRedPointModel = eVar.getRichRedPointModel();
                Intrinsics.checkNotNull(richRedPointModel);
                o16.r(richRedPointModel);
            }
            n().o().setVisibility(0);
        } else if (O instanceof x.c.h) {
            CapabilityInjector.f316927a.g(n().r(), ((x.c.h) O).getRedPath());
        } else {
            boolean z17 = O instanceof x.c.C8997c;
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(x.c rightConfig, QUISingleLineListItem this$0, View it) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x.c.i iVar = (x.c.i) rightConfig;
        iVar.f(!iVar.getIsSelected());
        ImageView s16 = this$0.n().s();
        if (iVar.getIsSelected()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        s16.setVisibility(i3);
        h listener = iVar.getListener();
        if (listener != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            listener.a(it, iVar.getIsSelected());
        }
        this$0.sendAccessibilityEvent(1);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(x.c rightConfig, CompoundButton button, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(button, z16);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(button, "button");
        x.c.f fVar = (x.c.f) rightConfig;
        fVar.f(z16);
        CompoundButton.OnCheckedChangeListener listener = fVar.getListener();
        if (listener != null) {
            listener.onCheckedChanged(button, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(button, z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        D();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
    }

    public final void setConfig(@NotNull x.b leftConfig, @NotNull x.c rightConfig) {
        Intrinsics.checkNotNullParameter(leftConfig, "leftConfig");
        Intrinsics.checkNotNullParameter(rightConfig, "rightConfig");
        setConfig(new x<>(leftConfig, rightConfig));
    }

    public /* synthetic */ QUISingleLineListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void setConfig(@NotNull x<x.b, x.c> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        setThemeId(config.getThemeId());
        x<x.b, x.c> xVar = this.config;
        if (xVar == null) {
            this.config = config;
            w();
            x();
            u();
            v();
            return;
        }
        x<x.b, x.c> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        x.b K = xVar.K();
        x<x.b, x.c> xVar3 = this.config;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            xVar2 = xVar3;
        }
        x.c O = xVar2.O();
        this.config = config;
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(config.K().getClass()), Reflection.getOrCreateKotlinClass(K.getClass()))) {
            l().f();
            w();
            u();
            l().c();
        } else {
            w();
        }
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(config.O().getClass()), Reflection.getOrCreateKotlinClass(O.getClass()))) {
            n().f();
            x();
            v();
            n().c();
            return;
        }
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

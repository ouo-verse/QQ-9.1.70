package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.aa;
import com.tencent.mobileqq.widget.listitem.c;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00108TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUIDoubleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "Lcom/tencent/mobileqq/widget/listitem/c$b;", "", "w", HippyTKDListViewAdapter.X, "u", "v", "Landroid/widget/ImageView;", "view", "", "url", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "drawableId", "B", "D", "E", "leftConfig", "rightConfig", "setConfig", DownloadInfo.spKey_Config, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/widget/listitem/aa$a;", "I", "Lcom/tencent/mobileqq/widget/listitem/aa$a;", "touchExplorationRegistry", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "leftTextContainer", "K", "Lcom/tencent/mobileqq/widget/listitem/c;", "k", "()I", "itemHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QUIDoubleLineListItem extends QUIListItem<c<c.a, c.b>> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private aa.a touchExplorationRegistry;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout leftTextContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private c<c.a, c.b> config;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIDoubleLineListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(ImageView view, String url) {
        c<c.a, c.b> cVar = this.config;
        Unit unit = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        Function2<ImageView, String, Unit> L = cVar.L();
        if (L != null) {
            L.invoke(view, url);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CapabilityInjector.f316927a.d(view, url);
        }
    }

    private final void B(ImageView view, int drawableId) {
        c<c.a, c.b> cVar = this.config;
        Unit unit = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        Function2<ImageView, Integer, Unit> M = cVar.M();
        if (M != null) {
            M.invoke(view, Integer.valueOf(drawableId));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CapabilityInjector.f316927a.e(view, drawableId);
        }
    }

    private final void C(ImageView view, String url) {
        c<c.a, c.b> cVar = this.config;
        Unit unit = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        Function2<ImageView, String, Unit> N = cVar.N();
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
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        c.b O = cVar.O();
        if (!(O instanceof c.b.C8994b)) {
            return;
        }
        aa aaVar = aa.f316999a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.touchExplorationRegistry = aaVar.c(context, new QUIDoubleLineListItem$registerAccessibilityTouchExplorationStateChange$2(this, O));
    }

    private final void E() {
        aa.a aVar = this.touchExplorationRegistry;
        if (aVar != null) {
            aVar.a();
        }
        this.touchExplorationRegistry = null;
    }

    private final void u() {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        c<c.a, c.b> cVar = this.config;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        c.a K = cVar.K();
        int i19 = -2;
        if (K instanceof c.a.C8992a) {
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().h());
            ImageView g16 = l().g();
            int dp12 = getDp12();
            ViewGroup.LayoutParams layoutParams = g16.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = g16.getLayoutParams();
                if (layoutParams2 != null) {
                    i18 = layoutParams2.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = g16.getLayoutParams();
                if (layoutParams3 != null) {
                    i19 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            if (dp12 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dp12;
                g16.setLayoutParams(marginLayoutParams);
            }
            a(l().g(), 0);
            return;
        }
        if (K instanceof c.a.d) {
            ImageView k3 = l().k();
            int dp122 = getDp12();
            ViewGroup.LayoutParams layoutParams4 = k3.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams5 = k3.getLayoutParams();
                if (layoutParams5 != null) {
                    i17 = layoutParams5.width;
                } else {
                    i17 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = k3.getLayoutParams();
                if (layoutParams6 != null) {
                    i19 = layoutParams6.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i19);
            }
            if (dp122 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dp122;
                k3.setLayoutParams(marginLayoutParams);
            }
            a(l().k(), 0);
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().h());
            return;
        }
        if (K instanceof c.a.b) {
            ImageView i26 = l().i();
            int dp123 = getDp12();
            ViewGroup.LayoutParams layoutParams7 = i26.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams7;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams8 = i26.getLayoutParams();
                if (layoutParams8 != null) {
                    i16 = layoutParams8.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = i26.getLayoutParams();
                if (layoutParams9 != null) {
                    i19 = layoutParams9.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i19);
            }
            if (dp123 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dp123;
                i26.setLayoutParams(marginLayoutParams);
            }
            a(l().i(), 0);
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().h());
            return;
        }
        if (K instanceof c.a.C8993c) {
            z16 = true;
        } else {
            z16 = K instanceof c.a.e;
        }
        if (z16) {
            ImageView j3 = l().j();
            int dp124 = getDp12();
            ViewGroup.LayoutParams layoutParams10 = j3.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams10;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams11 = j3.getLayoutParams();
                if (layoutParams11 != null) {
                    i3 = layoutParams11.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = j3.getLayoutParams();
                if (layoutParams12 != null) {
                    i19 = layoutParams12.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i19);
            }
            if (dp124 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dp124;
                j3.setLayoutParams(marginLayoutParams);
            }
            a(l().j(), 0);
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().h());
            return;
        }
        if (K instanceof c.a.f) {
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().l());
        } else if (K instanceof c.a.g) {
            this.leftTextContainer.addView(l().m());
            this.leftTextContainer.addView(l().h());
        }
    }

    private final void v() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        int i26;
        ViewGroup.MarginLayoutParams marginLayoutParams5;
        int i27;
        ViewGroup.MarginLayoutParams marginLayoutParams6;
        ViewGroup.MarginLayoutParams marginLayoutParams7;
        int i28;
        int i29;
        int i36;
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        c.b O = cVar.O();
        int i37 = -2;
        if (O instanceof c.b.a) {
            Button i38 = n().i();
            int dp8 = getDp8();
            ViewGroup.LayoutParams layoutParams = i38.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams6 = null;
            }
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams2 = i38.getLayoutParams();
                if (layoutParams2 != null) {
                    i29 = layoutParams2.width;
                } else {
                    i29 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = i38.getLayoutParams();
                if (layoutParams3 != null) {
                    i36 = layoutParams3.height;
                } else {
                    i36 = -2;
                }
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i29, i36);
            }
            if (dp8 != marginLayoutParams6.rightMargin) {
                marginLayoutParams6.rightMargin = dp8;
                i38.setLayoutParams(marginLayoutParams6);
            }
            QUIListItem.b(this, n().i(), 0, 2, null);
            ImageView j3 = n().j();
            int dp82 = getDp8();
            ViewGroup.LayoutParams layoutParams4 = j3.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams4;
            } else {
                marginLayoutParams7 = null;
            }
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams5 = j3.getLayoutParams();
                if (layoutParams5 != null) {
                    i28 = layoutParams5.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = j3.getLayoutParams();
                if (layoutParams6 != null) {
                    i37 = layoutParams6.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i28, i37);
            }
            if (dp82 != marginLayoutParams7.rightMargin) {
                marginLayoutParams7.rightMargin = dp82;
                j3.setLayoutParams(marginLayoutParams7);
            }
            QUIListItem.b(this, n().j(), 0, 2, null);
            return;
        }
        if (O instanceof c.b.d) {
            ImageView s16 = n().s();
            int dp83 = getDp8();
            ViewGroup.LayoutParams layoutParams7 = s16.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams7;
            } else {
                marginLayoutParams5 = null;
            }
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams8 = s16.getLayoutParams();
                if (layoutParams8 != null) {
                    i27 = layoutParams8.width;
                } else {
                    i27 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = s16.getLayoutParams();
                if (layoutParams9 != null) {
                    i37 = layoutParams9.height;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i27, i37);
            }
            if (dp83 != marginLayoutParams5.rightMargin) {
                marginLayoutParams5.rightMargin = dp83;
                s16.setLayoutParams(marginLayoutParams5);
            }
            QUIListItem.b(this, n().s(), 0, 2, null);
            return;
        }
        if (O instanceof c.b.C8994b) {
            CompoundButton p16 = n().p();
            int dp84 = getDp8();
            ViewGroup.LayoutParams layoutParams10 = p16.getLayoutParams();
            if (layoutParams10 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams10;
            } else {
                marginLayoutParams4 = null;
            }
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams11 = p16.getLayoutParams();
                if (layoutParams11 != null) {
                    i26 = layoutParams11.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = p16.getLayoutParams();
                if (layoutParams12 != null) {
                    i37 = layoutParams12.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i26, i37);
            }
            if (dp84 != marginLayoutParams4.rightMargin) {
                marginLayoutParams4.rightMargin = dp84;
                p16.setLayoutParams(marginLayoutParams4);
            }
            QUIListItem.b(this, n().p(), 0, 2, null);
            return;
        }
        if (O instanceof c.b.C8995c) {
            TextView q16 = n().q();
            int dp85 = getDp8();
            ViewGroup.LayoutParams layoutParams13 = q16.getLayoutParams();
            if (layoutParams13 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams13;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams14 = q16.getLayoutParams();
                if (layoutParams14 != null) {
                    i18 = layoutParams14.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = q16.getLayoutParams();
                if (layoutParams15 != null) {
                    i19 = layoutParams15.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            if (dp85 != marginLayoutParams.rightMargin) {
                marginLayoutParams.rightMargin = dp85;
                q16.setLayoutParams(marginLayoutParams);
            }
            QUIListItem.b(this, n().q(), 0, 2, null);
            ImageView g16 = n().g();
            int dp86 = getDp8();
            ViewGroup.LayoutParams layoutParams16 = g16.getLayoutParams();
            if (layoutParams16 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams16;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams17 = g16.getLayoutParams();
                if (layoutParams17 != null) {
                    i16 = layoutParams17.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = g16.getLayoutParams();
                if (layoutParams18 != null) {
                    i17 = layoutParams18.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (dp86 != marginLayoutParams2.rightMargin) {
                marginLayoutParams2.rightMargin = dp86;
                g16.setLayoutParams(marginLayoutParams2);
            }
            QUIListItem.b(this, n().g(), 0, 2, null);
            View n3 = n().n();
            int dp87 = getDp8();
            ViewGroup.LayoutParams layoutParams19 = n3.getLayoutParams();
            if (layoutParams19 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams19;
            } else {
                marginLayoutParams3 = null;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams20 = n3.getLayoutParams();
                if (layoutParams20 != null) {
                    i3 = layoutParams20.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams21 = n3.getLayoutParams();
                if (layoutParams21 != null) {
                    i37 = layoutParams21.height;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i3, i37);
            }
            if (dp87 != marginLayoutParams3.rightMargin) {
                marginLayoutParams3.rightMargin = dp87;
                n3.setLayoutParams(marginLayoutParams3);
            }
            QUIListItem.b(this, n().n(), 0, 2, null);
        }
    }

    private final void w() {
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        c.a K = cVar.K();
        if (K instanceof c.a.C8992a) {
            c.a.C8992a c8992a = (c.a.C8992a) K;
            l().m().setText(c8992a.getText());
            l().h().setText(c8992a.getDescription());
            A(l().g(), c8992a.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
            return;
        }
        if (K instanceof c.a.d) {
            c.a.d dVar = (c.a.d) K;
            l().m().setText(dVar.getText());
            l().h().setText(dVar.getDescription());
            A(l().k(), dVar.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
            return;
        }
        if (K instanceof c.a.b) {
            c.a.b bVar = (c.a.b) K;
            l().m().setText(bVar.getText());
            l().h().setText(bVar.getDescription());
            if (bVar.getIconDrawable() != null) {
                l().i().setImageDrawable(bVar.getIconDrawable());
                return;
            } else {
                B(l().i(), bVar.getIconDrawableResId());
                return;
            }
        }
        if (K instanceof c.a.C8993c) {
            c.a.C8993c c8993c = (c.a.C8993c) K;
            l().m().setText(c8993c.getText());
            l().h().setText(c8993c.getDescription());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.daa);
            ab.f(l().j(), dimensionPixelSize, dimensionPixelSize);
            C(l().j(), c8993c.getImageUrl());
            return;
        }
        if (K instanceof c.a.f) {
            c.a.f fVar = (c.a.f) K;
            l().m().setText(fVar.getText());
            l().l().setText(fVar.getDescription());
        } else {
            if (K instanceof c.a.e) {
                c.a.e eVar = (c.a.e) K;
                l().m().setText(eVar.getText());
                l().h().setText(eVar.getDescription());
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dab);
                ab.f(l().j(), dimensionPixelSize2, dimensionPixelSize2);
                C(l().j(), eVar.getImageUrl());
                return;
            }
            if (K instanceof c.a.g) {
                c.a.g gVar = (c.a.g) K;
                l().m().setText(gVar.getText());
                l().h().setText(gVar.getDescription());
            }
        }
    }

    private final void x() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        getFlexboxLayout().setOnClickListener(null);
        int i18 = 0;
        getFlexboxLayout().setClickable(false);
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        final c.b O = cVar.O();
        boolean z17 = true;
        if (O instanceof c.b.a) {
            c.b.a aVar = (c.b.a) O;
            n().i().setText(aVar.getButtonText());
            n().i().setOnClickListener(aVar.getClickListener());
            ImageView j3 = n().j();
            if (aVar.getShowCloseButton()) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            j3.setVisibility(i17);
            n().j().setOnClickListener(aVar.getCloseButtonClickListener());
            n().j().setContentDescription(aVar.getCloseButtonDescription());
            Button i19 = n().i();
            if (aVar.getButtonText().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && aVar.getClickListener() == null) {
                z17 = false;
            }
            if (!z17) {
                i18 = 8;
            }
            i19.setVisibility(i18);
        } else if (O instanceof c.b.d) {
            ImageView s16 = n().s();
            if (!((c.b.d) O).getIsSelected()) {
                i18 = 8;
            }
            s16.setVisibility(i18);
            getFlexboxLayout().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.listitem.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QUIDoubleLineListItem.y(c.b.this, this, view);
                }
            });
            O.a(getFlexboxLayout());
        } else if (O instanceof c.b.C8994b) {
            n().p().setOnCheckedChangeListener(null);
            c.b.C8994b c8994b = (c.b.C8994b) O;
            n().p().setChecked(c8994b.getIsChecked());
            n().p().setEnabled(c8994b.getIsEnabled());
            n().p().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.widget.listitem.j
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                    QUIDoubleLineListItem.z(c.b.this, compoundButton, z18);
                }
            });
            O.a(n().p());
        } else if (O instanceof c.b.C8995c) {
            ImageView g16 = n().g();
            c.b.C8995c c8995c = (c.b.C8995c) O;
            if (c8995c.getShowArrow()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            g16.setVisibility(i3);
            View n3 = n().n();
            if (c8995c.getShowRedPoint()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            n3.setVisibility(i16);
            n().q().setText(c8995c.getText());
            TextView q16 = n().q();
            if (c8995c.getText().length() <= 0) {
                z17 = false;
            }
            if (!z17) {
                i18 = 8;
            }
            q16.setVisibility(i18);
            p(n().q(), getResources().getDimensionPixelSize(R.dimen.dao));
        }
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(c.b rightConfig, QUIDoubleLineListItem this$0, View it) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c.b.d dVar = (c.b.d) rightConfig;
        dVar.e(!dVar.getIsSelected());
        ImageView s16 = this$0.n().s();
        if (dVar.getIsSelected()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        s16.setVisibility(i3);
        h listener = dVar.getListener();
        if (listener != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            listener.a(it, dVar.getIsSelected());
        }
        this$0.sendAccessibilityEvent(1);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(c.b rightConfig, CompoundButton button, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(button, z16);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(button, "button");
        c.b.C8994b c8994b = (c.b.C8994b) rightConfig;
        c8994b.e(z16);
        CompoundButton.OnCheckedChangeListener listener = c8994b.getListener();
        if (listener != null) {
            listener.onCheckedChanged(button, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(button, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if ((r1.K() instanceof com.tencent.mobileqq.widget.listitem.c.a.C8992a) != false) goto L15;
     */
    @Override // com.tencent.mobileqq.widget.listitem.QUIListItem
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int getItemHeight() {
        c<c.a, c.b> cVar = this.config;
        if (cVar != null) {
            c<c.a, c.b> cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                cVar = null;
            }
            if (!(cVar.K() instanceof c.a.C8993c)) {
                c<c.a, c.b> cVar3 = this.config;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                } else {
                    cVar2 = cVar3;
                }
            }
            return getResources().getDimensionPixelSize(R.dimen.da6);
        }
        return getResources().getDimensionPixelSize(R.dimen.da5);
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

    public final void setConfig(@NotNull c.a leftConfig, @NotNull c.b rightConfig) {
        Intrinsics.checkNotNullParameter(leftConfig, "leftConfig");
        Intrinsics.checkNotNullParameter(rightConfig, "rightConfig");
        setConfig(new c<>(leftConfig, rightConfig));
    }

    public /* synthetic */ QUIDoubleLineListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void setConfig(@NotNull c<c.a, c.b> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        setThemeId(config.getThemeId());
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            this.config = config;
            w();
            x();
            u();
            v();
            return;
        }
        c<c.a, c.b> cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        c.a K = cVar.K();
        c<c.a, c.b> cVar3 = this.config;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            cVar2 = cVar3;
        }
        c.b O = cVar2.O();
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
    public QUIDoubleLineListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.b(0.01f);
        linearLayout.setLayoutParams(layoutParams);
        int dp12 = getDp12();
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            int i3 = layoutParams3 != null ? layoutParams3.width : -2;
            ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams4 != null ? layoutParams4.height : -2);
        }
        if (dp12 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = dp12;
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        d(linearLayout);
        this.leftTextContainer = linearLayout;
    }
}

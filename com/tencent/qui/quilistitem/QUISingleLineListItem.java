package com.tencent.qui.quilistitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIRichBadge;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quilistitem.u;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qui/quilistitem/QUISingleLineListItem;", "Lcom/tencent/qui/quilistitem/QUIListItem;", "Lcom/tencent/qui/quilistitem/u;", "Lcom/tencent/qui/quilistitem/u$b;", "Lcom/tencent/qui/quilistitem/u$c;", "", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "view", "", "url", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "leftConfig", "rightConfig", "setConfig", DownloadInfo.spKey_Config, "H", "Lcom/tencent/qui/quilistitem/u;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QUISingleLineListItem extends QUIListItem<u<u.b, u.c>> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    private u<u.b, u.c> config;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ u.c f363769e;

        a(u.c cVar) {
            this.f363769e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) QUISingleLineListItem.this, (Object) cVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(it);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
            } else {
                ((u.c.h) this.f363769e).d(!((u.c.h) r0).c());
                ImageView q16 = QUISingleLineListItem.this.j().q();
                if (((u.c.h) this.f363769e).c()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                q16.setVisibility(i3);
                i b16 = ((u.c.h) this.f363769e).b();
                if (b16 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    b16.a(it, ((u.c.h) this.f363769e).c());
                }
            }
            EventCollector.getInstance().onViewClicked(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "button", "Landroid/widget/CompoundButton;", "checked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u.c f363770d;

        b(u.c cVar) {
            this.f363770d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(@NotNull CompoundButton button, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(button, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, button, Boolean.valueOf(z16));
            } else {
                Intrinsics.checkNotNullParameter(button, "button");
                ((u.c.f) this.f363770d).e(z16);
                CompoundButton.OnCheckedChangeListener b16 = ((u.c.f) this.f363770d).b();
                if (b16 != null) {
                    b16.onCheckedChanged(button, z16);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(button, z16);
        }
    }

    @JvmOverloads
    public QUISingleLineListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    private final void m() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.b r16 = uVar.r();
        ViewGroup.LayoutParams layoutParams = null;
        int i37 = -2;
        if (r16 instanceof u.b.a) {
            ImageView f16 = i().f();
            int e16 = e();
            ViewGroup.LayoutParams layoutParams2 = f16.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams3 = f16.getLayoutParams();
                if (layoutParams3 != null) {
                    i29 = layoutParams3.width;
                } else {
                    i29 = -2;
                }
                ViewGroup.LayoutParams layoutParams4 = f16.getLayoutParams();
                if (layoutParams4 != null) {
                    i36 = layoutParams4.height;
                } else {
                    i36 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i29, i36);
            }
            marginLayoutParams.leftMargin = e16;
            f16.setLayoutParams(marginLayoutParams);
            TextView k3 = i().k();
            int e17 = e();
            ViewGroup.LayoutParams layoutParams5 = k3.getLayoutParams();
            if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams5;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams6 = k3.getLayoutParams();
                if (layoutParams6 != null) {
                    i28 = layoutParams6.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams7 = k3.getLayoutParams();
                if (layoutParams7 != null) {
                    i37 = layoutParams7.height;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i28, i37);
            }
            marginLayoutParams2.leftMargin = e17;
            k3.setLayoutParams(marginLayoutParams2);
            a(i().k(), 0);
            a(i().f(), 0);
            return;
        }
        if (r16 instanceof u.b.C9720b) {
            ImageView h16 = i().h();
            int e18 = e();
            ViewGroup.LayoutParams layoutParams8 = h16.getLayoutParams();
            if (!(layoutParams8 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams8 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams8;
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams9 = h16.getLayoutParams();
                if (layoutParams9 != null) {
                    i26 = layoutParams9.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams10 = h16.getLayoutParams();
                if (layoutParams10 != null) {
                    i27 = layoutParams10.height;
                } else {
                    i27 = -2;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i26, i27);
            }
            marginLayoutParams3.leftMargin = e18;
            h16.setLayoutParams(marginLayoutParams3);
            TextView k16 = i().k();
            int e19 = e();
            ViewGroup.LayoutParams layoutParams11 = k16.getLayoutParams();
            if (layoutParams11 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams11;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams12 = k16.getLayoutParams();
                if (layoutParams12 != null) {
                    i19 = layoutParams12.width;
                } else {
                    i19 = -2;
                }
                ViewGroup.LayoutParams layoutParams13 = k16.getLayoutParams();
                if (layoutParams13 != null) {
                    i37 = layoutParams13.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i19, i37);
            }
            marginLayoutParams4.leftMargin = e19;
            k16.setLayoutParams(marginLayoutParams4);
            a(i().k(), 0);
            a(i().h(), 0);
            return;
        }
        if (r16 instanceof u.b.c) {
            ImageView i38 = i().i();
            int e26 = e();
            ViewGroup.LayoutParams layoutParams14 = i38.getLayoutParams();
            if (!(layoutParams14 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams14 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams14;
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams15 = i38.getLayoutParams();
                if (layoutParams15 != null) {
                    i17 = layoutParams15.width;
                } else {
                    i17 = -2;
                }
                ViewGroup.LayoutParams layoutParams16 = i38.getLayoutParams();
                if (layoutParams16 != null) {
                    i18 = layoutParams16.height;
                } else {
                    i18 = -2;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i17, i18);
            }
            marginLayoutParams5.leftMargin = e26;
            i38.setLayoutParams(marginLayoutParams5);
            TextView k17 = i().k();
            int e27 = e();
            ViewGroup.LayoutParams layoutParams17 = k17.getLayoutParams();
            if (layoutParams17 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams17;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams18 = k17.getLayoutParams();
                if (layoutParams18 != null) {
                    i16 = layoutParams18.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams19 = k17.getLayoutParams();
                if (layoutParams19 != null) {
                    i37 = layoutParams19.height;
                }
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i16, i37);
            }
            marginLayoutParams6.leftMargin = e27;
            k17.setLayoutParams(marginLayoutParams6);
            a(i().k(), 0);
            a(i().i(), 0);
            return;
        }
        if (r16 instanceof u.b.d) {
            TextView k18 = i().k();
            int e28 = e();
            ViewGroup.LayoutParams layoutParams20 = k18.getLayoutParams();
            if (layoutParams20 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams20;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams21 = k18.getLayoutParams();
                if (layoutParams21 != null) {
                    i3 = layoutParams21.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams22 = k18.getLayoutParams();
                if (layoutParams22 != null) {
                    i37 = layoutParams22.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i3, i37);
            }
            marginLayoutParams7.leftMargin = e28;
            k18.setLayoutParams(marginLayoutParams7);
            a(i().k(), 0);
        }
    }

    private final void n() {
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.c u16 = uVar.u();
        if (u16 instanceof u.c.a) {
            TextView p16 = j().p();
            int f16 = f();
            ViewGroup.LayoutParams layoutParams = p16.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = p16.getLayoutParams();
                int i3 = layoutParams2 != null ? layoutParams2.width : -2;
                ViewGroup.LayoutParams layoutParams3 = p16.getLayoutParams();
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
            }
            marginLayoutParams.rightMargin = f16;
            p16.setLayoutParams(marginLayoutParams);
            Unit unit = Unit.INSTANCE;
            ImageView g16 = j().g();
            int f17 = f();
            ViewGroup.LayoutParams layoutParams4 = g16.getLayoutParams();
            if (!(layoutParams4 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams4 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams5 = g16.getLayoutParams();
                int i16 = layoutParams5 != null ? layoutParams5.width : -2;
                ViewGroup.LayoutParams layoutParams6 = g16.getLayoutParams();
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, layoutParams6 != null ? layoutParams6.height : -2);
            }
            marginLayoutParams2.rightMargin = f17;
            g16.setLayoutParams(marginLayoutParams2);
            ImageView f18 = j().f();
            int f19 = f();
            ViewGroup.LayoutParams layoutParams7 = f18.getLayoutParams();
            if (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams7 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams7;
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams8 = f18.getLayoutParams();
                int i17 = layoutParams8 != null ? layoutParams8.width : -2;
                ViewGroup.LayoutParams layoutParams9 = f18.getLayoutParams();
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i17, layoutParams9 != null ? layoutParams9.height : -2);
            }
            marginLayoutParams3.rightMargin = f19;
            f18.setLayoutParams(marginLayoutParams3);
            QUIListItem.b(this, j().p(), 0, 2, null);
            QUIListItem.b(this, j().g(), 0, 2, null);
            View m3 = j().m();
            int f26 = f();
            ViewGroup.LayoutParams layoutParams10 = m3.getLayoutParams();
            if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams10 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams10;
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams11 = m3.getLayoutParams();
                int i18 = layoutParams11 != null ? layoutParams11.width : -2;
                ViewGroup.LayoutParams layoutParams12 = m3.getLayoutParams();
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i18, layoutParams12 != null ? layoutParams12.height : -2);
            }
            marginLayoutParams4.rightMargin = f26;
            m3.setLayoutParams(marginLayoutParams4);
            QUIListItem.b(this, j().m(), 0, 2, null);
            QUIListItem.b(this, j().f(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.b) {
            Button h16 = j().h();
            int f27 = f();
            ViewGroup.LayoutParams layoutParams13 = h16.getLayoutParams();
            if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams13 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams13;
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams14 = h16.getLayoutParams();
                int i19 = layoutParams14 != null ? layoutParams14.width : -2;
                ViewGroup.LayoutParams layoutParams15 = h16.getLayoutParams();
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i19, layoutParams15 != null ? layoutParams15.height : -2);
            }
            marginLayoutParams5.rightMargin = f27;
            h16.setLayoutParams(marginLayoutParams5);
            Unit unit2 = Unit.INSTANCE;
            QUIListItem.b(this, j().h(), 0, 2, null);
            ImageView i26 = j().i();
            int f28 = f();
            ViewGroup.LayoutParams layoutParams16 = i26.getLayoutParams();
            if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams16 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams16;
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams17 = i26.getLayoutParams();
                int i27 = layoutParams17 != null ? layoutParams17.width : -2;
                ViewGroup.LayoutParams layoutParams18 = i26.getLayoutParams();
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i27, layoutParams18 != null ? layoutParams18.height : -2);
            }
            marginLayoutParams6.rightMargin = f28;
            i26.setLayoutParams(marginLayoutParams6);
            QUIListItem.b(this, j().i(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.d) {
            TextView p17 = j().p();
            int f29 = f();
            ViewGroup.LayoutParams layoutParams19 = p17.getLayoutParams();
            if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams19 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams19;
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams20 = p17.getLayoutParams();
                int i28 = layoutParams20 != null ? layoutParams20.width : -2;
                ViewGroup.LayoutParams layoutParams21 = p17.getLayoutParams();
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i28, layoutParams21 != null ? layoutParams21.height : -2);
            }
            marginLayoutParams7.rightMargin = f29;
            p17.setLayoutParams(marginLayoutParams7);
            Unit unit3 = Unit.INSTANCE;
            ImageView j3 = j().j();
            int f36 = f();
            ViewGroup.LayoutParams layoutParams22 = j3.getLayoutParams();
            if (!(layoutParams22 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams22 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams22;
            if (marginLayoutParams8 == null) {
                ViewGroup.LayoutParams layoutParams23 = j3.getLayoutParams();
                int i29 = layoutParams23 != null ? layoutParams23.width : -2;
                ViewGroup.LayoutParams layoutParams24 = j3.getLayoutParams();
                marginLayoutParams8 = new ViewGroup.MarginLayoutParams(i29, layoutParams24 != null ? layoutParams24.height : -2);
            }
            marginLayoutParams8.rightMargin = f36;
            j3.setLayoutParams(marginLayoutParams8);
            ImageView f37 = j().f();
            int f38 = f();
            ViewGroup.LayoutParams layoutParams25 = f37.getLayoutParams();
            if (!(layoutParams25 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams25 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams25;
            if (marginLayoutParams9 == null) {
                ViewGroup.LayoutParams layoutParams26 = f37.getLayoutParams();
                int i36 = layoutParams26 != null ? layoutParams26.width : -2;
                ViewGroup.LayoutParams layoutParams27 = f37.getLayoutParams();
                marginLayoutParams9 = new ViewGroup.MarginLayoutParams(i36, layoutParams27 != null ? layoutParams27.height : -2);
            }
            marginLayoutParams9.rightMargin = f38;
            f37.setLayoutParams(marginLayoutParams9);
            QUIListItem.b(this, j().p(), 0, 2, null);
            QUIListItem.b(this, j().j(), 0, 2, null);
            View m16 = j().m();
            int f39 = f();
            ViewGroup.LayoutParams layoutParams28 = m16.getLayoutParams();
            if (!(layoutParams28 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams28 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams28;
            if (marginLayoutParams10 == null) {
                ViewGroup.LayoutParams layoutParams29 = m16.getLayoutParams();
                int i37 = layoutParams29 != null ? layoutParams29.width : -2;
                ViewGroup.LayoutParams layoutParams30 = m16.getLayoutParams();
                marginLayoutParams10 = new ViewGroup.MarginLayoutParams(i37, layoutParams30 != null ? layoutParams30.height : -2);
            }
            marginLayoutParams10.rightMargin = f39;
            m16.setLayoutParams(marginLayoutParams10);
            QUIListItem.b(this, j().m(), 0, 2, null);
            QUIListItem.b(this, j().f(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.h) {
            ImageView q16 = j().q();
            int f46 = f();
            ViewGroup.LayoutParams layoutParams31 = q16.getLayoutParams();
            if (!(layoutParams31 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams31 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams31;
            if (marginLayoutParams11 == null) {
                ViewGroup.LayoutParams layoutParams32 = q16.getLayoutParams();
                int i38 = layoutParams32 != null ? layoutParams32.width : -2;
                ViewGroup.LayoutParams layoutParams33 = q16.getLayoutParams();
                marginLayoutParams11 = new ViewGroup.MarginLayoutParams(i38, layoutParams33 != null ? layoutParams33.height : -2);
            }
            marginLayoutParams11.rightMargin = f46;
            q16.setLayoutParams(marginLayoutParams11);
            Unit unit4 = Unit.INSTANCE;
            QUIListItem.b(this, j().q(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.f) {
            CompoundButton o16 = j().o();
            int f47 = f();
            ViewGroup.LayoutParams layoutParams34 = o16.getLayoutParams();
            if (!(layoutParams34 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams34 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams34;
            if (marginLayoutParams12 == null) {
                ViewGroup.LayoutParams layoutParams35 = o16.getLayoutParams();
                int i39 = layoutParams35 != null ? layoutParams35.width : -2;
                ViewGroup.LayoutParams layoutParams36 = o16.getLayoutParams();
                marginLayoutParams12 = new ViewGroup.MarginLayoutParams(i39, layoutParams36 != null ? layoutParams36.height : -2);
            }
            marginLayoutParams12.rightMargin = f47;
            o16.setLayoutParams(marginLayoutParams12);
            Unit unit5 = Unit.INSTANCE;
            QUIListItem.b(this, j().o(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.g) {
            TextView p18 = j().p();
            int f48 = f();
            ViewGroup.LayoutParams layoutParams37 = p18.getLayoutParams();
            if (!(layoutParams37 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams37 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams37;
            if (marginLayoutParams13 == null) {
                ViewGroup.LayoutParams layoutParams38 = p18.getLayoutParams();
                int i46 = layoutParams38 != null ? layoutParams38.width : -2;
                ViewGroup.LayoutParams layoutParams39 = p18.getLayoutParams();
                marginLayoutParams13 = new ViewGroup.MarginLayoutParams(i46, layoutParams39 != null ? layoutParams39.height : -2);
            }
            marginLayoutParams13.rightMargin = f48;
            p18.setLayoutParams(marginLayoutParams13);
            Unit unit6 = Unit.INSTANCE;
            ImageView f49 = j().f();
            int f56 = f();
            ViewGroup.LayoutParams layoutParams40 = f49.getLayoutParams();
            if (!(layoutParams40 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams40 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams14 = (ViewGroup.MarginLayoutParams) layoutParams40;
            if (marginLayoutParams14 == null) {
                ViewGroup.LayoutParams layoutParams41 = f49.getLayoutParams();
                int i47 = layoutParams41 != null ? layoutParams41.width : -2;
                ViewGroup.LayoutParams layoutParams42 = f49.getLayoutParams();
                marginLayoutParams14 = new ViewGroup.MarginLayoutParams(i47, layoutParams42 != null ? layoutParams42.height : -2);
            }
            marginLayoutParams14.rightMargin = f56;
            f49.setLayoutParams(marginLayoutParams14);
            QUIListItem.b(this, j().p(), 0, 2, null);
            View m17 = j().m();
            int f57 = f();
            ViewGroup.LayoutParams layoutParams43 = m17.getLayoutParams();
            if (!(layoutParams43 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams43 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams15 = (ViewGroup.MarginLayoutParams) layoutParams43;
            if (marginLayoutParams15 == null) {
                ViewGroup.LayoutParams layoutParams44 = m17.getLayoutParams();
                int i48 = layoutParams44 != null ? layoutParams44.width : -2;
                ViewGroup.LayoutParams layoutParams45 = m17.getLayoutParams();
                marginLayoutParams15 = new ViewGroup.MarginLayoutParams(i48, layoutParams45 != null ? layoutParams45.height : -2);
            }
            marginLayoutParams15.rightMargin = f57;
            m17.setLayoutParams(marginLayoutParams15);
            QUIListItem.b(this, j().m(), 0, 2, null);
            QUIListItem.b(this, j().f(), 0, 2, null);
            return;
        }
        if (u16 instanceof u.c.e) {
            QUIRichBadge n3 = j().n();
            int f58 = f();
            ViewGroup.LayoutParams layoutParams46 = n3.getLayoutParams();
            if (!(layoutParams46 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams46 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams16 = (ViewGroup.MarginLayoutParams) layoutParams46;
            if (marginLayoutParams16 == null) {
                ViewGroup.LayoutParams layoutParams47 = n3.getLayoutParams();
                int i49 = layoutParams47 != null ? layoutParams47.width : -2;
                ViewGroup.LayoutParams layoutParams48 = n3.getLayoutParams();
                marginLayoutParams16 = new ViewGroup.MarginLayoutParams(i49, layoutParams48 != null ? layoutParams48.height : -2);
            }
            marginLayoutParams16.rightMargin = f58;
            n3.setLayoutParams(marginLayoutParams16);
            Unit unit7 = Unit.INSTANCE;
            QUIListItem.b(this, j().n(), 0, 2, null);
            ImageView f59 = j().f();
            int f65 = f();
            ViewGroup.LayoutParams layoutParams49 = f59.getLayoutParams();
            if (!(layoutParams49 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams49 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams17 = (ViewGroup.MarginLayoutParams) layoutParams49;
            if (marginLayoutParams17 == null) {
                ViewGroup.LayoutParams layoutParams50 = f59.getLayoutParams();
                int i56 = layoutParams50 != null ? layoutParams50.width : -2;
                ViewGroup.LayoutParams layoutParams51 = f59.getLayoutParams();
                marginLayoutParams17 = new ViewGroup.MarginLayoutParams(i56, layoutParams51 != null ? layoutParams51.height : -2);
            }
            marginLayoutParams17.rightMargin = f65;
            f59.setLayoutParams(marginLayoutParams17);
            QUIListItem.b(this, j().f(), 0, 2, null);
            return;
        }
        boolean z16 = u16 instanceof u.c.C9721c;
    }

    private final void o() {
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.b r16 = uVar.r();
        int i3 = 8;
        boolean z16 = true;
        if (r16 instanceof u.b.a) {
            u.b.a aVar = (u.b.a) r16;
            i().k().setText(aVar.a());
            TextView k3 = i().k();
            if (aVar.a().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            k3.setVisibility(i3);
            q(i().f(), aVar.b());
            return;
        }
        if (r16 instanceof u.b.C9720b) {
            u.b.C9720b c9720b = (u.b.C9720b) r16;
            i().k().setText(c9720b.a());
            TextView k16 = i().k();
            if (c9720b.a().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            k16.setVisibility(i3);
            v.b(i().h(), c9720b.b());
            return;
        }
        if (r16 instanceof u.b.c) {
            u.b.c cVar = (u.b.c) r16;
            i().k().setText(cVar.a());
            TextView k17 = i().k();
            if (cVar.a().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            k17.setVisibility(i3);
            r(i().i(), cVar.b());
            return;
        }
        if (r16 instanceof u.b.d) {
            u.b.d dVar = (u.b.d) r16;
            i().k().setText(dVar.a());
            TextView k18 = i().k();
            if (dVar.a().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            }
            k18.setVisibility(i3);
        }
    }

    private final void p() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        g().setOnClickListener(null);
        int i27 = 0;
        g().setClickable(false);
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.c u16 = uVar.u();
        boolean z16 = true;
        if (u16 instanceof u.c.a) {
            ImageView f16 = j().f();
            u.c.a aVar = (u.c.a) u16;
            if (aVar.b()) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            f16.setVisibility(i19);
            View m3 = j().m();
            if (aVar.c()) {
                i26 = 0;
            } else {
                i26 = 8;
            }
            m3.setVisibility(i26);
            j().p().setText(aVar.d());
            TextView p16 = j().p();
            if (aVar.d().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                i27 = 8;
            }
            p16.setVisibility(i27);
            l(j().p(), getResources().getDimensionPixelSize(R.dimen.dao));
            q(j().g(), aVar.e());
            return;
        }
        if (u16 instanceof u.c.b) {
            u.c.b bVar = (u.c.b) u16;
            j().h().setText(bVar.b());
            j().h().setOnClickListener(bVar.c());
            ImageView i28 = j().i();
            if (!bVar.e()) {
                i27 = 8;
            }
            i28.setVisibility(i27);
            j().i().setOnClickListener(bVar.d());
            return;
        }
        if (u16 instanceof u.c.d) {
            ImageView f17 = j().f();
            u.c.d dVar = (u.c.d) u16;
            if (dVar.b()) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            f17.setVisibility(i17);
            j().p().setText(dVar.d());
            TextView p17 = j().p();
            if (dVar.d().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            p17.setVisibility(i18);
            l(j().p(), getResources().getDimensionPixelSize(R.dimen.dao));
            View m16 = j().m();
            if (!dVar.c()) {
                i27 = 8;
            }
            m16.setVisibility(i27);
            r(j().j(), dVar.e());
            return;
        }
        if (u16 instanceof u.c.h) {
            ImageView q16 = j().q();
            if (!((u.c.h) u16).c()) {
                i27 = 8;
            }
            q16.setVisibility(i27);
            g().setOnClickListener(new a(u16));
            u16.a(g());
            return;
        }
        if (u16 instanceof u.c.f) {
            j().o().setOnCheckedChangeListener(null);
            u.c.f fVar = (u.c.f) u16;
            j().o().setChecked(fVar.c());
            j().o().setEnabled(fVar.d());
            j().o().setOnCheckedChangeListener(new b(u16));
            u16.a(j().o());
            return;
        }
        if (u16 instanceof u.c.g) {
            ImageView f18 = j().f();
            u.c.g gVar = (u.c.g) u16;
            if (gVar.b()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            f18.setVisibility(i3);
            View m17 = j().m();
            if (gVar.c()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            m17.setVisibility(i16);
            j().p().setText(gVar.d());
            TextView p18 = j().p();
            if (gVar.d().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                i27 = 8;
            }
            p18.setVisibility(i27);
            l(j().p(), getResources().getDimensionPixelSize(R.dimen.dao));
            return;
        }
        if (u16 instanceof u.c.e) {
            u.c.e eVar = (u.c.e) u16;
            if (eVar.b() != null) {
                QUIRichBadge n3 = j().n();
                com.tencent.mobileqq.quibadge.c b16 = eVar.b();
                Intrinsics.checkNotNull(b16);
                n3.r(b16);
            }
            QUIRichBadge n16 = j().n();
            if (eVar.b() == null) {
                z16 = false;
            }
            if (!z16) {
                i27 = 8;
            }
            n16.setVisibility(i27);
            return;
        }
        boolean z17 = u16 instanceof u.c.C9721c;
    }

    private final void q(ImageView view, String url) {
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        Function2<ImageView, String, Unit> s16 = uVar.s();
        if (s16 == null || s16.invoke(view, url) == null) {
            v.a(view, url);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void r(ImageView view, String url) {
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        Function2<ImageView, String, Unit> t16 = uVar.t();
        if (t16 == null || t16.invoke(view, url) == null) {
            v.c(view, url);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setConfig(@NotNull u.b leftConfig, @NotNull u.c rightConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) leftConfig, (Object) rightConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(leftConfig, "leftConfig");
        Intrinsics.checkNotNullParameter(rightConfig, "rightConfig");
        setConfig(new u<>(leftConfig, rightConfig));
    }

    public /* synthetic */ QUISingleLineListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public final void setConfig(@NotNull u<u.b, u.c> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        setThemeId(config.f());
        u<u.b, u.c> uVar = this.config;
        if (uVar == null) {
            this.config = config;
            o();
            p();
            m();
            n();
            return;
        }
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.b r16 = uVar.r();
        u<u.b, u.c> uVar2 = this.config;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        u.c u16 = uVar2.u();
        this.config = config;
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(config.r().getClass()), Reflection.getOrCreateKotlinClass(r16.getClass()))) {
            i().e();
            o();
            m();
            i().b();
        } else {
            o();
        }
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(config.u().getClass()), Reflection.getOrCreateKotlinClass(u16.getClass()))) {
            j().e();
            p();
            n();
            j().b();
            return;
        }
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }
}

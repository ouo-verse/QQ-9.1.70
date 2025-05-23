package com.tencent.qui.quilistitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quilistitem.c;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u001a\u0010\u0019\u001a\u00020\u00148\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIDoubleLineListItem;", "Lcom/tencent/qui/quilistitem/QUIListItem;", "Lcom/tencent/qui/quilistitem/c;", "Lcom/tencent/qui/quilistitem/c$a;", "Lcom/tencent/qui/quilistitem/c$b;", "", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "view", "", "url", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "leftConfig", "rightConfig", "setConfig", DownloadInfo.spKey_Config, "", "H", "I", tl.h.F, "()I", "itemHeight", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "leftTextContainer", "J", "Lcom/tencent/qui/quilistitem/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QUIDoubleLineListItem extends QUIListItem<c<c.a, c.b>> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private final LinearLayout leftTextContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private c<c.a, c.b> config;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c.b f363729e;

        a(c.b bVar) {
            this.f363729e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) QUIDoubleLineListItem.this, (Object) bVar);
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
                ((c.b.e) this.f363729e).d(!((c.b.e) r0).c());
                ImageView q16 = QUIDoubleLineListItem.this.j().q();
                if (((c.b.e) this.f363729e).c()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                q16.setVisibility(i3);
                i b16 = ((c.b.e) this.f363729e).b();
                if (b16 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    b16.a(it, ((c.b.e) this.f363729e).c());
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
        final /* synthetic */ c.b f363730d;

        b(c.b bVar) {
            this.f363730d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
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
                ((c.b.C9719c) this.f363730d).e(z16);
                CompoundButton.OnCheckedChangeListener b16 = ((c.b.C9719c) this.f363730d).b();
                if (b16 != null) {
                    b16.onCheckedChanged(button, z16);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(button, z16);
        }
    }

    @JvmOverloads
    public QUIDoubleLineListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    private final void m() {
        int i3;
        int i16;
        int i17;
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        c.a r16 = cVar.r();
        ViewGroup.LayoutParams layoutParams = null;
        int i18 = -2;
        if (r16 instanceof c.a.C9716a) {
            this.leftTextContainer.addView(i().k());
            this.leftTextContainer.addView(i().g());
            ImageView f16 = i().f();
            int e16 = e();
            ViewGroup.LayoutParams layoutParams2 = f16.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams3 = f16.getLayoutParams();
                if (layoutParams3 != null) {
                    i17 = layoutParams3.width;
                } else {
                    i17 = -2;
                }
                ViewGroup.LayoutParams layoutParams4 = f16.getLayoutParams();
                if (layoutParams4 != null) {
                    i18 = layoutParams4.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i18);
            }
            marginLayoutParams.leftMargin = e16;
            f16.setLayoutParams(marginLayoutParams);
            a(i().f(), 0);
            return;
        }
        if (r16 instanceof c.a.C9717c) {
            ImageView j3 = i().j();
            int e17 = e();
            ViewGroup.LayoutParams layoutParams5 = j3.getLayoutParams();
            if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams5;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams6 = j3.getLayoutParams();
                if (layoutParams6 != null) {
                    i16 = layoutParams6.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams7 = j3.getLayoutParams();
                if (layoutParams7 != null) {
                    i18 = layoutParams7.height;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, i18);
            }
            marginLayoutParams2.leftMargin = e17;
            j3.setLayoutParams(marginLayoutParams2);
            a(i().j(), 0);
            this.leftTextContainer.addView(i().k());
            this.leftTextContainer.addView(i().g());
            return;
        }
        if (r16 instanceof c.a.b) {
            ImageView i19 = i().i();
            int e18 = e();
            ViewGroup.LayoutParams layoutParams8 = i19.getLayoutParams();
            if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams8;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams9 = i19.getLayoutParams();
                if (layoutParams9 != null) {
                    i3 = layoutParams9.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams10 = i19.getLayoutParams();
                if (layoutParams10 != null) {
                    i18 = layoutParams10.height;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i3, i18);
            }
            marginLayoutParams3.leftMargin = e18;
            i19.setLayoutParams(marginLayoutParams3);
            a(i().i(), 0);
            this.leftTextContainer.addView(i().k());
            this.leftTextContainer.addView(i().g());
            return;
        }
        if (r16 instanceof c.a.d) {
            this.leftTextContainer.addView(i().k());
            this.leftTextContainer.addView(i().g());
        }
    }

    private final void n() {
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
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        c.b u16 = cVar.u();
        int i37 = -2;
        if (u16 instanceof c.b.a) {
            Button h16 = j().h();
            int f16 = f();
            ViewGroup.LayoutParams layoutParams = h16.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                if (layoutParams2 != null) {
                    i29 = layoutParams2.width;
                } else {
                    i29 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = h16.getLayoutParams();
                if (layoutParams3 != null) {
                    i36 = layoutParams3.height;
                } else {
                    i36 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i29, i36);
            }
            marginLayoutParams.rightMargin = f16;
            h16.setLayoutParams(marginLayoutParams);
            QUIListItem.b(this, j().h(), 0, 2, null);
            ImageView i38 = j().i();
            int f17 = f();
            ViewGroup.LayoutParams layoutParams4 = i38.getLayoutParams();
            if (!(layoutParams4 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams4 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams5 = i38.getLayoutParams();
                if (layoutParams5 != null) {
                    i28 = layoutParams5.width;
                } else {
                    i28 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = i38.getLayoutParams();
                if (layoutParams6 != null) {
                    i37 = layoutParams6.height;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i28, i37);
            }
            marginLayoutParams2.rightMargin = f17;
            i38.setLayoutParams(marginLayoutParams2);
            QUIListItem.b(this, j().i(), 0, 2, null);
            return;
        }
        if (u16 instanceof c.b.e) {
            ImageView q16 = j().q();
            int f18 = f();
            ViewGroup.LayoutParams layoutParams7 = q16.getLayoutParams();
            if (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams7 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams7;
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams8 = q16.getLayoutParams();
                if (layoutParams8 != null) {
                    i27 = layoutParams8.width;
                } else {
                    i27 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = q16.getLayoutParams();
                if (layoutParams9 != null) {
                    i37 = layoutParams9.height;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i27, i37);
            }
            marginLayoutParams3.rightMargin = f18;
            q16.setLayoutParams(marginLayoutParams3);
            QUIListItem.b(this, j().q(), 0, 2, null);
            return;
        }
        if (u16 instanceof c.b.C9719c) {
            CompoundButton o16 = j().o();
            int f19 = f();
            ViewGroup.LayoutParams layoutParams10 = o16.getLayoutParams();
            if (!(layoutParams10 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams10 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams10;
            if (marginLayoutParams4 == null) {
                ViewGroup.LayoutParams layoutParams11 = o16.getLayoutParams();
                if (layoutParams11 != null) {
                    i26 = layoutParams11.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams12 = o16.getLayoutParams();
                if (layoutParams12 != null) {
                    i37 = layoutParams12.height;
                }
                marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i26, i37);
            }
            marginLayoutParams4.rightMargin = f19;
            o16.setLayoutParams(marginLayoutParams4);
            QUIListItem.b(this, j().o(), 0, 2, null);
            return;
        }
        if (u16 instanceof c.b.d) {
            TextView p16 = j().p();
            int f26 = f();
            ViewGroup.LayoutParams layoutParams13 = p16.getLayoutParams();
            if (!(layoutParams13 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams13 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams13;
            if (marginLayoutParams5 == null) {
                ViewGroup.LayoutParams layoutParams14 = p16.getLayoutParams();
                if (layoutParams14 != null) {
                    i18 = layoutParams14.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams15 = p16.getLayoutParams();
                if (layoutParams15 != null) {
                    i19 = layoutParams15.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            marginLayoutParams5.rightMargin = f26;
            p16.setLayoutParams(marginLayoutParams5);
            QUIListItem.b(this, j().p(), 0, 2, null);
            ImageView f27 = j().f();
            int f28 = f();
            ViewGroup.LayoutParams layoutParams16 = f27.getLayoutParams();
            if (!(layoutParams16 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams16 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams16;
            if (marginLayoutParams6 == null) {
                ViewGroup.LayoutParams layoutParams17 = f27.getLayoutParams();
                if (layoutParams17 != null) {
                    i16 = layoutParams17.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams18 = f27.getLayoutParams();
                if (layoutParams18 != null) {
                    i17 = layoutParams18.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            marginLayoutParams6.rightMargin = f28;
            f27.setLayoutParams(marginLayoutParams6);
            QUIListItem.b(this, j().f(), 0, 2, null);
            View m3 = j().m();
            int f29 = f();
            ViewGroup.LayoutParams layoutParams19 = m3.getLayoutParams();
            if (!(layoutParams19 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams19 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams19;
            if (marginLayoutParams7 == null) {
                ViewGroup.LayoutParams layoutParams20 = m3.getLayoutParams();
                if (layoutParams20 != null) {
                    i3 = layoutParams20.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams21 = m3.getLayoutParams();
                if (layoutParams21 != null) {
                    i37 = layoutParams21.height;
                }
                marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i3, i37);
            }
            marginLayoutParams7.rightMargin = f29;
            m3.setLayoutParams(marginLayoutParams7);
            QUIListItem.b(this, j().m(), 0, 2, null);
            return;
        }
        boolean z16 = u16 instanceof c.b.C9718b;
    }

    private final void o() {
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        c.a r16 = cVar.r();
        if (r16 instanceof c.a.C9716a) {
            c.a.C9716a c9716a = (c.a.C9716a) r16;
            i().k().setText(c9716a.b());
            i().g().setText(c9716a.a());
            q(i().f(), c9716a.c());
            return;
        }
        if (r16 instanceof c.a.C9717c) {
            c.a.C9717c c9717c = (c.a.C9717c) r16;
            i().k().setText(c9717c.b());
            i().g().setText(c9717c.a());
            q(i().j(), c9717c.c());
            return;
        }
        if (r16 instanceof c.a.b) {
            c.a.b bVar = (c.a.b) r16;
            i().k().setText(bVar.b());
            i().g().setText(bVar.a());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.daa);
            v.g(i().i(), dimensionPixelSize, dimensionPixelSize);
            r(i().i(), bVar.c());
            return;
        }
        if (r16 instanceof c.a.d) {
            c.a.d dVar = (c.a.d) r16;
            i().k().setText(dVar.b());
            i().g().setText(dVar.a());
        }
    }

    private final void p() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        g().setOnClickListener(null);
        int i18 = 0;
        g().setClickable(false);
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        c.b u16 = cVar.u();
        boolean z17 = true;
        if (u16 instanceof c.b.a) {
            c.b.a aVar = (c.b.a) u16;
            j().h().setText(aVar.b());
            j().h().setOnClickListener(aVar.c());
            ImageView i19 = j().i();
            if (aVar.e()) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            i19.setVisibility(i17);
            j().i().setOnClickListener(aVar.d());
            Button h16 = j().h();
            if (aVar.b().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && aVar.c() == null) {
                z17 = false;
            }
            if (!z17) {
                i18 = 8;
            }
            h16.setVisibility(i18);
            return;
        }
        if (u16 instanceof c.b.e) {
            ImageView q16 = j().q();
            if (!((c.b.e) u16).c()) {
                i18 = 8;
            }
            q16.setVisibility(i18);
            g().setOnClickListener(new a(u16));
            u16.a(g());
            return;
        }
        if (u16 instanceof c.b.C9719c) {
            j().o().setOnCheckedChangeListener(null);
            c.b.C9719c c9719c = (c.b.C9719c) u16;
            j().o().setChecked(c9719c.c());
            j().o().setEnabled(c9719c.d());
            j().o().setOnCheckedChangeListener(new b(u16));
            u16.a(j().o());
            return;
        }
        if (u16 instanceof c.b.d) {
            ImageView f16 = j().f();
            c.b.d dVar = (c.b.d) u16;
            if (dVar.b()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            f16.setVisibility(i3);
            View m3 = j().m();
            if (dVar.c()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            m3.setVisibility(i16);
            j().p().setText(dVar.d());
            TextView p16 = j().p();
            if (dVar.d().length() <= 0) {
                z17 = false;
            }
            if (!z17) {
                i18 = 8;
            }
            p16.setVisibility(i18);
            l(j().p(), getResources().getDimensionPixelSize(R.dimen.dao));
            return;
        }
        boolean z18 = u16 instanceof c.b.C9718b;
    }

    private final void q(ImageView view, String url) {
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        Function2<ImageView, String, Unit> s16 = cVar.s();
        if (s16 == null || s16.invoke(view, url) == null) {
            v.a(view, url);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void r(ImageView view, String url) {
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        Function2<ImageView, String, Unit> t16 = cVar.t();
        if (t16 == null || t16.invoke(view, url) == null) {
            v.c(view, url);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qui.quilistitem.QUIListItem
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.itemHeight;
    }

    public final void setConfig(@NotNull c.a leftConfig, @NotNull c.b rightConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) leftConfig, (Object) rightConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(leftConfig, "leftConfig");
        Intrinsics.checkNotNullParameter(rightConfig, "rightConfig");
        setConfig(new c<>(leftConfig, rightConfig));
    }

    public /* synthetic */ QUIDoubleLineListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public final void setConfig(@NotNull c<c.a, c.b> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        setThemeId(config.f());
        c.a r16 = config.r();
        c.b u16 = config.u();
        c<c.a, c.b> cVar = this.config;
        if (cVar == null) {
            this.config = config;
            o();
            p();
            m();
            n();
            return;
        }
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(cVar.r().getClass()), Reflection.getOrCreateKotlinClass(r16.getClass()))) {
            c<c.a, c.b> cVar2 = this.config;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            }
            cVar2.x(r16);
            i().e();
            o();
            m();
            i().b();
        } else {
            c<c.a, c.b> cVar3 = this.config;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            }
            cVar3.x(r16);
            o();
        }
        if (this.config == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r5.u().getClass()), Reflection.getOrCreateKotlinClass(u16.getClass()))) {
            c<c.a, c.b> cVar4 = this.config;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            }
            cVar4.y(u16);
            j().e();
            p();
            n();
            j().b();
            return;
        }
        c<c.a, c.b> cVar5 = this.config;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        cVar5.y(u16);
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIDoubleLineListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.da5);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.b(0.01f);
        Unit unit = Unit.INSTANCE;
        linearLayout.setLayoutParams(layoutParams);
        int e16 = e();
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null);
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            int i3 = layoutParams3 != null ? layoutParams3.width : -2;
            ViewGroup.LayoutParams layoutParams4 = linearLayout.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams4 != null ? layoutParams4.height : -2);
        }
        marginLayoutParams.leftMargin = e16;
        linearLayout.setLayoutParams(marginLayoutParams);
        c(linearLayout);
        this.leftTextContainer = linearLayout;
    }
}

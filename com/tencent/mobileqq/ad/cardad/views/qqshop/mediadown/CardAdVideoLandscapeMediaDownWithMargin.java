package com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdVideoViewForQQShop;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B!\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/mediadown/CardAdVideoLandscapeMediaDownWithMargin;", "Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdVideoViewForQQShop;", "", "o", "", "Y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o0", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "z0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdVideoLandscapeMediaDownWithMargin extends CardAdVideoViewForQQShop {
    static IPatchRedirector $redirector_;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/mediadown/CardAdVideoLandscapeMediaDownWithMargin$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdVideoLandscapeMediaDownWithMargin$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdVideoLandscapeMediaDownWithMargin(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.Y();
        TextView t16 = t();
        ViewGroup.LayoutParams layoutParams2 = null;
        if (t16 != null) {
            layoutParams = t16.getLayoutParams();
        } else {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams3 != null) {
            layoutParams3.leftMargin = ViewUtils.dpToPx(12.0f);
        }
        LinearLayout r16 = r();
        if (r16 != null) {
            layoutParams2 = r16.getLayoutParams();
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
        if (layoutParams4 != null) {
            layoutParams4.rightMargin = ViewUtils.dpToPx(12.0f);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e0y;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            GdtUIUtils.setViewRadius(I(), I0(8.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdVideoViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "CardAdVideoLandscapeMediaDownWithMargin";
    }
}

package com.tencent.mobileqq.ad.cardad.views.qqshop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdPicPortraitForQQShop;", "Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdViewForQQShop;", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Y", "f", "o0", "Q0", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "u0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdPicPortraitForQQShop extends CardAdViewForQQShop {
    static IPatchRedirector $redirector_;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdPicPortraitForQQShop$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdPicPortraitForQQShop$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdPicPortraitForQQShop(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop
    public void Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        LinearLayout r16 = r();
        if (r16 != null) {
            r16.setBackgroundColor(Color.parseColor("#0066CC"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.Y();
            p0(G(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdViewForQQShop, com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.f();
        GdtImageData imageData = D().getImageData();
        Drawable drawable = null;
        if (imageData != null) {
            str = imageData.url;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("CardAdPicPortraitForQQShop", 1, "bindData image url is empty");
            return;
        }
        String uri = Uri.parse(str).buildUpon().appendQueryParameter(VasProfileTemplatePreloadHelper.BACKGROUND, "blur").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(adImageUrl).buildU\u2026blur\").build().toString()");
        ImageView w3 = w();
        if (w3 != null) {
            GdtThirdProcessorProxy L0 = L0();
            if (L0 != null) {
                drawable = L0.getPreViewImage(getContext(), uri);
            }
            w3.setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f167688e14;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            GdtUIUtils.setViewRadius(I(), I0(4.0f));
            GdtUIUtils.setViewRadius(r(), I0(4.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CardAdPicPortraitForQQShop";
    }
}

package com.tencent.mobileqq.flock.feedcommon.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/part/c;", "Lcom/tencent/mobileqq/flock/base/b;", "", "coverUrl", "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Ljava/lang/String;", "ratio", "e", "dayBgUrl", "f", "nightBgUrl", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "ivBg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "i", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ratio;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dayBgUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nightBgUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/part/c$a;", "", "", "FEED_DETAIL_HEADER_BG_DAY", "Ljava/lang/String;", "FEED_DETAIL_HEADER_BG_NIGHT", "FEED_LIST_HEADER_BG_DAY", "FEED_LIST_HEADER_BG_NIGHT", "FEED_LIST_RECOMMAND_HEADER_BG_DAY", "FEED_LIST_RECOMMAND_HEADER_BG_NIGHT", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedcommon.part.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ c(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "375:180" : str, (i3 & 2) != 0 ? "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/dazi/9060/qecommerce_dazi_detailpage_bg.png" : str2, (i3 & 4) != 0 ? "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/dazi/9060/qecommerce_dazi_detailpage_bg.png" : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void x9(String coverUrl) {
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        Option preferDecodeFormat = Option.obtain().setUrl(coverUrl).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        ImageView imageView = this.ivBg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBg");
            imageView = null;
        }
        Option requestWidth = preferDecodeFormat.setRequestWidth(imageView.getLayoutParams().width);
        ImageView imageView3 = this.ivBg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBg");
            imageView3 = null;
        }
        Option requestHeight = requestWidth.setRequestHeight(imageView3.getLayoutParams().height);
        ImageView imageView4 = this.ivBg;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBg");
        } else {
            imageView2 = imageView4;
        }
        a16.c(requestHeight.setTargetView(imageView2));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.y0r);
            ImageView onInitView$lambda$2$lambda$1 = (ImageView) findViewById;
            Intrinsics.checkNotNullExpressionValue(onInitView$lambda$2$lambda$1, "onInitView$lambda$2$lambda$1");
            ViewGroup.LayoutParams layoutParams = onInitView$lambda$2$lambda$1.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.dimensionRatio = this.ratio;
                onInitView$lambda$2$lambda$1.setLayoutParams(layoutParams2);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026          }\n            }");
                this.ivBg = onInitView$lambda$2$lambda$1;
                if (QQTheme.isNowThemeIsNight()) {
                    str = this.nightBgUrl;
                } else {
                    str = this.dayBgUrl;
                }
                x9(str);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public c(@NotNull String ratio, @NotNull String dayBgUrl, @NotNull String nightBgUrl) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        Intrinsics.checkNotNullParameter(dayBgUrl, "dayBgUrl");
        Intrinsics.checkNotNullParameter(nightBgUrl, "nightBgUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ratio, dayBgUrl, nightBgUrl);
            return;
        }
        this.ratio = ratio;
        this.dayBgUrl = dayBgUrl;
        this.nightBgUrl = nightBgUrl;
    }
}

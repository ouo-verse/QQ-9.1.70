package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0018\u00100\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001f\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "", "H", "Landroid/widget/TextView;", "titleView", "contentView", "", "businessId", "", "background", "I", "D", UserInfo.SEX_FEMALE, "", "J", "url", "E", "Landroid/content/Context;", "context", "Landroid/view/View;", "l", "B", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "mIvCover", "Landroid/widget/TextView;", "mTvTitle", "K", "mTvContent", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mIvHead", "M", "mIvBussinessIcon", "Landroid/graphics/drawable/ColorDrawable;", "N", "Landroid/graphics/drawable/ColorDrawable;", "mDefultBgDrawable", "P", "mIvIcon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mText", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private CornerImageView mIvCover;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mTvTitle;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView mTvContent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvHead;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvBussinessIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ColorDrawable mDefultBgDrawable;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView mText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/e$a;", "", "", "TAG", "Ljava/lang/String;", "mDefaultBgColor", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.e$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            C();
        }
    }

    private final void D(String background) {
        if (TextUtils.isEmpty(background)) {
            CornerImageView cornerImageView = this.mIvCover;
            if (cornerImageView != null) {
                cornerImageView.setVisibility(8);
                return;
            }
            return;
        }
        if (!J(background)) {
            F(background);
        }
    }

    private final void E(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        URLDrawable b16 = b(url);
        ImageView imageView = this.mIvBussinessIcon;
        if (imageView != null) {
            imageView.setImageDrawable(b16);
        }
    }

    private final void F(String background) {
        if (!TextUtils.isEmpty(background)) {
            try {
                int parseColor = Color.parseColor(background);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(parseColor);
                gradientDrawable.setCornerRadius(j());
                k().setBackgroundDrawable(gradientDrawable);
            } catch (Exception e16) {
                QLog.d("MultiImageBeancurdViewNew", 1, "updateBackgroundIfNeed err: ", e16);
            }
        }
    }

    private final void H(ah message) {
        boolean startsWith$default;
        String replace$default;
        String replace$default2;
        TextView textView;
        try {
            JSONObject jSONObject = new JSONObject(message.l2());
            String optString = jSONObject.optString("icon");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"icon\")");
            if (!TextUtils.isEmpty(optString)) {
                Drawable apngDrawable = ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getApngDrawable(optString);
                ImageView imageView = this.mIvIcon;
                if (imageView != null) {
                    imageView.setImageDrawable(apngDrawable);
                }
            }
            String optString2 = jSONObject.optString("desc1");
            Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"desc1\")");
            TextView textView2 = this.mText;
            if (textView2 != null) {
                textView2.setText(optString2);
            }
            String string = jSONObject.getString("desc1_color");
            Intrinsics.checkNotNullExpressionValue(string, "data.getString(\"desc1_color\")");
            if (!TextUtils.isEmpty(string) && (textView = this.mText) != null) {
                textView.setTextColor(Color.parseColor(string));
            }
            String iconBgColor = jSONObject.optString("icon_bg_color");
            if (!TextUtils.isEmpty(iconBgColor)) {
                Intrinsics.checkNotNullExpressionValue(iconBgColor, "iconBgColor");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(iconBgColor, "#", false, 2, null);
                if (!startsWith$default) {
                    iconBgColor = "#" + iconBgColor;
                }
                String iconBgColor2 = iconBgColor;
                Intrinsics.checkNotNullExpressionValue(iconBgColor2, "iconBgColor");
                replace$default = StringsKt__StringsJVMKt.replace$default(iconBgColor2, "#", "#7F", false, 4, (Object) null);
                Intrinsics.checkNotNullExpressionValue(iconBgColor2, "iconBgColor");
                replace$default2 = StringsKt__StringsJVMKt.replace$default(iconBgColor2, "#", "#4C", false, 4, (Object) null);
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(replace$default), Color.parseColor(replace$default2)});
                ImageView imageView2 = this.mIvIcon;
                if (imageView2 != null) {
                    imageView2.setBackground(gradientDrawable);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("MultiImageBeancurdViewNew", 2, "updateIconIfNeed e : " + e16);
            }
        }
    }

    private final void I(TextView titleView, TextView contentView, long businessId, String background) {
        if (businessId != 1 || background == null) {
            return;
        }
        CharSequence text = contentView.getText();
        if (!(text instanceof SpannedString)) {
            return;
        }
        Object[] spans = ((Spanned) text).getSpans(0, text.length() - 1, Object.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : spans) {
            if (!(obj instanceof ForegroundColorSpan)) {
                return;
            }
            int foregroundColor = ((ForegroundColorSpan) obj).getForegroundColor();
            int backgroundTextColor = ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getBackgroundTextColor(businessId, background, foregroundColor);
            if (foregroundColor != backgroundTextColor) {
                if (QLog.isColorLevel()) {
                    QLog.i("MultiImageBeancurdViewNew", 1, "BusinessId[" + businessId + "] Background[" + background + "] TextColor = [" + Color.red(backgroundTextColor) + "," + Color.green(backgroundTextColor) + "," + Color.blue(backgroundTextColor) + "]");
                }
                z16 = true;
                i3 = backgroundTextColor;
            }
        }
        if (z16) {
            titleView.setTextColor(i3);
            contentView.setText(new SpannableStringBuilder().append(text, new ForegroundColorSpan(i3), 33));
        }
    }

    private final boolean J(String background) {
        boolean endsWith$default;
        if (!URLUtil.isHttpsUrl(background) && !URLUtil.isHttpUrl(background)) {
            if (QLog.isColorLevel()) {
                QLog.i("MultiImageBeancurdViewNew", 2, "background is not web url : " + background);
            }
            return false;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = this.mDefultBgDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        String path = new URL(background).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URL(background).path");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ".png", false, 2, null);
        if (endsWith$default) {
            obtain.mUseApngImage = true;
        }
        URLDrawable drawable = URLDrawable.getDrawable(background, obtain);
        CornerImageView cornerImageView = this.mIvCover;
        if (cornerImageView != null) {
            cornerImageView.setImageDrawable(drawable);
        }
        CornerImageView cornerImageView2 = this.mIvCover;
        if (cornerImageView2 != null) {
            cornerImageView2.setRadius(j());
        }
        CornerImageView cornerImageView3 = this.mIvCover;
        if (cornerImageView3 != null) {
            cornerImageView3.setVisibility(0);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        G(message);
        return d();
    }

    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View findViewById = k().findViewById(R.id.duw);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.CornerImageView");
        this.mIvCover = (CornerImageView) findViewById;
        View findViewById2 = k().findViewById(R.id.f10625688);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvTitle = (TextView) findViewById2;
        View findViewById3 = k().findViewById(R.id.f10623686);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvContent = (TextView) findViewById3;
        View findViewById4 = k().findViewById(R.id.dvn);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mIvHead = (ImageView) findViewById4;
        View findViewById5 = k().findViewById(R.id.f165913y11);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.mIvBussinessIcon = (ImageView) findViewById5;
        this.mIvIcon = (ImageView) k().findViewById(R.id.f165914y12);
        this.mText = (TextView) k().findViewById(R.id.f10624687);
    }

    protected void G(@NotNull ah message) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) message);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        List<String> v26 = message.v2();
        if (v26 != null) {
            Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
            z((BaseQQAppInterface) waitAppRuntime, this.mIvHead, v26.get(0));
        }
        TextView textView2 = this.mTvTitle;
        if (textView2 != null) {
            A(textView2, message.p2());
        }
        TextView textView3 = this.mTvContent;
        if (textView3 != null) {
            y(textView3, message.o2());
        }
        TextView textView4 = this.mTvTitle;
        if (textView4 != null && (textView = this.mTvContent) != null) {
            I(textView4, textView, message.n2(), message.j2());
        }
        E(message.getIcon());
        D(message.j2());
        H(message);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.hc8, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026rd_dress_up_layout, null)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    public void n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.n(context);
        this.mDefultBgDrawable = new ColorDrawable(Color.parseColor("#F1F2F8"));
    }
}

package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b5\u00106J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0014J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u001a\u001a\u00020\tH\u0014J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J \u0010\"\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00022\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010 H\u0014R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/k;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "Landroid/widget/TextView;", "titleView", "contentView", "", "businessId", "", "background", "", "H", "D", UserInfo.SEX_FEMALE, "", "I", "url", "E", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "Landroid/view/View;", "B", "Landroid/content/Context;", "context", "l", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "o", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "titleContent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tvContent", "", "contentList", "y", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "mIvCover", "J", "Landroid/widget/TextView;", "mTvTitle", "K", "mTvContent", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mIvHead", "M", "mIvBussinessIcon", "Landroid/graphics/drawable/ColorDrawable;", "N", "Landroid/graphics/drawable/ColorDrawable;", "mBgLoadingDrawable", "<init>", "(Landroid/content/Context;)V", "P", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
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
    private ColorDrawable mBgLoadingDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.k$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63788);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Context context) {
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
        if (!I(background)) {
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
                QLog.d("WithBgTextBeancurdView", 1, "updateBackgroundIfNeed err: ", e16);
            }
        }
    }

    private final void H(TextView titleView, TextView contentView, long businessId, String background) {
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
                    QLog.i("WithBgTextBeancurdView", 1, "BusinessId[" + businessId + "] Background[" + background + "] TextColor = [" + Color.red(backgroundTextColor) + "," + Color.green(backgroundTextColor) + "," + Color.blue(backgroundTextColor) + "]");
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

    private final boolean I(String background) {
        boolean endsWith$default;
        if (!URLUtil.isHttpsUrl(background) && !URLUtil.isHttpUrl(background)) {
            if (QLog.isColorLevel()) {
                QLog.i("WithBgTextBeancurdView", 2, "background is not web url : " + background);
            }
            return false;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = this.mBgLoadingDrawable;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    public void A(@NotNull TextView titleView, @Nullable TofuContent titleContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) titleView, (Object) titleContent);
            return;
        }
        Intrinsics.checkNotNullParameter(titleView, "titleView");
        if (titleContent == null) {
            QLog.d("WithBgTextBeancurdView", 1, "updateTitle err: titleContent is null");
        } else {
            titleView.setText(titleContent.title);
            titleView.setTextColor(f());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
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
    }

    protected void G(@NotNull ah message) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message);
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
            H(textView4, textView, message.n2(), message.j2());
        }
        E(message.getIcon());
        D(message.j2());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fq5, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ncurd_image_layout, null)");
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
        r(context.getResources().getColor(R.color.qui_common_bubble_guest_text_secondary));
        s(context.getResources().getColor(R.color.qui_common_bubble_guest_text_primary));
        this.mBgLoadingDrawable = new ColorDrawable(context.getResources().getColor(R.color.qui_common_bubble_guest));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            k().setBackgroundResource(R.drawable.qui_qq_beancurd_default_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    public void y(@NotNull TextView tvContent, @Nullable List<TofuContent> contentList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tvContent, (Object) contentList);
            return;
        }
        Intrinsics.checkNotNullParameter(tvContent, "tvContent");
        if (contentList != null && !contentList.isEmpty()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<TofuContent> it = contentList.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append(it.next().title, new ForegroundColorSpan(g()), 33);
            }
            tvContent.setText(spannableStringBuilder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WithBgTextBeancurdView", 2, "update content failed, contentList is null");
        }
    }
}

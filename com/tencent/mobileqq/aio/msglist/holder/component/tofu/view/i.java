package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", "url", "", "D", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "Landroid/view/View;", "B", "Landroid/content/Context;", "context", "l", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "o", "E", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "titleContent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tvContent", "", "contentList", "y", "I", "Landroid/widget/TextView;", "mTvTitle", "J", "mTvContent", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "mIvHead", "L", "mIvBussinessIcon", "<init>", "(Landroid/content/Context;)V", "M", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class i extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mTvTitle;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mTvContent;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvHead;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvBussinessIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            C();
        }
    }

    private final void D(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        URLDrawable b16 = b(url);
        ImageView imageView = this.mIvBussinessIcon;
        if (imageView != null) {
            imageView.setImageDrawable(b16);
        }
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
            QLog.d("TextBeancurdView", 1, "updateTitle err: titleContent is null");
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
        E(message);
        return d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View findViewById = k().findViewById(R.id.f10625688);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvTitle = (TextView) findViewById;
        View findViewById2 = k().findViewById(R.id.f10623686);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvContent = (TextView) findViewById2;
        View findViewById3 = k().findViewById(R.id.dvn);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.mIvHead = (ImageView) findViewById3;
        View findViewById4 = k().findViewById(R.id.f165913y11);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mIvBussinessIcon = (ImageView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(@NotNull ah message) {
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
        TextView textView = this.mTvTitle;
        if (textView != null) {
            A(textView, message.p2());
        }
        TextView textView2 = this.mTvContent;
        if (textView2 != null) {
            y(textView2, message.o2());
        }
        D(message.getIcon());
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
                spannableStringBuilder.append(new QQText(it.next().title, 3, 16), new ForegroundColorSpan(g()), 33);
            }
            tvContent.setText(spannableStringBuilder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TextBeancurdView", 2, "update content failed, contentList is null");
        }
    }
}

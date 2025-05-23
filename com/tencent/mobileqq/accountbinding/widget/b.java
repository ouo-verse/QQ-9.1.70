package com.tencent.mobileqq.accountbinding.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.e;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b&\u0010'J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\r\u0010!R\u0017\u0010%\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/widget/b;", "", "", "isBound", "", "titleStr", "headUrl", "", "b", "Lcom/tencent/mobileqq/accountbinding/data/b;", "info", "d", "Landroid/view/View;", "a", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/tencent/mobileqq/widget/RoundImageView;", "Lcom/tencent/mobileqq/widget/RoundImageView;", "getIcon", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "icon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", QQWinkConstants.TAB_SUBTITLE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "f", "getDesc", "desc", "<init>", "(Landroid/view/View;)V", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundImageView icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView subTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIButton button;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/widget/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.accountbinding.widget.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.view = view;
        View findViewById = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.icon)");
        this.icon = (RoundImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.title = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f166931j64);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.sub_title)");
        this.subTitle = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.ama);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.button)");
        this.button = (QUIButton) findViewById4;
        View findViewById5 = view.findViewById(R.id.bg6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.desc)");
        TextView textView = (TextView) findViewById5;
        this.desc = textView;
        textView.setText(HardCodeUtil.qqStr(R.string.f200844t8));
        String c16 = e.c();
        String b16 = e.b();
        if (c16 != null && c16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        b(true ^ z16, c16, b16);
    }

    private final void b(boolean isBound, String titleStr, String headUrl) {
        boolean z16;
        QLog.d("ThirdAppBindingViewHolder", 4, "update isBound: " + isBound + ", titleStr: " + titleStr + ", headUrl: " + headUrl);
        if (isBound) {
            if (headUrl != null && headUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.icon.setmRadius(ViewUtils.dip2px(4.0f), false);
                Drawable drawable = this.icon.getContext().getDrawable(R.drawable.nf6);
                Option option = Option.obtain().setTargetView(this.icon).setUrl(headUrl).setLoadingDrawable(drawable).setFailDrawable(drawable);
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, null);
            } else {
                this.icon.setmRadius(0, false);
                this.icon.setImageResource(R.drawable.nf6);
            }
            this.title.setText(titleStr);
            this.subTitle.setText("\u5fae\u4fe1\u8d26\u53f7");
            this.button.setText(HardCodeUtil.qqStr(R.string.f200754sz));
            return;
        }
        this.icon.setmRadius(0, false);
        this.icon.setImageResource(R.drawable.nf7);
        this.title.setText("\u5fae\u4fe1");
        this.subTitle.setText("\u672a\u7ed1\u5b9a");
        this.button.setText(HardCodeUtil.qqStr(R.string.f200804t4));
    }

    static /* synthetic */ void c(b bVar, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        bVar.b(z16, str, str2);
    }

    @NotNull
    public final QUIButton a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUIButton) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.button;
    }

    public final void d(@NotNull com.tencent.mobileqq.accountbinding.data.b info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.g()) {
            b(true, info.e(), info.d());
        } else {
            c(this, false, null, null, 6, null);
        }
    }
}

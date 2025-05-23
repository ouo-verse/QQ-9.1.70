package com.tencent.mobileqq.identification;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.tencent.could.huiyansdk.api.HuiYanAuthEventCallBack;
import com.tencent.could.huiyansdk.enums.HuiYanAuthEvent;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/identification/n;", "Lcom/tencent/could/huiyansdk/api/HuiYanAuthEventCallBack;", "", "c", "Lcom/tencent/could/huiyansdk/enums/HuiYanAuthTipsEvent;", "p0", "onAuthTipsEvent", "Lcom/tencent/could/huiyansdk/enums/HuiYanAuthEvent;", "onAuthEvent", "Landroid/view/View;", "view", "onMainViewCreate", "onMainViewDestroy", "", "a", "Ljava/lang/String;", "customWording", "b", "Landroid/view/View;", "customLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textTitle", "d", "textContent", "<init>", "(Ljava/lang/String;)V", "e", "qqconnectface-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class n implements HuiYanAuthEventCallBack {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static final int f237981f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f237982g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f237983h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f237984i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String customWording;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View customLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/identification/n$a;", "", "", "CONTENT_TEXT_MAX_SIZE", "I", "CONTENT_TEXT_MIN_SIZE", "", "TAG", "Ljava/lang/String;", "TITLE_TEXT_MAX_SIZE", "TITLE_TEXT_MIN_SIZE", "<init>", "()V", "qqconnectface-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.identification.n$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        f237981f = 24;
        f237982g = 14;
        f237983h = 16;
        f237984i = 12;
    }

    public n(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.customWording = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(n this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.text.Spanned] */
    private final void c() {
        boolean z16;
        List split;
        boolean z17;
        boolean z18;
        if (this.textTitle != null && this.textContent != null) {
            String str = this.customWording;
            boolean z19 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            String str2 = null;
            if (!z16) {
                split = StringsKt__StringsKt.split((CharSequence) this.customWording, new String[]{"\n"}, true, 2);
                QLog.d("IdentificationCustomUIHandler", 4, "split size: " + split.size() + TokenParser.SP + split);
                String str3 = (String) split.get(0);
                View view = this.customLayout;
                if (view != null) {
                    view.setVisibility(0);
                }
                TextView textView = this.textTitle;
                if (textView != null) {
                    if (str3.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        CharSequence fromHtml = Html.fromHtml(str3);
                        if (fromHtml == null) {
                            fromHtml = str3;
                        }
                        textView.setText(fromHtml);
                        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, f237982g, f237981f, 1, 2);
                    }
                }
                TextView textView2 = this.textContent;
                if (textView2 != null) {
                    if (split.size() > 1) {
                        str2 = (String) split.get(1);
                    }
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            z19 = true;
                        }
                    }
                    if (z19) {
                        ?? fromHtml2 = Html.fromHtml(str2);
                        if (fromHtml2 != 0) {
                            str3 = fromHtml2;
                        }
                        textView2.setText(str3);
                        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView2, f237984i, f237983h, 1, 2);
                        return;
                    }
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            QLog.e("IdentificationCustomUIHandler", 1, "updateCustomTipsView failed, customWording is empty ");
            View view2 = this.customLayout;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            TextView textView3 = this.textTitle;
            if (textView3 != null) {
                textView3.setText((CharSequence) null);
            }
            TextView textView4 = this.textContent;
            if (textView4 != null) {
                textView4.setText((CharSequence) null);
                return;
            }
            return;
        }
        QLog.e("IdentificationCustomUIHandler", 1, "updateCustomWording view is null");
    }

    @Override // com.tencent.could.huiyansdk.api.HuiYanAuthEventCallBack
    public void onAuthEvent(@Nullable HuiYanAuthEvent p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
        } else {
            QLog.i("IdentificationCustomUIHandler", 4, "onAuthEvent");
        }
    }

    @Override // com.tencent.could.huiyansdk.api.HuiYanAuthEventCallBack
    public void onAuthTipsEvent(@Nullable HuiYanAuthTipsEvent p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
        } else {
            QLog.i("IdentificationCustomUIHandler", 4, "onAuthTipsEvent");
        }
    }

    @Override // com.tencent.could.huiyansdk.api.HuiYanAuthEventCallBack
    public void onMainViewCreate(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        QLog.i("IdentificationCustomUIHandler", 1, "onMainViewCreate");
        if (view == null) {
            QLog.e("IdentificationCustomUIHandler", 1, "onMainViewCreate failed, p0 is null ");
            return;
        }
        this.customLayout = view.findViewById(R.id.xh7);
        this.textTitle = (TextView) view.findViewById(R.id.xh8);
        this.textContent = (TextView) view.findViewById(R.id.xh6);
        QLog.i("IdentificationCustomUIHandler", 1, "onMainViewCreate title: " + this.textTitle + ", content: " + this.textContent);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.identification.m
            @Override // java.lang.Runnable
            public final void run() {
                n.b(n.this);
            }
        });
    }

    @Override // com.tencent.could.huiyansdk.api.HuiYanAuthEventCallBack
    public void onMainViewDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.i("IdentificationCustomUIHandler", 1, "onMainViewDestroy");
        }
    }
}

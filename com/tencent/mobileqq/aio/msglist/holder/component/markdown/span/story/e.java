package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.story;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0003B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/e;", "", "Landroid/view/View;", "a", "b", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/c;", "getParseResult", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/c;", "parseResult", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "getMsgItemCallback", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "msgItemCallback", "d", "Landroid/view/View;", "view", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/c;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;)V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c parseResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a msgItemCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/story/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.story.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61594);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull Context context, @NotNull c parseResult, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a msgItemCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parseResult, "parseResult");
        Intrinsics.checkNotNullParameter(msgItemCallback, "msgItemCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, parseResult, msgItemCallback);
            return;
        }
        this.context = context;
        this.parseResult = parseResult;
        this.msgItemCallback = msgItemCallback;
        this.view = a();
    }

    private final View a() {
        a a16 = this.parseResult.a();
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setText(a16.b());
        textView.setTextSize(17.0f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_bubble_guest_text_primary));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ViewUtils.dip2px(4.0f);
        textView2.setLayoutParams(layoutParams);
        textView2.setText(a16.a());
        textView2.setTextSize(14.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView2.setLineHeight(ViewUtils.dip2px(20.0f));
        }
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qui_common_bubble_guest_text_primary));
        linearLayout.addView(textView2);
        return linearLayout;
    }

    @NotNull
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.view;
    }
}

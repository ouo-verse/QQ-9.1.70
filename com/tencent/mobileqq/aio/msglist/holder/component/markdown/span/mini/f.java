package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FoldableTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/f;", "", "Landroid/view/View;", "c", "Lcom/tencent/widget/FoldableTextView;", "miniProfileDesc", "", "f", "e", "g", "b", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/d;", "getParseResult", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/d;", "parseResult", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "getMsgItemCallback", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "msgItemCallback", "", "d", "I", "iconAlign", "Landroid/view/View;", "miniProfileView", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/d;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d parseResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a msgItemCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int iconAlign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View miniProfileView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull Context context, @NotNull d parseResult, @NotNull a msgItemCallback) {
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
        this.iconAlign = Build.VERSION.SDK_INT >= 29 ? 2 : 1;
        this.miniProfileView = c();
    }

    private final View c() {
        b a16 = this.parseResult.a();
        p g16 = p.g(LayoutInflater.from(this.context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        g16.f444873g.setText(a16.e());
        TextView textView = g16.f444873g;
        Boolean valueOf = Boolean.valueOf(TextUtils.isEmpty(a16.e()));
        textView.setVisibility(8);
        if (((View) au.a(valueOf, textView)) == null) {
            textView.setVisibility(0);
        }
        g16.f444868b.setText(a16.a());
        FoldableTextView foldableTextView = g16.f444868b;
        Boolean valueOf2 = Boolean.valueOf(TextUtils.isEmpty(a16.a()));
        foldableTextView.setVisibility(8);
        if (((View) au.a(valueOf2, foldableTextView)) == null) {
            foldableTextView.setVisibility(0);
        }
        g16.f444869c.setText(a16.b());
        TextView textView2 = g16.f444869c;
        Boolean valueOf3 = Boolean.valueOf(TextUtils.isEmpty(a16.b()));
        textView2.setVisibility(8);
        if (((View) au.a(valueOf3, textView2)) == null) {
            textView2.setVisibility(0);
        }
        LinearLayout linearLayout = g16.f444872f;
        Boolean valueOf4 = Boolean.valueOf(TextUtils.isEmpty(a16.b()));
        linearLayout.setVisibility(8);
        if (((View) au.a(valueOf4, linearLayout)) == null) {
            linearLayout.setVisibility(0);
        }
        g16.f444870d.setText(a16.c());
        TextView textView3 = g16.f444870d;
        Boolean valueOf5 = Boolean.valueOf(TextUtils.isEmpty(a16.c()));
        textView3.setVisibility(8);
        if (((View) au.a(valueOf5, textView3)) == null) {
            textView3.setVisibility(0);
        }
        g16.f444871e.setText(a16.d());
        TextView textView4 = g16.f444871e;
        Boolean valueOf6 = Boolean.valueOf(TextUtils.isEmpty(a16.d()));
        textView4.setVisibility(8);
        if (((View) au.a(valueOf6, textView4)) == null) {
            textView4.setVisibility(0);
        }
        FoldableTextView foldableTextView2 = g16.f444868b;
        Intrinsics.checkNotNullExpressionValue(foldableTextView2, "binding.miniProfileDesc");
        f(foldableTextView2);
        b();
        LinearLayout root = g16.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.d(f.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(root, "binding.root.apply {\n   \u2026)\n            }\n        }");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f(FoldableTextView miniProfileDesc) {
        int dip2px = ViewUtils.dip2px(16.0f);
        SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.zp9));
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_down_icon_secondary);
        if (drawable != null) {
            drawable.setBounds(0, 0, dip2px, dip2px);
            spannableString.setSpan(new ImageSpan(drawable, this.iconAlign), 0, spannableString.length(), 33);
        }
        SpannableString spannableString2 = new SpannableString(HardCodeUtil.qqStr(R.string.zp_));
        Drawable drawable2 = ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_up_icon_secondary_01);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, dip2px, dip2px);
            spannableString2.setSpan(new ImageSpan(drawable2, this.iconAlign), 0, spannableString2.length(), 33);
        }
        miniProfileDesc.setFoldStateText(spannableString);
        miniProfileDesc.setExpandStateText(spannableString2);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("MiniProfileViewWrapper", 1, "bind isReported=" + this.msgItemCallback.b() + ", busiId=" + this.msgItemCallback.a() + " ");
        if (!this.msgItemCallback.b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", this.msgItemCallback.a());
            com.tencent.mobileqq.aio.utils.b.q("em_bas_mini_data_card", hashMap);
        }
    }

    @NotNull
    public final View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.miniProfileView;
    }

    public final void g() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View findViewById = this.miniProfileView.findViewById(R.id.z_8);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.widget.FoldableTextView");
        FoldableTextView foldableTextView = (FoldableTextView) findViewById;
        if (!foldableTextView.f()) {
            QLog.d("MiniProfileViewWrapper", 1, "onClick not Support Expand");
            return;
        }
        foldableTextView.b();
        String a16 = this.msgItemCallback.a();
        int c16 = foldableTextView.c();
        QLog.d("MiniProfileViewWrapper", 1, "onClick FoldStatus=" + c16 + ", tag=" + a16);
        HashMap hashMap = new HashMap();
        if (c16 == 1) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("after_click_state", str);
        hashMap.put("buss_id", a16);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_mini_data_card", hashMap);
        this.miniProfileView.requestLayout();
        this.miniProfileView.invalidate();
    }
}

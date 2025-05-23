package com.tencent.mobileqq.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.utils.n;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b\u001c\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rR\"\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/webview/view/WebBrowserViewContainerKt;", "Landroid/widget/RelativeLayout;", "Landroid/widget/FrameLayout;", "frameLayout", "", "g", h.F, "relativeLayout", "i", "f", "Landroid/widget/ProgressBar;", "b", "c", "", "withRefresh", "d", "e", "(Landroid/widget/FrameLayout;)V", "isFromQzoneGame", "a", "Z", "getInit", "()Z", "setInit", "(Z)V", "init", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WebBrowserViewContainerKt extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean init;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBrowserViewContainerKt(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            setBackgroundResource(n.token_background_content_bg);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    private final void f(FrameLayout frameLayout) {
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setId(R.id.aea);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 49;
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(linearLayout.getContext());
        textView.setId(R.id.aeb);
        textView.setGravity(17);
        textView.setText("");
        int i3 = n.token_color_content_text;
        textView.setTextColor(b.b(i3));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = b.e(20);
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setId(R.id.jbx);
        textView2.setVisibility(8);
        textView2.setText("QQ\u6d4f\u89c8\u5668X5\u5185\u6838\u63d0\u4f9b\u6280\u672f\u652f\u6301");
        textView2.setTextColor(b.b(i3));
        textView2.setPadding(b.e(2), 0, b.e(2), 0);
        textView2.setCompoundDrawablePadding(b.e(2));
        try {
            textView2.setCompoundDrawables(b.c(n.browser_icon_with_token_color), null, null, null);
        } catch (Throwable th5) {
            QLog.d("WebBrowserViewContainerKt", 1, "initBrowserTipsLayout ex:" + th5.getMessage(), th5);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = b.e(8);
        layoutParams3.gravity = 1;
        textView2.setLayoutParams(layoutParams3);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    private final void g(FrameLayout frameLayout) {
        RelativeLayout refreshView = new RefreshView(frameLayout.getContext());
        refreshView.setId(R.id.l2a);
        refreshView.setMinimumHeight(b.e(50));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        refreshView.setLayoutParams(layoutParams);
        frameLayout.addView(refreshView);
        i(refreshView);
    }

    private final void h(FrameLayout frameLayout) {
        RelativeLayout relativeLayout = new RelativeLayout(frameLayout.getContext());
        relativeLayout.setId(R.id.l2a);
        relativeLayout.setMinimumHeight(b.e(50));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        relativeLayout.setLayoutParams(layoutParams);
        frameLayout.addView(relativeLayout);
        i(relativeLayout);
    }

    private final void i(RelativeLayout relativeLayout) {
        View view = new View(relativeLayout.getContext());
        view.setId(R.id.enc);
        view.setVisibility(8);
        view.setBackgroundColor(1996488704);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(view);
        View webViewProgressBar = new WebViewProgressBar(relativeLayout.getContext());
        webViewProgressBar.setId(R.id.g1p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, b.e(3));
        layoutParams.addRule(10);
        webViewProgressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(webViewProgressBar);
    }

    public final void a(boolean isFromQzoneGame) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isFromQzoneGame);
            return;
        }
        if (isFromQzoneGame) {
            i3 = R.layout.a3u;
        } else {
            i3 = R.layout.a3t;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null);
        inflate.setId(R.id.cda);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(inflate);
    }

    @NotNull
    public final ProgressBar b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ProgressBar) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View findViewById = findViewById(R.id.i5n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.refresh_progress)");
        return (ProgressBar) findViewById;
    }

    @NotNull
    public final FrameLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        View findViewById = findViewById(R.id.cq6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.fullscreen_webview_content)");
        return (FrameLayout) findViewById;
    }

    public final void d(boolean withRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, withRefresh);
            return;
        }
        if (!this.init) {
            this.init = true;
            setId(R.id.ae8);
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setId(R.id.cq6);
            frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            View frameLayout2 = new FrameLayout(frameLayout.getContext());
            frameLayout2.setId(R.id.f164351sq);
            frameLayout2.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            frameLayout2.setLayoutParams(layoutParams);
            frameLayout.addView(frameLayout2);
            if (withRefresh) {
                f(frameLayout);
                g(frameLayout);
            } else {
                h(frameLayout);
            }
            e(frameLayout);
            addView(frameLayout);
            ProgressBar progressBar = new ProgressBar(getContext());
            progressBar.setId(R.id.i5n);
            progressBar.setVisibility(8);
            progressBar.setIndeterminate(true);
            progressBar.setIndeterminateDrawable(b.c(R.drawable.common_loading6));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b.e(23), b.e(23));
            layoutParams2.topMargin = b.e(-25);
            layoutParams2.addRule(13);
            progressBar.setLayoutParams(layoutParams2);
            addView(progressBar);
        }
    }

    public final void e(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameLayout);
            return;
        }
        Intrinsics.checkNotNullParameter(frameLayout, "frameLayout");
        ViewStub viewStub = new ViewStub(frameLayout.getContext());
        viewStub.setId(R.id.ad6);
        viewStub.setLayoutResource(R.layout.f168544a15);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        viewStub.setLayoutParams(layoutParams);
        frameLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(frameLayout.getContext());
        viewStub2.setId(R.id.f164623vx);
        viewStub2.setLayoutResource(R.layout.a7y);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        viewStub2.setLayoutParams(layoutParams2);
        frameLayout.addView(viewStub2);
        ViewStub viewStub3 = new ViewStub(frameLayout.getContext());
        viewStub3.setId(R.id.vax);
        viewStub3.setLayoutResource(R.layout.f168545fv0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, b.e(44));
        layoutParams3.gravity = 53;
        layoutParams3.topMargin = ImmersiveUtils.getStatusBarHeight(viewStub3.getContext());
        viewStub3.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub3);
    }

    public final void setInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.init = z16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBrowserViewContainerKt(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setBackgroundResource(n.token_background_content_bg);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebBrowserViewContainerKt(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            setBackgroundResource(n.token_background_content_bg);
        } else {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

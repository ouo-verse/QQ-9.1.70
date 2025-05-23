package com.tencent.mobileqq.webview.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/webview/view/a;", "", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/webview/view/a$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/PullRefreshHeader;", "a", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final PullRefreshHeader a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PullRefreshHeader) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            PullRefreshHeader pullRefreshHeader = new PullRefreshHeader(context, null);
            View relativeLayout = new RelativeLayout(pullRefreshHeader.getContext());
            relativeLayout.setVisibility(8);
            relativeLayout.setId(R.id.lts);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            pullRefreshHeader.addView(relativeLayout);
            RelativeLayout relativeLayout2 = new RelativeLayout(pullRefreshHeader.getContext());
            relativeLayout2.setVisibility(8);
            relativeLayout2.setId(R.id.i5j);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, b.e(50)));
            LinearLayout linearLayout = new LinearLayout(relativeLayout2.getContext());
            linearLayout.setId(R.id.g5l);
            linearLayout.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            TextView textView = new TextView(linearLayout.getContext());
            textView.setId(R.id.i5m);
            textView.setText(R.string.hqh);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(b.b(R.color.skin_gray2_theme_version2));
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            textView.setLayoutParams(layoutParams2);
            linearLayout.addView(textView);
            TextView textView2 = new TextView(linearLayout.getContext());
            textView2.setId(R.id.i5q);
            textView2.setText(R.string.hqh);
            textView2.setTextSize(1, 13.0f);
            textView2.setTextColor(b.b(R.color.skin_gray2_theme_version2));
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = b.e(2);
            textView2.setLayoutParams(layoutParams3);
            linearLayout.addView(textView2);
            relativeLayout2.addView(linearLayout);
            FrameLayout frameLayout = new FrameLayout(relativeLayout2.getContext());
            frameLayout.setId(R.id.dmy);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(b.e(33), b.e(33));
            layoutParams4.addRule(15);
            layoutParams4.addRule(0, R.id.g5l);
            layoutParams4.rightMargin = b.e(8);
            frameLayout.setLayoutParams(layoutParams4);
            ProgressBar progressBar = new ProgressBar(frameLayout.getContext());
            progressBar.setId(R.id.i5n);
            progressBar.setVisibility(4);
            progressBar.setIndeterminate(true);
            progressBar.setIndeterminateDrawable(b.c(R.drawable.common_loading6));
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(b.e(18), b.e(18));
            layoutParams5.gravity = 17;
            progressBar.setLayoutParams(layoutParams5);
            frameLayout.addView(progressBar);
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setId(R.id.i5l);
            imageView.setContentDescription(b.f(R.string.image));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(R.drawable.refresh_arrow);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams6.gravity = 17;
            imageView.setLayoutParams(layoutParams6);
            frameLayout.addView(imageView);
            relativeLayout2.addView(frameLayout);
            pullRefreshHeader.addView(relativeLayout2);
            pullRefreshHeader.e();
            return pullRefreshHeader;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmStatic
    @NotNull
    public static final PullRefreshHeader a(@NotNull Context context) {
        return INSTANCE.a(context);
    }
}

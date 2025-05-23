package jy2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J0\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004R\u0015\u0010!\u001a\u00020\u0004*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Ljy2/f;", "", "Landroid/view/View;", "touchView", "", "top", "bottom", "left", "right", "", "e", "c", "Landroid/widget/ImageView;", "imageView", "", "imageUrl", "j", "Landroid/content/Context;", "context", "url", "i", "Lcom/tencent/biz/pubaccount/CustomWebView;", "webView", "b", tl.h.F, "", "cornerRadius", "color", "Landroid/graphics/drawable/GradientDrawable;", "g", "", "f", "(Ljava/lang/Number;)I", "dp", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f411169a = new f();

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, int i3, int i16, int i17, int i18, View parent) {
        Intrinsics.checkNotNullParameter(parent, "$parent");
        Rect rect = new Rect();
        view.setEnabled(true);
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i16;
        rect.left -= i17;
        rect.right += i18;
        parent.setTouchDelegate(new TouchDelegate(rect, view));
    }

    public final void b(@Nullable CustomWebView webView) {
        if (webView == null) {
            return;
        }
        try {
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(webView);
            }
            QLog.d("TVideoUIUtils", 4, "destroyWebView " + webView.hashCode());
            webView.clearView();
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.destroy();
        } catch (Exception e16) {
            QLog.d("TVideoUIUtils", 4, "destroyWebView Exception " + e16);
        }
    }

    public final void c(@Nullable final View touchView, final int top, final int bottom, final int left, final int right) {
        View view;
        if (touchView != null && touchView.getParent() != null) {
            Object parent = touchView.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view != null) {
                final View view2 = view;
                view.post(new Runnable() { // from class: jy2.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.d(touchView, top, bottom, left, right, view2);
                    }
                });
            }
        }
    }

    public final void e(@Nullable View touchView, int top, int bottom, int left, int right) {
        c(touchView, f(Integer.valueOf(top)), f(Integer.valueOf(bottom)), f(Integer.valueOf(left)), f(Integer.valueOf(right)));
    }

    public final int f(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return (int) TypedValue.applyDimension(1, number.floatValue(), Resources.getSystem().getDisplayMetrics());
    }

    @NotNull
    public final GradientDrawable g(float cornerRadius, int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(cornerRadius);
        return gradientDrawable;
    }

    public final void h(@Nullable CustomWebView webView) {
        if (webView == null) {
            return;
        }
        webView.setVisibility(8);
        webView.setTag("view_never_show_tag");
        webView.loadUrl("about:blank");
    }

    public final void i(@Nullable Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", url).putExtra("bFormatUrl", false);
        context.startActivity(intent);
    }

    public final void j(@Nullable ImageView imageView, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        if (imageView == null) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(imageUrl));
    }
}

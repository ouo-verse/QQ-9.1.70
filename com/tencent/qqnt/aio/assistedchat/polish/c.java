package com.tencent.qqnt.aio.assistedchat.polish;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/c;", "", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "a", "", "width", "", "content", "Lkotlin/Pair;", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "c", "Landroid/text/SpannableString;", "endSpannableString", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f349397a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TextView textView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SpannableString endSpannableString;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f349397a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SpannableString a(Context context) {
        SpannableString spannableString = endSpannableString;
        if (spannableString != null) {
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(" \u4f7f\u7528\u7bad\u5934");
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.qui_common_text_link)), 1, spannableString2.length() - 2, 33);
        spannableString2.setSpan(new StyleSpan(1), 1, spannableString2.length() - 2, 33);
        Drawable o16 = ie0.a.f().o(context, R.drawable.qui_arrowhead_down, R.color.qui_common_text_link, 1000);
        if (o16 != null) {
            o16.setBounds(0, 0, l.b(14), l.b(14));
            spannableString2.setSpan(new VerticalCenterImageSpan(o16, 1), spannableString2.length() - 2, spannableString2.length(), 33);
        }
        endSpannableString = spannableString2;
        Intrinsics.checkNotNull(spannableString2);
        return spannableString2;
    }

    @NotNull
    public final Pair<CharSequence, Integer> b(@NotNull Context context, int width, @NotNull CharSequence content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(width), content);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        long currentTimeMillis = System.currentTimeMillis();
        if (textView == null) {
            TextView textView2 = new TextView(context);
            textView2.setLayoutParams(new FrameLayout.LayoutParams(width, -2));
            textView2.setBreakStrategy(0);
            textView2.setTextSize(0, ViewUtils.spToPx(13.0f));
            textView = textView2;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WriteWhilePolishingViewUtil", 1, "create textView. cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        TextView textView3 = textView;
        if (textView3 != null) {
            try {
                SpannableString a16 = f349397a.a(context);
                SpannableStringBuilder tempContent = new SpannableStringBuilder(content).append((CharSequence) a16);
                Intrinsics.checkNotNullExpressionValue(tempContent, "tempContent");
                DynamicLayout a17 = e.a(textView3, tempContent, width);
                if (a17.getLineCount() <= 3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("WriteWhilePolishingViewUtil", 1, "less or equal Max lines. length=" + content.length() + ",cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                    return new Pair<>(tempContent, Integer.valueOf(a16.length()));
                }
                SpannableStringBuilder append = new SpannableStringBuilder(MiniBoxNoticeInfo.APPNAME_SUFFIX).append((CharSequence) a16);
                int lineEnd = a17.getLineEnd(2) - a16.length();
                if (QLog.isDevelopLevel()) {
                    QLog.i("WriteWhilePolishingViewUtil", 1, "endIndex=" + lineEnd);
                }
                SpannableStringBuilder result = new SpannableStringBuilder(content.subSequence(0, lineEnd).toString()).append((CharSequence) append);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                DynamicLayout a18 = e.a(textView3, result, width);
                while (a18.getLineCount() > 3) {
                    lineEnd--;
                    String obj = content.subSequence(0, lineEnd).toString();
                    result.clear();
                    result.append((CharSequence) obj).append((CharSequence) append);
                    a18 = e.a(textView3, result, width);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("WriteWhilePolishingViewUtil", 1, "more than Max lines. length=" + content.length() + ", endIndex=" + lineEnd + ", cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                return new Pair<>(result, Integer.valueOf(append.length()));
            } catch (Exception e16) {
                QLog.e("WriteWhilePolishingViewUtil", 1, "getShowText error ", e16);
            }
        }
        return new Pair<>(content, 0);
    }
}

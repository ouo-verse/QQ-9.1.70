package com.tencent.mobileqq.nearbypro.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/h;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "b", "Landroid/widget/TextView;", "textView", "", "d", "", ReportConstant.COSTREPORT_PREFIX, "", "limit", "e", "a", "", "", "c", "Landroid/graphics/Typeface;", "numberTypeface", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f253950a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Typeface numberTypeface;

    h() {
    }

    private final Typeface b(Context context) {
        if (numberTypeface == null) {
            synchronized (h.class) {
                if (numberTypeface == null) {
                    numberTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/tg_din_condensed_bold.ttf");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return numberTypeface;
    }

    public final int a(@Nullable String s16) {
        int i3;
        if (s16 == null) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < s16.length(); i17++) {
            if (c(s16.charAt(i17))) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            i16 += i3;
        }
        return i16;
    }

    public final boolean c(char a16) {
        if (a16 < '\u00ff' && a16 >= 0) {
            return false;
        }
        return true;
    }

    public final void d(@Nullable TextView textView) {
        if (textView != null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            if (b(context) != null) {
                Context context2 = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "textView.context");
                textView.setTypeface(b(context2));
            }
        }
    }

    @Nullable
    public final String e(@Nullable String s16, int limit) {
        int i3;
        String obj;
        if (s16 == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        CharBuffer decode = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(s16));
        Intrinsics.checkNotNullExpressionValue(decode, "forName(\"UTF-16\").decode\u2026-16\").encode(s)\n        )");
        int length = decode.length();
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (Character.isHighSurrogate(decode.charAt(i16))) {
                    i3 = i16 + 2;
                    obj = decode.subSequence(i16, i3).toString();
                } else {
                    i3 = i16 + 1;
                    obj = decode.subSequence(i16, i3).toString();
                }
                int a16 = a(obj);
                if (limit >= a16) {
                    limit -= a16;
                    sb5.append(obj);
                    i16 = i3;
                } else {
                    sb5.delete(sb5.length() - 2, sb5.length());
                    sb5.append("\u2026");
                    break;
                }
            } else {
                break;
            }
        }
        return sb5.toString();
    }
}

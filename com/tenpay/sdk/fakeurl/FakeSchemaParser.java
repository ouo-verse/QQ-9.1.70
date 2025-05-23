package com.tenpay.sdk.fakeurl;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/fakeurl/FakeSchemaParser;", "", "()V", "SCHEMA_REGEX", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "TAG", "", "toSpannable", "", "content", "onClickAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FakeSchemaParser {

    @NotNull
    public static final FakeSchemaParser INSTANCE = new FakeSchemaParser();
    private static final Pattern SCHEMA_REGEX = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);

    @NotNull
    public static final String TAG = "QWalletHttp.SchemaTextUtils";

    FakeSchemaParser() {
    }

    @Nullable
    public final CharSequence toSpannable(@Nullable String content, @Nullable final Function1<? super String, Unit> onClickAction) {
        boolean z16;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && onClickAction != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Matcher matcher = SCHEMA_REGEX.matcher(content);
            boolean z17 = false;
            int i3 = 0;
            int i16 = 0;
            while (matcher.find()) {
                try {
                    int start = matcher.start(0);
                    i3 = matcher.end(0);
                    if (i16 != start) {
                        spannableStringBuilder.append(content.subSequence(i16, start));
                        i16 = i3;
                    }
                    String substring = content.substring(matcher.start(1), matcher.end(1));
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    final String substring2 = content.substring(matcher.start(2), matcher.end(2));
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    SpannableString spannableString = new SpannableString(substring);
                    spannableString.setSpan(new ClickableSpan() { // from class: com.tenpay.sdk.fakeurl.FakeSchemaParser$toSpannable$1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NotNull View widget) {
                            Intrinsics.checkNotNullParameter(widget, "widget");
                            onClickAction.invoke(substring2);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NotNull TextPaint ds5) {
                            Intrinsics.checkNotNullParameter(ds5, "ds");
                            super.updateDrawState(ds5);
                            ds5.setUnderlineText(false);
                        }
                    }, 0, substring.length(), 33);
                    spannableString.setSpan(Integer.valueOf(BaseApplication.context.getApplicationContext().getResources().getColor(R.color.login_error_url)), 0, substring.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    z17 = true;
                } catch (Throwable th5) {
                    QLog.w(TAG, 1, "find regex fail", th5);
                    return null;
                }
            }
            if (z17) {
                String substring3 = content.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                spannableStringBuilder.append((CharSequence) substring3);
                return spannableStringBuilder;
            }
            return content;
        }
        return content;
    }
}

package com.tencent.guild.aio.component.combinestyle;

import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/x;", "", "", "nick", "Landroid/widget/TextView;", "textView", "c", "Landroid/text/TextPaint;", "paint", "", com.tencent.luggage.wxa.c8.c.E, "a", "msgItemNickName", "b", "roleColor", "", "d", "(Ljava/lang/Integer;)Z", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f110293a = new x();

    x() {
    }

    private final String a(TextPaint paint, int len, String nick) {
        for (int length = nick.length() - 1; length > 0; length--) {
            String substring = nick.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (paint.measureText(substring) <= len) {
                return substring;
            }
        }
        return nick;
    }

    private final String c(String nick, TextView textView) {
        int dimensionPixelSize = textView.getContext().getResources().getDimensionPixelSize(R.dimen.cg_);
        if (textView.getPaint().measureText(nick) > dimensionPixelSize) {
            TextPaint paint = textView.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
            return a(paint, dimensionPixelSize, nick) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return nick;
    }

    @NotNull
    public final String b(@NotNull String msgItemNickName, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(msgItemNickName, "msgItemNickName");
        Intrinsics.checkNotNullParameter(textView, "textView");
        return c(msgItemNickName, textView);
    }

    public final boolean d(@Nullable Integer roleColor) {
        if (roleColor != null && roleColor.intValue() != -1 && roleColor.intValue() != -16777216) {
            return true;
        }
        return false;
    }
}

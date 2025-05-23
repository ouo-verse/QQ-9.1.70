package h50;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lh50/b;", "", "", "nick", "recommend", "Landroid/text/TextPaint;", "textPaint", "", "availableWidth", "Landroid/text/SpannableStringBuilder;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f404331a = new b();

    b() {
    }

    @NotNull
    public final SpannableStringBuilder a(@NotNull String nick, @NotNull String recommend, @NotNull TextPaint textPaint, float availableWidth) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(recommend, "recommend");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        String str = nick + recommend;
        float measureText = textPaint.measureText(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (measureText <= availableWidth) {
            spannableStringBuilder.append((CharSequence) str);
            QLog.d("QFSPublicAccountStaggerItemTextUtil", 4, "completeText:" + ((Object) spannableStringBuilder));
        } else {
            float measureText2 = textPaint.measureText(recommend);
            if (measureText2 < availableWidth) {
                spannableStringBuilder.append((CharSequence) TextUtils.ellipsize(nick, textPaint, availableWidth - measureText2, TextUtils.TruncateAt.END).toString()).append((CharSequence) recommend);
                QLog.d("QFSPublicAccountStaggerItemTextUtil", 4, "ellipsizedNick + recommend:" + ((Object) spannableStringBuilder));
            } else {
                spannableStringBuilder.append((CharSequence) TextUtils.ellipsize(recommend, textPaint, availableWidth, TextUtils.TruncateAt.END).toString());
                QLog.d("QFSPublicAccountStaggerItemTextUtil", 4, "ellipsizedRecommend:" + ((Object) spannableStringBuilder));
            }
        }
        return spannableStringBuilder;
    }
}

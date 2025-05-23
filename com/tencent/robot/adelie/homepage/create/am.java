package com.tencent.robot.adelie.homepage.create;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/am;", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "Ljava/util/regex/Pattern;", "d", "Ljava/util/regex/Pattern;", "emojiPattern", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class am implements InputFilter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pattern emojiPattern;

    public am() {
        Pattern compile = Pattern.compile("[\u1f300-\u1f5ff]|[\u1f600-\u1f64f]|[\u1f680-\u1f6ff]|[\u2600-\u26ff]|[\u2700-\u27bf]", 66);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\n        \"[\\uD83\u2026rn.CASE_INSENSITIVE\n    )");
        this.emojiPattern = compile;
    }

    @Override // android.text.InputFilter
    @NotNull
    public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (this.emojiPattern.matcher(source).find()) {
            return "";
        }
        return source;
    }
}

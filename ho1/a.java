package ho1;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lho1/a;", "", "Landroid/widget/TextView;", "textView", "", "curInputLength", "maxLength", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f405438a = new a();

    a() {
    }

    public final void a(@NotNull TextView textView, int curInputLength, int maxLength) {
        int color;
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (maxLength - curInputLength <= 100) {
            textView.setVisibility(0);
            if (curInputLength >= 500) {
                color = textView.getResources().getColor(R.color.qui_common_feedback_error);
            } else {
                color = textView.getResources().getColor(R.color.btw);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(curInputLength + "/" + maxLength);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, String.valueOf(curInputLength).length(), 17);
            textView.setText(spannableStringBuilder);
            return;
        }
        textView.setVisibility(8);
    }
}

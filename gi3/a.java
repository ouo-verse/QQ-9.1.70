package gi3;

import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lgi3/a;", "Lvb3/b;", "", "otherEmoString", "q0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f402157a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lgi3/a$a;", "", "", "content", "", "fontSize", "Lcom/tencent/mobileqq/text/QQText;", "a", "Landroid/widget/TextView;", "emoSize", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gi3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f402157a = new Companion();

        Companion() {
        }

        private final QQText a(String content, int fontSize) {
            String q06 = ((a) vb3.a.f441346a.a(a.class)).q0(content);
            QLog.i("zplan_emoji", 1, "emCodesToQQcodes result = " + q06);
            return new QQText(q06, 7, fontSize);
        }

        public final void b(TextView textView, String content, int i3) {
            Intrinsics.checkNotNullParameter(textView, "<this>");
            Intrinsics.checkNotNullParameter(content, "content");
            textView.setText(a(content, i3));
        }
    }

    String q0(String otherEmoString);
}

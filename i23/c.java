package i23;

import androidx.annotation.DrawableRes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Li23/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "I", "()I", "bgRes", "<init>", "(Ljava/lang/String;I)V", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int bgRes;

    public c(@NotNull String text, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bgRes = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getBgRes() {
        return this.bgRes;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.text, cVar.text) && this.bgRes == cVar.bgRes) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.bgRes;
    }

    @NotNull
    public String toString() {
        String str;
        try {
            str = BaseApplication.context.getResources().getResourceName(this.bgRes);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getResourceName(bgRes)");
        } catch (Exception e16) {
            QLog.w("PayBtnStyle", 1, e16.getMessage());
            str = "";
        }
        return "PayBtnStyle(text='" + this.text + "', bgRes=" + str + ")";
    }
}

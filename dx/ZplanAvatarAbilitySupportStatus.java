package dx;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u000fB\t\b\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ldx/b;", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "d", "(I)V", "supportStatus", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dx.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ZplanAvatarAbilitySupportStatus {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int supportStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Ldx/b$a;", "", "", "str", "Ldx/b;", "a", "", "NOT_SUPPORT_ZPLAN_AVATAR", "I", "SUPPORT_ZPLAN_AVATAR", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dx.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final ZplanAvatarAbilitySupportStatus a(@Nullable String str) {
            List split$default;
            if (TextUtils.isEmpty(str)) {
                QLog.i("ZplanAvatarAbilitySupportStatus", 2, "convertStringToZplanAvatarAbilitySupportStatus str is empty");
                return null;
            }
            Intrinsics.checkNotNull(str);
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                QLog.i("ZplanAvatarAbilitySupportStatus", 2, "convertStringToZplanAvatarAbilitySupportStatus str size invalid");
                return null;
            }
            ZplanAvatarAbilitySupportStatus zplanAvatarAbilitySupportStatus = new ZplanAvatarAbilitySupportStatus();
            try {
                zplanAvatarAbilitySupportStatus.d(Integer.parseInt((String) split$default.get(0)));
                QLog.i("ZplanAvatarAbilitySupportStatus", 2, "supportStatus " + zplanAvatarAbilitySupportStatus.getSupportStatus());
                return zplanAvatarAbilitySupportStatus;
            } catch (Exception unused) {
                QLog.e("ZplanAvatarAbilitySupportStatus", 2, "convertStringToZplanAvatarAbilitySupportStatus parse exception");
                return null;
            }
        }

        Companion() {
        }
    }

    public ZplanAvatarAbilitySupportStatus(int i3) {
        this.supportStatus = i3;
    }

    @JvmStatic
    @Nullable
    public static final ZplanAvatarAbilitySupportStatus a(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @NotNull
    public final String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.supportStatus);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().append(supportStatus).toString()");
        QLog.i("ZplanAvatarAbilitySupportStatus", 2, sb6);
        return sb6;
    }

    /* renamed from: c, reason: from getter */
    public final int getSupportStatus() {
        return this.supportStatus;
    }

    public final void d(int i3) {
        this.supportStatus = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ZplanAvatarAbilitySupportStatus) && this.supportStatus == ((ZplanAvatarAbilitySupportStatus) other).supportStatus) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.supportStatus;
    }

    @NotNull
    public String toString() {
        return "ZplanAvatarAbilitySupportStatus(supportStatus=" + this.supportStatus + ")";
    }

    public ZplanAvatarAbilitySupportStatus() {
        this(0);
    }
}

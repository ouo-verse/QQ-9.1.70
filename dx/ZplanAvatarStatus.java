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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eB\t\b\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Ldx/d;", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "f", "(I)V", "enable", "getWidth", h.F, "width", "c", "getHeight", "g", "height", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "backgroundId", "<init>", "(IIILjava/lang/String;)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dx.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ZplanAvatarStatus {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int enable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String backgroundId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Ldx/d$a;", "", "", "str", "Ldx/d;", "a", "", "DISABLE_ZPLAN_AVATAR", "I", "ENABLE_ZPLAN_AVATAR", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dx.d$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final ZplanAvatarStatus a(@Nullable String str) {
            List split$default;
            if (TextUtils.isEmpty(str)) {
                QLog.i("ZplanAvatarStatus", 2, "convertStringToGAudioZPlanStatus statusStr is empty");
                return null;
            }
            Intrinsics.checkNotNull(str);
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default.size() < 4) {
                QLog.i("ZplanAvatarStatus", 2, "convertStringToZplanAvatarStatus statusStr size invalid");
                return null;
            }
            ZplanAvatarStatus zplanAvatarStatus = new ZplanAvatarStatus();
            try {
                zplanAvatarStatus.f(Integer.parseInt((String) split$default.get(0)));
                if (zplanAvatarStatus.getEnable() == 1) {
                    try {
                        zplanAvatarStatus.h(Integer.parseInt((String) split$default.get(1)));
                        zplanAvatarStatus.g(Integer.parseInt((String) split$default.get(2)));
                    } catch (Exception unused) {
                        zplanAvatarStatus.h(720);
                        zplanAvatarStatus.g(1280);
                    }
                    zplanAvatarStatus.e((String) split$default.get(3));
                }
                return zplanAvatarStatus;
            } catch (Exception unused2) {
                QLog.e("ZplanAvatarStatus", 2, "convertStringToZplanAvatarStatus parse exception");
                return null;
            }
        }

        Companion() {
        }
    }

    public ZplanAvatarStatus(int i3, int i16, int i17, @NotNull String backgroundId) {
        Intrinsics.checkNotNullParameter(backgroundId, "backgroundId");
        this.enable = i3;
        this.width = i16;
        this.height = i17;
        this.backgroundId = backgroundId;
    }

    @JvmStatic
    @Nullable
    public static final ZplanAvatarStatus a(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @NotNull
    public final String b() {
        String str = this.enable + "_" + this.width + "_" + this.height + "_" + this.backgroundId;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(e\u2026(backgroundId).toString()");
        QLog.i("ZplanAvatarStatus", 2, str);
        return str;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getBackgroundId() {
        return this.backgroundId;
    }

    /* renamed from: d, reason: from getter */
    public final int getEnable() {
        return this.enable;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundId = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanAvatarStatus)) {
            return false;
        }
        ZplanAvatarStatus zplanAvatarStatus = (ZplanAvatarStatus) other;
        if (this.enable == zplanAvatarStatus.enable && this.width == zplanAvatarStatus.width && this.height == zplanAvatarStatus.height && Intrinsics.areEqual(this.backgroundId, zplanAvatarStatus.backgroundId)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.enable = i3;
    }

    public final void g(int i3) {
        this.height = i3;
    }

    public final void h(int i3) {
        this.width = i3;
    }

    public int hashCode() {
        return (((((this.enable * 31) + this.width) * 31) + this.height) * 31) + this.backgroundId.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZplanAvatarStatus(enable=" + this.enable + ", width=" + this.width + ", height=" + this.height + ", backgroundId=" + this.backgroundId + ")";
    }

    public ZplanAvatarStatus() {
        this(0, 720, 1280, "");
    }
}

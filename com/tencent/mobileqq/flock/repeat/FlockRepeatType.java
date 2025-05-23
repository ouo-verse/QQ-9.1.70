package com.tencent.mobileqq.flock.repeat;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "", "Ljava/io/Serializable;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "NONE", "DAY", "WEEK", "MONTH", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockRepeatType implements Serializable {
    private static final /* synthetic */ FlockRepeatType[] $VALUES;
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final FlockRepeatType DAY;
    public static final FlockRepeatType MONTH;
    public static final FlockRepeatType NONE;
    private static final int REPEAT_NOT_LIMITED = 0;
    private static final int REPEAT_PER_DAY = 1;
    private static final int REPEAT_PER_MONTH = 3;
    private static final int REPEAT_PER_WEEK = 2;
    public static final FlockRepeatType WEEK;

    @NotNull
    private final String content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType$a;", "", "", "type", "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "b", "a", "", "c", "REPEAT_NOT_LIMITED", "I", "REPEAT_PER_DAY", "REPEAT_PER_MONTH", "REPEAT_PER_WEEK", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.repeat.FlockRepeatType$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.flock.repeat.FlockRepeatType$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public /* synthetic */ class C7611a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f210380a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48927);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[FlockRepeatType.values().length];
                try {
                    iArr[FlockRepeatType.DAY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FlockRepeatType.WEEK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FlockRepeatType.MONTH.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f210380a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@NotNull FlockRepeatType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) type)).intValue();
            }
            Intrinsics.checkNotNullParameter(type, "type");
            int i3 = C7611a.f210380a[type.ordinal()];
            int i16 = 1;
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    if (i3 == 3) {
                        return 3;
                    }
                    return 0;
                }
            }
            return i16;
        }

        @NotNull
        public final FlockRepeatType b(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FlockRepeatType) iPatchRedirector.redirect((short) 2, (Object) this, type);
            }
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        return FlockRepeatType.NONE;
                    }
                    return FlockRepeatType.MONTH;
                }
                return FlockRepeatType.WEEK;
            }
            return FlockRepeatType.DAY;
        }

        @Nullable
        public final String c(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, type);
            }
            FlockRepeatType b16 = b(type);
            if (b16 == FlockRepeatType.NONE) {
                return null;
            }
            String string = MobileQQ.sMobileQQ.getString(R.string.f199194or);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.string.qq_flock_repeat)");
            return b16.getContent() + string;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ FlockRepeatType[] $values() {
        return new FlockRepeatType[]{NONE, DAY, WEEK, MONTH};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48932);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        NONE = new FlockRepeatType("NONE", 0, "\u4e0d\u91cd\u590d");
        DAY = new FlockRepeatType("DAY", 1, "\u6bcf\u5929");
        WEEK = new FlockRepeatType("WEEK", 2, "\u6bcf\u5468");
        MONTH = new FlockRepeatType("MONTH", 3, "\u6bcf\u6708");
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    FlockRepeatType(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.content = str2;
        }
    }

    public static FlockRepeatType valueOf(String str) {
        return (FlockRepeatType) Enum.valueOf(FlockRepeatType.class, str);
    }

    public static FlockRepeatType[] values() {
        return (FlockRepeatType[]) $VALUES.clone();
    }

    @NotNull
    public final String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.content;
    }
}

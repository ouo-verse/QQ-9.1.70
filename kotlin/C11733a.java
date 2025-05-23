package kotlin;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a8\u0006\n"}, d2 = {"Lsg1/a;", "", "T", "", "tag", "valueName", "Lsg1/a$a;", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sg1.a, reason: case insensitive filesystem */
/* loaded from: classes12.dex */
public final class C11733a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C11733a f433775a = new C11733a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lsg1/a$a;", "T", "", "", "message", "a", "newValue", "", "b", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/String;", "tag", "valueName", "c", "Ljava/lang/Object;", "lastValue", "", "d", "Z", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sg1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C11227a<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String valueName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private T lastValue;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean first;

        public C11227a(@NotNull String tag, @NotNull String valueName) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(valueName, "valueName");
            this.tag = tag;
            this.valueName = valueName;
            this.first = true;
        }

        private final String a(String message) {
            boolean z16;
            if (message.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                message = null;
            }
            if (message != null) {
                String str = "[" + message + "] ";
                if (str != null) {
                    return str;
                }
            }
            return "";
        }

        public final void b(T newValue, @NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (this.first) {
                C11734b c11734b = C11734b.f433780a;
                String str = "Guild.component." + this.tag;
                String a16 = a(message);
                String str2 = this.valueName;
                C11733a c11733a = C11733a.f433775a;
                QLog.i(str, 1, a16 + str2 + " set: " + newValue + "[" + System.identityHashCode(this) + "]", null);
                this.lastValue = newValue;
                this.first = false;
                return;
            }
            if (!Intrinsics.areEqual(this.lastValue, newValue)) {
                C11734b c11734b2 = C11734b.f433780a;
                String str3 = "Guild.component." + this.tag;
                String a17 = a(message);
                String str4 = this.valueName;
                T t16 = this.lastValue;
                C11733a c11733a2 = C11733a.f433775a;
                QLog.i(str3, 1, a17 + str4 + " changed: " + t16 + " -> " + newValue + "[" + System.identityHashCode(this) + "]", null);
                this.lastValue = newValue;
            }
        }
    }

    C11733a() {
    }

    @NotNull
    public final <T> C11227a<T> a(@NotNull String tag, @NotNull String valueName) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(valueName, "valueName");
        return new C11227a<>("ValueChange." + tag, valueName);
    }
}

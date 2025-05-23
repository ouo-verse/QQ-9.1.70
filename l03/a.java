package l03;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.bubble.report.VasBubbleReporter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ll03/a;", "", "", "bubbleId", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Lf03/b;", "b", "c", "Lf03/c;", "a", "Lf03/c;", "bubbleConfigFactory", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f413601c = IBubbleManager.INSTANCE.b() + "BubbleIndoManager";

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, f03.b> f413602d = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f03.c bubbleConfigFactory = new f03.c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Ll03/a$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l03.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return a.f413601c;
        }

        Companion() {
        }
    }

    private final f03.b b(String bubbleId, boolean needDownload) {
        return this.bubbleConfigFactory.a(bubbleId, needDownload);
    }

    @Nullable
    public f03.b c(@NotNull String bubbleId, boolean needDownload) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        ConcurrentHashMap<String, f03.b> concurrentHashMap = f413602d;
        f03.b bVar = concurrentHashMap.get(bubbleId);
        if (bVar != null) {
            return bVar;
        }
        f03.b b16 = b(bubbleId, needDownload);
        if (b16 == null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(VasBubbleReporter.ERROR_BUBBLE_CREATE, "{id}", bubbleId, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{msg}", "bubbleConfig == null", false, 4, (Object) null);
            VasBubbleReporter.INSTANCE.report(replace$default2);
        } else {
            concurrentHashMap.put(bubbleId, b16);
        }
        return b16;
    }
}

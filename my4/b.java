package my4;

import com.tme.karaoke.lib_earback.base.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lmy4/b;", "", "Lmy4/b$a;", "timeSlotScene", "", "a", "b", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f417812b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = TAG;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0005B\u001b\b\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0001\u0012\u00a8\u0006\u0013"}, d2 = {"Lmy4/b$a;", "", "", "toString", "Lmy4/a;", "a", "Lmy4/a;", "()Lmy4/a;", "setTimeSlot", "(Lmy4/a;)V", "timeSlot", "b", "Ljava/lang/String;", "getTimeSceneName", "()Ljava/lang/String;", "timeSceneName", "<init>", "(Lmy4/a;Ljava/lang/String;)V", "Lmy4/b$a$a;", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: my4.b$a, reason: from toString */
    /* loaded from: classes27.dex */
    public static abstract class TimeSlotScene {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private EarbackTimeSlot timeSlot;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String timeSceneName;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lmy4/b$a$a;", "Lmy4/b$a;", "<init>", "()V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: my4.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static final class C10809a extends TimeSlotScene {

            /* renamed from: c, reason: collision with root package name */
            public static final C10809a f417815c = new C10809a();

            C10809a() {
                super(null, "HuaweiAudioKitInitCostTime", 1, 0 == true ? 1 : 0);
            }
        }

        TimeSlotScene(EarbackTimeSlot earbackTimeSlot, String str) {
            this.timeSlot = earbackTimeSlot;
            this.timeSceneName = str;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EarbackTimeSlot getTimeSlot() {
            return this.timeSlot;
        }

        @NotNull
        public String toString() {
            return "TimeSlotScene(timeSlot=" + this.timeSlot + ", timeSceneName='" + this.timeSceneName + "')";
        }

        /* synthetic */ TimeSlotScene(EarbackTimeSlot earbackTimeSlot, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new EarbackTimeSlot(Long.MIN_VALUE, Long.MIN_VALUE, 0L, 4, null) : earbackTimeSlot, str);
        }
    }

    b() {
    }

    public final void a(@NotNull TimeSlotScene timeSlotScene) {
        Intrinsics.checkParameterIsNotNull(timeSlotScene, "timeSlotScene");
        if (timeSlotScene.getTimeSlot().getBeginTime() == Long.MIN_VALUE) {
            timeSlotScene.getTimeSlot().d(System.currentTimeMillis());
            return;
        }
        if (timeSlotScene.getTimeSlot().getEndTime() == Long.MIN_VALUE) {
            timeSlotScene.getTimeSlot().f(System.currentTimeMillis());
            timeSlotScene.getTimeSlot().e(timeSlotScene.getTimeSlot().getEndTime() - timeSlotScene.getTimeSlot().getBeginTime());
            c.m("timeSlotScene : " + timeSlotScene);
        }
    }

    public final void b() {
        TimeSlotScene.C10809a.f417815c.getTimeSlot().c();
    }
}

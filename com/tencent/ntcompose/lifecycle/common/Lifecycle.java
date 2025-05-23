package com.tencent.ntcompose.lifecycle.common;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;", "", "Lcom/tencent/ntcompose/lifecycle/common/b;", "observer", "", "a", "<init>", "()V", "Event", "State", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    public static final int f339325a = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "getTargetState", "()Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "targetState", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "ON_CREATE", "ON_RESUME", "ON_PAUSE", "ON_DESTROY", "ON_ANY", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public enum Event {
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_DESTROY,
        ON_ANY;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event$a;", "", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "state", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "a", "b", "c", "d", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.ntcompose.lifecycle.common.Lifecycle$Event$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.ntcompose.lifecycle.common.Lifecycle$Event$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            public /* synthetic */ class C9258a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f339326a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f339326a = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Event a(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = C9258a.f339326a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i3 != 2) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            @JvmStatic
            public final Event b(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = C9258a.f339326a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_PAUSE;
                }
                if (i3 != 3) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            @JvmStatic
            public final Event c(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = C9258a.f339326a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_RESUME;
                }
                if (i3 != 4) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            @JvmStatic
            public final Event d(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                int i3 = C9258a.f339326a[state.ordinal()];
                if (i3 == 1) {
                    return Event.ON_CREATE;
                }
                if (i3 != 2) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            Companion() {
            }
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f339327a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f339327a = iArr;
            }
        }

        @JvmStatic
        public static final Event downFrom(State state) {
            return INSTANCE.a(state);
        }

        @JvmStatic
        public static final Event downTo(State state) {
            return INSTANCE.b(state);
        }

        @JvmStatic
        public static final Event upFrom(State state) {
            return INSTANCE.c(state);
        }

        @JvmStatic
        public static final Event upTo(State state) {
            return INSTANCE.d(state);
        }

        public final State getTargetState() {
            int i3 = b.f339327a[ordinal()];
            if (i3 == 1 || i3 == 2) {
                return State.CREATED;
            }
            if (i3 == 3) {
                return State.RESUMED;
            }
            if (i3 == 4) {
                return State.DESTROYED;
            }
            throw new IllegalArgumentException(this + " has no target state");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "", "(Ljava/lang/String;I)V", "isAtLeast", "", "state", "DESTROYED", "INITIALIZED", DebugCoroutineInfoImplKt.CREATED, "RESUMED", "ntcompose_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(b observer);
}

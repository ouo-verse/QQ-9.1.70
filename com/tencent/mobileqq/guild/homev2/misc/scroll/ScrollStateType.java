package com.tencent.mobileqq.guild.homev2.misc.scroll;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/scroll/ScrollStateType;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public @interface ScrollStateType {
    public static final int COLLAPSED = 0;
    public static final int COLLAPSING_ANIMATE_RUNNING = 9;
    public static final int COLLAPSING_SETTLING = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f225913a;
    public static final int EXPANDED = 2;
    public static final int PULL_DOWN_TO_REFRESH = 3;
    public static final int PULL_OVER_RESTORING = 5;
    public static final int PULL_REFRESH_ANIMATE_FINISH = 7;
    public static final int PULL_REFRESH_ANIMATE_RUNNING = 8;
    public static final int PULL_REFRESH_ANIMATE_START = 6;
    public static final int PULL_RELEASE_TO_REFRESH = 4;
    public static final int UNKNOWN = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/scroll/ScrollStateType$a;", "", "", "state", "", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.misc.scroll.ScrollStateType$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f225913a = new Companion();

        Companion() {
        }

        public final boolean a(int state) {
            if (state != 3 && state != 4 && state != 5 && state != 6 && state != 7 && state != 8 && state != 9) {
                return false;
            }
            return true;
        }

        @NotNull
        public final String b(int state) {
            switch (state) {
                case 0:
                    return "COLLAPSED";
                case 1:
                    return "COLLAPSING_SETTLING";
                case 2:
                    return "EXPANDED";
                case 3:
                    return "PULL_DOWN_TO_REFRESH";
                case 4:
                    return "PULL_RELEASE_TO_REFRESH";
                case 5:
                    return "PULL_OVER_RESTORING";
                case 6:
                    return "PULL_REFRESH_ANIMATE_START";
                case 7:
                    return "PULL_REFRESH_ANIMATE_FINISH";
                case 8:
                    return "PULL_REFRESH_ANIMATE_RUNNING";
                case 9:
                    return "COLLAPSING_ANIMATE_RUNNING";
                default:
                    return "UNKNOWN(" + state + ")";
            }
        }
    }
}

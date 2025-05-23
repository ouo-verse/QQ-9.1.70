package com.tencent.mobileqq.guild.api;

import androidx.annotation.AnyThread;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0006\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0004H'J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildDelayInitializeService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/guild/api/IGuildDelayInitializeService$a;", "task", "", "scheduleTask", "allowDelayTaskRunning", "checkSessionInitComplete", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildTabUnreadCountSafely", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface IGuildDelayInitializeService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildDelayInitializeService$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "value", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.api.IGuildDelayInitializeService$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class InitializeTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Function0<Unit> value;

        public InitializeTask(@NotNull String name, @NotNull Function0<Unit> value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Function0<Unit> b() {
            return this.value;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitializeTask)) {
                return false;
            }
            InitializeTask initializeTask = (InitializeTask) other;
            if (Intrinsics.areEqual(this.name, initializeTask.name) && Intrinsics.areEqual(this.value, initializeTask.value)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitializeTask(name=" + this.name + ", value=" + this.value + ')';
        }
    }

    @AnyThread
    void allowDelayTaskRunning();

    @AnyThread
    void checkSessionInitComplete();

    @NotNull
    UnreadInfo.a getGuildTabUnreadCountSafely();

    @UiThread
    void scheduleTask(@NotNull InitializeTask task);
}

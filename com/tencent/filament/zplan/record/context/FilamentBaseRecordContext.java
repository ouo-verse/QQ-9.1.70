package com.tencent.filament.zplan.record.context;

import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_TIME_OUT;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0004R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplan/record/context/FilamentBaseRecordContext;", "", "Lorg/json/JSONObject;", "data", "", "g", "f", "e", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "b", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Ljava/lang/Runnable;", "d", "", "a", "Z", "c", "()Z", "setForceStopped", "(Z)V", "forceStopped", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class FilamentBaseRecordContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean forceStopped;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f105823b = Meme.f385754h.k().getTimeout();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/record/context/FilamentBaseRecordContext$a;", "", "", "timeout", "J", "a", "()J", "", "DEFAULT_FPS", "I", "", "JS_EVENT_RECORD_END", "Ljava/lang/String;", "JS_EVENT_RECORD_FRAME", "JS_EVENT_RECORD_START", "TAG", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.record.context.FilamentBaseRecordContext$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        public final long a() {
            return FilamentBaseRecordContext.f105823b;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract void b(@NotNull ActionStatus status);

    /* renamed from: c, reason: from getter */
    public final boolean getForceStopped() {
        return this.forceStopped;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Runnable d(@NotNull final MemeZPlanBaseAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new Runnable() { // from class: com.tencent.filament.zplan.record.context.FilamentBaseRecordContext$getTimeoutRunner$1
            @Override // java.lang.Runnable
            public final void run() {
                if (FilamentBaseRecordContext.this.getForceStopped()) {
                    return;
                }
                FLog.INSTANCE.e("[zplan][MemePlayer-SDK][FilamentBaseRecordContext]", action.getDesc() + " timeout(" + FilamentBaseRecordContext.INSTANCE.a() + "ms)!! callback timeout");
                FilamentBaseRecordContext.this.b(ERROR_TIME_OUT.INSTANCE);
            }
        };
    }

    public abstract void e(@NotNull JSONObject data);

    public abstract void f(@NotNull JSONObject data);

    public abstract void g(@NotNull JSONObject data);
}

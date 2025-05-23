package com.tencent.filament.zplan.record;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.record.context.FilamentBaseRecordContext;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0004H\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/filament/zplan/record/a;", "Lcom/tencent/zplan/meme/recorder/a;", "Landroid/content/Context;", "context", "", "initEngineIfNeed", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "stopAction", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/filament/zplan/record/context/FilamentBaseRecordContext;", "recordContext", "setRecordContext", "getRecordContextWithCheck", "removeRecordContext$zplan_android_release", "(I)V", "removeRecordContext", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "recordContexts", "Ljava/util/Map;", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "encoder", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "getEncoder$zplan_android_release", "()Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "<init>", "()V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class a implements com.tencent.zplan.meme.recorder.a {
    private static final String TAG = "[zplan][MemePlayer-SDK][FilamentBaseRecorder]";
    private final Map<Integer, FilamentBaseRecordContext> recordContexts = new LinkedHashMap();

    @NotNull
    private final MemeEncodeController encoder = new MemeEncodeController();

    @NotNull
    /* renamed from: getEncoder$zplan_android_release, reason: from getter */
    public final MemeEncodeController getEncoder() {
        return this.encoder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final FilamentBaseRecordContext getRecordContextWithCheck(int taskId) {
        FilamentBaseRecordContext filamentBaseRecordContext;
        synchronized (this.recordContexts) {
            filamentBaseRecordContext = this.recordContexts.get(Integer.valueOf(taskId));
        }
        if (filamentBaseRecordContext == null) {
            return null;
        }
        if (filamentBaseRecordContext.getForceStopped()) {
            FLog.INSTANCE.w(TAG, "getRecordContextWithCheck for " + taskId + ", forceStopped!");
            return null;
        }
        return filamentBaseRecordContext;
    }

    public abstract void initEngineIfNeed(@NotNull Context context);

    @Override // com.tencent.zplan.meme.recorder.a
    public void onDestroy() {
        this.encoder.n();
    }

    public final void removeRecordContext$zplan_android_release(int taskId) {
        synchronized (this.recordContexts) {
            this.recordContexts.remove(Integer.valueOf(taskId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRecordContext(int taskId, @NotNull FilamentBaseRecordContext recordContext) {
        Intrinsics.checkNotNullParameter(recordContext, "recordContext");
        synchronized (this.recordContexts) {
            this.recordContexts.put(Integer.valueOf(taskId), recordContext);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void stopAction(@NotNull MemeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }
}

package com.tencent.filament.zplan.record;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.record.context.FilamentAppRecordContext;
import com.tencent.filament.zplan.record.context.FilamentBaseRecordContext;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import uk0.e;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0017\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J9\u0010\u0012\u001a\u00020\u0004\"\b\b\u0000\u0010\r*\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/record/FilamentNativeAppRecorder;", "Lcom/tencent/filament/zplan/record/a;", "", "data", "", "handleRecordStart", "handleRecordFrame", "handleRecordEnd", "Landroid/content/Context;", "context", "initEngineIfNeed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/zplan/meme/b;", "T", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "recordKey", "listener", "recordAction", "(Landroid/content/Context;Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Lcom/tencent/zplan/meme/b;)V", "Lcom/tencent/filament/zplan/record/FilamentRecordNativeApp;", "nativeApp", "Lcom/tencent/filament/zplan/record/FilamentRecordNativeApp;", "com/tencent/filament/zplan/record/FilamentNativeAppRecorder$b", "jsEventListener", "Lcom/tencent/filament/zplan/record/FilamentNativeAppRecorder$b;", "<init>", "()V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeAppRecorder extends a {

    @NotNull
    public static final String TAG = "[zplan][MemePlayer-SDK][FilamentNativeAppRecorder]";
    private final b jsEventListener = new b();
    private FilamentRecordNativeApp nativeApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/record/FilamentNativeAppRecorder$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements e {
        b() {
        }

        @Override // uk0.e
        public void onEvent(@NotNull String type, @NotNull String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            FLog.INSTANCE.i(FilamentNativeAppRecorder.TAG, "onEvent, type:" + type + ", eventData:" + eventData);
            int hashCode = type.hashCode();
            if (hashCode != 993523402) {
                if (hashCode != 1294292892) {
                    if (hashCode == 1306358417 && type.equals("recordStart")) {
                        FilamentNativeAppRecorder.this.handleRecordStart(eventData);
                        return;
                    }
                    return;
                }
                if (type.equals("recordFrame")) {
                    FilamentNativeAppRecorder.this.handleRecordFrame(eventData);
                    return;
                }
                return;
            }
            if (type.equals("recordEnd")) {
                FilamentNativeAppRecorder.this.handleRecordEnd(eventData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRecordEnd(String data) {
        FilamentBaseRecordContext recordContextWithCheck;
        JSONObject b16 = h.f385294a.b(data);
        if (b16 != null && (recordContextWithCheck = getRecordContextWithCheck(b16.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID))) != null) {
            recordContextWithCheck.e(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRecordFrame(String data) {
        FilamentBaseRecordContext recordContextWithCheck;
        JSONObject b16 = h.f385294a.b(data);
        if (b16 != null && (recordContextWithCheck = getRecordContextWithCheck(b16.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID))) != null) {
            recordContextWithCheck.f(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRecordStart(String data) {
        FilamentBaseRecordContext recordContextWithCheck;
        JSONObject b16 = h.f385294a.b(data);
        if (b16 != null && (recordContextWithCheck = getRecordContextWithCheck(b16.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID))) != null) {
            recordContextWithCheck.g(b16);
        }
    }

    @Override // com.tencent.filament.zplan.record.a
    public void initEngineIfNeed(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.nativeApp == null) {
            FilamentRecordNativeApp filamentRecordNativeApp = new FilamentRecordNativeApp(FilamentRecordHelper.f105779a.d(context));
            filamentRecordNativeApp.O().addListener("recordStart", this.jsEventListener);
            filamentRecordNativeApp.O().addListener("recordFrame", this.jsEventListener);
            filamentRecordNativeApp.O().addListener("recordEnd", this.jsEventListener);
            this.nativeApp = filamentRecordNativeApp;
        }
    }

    @Override // com.tencent.filament.zplan.record.a, com.tencent.zplan.meme.recorder.a
    public void onDestroy() {
        super.onDestroy();
        FLog.INSTANCE.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        FilamentRecordNativeApp filamentRecordNativeApp = this.nativeApp;
        if (filamentRecordNativeApp != null) {
            filamentRecordNativeApp.B();
        }
        this.nativeApp = null;
    }

    @Override // com.tencent.zplan.meme.recorder.a
    public <T extends com.tencent.zplan.meme.b> void recordAction(@NotNull Context context, @NotNull MemeAction action, @NotNull String recordKey, @NotNull T listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        initEngineIfNeed(context);
        FilamentAppRecordContext filamentAppRecordContext = new FilamentAppRecordContext(this, getEncoder(), (MemeZPlanBaseAction) action, recordKey, (d) listener);
        setRecordContext(action.getTaskId(), filamentAppRecordContext);
        filamentAppRecordContext.o();
        FilamentRecordNativeApp filamentRecordNativeApp = this.nativeApp;
        if (filamentRecordNativeApp != null) {
            filamentRecordNativeApp.X(filamentAppRecordContext.getRecordParams().toJSON());
        }
    }
}

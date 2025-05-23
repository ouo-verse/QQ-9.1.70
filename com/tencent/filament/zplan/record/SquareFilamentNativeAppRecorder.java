package com.tencent.filament.zplan.record;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.record.context.FilamentAppRecordContext;
import com.tencent.filament.zplan.record.context.FilamentBaseRecordContext;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import dl0.d;
import dl0.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0013\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J9\u0010\u000e\u001a\u00020\u0004\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/record/SquareFilamentNativeAppRecorder;", "Lcom/tencent/filament/zplan/record/a;", "Landroid/content/Context;", "context", "", "initEngineIfNeed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/zplan/meme/b;", "T", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "recordKey", "listener", "recordAction", "(Landroid/content/Context;Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Lcom/tencent/zplan/meme/b;)V", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "com/tencent/filament/zplan/record/SquareFilamentNativeAppRecorder$b", "recordListener", "Lcom/tencent/filament/zplan/record/SquareFilamentNativeAppRecorder$b;", "<init>", "()V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareFilamentNativeAppRecorder extends a {

    @NotNull
    public static final String TAG = "[zplan][MemePlayer-SDK][SquareFilamentNativeAppRecorder]";
    private FilamentNativeAppV2305 nativeApp;
    private final b recordListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/record/SquareFilamentNativeAppRecorder$b", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements sk0.b {
        b() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            JSONObject b16 = h.f385294a.b(data);
            if (b16 != null) {
                FilamentBaseRecordContext recordContextWithCheck = SquareFilamentNativeAppRecorder.this.getRecordContextWithCheck(b16.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                if (recordContextWithCheck != null) {
                    int hashCode = type.hashCode();
                    if (hashCode != 806401375) {
                        if (hashCode != 1858650353) {
                            if (hashCode == 1870715878 && type.equals("BaseRecordSceneV2305.START")) {
                                recordContextWithCheck.g(b16);
                                return;
                            }
                            return;
                        }
                        if (type.equals("BaseRecordSceneV2305.FRAME")) {
                            recordContextWithCheck.f(b16);
                            return;
                        }
                        return;
                    }
                    if (type.equals("BaseRecordSceneV2305.END")) {
                        recordContextWithCheck.e(b16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.filament.zplan.record.a
    public void initEngineIfNeed(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.nativeApp == null) {
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            fl0.a aVar = fl0.a.f399763a;
            FilamentNativeAppV2305 filamentNativeAppV2305 = new FilamentNativeAppV2305(new sk0.a(F, false, context, 0, (k) aVar.a(k.class), (d) aVar.a(d.class), null, 72, null));
            filamentNativeAppV2305.addEventListener("BaseRecordSceneV2305.START", this.recordListener);
            filamentNativeAppV2305.addEventListener("BaseRecordSceneV2305.FRAME", this.recordListener);
            filamentNativeAppV2305.addEventListener("BaseRecordSceneV2305.END", this.recordListener);
            filamentNativeAppV2305.startWithEntry(null, "bundle/scenes/square_record/main.js");
            this.nativeApp = filamentNativeAppV2305;
        }
    }

    @Override // com.tencent.filament.zplan.record.a, com.tencent.zplan.meme.recorder.a
    public void onDestroy() {
        super.onDestroy();
        FLog.INSTANCE.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp;
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.destroy();
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
        FilamentAppRecordContext filamentAppRecordContext = new FilamentAppRecordContext(this, getEncoder(), (MemeZPlanBaseAction) action, recordKey, (com.tencent.zplan.meme.d) listener);
        setRecordContext(action.getTaskId(), filamentAppRecordContext);
        filamentAppRecordContext.o();
        JSONObject json = filamentAppRecordContext.getRecordParams().toJSON();
        FilamentNativeAppV2305 filamentNativeAppV2305 = this.nativeApp;
        if (filamentNativeAppV2305 != null) {
            filamentNativeAppV2305.dispatchEvent(null, "BaseRecordSceneV2305.LOAD", json.toString());
        }
    }
}

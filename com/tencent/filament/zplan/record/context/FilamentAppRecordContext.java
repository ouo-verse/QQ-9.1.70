package com.tencent.filament.zplan.record.context;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.filament.zplan.data.NativeBuffer;
import com.tencent.filament.zplan.record.a;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.COMPLETE;
import com.tencent.zplan.meme.action.ERROR_ENGINE_RECORD_FAIL;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.action.START;
import com.tencent.zplan.meme.d;
import com.tencent.zplan.meme.encoder.IRecordOperator;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeResult;
import dl0.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u00012B/\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020-\u00a2\u0006\u0004\b0\u00101J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/filament/zplan/record/context/FilamentAppRecordContext;", "Lcom/tencent/filament/zplan/record/context/FilamentBaseRecordContext;", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "", "path", "", "frames", "", "k", "o", "Lorg/json/JSONObject;", "data", "g", "f", "e", "b", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "timeoutRunner", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/model/MemeRecordParams;", "recordParams", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", "Lcom/tencent/zplan/meme/encoder/IRecordOperator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/zplan/meme/encoder/IRecordOperator;", JsonRuleKey.OPERATOR, "Lcom/tencent/filament/zplan/record/a;", "Lcom/tencent/filament/zplan/record/a;", "recorder", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", h.F, "Lcom/tencent/zplan/meme/encoder/MemeEncodeController;", "encoder", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "i", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "j", "Ljava/lang/String;", "recordKey", "Lcom/tencent/zplan/meme/d;", "Lcom/tencent/zplan/meme/d;", "listener", "<init>", "(Lcom/tencent/filament/zplan/record/a;Lcom/tencent/zplan/meme/encoder/MemeEncodeController;Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;Ljava/lang/String;Lcom/tencent/zplan/meme/d;)V", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentAppRecordContext extends FilamentBaseRecordContext {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final j f105813l;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Runnable timeoutRunner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MemeRecordParams recordParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecordOperator operator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final a recorder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MemeEncodeController encoder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MemeZPlanBaseAction action;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String recordKey;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final d listener;

    static {
        Object a16 = fl0.a.f399763a.a(j.class);
        Intrinsics.checkNotNull(a16);
        f105813l = (j) a16;
    }

    public FilamentAppRecordContext(@NotNull a recorder, @NotNull MemeEncodeController encoder, @NotNull MemeZPlanBaseAction action, @NotNull String recordKey, @NotNull d listener) {
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.recorder = recorder;
        this.encoder = encoder;
        this.action = action;
        this.recordKey = recordKey;
        this.listener = listener;
        this.recordParams = action.toMemeRecordParams();
        this.operator = new IRecordOperator() { // from class: com.tencent.filament.zplan.record.context.FilamentAppRecordContext$operator$1

            @NotNull
            private final MemeRecordParams params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.params = FilamentAppRecordContext.this.getRecordParams();
            }

            @Override // android.os.IInterface
            public /* bridge */ /* synthetic */ IBinder asBinder() {
                return (IBinder) asBinder();
            }

            @Override // com.tencent.zplan.meme.encoder.IRecordOperator
            @NotNull
            public MemeRecordParams getParams() {
                return this.params;
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onEncodeEnd(@NotNull String recordKey2, int portraitId, @NotNull Bundle data) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                Intrinsics.checkNotNullParameter(data, "data");
                int i3 = data.getInt("MemeRecordRealFrameCount");
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                wx4.d statistic = memeZPlanBaseAction.getStatistic();
                statistic.r(Meme.f385754h.i());
                statistic.A(i3);
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onEncodeStart(@NotNull String recordKey2, int portraitId) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                memeZPlanBaseAction.getStatistic().s(Meme.f385754h.i());
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onRecordCoverDone(@NotNull String recordKey2, int portraitId, @NotNull Bundle data) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                d dVar;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                Intrinsics.checkNotNullParameter(data, "data");
                ActionStatus actionStatus = ActionStatus.INSTANCE.toActionStatus(data.getInt("MemeRecordActionStatus"));
                String string = data.getString("MemeRecordCoverResultPath");
                boolean areEqual = Intrinsics.areEqual(actionStatus, RECORD_COMPLETE.INSTANCE);
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                MemeResult memeResult = new MemeResult(memeZPlanBaseAction, recordKey2, null);
                memeResult.l(new MemeResult.Cover(string, Meme.f385754h.m(recordKey2)));
                dVar = FilamentAppRecordContext.this.listener;
                dVar.ad(areEqual, memeResult);
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onRecordDone(@NotNull String recordKey2, int portraitId, @NotNull Bundle data) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                MemeZPlanBaseAction memeZPlanBaseAction2;
                boolean z16;
                a aVar;
                MemeZPlanBaseAction memeZPlanBaseAction3;
                MemeZPlanBaseAction memeZPlanBaseAction4;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                Intrinsics.checkNotNullParameter(data, "data");
                ActionStatus actionStatus = ActionStatus.INSTANCE.toActionStatus(data.getInt("MemeRecordActionStatus"));
                String string = data.getString("MemeRecordResultPath");
                ArrayList<String> stringArrayList = data.getStringArrayList("MemeRecordFramePathList");
                boolean z17 = data.getBoolean("MemeRecordOccurOOM");
                int i3 = data.getInt("MemeRecordScriptErrorCode");
                String string2 = data.getString("MemeRecordScriptStatisticData");
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                memeZPlanBaseAction.getStatistic().y(z17);
                memeZPlanBaseAction2 = FilamentAppRecordContext.this.action;
                memeZPlanBaseAction2.getStatistic().F(i3);
                if (string2 != null && string2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    memeZPlanBaseAction4 = FilamentAppRecordContext.this.action;
                    memeZPlanBaseAction4.getStatistic().G(string2);
                }
                FilamentAppRecordContext.this.k(actionStatus, string, stringArrayList);
                aVar = FilamentAppRecordContext.this.recorder;
                memeZPlanBaseAction3 = FilamentAppRecordContext.this.action;
                aVar.removeRecordContext$zplan_android_release(memeZPlanBaseAction3.getTaskId());
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onRecordFrameEnd(@NotNull String recordKey2, int portraitId, @NotNull Bundle data) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                boolean z16;
                d dVar;
                MemeZPlanBaseAction memeZPlanBaseAction2;
                MemeZPlanBaseAction memeZPlanBaseAction3;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                Intrinsics.checkNotNullParameter(data, "data");
                String string = data.getString("MemeRecordScriptStatisticData");
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                memeZPlanBaseAction.getStatistic().z(Meme.f385754h.i());
                if (string != null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    memeZPlanBaseAction3 = FilamentAppRecordContext.this.action;
                    memeZPlanBaseAction3.getStatistic().G(string);
                }
                dVar = FilamentAppRecordContext.this.listener;
                memeZPlanBaseAction2 = FilamentAppRecordContext.this.action;
                dVar.kg(memeZPlanBaseAction2, recordKey2, COMPLETE.INSTANCE);
            }

            @Override // com.tencent.zplan.meme.IZPlanRecordCallback
            public void onRecordFrameStart(@NotNull String recordKey2, int portraitId, @NotNull Bundle data) {
                MemeZPlanBaseAction memeZPlanBaseAction;
                boolean z16;
                d dVar;
                MemeZPlanBaseAction memeZPlanBaseAction2;
                MemeZPlanBaseAction memeZPlanBaseAction3;
                Intrinsics.checkNotNullParameter(recordKey2, "recordKey");
                Intrinsics.checkNotNullParameter(data, "data");
                String string = data.getString("MemeRecordScriptStatisticData");
                memeZPlanBaseAction = FilamentAppRecordContext.this.action;
                memeZPlanBaseAction.getStatistic().B(Meme.f385754h.i());
                if (string != null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    memeZPlanBaseAction3 = FilamentAppRecordContext.this.action;
                    memeZPlanBaseAction3.getStatistic().G(string);
                }
                dVar = FilamentAppRecordContext.this.listener;
                memeZPlanBaseAction2 = FilamentAppRecordContext.this.action;
                dVar.kg(memeZPlanBaseAction2, recordKey2, START.INSTANCE);
            }

            @Override // com.tencent.zplan.meme.encoder.IRecordOperator, android.os.IInterface
            @Nullable
            public Void asBinder() {
                return IRecordOperator.a.a(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(FilamentAppRecordContext filamentAppRecordContext, ActionStatus actionStatus, String str, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            list = null;
        }
        filamentAppRecordContext.k(actionStatus, str, list);
    }

    @Override // com.tencent.filament.zplan.record.context.FilamentBaseRecordContext
    public void b(@NotNull ActionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        l(this, status, null, null, 6, null);
    }

    @Override // com.tencent.filament.zplan.record.context.FilamentBaseRecordContext
    public void e(@NotNull JSONObject data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        int optInt = data.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        int taskId = this.action.getTaskId();
        if (optInt != taskId) {
            FLog.INSTANCE.w("[zplan][MemePlayer-SDK][FilamentJsAppRecordContext]", "onRecordEnd checkTask fail, currentKey:" + this.recordKey + ", currentTaskId:" + taskId + ", dataTaskId:" + optInt);
            return;
        }
        int optInt2 = data.optInt("errorCode");
        JSONObject optJSONObject = data.optJSONObject("statistic");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = null;
        }
        if (optInt2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
            bundle.putInt("MemeRecordScriptErrorCode", optInt2);
            bundle.putString("MemeRecordScriptStatisticData", str);
            getOperator().onRecordDone(this.recordKey, this.action.getActionId(), bundle);
            return;
        }
        this.encoder.h(this.action.getActionId(), true, str);
        this.encoder.l(this.action.getActionId());
    }

    @Override // com.tencent.filament.zplan.record.context.FilamentBaseRecordContext
    public void f(@NotNull JSONObject data) {
        NativeBuffer from;
        Intrinsics.checkNotNullParameter(data, "data");
        int optInt = data.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        int taskId = this.action.getTaskId();
        if (optInt != taskId) {
            FLog.INSTANCE.w("[zplan][MemePlayer-SDK][FilamentJsAppRecordContext]", "onRecordFrame checkTask fail, currentKey:" + this.recordKey + ", currentTaskId:" + taskId + ", dataTaskId:" + optInt);
            return;
        }
        int optInt2 = data.optInt("width");
        int optInt3 = data.optInt("height");
        JSONObject optJSONObject = data.optJSONObject("buffer");
        if (optJSONObject != null && (from = NativeBuffer.INSTANCE.from(optJSONObject)) != null) {
            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentJsAppRecordContext]", "onRecordFrame, currentKey:" + this.recordKey + ", taskId:" + taskId + ", buffer:" + from + ", width:" + optInt2 + ", height:" + optInt3);
            this.encoder.m(this.action.getActionId(), from.getData(), optInt2, optInt3);
        }
    }

    @Override // com.tencent.filament.zplan.record.context.FilamentBaseRecordContext
    public void g(@NotNull JSONObject data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        int optInt = data.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        int taskId = this.action.getTaskId();
        if (optInt != taskId) {
            FLog.INSTANCE.w("[zplan][MemePlayer-SDK][FilamentJsAppRecordContext]", "onRecordStart checkTask fail,  currentKey:" + this.recordKey + ", currentTaskId:" + taskId + ", dataTaskId:" + optInt);
            return;
        }
        int optInt2 = data.optInt("errorCode");
        JSONObject optJSONObject = data.optJSONObject("statistic");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = null;
        }
        String str2 = str;
        if (optInt2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("MemeRecordActionStatus", ERROR_ENGINE_RECORD_FAIL.INSTANCE.toInt());
            bundle.putInt("MemeRecordScriptErrorCode", optInt2);
            bundle.putString("MemeRecordScriptStatisticData", str2);
            getOperator().onRecordDone(this.recordKey, this.action.getActionId(), bundle);
            return;
        }
        float optInt3 = 1.0f / data.optInt("fps", 30);
        int optInt4 = data.optInt("totalFrameCount");
        Meme meme = Meme.f385754h;
        this.encoder.i(this.action.getActionId(), optInt3, optInt4, meme.q(this.recordKey), meme.v(this.recordKey, this.action.getMode()), str2, meme.l(this.recordKey));
    }

    public final void k(@NotNull ActionStatus status, @Nullable String path, @Nullable List<String> frames) {
        Intrinsics.checkNotNullParameter(status, "status");
        Runnable runnable = this.timeoutRunner;
        if (runnable != null) {
            f105813l.d(runnable);
        }
        boolean areEqual = Intrinsics.areEqual(status, RECORD_COMPLETE.INSTANCE);
        this.action.setActionStatus(status);
        MemeResult memeResult = new MemeResult(this.action, this.recordKey, path);
        if (this.action.getConfig().getSaveEachFrame2File()) {
            memeResult.m(frames);
        }
        if (this.action.getConfig().getMp4Config().getCover().getSaveCover()) {
            memeResult.l(Meme.f385754h.t(this.recordKey));
        }
        this.listener.l9(areEqual, memeResult);
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public IRecordOperator getOperator() {
        return this.operator;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final MemeRecordParams getRecordParams() {
        return this.recordParams;
    }

    public void o() {
        this.encoder.o(getOperator());
        this.action.getStatistic().w(Meme.f385754h.i());
        this.timeoutRunner = f105813l.c(d(this.action), FilamentBaseRecordContext.INSTANCE.a());
    }
}

package com.tencent.zplan.record.recorder;

import android.content.Context;
import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.COMPLETE;
import com.tencent.zplan.meme.action.ERROR_FORCE_STOPPED;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.action.START;
import com.tencent.zplan.meme.b;
import com.tencent.zplan.meme.d;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.model.ZPlanRecordFrameData;
import com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0013B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J9\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanSingleRecorder;", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", "Lcom/tencent/zplan/meme/b;", "T", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/meme/action/MemeAction;", "memeAction", "", "recordKey", "listener", "", "recordAction", "(Landroid/content/Context;Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Lcom/tencent/zplan/meme/b;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "Util", "a", "b", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeZPlanSingleRecorder extends MemeZPlanBaseRecorder {
    private static final String TAG = "[zplan][MemePlayer-SDK][MemeZPlanSingleRecorder]";

    /* renamed from: Util, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static float PROGRESS_ON_FRAME_START = 1.0f;
    private static float PROGRESS_ON_ENCODE_START = 51.0f;
    private static float PROGRESS_ON_ENCODE_END = 100.0f;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J,\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010 R\u001a\u0010&\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanSingleRecorder$a;", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext;", "", "c", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "recordKey", "", "portraitId", "Landroid/os/Bundle;", "data", "i", "Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "j", h.F, "e", "d", "g", "f", "Lcom/tencent/zplan/meme/action/ActionStatus;", "errorStatus", "k", "status", "path", "", "frames", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "timeoutRunner", "I", "totalFrameCount", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "B", "()Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "action", "Lcom/tencent/zplan/meme/d;", "listener", "Lcom/tencent/zplan/IZPlanRecordCallback;", "recordCallback", "Lcom/tencent/zplan/record/recorder/MemeZPlanSingleRecorder;", "recorder", "<init>", "(Lcom/tencent/zplan/meme/action/MemeZPlanAction;Ljava/lang/String;Lcom/tencent/zplan/meme/d;Lcom/tencent/zplan/IZPlanRecordCallback;Lcom/tencent/zplan/record/recorder/MemeZPlanSingleRecorder;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    private static final class a extends MemeZPlanBaseRecorder.BaseRecordContext {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private Runnable timeoutRunner;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int totalFrameCount;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MemeZPlanAction action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull MemeZPlanAction action, @NotNull String recordKey, @NotNull d listener, @NotNull IZPlanRecordCallback recordCallback, @NotNull MemeZPlanSingleRecorder recorder) {
            super(action, recordKey, listener, recordCallback, recorder);
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(recordCallback, "recordCallback");
            Intrinsics.checkNotNullParameter(recorder, "recorder");
            this.action = action;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void A(a aVar, ActionStatus actionStatus, String str, List list, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                list = null;
            }
            aVar.z(actionStatus, str, list);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        @NotNull
        /* renamed from: B, reason: from getter */
        public MemeZPlanAction getAction() {
            return this.action;
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void c() {
            getAction().getStatistic().w(Meme.f385754h.i());
            this.timeoutRunner = getThreadPool().c(u(getAction()), MemeZPlanBaseRecorder.INSTANCE.b());
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void d(int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("MemeRecordRealFrameCount");
            wx4.d statistic = getAction().getStatistic();
            statistic.r(Meme.f385754h.i());
            statistic.A(i3);
            ZLog.f386189b.k(MemeZPlanSingleRecorder.TAG, "action:" + getAction().getDesc() + " encode end, update progress.");
            getListener().d3(getAction(), MemeZPlanSingleRecorder.PROGRESS_ON_ENCODE_END);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void e(int portraitId) {
            getAction().getStatistic().s(Meme.f385754h.i());
            getListener().d3(getAction(), MemeZPlanSingleRecorder.PROGRESS_ON_ENCODE_START);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void f(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            ActionStatus actionStatus = ActionStatus.INSTANCE.toActionStatus(data.getInt("MemeRecordActionStatus"));
            String string = data.getString("MemeRecordCoverResultPath");
            boolean areEqual = Intrinsics.areEqual(actionStatus, RECORD_COMPLETE.INSTANCE);
            d dVar = null;
            MemeResult memeResult = new MemeResult(getAction(), recordKey, null);
            memeResult.l(new MemeResult.Cover(string, Meme.f385754h.m(recordKey)));
            d listener = getListener();
            if (listener instanceof b) {
                dVar = listener;
            }
            if (dVar != null) {
                dVar.ad(areEqual, memeResult);
            }
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void g(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            ActionStatus actionStatus = ActionStatus.INSTANCE.toActionStatus(data.getInt("MemeRecordActionStatus"));
            String string = data.getString("MemeRecordResultPath");
            ArrayList<String> stringArrayList = data.getStringArrayList("MemeRecordFramePathList");
            boolean z16 = data.getBoolean("MemeRecordOccurOOM");
            int i3 = data.getInt("MemeRecordScriptErrorCode");
            int i16 = data.getInt("MemeUseRecordV2");
            getAction().getStatistic().y(z16);
            getAction().getStatistic().F(i3);
            getAction().getStatistic().H(i16);
            z(actionStatus, string, stringArrayList);
            getRecorder().removeRecordContext$zplan_debug(recordKey);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void h(int portraitId, @NotNull Bundle data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString("MemeRecordScriptStatisticData");
            getAction().getStatistic().z(Meme.f385754h.i());
            if (string != null && string.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                getAction().getStatistic().G(string);
            }
            getListener().kg(getAction(), getRecordKey(), COMPLETE.INSTANCE);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void i(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString("MemeRecordScriptStatisticData");
            getAction().getStatistic().B(Meme.f385754h.i());
            if (string != null && string.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                getAction().getStatistic().G(string);
            }
            getListener().kg(getAction(), recordKey, START.INSTANCE);
            int i3 = data.getInt("MemeRecordTargetFrameCount");
            if (i3 == 0) {
                ZLog.f386189b.f(MemeZPlanSingleRecorder.TAG, "realCount 0, update progress error.");
                return;
            }
            this.totalFrameCount = i3;
            ZLog.f386189b.k(MemeZPlanSingleRecorder.TAG, "recordFrameStart, " + getAction().getDesc() + ", totalFrameCount:" + this.totalFrameCount);
            getListener().d3(getAction(), MemeZPlanSingleRecorder.PROGRESS_ON_FRAME_START);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void j(@NotNull ZPlanRecordFrameData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] frameData = data.getFrameData();
            if (frameData != null) {
                d listener = getListener();
                int frameTime = data.getFrameTime();
                MemeFrame memeFrame = new MemeFrame(getAction(), getRecordKey(), data.getIndex(), data.getWidth(), data.getHeight(), frameData, frameTime);
                if (this.totalFrameCount != 0) {
                    listener.d3(getAction(), (r9 / r1) * 0.5f);
                }
                listener.Z1(memeFrame);
            }
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void k(@NotNull ActionStatus errorStatus) {
            Intrinsics.checkNotNullParameter(errorStatus, "errorStatus");
            A(this, errorStatus, null, null, 6, null);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void l() {
            super.l();
            A(this, ERROR_FORCE_STOPPED.INSTANCE, null, null, 6, null);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        @NotNull
        public MemeRecordParams m() {
            return getAction().toMemeRecordParams();
        }

        public final void z(@NotNull ActionStatus status, @Nullable String path, @Nullable List<String> frames) {
            Intrinsics.checkNotNullParameter(status, "status");
            Runnable runnable = this.timeoutRunner;
            if (runnable != null) {
                getThreadPool().d(runnable);
            }
            v();
            boolean areEqual = Intrinsics.areEqual(status, RECORD_COMPLETE.INSTANCE);
            getAction().setActionStatus(status);
            MemeResult memeResult = new MemeResult(getAction(), getRecordKey(), path);
            if (getAction().getConfig().getSaveEachFrame2File()) {
                memeResult.m(frames);
            }
            if (getAction().getConfig().getMp4Config().getCover().getSaveCover()) {
                memeResult.l(Meme.f385754h.t(getRecordKey()));
            }
            getListener().l9(areEqual, memeResult);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanSingleRecorder$b;", "", "", "PROGRESS_ON_ENCODE_END", UserInfo.SEX_FEMALE, "PROGRESS_ON_ENCODE_START", "PROGRESS_ON_FRAME_START", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.recorder.MemeZPlanSingleRecorder$b, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder, com.tencent.zplan.meme.recorder.a
    public void onDestroy() {
        com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
        if (S != null) {
            a.C10063a.a(S, "N2L_ReleaseRecordRuntimeData", null, false, 6, null);
        }
        super.onDestroy();
    }

    @Override // com.tencent.zplan.meme.recorder.a
    public <T extends b> void recordAction(@NotNull Context context, @NotNull MemeAction memeAction, @NotNull String recordKey, @NotNull T listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(memeAction, "memeAction");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        a aVar = new a((MemeZPlanAction) memeAction, recordKey, (d) listener, getZPlanRecordCallback(), this);
        setRecordContext(recordKey, aVar);
        aVar.x();
    }
}

package com.tencent.zplan.record.recorder;

import android.content.Context;
import android.os.Bundle;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_ENGINE_PAUSED;
import com.tencent.zplan.meme.action.ERROR_FORCE_STOPPED;
import com.tencent.zplan.meme.action.ERROR_RESULT_INVALID;
import com.tencent.zplan.meme.action.ERROR_TIME_OUT;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.action.SUB_COMPLETE;
import com.tencent.zplan.meme.b;
import com.tencent.zplan.meme.d;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.model.ZPlanRecordFrameData;
import com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder;
import com.tencent.zplan.record.recorder.MemeZPlanBatchRecorder;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBatchRecorder;", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder;", "Lcom/tencent/zplan/meme/b;", "T", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/meme/action/MemeAction;", "memeAction", "", "recordKey", "listener", "", "recordAction", "(Landroid/content/Context;Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;Lcom/tencent/zplan/meme/b;)V", "<init>", "()V", "Util", "BatchRecordContext", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeZPlanBatchRecorder extends MemeZPlanBaseRecorder {
    private static final String TAG = "[zplan][MemePlayer-SDK][MemeZPlanBatchRecorder]";

    /* renamed from: Util, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J<\u0010#\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010!J\b\u0010$\u001a\u00020\u0004H\u0016R#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0%8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBatchRecorder$BatchRecordContext;", "Lcom/tencent/zplan/record/recorder/MemeZPlanBaseRecorder$BaseRecordContext;", "Lcom/tencent/zplan/meme/action/ActionStatus;", "errorStatus", "", "D", "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "action", "", "recordKey", "Lcom/tencent/zplan/meme/d;", "listener", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "c", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "portraitId", "Landroid/os/Bundle;", "data", "i", "Lcom/tencent/zplan/model/ZPlanRecordFrameData;", "j", h.F, "e", "d", "g", "f", "status", "path", "", "frames", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", "", "Ljava/util/Map;", "getSubActionTimeoutRunnerMap", "()Ljava/util/Map;", "subActionTimeoutRunnerMap", "", "Ljava/util/List;", "getRemainSubActionIds", "()Ljava/util/List;", "setRemainSubActionIds", "(Ljava/util/List;)V", "remainSubActionIds", "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "B", "()Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "Lcom/tencent/zplan/IZPlanRecordCallback;", "recordCallback", "Lcom/tencent/zplan/record/recorder/MemeZPlanBatchRecorder;", "recorder", "<init>", "(Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;Ljava/lang/String;Lcom/tencent/zplan/meme/d;Lcom/tencent/zplan/IZPlanRecordCallback;Lcom/tencent/zplan/record/recorder/MemeZPlanBatchRecorder;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    private static final class BatchRecordContext extends MemeZPlanBaseRecorder.BaseRecordContext {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, Runnable> subActionTimeoutRunnerMap;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<Integer> remainSubActionIds;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MemeZPlanBatchAction action;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BatchRecordContext(@NotNull MemeZPlanBatchAction action, @NotNull String recordKey, @NotNull d listener, @NotNull IZPlanRecordCallback recordCallback, @NotNull MemeZPlanBatchRecorder recorder) {
            super(action, recordKey, listener, recordCallback, recorder);
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(recordCallback, "recordCallback");
            Intrinsics.checkNotNullParameter(recorder, "recorder");
            this.action = action;
            this.subActionTimeoutRunnerMap = new LinkedHashMap();
            this.remainSubActionIds = new ArrayList();
        }

        public static /* synthetic */ void A(BatchRecordContext batchRecordContext, String str, int i3, ActionStatus actionStatus, String str2, List list, int i16, Object obj) {
            String str3;
            List list2;
            if ((i16 & 8) != 0) {
                str3 = null;
            } else {
                str3 = str2;
            }
            if ((i16 & 16) != 0) {
                list2 = null;
            } else {
                list2 = list;
            }
            batchRecordContext.z(str, i3, actionStatus, str3, list2);
        }

        private final Runnable C(final MemeZPlanBatchAction action, final String recordKey, final d listener) {
            return new Runnable() { // from class: com.tencent.zplan.record.recorder.MemeZPlanBatchRecorder$BatchRecordContext$getTimeoutRunner$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (MemeZPlanBatchRecorder.BatchRecordContext.this.getForceStopped()) {
                        ZLog.f386189b.k("[zplan][MemePlayer-SDK][MemeZPlanBatchRecorder]", "onTimeout forceStopped!! recordKey:" + recordKey);
                        return;
                    }
                    boolean k06 = ZPlanServiceHelper.I.k0();
                    ZLog.f386189b.f("[zplan][MemePlayer-SDK][MemeZPlanBatchRecorder]", action.getDesc() + " timeout(" + MemeZPlanBaseRecorder.INSTANCE.b() + "ms)!! callback timeout, enginePaused:" + k06);
                    if (k06) {
                        d dVar = listener;
                        MemeZPlanBatchAction memeZPlanBatchAction = action;
                        String str = recordKey;
                        ERROR_ENGINE_PAUSED error_engine_paused = ERROR_ENGINE_PAUSED.INSTANCE;
                        dVar.kg(memeZPlanBatchAction, str, error_engine_paused);
                        MemeZPlanBatchRecorder.BatchRecordContext.this.k(error_engine_paused);
                        return;
                    }
                    d dVar2 = listener;
                    MemeZPlanBatchAction memeZPlanBatchAction2 = action;
                    String str2 = recordKey;
                    ERROR_TIME_OUT error_time_out = ERROR_TIME_OUT.INSTANCE;
                    dVar2.kg(memeZPlanBatchAction2, str2, error_time_out);
                    MemeZPlanBatchRecorder.BatchRecordContext.this.k(error_time_out);
                }
            };
        }

        private final void D(ActionStatus errorStatus) {
            List list;
            list = CollectionsKt___CollectionsKt.toList(this.remainSubActionIds);
            ZLog.f386189b.k(MemeZPlanBatchRecorder.TAG, "doOnStatusError, remainSubActionId size: " + list.size() + ", error status: " + errorStatus);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                getAction().clearCache(intValue);
                A(this, getAction().getKey(), intValue, errorStatus, null, null, 24, null);
            }
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        @NotNull
        /* renamed from: B, reason: from getter */
        public MemeZPlanBatchAction getAction() {
            return this.action;
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void c() {
            List list;
            list = CollectionsKt___CollectionsKt.toList(this.remainSubActionIds);
            long i3 = Meme.f385754h.i();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                getAction().getStatisticById(((Number) it.next()).intValue()).w(i3);
            }
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void d(int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ZLog.f386189b.k(MemeZPlanBatchRecorder.TAG, getAction().getDesc() + " encode end, update progress.");
            int i3 = data.getInt("MemeRecordRealFrameCount");
            wx4.d statisticById = getAction().getStatisticById(portraitId);
            statisticById.r(Meme.f385754h.i());
            statisticById.A(i3);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void e(int portraitId) {
            getAction().getStatisticById(portraitId).s(Meme.f385754h.i());
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
            memeResult.n(new MemeResult.Sub(portraitId, ""));
            memeResult.l(new MemeResult.Cover(string, Meme.f385754h.m(getAction().getSingleActionKey(portraitId))));
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
            wx4.d statisticById = getAction().getStatisticById(portraitId);
            statisticById.y(z16);
            statisticById.F(i3);
            z(recordKey, portraitId, actionStatus, string, stringArrayList);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void h(int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString("MemeRecordScriptStatisticData");
            wx4.d statisticById = getAction().getStatisticById(portraitId);
            statisticById.z(Meme.f385754h.i());
            statisticById.G(string);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void i(@NotNull String recordKey, int portraitId, @NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(data, "data");
            getAction().getStatisticById(portraitId).B(Meme.f385754h.i());
            this.subActionTimeoutRunnerMap.put(getAction().getSingleActionKey(portraitId), getThreadPool().c(C(getAction(), recordKey, getListener()), MemeZPlanBaseRecorder.INSTANCE.b()));
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void j(@NotNull ZPlanRecordFrameData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] frameData = data.getFrameData();
            if (frameData != null) {
                d listener = getListener();
                int frameTime = data.getFrameTime();
                listener.Z1(new MemeFrame(getAction(), getRecordKey(), data.getIndex(), data.getWidth(), data.getHeight(), frameData, frameTime));
            }
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void k(@NotNull ActionStatus errorStatus) {
            Intrinsics.checkNotNullParameter(errorStatus, "errorStatus");
            D(errorStatus);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void l() {
            super.l();
            D(ERROR_FORCE_STOPPED.INSTANCE);
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        @NotNull
        public MemeRecordParams m() {
            return getAction().toMemeRecordParams();
        }

        @Override // com.tencent.zplan.record.recorder.MemeZPlanBaseRecorder.BaseRecordContext
        public void x() {
            this.remainSubActionIds.addAll(getAction().getRealNeedRecordIds());
            super.x();
        }

        public final synchronized void z(@NotNull String recordKey, int portraitId, @NotNull ActionStatus status, @Nullable String path, @Nullable List<String> frames) {
            Pair pair;
            Object obj;
            Intrinsics.checkNotNullParameter(recordKey, "recordKey");
            Intrinsics.checkNotNullParameter(status, "status");
            String singleActionKey = getAction().getSingleActionKey(portraitId);
            Runnable remove = this.subActionTimeoutRunnerMap.remove(singleActionKey);
            if (remove != null) {
                getThreadPool().d(remove);
            }
            this.remainSubActionIds.remove(Integer.valueOf(portraitId));
            if (this.remainSubActionIds.size() == 0) {
                v();
                getRecorder().removeRecordContext$zplan_debug(recordKey);
            }
            MemeResult memeResult = new MemeResult(getAction(), recordKey, path);
            memeResult.n(new MemeResult.Sub(portraitId, singleActionKey));
            if (memeResult.getAction().getConfig().getSaveEachFrame2File() || memeResult.getAction().getMode() == MODE.SEQFRAMES) {
                memeResult.m(frames);
            }
            if (memeResult.getAction().getConfig().getMp4Config().getCover().getSaveCover()) {
                memeResult.l(Meme.f385754h.t(singleActionKey));
            }
            if (Intrinsics.areEqual(status, RECORD_COMPLETE.INSTANCE)) {
                boolean isResultValid = memeResult.isResultValid();
                Boolean valueOf = Boolean.valueOf(isResultValid);
                if (isResultValid) {
                    obj = SUB_COMPLETE.INSTANCE;
                } else {
                    obj = ERROR_RESULT_INVALID.INSTANCE;
                }
                pair = new Pair(valueOf, obj);
            } else {
                pair = new Pair(Boolean.FALSE, status);
            }
            boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
            ActionStatus actionStatus = (ActionStatus) pair.component2();
            ZLog.f386189b.k(MemeZPlanBatchRecorder.TAG, "doOnRecordDone, " + singleActionKey + ", success:" + booleanValue + ", finalStatus:" + actionStatus + ", path:" + path);
            getAction().setActionStatus(actionStatus);
            getListener().l9(booleanValue, memeResult);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/zplan/record/recorder/MemeZPlanBatchRecorder$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.recorder.MemeZPlanBatchRecorder$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.zplan.meme.recorder.a
    public <T extends b> void recordAction(@NotNull Context context, @NotNull MemeAction memeAction, @NotNull String recordKey, @NotNull T listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(memeAction, "memeAction");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BatchRecordContext batchRecordContext = new BatchRecordContext((MemeZPlanBatchAction) memeAction, recordKey, (d) listener, getZPlanRecordCallback(), this);
        setRecordContext(recordKey, batchRecordContext);
        batchRecordContext.x();
    }
}

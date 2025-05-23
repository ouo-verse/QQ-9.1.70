package com.tencent.mobileqq.guild.feed.publish;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.FeedDeleteTempMediaEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCallPostFeedTaskFacadeMethodEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCreateTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftNativeAutoRestoreEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftTaskResponseEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedPublishQualityEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildGetDraftTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildModifyUploadTaskEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishFeedTaskRebindInfoEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRemoveFakeFeedTaskEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildSaveDraftTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskOperationCreatedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildUploadMediaOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PassiveCancellationException;
import com.tencent.mobileqq.guild.feed.util.al;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkpublish.config.GuildUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.event.GuildUploadStateEvent;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildTaskQueueManager implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private static volatile GuildTaskQueueManager f222868i;

    /* renamed from: d, reason: collision with root package name */
    private GuildUploadLocalConfig f222869d;

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<GuildSingleMainTask> f222870e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, IPerformanceReportTask> f222871f = new ConcurrentHashMap(4);

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f222872h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements GuildDbDataHelper.a<List<GuildTaskProgressState>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildRetryTaskOperationEvent f222874a;

        a(GuildRetryTaskOperationEvent guildRetryTaskOperationEvent) {
            this.f222874a = guildRetryTaskOperationEvent;
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(List<GuildTaskProgressState> list) {
            if (bl.b(list)) {
                QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleRetryTaskOperationEvent] onResult, list == null");
                return;
            }
            GuildTaskQueueManager.this.J(this.f222874a, GuildTaskQueueManager.this.O(list.get(0)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements GuildDbDataHelper.a<List<GuildTaskProgressState>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildDbDataHelper.a f222876a;

        b(GuildDbDataHelper.a aVar) {
            this.f222876a = aVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(List<GuildTaskProgressState> list) {
            int size;
            if (list != null) {
                Iterator<GuildTaskProgressState> it = list.iterator();
                while (it.hasNext()) {
                    GuildTaskQueueManager.this.O(it.next());
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[queryDbFailTaskList]  list.size = ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.i("GUP-T-GuildTaskQueueManager", 1, sb5.toString());
            GuildDbDataHelper.a aVar = this.f222876a;
            if (aVar != null) {
                aVar.onResult(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends JSONObject {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildRetryTaskOperationEvent f222878b;

        /* compiled from: P */
        /* loaded from: classes13.dex */
        class a extends JSONObject {
            a(String str) throws JSONException {
                super(str);
                JSONObject jSONObject = getJSONObject("channelInfo");
                jSONObject.getJSONObject("sign").put("channel_id", c.this.f222878b.forcePostChannelId);
                put("channelInfo", jSONObject);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, GuildRetryTaskOperationEvent guildRetryTaskOperationEvent) throws JSONException {
            super(str);
            this.f222878b = guildRetryTaskOperationEvent;
            put("jsonFeed", new a(optString("jsonFeed", "{}")).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements GuildDbDataHelper.a<List<GuildTaskProgressState>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildGetDraftTaskOperationEvent f222881a;

        d(GuildGetDraftTaskOperationEvent guildGetDraftTaskOperationEvent) {
            this.f222881a = guildGetDraftTaskOperationEvent;
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(List<GuildTaskProgressState> list) {
            String str;
            if (list != null) {
                Iterator<GuildTaskProgressState> it = list.iterator();
                while (it.hasNext()) {
                    GuildTaskProgressState next = it.next();
                    if (next.isTriggerPublish() || next.mScope != this.f222881a.getScope()) {
                        it.remove();
                        QLog.d("GUP-T-GuildTaskQueueManager", 1, "[handleGetDraftTaskOperationEvent]  find task is publish task, remove  | mainTaskId = " + next.getMainTaskId());
                    }
                }
            }
            GuildDraftTaskResponseEvent guildDraftTaskResponseEvent = new GuildDraftTaskResponseEvent(String.valueOf(System.currentTimeMillis()));
            guildDraftTaskResponseEvent.setRequestEvent(this.f222881a);
            if (bl.b(list)) {
                QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleGetDraftTaskOperationEvent] onResult, list == null");
                SimpleEventBus.getInstance().dispatchEvent(guildDraftTaskResponseEvent, true);
                return;
            }
            Iterator<GuildTaskProgressState> it5 = list.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                GuildTaskProgressState next2 = it5.next();
                if (next2.isTriggerSave() && next2.getMainTaskId().startsWith(this.f222881a.getPublisherType())) {
                    GuildTaskQueueManager.this.O(next2);
                    guildDraftTaskResponseEvent.setMainTaskId(next2.getMainTaskId());
                    guildDraftTaskResponseEvent.setFeedJson(next2.getJson());
                    String str2 = "";
                    if (next2.getGuildId() == null) {
                        str = "";
                    } else {
                        str = next2.getGuildId();
                    }
                    if (next2.getChannelId() != null) {
                        str2 = next2.getChannelId();
                    }
                    guildDraftTaskResponseEvent.setGuildContact(new GuildSimpleContact(str, str2));
                }
            }
            GuildDraftTaskResponseEvent.saveInMMKVIfNeeded(guildDraftTaskResponseEvent);
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleGetDraftTaskOperationEvent] onResult, find and response  | list.size = " + list.size() + " | responseEvent = " + guildDraftTaskResponseEvent.toString());
            SimpleEventBus.getInstance().dispatchEvent(guildDraftTaskResponseEvent, this.f222881a.isIpcEvent());
        }
    }

    private void A(final GuildTriggerPublishOperationEvent guildTriggerPublishOperationEvent) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (TextUtils.isEmpty(guildTriggerPublishOperationEvent.getMainTaskId())) {
                    QLog.e("GUP-T-GuildTaskQueueManager", 1, "[handleTriggerPublishOperationEvent]  mainTaskId == null");
                    return;
                }
                if (guildTriggerPublishOperationEvent.getJson() == null) {
                    QLog.e("GUP-T-GuildTaskQueueManager", 1, "json == null");
                    return;
                }
                GuildSingleMainTask k3 = GuildTaskQueueManager.this.k(guildTriggerPublishOperationEvent.getMainTaskId());
                if (k3 != null) {
                    GuildTaskQueueManager.this.h(guildTriggerPublishOperationEvent.getMainTaskId(), guildTriggerPublishOperationEvent.mediaInfoMap);
                    QLog.i("GUP-T-GuildTaskQueueManager", 1, "triggerPublish  | task = " + k3 + " | mainTaskId = " + guildTriggerPublishOperationEvent.getMainTaskId());
                    GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(guildTriggerPublishOperationEvent.getMainTaskId());
                    if (q16 != null) {
                        if (q16.isTriggerPublish()) {
                            str = "sendboxedit";
                        } else if (q16.isEdit()) {
                            str = "detailedit";
                        } else {
                            str = "newpublish";
                        }
                        GuildTaskQueueManager.this.G("CH_E_POST_START", q16, str);
                    }
                    k3.V(guildTriggerPublishOperationEvent.showSuccessToast);
                    k3.U(guildTriggerPublishOperationEvent.showFailToast);
                    k3.P(guildTriggerPublishOperationEvent.isEdit());
                    k3.T(guildTriggerPublishOperationEvent.isPersonalGuildToBeCreated());
                    k3.Q(guildTriggerPublishOperationEvent.isMileStoneFeed());
                    k3.J(guildTriggerPublishOperationEvent.getJson(), guildTriggerPublishOperationEvent.isNewFeed());
                    return;
                }
                QLog.e("GUP-T-GuildTaskQueueManager", 1, "[handleTriggerPublishOperationEvent]  not find publishTask in taskQueue | mainTaskId = " + guildTriggerPublishOperationEvent.getMainTaskId());
            }
        });
    }

    private void B(final GuildUploadMediaOperationEvent guildUploadMediaOperationEvent) {
        final Map<String, LocalMediaInfo> taskIdLocalMediaInfoMap = guildUploadMediaOperationEvent.getTaskIdLocalMediaInfoMap();
        if (taskIdLocalMediaInfoMap != null) {
            Iterator<Map.Entry<String, LocalMediaInfo>> it = taskIdLocalMediaInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().isRwa = guildUploadMediaOperationEvent.getOriginalPic();
            }
        }
        if (!guildUploadMediaOperationEvent.getNeedSwitchThread()) {
            Q(guildUploadMediaOperationEvent.getMainTaskId(), taskIdLocalMediaInfoMap);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.aa
                @Override // java.lang.Runnable
                public final void run() {
                    GuildTaskQueueManager.this.E(guildUploadMediaOperationEvent, taskIdLocalMediaInfoMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent2 = (GuildSaveDraftTaskOperationEvent) guildSaveDraftTaskOperationEvent.restoreFromFile();
        if (guildSaveDraftTaskOperationEvent2 != null) {
            z(guildSaveDraftTaskOperationEvent2);
        } else {
            QLog.e("GUP-T-GuildTaskQueueManager", 1, "[handleSaveDraftTaskOperationEvent]: restore event fails");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(GuildUploadMediaOperationEvent guildUploadMediaOperationEvent, Map map) {
        Q(guildUploadMediaOperationEvent.getMainTaskId(), map);
    }

    private void F(String str, String str2, int i3, String str3, GuildSingleMainTask guildSingleMainTask) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            guildSingleMainTask.K(str, str2);
            GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(guildSingleMainTask.b());
            if (q16 == null) {
                QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleReBindChannelInfo] id=" + str3 + " taskProgressState is null!");
                return;
            }
            q16.setGuildId(str);
            q16.setChannelId(str2);
            q16.setBusinessType(i3);
            GuildDbDataHelper.s().O(q16);
            return;
        }
        QLog.e("GUP-T-GuildTaskQueueManager", 1, "[handleReBindChannelInfo] guildId=" + str + " channelId=" + str2 + " empty ids");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, GuildTaskProgressState guildTaskProgressState, String str2) {
        if (guildTaskProgressState == null) {
            return;
        }
        n().uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str).setTraceId(guildTaskProgressState.getMainTaskId()).setExt1(al.c(guildTaskProgressState.getMediaProgressStates())).setExt2(String.valueOf(guildTaskProgressState.getMediaProgressStates().size())).setExt3(al.a(guildTaskProgressState.getMediaProgressStates())).setExt4(al.b(guildTaskProgressState.getMediaProgressStates())).setExt5(str2));
    }

    private void H(String str, String str2, String str3, int i3) {
        n().uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str).setTraceId(str3).setExt1(str2).setExt2(str3).setExt3(String.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(GuildRetryTaskOperationEvent guildRetryTaskOperationEvent, GuildSingleMainTask guildSingleMainTask) {
        if (guildSingleMainTask != null && guildRetryTaskOperationEvent != null) {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[reallyRetryTaskOperation]  | mainTask = " + guildSingleMainTask.toString() + " | event = " + guildRetryTaskOperationEvent.toString());
            if (guildRetryTaskOperationEvent.getType() == 1) {
                guildSingleMainTask.H(guildRetryTaskOperationEvent.getTaskId());
                H("CH_E_MEDIA_RE_UPLOAD", guildSingleMainTask.t(guildRetryTaskOperationEvent.getTaskId()), guildRetryTaskOperationEvent.getTaskId(), guildSingleMainTask.r());
                return;
            }
            if (guildRetryTaskOperationEvent.getType() == 2) {
                km1.a.f412694a.d(guildSingleMainTask, guildRetryTaskOperationEvent.isAutoRetryReportValue());
                if (!TextUtils.isEmpty(guildRetryTaskOperationEvent.forcePostChannelId) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("bug138435103", true)) {
                    try {
                        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(guildSingleMainTask.b());
                        if (q16 != null) {
                            guildSingleMainTask.R(new c(guildSingleMainTask.q(), guildRetryTaskOperationEvent).toString());
                            guildSingleMainTask.K(guildSingleMainTask.n().getGuildId(), guildRetryTaskOperationEvent.forcePostChannelId);
                            q16.setChannelId(guildRetryTaskOperationEvent.forcePostChannelId);
                            GuildDbDataHelper.s().O(q16);
                        } else {
                            QLog.e("GUP-T-GuildTaskQueueManager", 1, "[reallyRetryTaskOperation] taskProgressState == null");
                        }
                    } catch (Exception e16) {
                        QLog.e("GUP-T-GuildTaskQueueManager", 1, "[reallyRetryTaskOperation] error = " + e16);
                    }
                }
                guildSingleMainTask.U(guildRetryTaskOperationEvent.showFailToast);
                guildSingleMainTask.V(guildRetryTaskOperationEvent.showSuccessToast);
                guildSingleMainTask.J(guildSingleMainTask.q(), false);
            }
        }
    }

    private void K(GuildSingleMainTask guildSingleMainTask) {
        if (guildSingleMainTask != null) {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[removeTaskInTaskQueue]  mainTaskId = " + guildSingleMainTask.b());
            this.f222870e.remove(guildSingleMainTask);
            guildSingleMainTask.C();
            if (guildSingleMainTask.p()) {
                SimpleEventBus.getInstance().dispatchEvent(new FeedDeleteTempMediaEvent(guildSingleMainTask.b()));
            }
        }
    }

    private void N(@NonNull GuildSingleMainTask guildSingleMainTask, @NonNull GuildCreateTaskOperationEvent guildCreateTaskOperationEvent) {
        in1.c uploadTaskApi = guildSingleMainTask.s().getUploadTaskApi();
        Boolean enablePreUpload = guildCreateTaskOperationEvent.getEnablePreUpload();
        if (enablePreUpload != null) {
            uploadTaskApi.g(enablePreUpload.booleanValue());
        }
        if (uploadTaskApi.getIsEnablePreUpload()) {
            uploadTaskApi.a(guildCreateTaskOperationEvent.isPreUploadGuardByNetworkCondition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GuildSingleMainTask O(GuildTaskProgressState guildTaskProgressState) {
        boolean z16;
        if (guildTaskProgressState == null) {
            return null;
        }
        GuildSingleMainTask k3 = k(guildTaskProgressState.getMainTaskId());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[taskStateTransformToMainTask]  | taskState = ");
        sb5.append(guildTaskProgressState.toString());
        sb5.append(" | needCreate = ");
        if (k3 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GUP-T-GuildTaskQueueManager", 1, sb5.toString());
        if (k3 == null) {
            GuildSingleMainTask guildSingleMainTask = new GuildSingleMainTask(guildTaskProgressState.getMainTaskId(), guildTaskProgressState.getGuildId(), guildTaskProgressState.getChannelId(), guildTaskProgressState.getMainState(), guildTaskProgressState.isEdit(), guildTaskProgressState.mBusinessType, guildTaskProgressState.mReportMap, guildTaskProgressState.mScope);
            guildSingleMainTask.R(guildTaskProgressState.getJson());
            guildSingleMainTask.O(guildTaskProgressState);
            this.f222870e.add(guildSingleMainTask);
            return guildSingleMainTask;
        }
        return k3;
    }

    private void Q(String str, Map<String, LocalMediaInfo> map) {
        if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            GuildSingleMainTask k3 = k(str);
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[uploadMediaOperation]  | task = " + k3 + " | mainTaskId = " + k3 + " | localMediaInfos.size = " + map.size());
            if (k3 == null) {
                return;
            }
            for (Map.Entry<String, LocalMediaInfo> entry : map.entrySet()) {
                k3.s().getUploadTaskApi().f(entry.getKey(), entry.getValue());
            }
            return;
        }
        QLog.w("GUP-T-GuildTaskQueueManager", 1, "[uploadMediaOperation]  mainTaskId == null || localMediaInfos == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, Map<String, LocalMediaInfo> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "[batchUploadMedia]  mainTaskId == null || localMediaInfos == null");
            return;
        }
        if (map == null) {
            return;
        }
        GuildSingleMainTask k3 = k(str);
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[batchUploadMedia]  | task = " + k3 + " | mainTaskId = " + k3 + " | localMediaInfos.size = " + map.size());
        if (k3 == null) {
            return;
        }
        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(str);
        if (q16 == null) {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[batchUploadMedia] taskProgressState == null");
            return;
        }
        LinkedList linkedList = new LinkedList(q16.getMediaProgressStates());
        Iterator it = linkedList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            GuildMediaProgressState guildMediaProgressState = (GuildMediaProgressState) it.next();
            if (!map.containsKey(guildMediaProgressState.getTaskId())) {
                k3.k(guildMediaProgressState.getTaskId());
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            q16.setMediaProgressStates(linkedList);
        }
        for (Map.Entry<String, LocalMediaInfo> entry : map.entrySet()) {
            k3.j(entry.getKey(), entry.getValue(), entry.getValue().isRwa);
            H("CH_E_MEDIA_UPLOAD", k3.t(entry.getKey()), entry.getKey(), k3.r());
        }
    }

    private void l(@NonNull GuildTaskProgressState guildTaskProgressState) {
        String mainTaskId = guildTaskProgressState.getMainTaskId();
        GuildSingleMainTask k3 = k(mainTaskId);
        if (k3 != null && !k3.x()) {
            guildTaskProgressState.setMainState(5);
            guildTaskProgressState.setPublishErrCode(Constant.FROM_ID_UNINSTALL_PLUGIN);
            guildTaskProgressState.setPublishErrMsg(HardCodeUtil.qqStr(R.string.f145170qr));
            SimpleEventBus.getInstance().dispatchEvent(new GuildTaskProgressStateEvent(guildTaskProgressState));
            GuildDbDataHelper.s().P("forwardTaskStateToFailed", guildTaskProgressState.m184clone());
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GUP-T-GuildTaskQueueManager", 4, "[forwardTaskStateToFailed]: taskId=" + mainTaskId + " is not trigger yet");
        }
    }

    public static GuildTaskQueueManager m() {
        if (f222868i == null) {
            synchronized (GuildTaskQueueManager.class) {
                if (f222868i == null) {
                    f222868i = new GuildTaskQueueManager();
                }
            }
        }
        return f222868i;
    }

    private void o() {
        onDestroy();
    }

    private void p(GuildCancelTaskOperationEvent guildCancelTaskOperationEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleCancelTaskOperationEvent]  event = " + guildCancelTaskOperationEvent.toString());
        GuildSingleMainTask k3 = k(guildCancelTaskOperationEvent.getMainTaskId());
        if (k3 == null) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleCancelTaskOperationEvent] queueList mainTask == null");
        }
        if (guildCancelTaskOperationEvent.getType() == 2) {
            if (k3 != null) {
                k3.D(null);
            }
            K(k3);
            GuildTaskProgressBoxHelper.o().y(guildCancelTaskOperationEvent.getMainTaskId());
            GuildDbDataHelper.s().q(guildCancelTaskOperationEvent.getMainTaskId());
            GuildRemoveFakeFeedTaskEvent guildRemoveFakeFeedTaskEvent = new GuildRemoveFakeFeedTaskEvent();
            guildRemoveFakeFeedTaskEvent.setMainTaskId(guildCancelTaskOperationEvent.getMainTaskId());
            SimpleEventBus.getInstance().dispatchEvent(guildRemoveFakeFeedTaskEvent);
            G("CH_E_DISCARD_EDIT_SEL_DISCARD_EXIT", GuildTaskProgressBoxHelper.o().q(guildCancelTaskOperationEvent.getMainTaskId()), null);
            if (k3 != null) {
                km1.a.f412694a.h(k3.b(), guildCancelTaskOperationEvent.getReportCancelType());
            }
        }
    }

    private void r(GuildDraftNativeAutoRestoreEvent guildDraftNativeAutoRestoreEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleDraftNativeAutoRestoreEvent]  event = " + guildDraftNativeAutoRestoreEvent.toString());
        GuildSingleMainTask k3 = k(guildDraftNativeAutoRestoreEvent.getMainTaskId());
        if (k3 == null) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleDraftNativeAutoRestoreEvent] queueList mainTask == null");
        } else {
            k3.Y(k3.r());
            G("CH_E_LOAD_DRAFT_SEL_LOAD", GuildTaskProgressBoxHelper.o().q(guildDraftNativeAutoRestoreEvent.getMainTaskId()), null);
        }
    }

    private void s(GuildGetDraftTaskOperationEvent guildGetDraftTaskOperationEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleGetDraftTaskOperationEvent]  event = " + guildGetDraftTaskOperationEvent.toString());
        d dVar = new d(guildGetDraftTaskOperationEvent);
        if (guildGetDraftTaskOperationEvent.getScope() == 1) {
            GuildDbDataHelper.s().K(guildGetDraftTaskOperationEvent.getScope(), dVar);
        } else {
            GuildDbDataHelper.s().F(guildGetDraftTaskOperationEvent.getGuildId(), guildGetDraftTaskOperationEvent.getChannelId(), dVar);
        }
    }

    private void t(GuildFeedPublishQualityEvent guildFeedPublishQualityEvent) {
        n().uploadQualityReport(guildFeedPublishQualityEvent.getBuilder());
    }

    private void u(GuildModifyUploadTaskEvent guildModifyUploadTaskEvent) {
        GuildSingleMainTask k3 = k(guildModifyUploadTaskEvent.getMainTaskId());
        if (k3 == null) {
            QLog.e("GUP-T-GuildTaskQueueManager", 1, "[handleGuildModifyUploadTaskEvent] maintask is null!");
            return;
        }
        QLog.d("GUP-T-GuildTaskQueueManager", 1, "[handleGuildModifyUploadTaskEvent], event: " + guildModifyUploadTaskEvent);
        mn1.b.f(guildModifyUploadTaskEvent, k3);
    }

    private void v(@NonNull FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent) {
        if (onStartPublishFeedEvent.getTopicIds().isEmpty()) {
            return;
        }
        long longValue = onStartPublishFeedEvent.getTopicIds().iterator().next().longValue();
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "handleOnStartPublishEvent|topicId=" + longValue);
        GuildSingleMainTask k3 = k(onStartPublishFeedEvent.getMainTaskId());
        if (k3 == null) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "handleOnStartPublishEvent|mainTask of " + onStartPublishFeedEvent.getMainTaskId() + " not exist");
            return;
        }
        k3.u(new ln1.a(longValue));
    }

    private void w(GuildPublishFeedTaskRebindInfoEvent guildPublishFeedTaskRebindInfoEvent) {
        String mainTaskId = guildPublishFeedTaskRebindInfoEvent.getMainTaskId();
        GuildSingleMainTask k3 = k(mainTaskId);
        if (k3 == null) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "[handleReBindChannelInfo] id=" + mainTaskId + " not found");
            return;
        }
        Boolean isPersonalGuildToBeCreated = guildPublishFeedTaskRebindInfoEvent.getIsPersonalGuildToBeCreated();
        if (isPersonalGuildToBeCreated != null) {
            k3.T(isPersonalGuildToBeCreated.booleanValue());
        }
        if (guildPublishFeedTaskRebindInfoEvent.getContact() == null) {
            return;
        }
        F(guildPublishFeedTaskRebindInfoEvent.getContact().getGuildId(), guildPublishFeedTaskRebindInfoEvent.getContact().getChannelId(), guildPublishFeedTaskRebindInfoEvent.getBusinessType(), mainTaskId, k3);
    }

    private void x(GuildRetryTaskOperationEvent guildRetryTaskOperationEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleRetryTaskOperationEvent]  event = " + guildRetryTaskOperationEvent.toString());
        GuildSingleMainTask k3 = k(guildRetryTaskOperationEvent.getMainTaskId());
        if (k3 == null) {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleRetryTaskOperationEvent]  mainTask == null, need find from db");
            GuildDbDataHelper.s().H(guildRetryTaskOperationEvent.getMainTaskId(), new a(guildRetryTaskOperationEvent));
        } else {
            J(guildRetryTaskOperationEvent, k3);
        }
    }

    private void y(final GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleSaveDraftTaskOperationEvent]  event = " + guildSaveDraftTaskOperationEvent.toString());
        if (guildSaveDraftTaskOperationEvent.getIsRestore()) {
            z(guildSaveDraftTaskOperationEvent);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.ab
                @Override // java.lang.Runnable
                public final void run() {
                    GuildTaskQueueManager.this.D(guildSaveDraftTaskOperationEvent);
                }
            }, 80, null, false);
        }
    }

    private void z(GuildSaveDraftTaskOperationEvent guildSaveDraftTaskOperationEvent) {
        M(guildSaveDraftTaskOperationEvent.getMainTaskId(), guildSaveDraftTaskOperationEvent.getFeedJson(), guildSaveDraftTaskOperationEvent.getFeedPublishJson(), guildSaveDraftTaskOperationEvent.getScope());
        G("CH_E_SAVE_DRAFT_SEL_SAVE_EXIT", GuildTaskProgressBoxHelper.o().q(guildSaveDraftTaskOperationEvent.getMainTaskId()), null);
    }

    public synchronized void C() {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "init");
        if (this.f222872h) {
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f222869d = new GuildUploadLocalConfig();
        this.f222872h = true;
    }

    public void I(String str, String str2, GuildDbDataHelper.a<List<GuildTaskProgressState>> aVar) {
        GuildDbDataHelper.s().D(str, str2, true, 0, new b(aVar));
    }

    public void L(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        K(k(str));
    }

    public void M(String str, String str2, String str3, int i3) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[saveDraftTaskOperation]  | mainTaskId = " + str + " | draftJson = " + str2);
        GuildSingleMainTask k3 = k(str);
        if (k3 == null) {
            QLog.w("GUP-T-GuildTaskQueueManager", 1, "[saveDraftTaskOperation] queueList mainTask == null");
            return;
        }
        if (str3 != null) {
            k3.R(str3);
        }
        try {
            String optString = new JSONObject(str2).optString("jsonFeed");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject = new JSONObject(optString);
                if (jSONObject.has("publishExtra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("publishExtra");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("sceneType", jSONObject2.getInt("sceneType"));
                    jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, jSONObject2.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    jSONObject3.put("originJsonFeed", jSONObject2.getString("originJsonFeed"));
                    jSONObject3.put("contentJsonFeed", optString);
                    GuildTaskProgressBoxHelper.o().C(str, jSONObject3.toString(), i3);
                    return;
                }
            }
            GuildTaskProgressBoxHelper.o().C(str, str2, i3);
        } catch (Exception e16) {
            QLog.e("GUP-T-GuildTaskQueueManager", 1, "saveDraftTaskOperation error ! " + e16);
        }
    }

    public void P(@NonNull String str) {
        this.f222871f.remove(str);
    }

    public void g(List<GuildTaskProgressState> list) {
        for (GuildTaskProgressState guildTaskProgressState : list) {
            if (guildTaskProgressState != null && GuildSingleMainTask.w(guildTaskProgressState.getMainState())) {
                l(guildTaskProgressState);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildCreateTaskOperationEvent.class);
        arrayList.add(GuildUploadMediaOperationEvent.class);
        arrayList.add(GuildTriggerPublishOperationEvent.class);
        arrayList.add(GuildGetDraftTaskOperationEvent.class);
        arrayList.add(GuildRetryTaskOperationEvent.class);
        arrayList.add(GuildCancelTaskOperationEvent.class);
        arrayList.add(GuildSaveDraftTaskOperationEvent.class);
        arrayList.add(AccountChangeEvent.class);
        arrayList.add(GuildFeedPublishQualityEvent.class);
        arrayList.add(GuildDraftNativeAutoRestoreEvent.class);
        arrayList.add(GuildModifyUploadTaskEvent.class);
        arrayList.add(GuildUploadStateEvent.class);
        arrayList.add(GuildPublishFeedTaskRebindInfoEvent.class);
        arrayList.add(FeedEditorEvent.OnStartPublishFeedEvent.class);
        arrayList.add(GuildCallPostFeedTaskFacadeMethodEvent.class);
        return arrayList;
    }

    public void i(@NonNull String str, @NonNull IPerformanceReportTask iPerformanceReportTask) {
        this.f222871f.put(str, iPerformanceReportTask);
    }

    @Nullable
    public IPerformanceReportTask j(@NonNull String str) {
        return this.f222871f.get(str);
    }

    public GuildSingleMainTask k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<GuildSingleMainTask> it = this.f222870e.iterator();
        while (it.hasNext()) {
            GuildSingleMainTask next = it.next();
            if (TextUtils.equals(str, next.b())) {
                return next;
            }
        }
        return null;
    }

    public GuildUploadLocalConfig n() {
        if (this.f222869d == null) {
            this.f222869d = new GuildUploadLocalConfig();
        }
        return this.f222869d;
    }

    public void onDestroy() {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (!this.f222870e.isEmpty()) {
            PassiveCancellationException passiveCancellationException = new PassiveCancellationException("account change");
            Iterator<GuildSingleMainTask> it = this.f222870e.iterator();
            while (it.hasNext()) {
                GuildSingleMainTask next = it.next();
                if (next != null) {
                    next.D(passiveCancellationException);
                }
            }
        }
        this.f222870e.clear();
        GuildTaskProgressBoxHelper.o().n();
        this.f222871f.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildCreateTaskOperationEvent) {
            q((GuildCreateTaskOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildUploadMediaOperationEvent) {
            B((GuildUploadMediaOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildTriggerPublishOperationEvent) {
            A((GuildTriggerPublishOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildGetDraftTaskOperationEvent) {
            s((GuildGetDraftTaskOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildRetryTaskOperationEvent) {
            x((GuildRetryTaskOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildCancelTaskOperationEvent) {
            p((GuildCancelTaskOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildSaveDraftTaskOperationEvent) {
            y((GuildSaveDraftTaskOperationEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            o();
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedPublishQualityEvent) {
            t((GuildFeedPublishQualityEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildDraftNativeAutoRestoreEvent) {
            r((GuildDraftNativeAutoRestoreEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildModifyUploadTaskEvent) {
            u((GuildModifyUploadTaskEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildPublishFeedTaskRebindInfoEvent) {
            w((GuildPublishFeedTaskRebindInfoEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof FeedEditorEvent.OnStartPublishFeedEvent) {
            v((FeedEditorEvent.OnStartPublishFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildCallPostFeedTaskFacadeMethodEvent) {
            ((GuildCallPostFeedTaskFacadeMethodEvent) simpleBaseEvent).handle();
        }
    }

    public void q(GuildCreateTaskOperationEvent guildCreateTaskOperationEvent) {
        QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleCreateTaskOperationEvent]  mainTaskId = " + guildCreateTaskOperationEvent.getMainTaskId());
        GuildSingleMainTask k3 = k(guildCreateTaskOperationEvent.getMainTaskId());
        if (k3 == null) {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleCreateTaskOperationEvent] need create task  , mainTaskId = " + guildCreateTaskOperationEvent.getMainTaskId());
            GuildSingleMainTask guildSingleMainTask = new GuildSingleMainTask(guildCreateTaskOperationEvent.getMainTaskId(), guildCreateTaskOperationEvent.getGuildId(), guildCreateTaskOperationEvent.getChannelId(), 0, guildCreateTaskOperationEvent.isEdit(), guildCreateTaskOperationEvent.getBusinessType(), guildCreateTaskOperationEvent.getReportMap(), guildCreateTaskOperationEvent.getScope());
            N(guildSingleMainTask, guildCreateTaskOperationEvent);
            this.f222870e.add(guildSingleMainTask);
            SimpleEventBus.getInstance().dispatchEvent(new GuildTaskOperationCreatedEvent(guildSingleMainTask));
        } else {
            QLog.i("GUP-T-GuildTaskQueueManager", 1, "[handleCreateTaskOperationEvent] taskQueue has this task  , mainTaskId = " + guildCreateTaskOperationEvent.getMainTaskId() + " channelId" + guildCreateTaskOperationEvent.getChannelId());
            if (!TextUtils.equals(guildCreateTaskOperationEvent.getChannelId(), k3.n().getChannelId()) || !TextUtils.equals(guildCreateTaskOperationEvent.getGuildId(), k3.n().getGuildId()) || guildCreateTaskOperationEvent.getBusinessType() != guildCreateTaskOperationEvent.getBusinessType()) {
                F(guildCreateTaskOperationEvent.getGuildId(), guildCreateTaskOperationEvent.getChannelId(), guildCreateTaskOperationEvent.getBusinessType(), guildCreateTaskOperationEvent.getMainTaskId(), k3);
                N(k3, guildCreateTaskOperationEvent);
            }
        }
        ((IGuildNewUserMsgNoticeApi) QRoute.api(IGuildNewUserMsgNoticeApi.class)).setNewUserStayOrWriteInChannel(guildCreateTaskOperationEvent.getGuildId(), guildCreateTaskOperationEvent.getChannelId(), 7);
    }
}

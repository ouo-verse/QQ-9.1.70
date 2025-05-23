package com.tencent.mobileqq.guild.feed.performance.report;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJX\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00142\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0014H\u0016J,\u0010\u0018\u001a\u00020\u00062\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0014H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016R\u0014\u0010%\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/n;", "Lcom/tencent/mobileqq/guild/feed/performance/report/GuildFeedBaseReportData;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/publish/event/GuildTaskProgressStateEvent;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;", "initBean", "", "B", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "delay", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventAttributeParams", "taskAttributeParams", "l", ReportConstant.COSTREPORT_PREFIX, "", tl.h.F, "o", "f", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", DomainData.DOMAIN_NAME, "D", "J", "DELAY_END_TASK_MS_WHILE_EXIT_WEBVIEW", "DELAY_END_TASK_MS_WHILE_TASK_END", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "tinyId", "G", "isEditPublish", "H", "isEditDraft", "I", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "endTaskRunnable", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends GuildFeedBaseReportData implements SimpleEventReceiver<GuildTaskProgressStateEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    private final long DELAY_END_TASK_MS_WHILE_EXIT_WEBVIEW;

    /* renamed from: E, reason: from kotlin metadata */
    private final long DELAY_END_TASK_MS_WHILE_TASK_END;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String tinyId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String isEditPublish;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String isEditDraft;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String taskId;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Runnable endTaskRunnable;

    public n(@NotNull GuildFeedPublishInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.DELAY_END_TASK_MS_WHILE_EXIT_WEBVIEW = 10000L;
        this.DELAY_END_TASK_MS_WHILE_TASK_END = 3000L;
        this.tinyId = "";
        this.isEditPublish = "false";
        this.isEditDraft = "false";
        this.taskId = "";
        this.endTaskRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.performance.report.m
            @Override // java.lang.Runnable
            public final void run() {
                n.y(n.this);
            }
        };
        B(initBean);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A(SimpleBaseEvent event) {
        GuildTaskProgressStateEvent guildTaskProgressStateEvent;
        GuildTaskProgressState taskProgressState;
        HashMap<String, String> hashMapOf;
        String str;
        boolean z16;
        long j3;
        String str2;
        if (event instanceof GuildTaskProgressStateEvent) {
            guildTaskProgressStateEvent = (GuildTaskProgressStateEvent) event;
        } else {
            guildTaskProgressStateEvent = null;
        }
        if (guildTaskProgressStateEvent == null || (taskProgressState = guildTaskProgressStateEvent.getTaskProgressState()) == null) {
            return;
        }
        String str3 = taskProgressState.mTaskId;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3) && !Intrinsics.areEqual(str3, this.taskId)) {
            return;
        }
        Logger logger = Logger.f235387a;
        String tag = getTAG();
        if (QLog.isColorLevel()) {
            logger.d().d(tag, 2, "handleTaskStateEvent, curTaskId: " + this.taskId + ",  onReceiveEvent " + event);
        }
        boolean z17 = true;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_publish_task_id", taskProgressState.mTaskId));
        long j16 = taskProgressState.mPublishErrCode;
        String str5 = taskProgressState.mPublishErrMsg;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        int mainState = taskProgressState.getMainState();
        if (mainState != 1) {
            if (mainState != 2) {
                if (mainState != 3) {
                    if (mainState != 4) {
                        if (mainState == 5) {
                            str4 = "feed_publish_send_publish_failed";
                            if (j16 == 0) {
                                str2 = "feed_publish_send_publish_failed";
                                j3 = -1;
                            }
                        }
                    } else {
                        if (j16 == 0) {
                            j16 = -1;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        List<GuildMediaProgressState> mediaProgressStates = taskProgressState.getMediaProgressStates();
                        if (mediaProgressStates != null) {
                            for (GuildMediaProgressState guildMediaProgressState : mediaProgressStates) {
                                sb5.append("type: " + guildMediaProgressState.getType() + ", mediaTaskId: " + guildMediaProgressState.getUploadTaskId() + ",  errCode: " + guildMediaProgressState.getErrCode() + ", errMsg: " + guildMediaProgressState.getErrMsg());
                            }
                        }
                        hashMapOf.put("feed_publish_media_upload_content", sb5.toString());
                        str4 = "feed_publish_media_upload_failed";
                    }
                } else {
                    str2 = "feed_publish_send_publish_success";
                    j3 = 0;
                }
                if (!TextUtils.isEmpty(str2)) {
                    return;
                }
                c(str2, hashMapOf, j3, str);
                return;
            }
            str4 = "feed_publish_send_request";
        } else {
            StringBuilder sb6 = new StringBuilder();
            List<GuildMediaProgressState> mediaProgressStates2 = taskProgressState.getMediaProgressStates();
            if (mediaProgressStates2 != null) {
                ArrayList<GuildMediaProgressState> arrayList = new ArrayList();
                for (Object obj : mediaProgressStates2) {
                    if (((GuildMediaProgressState) obj).mProgress == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                for (GuildMediaProgressState guildMediaProgressState2 : arrayList) {
                    sb6.append("type: " + guildMediaProgressState2.getType() + ", mediaTaskId: " + guildMediaProgressState2.getUploadTaskId() + " ");
                }
            }
            if (sb6.length() != 0) {
                z17 = false;
            }
            if (z17) {
                return;
            }
            hashMapOf.put("feed_publish_media_upload_content", sb6.toString());
            str4 = "feed_publish_media_start_upload";
        }
        j3 = j16;
        str2 = str4;
        if (!TextUtils.isEmpty(str2)) {
        }
    }

    private final void B(GuildFeedPublishInitBean initBean) {
        String tinyId = initBean.getTinyId();
        String str = "";
        if (tinyId == null) {
            tinyId = "";
        }
        this.tinyId = tinyId;
        String channelId = initBean.getChannelId();
        if (channelId == null) {
            channelId = "";
        }
        r(channelId);
        String guildId = initBean.getGuildId();
        if (guildId != null) {
            str = guildId;
        }
        t(str);
        this.isEditDraft = String.valueOf(initBean.isEditDraft());
        this.isEditPublish = String.valueOf(initBean.isEditPublish());
        bl.c().d(this);
    }

    private final void C(long delay) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.endTaskRunnable, delay);
    }

    static /* synthetic */ void D(n nVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = nVar.DELAY_END_TASK_MS_WHILE_TASK_END;
        }
        nVar.C(j3);
    }

    private final void x() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.endTaskRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(n this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        String tag = this$0.getTAG();
        if (QLog.isColorLevel()) {
            logger.d().d(tag, 2, "reportTaskEnd taskId: " + this$0.taskId);
        }
        this$0.f();
    }

    public final void E(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    public void f() {
        super.f();
        if (!TextUtils.isEmpty(this.taskId)) {
            l.q(this.taskId);
            this.taskId = "";
        }
        bl.c().e(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildTaskProgressStateEvent>> getEventClass() {
        ArrayList<Class<GuildTaskProgressStateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildTaskProgressStateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    @NotNull
    public List<String> h() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("feed_publish_send_request");
        return listOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    public void l(@NotNull String event, @NotNull HashMap<String, String> eventAttributeParams, @NotNull HashMap<String, String> taskAttributeParams) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
        Intrinsics.checkNotNullParameter(taskAttributeParams, "taskAttributeParams");
        super.l(event, eventAttributeParams, taskAttributeParams);
        switch (event.hashCode()) {
            case -1454493084:
                if (!event.equals("CH_E_DISCARD_EDIT_SEL_DISCARD_EXIT")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            case -512976307:
                if (!event.equals("feed_publish_send_publish_success")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            case 9256499:
                if (!event.equals("CH_E_SAVE_DRAFT_SEL_NO_SAVE_EXIT")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            case 147179699:
                if (!event.equals("feed_publish_send_publish_failed")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            case 357742954:
                if (!event.equals("feed_publish_media_start_upload")) {
                    return;
                }
                break;
            case 863440582:
                if (event.equals("feed_publish_exit_webview_fragment")) {
                    C(this.DELAY_END_TASK_MS_WHILE_EXIT_WEBVIEW);
                    return;
                }
                return;
            case 1038787081:
                if (!event.equals("feed_publish_send_request")) {
                    return;
                }
                break;
            case 1159055567:
                if (!event.equals("feed_publish_media_upload_failed")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            case 1999939503:
                if (!event.equals("CH_E_SAVE_DRAFT_SEL_SAVE_EXIT")) {
                    return;
                }
                D(this, 0L, 1, null);
                return;
            default:
                return;
        }
        x();
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    @NotNull
    public String n() {
        return "FeedPublishReportBean";
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    @NotNull
    public List<String> o() {
        List listOf;
        List<String> plus;
        List<String> o16 = super.o();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"is_first_load", "is_use_offline", "is_hit_detail_cache_data", "web_process_status", "feed_publish_is_publish_edit", "feed_publish_is_draft_edit"});
        plus = CollectionsKt___CollectionsKt.plus((Collection) o16, (Iterable) listOf);
        return plus;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        A(event);
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData
    public void s(@NotNull HashMap<String, String> eventAttributeParams) {
        Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
        super.s(eventAttributeParams);
        eventAttributeParams.put(INetChannelCallback.KEY_TINY_ID, this.tinyId);
        eventAttributeParams.put("feed_publish_is_publish_edit", this.isEditPublish);
        eventAttributeParams.put("feed_publish_is_draft_edit", this.isEditDraft);
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }
}

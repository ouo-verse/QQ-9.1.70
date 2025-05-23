package km1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cm1.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiImpl;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import in1.c;
import in1.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J.\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001e\u001a\u00020\u000e2\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u001b0\u001aj\u0002`\u001cJ\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003J\u001e\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003J&\u0010%\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010'\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005\u00a8\u0006*"}, d2 = {"Lkm1/a;", "", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "", "mainTaskId", "", QzoneIPCModule.RESULT_CODE, "resultMsg", "", "rspResultCode", "a", "j", "Landroid/content/Intent;", "intent", "", "c", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;", "mainTask", "", "isAutoRetry", "d", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "argument", "e", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "b", "editorParam", "errorMsg", "f", "guildId", "channelId", "i", "g", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CANCEL_TYPE, h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f412694a = new a();

    a() {
    }

    private final IPerformanceReportTask a(IPerformanceReportTask iPerformanceReportTask, String str, int i3, String str2, long j3) {
        String stackTraceToString;
        try {
            IPerformanceReportTask resultMsg = iPerformanceReportTask.duplicate("upload_version").setStageCode("stage_post_end").setResultCode(i3).setResultMsg(str2);
            String apn = NetworkUtil.getApn(BaseApplication.getContext());
            if (apn == null) {
                apn = "";
            }
            return j(resultMsg.setParam("apn", apn).setExtra("rsp_result_code", Long.valueOf(j3)).setRealTime(false), str);
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
            return null;
        }
    }

    private final IPerformanceReportTask j(IPerformanceReportTask iPerformanceReportTask, String str) {
        d s16;
        c uploadTaskApi;
        Map<String, o> c16;
        GuildSingleMainTask k3 = GuildTaskQueueManager.m().k(str);
        if (k3 != null && (s16 = k3.s()) != null && (uploadTaskApi = s16.getUploadTaskApi()) != null && (c16 = uploadTaskApi.c()) != null) {
            int i3 = 0;
            if (!c16.isEmpty()) {
                Iterator<Map.Entry<String, o>> it = c16.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().g()) {
                        i3++;
                    }
                }
            }
            iPerformanceReportTask.setExtra("image_count", Integer.valueOf(i3));
            iPerformanceReportTask.setExtra("video_count", Integer.valueOf(c16.size() - i3));
        }
        return iPerformanceReportTask;
    }

    public final void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        String stackTraceToString;
        Map<String, LocalMediaInfo> emptyMap;
        int i3;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        zl1.a h16 = context.h();
        try {
            k k3 = context.e().k(FeedEditorContentMsgIntent.FetchMediaUploadTasks.f221790d);
            if (!(k3 instanceof a.FetchMediasUploadTaskMsgResult)) {
                k3 = null;
            }
            a.FetchMediasUploadTaskMsgResult fetchMediasUploadTaskMsgResult = (a.FetchMediasUploadTaskMsgResult) k3;
            if (fetchMediasUploadTaskMsgResult == null || (emptyMap = fetchMediasUploadTaskMsgResult.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            if (emptyMap.isEmpty()) {
                i3 = 0;
            } else {
                Iterator<Map.Entry<String, LocalMediaInfo>> it = emptyMap.entrySet().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (AlbumUtil.isImage(it.next().getValue())) {
                        i3++;
                    }
                }
            }
            int size = emptyMap.size() - i3;
            Iterator<T> it5 = emptyMap.values().iterator();
            long j3 = 0;
            while (it5.hasNext()) {
                j3 += ((LocalMediaInfo) it5.next()).fileSize;
            }
            IPerformanceReportTask param = qw1.b.g(h16.getExtra(), null, 1, null).duplicate("upload_version").setStageCode("stage_click_post").setParam("guild_id", h16.h()).setParam("guild_channel_id", h16.a());
            String apn = NetworkUtil.getApn(BaseApplication.getContext());
            if (apn == null) {
                apn = "";
            }
            IPerformanceReportTask param2 = param.setParam("apn", apn);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("task_id", h16.m()), TuplesKt.to("image_count", Integer.valueOf(i3)), TuplesKt.to("video_count", Integer.valueOf(size)), TuplesKt.to("total_media_length", Long.valueOf(j3)));
            param2.setExtras(mapOf).report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void c(@NotNull Intent intent) {
        String stackTraceToString;
        GuildFeedBaseInitBean guildFeedBaseInitBean;
        String str;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            String str2 = null;
            if (serializableExtra instanceof GuildFeedBaseInitBean) {
                guildFeedBaseInitBean = (GuildFeedBaseInitBean) serializableExtra;
            } else {
                guildFeedBaseInitBean = null;
            }
            IPerformanceReportTask realTime = Reporters.f231995a.b().a("feed_publisher").setStageCode("stage_init").setRealTime(false);
            if (guildFeedBaseInitBean != null) {
                str = guildFeedBaseInitBean.getGuildId();
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            IPerformanceReportTask param = realTime.setParam("guild_id", str);
            if (guildFeedBaseInitBean != null) {
                str2 = guildFeedBaseInitBean.getChannelId();
            }
            if (str2 == null) {
                str2 = "";
            }
            IPerformanceReportTask param2 = param.setParam("guild_channel_id", str2);
            Pair[] pairArr = new Pair[4];
            i iVar = i.f450608a;
            pairArr[0] = TuplesKt.to("is_edit", Integer.valueOf(iVar.m(intent.getBooleanExtra("launch_edit_flag", false))));
            String stringExtra = intent.getStringExtra("launch_main_task_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            pairArr[1] = TuplesKt.to("task_id", stringExtra);
            String stringExtra2 = intent.getStringExtra("launch_feed_id");
            if (stringExtra2 != null) {
                str3 = stringExtra2;
            }
            pairArr[2] = TuplesKt.to("feed_id", str3);
            pairArr[3] = TuplesKt.to("upload_version", Integer.valueOf(iVar.m(GuildFeedMediaUploadServiceApiImpl.INSTANCE.b())));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            qw1.b.r(intent, param2.setExtras(mapOf).report());
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void d(@NotNull GuildSingleMainTask mainTask, boolean isAutoRetry) {
        String stackTraceToString;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(mainTask, "mainTask");
        try {
            IPerformanceReportTask param = Reporters.f231995a.b().a("feed_publisher").setStageCode("stage_init").setRealTime(false).setParam("guild_id", mainTask.n().getGuildId()).setParam("guild_channel_id", mainTask.n().getChannelId());
            i iVar = i.f450608a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("is_edit", Boolean.valueOf(mainTask.v())), TuplesKt.to("task_id", mainTask.b()), TuplesKt.to("is_auto_retry", Integer.valueOf(iVar.m(isAutoRetry))), TuplesKt.to("upload_version", Integer.valueOf(iVar.m(GuildFeedMediaUploadServiceApiImpl.INSTANCE.b()))));
            GuildTaskQueueManager.m().i(mainTask.b(), param.setExtras(mapOf).report());
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void e(@Nullable View view, @NotNull Bundle argument) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(argument, "argument");
        try {
            qw1.b.k(qw1.b.g(argument, null, 1, null).duplicate("upload_version").setStageCode("stage_open_editor").setRealTime(false), view, null, 2, null);
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void f(@NotNull zl1.a editorParam, int resultCode, @NotNull String errorMsg) {
        String stackTraceToString;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        IPerformanceReportTask resultCode2;
        IPerformanceReportTask resultMsg;
        IPerformanceReportTask realTime;
        Intrinsics.checkNotNullParameter(editorParam, "editorParam");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        try {
            IPerformanceReportTask g16 = qw1.b.g(editorParam.getExtra(), null, 1, null);
            if (g16 != null && (duplicate = g16.duplicate(new String[0])) != null && (stageCode = duplicate.setStageCode("stage_post_block")) != null && (resultCode2 = stageCode.setResultCode(resultCode)) != null && (resultMsg = resultCode2.setResultMsg(errorMsg)) != null && (realTime = resultMsg.setRealTime(false)) != null) {
                realTime.report();
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void g(@NotNull String mainTaskId, int resultCode, @NotNull String resultMsg, long rspResultCode) {
        String stackTraceToString;
        IPerformanceReportTask a16;
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        try {
            IPerformanceReportTask j3 = GuildTaskQueueManager.m().j(mainTaskId);
            if (j3 != null && (a16 = a(j3, mainTaskId, resultCode, resultMsg, rspResultCode)) != null) {
                a16.report();
            }
            GuildTaskQueueManager.m().P(mainTaskId);
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void h(@NotNull String mainTaskId, int cancelType) {
        String stackTraceToString;
        IPerformanceReportTask a16;
        IPerformanceReportTask extra;
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        try {
            IPerformanceReportTask j3 = GuildTaskQueueManager.m().j(mainTaskId);
            if (j3 == null && QLog.isDevelopLevel()) {
                QLog.i("FeedEditor.MonitorReporter", 4, "[reportStagePostEndOfCancel]: did not find reportTask which binds witt " + mainTaskId);
                return;
            }
            if (j3 != null && (a16 = a(j3, mainTaskId, 400004, "\u4efb\u52a1\u53d6\u6d88", 0L)) != null && (extra = a16.setExtra("task_cancel_type", Integer.valueOf(cancelType))) != null) {
                extra.report();
            }
            GuildTaskQueueManager.m().P(mainTaskId);
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }

    public final void i(@NotNull String mainTaskId, @NotNull String guildId, @NotNull String channelId) {
        String stackTraceToString;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        IPerformanceReportTask param;
        IPerformanceReportTask param2;
        IPerformanceReportTask extra;
        IPerformanceReportTask realTime;
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        try {
            IPerformanceReportTask j3 = GuildTaskQueueManager.m().j(mainTaskId);
            if (j3 != null && (duplicate = j3.duplicate("upload_version")) != null && (stageCode = duplicate.setStageCode("stage_trigger_real_post")) != null && (param = stageCode.setParam("guild_id", guildId)) != null && (param2 = param.setParam("guild_channel_id", channelId)) != null) {
                String apn = NetworkUtil.getApn(BaseApplication.getContext());
                if (apn == null) {
                    apn = "";
                }
                IPerformanceReportTask param3 = param2.setParam("apn", apn);
                if (param3 != null && (extra = param3.setExtra("task_id", mainTaskId)) != null && (realTime = extra.setRealTime(false)) != null) {
                    realTime.report();
                }
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("FeedEditor.MonitorReporter", 1, "runCatching: " + stackTraceToString);
        }
    }
}

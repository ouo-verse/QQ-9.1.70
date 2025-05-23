package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditDraftInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.util.ad;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkpublish.config.GuildUploadLocalConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\bH\u0002J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010(\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010C\u001a\n\u0018\u00010<j\u0004\u0018\u0001`=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "k", "d", "j", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "state", "", "f", "taskData", "Landroid/content/Context;", "context", "channelIdOverwritten", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;", "y", "i", "eventId", "r", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", CacheTable.TABLE_NAME, "p", "a", "Landroid/content/Context;", "e", "()Landroid/content/Context;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/content/Context;)V", "b", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "g", "()Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;)V", "taskProgressState", "c", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "logTag", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "getStFeed", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "w", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;)V", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "getSession", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "v", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;)V", SessionDbHelper.SESSION_ID, "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lqj1/h;", "getLastFeedInfo", "()Lqj1/h;", "t", "(Lqj1/h;)V", "lastFeedInfo", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBottomSectionHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildTaskProgressState taskProgressState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String logTag = "GuildFeedBottomSectionHelper";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStFeed stFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<?> session;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qj1.h lastFeedInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(GProStFeed stFeed) {
        long j3;
        GProStChannelSign gProStChannelSign;
        GProStChannelSign gProStChannelSign2;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = stFeed.clientTaskId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new GuildCancelTaskOperationEvent(2, str, false));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        String str3 = stFeed.idd;
        if (str3 != null) {
            str2 = str3;
        }
        GProStChannelInfo gProStChannelInfo = stFeed.channelInfo;
        long j16 = 0;
        if (gProStChannelInfo != null && (gProStChannelSign2 = gProStChannelInfo.sign) != null) {
            j3 = gProStChannelSign2.guildId;
        } else {
            j3 = 0;
        }
        String valueOf = String.valueOf(j3);
        GProStChannelInfo gProStChannelInfo2 = stFeed.channelInfo;
        if (gProStChannelInfo2 != null && (gProStChannelSign = gProStChannelInfo2.sign) != null) {
            j16 = gProStChannelSign.channelId;
        }
        simpleEventBus2.dispatchEvent(new GuildFeedDeleteEvent(str2, valueOf, String.valueOf(j16)));
    }

    private final String f(GuildTaskProgressState state) {
        boolean z16;
        String str;
        boolean z17;
        IGuildParcelizeSimpleContact a16;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<?> iVar = this.session;
        boolean z18 = false;
        if (iVar != null) {
            z16 = wj1.c.c(iVar);
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<?> iVar2 = this.session;
        if (iVar2 == null || (a16 = iVar2.a()) == null || (str = a16.getChannelId()) == null) {
            str = "";
        }
        if (ch.B(state.getChannelId()) == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        GProStFeed gProStFeed = this.stFeed;
        if (gProStFeed != null && com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(gProStFeed)) {
            z18 = true;
        }
        if (!z16 || !z17 || !z18) {
            return "";
        }
        return str;
    }

    private final void h(GuildTaskProgressState taskData, Context context, String channelIdOverwritten) {
        boolean z16;
        String str;
        GuildFeedPublishInitBean y16 = y(taskData);
        y16.setGuildId(taskData.getGuildId());
        boolean z17 = false;
        if (channelIdOverwritten.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            channelIdOverwritten = taskData.getChannelId();
        }
        y16.setChannelId(channelIdOverwritten);
        y16.setBusinessType(taskData.getBusinessType());
        IGProChannelInfo B = ch.B(taskData.getChannelId());
        if (B == null || (str = B.getChannelName()) == null) {
            str = "";
        }
        y16.setChannelName(str);
        String u16 = ax.u();
        y16.setTinyId(u16);
        y16.setNickName(((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayName(taskData.getGuildId(), u16));
        HashMap<String, Serializable> attrs = y16.getAttrs();
        if (attrs != null) {
            yl1.i iVar = yl1.i.f450608a;
            if (y16.getBusinessType() == 16 || y16.getBusinessType() == 14) {
                z17 = true;
            }
            attrs.put("is_part_not_selected", Integer.valueOf(iVar.m(z17)));
        }
        GuildFeedLauncher.B(context, y16);
        Logger logger = Logger.f235387a;
        String str2 = this.logTag;
        logger.d().i(str2, 1, "[onEditPublish] | taskData = " + taskData + " | json = " + taskData.getJson());
        r("CH_E_SENDBOX_EDIT");
    }

    private final void i(GuildTaskProgressState taskData, Context context, String channelIdOverwritten) {
        int i3;
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(taskData.getJson()).optString("jsonFeed"));
            String str = "";
            if (jSONObject.has("id")) {
                str = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(str, "feedJson.getString(\"id\")");
            }
            String str2 = str;
            if (jSONObject.has("publishExtra")) {
                jSONObject.remove("publishExtra");
            }
            if (!TextUtils.isEmpty(str2)) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            int i16 = i3;
            String guildId = taskData.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "taskData.guildId");
            if (channelIdOverwritten.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                channelIdOverwritten = taskData.getChannelId();
            }
            String str3 = channelIdOverwritten;
            Intrinsics.checkNotNullExpressionValue(str3, "channelIdOverwritten.ifE\u2026ty { taskData.channelId }");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "feedJson.toString()");
            String mainTaskId = taskData.getMainTaskId();
            Intrinsics.checkNotNullExpressionValue(mainTaskId, "taskData.mainTaskId");
            em1.a.e(context, guildId, str3, str2, i16, jSONObject2, mainTaskId, taskData.getBusinessType());
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            String str4 = this.logTag;
            Logger.b bVar = new Logger.b();
            String str5 = "onEditPublish error! " + e16.getMessage();
            if (str5 instanceof String) {
                bVar.a().add(str5);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str4, 1, (String) it.next(), null);
            }
        }
    }

    private final void j(final GProStFeed stFeed) {
        long j3;
        GProStChannelSign gProStChannelSign;
        GProStChannelSign gProStChannelSign2;
        ad adVar = ad.f223828a;
        Context e16 = e();
        GProStChannelInfo gProStChannelInfo = stFeed.channelInfo;
        long j16 = 0;
        if (gProStChannelInfo != null && (gProStChannelSign2 = gProStChannelInfo.sign) != null) {
            j3 = gProStChannelSign2.guildId;
        } else {
            j3 = 0;
        }
        if (gProStChannelInfo != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
            j16 = gProStChannelSign.channelId;
        }
        String str = stFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
        String str2 = stFeed.poster.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.poster.idd");
        adVar.f(new ad.FeedDeleteArgs(e16, j3, j16, str, str2, stFeed.createTime, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedBottomSectionHelper$onDeleteFeedPublish$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedBottomSectionHelper.this.d(stFeed);
            }
        }, null, 128, null));
    }

    private final void k(final GProStFeed stFeed) {
        if (yl1.n.d(false, 0, 3, null)) {
            return;
        }
        DialogUtil.createCustomDialog(e(), 230, (String) null, e().getString(R.string.f145550rs), e().getString(R.string.cancel), e().getString(R.string.ajx), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildFeedBottomSectionHelper.l(GuildFeedBottomSectionHelper.this, stFeed, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildFeedBottomSectionHelper.m(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildFeedBottomSectionHelper this$0, GProStFeed stFeed, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        this$0.d(stFeed);
    }

    private final void r(String eventId) {
        String str;
        GuildTaskProgressState guildTaskProgressState = this.taskProgressState;
        if (guildTaskProgressState != null) {
            int size = ((GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)).v(guildTaskProgressState.getGuildId(), guildTaskProgressState.getChannelId()).size();
            GuildUploadLocalConfig n3 = GuildTaskQueueManager.m().n();
            QCirclePublishQualityDataBuilder ext4 = new QCirclePublishQualityDataBuilder().setKeyEventId(eventId).setTraceId(guildTaskProgressState.getMainTaskId()).setExt1(al.c(guildTaskProgressState.getMediaProgressStates())).setExt2(String.valueOf(guildTaskProgressState.getMediaProgressStates().size())).setExt3(al.a(guildTaskProgressState.getMediaProgressStates())).setExt4(al.b(guildTaskProgressState.getMediaProgressStates()));
            if (guildTaskProgressState.isEdit()) {
                str = "isModify";
            } else {
                str = "isNotModify";
            }
            n3.uploadQualityReport(ext4.setExt5(str).setExt6(String.valueOf(size)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:5:0x000f, B:7:0x0016, B:15:0x0027, B:17:0x0037, B:22:0x0043, B:24:0x004e, B:26:0x005e, B:27:0x006c), top: B:4:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:5:0x000f, B:7:0x0016, B:15:0x0027, B:17:0x0037, B:22:0x0043, B:24:0x004e, B:26:0x005e, B:27:0x006c), top: B:4:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0024  */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GuildFeedPublishInitBean y(GuildTaskProgressState taskData) {
        boolean z16;
        String str;
        String str2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (taskData.isEdit()) {
            try {
                String json = taskData.getJson();
                boolean z17 = false;
                if (json != null && json.length() != 0) {
                    z16 = false;
                    str = null;
                    if (!z16) {
                        json = null;
                    }
                    if (json == null) {
                        str2 = new JSONObject(json).optString("jsonFeed");
                    } else {
                        str2 = null;
                    }
                    if (str2 != null || str2.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        str = str2;
                    }
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("id")) {
                            ?? guildFeedPublishEditPostInitBean = new GuildFeedPublishEditPostInitBean();
                            guildFeedPublishEditPostInitBean.setFeedId(jSONObject.getString("id"));
                            qj1.h hVar = this.lastFeedInfo;
                            if (hVar != null) {
                                guildFeedPublishEditPostInitBean.setPosterTinyId(hVar.r());
                                guildFeedPublishEditPostInitBean.setCreateTime(hVar.getCreateTime());
                            }
                            objectRef.element = guildFeedPublishEditPostInitBean;
                        }
                    }
                }
                z16 = true;
                str = null;
                if (!z16) {
                }
                if (json == null) {
                }
                if (str2 != null) {
                }
                z17 = true;
                if (!z17) {
                }
                if (str != null) {
                }
            } catch (Exception e16) {
                QLog.e(this.logTag, 1, "[tryCreateInitBeanForOpeningLongFeedEditor]: exception: ", e16);
            }
        }
        if (objectRef.element == 0) {
            objectRef.element = new GuildFeedPublishInitBean();
        }
        T t16 = objectRef.element;
        Intrinsics.checkNotNull(t16);
        GuildFeedPublishEditDraftInitBean guildFeedPublishEditDraftInitBean = new GuildFeedPublishEditDraftInitBean();
        guildFeedPublishEditDraftInitBean.setFeedJson(taskData.getJson());
        guildFeedPublishEditDraftInitBean.setTaskId(taskData.getMainTaskId());
        ((GuildFeedPublishInitBean) t16).setDraftBean(guildFeedPublishEditDraftInitBean);
        T t17 = objectRef.element;
        Intrinsics.checkNotNull(t17);
        return (GuildFeedPublishInitBean) t17;
    }

    @NotNull
    public final Context e() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final GuildTaskProgressState getTaskProgressState() {
        return this.taskProgressState;
    }

    public final void n() {
        String str;
        Logger logger = Logger.f235387a;
        String str2 = this.logTag;
        Logger.a d16 = logger.d();
        GuildTaskProgressState taskProgressState = getTaskProgressState();
        if (taskProgressState != null) {
            str = taskProgressState.getMainTaskId();
        } else {
            str = null;
        }
        d16.i(str2, 1, "onDeletePublish mainTaskId = " + str);
        GProStFeed gProStFeed = this.stFeed;
        if (gProStFeed != null) {
            if (com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(gProStFeed)) {
                k(gProStFeed);
            } else {
                j(gProStFeed);
            }
        }
    }

    public final void o() {
        String str;
        boolean z16;
        boolean z17;
        Logger logger = Logger.f235387a;
        String str2 = this.logTag;
        Logger.a d16 = logger.d();
        GuildTaskProgressState taskProgressState = getTaskProgressState();
        if (taskProgressState != null) {
            str = taskProgressState.getMainTaskId();
        } else {
            str = null;
        }
        boolean z18 = true;
        d16.i(str2, 1, "onEditPublish mainTaskId = " + str);
        Context e16 = e();
        GuildTaskProgressState guildTaskProgressState = this.taskProgressState;
        if (guildTaskProgressState != null && (e16 instanceof Activity)) {
            GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
            Activity activity = (Activity) e16;
            Intrinsics.checkNotNull(guildTaskProgressState);
            String guildId = guildTaskProgressState.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "taskProgressState!!.guildId");
            GuildTaskProgressState guildTaskProgressState2 = this.taskProgressState;
            Intrinsics.checkNotNull(guildTaskProgressState2);
            String channelId = guildTaskProgressState2.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "taskProgressState!!.channelId");
            GProStFeed gProStFeed = this.stFeed;
            if (gProStFeed != null && !com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(gProStFeed)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!guildFeedPublishUtils.j(activity, guildId, channelId, z16)) {
                return;
            }
            GuildTaskProgressState guildTaskProgressState3 = this.taskProgressState;
            Intrinsics.checkNotNull(guildTaskProgressState3);
            String f16 = f(guildTaskProgressState3);
            if (f16.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String str3 = this.logTag;
                logger.d().i(str3, 1, "onEditPublish forcePostChannelId:" + f16);
            }
            GuildTaskProgressState guildTaskProgressState4 = this.taskProgressState;
            Intrinsics.checkNotNull(guildTaskProgressState4);
            String json = guildTaskProgressState4.getJson();
            if (json != null && json.length() != 0) {
                z18 = false;
            }
            if (!z18 && wj1.c.b(json)) {
                GuildTaskProgressState guildTaskProgressState5 = this.taskProgressState;
                Intrinsics.checkNotNull(guildTaskProgressState5);
                i(guildTaskProgressState5, e16, f16);
            } else {
                GuildTaskProgressState guildTaskProgressState6 = this.taskProgressState;
                Intrinsics.checkNotNull(guildTaskProgressState6);
                h(guildTaskProgressState6, e16, f16);
            }
        }
    }

    public final void p(@Nullable GuildFeedReportSourceInfo reportInfo) {
        int i3;
        String str;
        boolean z16;
        GProStFeed gProStFeed = this.stFeed;
        if (gProStFeed != null) {
            bc.a aVar = new bc.a();
            qj1.h hVar = this.lastFeedInfo;
            boolean z17 = false;
            if (hVar != null) {
                i3 = hVar.getPreferStatus();
            } else {
                i3 = 0;
            }
            aVar.curPreferStatus = i3;
            aVar.operate = 2000;
            aVar.feedId = gProStFeed.idd;
            GProStChannelSign gProStChannelSign = gProStFeed.channelInfo.sign;
            aVar.guildId = gProStChannelSign.guildId;
            aVar.channelId = gProStChannelSign.channelId;
            aVar.enableFake = true;
            aVar.stFeed = gProStFeed;
            aVar.reportMap = reportInfo;
            GuildTaskProgressState guildTaskProgressState = this.taskProgressState;
            if (guildTaskProgressState != null) {
                str = guildTaskProgressState.getMainTaskId();
            } else {
                str = null;
            }
            if (com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(gProStFeed)) {
                if (str != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    String str2 = gProStFeed.idd;
                    bc bcVar = bc.f223871a;
                    bc.r(str2, bcVar.k(aVar), aVar.curPreferStatus, null, 8, null);
                    bc.p(str, bcVar.j(aVar));
                    Logger logger = Logger.f235387a;
                    String str3 = this.logTag;
                    logger.d().i(str3, 1, "onPreferClick isLocalFeed feedId:" + gProStFeed.idd + " mainTaskId:" + str);
                    return;
                }
                Logger logger2 = Logger.f235387a;
                String str4 = this.logTag;
                Logger.b bVar = new Logger.b();
                String str5 = "onPreferClick isLocalFeed feedId:" + gProStFeed.idd + " no mainTaskId";
                if (str5 instanceof String) {
                    bVar.a().add(str5);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(str4, 1, (String) it.next(), null);
                }
                return;
            }
            bc.d(aVar);
        }
    }

    public final void q() {
        String str;
        GuildTaskProgressState guildTaskProgressState;
        String mainTaskId;
        Logger logger = Logger.f235387a;
        String str2 = this.logTag;
        Logger.a d16 = logger.d();
        GuildTaskProgressState taskProgressState = getTaskProgressState();
        if (taskProgressState != null) {
            str = taskProgressState.getMainTaskId();
        } else {
            str = null;
        }
        d16.i(str2, 1, "onRetryPublish mainTaskId = " + str);
        Context e16 = e();
        GuildTaskProgressState guildTaskProgressState2 = this.taskProgressState;
        if (guildTaskProgressState2 != null && (e16 instanceof Activity)) {
            Intrinsics.checkNotNull(guildTaskProgressState2);
            String guildId = guildTaskProgressState2.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "taskProgressState!!.guildId");
            GuildTaskProgressState guildTaskProgressState3 = this.taskProgressState;
            Intrinsics.checkNotNull(guildTaskProgressState3);
            String channelId = guildTaskProgressState3.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "taskProgressState!!.channelId");
            boolean z16 = false;
            if (GuildFeedPublishUtils.f222315a.j((Activity) e16, guildId, channelId, false) && (guildTaskProgressState = this.taskProgressState) != null && (mainTaskId = guildTaskProgressState.getMainTaskId()) != null) {
                GuildRetryTaskOperationEvent guildRetryTaskOperationEvent = new GuildRetryTaskOperationEvent(2, mainTaskId);
                guildRetryTaskOperationEvent.showSuccessToast = false;
                GuildTaskProgressState guildTaskProgressState4 = this.taskProgressState;
                Intrinsics.checkNotNull(guildTaskProgressState4);
                String f16 = f(guildTaskProgressState4);
                if (f16.length() > 0) {
                    z16 = true;
                }
                if (z16) {
                    String str3 = this.logTag;
                    logger.d().i(str3, 1, "onRetryPublish forcePostChannelId:" + f16);
                    guildRetryTaskOperationEvent.forcePostChannelId = f16;
                }
                SimpleEventBus.getInstance().dispatchEvent(guildRetryTaskOperationEvent);
                r("CH_E_SENDBOX_RETRY");
            }
        }
    }

    public final void s(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void t(@Nullable qj1.h hVar) {
        this.lastFeedInfo = hVar;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logTag = str;
    }

    public final void v(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<?> iVar) {
        this.session = iVar;
    }

    public final void w(@Nullable GProStFeed gProStFeed) {
        this.stFeed = gProStFeed;
    }

    public final void x(@Nullable GuildTaskProgressState guildTaskProgressState) {
        this.taskProgressState = guildTaskProgressState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DialogInterface dialogInterface, int i3) {
    }
}

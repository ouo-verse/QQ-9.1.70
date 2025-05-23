package com.tencent.mobileqq.guild.feed.publish.publish;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.k;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishSuccessGetFeedEvent;
import com.tencent.mobileqq.guild.feed.publish.v;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHttpReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStAlterFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStAlterFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStClientContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStClientImageContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStClientVideoContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStPublishFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStPublishFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAlterFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGPropublishFeedCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yl1.n;

/* compiled from: P */
/* loaded from: classes13.dex */
public class j implements s {
    private static Integer E;
    private static int F;
    private c C;
    private final FeedEditorPostPreProcessor D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f223013d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f223014e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f223015f;

    /* renamed from: h, reason: collision with root package name */
    private String f223016h;

    /* renamed from: i, reason: collision with root package name */
    private String f223017i;

    /* renamed from: m, reason: collision with root package name */
    private final v f223018m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProHttpReqInfo f223019a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f223020b;

        a(GProHttpReqInfo gProHttpReqInfo, Runnable runnable) {
            this.f223019a = gProHttpReqInfo;
            this.f223020b = runnable;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.i("PostFeedTask.RequestSenderTask", 1, "[getPskey]: mainTaskId = " + j.this.f223018m.getMMainTaskId() + ", error: " + str);
            this.f223020b.run();
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str = map.get("pd.qq.com");
            if (!TextUtils.isEmpty(str)) {
                this.f223019a.pskey = str;
            } else {
                QLog.i("PostFeedTask.RequestSenderTask", 1, "[getPskey]: mainTaskId = " + j.this.f223018m.getMMainTaskId() + ", success, but it is empty");
            }
            this.f223020b.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements sd2.a {
        b() {
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("PostFeedTask.RequestSenderTask", 1, "[replacePsk]: mainTaskId=" + j.this.f223018m.getMMainTaskId() + ", error: " + str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            QLog.i("PostFeedTask.RequestSenderTask", 1, "[replacePSK]: mainTaskId=" + j.this.f223018m.getMMainTaskId() + " success, contain= " + map.containsKey("pd.qq.com"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
        void a(boolean z16, long j3, String str, String str2);
    }

    public j(boolean z16, String str, String str2, @NonNull v vVar) {
        this.f223013d = z16;
        this.f223016h = str;
        this.f223017i = str2;
        this.f223018m = vVar;
        this.D = new FeedEditorPostPreProcessor("PostFeedTask.RequestSenderTask", vVar.getMMainTaskId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(o oVar, final GProStPublishFeedReq gProStPublishFeedReq) {
        oVar.publishFeed(gProStPublishFeedReq, new IGPropublishFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.f
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGPropublishFeedCallback
            public final void onResult(int i3, String str, boolean z16, GProStPublishFeedRsp gProStPublishFeedRsp) {
                j.this.z(gProStPublishFeedReq, i3, str, z16, gProStPublishFeedRsp);
            }
        });
        O("CH_E_PUBLISH_FEEDS_START");
    }

    private void B() {
        if (E != null) {
            return;
        }
        SSODebugUtil.isTestEnv();
        E = 0;
        F = 0;
    }

    private static void E(GProStClientContent gProStClientContent, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("mediaInfo"));
                QLog.i("PostFeedTask.RequestSenderTask", 1, "[parseClientContentByJson]: i=" + i3 + ", localType=" + jSONObject.optBoolean("localType") + ", mio.mediaType=" + jSONObject2.optInt("mediaType") + ", mio.taskId=" + jSONObject2.optString("task_id"));
                if (jSONObject2.has("mediaType")) {
                    if (jSONObject2.getInt("mediaType") == 0) {
                        GProStClientImageContent gProStClientImageContent = new GProStClientImageContent();
                        gProStClientImageContent.taskId = jSONObject2.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                        JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("svrContentJson"));
                        gProStClientImageContent.url = jSONObject3.getString("picUrl");
                        gProStClientImageContent.isOrig = jSONObject3.getBoolean("is_orig");
                        gProStClientImageContent.origSize = jSONObject3.getInt("orig_size");
                        gProStClientImageContent.isGif = jSONObject3.getBoolean("is_gif");
                        gProStClientImageContent.md5 = jSONObject3.getString("imageMD5");
                        gProStClientContent.clientImageContents.add(gProStClientImageContent);
                    } else {
                        GProStClientVideoContent gProStClientVideoContent = new GProStClientVideoContent();
                        gProStClientVideoContent.taskId = jSONObject2.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                        gProStClientVideoContent.coverUrl = jSONObject2.getString("videoCover");
                        gProStClientVideoContent.videoId = jSONObject2.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                        gProStClientContent.clientVideoContents.add(gProStClientVideoContent);
                    }
                }
            } catch (JSONException e16) {
                QLog.e("PostFeedTask.RequestSenderTask", 1, "[parseClientContentByJson]: exception = ", e16);
            }
        }
    }

    private void G(jn1.b bVar, GProStClientContent gProStClientContent, GProStCommonExt gProStCommonExt, int i3) {
        final o c16 = l.c();
        if (c16 == null) {
            QLog.d("PostFeedTask.RequestSenderTask", 1, "publishFeedRequest feedService == null");
            return;
        }
        final GProStPublishFeedReq gProStPublishFeedReq = new GProStPublishFeedReq();
        gProStPublishFeedReq.feed.channelInfo.sign.guildId = az.d(getGuildId(), 0L);
        gProStPublishFeedReq.feed.channelInfo.sign.channelId = az.d(getChannelId(), 0L);
        gProStPublishFeedReq.feed.clientTaskId = this.f223018m.getMMainTaskId();
        gProStPublishFeedReq.jsonFeed = bVar.jsonFeed;
        gProStPublishFeedReq.clientContent = gProStClientContent;
        gProStPublishFeedReq.from = 0;
        if (i3 == 7) {
            gProStPublishFeedReq.needSyncGroup = true;
            gProStPublishFeedReq.from = 1;
        }
        if (gProStCommonExt != null) {
            gProStPublishFeedReq.extInfo = gProStCommonExt;
        }
        if (this.f223014e) {
            gProStPublishFeedReq.needCreateOwnGuild = true;
        }
        Q(gProStPublishFeedReq.httpReqInfo, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.e
            @Override // java.lang.Runnable
            public final void run() {
                j.this.A(c16, gProStPublishFeedReq);
            }
        });
    }

    private void I(long j3) {
        AppRuntime Q0;
        if (j3 != 4003 || (Q0 = ch.Q0()) == null) {
            return;
        }
        ((IPskeyManager) Q0.getRuntimeService(IPskeyManager.class, "")).replacePskey(new String[]{"pd.qq.com"}, new b());
    }

    private void J(GProStFeed gProStFeed) {
        GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent = new GuildPublishSuccessGetFeedEvent();
        guildPublishSuccessGetFeedEvent.setMainTaskId(this.f223018m.getMMainTaskId());
        guildPublishSuccessGetFeedEvent.setShowSuccessToast(this.f223018m.d());
        guildPublishSuccessGetFeedEvent.setStFeed(gProStFeed);
        guildPublishSuccessGetFeedEvent.setEdit(this.f223013d);
        guildPublishSuccessGetFeedEvent.setGuildId(this.f223016h);
        guildPublishSuccessGetFeedEvent.setChannelId(this.f223017i);
        m(guildPublishSuccessGetFeedEvent);
        if (this.f223013d) {
            q(gProStFeed);
        }
    }

    private void O(String str) {
        GuildTaskQueueManager.m().n().uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str).setTraceId(this.f223018m.getMMainTaskId()).setExt3(ax.u()).setExt4(this.f223016h).setExt5(this.f223017i).setKeyRetCode("0"));
    }

    private void P(@NonNull jn1.b bVar, @NonNull GProStClientContent gProStClientContent, @NonNull Map<String, com.tencent.mobileqq.guild.data.o> map) throws Exception {
        Integer num;
        JSONObject jSONObject = new JSONObject(bVar.jsonFeed);
        E(gProStClientContent, jSONObject.optJSONArray("medias"));
        this.D.a(jSONObject, map);
        jSONObject.remove("medias");
        jSONObject.remove("publishExtra");
        bVar.jsonFeed = jSONObject.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[transformPostJson]: mainTaskId = ");
        sb5.append(this.f223018m.getMMainTaskId());
        sb5.append(", jsBean.jsonFeed.length = ");
        String str = bVar.jsonFeed;
        if (str != null) {
            num = Integer.valueOf(str.length());
        } else {
            num = null;
        }
        sb5.append(num);
        QLog.i("PostFeedTask.RequestSenderTask", 1, sb5.toString());
    }

    private void Q(GProHttpReqInfo gProHttpReqInfo, Runnable runnable) {
        AppRuntime Q0 = ch.Q0();
        if (Q0 == null) {
            runnable.run();
            return;
        }
        gProHttpReqInfo.appid = String.valueOf(AppSetting.f());
        B();
        gProHttpReqInfo.routeId = String.valueOf(E);
        gProHttpReqInfo.env = F;
        ((IPskeyManager) Q0.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{"pd.qq.com"}, new a(gProHttpReqInfo, runnable));
    }

    private void k(jn1.b bVar, GProStClientContent gProStClientContent, GProStCommonExt gProStCommonExt, int i3) {
        final o c16 = l.c();
        if (c16 == null) {
            return;
        }
        final GProStAlterFeedReq gProStAlterFeedReq = new GProStAlterFeedReq();
        gProStAlterFeedReq.from = 0;
        gProStAlterFeedReq.jsonFeed = bVar.jsonFeed;
        gProStAlterFeedReq.clientContent = gProStClientContent;
        if (i3 == 7) {
            gProStAlterFeedReq.from = 1;
        }
        if (gProStCommonExt != null) {
            gProStAlterFeedReq.extInfo = gProStCommonExt;
        }
        Q(gProStAlterFeedReq.httpReqInfo, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.d
            @Override // java.lang.Runnable
            public final void run() {
                j.this.u(c16, gProStAlterFeedReq);
            }
        });
    }

    private void l(long j3, String str, String str2, String str3) {
        GuildTaskQueueManager.m().n().uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(str2).setTraceId(this.f223018m.getMMainTaskId()).setExt1(BaseRequest.generateTraceId()).setExt2(String.valueOf(new Random().nextInt())).setExt3(ax.u()).setExt4(this.f223016h).setExt5(this.f223017i).setExt6(str3).setKeyRetCode(String.valueOf(j3)).setDesc(str));
    }

    private void m(@NonNull final GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        o c16 = l.c();
        if (c16 == null) {
            return;
        }
        GProStGetFeedDetailReq gProStGetFeedDetailReq = new GProStGetFeedDetailReq();
        gProStGetFeedDetailReq.from = 0;
        gProStGetFeedDetailReq.detailType = 1;
        gProStGetFeedDetailReq.feedId = guildPublishSuccessGetFeedEvent.getStFeed().idd;
        gProStGetFeedDetailReq.createTime = guildPublishSuccessGetFeedEvent.getStFeed().createTime;
        gProStGetFeedDetailReq.userId = guildPublishSuccessGetFeedEvent.getStFeed().poster.idd;
        gProStGetFeedDetailReq.channelSign = guildPublishSuccessGetFeedEvent.getStFeed().channelInfo.sign;
        gProStGetFeedDetailReq.contentType = 2;
        gProStGetFeedDetailReq.needExternalComment = true;
        gProStGetFeedDetailReq.notReportReadCnt = true;
        c16.getFeedDetail(gProStGetFeedDetailReq, false, new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.a
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
            public final void onResult(int i3, String str, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                j.w(GuildPublishSuccessGetFeedEvent.this, i3, str, z16, gProStGetFeedDetailRsp);
            }
        });
    }

    private GProStCommonExt o(GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        if (this.f223018m.getMMainTaskId() != null) {
            GProFeedEntry gProFeedEntry = new GProFeedEntry();
            gProFeedEntry.key = v4.b.CLIENTKEY;
            gProFeedEntry.value = this.f223018m.getMMainTaskId();
            gProStCommonExt.mapInfoList.add(gProFeedEntry);
        }
        k.a(guildFeedReportSourceInfo, gProStCommonExt);
        k.b(gProStCommonExt);
        return gProStCommonExt;
    }

    private void p(Object obj, boolean z16, long j3, String str, GProStFeed gProStFeed) {
        if (obj instanceof GProStPublishFeedReq) {
            l(j3, str, "CH_E_PUBLISH_FEEDS_RESULT", null);
        } else if (obj instanceof GProStAlterFeedReq) {
            l(j3, str, "CH_E_MODIFY_FEEDS_RESULT", null);
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(z16, j3, str, gProStFeed.idd);
        }
        if (z16 && j3 == 0) {
            J(gProStFeed);
        }
        if (ax.E(j3)) {
            J(gProStFeed);
        }
        if ((ax.F(j3) || r(j3)) && this.f223018m.c()) {
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
        }
    }

    private void q(GProStFeed gProStFeed) {
        Boolean bool;
        GProTopInfo gProTopInfo;
        GProTopInfo gProTopInfo2;
        boolean z16;
        if (gProStFeed == null) {
            return;
        }
        final String str = gProStFeed.idd;
        yl1.i iVar = yl1.i.f450608a;
        Boolean d16 = iVar.d(this.f223016h, str, "");
        boolean z17 = false;
        final int i3 = 1;
        if (d16 == null && (gProTopInfo2 = gProStFeed.topInfo) != null) {
            if (gProTopInfo2.topTimestamp > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16 = Boolean.valueOf(z16);
        }
        IGProChannelInfo B = ch.B(this.f223017i);
        if (B != null && !B.isHiddenPostChannel()) {
            bool = iVar.d(this.f223016h, str, this.f223017i);
            if (bool == null && (gProTopInfo = gProStFeed.topInfo) != null) {
                if (gProTopInfo.channelTopTimestamp > 0) {
                    z17 = true;
                }
                bool = Boolean.valueOf(z17);
            }
        } else {
            bool = null;
        }
        if ((d16 != null && d16.booleanValue()) || (bool != null && bool.booleanValue())) {
            Boolean bool2 = Boolean.TRUE;
            boolean equals = bool2.equals(bool);
            if (bool2.equals(d16) && equals) {
                i3 = 3;
            } else if (equals) {
                i3 = 2;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.b
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.x(str, i3);
                }
            }, 500L);
        }
    }

    private static boolean r(long j3) {
        if (j3 == 20027) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(int i3, String str, GProStAlterFeedReq gProStAlterFeedReq, GProStAlterFeedRsp gProStAlterFeedRsp) {
        boolean z16;
        GProStFeed gProStFeed;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("PostFeedTask.RequestSenderTask", 1, "[AlterFeedRequest]  onReceive | isSuccess = " + z16 + " | retCode =" + i3 + " | errMsg = " + str + " | mainTaskId = " + this.f223018m.getMMainTaskId());
        long j3 = (long) i3;
        if (gProStAlterFeedRsp != null) {
            gProStFeed = gProStAlterFeedRsp.feed;
        } else {
            gProStFeed = new GProStFeed();
        }
        p(gProStAlterFeedReq, z16, j3, str, gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final GProStAlterFeedReq gProStAlterFeedReq, final int i3, final String str, boolean z16, final GProStAlterFeedRsp gProStAlterFeedRsp) {
        I(i3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.h
            @Override // java.lang.Runnable
            public final void run() {
                j.this.s(i3, str, gProStAlterFeedReq, gProStAlterFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(o oVar, final GProStAlterFeedReq gProStAlterFeedReq) {
        oVar.alterFeed(gProStAlterFeedReq, new IGProAlterFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.g
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAlterFeedCallback
            public final void onResult(int i3, String str, boolean z16, GProStAlterFeedRsp gProStAlterFeedRsp) {
                j.this.t(gProStAlterFeedReq, i3, str, z16, gProStAlterFeedRsp);
            }
        });
        O("CH_E_MODIFY_FEEDS_START");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        SimpleEventBus.getInstance().dispatchEvent(guildPublishSuccessGetFeedEvent);
        if (guildPublishSuccessGetFeedEvent.showSuccessToast()) {
            n.z(2, R.string.f145030qd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(final GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent, int i3, String str, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        GProStFeed gProStFeed;
        if (i3 == 0 && gProStGetFeedDetailRsp != null && (gProStFeed = gProStGetFeedDetailRsp.feed) != null) {
            guildPublishSuccessGetFeedEvent.setStFeed(gProStFeed);
            guildPublishSuccessGetFeedEvent.setFeedFullDetail(true);
        } else {
            QLog.e("PostFeedTask.RequestSenderTask", 1, "fetchFeedDetailAndDispatchResult|result= " + i3, " errMsg=", str);
        }
        bc.s(guildPublishSuccessGetFeedEvent.getStFeed(), guildPublishSuccessGetFeedEvent.getMainTaskId());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.c
            @Override // java.lang.Runnable
            public final void run() {
                j.v(GuildPublishSuccessGetFeedEvent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(String str, int i3) {
        if (ch.m0(this.f223016h)) {
            yl1.h.f450607a.e(this.f223016h, this.f223017i, str, i3);
            return;
        }
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
        guildFeedDetailTopUpdateEvent.setGuildId(this.f223016h);
        guildFeedDetailTopUpdateEvent.setChannelId(this.f223017i);
        guildFeedDetailTopUpdateEvent.setTopType(i3);
        SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailTopUpdateEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(int i3, String str, GProStPublishFeedReq gProStPublishFeedReq, GProStPublishFeedRsp gProStPublishFeedRsp) {
        boolean z16;
        GProStFeed gProStFeed;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("PostFeedTask.RequestSenderTask", 1, "[publishFeedRequest]  onReceive | isSuccess = " + z16 + " | retCode = " + i3 + " | errMsg = " + str + " | mainTaskId = " + this.f223018m.getMMainTaskId());
        long j3 = (long) i3;
        if (gProStPublishFeedRsp != null) {
            gProStFeed = gProStPublishFeedRsp.feed;
        } else {
            gProStFeed = new GProStFeed();
        }
        p(gProStPublishFeedReq, z16, j3, str, gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(final GProStPublishFeedReq gProStPublishFeedReq, final int i3, final String str, boolean z16, final GProStPublishFeedRsp gProStPublishFeedRsp) {
        I(i3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publish.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.y(i3, str, gProStPublishFeedReq, gProStPublishFeedRsp);
            }
        });
    }

    public void C() {
        this.C = null;
    }

    protected GProStClientContent D(@NonNull Map<String, com.tencent.mobileqq.guild.data.o> map, List<String> list) {
        GProStClientContent gProStClientContent = new GProStClientContent();
        if (map.isEmpty()) {
            QLog.e("PostFeedTask.RequestSenderTask", 1, "mainTaskId=" + this.f223018m.getMMainTaskId() + "taskList == null || taskList.isEmpty()");
            return gProStClientContent;
        }
        if (list == null) {
            QLog.e("PostFeedTask.RequestSenderTask", 1, "[parseClientContent]: mainTaskId= " + this.f223018m.getMMainTaskId() + "taskIds is NULL! taskList size: " + map.size());
            return gProStClientContent;
        }
        ArrayList<GProStClientImageContent> arrayList = new ArrayList<>();
        ArrayList<GProStClientVideoContent> arrayList2 = new ArrayList<>();
        for (String str : list) {
            com.tencent.mobileqq.guild.data.o oVar = map.get(str);
            if (oVar == null) {
                QLog.i("PostFeedTask.RequestSenderTask", 1, "[parseClientContent] taskIds doesn't contain: " + str + ", taskIds size: " + list.size() + ", mainTaskId: " + this.f223018m.getMMainTaskId());
            } else if (oVar.isVideoTask()) {
                GProStClientVideoContent gProStClientVideoContent = new GProStClientVideoContent();
                gProStClientVideoContent.taskId = str;
                gProStClientVideoContent.coverUrl = oVar.getCoverUrl();
                gProStClientVideoContent.videoId = oVar.f();
                arrayList2.add(gProStClientVideoContent);
                QLog.i("PostFeedTask.RequestSenderTask", 1, "parseClientContent add video taskId | mainTaskId = " + this.f223018m.getMMainTaskId() + " | taskId = " + gProStClientVideoContent.taskId);
            } else {
                GProStClientImageContent gProStClientImageContent = new GProStClientImageContent();
                gProStClientImageContent.taskId = str;
                gProStClientImageContent.url = oVar.getUrl();
                gProStClientImageContent.isOrig = oVar.getIsRaw();
                gProStClientImageContent.origSize = (int) oVar.getTotalFileSize();
                gProStClientImageContent.isGif = oVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.CUSTOM_PROP_ISGIF java.lang.String();
                String md5 = oVar.getMd5();
                if (!TextUtils.isEmpty(md5)) {
                    gProStClientImageContent.md5 = md5;
                }
                arrayList.add(gProStClientImageContent);
                QLog.i("PostFeedTask.RequestSenderTask", 1, "parseClientContent add image taskId | mainTaskId = " + this.f223018m.getMMainTaskId() + " | taskId = " + gProStClientImageContent.taskId);
            }
        }
        gProStClientContent.clientImageContents = arrayList;
        gProStClientContent.clientVideoContents = arrayList2;
        return gProStClientContent;
    }

    public void F(String str, Map<String, com.tencent.mobileqq.guild.data.o> map, int i3, GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        List<String> list;
        String str2;
        jn1.b bVar = (jn1.b) new Gson().fromJson(str, jn1.b.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[publishFeed]  | mainTaskId = ");
        sb5.append(this.f223018m.getMMainTaskId());
        sb5.append(" | jsBean.taskIds = ");
        Integer num = null;
        if (bVar != null) {
            list = bVar.taskIds;
        } else {
            list = null;
        }
        sb5.append(list);
        sb5.append(" | jsBean.jsonFeed.length = ");
        if (bVar != null && (str2 = bVar.jsonFeed) != null) {
            num = Integer.valueOf(str2.length());
        }
        sb5.append(num);
        sb5.append(" | mIsEdit = ");
        sb5.append(this.f223013d);
        QLog.i("PostFeedTask.RequestSenderTask", 1, sb5.toString());
        if (bVar == null) {
            return;
        }
        GProStClientContent D = D(map, bVar.taskIds);
        GProStCommonExt o16 = o(guildFeedReportSourceInfo);
        try {
            P(bVar, D, map);
        } catch (Exception e16) {
            QLog.e("PostFeedTask.RequestSenderTask", 1, "[publishFeed]: transformPostJson failed, taskId=" + this.f223018m.getMMainTaskId() + " exception: \n" + e16);
        }
        if (this.f223013d) {
            k(bVar, D, o16, i3);
        } else {
            G(bVar, D, o16, i3);
        }
    }

    public void H(String str, String str2) {
        this.f223016h = str;
        this.f223017i = str2;
    }

    public void K(boolean z16) {
        this.f223013d = z16;
    }

    public void L(boolean z16) {
        this.f223015f = z16;
    }

    public void M(c cVar) {
        this.C = cVar;
    }

    public void N(boolean z16) {
        this.f223014e = z16;
    }

    @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
    @NonNull
    public String getChannelId() {
        String str = this.f223017i;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
    @NonNull
    public String getGuildId() {
        String str = this.f223016h;
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean n() {
        return this.f223015f;
    }
}

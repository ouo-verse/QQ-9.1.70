package com.tencent.mobileqq.guild.feed.report;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.guild.feed.requset.GuildClientReportRequest;
import com.tencent.mobileqq.guild.nt.qcircle.api.IOutboxTaskQueueApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import guild.GuildClientReport$SingleTableData;
import guild.GuildClientReport$StDataReportRsp;
import guild.GuildCommon$BytesEntry;
import guild.GuildCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedReporter {

    /* renamed from: g, reason: collision with root package name */
    private static volatile GuildFeedReporter f223261g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f223262h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f223263i;

    /* renamed from: a, reason: collision with root package name */
    private List<GuildClientReport$SingleTableData> f223264a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<GuildClientReport$SingleTableData> f223265b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<GuildClientReport$SingleTableData> f223266c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private long f223267d = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name */
    private long f223268e = System.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name */
    private Handler f223269f = RFWThreadManager.createNewThreadHandler("guild_feed_report", 10, new a());

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.report.GuildFeedReporter$5, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ GuildFeedReporter this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i3 = message.what;
            if (i3 == 4097) {
                GuildFeedReporter.this.m();
            } else if (i3 == 4098) {
                GuildFeedReporter.this.s();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<GuildClientReport$StDataReportRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, GuildClientReport$StDataReportRsp guildClientReport$StDataReportRsp) {
            if (z16 && j3 == 0 && guildClientReport$StDataReportRsp != null) {
                QLog.d("GuildFeedReporter", 2, "guildClientReport success!  traceId = " + baseRequest.getTraceId());
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e("GuildFeedReporter", 1, "guildClientReport error:" + str + ",traceId:" + baseRequest.getTraceId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f223262h = timeUnit.toMillis(10000L);
        f223263i = timeUnit.toMillis(60000L);
    }

    GuildFeedReporter() {
        p();
    }

    static /* bridge */ /* synthetic */ c b(GuildFeedReporter guildFeedReporter) {
        guildFeedReporter.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.f223269f.hasMessages(4098)) {
            this.f223269f.sendEmptyMessageDelayed(4098, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        boolean z16;
        if (this.f223264a.size() <= 0 && this.f223266c.size() <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (System.currentTimeMillis() - this.f223267d > f223262h || this.f223264a.size() >= 10) {
                t();
            }
            if (System.currentTimeMillis() - this.f223268e > f223263i || this.f223266c.size() >= 5) {
                u();
            }
        }
        if (!this.f223269f.hasMessages(4097)) {
            if (!z16 && System.currentTimeMillis() - this.f223267d > f223262h * 10) {
                return;
            }
            this.f223269f.sendEmptyMessageDelayed(4097, f223262h);
        }
    }

    public static GuildFeedReporter o() {
        if (f223261g == null) {
            synchronized (GuildFeedReporter.class) {
                if (f223261g == null) {
                    f223261g = new GuildFeedReporter();
                }
            }
        }
        return f223261g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(GuildClientReport$SingleTableData guildClientReport$SingleTableData) {
        StringBuilder sb5 = new StringBuilder();
        if (guildClientReport$SingleTableData != null) {
            sb5.append("tableID:");
            sb5.append(guildClientReport$SingleTableData.tableID.get());
            sb5.append(",reportData:{");
            for (GuildCommon$Entry guildCommon$Entry : guildClientReport$SingleTableData.reportData.get()) {
                sb5.append(guildCommon$Entry.key.get());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(guildCommon$Entry.value.get());
                sb5.append(", ");
            }
            if (guildClientReport$SingleTableData.byteExtInfo.has()) {
                sb5.append("},byteExtInfo:{");
                Iterator<GuildCommon$BytesEntry> it = guildClientReport$SingleTableData.byteExtInfo.get().iterator();
                while (it.hasNext()) {
                    sb5.append(it.next().key.get());
                    sb5.append(", ");
                }
            }
            sb5.append("}\n");
        }
        return sb5.toString();
    }

    public static void r(List<GuildClientReport$SingleTableData> list) {
        if (list != null && list.size() > 0) {
            GuildClientReportRequest guildClientReportRequest = new GuildClientReportRequest(new ArrayList(list));
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.d("GuildFeedReporter", 2, "performClientReport fail! network is not available,save in cache first");
                IOutboxTaskQueueApi iOutboxTaskQueueApi = (IOutboxTaskQueueApi) QRoute.api(IOutboxTaskQueueApi.class);
                iOutboxTaskQueueApi.addPausedTask(iOutboxTaskQueueApi.newTask(guildClientReportRequest));
                return;
            }
            VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), guildClientReportRequest, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        r(this.f223265b);
        this.f223265b.clear();
        QLog.d("GuildFeedReporter", 2, "performImmediateDataListReportToServer called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f223267d = System.currentTimeMillis();
        r(this.f223264a);
        this.f223264a.clear();
        QLog.d("GuildFeedReporter", 2, "performNormalDataListReportToServer called");
    }

    private void u() {
        this.f223268e = System.currentTimeMillis();
        r(this.f223266c);
        this.f223266c.clear();
        QLog.d("GuildFeedReporter", 2, "performQualityDataListReportToServer called");
    }

    public void j(final GuildClientReport$SingleTableData guildClientReport$SingleTableData, final boolean z16) {
        this.f223269f.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.GuildFeedReporter.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                GuildFeedReporter.b(GuildFeedReporter.this);
                if (z16) {
                    GuildFeedReporter.this.f223265b.add(guildClientReport$SingleTableData);
                    GuildFeedReporter.this.l();
                } else {
                    GuildFeedReporter.this.f223264a.add(guildClientReport$SingleTableData);
                }
                GuildFeedReporter.this.m();
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("GuildFeedReporter");
                    if (z16) {
                        str = "_DoImmediate";
                    } else {
                        str = "_DoNormal";
                    }
                    sb5.append(str);
                    QLog.d(sb5.toString(), 2, "add one SingleTableData:" + GuildFeedReporter.q(guildClientReport$SingleTableData));
                }
            }
        });
    }

    public void k(final GuildClientReport$SingleTableData guildClientReport$SingleTableData) {
        this.f223269f.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.GuildFeedReporter.4
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedReporter.this.f223266c.add(guildClientReport$SingleTableData);
                GuildFeedReporter.this.m();
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.d("GuildFeedReporter_DoQuality", 2, "add one singleTableData:" + GuildFeedReporter.q(guildClientReport$SingleTableData));
                }
            }
        });
    }

    public Handler n() {
        return this.f223269f;
    }

    public void p() {
        this.f223269f.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.GuildFeedReporter.2
            @Override // java.lang.Runnable
            public void run() {
                ((IOutboxTaskQueueApi) QRoute.api(IOutboxTaskQueueApi.class)).init();
            }
        }, 10000L);
    }
}

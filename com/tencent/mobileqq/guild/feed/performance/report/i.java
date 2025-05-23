package com.tencent.mobileqq.guild.feed.performance.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class i implements SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private static volatile i f222730e;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, a> f222731d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f222732a = "";

        /* renamed from: b, reason: collision with root package name */
        public boolean f222733b = false;

        /* renamed from: c, reason: collision with root package name */
        public int f222734c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f222735d = 0;

        /* renamed from: e, reason: collision with root package name */
        public String f222736e = "";

        /* renamed from: f, reason: collision with root package name */
        public boolean f222737f = false;

        a() {
        }

        public void a() {
            if (this.f222737f) {
                QLog.w("GuildFeedPublishQualityReportTask", 1, "already report Task, Task: " + this);
                return;
            }
            this.f222737f = true;
            HashMap hashMap = new HashMap();
            hashMap.put("ret", String.valueOf(this.f222735d));
            hashMap.put("msg", this.f222736e);
            hashMap.put("feed_publish_task_id", this.f222732a);
            hashMap.put("feed_publish_task_is_retry", String.valueOf(this.f222733b));
            hashMap.put("feed_publish_task_state", String.valueOf(this.f222734c));
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#error_code#feed_publish", hashMap);
            i.this.f222731d.remove(this.f222732a);
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedPublishQualityReportTask", 1, "reportTask " + this);
            }
        }

        public String toString() {
            return "mainTaskId " + this.f222732a + ", isRetry: " + this.f222733b + ", curState: " + this.f222734c + ", errorCode: " + this.f222735d + ", errMsg: " + this.f222736e + ", isReport: " + this.f222737f;
        }
    }

    i() {
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a();
        aVar.f222732a = str;
        this.f222731d.put(str, aVar);
    }

    public static i e() {
        if (f222730e == null) {
            synchronized (i.class) {
                if (f222730e == null) {
                    f222730e = new i();
                }
            }
        }
        return f222730e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void g(GuildTaskProgressStateEvent guildTaskProgressStateEvent) {
        GuildTaskProgressState taskProgressState = guildTaskProgressStateEvent.getTaskProgressState();
        if (taskProgressState == null) {
            QLog.e("GuildFeedPublishQualityReportTask", 1, "updateStateAndReport taskState is null!");
            return;
        }
        a aVar = this.f222731d.get(taskProgressState.getMainTaskId());
        if (aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedPublishQualityReportTask", 1, "updateStateAndReport: " + guildTaskProgressStateEvent);
        }
        int mainState = taskProgressState.getMainState();
        aVar.f222734c = mainState;
        if (mainState != 3) {
            if (mainState != 4) {
                if (mainState != 5) {
                    return;
                }
                aVar.f222735d = taskProgressState.mPublishErrCode;
                aVar.f222736e = taskProgressState.mPublishErrMsg;
            } else {
                List<GuildMediaProgressState> mediaProgressStates = taskProgressState.getMediaProgressStates();
                if (!mediaProgressStates.isEmpty()) {
                    Iterator<GuildMediaProgressState> it = mediaProgressStates.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GuildMediaProgressState next = it.next();
                        if (next != null && next.mErrCode != 0) {
                            aVar.f222735d = taskProgressState.mPublishErrCode;
                            aVar.f222736e = taskProgressState.mPublishErrMsg;
                            break;
                        }
                    }
                }
                if (aVar.f222735d == 0) {
                    aVar.f222735d = taskProgressState.mPublishErrCode;
                    aVar.f222736e = taskProgressState.mPublishErrMsg;
                }
            }
        } else {
            aVar.f222735d = 0L;
        }
        aVar.a();
    }

    public void d() {
        this.f222731d.clear();
        bl.c().e(this);
    }

    public void f() {
        bl.c().d(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildTriggerPublishOperationEvent.class);
        arrayList.add(GuildRetryTaskOperationEvent.class);
        arrayList.add(AccountChangeEvent.class);
        arrayList.add(GuildTaskProgressStateEvent.class);
        arrayList.add(GuildCancelTaskOperationEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedPublishQualityReportTask", 1, "onReceiveEvent " + simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof GuildTriggerPublishOperationEvent) {
            c(((GuildTriggerPublishOperationEvent) simpleBaseEvent).getMainTaskId());
            return;
        }
        if (simpleBaseEvent instanceof GuildRetryTaskOperationEvent) {
            c(((GuildRetryTaskOperationEvent) simpleBaseEvent).getMainTaskId());
            return;
        }
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            d();
            return;
        }
        if (simpleBaseEvent instanceof GuildTaskProgressStateEvent) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.performance.report.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.g(simpleBaseEvent);
                }
            });
        } else if (simpleBaseEvent instanceof GuildCancelTaskOperationEvent) {
            String mainTaskId = ((GuildCancelTaskOperationEvent) simpleBaseEvent).getMainTaskId();
            if (!TextUtils.isEmpty(mainTaskId)) {
                this.f222731d.remove(mainTaskId);
            }
        }
    }
}

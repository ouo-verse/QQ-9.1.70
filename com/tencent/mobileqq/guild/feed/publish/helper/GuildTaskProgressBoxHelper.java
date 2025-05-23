package com.tencent.mobileqq.guild.feed.publish.helper;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.BatchedMediaProgressStateStorageMediator;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes13.dex */
public class GuildTaskProgressBoxHelper {

    /* renamed from: e, reason: collision with root package name */
    private static volatile GuildTaskProgressBoxHelper f222928e;

    /* renamed from: a, reason: collision with root package name */
    private bc f222929a;

    /* renamed from: b, reason: collision with root package name */
    private bd f222930b;

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<GuildTaskProgressState> f222931c = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final in1.a f222932d;

    public GuildTaskProgressBoxHelper() {
        bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("GuildTaskProgressThread", 0);
        this.f222930b = newHandlerRecycleThread;
        this.f222929a = newHandlerRecycleThread.b();
        this.f222932d = new BatchedMediaProgressStateStorageMediator(this.f222929a);
    }

    public static void A(GuildTaskProgressState guildTaskProgressState, GuildMediaProgressState guildMediaProgressState, GuildMediaProgressState guildMediaProgressState2) {
        int progress;
        if (guildMediaProgressState != null && guildMediaProgressState2 != null) {
            if (!TextUtils.isEmpty(guildMediaProgressState.getPicId())) {
                guildMediaProgressState2.setPicId(guildMediaProgressState.getPicId());
            }
            if (!TextUtils.isEmpty(guildMediaProgressState.getVideoId())) {
                guildMediaProgressState2.setVideoId(guildMediaProgressState.getVideoId());
            }
            if (!TextUtils.isEmpty(guildMediaProgressState.getCoverUrl())) {
                guildMediaProgressState2.setCoverUrl(guildMediaProgressState.getCoverUrl());
            }
            guildMediaProgressState2.setState(guildMediaProgressState.getState());
            if (guildMediaProgressState.getState() == 3) {
                progress = 100;
            } else {
                progress = guildMediaProgressState.getProgress();
            }
            guildMediaProgressState2.setProgress(progress);
            if (guildMediaProgressState.getErrCode() != 0) {
                guildMediaProgressState2.setErrCode(guildMediaProgressState.getErrCode());
            }
            if (!TextUtils.isEmpty(guildMediaProgressState.getErrMsg())) {
                guildMediaProgressState2.setErrMsg(guildMediaProgressState.getErrMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void u(String str, int i3, Object... objArr) {
        GuildTaskProgressState q16 = q(str);
        if (q16 == null) {
            QLog.w("GUP-T-GuildTaskProgressBoxHelper", 1, "[updatePublishProgressStateInner]  taskProgressState == null");
            return;
        }
        q16.setMainState(i3);
        GuildTaskProgressStateEvent guildTaskProgressStateEvent = new GuildTaskProgressStateEvent(q16);
        if (i3 == 2) {
            k(q16);
        } else if (i3 == 3) {
            q16.setProgress(100);
            GuildDbDataHelper.s().q(str);
        } else if (i3 == 5 && objArr.length == 2) {
            Object obj = objArr[0];
            if ((obj instanceof Long) && (objArr[1] instanceof String)) {
                q16.setPublishErrCode(((Long) obj).longValue());
                q16.setPublishErrMsg((String) objArr[1]);
                q16.setProgress(100);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(guildTaskProgressStateEvent, false);
        if (w(q16.getProgress())) {
            QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[updatePublishProgressStateInner]  | taskProgressState = " + q16.toString());
        }
        GuildDbDataHelper.s().O(q16.m184clone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(final GuildTaskProgressState guildTaskProgressState) {
        this.f222929a.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper.2
            @Override // java.lang.Runnable
            public void run() {
                GuildTaskProgressState guildTaskProgressState2 = guildTaskProgressState;
                if (guildTaskProgressState2 != null && guildTaskProgressState2.getMainState() == 2) {
                    if (GuildTaskProgressBoxHelper.this.q(guildTaskProgressState.getMainTaskId()) == null) {
                        QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "calculateFakePublishProgress  not find taskState in queue , return");
                        return;
                    }
                    int mainState = guildTaskProgressState.getMainState();
                    int progress = guildTaskProgressState.getProgress();
                    GuildTaskProgressState guildTaskProgressState3 = guildTaskProgressState;
                    guildTaskProgressState3.setFakePublishProgress(guildTaskProgressState3.getFakePublishProgress() + 5);
                    if (guildTaskProgressState.getFakePublishProgress() >= 100) {
                        guildTaskProgressState.setFakePublishProgress(99);
                    }
                    GuildTaskProgressBoxHelper.l(guildTaskProgressState);
                    if (!GuildTaskProgressBoxHelper.this.m(mainState, progress, guildTaskProgressState)) {
                        SimpleEventBus.getInstance().dispatchEvent(new GuildTaskProgressStateEvent(guildTaskProgressState), false);
                        if (GuildTaskProgressBoxHelper.this.w(guildTaskProgressState.getProgress())) {
                            QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[calculateFakePublishProgress]  | taskProgressState = " + guildTaskProgressState.toString());
                        }
                    }
                    GuildTaskProgressBoxHelper.this.k(guildTaskProgressState);
                    return;
                }
                QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "calculateFakePublishProgress  not publishing , return");
            }
        }, 50L);
    }

    public static void l(GuildTaskProgressState guildTaskProgressState) {
        int progress;
        if (guildTaskProgressState == null) {
            return;
        }
        List<GuildMediaProgressState> mediaProgressStates = guildTaskProgressState.getMediaProgressStates();
        int i3 = 0;
        for (GuildMediaProgressState guildMediaProgressState : mediaProgressStates) {
            if (guildMediaProgressState.getState() == 3) {
                progress = 100;
            } else {
                progress = guildMediaProgressState.getProgress();
            }
            i3 += progress;
        }
        guildTaskProgressState.setProgress((i3 + guildTaskProgressState.getFakePublishProgress()) / (mediaProgressStates.size() + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(int i3, int i16, GuildTaskProgressState guildTaskProgressState) {
        if (guildTaskProgressState == null) {
            return false;
        }
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        if ((guildTaskProgressState.getMainState() != 1 && guildTaskProgressState.getMainState() != 2) || i3 != guildTaskProgressState.getMainState() || i16 != guildTaskProgressState.getProgress()) {
            return false;
        }
        return true;
    }

    public static GuildTaskProgressBoxHelper o() {
        if (f222928e == null) {
            synchronized (GuildTaskProgressBoxHelper.class) {
                if (f222928e == null) {
                    f222928e = new GuildTaskProgressBoxHelper();
                }
            }
        }
        return f222928e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str, String str2) {
        GuildMediaProgressState guildMediaProgressState;
        GuildTaskProgressState q16 = q(str);
        if (q16 == null) {
            QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[removeMediaProgressStateTask] no taskProgressState, taskId=  " + str2);
            return;
        }
        QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[removeMediaProgressStateTask] try find taskId = " + str2);
        List<GuildMediaProgressState> mediaProgressStates = q16.getMediaProgressStates();
        Iterator<GuildMediaProgressState> it = mediaProgressStates.iterator();
        while (true) {
            if (it.hasNext()) {
                guildMediaProgressState = it.next();
                if (TextUtils.equals(guildMediaProgressState.getTaskId(), str2)) {
                    break;
                }
            } else {
                guildMediaProgressState = null;
                break;
            }
        }
        if (guildMediaProgressState != null) {
            QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[removeMediaProgressStateTask]  now remove taskId = " + str2);
            mediaProgressStates.remove(guildMediaProgressState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator<GuildTaskProgressState> it5 = this.f222931c.iterator();
            while (it5.hasNext()) {
                GuildTaskProgressState next = it5.next();
                if (TextUtils.equals(next.getMainTaskId(), str)) {
                    this.f222931c.remove(next);
                    QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[removeProgressStateTaskList]  task = " + next.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(String str, String str2, int i3) {
        GuildTaskProgressState q16 = q(str);
        if (q16 == null) {
            QLog.i("GUP-T-GuildTaskProgressBoxHelper", 1, "taskProgressState == null mainTaskId=" + str);
            return;
        }
        q16.setTriggerSave(true);
        q16.setTriggerPublish(false);
        q16.setJson(str2);
        q16.mScope = i3;
        QLog.i("GUP-T-GuildTaskProgressBoxHelper", 1, "triggerSaveDraftOperation, draftScope" + i3);
        if (i3 == 0) {
            GuildDbDataHelper.s().p(str, q16.getGuildId(), q16.getChannelId());
        } else if (i3 == 1) {
            GuildDbDataHelper.s().n(str, 1);
        }
        GuildDbDataHelper.s().O(q16.m184clone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(String str, int i3) {
        GuildTaskProgressState q16 = q(str);
        if (q16 == null) {
            return;
        }
        q16.setMainState(i3);
        QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[updateTaskStateChange]  | taskProgressState = " + q16);
        SimpleEventBus.getInstance().dispatchEvent(new GuildTaskProgressStateEvent(q16), false);
        GuildDbDataHelper.s().P("StateChange", q16.m184clone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(int i3) {
        if (i3 % 10 == 0) {
            return true;
        }
        return false;
    }

    public void B(final String str, final int i3, final boolean z16, final String str2) {
        final long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() * 1000 * 1000;
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper.5
            @Override // java.lang.Runnable
            public void run() {
                GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.this.q(str);
                if (q16 == null) {
                    return;
                }
                q16.setTriggerPublishTimeNs(serverTimeMillis);
                q16.setTriggerPublish(true);
                q16.setMainState(i3);
                q16.setJson(str2);
                ((FeedPublishServiceV2Impl) ch.R0(IFeedPublishServiceV2.class)).innerOnPublishBegin(z16, q16);
                GuildDbDataHelper.s().O(q16.m184clone());
            }
        });
    }

    public void C(final String str, final String str2, final int i3) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildTaskProgressBoxHelper.this.t(str, str2, i3);
            }
        });
    }

    public void D(final String str, final int i3, final Object... objArr) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildTaskProgressBoxHelper.this.u(str, i3, objArr);
            }
        });
    }

    public void F(final String str, final int i3) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildTaskProgressBoxHelper.this.v(str, i3);
            }
        });
    }

    public void j(final String str, final int i3, final String str2, final String str3, final boolean z16, final int i16, final GuildFeedReportSourceInfo guildFeedReportSourceInfo, final int i17) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                GuildTaskProgressState guildTaskProgressState = new GuildTaskProgressState(str);
                guildTaskProgressState.setGuildId(str2);
                guildTaskProgressState.setChannelId(str3);
                guildTaskProgressState.setMainState(i3);
                guildTaskProgressState.setEdit(z16);
                guildTaskProgressState.setUin(ax.v());
                guildTaskProgressState.setBusinessType(i16);
                guildTaskProgressState.setExtra(guildFeedReportSourceInfo);
                guildTaskProgressState.mScope = i17;
                synchronized (GuildTaskProgressBoxHelper.this.f222931c) {
                    GuildTaskProgressBoxHelper.this.f222931c.add(guildTaskProgressState);
                }
                SimpleEventBus.getInstance().dispatchEvent(new GuildTaskProgressStateEvent(guildTaskProgressState), false);
                QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[addProgressStateTask]  task = " + guildTaskProgressState.toString());
            }
        });
    }

    public void n() {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper.1
            @Override // java.lang.Runnable
            public void run() {
                GuildTaskProgressBoxHelper.this.f222931c.clear();
            }
        });
    }

    public in1.a p() {
        return this.f222932d;
    }

    @Nullable
    public GuildTaskProgressState q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<GuildTaskProgressState> it = this.f222931c.iterator();
        while (it.hasNext()) {
            GuildTaskProgressState next = it.next();
            if (TextUtils.equals(next.getMainTaskId(), str)) {
                return next;
            }
        }
        return null;
    }

    public void x(final String str, final String str2) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildTaskProgressBoxHelper.this.r(str, str2);
            }
        });
    }

    public void y(final String str) {
        GuildTaskProgressState q16 = q(str);
        if (q16 != null) {
            ((FeedPublishServiceV2Impl) ch.R0(IFeedPublishServiceV2.class)).invalidateCache(q16.mGuildId, q16.getChannelId());
        }
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = GuildTaskProgressBoxHelper.this.f222931c.iterator();
                while (it.hasNext()) {
                    GuildTaskProgressState guildTaskProgressState = (GuildTaskProgressState) it.next();
                    if (TextUtils.equals(guildTaskProgressState.getMainTaskId(), str)) {
                        GuildTaskProgressBoxHelper.this.f222931c.remove(guildTaskProgressState);
                        QLog.d("GUP-T-GuildTaskProgressBoxHelper", 1, "[removeProgressStateTask]  task = " + guildTaskProgressState.toString());
                    }
                }
            }
        });
    }

    public void z(final List<String> list) {
        this.f222929a.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.helper.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildTaskProgressBoxHelper.this.s(list);
            }
        });
    }
}

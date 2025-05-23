package com.tencent.mobileqq.guild.feed.detail.task;

import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.detail.event.DeleteCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.event.FindUnfinishedCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.event.NotifySendingCommentsEvent;
import com.tencent.mobileqq.guild.feed.detail.event.ResendCommentEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkpublish.event.GuildUploadStateEvent;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e implements SimpleEventReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static volatile e f218533f;

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<GuildCommentTask> f218534d = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f218535e = new AtomicBoolean(false);

    public static String e(String str) {
        com.tencent.mobileqq.qqalbum.a aVar = new com.tencent.mobileqq.qqalbum.a();
        aVar.f262095a = str;
        String filePath = AbsDownloader.getFilePath(str);
        aVar.f262096b = filePath;
        if (FileUtils.fileExistsAndNotEmpty(filePath) || ((IPicToJpg) QRoute.api(IPicToJpg.class)).picToJpg(aVar)) {
            return aVar.f262096b;
        }
        return str;
    }

    private void f(ArrayList<LocalMediaInfo> arrayList) {
        Iterator<LocalMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            boolean isHeifFile = Utils.isHeifFile(next.path);
            QLog.i("GuildCommentTaskQueueManager", 1, "checkCommentMediaIsHeifAndTans isHeif=" + isHeifFile);
            if (isHeifFile) {
                next.path = e(next.path);
            }
        }
    }

    public static e h() {
        if (f218533f == null) {
            synchronized (e.class) {
                if (f218533f == null) {
                    f218533f = new e();
                }
            }
        }
        return f218533f;
    }

    private void i() {
        onDestroy();
    }

    private void j(final DeleteCommentEvent deleteCommentEvent) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.o(deleteCommentEvent);
            }
        }, 16, null, true);
    }

    private void k(final GuildDoCommentEvent guildDoCommentEvent) {
        if (guildDoCommentEvent.getLocalMediaInfos() == null) {
            hj1.b.a("GuildCommentTaskQueueManager", "handleDoCommentEvent | mediaInfo is null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.p(guildDoCommentEvent);
                }
            }, 128, null, true);
            ((IGuildNewUserMsgNoticeApi) QRoute.api(IGuildNewUserMsgNoticeApi.class)).setNewUserStayOrWriteInChannel(guildDoCommentEvent.getGuildId(), guildDoCommentEvent.getChannelId(), 7);
        }
    }

    private void l(final FindUnfinishedCommentEvent findUnfinishedCommentEvent) {
        final List unmodifiableList = Collections.unmodifiableList(this.f218534d);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.q(unmodifiableList, findUnfinishedCommentEvent);
            }
        }, 16, null, true);
    }

    private void m(final ResendCommentEvent resendCommentEvent) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.task.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.r(resendCommentEvent);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(DeleteCommentEvent deleteCommentEvent) {
        GuildCommentTask g16 = g(deleteCommentEvent.getUuid());
        if (g16 != null) {
            g16.t();
            this.f218534d.remove(g16);
        } else {
            hj1.b.a("GuildCommentTaskQueueManager", "handleDeleteCommentEvent | task is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(GuildDoCommentEvent guildDoCommentEvent) {
        f(guildDoCommentEvent.getLocalMediaInfos());
        GuildCommentTask guildCommentTask = new GuildCommentTask(guildDoCommentEvent, com.tencent.mobileqq.guild.feed.detail.a.a());
        this.f218534d.add(guildCommentTask);
        guildCommentTask.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(List list, FindUnfinishedCommentEvent findUnfinishedCommentEvent) {
        ArrayList arrayList = new ArrayList();
        hj1.b.a("GuildCommentTaskQueueManager", "commentTasks.size: " + list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            GuildCommentTask guildCommentTask = (GuildCommentTask) list.get(i3);
            if (guildCommentTask.q(findUnfinishedCommentEvent) && guildCommentTask.r()) {
                if (guildCommentTask.k()) {
                    guildCommentTask.t();
                    this.f218534d.remove(guildCommentTask);
                } else {
                    CommentResult mResult = guildCommentTask.getMResult();
                    if (mResult != null) {
                        arrayList.add(mResult);
                    }
                }
            }
        }
        bl.c().b(new NotifySendingCommentsEvent(CommentDataUtil.i(arrayList)), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(ResendCommentEvent resendCommentEvent) {
        GuildCommentTask g16 = g(resendCommentEvent.getUuid());
        if (g16 != null) {
            g16.x();
        }
    }

    @Nullable
    public GuildCommentTask g(String str) {
        for (int i3 = 0; i3 < this.f218534d.size(); i3++) {
            if (this.f218534d.get(i3).p().equals(str)) {
                return this.f218534d.get(i3);
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildDoCommentEvent.class);
        arrayList.add(ResendCommentEvent.class);
        arrayList.add(FindUnfinishedCommentEvent.class);
        arrayList.add(AccountChangeEvent.class);
        arrayList.add(DeleteCommentEvent.class);
        arrayList.add(GuildUploadStateEvent.class);
        return arrayList;
    }

    public void n() {
        if (this.f218535e.compareAndSet(false, true)) {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    public void onDestroy() {
        QLog.i("GuildCommentTaskQueueManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f218534d.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        hj1.b.a("GuildCommentTaskQueueManager", "onReceiveEvent " + simpleBaseEvent.getClass().getSimpleName());
        if (simpleBaseEvent instanceof GuildDoCommentEvent) {
            k((GuildDoCommentEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof ResendCommentEvent) {
            m((ResendCommentEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof FindUnfinishedCommentEvent) {
            l((FindUnfinishedCommentEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof AccountChangeEvent) {
            i();
        } else if (simpleBaseEvent instanceof DeleteCommentEvent) {
            j((DeleteCommentEvent) simpleBaseEvent);
        }
    }

    public void s(String str) {
        for (int i3 = 0; i3 < this.f218534d.size(); i3++) {
            if (this.f218534d.get(i3).getMMainTaskId().equals(str)) {
                CopyOnWriteArrayList<GuildCommentTask> copyOnWriteArrayList = this.f218534d;
                copyOnWriteArrayList.remove(copyOnWriteArrayList.get(i3));
            }
        }
    }
}

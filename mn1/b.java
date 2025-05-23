package mn1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.g;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.performance.report.l;
import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildPublishTaskChangeBean;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildMediaProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildModifyUploadTaskEvent;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildTaskProgressBoxHelper;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaInfo;
import ij1.GuildMediaUploadTaskInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J0\u0010\u0015\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a8\u0006#"}, d2 = {"Lmn1/b;", "", "", "flag", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildPublishTaskChangeBean;", "changeBean", "", "k", "Lcom/tencent/mobileqq/guild/feed/publish/event/GuildModifyUploadTaskEvent;", "event", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;", "mainTask", "f", "", "mainTaskId", "Lij1/m;", "taskInfo", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "c", "Lkotlin/Pair;", "", "b", "currentShowList", "e", "d", "mediaTaskId", "i", h.F, "eventId", "j", MiniAppGetGameTaskTicketServlet.KEY_TASKID, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f417040a = new b();

    b() {
    }

    private final Pair<List<String>, List<String>> b(String mainTaskId, GuildPublishTaskChangeBean changeBean) {
        List<String> currentShowMediaList = changeBean.getCurrentShowMediaList();
        Intrinsics.checkNotNullExpressionValue(currentShowMediaList, "changeBean.currentShowMediaList");
        List<String> e16 = e(mainTaskId, currentShowMediaList);
        List<String> currentShowMediaList2 = changeBean.getCurrentShowMediaList();
        Intrinsics.checkNotNullExpressionValue(currentShowMediaList2, "changeBean.currentShowMediaList");
        return new Pair<>(e16, d(mainTaskId, currentShowMediaList2));
    }

    @JvmStatic
    @NotNull
    public static final GuildMediaProgressState c(@NotNull String mainTaskId, @NotNull GuildMediaUploadTaskInfo taskInfo) {
        String str;
        int i3;
        int i16;
        boolean z16;
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        GuildMediaProgressState guildMediaProgressState = new GuildMediaProgressState(taskInfo.getFileId());
        int i17 = 1;
        if (taskInfo.isVideoTask()) {
            guildMediaProgressState.setType("video");
            if (taskInfo.getCoverUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                guildMediaProgressState.setCoverUrl(taskInfo.getCoverUrl());
            }
            guildMediaProgressState.setVideoId(taskInfo.f());
        } else {
            guildMediaProgressState.setType("pic");
            guildMediaProgressState.setCoverUrl(taskInfo.getUrl());
        }
        guildMediaProgressState.setTaskId(taskInfo.getFileId());
        guildMediaProgressState.setState(taskInfo.getState());
        GuildMediaInfo mediaInfo = taskInfo.getMediaInfo();
        if (mediaInfo == null || (str = mediaInfo.getMediaPath()) == null) {
            g localMediaInfo = taskInfo.getLocalMediaInfo();
            if (localMediaInfo != null) {
                str = localMediaInfo.getPath();
            } else {
                str = "";
            }
        }
        guildMediaProgressState.setPath(str);
        guildMediaProgressState.setErrCode(taskInfo.getErrCode());
        guildMediaProgressState.setErrMsg(taskInfo.getErrMsg());
        guildMediaProgressState.setClientKey(taskInfo.getClientKey());
        guildMediaProgressState.setProgress(taskInfo.getUploadProgress());
        guildMediaProgressState.setMainTaskId(mainTaskId);
        guildMediaProgressState.setUploadTaskId(taskInfo.getInternalId());
        Bundle transParams = taskInfo.getTransParams();
        if (transParams != null && transParams.getBoolean("key_original_pic", false)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        guildMediaProgressState.mOriginalPic = i3;
        Bundle transParams2 = taskInfo.getTransParams();
        if (transParams2 != null && transParams2.getBoolean("key_is_gif", false)) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        guildMediaProgressState.mIsGif = i16;
        Bundle transParams3 = taskInfo.getTransParams();
        if (transParams3 == null || !transParams3.getBoolean("key_is_undo", false)) {
            i17 = 0;
        }
        guildMediaProgressState.mIsUndo = i17;
        return guildMediaProgressState;
    }

    private final List<String> d(String mainTaskId, List<String> currentShowList) {
        int collectionSizeOrDefault;
        List list;
        List<String> minus;
        List<String> emptyList;
        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(mainTaskId);
        if (q16 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<GuildMediaProgressState> mediaProgressStates = q16.getMediaProgressStates();
        Intrinsics.checkNotNullExpressionValue(mediaProgressStates, "taskProgressState.mediaProgressStates");
        List<GuildMediaProgressState> list2 = mediaProgressStates;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuildMediaProgressState) it.next()).getTaskId());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) currentShowList, (Iterable) list);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildModifyUploadTaskHelper", 2, "currentUploadList: " + list + ", currentShowList: " + currentShowList + ", needRedoList: " + minus);
        }
        return minus;
    }

    private final List<String> e(String mainTaskId, List<String> currentShowList) {
        int collectionSizeOrDefault;
        List list;
        List<String> minus;
        List<String> emptyList;
        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(mainTaskId);
        if (q16 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<GuildMediaProgressState> mediaProgressStates = q16.getMediaProgressStates();
        Intrinsics.checkNotNullExpressionValue(mediaProgressStates, "taskProgressState.mediaProgressStates");
        List<GuildMediaProgressState> list2 = mediaProgressStates;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuildMediaProgressState) it.next()).getTaskId());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) currentShowList);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildModifyUploadTaskHelper", 2, "currentUploadList: " + list + ", currentShowList: " + currentShowList + ", needUndoList: " + minus);
        }
        return minus;
    }

    @JvmStatic
    public static final void f(@NotNull final GuildModifyUploadTaskEvent event, @NotNull final GuildSingleMainTask mainTask) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(mainTask, "mainTask");
        ThreadManagerV2.excute(new Runnable() { // from class: mn1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(GuildModifyUploadTaskEvent.this, mainTask);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildModifyUploadTaskEvent event, GuildSingleMainTask mainTask) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(mainTask, "$mainTask");
        int flag = event.getFlag();
        if (flag != 1) {
            if (flag == 2) {
                List<String> deleteMediaList = event.getChangeBean().getDeleteMediaList();
                Intrinsics.checkNotNullExpressionValue(deleteMediaList, "event.changeBean.deleteMediaList");
                for (String it : deleteMediaList) {
                    b bVar = f417040a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    bVar.i(it, mainTask);
                }
                return;
            }
            return;
        }
        b bVar2 = f417040a;
        String b16 = mainTask.b();
        Intrinsics.checkNotNullExpressionValue(b16, "mainTask.mainTaskId");
        GuildPublishTaskChangeBean changeBean = event.getChangeBean();
        Intrinsics.checkNotNullExpressionValue(changeBean, "event.changeBean");
        Pair<List<String>, List<String>> b17 = bVar2.b(b16, changeBean);
        Iterator<T> it5 = b17.getFirst().iterator();
        while (it5.hasNext()) {
            f417040a.i((String) it5.next(), mainTask);
        }
        Iterator<T> it6 = b17.getSecond().iterator();
        while (it6.hasNext()) {
            f417040a.h((String) it6.next(), mainTask);
        }
    }

    private final void h(String mediaTaskId, GuildSingleMainTask mainTask) {
        mainTask.G(mediaTaskId);
        l(mediaTaskId, mainTask);
        j(mainTask, "feed_publish_media_redo_upload", mediaTaskId);
    }

    private final void i(String mediaTaskId, GuildSingleMainTask mainTask) {
        mainTask.I(mediaTaskId);
        m(mediaTaskId, mainTask);
        j(mainTask, "feed_publish_media_undo_upload", mediaTaskId);
    }

    private final void j(GuildSingleMainTask mainTask, String eventId, String mediaTaskId) {
        HashMap hashMapOf;
        String t16 = mainTask.t(mediaTaskId);
        if (t16 == null) {
            t16 = "";
        }
        String b16 = mainTask.b();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_publish_task_id", mainTask.b()), TuplesKt.to("feed_publish_media_task_id", mediaTaskId), TuplesKt.to("feed_publish_media_task_type", t16));
        l.g(b16, eventId, hashMapOf, 0L, null, 24, null);
    }

    @JvmStatic
    public static final void k(@GuildModifyUploadTaskEvent.GuildModifyTaskFlag int flag, @NotNull GuildPublishTaskChangeBean changeBean) {
        Intrinsics.checkNotNullParameter(changeBean, "changeBean");
        if (7 != MobileQQ.sProcessId) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "can not send modify event from other process " + MobileQQ.sProcessId;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildModifyUploadTaskHelper", 1, (String) it.next(), null);
            }
            return;
        }
        String h16 = GuildUploadHelper.i().h();
        if (TextUtils.isEmpty(h16)) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("can not send modify event,  because mainTaskId is empty!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildModifyUploadTaskHelper", 1, (String) it5.next(), null);
            }
            return;
        }
        bl.c().b(new GuildModifyUploadTaskEvent(flag, h16, changeBean), true);
    }

    private final void l(String taskId, GuildSingleMainTask mainTask) {
        GuildMediaProgressState guildMediaProgressState;
        String b16 = mainTask.b();
        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(b16);
        if (q16 == null) {
            return;
        }
        Iterator<GuildMediaProgressState> it = q16.getMediaProgressStates().iterator();
        while (true) {
            if (it.hasNext()) {
                guildMediaProgressState = it.next();
                if (TextUtils.equals(guildMediaProgressState.getTaskId(), taskId)) {
                    break;
                }
            } else {
                guildMediaProgressState = null;
                break;
            }
        }
        if (guildMediaProgressState == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildMediaProgressStateEvent(guildMediaProgressState), true);
        GuildTaskProgressBoxHelper.o().F(b16, q16.mState);
    }

    private final void m(String taskId, GuildSingleMainTask mainTask) {
        String b16 = mainTask.b();
        GuildTaskProgressState q16 = GuildTaskProgressBoxHelper.o().q(b16);
        if (q16 == null) {
            return;
        }
        GuildTaskProgressBoxHelper.o().x(b16, taskId);
        GuildDbDataHelper.s().o(b16, taskId);
        GuildTaskProgressBoxHelper.o().F(b16, q16.mState);
    }
}

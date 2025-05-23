package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/q;", "", "Lcom/tencent/mobileqq/guild/feed/api/f;", "listener", "", "fileId", "", "b", "d", "c", "Lij1/m;", "taskInfo", "", "preState", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u001b\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0007H\u0086\u0002R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/q$b;", "", "", "fileId", "", "Lcom/tencent/mobileqq/guild/feed/api/f;", "b", "", "a", "Ljava/util/Map;", "listeners", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f218095a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Map<String, Set<com.tencent.mobileqq.guild.feed.api.f>> listeners = new ConcurrentHashMap();

        b() {
        }

        @NotNull
        public final Map<String, Set<com.tencent.mobileqq.guild.feed.api.f>> a() {
            return listeners;
        }

        @NotNull
        public final Set<com.tencent.mobileqq.guild.feed.api.f> b(@NotNull String fileId) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Map<String, Set<com.tencent.mobileqq.guild.feed.api.f>> map = listeners;
            Set<com.tencent.mobileqq.guild.feed.api.f> set = map.get(fileId);
            if (set == null) {
                set = new LinkedHashSet<>();
                map.put(fileId, set);
            }
            return set;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0194, code lost:
    
        if (r13 == 2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0196, code lost:
    
        if (r13 == 3) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0198, code lost:
    
        if (r13 == 5) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x019e, code lost:
    
        if (r12.j() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a0, code lost:
    
        com.tencent.qphone.base.util.QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onFailed, fileId = " + r12.getFileId());
        ((com.tencent.mobileqq.guild.feed.api.h) r0).g(r12.getFileId(), r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull GuildMediaUploadTaskInfo taskInfo, int preState) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        if (taskInfo.getState() != preState) {
            QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged, fileId = " + taskInfo.getFileId() + " new = " + taskInfo.getState() + ",  old = " + preState);
        }
        for (com.tencent.mobileqq.guild.feed.api.f fVar : b.f218095a.b(taskInfo.getFileId())) {
            fVar.a(taskInfo);
            if (fVar instanceof com.tencent.mobileqq.guild.feed.api.h) {
                if (preState == -1000 && taskInfo.getState() == 0) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onSubmit, fileId = " + taskInfo.getFileId());
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).e(taskInfo.getFileId(), taskInfo);
                } else if (preState == -1000 && taskInfo.getState() == 1) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onSubmit and onResume, fileId = " + taskInfo.getFileId());
                    com.tencent.mobileqq.guild.feed.api.h hVar = (com.tencent.mobileqq.guild.feed.api.h) fVar;
                    hVar.e(taskInfo.getFileId(), taskInfo);
                    hVar.d(taskInfo.getFileId(), taskInfo);
                } else if (preState == 1 && taskInfo.getState() == 1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("GuildFeedMediaUploadObservable", 4, "notifyChanged onProgress, fileId = " + taskInfo.getFileId());
                    }
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).c(taskInfo.getFileId(), taskInfo.getTotalUploadFileSize(), taskInfo.getTotalFileSize(), taskInfo);
                } else if (preState == 1 && (taskInfo.getState() == 0 || taskInfo.getState() == 6)) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onPause, fileId = " + taskInfo.getFileId());
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).b(taskInfo.getFileId(), taskInfo);
                } else if ((preState == 0 || preState == 6) && taskInfo.getState() == 1) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onResume, fileId = " + taskInfo.getFileId());
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).d(taskInfo.getFileId(), taskInfo);
                } else if (preState != -1000 && preState != 2 && preState != 3 && preState != 5 && taskInfo.getState() == 5) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onCancel, fileId = " + taskInfo.getFileId());
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).h(taskInfo.getFileId(), taskInfo);
                } else if (preState != -1000 && preState != 2 && preState != 3 && preState != 5 && taskInfo.e()) {
                    QLog.i("GuildFeedMediaUploadObservable", 1, "notifyChanged onSuccess, fileId = " + taskInfo.getFileId());
                    ((com.tencent.mobileqq.guild.feed.api.h) fVar).f(taskInfo.getFileId(), taskInfo);
                } else {
                    QLog.e("GuildFeedMediaUploadObservable", 1, "notifyChanged unknown action, fileId = " + taskInfo.getFileId() + "\uff0cnew = " + taskInfo.getState() + ",  old = " + preState);
                }
            }
        }
    }

    public void b(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        b.f218095a.b(fileId).add(listener);
    }

    public void c(@NotNull com.tencent.mobileqq.guild.feed.api.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<Map.Entry<String, Set<com.tencent.mobileqq.guild.feed.api.f>>> it = b.f218095a.a().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(listener);
        }
    }

    public void d(@NotNull com.tencent.mobileqq.guild.feed.api.f listener, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        b.f218095a.b(fileId).remove(listener);
    }
}

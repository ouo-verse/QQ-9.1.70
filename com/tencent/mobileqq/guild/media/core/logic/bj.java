package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020!\u00a2\u0006\u0004\b.\u0010/J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J2\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J*\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J<\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J>\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u0019H\u0016R\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/bj;", "Lcom/tencent/mobileqq/guild/media/core/logic/p;", "", "roomId", "", "roomType", "reason", "msg", "", "d", "userId", "a", "g", "", "available", "b", "f", "width", "height", tl.h.F, "errorCode", "errorMsg", "e", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "userVolumes", "totalVolume", "c", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "localQuality", "remoteQuality", "i", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "getCore", "()Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Lcom/tencent/mobileqq/guild/media/core/logic/cg;", "Lcom/tencent/mobileqq/guild/media/core/logic/cg;", "innerListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bj implements p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cg innerListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<WeakReference<ITRTCAudioRoom.b>> listeners;

    public bj(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        cg cgVar = new cg(core);
        this.innerListener = cgVar;
        CopyOnWriteArrayList<WeakReference<ITRTCAudioRoom.b>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(new WeakReference<>(cgVar));
        this.listeners = copyOnWriteArrayList;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void a(@NotNull String roomId, int roomType, @Nullable String userId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.a(roomId, roomType, userId);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void b(@NotNull String roomId, int roomType, @Nullable String userId, boolean available) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.b(roomId, roomType, userId, available);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void c(@NotNull String roomId, int roomType, @Nullable ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.c(roomId, roomType, userVolumes, totalVolume);
            }
        }
        ITRTCAudioRoom.TRTCVolumeInfo.j(userVolumes);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void d(@NotNull String roomId, int roomType, int reason, @Nullable String msg2) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.d(roomId, roomType, reason, msg2);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void e(@NotNull String roomId, int roomType, int errorCode, @Nullable String errorMsg) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.e(roomId, roomType, errorCode, errorMsg);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void f(@NotNull String roomId, int roomType, @Nullable String userId, boolean available) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.f(roomId, roomType, userId, available);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void g(@NotNull String roomId, int roomType, @Nullable String userId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.g(roomId, roomType, userId);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void h(@NotNull String roomId, int roomType, @Nullable String userId, int width, int height) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.h(roomId, roomType, userId, width, height);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void i(@NotNull String roomId, int roomType, @Nullable TRTCQuality localQuality, @Nullable ArrayList<TRTCQuality> remoteQuality) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Iterator<WeakReference<ITRTCAudioRoom.b>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ITRTCAudioRoom.b bVar = it.next().get();
            if (bVar != null) {
                bVar.i(roomId, roomType, localQuality, remoteQuality);
            }
        }
    }
}

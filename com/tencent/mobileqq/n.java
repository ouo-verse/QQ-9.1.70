package com.tencent.mobileqq;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR0\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R.\u0010*\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0)0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR2\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0 j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010#R\u0014\u0010.\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/n;", "", "", "uin", "", "i", "j", "time", "", "g", "pendantId", "", "pendantDiyId", "f", "avatarId", "e", "", "peerUid", "o", "k", "scid", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "peerUin", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Runnable;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "taskMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "uinToLastMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "d", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "uinToLastLock", "Lkotlin/Pair;", "cachePendantIdMap", "cacheAvatarIdMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "forceFrequencyFlags", "forceFrequencyFlagLock", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f252475a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Runnable> taskMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Long> uinToLastMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantReadWriteLock uinToLastLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Long, Pair<Long, Integer>> cachePendantIdMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Long, Integer> cacheAvatarIdMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Long, AtomicBoolean> forceFrequencyFlags;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantReadWriteLock forceFrequencyFlagLock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f252475a = new n();
        taskMap = new ConcurrentHashMap<>();
        uinToLastMap = new HashMap<>();
        uinToLastLock = new ReentrantReadWriteLock();
        cachePendantIdMap = new ConcurrentHashMap<>();
        cacheAvatarIdMap = new ConcurrentHashMap<>();
        forceFrequencyFlags = new HashMap<>();
        forceFrequencyFlagLock = new ReentrantReadWriteLock();
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(long j3, int i3, String peerUid, String key) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(key, "$key");
        QLog.i("AvatarPendantCache", 1, "dispatch avatar Frequency uin:" + LogUtil.wrapLogUin(String.valueOf(j3)) + " avatarId:" + i3);
        String scid = com.tencent.mobileqq.vas.avatar.h.a(i3, com.tencent.mobileqq.vas.avatar.h.b(200));
        Intrinsics.checkNotNullExpressionValue(scid, "scid");
        new i.g(scid).e(false, j3, peerUid);
        new i.g(scid).e(true, j3, peerUid);
        taskMap.remove(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String scid, AIOMsgItem msg2, String key) {
        Intrinsics.checkNotNullParameter(scid, "$scid");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(key, "$key");
        new i.g(scid).f(msg2);
        taskMap.remove(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(long j3, long j16, String peerUid, String key) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(key, "$key");
        QLog.i("AvatarPendantCache", 1, "dispatch pendant Frequency uin:" + LogUtil.wrapLogUin(String.valueOf(j3)) + " pendantId:" + j16);
        new i.d(j16).e(false, j3, peerUid);
        new i.d(j16).e(true, j3, peerUid);
        taskMap.remove(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(i.d frequency, AIOMsgItem msg2, String key) {
        Intrinsics.checkNotNullParameter(frequency, "$frequency");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(key, "$key");
        frequency.f(msg2);
        taskMap.remove(key);
    }

    public final void e(long uin, int avatarId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(uin), Integer.valueOf(avatarId));
        } else {
            cacheAvatarIdMap.put(Long.valueOf(uin), Integer.valueOf(avatarId));
        }
    }

    public final void f(long uin, long pendantId, int pendantDiyId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(uin), Long.valueOf(pendantId), Integer.valueOf(pendantDiyId));
        } else {
            cachePendantIdMap.put(Long.valueOf(uin), new Pair<>(Long.valueOf(pendantId), Integer.valueOf(pendantDiyId)));
        }
    }

    public final void g(long uin, long time) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(uin), Long.valueOf(time));
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = uinToLastLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            Long l3 = uinToLastMap.get(Long.valueOf(uin));
            if (l3 == null || time > l3.longValue()) {
                ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    i3 = reentrantReadWriteLock.getReadHoldCount();
                } else {
                    i3 = 0;
                }
                for (int i17 = 0; i17 < i3; i17++) {
                    readLock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    uinToLastMap.put(Long.valueOf(uin), Long.valueOf(time));
                    Unit unit = Unit.INSTANCE;
                } finally {
                    while (i16 < i3) {
                        readLock2.lock();
                        i16++;
                    }
                    writeLock.unlock();
                }
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void h(long uin, @NotNull String peerUin, @NotNull String peerUid) {
        int i3;
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(uin), peerUin, peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (uin == 0) {
            return;
        }
        IVasAioData iVasAioData = (IVasAioData) QRoute.api(IVasAioData.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(uin);
        IVasAioData.VasAioPersonalData aioVasPersonalData = iVasAioData.getAioVasPersonalData(peerUin, sb5.toString(), 0);
        int avatarId = aioVasPersonalData.getAvatarId();
        Integer num = cacheAvatarIdMap.get(Long.valueOf(uin));
        if (num == null || avatarId != num.intValue()) {
            ReentrantReadWriteLock reentrantReadWriteLock = forceFrequencyFlagLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i3 = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i3 = 0;
            }
            for (int i18 = 0; i18 < i3; i18++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                forceFrequencyFlags.put(Long.valueOf(uin), new AtomicBoolean(true));
                for (int i19 = 0; i19 < i3; i19++) {
                    readLock.lock();
                }
                writeLock.unlock();
                k(aioVasPersonalData.getAvatarId(), uin, peerUid);
                if (QLog.isDebugVersion()) {
                    QLog.i("AvatarPendantCache", 4, "avatar is not match and request frequency: new=" + aioVasPersonalData.getAvatarId() + " old:" + cacheAvatarIdMap.get(Long.valueOf(uin)));
                }
            } catch (Throwable th5) {
                while (i17 < i3) {
                    readLock.lock();
                    i17++;
                }
                writeLock.unlock();
                throw th5;
            }
        }
        Pair<Long, Integer> pair = cachePendantIdMap.get(Long.valueOf(uin));
        if (pair != null && aioVasPersonalData.getPendantId() == pair.getFirst().longValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || aioVasPersonalData.getPendantDiyInfoId() != pair.getSecond().intValue()) {
            ReentrantReadWriteLock reentrantReadWriteLock2 = forceFrequencyFlagLock;
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock2.readLock();
            if (reentrantReadWriteLock2.getWriteHoldCount() == 0) {
                i16 = reentrantReadWriteLock2.getReadHoldCount();
            } else {
                i16 = 0;
            }
            for (int i26 = 0; i26 < i16; i26++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
            writeLock2.lock();
            try {
                forceFrequencyFlags.put(Long.valueOf(uin), new AtomicBoolean(true));
                while (i17 < i16) {
                    readLock2.lock();
                    i17++;
                }
                writeLock2.unlock();
                o(aioVasPersonalData.getPendantId(), uin, peerUid);
                if (QLog.isDebugVersion()) {
                    QLog.i("AvatarPendantCache", 4, "pendant is not match and request frequency: new=" + aioVasPersonalData.getPendantId() + " diyId:" + aioVasPersonalData.getPendantDiyInfoId() + " old:" + cacheAvatarIdMap.get(Long.valueOf(uin)));
                }
            } catch (Throwable th6) {
                while (i17 < i16) {
                    readLock2.lock();
                    i17++;
                }
                writeLock2.unlock();
                throw th6;
            }
        }
    }

    public final boolean i(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, uin)).booleanValue();
        }
        ReentrantReadWriteLock.ReadLock readLock = forceFrequencyFlagLock.readLock();
        readLock.lock();
        try {
            AtomicBoolean atomicBoolean = forceFrequencyFlags.get(Long.valueOf(uin));
            if (atomicBoolean == null) {
                return false;
            }
            readLock.unlock();
            Intrinsics.checkNotNullExpressionValue(atomicBoolean, "forceFrequencyFlagLock.r\u2026?: return false\n        }");
            if (!atomicBoolean.compareAndSet(true, false)) {
                return false;
            }
            return true;
        } finally {
            readLock.unlock();
        }
    }

    public final long j(long uin) {
        long longValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, uin)).longValue();
        }
        ReentrantReadWriteLock.ReadLock readLock = uinToLastLock.readLock();
        readLock.lock();
        try {
            Long l3 = uinToLastMap.get(Long.valueOf(uin));
            if (l3 == null) {
                longValue = -1;
            } else {
                Intrinsics.checkNotNullExpressionValue(l3, "uinToLastMap[uin] ?: -1L");
                longValue = l3.longValue();
            }
            return longValue;
        } finally {
            readLock.unlock();
        }
    }

    public final void k(final int avatarId, final long uin, @NotNull final String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(avatarId), Long.valueOf(uin), peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        final String str = "a_" + avatarId + "-u_" + uin;
        ConcurrentHashMap<String, Runnable> concurrentHashMap = taskMap;
        Runnable remove = concurrentHashMap.remove(str);
        if (remove != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(remove);
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.k
            @Override // java.lang.Runnable
            public final void run() {
                n.l(uin, avatarId, peerUid, str);
            }
        };
        concurrentHashMap.put(str, runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1L);
    }

    public final void m(@NotNull final String scid, @NotNull final AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) scid, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(scid, "scid");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        final String str = "a_" + scid + "-u_" + msg2.getMsgRecord().senderUin;
        ConcurrentHashMap<String, Runnable> concurrentHashMap = taskMap;
        Runnable remove = concurrentHashMap.remove(str);
        if (remove != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(remove);
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.l
            @Override // java.lang.Runnable
            public final void run() {
                n.n(scid, msg2, str);
            }
        };
        concurrentHashMap.put(str, runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1L);
    }

    public final void o(final long pendantId, final long uin, @NotNull final String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(pendantId), Long.valueOf(uin), peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        final String str = "p_" + pendantId + "-u_" + uin;
        ConcurrentHashMap<String, Runnable> concurrentHashMap = taskMap;
        Runnable remove = concurrentHashMap.remove(str);
        if (remove != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(remove);
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.j
            @Override // java.lang.Runnable
            public final void run() {
                n.p(uin, pendantId, peerUid, str);
            }
        };
        concurrentHashMap.put(str, runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1L);
    }

    public final void q(long pendantId, @NotNull final AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(pendantId), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        final i.d dVar = new i.d(pendantId);
        final String str = "p_" + dVar.b() + "-u_" + msg2.getMsgRecord().senderUin;
        ConcurrentHashMap<String, Runnable> concurrentHashMap = taskMap;
        Runnable remove = concurrentHashMap.remove(str);
        if (remove != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(remove);
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.m
            @Override // java.lang.Runnable
            public final void run() {
                n.r(i.d.this, msg2, str);
            }
        };
        concurrentHashMap.put(str, runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1L);
    }
}

package com.tencent.mobileqq.wink.newalbum.scale;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0002R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/scale/b;", "", "", "e", "g", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "b", "d", "c", "Ljava/util/concurrent/LinkedBlockingQueue;", "a", "Ljava/util/concurrent/LinkedBlockingQueue;", "contextList", "getResultList", "()Ljava/util/concurrent/LinkedBlockingQueue;", "setResultList", "(Ljava/util/concurrent/LinkedBlockingQueue;)V", "resultList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInterrupted", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedBlockingQueue<WinkNewAlbumContext> contextList = new LinkedBlockingQueue<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedBlockingQueue<WinkNewAlbumContext> resultList = new LinkedBlockingQueue<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isInterrupted = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.scale.a
        @Override // java.lang.Runnable
        public final void run() {
            b.f(b.this);
        }
    };

    private final void e() {
        while (true) {
            if (this.isInterrupted.get()) {
                break;
            }
            try {
                WinkNewAlbumContext poll = this.contextList.poll();
                if (poll == null) {
                    try {
                        LockMethodProxy.sleep(10L);
                    } catch (Exception e16) {
                        QLog.e("WinkNewAlbumPhotoScaleManager", 1, e16, new Object[0]);
                    }
                } else {
                    if (poll.getIsLast()) {
                        this.resultList.offer(poll);
                        this.isInterrupted.set(true);
                        QLog.e("WinkNewAlbumPhotoScaleManager", 1, "finish");
                        break;
                    }
                    String id5 = poll.getMetaData().getId();
                    if (StringUtil.isEmpty(id5)) {
                        QLog.e("WinkNewAlbumPhotoScaleManager", 1, "photoID is empty!");
                    } else if (WinkNewAlbumDatabaseImp.u(id5)) {
                        this.resultList.offer(poll);
                    } else {
                        synchronized (this.resultList) {
                            if (this.resultList.size() >= 10) {
                                QLog.i("WinkNewAlbumPhotoScaleManager", 1, "resultList size = " + this.resultList.size() + ", wait ");
                                LinkedBlockingQueue<WinkNewAlbumContext> linkedBlockingQueue = this.resultList;
                                Intrinsics.checkNotNull(linkedBlockingQueue, "null cannot be cast to non-null type java.lang.Object");
                                LockMethodProxy.wait(linkedBlockingQueue);
                            }
                            LocalMediaInfo originPhoto = poll.getMetaData().getOriginPhoto();
                            if (originPhoto != null) {
                                poll.z(WinkNewAlbumPhotoScaleUtils.f324337a.a(originPhoto, w83.b.f445025a.t()));
                            }
                            this.resultList.offer(poll);
                            QLog.d("WinkNewAlbumPhotoScaleManager", 4, "offer resultList size = " + this.resultList.size());
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            } catch (InterruptedException e17) {
                Thread.currentThread().interrupt();
                QLog.e("WinkNewAlbumPhotoScaleManager", 1, e17, new Object[0]);
            } catch (Exception e18) {
                QLog.e("WinkNewAlbumPhotoScaleManager", 1, e18, new Object[0]);
            }
        }
        QLog.i("WinkNewAlbumPhotoScaleManager", 1, "produce end");
        WinkNewAlbumPhotoScaleUtils.f324337a.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    public final void b(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextList.offer(context);
    }

    public final void c() {
        QLog.i("WinkNewAlbumPhotoScaleManager", 1, "cancel");
        this.isInterrupted.set(true);
        synchronized (this.resultList) {
            LinkedBlockingQueue<WinkNewAlbumContext> linkedBlockingQueue = this.resultList;
            Intrinsics.checkNotNull(linkedBlockingQueue, "null cannot be cast to non-null type java.lang.Object");
            linkedBlockingQueue.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final WinkNewAlbumContext d() {
        WinkNewAlbumContext poll;
        synchronized (this.resultList) {
            if (this.resultList.size() <= 2) {
                LinkedBlockingQueue<WinkNewAlbumContext> linkedBlockingQueue = this.resultList;
                Intrinsics.checkNotNull(linkedBlockingQueue, "null cannot be cast to non-null type java.lang.Object");
                linkedBlockingQueue.notifyAll();
            }
            poll = this.resultList.poll();
        }
        return poll;
    }

    public final void g() {
        QLog.i("WinkNewAlbumPhotoScaleManager", 1, "start");
        ThreadManagerV2.excute(this.runnable, 64, null, true);
    }
}

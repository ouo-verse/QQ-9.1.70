package com.tencent.qqnt.chats.main.vm.datasource.preprocess;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J.\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tJ8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0003\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/b;", "", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "processor", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "srcList", "", "latchCount", "", "isGuildUpdate", "", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "index", "b", "f", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "", "sortedContactList", "allContactList", "e", "a", "Z", "isWork", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isWork;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/b$a;", "", "", "COUNT_PER_HANDLE", "I", "COUNT_TOTAL_THREAD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.preprocess.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(c processor, AtomicInteger index, List<RecentContactInfo> srcList, boolean isGuildUpdate) {
        int andIncrement;
        int size = srcList.size();
        while (this.isWork && (andIncrement = index.getAndIncrement()) < size) {
            processor.a(srcList.get(andIncrement), isGuildUpdate);
        }
    }

    private final void c(final c processor, final List<RecentContactInfo> srcList, int latchCount, final boolean isGuildUpdate) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        int i3 = latchCount - 1;
        final CountDownLatch countDownLatch = new CountDownLatch(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.main.vm.datasource.preprocess.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(b.this, processor, atomicInteger, srcList, isGuildUpdate, countDownLatch);
                }
            }, 16, null, false);
        }
        b(processor, atomicInteger, srcList, isGuildUpdate);
        countDownLatch.await(200L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, c processor, AtomicInteger index, List srcList, boolean z16, CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(processor, "$processor");
        Intrinsics.checkNotNullParameter(index, "$index");
        Intrinsics.checkNotNullParameter(srcList, "$srcList");
        Intrinsics.checkNotNullParameter(latch, "$latch");
        this$0.b(processor, index, srcList, z16);
        latch.countDown();
    }

    @NotNull
    public final List<Long> e(@NotNull d processor, @NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> allContactList, boolean isGuildUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, processor, sortedContactList, allContactList, Boolean.valueOf(isGuildUpdate));
        }
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
        Intrinsics.checkNotNullParameter(allContactList, "allContactList");
        return processor.a(sortedContactList, allContactList, isGuildUpdate);
    }

    public final void f(@NotNull c processor, @NotNull List<RecentContactInfo> srcList, boolean isGuildUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, processor, srcList, Boolean.valueOf(isGuildUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(srcList, "srcList");
        if (this.isWork) {
            QLog.d("ChatsDataProcExecutor", 1, "chatData pre process fail. isWorking");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.isWork = true;
        int min = Math.min(srcList.size() / 4, 5);
        if (min <= 1) {
            int size = srcList.size();
            for (int i3 = 0; i3 < size; i3++) {
                processor.a(srcList.get(i3), isGuildUpdate);
            }
        } else {
            c(processor, srcList, min, isGuildUpdate);
        }
        this.isWork = false;
        QLog.d("ChatsDataPreProcessExecutor", 1, "chatData pre process cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms, useThreadCount=" + min);
    }
}

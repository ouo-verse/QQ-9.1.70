package com.tencent.qqnt.chats.main.vm.datasource;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b'\u0010(JE\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001c\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u000eJR\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00022\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\r\u001a\u00020\fR\u0016\u0010&\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/b;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "srcList", "", "latchCount", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "resultList", "Lcom/tencent/qqnt/chats/data/converter/b;", "converter", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;", "ext", "", "e", "(Ljava/util/List;I[Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Lcom/tencent/qqnt/chats/data/converter/b;Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;)V", "b", "([Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;)I", "Ljava/util/concurrent/atomic/AtomicInteger;", "index", "d", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/List;[Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Lcom/tencent/qqnt/chats/data/converter/b;Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;)V", "", "g", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "filterList", "info", "c", "i", "localFilterList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "filterIdSet", h.F, "a", "Z", "isWork", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isWork;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/b$a;", "", "", "COUNT_PER_HANDLE", "I", "COUNT_TOTAL_THREAD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
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

    private final int b(com.tencent.qqnt.chats.core.adapter.itemdata.g[] resultList) {
        int i3 = 0;
        for (com.tencent.qqnt.chats.core.adapter.itemdata.g gVar : resultList) {
            if (gVar != null) {
                i3++;
            }
        }
        return i3;
    }

    private final boolean c(List<? extends com.tencent.qqnt.chats.main.vm.datasource.filter.a> filterList, com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        if (filterList != null) {
            Iterator<T> it = filterList.iterator();
            while (it.hasNext()) {
                if (((com.tencent.qqnt.chats.main.vm.datasource.filter.a) it.next()).a(info)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private final void d(AtomicInteger index, List<RecentContactInfo> srcList, com.tencent.qqnt.chats.core.adapter.itemdata.g[] resultList, com.tencent.qqnt.chats.data.converter.b converter, LocalChatsCacheDataSource.b ext) {
        int andIncrement;
        int size = srcList.size();
        while (this.isWork && (andIncrement = index.getAndIncrement()) < size) {
            resultList[andIncrement] = converter.a(srcList.get(andIncrement), ext);
        }
    }

    private final void e(final List<RecentContactInfo> srcList, int latchCount, final com.tencent.qqnt.chats.core.adapter.itemdata.g[] resultList, final com.tencent.qqnt.chats.data.converter.b converter, final LocalChatsCacheDataSource.b ext) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        int i3 = latchCount - 1;
        final CountDownLatch countDownLatch = new CountDownLatch(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.main.vm.datasource.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.f(b.this, atomicInteger, srcList, resultList, converter, ext, countDownLatch);
                }
            }, 16, null, false);
        }
        d(atomicInteger, srcList, resultList, converter, ext);
        boolean await = countDownLatch.await(200L, TimeUnit.MILLISECONDS);
        int b16 = b(resultList);
        if (b16 != srcList.size() && g()) {
            QLog.d("ChatsDataProcExecutor", 1, "thread handle timeout, count=" + atomicInteger.get() + ", source.size=" + srcList.size() + ", isFinish=" + await);
            atomicInteger.set(b16);
            d(atomicInteger, srcList, resultList, converter, ext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, AtomicInteger index, List srcList, com.tencent.qqnt.chats.core.adapter.itemdata.g[] resultList, com.tencent.qqnt.chats.data.converter.b converter, LocalChatsCacheDataSource.b ext, CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(index, "$index");
        Intrinsics.checkNotNullParameter(srcList, "$srcList");
        Intrinsics.checkNotNullParameter(resultList, "$resultList");
        Intrinsics.checkNotNullParameter(converter, "$converter");
        Intrinsics.checkNotNullParameter(ext, "$ext");
        Intrinsics.checkNotNullParameter(latch, "$latch");
        this$0.d(index, srcList, resultList, converter, ext);
        latch.countDown();
    }

    private final boolean g() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("chats_90100_handle_not_equal", true);
    }

    @NotNull
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> h(@NotNull List<RecentContactInfo> srcList, @NotNull com.tencent.qqnt.chats.data.converter.b converter, @Nullable List<? extends com.tencent.qqnt.chats.main.vm.datasource.filter.a> localFilterList, @NotNull HashSet<Long> filterIdSet, @NotNull LocalChatsCacheDataSource.b ext) {
        int i3;
        com.tencent.qqnt.chats.core.adapter.itemdata.g[] gVarArr;
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, srcList, converter, localFilterList, filterIdSet, ext);
        }
        Intrinsics.checkNotNullParameter(srcList, "srcList");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(filterIdSet, "filterIdSet");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (this.isWork) {
            QLog.d("ChatsDataProcExecutor", 1, "chatData proc fail. isWorking");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.isWork = true;
        int size = srcList.size();
        com.tencent.qqnt.chats.core.adapter.itemdata.g[] gVarArr2 = new com.tencent.qqnt.chats.core.adapter.itemdata.g[size];
        for (int i17 = 0; i17 < size; i17++) {
            gVarArr2[i17] = null;
        }
        int min = Math.min(srcList.size() / 4, 5);
        if (min > 1 && !ext.d()) {
            i3 = min;
            gVarArr = gVarArr2;
            e(srcList, min, gVarArr2, converter, ext);
        } else {
            i3 = min;
            gVarArr = gVarArr2;
            int size2 = srcList.size();
            for (int i18 = 0; i18 < size2; i18++) {
                gVarArr[i18] = converter.a(srcList.get(i18), ext);
            }
        }
        this.isWork = false;
        QLog.d("ChatsDataProcExecutor", 1, "chatData proc1 cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms, useThreadCount=" + i3 + ", resultListCount=" + size);
        ArrayList arrayList = new ArrayList();
        int i19 = 0;
        while (i16 < size) {
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = gVarArr[i16];
            int i26 = i19 + 1;
            if (gVar == null || !c(localFilterList, gVar)) {
                filterIdSet.add(Long.valueOf(srcList.get(i19).contactId));
                gVar = null;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
            i16++;
            i19 = i26;
        }
        QLog.d("ChatsDataProcExecutor", 1, "chatData proc2 after filter: " + (System.currentTimeMillis() - currentTimeMillis) + "ms, changeSize=" + srcList.size() + ", afterSize=" + arrayList.size());
        return arrayList;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.isWork = false;
            QLog.d("ChatsDataProcExecutor", 1, "stop stop stop. stop");
        }
    }
}

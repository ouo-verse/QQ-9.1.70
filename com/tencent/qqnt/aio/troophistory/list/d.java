package com.tencent.qqnt.aio.troophistory.list;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback;
import com.tencent.qqnt.kernel.nativeinterface.QueriedMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "e", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "msgId", "msgTime", "msgSeq", "Lcom/tencent/qqnt/aio/troophistory/list/c;", h.F, "(ZJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "Ljava/lang/String;", "troopUin", "", "b", "Ljava/util/List;", "uidList", "<set-?>", "c", "Z", "f", "()Z", "hasMoreData", "d", "g", "isLoading", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> uidList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasMoreData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isLoading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/d$a;", "", "", "PAGE_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.troophistory.list.d$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052*\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "queriedMsgInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b implements IQueryMsgsAndAbstractsWithFilterCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StringBuffer f352215a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f352216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<c> f352217c;

        /* JADX WARN: Multi-variable type inference failed */
        b(StringBuffer stringBuffer, d dVar, CancellableContinuation<? super c> cancellableContinuation) {
            this.f352215a = stringBuffer;
            this.f352216b = dVar;
            this.f352217c = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, stringBuffer, dVar, cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryMsgsAndAbstractsWithFilterCallback
        public final void onResult(int i3, String str, ArrayList<QueriedMsgInfo> queriedMsgInfoList) {
            boolean z16;
            int collectionSizeOrDefault;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, queriedMsgInfoList);
                return;
            }
            this.f352215a.append("result:" + i3 + ", errMsg:" + str + ", size:" + queriedMsgInfoList.size());
            QLog.i("TroopHistoryMsgLoader.", 1, this.f352215a.toString());
            this.f352216b.isLoading = false;
            d dVar = this.f352216b;
            if (i3 != 0 || queriedMsgInfoList.size() >= 20) {
                z16 = true;
            } else {
                z16 = false;
            }
            dVar.hasMoreData = z16;
            if (!this.f352217c.isActive()) {
                return;
            }
            if (i3 == 0) {
                z17 = true;
            }
            Intrinsics.checkNotNullExpressionValue(queriedMsgInfoList, "queriedMsgInfoList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(queriedMsgInfoList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = queriedMsgInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(((QueriedMsgInfo) it.next()).msgRecord);
            }
            this.f352217c.resumeWith(Result.m476constructorimpl(new c(z17, arrayList)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull String troopUin, @NotNull List<String> uidList) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin, (Object) uidList);
        } else {
            this.troopUin = troopUin;
            this.uidList = uidList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QueryMsgsParams e() {
        List emptyList;
        ChatInfo chatInfo = new ChatInfo(2, this.troopUin);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new QueryMsgsParams(chatInfo, new ArrayList(emptyList), new ArrayList(this.uidList), 0L, 0L, 20, false, false);
    }

    public static /* synthetic */ Object i(d dVar, boolean z16, long j3, long j16, long j17, Continuation continuation, int i3, Object obj) {
        long j18;
        long j19;
        long j26;
        if ((i3 & 2) != 0) {
            j18 = 0;
        } else {
            j18 = j3;
        }
        if ((i3 & 4) != 0) {
            j19 = 0;
        } else {
            j19 = j16;
        }
        if ((i3 & 8) != 0) {
            j26 = 0;
        } else {
            j26 = j17;
        }
        return dVar.h(z16, j18, j19, j26, continuation);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.hasMoreData;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isLoading;
    }

    @Nullable
    public final Object h(boolean z16, long j3, long j16, long j17, @NotNull Continuation<? super c> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            StringBuffer stringBuffer = new StringBuffer("loadData. troopUin:" + this.troopUin + ", isLoadMore:" + z16 + ", msgSeq:" + j17 + ", msgId:" + j3 + ", ");
            QLog.i("TroopHistoryMsgLoader.", 1, stringBuffer.toString());
            this.isLoading = true;
            b bVar = new b(stringBuffer, this, cancellableContinuationImpl);
            w e16 = f.e();
            if (e16 != null) {
                e16.queryMsgsAndAbstractsWithFilter(j3, j16, j17, e(), bVar);
            } else {
                QLog.e("TroopHistoryMsgLoader.", 1, "getKernelMsgService is null!");
                this.isLoading = false;
                this.hasMoreData = true;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(c.INSTANCE.a()));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), continuation);
    }
}

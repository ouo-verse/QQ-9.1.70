package com.tencent.mobileqq.troop.teamup.home.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpListCallback;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J3\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/repo/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpListReq;", "req", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/troop/teamup/home/data/b;", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpListReq;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/api/s;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "Lcom/tencent/mobileqq/troop/teamup/home/data/a;", "a", "", "isCreator", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData$TroopTeamUpState;", "c", "", "cookie", "", "groupId", "", "type", "e", "([BJILkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", PanoramaConfig.KEY_CURRENT_UIN, "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/repo/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.repo.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpListRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b implements IGetTeamUpListCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.mobileqq.troop.teamup.home.data.b> f299007a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<TroopTeamUpData> f299008b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f299009c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super com.tencent.mobileqq.troop.teamup.home.data.b> continuation, ArrayList<TroopTeamUpData> arrayList, a aVar) {
            this.f299007a = continuation;
            this.f299008b = arrayList;
            this.f299009c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, continuation, arrayList, aVar);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpListCallback
        public final void onResult(int i3, String errMsg, GetTeamUpListRsp getTeamUpListRsp) {
            boolean z16;
            String str;
            int collectionSizeOrDefault;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, getTeamUpListRsp);
                return;
            }
            if (getTeamUpListRsp.isEnd == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 != 0) {
                QLog.e("TroopTeamUp::TeamUpRepository", 1, "getTeamUpList() error: " + errMsg);
                Continuation<com.tencent.mobileqq.troop.teamup.home.data.b> continuation = this.f299007a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                continuation.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.home.data.b(false, errMsg, z16, this.f299008b, null)));
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                Continuation<com.tencent.mobileqq.troop.teamup.home.data.b> continuation2 = this.f299007a;
                ArrayList<TroopTeamUpData> arrayList = this.f299008b;
                QLog.e("TroopTeamUp::TeamUpRepository", 1, "cannot find qq runtime");
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.home.data.b(false, "\u83b7\u53d6\u8d26\u53f7\u670d\u52a1\u5f02\u5e38", false, arrayList, null)));
                return;
            }
            ArrayList<TeamUpTeamDetail> arrayList2 = getTeamUpListRsp.details;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.details");
            a aVar = this.f299009c;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (TeamUpTeamDetail it : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList3.add(aVar.f(it, str));
            }
            this.f299008b.addAll(arrayList3);
            Continuation<com.tencent.mobileqq.troop.teamup.home.data.b> continuation3 = this.f299007a;
            Result.Companion companion3 = Result.INSTANCE;
            continuation3.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.home.data.b(true, "", z16, this.f299008b, getTeamUpListRsp.cookie)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.troop.teamup.home.data.a a(TeamUpTeamDetail detail) {
        int collectionSizeOrDefault;
        ArrayList<TeamUpImage> arrayList = detail.images;
        Intrinsics.checkNotNullExpressionValue(arrayList, "detail.images");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (TeamUpImage teamUpImage : arrayList) {
            ImageItem imageItem = new ImageItem();
            imageItem.setWidth(teamUpImage.width);
            imageItem.setHeight(teamUpImage.height);
            imageItem.setHttpUrl(teamUpImage.picUrl);
            arrayList2.add(imageItem);
        }
        String str = detail.content;
        Intrinsics.checkNotNullExpressionValue(str, "detail.content");
        return new com.tencent.mobileqq.troop.teamup.home.data.a(str, arrayList2);
    }

    private final s b() {
        return ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupService();
    }

    private final TroopTeamUpData.TroopTeamUpState c(TeamUpTeamDetail detail, boolean isCreator) {
        int i3 = detail.status;
        int i16 = detail.joinType;
        boolean z16 = detail.isJoined;
        if (i3 == 2) {
            return TroopTeamUpData.TroopTeamUpState.CLOSED;
        }
        if (i3 == 1 && (z16 || isCreator)) {
            if (i16 == 2) {
                return TroopTeamUpData.TroopTeamUpState.ALREADY_UPLOAD;
            }
            return TroopTeamUpData.TroopTeamUpState.ALREADY_APPLIED;
        }
        if (i3 == 1 && i16 == 1) {
            return TroopTeamUpData.TroopTeamUpState.CAN_APPLY;
        }
        if (i3 == 1 && i16 == 2) {
            return TroopTeamUpData.TroopTeamUpState.CAN_APPLY_WITH_IMG;
        }
        return TroopTeamUpData.TroopTeamUpState.INVALID;
    }

    private final Object d(GetTeamUpListReq getTeamUpListReq, CoroutineScope coroutineScope, Continuation<? super com.tencent.mobileqq.troop.teamup.home.data.b> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ArrayList arrayList = new ArrayList();
        s b16 = b();
        if (b16 != null) {
            b16.getTeamUpList(getTeamUpListReq, new b(safeContinuation, arrayList, this));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("TroopTeamUp::TeamUpRepository", 1, "getGroupService() returns null, which is impossible");
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.home.data.b(false, "\u83b7\u53d6\u7ec4\u961f\u670d\u52a1\u5f02\u5e38", false, arrayList, null)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object e(@NotNull byte[] bArr, long j3, int i3, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super com.tencent.mobileqq.troop.teamup.home.data.b> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, bArr, Long.valueOf(j3), Integer.valueOf(i3), coroutineScope, continuation);
        }
        GetTeamUpListReq getTeamUpListReq = new GetTeamUpListReq();
        getTeamUpListReq.groupId = j3;
        getTeamUpListReq.type = i3;
        getTeamUpListReq.status = 0;
        getTeamUpListReq.cookies = bArr;
        return d(getTeamUpListReq, coroutineScope, continuation);
    }

    @NotNull
    public final TroopTeamUpData f(@NotNull TeamUpTeamDetail detail, @NotNull String currentUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopTeamUpData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) detail, (Object) currentUin);
        }
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(currentUin, "currentUin");
        com.tencent.mobileqq.troop.teamup.home.data.a a16 = a(detail);
        boolean areEqual = Intrinsics.areEqual(String.valueOf(detail.creator.uin), currentUin);
        TroopTeamUpData.TroopTeamUpState c16 = c(detail, areEqual);
        String str = detail.teamId;
        Intrinsics.checkNotNullExpressionValue(str, "detail.teamId");
        String str2 = detail.title;
        Intrinsics.checkNotNullExpressionValue(str2, "detail.title");
        return new TroopTeamUpData(str, c16, str2, a16, detail.joinedCnt, detail.joinLimit, areEqual, detail, false, 256, null);
    }
}

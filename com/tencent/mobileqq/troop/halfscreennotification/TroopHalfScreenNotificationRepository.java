package com.tencent.mobileqq.troop.halfscreennotification;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatus;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenButton;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenImage;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenNotice;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenPullNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenPullNoticeRsp;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenReportClickReq;
import com.tencent.qqnt.kernel.nativeinterface.IHalfScreenPullNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J5\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationRepository;", "", "", "troopUin", "", "b", "", tl.h.F, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "i", "f", "(J)Ljava/lang/Integer;", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenPullNoticeReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenNotice;", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenPullNoticeReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rsp", "Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenButton;", "src", "Lcom/tencent/mobileqq/troop/halfscreennotification/b;", "e", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appId", "c", "(JLjava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", UinConfigManager.KEY_ADS, "", "j", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopHalfScreenNotificationRepository f296194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenPullNoticeRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a implements IHalfScreenPullNoticeCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<HalfScreenNotice> f296195a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super HalfScreenNotice> continuation) {
            this.f296195a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IHalfScreenPullNoticeCallback
        public final void onResult(int i3, String str, HalfScreenPullNoticeRsp halfScreenPullNoticeRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, halfScreenPullNoticeRsp);
                return;
            }
            if (i3 == 10) {
                QLog.i("TroopHalfScreenNotificationRepository", 1, "cache hit");
                this.f296195a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            if (i3 != 0) {
                QLog.e("TroopHalfScreenNotificationRepository", 1, "fetch data error: " + i3 + ", " + str);
                this.f296195a.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            QLog.i("TroopHalfScreenNotificationRepository", 1, "fetched data: " + halfScreenPullNoticeRsp);
            Continuation<HalfScreenNotice> continuation = this.f296195a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(halfScreenPullNoticeRsp.halfScreenNotice));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f296194a = new TroopHalfScreenNotificationRepository();
        }
    }

    TroopHalfScreenNotificationRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(long troopUin) {
        GroupStatus groupStatus;
        TroopInfo i3 = i(troopUin);
        if (i3 == null || (groupStatus = i3.groupStatus) == null || groupStatus != GroupStatus.KENABLE || !i3.isMember()) {
            return false;
        }
        return true;
    }

    private final Object d(HalfScreenPullNoticeReq halfScreenPullNoticeReq, Continuation<? super HalfScreenNotice> continuation) {
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.halfScreenPullNotice(halfScreenPullNoticeReq, new a(safeContinuation));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("TroopHalfScreenNotificationRepository", 1, "get kernel service error");
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final b e(HalfScreenButton src) {
        boolean z16;
        String str = src.btnText;
        boolean z17 = true;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = null;
        if (z16) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(str, "src.btnText.ifEmpty { return null }");
        String str3 = src.btnUrl;
        if (str3.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            str2 = str3;
        }
        return new b(str, str2);
    }

    private final Integer f(long troopUin) {
        TroopInfo i3 = i(troopUin);
        if (i3 != null) {
            return Integer.valueOf((int) i3.dwGroupClassExt);
        }
        return null;
    }

    private final com.tencent.mobileqq.troop.halfscreennotification.a g(long troopUin, HalfScreenNotice rsp) {
        boolean z16;
        Object firstOrNull;
        if (rsp == null) {
            return null;
        }
        String str = rsp.noticeId;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.noticeId");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("TroopHalfScreenNotificationRepository", 1, "no notice");
            return null;
        }
        if (rsp.images.size() != 1) {
            QLog.e("TroopHalfScreenNotificationRepository", 1, "only support 1 image, found: " + rsp.images);
            return null;
        }
        ArrayList<HalfScreenImage> arrayList = rsp.images;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.images");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        HalfScreenImage halfScreenImage = (HalfScreenImage) firstOrNull;
        if (halfScreenImage == null) {
            return null;
        }
        if (halfScreenImage.height != halfScreenImage.width * 2) {
            QLog.e("TroopHalfScreenNotificationRepository", 1, "image size err");
        }
        String str2 = rsp.noticeId;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.noticeId");
        String str3 = rsp.title;
        Intrinsics.checkNotNullExpressionValue(str3, "rsp.title");
        String str4 = rsp.desc;
        Intrinsics.checkNotNullExpressionValue(str4, "rsp.desc");
        String str5 = halfScreenImage.picUrl;
        Intrinsics.checkNotNullExpressionValue(str5, "image.picUrl");
        int i3 = halfScreenImage.width;
        int i16 = halfScreenImage.height;
        HalfScreenButton halfScreenButton = rsp.confirmOp;
        Intrinsics.checkNotNullExpressionValue(halfScreenButton, "rsp.confirmOp");
        b e16 = e(halfScreenButton);
        if (e16 == null) {
            QLog.e("TroopHalfScreenNotificationRepository", 1, "no main button");
            return null;
        }
        HalfScreenButton halfScreenButton2 = rsp.otherOp;
        Intrinsics.checkNotNullExpressionValue(halfScreenButton2, "rsp.otherOp");
        return new com.tencent.mobileqq.troop.halfscreennotification.a(troopUin, str2, str3, str4, str5, i3, i16, e16, e(halfScreenButton2));
    }

    private final int h() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0;
    }

    private final TroopInfo i(long troopUin) {
        return ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(troopUin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        QLog.i("TroopHalfScreenNotificationRepository", 1, "[halfScreenReportClick] errCode: " + i3 + " errMsg: " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(long j3, @NotNull ArrayList<String> arrayList, @NotNull Continuation<? super com.tencent.mobileqq.troop.halfscreennotification.a> continuation) {
        TroopHalfScreenNotificationRepository$fetchData$1 troopHalfScreenNotificationRepository$fetchData$1;
        Object coroutine_suspended;
        int i3;
        TroopHalfScreenNotificationRepository troopHalfScreenNotificationRepository;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), arrayList, continuation);
        }
        if (continuation instanceof TroopHalfScreenNotificationRepository$fetchData$1) {
            troopHalfScreenNotificationRepository$fetchData$1 = (TroopHalfScreenNotificationRepository$fetchData$1) continuation;
            int i16 = troopHalfScreenNotificationRepository$fetchData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopHalfScreenNotificationRepository$fetchData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = troopHalfScreenNotificationRepository$fetchData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopHalfScreenNotificationRepository$fetchData$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = troopHalfScreenNotificationRepository$fetchData$1.J$0;
                        troopHalfScreenNotificationRepository = (TroopHalfScreenNotificationRepository) troopHalfScreenNotificationRepository$fetchData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!b(j3)) {
                        QLog.i("TroopHalfScreenNotificationRepository", 1, "no need to fetch");
                        return null;
                    }
                    HalfScreenPullNoticeReq halfScreenPullNoticeReq = new HalfScreenPullNoticeReq();
                    halfScreenPullNoticeReq.groupCode = j3;
                    halfScreenPullNoticeReq.appidList = arrayList;
                    Integer f16 = f296194a.f(j3);
                    if (f16 == null) {
                        return null;
                    }
                    halfScreenPullNoticeReq.groupClass = f16.intValue();
                    halfScreenPullNoticeReq.mode = h();
                    halfScreenPullNoticeReq.miniappProtect = 0;
                    troopHalfScreenNotificationRepository$fetchData$1.L$0 = this;
                    troopHalfScreenNotificationRepository$fetchData$1.J$0 = j3;
                    troopHalfScreenNotificationRepository$fetchData$1.label = 1;
                    obj = d(halfScreenPullNoticeReq, troopHalfScreenNotificationRepository$fetchData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopHalfScreenNotificationRepository = this;
                }
                return troopHalfScreenNotificationRepository.g(j3, (HalfScreenNotice) obj);
            }
        }
        troopHalfScreenNotificationRepository$fetchData$1 = new TroopHalfScreenNotificationRepository$fetchData$1(this, continuation);
        Object obj2 = troopHalfScreenNotificationRepository$fetchData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopHalfScreenNotificationRepository$fetchData$1.label;
        if (i3 == 0) {
        }
        return troopHalfScreenNotificationRepository.g(j3, (HalfScreenNotice) obj2);
    }

    public final void j(long troopUin, @NotNull String notice) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(troopUin), notice);
            return;
        }
        Intrinsics.checkNotNullParameter(notice, "notice");
        HalfScreenReportClickReq halfScreenReportClickReq = new HalfScreenReportClickReq();
        halfScreenReportClickReq.groupCode = troopUin;
        halfScreenReportClickReq.noticeId = notice;
        s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.halfScreenReportClick(halfScreenReportClickReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.halfscreennotification.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    TroopHalfScreenNotificationRepository.k(i3, str);
                }
            });
        }
    }
}

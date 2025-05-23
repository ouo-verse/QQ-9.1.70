package com.tencent.mobileqq.troop.teamup.detail.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITeamUpRequestToJoinCallback;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpRequestToJoinReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpRequestToJoinRsp;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J;\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/repo/c;", "", "", "troopUin", "teamId", "Lcom/tencent/mobileqq/troop/teamup/detail/repo/a;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpImage;", "Lkotlin/collections/ArrayList;", "pictures", "Lcom/tencent/mobileqq/troop/teamup/detail/repo/c$a;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/teamup/detail/repo/b;", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/repo/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "success", "I", "()I", "errCode", "<init>", "(ZI)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean success;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int errCode;

        public a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else {
                this.success = z16;
                this.errCode = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.errCode;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.success;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.success == aVar.success && this.errCode == aVar.errCode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.success;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.errCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "ApplyResult(success=" + this.success + ", errCode=" + this.errCode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/repo/c$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.repo.c$b, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.repo.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    static final class C8779c implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f298932a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f298933b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<a> f298934c;

        /* JADX WARN: Multi-variable type inference failed */
        C8779c(String str, String str2, Continuation<? super a> continuation) {
            this.f298932a = str;
            this.f298933b = str2;
            this.f298934c = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopTeamUpDetailRepo", 2, "applyTeamUp: troopUin=" + this.f298932a + ", teamId=" + this.f298933b + ", errMsg=" + str);
            }
            if (i3 == 0) {
                Continuation<a> continuation = this.f298934c;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new a(true, i3)));
            } else {
                Continuation<a> continuation2 = this.f298934c;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(new a(false, i3)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpDetailRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    static final class d implements IGetTeamUpDetailCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f298935a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f298936b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.mobileqq.troop.teamup.detail.repo.a> f298937c;

        /* JADX WARN: Multi-variable type inference failed */
        d(String str, String str2, Continuation<? super com.tencent.mobileqq.troop.teamup.detail.repo.a> continuation) {
            this.f298935a = str;
            this.f298936b = str2;
            this.f298937c = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpDetailCallback
        public final void onResult(int i3, String errMsg, GetTeamUpDetailRsp getTeamUpDetailRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, getTeamUpDetailRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopTeamUpDetailRepo", 2, "fetchTeamUpDetail: troopUin=" + this.f298935a + ", teamId=" + this.f298936b + ", errCode=" + i3 + ", errMsg=" + errMsg + ", rsp=" + getTeamUpDetailRsp);
            }
            if (i3 == 0) {
                Continuation<com.tencent.mobileqq.troop.teamup.detail.repo.a> continuation = this.f298937c;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                TeamUpTeamDetail teamUpTeamDetail = getTeamUpDetailRsp.detail;
                Intrinsics.checkNotNullExpressionValue(teamUpTeamDetail, "rsp.detail");
                continuation.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.detail.repo.a(true, i3, errMsg, teamUpTeamDetail)));
                return;
            }
            Continuation<com.tencent.mobileqq.troop.teamup.detail.repo.a> continuation2 = this.f298937c;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            TeamUpTeamDetail teamUpTeamDetail2 = getTeamUpDetailRsp.detail;
            Intrinsics.checkNotNullExpressionValue(teamUpTeamDetail2, "rsp.detail");
            continuation2.resumeWith(Result.m476constructorimpl(new com.tencent.mobileqq.troop.teamup.detail.repo.a(false, i3, errMsg, teamUpTeamDetail2)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpRequestToJoinRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    static final class e implements ITeamUpRequestToJoinCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f298938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f298939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<b> f298940c;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, String str2, Continuation<? super b> continuation) {
            this.f298938a = str;
            this.f298939b = str2;
            this.f298940c = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ITeamUpRequestToJoinCallback
        public final void onResult(int i3, String errMsg, TeamUpRequestToJoinRsp teamUpRequestToJoinRsp) {
            String str;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, teamUpRequestToJoinRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopTeamUpDetailRepo", 2, "requestJoinTroop: troopUin=" + this.f298938a + ", teamId=" + this.f298939b + ", errCode=" + i3 + ", errMsg=" + errMsg);
            }
            if (i3 == 0) {
                byte[] bArr = teamUpRequestToJoinRsp.joinGroupAuth;
                if (bArr != null) {
                    str = StringsKt__StringsJVMKt.decodeToString(bArr);
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    QLog.e("TroopTeamUpDetailRepo", 1, "requestJoinTroop: get auth failed, errCode=" + i3 + ", errMsg=" + errMsg + ", auth null");
                    Continuation<b> continuation = this.f298940c;
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    continuation.resumeWith(Result.m476constructorimpl(new b(false, errMsg, "")));
                    return;
                }
                Continuation<b> continuation2 = this.f298940c;
                Result.Companion companion2 = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                continuation2.resumeWith(Result.m476constructorimpl(new b(true, errMsg, str)));
                return;
            }
            QLog.e("TroopTeamUpDetailRepo", 1, "requestJoinTroop: get auth failed, errCode=" + i3 + ", errMsg=" + errMsg);
            Continuation<b> continuation3 = this.f298940c;
            Result.Companion companion3 = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            continuation3.resumeWith(Result.m476constructorimpl(new b(false, errMsg, "")));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55546);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull String str2, @NotNull ArrayList<TeamUpImage> arrayList, @NotNull Continuation<? super a> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            TeamUpApplyReq teamUpApplyReq = new TeamUpApplyReq();
            teamUpApplyReq.teamId = str2;
            teamUpApplyReq.pictures = arrayList;
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.applyTeamUp(teamUpApplyReq, new C8779c(str, str2, safeContinuation));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 3, this, str, str2, arrayList, continuation);
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super com.tencent.mobileqq.troop.teamup.detail.repo.a> continuation) {
        Continuation intercepted;
        Long longOrNull;
        long j3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            GetTeamUpDetailReq getTeamUpDetailReq = new GetTeamUpDetailReq();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            getTeamUpDetailReq.groupId = j3;
            getTeamUpDetailReq.teamId = str2;
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.getTeamUpDetail(getTeamUpDetailReq, new d(str, str2, safeContinuation));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 2, this, str, str2, continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            TeamUpRequestToJoinReq teamUpRequestToJoinReq = new TeamUpRequestToJoinReq();
            teamUpRequestToJoinReq.teamId = str2;
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.teamUpRequestToJoin(teamUpRequestToJoinReq, new e(str, str2, safeContinuation));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return iPatchRedirector.redirect((short) 4, this, str, str2, continuation);
    }
}

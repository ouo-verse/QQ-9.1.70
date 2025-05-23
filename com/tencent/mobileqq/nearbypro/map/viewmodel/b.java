package com.tencent.mobileqq.nearbypro.map.viewmodel;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils;
import com.tencent.mobileqq.nearbypro.map.request.LoginRequest;
import com.tencent.mobileqq.nearbypro.request.CommonExtSig;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import hq4.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mp4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/viewmodel/b;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/tencent/mobileqq/nearbypro/map/viewmodel/b$a;", "coroutine", "", "P1", "Lhq4/h;", "rsp", "O1", "", "from", "Lcom/tencent/mobileqq/soso/location/data/SosoLocation;", "R1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N1", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "i", "a", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends ViewModel {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/viewmodel/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "getNeedGet", "()Z", "needGet", "b", "getSig", "Lcom/tencent/mobileqq/nearbypro/request/d;", "c", "Lcom/tencent/mobileqq/nearbypro/request/d;", "()Lcom/tencent/mobileqq/nearbypro/request/d;", "rspStatus", "<init>", "(ZZLcom/tencent/mobileqq/nearbypro/request/d;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.viewmodel.b$a, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class CheckTinyIdAndSigResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needGet;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean getSig;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RspStatus rspStatus;

        public CheckTinyIdAndSigResult(boolean z16, boolean z17, @NotNull RspStatus rspStatus) {
            Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
            this.needGet = z16;
            this.getSig = z17;
            this.rspStatus = rspStatus;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getGetSig() {
            return this.getSig;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RspStatus getRspStatus() {
            return this.rspStatus;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckTinyIdAndSigResult)) {
                return false;
            }
            CheckTinyIdAndSigResult checkTinyIdAndSigResult = (CheckTinyIdAndSigResult) other;
            if (this.needGet == checkTinyIdAndSigResult.needGet && this.getSig == checkTinyIdAndSigResult.getSig && Intrinsics.areEqual(this.rspStatus, checkTinyIdAndSigResult.rspStatus)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.needGet;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.getSig;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.rspStatus.hashCode();
        }

        @NotNull
        public String toString() {
            return "CheckTinyIdAndSigResult(needGet=" + this.needGet + ", getSig=" + this.getSig + ", rspStatus=" + this.rspStatus + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/map/viewmodel/b$c", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<SosoLocation> f253599a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super SosoLocation> cancellableContinuation) {
            super("NearByPro", true);
            this.f253599a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            String str;
            SosoLocation sosoLocation;
            ga2.a c16 = j.c();
            if (info != null) {
                str = ab2.a.f25767a.e(info);
            } else {
                str = null;
            }
            c16.e("NBP.LocationPart", "onLocationFinish errCode:" + errCode + " info:" + str);
            if (errCode == 0 && info != null && (sosoLocation = info.mLocation) != null) {
                this.f253599a.resumeWith(Result.m476constructorimpl(sosoLocation));
            } else {
                this.f253599a.resumeWith(Result.m476constructorimpl(null));
            }
        }
    }

    private final void O1(h rsp) {
        boolean z16;
        boolean z17;
        if (rsp.f405975c) {
            if (((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase()) {
                j.c().e("NBP.LocationPart", "needUpdateAvatarHead");
                f[] fVarArr = rsp.f405976d.f417147c;
                Intrinsics.checkNotNullExpressionValue(fVarArr, "rsp.avatarConfig.headConfigs");
                if (fVarArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    mp4.a[] aVarArr = rsp.f405976d.f417148d;
                    Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.avatarConfig.backgroundConfigs");
                    if (aVarArr.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        mp4.d dVar = rsp.f405976d;
                        f headConfig = dVar.f417147c[0];
                        mp4.a backgroundConfig = dVar.f417148d[0];
                        MapAvatarUtils mapAvatarUtils = MapAvatarUtils.f253394a;
                        Intrinsics.checkNotNullExpressionValue(headConfig, "headConfig");
                        Intrinsics.checkNotNullExpressionValue(backgroundConfig, "backgroundConfig");
                        mapAvatarUtils.l(headConfig, backgroundConfig);
                        return;
                    }
                }
                ga2.a c16 = j.c();
                mp4.d dVar2 = rsp.f405976d;
                c16.d("NBP.LocationPart", "avatarConfig is not valid, headConfigs.size: " + dVar2.f417147c.length + ", backgroundConfigs.size: " + dVar2.f417148d.length);
                return;
            }
            j.c().e("NBP.LocationPart", "enableZPlanFilamentBase false, do not update avatar head");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(Context context, final CancellableContinuation<? super CheckTinyIdAndSigResult> coroutine) {
        j.e().c(context, new LoginRequest(), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.map.viewmodel.a
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                b.Q1(b.this, coroutine, (NearbyProBaseRequest) obj, rspStatus, (h) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(b this$0, CancellableContinuation coroutine, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, h hVar) {
        boolean z16;
        boolean z17;
        IMapNearbyDataService f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coroutine, "$coroutine");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (rspStatus.c() && hVar != null) {
            sp4.c cVar = hVar.f405974b;
            if (cVar != null && (f16 = ab2.a.f25767a.f()) != null) {
                ab2.c.f25771a.e(f16.getSelfUserInfo(), cVar);
                j.c().e("NBP.LocationPart", "checkTinyIdAndSig updateSelf: " + f16.getSelfUserInfo());
            }
            np4.c cVar2 = hVar.f405973a;
            if (cVar2 != null) {
                byte[] bArr = cVar2.f420674b;
                Intrinsics.checkNotNullExpressionValue(bArr, "this.sig");
                if (bArr.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    byte[] bArr2 = cVar2.f420674b;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "this.sig");
                    com.tencent.mobileqq.nearbypro.request.a.d(bArr2);
                    ab2.a.f25767a.A();
                    z16 = true;
                    this$0.O1(hVar);
                }
            }
            z16 = false;
            this$0.O1(hVar);
        } else {
            z16 = false;
        }
        if (!z16) {
            j.c().d("NBP.LocationPart", rspStatus + " getSig empty");
            Result.Companion companion = Result.INSTANCE;
            coroutine.resumeWith(Result.m476constructorimpl(new CheckTinyIdAndSigResult(true, false, rspStatus)));
            return;
        }
        Result.Companion companion2 = Result.INSTANCE;
        coroutine.resumeWith(Result.m476constructorimpl(new CheckTinyIdAndSigResult(true, true, rspStatus)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    @MainThread
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object N1(@Nullable Context context, @NotNull Continuation<? super CheckTinyIdAndSigResult> continuation) {
        Continuation intercepted;
        boolean z16;
        Object result;
        Object coroutine_suspended;
        boolean z17;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        CommonExtSig b16 = com.tencent.mobileqq.nearbypro.request.a.b();
        long m3 = ab2.a.f25767a.m();
        ga2.a c16 = j.c();
        boolean b17 = b16.b();
        if (b16.getSig().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        c16.e("NBP.LocationPart", "checkTinyIdAndSig isSigExpiry:" + b17 + " isEmptySig:" + z16 + " selfTinyId:" + m3);
        if (!b16.b()) {
            if (b16.getSig().length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && m3 != 0) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(new CheckTinyIdAndSigResult(false, true, new RspStatus(null, 0L, null, 7, null))));
                result = cancellableContinuationImpl.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return result;
            }
        }
        P1(context, cancellableContinuationImpl);
        result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
        }
        return result;
    }

    @MainThread
    @Nullable
    public final Object R1(@NotNull String str, @NotNull Continuation<? super SosoLocation> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        j.c().e("NBP.LocationPart", "startLocation from:" + str + "}");
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

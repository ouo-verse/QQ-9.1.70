package cooperation.vip.ad;

import android.app.Activity;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "cooperation.vip.ad.GrowHalfLayerHelper$startGrowHalfLayer$1", f = "GrowHalfLayerHelper.kt", i = {0, 1}, l = {148, 149, 196}, m = "invokeSuspend", n = {"loadSoDeferred", "loadJsBundleResultCode"}, s = {"L$0", "I$0"})
/* loaded from: classes28.dex */
public final class GrowHalfLayerHelper$startGrowHalfLayer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ long $durationFromLastTryShow;
    final /* synthetic */ GrowHalfLayerInfo $growHalfLayerInfo;
    final /* synthetic */ boolean $ignoreSplashAndConversion;
    final /* synthetic */ long $preStartTime;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "cooperation.vip.ad.GrowHalfLayerHelper$startGrowHalfLayer$1$1", f = "GrowHalfLayerHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: cooperation.vip.ad.GrowHalfLayerHelper$startGrowHalfLayer$1$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ GrowHalfLayerInfo $growHalfLayerInfo;
        final /* synthetic */ GrowHalfLayerTechInfo $techInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, GrowHalfLayerInfo growHalfLayerInfo, GrowHalfLayerTechInfo growHalfLayerTechInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$growHalfLayerInfo = growHalfLayerInfo;
            this.$techInfo = growHalfLayerTechInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.$growHalfLayerInfo, this.$techInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GrowHalfLayerHelper.f391021a.n(this.$activity, this.$growHalfLayerInfo, this.$techInfo);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrowHalfLayerHelper$startGrowHalfLayer$1(GrowHalfLayerInfo growHalfLayerInfo, boolean z16, long j3, long j16, Activity activity, Continuation<? super GrowHalfLayerHelper$startGrowHalfLayer$1> continuation) {
        super(2, continuation);
        this.$growHalfLayerInfo = growHalfLayerInfo;
        this.$ignoreSplashAndConversion = z16;
        this.$durationFromLastTryShow = j3;
        this.$preStartTime = j16;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GrowHalfLayerHelper$startGrowHalfLayer$1 growHalfLayerHelper$startGrowHalfLayer$1 = new GrowHalfLayerHelper$startGrowHalfLayer$1(this.$growHalfLayerInfo, this.$ignoreSplashAndConversion, this.$durationFromLastTryShow, this.$preStartTime, this.$activity, continuation);
        growHalfLayerHelper$startGrowHalfLayer$1.L$0 = obj;
        return growHalfLayerHelper$startGrowHalfLayer$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        Object await2;
        int i3;
        boolean z16;
        int moduleVersion;
        boolean z17;
        boolean z18;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 2;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i18 = this.I$0;
                ResultKt.throwOnFailure(obj);
                i3 = i18;
                await2 = obj;
                int intValue = ((Number) await2).intValue();
                if (i3 != 0 && intValue == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.$growHalfLayerInfo.getHippyJsBundleName());
                if (this.$ignoreSplashAndConversion && !GrowHalfLayerHelper.h()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z16 && moduleVersion >= 0 && z17 && !GrowHalfLayerHelper.f391021a.i()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                GrowHalfLayerHelper growHalfLayerHelper = GrowHalfLayerHelper.f391021a;
                QLog.i("GrowHalfLayerUtils", 1, "startGrowHalfLayer, loadJsBundleResultCode=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + moduleVersion + ", loadSoResultCode=" + intValue + ",isConversationVisible=" + z17 + ",isShowingGrowHalfLayer=" + growHalfLayerHelper.i());
                if (moduleVersion >= 0) {
                    i17 = 3;
                } else if (!z17) {
                    i17 = 1;
                } else if (!growHalfLayerHelper.i()) {
                    i17 = 0;
                }
                GrowHalfLayerTechReporter growHalfLayerTechReporter = GrowHalfLayerTechReporter.f391039a;
                growHalfLayerTechReporter.c(String.valueOf(this.$growHalfLayerInfo.getAdId()), i3, intValue, i17, z18, System.currentTimeMillis());
                growHalfLayerTechReporter.j(this.$growHalfLayerInfo.getTraceId(), this.$growHalfLayerInfo.getAdId(), i17);
                if (z18) {
                    growHalfLayerHelper.p(this.$growHalfLayerInfo);
                    return Unit.INSTANCE;
                }
                GrowHalfLayerTechInfo growHalfLayerTechInfo = new GrowHalfLayerTechInfo(this.$growHalfLayerInfo.getAdId(), this.$durationFromLastTryShow, o.g(this.$growHalfLayerInfo.getAdId()), this.$preStartTime, NetConnInfoCenter.getServerTimeMillis());
                growHalfLayerHelper.q(true);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$activity, this.$growHalfLayerInfo, growHalfLayerTechInfo, null);
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1(this.$growHalfLayerInfo, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GrowHalfLayerHelper$startGrowHalfLayer$1$loadSoDeferred$1(this.$growHalfLayerInfo, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        int intValue2 = ((Number) await).intValue();
        this.L$0 = null;
        this.I$0 = intValue2;
        this.label = 2;
        await2 = async$default2.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        i3 = intValue2;
        int intValue3 = ((Number) await2).intValue();
        if (i3 != 0) {
        }
        z16 = false;
        moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(this.$growHalfLayerInfo.getHippyJsBundleName());
        if (this.$ignoreSplashAndConversion) {
        }
        z17 = true;
        if (!z16) {
        }
        z18 = false;
        GrowHalfLayerHelper growHalfLayerHelper2 = GrowHalfLayerHelper.f391021a;
        QLog.i("GrowHalfLayerUtils", 1, "startGrowHalfLayer, loadJsBundleResultCode=" + i3 + MttLoader.QQBROWSER_PARAMS_VERSION + moduleVersion + ", loadSoResultCode=" + intValue3 + ",isConversationVisible=" + z17 + ",isShowingGrowHalfLayer=" + growHalfLayerHelper2.i());
        if (moduleVersion >= 0) {
        }
        GrowHalfLayerTechReporter growHalfLayerTechReporter2 = GrowHalfLayerTechReporter.f391039a;
        growHalfLayerTechReporter2.c(String.valueOf(this.$growHalfLayerInfo.getAdId()), i3, intValue3, i17, z18, System.currentTimeMillis());
        growHalfLayerTechReporter2.j(this.$growHalfLayerInfo.getTraceId(), this.$growHalfLayerInfo.getAdId(), i17);
        if (z18) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GrowHalfLayerHelper$startGrowHalfLayer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.nearbypro.map.part;

import android.content.Context;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.map.viewmodel.b;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.part.LocationPart$onHasPermission$1", f = "LocationPart.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class LocationPart$onHasPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.part.LocationPart$onHasPermission$1$1", f = "LocationPart.kt", i = {1}, l = {154, 157}, m = "invokeSuspend", n = {"sosoLocation"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.part.LocationPart$onHasPermission$1$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ LocationPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocationPart locationPart, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = locationPart;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            com.tencent.mobileqq.nearbypro.map.viewmodel.b bVar;
            com.tencent.mobileqq.nearbypro.map.viewmodel.b bVar2;
            SosoLocation sosoLocation;
            b.CheckTinyIdAndSigResult checkTinyIdAndSigResult;
            boolean z16;
            SelfUserInfo selfUserInfo;
            LatLng a16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        sosoLocation = (SosoLocation) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        checkTinyIdAndSigResult = (b.CheckTinyIdAndSigResult) obj;
                        this.this$0.broadcastMessage("MSG_ON_LOCATION_RESULT_AND_SIG_CHECK", sosoLocation);
                        if (!checkTinyIdAndSigResult.getRspStatus().c() && checkTinyIdAndSigResult.getGetSig()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            this.this$0.S9(checkTinyIdAndSigResult.getRspStatus());
                            return Unit.INSTANCE;
                        }
                        this.this$0.com.tencent.xweb.internal.ConstValue.EXTEND_CONFIG_KEY_HAS_LOGIN java.lang.String = true;
                        IMapNearbyDataService f16 = ab2.a.f25767a.f();
                        if (f16 == null || (selfUserInfo = f16.getSelfUserInfo()) == null || (a16 = ab2.c.f25771a.a(selfUserInfo)) == null) {
                            return null;
                        }
                        final LocationPart locationPart = this.this$0;
                        locationPart.broadcastMessage("MSG_ENTER_MAP_BEGIN", Boxing.boxBoolean(true));
                        locationPart.Q9(a16, new Function2<Boolean, CameraUpdate, Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.part.LocationPart$onHasPermission$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, CameraUpdate cameraUpdate) {
                                invoke(bool.booleanValue(), cameraUpdate);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17, @NotNull CameraUpdate pos) {
                                Intrinsics.checkNotNullParameter(pos, "pos");
                                if (z17) {
                                    LocationPart.this.broadcastMessage("MSG_ENTER_MAP_END", null);
                                    return;
                                }
                                TencentMap a17 = i.INSTANCE.a(LocationPart.this);
                                if (a17 != null) {
                                    a17.moveCamera(pos);
                                }
                                LocationPart.this.broadcastMessage("MSG_ENTER_MAP_END", null);
                            }
                        });
                        locationPart.broadcastMessage("MSG_START_HEART_BEAT", null);
                        return a16;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                bVar = this.this$0.locationVM;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationVM");
                    bVar = null;
                }
                this.label = 1;
                obj = bVar.R1("has_permission", this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SosoLocation sosoLocation2 = (SosoLocation) obj;
            this.this$0.Y9();
            this.this$0.W9(sosoLocation2);
            bVar2 = this.this$0.locationVM;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationVM");
                bVar2 = null;
            }
            Context context = this.this$0.getContext();
            this.L$0 = sosoLocation2;
            this.label = 2;
            Object N1 = bVar2.N1(context, this);
            if (N1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            sosoLocation = sosoLocation2;
            obj = N1;
            checkTinyIdAndSigResult = (b.CheckTinyIdAndSigResult) obj;
            this.this$0.broadcastMessage("MSG_ON_LOCATION_RESULT_AND_SIG_CHECK", sosoLocation);
            if (!checkTinyIdAndSigResult.getRspStatus().c()) {
            }
            z16 = true;
            if (!z16) {
            }
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPart$onHasPermission$1(LocationPart locationPart, Continuation<? super LocationPart$onHasPermission$1> continuation) {
        super(2, continuation);
        this.this$0 = locationPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocationPart$onHasPermission$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (CorountineFunKt.i(eVar, null, null, anonymousClass1, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LocationPart$onHasPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

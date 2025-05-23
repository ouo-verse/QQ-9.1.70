package com.tencent.mobileqq.nearbypro.part.guide;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.part.guide.NearbyProGuideDialog$showDialog$1", f = "NearbyProGuideDialog.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class NearbyProGuideDialog$showDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NearbyProGuideDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.nearbypro.part.guide.NearbyProGuideDialog$showDialog$1$1", f = "NearbyProGuideDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.nearbypro.part.guide.NearbyProGuideDialog$showDialog$1$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $config;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NearbyProGuideDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NearbyProGuideDialog nearbyProGuideDialog, e eVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = nearbyProGuideDialog;
            this.$config = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$config, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AtomicBoolean atomicBoolean;
            Object firstOrNull;
            String str;
            Object firstOrNull2;
            View view;
            View view2;
            String mGuideDesc;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0)) {
                    atomicBoolean = this.this$0.mIsAsyncLoadingConfig;
                    atomicBoolean.set(false);
                    this.this$0.mGuideConfigItemSize = this.$config.a().size();
                    NearbyProGuideDialog nearbyProGuideDialog = this.this$0;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.$config.a());
                    GuideConfigItem guideConfigItem = (GuideConfigItem) firstOrNull;
                    String str2 = "";
                    if (guideConfigItem == null || (str = guideConfigItem.getMGuideTitle()) == null) {
                        str = "";
                    }
                    nearbyProGuideDialog.r0(str);
                    NearbyProGuideDialog nearbyProGuideDialog2 = this.this$0;
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.$config.a());
                    GuideConfigItem guideConfigItem2 = (GuideConfigItem) firstOrNull2;
                    if (guideConfigItem2 != null && (mGuideDesc = guideConfigItem2.getMGuideDesc()) != null) {
                        str2 = mGuideDesc;
                    }
                    nearbyProGuideDialog2.q0(str2);
                    this.this$0.p0(0);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.$config.a());
                    int screenWidth = (ViewUtils.getScreenWidth() - ViewUtils.dpToPx(22.0f)) - ViewUtils.dpToPx(22.0f);
                    this.this$0.o0(screenWidth, (int) ((this.$config.getMGuideImageHeightDP() / this.$config.getMGuideImageWidthPD()) * screenWidth), arrayList);
                    this.this$0.n0();
                    view = this.this$0.mRootView;
                    View view3 = null;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                        view = null;
                    }
                    view2 = this.this$0.mRootView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    } else {
                        view3 = view2;
                    }
                    view.setTranslationY(view3.getMeasuredHeight());
                    this.this$0.show();
                    return Unit.INSTANCE;
                }
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
    public NearbyProGuideDialog$showDialog$1(NearbyProGuideDialog nearbyProGuideDialog, Continuation<? super NearbyProGuideDialog$showDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = nearbyProGuideDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NearbyProGuideDialog$showDialog$1(this.this$0, continuation);
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
            e eVar = (e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101141");
            if (eVar == null) {
                eVar = new e();
                eVar.d();
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, eVar, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NearbyProGuideDialog$showDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

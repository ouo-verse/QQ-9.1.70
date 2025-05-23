package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository;
import com.tencent.videocut.model.MediaClip;
import java.io.File;
import java.util.List;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$handleNextStep$1", f = "WinkEditorOpeningEndingViewModel.kt", i = {}, l = {292, 305, 309}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$handleNextStep$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $finishedCallback;
    final /* synthetic */ boolean $isFromClipping;
    final /* synthetic */ MetaMaterial $material;
    final /* synthetic */ List<MediaClip> $mediaClips;
    int label;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321347a;

        static {
            int[] iArr = new int[MaterialType.values().length];
            try {
                iArr[MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaterialType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaterialType.TEMPLATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaterialType.ONLINE_VIDEO_LIGHTSDK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f321347a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkEditorOpeningEndingViewModel$handleNextStep$1(MetaMaterial metaMaterial, Function2<? super Boolean, ? super Boolean, Unit> function2, WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, Activity activity, List<? extends MediaClip> list, boolean z16, Continuation<? super WinkEditorOpeningEndingViewModel$handleNextStep$1> continuation) {
        super(2, continuation);
        this.$material = metaMaterial;
        this.$finishedCallback = function2;
        this.this$0 = winkEditorOpeningEndingViewModel;
        this.$activity = activity;
        this.$mediaClips = list;
        this.$isFromClipping = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorOpeningEndingViewModel$handleNextStep$1(this.$material, this.$finishedCallback, this.this$0, this.$activity, this.$mediaClips, this.$isFromClipping, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x014b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object b16;
        String str;
        Object B2;
        Object g16;
        String str2;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        g16 = obj;
                        str = (String) g16;
                        str2 = str;
                        w53.b.f("WinkEditorOpeningEndingViewModel", "handleNextStep filepath: " + str2);
                        if (str2 == null && str2.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            MetaMaterial metaMaterial = this.$material;
                            w53.b.c("WinkEditorOpeningEndingViewModel", "handleNextStep failed: filepath is null: " + metaMaterial.f30533id + ", " + com.tencent.mobileqq.wink.editor.c.T(metaMaterial));
                            this.$finishedCallback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false));
                            return Unit.INSTANCE;
                        }
                        this.$finishedCallback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(WinkEditorOpeningEndingViewModel.O2(this.this$0, str2, Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(this.$material), "opening"), this.$isFromClipping, this.$material.f30533id, null, null, 48, null)));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            b16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
            Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
            MetaMaterial metaMaterial2 = this.$material;
            this.label = 1;
            b16 = com.tencent.mobileqq.wink.edit.manager.ak.b(a16, metaMaterial2, null, this, 2, null);
            if (b16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!((Boolean) b16).booleanValue()) {
            w53.b.c("WinkEditorOpeningEndingViewModel", "download material failed, id: " + this.$material.f30533id);
            this.$finishedCallback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
        WinkEditorResourceManager.a1().i0(this.$material);
        int i16 = a.f321347a[com.tencent.mobileqq.wink.editor.c.T(this.$material).ordinal()];
        if (i16 != 1 && i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    str = null;
                } else {
                    WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository = WinkOnlineAssetMediaRepository.f324625a;
                    MetaMaterial metaMaterial3 = this.$material;
                    this.label = 3;
                    g16 = winkOnlineAssetMediaRepository.g(metaMaterial3, this);
                    if (g16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = (String) g16;
                }
            } else {
                WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel = this.this$0;
                Activity activity = this.$activity;
                MetaMaterial metaMaterial4 = this.$material;
                List<MediaClip> list = this.$mediaClips;
                boolean z17 = this.$isFromClipping;
                Function2<Boolean, Boolean, Unit> function2 = this.$finishedCallback;
                this.label = 2;
                B2 = winkEditorOpeningEndingViewModel.B2(activity, metaMaterial4, list, z17, function2, this);
                if (B2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else {
            str = WinkEditorResourceManager.a1().m(this.$material) + File.separator + com.tencent.mobileqq.wink.editor.c.k0(this.$material);
        }
        str2 = str;
        w53.b.f("WinkEditorOpeningEndingViewModel", "handleNextStep filepath: " + str2);
        if (str2 == null) {
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorOpeningEndingViewModel$handleNextStep$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

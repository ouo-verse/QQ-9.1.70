package com.tencent.mobileqq.nearbypro.media.gallery;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryPreview$enterToGallery$1", f = "NBGalleryPreview.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class NBGalleryPreview$enterToGallery$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $path;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryPreview$enterToGallery$1$1", f = "NBGalleryPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.nearbypro.media.gallery.NBGalleryPreview$enterToGallery$1$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bundle;
        final /* synthetic */ Context $context;
        final /* synthetic */ NBGalleryImageData $data;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NBGalleryImageData nBGalleryImageData, Context context, Bundle bundle, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = nBGalleryImageData;
            this.$context = context;
            this.$bundle = bundle;
            this.$path = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$data, this.$context, this.$bundle, this.$path, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<NBGalleryImageData> listOf;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NBGalleryImageData nBGalleryImageData = this.$data;
                if (nBGalleryImageData != null) {
                    Context context = this.$context;
                    Bundle bundle = this.$bundle;
                    NBGalleryPreview nBGalleryPreview = NBGalleryPreview.f253611a;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(nBGalleryImageData);
                    nBGalleryPreview.b(listOf, null, context, bundle);
                    Unit unit = Unit.INSTANCE;
                    String str = this.$path;
                    j.c().d("NBGalleryPreview", "enterToGallery fail, path: " + str);
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
    public NBGalleryPreview$enterToGallery$1(String str, Context context, Bundle bundle, Continuation<? super NBGalleryPreview$enterToGallery$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$context = context;
        this.$bundle = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NBGalleryPreview$enterToGallery$1(this.$path, this.$context, this.$bundle, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        NBGalleryImageData nBGalleryImageData;
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
            if (r.a(this.$path)) {
                String str = this.$path;
                nBGalleryImageData = new NBGalleryImageData(str, new NBGalleryImageInfo(str, 0, 0), new NBGalleryImageInfo(this.$path, 0, 0));
            } else {
                nBGalleryImageData = null;
            }
            NBGalleryImageData nBGalleryImageData2 = nBGalleryImageData;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(nBGalleryImageData2, this.$context, this.$bundle, this.$path, null);
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
        return ((NBGalleryPreview$enterToGallery$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.qqnt.avatar.meta;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import com.tencent.qqnt.avatar.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.MetaAvatarLoadTask$getSourceBitmapArr$2", f = "MetaAvatarLoadTask.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class MetaAvatarLoadTask$getSourceBitmapArr$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.avatar.meta.info.a[] $avatarInfoArr;
    final /* synthetic */ int $avatarSize;
    final /* synthetic */ Bitmap[] $bitmapArr;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<IndexedValue<com.tencent.qqnt.avatar.meta.info.a>> $downloadList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/collections/IndexedValue;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.avatar.meta.MetaAvatarLoadTask$getSourceBitmapArr$2$1", f = "MetaAvatarLoadTask.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.avatar.meta.MetaAvatarLoadTask$getSourceBitmapArr$2$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IndexedValue<? extends Bitmap>>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int $avatarSize;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $index;
        final /* synthetic */ com.tencent.qqnt.avatar.meta.info.a $info;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, com.tencent.qqnt.avatar.meta.info.a aVar, Context context, int i16, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$index = i3;
            this.$info = aVar;
            this.$context = context;
            this.$avatarSize = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), aVar, context, Integer.valueOf(i16), continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$index, this.$info, this.$context, this.$avatarSize, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super IndexedValue<? extends Bitmap>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super IndexedValue<Bitmap>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i16 = this.label;
                if (i16 != 0) {
                    if (i16 == 1) {
                        i3 = this.I$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    int i17 = this.$index;
                    AvatarResourceManager avatarResourceManager = AvatarResourceManager.f352954a;
                    com.tencent.qqnt.avatar.meta.info.a aVar = this.$info;
                    Context context = this.$context;
                    int i18 = this.$avatarSize;
                    this.I$0 = i17;
                    this.label = 1;
                    Object e16 = avatarResourceManager.e(aVar, context, i18, this);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i3 = i17;
                    obj = e16;
                }
                return new IndexedValue(i3, obj);
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super IndexedValue<Bitmap>> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaAvatarLoadTask$getSourceBitmapArr$2(List<IndexedValue<com.tencent.qqnt.avatar.meta.info.a>> list, com.tencent.qqnt.avatar.meta.info.a[] aVarArr, Bitmap[] bitmapArr, Context context, int i3, Continuation<? super MetaAvatarLoadTask$getSourceBitmapArr$2> continuation) {
        super(2, continuation);
        this.$downloadList = list;
        this.$avatarInfoArr = aVarArr;
        this.$bitmapArr = bitmapArr;
        this.$context = context;
        this.$avatarSize = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, aVarArr, bitmapArr, context, Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        MetaAvatarLoadTask$getSourceBitmapArr$2 metaAvatarLoadTask$getSourceBitmapArr$2 = new MetaAvatarLoadTask$getSourceBitmapArr$2(this.$downloadList, this.$avatarInfoArr, this.$bitmapArr, this.$context, this.$avatarSize, continuation);
        metaAvatarLoadTask$getSourceBitmapArr$2.L$0 = obj;
        return metaAvatarLoadTask$getSourceBitmapArr$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009a -> B:12:0x009f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Iterator it;
        MetaAvatarLoadTask$getSourceBitmapArr$2 metaAvatarLoadTask$getSourceBitmapArr$2;
        Deferred async$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                MetaAvatarLoadTask$getSourceBitmapArr$2 metaAvatarLoadTask$getSourceBitmapArr$22 = this;
                IndexedValue indexedValue = (IndexedValue) obj2;
                int index = indexedValue.getIndex();
                Bitmap bitmap = (Bitmap) indexedValue.getValue();
                if (bitmap != null) {
                    d.d(d.f352991a, "MetaAvatarLoadTask", "download fail " + metaAvatarLoadTask$getSourceBitmapArr$22.$avatarInfoArr[index], null, 4, null);
                    return Unit.INSTANCE;
                }
                metaAvatarLoadTask$getSourceBitmapArr$22.$bitmapArr[index] = bitmap;
                metaAvatarLoadTask$getSourceBitmapArr$2 = metaAvatarLoadTask$getSourceBitmapArr$22;
                if (!it.hasNext()) {
                    Deferred deferred = (Deferred) it.next();
                    metaAvatarLoadTask$getSourceBitmapArr$2.L$0 = it;
                    metaAvatarLoadTask$getSourceBitmapArr$2.label = 1;
                    Object await = deferred.await(metaAvatarLoadTask$getSourceBitmapArr$2);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    metaAvatarLoadTask$getSourceBitmapArr$22 = metaAvatarLoadTask$getSourceBitmapArr$2;
                    obj2 = await;
                    IndexedValue indexedValue2 = (IndexedValue) obj2;
                    int index2 = indexedValue2.getIndex();
                    Bitmap bitmap2 = (Bitmap) indexedValue2.getValue();
                    if (bitmap2 != null) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList(this.$downloadList.size());
            for (IndexedValue<com.tencent.qqnt.avatar.meta.info.a> indexedValue3 : this.$downloadList) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(indexedValue3.getIndex(), indexedValue3.component2(), this.$context, this.$avatarSize, null), 3, null);
                arrayList.add(async$default);
            }
            it = arrayList.iterator();
            metaAvatarLoadTask$getSourceBitmapArr$2 = this;
            if (!it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MetaAvatarLoadTask$getSourceBitmapArr$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

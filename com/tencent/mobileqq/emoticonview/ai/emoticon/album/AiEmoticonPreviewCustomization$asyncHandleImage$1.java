package com.tencent.mobileqq.emoticonview.ai.emoticon.album;

import com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper;
import com.tencent.mobileqq.emoticonview.ai.emoticon.PicModel;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.util.file.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.ai.emoticon.album.AiEmoticonPreviewCustomization$asyncHandleImage$1", f = "AiEmoticonPreviewCustomization.kt", i = {0}, l = {95, 96}, m = "invokeSuspend", n = {"picModelList"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class AiEmoticonPreviewCustomization$asyncHandleImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    final /* synthetic */ AiEmoticonPreviewCustomization this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.emoticonview.ai.emoticon.album.AiEmoticonPreviewCustomization$asyncHandleImage$1$1", f = "AiEmoticonPreviewCustomization.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.emoticonview.ai.emoticon.album.AiEmoticonPreviewCustomization$asyncHandleImage$1$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CheckImageResult $checkResult;
        final /* synthetic */ List<PicModel> $picModelList;
        int label;
        final /* synthetic */ AiEmoticonPreviewCustomization this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AiEmoticonPreviewCustomization aiEmoticonPreviewCustomization, CheckImageResult checkImageResult, List<PicModel> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aiEmoticonPreviewCustomization;
            this.$checkResult = checkImageResult;
            this.$picModelList = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aiEmoticonPreviewCustomization, checkImageResult, list, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$checkResult, this.$picModelList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.handleUploadResult(this.$checkResult, this.$picModelList);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonPreviewCustomization$asyncHandleImage$1(AiEmoticonPreviewCustomization aiEmoticonPreviewCustomization, Continuation<? super AiEmoticonPreviewCustomization$asyncHandleImage$1> continuation) {
        super(2, continuation);
        this.this$0 = aiEmoticonPreviewCustomization;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aiEmoticonPreviewCustomization, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AiEmoticonPreviewCustomization$asyncHandleImage$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        List<PicModel> list;
        List<PicModel> list2;
        Pair pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                List<LocalMediaInfo> h16 = this.this$0.getPhotoCommonData().h();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = h16.iterator();
                while (it.hasNext()) {
                    String path = ((LocalMediaInfo) it.next()).getPath();
                    if (path != null) {
                        String picThumbPath = AiEmoticonUploadHelper.INSTANCE.getPicThumbPath(path);
                        pair = new Pair(picThumbPath, b.f362981a.b(picThumbPath));
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(new PicModel((String) ((Pair) it5.next()).getFirst(), null, 2, null));
                }
                list = CollectionsKt___CollectionsKt.toList(arrayList2);
                AiEmoticonUploadHelper aiEmoticonUploadHelper = AiEmoticonUploadHelper.INSTANCE;
                this.L$0 = list;
                this.label = 1;
                Object uploadPicAndCheck = aiEmoticonUploadHelper.uploadPicAndCheck(arrayList, list, this);
                if (uploadPicAndCheck == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = list;
                obj = uploadPicAndCheck;
            }
            i.e eVar = i.e.f261783e;
            Boolean boxBoolean = Boxing.boxBoolean(true);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (CheckImageResult) obj, list2, null);
            this.L$0 = null;
            this.label = 2;
            if (CorountineFunKt.i(eVar, null, boxBoolean, anonymousClass1, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AiEmoticonPreviewCustomization$asyncHandleImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

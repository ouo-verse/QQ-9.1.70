package com.tencent.mobileqq.emoticonview.ai.emoticon;

import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.l;
import com.tencent.qqnt.kernel.nativeinterface.PicMaterial;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1", f = "AiEmoticonUploadHelper.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PicMaterial>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ l $bdhUploadService;
    final /* synthetic */ Pair<String, String> $pathMd5;
    final /* synthetic */ List<PicModel> $picModelList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1(Pair<String, String> pair, l lVar, List<PicModel> list, Continuation<? super AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1> continuation) {
        super(2, continuation);
        this.$pathMd5 = pair;
        this.$bdhUploadService = lVar;
        this.$picModelList = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pair, lVar, list, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1(this.$pathMd5, this.$bdhUploadService, this.$picModelList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String substringAfterLast;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            Object obj2 = null;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
                commFileExtReq.uint32_action_type.set(0);
                substringAfterLast = StringsKt__StringsKt.substringAfterLast(this.$pathMd5.getFirst(), ".", "png");
                String lowerCase = substringAfterLast.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    str = peekAppRuntime.getCurrentUin();
                } else {
                    str = null;
                }
                String str2 = "tmp_figure/" + str + "/" + UUID.randomUUID() + "." + lowerCase;
                QLog.d(AiEmoticonUploadHelper.TAG, 1, "uploadPicAndCheck generate uuid:path:" + ((Object) this.$pathMd5.getFirst()) + ", uuid:" + str2);
                commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str2));
                AiEmoticonUploadHelper aiEmoticonUploadHelper = AiEmoticonUploadHelper.INSTANCE;
                l lVar = this.$bdhUploadService;
                Pair<String, String> pair = this.$pathMd5;
                byte[] byteArray = commFileExtReq.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "extReq.toByteArray()");
                this.label = 1;
                obj = aiEmoticonUploadHelper.uploadFile(lVar, pair, byteArray, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List<PicModel> list = this.$picModelList;
            Pair<String, String> pair2 = this.$pathMd5;
            PicMaterial picMaterial = (PicMaterial) obj;
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((PicModel) next).getPath(), pair2.getFirst())) {
                    obj2 = next;
                    break;
                }
            }
            PicModel picModel = (PicModel) obj2;
            if (picModel != null) {
                String str3 = picMaterial.url;
                Intrinsics.checkNotNullExpressionValue(str3, "picMaterial.url");
                picModel.setUrl(str3);
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super PicMaterial> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

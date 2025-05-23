package com.tencent.mobileqq.zplan.lite;

import com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/lite/ZPlanFilamentResourceDownloader$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1", f = "ZPlanFilamentResourceDownloader.kt", i = {}, l = {80, 82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanFilamentResourceDownloader.AvatarResourceResult>, Object> {
    final /* synthetic */ Map.Entry<String, String> $avatar;
    final /* synthetic */ HashMap<String, String> $avatarResourcePathMap;
    final /* synthetic */ ZPlanFilamentResourceDownloader.AvatarResourceResult $avatarResult;
    final /* synthetic */ String $unZipPath;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1(Map.Entry<String, String> entry, HashMap<String, String> hashMap, ZPlanFilamentResourceDownloader.AvatarResourceResult avatarResourceResult, String str, Continuation<? super ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1> continuation) {
        super(2, continuation);
        this.$avatar = entry;
        this.$avatarResourcePathMap = hashMap;
        this.$avatarResult = avatarResourceResult;
        this.$unZipPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1(this.$avatar, this.$avatarResourcePathMap, this.$avatarResult, this.$unZipPath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object n3;
        String str;
        ZPlanFilamentResourceDownloader.AvatarResourceResult avatarResourceResult;
        Map.Entry<String, String> entry;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanFilamentResourceDownloader zPlanFilamentResourceDownloader = ZPlanFilamentResourceDownloader.f333782a;
            String value = this.$avatar.getValue();
            this.label = 1;
            obj = zPlanFilamentResourceDownloader.g(value, null, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    entry = (Map.Entry) this.L$2;
                    avatarResourceResult = (ZPlanFilamentResourceDownloader.AvatarResourceResult) this.L$1;
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    avatarResourceResult.c(entry.getKey());
                    avatarResourceResult.d(str);
                    this.$avatarResourcePathMap.put(this.$avatarResult.getKey(), this.$avatarResult.getLocalPath());
                    return this.$avatarResult;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str2 = (String) obj;
        if (str2 != null) {
            String str3 = this.$unZipPath;
            ZPlanFilamentResourceDownloader.AvatarResourceResult avatarResourceResult2 = this.$avatarResult;
            Map.Entry<String, String> entry2 = this.$avatar;
            ZPlanFilamentResourceDownloader zPlanFilamentResourceDownloader2 = ZPlanFilamentResourceDownloader.f333782a;
            this.L$0 = str3;
            this.L$1 = avatarResourceResult2;
            this.L$2 = entry2;
            this.label = 2;
            n3 = zPlanFilamentResourceDownloader2.n(str2, str3, this);
            if (n3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str3;
            avatarResourceResult = avatarResourceResult2;
            entry = entry2;
            avatarResourceResult.c(entry.getKey());
            avatarResourceResult.d(str);
        }
        this.$avatarResourcePathMap.put(this.$avatarResult.getKey(), this.$avatarResult.getLocalPath());
        return this.$avatarResult;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanFilamentResourceDownloader.AvatarResourceResult> continuation) {
        return ((ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.zplan.lite;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$downloadAvatarResource$2", f = "ZPlanFilamentResourceDownloader.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"avatarResourcePathMap"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanFilamentResourceDownloader$downloadAvatarResource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, String>>, Object> {
    final /* synthetic */ HashMap<String, String> $avatarUrlMap;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentResourceDownloader$downloadAvatarResource$2(HashMap<String, String> hashMap, Continuation<? super ZPlanFilamentResourceDownloader$downloadAvatarResource$2> continuation) {
        super(2, continuation);
        this.$avatarUrlMap = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZPlanFilamentResourceDownloader$downloadAvatarResource$2 zPlanFilamentResourceDownloader$downloadAvatarResource$2 = new ZPlanFilamentResourceDownloader$downloadAvatarResource$2(this.$avatarUrlMap, continuation);
        zPlanFilamentResourceDownloader$downloadAvatarResource$2.L$0 = obj;
        return zPlanFilamentResourceDownloader$downloadAvatarResource$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HashMap<String, String>> continuation) {
        return ((ZPlanFilamentResourceDownloader$downloadAvatarResource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00ec  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0102 -> B:5:0x0105). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Iterator it;
        ZPlanFilamentResourceDownloader$downloadAvatarResource$2 zPlanFilamentResourceDownloader$downloadAvatarResource$2;
        HashMap hashMap;
        boolean startsWith$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                it = (Iterator) this.L$1;
                hashMap = (HashMap) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object await = obj;
                zPlanFilamentResourceDownloader$downloadAvatarResource$2 = this;
                while (it.hasNext()) {
                    Deferred o16 = ((com.tencent.mobileqq.qcoroutine.api.coroutine.a) it.next()).o();
                    if (o16 != null) {
                        zPlanFilamentResourceDownloader$downloadAvatarResource$2.L$0 = hashMap;
                        zPlanFilamentResourceDownloader$downloadAvatarResource$2.L$1 = it;
                        zPlanFilamentResourceDownloader$downloadAvatarResource$2.label = 1;
                        await = o16.await(zPlanFilamentResourceDownloader$downloadAvatarResource$2);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
                return hashMap;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.$avatarUrlMap.entrySet()) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(entry.getValue(), "https://ugc.superqqshow.qq.com", false, 2, null);
            String m3 = startsWith$default ? ZPlanFilamentResourceDownloader.f333782a.m(entry.getValue()) : ZPlanFilamentResourceDownloader.f333782a.l(entry.getValue());
            if (new File(m3).exists()) {
                boolean c16 = FAssetChecker.f333779a.c(m3);
                QLog.i("ZPlanFilamentResourceDownloader", 1, "avatarResource unZipPath exist. path:" + m3 + ", isPassVerify:" + c16);
                if (c16) {
                    hashMap2.put(entry.getKey(), m3);
                }
            }
            com.tencent.mobileqq.qcoroutine.api.coroutine.a c17 = CorountineFunKt.c(coroutineScope, null, null, null, new ZPlanFilamentResourceDownloader$downloadAvatarResource$2$1$downloadAvatarJob$1(entry, hashMap2, new ZPlanFilamentResourceDownloader.AvatarResourceResult("", ""), m3, null), 7, null);
            if (c17 != null) {
                arrayList.add(c17);
            }
        }
        it = arrayList.iterator();
        zPlanFilamentResourceDownloader$downloadAvatarResource$2 = this;
        hashMap = hashMap2;
        while (it.hasNext()) {
        }
        return hashMap;
    }
}

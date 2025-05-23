package com.tencent.mobileqq.nearbypro.profile.kuikly;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendUploadApi;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.nearbypro.repository.service.BDHService;
import com.tencent.mobileqq.nearbypro.request.c;
import com.tencent.mobileqq.qroute.QRoute;
import fu4.v;
import fu4.w;
import fu4.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyModule$call$5", f = "NearbyProfileKuiklyModule.kt", i = {1, 2, 2}, l = {284, 297, 305}, m = "invokeSuspend", n = {"$this$qLaunch", "$this$qLaunch", "msgInfo"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes15.dex */
final class NearbyProfileKuiklyModule$call$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appId;
    final /* synthetic */ String $avatarNormalPath;
    final /* synthetic */ Function1<Object, Unit> $callback;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProfileKuiklyModule$call$5(int i3, String str, Function1<Object, Unit> function1, Continuation<? super NearbyProfileKuiklyModule$call$5> continuation) {
        super(2, continuation);
        this.$appId = i3;
        this.$avatarNormalPath = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NearbyProfileKuiklyModule$call$5 nearbyProfileKuiklyModule$call$5 = new NearbyProfileKuiklyModule$call$5(this.$appId, this.$avatarNormalPath, this.$callback, continuation);
        nearbyProfileKuiklyModule$call$5.L$0 = obj;
        return nearbyProfileKuiklyModule$call$5;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        List<String> listOf;
        List list;
        Object first;
        w wVar;
        Object firstOrNull;
        w wVar2;
        Object firstOrNull2;
        String str;
        String decodeToString;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        wVar2 = (w) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
                        str = (String) firstOrNull2;
                        if (str != null) {
                            Function1<Object, Unit> function1 = this.$callback;
                            j.c().d("NearbyProfileKuiklyModule", "urls is empty");
                            if (function1 != null) {
                                function1.invoke(null);
                            }
                            return Unit.INSTANCE;
                        }
                        Function1<Object, Unit> function12 = this.$callback;
                        if (function12 != null) {
                            JSONObject jSONObject = new JSONObject();
                            decodeToString = StringsKt__StringsJVMKt.decodeToString(QQNearbyModule.Companion.d(QQNearbyModule.INSTANCE, c.c(wVar2), null, 2, null));
                            jSONObject.put("msgInfo", decodeToString);
                            jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, str);
                            function12.invoke(jSONObject);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                wVar = (w) obj;
                if (wVar == null) {
                    z[] zVarArr = wVar.f400825a;
                    Intrinsics.checkNotNullExpressionValue(zVarArr, "msgInfo.msgInfoBody");
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
                    z zVar = (z) firstOrNull;
                    if (zVar == null) {
                        Function1<Object, Unit> function13 = this.$callback;
                        j.c().d("NearbyProfileKuiklyModule", "msgInfoBody is empty");
                        if (function13 != null) {
                            function13.invoke(null);
                        }
                        return Unit.INSTANCE;
                    }
                    BDHService bDHService = new BDHService();
                    v vVar = zVar.f400830a;
                    this.L$0 = coroutineScope;
                    this.L$1 = wVar;
                    this.label = 3;
                    Object j3 = bDHService.j(vVar, this);
                    if (j3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    wVar2 = wVar;
                    obj = j3;
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
                    str = (String) firstOrNull2;
                    if (str != null) {
                    }
                } else {
                    j.c().d("NearbyProfileKuiklyModule", "sendPhoto fail, msgInfo is null");
                    Function1<Object, Unit> function14 = this.$callback;
                    if (function14 != null) {
                        function14.invoke(null);
                    }
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                list = (List) obj;
                if (!list.isEmpty()) {
                    j.c().d("NearbyProfileKuiklyModule", "upload result is empty");
                    Function1<Object, Unit> function15 = this.$callback;
                    if (function15 != null) {
                        function15.invoke(null);
                    }
                    return Unit.INSTANCE;
                }
                JSONObject jSONObject2 = new JSONObject();
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, first);
                Function1<Object, Unit> function16 = this.$callback;
                if (function16 != null) {
                    function16.invoke(jSONObject2);
                }
                return Unit.INSTANCE;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (this.$appId == 1) {
                IMatchFriendUploadApi iMatchFriendUploadApi = (IMatchFriendUploadApi) QRoute.api(IMatchFriendUploadApi.class);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$avatarNormalPath);
                this.label = 1;
                obj = iMatchFriendUploadApi.uploadPics(listOf, false, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) obj;
                if (!list.isEmpty()) {
                }
            } else {
                BDHService bDHService2 = new BDHService();
                String avatarNormalPath = this.$avatarNormalPath;
                Intrinsics.checkNotNullExpressionValue(avatarNormalPath, "avatarNormalPath");
                this.L$0 = coroutineScope;
                this.label = 2;
                obj = bDHService2.o(avatarNormalPath, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                wVar = (w) obj;
                if (wVar == null) {
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NearbyProfileKuiklyModule$call$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

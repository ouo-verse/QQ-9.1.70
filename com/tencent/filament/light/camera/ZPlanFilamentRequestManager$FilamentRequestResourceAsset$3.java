package com.tencent.filament.light.camera;

import com.google.gson.Gson;
import com.tencent.filament.light.data.FilamentRequestStatus;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3", f = "ZPlanFilamentRequestManager.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3}, l = {120, 121, 144, 147}, m = "invokeSuspend", n = {"$this$launch", "avatarResourceDeferred", "$this$launch", "bootResource", "avatarInfoResources", "avatarBaseResourcesJson", "meshActionList", "particleResourceDeferred", "avatarInfoResources", "avatarBaseResourcesJson", "meshActionList"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
public final class ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $avatarJson;
    final /* synthetic */ List $meshAnimationPaths;
    final /* synthetic */ int $requestID;
    final /* synthetic */ boolean $showOnlyHead;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3(Ref.ObjectRef objectRef, int i3, boolean z16, List list, Continuation continuation) {
        super(2, continuation);
        this.$avatarJson = objectRef;
        this.$requestID = i3;
        this.$showOnlyHead = z16;
        this.$meshAnimationPaths = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3 zPlanFilamentRequestManager$FilamentRequestResourceAsset$3 = new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3(this.$avatarJson, this.$requestID, this.$showOnlyHead, this.$meshAnimationPaths, completion);
        zPlanFilamentRequestManager$FilamentRequestResourceAsset$3.L$0 = obj;
        return zPlanFilamentRequestManager$FilamentRequestResourceAsset$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0230 A[LOOP:0: B:33:0x022a->B:35:0x0230, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r11v14, types: [T, java.util.Collection, java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        CoroutineScope coroutineScope;
        Deferred deferred;
        BootResourceModel bootResourceModel;
        Object await2;
        String str;
        String jSONObject;
        JSONObject n3;
        Ref.ObjectRef objectRef;
        ?? emptyList;
        boolean z16;
        String str2;
        Deferred async$default3;
        Object awaitAll;
        JSONObject jSONObject2;
        Ref.ObjectRef objectRef2;
        Deferred async$default4;
        List filterNotNull;
        Object await3;
        Ref.ObjectRef objectRef3;
        boolean contains$default;
        String str3;
        String str4;
        String str5;
        boolean z17;
        boolean z18;
        boolean z19;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            objectRef3 = (Ref.ObjectRef) this.L$2;
                            JSONObject jSONObject3 = (JSONObject) this.L$1;
                            str2 = (String) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            jSONObject2 = jSONObject3;
                            await3 = obj;
                            str5 = (String) await3;
                            if (str5.length() <= 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                JSONObject jSONObject4 = new JSONObject(str5);
                                String string = jSONObject4.getString("particleResourcePath");
                                if (string != null && string.length() != 0) {
                                    z18 = false;
                                } else {
                                    z18 = true;
                                }
                                if (!z18) {
                                    jSONObject2.put("particleResourcePath", string);
                                }
                                String string2 = jSONObject4.getString("shaderRootPath");
                                if (string2 != null && string2.length() != 0) {
                                    z19 = false;
                                } else {
                                    z19 = true;
                                }
                                if (!z19) {
                                    jSONObject2.put("shaderDir", string2);
                                }
                            }
                            objectRef = objectRef3;
                            jSONObject = str2;
                            n3 = jSONObject2;
                            HashMap hashMap = new HashMap();
                            hashMap.put("avatarInfoResources", jSONObject);
                            hashMap.put("avatarBaseResources", n3.toString());
                            if (!((List) objectRef.element).isEmpty()) {
                                hashMap.put("meshAnimationGltfPaths", new Gson().toJson((List) objectRef.element));
                            }
                            for (Map.Entry entry : hashMap.entrySet()) {
                                FLog fLog = FLog.INSTANCE;
                                ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
                                str3 = ZPlanFilamentRequestManager.TAG;
                                fLog.i(str3, "FilamentRequestResourceAsset key: " + ((String) entry.getKey()));
                                str4 = ZPlanFilamentRequestManager.TAG;
                                fLog.i(str4, "FilamentRequestResourceAsset value: " + ((String) entry.getValue()));
                            }
                            ZPlanFilamentRequestManager.INSTANCE.nRequestRequestResourceAssetCallback(this.$requestID, 0, hashMap);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    Deferred deferred2 = (Deferred) this.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.L$2;
                    jSONObject2 = (JSONObject) this.L$1;
                    String str6 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef4;
                    str2 = str6;
                    async$default3 = deferred2;
                    awaitAll = obj;
                    filterNotNull = CollectionsKt___CollectionsKt.filterNotNull((Iterable) awaitAll);
                    ?? arrayList = new ArrayList();
                    for (Object obj2 : filterNotNull) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) obj2, (CharSequence) "/Empty.gltf", false, 2, (Object) null);
                        if (!Boxing.boxBoolean(contains$default).booleanValue()) {
                            arrayList.add(obj2);
                        }
                    }
                    objectRef2.element = arrayList;
                    this.L$0 = str2;
                    this.L$1 = jSONObject2;
                    this.L$2 = objectRef;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 4;
                    await3 = async$default3.await(this);
                    if (await3 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef3 = objectRef;
                    str5 = (String) await3;
                    if (str5.length() <= 0) {
                    }
                    if (z17) {
                    }
                    objectRef = objectRef3;
                    jSONObject = str2;
                    n3 = jSONObject2;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("avatarInfoResources", jSONObject);
                    hashMap2.put("avatarBaseResources", n3.toString());
                    if (!((List) objectRef.element).isEmpty()) {
                    }
                    while (r2.hasNext()) {
                    }
                    ZPlanFilamentRequestManager.INSTANCE.nRequestRequestResourceAssetCallback(this.$requestID, 0, hashMap2);
                    return Unit.INSTANCE;
                }
                BootResourceModel bootResourceModel2 = (BootResourceModel) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                bootResourceModel = bootResourceModel2;
                await2 = obj;
                ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) await2;
                if (bootResourceModel == null && reloadAvatarResourceModel != null) {
                    boolean z26 = this.$showOnlyHead;
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    jSONObject = ZPlanAvatarResourceHelper.p(zPlanAvatarResourceHelper, reloadAvatarResourceModel, (JSONObject) this.$avatarJson.element, !z26, z26, false, null, 48, null).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "ZPlanAvatarResourceHelpe\u2026 showOnlyHead).toString()");
                    n3 = zPlanAvatarResourceHelper.n(bootResourceModel, reloadAvatarResourceModel);
                    objectRef = new Ref.ObjectRef();
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    objectRef.element = emptyList;
                    ZPlanFilamentRequestManager zPlanFilamentRequestManager2 = ZPlanFilamentRequestManager.INSTANCE;
                    z16 = ZPlanFilamentRequestManager.mUseCppDownloader;
                    if (z16) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = this.$meshAnimationPaths.iterator();
                        while (it.hasNext()) {
                            async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$1$1((String) it.next(), null), 3, null);
                            arrayList2.add(async$default4);
                            jSONObject = jSONObject;
                        }
                        str2 = jSONObject;
                        async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1(this, null), 3, null);
                        this.L$0 = str2;
                        this.L$1 = n3;
                        this.L$2 = objectRef;
                        this.L$3 = async$default3;
                        this.L$4 = objectRef;
                        this.label = 3;
                        awaitAll = AwaitKt.awaitAll(arrayList2, this);
                        if (awaitAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jSONObject2 = n3;
                        objectRef2 = objectRef;
                        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull((Iterable) awaitAll);
                        ?? arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                        }
                        objectRef2.element = arrayList3;
                        this.L$0 = str2;
                        this.L$1 = jSONObject2;
                        this.L$2 = objectRef;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 4;
                        await3 = async$default3.await(this);
                        if (await3 != coroutine_suspended) {
                        }
                    } else {
                        HashMap hashMap22 = new HashMap();
                        hashMap22.put("avatarInfoResources", jSONObject);
                        hashMap22.put("avatarBaseResources", n3.toString());
                        if (!((List) objectRef.element).isEmpty()) {
                        }
                        while (r2.hasNext()) {
                        }
                        ZPlanFilamentRequestManager.INSTANCE.nRequestRequestResourceAssetCallback(this.$requestID, 0, hashMap22);
                        return Unit.INSTANCE;
                    }
                } else {
                    FLog fLog2 = FLog.INSTANCE;
                    ZPlanFilamentRequestManager zPlanFilamentRequestManager3 = ZPlanFilamentRequestManager.INSTANCE;
                    str = ZPlanFilamentRequestManager.TAG;
                    fLog2.e(str, "FilamentRequestResourceAsset bootResource is null or avatarResource is null");
                    zPlanFilamentRequestManager3.nRequestRequestResourceAssetCallback(this.$requestID, FilamentRequestStatus.DOWNLOAD_FAILED.ordinal(), new HashMap());
                    return Unit.INSTANCE;
                }
            } else {
                deferred = (Deferred) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                await = obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$bootResourceDeferred$1(null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$avatarResourceDeferred$1(this, null), 3, null);
            this.L$0 = coroutineScope2;
            this.L$1 = async$default2;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            deferred = async$default2;
        }
        bootResourceModel = (BootResourceModel) await;
        this.L$0 = coroutineScope;
        this.L$1 = bootResourceModel;
        this.label = 2;
        await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) await2;
        if (bootResourceModel == null) {
        }
        FLog fLog22 = FLog.INSTANCE;
        ZPlanFilamentRequestManager zPlanFilamentRequestManager32 = ZPlanFilamentRequestManager.INSTANCE;
        str = ZPlanFilamentRequestManager.TAG;
        fLog22.e(str, "FilamentRequestResourceAsset bootResource is null or avatarResource is null");
        zPlanFilamentRequestManager32.nRequestRequestResourceAssetCallback(this.$requestID, FilamentRequestStatus.DOWNLOAD_FAILED.ordinal(), new HashMap());
        return Unit.INSTANCE;
    }
}

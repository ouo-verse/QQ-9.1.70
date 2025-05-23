package com.tencent.filament.zplan.record;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordHelper$fetchStickerAnimation$2", f = "FilamentRecordHelper.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {66, 67, 70}, m = "invokeSuspend", n = {"faceUrl", "bodyUrl", "bodyDeferred", "faceUrl", "bodyUrl", "faceGltf", "configJson", "faceUrl", "bodyUrl", "faceGltf", "configJson", "bodyGltf"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes6.dex */
final class FilamentRecordHelper$fetchStickerAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ZPlanAction, ? extends String>>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ String $recordStickDataBaseUrl;
    final /* synthetic */ JSONObject $stickerConfig;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordHelper$fetchStickerAnimation$2(JSONObject jSONObject, EnumUserGender enumUserGender, String str, FilamentUrlTemplate filamentUrlTemplate, Continuation continuation) {
        super(2, continuation);
        this.$stickerConfig = jSONObject;
        this.$gender = enumUserGender;
        this.$recordStickDataBaseUrl = str;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        FilamentRecordHelper$fetchStickerAnimation$2 filamentRecordHelper$fetchStickerAnimation$2 = new FilamentRecordHelper$fetchStickerAnimation$2(this.$stickerConfig, this.$gender, this.$recordStickDataBaseUrl, this.$urlTemplate, completion);
        filamentRecordHelper$fetchStickerAnimation$2.L$0 = obj;
        return filamentRecordHelper$fetchStickerAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ZPlanAction, ? extends String>> continuation) {
        return ((FilamentRecordHelper$fetchStickerAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01fa  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        Pair pair;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        String str8;
        String str9;
        int lastIndexOf$default;
        int lastIndexOf$default2;
        String str10;
        String str11;
        Resource resource;
        Resource resource2;
        Object await2;
        String e16;
        FilamentRecordHelper filamentRecordHelper;
        FilamentUrlTemplate filamentUrlTemplate;
        Resource resource3;
        Resource resource4;
        String str12;
        String str13;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        resource3 = (Resource) this.L$4;
                        resource4 = (Resource) this.L$3;
                        resource = (Resource) this.L$2;
                        str12 = (String) this.L$1;
                        str13 = (String) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ZPlanAction zPlanAction = new ZPlanAction(resource.e(), resource3.e(), str13, str12);
                        if (!resource.f() && !resource3.f() && !resource4.f()) {
                            z16 = false;
                        }
                        zPlanAction.f(z16);
                        Unit unit = Unit.INSTANCE;
                        return new Pair(zPlanAction, resource4.e());
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Resource resource5 = (Resource) this.L$3;
                Resource resource6 = (Resource) this.L$2;
                str9 = (String) this.L$1;
                str8 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                resource = resource6;
                resource2 = resource5;
                await2 = obj;
                Resource resource7 = (Resource) await2;
                e16 = resource2.e();
                filamentRecordHelper = FilamentRecordHelper.f105779a;
                filamentUrlTemplate = this.$urlTemplate;
                this.L$0 = str8;
                this.L$1 = str9;
                this.L$2 = resource;
                this.L$3 = resource2;
                this.L$4 = resource7;
                this.label = 3;
                if (filamentRecordHelper.a(null, e16, filamentUrlTemplate, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                resource3 = resource7;
                resource4 = resource2;
                str12 = str9;
                str13 = str8;
                ZPlanAction zPlanAction2 = new ZPlanAction(resource.e(), resource3.e(), str13, str12);
                if (!resource.f()) {
                    z16 = false;
                }
                zPlanAction2.f(z16);
                Unit unit2 = Unit.INSTANCE;
                return new Pair(zPlanAction2, resource4.e());
            }
            async$default2 = (Deferred) this.L$2;
            str9 = (String) this.L$1;
            str8 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int optInt = this.$stickerConfig.optInt(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID);
            EnumUserGender enumUserGender = this.$gender;
            if (enumUserGender != null) {
                int i16 = b.f105811a[enumUserGender.ordinal()];
                if (i16 != 1) {
                    if (i16 == 2) {
                        JSONArray optJSONArray = this.$stickerConfig.optJSONArray("ue4_head_anim_path");
                        if (optJSONArray != null) {
                            str10 = optJSONArray.optString(0);
                        } else {
                            str10 = null;
                        }
                        JSONArray optJSONArray2 = this.$stickerConfig.optJSONArray("ue4_pose_anim_path");
                        if (optJSONArray2 != null) {
                            str11 = optJSONArray2.optString(0);
                        } else {
                            str11 = null;
                        }
                        pair = new Pair(str10, str11);
                    }
                } else {
                    JSONArray optJSONArray3 = this.$stickerConfig.optJSONArray("ue4_head_anim_female_path");
                    if (optJSONArray3 != null) {
                        str = optJSONArray3.optString(0);
                    } else {
                        str = null;
                    }
                    JSONArray optJSONArray4 = this.$stickerConfig.optJSONArray("ue4_pose_anim_female_path");
                    if (optJSONArray4 != null) {
                        str2 = optJSONArray4.optString(0);
                    } else {
                        str2 = null;
                    }
                    pair = new Pair(str, str2);
                }
                String str14 = (String) pair.component1();
                String str15 = (String) pair.component2();
                FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "fetchAnimation gender:" + this.$gender + ", facePath:" + str14 + ", bodyPath:" + str15 + ", recordStickDataBaseUrl:" + this.$recordStickDataBaseUrl);
                String str16 = this.$recordStickDataBaseUrl;
                if (str16 == null) {
                    str16 = this.$urlTemplate.getRecordStickDataBaseUrl();
                }
                String str17 = str16 + '/' + str14 + ".fasset";
                String str18 = str16 + '/' + str15 + ".fasset";
                if (str14 != null) {
                    str3 = "(this as java.lang.String).substring(startIndex)";
                    str4 = str17;
                    lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str14, "/", 0, false, 6, (Object) null);
                    str5 = str14.substring(lastIndexOf$default2 + 1);
                    Intrinsics.checkNotNullExpressionValue(str5, str3);
                } else {
                    str3 = "(this as java.lang.String).substring(startIndex)";
                    str4 = str17;
                    str5 = null;
                }
                if (str15 != null) {
                    str6 = str18;
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str15, "/", 0, false, 6, (Object) null);
                    String substring = str15.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, str3);
                    str7 = substring;
                } else {
                    str6 = str18;
                    str7 = null;
                }
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1(this, str4, str5, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentRecordHelper$fetchStickerAnimation$2$bodyDeferred$1(this, str6, str7, null), 3, null);
                this.L$0 = str4;
                this.L$1 = str6;
                this.L$2 = async$default2;
                this.label = 1;
                await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str8 = str4;
                str9 = str6;
            }
            throw new IllegalArgumentException("fetchAnimation failed for id: " + optInt + " with gender: " + this.$gender);
        }
        Pair pair2 = (Pair) await;
        resource = (Resource) pair2.component1();
        resource2 = (Resource) pair2.component2();
        this.L$0 = str8;
        this.L$1 = str9;
        this.L$2 = resource;
        this.L$3 = resource2;
        this.label = 2;
        await2 = async$default2.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        Resource resource72 = (Resource) await2;
        e16 = resource2.e();
        filamentRecordHelper = FilamentRecordHelper.f105779a;
        filamentUrlTemplate = this.$urlTemplate;
        this.L$0 = str8;
        this.L$1 = str9;
        this.L$2 = resource;
        this.L$3 = resource2;
        this.L$4 = resource72;
        this.label = 3;
        if (filamentRecordHelper.a(null, e16, filamentUrlTemplate, this) != coroutine_suspended) {
        }
    }
}

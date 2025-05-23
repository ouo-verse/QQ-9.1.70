package com.tencent.filament.zplan.record;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.zplan.common.utils.h;
import kotlin.Metadata;
import kotlin.Pair;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordNativeApp$fetchAnimation$2", f = "FilamentRecordNativeApp.kt", i = {}, l = {534}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$fetchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ZPlanAction, ? extends String>>, Object> {
    final /* synthetic */ JSONObject $data;
    int label;
    final /* synthetic */ FilamentRecordNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordNativeApp$fetchAnimation$2(FilamentRecordNativeApp filamentRecordNativeApp, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentRecordNativeApp;
        this.$data = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentRecordNativeApp$fetchAnimation$2(this.this$0, this.$data, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ZPlanAction, ? extends String>> continuation) {
        return ((FilamentRecordNativeApp$fetchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        JSONObject jSONObject;
        EnumUserGender enumUserGender;
        String str;
        FilamentUrlTemplate filamentUrlTemplate;
        Integer boxInt;
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
            String valueOf = String.valueOf(this.$data.optInt("id"));
            JSONObject optJSONObject = this.$data.optJSONObject("sender");
            String str2 = null;
            if (optJSONObject == null || (jSONObject = optJSONObject.optJSONObject("userData")) == null) {
                if (optJSONObject != null) {
                    jSONObject = optJSONObject.optJSONObject(IZplanHandleApi.BUSINESS_DRESS_INFO);
                } else {
                    jSONObject = null;
                }
            }
            if (jSONObject != null && (boxInt = Boxing.boxInt(jSONObject.optInt("gender"))) != null) {
                enumUserGender = EnumUserGender.INSTANCE.a(boxInt.intValue());
            } else {
                enumUserGender = null;
            }
            h hVar = h.f385294a;
            JSONObject optJSONObject2 = this.$data.optJSONObject("stickerData");
            if (optJSONObject2 != null) {
                str = optJSONObject2.optString(valueOf);
            } else {
                str = null;
            }
            JSONObject b16 = hVar.b(str);
            if (b16 != null) {
                JSONObject b17 = hVar.b(this.$data.optString(QQBrowserActivity.APP_PARAM));
                if (b17 != null) {
                    str2 = b17.optString("record_stick_data_base_url");
                }
                FilamentRecordHelper filamentRecordHelper = FilamentRecordHelper.f105779a;
                filamentUrlTemplate = this.this$0.urlTemplate;
                this.label = 1;
                obj = filamentRecordHelper.b(b16, enumUserGender, filamentUrlTemplate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalArgumentException("fetchAnimation failed for missing stickerConf for id: " + valueOf);
            }
        }
        return obj;
    }
}

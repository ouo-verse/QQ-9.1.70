package com.tencent.mobileqq.wink.preprocess;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment$recoveryFromWinkEditData$1", f = "WinkAvatarShareTransFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAvatarShareTransFragment$recoveryFromWinkEditData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $missionId;
    int label;
    final /* synthetic */ WinkAvatarShareTransFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAvatarShareTransFragment$recoveryFromWinkEditData$1(String str, WinkAvatarShareTransFragment winkAvatarShareTransFragment, Continuation<? super WinkAvatarShareTransFragment$recoveryFromWinkEditData$1> continuation) {
        super(2, continuation);
        this.$missionId = str;
        this.this$0 = winkAvatarShareTransFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAvatarShareTransFragment$recoveryFromWinkEditData$1(this.$missionId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Boolean bool;
        String str;
        String str2;
        p pVar;
        p pVar2;
        p pVar3;
        int i3;
        Intent intent;
        WinkTemplateSharePreviewViewModel Ch;
        WinkTemplateSharePreviewViewModel Ch2;
        Intent intent2;
        Intent intent3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(this.$missionId);
            FragmentActivity activity = this.this$0.getActivity();
            p pVar4 = null;
            if (activity != null && (intent3 = activity.getIntent()) != null) {
                bool = Boxing.boxBoolean(intent3.getBooleanExtra(QQWinkConstants.AVATAR_SYNC_PUBLISH, false));
            } else {
                bool = null;
            }
            FragmentActivity activity2 = this.this$0.getActivity();
            if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                str = intent2.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE);
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            String Bh = this.this$0.Bh(valueOf);
            if (d16 == null) {
                w53.b.f("WinkProcessContentTransFragment", "editData is null, try to use mediaPaths");
                if (Intrinsics.areEqual(bool, Boxing.boxBoolean(true))) {
                    Ch2 = this.this$0.Ch();
                    Ch2.j2(true, Bh, this.$missionId);
                    this.this$0.Gh(valueOf);
                    this.this$0.xh("publish");
                } else {
                    Ch = this.this$0.Ch();
                    Ch.j2(false, Bh, this.$missionId);
                }
                return Unit.INSTANCE;
            }
            try {
                FragmentActivity activity3 = this.this$0.getActivity();
                if (activity3 != null && (intent = activity3.getIntent()) != null) {
                    str2 = intent.getStringExtra(QQWinkConstants.AVATAR_NEW_HD_PATH);
                } else {
                    str2 = null;
                }
                WinkEditDataWrapper yh5 = this.this$0.yh(String.valueOf(str2), valueOf, d16);
                if (!Intrinsics.areEqual(bool, Boxing.boxBoolean(true))) {
                    this.this$0.wh(yh5);
                } else {
                    com.tencent.mobileqq.wink.editor.draft.a.h(yh5, yh5.getMissionId());
                    com.tencent.mobileqq.wink.editor.draft.a.i(yh5, yh5.getMissionId());
                    Bundle bundle = new Bundle();
                    pVar = this.this$0.winkTemplateShareConfig;
                    if (pVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                        pVar = null;
                    }
                    bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, pVar.c().getTaskId());
                    pVar2 = this.this$0.winkTemplateShareConfig;
                    if (pVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                        pVar2 = null;
                    }
                    bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, pVar2.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String());
                    pVar3 = this.this$0.winkTemplateShareConfig;
                    if (pVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                    } else {
                        pVar4 = pVar3;
                    }
                    if (Intrinsics.areEqual(pVar4.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String(), QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR)) {
                        i3 = 27;
                    } else {
                        i3 = 26;
                    }
                    OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
                    String missionId = yh5.getMissionId();
                    Intrinsics.checkNotNull(missionId);
                    OneClickPublishingHelper.z(oneClickPublishingHelper, i3, missionId, null, Bh, bundle, false, 32, null);
                    this.this$0.Gh(valueOf);
                    this.this$0.xh("success");
                }
            } catch (Exception e16) {
                w53.b.d("WinkProcessContentTransFragment", "recoveryFromWinkEditData fail", e16);
                this.this$0.xh("error");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAvatarShareTransFragment$recoveryFromWinkEditData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

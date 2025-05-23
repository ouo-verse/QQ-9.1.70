package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$getNickName$1", f = "UploadBackgroundPage.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage$getNickName$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $isGroup;
    public final /* synthetic */ String $uin;
    public UpLoadBackgroundPage L$0;
    public int label;
    public final /* synthetic */ UpLoadBackgroundPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpLoadBackgroundPage$getNickName$1(UpLoadBackgroundPage upLoadBackgroundPage, String str, boolean z16, Continuation<? super UpLoadBackgroundPage$getNickName$1> continuation) {
        super(2, continuation);
        this.this$0 = upLoadBackgroundPage;
        this.$uin = str;
        this.$isGroup = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpLoadBackgroundPage$getNickName$1(this.this$0, this.$uin, this.$isGroup, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((UpLoadBackgroundPage$getNickName$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        UpLoadBackgroundPage upLoadBackgroundPage;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            UpLoadBackgroundPage upLoadBackgroundPage2 = this.this$0;
            Friends friends = VasBasePage.Companion.getCtx().platformApi.getVasModule().getFriends();
            String str = this.$uin;
            boolean z16 = this.$isGroup;
            this.L$0 = upLoadBackgroundPage2;
            this.label = 1;
            Object friendOrGroupName = friends.getFriendOrGroupName(str, z16, false, this);
            if (friendOrGroupName == coroutine_suspended) {
                return coroutine_suspended;
            }
            upLoadBackgroundPage = upLoadBackgroundPage2;
            obj = friendOrGroupName;
        } else if (i3 == 1) {
            upLoadBackgroundPage = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CharSequence charSequence = (CharSequence) obj;
        String str2 = this.$uin;
        if (charSequence.length() == 0) {
            charSequence = str2;
        }
        upLoadBackgroundPage.nickName$delegate.setValue(upLoadBackgroundPage, UpLoadBackgroundPage.$$delegatedProperties[6], (String) charSequence);
        return Unit.INSTANCE;
    }
}

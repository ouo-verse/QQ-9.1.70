package com.tencent.mobileqq.zplan.easteregg.recent;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.IZplanOutboundAvatar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.easteregg.recent.ZPlanRecentHeadEffectProcessor$updateContent$1", f = "ZPlanRecentHeadEffectProcessor.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {DownloadInfo.spKey_Config}, s = {"L$0"})
/* loaded from: classes34.dex */
final class ZPlanRecentHeadEffectProcessor$updateContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $item;
    Object L$0;
    int label;
    final /* synthetic */ ZPlanRecentHeadEffectProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRecentHeadEffectProcessor$updateContent$1(ZPlanRecentHeadEffectProcessor zPlanRecentHeadEffectProcessor, g gVar, Continuation<? super ZPlanRecentHeadEffectProcessor$updateContent$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanRecentHeadEffectProcessor;
        this.$item = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanRecentHeadEffectProcessor$updateContent$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean r16;
        boolean q16;
        String substringAfterLast$default;
        Object p16;
        com.tencent.mobileqq.zplan.easteregg.a aVar;
        WeakReference weakReference;
        WeakReference weakReference2;
        RecentContactItemBinding recentContactItemBinding;
        nw3.a a16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            r16 = this.this$0.r();
            if (r16) {
                q16 = this.this$0.q(this.$item);
                if (q16) {
                    substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(this.$item.v().f().toString(), ":", (String) null, 2, (Object) null);
                    com.tencent.mobileqq.zplan.easteregg.a matchKeywordEasterEggConfig = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMatchKeywordEasterEggConfig(substringAfterLast$default, this.$item.n());
                    if (matchKeywordEasterEggConfig == null) {
                        return Unit.INSTANCE;
                    }
                    QLog.i("ZPlanRecentHeadEffectProcessor", 1, "updateContent, config: " + matchKeywordEasterEggConfig);
                    ZPlanRecentHeadEffectProcessor zPlanRecentHeadEffectProcessor = this.this$0;
                    g gVar = this.$item;
                    this.L$0 = matchKeywordEasterEggConfig;
                    this.label = 1;
                    p16 = zPlanRecentHeadEffectProcessor.p(gVar, this);
                    if (p16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = matchKeywordEasterEggConfig;
                    obj = p16;
                } else {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 4, "checkUin false, retrun.");
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            aVar = (com.tencent.mobileqq.zplan.easteregg.a) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            weakReference = this.this$0.bindingRef;
            ImageView avatarView = (weakReference == null || (recentContactItemBinding = (RecentContactItemBinding) weakReference.get()) == null || (a16 = recentContactItemBinding.a()) == null) ? null : a16.getAvatarView();
            Object drawable = avatarView != null ? avatarView.getDrawable() : null;
            if (!(drawable instanceof IZplanOutboundAvatar)) {
                QLog.e("ZPlanRecentHeadEffectProcessor", 1, "faceDrawable is not FaceDrawable, retrun.");
                return Unit.INSTANCE;
            }
            IZplanOutboundAvatar iZplanOutboundAvatar = (IZplanOutboundAvatar) drawable;
            iZplanOutboundAvatar.preloadOutboundResource();
            boolean isShowZplanOutboundAvatar = iZplanOutboundAvatar.isShowZplanOutboundAvatar();
            String zPlanAvatarBackgroundUrl = iZplanOutboundAvatar.getZPlanAvatarBackgroundUrl();
            if (zPlanAvatarBackgroundUrl == null) {
                zPlanAvatarBackgroundUrl = "";
            }
            aVar.y(zPlanAvatarBackgroundUrl);
            aVar.F(isShowZplanOutboundAvatar);
            if (isShowZplanOutboundAvatar && !TextUtils.isEmpty(zPlanAvatarBackgroundUrl)) {
                weakReference2 = this.this$0.contentViewRef;
                if (weakReference2 != null) {
                    this.this$0.v(aVar, this.$item, weakReference2, avatarView);
                }
                return Unit.INSTANCE;
            }
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "updateContent, isZPlanOutBoundAvatar is " + isShowZplanOutboundAvatar + ", zplanBackgroundUrl is " + zPlanAvatarBackgroundUrl + ", return.");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanRecentHeadEffectProcessor$updateContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

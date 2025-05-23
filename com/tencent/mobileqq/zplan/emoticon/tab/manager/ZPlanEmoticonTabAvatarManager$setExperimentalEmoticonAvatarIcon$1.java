package com.tencent.mobileqq.zplan.emoticon.tab.manager;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.zplan.emoticon.tab.model.ZPlanEmoticonAvatarIconStatus;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1", f = "ZPlanEmoticonTabAvatarManager.kt", i = {0}, l = {211}, m = "invokeSuspend", n = {"backupDrawable"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ URLImageView $tabImageView;
    final /* synthetic */ WeakReference<URLImageView> $tabImageViewRef;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1(URLImageView uRLImageView, CoroutineScope coroutineScope, WeakReference<URLImageView> weakReference, Continuation<? super ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1> continuation) {
        super(2, continuation);
        this.$tabImageView = uRLImageView;
        this.$scope = coroutineScope;
        this.$tabImageViewRef = weakReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1(this.$tabImageView, this.$scope, this.$tabImageViewRef, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        r9 = r1.u();
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Drawable y16;
        boolean E;
        String str;
        Drawable drawable;
        ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager;
        boolean x16;
        boolean F;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager2 = ZPlanEmoticonTabAvatarManager.f333345a;
            y16 = zPlanEmoticonTabAvatarManager2.y();
            if (y16 == null) {
                y16 = zPlanEmoticonTabAvatarManager2.q();
            }
            E = zPlanEmoticonTabAvatarManager2.E();
            Drawable w3 = E ? y16 : zPlanEmoticonTabAvatarManager2.w();
            if (w3 == null) {
                str = "set backupDrawable";
            } else {
                str = "set meme cache drawable";
            }
            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "setExperimentalEmoticonAvatarIcon " + str);
            zPlanEmoticonTabAvatarManager2.M(this.$tabImageView, w3 == null ? y16 : w3);
            if (w3 == null) {
                this.L$0 = y16;
                this.label = 1;
                obj = zPlanEmoticonTabAvatarManager2.s(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                drawable = y16;
            }
            zPlanEmoticonTabAvatarManager = ZPlanEmoticonTabAvatarManager.f333345a;
            if (zPlanEmoticonTabAvatarManager.D(false) != ZPlanEmoticonAvatarIconStatus.AvatarIconWithShaking) {
                x16 = zPlanEmoticonTabAvatarManager.x();
                if (!x16) {
                    zPlanEmoticonTabAvatarManager.C(this.$scope, this.$tabImageViewRef);
                } else {
                    QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "setZPlanEmoticonAvatarIcon need shake on last update tabImageView:" + this.$tabImageView);
                    F = zPlanEmoticonTabAvatarManager.F(this.$tabImageView);
                    if (F) {
                        URLImageView uRLImageView = this.$tabImageView;
                        Intrinsics.checkNotNull(uRLImageView);
                        zPlanEmoticonTabAvatarManager.P(uRLImageView);
                    }
                }
                return Unit.INSTANCE;
            }
            QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "setZPlanEmoticonAvatarIcon no need to shake so no need to request");
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            drawable = (Drawable) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Drawable drawable2 = (Drawable) obj;
        if (drawable2 == null) {
            str2 = "set last or backupDrawable";
        } else {
            str2 = "set file or cloud cache drawable";
        }
        QLog.i("[zplan][ZPlanEmoticonAvatarIconUtil]", 1, "setExperimentalEmoticonAvatarIcon " + str2);
        ZPlanEmoticonTabAvatarManager zPlanEmoticonTabAvatarManager3 = ZPlanEmoticonTabAvatarManager.f333345a;
        URLImageView uRLImageView2 = this.$tabImageView;
        if (drawable2 != null || drawable2 != null) {
            drawable = drawable2;
        }
        zPlanEmoticonTabAvatarManager3.M(uRLImageView2, drawable);
        zPlanEmoticonTabAvatarManager = ZPlanEmoticonTabAvatarManager.f333345a;
        if (zPlanEmoticonTabAvatarManager.D(false) != ZPlanEmoticonAvatarIconStatus.AvatarIconWithShaking) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonTabAvatarManager$setExperimentalEmoticonAvatarIcon$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

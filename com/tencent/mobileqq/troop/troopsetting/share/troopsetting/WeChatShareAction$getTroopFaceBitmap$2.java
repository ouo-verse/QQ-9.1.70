package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.share.troopsetting.WeChatShareAction$getTroopFaceBitmap$2", f = "WeChatShareAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class WeChatShareAction$getTroopFaceBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $result;
    final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b $shareContext;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeChatShareAction$getTroopFaceBitmap$2(com.tencent.mobileqq.troop.troopsetting.share.b bVar, Ref.ObjectRef<Bitmap> objectRef, Continuation<? super WeChatShareAction$getTroopFaceBitmap$2> continuation) {
        super(2, continuation);
        this.$shareContext = bVar;
        this.$result = objectRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, objectRef, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new WeChatShareAction$getTroopFaceBitmap$2(this.$shareContext, this.$result, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, android.graphics.Bitmap] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AppRuntime appRuntime = this.$shareContext.b().getAppRuntime();
                if (appRuntime == null) {
                    return Unit.INSTANCE;
                }
                IRuntimeService runtimeService = appRuntime.getRuntimeService(IQQAvatarCompatibleService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026va, ProcessConstant.MAIN)");
                Bitmap faceBitmap = ((IQQAvatarCompatibleService) runtimeService).getFaceBitmap(4, this.$shareContext.h().troopUin, (byte) 3, 100, true, (byte) 1, 0);
                if (faceBitmap == null) {
                    faceBitmap = BaseImageUtil.getDefaultTroopFaceBitmap();
                }
                if (faceBitmap == null) {
                    return Unit.INSTANCE;
                }
                this.$result.element = Bitmap.createBitmap(faceBitmap.getWidth(), faceBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                if (this.$result.element == null) {
                    return Unit.INSTANCE;
                }
                Bitmap bitmap = this.$result.element;
                Intrinsics.checkNotNull(bitmap);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(-1);
                canvas.drawBitmap(faceBitmap, 0.0f, 0.0f, new Paint());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((WeChatShareAction$getTroopFaceBitmap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

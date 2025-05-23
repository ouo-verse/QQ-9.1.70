package com.tencent.mobileqq.aio.msglist.holder.component.position;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgHelper$bindView$2", f = "AIOPositionMsgHelper.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOPositionMsgHelper$bindView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ImageView $map;
    final /* synthetic */ com.tencent.mobileqq.aio.msg.template.b $msgItem;
    final /* synthetic */ Resources $res;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPositionMsgHelper$bindView$2(com.tencent.mobileqq.aio.msg.template.b bVar, View view, ImageView imageView, Resources resources, Continuation<? super AIOPositionMsgHelper$bindView$2> continuation) {
        super(2, continuation);
        this.$msgItem = bVar;
        this.$view = view;
        this.$map = imageView;
        this.$res = resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, view, imageView, resources, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOPositionMsgHelper$bindView$2(this.$msgItem, this.$view, this.$map, this.$res, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r9);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Double doubleOrNull;
        Double doubleOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                AIOPositionMsgHelper aIOPositionMsgHelper = AIOPositionMsgHelper.f191690a;
                String b16 = this.$msgItem.b();
                if (b16 != null && doubleOrNull != null) {
                    double doubleValue = doubleOrNull.doubleValue();
                    String c16 = this.$msgItem.c();
                    if (c16 != null && doubleOrNull2 != null) {
                        double doubleValue2 = doubleOrNull2.doubleValue();
                        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
                        this.label = 1;
                        obj = aIOPositionMsgHelper.r(doubleValue, doubleValue2, isNowThemeIsNight, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
            AIOPositionMsgHelper.f191690a.m(this.$view);
            this.$map.setImageDrawable(new BitmapDrawable(this.$res, (Bitmap) obj));
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOPositionMsgHelper$bindView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

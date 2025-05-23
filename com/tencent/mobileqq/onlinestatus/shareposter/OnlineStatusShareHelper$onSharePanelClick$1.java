package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.onlinestatus.utils.z;
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
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$onSharePanelClick$1", f = "OnlineStatusShareHelper.kt", i = {}, l = {243, 249, 255, 261, 273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$onSharePanelClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionId;
    final /* synthetic */ Bitmap $posterBitmap;
    int label;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$onSharePanelClick$1(String str, OnlineStatusShareHelper onlineStatusShareHelper, Bitmap bitmap, Continuation<? super OnlineStatusShareHelper$onSharePanelClick$1> continuation) {
        super(2, continuation);
        this.$actionId = str;
        this.this$0 = onlineStatusShareHelper;
        this.$posterBitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$onSharePanelClick$1(this.$actionId, this.this$0, this.$posterBitmap, continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0040. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object S;
        Object Q;
        Object R;
        Object S2;
        Object x16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ResultKt.throwOnFailure(obj);
                                z.y(5);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            z.y(3);
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        z.y(1);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    z.y(2);
                }
            } else {
                ResultKt.throwOnFailure(obj);
                z.y(0);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str = this.$actionId;
            switch (str.hashCode()) {
                case -1052216532:
                    if (str.equals("save_to_phone")) {
                        this.this$0.O(this.$posterBitmap);
                        z.y(4);
                        break;
                    }
                    break;
                case -844718236:
                    if (str.equals("avatar_switch_on")) {
                        this.this$0.M(1);
                        z.z(true);
                        break;
                    }
                    break;
                case -791575966:
                    if (str.equals("weixin")) {
                        OnlineStatusShareHelper onlineStatusShareHelper = this.this$0;
                        Bitmap bitmap = this.$posterBitmap;
                        this.label = 3;
                        S = onlineStatusShareHelper.S(bitmap, true, true, this);
                        if (S == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z.y(1);
                        break;
                    }
                    break;
                case -416461686:
                    if (str.equals("avatar_switch_off")) {
                        this.this$0.M(2);
                        z.z(false);
                        break;
                    }
                    break;
                case -393543490:
                    if (str.equals("qqfriend")) {
                        OnlineStatusShareHelper onlineStatusShareHelper2 = this.this$0;
                        Bitmap bitmap2 = this.$posterBitmap;
                        this.label = 1;
                        Q = onlineStatusShareHelper2.Q(bitmap2, true, this);
                        if (Q == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z.y(0);
                        break;
                    }
                    break;
                case -304161157:
                    if (str.equals("qzoneshuoshuo")) {
                        OnlineStatusShareHelper onlineStatusShareHelper3 = this.this$0;
                        Bitmap bitmap3 = this.$posterBitmap;
                        this.label = 2;
                        R = onlineStatusShareHelper3.R(bitmap3, this);
                        if (R == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z.y(2);
                        break;
                    }
                    break;
                case 154627506:
                    if (str.equals("weixincircle")) {
                        OnlineStatusShareHelper onlineStatusShareHelper4 = this.this$0;
                        Bitmap bitmap4 = this.$posterBitmap;
                        this.label = 4;
                        S2 = onlineStatusShareHelper4.S(bitmap4, false, true, this);
                        if (S2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z.y(3);
                        break;
                    }
                    break;
                case 1050790300:
                    if (str.equals("favorite")) {
                        OnlineStatusShareHelper onlineStatusShareHelper5 = this.this$0;
                        Bitmap bitmap5 = this.$posterBitmap;
                        this.label = 5;
                        x16 = onlineStatusShareHelper5.x(bitmap5, this);
                        if (x16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z.y(5);
                        break;
                    }
                    break;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$onSharePanelClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

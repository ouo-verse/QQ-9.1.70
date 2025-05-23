package com.tencent.mobileqq.troop.troopsetting.part;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.part.TroopSettingGroupInfoPart$initObserver$1", f = "TroopSettingGroupInfoPart.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopSettingGroupInfoPart$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopSettingGroupInfoPart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.troop.troopsetting.event.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopSettingGroupInfoPart f301272d;

        public a(TroopSettingGroupInfoPart troopSettingGroupInfoPart) {
            this.f301272d = troopSettingGroupInfoPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingGroupInfoPart);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.troop.troopsetting.event.a aVar, @NotNull Continuation<? super Unit> continuation) {
            TextView textView;
            com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
            }
            com.tencent.mobileqq.troop.troopsetting.event.a aVar2 = aVar;
            TextView textView2 = null;
            com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar2 = null;
            if (aVar2 instanceof a.af) {
                bVar = this.f301272d.troopInfoProfileConfig;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopInfoProfileConfig");
                } else {
                    bVar2 = bVar;
                }
                ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).updateRedPoint(((a.af) aVar2).a(), (TextView) bVar2.K().findViewById(R.id.i_f));
            } else if (aVar2 instanceof a.y) {
                this.f301272d.ra(((a.y) aVar2).a());
            } else if (aVar2 instanceof a.ad) {
                this.f301272d.sa(((a.ad) aVar2).a());
            } else if (aVar2 instanceof a.n) {
                this.f301272d.la();
            } else if (aVar2 instanceof a.g) {
                String str = this.f301272d.B9().T2().mRichFingerMemo;
                if (!TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026                        }");
                } else {
                    str = ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026                        }");
                }
                textView = this.f301272d.subTitleView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
                } else {
                    textView2 = textView;
                }
                textView2.setText(new QQText(str, 11, 16));
            } else if (aVar2 instanceof a.l) {
                this.f301272d.ia(((a.l) aVar2).a());
            } else if (aVar2 instanceof a.m) {
                AvatarInfoCheck.c(4, this.f301272d.B9().T2().troopUin, 0, "troopSettingIntent updateAvatarEntry");
            } else if (aVar2 instanceof a.v) {
                this.f301272d.pa();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSettingGroupInfoPart$initObserver$1(TroopSettingGroupInfoPart troopSettingGroupInfoPart, Continuation<? super TroopSettingGroupInfoPart$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSettingGroupInfoPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingGroupInfoPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSettingGroupInfoPart$initObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
                StateFlow<com.tencent.mobileqq.troop.troopsetting.event.a> V2 = this.this$0.B9().V2();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (V2.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSettingGroupInfoPart$initObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

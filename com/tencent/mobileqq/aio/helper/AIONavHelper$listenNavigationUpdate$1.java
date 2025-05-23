package com.tencent.mobileqq.aio.helper;

import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u008a@"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", "Lkotlin/collections/ArrayList;", "boxInfo", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.helper.AIONavHelper$listenNavigationUpdate$1", f = "AIONavHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class AIONavHelper$listenNavigationUpdate$1 extends SuspendLambda implements Function2<ArrayList<ContactMsgBoxInfo>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $curUid;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIONavHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIONavHelper$listenNavigationUpdate$1(String str, AIONavHelper aIONavHelper, Continuation<? super AIONavHelper$listenNavigationUpdate$1> continuation) {
        super(2, continuation);
        this.$curUid = str;
        this.this$0 = aIONavHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, aIONavHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIONavHelper$listenNavigationUpdate$1 aIONavHelper$listenNavigationUpdate$1 = new AIONavHelper$listenNavigationUpdate$1(this.$curUid, this.this$0, continuation);
        aIONavHelper$listenNavigationUpdate$1.L$0 = obj;
        return aIONavHelper$listenNavigationUpdate$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList<ContactMsgBoxInfo> arrayList = (ArrayList) this.L$0;
                String str = this.$curUid;
                final AIONavHelper aIONavHelper = this.this$0;
                for (final ContactMsgBoxInfo contactMsgBoxInfo : arrayList) {
                    if (Intrinsics.areEqual(contactMsgBoxInfo.contact.peerUid, str)) {
                        QLog.d("AIONavHelper", 1, "listenNavigationUpdate contactMsgBoxChanged");
                        com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(contactMsgBoxInfo) { // from class: com.tencent.mobileqq.aio.helper.AIONavHelper$listenNavigationUpdate$1$1$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ContactMsgBoxInfo $msgBox;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$msgBox = contactMsgBoxInfo;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONavHelper.this, (Object) contactMsgBoxInfo);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                com.tencent.aio.api.runtime.a aVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                aVar = AIONavHelper.this.mContext;
                                if (aVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    aVar = null;
                                }
                                aVar.e().h(new AIOReserve1CreateModelIntent("aio_navigation", new NavigationMsgIntent.UpdateNavigation(this.$msgBox, false)));
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ArrayList<ContactMsgBoxInfo> arrayList, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIONavHelper$listenNavigationUpdate$1) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) continuation);
    }
}

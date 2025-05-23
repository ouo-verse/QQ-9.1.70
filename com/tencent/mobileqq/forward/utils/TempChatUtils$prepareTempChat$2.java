package com.tencent.mobileqq.forward.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.interceptor.g;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.forward.utils.TempChatUtils$prepareTempChat$2", f = "TempChatUtils.kt", i = {0}, l = {86}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class TempChatUtils$prepareTempChat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ List<SessionInfo> $tempChats;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.forward.utils.TempChatUtils$prepareTempChat$2$2", f = "TempChatUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.forward.utils.TempChatUtils$prepareTempChat$2$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Function0<Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$callback.invoke();
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TempChatUtils$prepareTempChat$2(List<SessionInfo> list, Activity activity, Function0<Unit> function0, Continuation<? super TempChatUtils$prepareTempChat$2> continuation) {
        super(2, continuation);
        this.$tempChats = list;
        this.$activity = activity;
        this.$callback = function0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, activity, function0, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TempChatUtils$prepareTempChat$2 tempChatUtils$prepareTempChat$2 = new TempChatUtils$prepareTempChat$2(this.$tempChats, this.$activity, this.$callback, continuation);
        tempChatUtils$prepareTempChat$2.L$0 = obj;
        return tempChatUtils$prepareTempChat$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ad, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0097 -> B:13:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00ec -> B:12:0x00ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f3 -> B:13:0x00f5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TempChatUtils$prepareTempChat$2 tempChatUtils$prepareTempChat$2;
        CoroutineScope coroutineScope;
        Iterator it;
        Activity activity;
        boolean z16;
        Object obj2;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    it = (Iterator) this.L$2;
                    Activity activity2 = (Activity) this.L$1;
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tempChatUtils$prepareTempChat$2 = this;
                    Object b16 = obj;
                    activity = activity2;
                    coroutineScope = coroutineScope2;
                    if (it.hasNext()) {
                        SessionInfo sessionInfo = (SessionInfo) it.next();
                        String str = sessionInfo.f178172i0;
                        boolean z17 = false;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            QLog.d("TempChatUtils", 1, "prepareTempChat uid isNullOrEmpty");
                            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(sessionInfo.f179557e);
                        }
                        String str2 = str;
                        if (str2 == null || str2.length() == 0) {
                            z17 = true;
                        }
                        if (z17) {
                            QLog.d("TempChatUtils", 1, "prepareTempChat uid is still null");
                        } else {
                            int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
                            Bundle bundle = new Bundle();
                            String str3 = sessionInfo.f179559f;
                            if (str3 != null && longOrNull != null) {
                                obj2 = coroutine_suspended;
                                long longValue = longOrNull.longValue();
                                QLog.d("TempChatUtils", 1, "prepareTempChat troopUin not null");
                                bundle.putLong("key_groupUin", longValue);
                            } else {
                                obj2 = coroutine_suspended;
                            }
                            g a16 = com.tencent.qqnt.aio.interceptor.a.f351159a.a(l3);
                            if (a16 != null) {
                                String str4 = sessionInfo.f179563i;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                tempChatUtils$prepareTempChat$2.L$0 = coroutineScope;
                                tempChatUtils$prepareTempChat$2.L$1 = activity;
                                tempChatUtils$prepareTempChat$2.L$2 = it;
                                tempChatUtils$prepareTempChat$2.label = 1;
                                b16 = a16.b(activity, l3, str2, str4, bundle, tempChatUtils$prepareTempChat$2);
                                coroutine_suspended = obj2;
                                if (b16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                activity2 = activity;
                                coroutineScope2 = coroutineScope;
                                activity = activity2;
                                coroutineScope = coroutineScope2;
                            } else {
                                coroutine_suspended = obj2;
                            }
                        }
                        if (it.hasNext()) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(tempChatUtils$prepareTempChat$2.$callback, null), 2, null);
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                QLog.d("TempChatUtils", 1, "prepareTempChat interceptStartAIO");
                List<SessionInfo> list = this.$tempChats;
                Activity activity3 = this.$activity;
                tempChatUtils$prepareTempChat$2 = this;
                coroutineScope = coroutineScope3;
                it = list.iterator();
                activity = activity3;
                if (it.hasNext()) {
                }
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TempChatUtils$prepareTempChat$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

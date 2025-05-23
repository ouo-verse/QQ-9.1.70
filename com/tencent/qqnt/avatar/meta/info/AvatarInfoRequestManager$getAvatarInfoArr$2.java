package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager$getAvatarInfoArr$2", f = "AvatarInfoRequestManager.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"index"}, s = {"I$1"})
/* loaded from: classes23.dex */
public final class AvatarInfoRequestManager$getAvatarInfoArr$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.avatar.meta.a $avatarBean;
    final /* synthetic */ a[] $avatarInfoArr;
    final /* synthetic */ List<com.tencent.qqnt.avatar.meta.a> $beanList;
    final /* synthetic */ Ref.BooleanRef $hasEmptyInfo;
    final /* synthetic */ boolean $skipMemory;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager$getAvatarInfoArr$2$1", f = "AvatarInfoRequestManager.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager$getAvatarInfoArr$2$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a[]>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ com.tencent.qqnt.avatar.meta.a $bean;
        final /* synthetic */ boolean $skipMemory;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.tencent.qqnt.avatar.meta.a aVar, boolean z16, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bean = aVar;
            this.$skipMemory = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Boolean.valueOf(z16), continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$bean, this.$skipMemory, continuation);
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
                    AvatarInfoRequestManager avatarInfoRequestManager = AvatarInfoRequestManager.f352916a;
                    com.tencent.qqnt.avatar.meta.a aVar = this.$bean;
                    boolean z16 = this.$skipMemory;
                    this.label = 1;
                    obj = avatarInfoRequestManager.e(aVar, z16, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super a[]> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarInfoRequestManager$getAvatarInfoArr$2(List<? extends com.tencent.qqnt.avatar.meta.a> list, Ref.BooleanRef booleanRef, com.tencent.qqnt.avatar.meta.a aVar, a[] aVarArr, boolean z16, Continuation<? super AvatarInfoRequestManager$getAvatarInfoArr$2> continuation) {
        super(2, continuation);
        this.$beanList = list;
        this.$hasEmptyInfo = booleanRef;
        this.$avatarBean = aVar;
        this.$avatarInfoArr = aVarArr;
        this.$skipMemory = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, booleanRef, aVar, aVarArr, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AvatarInfoRequestManager$getAvatarInfoArr$2 avatarInfoRequestManager$getAvatarInfoArr$2 = new AvatarInfoRequestManager$getAvatarInfoArr$2(this.$beanList, this.$hasEmptyInfo, this.$avatarBean, this.$avatarInfoArr, this.$skipMemory, continuation);
        avatarInfoRequestManager$getAvatarInfoArr$2.L$0 = obj;
        return avatarInfoRequestManager$getAvatarInfoArr$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008d -> B:12:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Iterator it;
        int i3;
        AvatarInfoRequestManager$getAvatarInfoArr$2 avatarInfoRequestManager$getAvatarInfoArr$2;
        Deferred async$default;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 != 0) {
                if (i16 == 1) {
                    int i17 = this.I$1;
                    int i18 = this.I$0;
                    Iterator it5 = (Iterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Iterator it6 = it5;
                    int i19 = i18;
                    int i26 = i17;
                    Object obj2 = coroutine_suspended;
                    AvatarInfoRequestManager$getAvatarInfoArr$2 avatarInfoRequestManager$getAvatarInfoArr$22 = this;
                    a[] aVarArr = (a[]) obj;
                    if (aVarArr != null) {
                        if (aVarArr.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            avatarInfoRequestManager$getAvatarInfoArr$22.$avatarInfoArr[i26] = aVarArr[0];
                            avatarInfoRequestManager$getAvatarInfoArr$2 = avatarInfoRequestManager$getAvatarInfoArr$22;
                            coroutine_suspended = obj2;
                            i3 = i19;
                            it = it6;
                            if (it.hasNext()) {
                                int i27 = i3 + 1;
                                Deferred deferred = (Deferred) it.next();
                                avatarInfoRequestManager$getAvatarInfoArr$2.L$0 = it;
                                avatarInfoRequestManager$getAvatarInfoArr$2.I$0 = i27;
                                avatarInfoRequestManager$getAvatarInfoArr$2.I$1 = i3;
                                avatarInfoRequestManager$getAvatarInfoArr$2.label = 1;
                                Object await = deferred.await(avatarInfoRequestManager$getAvatarInfoArr$2);
                                if (await == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Object obj3 = coroutine_suspended;
                                avatarInfoRequestManager$getAvatarInfoArr$22 = avatarInfoRequestManager$getAvatarInfoArr$2;
                                obj = await;
                                it6 = it;
                                i19 = i27;
                                i26 = i3;
                                obj2 = obj3;
                                a[] aVarArr2 = (a[]) obj;
                                if (aVarArr2 != null) {
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    avatarInfoRequestManager$getAvatarInfoArr$22.$hasEmptyInfo.element = true;
                    com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoRequestManager", "getAvatarInfoArr hasEmptyInfo " + avatarInfoRequestManager$getAvatarInfoArr$22.$avatarBean.c() + " " + i26);
                    avatarInfoRequestManager$getAvatarInfoArr$2 = avatarInfoRequestManager$getAvatarInfoArr$22;
                    coroutine_suspended = obj2;
                    i3 = i19;
                    it = it6;
                    if (it.hasNext()) {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ArrayList arrayList = new ArrayList();
                Iterator<com.tencent.qqnt.avatar.meta.a> it7 = this.$beanList.iterator();
                while (it7.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(it7.next(), this.$skipMemory, null), 3, null);
                    arrayList.add(async$default);
                }
                it = arrayList.iterator();
                i3 = 0;
                avatarInfoRequestManager$getAvatarInfoArr$2 = this;
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AvatarInfoRequestManager$getAvatarInfoArr$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

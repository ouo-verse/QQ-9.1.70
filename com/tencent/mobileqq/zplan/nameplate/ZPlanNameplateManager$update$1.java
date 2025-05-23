package com.tencent.mobileqq.zplan.nameplate;

import android.net.Uri;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager$update$1", f = "ZPlanNameplateManager.kt", i = {0, 0, 0}, l = {83, 108}, m = "invokeSuspend", n = {"business", "iconFile", "retryTimes"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes34.dex */
final class ZPlanNameplateManager$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clickJumpTo;
    final /* synthetic */ Integer $nameplateId;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ZPlanNameplateManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager$update$1$1", f = "ZPlanNameplateManager.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager$update$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends UpdateListenerParams>>, Object> {
        final /* synthetic */ f $business;
        final /* synthetic */ Integer $nameplateId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(f fVar, Integer num, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$business = fVar;
            this.$nameplateId = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$business, this.$nameplateId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Boolean, ? extends UpdateListenerParams>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<Boolean, ? extends UpdateListenerParams>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                f fVar = this.$business;
                int intValue = this.$nameplateId.intValue();
                this.label = 1;
                obj = g.a(fVar, intValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, ? extends UpdateListenerParams>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager$update$1$2", f = "ZPlanNameplateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager$update$1$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clickJumpTo;
        final /* synthetic */ Ref.ObjectRef<File> $iconFile;
        final /* synthetic */ Integer $nameplateId;
        int label;
        final /* synthetic */ ZPlanNameplateManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ZPlanNameplateManager zPlanNameplateManager, String str, Ref.ObjectRef<File> objectRef, Integer num, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = zPlanNameplateManager;
            this.$clickJumpTo = str;
            this.$iconFile = objectRef;
            this.$nameplateId = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$clickJumpTo, this.$iconFile, this.$nameplateId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Uri uri;
            List listOf;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanNameplateManager zPlanNameplateManager = this.this$0;
                if (this.$clickJumpTo.length() > 0) {
                    byte[] bytes = this.$clickJumpTo.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    uri = Uri.parse("mqqapi://forward/url?src_type=web&version=1&url_prefix=" + PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0));
                } else {
                    uri = null;
                }
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new Nameplate(uri, this.$iconFile.element, this.$nameplateId.intValue()));
                zPlanNameplateManager.d(new Nameplates(listOf));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanNameplateManager$update$1(Integer num, ZPlanNameplateManager zPlanNameplateManager, String str, Continuation<? super ZPlanNameplateManager$update$1> continuation) {
        super(2, continuation);
        this.$nameplateId = num;
        this.this$0 = zPlanNameplateManager;
        this.$clickJumpTo = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanNameplateManager$update$1(this.$nameplateId, this.this$0, this.$clickJumpTo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanNameplateManager$update$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Type inference failed for: r7v17, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.io.File] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0091 -> B:12:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ZPlanNameplateManager$update$1 zPlanNameplateManager$update$1;
        f fVar;
        int i3;
        Ref.ObjectRef objectRef;
        T t16;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 2;
        int i18 = 1;
        Continuation continuation = null;
        String str2 = 0;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            f fVar2 = (f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(f.class);
            if (fVar2 == null) {
                QLog.e("ZPlanNameplateManager", 1, "business == null");
                return Unit.INSTANCE;
            }
            if (fVar2.i(this.$nameplateId.intValue())) {
                return Unit.INSTANCE;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = f.g(fVar2, this.$nameplateId.intValue(), null, 2, null);
            zPlanNameplateManager$update$1 = this;
            fVar = fVar2;
            i3 = 1;
            objectRef = objectRef2;
            if (i3 >= i17) {
            }
            t16 = objectRef.element;
            if (t16 == 0) {
            }
            boolean isFileExists = fVar.isFileExists(zPlanNameplateManager$update$1.$nameplateId.intValue());
            File file = (File) objectRef.element;
            if (file != null) {
            }
            QLog.e("ZPlanNameplateManager", 1, "\u627e\u4e0d\u5230png\u94ed\u724c\u56fe\u6807 isFileExists=" + isFileExists + " iconFile.exists=" + (file != null ? Boxing.boxBoolean(file.exists()) : null));
            return Unit.INSTANCE;
        }
        if (i16 != 1) {
            if (i16 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = this.I$0;
        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) this.L$1;
        fVar = (f) this.L$0;
        ResultKt.throwOnFailure(obj);
        zPlanNameplateManager$update$1 = this;
        objectRef = objectRef3;
        Object withTimeoutOrNull = obj;
        Pair pair = (Pair) withTimeoutOrNull;
        if (pair == null) {
            pair = TuplesKt.to(Boxing.boxBoolean(false), str2);
        }
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        UpdateListenerParams updateListenerParams = (UpdateListenerParams) pair.component2();
        if (booleanValue) {
            objectRef.element = f.g(fVar, zPlanNameplateManager$update$1.$nameplateId.intValue(), str2, i17, str2);
        } else {
            if (updateListenerParams != null) {
                str = "\u4e0b\u8f7d\u5931\u8d25 t=" + i3 + " errorCode=" + updateListenerParams.mErrorCode + " errorMsg=" + updateListenerParams.mErrorMessage + " httpCode=" + updateListenerParams.mHttpCode + " pgs=" + updateListenerParams.mProgress + " pgsMax=" + updateListenerParams.mProgressMax + " pgsRate=" + updateListenerParams.mProgressRate + " ";
            } else {
                str = "\u4e0b\u8f7d\u8d85\u65f6(10s)";
            }
            QLog.e("ZPlanNameplateManager", 1, str);
        }
        i3++;
        i17 = 2;
        i18 = 1;
        continuation = null;
        if (i3 >= i17 && objectRef.element == 0) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fVar, zPlanNameplateManager$update$1.$nameplateId, continuation);
            zPlanNameplateManager$update$1.L$0 = fVar;
            zPlanNameplateManager$update$1.L$1 = objectRef;
            zPlanNameplateManager$update$1.I$0 = i3;
            zPlanNameplateManager$update$1.label = i18;
            withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(10000L, anonymousClass1, zPlanNameplateManager$update$1);
            str2 = continuation;
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            Pair pair2 = (Pair) withTimeoutOrNull;
            if (pair2 == null) {
            }
            boolean booleanValue2 = ((Boolean) pair2.component1()).booleanValue();
            UpdateListenerParams updateListenerParams2 = (UpdateListenerParams) pair2.component2();
            if (booleanValue2) {
            }
            i3++;
            i17 = 2;
            i18 = 1;
            continuation = null;
            if (i3 >= i17) {
            }
            t16 = objectRef.element;
            if (t16 == 0) {
            }
            boolean isFileExists2 = fVar.isFileExists(zPlanNameplateManager$update$1.$nameplateId.intValue());
            File file2 = (File) objectRef.element;
            if (file2 != null) {
            }
            QLog.e("ZPlanNameplateManager", 1, "\u627e\u4e0d\u5230png\u94ed\u724c\u56fe\u6807 isFileExists=" + isFileExists2 + " iconFile.exists=" + (file2 != null ? Boxing.boxBoolean(file2.exists()) : null));
            return Unit.INSTANCE;
        }
        t16 = objectRef.element;
        if (t16 == 0 && ((File) t16).exists()) {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(zPlanNameplateManager$update$1.this$0, zPlanNameplateManager$update$1.$clickJumpTo, objectRef, zPlanNameplateManager$update$1.$nameplateId, null);
            zPlanNameplateManager$update$1.L$0 = null;
            zPlanNameplateManager$update$1.L$1 = null;
            zPlanNameplateManager$update$1.label = 2;
            if (BuildersKt.withContext(main, anonymousClass2, zPlanNameplateManager$update$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        boolean isFileExists22 = fVar.isFileExists(zPlanNameplateManager$update$1.$nameplateId.intValue());
        File file22 = (File) objectRef.element;
        QLog.e("ZPlanNameplateManager", 1, "\u627e\u4e0d\u5230png\u94ed\u724c\u56fe\u6807 isFileExists=" + isFileExists22 + " iconFile.exists=" + (file22 != null ? Boxing.boxBoolean(file22.exists()) : null));
        return Unit.INSTANCE;
    }
}

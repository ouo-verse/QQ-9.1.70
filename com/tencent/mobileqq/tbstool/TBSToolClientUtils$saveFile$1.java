package com.tencent.mobileqq.tbstool;

import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.tbstool.TBSToolClientUtils$saveFile$1", f = "TBSToolClientUtils.kt", i = {}, l = {194, 220}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class TBSToolClientUtils$saveFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Object $callback;
    final /* synthetic */ Function1<FileManagerEntity, Unit> $newSaveCallback;
    final /* synthetic */ long $sessionId;
    final /* synthetic */ String $srcFileName;
    final /* synthetic */ String $tempFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.tbstool.TBSToolClientUtils$saveFile$1$1", f = "TBSToolClientUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.tbstool.TBSToolClientUtils$saveFile$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Object $callback;
        final /* synthetic */ Entity $entity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Entity entity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = obj;
            this.$entity = entity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, entity, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$callback, this.$entity, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TBSToolClientUtils tBSToolClientUtils = TBSToolClientUtils.f291401a;
                    Object obj2 = this.$callback;
                    String filePath = ((FileManagerEntity) this.$entity).getFilePath();
                    Intrinsics.checkNotNullExpressionValue(filePath, "entity.filePath");
                    tBSToolClientUtils.l(obj2, false, filePath, ((FileManagerEntity) this.$entity).nSessionId);
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.tbstool.TBSToolClientUtils$saveFile$1$2", f = "TBSToolClientUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.tbstool.TBSToolClientUtils$saveFile$1$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Object $callback;
        final /* synthetic */ Function1<FileManagerEntity, Unit> $newSaveCallback;
        final /* synthetic */ FileManagerEntity $saveEntity;
        final /* synthetic */ String $saveFilePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, String str, FileManagerEntity fileManagerEntity, Function1<? super FileManagerEntity, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = obj;
            this.$saveFilePath = str;
            this.$saveEntity = fileManagerEntity;
            this.$newSaveCallback = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, str, fileManagerEntity, function1, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.$callback, this.$saveFilePath, this.$saveEntity, this.$newSaveCallback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TBSToolClientUtils.f291401a.l(this.$callback, true, this.$saveFilePath, this.$saveEntity.nSessionId);
                    Function1<FileManagerEntity, Unit> function1 = this.$newSaveCallback;
                    if (function1 != null) {
                        function1.invoke(this.$saveEntity);
                        return Unit.INSTANCE;
                    }
                    return null;
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
    public TBSToolClientUtils$saveFile$1(long j3, String str, String str2, Object obj, Function1<? super FileManagerEntity, Unit> function1, Continuation<? super TBSToolClientUtils$saveFile$1> continuation) {
        super(2, continuation);
        this.$sessionId = j3;
        this.$tempFilePath = str;
        this.$srcFileName = str2;
        this.$callback = obj;
        this.$newSaveCallback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, str2, obj, function1, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TBSToolClientUtils$saveFile$1(this.$sessionId, this.$tempFilePath, this.$srcFileName, this.$callback, this.$newSaveCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String o16;
        String v3;
        FileManagerEntity p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1 && i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                QLog.d("TBSToolClientFileUtils", 1, "saveFile sessionId: " + this.$sessionId);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return Unit.INSTANCE;
                }
                Entity find = DBMethodProxy.find(peekAppRuntime.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(this.$sessionId));
                boolean z16 = find instanceof FileManagerEntity;
                if (z16) {
                    FileManagerEntity fileManagerEntity = (FileManagerEntity) find;
                    if (fileManagerEntity.isDuplicateFile) {
                        QLog.d("TBSToolClientFileUtils", 1, "saveFile cover origin file");
                        FileUtils.copyFile(this.$tempFilePath, fileManagerEntity.getFilePath(), true);
                        fileManagerEntity.srvTime = NetConnInfoCenter.getServerTimeMillis();
                        ((IQQFileDataCenter) peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "")).updateTBSToolFileEntity(fileManagerEntity);
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$callback, find, null);
                        this.label = 1;
                        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                QLog.d("TBSToolClientFileUtils", 1, "saveFile new save file");
                TBSToolClientUtils tBSToolClientUtils = TBSToolClientUtils.f291401a;
                o16 = tBSToolClientUtils.o(this.$tempFilePath, this.$srcFileName);
                v3 = tBSToolClientUtils.v(o16);
                FileUtils.copyFile(this.$tempFilePath, v3, true);
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "ar.getRuntimeService(IQQ\u2026va, ProcessConstant.MAIN)");
                IQQFileDataCenter iQQFileDataCenter = (IQQFileDataCenter) runtimeService;
                if (!z16) {
                    p16 = tBSToolClientUtils.p(peekAppRuntime, v3);
                } else {
                    FileManagerEntity fileManagerEntity2 = (FileManagerEntity) find;
                    QLog.d("TBSToolClientFileUtils", 1, "saveFile update old origin entity path: " + fileManagerEntity2.duplicateFilePath);
                    p16 = tBSToolClientUtils.q(fileManagerEntity2, v3);
                    fileManagerEntity2.duplicateFilePath = v3;
                    fileManagerEntity2.duplicateEntitySessionId = p16.nSessionId;
                    iQQFileDataCenter.updateFileEntity(fileManagerEntity2);
                }
                FileManagerEntity fileManagerEntity3 = p16;
                iQQFileDataCenter.insertTBSToolFileEntity(fileManagerEntity3);
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, v3, fileManagerEntity3, this.$newSaveCallback, null);
                this.label = 2;
                if (BuildersKt.withContext(main2, anonymousClass2, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TBSToolClientUtils$saveFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

package com.tencent.mobileqq.tbstool;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tbstool.TBSToolClientUtils$checkNewestCopyFile$1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.tbstool.TBSToolClientUtils$checkNewestCopyFile$1", f = "TBSToolClientUtils.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class TBSToolClientUtils$checkNewestCopyFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ long $sessionId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.tbstool.TBSToolClientUtils$checkNewestCopyFile$1$1", f = "TBSToolClientUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.tbstool.TBSToolClientUtils$checkNewestCopyFile$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Activity $activity;
        final /* synthetic */ FileManagerEntity $entity;
        final /* synthetic */ String $scene;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, String str, FileManagerEntity fileManagerEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$scene = str;
            this.$entity = fileManagerEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, str, fileManagerEntity, continuation);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Activity activity, FileManagerEntity fileManagerEntity, String str, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).jumpToMyFile(activity, fileManagerEntity.nSessionId);
            c.f291412a.a(str);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$activity, this.$scene, this.$entity, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int k3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    QUIBottomToast.Companion companion = QUIBottomToast.INSTANCE;
                    final Activity activity = this.$activity;
                    final FileManagerEntity fileManagerEntity = this.$entity;
                    final String str = this.$scene;
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.tbstool.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TBSToolClientUtils$checkNewestCopyFile$1.AnonymousClass1.b(activity, fileManagerEntity, str, view);
                        }
                    };
                    TBSToolClientUtils tBSToolClientUtils = TBSToolClientUtils.f291401a;
                    Activity activity2 = this.$activity;
                    Intrinsics.checkNotNull(activity2);
                    k3 = tBSToolClientUtils.k(activity2);
                    companion.a(activity, 2, "\u6587\u6863\u6709\u6700\u65b0\u7f16\u8f91\u8fc7\u7684\u7248\u672c", "\u67e5\u770b", onClickListener, k3).n();
                    c.f291412a.b(this.$scene);
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
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBSToolClientUtils$checkNewestCopyFile$1(long j3, Activity activity, Continuation<? super TBSToolClientUtils$checkNewestCopyFile$1> continuation) {
        super(2, continuation);
        this.$sessionId = j3;
        this.$activity = activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), activity, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TBSToolClientUtils$checkNewestCopyFile$1(this.$sessionId, this.$activity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FileManagerEntity u16;
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
                u16 = TBSToolClientUtils.f291401a.u(this.$sessionId);
                if (u16 == null) {
                    return Unit.INSTANCE;
                }
                String fileSuffix = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileSuffix(u16.fileName);
                Intrinsics.checkNotNullExpressionValue(fileSuffix, "api(IFileManagerUtil::cl\u2026leSuffix(entity.fileName)");
                String lowerCase = fileSuffix.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$activity, lowerCase + "_newest_edit_file", u16, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TBSToolClientUtils$checkNewestCopyFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

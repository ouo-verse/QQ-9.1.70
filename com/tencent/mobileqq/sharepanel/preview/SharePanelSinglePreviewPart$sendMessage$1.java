package com.tencent.mobileqq.sharepanel.preview;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.IForwardMsgApi;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.p;
import com.tencent.mobileqq.sharepanel.util.ShareConfirmUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1", f = "SharePanelSinglePreviewPart.kt", i = {0, 0, 1, 1, 1}, l = {143, 153, 157}, m = "invokeSuspend", n = {EventKey.ACT, "targetList", EventKey.ACT, "targetList", "hasIntercept"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes18.dex */
public final class SharePanelSinglePreviewPart$sendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SharePanelContactItem $contact;
    final /* synthetic */ Intent $forwardIntent;
    final /* synthetic */ String $leaveMsg;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SharePanelSinglePreviewPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$1", f = "SharePanelSinglePreviewPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Ref.BooleanRef $hasIntercept;
        final /* synthetic */ String $leaveMsg;
        final /* synthetic */ ArrayList<ResultRecord> $targetList;
        int label;
        final /* synthetic */ SharePanelSinglePreviewPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, SharePanelSinglePreviewPart sharePanelSinglePreviewPart, ArrayList<ResultRecord> arrayList, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$hasIntercept = booleanRef;
            this.this$0 = sharePanelSinglePreviewPart;
            this.$targetList = arrayList;
            this.$leaveMsg = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, booleanRef, sharePanelSinglePreviewPart, arrayList, str, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$hasIntercept, this.this$0, this.$targetList, this.$leaveMsg, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef = this.$hasIntercept;
                    com.tencent.mobileqq.sharepanel.d g16 = this.this$0.F9().g();
                    boolean z16 = false;
                    if (g16 != null && g16.J(this.$targetList, this.$leaveMsg)) {
                        z16 = true;
                    }
                    booleanRef.element = z16;
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
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$2", f = "SharePanelSinglePreviewPart.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Activity $act;
        final /* synthetic */ Intent $forwardIntent;
        final /* synthetic */ Ref.BooleanRef $hasIntercept;
        final /* synthetic */ String $leaveMsg;
        final /* synthetic */ ArrayList<ResultRecord> $targetList;
        int label;
        final /* synthetic */ SharePanelSinglePreviewPart this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$2$1", f = "SharePanelSinglePreviewPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$sendMessage$1$2$1, reason: invalid class name */
        /* loaded from: classes18.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<ResultRecord> $targetList;
            int label;
            final /* synthetic */ SharePanelSinglePreviewPart this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SharePanelSinglePreviewPart sharePanelSinglePreviewPart, ArrayList<ResultRecord> arrayList, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = sharePanelSinglePreviewPart;
                this.$targetList = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, sharePanelSinglePreviewPart, arrayList, continuation);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                }
                return new AnonymousClass1(this.this$0, this.$targetList, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.mobileqq.sharepanel.b j3 = this.this$0.F9().j();
                        if (j3 != null) {
                            j3.a(true, this.$targetList);
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
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.BooleanRef booleanRef, SharePanelSinglePreviewPart sharePanelSinglePreviewPart, Intent intent, ArrayList<ResultRecord> arrayList, String str, Activity activity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$hasIntercept = booleanRef;
            this.this$0 = sharePanelSinglePreviewPart;
            this.$forwardIntent = intent;
            this.$targetList = arrayList;
            this.$leaveMsg = str;
            this.$act = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, booleanRef, sharePanelSinglePreviewPart, intent, arrayList, str, activity, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.$hasIntercept, this.this$0, this.$forwardIntent, this.$targetList, this.$leaveMsg, this.$act, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            com.tencent.mobileqq.sharepanel.forward.g gVar;
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
                    if (this.$hasIntercept.element) {
                        QLog.d("SharePanelSinglePreviewPart", 1, "sendMessage hasIntercept");
                        this.this$0.E9();
                        return Unit.INSTANCE;
                    }
                    Intent intent = new Intent(this.$forwardIntent);
                    intent.putExtra(AppConstants.Key.FORWARD_MULTI_TARGET, this.$targetList);
                    intent.putExtra("direct_show_msg", this.$leaveMsg);
                    intent.putExtra(AppConstants.Key.SHARE_REQ_FROM_NEW_PANEL, true);
                    ((IForwardMsgApi) QRoute.api(IForwardMsgApi.class)).directForwardMsg(this.$act, intent);
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$targetList, null);
                    this.label = 1;
                    if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                gVar = this.this$0.previewPanel;
                if (gVar != null) {
                    gVar.dismiss();
                }
                return Unit.INSTANCE;
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
    public SharePanelSinglePreviewPart$sendMessage$1(SharePanelSinglePreviewPart sharePanelSinglePreviewPart, SharePanelContactItem sharePanelContactItem, String str, Intent intent, Continuation<? super SharePanelSinglePreviewPart$sendMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = sharePanelSinglePreviewPart;
        this.$contact = sharePanelContactItem;
        this.$leaveMsg = str;
        this.$forwardIntent = intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sharePanelSinglePreviewPart, sharePanelContactItem, str, intent, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        SharePanelSinglePreviewPart$sendMessage$1 sharePanelSinglePreviewPart$sendMessage$1 = new SharePanelSinglePreviewPart$sendMessage$1(this.this$0, this.$contact, this.$leaveMsg, this.$forwardIntent, continuation);
        sharePanelSinglePreviewPart$sendMessage$1.L$0 = obj;
        return sharePanelSinglePreviewPart$sendMessage$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x011c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayListOf;
        Activity activity;
        Ref.BooleanRef booleanRef;
        ArrayList arrayList;
        Activity activity2;
        MainCoroutineDispatcher main;
        AnonymousClass2 anonymousClass2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) this.L$2;
                ArrayList arrayList2 = (ArrayList) this.L$1;
                Activity activity3 = (Activity) this.L$0;
                ResultKt.throwOnFailure(obj);
                booleanRef = booleanRef2;
                arrayList = arrayList2;
                activity2 = activity3;
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(booleanRef, this.this$0, this.$forwardIntent, arrayList, this.$leaveMsg, activity2, null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            arrayListOf = (ArrayList) this.L$1;
            Activity activity4 = (Activity) this.L$0;
            ResultKt.throwOnFailure(obj);
            activity = activity4;
        } else {
            ResultKt.throwOnFailure(obj);
            Activity activity5 = this.this$0.getActivity();
            if (activity5 != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ResultRecord(this.$contact.e(), this.$contact.b(), this.$contact.f(), this.$contact.a()));
                ShareConfirmUtil shareConfirmUtil = ShareConfirmUtil.f287597a;
                p x16 = this.this$0.F9().x();
                ShareConfirmAction.Forward forward = new ShareConfirmAction.Forward(arrayListOf);
                this.L$0 = activity5;
                this.L$1 = arrayListOf;
                this.label = 1;
                Object a16 = shareConfirmUtil.a(x16, forward, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                activity = activity5;
                obj2 = a16;
            } else {
                QLog.w("SharePanelSinglePreviewPart", 1, "sendMessage activity is null");
                return Unit.INSTANCE;
            }
        }
        if (!((Boolean) obj2).booleanValue()) {
            QLog.d("SharePanelSinglePreviewPart", 1, "sendMessage share confirm rejected");
            return Unit.INSTANCE;
        }
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        CoroutineDispatcher io5 = Dispatchers.getIO();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef3, this.this$0, arrayListOf, this.$leaveMsg, null);
        this.L$0 = activity;
        this.L$1 = arrayListOf;
        this.L$2 = booleanRef3;
        this.label = 2;
        if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        booleanRef = booleanRef3;
        arrayList = arrayListOf;
        activity2 = activity;
        main = Dispatchers.getMain();
        anonymousClass2 = new AnonymousClass2(booleanRef, this.this$0, this.$forwardIntent, arrayList, this.$leaveMsg, activity2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SharePanelSinglePreviewPart$sendMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

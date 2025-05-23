package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.FileTransferListVM$handleFileTransferEnd$1", f = "FileTransferListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class FileTransferListVM$handleFileTransferEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $elementId;
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ FileTransferListVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileTransferListVM$handleFileTransferEnd$1(FileTransferListVM fileTransferListVM, long j3, boolean z16, Continuation<? super FileTransferListVM$handleFileTransferEnd$1> continuation) {
        super(2, continuation);
        this.this$0 = fileTransferListVM;
        this.$elementId = j3;
        this.$success = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileTransferListVM, Long.valueOf(j3), Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new FileTransferListVM$handleFileTransferEnd$1(this.this$0, this.$elementId, this.$success, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.d().m().M();
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                long j3 = this.$elementId;
                boolean z17 = this.$success;
                int i16 = 0;
                for (Object obj2 : M) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj2;
                    if ((aVar instanceof FileMsgItem) && com.tencent.mobileqq.aio.utils.d.c0((AIOMsgItem) aVar)) {
                        FileMsgItem fileMsgItem = (FileMsgItem) aVar;
                        MsgElement q26 = fileMsgItem.q2();
                        if (q26 != null && q26.elementId == j3) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16 && fileMsgItem.A2() == 3) {
                            AIOMsgItem cloneNewInstance = fileMsgItem.cloneNewInstance();
                            Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.FileMsgItem");
                            FileMsgItem fileMsgItem2 = (FileMsgItem) cloneNewInstance;
                            if (z17) {
                                i3 = 4;
                            } else {
                                i3 = 5;
                            }
                            fileMsgItem2.K2(i3);
                            M.set(i16, (com.tencent.aio.data.msglist.a) fileMsgItem2);
                            booleanRef.element = true;
                        }
                    }
                    i16 = i17;
                }
                QLog.i("FileTransferListVM", 1, "[handleFileTransferEnd]: match is " + booleanRef.element);
                if (booleanRef.element) {
                    e.a(this.this$0, M, "file_transfer");
                }
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FileTransferListVM$handleFileTransferEnd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

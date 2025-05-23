package com.tencent.qqnt.chathistory.ui.file.c2c.adapter;

import android.app.Activity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.chathistory.ui.base.e;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.file.c2c.adapter.ChatHistoryFileAdapter$handleMultiDownload$1", f = "ChatHistoryFileAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryFileAdapter$handleMultiDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.BooleanRef $isAllFileDownloading;
    final /* synthetic */ List<FileItemModel> $itemModelList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryFileAdapter$handleMultiDownload$1(List<FileItemModel> list, Activity activity, Ref.BooleanRef booleanRef, Continuation<? super ChatHistoryFileAdapter$handleMultiDownload$1> continuation) {
        super(2, continuation);
        this.$itemModelList = list;
        this.$activity = activity;
        this.$isAllFileDownloading = booleanRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, activity, booleanRef, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ChatHistoryFileAdapter$handleMultiDownload$1(this.$itemModelList, this.$activity, this.$isAllFileDownloading, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<FileItemModel> list = this.$itemModelList;
                Activity activity = this.$activity;
                Ref.BooleanRef booleanRef = this.$isAllFileDownloading;
                for (FileItemModel fileItemModel : list) {
                    if (!Intrinsics.areEqual(fileItemModel.I(), e.a.f353346a) && ((!Intrinsics.areEqual(fileItemModel.I(), e.d.f353349a) || !fileItemModel.i()) && !fileItemModel.A())) {
                        IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) QRoute.api(IAIOFileManagerApi.class);
                        AIOMsgItem aIOMsgItem = new AIOMsgItem(fileItemModel.y());
                        long j3 = aIOMsgItem.getMsgRecord().msgId;
                        int i3 = aIOMsgItem.getMsgRecord().chatType;
                        int i16 = aIOMsgItem.getMsgRecord().sendType;
                        String str = aIOMsgItem.getMsgRecord().peerUid;
                        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
                        aIOMsgItem.O1(new MsgRecordParams(j3, i3, i16, str, aIOMsgItem.getMsgRecord().peerUin, null, 32, null));
                        Unit unit = Unit.INSTANCE;
                        iAIOFileManagerApi.downloadFile(activity, aIOMsgItem, ChatHistoryFileAdapter$handleMultiDownload$1$1$2.INSTANCE);
                        booleanRef.element = false;
                    }
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryFileAdapter", "downLoadOrUpLoad  downMedia");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryFileAdapter$handleMultiDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

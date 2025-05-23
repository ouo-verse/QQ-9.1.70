package com.tencent.qqnt.pluspanel.processor;

import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.pluspanel.processor.PictureOnClickProcessor$onAlbumResult$1", f = "PictureOnClickProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
final class PictureOnClickProcessor$onAlbumResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AlbumResult $albumResult;
    final /* synthetic */ com.tencent.aio.api.runtime.a $context;
    final /* synthetic */ List<LocalMediaInfo> $selectList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureOnClickProcessor$onAlbumResult$1(List<LocalMediaInfo> list, com.tencent.aio.api.runtime.a aVar, AlbumResult albumResult, Continuation<? super PictureOnClickProcessor$onAlbumResult$1> continuation) {
        super(2, continuation);
        this.$selectList = list;
        this.$context = aVar;
        this.$albumResult = albumResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, aVar, albumResult, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PictureOnClickProcessor$onAlbumResult$1(this.$selectList, this.$context, this.$albumResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        MsgIntent sendAlbumMixEvent;
        List list;
        List list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                Iterator<LocalMediaInfo> it = this.$selectList.iterator();
                while (it.hasNext()) {
                    arrayList.add(WrapLocalMediaInfoKt.d(WrapLocalMediaInfoKt.j(it.next())));
                }
                com.tencent.mvi.base.route.j e16 = this.$context.e();
                String a16 = this.$albumResult.a();
                if (a16 != null && a16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                    sendAlbumMixEvent = new AIOMsgSendEvent.SendAlbumMediaEvent(list2, this.$albumResult.g(), this.$albumResult.f());
                } else {
                    list = CollectionsKt___CollectionsKt.toList(arrayList);
                    boolean g16 = this.$albumResult.g();
                    String a17 = this.$albumResult.a();
                    Intrinsics.checkNotNull(a17);
                    sendAlbumMixEvent = new AIOMsgSendEvent.SendAlbumMixEvent(list, g16, a17);
                }
                e16.h(sendAlbumMixEvent);
                this.$context.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PictureOnClickProcessor", false, 2, null));
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PictureOnClickProcessor$onAlbumResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

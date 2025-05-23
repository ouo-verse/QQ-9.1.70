package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWVideoCompressHelper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$handleVideoItem$1", f = "PublishMediaEditManager.kt", i = {}, l = {257, 264}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class PublishMediaEditManager$handleVideoItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ h $info;
    final /* synthetic */ VideoItem $item;
    int label;
    final /* synthetic */ PublishMediaEditManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishMediaEditManager$handleVideoItem$1(VideoItem videoItem, PublishMediaEditManager publishMediaEditManager, h hVar, Continuation<? super PublishMediaEditManager$handleVideoItem$1> continuation) {
        super(2, continuation);
        this.$item = videoItem;
        this.this$0 = publishMediaEditManager;
        this.$info = hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, videoItem, publishMediaEditManager, hVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PublishMediaEditManager$handleVideoItem$1(this.$item, this.this$0, this.$info, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean H;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            H = this.this$0.H(this.$item.getFileSize());
                            if (!H) {
                                this.$item.setState(UploadOrDownloadState.VIDEO_INVALID_SIZE);
                                this.this$0.Z(this.$item);
                                return Unit.INSTANCE;
                            }
                            PublishMediaEditManager.V(this.this$0, this.$item, false, 2, null);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                this.$item.setState(UploadOrDownloadState.COMPRESSING);
                this.this$0.Z(this.$item);
                PublishMediaEditManager publishMediaEditManager = this.this$0;
                String b16 = this.$info.b();
                VideoItem videoItem = this.$item;
                this.label = 1;
                obj = publishMediaEditManager.J(b16, videoItem, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str == null) {
                this.this$0.O(this.$item);
                return Unit.INSTANCE;
            }
            this.$item.setPosterLocalPath(str);
            CoroutineScope M = this.this$0.M();
            final PublishMediaEditManager publishMediaEditManager2 = this.this$0;
            HWVideoCompressHelper hWVideoCompressHelper = new HWVideoCompressHelper(M, new Function1<BaseItem, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager$handleVideoItem$1$videoCompressHelper$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublishMediaEditManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                    invoke2(baseItem);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable BaseItem baseItem) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) baseItem);
                    } else if (baseItem != null) {
                        PublishMediaEditManager.this.Z(baseItem);
                    }
                }
            });
            VideoItem videoItem2 = this.$item;
            this.label = 2;
            obj = hWVideoCompressHelper.f(videoItem2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PublishMediaEditManager$handleVideoItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

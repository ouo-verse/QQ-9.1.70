package com.tencent.qqnt.compress.demo;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqnt.videoplay.api.view.SimpleVideoView;
import com.tencent.qqnt.compress.demo.CompressDemoActivity;
import com.tencent.qqnt.util.video.a;
import com.tencent.richmedia.videocompress.VideoConverter;
import java.io.File;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.compress.demo.CompressDemoActivity$compressVideo$1", f = "CompressDemoActivity.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"originVideoInfo", "compressedVideoInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes24.dex */
public final class CompressDemoActivity$compressVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ File $videoFile;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CompressDemoActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.compress.demo.CompressDemoActivity$compressVideo$1$1", f = "CompressDemoActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.compress.demo.CompressDemoActivity$compressVideo$1$1, reason: invalid class name */
    /* loaded from: classes24.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Ref.ObjectRef<a.C9706a> $compressedVideoInfo;
        final /* synthetic */ Ref.ObjectRef<a.C9706a> $originVideoInfo;
        final /* synthetic */ File $videoFile;
        int label;
        final /* synthetic */ CompressDemoActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<a.C9706a> objectRef, CompressDemoActivity compressDemoActivity, File file, Ref.ObjectRef<a.C9706a> objectRef2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$originVideoInfo = objectRef;
            this.this$0 = compressDemoActivity;
            this.$videoFile = file;
            this.$compressedVideoInfo = objectRef2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, objectRef, compressDemoActivity, file, objectRef2, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$originVideoInfo, this.this$0, this.$videoFile, this.$compressedVideoInfo, continuation);
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, com.tencent.qqnt.util.video.a$a] */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, com.tencent.qqnt.util.video.a$a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            File file;
            CompressDemoActivity.b bVar;
            CompressDemoActivity$videoProcessor$1 compressDemoActivity$videoProcessor$1;
            File file2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef<a.C9706a> objectRef = this.$originVideoInfo;
                    com.tencent.qqnt.util.video.a aVar = com.tencent.qqnt.util.video.a.f362991a;
                    file = this.this$0.originVideo;
                    File file3 = null;
                    if (file == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("originVideo");
                        file = null;
                    }
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "originVideo.absolutePath");
                    objectRef.element = aVar.a(absolutePath);
                    bVar = this.this$0.convertLogger;
                    VideoConverter videoConverter = new VideoConverter(bVar);
                    videoConverter.setCompressMode(1);
                    CompressDemoActivity compressDemoActivity = this.this$0;
                    String absolutePath2 = this.$videoFile.getAbsolutePath();
                    compressDemoActivity$videoProcessor$1 = this.this$0.videoProcessor;
                    videoConverter.startCompress(compressDemoActivity, absolutePath2, compressDemoActivity$videoProcessor$1, true);
                    Ref.ObjectRef<a.C9706a> objectRef2 = this.$compressedVideoInfo;
                    file2 = this.this$0.compressedVideo;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                    } else {
                        file3 = file2;
                    }
                    String absolutePath3 = file3.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "compressedVideo.absolutePath");
                    objectRef2.element = aVar.a(absolutePath3);
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
    public CompressDemoActivity$compressVideo$1(CompressDemoActivity compressDemoActivity, File file, Continuation<? super CompressDemoActivity$compressVideo$1> continuation) {
        super(2, continuation);
        this.this$0 = compressDemoActivity;
        this.$videoFile = file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, compressDemoActivity, file, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new CompressDemoActivity$compressVideo$1(this.this$0, this.$videoFile, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        File file;
        rw3.a aVar;
        rw3.a aVar2;
        rw3.a aVar3;
        File file2;
        rw3.a aVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                CoroutineDispatcher io5 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, this.this$0, this.$videoFile, objectRef3, null);
                this.L$0 = objectRef;
                this.L$1 = objectRef3;
                this.label = 1;
                if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef3;
            }
            CompressDemoActivity compressDemoActivity = this.this$0;
            file = compressDemoActivity.compressedVideo;
            rw3.a aVar5 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                file = null;
            }
            aVar = this.this$0.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            SimpleVideoView simpleVideoView = aVar.f432638f;
            Intrinsics.checkNotNullExpressionValue(simpleVideoView, "binding.compressVideo");
            compressDemoActivity.b3(file, simpleVideoView);
            aVar2 = this.this$0.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            TextView textView = aVar2.f432639g;
            aVar3 = this.this$0.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            CharSequence text = aVar3.f432639g.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.compressVideoPath.text");
            String obj2 = text.subSequence(0, 8).toString();
            file2 = this.this$0.compressedVideo;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressedVideo");
                file2 = null;
            }
            textView.setText(obj2 + file2.getAbsolutePath());
            aVar4 = this.this$0.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar5 = aVar4;
            }
            aVar5.f432634b.setText("\u538b\u7f29\u524d  " + objectRef.element + "\n\u538b\u7f29\u540e  " + objectRef2.element);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((CompressDemoActivity$compressVideo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

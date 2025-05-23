package com.tencent.mobileqq.aio.menu;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.impl.AIOEmoReplyMenuApiImpl;
import com.tencent.qqnt.aio.emoreply.h;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import cooperation.photoplus.sticker.Sticker;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.menu.EmoReplyAnimationUtil$createScaleAnimationView$1", f = "EmoReplyAnimationUtil.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"lottieFilePath"}, s = {"L$0"})
/* loaded from: classes10.dex */
final class EmoReplyAnimationUtil$createScaleAnimationView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FragmentActivity $act;
    final /* synthetic */ ImageView $animationImageView;
    final /* synthetic */ h $info;
    final /* synthetic */ ImageView $lottieImageView;
    final /* synthetic */ FrameLayout $parentLayout;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.menu.EmoReplyAnimationUtil$createScaleAnimationView$1$1", f = "EmoReplyAnimationUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.menu.EmoReplyAnimationUtil$createScaleAnimationView$1$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ h $info;
        final /* synthetic */ Ref.ObjectRef<String> $lottieFilePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(h hVar, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$info = hVar;
            this.$lottieFilePath = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, hVar, objectRef, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$info, this.$lottieFilePath, continuation);
        }

        /* JADX WARN: Type inference failed for: r6v12, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v16, types: [T, java.lang.Object, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MsgEmojiLikes d16 = this.$info.d();
                    if (d16 != null && (str = d16.emojiId) != null) {
                        Ref.ObjectRef<String> objectRef = this.$lottieFilePath;
                        AIOEmoReplyMenuApiImpl.Companion companion = AIOEmoReplyMenuApiImpl.INSTANCE;
                        File file = new File(companion.b() + str + Sticker.JSON_SUFFIX);
                        if (file.exists()) {
                            ?? absolutePath = file.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                            objectRef.element = absolutePath;
                        } else if (new File(companion.a()).exists()) {
                            objectRef.element = companion.a();
                        } else {
                            QLog.e("EmoReplyAnimationUtil", 1, "doScaleAnimation  no lottie json");
                        }
                        QLog.i("EmoReplyAnimationUtil", 1, "doScaleAnimation  filePath:" + ((Object) objectRef.element));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoReplyAnimationUtil$createScaleAnimationView$1(FrameLayout frameLayout, h hVar, FragmentActivity fragmentActivity, ImageView imageView, ImageView imageView2, Continuation<? super EmoReplyAnimationUtil$createScaleAnimationView$1> continuation) {
        super(2, continuation);
        this.$parentLayout = frameLayout;
        this.$info = hVar;
        this.$act = fragmentActivity;
        this.$animationImageView = imageView;
        this.$lottieImageView = imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, frameLayout, hVar, fragmentActivity, imageView, imageView2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new EmoReplyAnimationUtil$createScaleAnimationView$1(this.$parentLayout, this.$info, this.$act, this.$animationImageView, this.$lottieImageView, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16;
        Deferred p16;
        Ref.ObjectRef objectRef2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                if (f16 != null && (c16 = CorountineFunKt.c(f16, "EmoReplyAnimationUtil", null, null, new AnonymousClass1(this.$info, objectRef, null), 6, null)) != null && (p16 = c16.p()) != null) {
                    this.L$0 = objectRef;
                    this.label = 1;
                    Object await = p16.await(this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef;
                    obj = await;
                }
                float a16 = ((-l.b(100)) / 2) + (l.a(20.0f) / 2);
                this.$parentLayout.setX(this.$info.c()[0] + a16);
                this.$parentLayout.setY(this.$info.c()[1] + a16);
                EmoReplyAnimationUtil.f189971a.l(this.$act, this.$animationImageView, this.$lottieImageView, (String) objectRef.element);
                return Unit.INSTANCE;
            }
            objectRef = objectRef2;
            float a162 = ((-l.b(100)) / 2) + (l.a(20.0f) / 2);
            this.$parentLayout.setX(this.$info.c()[0] + a162);
            this.$parentLayout.setY(this.$info.c()[1] + a162);
            EmoReplyAnimationUtil.f189971a.l(this.$act, this.$animationImageView, this.$lottieImageView, (String) objectRef.element);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((EmoReplyAnimationUtil$createScaleAnimationView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

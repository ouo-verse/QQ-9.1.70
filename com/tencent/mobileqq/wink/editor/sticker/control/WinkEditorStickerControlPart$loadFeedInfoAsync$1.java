package com.tencent.mobileqq.wink.editor.sticker.control;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$loadFeedInfoAsync$1;
import com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$loadFeedInfoAsync$1", f = "WinkEditorStickerControlPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorStickerControlPart$loadFeedInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $avatarView;
    final /* synthetic */ TextView $nameView;
    int label;
    final /* synthetic */ WinkEditorStickerControlPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/model/c;", ITVKPlayerEventListener.KEY_USER_INFO, "", "invoke", "(Lcom/tencent/mobileqq/wink/editor/model/c;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.control.WinkEditorStickerControlPart$loadFeedInfoAsync$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<WinkUserInfo, Unit> {
        final /* synthetic */ ImageView $avatarView;
        final /* synthetic */ TextView $nameView;
        final /* synthetic */ WinkEditorStickerControlPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WinkEditorStickerControlPart winkEditorStickerControlPart, TextView textView, ImageView imageView) {
            super(1);
            this.this$0 = winkEditorStickerControlPart;
            this.$nameView = textView;
            this.$avatarView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkUserInfo winkUserInfo, TextView nameView, Bitmap bitmap, ImageView avatarView) {
            String nickName;
            boolean z16;
            Intrinsics.checkNotNullParameter(nameView, "$nameView");
            Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
            boolean z17 = false;
            if (winkUserInfo != null && (nickName = winkUserInfo.getNickName()) != null) {
                if (nickName.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                nameView.setText("@" + winkUserInfo.getNickName());
            }
            if (bitmap != null) {
                avatarView.setImageBitmap(bitmap);
            } else {
                avatarView.setImageResource(R.drawable.ntp);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WinkUserInfo winkUserInfo) {
            invoke2(winkUserInfo);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable final WinkUserInfo winkUserInfo) {
            String logoLocalPath;
            boolean z16 = false;
            if (winkUserInfo != null && (logoLocalPath = winkUserInfo.getLogoLocalPath()) != null) {
                if (logoLocalPath.length() > 0) {
                    z16 = true;
                }
            }
            final Bitmap Va = z16 ? this.this$0.Va(winkUserInfo.getLogoLocalPath()) : null;
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final TextView textView = this.$nameView;
            final ImageView imageView = this.$avatarView;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.control.aa
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorStickerControlPart$loadFeedInfoAsync$1.AnonymousClass1.b(WinkUserInfo.this, textView, Va, imageView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorStickerControlPart$loadFeedInfoAsync$1(WinkEditorStickerControlPart winkEditorStickerControlPart, TextView textView, ImageView imageView, Continuation<? super WinkEditorStickerControlPart$loadFeedInfoAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorStickerControlPart;
        this.$nameView = textView;
        this.$avatarView = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorStickerControlPart$loadFeedInfoAsync$1(this.this$0, this.$nameView, this.$avatarView, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WinkUserInfoDataManager.INSTANCE.b().e(new AnonymousClass1(this.this$0, this.$nameView, this.$avatarView));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorStickerControlPart$loadFeedInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

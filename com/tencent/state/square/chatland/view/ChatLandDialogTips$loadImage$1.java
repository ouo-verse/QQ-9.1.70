package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/state/square/chatland/view/ChatLandDialogTips$loadImage$1", "Lcom/nostra13/universalimageloader/core/listener/SimpleImageLoadingListener;", "onLoadingComplete", "", "imageUri", "", "view", "Landroid/view/View;", "loadedImage", "Landroid/graphics/Bitmap;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandDialogTips$loadImage$1 extends SimpleImageLoadingListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1 $done;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandDialogTips$loadImage$1(Context context, Function1 function1) {
        this.$context = context;
        this.$done = function1;
    }

    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.$context.getResources(), loadedImage);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandDialogTips$loadImage$1$onLoadingComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatLandDialogTips$loadImage$1.this.$done.invoke(bitmapDrawable);
            }
        });
    }
}

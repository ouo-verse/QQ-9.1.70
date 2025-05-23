package com.tencent.state.square.chatland.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.Size;
import android.view.ViewGroup;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.view.ImageTipsManager$show$1;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ImageTipsManager$show$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ long $duration;
    final /* synthetic */ Point $location;
    final /* synthetic */ Size $size;
    final /* synthetic */ ImageTipsManager this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/state/square/chatland/view/ImageTipsManager$show$1$1", "Ljava/util/TimerTask;", TencentLocation.RUN_MODE, "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.chatland.view.ImageTipsManager$show$1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ SquareImageView $imgView;

        AnonymousClass1(SquareImageView squareImageView) {
            this.$imgView = squareImageView;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ImageTipsManager$show$1$1$run$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    AnimationUtils.INSTANCE.startAlphaAnimation(ImageTipsManager$show$1.AnonymousClass1.this.$imgView, false, 300L, new AnimatorListenerAdapter() { // from class: com.tencent.state.square.chatland.view.ImageTipsManager$show$1$1$run$1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            WeakReference weakReference;
                            IViewContainer iViewContainer;
                            weakReference = ImageTipsManager$show$1.this.this$0.container;
                            if (weakReference == null || (iViewContainer = (IViewContainer) weakReference.get()) == null) {
                                return;
                            }
                            iViewContainer.removeView(ImageTipsManager$show$1.AnonymousClass1.this.$imgView);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTipsManager$show$1(ImageTipsManager imageTipsManager, Context context, Size size, Point point, long j3) {
        super(1);
        this.this$0 = imageTipsManager;
        this.$context = context;
        this.$size = size;
        this.$location = point;
        this.$duration = j3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap) {
        WeakReference weakReference;
        Timer timer;
        IViewContainer iViewContainer;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        SquareImageView squareImageView = new SquareImageView(this.$context);
        squareImageView.setImageDrawable(new BitmapDrawable(this.$context.getResources(), bitmap));
        squareImageView.setLayoutParams(new ViewGroup.LayoutParams(this.$size.getWidth(), this.$size.getHeight()));
        squareImageView.setX(this.$location.x);
        squareImageView.setY(this.$location.y);
        weakReference = this.this$0.container;
        if (weakReference != null && (iViewContainer = (IViewContainer) weakReference.get()) != null) {
            iViewContainer.addView(squareImageView);
        }
        timer = this.this$0.timer;
        if (timer != null) {
            timer.schedule(new AnonymousClass1(squareImageView), this.$duration);
        }
    }
}

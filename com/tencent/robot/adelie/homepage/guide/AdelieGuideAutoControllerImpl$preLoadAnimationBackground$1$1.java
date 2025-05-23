package com.tencent.robot.adelie.homepage.guide;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bgBitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieGuideAutoControllerImpl$preLoadAnimationBackground$1$1 extends Lambda implements Function3<Bitmap, Bitmap, Bitmap, Unit> {
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ AdelieGuideAutoControllerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieGuideAutoControllerImpl$preLoadAnimationBackground$1$1(Function0<Unit> function0, AdelieGuideAutoControllerImpl adelieGuideAutoControllerImpl) {
        super(3);
        this.$onComplete = function0;
        this.this$0 = adelieGuideAutoControllerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieGuideAutoControllerImpl this$0, Bitmap bitmap) {
        AdelieGuideAnimationContainer adelieGuideAnimationContainer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        adelieGuideAnimationContainer = this$0.animatorContainer;
        if (adelieGuideAnimationContainer != null) {
            adelieGuideAnimationContainer.i(bitmap);
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        invoke2(bitmap, bitmap2, bitmap3);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final Bitmap bitmap, @Nullable Bitmap bitmap2, @Nullable Bitmap bitmap3) {
        QLog.i("AdelieGuideAutoControllerImpl", 1, "preloadRobotGuideBg end " + bitmap);
        if (bitmap != null) {
            Function0<Unit> function0 = this.$onComplete;
            final AdelieGuideAutoControllerImpl adelieGuideAutoControllerImpl = this.this$0;
            AIOUtil.f366629a.g(bitmap);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.guide.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieGuideAutoControllerImpl$preLoadAnimationBackground$1$1.b(AdelieGuideAutoControllerImpl.this, bitmap);
                }
            });
            function0.invoke();
        }
    }
}

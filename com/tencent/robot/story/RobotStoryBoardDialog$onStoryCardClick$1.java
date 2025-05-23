package com.tencent.robot.story;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class RobotStoryBoardDialog$onStoryCardClick$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RobotStoryBoardDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotStoryBoardDialog$onStoryCardClick$1(RobotStoryBoardDialog robotStoryBoardDialog) {
        super(1);
        this.this$0 = robotStoryBoardDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotStoryBoardDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        FrameLayout frameLayout;
        if (z16) {
            frameLayout = this.this$0.rootLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
                frameLayout = null;
            }
            final RobotStoryBoardDialog robotStoryBoardDialog = this.this$0;
            frameLayout.postDelayed(new Runnable() { // from class: com.tencent.robot.story.h
                @Override // java.lang.Runnable
                public final void run() {
                    RobotStoryBoardDialog$onStoryCardClick$1.b(RobotStoryBoardDialog.this);
                }
            }, 200L);
        }
    }
}

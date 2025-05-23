package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.os.Handler;
import com.tencent.biz.qqcircle.immersive.repository.QFSFeedFollowGuideAnimRepository;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSFeedAvatarFollowGuideAnimController$startFollowGuideAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QFSFeedAvatarFollowGuideAnimController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSFeedAvatarFollowGuideAnimController$startFollowGuideAnimation$1(QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController) {
        super(0);
        this.this$0 = qFSFeedAvatarFollowGuideAnimController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSFeedAvatarFollowGuideAnimController this$0) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler uIHandler = RFWThreadManager.getUIHandler();
        runnable = this$0.collapseAnimatorRunnable;
        uIHandler.removeCallbacks(runnable);
        this$0.I(true);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str;
        boolean z16;
        Runnable runnable;
        QFSPlusFollowView qFSPlusFollowView;
        QFSPlusFollowView qFSPlusFollowView2;
        QFSFollowView.e eVar;
        QFSFeedFollowGuideAnimRepository qFSFeedFollowGuideAnimRepository = QFSFeedFollowGuideAnimRepository.f89742a;
        qFSFeedFollowGuideAnimRepository.d();
        str = this.this$0.posterId;
        qFSFeedFollowGuideAnimRepository.e(str);
        z16 = this.this$0.isFollowed;
        if (z16) {
            this.this$0.I(false);
            return;
        }
        Handler uIHandler = RFWThreadManager.getUIHandler();
        runnable = this.this$0.collapseAnimatorRunnable;
        uIHandler.postDelayed(runnable, 10000L);
        qFSPlusFollowView = this.this$0.followView;
        final QFSFeedAvatarFollowGuideAnimController qFSFeedAvatarFollowGuideAnimController = this.this$0;
        qFSPlusFollowView.setDismissAnimationListener(new QFSPlusFollowView.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.w
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView.a
            public final void onAnimationEnd() {
                QFSFeedAvatarFollowGuideAnimController$startFollowGuideAnimation$1.b(QFSFeedAvatarFollowGuideAnimController.this);
            }
        });
        qFSPlusFollowView2 = this.this$0.followView;
        eVar = this.this$0.followViewClickListener;
        qFSPlusFollowView2.f(eVar);
    }
}

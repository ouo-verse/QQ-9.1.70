package com.tencent.robot.aio.story;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.aio.story.RobotStoryAnimatorMviUIState;
import com.tencent.robot.aio.story.RobotStoryMsgIntent;
import com.tencent.robot.aio.story.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0007*\u0001\u0018\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/story/h;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/robot/aio/story/a;", "Lcom/tencent/robot/aio/story/RobotStoryAnimatorMviUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "t", "Lcom/tencent/robot/aio/story/a$a;", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/robot/aio/story/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r", "com/tencent/robot/aio/story/h$a", "d", "Lcom/tencent/robot/aio/story/h$a;", "action", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h extends com.tencent.aio.base.mvvm.b<com.tencent.robot.aio.story.a, RobotStoryAnimatorMviUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/story/h$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            h.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOBackgroundMsgIntent.OnBackgroundLoadCompleted) {
            n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        a.b bVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOBackgroundMsgIntent.GetBackgroundLoadCompleted.f349765d);
        if (k3 instanceof a.b) {
            bVar = (a.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            boolean a16 = bVar.a();
            if (a16) {
                n();
                new com.tencent.videocut.utils.dsl.b();
            } else {
                new com.tencent.videocut.utils.dsl.a(a16);
            }
        }
    }

    private final void n() {
        updateUI(RobotStoryAnimatorMviUIState.StopStoryViewAnimator.f367373d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(final a.C9770a intent) {
        intent.getBinding().getRoot().post(new Runnable() { // from class: com.tencent.robot.aio.story.g
            @Override // java.lang.Runnable
            public final void run() {
                h.p(h.this, intent);
            }
        });
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        ConstraintLayout root = intent.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "intent.binding.root");
        e16.h(new BusiAnimationEvent.AddFullScreenView(9, root));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h this$0, a.C9770a intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.updateUI(new RobotStoryAnimatorMviUIState.StartStoryViewAnimator(intent.getBinding()));
        this$0.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(a.b intent) {
        a.C9469a c9469a;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOBackgroundMsgIntent.GetBackgroundDrawable.f349764d);
        Drawable drawable = null;
        if (k3 instanceof a.C9469a) {
            c9469a = (a.C9469a) k3;
        } else {
            c9469a = null;
        }
        if (c9469a != null) {
            drawable = c9469a.a();
        }
        intent.b(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(RobotStoryMsgIntent.RobotStoryAnimEnd.f367379d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        if (AdelieUtils.f365929a.T((com.tencent.aio.api.runtime.a) getMContext()) && StoryUtils.f366640a.s((com.tencent.aio.api.runtime.a) getMContext())) {
            updateUI(RobotStoryAnimatorMviUIState.CreateStoryAnimatorView.f367371d);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.OnBackgroundLoadCompleted");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.action);
        t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.action);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.robot.aio.story.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C9770a) {
            o((a.C9770a) intent);
        } else if (intent instanceof a.b) {
            q((a.b) intent);
        } else if (intent instanceof a.c) {
            s();
        }
    }
}

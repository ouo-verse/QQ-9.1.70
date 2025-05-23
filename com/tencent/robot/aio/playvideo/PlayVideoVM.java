package com.tencent.robot.aio.playvideo;

import android.content.res.Configuration;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.robot.aio.playvideo.PlayVideoMsgIntent;
import com.tencent.robot.aio.playvideo.PlayVideoUIState;
import com.tencent.robot.aio.playvideo.a;
import com.tencent.robot.aio.playvideo.r;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/aio/playvideo/PlayVideoVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/robot/aio/playvideo/a;", "Lcom/tencent/robot/aio/playvideo/PlayVideoUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/aio/api/runtime/emitter/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroidx/lifecycle/LifecycleEventObserver;", "e", "Lkotlin/Lazy;", "l", "()Landroidx/lifecycle/LifecycleEventObserver;", "lifeEventObserver", "<init>", "()V", "f", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PlayVideoVM extends com.tencent.qqnt.aio.baseVM.a<a, PlayVideoUIState> implements com.tencent.aio.api.runtime.emitter.a, com.tencent.aio.api.runtime.emitter.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy lifeEventObserver;

    public PlayVideoVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new PlayVideoVM$lifeEventObserver$2(this));
        this.lifeEventObserver = lazy;
    }

    private final LifecycleEventObserver l() {
        return (LifecycleEventObserver) this.lifeEventObserver.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        e.C7244e c7244e;
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.GetVideoInfoIntent) {
            a.GetVideoInfoIntent getVideoInfoIntent = (a.GetVideoInfoIntent) intent;
            getVideoInfoIntent.d(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getString("key_babyQ_video_url", ""));
            getVideoInfoIntent.c(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getString("key_babyQ_image_url", ""));
            ((com.tencent.aio.api.runtime.a) getMContext()).g().l().remove("key_babyQ_video_url");
            ((com.tencent.aio.api.runtime.a) getMContext()).g().l().remove("key_babyQ_image_url");
            ((com.tencent.aio.api.runtime.a) getMContext()).g().l().remove("key_babyQ_need_show_video");
            return;
        }
        if (intent instanceof a.GetVideoMsgViewInfo) {
            com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(RobotMsgIntent.GetVideoViewInfo.f188692d);
            if (k3 instanceof e.C7244e) {
                c7244e = (e.C7244e) k3;
            } else {
                c7244e = null;
            }
            a.GetVideoMsgViewInfo getVideoMsgViewInfo = (a.GetVideoMsgViewInfo) intent;
            int i18 = 0;
            if (c7244e != null) {
                i3 = c7244e.d();
            } else {
                i3 = 0;
            }
            getVideoMsgViewInfo.h(i3);
            if (c7244e != null) {
                i16 = c7244e.a();
            } else {
                i16 = 0;
            }
            getVideoMsgViewInfo.e(i16);
            if (c7244e != null) {
                i17 = c7244e.c();
            } else {
                i17 = 0;
            }
            getVideoMsgViewInfo.g(i17);
            if (c7244e != null) {
                i18 = c7244e.b();
            }
            getVideoMsgViewInfo.f(i18);
            return;
        }
        if (intent instanceof a.d) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(PlayVideoMsgIntent.OnVideoPlayStart.f367275d);
        } else if (intent instanceof a.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(PlayVideoMsgIntent.OnVideoPlayEnd.f367274d);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (!fetchVBState(r.a.f367316a).b().getBoolean("is_palying", false)) {
            return false;
        }
        updateUI(PlayVideoUIState.DismissVideoView.f367277d);
        return true;
    }

    @Override // com.tencent.aio.api.runtime.emitter.b
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        updateUI(PlayVideoUIState.ConfigChange.f367276d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        ml3.a a16 = context.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        a16.b(this, d16);
        ml3.a a17 = context.b().a(com.tencent.aio.api.runtime.emitter.b.class);
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        a17.b(this, d17);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(l());
    }
}

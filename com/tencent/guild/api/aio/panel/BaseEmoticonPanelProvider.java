package com.tencent.guild.api.aio.panel;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\b\u0007*\u0001\u001f\b&\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0006\u0010\u000f\u001a\u00020\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0017J\b\u0010\u0015\u001a\u00020\u0005H\u0017J\b\u0010\u0016\u001a\u00020\u0005H\u0017J\b\u0010\u0017\u001a\u00020\u0005H\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0004\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider;", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "j", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lzq0/c;", "k", "g", "Landroid/widget/EditText;", h.F, "", "b", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "()Lcom/tencent/aio/part/root/panel/mvx/config/c;", "e", "Lzq0/c;", "emoticonPanel", "com/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider$b", "f", "Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider$b;", "action", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class BaseEmoticonPanelProvider extends com.tencent.aio.part.root.panel.mvx.config.b implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private zq0.c emoticonPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            BaseEmoticonPanelProvider.this.j(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public BaseEmoticonPanelProvider(@NotNull c panelParam) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
        this.action = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent i3) {
        if (i3 instanceof UpdateFavEmoPageEvent) {
            QLog.i("BaseEmoticonPanelProvider", 1, "handleAction UpdateFavEmoPageEvent");
            zq0.c cVar = this.emoticonPanel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonPanel");
                cVar = null;
            }
            cVar.a();
        }
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    @NotNull
    public View a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("BaseEmoticonPanelProvider", 4, "onCreate");
        zq0.c k3 = k(this.panelParam);
        this.emoticonPanel = k3;
        zq0.c cVar = null;
        if (k3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonPanel");
            k3 = null;
        }
        k3.onCreate();
        this.panelParam.a().d().getLifecycle().addObserver(this);
        this.panelParam.a().e().d(Reflection.getOrCreateKotlinClass(UpdateFavEmoPageEvent.class).getQualifiedName(), this.action);
        zq0.c cVar2 = this.emoticonPanel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonPanel");
        } else {
            cVar = cVar2;
        }
        return cVar.d();
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public boolean b() {
        QLog.i("BaseEmoticonPanelProvider", 4, "isNeedRecreate");
        return super.b();
    }

    @NotNull
    public final Context g() {
        Context requireContext = this.panelParam.a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "panelParam.mAIOContext.fragment.requireContext()");
        return requireContext;
    }

    @Nullable
    public abstract EditText h();

    @NotNull
    /* renamed from: i, reason: from getter */
    public final c getPanelParam() {
        return this.panelParam;
    }

    @NotNull
    public abstract zq0.c k(@NotNull c panelParam);

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void onDestroy() {
        QLog.i("BaseEmoticonPanelProvider", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        zq0.c cVar = this.emoticonPanel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonPanel");
            cVar = null;
        }
        cVar.onDestroy();
        this.panelParam.a().e().b(Reflection.getOrCreateKotlinClass(UpdateFavEmoPageEvent.class).getQualifiedName(), this.action);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        QLog.i("BaseEmoticonPanelProvider", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        QLog.i("BaseEmoticonPanelProvider", 4, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        QLog.i("BaseEmoticonPanelProvider", 4, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        QLog.i("BaseEmoticonPanelProvider", 4, DKHippyEvent.EVENT_STOP);
    }
}

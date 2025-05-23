package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.launcher.d;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001.\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R0\u00106\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f02j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f`38\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMainProcessWebViewFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "rh", "Landroid/view/ViewGroup;", "parentView", "sh", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "th", "", "actionType", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "action", "mb", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "Rf", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", DKHippyEvent.EVENT_STOP, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "D", "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/launcher/a;", "E", "Lcom/tencent/launcher/a;", "inputProvider", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/d;", "rootVB", "com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMainProcessWebViewFragment$b", "G", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMainProcessWebViewFragment$b;", "actionCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "H", "Ljava/util/HashMap;", "registerCallbackMap", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMainProcessWebViewFragment extends QPublicBaseFragment implements com.tencent.mobileqq.guild.media.thirdapp.container.b {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewGroup containerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.launcher.a inputProvider;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.container.vb.d rootVB;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b actionCallback = new b();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.guild.media.thirdapp.container.intent.f> registerCallbackMap = new HashMap<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMainProcessWebViewFragment$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildMainProcessWebViewFragment.this.rh(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rh(MsgIntent i3) {
        String qualifiedName = Reflection.getOrCreateKotlinClass(i3.getClass()).getQualifiedName();
        if (qualifiedName == null) {
            qualifiedName = "";
        }
        com.tencent.mobileqq.guild.media.thirdapp.container.intent.f fVar = this.registerCallbackMap.get(qualifiedName);
        if (fVar != null) {
            Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent");
            fVar.a((ContainerMsgIntent) i3);
        }
    }

    private final void sh(ViewGroup parentView) {
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        GuildOpenContainerLauncher.StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        this.rootVB = new com.tencent.mobileqq.guild.media.thirdapp.container.vb.d(startParams);
        d.a c16 = new d.a().c(this);
        com.tencent.mobileqq.guild.media.thirdapp.container.vb.d dVar = this.rootVB;
        Intrinsics.checkNotNull(dVar);
        d.a d16 = c16.f(dVar).e(parentView).d(this);
        GuildOpenContainerLauncher.StartParams startParams3 = this.startParams;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
        } else {
            startParams2 = startParams3;
        }
        this.inputProvider = new com.tencent.launcher.c().a(d16.a(startParams2).b());
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.b
    public void Rf(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[sendIntent]: intent " + intent);
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.a(intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.b
    public void mb(@NotNull String actionType, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.intent.f action) {
        boolean z16;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger.a d16 = Logger.f235387a.d();
        boolean z17 = false;
        if (this.inputProvider != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[registerIntentAction]: " + z16);
        if (actionType.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return;
        }
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.b(actionType, this.actionCallback);
        }
        this.registerCallbackMap.put(actionType, action);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[onCreate] ");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[onCreateView] ");
        if (container != null) {
            this.containerView = container;
            sh(container);
        }
        for (Map.Entry<String, com.tencent.mobileqq.guild.media.thirdapp.container.intent.f> entry : this.registerCallbackMap.entrySet()) {
            com.tencent.launcher.a aVar = this.inputProvider;
            if (aVar != null) {
                aVar.b(entry.getKey(), this.actionCallback);
            }
        }
        com.tencent.launcher.a aVar2 = this.inputProvider;
        if (aVar2 != null) {
            aVar2.d(Lifecycle.Event.ON_CREATE);
        }
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[destroy]");
        try {
            com.tencent.launcher.a aVar = this.inputProvider;
            if (aVar != null) {
                aVar.d(Lifecycle.Event.ON_DESTROY);
            }
        } catch (Throwable th5) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[onDestroy] error " + th5);
        }
        Set<String> keySet = this.registerCallbackMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "registerCallbackMap.keys");
        for (String it : keySet) {
            com.tencent.launcher.a aVar2 = this.inputProvider;
            if (aVar2 != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar2.c(it, this.actionCallback);
            }
        }
        this.registerCallbackMap.clear();
        com.tencent.mobileqq.guild.media.thirdapp.container.vb.d dVar = this.rootVB;
        if (dVar != null) {
            dVar.destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[onPause]");
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.setKeepScreenOn(false);
        }
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMainProcessWebViewFragment", 1, "[onResume]");
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.setKeepScreenOn(true);
        }
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_RESUME);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.tencent.launcher.a aVar = this.inputProvider;
        if (aVar != null) {
            aVar.d(Lifecycle.Event.ON_STOP);
        }
    }

    public final void th(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.startParams = startParams;
    }
}

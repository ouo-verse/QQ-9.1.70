package mu3;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 >2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\b<\u0010=J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010+\u001a\u0004\u0018\u00010*2\f\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010(H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lmu3/b;", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", "root", "", "onRuntimeAttachActivity", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "", "fromReload", "", "reloadPath", "onLoadMiniAppInfo", "onRuntimeStart", "onRuntimeResume", "onRuntimePause", "onRuntimeStop", "onRuntimeDetachActivity", "onRuntimeDestroy", "onBackPress", "Landroid/content/Context;", "getContext", "getAttachedActivity", "getMiniAppInfo", "isMiniGame", "isOrientationLandscape", "getBaseLibVersion", "onRuntimeCreate", "loadMiniApp", "isForeground", "Lcom/tencent/qqmini/sdk/launcher/core/IPage;", "getPage", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "getJsService", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "getJsPluginEngine", "Lcom/tencent/qqmini/sdk/launcher/model/ShareState;", "getShareState", "Lcom/tencent/qqmini/sdk/launcher/core/action/Action;", "action", "", "performAction", "d", "Landroid/app/Activity;", "attachActivity", "e", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "f", "Z", h.F, "Landroid/view/ViewGroup;", "contentView", "", "i", "I", "getEngineType", "()I", TagName.ENGINE_TYPE, "<init>", "(I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "lib_minihippy_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class b extends BaseRuntime {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Activity attachActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MiniAppInfo miniAppInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isForeground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int engineType;

    public b(int i3) {
        this.engineType = i3;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    @Nullable
    /* renamed from: getAttachedActivity, reason: from getter */
    public Activity getAttachActivity() {
        return this.attachActivity;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    @NotNull
    public String getBaseLibVersion() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    @Nullable
    public Context getContext() {
        return this.attachActivity;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    @Nullable
    public IJsPluginEngine getJsPluginEngine() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    @Nullable
    public IJsService getJsService() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    @Nullable
    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    @Nullable
    public IPage getPage() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    @NotNull
    public ShareState getShareState() {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        ShareState shareState = new ShareState();
        ThirdPartyMiniPageProxy thirdPartyMiniPageProxy = (ThirdPartyMiniPageProxy) ProxyManager.get(ThirdPartyMiniPageProxy.class);
        String str3 = null;
        boolean z18 = false;
        if (thirdPartyMiniPageProxy != null) {
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo != null) {
                str2 = miniAppInfo.appId;
            } else {
                str2 = null;
            }
            z16 = thirdPartyMiniPageProxy.needRestart(str2, this.engineType);
        } else {
            z16 = false;
        }
        shareState.showRestart = z16;
        ThirdPartyMiniPageProxy thirdPartyMiniPageProxy2 = (ThirdPartyMiniPageProxy) ProxyManager.get(ThirdPartyMiniPageProxy.class);
        if (thirdPartyMiniPageProxy2 != null) {
            MiniAppInfo miniAppInfo2 = this.miniAppInfo;
            if (miniAppInfo2 != null) {
                str = miniAppInfo2.appId;
            } else {
                str = null;
            }
            z17 = thirdPartyMiniPageProxy2.needShareToQZone(str, this.engineType);
        } else {
            z17 = false;
        }
        shareState.withShareQzone = z17;
        ThirdPartyMiniPageProxy thirdPartyMiniPageProxy3 = (ThirdPartyMiniPageProxy) ProxyManager.get(ThirdPartyMiniPageProxy.class);
        if (thirdPartyMiniPageProxy3 != null) {
            MiniAppInfo miniAppInfo3 = this.miniAppInfo;
            if (miniAppInfo3 != null) {
                str3 = miniAppInfo3.appId;
            }
            z18 = thirdPartyMiniPageProxy3.needShareToQQ(str3, this.engineType);
        }
        shareState.withShareQQ = z18;
        return shareState;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    /* renamed from: isForeground, reason: from getter */
    public boolean getIsForeground() {
        return this.isForeground;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isMiniGame() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isOrientationLandscape() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void loadMiniApp(@Nullable MiniAppInfo miniAppInfo) {
        this.miniAppInfo = miniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeAttachActivity(@Nullable Activity activity, @NotNull ViewGroup root) {
        Intrinsics.checkParameterIsNotNull(root, "root");
        this.attachActivity = activity;
        this.contentView = root;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDetachActivity(@Nullable Activity activity) {
        this.attachActivity = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimePause() {
        this.isForeground = false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeResume() {
        this.isForeground = true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    @Nullable
    public Object performAction(@Nullable Action<?> action) {
        if (action instanceof ActionBridge.ShareActionBridge) {
            c cVar = c.f417637a;
            Action<Boolean> realAction = ((ActionBridge.ShareActionBridge) action).getRealAction();
            if (realAction != null) {
                return Boolean.valueOf(cVar.a(this, (ShareAction) realAction, this.engineType));
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.sdk.action.ShareAction");
        }
        return super.performAction(action);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onRuntimeCreate() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDestroy() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStop() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onLoadMiniAppInfo(@Nullable MiniAppInfo miniAppInfo, boolean fromReload, @Nullable String reloadPath) {
    }
}

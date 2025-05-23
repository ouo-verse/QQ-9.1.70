package com.tencent.qq.minibox.proxy;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy;
import com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/qq/minibox/proxy/h;", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView;", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate$a;", "", "getProcess", "getVisibility", "", "versionCode", "", "setGameVersionCode", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "resetDownloadProcess", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView$VATipsOperateClickListener;", "clickListener", "setOperateClickListener", "process", "updateDownloadProcess", "", "downloadedSize", VirtualAppProxy.KEY_PKG_SIZE, "state", "updateState", "visibility", "updateVisibility", "", "isWifi", "updateWifiState", VirtualAppProxy.KEY_GAME_ID, "showDownloadView", "onStartDownloadClick", "onStopClick", "onContinueClick", "onCancelClick", "onRestartClick", "onRetryClick", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "a", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "delegate", "b", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView$VATipsOperateClickListener;", "<init>", "(Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class h implements MiniBoxGameUpgradeProxy.IDownloadView, IMiniBoxVADownloadTipsDelegate.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IMiniBoxVADownloadTipsDelegate delegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener clickListener;

    public h(@NotNull IMiniBoxVADownloadTipsDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public int getProcess() {
        return this.delegate.getProcess();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public int getVisibility() {
        return this.delegate.getVisibility();
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onCancelClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onCancelClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onContinueClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onContinueClick();
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void onDestroy() {
        this.delegate.onDestroy();
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onRestartClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onRestartClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onRetryClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onRetryClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onStartDownloadClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onStartDownloadClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate.a
    public void onStopClick() {
        MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener vATipsOperateClickListener = this.clickListener;
        if (vATipsOperateClickListener != null) {
            vATipsOperateClickListener.onStopClick();
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void resetDownloadProcess() {
        this.delegate.resetDownloadProcess();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void setGameVersionCode(@Nullable String versionCode) {
        this.delegate.setGameVersionCode(versionCode);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void setOperateClickListener(@NotNull MiniBoxGameUpgradeProxy.IDownloadView.VATipsOperateClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        this.delegate.setOperateClickListener(this);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void showDownloadView(boolean isWifi, @Nullable String gameId) {
        this.delegate.showDownloadView(isWifi, gameId);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void updateDownloadProcess(int process) {
        this.delegate.updateDownloadProcess(process);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void updateState(int state) {
        this.delegate.updateState(state);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void updateVisibility(int visibility) {
        this.delegate.updateVisibility(visibility);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void updateWifiState(boolean isWifi) {
        this.delegate.updateWifiState(isWifi);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy.IDownloadView
    public void updateDownloadProcess(int process, long downloadedSize, long pkgSize) {
        this.delegate.updateDownloadProcess(process, downloadedSize, pkgSize);
    }
}

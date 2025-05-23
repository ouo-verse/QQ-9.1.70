package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import java.lang.ref.WeakReference;

@MiniKeep
/* loaded from: classes23.dex */
public class GetAppPageRouterAction implements Action<IAppPageRouter> {
    private static final int EMPTY_CALLBACK_ID = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class a implements IAppPageRouter {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<IAppBrandPageContainer> f346211a;

        a(IAppBrandPageContainer iAppBrandPageContainer) {
            this.f346211a = new WeakReference<>(iAppBrandPageContainer);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
        public boolean navigateBack(int i3) {
            IAppBrandPageContainer iAppBrandPageContainer = this.f346211a.get();
            if (iAppBrandPageContainer != null) {
                return iAppBrandPageContainer.navigateBack(i3, -1);
            }
            return false;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
        public void navigateTo(String str) {
            IAppBrandPageContainer iAppBrandPageContainer = this.f346211a.get();
            if (iAppBrandPageContainer != null) {
                iAppBrandPageContainer.navigateTo(str, -1);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
        public void reLaunch(String str) {
            IAppBrandPageContainer iAppBrandPageContainer = this.f346211a.get();
            if (iAppBrandPageContainer != null) {
                iAppBrandPageContainer.cleanup(false);
                iAppBrandPageContainer.launch(str, "reLaunch");
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
        public void redirectTo(String str) {
            IAppBrandPageContainer iAppBrandPageContainer = this.f346211a.get();
            if (iAppBrandPageContainer != null) {
                iAppBrandPageContainer.redirectTo(str, -1);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.IAppPageRouter
        public void switchTab(String str) {
            IAppBrandPageContainer iAppBrandPageContainer = this.f346211a.get();
            if (iAppBrandPageContainer != null) {
                iAppBrandPageContainer.switchTab(str);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public IAppPageRouter perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page instanceof IAppBrandPageContainer) {
            return new a((IAppBrandPageContainer) page);
        }
        return null;
    }
}

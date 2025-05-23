package com.tencent.mobileqq.profilecard.template;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\nH\u0082\bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/template/ProfileTemplateApi;", "", "()V", "TAG", "", "emptyApi", "Lcom/tencent/mobileqq/profilecard/template/EmptyApi;", "checkNull", "", "block", "Lkotlin/Function0;", "", "getDiyMoreInfoManager", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "getTemplateComponent", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponent;", "getTemplateManager", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "getTemplateUtils", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "isDiyTemplateStyleID", "", "styleId", "", "isVasCustomBgTemplateStyleID", "profilecard-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileTemplateApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final ProfileTemplateApi INSTANCE;

    @NotNull
    private static final String TAG = "ProfileTemplateComponentUtils";

    @NotNull
    private static final EmptyApi emptyApi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ProfileTemplateApi();
            emptyApi = new EmptyApi();
        }
    }

    ProfileTemplateApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final IDiyMoreInfoManager getDiyMoreInfoManager(@Nullable IComponentCenter componentCenter) {
        IComponent<?, ?> templateComponent = INSTANCE.getTemplateComponent(componentCenter);
        if (templateComponent instanceof IDiyMoreInfoManager) {
            return (IDiyMoreInfoManager) templateComponent;
        }
        return emptyApi;
    }

    private final IComponent<?, ?> getTemplateComponent(IComponentCenter componentCenter) {
        if (componentCenter != null) {
            return componentCenter.getComponent(1034);
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final ITemplateManager getTemplateManager(@Nullable IComponentCenter componentCenter) {
        IComponent<?, ?> templateComponent = INSTANCE.getTemplateComponent(componentCenter);
        if (templateComponent instanceof ITemplateManager) {
            return (ITemplateManager) templateComponent;
        }
        return emptyApi;
    }

    @JvmStatic
    @NotNull
    public static final ITemplateUtils getTemplateUtils(@Nullable IComponentCenter componentCenter) {
        IComponent<?, ?> templateComponent = INSTANCE.getTemplateComponent(componentCenter);
        if (templateComponent instanceof ITemplateUtils) {
            return (ITemplateUtils) templateComponent;
        }
        return emptyApi;
    }

    @JvmStatic
    public static final boolean isDiyTemplateStyleID(long styleId) {
        if (styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE && styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE_2) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isVasCustomBgTemplateStyleID(long styleId) {
        if (styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_VAS_CUSTOM_BG_TEMPLATE) {
            return true;
        }
        return false;
    }

    private final void checkNull(Function0<Object[]> block) {
    }
}

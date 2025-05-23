package com.tencent.mobileqq.sharepanel.api;

import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.sharepanel.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/ISharePanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/sharepanel/f;", "createSharePanel", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "", "useNewSharePanel", "Companion", "a", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISharePanelApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String IPC_MODULE_ID = "SharePanelIPCServer";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/ISharePanelApi$a;", "", "<init>", "()V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.api.ISharePanelApi$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f287176a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41204);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f287176a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(41205), (Class<?>) ISharePanelApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f287176a;
        }
    }

    @NotNull
    f createSharePanel(@NotNull FragmentActivity activity, @NotNull String sceneId);

    @NotNull
    QIPCModule getIPCModule();

    @Deprecated(message = "\u8bf7\u76f4\u63a5\u4f7f\u7528\u4e1a\u52a1\u63a5\u5165\u5f00\u5173", replaceWith = @ReplaceWith(expression = "useNewSharePanel(sceneId: String)", imports = {}))
    boolean useNewSharePanel();

    boolean useNewSharePanel(@NotNull String sceneId);
}

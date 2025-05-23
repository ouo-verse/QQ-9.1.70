package com.tencent.mobileqq.troop.appscenter.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/api/ITroopAppsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroidx/fragment/app/Fragment;", "getFragment", "Landroid/content/Context;", "context", "", "troopUin", "", "pageType", "", "openNewPage", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopAppsApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int FROM_AIO = 2;
    public static final int FROM_SETTING = 3;
    public static final int FROM_SHORT_CUT = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/api/ITroopAppsApi$a;", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f294381a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25533);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f294381a = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(25537), (Class<?>) ITroopAppsApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f294381a;
        }
    }

    @NotNull
    Fragment getFragment();

    void openNewPage(@NotNull Context context, @NotNull String troopUin, int pageType);
}

package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J8\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/ISearchEmoticonMgrApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "aioDestroy", "", "setFloatingViewDraggable", "draggable", "", "showSearchEmoticonDialog", "context", "Landroid/content/Context;", "appRuntime", "Lmqq/app/AppRuntime;", "emotionEventCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "searchWords", "", IProfileCardConst.KEY_FROM_TYPE, "", "defaultSelectTabIndex", "Companion", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ISearchEmoticonMgrApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int FROM_HOT_PIC_PANEL = 2;
    public static final int FROM_MAGNIFIER = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/ISearchEmoticonMgrApi$Companion;", "", "()V", "FROM_HOT_PIC_PANEL", "", "FROM_MAGNIFIER", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        static IPatchRedirector $redirector_ = null;
        public static final int FROM_HOT_PIC_PANEL = 2;
        public static final int FROM_MAGNIFIER = 1;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28177);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                $$INSTANCE = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(28180), (Class<?>) ISearchEmoticonMgrApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.$$INSTANCE;
        }
    }

    void aioDestroy();

    void setFloatingViewDraggable(boolean draggable);

    void showSearchEmoticonDialog(@NotNull Context context, @NotNull AppRuntime appRuntime, @NotNull IEmoticonEventCallback emotionEventCallback, @NotNull CharSequence searchWords, int fromType, int defaultSelectTabIndex);
}

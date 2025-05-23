package com.tencent.qqnt.chats.api;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J.\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/api/IGuildFolderGuideApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "scene", "guildId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "callback", "showGuildFolderGuideDialog", "", "alwaysShowInDebug", "isShowGuildFolderGuide", "setShowGuildFolderGuide", "Companion", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IGuildFolderGuideApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String PARAM_SCENE = "REQUEST_SCROLL_GUILD_HELPER_SCENE";

    @NotNull
    public static final String SCENE_MSG_LIST = "SCENE_MSG_LIST";

    @NotNull
    public static final String SCENE_SETTING = "SCENE_SETTING";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/api/IGuildFolderGuideApi$a;", "", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.IGuildFolderGuideApi$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f354225a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38408);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f354225a = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38412), (Class<?>) IGuildFolderGuideApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f354225a;
        }
    }

    boolean alwaysShowInDebug();

    boolean isShowGuildFolderGuide(@NotNull String scene);

    void setShowGuildFolderGuide(@NotNull String scene);

    void showGuildFolderGuideDialog(@NotNull String scene, @NotNull String guildId, @NotNull FragmentManager fragmentManager, @NotNull Function0<Unit> callback);
}

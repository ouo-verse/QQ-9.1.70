package com.tencent.qqnt.chats.biz.gamebox;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/biz/gamebox/IGameBoxChatsHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "gameBoxScene", "", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "getLocalChatsFilter", "Companion", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IGameBoxChatsHelper extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int GAME_BOX_SCENE_TYPE_ALL_MSG_BOX = 1;
    public static final int GAME_BOX_SCENE_TYPE_APPLY_PARTNER = 3;
    public static final int GAME_BOX_SCENE_TYPE_META_DREAM_GAME = 2;
    public static final int GAME_SUB_BOX_TYPE_APPLY_PARTNER = 10000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chats/biz/gamebox/IGameBoxChatsHelper$a;", "", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.gamebox.IGameBoxChatsHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f354253a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38588);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f354253a = new Companion();
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
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38597), (Class<?>) IGameBoxChatsHelper.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f354253a;
        }
    }

    @NotNull
    List<com.tencent.qqnt.chats.main.vm.datasource.filter.a> getLocalChatsFilter(int gameBoxScene);
}

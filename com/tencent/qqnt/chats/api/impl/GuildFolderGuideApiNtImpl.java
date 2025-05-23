package com.tencent.qqnt.chats.api.impl;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IGuildFolderGuideApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/GuildFolderGuideApiNtImpl;", "Lcom/tencent/qqnt/chats/api/IGuildFolderGuideApi;", "()V", "alwaysShowInDebug", "", "isShowGuildFolderGuide", "scene", "", "setShowGuildFolderGuide", "", "showGuildFolderGuideDialog", "guildId", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "callback", "Lkotlin/Function0;", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class GuildFolderGuideApiNtImpl implements IGuildFolderGuideApi {
    static IPatchRedirector $redirector_;

    public GuildFolderGuideApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IGuildFolderGuideApi
    public boolean alwaysShowInDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.api.IGuildFolderGuideApi
    public boolean isShowGuildFolderGuide(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) scene)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        return false;
    }

    @Override // com.tencent.qqnt.chats.api.IGuildFolderGuideApi
    public void setShowGuildFolderGuide(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) scene);
        } else {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }
    }

    @Override // com.tencent.qqnt.chats.api.IGuildFolderGuideApi
    public void showGuildFolderGuideDialog(@NotNull String scene, @NotNull String guildId, @NotNull FragmentManager fragmentManager, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, scene, guildId, fragmentManager, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }
}

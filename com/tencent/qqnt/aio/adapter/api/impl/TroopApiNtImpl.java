package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0018\u0012\u0006\b\u0001\u0012\u00020\u00190\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J(\u0010\"\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TroopApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITroopApi;", "Landroid/content/Context;", "context", "", "groupUin", "", "openGroupProfile", "uin", "", "isGagMode", "isExitTroop", "troopUin", "isTroopMember", "memberUin", "isTroopOwner", "peerUinStr", "goToAppealForTempBlock", "showExitTroopPinToTopMsg", "ext", "openTroopSquarePage", "isTroopSquareSwitchOn", "hasTroopFlame", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getAIVoiceChatVB", "", "groupCode", "clearGroupSquareRedpointCache", "event", "", "", "params", "troopBeaconReport", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopApiNtImpl implements ITroopApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/TroopApiNtImpl$a", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.mvvm.b
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
            }
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            return new View(createViewParams.a());
        }
    }

    public TroopApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void clearGroupSquareRedpointCache(long groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, groupCode);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getAIVoiceChatVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void goToAppealForTempBlock(@Nullable Context context, @NotNull String peerUinStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) peerUinStr);
        } else {
            Intrinsics.checkNotNullParameter(peerUinStr, "peerUinStr");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean hasTroopFlame(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isExitTroop(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isGagMode(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopMember(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopOwner(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin, (Object) memberUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopSquareSwitchOn(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void openGroupProfile(@NotNull Context context, @NotNull String groupUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) groupUin);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void openTroopSquarePage(@NotNull String troopUin, @NotNull String ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin, (Object) ext);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(ext, "ext");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void showExitTroopPinToTopMsg(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void troopBeaconReport(@Nullable String event, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) event, (Object) params);
        }
    }
}

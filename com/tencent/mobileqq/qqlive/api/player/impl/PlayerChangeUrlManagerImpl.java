package com.tencent.mobileqq.qqlive.api.player.impl;

import br4.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlManagerImpl;", "Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager;", "", "resetCounter", "increaseCounter", "", "roomId", "init", "", "playerErrorCode", "", "needChangeUrl", "Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager$Callback;", "callback", "getChangedUrl", "hasChangeUrl", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo$VideoDefinition;", "targetDefinition", "", "getUrlByDefinition", "J", "Lbr4/d;", "roomInfo", "Lbr4/d;", "changeCounter", "I", "Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlModel;", "playerChangeUrlModel", "Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlModel;", "<init>", "()V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayerChangeUrlManagerImpl implements IPlayerChangeUrlManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int DEFAULT_MAX_CHANGE_TIMES = 1;

    @NotNull
    private static final String ERROR_CODES_DEFAULT = "14020003,403,11030102,11030402";

    @NotNull
    private static final String ERROR_CODES_NONE = "none";

    @NotNull
    private static final String TAG = "QQLive_Player|PlayerChangeUrlManagerImpl";
    private int changeCounter;

    @Nullable
    private PlayerChangeUrlModel playerChangeUrlModel;
    private long roomId;

    @Nullable
    private d roomInfo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlManagerImpl$Companion;", "", "()V", "DEFAULT_MAX_CHANGE_TIMES", "", "ERROR_CODES_DEFAULT", "", "ERROR_CODES_NONE", "TAG", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42903);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayerChangeUrlManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void increaseCounter() {
        this.changeCounter++;
    }

    private final void resetCounter() {
        this.changeCounter = 0;
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager
    public void getChangedUrl(@NotNull IPlayerChangeUrlManager.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i(TAG, "getChangedUrl", "roomId:" + this.roomId);
        if (this.changeCounter >= ht3.a.b("qqlive_player_change_url_max_times", 1)) {
            companion.i(TAG, "getChangedUrl", "change too many times.");
            return;
        }
        increaseCounter();
        PlayerChangeUrlModel playerChangeUrlModel = this.playerChangeUrlModel;
        if (playerChangeUrlModel != null) {
            playerChangeUrlModel.getChangedUrl(callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager
    @NotNull
    public String getUrlByDefinition(@Nullable EnterRoomInfo.VideoDefinition targetDefinition) {
        String urlByDefinition;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetDefinition);
        }
        resetCounter();
        PlayerChangeUrlModel playerChangeUrlModel = this.playerChangeUrlModel;
        if (playerChangeUrlModel == null || (urlByDefinition = playerChangeUrlModel.getUrlByDefinition(targetDefinition)) == null) {
            return "";
        }
        return urlByDefinition;
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager
    public boolean hasChangeUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.changeCounter > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager
    public void init(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, roomId);
            return;
        }
        AegisLogger.INSTANCE.i(TAG, "initRoomId", "hashCode:" + hashCode() + ", roomId:" + roomId);
        this.roomId = roomId;
        this.playerChangeUrlModel = new PlayerChangeUrlModel(roomId);
        resetCounter();
    }

    @Override // com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager
    public boolean needChangeUrl(int playerErrorCode) {
        List split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, playerErrorCode)).booleanValue();
        }
        String d16 = ht3.a.d("qqlive_player_auth_failed_code_list", ERROR_CODES_DEFAULT);
        if (!Intrinsics.areEqual("none", d16)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) d16, new String[]{","}, false, 0, 6, (Object) null);
            return split$default.contains(String.valueOf(playerErrorCode));
        }
        return false;
    }
}

package com.tencent.mobileqq.qqlive.api.room.avchatroom;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;

/* loaded from: classes17.dex */
public interface ILiveAudiencePlayerLiveTypeSwitcher {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes17.dex */
    public static final class PlayerLiveType {
        private static final /* synthetic */ PlayerLiveType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PlayerLiveType LIVE_AV_CHAT;
        public static final PlayerLiveType LIVE_NORMAL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50876);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PlayerLiveType playerLiveType = new PlayerLiveType("LIVE_NORMAL", 0);
            LIVE_NORMAL = playerLiveType;
            PlayerLiveType playerLiveType2 = new PlayerLiveType("LIVE_AV_CHAT", 1);
            LIVE_AV_CHAT = playerLiveType2;
            $VALUES = new PlayerLiveType[]{playerLiveType, playerLiveType2};
        }

        PlayerLiveType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PlayerLiveType valueOf(String str) {
            return (PlayerLiveType) Enum.valueOf(PlayerLiveType.class, str);
        }

        public static PlayerLiveType[] values() {
            return (PlayerLiveType[]) $VALUES.clone();
        }
    }

    void closeAVChatModule();

    void closeSuperPlayerModule();

    PlayerLiveType getPlayerLiveType();

    void openAVChatModule(Context context, String str, QQLiveRoomParams qQLiveRoomParams);

    void openSuperPlayerModule();

    void switchPlayerLiveType(PlayerLiveType playerLiveType, Context context, String str, QQLiveRoomParams qQLiveRoomParams);
}

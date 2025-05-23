package com.tencent.upload.network.route;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadRouteStrategy {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RouteCategoryType {
        private static final /* synthetic */ RouteCategoryType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RouteCategoryType BACKUP;
        public static final RouteCategoryType CDN;
        public static final RouteCategoryType HOST;
        public static final RouteCategoryType OPTIMUM;
        public static final RouteCategoryType RECENT;
        public static final RouteCategoryType REDIRECT;
        private final int code;
        private final String desc;
        private final int type;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11505);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            RouteCategoryType routeCategoryType = new RouteCategoryType("OPTIMUM", 0, 1, 541, "optimum");
            OPTIMUM = routeCategoryType;
            RouteCategoryType routeCategoryType2 = new RouteCategoryType("REDIRECT", 1, 2, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE, "redirect");
            REDIRECT = routeCategoryType2;
            RouteCategoryType routeCategoryType3 = new RouteCategoryType("RECENT", 2, 3, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED, RecentUser.TABLE_NAME);
            RECENT = routeCategoryType3;
            RouteCategoryType routeCategoryType4 = new RouteCategoryType("HOST", 3, 4, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, "host");
            HOST = routeCategoryType4;
            RouteCategoryType routeCategoryType5 = new RouteCategoryType("BACKUP", 4, 5, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED, "backup");
            BACKUP = routeCategoryType5;
            RouteCategoryType routeCategoryType6 = new RouteCategoryType("CDN", 5, 6, 546, "cdn");
            CDN = routeCategoryType6;
            $VALUES = new RouteCategoryType[]{routeCategoryType, routeCategoryType2, routeCategoryType3, routeCategoryType4, routeCategoryType5, routeCategoryType6};
        }

        RouteCategoryType(String str, int i3, int i16, int i17, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2);
                return;
            }
            this.type = i16;
            this.code = i17;
            this.desc = str2;
        }

        public static RouteCategoryType valueOf(String str) {
            return (RouteCategoryType) Enum.valueOf(RouteCategoryType.class, str);
        }

        public static RouteCategoryType[] values() {
            return (RouteCategoryType[]) $VALUES.clone();
        }

        public int getCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.code;
        }

        public String getDesc() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.desc;
        }

        public int getType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.type;
        }
    }

    ServerRouteTable getServerRouteTable();

    boolean isApnChanged();

    boolean isApnChangedForNext();

    UploadRoute next(UploadRoute uploadRoute, int i3);

    UploadRoute reset();

    boolean save(UploadRoute uploadRoute);
}

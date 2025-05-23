package com.tencent.mobileqq.vip.api;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u000b2\u00020\u0001:\u0003\f\r\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$b;", "from", "", "getTraceDetailInfo", "url", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$FROM;", "buildTraceDetailUrl", "", "skipWhenExists", "Companion", "a", "b", "FROM", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipTraceDetailReport extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b8\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000fj\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$FROM;", "", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$b;", "toData", "", "toString", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "pageId", "getPageId", "itemID", "getItemID", "setItemID", "(Ljava/lang/String;)V", "itemType", "getItemType", "setItemType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "QQSETTINGS_ICON", "QQSETTINGS_DIAMOND", "QQSETTINGS_LEVEL", "QQSETTINGS_QQVALUE", "VIPCLUB_SEARCH", "VIPCLUB_RECENT", "VIPCLUB_FRIENDLIST", "PROFILECARD_ICON", "PROFILECARD_ICON_GUEST", "PROFILECARD_LEVEL", "PROFILECARD_LEVEL_GUEST", "PROFILECARD_DIAMOND", "PROFILECARD_DIAMOND_EMPTY", "PROFILECARD_DIAMOND_GUEST", "PROFILECARD_DIAMOND_GUEST_EMPTY", "PROFILECARD_QQVALUE", "PROFILECARD_SINGLE_DIAMOND", "PROFILECARD_SINGLE_DIAMOND_GUEST", "PROFILECARD_LIKEAREA_SETTING", "PROFILECARD_LIKEAREA_SHEET", "TROOP_MANAGER_INCREASE_GROUP_NUMBER", "TROOP_MANAGER_GET_BEAUTIFUL_NUMBER", "PROFIEDCARD_QID", "DRAWER_QQWALLET_VIP_DRILL", "DRAWER_QQWALLET_RENEWAL_PRIVILEGE", "DRAWER_QRCODE_EDIT_QID", "DRAWER_KINGCARD_NO_REDTOUCH", "DRAWER_KINGCARD_WITH_REDTOUCH", "AIO_DIALOG_TOP_NAMEPLATE", "DRAWER_TOP_MSG", "SETTING_CHAT_HISTORY_ROAM", "AIO_CHAT_VIP_ICON", "FUN_CALL_SETTING", "SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS", "SPECIALCARE_MALL_C2C_NOTIFICATION", "QZONE_DRESS_UP_FRIENDS", "QZONE_DRESS_UP_PRESONAL", "QZONE_DRESS_UP_PRESONAL_PANEL", "LUCKYNUMBER_AIO", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class FROM {
        private static final /* synthetic */ FROM[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FROM AIO_CHAT_VIP_ICON;
        public static final FROM AIO_DIALOG_TOP_NAMEPLATE;
        public static final FROM DRAWER_KINGCARD_NO_REDTOUCH;
        public static final FROM DRAWER_KINGCARD_WITH_REDTOUCH;
        public static final FROM DRAWER_QQWALLET_RENEWAL_PRIVILEGE;
        public static final FROM DRAWER_QQWALLET_VIP_DRILL;
        public static final FROM DRAWER_QRCODE_EDIT_QID;
        public static final FROM DRAWER_TOP_MSG;
        public static final FROM FUN_CALL_SETTING;
        public static final FROM LUCKYNUMBER_AIO;
        public static final FROM PROFIEDCARD_QID;
        public static final FROM PROFILECARD_DIAMOND;
        public static final FROM PROFILECARD_DIAMOND_EMPTY;
        public static final FROM PROFILECARD_DIAMOND_GUEST;
        public static final FROM PROFILECARD_DIAMOND_GUEST_EMPTY;
        public static final FROM PROFILECARD_ICON;
        public static final FROM PROFILECARD_ICON_GUEST;
        public static final FROM PROFILECARD_LEVEL;
        public static final FROM PROFILECARD_LEVEL_GUEST;
        public static final FROM PROFILECARD_LIKEAREA_SETTING;
        public static final FROM PROFILECARD_LIKEAREA_SHEET;
        public static final FROM PROFILECARD_QQVALUE;
        public static final FROM PROFILECARD_SINGLE_DIAMOND;
        public static final FROM PROFILECARD_SINGLE_DIAMOND_GUEST;
        public static final FROM QQSETTINGS_DIAMOND;
        public static final FROM QQSETTINGS_ICON;
        public static final FROM QQSETTINGS_LEVEL;
        public static final FROM QQSETTINGS_QQVALUE;
        public static final FROM QZONE_DRESS_UP_FRIENDS;
        public static final FROM QZONE_DRESS_UP_PRESONAL;
        public static final FROM QZONE_DRESS_UP_PRESONAL_PANEL;
        public static final FROM SETTING_CHAT_HISTORY_ROAM;
        public static final FROM SPECIALCARE_MALL_C2C_NOTIFICATION;
        public static final FROM SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS;
        public static final FROM TROOP_MANAGER_GET_BEAUTIFUL_NUMBER;
        public static final FROM TROOP_MANAGER_INCREASE_GROUP_NUMBER;
        public static final FROM VIPCLUB_FRIENDLIST;
        public static final FROM VIPCLUB_RECENT;
        public static final FROM VIPCLUB_SEARCH;

        @NotNull
        private final String appId;

        @NotNull
        private String itemID;

        @NotNull
        private String itemType;

        @NotNull
        private final String pageId;

        private static final /* synthetic */ FROM[] $values() {
            return new FROM[]{QQSETTINGS_ICON, QQSETTINGS_DIAMOND, QQSETTINGS_LEVEL, QQSETTINGS_QQVALUE, VIPCLUB_SEARCH, VIPCLUB_RECENT, VIPCLUB_FRIENDLIST, PROFILECARD_ICON, PROFILECARD_ICON_GUEST, PROFILECARD_LEVEL, PROFILECARD_LEVEL_GUEST, PROFILECARD_DIAMOND, PROFILECARD_DIAMOND_EMPTY, PROFILECARD_DIAMOND_GUEST, PROFILECARD_DIAMOND_GUEST_EMPTY, PROFILECARD_QQVALUE, PROFILECARD_SINGLE_DIAMOND, PROFILECARD_SINGLE_DIAMOND_GUEST, PROFILECARD_LIKEAREA_SETTING, PROFILECARD_LIKEAREA_SHEET, TROOP_MANAGER_INCREASE_GROUP_NUMBER, TROOP_MANAGER_GET_BEAUTIFUL_NUMBER, PROFIEDCARD_QID, DRAWER_QQWALLET_VIP_DRILL, DRAWER_QQWALLET_RENEWAL_PRIVILEGE, DRAWER_QRCODE_EDIT_QID, DRAWER_KINGCARD_NO_REDTOUCH, DRAWER_KINGCARD_WITH_REDTOUCH, AIO_DIALOG_TOP_NAMEPLATE, DRAWER_TOP_MSG, SETTING_CHAT_HISTORY_ROAM, AIO_CHAT_VIP_ICON, FUN_CALL_SETTING, SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS, SPECIALCARE_MALL_C2C_NOTIFICATION, QZONE_DRESS_UP_FRIENDS, QZONE_DRESS_UP_PRESONAL, QZONE_DRESS_UP_PRESONAL_PANEL, LUCKYNUMBER_AIO};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39983);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 11)) {
                redirector.redirect((short) 11);
                return;
            }
            QQSETTINGS_ICON = new FROM("QQSETTINGS_ICON", 0, VasWebConstants.REPORT_ORIGIN, "65", null, null, 12, null);
            QQSETTINGS_DIAMOND = new FROM("QQSETTINGS_DIAMOND", 1, VasWebConstants.REPORT_ORIGIN, "6", null, null, 12, null);
            String str = null;
            String str2 = null;
            int i3 = 12;
            QQSETTINGS_LEVEL = new FROM("QQSETTINGS_LEVEL", 2, VasWebConstants.REPORT_ORIGIN, "5", str, str2, i3, 0 == true ? 1 : 0);
            String str3 = null;
            String str4 = null;
            int i16 = 12;
            QQSETTINGS_QQVALUE = new FROM("QQSETTINGS_QQVALUE", 3, VasWebConstants.REPORT_ORIGIN, "70", str3, str4, i16, 0 == true ? 1 : 0);
            VIPCLUB_SEARCH = new FROM("VIPCLUB_SEARCH", 4, VasWebConstants.REPORT_ORIGIN, "80", str, str2, i3, 0 == true ? 1 : 0);
            VIPCLUB_RECENT = new FROM("VIPCLUB_RECENT", 5, VasWebConstants.REPORT_ORIGIN, "81", str3, str4, i16, 0 == true ? 1 : 0);
            VIPCLUB_FRIENDLIST = new FROM("VIPCLUB_FRIENDLIST", 6, VasWebConstants.REPORT_ORIGIN, "82", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_ICON = new FROM("PROFILECARD_ICON", 7, VasWebConstants.REPORT_ORIGIN, "63", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_ICON_GUEST = new FROM("PROFILECARD_ICON_GUEST", 8, VasWebConstants.REPORT_ORIGIN, IPreloadResource.ABI_64, str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_LEVEL = new FROM("PROFILECARD_LEVEL", 9, VasWebConstants.REPORT_ORIGIN, "7", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_LEVEL_GUEST = new FROM("PROFILECARD_LEVEL_GUEST", 10, VasWebConstants.REPORT_ORIGIN, "8", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_DIAMOND = new FROM("PROFILECARD_DIAMOND", 11, VasWebConstants.REPORT_ORIGIN, "9", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_DIAMOND_EMPTY = new FROM("PROFILECARD_DIAMOND_EMPTY", 12, VasWebConstants.REPORT_ORIGIN, "66", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_DIAMOND_GUEST = new FROM("PROFILECARD_DIAMOND_GUEST", 13, VasWebConstants.REPORT_ORIGIN, "10", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_DIAMOND_GUEST_EMPTY = new FROM("PROFILECARD_DIAMOND_GUEST_EMPTY", 14, VasWebConstants.REPORT_ORIGIN, "67", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_QQVALUE = new FROM("PROFILECARD_QQVALUE", 15, VasWebConstants.REPORT_ORIGIN, "71", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_SINGLE_DIAMOND = new FROM("PROFILECARD_SINGLE_DIAMOND", 16, VasWebConstants.REPORT_ORIGIN, "61", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_SINGLE_DIAMOND_GUEST = new FROM("PROFILECARD_SINGLE_DIAMOND_GUEST", 17, VasWebConstants.REPORT_ORIGIN, "62", str3, str4, i16, 0 == true ? 1 : 0);
            PROFILECARD_LIKEAREA_SETTING = new FROM("PROFILECARD_LIKEAREA_SETTING", 18, VasWebConstants.REPORT_ORIGIN, "pg_user_profile_likeplace_setting", str, str2, i3, 0 == true ? 1 : 0);
            PROFILECARD_LIKEAREA_SHEET = new FROM("PROFILECARD_LIKEAREA_SHEET", 19, VasWebConstants.REPORT_ORIGIN, "pg_user_profile_likeplace_set", str3, str4, i16, 0 == true ? 1 : 0);
            TROOP_MANAGER_INCREASE_GROUP_NUMBER = new FROM("TROOP_MANAGER_INCREASE_GROUP_NUMBER", 20, VasWebConstants.REPORT_ORIGIN, "76", str, str2, i3, 0 == true ? 1 : 0);
            TROOP_MANAGER_GET_BEAUTIFUL_NUMBER = new FROM("TROOP_MANAGER_GET_BEAUTIFUL_NUMBER", 21, VasWebConstants.REPORT_ORIGIN, "77", str3, str4, i16, 0 == true ? 1 : 0);
            PROFIEDCARD_QID = new FROM("PROFIEDCARD_QID", 22, VasWebConstants.REPORT_ORIGIN, "78", str, str2, i3, 0 == true ? 1 : 0);
            DRAWER_QQWALLET_VIP_DRILL = new FROM("DRAWER_QQWALLET_VIP_DRILL", 23, VasWebConstants.REPORT_ORIGIN, "79", str3, str4, i16, 0 == true ? 1 : 0);
            DRAWER_QQWALLET_RENEWAL_PRIVILEGE = new FROM("DRAWER_QQWALLET_RENEWAL_PRIVILEGE", 24, VasWebConstants.REPORT_ORIGIN, "80", str, str2, i3, 0 == true ? 1 : 0);
            DRAWER_QRCODE_EDIT_QID = new FROM("DRAWER_QRCODE_EDIT_QID", 25, VasWebConstants.REPORT_ORIGIN, "81", str3, str4, i16, 0 == true ? 1 : 0);
            DRAWER_KINGCARD_NO_REDTOUCH = new FROM("DRAWER_KINGCARD_NO_REDTOUCH", 26, VasWebConstants.REPORT_ORIGIN, HippyQQConstants.HIPPY_BID, str, str2, i3, 0 == true ? 1 : 0);
            DRAWER_KINGCARD_WITH_REDTOUCH = new FROM("DRAWER_KINGCARD_WITH_REDTOUCH", 27, VasWebConstants.REPORT_ORIGIN, "1012", str3, str4, i16, 0 == true ? 1 : 0);
            AIO_DIALOG_TOP_NAMEPLATE = new FROM("AIO_DIALOG_TOP_NAMEPLATE", 28, VasWebConstants.REPORT_ORIGIN, "82", str, str2, i3, 0 == true ? 1 : 0);
            DRAWER_TOP_MSG = new FROM("DRAWER_TOP_MSG", 29, VasWebConstants.REPORT_ORIGIN, "83", str3, str4, i16, 0 == true ? 1 : 0);
            SETTING_CHAT_HISTORY_ROAM = new FROM("SETTING_CHAT_HISTORY_ROAM", 30, VasWebConstants.REPORT_ORIGIN, "84", str, str2, i3, 0 == true ? 1 : 0);
            AIO_CHAT_VIP_ICON = new FROM("AIO_CHAT_VIP_ICON", 31, VasWebConstants.REPORT_ORIGIN, "85", str3, str4, i16, 0 == true ? 1 : 0);
            FUN_CALL_SETTING = new FROM("FUN_CALL_SETTING", 32, VasWebConstants.REPORT_ORIGIN, "pg_bas_dressvip_set", str, str2, i3, 0 == true ? 1 : 0);
            SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS = new FROM("SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS", 33, VasWebConstants.REPORT_ORIGIN, "1017", str3, str4, i16, 0 == true ? 1 : 0);
            SPECIALCARE_MALL_C2C_NOTIFICATION = new FROM("SPECIALCARE_MALL_C2C_NOTIFICATION", 34, VasWebConstants.REPORT_ORIGIN, "1018", str, str2, i3, 0 == true ? 1 : 0);
            QZONE_DRESS_UP_FRIENDS = new FROM("QZONE_DRESS_UP_FRIENDS", 35, VasWebConstants.REPORT_ORIGIN, "1019", str3, str4, i16, 0 == true ? 1 : 0);
            QZONE_DRESS_UP_PRESONAL = new FROM("QZONE_DRESS_UP_PRESONAL", 36, VasWebConstants.REPORT_ORIGIN, "1021", str, str2, i3, 0 == true ? 1 : 0);
            QZONE_DRESS_UP_PRESONAL_PANEL = new FROM("QZONE_DRESS_UP_PRESONAL_PANEL", 37, VasWebConstants.REPORT_ORIGIN, "1022", str3, str4, i16, 0 == true ? 1 : 0);
            LUCKYNUMBER_AIO = new FROM("LUCKYNUMBER_AIO", 38, VasWebConstants.REPORT_ORIGIN, "1020", str, str2, i3, 0 == true ? 1 : 0);
            $VALUES = $values();
        }

        FROM(String str, int i3, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3, str4, str5);
                return;
            }
            this.appId = str2;
            this.pageId = str3;
            this.itemID = str4;
            this.itemType = str5;
        }

        public static FROM valueOf(String str) {
            return (FROM) Enum.valueOf(FROM.class, str);
        }

        public static FROM[] values() {
            return (FROM[]) $VALUES.clone();
        }

        @NotNull
        public final String getAppId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.appId;
        }

        @NotNull
        public final String getItemID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.itemID;
        }

        @NotNull
        public final String getItemType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.itemType;
        }

        @NotNull
        public final String getPageId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.pageId;
        }

        public final void setItemID(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.itemID = str;
            }
        }

        public final void setItemType(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.itemType = str;
            }
        }

        @NotNull
        public final b toData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return new b(this.appId, this.pageId, this.itemID, this.itemType);
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "FROM(appId='" + this.appId + "', pageId='" + this.pageId + "')";
        }

        /* synthetic */ FROM(String str, int i3, String str2, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, str2, str3, (i16 & 4) != 0 ? "" : str4, (i16 & 8) != 0 ? "" : str5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, str3, str4, str5, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$a;", "", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport;", "a", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.IVipTraceDetailReport$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f312790a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39960);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f312790a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        @NotNull
        public final IVipTraceDetailReport a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IVipTraceDetailReport) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IVipTraceDetailReport.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVipTraceDetailReport::class.java)");
            return (IVipTraceDetailReport) api;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "b", "d", "pageId", "c", "itemID", "itemType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String pageId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String itemID;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String itemType;

        public b(@NotNull String appId, @NotNull String pageId, @NotNull String itemID, @NotNull String itemType) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(itemID, "itemID");
            Intrinsics.checkNotNullParameter(itemType, "itemType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appId, pageId, itemID, itemType);
                return;
            }
            this.appId = appId;
            this.pageId = pageId;
            this.itemID = itemID;
            this.itemType = itemType;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.appId;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.itemID;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.itemType;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.pageId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.appId, bVar.appId) && Intrinsics.areEqual(this.pageId, bVar.pageId) && Intrinsics.areEqual(this.itemID, bVar.itemID) && Intrinsics.areEqual(this.itemType, bVar.itemType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return (((((this.appId.hashCode() * 31) + this.pageId.hashCode()) * 31) + this.itemID.hashCode()) * 31) + this.itemType.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "Data(appId=" + this.appId + ", pageId=" + this.pageId + ", itemID=" + this.itemID + ", itemType=" + this.itemType + ")";
        }

        public /* synthetic */ b(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? VasWebConstants.REPORT_ORIGIN : str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) == 0 ? str4 : "");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40026), (Class<?>) IVipTraceDetailReport.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2);
        } else {
            INSTANCE = Companion.f312790a;
        }
    }

    @NotNull
    String buildTraceDetailUrl(@NotNull String url, @NotNull FROM from);

    @NotNull
    String buildTraceDetailUrl(@NotNull String url, @NotNull b from);

    @NotNull
    String buildTraceDetailUrl(@NotNull String url, @NotNull b from, boolean skipWhenExists);

    @NotNull
    String getTraceDetailInfo(@NotNull b from);
}

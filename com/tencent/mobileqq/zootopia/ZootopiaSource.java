package com.tencent.mobileqq.zootopia;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\u00c6\u0003J)\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0000H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/zootopia/Source;", "component1", "", "component2", "component3", "mainSource", "subSource", "last", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/zootopia/Source;", "getMainSource", "()Lcom/tencent/mobileqq/zootopia/Source;", "Ljava/lang/String;", "getSubSource", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getLast", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setLast", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "<init>", "(Lcom/tencent/mobileqq/zootopia/Source;Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaSource implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_FRAGMENT_SOURCE = "key_fragment_source";

    @NotNull
    public static final String SUB_SOURCE_AIGC_CREATION_ENTRANCE = "em_zplan_entrance_plus";

    @NotNull
    public static final String SUB_SOURCE_AIGC_PREVIEW = "zp_aigc_preview";

    @NotNull
    public static final String SUB_SOURCE_ARK_GAME = "em_zplan_entrance_ark_invite";

    @NotNull
    public static final String SUB_SOURCE_ARK_SEND_GIFT = "em_zplan_entrance_ark_gift";

    @NotNull
    public static final String SUB_SOURCE_ARK_XIAOWO = "em_zplan_entrance_ark_xiaowo_invite";

    @NotNull
    public static final String SUB_SOURCE_BEANCURD = "zplan_entrance_aio_tofu";

    @NotNull
    public static final String SUB_SOURCE_BRAND_LIST = "zp_brand_list";

    @NotNull
    public static final String SUB_SOURCE_CHANGE_ROLE = "zp_changed_role";

    @NotNull
    public static final String SUB_SOURCE_CREATE_ROLE = "zp_create_role";

    @NotNull
    public static final String SUB_SOURCE_DIRECT = "0";

    @NotNull
    public static final String SUB_SOURCE_DOWNLOAD = "zp_download";

    @NotNull
    public static final String SUB_SOURCE_DRAWER_SUPER_QQ_SHOW_TAB = "em_drawer_superqqshow_tab";

    @NotNull
    public static final String SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL = "em_zplan_manage_portal";

    @NotNull
    public static final String SUB_SOURCE_DRESS_SQUARE = "zp_dress_square";

    @NotNull
    public static final String SUB_SOURCE_EMOTICON_DETAIL = "em_zplan_emote_detail_click_to_mall";

    @NotNull
    public static final String SUB_SOURCE_EMOTICON_GRAY_TIP = "em_zplan_emote_xht_to_chuangjue";

    @NotNull
    public static final String SUB_SOURCE_ENTRANCE_EMOTICON = "em_zplan_entrance_qq_emote";

    @NotNull
    public static final String SUB_SOURCE_ENTRANCE_PROFILE = "em_zplan_entrance_profile_picture";

    @NotNull
    public static final String SUB_SOURCE_FEEDS_CARD_LIST = "zp_feeds_card_list";

    @NotNull
    public static final String SUB_SOURCE_FRIENDS_DRESS_UP = "zp_friends_dress_up";

    @NotNull
    public static final String SUB_SOURCE_FRIEND_LIST = "zp_friend_list";

    @NotNull
    public static final String SUB_SOURCE_GROUP_TRANSIT = "zp_group_transit";

    @NotNull
    public static final String SUB_SOURCE_H5_COUPLE = "em_zplan_entrance_event_couple_h5";

    @NotNull
    public static final String SUB_SOURCE_H5_LIGHT_UP = "em_zplan_entrance_event_lightup_icon";

    @NotNull
    public static final String SUB_SOURCE_H5_NY_COUPLE = "em_zplan_entrance_event_ny_coupon";

    @NotNull
    public static final String SUB_SOURCE_H5_XSJ_SHARE = "em_zplan_entrance_event_xsj_share_h5";

    @NotNull
    public static final String SUB_SOURCE_LEBA = "zplan_entrance_dongtai_xiaowo";

    @NotNull
    public static final String SUB_SOURCE_MAIN_HOME_LIST = "zp_main_home_list";

    @NotNull
    public static final String SUB_SOURCE_MAKE_GIF = "zp_emo_make_gif";

    @NotNull
    public static final String SUB_SOURCE_MAP_DETAIL = "zp_map_detail";

    @NotNull
    public static final String SUB_SOURCE_MAP_LIST = "zp_map_list";

    @NotNull
    public static final String SUB_SOURCE_PARADISE = "zp_paradise";

    @NotNull
    public static final String SUB_SOURCE_PHOTOGRAPH = "zp_photograph";

    @NotNull
    public static final String SUB_SOURCE_PK_PORTAL = "em_zplan_entrance_h5_activity_fashionpk";

    @NotNull
    public static final String SUB_SOURCE_PROFILE_OWNER = "em_zplan_entrance_qq_account_owner";

    @NotNull
    public static final String SUB_SOURCE_PROFILE_VISITOR = "em_zplan_entrance_qq_account_visitor";

    @NotNull
    public static final String SUB_SOURCE_QAV_C2C_AUTO = "em_zplan_entrance_qqchat_c2c_auto";

    @NotNull
    public static final String SUB_SOURCE_QAV_C2C_MID = "em_zplan_entrance_qqchat_c2c_mid_xiaowo";

    @NotNull
    public static final String SUB_SOURCE_QAV_C2C_RIGHT = "em_zplan_entrance_qqchat_c2c_right_xiaowo";

    @NotNull
    public static final String SUB_SOURCE_QAV_GROUP_AUTO = "em_zplan_entrance_qqchat_grp_auto";

    @NotNull
    public static final String SUB_SOURCE_QAV_GROUP_MID = "em_zplan_entrance_qqchat_grp_mid_xiaowo";

    @NotNull
    public static final String SUB_SOURCE_QAV_GROUP_RIGHT = "em_zplan_entrance_qqchat_grp_right_xiaowo";

    @NotNull
    public static final String SUB_SOURCE_ROLE_FRAGMENT = "zp_role_fragment";

    @NotNull
    public static final String SUB_SOURCE_SEARCH = "em_zplan_entrance_search";

    @NotNull
    public static final String SUB_SOURCE_SET_COVER = "em_zplan_xiaowo_entrance_set_cover";

    @NotNull
    public static final String SUB_SOURCE_STORE = "zp_store";

    @NotNull
    public static final String SUB_SOURCE_USER_CENTER = "zp_user_center";

    @NotNull
    public static final String SUB_SOURCE_XSJ = "em_zplan_entrance_xsj";

    @Nullable
    private ZootopiaSource last;

    @NotNull
    private final Source mainSource;

    @NotNull
    private final String subSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b6\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\f\u0010\u0014\u001a\u00020\u0013*\u0004\u0018\u00010\u0004R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016R\u0014\u0010&\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0016R\u0014\u0010(\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0014\u0010)\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0016R\u0014\u0010*\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0014\u0010,\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0016R\u0014\u0010-\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0016R\u0014\u0010.\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0016R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0016R\u0014\u00100\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0016R\u0014\u00102\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0016R\u0014\u00103\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0016R\u0014\u00104\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0016R\u0014\u00105\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010\u0016R\u0014\u00106\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0016R\u0014\u00108\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010\u0016R\u0014\u00109\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0016R\u0014\u0010:\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010\u0016R\u0014\u0010;\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010\u0016R\u0014\u0010<\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010\u0016R\u0014\u0010=\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010\u0016R\u0014\u0010>\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010\u0016R\u0014\u0010?\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010\u0016R\u0014\u0010@\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010\u0016R\u0014\u0010A\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010\u0016R\u0014\u0010B\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0016R\u0014\u0010C\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bC\u0010\u0016R\u0014\u0010D\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0016R\u0014\u0010E\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bE\u0010\u0016R\u0014\u0010F\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u0016\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ZootopiaSource$a;", "", "Lcom/tencent/mobileqq/zootopia/Source;", "mainSource", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "", "subSource", "last", "c", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "e", "Landroid/os/Bundle;", "bundle", "f", tl.h.F, "i", "g", "", "j", "KEY_FRAGMENT_SOURCE", "Ljava/lang/String;", "SUB_SOURCE_AIGC_CREATION_ENTRANCE", "SUB_SOURCE_AIGC_PREVIEW", "SUB_SOURCE_ARK_GAME", "SUB_SOURCE_ARK_SEND_GIFT", "SUB_SOURCE_ARK_XIAOWO", "SUB_SOURCE_BEANCURD", "SUB_SOURCE_BRAND_LIST", "SUB_SOURCE_CHANGE_ROLE", "SUB_SOURCE_CREATE_ROLE", "SUB_SOURCE_DIRECT", "SUB_SOURCE_DOWNLOAD", "SUB_SOURCE_DRAWER_SUPER_QQ_SHOW_TAB", "SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL", "SUB_SOURCE_DRESS_SQUARE", "SUB_SOURCE_EMOTICON_DETAIL", "SUB_SOURCE_EMOTICON_GRAY_TIP", "SUB_SOURCE_ENTRANCE_EMOTICON", "SUB_SOURCE_ENTRANCE_PROFILE", "SUB_SOURCE_FEEDS_CARD_LIST", "SUB_SOURCE_FRIENDS_DRESS_UP", "SUB_SOURCE_FRIEND_LIST", "SUB_SOURCE_GROUP_TRANSIT", "SUB_SOURCE_H5_COUPLE", "SUB_SOURCE_H5_LIGHT_UP", "SUB_SOURCE_H5_NY_COUPLE", "SUB_SOURCE_H5_XSJ_SHARE", "SUB_SOURCE_LEBA", "SUB_SOURCE_MAIN_HOME_LIST", "SUB_SOURCE_MAKE_GIF", "SUB_SOURCE_MAP_DETAIL", "SUB_SOURCE_MAP_LIST", "SUB_SOURCE_PARADISE", "SUB_SOURCE_PHOTOGRAPH", "SUB_SOURCE_PK_PORTAL", "SUB_SOURCE_PROFILE_OWNER", "SUB_SOURCE_PROFILE_VISITOR", "SUB_SOURCE_QAV_C2C_AUTO", "SUB_SOURCE_QAV_C2C_MID", "SUB_SOURCE_QAV_C2C_RIGHT", "SUB_SOURCE_QAV_GROUP_AUTO", "SUB_SOURCE_QAV_GROUP_MID", "SUB_SOURCE_QAV_GROUP_RIGHT", "SUB_SOURCE_ROLE_FRAGMENT", "SUB_SOURCE_SEARCH", "SUB_SOURCE_SET_COVER", "SUB_SOURCE_STORE", "SUB_SOURCE_USER_CENTER", "SUB_SOURCE_XSJ", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ZootopiaSource$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zootopia.ZootopiaSource$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public /* synthetic */ class C9105a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f327879a;

            static {
                int[] iArr = new int[Source.values().length];
                try {
                    iArr[Source.UnSet.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Source.None.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Source.Dynamic.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Source.PortalActivity.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Source.ZootopiaUEActivity.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Source.Profile.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Source.Ark.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f327879a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ZootopiaSource d(Companion companion, Source source, String str, ZootopiaSource zootopiaSource, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                zootopiaSource = null;
            }
            return companion.c(source, str, zootopiaSource);
        }

        @JvmStatic
        @NotNull
        public final ZootopiaSource a(@NotNull Source mainSource) {
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            return new ZootopiaSource(mainSource, "0", null, 4, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ZootopiaSource b(@NotNull Source mainSource, @NotNull String subSource) {
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            return d(this, mainSource, subSource, null, 4, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ZootopiaSource c(@NotNull Source mainSource, @NotNull String subSource, @Nullable ZootopiaSource last) {
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            ZootopiaSource zootopiaSource = new ZootopiaSource(mainSource, subSource, null, 4, null);
            zootopiaSource.setLast(last);
            return zootopiaSource;
        }

        @NotNull
        public final FragmentSource e(@NotNull ZootopiaSource sourceCurrent) {
            Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
            return new FragmentSource(sourceCurrent.getMainSource(), sourceCurrent);
        }

        @Nullable
        public final FragmentSource f(@Nullable Bundle bundle) {
            Serializable serializable;
            if (bundle != null) {
                serializable = bundle.getSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE);
            } else {
                serializable = null;
            }
            if (!(serializable instanceof FragmentSource)) {
                return null;
            }
            return (FragmentSource) serializable;
        }

        @NotNull
        public final ZootopiaSource g() {
            return d(this, Source.None, "", null, 4, null);
        }

        @NotNull
        public final Source h(@Nullable Bundle bundle) {
            Source current;
            FragmentSource f16 = f(bundle);
            if (f16 == null || (current = f16.getCurrent()) == null) {
                return Source.UnSet;
            }
            return current;
        }

        @NotNull
        public final ZootopiaSource i() {
            return d(this, Source.UnSet, "", null, 4, null);
        }

        public final int j(@Nullable ZootopiaSource zootopiaSource) {
            Source source;
            int i3;
            if (zootopiaSource != null) {
                source = zootopiaSource.getMainSource();
            } else {
                source = null;
            }
            if (source == null) {
                i3 = -1;
            } else {
                i3 = C9105a.f327879a[source.ordinal()];
            }
            if (i3 != 3 && i3 != 4 && i3 != 5) {
                if (i3 == 6) {
                    return 3;
                }
                if (i3 == 7) {
                    return 5;
                }
                return 0;
            }
            return 1;
        }

        Companion() {
        }
    }

    public ZootopiaSource(@NotNull Source mainSource, @NotNull String subSource, @Nullable ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        this.mainSource = mainSource;
        this.subSource = subSource;
        this.last = zootopiaSource;
    }

    public static /* synthetic */ ZootopiaSource copy$default(ZootopiaSource zootopiaSource, Source source, String str, ZootopiaSource zootopiaSource2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            source = zootopiaSource.mainSource;
        }
        if ((i3 & 2) != 0) {
            str = zootopiaSource.subSource;
        }
        if ((i3 & 4) != 0) {
            zootopiaSource2 = zootopiaSource.last;
        }
        return zootopiaSource.copy(source, str, zootopiaSource2);
    }

    @JvmStatic
    @NotNull
    public static final ZootopiaSource create(@NotNull Source source) {
        return INSTANCE.a(source);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Source getMainSource() {
        return this.mainSource;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSubSource() {
        return this.subSource;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ZootopiaSource getLast() {
        return this.last;
    }

    @NotNull
    public final ZootopiaSource copy(@NotNull Source mainSource, @NotNull String subSource, @Nullable ZootopiaSource last) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        return new ZootopiaSource(mainSource, subSource, last);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaSource)) {
            return false;
        }
        ZootopiaSource zootopiaSource = (ZootopiaSource) other;
        if (this.mainSource == zootopiaSource.mainSource && Intrinsics.areEqual(this.subSource, zootopiaSource.subSource) && Intrinsics.areEqual(this.last, zootopiaSource.last)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ZootopiaSource getLast() {
        return this.last;
    }

    @NotNull
    public final Source getMainSource() {
        return this.mainSource;
    }

    @NotNull
    public final String getSubSource() {
        return this.subSource;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.mainSource.hashCode() * 31) + this.subSource.hashCode()) * 31;
        ZootopiaSource zootopiaSource = this.last;
        if (zootopiaSource == null) {
            hashCode = 0;
        } else {
            hashCode = zootopiaSource.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setLast(@Nullable ZootopiaSource zootopiaSource) {
        this.last = zootopiaSource;
    }

    @NotNull
    public String toString() {
        return "ZootopiaSource(mainSource=" + this.mainSource + ", subSource=" + this.subSource + ", last=" + this.last + ')';
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ZootopiaSource create(@NotNull Source source, @NotNull String str) {
        return INSTANCE.b(source, str);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ZootopiaSource create(@NotNull Source source, @NotNull String str, @Nullable ZootopiaSource zootopiaSource) {
        return INSTANCE.c(source, str, zootopiaSource);
    }

    public /* synthetic */ ZootopiaSource(Source source, String str, ZootopiaSource zootopiaSource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(source, str, (i3 & 4) != 0 ? null : zootopiaSource);
    }
}

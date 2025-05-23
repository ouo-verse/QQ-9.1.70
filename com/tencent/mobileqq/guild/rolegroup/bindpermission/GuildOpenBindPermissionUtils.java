package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import android.content.Context;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.bizfragments.GuildBindPermissionForAudioFragment;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001DB\t\b\u0002\u00a2\u0006\u0004\bC\u0010AJW\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J8\u0010%\u001a\u00020$2\b\b\u0002\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J*\u0010&\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020$H\u0002J*\u0010(\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J(\u0010)\u001a\u00020$2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010*\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010-\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\bH\u0007J#\u00102\u001a\b\u0012\u0004\u0012\u00020\u0004012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u00a2\u0006\u0004\b2\u00103J#\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0007\u00a2\u0006\u0004\b5\u00106J \u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001012\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000101H\u0007J&\u0010:\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00040\u0004012\u000e\u00104\u001a\n\u0012\u0004\u0012\u000208\u0018\u000101H\u0007J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R&\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0<8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b5\u0010=\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildOpenBindPermissionUtils;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "type", "", "requestCode", "", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "selectUsers", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "selectRoles", "channelType", "", "v", "(Lcom/tencent/mobileqq/app/QBaseFragment;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;I[Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;[Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;I)V", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "w", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", DomainData.DOMAIN_NAME, "o", "u", "t", "j", "", "isCreate", "channelName", "categoryName", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/BindPermissionWord;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "p", tl.h.F, "f", "k", "l", "g", "roleType", ReportConstant.COSTREPORT_PREFIX, "cacheSelectUser", "", "c", "([Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;)Ljava/util/List;", "cacheSelectRoles", "b", "([Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;)Ljava/util/List;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "kotlin.jvm.PlatformType", "e", "a", "", "Ljava/util/Set;", "getOnlyDisplayRoles", "()Ljava/util/Set;", "getOnlyDisplayRoles$annotations", "()V", "onlyDisplayRoles", "<init>", "IBindPermissionWhenCreateRequestCode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenBindPermissionUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildOpenBindPermissionUtils f232368a = new GuildOpenBindPermissionUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<Integer> onlyDisplayRoles;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildOpenBindPermissionUtils$IBindPermissionWhenCreateRequestCode;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes14.dex */
    public @interface IBindPermissionWhenCreateRequestCode {
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232370a;

        static {
            int[] iArr = new int[GuildBindPermissionActionFactory.FetchType.values().length];
            try {
                iArr[GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildBindPermissionActionFactory.FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f232370a = iArr;
        }
    }

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{4, 2, 5, 7});
        onlyDisplayRoles = of5;
    }

    GuildOpenBindPermissionUtils() {
    }

    @JvmStatic
    @NotNull
    public static final GuildBindPermissionActionFactory.FetchType a(int type) {
        switch (type) {
            case 1:
                return GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE;
            case 2:
                return GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SPEAK;
            case 3:
                return GuildBindPermissionActionFactory.FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE;
            case 4:
                return GuildBindPermissionActionFactory.FetchType.FETCH_SPEAK_RULE_UNLIMITED;
            case 5:
                return GuildBindPermissionActionFactory.FetchType.FETCH_AUDIO_CHANNEL_ACTIVITY;
            case 6:
                return GuildBindPermissionActionFactory.FetchType.FETCH_WORD_CHANNEL_EDIT_MAP;
            default:
                return GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE;
        }
    }

    @JvmStatic
    @NotNull
    public static final List<String> b(@NotNull RoleLabelData[] cacheSelectRoles) {
        Intrinsics.checkNotNullParameter(cacheSelectRoles, "cacheSelectRoles");
        ArrayList arrayList = new ArrayList(cacheSelectRoles.length);
        for (RoleLabelData roleLabelData : cacheSelectRoles) {
            arrayList.add(roleLabelData.getRoleId());
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<String> c(@NotNull RoleGroupUserUIData[] cacheSelectUser) {
        Intrinsics.checkNotNullParameter(cacheSelectUser, "cacheSelectUser");
        ArrayList arrayList = new ArrayList(cacheSelectUser.length);
        for (RoleGroupUserUIData roleGroupUserUIData : cacheSelectUser) {
            arrayList.add(roleGroupUserUIData.getMTinyId());
        }
        return arrayList;
    }

    @JvmStatic
    @Nullable
    public static final List<String> d(@Nullable List<String> cacheSelectRoles) {
        if (cacheSelectRoles != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : cacheSelectRoles) {
                if (!s(Integer.parseInt((String) obj))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final List<String> e(@Nullable List<? extends IGProGuildRoleInfo> cacheSelectRoles) {
        List<String> emptyList;
        int collectionSizeOrDefault;
        if (cacheSelectRoles == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : cacheSelectRoles) {
            String roleId = ((IGProGuildRoleInfo) obj).getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "it.roleId");
            if (s(Integer.parseInt(roleId))) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((IGProGuildRoleInfo) it.next()).getRoleId());
        }
        return arrayList2;
    }

    private final BindPermissionWord f(String channelName, String categoryName) {
        String qqStr = HardCodeUtil.qqStr(R.string.f154561f5);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f154411eq);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154861fy);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154471ew);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154481ex);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154341ej);
        String l3 = l(channelName);
        String g16 = g(categoryName);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_rol\u2026eate_activity_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_role_all_can_activity)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_part_can_activity)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_activity_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_activity_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr5, qqStr6, qqStr4, l3, g16, null, null, 768, null);
    }

    private final String g(String categoryName) {
        boolean z16;
        if (categoryName != null && categoryName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String qqStr = HardCodeUtil.qqStr(R.string.f141780hl);
            Intrinsics.checkNotNullExpressionValue(qqStr, "{\n            HardCodeUt\u2026el_no_category)\n        }");
            return qqStr;
        }
        return categoryName;
    }

    private final BindPermissionWord h(boolean isCreate, String channelName, String categoryName) {
        String l3;
        String qqStr = HardCodeUtil.qqStr(R.string.f154821fu);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f154811ft);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154831fv);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154491ey);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154501ez);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154341ej);
        String str = "";
        if (isCreate) {
            l3 = "";
        } else {
            l3 = l(channelName);
        }
        if (!isCreate) {
            str = g(categoryName);
        }
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_live_anchor_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_role_live_all_can_see)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_live_part_can_see)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_live_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_live_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr5, qqStr6, qqStr4, l3, str, null, null, 768, null);
    }

    static /* synthetic */ BindPermissionWord i(GuildOpenBindPermissionUtils guildOpenBindPermissionUtils, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return guildOpenBindPermissionUtils.h(z16, str, str2);
    }

    @JvmStatic
    @NotNull
    public static final GuildBindPermissionParam j(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return new GuildBindPermissionParam(guildId, new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_SPEAK_RULE_UNLIMITED, 4, 20, 19), f232368a.k(), new DTReportParam(null, null, null, 7, null));
    }

    private final BindPermissionWord k() {
        String qqStr = HardCodeUtil.qqStr(R.string.f154551f4);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f157151m5);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154341ej);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f156981lo);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f156971ln);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_speak_rule_unlimited_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_rol\u2026eck_talk_unlimited_group)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_spe\u2026_rule_channel_admin_tips)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_spe\u2026rule_category_admin_tips)");
        return new BindPermissionWord("", "", "", qqStr2, qqStr3, qqStr, qqStr4, qqStr5, null, null, 768, null);
    }

    private final String l(String channelName) {
        String string = BaseApplication.getContext().getResources().getString(R.string.f141750hi, channelName);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026    channelName\n        )");
        return string;
    }

    private final BindPermissionWord m(boolean isCreate, String guildId, String channelName, String categoryName, int channelType) {
        boolean z16;
        int i3;
        String l3;
        IGProGuildInfo L = ch.L(guildId);
        if (L != null) {
            z16 = L.isVisibleForVisitor();
        } else {
            z16 = false;
        }
        if (channelType == 7 && ch.L(guildId) != null) {
            z16 = ((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getVisibleForVisitor(ch.L(guildId));
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f155031ge);
        if (z16 && channelType != 6) {
            i3 = R.string.f154391eo;
        } else {
            i3 = R.string.f154441et;
        }
        String qqStr2 = HardCodeUtil.qqStr(i3);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154881g0);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154511f0);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154511f0);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154521f1);
        String qqStr7 = HardCodeUtil.qqStr(R.string.f154341ej);
        String str = "";
        if (isCreate) {
            l3 = "";
        } else {
            l3 = l(channelName);
        }
        if (!isCreate) {
            str = g(categoryName);
        }
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_visible_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(if(isVisibleForVis\u2026g.guild_role_all_can_see)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_part_can_see)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_check_see_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr7, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_see_group)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_see_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr6, qqStr7, qqStr4, l3, str, qqStr5, null, 512, null);
    }

    private final GuildBindPermissionParam n(IGProChannelInfo channelInfo) {
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        RoleAndMemberRequestType roleAndMemberRequestType = new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SPEAK, 2, 12, 11);
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        String categoryName = channelInfo.getCategoryName();
        String guildId2 = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId2, "channelInfo.guildId");
        GuildBindPermissionParam guildBindPermissionParam = new GuildBindPermissionParam(guildId, roleAndMemberRequestType, p(channelName, categoryName, guildId2, channelInfo.getType()), new DTReportParam("pg_sgrp_speak_subchannel_detail", "em_sgrp_speak_all", "em_sgrp_speak_part"));
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        return guildBindPermissionParam.setChannelId(channelUin).setChannelType(channelInfo.getType());
    }

    private final GuildBindPermissionParam o(String guildId) {
        return new GuildBindPermissionParam(guildId, new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SPEAK, 2, 22, 21), r(), new DTReportParam("pg_sgrp_publish_forum_set", "em_sgrp_all_member", "em_sgrp_presume_member"));
    }

    private final BindPermissionWord p(String channelName, String categoryName, String guildId, int channelType) {
        int i3;
        if (channelType == 7) {
            return q(channelName, categoryName, guildId, channelType);
        }
        boolean q06 = ch.q0(guildId);
        if (channelType == 1 || channelType == 2) {
            q06 = false;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f155021gd);
        if (q06 && channelType != 6) {
            i3 = R.string.f154401ep;
        } else {
            i3 = R.string.f154451eu;
        }
        String qqStr2 = HardCodeUtil.qqStr(i3);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154891g1);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154531f2);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154541f3);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154341ej);
        String l3 = l(channelName);
        String g16 = g(categoryName);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_speable_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(if(isInteractiveFo\u2026.guild_role_all_can_talk)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_part_can_talk)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_talk_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_talk_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr5, qqStr6, qqStr4, l3, g16, null, null, 768, null);
    }

    private final BindPermissionWord q(String channelName, String categoryName, String guildId, int channelType) {
        String qqStr = HardCodeUtil.qqStr(R.string.f154991ga);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f154421er);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154871fz);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154531f2);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154541f3);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154341ej);
        String l3 = l(channelName);
        String g16 = g(categoryName);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_post_feed_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_role_all_can_publish)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_part_can_publish)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_talk_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_talk_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr5, qqStr6, qqStr4, l3, g16, null, null, 768, null);
    }

    private final BindPermissionWord r() {
        String qqStr = HardCodeUtil.qqStr(R.string.f154991ga);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f154431es);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f154901g2);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f154531f2);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f154541f3);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f154341ej);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_post_feed_permission)");
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_rol\u2026all_can_publish_in_guild)");
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_role_part_can_talk_in_guild)");
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_role_check_talk_member)");
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_role_add_members)");
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_role_check_talk_group)");
        return new BindPermissionWord(qqStr, qqStr2, qqStr3, qqStr5, qqStr6, qqStr4, "", "", null, null, 768, null);
    }

    @JvmStatic
    public static final boolean s(int roleType) {
        return onlyDisplayRoles.contains(Integer.valueOf(roleType));
    }

    @JvmStatic
    public static final void t(@NotNull Context context, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        GuildBindPermissionFragment.Companion companion = GuildBindPermissionFragment.INSTANCE;
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        RoleAndMemberRequestType roleAndMemberRequestType = new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_AUDIO_CHANNEL_ACTIVITY, 5, 16, 15);
        GuildOpenBindPermissionUtils guildOpenBindPermissionUtils = f232368a;
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        GuildBindPermissionParam guildBindPermissionParam = new GuildBindPermissionParam(guildId, roleAndMemberRequestType, guildOpenBindPermissionUtils.f(channelName, channelInfo.getCategoryName()), new DTReportParam("pg_sgrp_playset_subchannel_detail", "em_sgrp_playset_all", "em_sgrp_playset_part"));
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        companion.b(guildBindPermissionParam.setChannelId(channelUin).setChannelType(channelInfo.getType()));
    }

    @JvmStatic
    public static final void u(@NotNull Context context, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        GuildBindPermissionFragment.Companion companion = GuildBindPermissionFragment.INSTANCE;
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        RoleAndMemberRequestType roleAndMemberRequestType = new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE, 3, 14, 13);
        GuildOpenBindPermissionUtils guildOpenBindPermissionUtils = f232368a;
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        GuildBindPermissionParam guildBindPermissionParam = new GuildBindPermissionParam(guildId, roleAndMemberRequestType, guildOpenBindPermissionUtils.h(false, channelName, channelInfo.getCategoryName()), new DTReportParam("pg_sgrp_all_anchor_detail", "em_sgrp_visit_all", "em_sgrp_visit_part"));
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        companion.b(guildBindPermissionParam.setChannelId(channelUin).setChannelType(channelInfo.getType()));
    }

    @JvmStatic
    public static final void v(@NotNull QBaseFragment fragment, @NotNull String guildId, @NotNull GuildBindPermissionActionFactory.FetchType type, int requestCode, @Nullable RoleGroupUserUIData[] selectUsers, @Nullable RoleLabelData[] selectRoles, int channelType) {
        BindPermissionWord m3;
        RoleAndMemberRequestType roleAndMemberRequestType;
        RoleLabelData[] roleLabelDataArr;
        RoleGroupUserUIData[] roleGroupUserUIDataArr;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = a.f232370a[type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                m3 = i(f232368a, true, null, null, 6, null);
                roleAndMemberRequestType = new RoleAndMemberRequestType(type, 3, 1, 0);
            } else {
                throw new IllegalArgumentException("Unknown fetchType:" + type + " when create!");
            }
        } else {
            m3 = f232368a.m(true, guildId, "", "", channelType);
            roleAndMemberRequestType = new RoleAndMemberRequestType(type, 1, 1, 0);
        }
        GuildBindPermissionFragment.Companion companion = GuildBindPermissionFragment.INSTANCE;
        GuildBindPermissionParam requestCode2 = new GuildBindPermissionParam(guildId, roleAndMemberRequestType, m3, new DTReportParam(null, null, null, 7, null)).setIsCreating(true).setRequestCode(requestCode);
        if (selectRoles == null) {
            roleLabelDataArr = new RoleLabelData[0];
        } else {
            roleLabelDataArr = selectRoles;
        }
        GuildBindPermissionParam selectRoles2 = requestCode2.setSelectRoles(roleLabelDataArr);
        if (selectUsers == null) {
            roleGroupUserUIDataArr = new RoleGroupUserUIData[0];
        } else {
            roleGroupUserUIDataArr = selectUsers;
        }
        companion.a(fragment, selectRoles2.setSelectUsers(roleGroupUserUIDataArr).setChannelType(channelType));
    }

    @JvmStatic
    public static final void w(@NotNull Context context, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        GuildBindPermissionFragment.Companion companion = GuildBindPermissionFragment.INSTANCE;
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        RoleAndMemberRequestType roleAndMemberRequestType = new RoleAndMemberRequestType(GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE, 1, 10, 9);
        GuildOpenBindPermissionUtils guildOpenBindPermissionUtils = f232368a;
        String guildId2 = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId2, "channelInfo.guildId");
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        GuildBindPermissionParam guildBindPermissionParam = new GuildBindPermissionParam(guildId, roleAndMemberRequestType, guildOpenBindPermissionUtils.m(false, guildId2, channelName, channelInfo.getCategoryName(), channelInfo.getType()), new DTReportParam("pg_sgrp_visit_role_detail", "em_sgrp_visit_all", "em_sgrp_visit_part"));
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        companion.b(guildBindPermissionParam.setChannelId(channelUin).setChannelType(channelInfo.getType()));
    }

    @JvmStatic
    public static final void x(@NotNull Context context, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (channelInfo.getType() == 2) {
            GuildBindPermissionForAudioFragment.INSTANCE.a(f232368a.n(channelInfo));
        } else {
            GuildBindPermissionFragment.INSTANCE.b(f232368a.n(channelInfo));
        }
    }

    @JvmStatic
    public static final void y(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        GuildBindPermissionFragment.INSTANCE.b(f232368a.o(guildId));
    }
}

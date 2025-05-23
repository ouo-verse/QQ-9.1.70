package cy1;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J<\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0014"}, d2 = {"Lcy1/k;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "paramData", "Ljy1/a;", "viewModel", "", "", "selectedTinyIdSet", "", "roleMemberList", "", "b", "", "defaultId", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f392394a = new k();

    k() {
    }

    private final String a(int defaultId, GuildRoleMemberParamData paramData) {
        String nextAddPageTitle;
        String str;
        if (TextUtils.isEmpty(paramData.getNextAddPageTitle())) {
            nextAddPageTitle = HardCodeUtil.qqStr(defaultId);
            str = "qqStr(defaultId)";
        } else {
            nextAddPageTitle = paramData.getNextAddPageTitle();
            str = "paramData.nextAddPageTitle";
        }
        Intrinsics.checkNotNullExpressionValue(nextAddPageTitle, str);
        return nextAddPageTitle;
    }

    @JvmStatic
    public static final void b(@NotNull Activity activity, @NotNull GuildRoleMemberParamData paramData, @NotNull jy1.a viewModel, @NotNull Set<String> selectedTinyIdSet, @NotNull List<String> roleMemberList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(paramData, "paramData");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(selectedTinyIdSet, "selectedTinyIdSet");
        Intrinsics.checkNotNullParameter(roleMemberList, "roleMemberList");
        if (paramData.getLayoutType() == 5) {
            GuildRoleMemberParamData guildRoleMemberParamData = new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 0, 1);
            Object[] array = selectedTinyIdSet.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            GuildRoleMemberParamData activityRequestCode = guildRoleMemberParamData.setSelectedIdList((String[]) array).setMaxCountCanSelect(paramData.getMaxCountCanSelect() - viewModel.f2()).setActivityRequestCode(2000);
            ArrayList<RoleGroupUserUIData> i26 = viewModel.i2(selectedTinyIdSet);
            Intrinsics.checkNotNullExpressionValue(i26, "viewModel.getUIDataByIdList(selectedTinyIdSet)");
            Object[] array2 = i26.toArray(new RoleGroupUserUIData[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            GuildCommonViewMemberFragment.ki(activity, activityRequestCode.setSelectedUIList(array2));
            return;
        }
        int fetchType = paramData.getFetchType();
        if (fetchType != 2) {
            if (fetchType != 3) {
                if (fetchType != 4) {
                    if (fetchType != 9) {
                        if (fetchType != 11) {
                            if (fetchType != 13) {
                                if (fetchType != 15) {
                                    switch (fetchType) {
                                        case 19:
                                            GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 20).setSubChannelId(paramData.getSubChannelId()));
                                            return;
                                        case 20:
                                            GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 19).setSubChannelId(paramData.getSubChannelId()));
                                            return;
                                        case 21:
                                            GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 22).setSubChannelId(paramData.getSubChannelId()));
                                            return;
                                        default:
                                            Logger logger = Logger.f235387a;
                                            Logger.b bVar = new Logger.b();
                                            String str = "openForAddMember params:" + paramData;
                                            if (str instanceof String) {
                                                bVar.a().add(str);
                                            }
                                            Iterator<T> it = bVar.a().iterator();
                                            while (it.hasNext()) {
                                                Logger.f235387a.d().e("GuildCommonViewMemberJumpHelper", 1, (String) it.next(), null);
                                            }
                                            s.f("GuildCommonViewMemberJumpHelper", "unexpected searchParam", new IllegalArgumentException());
                                            return;
                                    }
                                }
                                GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 16).setSubChannelId(paramData.getSubChannelId()));
                                return;
                            }
                            GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 14).setSubChannelId(paramData.getSubChannelId()));
                            return;
                        }
                        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 12).setSubChannelId(paramData.getSubChannelId()));
                        return;
                    }
                    GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 10).setSubChannelId(paramData.getSubChannelId()));
                    return;
                }
                GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 7).setRoleGroupId(paramData.getRoleGroupId()).setCategoryId(paramData.getCategoryId()));
                return;
            }
            GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 6).setSubChannelId(paramData.getSubChannelId()).setRoleGroupId(paramData.getRoleGroupId()).setLocalMemberList(roleMemberList).setMaxCountCanSelect(paramData.getMaxCountCanSelect() - viewModel.f2()).setActivityRequestCode(2002));
            return;
        }
        GuildCommonViewMemberFragment.ki(activity, new GuildRoleMemberParamData(paramData.getGuildId(), f392394a.a(R.string.f154341ej, paramData), 1, 5).setSubChannelId(paramData.getSubChannelId()).setRoleGroupId(paramData.getRoleGroupId()).setLocalMemberList(roleMemberList).setMaxCountCanSelect(paramData.getMaxCountCanSelect() - viewModel.f2()).setActivityRequestCode(2002));
    }
}

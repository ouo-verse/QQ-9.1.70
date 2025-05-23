package dy1;

import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleForChannelPermissionViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Ldy1/b;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "", "isCreatingScene", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "fetchType", "b", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$PermissionType;", "permissionType", "c", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f395201a = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f395202a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f395203b;

        static {
            int[] iArr = new int[SelectRoleForChannelPermissionViewModel.PermissionType.values().length];
            try {
                iArr[SelectRoleForChannelPermissionViewModel.PermissionType.LiveAnchorPermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectRoleForChannelPermissionViewModel.PermissionType.ActivityPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f395202a = iArr;
            int[] iArr2 = new int[GuildBindPermissionActionFactory.FetchType.values().length];
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SPEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_AUDIO_CHANNEL_ACTIVITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_WORD_CHANNEL_EDIT_MAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[GuildBindPermissionActionFactory.FetchType.FETCH_SPEAK_RULE_UNLIMITED.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            f395203b = iArr2;
        }
    }

    b() {
    }

    private final SelectRoleForChannelPermissionViewModel.PermissionType a(GuildBindPermissionActionFactory.FetchType fetchType) {
        switch (a.f395203b[fetchType.ordinal()]) {
            case 1:
                return SelectRoleForChannelPermissionViewModel.PermissionType.ViewPermission;
            case 2:
                return SelectRoleForChannelPermissionViewModel.PermissionType.SpeakPermission;
            case 3:
                return SelectRoleForChannelPermissionViewModel.PermissionType.LiveAnchorPermission;
            case 4:
                return SelectRoleForChannelPermissionViewModel.PermissionType.ActivityPermission;
            case 5:
                return SelectRoleForChannelPermissionViewModel.PermissionType.ModifyMapPermission;
            case 6:
                return SelectRoleForChannelPermissionViewModel.PermissionType.SpeakUnlimitedPermission;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @JvmStatic
    public static final boolean b(@NotNull RoleGroupModel role, boolean isCreatingScene, @NotNull GuildBindPermissionActionFactory.FetchType fetchType) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        return c(role, isCreatingScene, f395201a.a(fetchType));
    }

    @JvmStatic
    public static final boolean c(@NotNull RoleGroupModel role, boolean isCreatingScene, @NotNull SelectRoleForChannelPermissionViewModel.PermissionType permissionType) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        if (!isCreatingScene ? !((i3 = a.f395202a[permissionType.ordinal()]) == 1 ? role.getRolePermission().getIsAccessibleWhenCreate() || role.getRolePermission().getIsAccessibleInList() : i3 == 2 ? role.getRolePermission().getIsAccessibleWhenAudioActivity() || role.getRolePermission().getIsAccessibleInList() : role.getRolePermission().getIsAccessibleInList()) : !role.getRolePermission().getIsAccessibleWhenCreate()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (role.v() || role.s() || role.t() || role.u() || z16) {
            return false;
        }
        return true;
    }
}

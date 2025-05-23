package com.tencent.mobileqq.guild.mission.beginmission.presentdialog;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentDialogFragment;", "Lcom/tencent/mobileqq/guild/channel/create/dialog/BaseDialogFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;", "createSubChannelInfo", "Landroidx/fragment/app/Fragment;", "wh", "", "M", "Ljava/lang/String;", "guildId", "", "N", "I", "missionId", "<init>", "()V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionPresentDialogFragment extends BaseDialogFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: N, reason: from kotlin metadata */
    private int missionId = -1;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentDialogFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "guildId", "", "missionId", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mission.beginmission.presentdialog.MissionPresentDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String guildId, int missionId) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            MissionPresentDialogFragment missionPresentDialogFragment = new MissionPresentDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", guildId);
            bundle.putInt("mission_id", missionId);
            missionPresentDialogFragment.setArguments(bundle);
            missionPresentDialogFragment.show(fragmentManager, "Guild.mission.MissionPresentDialogFragment");
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        boolean z16;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null) {
            str = arguments.getString("guild_id", "");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            num = Integer.valueOf(arguments2.getInt("mission_id", -1));
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && num != null && num.intValue() != -1) {
            this.guildId = str;
            this.missionId = num.intValue();
        } else {
            dismiss();
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment
    @NotNull
    protected Fragment wh(@Nullable CreateSubChannelInfo createSubChannelInfo) {
        MissionPresentFragment b16 = MissionPresentFragment.INSTANCE.b(this.guildId, this.missionId);
        b16.ph(this);
        return b16;
    }
}

package com.tencent.mobileqq.guild.rolegroup.bindpermission.bizfragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionParam;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.bizfragments.GuildBindPermissionForAudioFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.qqui.c;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/bizfragments/GuildBindPermissionForAudioFragment;", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionFragment;", "Landroid/view/View;", "view", "", "pi", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "type", "ki", "Yh", "", "h0", "Z", "mIsAudioChannel", "<init>", "()V", "i0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBindPermissionForAudioFragment extends GuildBindPermissionFragment {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAudioChannel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/bizfragments/GuildBindPermissionForAudioFragment$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "param", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.bindpermission.bizfragments.GuildBindPermissionForAudioFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull GuildBindPermissionParam param) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("GUILD_BIND_PERMISSION_PARAM", param)));
            QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, GuildBindPermissionForAudioFragment.class);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(GuildBindPermissionForAudioFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.Yh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void pi(View view) {
        boolean z16;
        if (((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(Uh().getChannelId()).getType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsAudioChannel = z16;
        if (!z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("not audio channel");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.BindPermission.Audio", 1, (String) it.next(), null);
            }
            requireActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment
    public void Yh() {
        if (4 == MediaChannelUtils.f228046a.n(Uh().getChannelId())) {
            c.c(getContext(), 230, null, BaseApplication.context.getString(R.string.f139950cn), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: zx1.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildBindPermissionForAudioFragment.ni(GuildBindPermissionForAudioFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: zx1.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildBindPermissionForAudioFragment.oi(dialogInterface, i3);
                }
            }).show();
        } else {
            super.Yh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment
    public void ki(@NotNull PermissionSwitchStatus type) {
        Intrinsics.checkNotNullParameter(type, "type");
        super.ki(type);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        pi(view);
    }
}

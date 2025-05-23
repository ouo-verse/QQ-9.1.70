package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/BaseJoinGuildFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "ph", "", "isWrapContent", "needImmersive", "needStatusTrans", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class BaseJoinGuildFragment extends QPublicBaseFragment {
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ph() {
        Resources resources;
        FragmentActivity activity = getActivity();
        View view = getView();
        if (view == null || (resources = view.getResources()) == null) {
            resources = getResources();
        }
        QQGuildUIUtil.L(activity, resources.getColor(R.color.qui_common_bg_bottom_standard));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }
}

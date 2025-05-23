package com.tencent.mobileqq.contact.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.contact.IContactExtApi;
import com.tencent.mobileqq.contact.robot.RobotContactFragment;
import com.tencent.mobileqq.guild.GuildTestFragment;
import com.tencent.mobileqq.guild.GuildsPinnedHeaderExpandableListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/contact/impl/ContactExtApiImpl;", "Lcom/tencent/mobileqq/contact/IContactExtApi;", "()V", "getRobotContactFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "setChildViewCanAction", "", "scrollableView", "Landroid/view/View;", "canAction", "", "startGuildTestFragment", "context", "Landroid/content/Context;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ContactExtApiImpl implements IContactExtApi {
    @Override // com.tencent.mobileqq.contact.IContactExtApi
    public QBaseFragment getRobotContactFragment() {
        return new RobotContactFragment();
    }

    @Override // com.tencent.mobileqq.contact.IContactExtApi
    public void setChildViewCanAction(View scrollableView, boolean canAction) {
        Intrinsics.checkNotNullParameter(scrollableView, "scrollableView");
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = scrollableView instanceof GuildsPinnedHeaderExpandableListView ? (GuildsPinnedHeaderExpandableListView) scrollableView : null;
        if (guildsPinnedHeaderExpandableListView != null) {
            guildsPinnedHeaderExpandableListView.setChildViewCanAction(canAction);
        }
    }

    @Override // com.tencent.mobileqq.contact.IContactExtApi
    public void startGuildTestFragment(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, GuildTestFragment.class);
    }
}

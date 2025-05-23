package com.tencent.mobileqq.qqexpand.profilecard.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils;
import com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/profilecard/impl/ExpandProfileComponentUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/profilecard/IExpandProfileComponentUtils;", "()V", "interceptAddFriend", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "info", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandProfileComponentUtilsImpl implements IExpandProfileComponentUtils {
    @Override // com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils
    public boolean interceptAddFriend(IComponentCenter componentCenter, ProfileCardInfo info) {
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(info, "info");
        IComponent component = componentCenter.getComponent(1008);
        ProfileExtendFriendComponent profileExtendFriendComponent = component instanceof ProfileExtendFriendComponent ? (ProfileExtendFriendComponent) component : null;
        if (profileExtendFriendComponent != null) {
            return profileExtendFriendComponent.I(info);
        }
        return false;
    }
}

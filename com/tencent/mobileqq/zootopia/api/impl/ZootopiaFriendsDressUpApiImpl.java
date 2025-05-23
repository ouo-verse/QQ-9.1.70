package com.tencent.mobileqq.zootopia.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zootopia.api.IZootopiaFriendsDressUpApi;
import com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaFriendsDressUpApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaFriendsDressUpApi;", "()V", "getFilamentEnable", "", "openSingleFriendDressUp", "", "context", "Landroid/content/Context;", "friendUin", "", "pageSource", "", "setFilamentEnable", "enable", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaFriendsDressUpApiImpl implements IZootopiaFriendsDressUpApi {
    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaFriendsDressUpApi
    public boolean getFilamentEnable() {
        return FriendsDressUpFragment.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaFriendsDressUpApi
    public void openSingleFriendDressUp(Context context, long friendUin, int pageSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        FriendsDressUpFragment.INSTANCE.b(context, friendUin, pageSource);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaFriendsDressUpApi
    public void setFilamentEnable(boolean enable) {
        FriendsDressUpFragment.INSTANCE.d(enable);
    }
}

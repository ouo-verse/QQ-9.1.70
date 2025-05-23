package com.tencent.state.square.api;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/api/ISquareFriendObserver;", "", "onUpdateAddFriend", "", "isSuccess", "", "addSuccess", a.ADD_DIRECT, "requestUin", "", "bundle", "Landroid/os/Bundle;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareFriendObserver {
    void onUpdateAddFriend(boolean isSuccess, boolean addSuccess, boolean addDirect, @Nullable String requestUin, @Nullable Bundle bundle);
}

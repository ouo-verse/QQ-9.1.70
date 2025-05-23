package com.tencent.state.library.push;

import com.tencent.state.template.data.User;
import com.tencent.state.template.data.UserStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"getUser", "Lcom/tencent/state/template/data/User;", "Lcom/tencent/state/library/push/FocusMessage;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryPushMessagesKt {
    public static final User getUser(FocusMessage getUser) {
        Intrinsics.checkNotNullParameter(getUser, "$this$getUser");
        return new User(String.valueOf(getUser.getUser().getUin()), getUser.getUser(), "", UserStatus.SIT_DOWN, getUser.getFocus(), null, null, null, null, null, null, 2016, null);
    }
}

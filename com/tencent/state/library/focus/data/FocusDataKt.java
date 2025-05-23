package com.tencent.state.library.focus.data;

import com.tencent.state.data.UserCommon;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0006\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u0006\u00a2\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0006\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u00020\u0006\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u0006\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"focusResource", "Lcom/tencent/state/square/data/Resource;", "Lcom/tencent/state/library/focus/data/FocusItem;", "getId", "", "getItem", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "tableId", "", "uin", "getMeResource", "getMeTableId", "(Lcom/tencent/state/library/focus/data/FocusBaseItem;)Ljava/lang/Long;", "getType", "", "hasMe", "", "meDeskNick", "meDeskUin", "meUin", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusDataKt {
    public static final Resource focusResource(FocusItem focusResource) {
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(focusResource, "$this$focusResource");
        User user = focusResource.getUser();
        if (user == null || (sitDown = user.getSitDown()) == null) {
            return null;
        }
        return sitDown.getResource();
    }

    public static final String getId(FocusItem getId) {
        String uin;
        Intrinsics.checkNotNullParameter(getId, "$this$getId");
        User user = getId.getUser();
        return (user == null || (uin = user.getUin()) == null) ? String.valueOf(getId.getTable().getId()) : uin;
    }

    public static final FocusItem getItem(FocusBaseItem getItem, long j3, String uin) {
        Intrinsics.checkNotNullParameter(getItem, "$this$getItem");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (j3 == getItem.getLeftItem().getTable().getId()) {
            User user = getItem.getLeftItem().getUser();
            if (Intrinsics.areEqual(user != null ? user.getUin() : null, uin)) {
                return getItem.getLeftItem();
            }
        }
        if (j3 != getItem.getRightItem().getTable().getId()) {
            return null;
        }
        User user2 = getItem.getRightItem().getUser();
        if (Intrinsics.areEqual(user2 != null ? user2.getUin() : null, uin)) {
            return getItem.getRightItem();
        }
        return null;
    }

    public static final Resource getMeResource(FocusBaseItem getMeResource) {
        Intrinsics.checkNotNullParameter(getMeResource, "$this$getMeResource");
        User user = getMeResource.getLeftItem().getUser();
        if (user != null && user.isMe()) {
            return focusResource(getMeResource.getLeftItem());
        }
        User user2 = getMeResource.getRightItem().getUser();
        if (user2 == null || !user2.isMe()) {
            return null;
        }
        return focusResource(getMeResource.getRightItem());
    }

    public static final Long getMeTableId(FocusBaseItem getMeTableId) {
        Intrinsics.checkNotNullParameter(getMeTableId, "$this$getMeTableId");
        User user = getMeTableId.getRightItem().getUser();
        if (user != null && user.isMe()) {
            return Long.valueOf(getMeTableId.getRightItem().getTable().getId());
        }
        User user2 = getMeTableId.getLeftItem().getUser();
        if (user2 == null || !user2.isMe()) {
            return null;
        }
        return Long.valueOf(getMeTableId.getLeftItem().getTable().getId());
    }

    public static final int getType(FocusItem getType) {
        Intrinsics.checkNotNullParameter(getType, "$this$getType");
        return getType.getUser() == null ? 2 : 1;
    }

    public static final boolean hasMe(FocusBaseItem hasMe) {
        Intrinsics.checkNotNullParameter(hasMe, "$this$hasMe");
        User user = hasMe.getRightItem().getUser();
        if (user != null && user.isMe()) {
            return true;
        }
        User user2 = hasMe.getLeftItem().getUser();
        return user2 != null && user2.isMe();
    }

    public static final String meDeskNick(FocusBaseItem meDeskNick) {
        UserCommon info;
        UserCommon info2;
        Intrinsics.checkNotNullParameter(meDeskNick, "$this$meDeskNick");
        if (!hasMe(meDeskNick)) {
            return null;
        }
        User user = meDeskNick.getLeftItem().getUser();
        if (Intrinsics.areEqual(user != null ? Boolean.valueOf(user.isMe()) : null, Boolean.TRUE)) {
            User user2 = meDeskNick.getRightItem().getUser();
            if (user2 == null || (info2 = user2.getInfo()) == null) {
                return null;
            }
            return info2.getNick();
        }
        User user3 = meDeskNick.getLeftItem().getUser();
        if (user3 == null || (info = user3.getInfo()) == null) {
            return null;
        }
        return info.getNick();
    }

    public static final String meDeskUin(FocusBaseItem meDeskUin) {
        Intrinsics.checkNotNullParameter(meDeskUin, "$this$meDeskUin");
        if (!hasMe(meDeskUin)) {
            return null;
        }
        User user = meDeskUin.getLeftItem().getUser();
        if (Intrinsics.areEqual(user != null ? Boolean.valueOf(user.isMe()) : null, Boolean.TRUE)) {
            User user2 = meDeskUin.getRightItem().getUser();
            if (user2 != null) {
                return user2.getUin();
            }
            return null;
        }
        User user3 = meDeskUin.getLeftItem().getUser();
        if (user3 != null) {
            return user3.getUin();
        }
        return null;
    }

    public static final String meUin(FocusBaseItem meUin) {
        User user;
        Intrinsics.checkNotNullParameter(meUin, "$this$meUin");
        User user2 = meUin.getRightItem().getUser();
        if (user2 != null && user2.isMe()) {
            User user3 = meUin.getRightItem().getUser();
            if (user3 != null) {
                return user3.getUin();
            }
            return null;
        }
        User user4 = meUin.getLeftItem().getUser();
        if (user4 == null || !user4.isMe() || (user = meUin.getLeftItem().getUser()) == null) {
            return null;
        }
        return user.getUin();
    }
}

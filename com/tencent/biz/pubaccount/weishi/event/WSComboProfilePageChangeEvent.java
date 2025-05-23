package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSComboProfilePageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "selectedProfile", "", "isSelectedByClickAvatar", "(ZZ)V", "()Z", "getSelectedProfile", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSComboProfilePageChangeEvent extends WSSimpleBaseEvent {
    private final boolean isSelectedByClickAvatar;
    private final boolean selectedProfile;

    public WSComboProfilePageChangeEvent(boolean z16, boolean z17) {
        this.selectedProfile = z16;
        this.isSelectedByClickAvatar = z17;
    }

    public final boolean getSelectedProfile() {
        return this.selectedProfile;
    }

    /* renamed from: isSelectedByClickAvatar, reason: from getter */
    public final boolean getIsSelectedByClickAvatar() {
        return this.isSelectedByClickAvatar;
    }
}

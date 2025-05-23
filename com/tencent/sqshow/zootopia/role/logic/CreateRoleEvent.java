package com.tencent.sqshow.zootopia.role.logic;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "success", "", "newCreate", "(ZZ)V", "getNewCreate", "()Z", "getSuccess", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class CreateRoleEvent extends SimpleBaseEvent {
    private final boolean newCreate;
    private final boolean success;

    public CreateRoleEvent(boolean z16, boolean z17) {
        this.success = z16;
        this.newCreate = z17;
    }

    public final boolean getNewCreate() {
        return this.newCreate;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public /* synthetic */ CreateRoleEvent(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? false : z17);
    }
}

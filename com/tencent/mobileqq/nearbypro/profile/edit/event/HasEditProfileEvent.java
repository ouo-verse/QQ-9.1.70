package com.tencent.mobileqq.nearbypro.profile.edit.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/edit/event/HasEditProfileEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tinyId", "", "(Ljava/lang/Long;)V", "getTinyId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class HasEditProfileEvent extends SimpleBaseEvent {

    @Nullable
    private final Long tinyId;

    public HasEditProfileEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final Long getTinyId() {
        return this.tinyId;
    }

    public HasEditProfileEvent(@Nullable Long l3) {
        this.tinyId = l3;
    }

    public /* synthetic */ HasEditProfileEvent(Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : l3);
    }
}

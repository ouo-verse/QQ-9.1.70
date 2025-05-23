package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/s;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/r;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "c", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "newStatus", "", "isSucceed", "<init>", "(ZLcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class s extends r {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MessageType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e newStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(boolean z16, MessageType type, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e newStatus) {
        super(z16, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        this.type = type;
        this.newStatus = newStatus;
    }

    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e getNewStatus() {
        return this.newStatus;
    }

    /* renamed from: c, reason: from getter */
    public final MessageType getType() {
        return this.type;
    }
}

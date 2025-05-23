package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/a;", "", "Lcom/tencent/mobileqq/data/MessageForStructing;", "a", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f239844a = new a();

    a() {
    }

    public final MessageForStructing a() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) c16;
        if (qQAppInterface.getMessageFacade() == null || qQAppInterface.getMessageFacade().G() == null) {
            return null;
        }
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1(AppConstants.WEISHI_UIN, 1008);
        if (x16 instanceof MessageForStructing) {
            return (MessageForStructing) x16;
        }
        return null;
    }
}

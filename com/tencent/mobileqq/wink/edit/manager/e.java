package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {
    @Nullable
    public static final WinkDataServiceHandler a() {
        Object m476constructorimpl;
        BusinessHandler businessHandler;
        WinkDataServiceHandler winkDataServiceHandler;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            AppInterface e16 = com.tencent.mobileqq.wink.b.e();
            if (e16 != null) {
                businessHandler = e16.getBusinessHandler(WinkDataServiceHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof WinkDataServiceHandler) {
                winkDataServiceHandler = (WinkDataServiceHandler) businessHandler;
            } else {
                winkDataServiceHandler = null;
            }
            m476constructorimpl = Result.m476constructorimpl(winkDataServiceHandler);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl == null) {
            obj = m476constructorimpl;
        } else {
            w53.b.f("WinkDataServiceHandler", "[getDataServiceHandler] error: " + m479exceptionOrNullimpl.getMessage());
        }
        return (WinkDataServiceHandler) obj;
    }
}

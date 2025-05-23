package com.tencent.mobileqq.vas.social.record;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/c;", "", "", "code", "", "message", "", "onError", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "timeCost", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static void a(c cVar, int i3, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    void a(RecordState stepState, RecordStepProduct product, long timeCost);

    void onError(int code, String message);
}

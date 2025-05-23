package com.tencent.mobileqq.setting.utils;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/mobileqq/data/Card;", "invoke", "(Lcom/tencent/mobileqq/data/Card;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExitCurrentAccountUtil$showLogoutActionSheet$1$1 extends Lambda implements Function1<Card, Boolean> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitCurrentAccountUtil$showLogoutActionSheet$1$1(Context context) {
        super(1);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, Card card) {
        Intrinsics.checkNotNullParameter(context, "$context");
        ExitCurrentAccountUtil.f286732a.u(context, card);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(final Card card) {
        MqqHandler uIHandler = ThreadManager.getUIHandler();
        final Context context = this.$context;
        return Boolean.valueOf(uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.setting.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                ExitCurrentAccountUtil$showLogoutActionSheet$1$1.b(context, card);
            }
        }));
    }
}

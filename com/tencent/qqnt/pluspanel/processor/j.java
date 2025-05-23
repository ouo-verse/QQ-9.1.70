package com.tencent.qqnt.pluspanel.processor;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/j;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j implements com.tencent.qqnt.pluspanel.logic.b {
    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        QQAppInterface qQAppInterface;
        String replace$default;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(data.k()) || (qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        String j3 = context.g().r().c().j();
        String k3 = data.k();
        Intrinsics.checkNotNull(k3);
        replace$default = StringsKt__StringsJVMKt.replace$default(k3, "$GCODE$", j3, false, 4, (Object) null);
        Intent intent = new Intent(requireActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", replace$default);
        requireActivity.startActivity(intent);
        l61.a.b(qQAppInterface, "0X8005CBA", 1);
    }
}
